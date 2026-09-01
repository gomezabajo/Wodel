package wodel.dsls.runner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeType;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.ListStringType;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.Program;
import mutatorenvironment.RandomBooleanType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomStringType;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.miniOCL.InvariantCS;
import wodel.dsls.WodelStandaloneSetup;
import wodel.dsls.runner.WodelGenerator.AttributeSelectionMode;
import wodel.dsls.runner.WodelGenerator.ClassSelectionMode;
import wodel.dsls.runner.WodelGenerator.OperatorCoverage;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.manager.EMFComparison;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Utils for serialize and deserialize Wodel programs
 * 
 */
public class WodelUtils {
	
	/**
	 * Serializes an already parsed/resolved Wodel MutatorEnvironment
	 * directly as an XMI model.
	 *
	 * This overload is especially useful after resolving Wodel library
	 * imports, because it serializes the effective MutatorEnvironment
	 * instead of reloading the original .mutator source file.
	 *
	 * The supplied MutatorEnvironment is NOT moved from its current
	 * Resource. A deep copy is serialized instead.
	 *
	 * @param mutatorEnvironment
	 *            The Wodel mutation environment to serialize.
	 * @param outputURI
	 *            URI of the output XMI model.
	 */
	public static void serialize(
            EObject mutatorEnvironment,
            String outputURI) {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }
        if (outputURI == null || outputURI.trim().isEmpty()) {
            throw new IllegalArgumentException("outputURI must not be blank");
        }

        ResourceSet xmiRS = new ResourceSetImpl();
        xmiRS.getPackageRegistry().put(
                MutatorenvironmentPackage.eNS_URI,
                MutatorenvironmentPackage.eINSTANCE);

        URI uri = URI.createURI(outputURI);
        String extension = uri.fileExtension();
        if (extension == null || extension.isBlank()) {
            extension = "model";
        }
        xmiRS.getResourceFactoryRegistry()
             .getExtensionToFactoryMap()
             .put(extension, new XMIResourceFactoryImpl());

        Resource xmiOutput = xmiRS.createResource(uri);
        if (xmiOutput == null) {
            throw new IllegalStateException(
                    "Could not create XMI resource for URI: " + outputURI);
        }

        xmiOutput.getContents().add(EcoreUtil.copy(mutatorEnvironment));
        try {
            xmiOutput.save(Collections.emptyMap());
        }
        catch (IOException e) {
            throw new RuntimeException(
                    "Could not serialize Wodel mutation model to '" + outputURI + "'.",
                    e);
        }
    }

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void serialize(String xTextURI, String outputURI) {
        if (xTextURI == null || xTextURI.isBlank()) {
            throw new IllegalArgumentException("xTextURI must not be blank");
        }
        if (outputURI == null || outputURI.isBlank()) {
            throw new IllegalArgumentException("outputURI must not be blank");
        }

        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
        XtextResource xtextInput = (XtextResource)xTextRS.getResource(
                URI.createURI(xTextURI), true);
        EcoreUtil.resolveAll(xtextInput);
        if (xtextInput.getContents().isEmpty()) {
            throw new IllegalStateException("The Wodel source contains no root object: " + xTextURI);
        }

        ResourceSet xmiRS = new ResourceSetImpl();
        xmiRS.getPackageRegistry().put(
                MutatorenvironmentPackage.eNS_URI,
                MutatorenvironmentPackage.eINSTANCE);
        URI output = URI.createURI(outputURI);
        String extension = output.fileExtension();
        if (extension == null || extension.isBlank()) {
            extension = "model";
        }
        xmiRS.getResourceFactoryRegistry()
             .getExtensionToFactoryMap()
             .put(extension, new XMIResourceFactoryImpl());
        Resource xmiOutput = xmiRS.createResource(output);
        if (xmiOutput == null) {
            throw new IllegalStateException("Could not create XMI resource: " + outputURI);
        }
        xmiOutput.getContents().add(EcoreUtil.copy(xtextInput.getContents().get(0)));
        try {
            xmiOutput.save(Collections.emptyMap());
        }
        catch (IOException e) {
            throw new RuntimeException("Could not serialize Wodel source to " + outputURI, e);
        }
    }
	
//	public static String deserialize(EObject eObject) {
//		Injector injector = Guice.createInjector(new  wodel.dsls.WodelRuntimeModule());  
//		Serializer serializer = injector.getInstance(Serializer.class);  
//		return serializer.serialize(eObject);
//	}
	
	/**
	 * Serializes an in-memory Wodel semantic model to textual Wodel syntax.
	 *
	 * <p>This method intentionally does <strong>not</strong> call the historic
	 * {@link #format(String)} post-processor. Xtext already emits valid syntax,
	 * while the old formatter repeatedly rebuilt and rescanned large strings and
	 * became prohibitively expensive for generated programs with hundreds of
	 * blocks.</p>
	 */
	public static String deserialize(String xTextURI, EObject eObject) {
        if (xTextURI == null || xTextURI.isBlank()) {
            throw new IllegalArgumentException("xTextURI must not be blank");
        }
        if (eObject == null) {
            throw new IllegalArgumentException("eObject must not be null");
        }

        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
        XtextResource xtextOutput = (XtextResource)xTextRS.createResource(URI.createURI(xTextURI));
        if (xtextOutput == null) {
            throw new IllegalStateException("Could not create Wodel Xtext resource: " + xTextURI);
        }

        // Copy the whole containment tree and then reconnect internal
        // non-containment cross-references (e.g. SpecificObjectSelection.objSel).
        EcoreUtil.Copier copier = new EcoreUtil.Copier(true, true);
        EObject copy = copier.copy(eObject);
        copier.copyReferences();
        xtextOutput.getContents().add(copy);

        ISerializer serializer = xtextOutput.getSerializer();
        return serializer.serialize(copy);
    }

	public static String deserialize(XtextResource model) {
		ISerializer serializer = model.getSerializer();
		return format(serializer.serialize(model.getContents().get(0)));
	}

//	
//	public static String deserialize(String xTextURI, EObject eObject) {
//		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
//		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
//		XtextResource xtextOutput = (XtextResource)xTextRS.createResource(URI.createURI(xTextURI));
//		xtextOutput.getContents().add(eObject);
//		try {
//			xtextOutput.save(null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String ret = "";
//		try {
//			File outputFile = new File(xTextURI);
//			if (outputFile.exists()) {
//				FileReader reader = new FileReader(outputFile);
//				BufferedReader br = new BufferedReader(reader);
//				String line = "";
//				while ((line = br.readLine()) != null) {
//					ret += line + "\n";
//				}
//				br.close();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ret;
//	}

	public static String getConstraintText(String xTextURI, InvariantCS expression) {
		return WodelUtils.deserialize(xTextURI, expression).
				replaceAll("(\\r|\\n)", "").
				replaceAll("\\$", "").
				replaceAll(";", "").
				trim();
	}
	
	private static String formatOperator(String operator) {
		operator = operator.replace("\\r\\n", "").replace("\\r", "").replace("\\n", "").replace("\"", "'");
		String formatted = "";
		String[] operations = {"create", "deep clone", "clone", "modify", "select", "remove", "retype"};
		int index = -1;
		int begin = Integer.MAX_VALUE;
		int i = 0;
		for (int j = 0; j < operations.length; j++) {
			int current = operator.indexOf(operations[j]);
			if (current != -1 && begin > current) {
				int prec = current - 1;
				if (prec > 0) {
					if (operator.charAt(prec) == '^') {
						continue;
					}
				}
				begin = current;
				index = j;
			}
		}
		if (index == - 1) {
			return formatted;
		}
		formatted += "\t\t";
		if (i < begin) {
			while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
				i++;
			}
			while (i < begin && (Character.isAlphabetic(operator.charAt(i)) || Character.isDigit(operator.charAt(i)))) {
				formatted += operator.charAt(i);
				i++;
			}
			while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
				i++;
			}
			formatted += " = ";
		}
		formatted += operations[index];
		i += operations[index].length();
		index = -1;
		int end = Integer.MAX_VALUE;
		for (int j = 0; j < operations.length; j++) {
			int current = operator.substring(i, operator.length()).indexOf(operations[j]);
			if (current != -1 && end > current) {
				int prec = current - 1;
				if (prec > 0) {
					if (operator.charAt(prec) == '^') {
						continue;
					}
				}
				end = current + i;
				index = j;
			}
		}
		if (index == -1) {
			int j = i;
			int k = i;
			boolean within = false;
			while (j < operator.length()) {
				do {
					while (j < operator.length() && operator.charAt(j) != '{') {
						j++;
					}
					if (j == operator.length()) {
						k = i;
						break;
					}
					if (operator.charAt(j) == '{') {
						within = true;
					}
					char lastcar = operator.charAt(k);
					while (within == true) {
						formatted += " " + operator.substring(k, j).trim();
						i = j;
						while ( j < operator.length() && operator.charAt(j) != '[') {
							if (operator.charAt(j) == '}' && within == true) {
								within = false;
							}
							if (operator.charAt(j) == '{' && within == false) {
								within = true;
							}
							j++;
						}
						if (within == false) {
							if (lastcar == ']') {
								k = i;
							}
							else {
								k = i - 1;
							}
							break;
						}
						k = j;
						if (j == operator.length()) {
							formatted += " " + operator.substring(i, j).trim();
							k = j;
							break;
						}
						formatted += " " + operator.substring(i, j).trim();
						if (operator.charAt(j) == '[') {
							while (k < operator.length() && operator.charAt(k) != ']') {
								k++;
							}
							if (operator.charAt(k) == ']') {
								j++;
								k--;
								String[] values = operator.substring(j, k).trim().split(",");
								String formattedValues = "";
								for (String value : values) {
									if (value.trim().charAt(0) == '^') {
										value = value.trim().substring(1, value.trim().length());
									}
									String formattedValue = value.trim();
									if ((formattedValue.startsWith("'") || formattedValue.startsWith("\"")) 
											&& (formattedValue.endsWith("'") || formattedValue.endsWith("\""))) {
										formattedValue = formattedValue.substring(1, formattedValue.length() - 1);
									}
									formattedValues += " '" + formattedValue + "',";
								}
								formattedValues = "[ " + formattedValues.substring(1, formattedValues.lastIndexOf(",")) + " ]";
								formatted += " " + formattedValues;
							}
						}
						lastcar = operator.charAt(k + 1);
						k += 2;
						j = k;
					}
					while (j < operator.length() && operator.charAt(j) != '}') {
						j++;
					}
					if (j == operator.length()) {
						break;
					}
					if (operator.charAt(j) == '}') {
						j++;
						formatted += operator.substring(k, j);
						k = j;
						i = j;
						within = false;
					}
				} while (j < operator.length() && operator.charAt(j) != '}');
			}
			formatted += operator.substring(k, operator.length()) + "\n";
		}
		else {
			formatted += " ";
			while (index != -1) {
				int k = end - 1;
				boolean variable = false;
				if (operator.indexOf(operations[index]) != 0) {
					int current = operator.indexOf(operations[index]);
					int prec = current - 1;
					if (prec > 0) {
						if (operator.charAt(prec) == '^') {
							k--;
						}
					}
					while (k > begin && !Character.isAlphabetic(operator.charAt(k)) && !Character.isDigit(operator.charAt(k)) && operator.charAt(k) != '=') {
						k--;
					}
					if (k > begin && operator.charAt(k) == '=') {
						variable = true;
						k--;
					}
					while (k > begin && !Character.isAlphabetic(operator.charAt(k)) && !Character.isDigit(operator.charAt(k))) {
						k--;
					}
					while (k > begin && (Character.isAlphabetic(operator.charAt(k)) || Character.isDigit(operator.charAt(k)))) {
						k--;
					}
				}
				if (variable == false) {
					k = end;
				}
				if (k > i) {
					formatted += operator.substring(i, k).trim() + "\n\t\t";
				}
				else {
					return formatted;
				}
				operator = operator.substring(k, operator.length()).trim();
				i = 0;
				begin = Integer.MAX_VALUE;
				for (int j = 0; j < operations.length; j++) {
					int current = operator.indexOf(operations[j]);
					if (current != -1 && begin > current) {
						int prec = current - 1;
						if (prec > 0) {
							if (operator.charAt(prec) == '^') {
								continue;
							}
						}
						begin = current;
						index = j;
					}
				}
				if (index == - 1) {
					return formatted;
				}
				if (i < begin) {
					while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
						i++;
					}
					while (i < begin && (Character.isAlphabetic(operator.charAt(i)) || Character.isDigit(operator.charAt(i)))) {
						i++;
					}
					while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
						i++;
					}
				}
				i += operations[index].length();
				index = -1;
				end = Integer.MAX_VALUE;
				for (int j = 0; j < operations.length; j++) {
					int current = operator.substring(i, operator.length()).indexOf(operations[j]);
					if (current != -1 && end > current) {
						int prec = current - 1;
						if (prec > 0) {
							if (operator.charAt(prec) == '^') {
								continue;
							}
						}
						end = current + i;
						index = j;
					}
				}
				i = 0;
				if (index == -1) {
					formatted += operator.substring(i, operator.length()).trim() + "\n";
				}
			}
		}
		return formatted;
	}
	
	public static String format(String program) {
		String formatted = "";
		int position = program.indexOf("in \"");
		int i = 0;
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("from \"");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("metamodel \"");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("with");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n\n";
		position = program.indexOf("{");
		String mode = "";
		for (; i < position; i++) {
			formatted += program.charAt(i);
			mode += program.charAt(i);
		}
		mode = mode.trim();
		i++;
		formatted += "{\n";
		while (program.charAt(i) == ' '  || program.charAt(i) == '\t') {
			i++;
		}
		formatted += "\t";
		if (mode.equals("with blocks")) {
			while (i < program.length()) {
				String words = "";
				while (i < program.length() && program.charAt(i) != '{') {
					while (i < program.length() && program.charAt(i) != ' ' && program.charAt(i) != '{' && program.charAt(i) != '\t') {
						words += program.charAt(i);
						i++;
					}
					if (i == program.length()) {
						formatted += "\n";
						break;
					}
					if (words.equals("}")) {
						formatted += "\n";
						break;
					}
					words += " ";
					i++;
				}
				if (formatted.endsWith("\n")) {
					break;
				}
				formatted += words + " " + "{" + "\n";
				int k = i + 1;
				int counter = 1;
				while (k < program.length() && counter != 0) {
					if (program.charAt(k) == '{') {
						counter++;
					}
					if (program.charAt(k) == '}') {
						counter--;
					}
					k++;
				}
				formatted += formatOperator(program.substring(i + 1, k - 1).trim()) + "\t}";
				i = k + 1;
				counter = 0;
				while (k < program.length() && program.charAt(k) != '{' && program.charAt(k) != '\t' && counter != 1) {
					if (program.charAt(k) == '[') {
						counter++;
					}
					k++;
				}
				while (k < program.length()  && program.charAt(k) != '{' && program.charAt(k) != '\t' && counter != 0) {
					if (program.charAt(k) == ']') {
						counter--;
					}
					k++;
				}
				if (k != program.length()) {
					String times = program.substring(i, k).trim();
					if (times.startsWith("[") && times.endsWith("]")) {
						formatted += " " + program.substring(i, k).trim();
						i = k + 1;
					}
				}
				formatted += "\n\t";
			}
			formatted = formatted.substring(0, formatted.length() - 1) + "\n}\n";
			if (program.lastIndexOf("}") > i) {
				formatted += program.substring(i, program.lastIndexOf("}") + 1);
			}
		}
		else {
			formatted += formatOperator(program.substring(i + 1, program.lastIndexOf("}")).trim()) + "}\n";
		}
		return formatted;
	}
	
	//public static void main(String[] args) {
	//	String program = "generate 2 mutants in \"data/out/\" from \"data/model/\" metamodel \"D:/foot/runtime-Synthesis/bpmn.wodel/data/model/simplebpmn.ecore\" with blocks { delete { s0 = select one Sequence where { ^to is typed Activity } a = select one Activity in s0 -> ^to s1 = select one Sequence where { ^from = a } f = select one FlowObject in s1 -> ^to remove a remove s1 modify target ^to from s0 to f } b0 { modify one Message with { name = \"string\" } } }";
	//	System.out.println(format(program));
	//}
	
	/**
	 * @param domainMetamodelPath
	 * @return
	 */
	public static MutatorEnvironment generateWodelProgram(String domainMetamodelPath) {
		MutatorEnvironment mutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment();
		Program program = MutatorenvironmentFactory.eINSTANCE.createProgram();
		program.setExhaustive(true);
		program.setMetamodel(domainMetamodelPath);
		program.setNum(0);
		program.setOutput("data/out/");
		Source source = MutatorenvironmentFactory.eINSTANCE.createSource();
		source.setPath("data/model/");
		program.setSource(source);
		mutatorEnvironment.setDefinition(program);
		
		return mutatorEnvironment;
	}
	
	/**
	 * @param mutatorEnvironment
	 * @param inputPath
	 * @param arrClassNames
	 * @throws MetaModelNotFoundException
	 */
	public static void generateCloningMutationOperators(MutatorEnvironment mutatorEnvironment, String inputPath, boolean deep, ClassSelectionMode classMode, OperatorCoverage coverage, String... arrClassNames) throws MetaModelNotFoundException {
		if (mutatorEnvironment == null || arrClassNames == null || inputPath == null) {
			return;
		}
		if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
			return;
		}
		Program program = (Program) mutatorEnvironment.getDefinition();
		String metamodel = program.getMetamodel();
		List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		List<EClass> eClasses = ModelManager.getEClasses(packages);
		List<String> classNames = Arrays.asList(arrClassNames);

		List<Block> blocks = mutatorEnvironment.getBlocks();
		
		int i = blocks != null ? blocks.size() : 0;
		
		List<String> wodelOperators = new ArrayList<String>();
		wodelOperators.add("clone");

		String strategyClass = "random";
		
		List<Resource> wodelModels = new ArrayList<Resource>();
		File inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
			if (inputPath.indexOf("/") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
			}
			else if (inputPath.indexOf("\\") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
			}
		}
		inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		List<String> wodelElementsNames = new ArrayList<String>();
		
		for (EClass cl : eClasses) {
			if (classNames.contains(cl.getName())) {
				wodelElementsNames.add(cl.getName());
			}
		}
		
		for (EClass cl : eClasses) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		EClass rootClass = ModelManager.getRootEClass(packages);
		int j = 0;
		for (EClass eClass : eClasses) {
			if (EcoreUtil.equals(eClass, rootClass)) {
				j++;
				continue;
			}
			if (classMode == ClassSelectionMode.CONCRETE) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			else if (classMode != ClassSelectionMode.ALL && !classNames.contains(eClass.getName())) {
				j++;
				continue;
			}
			if (coverage == OperatorCoverage.PARTIAL) {
				System.out.println("Generation of clonation mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				List<String> classWithElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("clone")) {
						System.out.println(eClass.getName() + " ----- Clonation mutation operator");
						CloneObjectMutator cloneObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
						cloneObjectMutator.setContents(deep);
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						cloneObjectMutator.setName("p");
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType == null) {
										if (feature instanceof EAttribute) {
											Operator operator = Operator.EQUALS;
											if (attribute.getEType().getName().equals("EString")) {
												RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
												stringType.setOperator(operator);
												stringType.setMin(0);
												stringType.setMax(10);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(0);
												integerType.setMax(10);
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
												doubleType.setOperator(operator);
												doubleType.setMin(0);
												doubleType.setMax(10);
												attributeType = doubleType;
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										cloneObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										cloneObjectMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						cloneObjectMutator.setObject(obSelectionStrategy);
						mutator.add(cloneObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
			if (coverage == OperatorCoverage.FULL) {
				System.out.println("Generation of clonation mutation operators for the class: " + eClass.getName());
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("clone")) {
						System.out.println(eClass.getName() + " ----- Clonation mutation operator");
						CloneObjectMutator cloneObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
						cloneObjectMutator.setContents(deep);
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						cloneObjectMutator.setName("p");
						cloneObjectMutator.setObject(obSelectionStrategy);
						mutator.add(cloneObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
				
			}
		}
	}

	/**
	 * @param mutatorEnvironment
	 * @param inputPath
	 * @param arrClassNames
	 * @throws MetaModelNotFoundException
	 */
	public static void generateModificationMutationOperators(MutatorEnvironment mutatorEnvironment, String inputPath, ClassSelectionMode classMode, OperatorCoverage coverage, String... arrClassNames) throws MetaModelNotFoundException {
		if (mutatorEnvironment == null || arrClassNames == null || inputPath == null) {
			return;
		}
		if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
			return;
		}
		Program program = (Program) mutatorEnvironment.getDefinition();
		String metamodel = program.getMetamodel();
		List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		List<EClass> eClasses = ModelManager.getEClasses(packages);
		List<String> classNames = Arrays.asList(arrClassNames);

		List<Block> blocks = mutatorEnvironment.getBlocks();
		
		int i = blocks != null ? blocks.size() : 0;
		
		List<String> wodelOperators = new ArrayList<String>();
		wodelOperators.add("modify");

		String strategyClass = "random";
		
		List<Resource> wodelModels = new ArrayList<Resource>();
		File inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
			if (inputPath.indexOf("/") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
			}
			else if (inputPath.indexOf("\\") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
			}
		}
		inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		List<String> wodelElementsNames = new ArrayList<String>();
		
		for (EClass cl : eClasses) {
			if (classNames.contains(cl.getName())) {
				wodelElementsNames.add(cl.getName());
			}
		}
		
		for (EClass cl : eClasses) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		EClass rootClass = ModelManager.getRootEClass(packages);
		int j = 0;
		for (EClass eClass : eClasses) {
			if (EcoreUtil.equals(eClass, rootClass)) {
				j++;
				continue;
			}
			if (classMode == ClassSelectionMode.CONCRETE) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			else if (classMode != ClassSelectionMode.ALL && !classNames.contains(eClass.getName())) {
				j++;
				continue;
			}
			if (coverage == OperatorCoverage.PARTIAL) {
				System.out.println("Generation of modification mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				List<String> classWithElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("modify")) {
						System.out.println(eClass.getName() + " ----- Modification mutation operator");
						ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						modifyInformationMutator.setName("p");
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType == null) {
										if (feature instanceof EAttribute) {
											Operator operator = Operator.EQUALS;
											if (attribute.getEType().getName().equals("EString")) {
												RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
												stringType.setOperator(operator);
												stringType.setMin(0);
												stringType.setMax(10);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(0);
												integerType.setMax(10);
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
												doubleType.setOperator(operator);
												doubleType.setMin(0);
												doubleType.setMax(10);
												attributeType = doubleType;
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										modifyInformationMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								EAttribute attribute = (EAttribute) feature;
								AttributeType attributeType = null;
								AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
								attributeScalar.getAttribute().add(attribute);
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
								}
								if (attributeType != null) {
									attributeScalar.setValue(attributeType);
								}
								if (attributeScalar != null && attributeScalar.getValue() != null) {
									modifyInformationMutator.getAttributes().add(attributeScalar);
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										modifyInformationMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						modifyInformationMutator.setObject(obSelectionStrategy);
						mutator.add(modifyInformationMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
			}
			if (coverage == OperatorCoverage.FULL) {
				System.out.println("Generation of modification mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					if (wodelOperator.equals("modify")) {
						int featureIndex = 0;
						for (EStructuralFeature targetFeature : eClass.getEAllStructuralFeatures()) {
							if (targetFeature instanceof EReference && ((EReference) targetFeature).getEOpposite() != null) {
								continue;
							}
							List<Object> featureValues = new ArrayList<Object>();
							featureValues.addAll(featureWithValues.get(featureIndex));
							if (targetFeature.getEType() instanceof EEnum) {
								EEnum eEnum = (EEnum) targetFeature.getEType();
								List<EEnumLiteral> literals = eEnum.getELiterals();
								for (EEnumLiteral literal : literals) {
									if (!featureValues.contains(literal.getLiteral())) {
										featureValues.add(literal.getLiteral());
									}
								}
							}
							if (featureValues.size() == 0) {
								List<Mutator> mutator = new ArrayList<Mutator>();
								List<Mutator> commands = new ArrayList<Mutator>();
								Block block = null;
								String blockName = "";
								blockName = "b" + i;
								block = MutatorenvironmentFactory.eINSTANCE.createBlock();
								block.setName(blockName);
								SelectObjectMutator selectObjectMutator = null;
								if (targetFeature instanceof EReference) {
									System.out.println(eClass.getName() + " ----- Selection mutation operator");
									selectObjectMutator = MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator();
									ObSelectionStrategy obSelectionStrategy = null;
									if (strategyClass.equals("random")) {
										obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									}
									if (strategyClass.equals("complete")) {
										obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
									}
									obSelectionStrategy.setType((EClass) targetFeature.getEType());
									selectObjectMutator.setObject(obSelectionStrategy);
									String selectObjectMutatorName = "s";
									selectObjectMutator.setName(selectObjectMutatorName);
									mutator.add(selectObjectMutator);
								}
								System.out.println(eClass.getName() + " ----- Modification mutation operator");
								ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
								ObSelectionStrategy obSelectionStrategy = null;
								if (strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
								if (targetFeature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) targetFeature;
									SpecificObjectSelection referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection();
									Operator operator = Operator.DIFFERENT;
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									referenceStrategy.setObjSel(selectObjectMutator);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
								if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
									for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
										if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
											expression.setFirst(referenceEvaluation);
										}
									}
								}
								modifyInformationMutator.setName("p");
								if (expression.getFirst() != null) {
									obSelectionStrategy.setExpression(expression);
								}
								if (targetFeature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) targetFeature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									if (targetFeature instanceof EAttribute) {
										Operator operator = Operator.EQUALS;
										if (attribute.getEType().getName().equals("EString")) {
											RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
											stringType.setOperator(operator);
											stringType.setMin(0);
											stringType.setMax(10);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
											integerType.setOperator(operator);
											integerType.setMin(0);
											integerType.setMax(10);
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
											booleanType.setOperator(operator);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
											doubleType.setOperator(operator);
											doubleType.setMin(0);
											doubleType.setMax(10);
											attributeType = doubleType;
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										modifyInformationMutator.getAttributes().add(attributeScalar);
									}
								}
								if (targetFeature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) targetFeature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									if (attribute.getEType() instanceof EEnum) {
										ListStringType eEnumType = null;
										if (attributeType == null) {
											Operator operator = Operator.IN;
											eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
											eEnumType.setOperator(operator);
											attributeType = eEnumType;
										}
										List<String> values = eEnumType.getValue();
										EEnum eEnum = (EEnum) attribute.getEType();
										List<EEnumLiteral> literals = eEnum.getELiterals();
										for (EEnumLiteral literal : literals) {
											if (!values.contains(literal.getLiteral())) {
												values.add(literal.getLiteral());
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										modifyInformationMutator.getAttributes().add(attributeScalar);
									}
								}
								if (targetFeature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) targetFeature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									SpecificObjectSelection referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection();
									referenceStrategy.setObjSel(selectObjectMutator);
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										modifyInformationMutator.getReferences().add(referenceInit);
									}
								}
								modifyInformationMutator.setObject(obSelectionStrategy);
								mutator.add(modifyInformationMutator);
								if (block != null) {
									if (mutator.size() > 0) {
										for (Mutator mut : mutator) {
											if (mut != null) {
												commands.add(mut);
											}
										}
									}
									if (commands.size() > 0) {
										for (Mutator com : commands) {
											if (com != null) {
												block.getCommands().add(com);
											}
										}
										if (block.getCommands().size() > 0) {
											blocks.add(block);
											i++;
										}
									}
								}
							}
							else {
								for (Object featureValue : featureValues) {
									List<Mutator> mutator = new ArrayList<Mutator>();
									List<Mutator> commands = new ArrayList<Mutator>();
									Block block = null;
									String blockName = "";
									blockName = "b" + i;
									block = MutatorenvironmentFactory.eINSTANCE.createBlock();
									block.setName(blockName);
									SelectObjectMutator selectObjectMutator = null;
									if (targetFeature instanceof EReference) {
										System.out.println(eClass.getName() + " ----- Selection mutation operator");
										selectObjectMutator = MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator();
										ObSelectionStrategy obSelectionStrategy = null;
										if (strategyClass.equals("random")) {
											obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										}
										if (strategyClass.equals("complete")) {
											obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
										}
										obSelectionStrategy.setType((EClass) targetFeature.getEType());
										selectObjectMutator.setObject(obSelectionStrategy);
										String selectObjectMutatorName = "s";
										selectObjectMutator.setName(selectObjectMutatorName);
										mutator.add(selectObjectMutator);
									}
									System.out.println(eClass.getName() + " ----- Modification mutation operator");
									ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
									ObSelectionStrategy obSelectionStrategy = null;
									if (strategyClass.equals("random")) {
										obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									}
									if (strategyClass.equals("complete")) {
										obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
									}
									obSelectionStrategy.setType(eClass);
									Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
									List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
									if (targetFeature instanceof EReference) {
										ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										EReference reference = (EReference) targetFeature;
										SpecificObjectSelection referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection();
										Operator operator = Operator.DIFFERENT;
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
										referenceStrategy.setObjSel(selectObjectMutator);
										if (referenceEvaluation != null) {
											listReferenceEvaluation.add(referenceEvaluation);
										}
									}
									if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
										for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
											if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
												expression.setFirst(referenceEvaluation);
											}
										}
									}
									int k = 0;
									int mAtt = 0;
									List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
									for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
										if (classWhereElements.contains(feature.getName())) {
											List<Object> lob = new ArrayList<Object>();
											for (Object ob : featureWhereValues.get(k)) {
												if (!ob.equals(featureValue)) {
													lob.add(ob);
												}
											}
											k++;
											if (feature instanceof EAttribute) {
												AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
												EAttribute attribute = (EAttribute) feature;
												AttributeEvaluationType attributeType = null;
												for (Object ob : lob) {
													if (attribute.getEType().getName().equals("EString")) {
														ListStringType stringType = null;
														if (attributeType == null) {
															Operator operator = Operator.IN;
															stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
															stringType.setOperator(operator);
															attributeType = stringType;
														}
														else {
															stringType = (ListStringType) attributeType;
														}
														stringType.getValue().add(((String) ob).replace("\\n", ""));
													}
													if (attribute.getEType().getName().equals("EInt")) {
														SpecificIntegerType integerType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
															integerType.setOperator(operator);
															attributeType = integerType;
														}
														else {
															integerType = (SpecificIntegerType) attributeType;
														}
														integerType.setValue((int) ob);
													}
													if (attribute.getEType().getName().equals("EBoolean")) {
														SpecificBooleanType booleanType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
															booleanType.setOperator(operator);
															attributeType = booleanType;
														}
														else {
															booleanType = (SpecificBooleanType) attributeType;
														}
														booleanType.setValue((boolean) ob);
													}
													if (attribute.getEType().getName().equals("EDouble")) {
														SpecificDoubleType doubleType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
															doubleType.setOperator(operator);
															attributeType = doubleType;
														}
														doubleType.setValue((double) ob);
													}
													if (attributeType != null) {
														attributeEvaluation.setName(attribute);
														attributeEvaluation.setValue(attributeType);
													}
												}
												if (attributeType != null) {
													listAttributeEvaluation.add(attributeEvaluation);
												}
											}
										}
									}
									for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
										if (feature instanceof EAttribute) {
											AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											EAttribute attribute = (EAttribute) feature;
											AttributeEvaluationType attributeType = null;
											if (attribute.getEType() instanceof EEnum) {
												ListStringType eEnumType = null;
												if (attributeType == null) {
													Operator operator = Operator.IN;
													eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
													eEnumType.setOperator(operator);
													attributeType = eEnumType;
												}
												List<String> values = eEnumType.getValue();
												EEnum eEnum = (EEnum) attribute.getEType();
												List<EEnumLiteral> literals = eEnum.getELiterals();
												for (EEnumLiteral literal : literals) {
													if (!values.contains(literal.getLiteral()) && !featureValue.equals(literal.getLiteral())) {
														values.add(literal.getLiteral());
													}
												}
												if (values.size() > 0 && attributeType != null) {
													attributeEvaluation.setName(attribute);
													attributeEvaluation.setValue(attributeType);
												}
											}
											if (attributeType != null) {
												listAttributeEvaluation.add(attributeEvaluation);
											}
										}
									}
									mAtt = 0;
									if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
										for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
											if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
												if (mAtt == 0) {
													expression.setFirst(attributeEvaluation);
												}
												if (mAtt > 0) {
													expression.getSecond().add(attributeEvaluation);
													BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
													operator.setType(LogicOperator.OR);
													expression.getOperator().add(operator);
												}
												mAtt++;
											}
										}
									}
									modifyInformationMutator.setName("p");
									if (mAtt > 0) {
										obSelectionStrategy.setExpression(expression);
									}
									if (targetFeature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) targetFeature;
										AttributeType attributeType = null;
										AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = null;
											Operator operator = Operator.IN;
											stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											attributeType = stringType;
											stringType.setValue((String.valueOf(featureValue)).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) featureValue);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) featureValue);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) featureValue);
										}
										if (attributeType == null) {
											if (targetFeature instanceof EAttribute) {
												Operator operator = Operator.EQUALS;
												if (attribute.getEType().getName().equals("EString")) {
													RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
													stringType.setOperator(operator);
													stringType.setMin(0);
													stringType.setMax(10);
													attributeType = stringType;
												}
												if (attribute.getEType().getName().equals("EInt")) {
													RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
													integerType.setOperator(operator);
													integerType.setMin(0);
													integerType.setMax(10);
													attributeType = integerType;
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
													doubleType.setOperator(operator);
													doubleType.setMin(0);
													doubleType.setMax(10);
													attributeType = doubleType;
												}
											}
											if (attributeType != null) {
												attributeScalar.setValue(attributeType);
											}
											if (attributeScalar != null && attributeScalar.getValue() != null) {
												modifyInformationMutator.getAttributes().add(attributeScalar);
											}
										}
									}
									if (targetFeature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) targetFeature;
										AttributeType attributeType = null;
										AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										if (attribute.getEType() instanceof EEnum) {
											SpecificStringType eEnumType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												eEnumType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												eEnumType.setOperator(operator);
												eEnumType.setValue(String.valueOf(featureValue));
												attributeType = eEnumType;
											}
										}
										if (attributeType != null) {
											attributeScalar.setValue(attributeType);
										}
										if (attributeScalar != null && attributeScalar.getValue() != null) {
											modifyInformationMutator.getAttributes().add(attributeScalar);
										}
									}
									if (targetFeature instanceof EReference) {
										ReferenceInit referenceInit = null;
										EReference reference = (EReference) targetFeature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										SpecificObjectSelection referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection();
										referenceStrategy.setObjSel(selectObjectMutator);
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
										if (referenceInit != null) {
											modifyInformationMutator.getReferences().add(referenceInit);
										}
									}
									modifyInformationMutator.setObject(obSelectionStrategy);
									mutator.add(modifyInformationMutator);
									if (block != null) {
										if (mutator.size() > 0) {
											for (Mutator mut : mutator) {
												if (mut != null) {
													commands.add(mut);
												}
											}
										}
										if (commands.size() > 0) {
											for (Mutator com : commands) {
												if (com != null) {
													block.getCommands().add(com);
												}
											}
											if (block.getCommands().size() > 0) {
												blocks.add(block);
												i++;
											}
										}
									}
								}
							}
						}
						featureIndex++;
					}
				}
			}
			j++;
		}
	}


	/**
	 * @param mutatorEnvironment
	 * @param inputPath
	 * @param arrClassNames
	 * @throws MetaModelNotFoundException
	 */
	public static void generateRetypingMutationOperators(MutatorEnvironment mutatorEnvironment, String inputPath, ClassSelectionMode classMode, OperatorCoverage coverage, String[] arrExcludedSuperClassNames, String... arrClassNames) throws MetaModelNotFoundException {
		if (mutatorEnvironment == null || arrClassNames == null || inputPath == null) {
			return;
		}
		if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
			return;
		}
		Program program = (Program) mutatorEnvironment.getDefinition();
		String metamodel = program.getMetamodel();
		List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		List<EClass> completeEClasses = ModelManager.getEClasses(packages);
		List<String> classNames = Arrays.asList(arrClassNames);

		List<Block> blocks = mutatorEnvironment.getBlocks();
		
		int i = blocks != null ? blocks.size() : 0;
		
		List<String> wodelOperators = new ArrayList<String>();
		wodelOperators.add("retype");

		String strategyClass = "random";
		
		List<Resource> wodelModels = new ArrayList<Resource>();
		File inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
			if (inputPath.indexOf("/") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
			}
			else if (inputPath.indexOf("\\") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
			}
		}
		inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		List<String> wodelElementsNames = new ArrayList<String>();
		
		List<EClass> excludedSuperTypes = new ArrayList<EClass>();
		for (String arrExcludedSuperType : arrExcludedSuperClassNames) {
			for (EClass cl : completeEClasses) {
				if (arrExcludedSuperType.equals(cl.getName())) {
					excludedSuperTypes.add(cl);
					break;
				}
			}
		}
		List<EClass> eClasses = new ArrayList<EClass>();
		for (EClass cl : completeEClasses) {
			if (!excludedSuperTypes.contains(cl)) {
				eClasses.add(cl);
			}
		}

		for (EClass cl : eClasses) {
			if (classNames.contains(cl.getName())) {
				wodelElementsNames.add(cl.getName());
			}
		}
		
		for (EClass cl : eClasses) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		EClass rootClass = ModelManager.getRootEClass(packages);
		int j = 0;
		for (EClass eClass : eClasses) {
			if (EcoreUtil.equals(eClass, rootClass)) {
				j++;
				continue;
			}
			if (classMode == ClassSelectionMode.CONCRETE) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			else if (classMode != ClassSelectionMode.ALL && !classNames.contains(eClass.getName())) {
				j++;
				continue;
			}
			if (coverage == OperatorCoverage.PARTIAL) {
				System.out.println("Generation of retyping mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				List<String> classWithElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("retype")) {
						System.out.println(eClass.getName() + " ----- Retyping mutation operator");
						RetypeObjectMutator retypeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRetypeObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						retypeObjectMutator.setObject(obSelectionStrategy);
						List<EClass> siblingEClasses = ModelManager.getSiblingEClasses(metamodel, MutatorUtils.getStrategyTypes(retypeObjectMutator.getObject()), excludedSuperTypes);
						List<EClass> classesToAdd = new ArrayList<EClass>();
						for (EClass sibCl : siblingEClasses) {
							EClassifier classifier = eClass.getEPackage().getEClassifier(sibCl.getName());
							if (classifier instanceof EClass) {
								EClass classToAdd = (EClass) classifier;
								if (classToAdd.isAbstract() == false) {
									classesToAdd.add(classToAdd);
								}
							}
						}
						if (classesToAdd.size() > 0) {
							Map<EClass, List<EStructuralFeature>> classesToAddFeatures = new HashMap<EClass, List<EStructuralFeature>>();
							for (EClass classToAdd : classesToAdd) {
								List<EStructuralFeature> classToAddFeatures = new ArrayList<EStructuralFeature>();
								classToAddFeatures.addAll(classToAdd.getEAllStructuralFeatures());
								classesToAddFeatures.put(classToAdd, classToAddFeatures);
							}
							List<EStructuralFeature> featuresToAdd = new ArrayList<EStructuralFeature>();
							featuresToAdd.addAll(eClass.getEAllStructuralFeatures());
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								boolean shared = true;
								for (EClass classToAdd : classesToAddFeatures.keySet()) {
									if (!classesToAddFeatures.get(classToAdd).contains(feature)) {
										shared = false;
										break;
									}
								}
								if (shared == false) {
									featuresToAdd.remove(feature);
								}
							}
							retypeObjectMutator.getTypes().addAll(classesToAdd);
							Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
							int k = 0;
							int mAtt = 0;
							List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWhereElements.contains(feature.getName())) {
									List<Object> lob = featureWhereValues.get(k);
									k++;
									if (feature instanceof EAttribute) {
										AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										EAttribute attribute = (EAttribute) feature;
										AttributeEvaluationType attributeType = null;
										for (Object ob : lob) {
											if (attribute.getEType().getName().equals("EString")) {
												ListStringType stringType = null;
												if (attributeType == null) {
													Operator operator = Operator.IN;
													stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
													stringType.setOperator(operator);
													attributeType = stringType;
												}
												else {
													stringType = (ListStringType) attributeType;
												}
												stringType.getValue().add(((String) ob).replace("\\n", ""));
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
													integerType.setOperator(operator);
													attributeType = integerType;
												}
												else {
													integerType = (SpecificIntegerType) attributeType;
												}
												integerType.setValue((int) ob);
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												else {
													booleanType = (SpecificBooleanType) attributeType;
												}
												booleanType.setValue((boolean) ob);
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
													doubleType.setOperator(operator);
													attributeType = doubleType;
												}
												doubleType.setValue((double) ob);
											}
											if (attributeType != null) {
												attributeEvaluation.setName(attribute);
												attributeEvaluation.setValue(attributeType);
											}
										}
										if (attributeType != null) {
											listAttributeEvaluation.add(attributeEvaluation);
										}
									}
								}
							}
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									if (attribute.getEType() instanceof EEnum) {
										ListStringType eEnumType = null;
										if (attributeType == null) {
											Operator operator = Operator.IN;
											eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
											eEnumType.setOperator(operator);
											attributeType = eEnumType;
										}
										List<String> values = eEnumType.getValue();
										EEnum eEnum = (EEnum) attribute.getEType();
										List<EEnumLiteral> literals = eEnum.getELiterals();
										for (EEnumLiteral literal : literals) {
											if (!values.contains(literal.getLiteral())) {
												values.add(literal.getLiteral());
											}
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
							mAtt = 0;
							if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
								for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
									if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
										if (mAtt == 0) {
											expression.setFirst(attributeEvaluation);
										}
										if (mAtt > 0) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
										mAtt++;
									}
								}
							}
							k = 0;
							int mRef = 0;
							List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWhereElements.contains(feature.getName())) {
									k++;
									if (feature instanceof EReference) {
										ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										EReference reference = (EReference) feature;
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
										if (referenceEvaluation != null) {
											listReferenceEvaluation.add(referenceEvaluation);
										}
									}
								}
							}
							mRef = 0;
							if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
								for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
									if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
										if (mAtt == 0 && mRef == 0) {
											expression.setFirst(referenceEvaluation);
										}
										if (mAtt > 0 || mRef > 0) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
										mRef++;
									}
								}
							}
							retypeObjectMutator.setName("p");
							if (mAtt > 0 || mRef > 0) {
								obSelectionStrategy.setExpression(expression);
							}
							k = 0;
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWithElements.contains(feature.getName())) {
									List<Object> lob = featureWithValues.get(k);
									k++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										AttributeType attributeType = null;
										AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										for (Object ob : lob) {
											if (attribute.getEType().getName().equals("EString")) {
												ListStringType stringType = null;
												if (attributeType == null) {
													Operator operator = Operator.IN;
													stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
													stringType.setOperator(operator);
													attributeType = stringType;
												}
												else {
													stringType = (ListStringType) attributeType;
												}
												stringType.getValue().add(((String) ob).replace("\\n", ""));
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
													integerType.setOperator(operator);
													attributeType = integerType;
												}
												else {
													integerType = (SpecificIntegerType) attributeType;
												}
												integerType.setValue((int) ob);
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												else {
													booleanType = (SpecificBooleanType) attributeType;
												}
												booleanType.setValue((boolean) ob);
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
													doubleType.setOperator(operator);
													attributeType = doubleType;
												}
												doubleType.setValue((double) ob);
											}
										}
										if (attributeType == null) {
											if (feature instanceof EAttribute) {
												Operator operator = Operator.EQUALS;
												if (attribute.getEType().getName().equals("EString")) {
													RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
													stringType.setOperator(operator);
													stringType.setMin(0);
													stringType.setMax(10);
													attributeType = stringType;
												}
												if (attribute.getEType().getName().equals("EInt")) {
													RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
													integerType.setOperator(operator);
													integerType.setMin(0);
													integerType.setMax(10);
													attributeType = integerType;
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
													doubleType.setOperator(operator);
													doubleType.setMin(0);
													doubleType.setMax(10);
													attributeType = doubleType;
												}
											}
										}
										if (attributeType != null) {
											attributeScalar.setValue(attributeType);
										}
										if (attributeScalar != null && attributeScalar.getValue() != null) {
											retypeObjectMutator.getAttributes().add(attributeScalar);
										}
									}
								}
							}
							for (EStructuralFeature feature : featuresToAdd) {
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									if (attribute.getEType() instanceof EEnum) {
										ListStringType eEnumType = null;
										if (attributeType == null) {
											Operator operator = Operator.IN;
											eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
											eEnumType.setOperator(operator);
											attributeType = eEnumType;
										}
										List<String> values = eEnumType.getValue();
										EEnum eEnum = (EEnum) attribute.getEType();
										List<EEnumLiteral> literals = eEnum.getELiterals();
										for (EEnumLiteral literal : literals) {
											if (!values.contains(literal.getLiteral())) {
												values.add(literal.getLiteral());
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										retypeObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
							k = 0;
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWithElements.contains(feature.getName())) {
									k++;
									if (feature instanceof EReference) {
										ReferenceInit referenceInit = null;
										EReference reference = (EReference) feature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										referenceStrategy.setType((EClass) reference.getEType());
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
										if (referenceInit != null) {
											retypeObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
							}
							retypeObjectMutator.setObject(obSelectionStrategy);
							mutator.add(retypeObjectMutator);
						}
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
			if (coverage == OperatorCoverage.FULL) {
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("retype")) {
						System.out.println(eClass.getName() + " ----- Retyping mutation operator");
						RetypeObjectMutator retypeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRetypeObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						retypeObjectMutator.setObject(obSelectionStrategy);
						List<EClass> siblingEClasses = ModelManager.getSiblingEClasses(metamodel, MutatorUtils.getStrategyTypes(retypeObjectMutator.getObject()), excludedSuperTypes);
						List<EClass> classesToAdd = new ArrayList<EClass>();
						for (EClass sibCl : siblingEClasses) {
							EClassifier classifier = eClass.getEPackage().getEClassifier(sibCl.getName());
							if (classifier instanceof EClass) {
								EClass classToAdd = (EClass) classifier;
								if (classToAdd.isAbstract() == false) {
									classesToAdd.add(classToAdd);
								}
							}
						}
						if (classesToAdd.size() > 0) {
							retypeObjectMutator.getTypes().addAll(classesToAdd);
							retypeObjectMutator.setName("p");
							retypeObjectMutator.setObject(obSelectionStrategy);
							mutator.add(retypeObjectMutator);
						}
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
		}
	}
	
	/**
	 * @param mutatorEnvironment
	 * @param inputPath
	 * @param arrClassNames
	 * @throws MetaModelNotFoundException
	 */
	public static void generateCreationMutationOperators(MutatorEnvironment mutatorEnvironment, String inputPath, ClassSelectionMode classMode, OperatorCoverage coverage, String... arrClassNames) throws MetaModelNotFoundException {
		if (mutatorEnvironment == null || arrClassNames == null || inputPath == null) {
			return;
		}
		if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
			return;
		}
		Program program = (Program) mutatorEnvironment.getDefinition();
		String metamodel = program.getMetamodel();
		List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		List<EClass> eClasses = ModelManager.getEClasses(packages);
		List<String> classNames = Arrays.asList(arrClassNames);

		List<Block> blocks = mutatorEnvironment.getBlocks();
		
		int i = blocks != null ? blocks.size() : 0;
		
		List<String> wodelOperators = new ArrayList<String>();
		wodelOperators.add("create");

		String strategyClass = "random";
		
		List<Resource> wodelModels = new ArrayList<Resource>();
		File inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
			if (inputPath.indexOf("/") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
			}
			else if (inputPath.indexOf("\\") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
			}
		}
		inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		List<String> wodelElementsNames = new ArrayList<String>();
		
		for (EClass cl : eClasses) {
			if (classNames.contains(cl.getName())) {
				wodelElementsNames.add(cl.getName());
			}
		}
		
		for (EClass cl : eClasses) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		EClass rootClass = ModelManager.getRootEClass(packages);
		int j = 0;
		for (EClass eClass : eClasses) {
			if (EcoreUtil.equals(eClass, rootClass)) {
				j++;
				continue;
			}
			if (eClass.isAbstract() == true) {
				j++;
				continue;
			}
			if (classMode == ClassSelectionMode.CONCRETE) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			else if (classMode != ClassSelectionMode.ALL && !classNames.contains(eClass.getName())) {
				j++;
				continue;
			}
			if (coverage == OperatorCoverage.PARTIAL) {
				System.out.println("Generation of creation mutation operators for the class: " + eClass.getName());
				List<String> classWithElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("create")) {
						System.out.println(eClass.getName() + " ----- Creation mutation operator");
						CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
						createObjectMutator.setType(eClass);
						int k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										createObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								EAttribute attribute = (EAttribute) feature;
								AttributeType attributeType = null;
								AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
								attributeScalar.getAttribute().add(attribute);
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
								}
								if (attributeType != null) {
									attributeScalar.setValue(attributeType);
								}
								if (attributeScalar != null && attributeScalar.getValue() != null) {
									createObjectMutator.getAttributes().add(attributeScalar);
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										createObjectMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						k = 0;
						mutator.add(createObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
			if (coverage == OperatorCoverage.FULL) {
				System.out.println("Generation of creation mutation operators for the class: " + eClass.getName());
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("create")) {
						System.out.println(eClass.getName() + " ----- Creation mutation operator");
						CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
						createObjectMutator.setType(eClass);
						mutator.add(createObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
		}
	}

	/**
	 * @param mutatorEnvironment
	 * @param inputPath
	 * @param arrClassNames
	 * @throws MetaModelNotFoundException
	 */
	public static void generateRemovalMutationOperators(MutatorEnvironment mutatorEnvironment, String inputPath, ClassSelectionMode classMode, OperatorCoverage coverage, String... arrClassNames) throws MetaModelNotFoundException {
		if (mutatorEnvironment == null || arrClassNames == null || inputPath == null) {
			return;
		}
		if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
			return;
		}
		Program program = (Program) mutatorEnvironment.getDefinition();
		String metamodel = program.getMetamodel();
		List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		List<EClass> eClasses = ModelManager.getEClasses(packages);
		List<String> classNames = Arrays.asList(arrClassNames);

		List<Block> blocks = mutatorEnvironment.getBlocks();
		
		int i = blocks != null ? blocks.size() : 0;
		
		List<String> wodelOperators = new ArrayList<String>();
		wodelOperators.add("remove");

		String strategyClass = "random";
		
		List<Resource> wodelModels = new ArrayList<Resource>();
		File inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
			if (inputPath.indexOf("/") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
			}
			else if (inputPath.indexOf("\\") != -1) {
				inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
			}
		}
		inputPathFile = new File(inputPath);
		if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
			System.out.println("This input folder " + inputPath + " does not exist.");
			return;
		}
		wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		List<String> wodelElementsNames = new ArrayList<String>();
		
		for (EClass cl : eClasses) {
			if (classNames.contains(cl.getName())) {
				wodelElementsNames.add(cl.getName());
			}
		}
		
		for (EClass cl : eClasses) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		EClass rootClass = ModelManager.getRootEClass(packages);
		int j = 0;
		for (EClass eClass : eClasses) {
			if (EcoreUtil.equals(eClass, rootClass)) {
				j++;
				continue;
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			if (classMode == ClassSelectionMode.CONCRETE) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
			}
//			if (eClass.isAbstract() == true) {
//				j++;
//				continue;
//			}
			else if (classMode != ClassSelectionMode.ALL && !classNames.contains(eClass.getName())) {
				j++;
				continue;
			}
			if (coverage == OperatorCoverage.PARTIAL) {
				System.out.println("Generation of remove mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("remove")) {
						System.out.println(eClass.getName() + " ----- Deletion mutation operator");
						RemoveObjectMutator removeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						removeObjectMutator.setObject(obSelectionStrategy);
						mutator.add(removeObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
			if (coverage == OperatorCoverage.FULL) {
				System.out.println("Generation of remove mutation operators for the class: " + eClass.getName());
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("remove")) {
						System.out.println(eClass.getName() + " ----- Deletion mutation operator");
						RemoveObjectMutator removeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						removeObjectMutator.setObject(obSelectionStrategy);
						mutator.add(removeObjectMutator);
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}
		}
	}
	
	/**
	 * Persists the generated Wodel semantic model as XMI. This is the canonical
	 * representation used by the headless API and does not require Xtext text
	 * serialization.
	 *
	 * @return path of the generated XMI model
	 */
	public static Path persistWodelProgramModel(
            MutatorEnvironment mutatorEnvironment,
            String wodelProjectPath)
            throws IOException {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }
        if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
            throw new IllegalArgumentException(
                    "The mutation environment must contain a Program definition");
        }

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        String projectName = project.getFileName().toString();
        Path dataOutDirectory = project.resolve("data").resolve("out");
        Files.createDirectories(dataOutDirectory);
        Path xmiProgram = dataOutDirectory.resolve(projectName + ".model");

        serialize(mutatorEnvironment, xmiProgram.toUri().toString());
        return xmiProgram;
    }

    /**
     * Explicitly exports an in-memory Wodel semantic model as human-readable
     * <code>.mutator</code> source. This operation is intentionally optional
     * because Xtext semantic serialization can be expensive for very large
     * automatically generated mutation programs.
     *
     * @return path of the exported Wodel source
     */
    public static Path exportWodelSource(
            MutatorEnvironment mutatorEnvironment,
            String wodelProjectPath)
            throws IOException {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }
        if (!(mutatorEnvironment.getDefinition() instanceof Program)) {
            throw new IllegalArgumentException(
                    "The mutation environment must contain a Program definition");
        }

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        String projectName = project.getFileName().toString();
        Path sourceDirectory = project.resolve("src");
        Files.createDirectories(sourceDirectory);
        Path programFile = sourceDirectory.resolve(projectName + ".mutator");

        long start = System.nanoTime();
        System.err.println(">>> Exporting Wodel source: " + programFile);
        String effectiveProgram = deserialize(
                programFile.toUri().toString(), mutatorEnvironment);
        Files.writeString(programFile, effectiveProgram, StandardCharsets.UTF_8);
        System.err.println(">>> Wodel source export finished: "
                + effectiveProgram.length() + " chars, "
                + elapsedMillis(start) + " ms");
        return programFile;
    }

    /**
     * Compatibility wrapper preserving the previous API. New headless callers
     * should normally use {@link #persistWodelProgramModel(MutatorEnvironment, String)}
     * and call {@link #exportWodelSource(MutatorEnvironment, String)} only when
     * textual source is actually wanted.
     */
    public static void serializeWodelProgram(
            MutatorEnvironment mutatorEnvironment,
            String wodelProjectPath)
            throws IOException, MetaModelNotFoundException {
        persistWodelProgramModel(mutatorEnvironment, wodelProjectPath);
        exportWodelSource(mutatorEnvironment, wodelProjectPath);
    }

    /**
     * Generates/compiles Java artifacts for an in-memory mutation environment.
     * Java code is produced directly from the semantic EMF model. Textual
     * .mutator serialization is performed only when keepSource is explicitly
     * requested.
     */
    /** Generate standalone Java directly from an in-memory Wodel semantic model. */
    public static ExecutionResult generateWodelCodeChecked(
            MutatorEnvironment mutatorEnvironment,
            String wodelProjectPath) throws IOException {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }
        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        long start = System.nanoTime();

        Injector injector = new WodelStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        WodelSemanticCodeGenerator codeGenerator =
                injector.getInstance(WodelSemanticCodeGenerator.class);
        WodelSemanticCodeGenerator.GenerationResult generated =
                codeGenerator.generateStandalone(
                        mutatorEnvironment, project.toString());

        return new ExecutionResult(true, 0, "codegen",
                generated.toString(), elapsedMillis(start));
    }

    /** Generate standalone Java directly from the canonical Wodel .model XMI. */
    public static ExecutionResult generateWodelCodeFromModelChecked(
            String modelPath,
            String wodelProjectPath) throws IOException {

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        long start = System.nanoTime();

        Injector injector = new WodelStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        WodelSemanticCodeGenerator codeGenerator =
                injector.getInstance(WodelSemanticCodeGenerator.class);
        WodelSemanticCodeGenerator.GenerationResult generated =
                codeGenerator.generateStandaloneFromModel(
                        modelPath, project.toString());

        return new ExecutionResult(true, 0, "codegen",
                generated.toString(), elapsedMillis(start));
    }

    public static ExecutionResult compileWodelEnvironmentChecked(
            MutatorEnvironment mutatorEnvironment,
            String wodelProjectPath,
            String eclipseHomePath,
            String compilerName,
            boolean keepSource)
            throws IOException, InterruptedException {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }

        Path project = requireDirectory(wodelProjectPath, "Wodel project");

        // XMI is the canonical durable representation of the generated program.
        persistWodelProgramModel(mutatorEnvironment, wodelProjectPath);

        long start = System.nanoTime();

        // Generate Java directly from the semantic model. No .mutator serializer
        // and no Xtext parser are involved in this path.
        Injector injector = new WodelStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        WodelSemanticCodeGenerator codeGenerator =
                injector.getInstance(WodelSemanticCodeGenerator.class);
        codeGenerator.generateStandalone(mutatorEnvironment, project.toString());

        // Text source is now a real optional export only.
        if (keepSource) {
            exportWodelSource(mutatorEnvironment, wodelProjectPath);
        }

        return compileGeneratedProjectChecked(
                project, eclipseHomePath, compilerName, start);
    }

	/**
	 * @param domainMetamodelPath
	 * @param inputPath
	 * @param wodelProjectPath
	 * @param flags
	 * @throws MetaModelNotFoundException
	 * @throws IOException
	 */
	public static void generateMutationOperators(String domainMetamodelPath, String inputPath, String wodelProjectPath, boolean... flags)  throws MetaModelNotFoundException, IOException {
		String metamodel = null;
		List<EPackage> packages = null;
		boolean exhaustive = false;
//		String domainMetamodelPath = "";
//		String inputPath = "";
//		String wodelProjectPath = "";
		String wodelProjectName = "";
		String wodelProgramPath = "";
//		if (args.length < 3) {
//			System.out.println("args[0] = domainMetamodelPath, args[1] = inputPath, args[2] = wodelProjectPath (, args[3] = exhaustive == true, optimized == false)?");
//			return;
//		}
//		if (args.length >= 3) {
//			domainMetamodelPath = args[0];
//			inputPath = args[1];
//			wodelProjectPath = args[2];
			wodelProjectName = wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/") + 1, wodelProjectPath.length());
			wodelProgramPath = wodelProjectPath + "/src" + wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/"), wodelProjectPath.length()) + ".mutator"; 
			exhaustive = flags.length >= 1 ? flags[0] : true;
//		}
		if (exhaustive == true) {
			MutatorenvironmentPackage.eINSTANCE.getClass();
			metamodel = domainMetamodelPath;
			packages = ModelManager.loadMetaModel(metamodel);
			List<Resource> wodelModels = new ArrayList<Resource>();
			File inputPathFile = new File(inputPath);
			if (inputPathFile.exists() == false) {
				System.out.println("This input folder " + inputPath + " does not exist.");
				return;
			}
			if (inputPathFile.isFile() == true && (inputPath.indexOf("/") != -1 || inputPath.indexOf("\\") != -1)) {
				if (inputPath.indexOf("/") != -1) {
					inputPath = inputPath.substring(0, inputPath.lastIndexOf("/"));
				}
				else if (inputPath.indexOf("\\") != -1) {
					inputPath = inputPath.substring(0, inputPath.lastIndexOf("\\"));
				}
			}
			inputPathFile = new File(inputPath);
			if (inputPathFile.exists() == false || inputPathFile.isFile() == true) {
				System.out.println("This input folder " + inputPath + " does not exist.");
				return;
			}
			wodelModels.addAll(ModelManager.getModelsNoException(metamodel, inputPath));
			
			MutatorEnvironment mutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment();
			Program program = MutatorenvironmentFactory.eINSTANCE.createProgram();
			program.setExhaustive(true);
			program.setMetamodel(domainMetamodelPath);
			program.setNum(0);
			program.setOutput("data/out/");
			Source source = MutatorenvironmentFactory.eINSTANCE.createSource();
			source.setPath("data/model/");
			program.setSource(source);
			mutatorEnvironment.setDefinition(program);
			List<Block> blocks = new ArrayList<Block>();
			
			List<String> wodelOperators = new ArrayList<String>();
			wodelOperators.add("create");
			wodelOperators.add("clone");
			wodelOperators.add("modify");
			wodelOperators.add("remove");
			//wodelOperators.add("select");
			wodelOperators.add("retype");
			
			String strategyClass = "random";
			
			List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

			List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
			
			List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
			
			List<EClass> classes = ModelManager.getEClasses(packages);
			
			List<String> wodelElementsNames = new ArrayList<String>();
			
			for (EClass cl : classes) {
				wodelElementsNames.add(cl.getName());
			}
			
			for (EClass cl : classes) {
				List<String> wodelClassElements = new ArrayList<String>();
				List<EObject> allEObjects = new ArrayList<EObject>();
				for (Resource wodelModel : wodelModels) {
					List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
					for (EObject clEObject : classEObjects) {
						boolean found = false;
						for (EObject eObject : allEObjects) {
							if (EMFComparison.equals(clEObject, eObject)) {
								found = true;
								break;
							}
						}
						if (found == false) {
							allEObjects.add(clEObject);
						}
					}
				}
				List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
				List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
				for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
					wodelClassElements.add(sf.getName());
					wodelClassFeatures.add(sf);
					List<Object> wodelObjectValues = new ArrayList<Object>();
					for (EObject eObject : allEObjects) {
						EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
						if (currentsf != null) {
							Object value = eObject.eGet(currentsf, true);
							if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
								boolean found = false;
								for (Object clObjectValue : wodelObjectValues) {
									if (value.equals(clObjectValue)) {
										found = true;
										break;
									}
								}
								if (found == false) {
									wodelObjectValues.add(value);
								}
							}
						}
					}
					Collections.sort(wodelObjectValues, new Comparator<Object>() {

						@Override
						public int compare(Object o1, Object o2) {
							return o1.toString().compareTo(o2.toString());
						}
						
					});
					wodelClassObjectValues.add(wodelObjectValues);
				}
				wodelClassObjectsValues.add(wodelClassObjectValues);
				wodelClassElementsNames.add(wodelClassElements);
				wodelClassElementsValues.add(wodelClassFeatures);
			}
			
			List<EClass> eClasses = ModelManager.getEClasses(packages);
			EClass rootClass = ModelManager.getRootEClass(packages);
			int i = 0;
			int j = 0;
			for (EClass eClass : eClasses) {
				if (EcoreUtil.equals(eClass, rootClass)) {
					j++;
					continue;
				}
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
				System.out.println("Generation of mutation operators for the class: " + eClass.getName());
				List<String> classWhereElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWhereValues = wodelClassObjectsValues.get(j);
				List<String> classWithElements = wodelClassElementsNames.get(j);
				List<List<Object>> featureWithValues = wodelClassObjectsValues.get(j);
				for (String wodelOperator : wodelOperators) {
					List<Mutator> mutator = new ArrayList<Mutator>();
					List<Mutator> commands = new ArrayList<Mutator>();
					Block block = null;
					String blockName = "";
					blockName = "b" + i;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					if (wodelOperator.equals("select")) {
						System.out.println(eClass.getName() + " ----- Selection mutation operator");
						SelectObjectMutator selectObjectMutator = MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						selectObjectMutator.setName("p");
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						selectObjectMutator.setObject(obSelectionStrategy);
						mutator.add(selectObjectMutator);
					}
					if (wodelOperator.equals("create")) {
						System.out.println(eClass.getName() + " ----- Creation mutation operator");
						CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
						createObjectMutator.setType(eClass);
						int k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										createObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								EAttribute attribute = (EAttribute) feature;
								AttributeType attributeType = null;
								AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
								attributeScalar.getAttribute().add(attribute);
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
								}
								if (attributeType != null) {
									attributeScalar.setValue(attributeType);
								}
								if (attributeScalar != null && attributeScalar.getValue() != null) {
									createObjectMutator.getAttributes().add(attributeScalar);
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										createObjectMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						k = 0;
						mutator.add(createObjectMutator);
					}
					if (wodelOperator.equals("remove")) {
						System.out.println(eClass.getName() + " ----- Deletion mutation operator");
						RemoveObjectMutator removeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						removeObjectMutator.setObject(obSelectionStrategy);
						mutator.add(removeObjectMutator);
					}
					if (wodelOperator.equals("modify")) {
						System.out.println(eClass.getName() + " ----- Modification mutation operator");
						ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						modifyInformationMutator.setName("p");
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType == null) {
										if (feature instanceof EAttribute) {
											Operator operator = Operator.EQUALS;
											if (attribute.getEType().getName().equals("EString")) {
												RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
												stringType.setOperator(operator);
												stringType.setMin(0);
												stringType.setMax(10);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(0);
												integerType.setMax(10);
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
												doubleType.setOperator(operator);
												doubleType.setMin(0);
												doubleType.setMax(10);
												attributeType = doubleType;
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										modifyInformationMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								EAttribute attribute = (EAttribute) feature;
								AttributeType attributeType = null;
								AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
								attributeScalar.getAttribute().add(attribute);
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
								}
								if (attributeType != null) {
									attributeScalar.setValue(attributeType);
								}
								if (attributeScalar != null && attributeScalar.getValue() != null) {
									modifyInformationMutator.getAttributes().add(attributeScalar);
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										modifyInformationMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						modifyInformationMutator.setObject(obSelectionStrategy);
						mutator.add(modifyInformationMutator);
					}
					if (wodelOperator.equals("clone")) {
						System.out.println(eClass.getName() + " ----- Clonation mutation operator");
						CloneObjectMutator cloneObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
						cloneObjectMutator.setContents(true);
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
						int k = 0;
						int mAtt = 0;
						List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
								EAttribute attribute = (EAttribute) feature;
								AttributeEvaluationType attributeType = null;
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
									if (attributeType != null) {
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
								}
								if (attributeType != null) {
									listAttributeEvaluation.add(attributeEvaluation);
								}
							}
						}
						mAtt = 0;
						if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
							for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
								if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
									if (mAtt == 0) {
										expression.setFirst(attributeEvaluation);
									}
									if (mAtt > 0) {
										expression.getSecond().add(attributeEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mAtt++;
								}
							}
						}
						k = 0;
						int mRef = 0;
						List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
									EReference reference = (EReference) feature;
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									Operator operator = Operator.EQUALS;
									referenceStrategy.setType((EClass) reference.getEType());
									referenceEvaluation.setName(reference);
									referenceEvaluation.setOperator(operator);
									referenceEvaluation.setValue(referenceStrategy);
									if (referenceEvaluation != null) {
										listReferenceEvaluation.add(referenceEvaluation);
									}
								}
							}
						}
						mRef = 0;
						if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
							for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
								if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
									if (mAtt == 0 && mRef == 0) {
										expression.setFirst(referenceEvaluation);
									}
									if (mAtt > 0 || mRef > 0) {
										expression.getSecond().add(referenceEvaluation);
										BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
										operator.setType(LogicOperator.OR);
										expression.getOperator().add(operator);
									}
									mRef++;
								}
							}
						}
						cloneObjectMutator.setName("p");
						if (mAtt > 0 || mRef > 0) {
							obSelectionStrategy.setExpression(expression);
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									for (Object ob : lob) {
										if (attribute.getEType().getName().equals("EString")) {
											ListStringType stringType = null;
											if (attributeType == null) {
												Operator operator = Operator.IN;
												stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
												stringType.setOperator(operator);
												attributeType = stringType;
											}
											else {
												stringType = (ListStringType) attributeType;
											}
											stringType.getValue().add(((String) ob).replace("\\n", ""));
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												attributeType = integerType;
											}
											else {
												integerType = (SpecificIntegerType) attributeType;
											}
											integerType.setValue((int) ob);
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											else {
												booleanType = (SpecificBooleanType) attributeType;
											}
											booleanType.setValue((boolean) ob);
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = null;
											if (attributeType == null) {
												Operator operator = Operator.EQUALS;
												doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												attributeType = doubleType;
											}
											doubleType.setValue((double) ob);
										}
									}
									if (attributeType == null) {
										if (feature instanceof EAttribute) {
											Operator operator = Operator.EQUALS;
											if (attribute.getEType().getName().equals("EString")) {
												RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
												stringType.setOperator(operator);
												stringType.setMin(0);
												stringType.setMax(10);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(0);
												integerType.setMax(10);
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
												booleanType.setOperator(operator);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
												doubleType.setOperator(operator);
												doubleType.setMin(0);
												doubleType.setMax(10);
												attributeType = doubleType;
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										cloneObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
						}
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (feature instanceof EAttribute) {
								EAttribute attribute = (EAttribute) feature;
								AttributeType attributeType = null;
								AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
								attributeScalar.getAttribute().add(attribute);
								if (attribute.getEType() instanceof EEnum) {
									ListStringType eEnumType = null;
									if (attributeType == null) {
										Operator operator = Operator.IN;
										eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
										eEnumType.setOperator(operator);
										attributeType = eEnumType;
									}
									List<String> values = eEnumType.getValue();
									EEnum eEnum = (EEnum) attribute.getEType();
									List<EEnumLiteral> literals = eEnum.getELiterals();
									for (EEnumLiteral literal : literals) {
										if (!values.contains(literal.getLiteral())) {
											values.add(literal.getLiteral());
										}
									}
								}
								if (attributeType != null) {
									attributeScalar.setValue(attributeType);
								}
								if (attributeScalar != null && attributeScalar.getValue() != null) {
									cloneObjectMutator.getAttributes().add(attributeScalar);
								}
							}
						}
						k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								k++;
								if (feature instanceof EReference) {
									ReferenceInit referenceInit = null;
									EReference reference = (EReference) feature;
									referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
									ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
									referenceStrategy.setType((EClass) reference.getEType());
									referenceInit.setObject(referenceStrategy);
									referenceInit.getReference().add(reference);
									if (referenceInit != null) {
										cloneObjectMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						cloneObjectMutator.setObject(obSelectionStrategy);
						mutator.add(cloneObjectMutator);
					}
					if (wodelOperator.equals("retype")) {
						System.out.println(eClass.getName() + " ----- Retyping mutation operator");
						RetypeObjectMutator retypeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRetypeObjectMutator();
						ObSelectionStrategy obSelectionStrategy = null;
						if (strategyClass.equals("random")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
						}
						if (strategyClass.equals("complete")) {
							obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
						}
						obSelectionStrategy.setType(eClass);
						retypeObjectMutator.setObject(obSelectionStrategy);
						List<EClass> siblingEClasses = ModelManager.getSiblingEClasses(metamodel, MutatorUtils.getStrategyTypes(retypeObjectMutator.getObject()));
						List<EClass> classesToAdd = new ArrayList<EClass>();
						for (EClass sibCl : siblingEClasses) {
							EClassifier classifier = eClass.getEPackage().getEClassifier(sibCl.getName());
							if (classifier instanceof EClass) {
								EClass classToAdd = (EClass) classifier;
								if (classToAdd.isAbstract() == false) {
									classesToAdd.add(classToAdd);
								}
							}
						}
						if (classesToAdd.size() > 0) {
							Map<EClass, List<EStructuralFeature>> classesToAddFeatures = new HashMap<EClass, List<EStructuralFeature>>();
							for (EClass classToAdd : classesToAdd) {
								List<EStructuralFeature> classToAddFeatures = new ArrayList<EStructuralFeature>();
								classToAddFeatures.addAll(classToAdd.getEAllStructuralFeatures());
								classesToAddFeatures.put(classToAdd, classToAddFeatures);
							}
							List<EStructuralFeature> featuresToAdd = new ArrayList<EStructuralFeature>();
							featuresToAdd.addAll(eClass.getEAllStructuralFeatures());
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								boolean shared = true;
								for (EClass classToAdd : classesToAddFeatures.keySet()) {
									if (!classesToAddFeatures.get(classToAdd).contains(feature)) {
										shared = false;
										break;
									}
								}
								if (shared == false) {
									featuresToAdd.remove(feature);
								}
							}
							retypeObjectMutator.getTypes().addAll(classesToAdd);
							Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
							int k = 0;
							int mAtt = 0;
							List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWhereElements.contains(feature.getName())) {
									List<Object> lob = featureWhereValues.get(k);
									k++;
									if (feature instanceof EAttribute) {
										AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										EAttribute attribute = (EAttribute) feature;
										AttributeEvaluationType attributeType = null;
										for (Object ob : lob) {
											if (attribute.getEType().getName().equals("EString")) {
												ListStringType stringType = null;
												if (attributeType == null) {
													Operator operator = Operator.IN;
													stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
													stringType.setOperator(operator);
													attributeType = stringType;
												}
												else {
													stringType = (ListStringType) attributeType;
												}
												stringType.getValue().add(((String) ob).replace("\\n", ""));
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
													integerType.setOperator(operator);
													attributeType = integerType;
												}
												else {
													integerType = (SpecificIntegerType) attributeType;
												}
												integerType.setValue((int) ob);
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												else {
													booleanType = (SpecificBooleanType) attributeType;
												}
												booleanType.setValue((boolean) ob);
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
													doubleType.setOperator(operator);
													attributeType = doubleType;
												}
												doubleType.setValue((double) ob);
											}
											if (attributeType != null) {
												attributeEvaluation.setName(attribute);
												attributeEvaluation.setValue(attributeType);
											}
										}
										if (attributeType != null) {
											listAttributeEvaluation.add(attributeEvaluation);
										}
									}
								}
							}
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								if (feature instanceof EAttribute) {
									AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
									EAttribute attribute = (EAttribute) feature;
									AttributeEvaluationType attributeType = null;
									if (attribute.getEType() instanceof EEnum) {
										ListStringType eEnumType = null;
										if (attributeType == null) {
											Operator operator = Operator.IN;
											eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
											eEnumType.setOperator(operator);
											attributeType = eEnumType;
										}
										List<String> values = eEnumType.getValue();
										EEnum eEnum = (EEnum) attribute.getEType();
										List<EEnumLiteral> literals = eEnum.getELiterals();
										for (EEnumLiteral literal : literals) {
											if (!values.contains(literal.getLiteral())) {
												values.add(literal.getLiteral());
											}
										}
										if (attributeType != null) {
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
									}
									if (attributeType != null) {
										listAttributeEvaluation.add(attributeEvaluation);
									}
								}
							}
							mAtt = 0;
							if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
								for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
									if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
										if (mAtt == 0) {
											expression.setFirst(attributeEvaluation);
										}
										if (mAtt > 0) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
										mAtt++;
									}
								}
							}
							k = 0;
							int mRef = 0;
							List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWhereElements.contains(feature.getName())) {
									k++;
									if (feature instanceof EReference) {
										ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										EReference reference = (EReference) feature;
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
										if (referenceEvaluation != null) {
											listReferenceEvaluation.add(referenceEvaluation);
										}
									}
								}
							}
							mRef = 0;
							if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
								for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
									if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
										if (mAtt == 0 && mRef == 0) {
											expression.setFirst(referenceEvaluation);
										}
										if (mAtt > 0 || mRef > 0) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
										mRef++;
									}
								}
							}
							retypeObjectMutator.setName("p");
							if (mAtt > 0 || mRef > 0) {
								obSelectionStrategy.setExpression(expression);
							}
							k = 0;
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWithElements.contains(feature.getName())) {
									List<Object> lob = featureWithValues.get(k);
									k++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										AttributeType attributeType = null;
										AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										for (Object ob : lob) {
											if (attribute.getEType().getName().equals("EString")) {
												ListStringType stringType = null;
												if (attributeType == null) {
													Operator operator = Operator.IN;
													stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
													stringType.setOperator(operator);
													attributeType = stringType;
												}
												else {
													stringType = (ListStringType) attributeType;
												}
												stringType.getValue().add(((String) ob).replace("\\n", ""));
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
													integerType.setOperator(operator);
													attributeType = integerType;
												}
												else {
													integerType = (SpecificIntegerType) attributeType;
												}
												integerType.setValue((int) ob);
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												else {
													booleanType = (SpecificBooleanType) attributeType;
												}
												booleanType.setValue((boolean) ob);
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = null;
												if (attributeType == null) {
													Operator operator = Operator.EQUALS;
													doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
													doubleType.setOperator(operator);
													attributeType = doubleType;
												}
												doubleType.setValue((double) ob);
											}
										}
										if (attributeType == null) {
											if (feature instanceof EAttribute) {
												Operator operator = Operator.EQUALS;
												if (attribute.getEType().getName().equals("EString")) {
													RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
													stringType.setOperator(operator);
													stringType.setMin(0);
													stringType.setMax(10);
													attributeType = stringType;
												}
												if (attribute.getEType().getName().equals("EInt")) {
													RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
													integerType.setOperator(operator);
													integerType.setMin(0);
													integerType.setMax(10);
													attributeType = integerType;
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
													booleanType.setOperator(operator);
													attributeType = booleanType;
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
													doubleType.setOperator(operator);
													doubleType.setMin(0);
													doubleType.setMax(10);
													attributeType = doubleType;
												}
											}
										}
										if (attributeType != null) {
											attributeScalar.setValue(attributeType);
										}
										if (attributeScalar != null && attributeScalar.getValue() != null) {
											retypeObjectMutator.getAttributes().add(attributeScalar);
										}
									}
								}
							}
							for (EStructuralFeature feature : featuresToAdd) {
								if (feature instanceof EAttribute) {
									EAttribute attribute = (EAttribute) feature;
									AttributeType attributeType = null;
									AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
									attributeScalar.getAttribute().add(attribute);
									if (attribute.getEType() instanceof EEnum) {
										ListStringType eEnumType = null;
										if (attributeType == null) {
											Operator operator = Operator.IN;
											eEnumType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
											eEnumType.setOperator(operator);
											attributeType = eEnumType;
										}
										List<String> values = eEnumType.getValue();
										EEnum eEnum = (EEnum) attribute.getEType();
										List<EEnumLiteral> literals = eEnum.getELiterals();
										for (EEnumLiteral literal : literals) {
											if (!values.contains(literal.getLiteral())) {
												values.add(literal.getLiteral());
											}
										}
									}
									if (attributeType != null) {
										attributeScalar.setValue(attributeType);
									}
									if (attributeScalar != null && attributeScalar.getValue() != null) {
										retypeObjectMutator.getAttributes().add(attributeScalar);
									}
								}
							}
							k = 0;
							for (EStructuralFeature feature : featuresToAdd) {
								if (classWithElements.contains(feature.getName())) {
									k++;
									if (feature instanceof EReference) {
										ReferenceInit referenceInit = null;
										EReference reference = (EReference) feature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										referenceStrategy.setType((EClass) reference.getEType());
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
										if (referenceInit != null) {
											retypeObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
							}
							retypeObjectMutator.setObject(obSelectionStrategy);
							mutator.add(retypeObjectMutator);
						}
					}
					if (block != null) {
						if (mutator.size() > 0) {
							for (Mutator mut : mutator) {
								if (mut != null) {
									commands.add(mut);
								}
							}
						}
						if (commands.size() > 0) {
							for (Mutator com : commands) {
								if (com != null) {
									block.getCommands().add(com);
								}
							}
							if (block.getCommands().size() > 0) {
								blocks.add(block);
								i++;
							}
						}
					}
				}
				j++;
			}

			mutatorEnvironment.getBlocks().addAll(blocks);
			mutatorEnvironment.getCommands().clear();
			
			String mutatorCode = "generate exhaustive mutants \r\n" +
									"in \"data/out/\" \r\n" +
									"from \"data/model/\" \r\n" +
									"metamodel \"" + domainMetamodelPath + "\" \r\n" +
									"\r\n" +
									"with commands {\r\n" +
									"\t\t c = create " + rootClass.getName() + "\r\n" +
									"}\r\n";

			FileWriter fileWriter = new FileWriter(wodelProgramPath);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(mutatorCode);
			writer.close();
			fileWriter.close();
			
			mutatorCode = WodelUtils.deserialize("file:/" + wodelProgramPath, mutatorEnvironment);

			fileWriter = new FileWriter(wodelProgramPath);
			writer = new BufferedWriter(fileWriter);
			writer.write(mutatorCode);
			writer.close();
			fileWriter.close();
			
			//WodelUtils.serialize("file:/" + wodelProgramPath, "file:/" + wodelProjectPath + "/data/out/" + wodelProjectName + ".model");
			
			WodelUtils.serialize(mutatorEnvironment, "file:/" + wodelProjectPath + "/data/out/" + wodelProjectName + ".model");
			
			System.out.println("Mutation operators created successfully!!");
		}
	}
	
	/**
	 * @param wodelProjectPath
	 * @param eclipseHomePath
	 * @param compilerName
	 */
	public static void compileWodelProject(
            String wodelProjectPath,
            String eclipseHomePath,
            String compilerName) {
        try {
            ExecutionResult result = compileWodelProjectChecked(
                    wodelProjectPath, eclipseHomePath, compilerName);
            if (!result.isSuccess()) {
                System.err.println(result.getMessage());
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Wodel project compilation was interrupted", e);
        }
        catch (IOException e) {
            throw new IllegalStateException("Could not compile Wodel project", e);
        }
    }

	/**
	 * @param inputPath
	 * @param outputPath
	 * @param currentPluginPath
	 * @param wodelProjectPath
	 * @param eclipseHomePath
	 */
	public static void generateMutants(
            String inputPath,
            String outputPath,
            String currentPluginPath,
            String wodelProjectPath,
            String eclipseHomePath) {
        try {
            ExecutionResult result = generateMutantsChecked(
                    inputPath,
                    outputPath,
                    currentPluginPath,
                    wodelProjectPath,
                    eclipseHomePath);
            if (!result.isSuccess()) {
                System.err.println(result.getMessage());
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Mutant generation was interrupted", e);
        }
        catch (IOException e) {
            throw new IllegalStateException("Could not generate mutants", e);
        }
    }
	

    /** Result of a headless compile or mutant-execution phase. */
    public static final class ExecutionResult {
        private final boolean success;
        private final int exitCode;
        private final String phase;
        private final String message;
        private final long durationMillis;

        private ExecutionResult(boolean success, int exitCode, String phase,
                String message, long durationMillis) {
            this.success = success;
            this.exitCode = exitCode;
            this.phase = phase;
            this.message = message;
            this.durationMillis = durationMillis;
        }

        public boolean isSuccess() { return success; }
        public int getExitCode() { return exitCode; }
        public String getPhase() { return phase; }
        public String getMessage() { return message; }
        public long getDurationMillis() { return durationMillis; }

        @Override
        public String toString() {
            return phase + ": " + message + " (exit=" + exitCode
                    + ", " + durationMillis + " ms)";
        }
    }

    public static ExecutionResult compileWodelProjectChecked(
            String wodelProjectPath,
            String eclipseHomePath,
            String compilerName)
            throws IOException, InterruptedException {

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        String projectName = project.getFileName().toString();
        Path modelFile = project.resolve("data").resolve("out")
                .resolve(projectName + ".model");
        Path mutatorFile = project.resolve("src").resolve(projectName + ".mutator");

        long start = System.nanoTime();

        if (Files.isRegularFile(modelFile)) {
            // Preferred headless path: load the semantic XMI and generate Java
            // directly from it.
            Injector injector = new WodelStandaloneSetup()
                    .createInjectorAndDoEMFRegistration();
            WodelSemanticCodeGenerator codeGenerator =
                    injector.getInstance(WodelSemanticCodeGenerator.class);
            codeGenerator.generateStandaloneFromModel(
                    modelFile.toString(), project.toString());
        }
        else if (Files.isRegularFile(mutatorFile)) {
            // Backward compatibility for existing hand-written Wodel projects.
            WodelRunner.main(new String[] { mutatorFile.toString(), project.toString() });
        }
        else {
            throw new IOException(
                    "Cannot find generated Wodel model or source. Expected either "
                    + modelFile + " or " + mutatorFile);
        }

        return compileGeneratedProjectChecked(
                project, eclipseHomePath, compilerName, start);
    }

    private static ExecutionResult compileGeneratedProjectChecked(
            Path project,
            String eclipseHomePath,
            String compilerName,
            long start)
            throws IOException, InterruptedException {

        Path workspace = project.getParent();
        if (workspace == null) {
            throw new IOException("Cannot determine workspace for " + project);
        }

        String eclipseExecutable = resolveExecutable(
                eclipseHomePath, compilerName);
        List<String> command = Arrays.asList(
                eclipseExecutable,
                "-nosplash",
                "-application", "org.eclipse.jdt.apt.core.aptBuild",
                "-data", workspace.toString(),
                "-build", "all");

        int exit = runProcess(command, workspace);
        long elapsed = elapsedMillis(start);
        if (exit != 0) {
            return new ExecutionResult(false, exit, "compile",
                    "Compilation failed for " + project, elapsed);
        }
        return new ExecutionResult(true, 0, "compile",
                "Semantic code generation and compilation completed for "
                + project, elapsed);
    }
    
    private static void addClasspathEntry(
            LinkedHashSet<String> entries,
            Path entry) {

        if (entry == null) {
            return;
        }

        Path normalized =
            entry.toAbsolutePath()
                 .normalize();

        if (Files.exists(normalized)) {
            entries.add(
                normalized.toString());
        }
    }
    
    private static void addJarDirectory(
            LinkedHashSet<String> entries,
            Path directory) {

        if (directory == null ||
            !Files.isDirectory(directory)) {
            return;
        }

        try (Stream<Path> stream =
                Files.list(directory)) {

            stream
                .filter(Files::isRegularFile)
                .filter(path ->
                    path.getFileName()
                        .toString()
                        .toLowerCase()
                        .endsWith(".jar"))
                .sorted()
                .forEach(path ->
                    addClasspathEntry(
                        entries,
                        path));
        }
        catch (IOException e) {
            System.err.println(
                "Cannot scan classpath directory " +
                directory + ": " +
                e.getMessage());
        }
    }
    
    private static void addCurrentPluginEntriesFirst(
            LinkedHashSet<String> entries,
            String currentPluginPath) {

        if (currentPluginPath == null ||
            currentPluginPath.isBlank()) {
            return;
        }

        Path current =
            Paths.get(currentPluginPath)
                 .toAbsolutePath()
                 .normalize();

        /*
         * currentPluginPath may itself be a JAR.
         */
        if (Files.isRegularFile(current)) {
            addClasspathEntry(entries, current);
            return;
        }

        /*
         * Or it may be a directory containing the current
         * distribution/plugin JARs.
         */
        if (Files.isDirectory(current)) {
            addJarDirectory(entries, current);
        }
    }

    /*
    private static String buildHeadlessRuntimeClasspath(
            Path project,
            String currentPluginPath,
            String eclipseHomePath) {

        LinkedHashSet<String> entries =
            new LinkedHashSet<>();

        //1. Freshly compiled generated classes MUST be first.
        Path bin =
            project.resolve("bin")
                   .toAbsolutePath()
                   .normalize();

        addClasspathEntry(entries, bin);

        //2. Current Wodel/CLI/plugin artifact MUST come before
        //    inherited Eclipse/update-site copies.
        addCurrentPluginEntriesFirst(
            entries,
            currentPluginPath);

        //3. Also add the JAR/directory from which the currently
        //    running MutatorUtils was loaded.
        //
        //    This is particularly important for the
        //    MutationResults ABI mismatch.
        try {
            java.net.URL location =
                wodel.utils.manager.MutatorUtils.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation();

            if (location != null &&
                "file".equalsIgnoreCase(
                    location.getProtocol())) {

                Path mutatorUtilsLocation =
                    Paths.get(location.toURI())
                         .toAbsolutePath()
                         .normalize();

                addClasspathEntry(
                    entries,
                    mutatorUtilsLocation);
            }
        }
        catch (Exception e) {
            System.err.println(
                "Cannot determine MutatorUtils CodeSource: " +
                e.getMessage());
        }

        //
        // 4. Add inherited classpath entries individually,
        //    rather than as one complete classpath string.
        //
        String inherited =
            System.getProperty("java.class.path");

        if (inherited != null &&
            !inherited.isBlank()) {

            String[] inheritedEntries =
                inherited.split(
                    Pattern.quote(
                        File.pathSeparator));

            Path parentWorkingDirectory =
                Paths.get(
                    System.getProperty("user.dir"))
                     .toAbsolutePath()
                     .normalize();

            for (String value : inheritedEntries) {

                if (value == null ||
                    value.isBlank()) {
                    continue;
                }

                try {
                    Path entry =
                        Paths.get(value);

                    //
                    // Relative java.class.path entries must be
                    // resolved relative to the PARENT JVM cwd.
                    //
                    if (!entry.isAbsolute()) {
                        entry =
                            parentWorkingDirectory.resolve(entry);
                    }

                    entry =
                        entry.toAbsolutePath()
                             .normalize();

                    addClasspathEntry(
                        entries,
                        entry);
                }
                catch (Exception e) {
                    //
                    // Preserve unusual entries if they cannot be
                    // interpreted as normal paths.
                    //
                    entries.add(value);
                }
            }
        }

        //
        // 5. Libraries belonging to the current plugin/distribution.
        //
        if (currentPluginPath != null &&
            !currentPluginPath.isBlank()) {

            Path current =
                Paths.get(currentPluginPath)
                     .toAbsolutePath()
                     .normalize();

            Path pluginDirectory =
                Files.isDirectory(current)
                    ? current
                    : current.getParent();

            if (pluginDirectory != null) {

                addJarDirectory(
                    entries,
                    pluginDirectory.resolve("lib"));
            }
        }

        //
        // 6. Eclipse plugins come AFTER the current Wodel artifacts.
        //
        if (eclipseHomePath != null &&
            !eclipseHomePath.isBlank()) {

            Path eclipseHome =
                Paths.get(eclipseHomePath)
                     .toAbsolutePath()
                     .normalize();

            addJarDirectory(
                entries,
                eclipseHome.resolve("plugins"));

            //
            // Update-site copies deliberately come LAST because
            // they are the most likely source of stale Wodel JARs.
            //
            addJarDirectory(
                entries,
                eclipseHome
                    .resolve("workspace")
                    .resolve("wodel.updatesite")
                    .resolve("plugins"));
        }

        //
        // Diagnostic: show the exact effective order.
        //
        System.err.println(
            "===== CHILD JVM CLASSPATH =====");

        int i = 0;

        for (String entry : entries) {
            System.err.println(
                "[" + (i++) + "] " + entry);
        }

        System.err.println(
            "===============================");

        return String.join(
            File.pathSeparator,
            entries);
    }
*/
    
    private static boolean isInsideEclipsePlugins(
            Path path,
            String eclipseHomePath) {

        if (path == null ||
            eclipseHomePath == null ||
            eclipseHomePath.isBlank()) {
            return false;
        }

        try {
            Path eclipse =
                Paths.get(eclipseHomePath)
                     .toAbsolutePath()
                     .normalize();

            Path plugins =
                eclipse.resolve("plugins");

            Path updatePlugins =
                eclipse
                    .resolve("workspace")
                    .resolve("wodel.updatesite")
                    .resolve("plugins");

            return path.startsWith(plugins) ||
                   path.startsWith(updatePlugins);
        }
        catch (Exception e) {
            return false;
        }
    }
	private static String buildHeadlessRuntimeClasspath(Path project, String currentPluginPath,
			String eclipseHomePath) {

		LinkedHashSet<String> entries = new LinkedHashSet<>();

		/*
		 * 1. Freshly compiled project classes.
		 */
		Path bin = project.resolve("bin").toAbsolutePath().normalize();

		entries.add(bin.toString());

		/*
		 * 2. Current CLI/plugin JAR.
		 */
		if (currentPluginPath != null && !currentPluginPath.isBlank()) {

			Path current = Paths.get(currentPluginPath).toAbsolutePath().normalize();

			if (Files.isRegularFile(current)) {

				entries.add(current.toString());

				/*
				 * Optional lib folder next to the current JAR.
				 */
				Path parent = current.getParent();

				if (parent != null) {

					Path lib = parent.resolve("lib");

					if (Files.isDirectory(lib)) {
						entries.add(lib.toString() + File.separator + "*");
					}
				}
			} else if (Files.isDirectory(current)) {

				entries.add(current.toString() + File.separator + "*");

				Path lib = current.resolve("lib");

				if (Files.isDirectory(lib)) {
					entries.add(lib.toString() + File.separator + "*");
				}
			}
		}

    /*
     * 3. Parent JVM classpath.
     *
     * Do not repeat Eclipse/plugin directories here.
     */
    String inherited =
        System.getProperty("java.class.path");

    if (inherited != null &&
        !inherited.isBlank()) {

        Path parentWorkingDirectory =
            Paths.get(
                System.getProperty("user.dir"))
                 .toAbsolutePath()
                 .normalize();

        String[] inheritedEntries =
            inherited.split(
                Pattern.quote(File.pathSeparator));

        for (String value : inheritedEntries) {

            if (value == null ||
                value.isBlank()) {
                continue;
            }

            try {
                Path p =
                    Paths.get(value);

                if (!p.isAbsolute()) {
                    p =
                        parentWorkingDirectory
                            .resolve(p);
                }

                p =
                    p.toAbsolutePath()
                     .normalize();

                /*
                 * Avoid duplicates that will already be
                 * supplied by Eclipse wildcards below.
                 */
                if (isInsideEclipsePlugins(
                        p,
                        eclipseHomePath)) {
                    continue;
                }

                entries.add(p.toString());
            }
            catch (Exception e) {
                entries.add(value);
            }
        }
    }

    /*
     * 4. Eclipse dependencies.
     *
     * IMPORTANT:
     * Add ONE wildcard instead of several thousand JAR names.
     */
    if (eclipseHomePath != null &&
        !eclipseHomePath.isBlank()) {

        Path eclipseHome =
            Paths.get(eclipseHomePath)
                 .toAbsolutePath()
                 .normalize();

        Path plugins =
            eclipseHome.resolve("plugins");

        if (Files.isDirectory(plugins)) {
            entries.add(
                plugins.toString() +
                File.separator +
                "*");
        }

        /*
         * Wodel update-site plugins last.
         */
        Path updatePlugins =
            eclipseHome
                .resolve("workspace")
                .resolve("wodel.updatesite")
                .resolve("plugins");

        if (Files.isDirectory(updatePlugins)) {
            entries.add(
                updatePlugins.toString() +
                File.separator +
                "*");
        }
    }

    System.err.println(
        "===== CHILD JVM CLASSPATH =====");

    int i = 0;

    for (String entry : entries) {
        System.err.println(
            "[" + (i++) + "] " + entry);
    }

    System.err.println(
        "===============================");

    return String.join(
        File.pathSeparator,
        entries);
}
    
    private static String prependClasspathEntry(
            Path entry,
            String classpath) {

        String first =
            entry.toAbsolutePath()
                 .normalize()
                 .toString();

        LinkedHashSet<String> entries =
            new LinkedHashSet<>();

        entries.add(first);

        if (classpath != null &&
            !classpath.isBlank()) {

            String[] values =
                classpath.split(
                    Pattern.quote(
                        File.pathSeparator));

            for (String value : values) {
                if (value != null &&
                    !value.isBlank()) {

                    entries.add(value);
                }
            }
        }

        return String.join(
            File.pathSeparator,
            entries);
    }
    
    public static ExecutionResult generateMutantsChecked(
            String inputPath,
            String outputPath,
            String currentPluginPath,
            String wodelProjectPath,
            String eclipseHomePath)
            throws IOException, InterruptedException {

        Path input =
            requireDirectory(inputPath, "Input model directory");

        Path output =
            ensureDirectory(outputPath, "Output mutant directory");

        Path project =
            requireDirectory(wodelProjectPath, "Wodel project");

        String projectName =
            project.getFileName().toString();

        Path srcGen =
            project.resolve("src-gen")
                   .toAbsolutePath()
                   .normalize();

        Path bin =
            project.resolve("bin")
                   .toAbsolutePath()
                   .normalize();

        Files.createDirectories(bin);

        Path mutatorSources =
            srcGen.resolve("mutator");

        Path standalone =
            mutatorSources
                .resolve(projectName + "Standalone")
                .resolve(projectName + "Standalone.java");

        Path api =
            mutatorSources
                .resolve(projectName)
                .resolve(projectName + "StandaloneAPI.java");

        Path launcher =
            mutatorSources
                .resolve(projectName)
                .resolve(projectName + "StandaloneAPILauncher.java");

        for (Path source :
                Arrays.asList(standalone, api, launcher)) {

            if (!Files.isRegularFile(source)) {
                throw new IOException(
                    "Missing generated standalone source. " +
                    "Compile/generate the Wodel project first: " +
                    source);
            }
        }

        /*
         * IMPORTANT:
         * Remove previously generated standalone .class files.
         *
         * Do NOT delete the complete bin directory because it may
         * contain other generated/compiled classes required by
         * the standalone mutator.
         */
        deleteCompiledClassFamily(
            bin,
            "mutator." + projectName + "Standalone." +
            projectName + "Standalone");

        deleteCompiledClassFamily(
            bin,
            "mutator." + projectName + "." +
            projectName + "StandaloneAPI");

        deleteCompiledClassFamily(
            bin,
            "mutator." + projectName + "." +
            projectName + "StandaloneAPILauncher");

        /*
         * Compile fresh standalone classes.
         */
        String compileClasspath =
            buildHeadlessCompileClasspath(
                srcGen,
                project,
                currentPluginPath,
                eclipseHomePath);

        String javac =
            resolveJavaTool("javac");

        List<String> javacCommand =
            Arrays.asList(
                javac,
                "-encoding", "UTF-8",
                "-classpath", compileClasspath,
                "-d", bin.toString(),
                standalone.toString(),
                api.toString(),
                launcher.toString()
            );

        long start = System.nanoTime();

        int compileExit =
            runProcess(
                javacCommand,
                mutatorSources);

        if (compileExit != 0) {
            return new ExecutionResult(
                false,
                compileExit,
                "standalone-compile",
                "Compilation of generated standalone Wodel classes failed",
                elapsedMillis(start));
        }

        /*
         * Build runtime classpath AFTER compilation.
         */
        String runClasspath =
            buildHeadlessRuntimeClasspath(
                project,
                currentPluginPath,
                eclipseHomePath);

        /*
         * Make absolutely sure that the newly compiled project/bin
         * is the FIRST classpath entry.
         */
        runClasspath =
            prependClasspathEntry(
                bin,
                runClasspath);

        /*
         * Do not allow src-gen itself on the runtime classpath.
         * Runtime must use compiled classes from bin.
         */
        runClasspath =
            removeClasspathEntry(
                srcGen,
                runClasspath);

        /*
         * Start a completely new JVM.
         */
        String java =
            resolveJavaTool("java");

        String launcherClass =
            "mutator." + projectName + "." +
            projectName + "StandaloneAPILauncher";

        List<String> runCommand =
            new ArrayList<>();

        runCommand.add(java);

        /*
         * Optional unique marker. Useful for confirming that every
         * execution is a different JVM.
         */
        runCommand.add(
            "-Dwodel.execution.id=" +
            UUID.randomUUID());
        runCommand.add("-Xlog:class+load=info");

        runCommand.add("-cp");
        runCommand.add(runClasspath);

        runCommand.add(launcherClass);
        runCommand.add(input.toString());
        runCommand.add(output.toString());

        int runExit =
            runProcess(
                runCommand,
                project);

        long elapsed =
            elapsedMillis(start);

        if (runExit != 0) {
            return new ExecutionResult(
                false,
                runExit,
                "mutate",
                "Standalone mutant generation failed",
                elapsed);
        }

        return new ExecutionResult(
            true,
            0,
            "mutate",
            "Mutants generated in " + output,
            elapsed);
    }
    private static String removeClasspathEntry(
            Path entry,
            String classpath) {

        if (classpath == null ||
            classpath.isBlank()) {
            return classpath;
        }

        Path excluded =
            entry.toAbsolutePath()
                 .normalize();

        List<String> entries =
            new ArrayList<>();

        String[] values =
            classpath.split(
                Pattern.quote(
                    File.pathSeparator));

        for (String value : values) {

            if (value == null ||
                value.isBlank()) {
                continue;
            }

            try {
                Path candidate =
                    Paths.get(value)
                         .toAbsolutePath()
                         .normalize();

                if (candidate.equals(excluded)) {
                    continue;
                }
            }
            catch (Exception ignored) {
                // Keep unusual/non-file classpath entries.
            }

            entries.add(value);
        }

        return String.join(
            File.pathSeparator,
            entries);
    }
    
    /**
     * Generates mutants directly from a canonical Wodel semantic .model file.
     *
     * Pipeline:
     *   .model XMI -> semantic code generation -> javac -> standalone launcher
     *
     * No textual .mutator file is created, parsed or serialized by this path.
     */
    public static ExecutionResult generateMutantsFromModelChecked(
            String modelPath,
            String inputPath,
            String outputPath,
            String currentPluginPath,
            String wodelProjectPath,
            String eclipseHomePath)
            throws IOException, InterruptedException {

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        String projectName = project.getFileName().toString();
        Path model = (modelPath == null || modelPath.isBlank())
                ? project.resolve("data").resolve("out")
                        .resolve(projectName + ".model")
                : Paths.get(modelPath).toAbsolutePath().normalize();

        if (!Files.isRegularFile(model)) {
            throw new IOException("Cannot find canonical Wodel model: " + model);
        }

        long start = System.nanoTime();

        // Direct semantic code generation. This deliberately bypasses both the
        // Xtext serializer and parser used by the textual .mutator workflow.
        generateWodelCodeFromModelChecked(model.toString(), project.toString());

        ExecutionResult mutation = generateMutantsChecked(
                inputPath,
                outputPath,
                currentPluginPath,
                project.toString(),
                eclipseHomePath);

        return new ExecutionResult(
                mutation.isSuccess(),
                mutation.getExitCode(),
                "mutate-model",
                mutation.isSuccess()
                        ? "Mutants generated directly from " + model
                        : "Direct mutant generation from " + model
                                + " failed during phase " + mutation.getPhase()
                                + ": " + mutation.getMessage(),
                elapsedMillis(start));
    }

    /**
     * Generates mutants directly from an in-memory Wodel semantic environment.
     * No .mutator source serialization or parsing is performed.
     */
    public static ExecutionResult generateMutantsFromEnvironmentChecked(
            MutatorEnvironment mutatorEnvironment,
            String inputPath,
            String outputPath,
            String currentPluginPath,
            String wodelProjectPath,
            String eclipseHomePath)
            throws IOException, InterruptedException {

        if (mutatorEnvironment == null) {
            throw new IllegalArgumentException("mutatorEnvironment must not be null");
        }

        Path project = requireDirectory(wodelProjectPath, "Wodel project");
        long start = System.nanoTime();

        // Keep the XMI form as the durable representation, but generate code
        // directly from the in-memory semantic model.
        persistWodelProgramModel(mutatorEnvironment, project.toString());
        generateWodelCodeChecked(mutatorEnvironment, project.toString());

        ExecutionResult mutation = generateMutantsChecked(
                inputPath,
                outputPath,
                currentPluginPath,
                project.toString(),
                eclipseHomePath);

        return new ExecutionResult(
                mutation.isSuccess(),
                mutation.getExitCode(),
                "mutate-environment",
                mutation.isSuccess()
                        ? "Mutants generated directly from in-memory MutatorEnvironment"
                        : "Direct mutant generation failed during phase "
                                + mutation.getPhase() + ": " + mutation.getMessage(),
                elapsedMillis(start));
    }

    /**
     * Applies value-range and attribute-selection options to generated
     * modification operators. This is intentionally a post-processing step so
     * the existing operator-generation algorithms remain backward compatible.
     */
    public static void configureModificationMutators(
            MutatorEnvironment environment,
            AttributeSelectionMode mode,
            int intMin,
            int intMax,
            double doubleMin,
            double doubleMax,
            int stringMin,
            int stringMax,
            long randomSeed) {

        if (environment == null) {
            return;
        }
        validateRange("integer", intMin, intMax);
        validateRange("double", doubleMin, doubleMax);
        validateRange("string length", stringMin, stringMax);
        AttributeSelectionMode effectiveMode = mode != null
                ? mode : AttributeSelectionMode.ALL;
        Random random = new Random(randomSeed);

        List<ModifyInformationMutator> modifications = new ArrayList<ModifyInformationMutator>();
        Iterator<EObject> iterator = environment.eAllContents();
        while (iterator.hasNext()) {
            EObject object = iterator.next();
            if (object instanceof ModifyInformationMutator) {
                modifications.add((ModifyInformationMutator)object);
            }
        }

        for (ModifyInformationMutator mutator : modifications) {
            List<AttributeSet> attributes = mutator.getAttributes();
            if (attributes == null || attributes.isEmpty()) {
                continue;
            }

            if (effectiveMode == AttributeSelectionMode.RANDOM && attributes.size() > 1) {
                AttributeSet selected = attributes.get(random.nextInt(attributes.size()));
                attributes.clear();
                attributes.add(selected);
            }
            else if (effectiveMode != AttributeSelectionMode.ALL
                    && effectiveMode != AttributeSelectionMode.RANDOM) {
                attributes.removeIf(attribute -> !matchesAttributeMode(attribute, effectiveMode));
            }

            for (AttributeSet attribute : attributes) {
            	if (attribute instanceof AttributeOperation) {
                    AttributeOperation op = (AttributeOperation) attribute;
                    AttributeEvaluationType value = op.getValue();
                    if (value instanceof RandomIntegerType) {
                        ((RandomIntegerType)value).setMin(intMin);
                        ((RandomIntegerType)value).setMax(intMax);
                    }
                    else if (value instanceof RandomDoubleType) {
                        ((RandomDoubleType)value).setMin(doubleMin);
                        ((RandomDoubleType)value).setMax(doubleMax);
                    }
                    else if (value instanceof RandomStringType) {
                        ((RandomStringType)value).setMin(stringMin);
                        ((RandomStringType)value).setMax(stringMax);
                    }
            	}
            }

            // If filtering removed the only actual change performed by this
            // mutation command, discard the command instead of generating a
            // no-op mutant. Reference modifications are intentionally kept.
            if (mutator.getAttributes().isEmpty() && mutator.getReferences().isEmpty()) {
                EcoreUtil.remove(mutator);
            }
        }

        environment.getBlocks().removeIf(block -> block.getCommands().isEmpty());
    }

    private static boolean matchesAttributeMode(
            AttributeSet attributes,
            AttributeSelectionMode mode) {
        if (attributes == null || attributes.getAttribute() == null) {
            return false;
        }
        for (EAttribute attribute : attributes.getAttribute()) {
            if (attribute == null || attribute.getEType() == null) {
                continue;
            }
            String type = attribute.getEType().getName();
            if (mode == AttributeSelectionMode.INTEGER && "EInt".equals(type)) return true;
            if (mode == AttributeSelectionMode.DOUBLE && "EDouble".equals(type)) return true;
            if (mode == AttributeSelectionMode.BOOLEAN && "EBoolean".equals(type)) return true;
            if (mode == AttributeSelectionMode.STRING && "EString".equals(type)) return true;
        }
        return false;
    }

    private static void validateRange(String name, double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "Invalid " + name + " range: min " + min + " > max " + max);
        }
    }

    private static Path requireDirectory(String value, String description) throws IOException {
        if (value == null || value.isBlank()) {
            throw new IOException(description + " path is not configured");
        }
        Path path = Paths.get(value).toAbsolutePath().normalize();
        if (!Files.isDirectory(path)) {
            throw new IOException(description + " does not exist: " + path);
        }
        return path;
    }

    private static Path ensureDirectory(String value, String description) throws IOException {
        if (value == null || value.isBlank()) {
            throw new IOException(description + " path is not configured");
        }
        Path path = Paths.get(value).toAbsolutePath().normalize();
        Files.createDirectories(path);
        if (!Files.isDirectory(path)) {
            throw new IOException("Cannot create " + description + ": " + path);
        }
        return path;
    }

    private static String resolveExecutable(String home, String executable) {
        if (executable == null || executable.isBlank()) {
            executable = isWindows() ? "eclipsec.exe" : "eclipse";
        }
        Path executablePath = Paths.get(executable);
        if (executablePath.isAbsolute() && Files.isRegularFile(executablePath)) {
            return executablePath.toString();
        }
        if (home != null && !home.isBlank()) {
            Path candidate = Paths.get(home).toAbsolutePath().normalize().resolve(executable);
            if (Files.isRegularFile(candidate)) {
                return candidate.toString();
            }
        }
        return executable;
    }

    private static String resolveJavaTool(String tool) {
        String executable = isWindows() ? tool + ".exe" : tool;
        String javaHome = System.getProperty("java.home");
        if (javaHome != null && !javaHome.isBlank()) {
            Path candidate = Paths.get(javaHome).resolve("bin").resolve(executable);
            if (Files.isRegularFile(candidate)) {
                return candidate.toString();
            }
            Path parentCandidate = Paths.get(javaHome).getParent();
            if (parentCandidate != null) {
                candidate = parentCandidate.resolve("bin").resolve(executable);
                if (Files.isRegularFile(candidate)) {
                    return candidate.toString();
                }
            }
        }
        return executable;
    }

    private static void addInheritedClasspath(
            Collection<String> entries) {

        String inherited =
            System.getProperty(
                "java.class.path");

        if (inherited == null ||
            inherited.isBlank()) {

            return;
        }

        for (String value :
                inherited.split(
                    java.util.regex.Pattern.quote(
                        File.pathSeparator))) {

            if (value == null ||
                value.isBlank()) {
                continue;
            }

            Path path =
                Paths.get(value)
                     .toAbsolutePath()
                     .normalize();

            entries.add(
                path.toString());
        }
    }
    
    private static Path extractNestedJar(
            JarFile sourceJar,
            JarEntry entry,
            Path cache)
            throws IOException {

        /*
         * Use a flattened cache name.
         *
         * Include a hash of the full archive entry name to
         * avoid collisions between same-named nested jars.
         */
        String entryName =
            entry.getName();

        String basename =
            Paths.get(entryName)
                 .getFileName()
                 .toString();

        String prefix =
            Integer.toUnsignedString(
                entryName.hashCode(),
                16);

        Path destination =
            cache.resolve(
                prefix + "-" + basename);

        /*
         * Reuse an existing extraction if its size agrees.
         */
        if (Files.isRegularFile(destination) &&
            entry.getSize() >= 0 &&
            Files.size(destination)
                == entry.getSize()) {

            return destination
                .toAbsolutePath()
                .normalize();
        }

        try (InputStream input =
                sourceJar.getInputStream(
                    entry)) {

            Files.copy(
                input,
                destination,
                StandardCopyOption.REPLACE_EXISTING);
        }

        return destination
            .toAbsolutePath()
            .normalize();
    }
    
    private static void extractNestedClasspath(
            Path outerJar,
            Path cache,
            Collection<String> entries)
            throws IOException {

        try (JarFile jar =
                new JarFile(
                    outerJar.toFile())) {

            Manifest manifest =
                jar.getManifest();

            boolean extractedFromManifest =
                false;

            /*
             * Eclipse JarRsrcLoader convention:
             *
             * Rsrc-Class-Path: ./ lib/a.jar lib/b.jar ...
             */
            if (manifest != null) {

                String rsrcClassPath =
                    manifest.getMainAttributes()
                            .getValue(
                                "Rsrc-Class-Path");

                if (rsrcClassPath != null &&
                    !rsrcClassPath.isBlank()) {

                    for (String name :
                            rsrcClassPath
                                .trim()
                                .split("\\s+")) {

                        if (name.equals(".") ||
                            name.equals("./")) {
                            continue;
                        }

                        String normalized =
                            name.startsWith("/")
                                ? name.substring(1)
                                : name;

                        JarEntry entry =
                            jar.getJarEntry(
                                normalized);

                        if (entry == null ||
                            entry.isDirectory() ||
                            !normalized
                                .toLowerCase()
                                .endsWith(".jar")) {

                            continue;
                        }

                        Path extracted =
                            extractNestedJar(
                                jar,
                                entry,
                                cache);

                        entries.add(
                            extracted.toString());

                        extractedFromManifest =
                            true;
                    }
                }
            }

            /*
             * Fallback:
             *
             * Some runnable-JAR variants don't have a useful
             * Rsrc-Class-Path. Find nested jars physically
             * present in the outer archive.
             */
            if (!extractedFromManifest) {

                Enumeration<JarEntry> jarEntries =
                    jar.entries();

                while (jarEntries
                        .hasMoreElements()) {

                    JarEntry entry =
                        jarEntries
                            .nextElement();

                    if (entry.isDirectory()) {
                        continue;
                    }

                    String name =
                        entry.getName();

                    if (!name.toLowerCase()
                             .endsWith(".jar")) {
                        continue;
                    }

                    Path extracted =
                        extractNestedJar(
                            jar,
                            entry,
                            cache);

                    entries.add(
                        extracted.toString());
                }
            }
        }
    }
    
    private static void addRunnableJarClasspath(
            Collection<String> entries,
            Path project)
            throws IOException {

        String inherited =
            System.getProperty(
                "java.class.path");

        if (inherited == null ||
            inherited.isBlank()) {
            return;
        }

        Path cache =
            project.resolve(".wodel-cli")
                   .resolve("classpath");

        Files.createDirectories(cache);

        for (String value :
                inherited.split(
                    java.util.regex.Pattern.quote(
                        File.pathSeparator))) {

            if (value == null ||
                value.isBlank()) {
                continue;
            }

            Path jarPath =
                Paths.get(value)
                     .toAbsolutePath()
                     .normalize();

            if (!Files.isRegularFile(jarPath) ||
                !jarPath.getFileName()
                        .toString()
                        .toLowerCase()
                        .endsWith(".jar")) {

                continue;
            }

            /*
             * The outer JAR itself may contain application
             * classes, so always include it.
             */
            entries.add(
                jarPath.toString());

            extractNestedClasspath(
                jarPath,
                cache,
                entries);
        }
    }
    
    private static String buildHeadlessCompileClasspath(
            Path srcGen,
            Path project,
            String currentPluginPath,
            String eclipseHomePath)
            throws IOException {

        LinkedHashSet<String> entries =
            new LinkedHashSet<String>();

        entries.add(
            srcGen.toAbsolutePath()
                  .normalize()
                  .toString());

        Path bin =
            project.resolve("bin");

        if (Files.isDirectory(bin)) {
            entries.add(
                bin.toAbsolutePath()
                   .normalize()
                   .toString());
        }

        /*
         * Normal Java classpath entries.
         */
        addInheritedClasspath(entries);

        /*
         * IMPORTANT:
         *
         * When executing an Eclipse exported runnable JAR,
         * java.class.path normally only exposes the outer
         * JAR. JarRsrcLoader can see nested JARs, javac
         * cannot.
         *
         * Extract those nested JARs and make them actual
         * filesystem classpath entries.
         */
        addRunnableJarClasspath(
            entries,
            project);

        addWildcard(
            entries,
            currentPluginPath);

        if (currentPluginPath != null &&
            !currentPluginPath.isBlank()) {

            addWildcard(
                entries,
                Paths.get(currentPluginPath)
                     .resolve("lib")
                     .toString());
        }

        if (eclipseHomePath != null &&
            !eclipseHomePath.isBlank()) {

            addWildcard(
                entries,
                Paths.get(eclipseHomePath)
                     .resolve("plugins")
                     .toString());

            Path updateSite =
                Paths.get(eclipseHomePath)
                     .resolve("workspace")
                     .resolve("wodel.updatesite")
                     .resolve("plugins");

            addWildcard(
                entries,
                updateSite.toString());
        }

        return String.join(
            File.pathSeparator,
            entries);
    }
    
    private static void addWildcard(
            Collection<String> entries,
            String directory) {

        if (directory == null || directory.isBlank()) {
            return;
        }

        Path path =
            Paths.get(directory)
                 .toAbsolutePath()
                 .normalize();

        if (Files.isDirectory(path)) {
            entries.add(
                path.toString()
                + File.separator
                + "*");
        }
    }

    private static int runProcess(
            List<String> command,
            Path workingDirectory)
            throws IOException, InterruptedException {

        ProcessBuilder builder =
            new ProcessBuilder(command);

        if (workingDirectory != null) {
            builder.directory(
                workingDirectory
                    .toAbsolutePath()
                    .normalize()
                    .toFile());
        }

        builder.inheritIO();

        Process process =
            builder.start();

        try {
            return process.waitFor();
        }
        catch (InterruptedException ex) {

            if (process.isAlive()) {
                process.destroy();

                if (process.isAlive()) {
                    process.destroyForcibly();
                }
            }

            Thread.currentThread().interrupt();
            throw ex;
        }
    }
    
    private static void deleteCompiledClassFamily(
            Path bin,
            String className)
            throws IOException {

        int lastDot =
            className.lastIndexOf('.');

        String packageName =
            lastDot >= 0
                ? className.substring(0, lastDot)
                : "";

        String simpleName =
            lastDot >= 0
                ? className.substring(lastDot + 1)
                : className;

        Path packageFolder = bin;

        if (!packageName.isEmpty()) {
            packageFolder =
                bin.resolve(
                    packageName.replace(
                        '.',
                        File.separatorChar));
        }

        if (!Files.isDirectory(packageFolder)) {
            return;
        }

        try (DirectoryStream<Path> stream =
                Files.newDirectoryStream(
                    packageFolder,
                    simpleName + "*.class")) {

            for (Path file : stream) {
                Files.deleteIfExists(file);
            }
        }
    }

    private static long elapsedMillis(long startNanos) {
        return (System.nanoTime() - startNanos) / 1_000_000L;
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "").toLowerCase().contains("win");
    }

    private static String escapeWodelString(String value) {
        return value == null ? "" : value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

	/**
	 * @param args
	 * @throws MetaModelNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws MetaModelNotFoundException, IOException {
        // Prefer the named-command CLI implemented by WodelGenerator.
        if (args != null && args.length > 0) {
            String first = args[0];
            if ("generate".equalsIgnoreCase(first)
                    || "compile".equalsIgnoreCase(first)
                    || "mutate".equalsIgnoreCase(first)
                    || "run".equalsIgnoreCase(first)
                    || "help".equalsIgnoreCase(first)
                    || "--help".equals(first)) {
                int exit = WodelGenerator.runCli(args);
                if (exit != 0) {
                    throw new IllegalStateException("Wodel CLI failed with exit code " + exit);
                }
                return;
            }
        }

        // Backward-compatible adapter for the former seven positional
        // arguments. New clients should use WodelGenerator's named options.
        if (args == null || args.length < 7) {
            System.out.println(
                    "Legacy usage: <metamodel> <input> <output> <pluginPath> "
                    + "<wodelProject> <eclipseHome> <compiler> [exhaustive]");
            System.out.println("Preferred usage: WodelGenerator --help");
            return;
        }
        boolean exhaustive = args.length < 8 || Boolean.parseBoolean(args[7]);
        List<String> translated = new ArrayList<String>();
        translated.add("run");
        translated.addAll(Arrays.asList(
                "--metamodel", args[0],
                "--input", args[1],
                "--output", args[2],
                "--plugin-path", args[3],
                "--project", args[4],
                "--eclipse-home", args[5],
                "--compiler", args[6],
                "--mode", exhaustive ? "exhaustive" : "stochastic",
                "--mutants", "1",
                "--operators", "create,remove,clone,modify,retype",
                "--class-mode", "concrete",
                "--coverage", "partial"));
        int exit = WodelGenerator.runCli(translated.toArray(new String[0]));
        if (exit != 0) {
            throw new IllegalStateException("Wodel CLI failed with exit code " + exit);
        }
    }

	private static boolean isWodelProgram(IFile file) {

	    if (file == null || !file.exists()) {
	        return false;
	    }

	    try {

	        Injector injector =
	            new WodelStandaloneSetup()
	                .createInjectorAndDoEMFRegistration();

	        XtextResourceSet resourceSet =
	            injector.getInstance(XtextResourceSet.class);

	        URI uri =
	            URI.createPlatformResourceURI(
	                file.getFullPath().toString(),
	                true
	            );

	        Resource resource =
	            resourceSet.getResource(uri, true);

	        EcoreUtil.resolveAll(resource);

	        if (resource.getContents().isEmpty()) {
	            return false;
	        }

	        EObject root =
	            resource.getContents().get(0);

	        if (!(root instanceof MutatorEnvironment)) {
	            return false;
	        }

	        MutatorEnvironment environment =
	            (MutatorEnvironment) root;

	        return environment.getDefinition() instanceof Program;

	    }
	    catch (Exception e) {

	        /*
	         * A malformed/unloadable .mutator file is not considered
	         * an executable Wodel program here.
	         */
	        return false;
	    }
	}
	
	/**
	 * Finds all files with a given extension under a container (project/folder).
	 * Uses proxy visitor (fast, avoids materializing all resources).
	 */
	public static Set<IFile> findFilesByExtension(IContainer root, String extension) throws CoreException {
		Objects.requireNonNull(root, "root");
		Objects.requireNonNull(extension, "extension");

		Set<IFile> result = new LinkedHashSet<>();

		root.accept((IResourceProxyVisitor) proxy -> {
			if (proxy.getType() == IResource.FILE) {
				String name = proxy.getName();
				if (name != null && name.endsWith("." + extension)) {
					IResource r = proxy.requestResource();
					if (r instanceof IFile) {
						result.add((IFile) r);
					}
				}
				return false; // no children under files
			}
			return true; // visit children
		}, IResource.DEPTH_INFINITE);

		return result;
	}
	
	/**
	 * Convenience: all *.mutator files in <project>/src (or whole project if src missing).
	 */
	public static List<IFile> getMutatorFiles(IProject project) throws CoreException {
		if (project == null) {
			return List.of();
		}
		IContainer base = project.getFolder("src");
		if (base == null || !base.exists()) {
			base = project;
		}

		List<IFile> files = new ArrayList<IFile>(findFilesByExtension(base, "mutator"));
		files.removeIf(file -> !isWodelProgram(file));
		files.sort(Comparator.comparing(f -> f.getProjectRelativePath().toString(), String.CASE_INSENSITIVE_ORDER));
		return files;
	}
	
	public ExecutionResult
	generateMutantsFromMutatorChecked(
	        String mutatorPath,
	        String inputPath,
	        String outputPath,
	        String currentPluginPath,
	        String wodelProjectPath,
	        String eclipseHomePath)
	        throws IOException,
	               InterruptedException {

	    long start =
	        System.nanoTime();

	    /*
	     * Parse and validate textual Wodel exactly once.
	     */
	    MutatorEnvironment environment =
	        loadWodelMutatorChecked(
	            mutatorPath,
	            wodelProjectPath);

	    /*
	     * Optional but useful:
	     * keep the resolved semantic form as canonical XMI.
	     */
	    persistWodelProgramModel(
	        environment,
	        wodelProjectPath);

	    /*
	     * Critical point:
	     *
	     * DO NOT invoke GeneratorDelegate.
	     *
	     * Generate the standalone Java directly from the
	     * already parsed MutatorEnvironment.
	     */
	    ExecutionResult codegen =
	        generateWodelCodeChecked(
	            environment,
	            wodelProjectPath);

	    if (!codegen.isSuccess()) {

	        return new ExecutionResult(
	            false,
	            codegen.getExitCode(),
	            "apply-codegen",
	            codegen.getMessage(),
	            elapsedMillis(start));
	    }

	    /*
	     * Compile generated standalone Java and execute it.
	     */
	    ExecutionResult mutation =
	        generateMutantsChecked(
	            inputPath,
	            outputPath,
	            currentPluginPath,
	            wodelProjectPath,
	            eclipseHomePath);

	    return new ExecutionResult(
	        mutation.isSuccess(),
	        mutation.getExitCode(),
	        "apply",
	        mutation.isSuccess()
	            ? "Wodel program applied successfully: "
	                + mutatorPath
	            : "Applying Wodel program failed during "
	                + mutation.getPhase()
	                + ": "
	                + mutation.getMessage(),
	        elapsedMillis(start));
	}
	
	private Path resolveMetamodelPath(String value, String projectPath) {

		String path = value.trim();

		if (path.startsWith("file:")) {

			return Paths.get(java.net.URI.create(path)).toAbsolutePath().normalize();
		}

		Path candidate = Paths.get(path);

		if (candidate.isAbsolute()) {
			return candidate.normalize();
		}

		if (projectPath != null && !projectPath.isBlank()) {

			Path project = Paths.get(projectPath).toAbsolutePath().normalize();

			/*
			 * First try relative to project.
			 */
			Path relative = project.resolve(candidate).normalize();

			if (Files.exists(relative)) {
				return relative;
			}

			/*
			 * Useful fallback when Program.metamodel contains only "python.ecore".
			 */
			Path dataModel = project.resolve("data").resolve("model").resolve(candidate.getFileName());

			if (Files.exists(dataModel)) {
				return dataModel.normalize();
			}
		}

		return candidate.toAbsolutePath().normalize();
	}
	
	private void registerPackage(ResourceSet set, EPackage ePackage) {

		if (ePackage == null) {
			return;
		}

		String nsURI = ePackage.getNsURI();

		if (nsURI != null && !nsURI.isBlank()) {

			set.getPackageRegistry().put(nsURI, ePackage);

			System.out.println("Registered EPackage: " + ePackage.getName() + " -> " + nsURI);
		}

		for (EPackage subpackage : ePackage.getESubpackages()) {

			registerPackage(set, subpackage);
		}
	}

	
	private void registerDomainMetamodel(ResourceSet set, MutatorEnvironment environment, String projectPath)
			throws IOException {

		if (!(environment.getDefinition() instanceof Program)) {

			throw new IllegalStateException("The MutatorEnvironment does not " + "contain a Wodel Program definition.");
		}

		Program program = (Program) environment.getDefinition();

		String metamodelValue = program.getMetamodel();

		if (metamodelValue == null || metamodelValue.isBlank()) {

			throw new IllegalStateException("The Wodel Program does not specify " + "a domain metamodel.");
		}

		Path metamodelPath = resolveMetamodelPath(metamodelValue, projectPath);

		if (!Files.isRegularFile(metamodelPath)) {

			throw new IOException("Domain metamodel not found: " + metamodelPath);
		}

		System.out.println("Loading domain metamodel: " + metamodelPath);

		Resource metamodelResource = set.getResource(URI.createFileURI(metamodelPath.toString()), true);

		for (EObject object : metamodelResource.getContents()) {

			if (object instanceof EPackage) {

				registerPackage(set, (EPackage) object);
			}
		}

		EcoreUtil.resolveAll(metamodelResource);
	}
	
	private static Path resolveHeadlessMetamodelPath(
            String value,
            Path project) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                "The Wodel program does not specify a metamodel");
        }

        String normalized =
            value.trim().replace('\\', '/');

        /*
         * file:/D:/...
         */
        if (normalized.startsWith("file:")) {
            return Paths.get(
                    java.net.URI.create(normalized))
                .toAbsolutePath()
                .normalize();
        }

        /*
         * platform:/resource/eduPy/data/model/python.ecore
         */
        if (normalized.startsWith(
                "platform:/resource/")) {

            String relative =
                normalized.substring(
                    "platform:/resource/".length());

            int slash =
                relative.indexOf('/');

            if (slash >= 0) {
                String projectName =
                    relative.substring(0, slash);

                String projectRelative =
                    relative.substring(slash + 1);

                if (project.getFileName()
                        .toString()
                        .equals(projectName)) {

                    return project
                        .resolve(projectRelative)
                        .normalize();
                }
            }
        }

        /*
         * Wodel Eclipse-style path:
         *
         * /eduPy/data/model/python.ecore
         */
        String projectName =
            project.getFileName().toString();

        String projectPrefix =
            "/" + projectName + "/";

        if (normalized.startsWith(
                projectPrefix)) {

            String relative =
                normalized.substring(
                    projectPrefix.length());

            return project
                .resolve(relative)
                .normalize();
        }

        /*
         * Genuine absolute filesystem path.
         */
        Path candidate =
            Paths.get(normalized);

        if (candidate.isAbsolute() &&
            Files.isRegularFile(candidate)) {

            return candidate
                .toAbsolutePath()
                .normalize();
        }

        /*
         * Project-relative path.
         */
        candidate =
            project.resolve(normalized)
                   .normalize();

        if (Files.isRegularFile(candidate)) {
            return candidate;
        }

        /*
         * Last useful fallback:
         * data/model/<filename>
         */
        Path filename =
            Paths.get(normalized)
                 .getFileName();

        candidate =
            project.resolve("data")
                   .resolve("model")
                   .resolve(filename)
                   .normalize();

        if (Files.isRegularFile(candidate)) {
            return candidate;
        }

        throw new IllegalArgumentException(
            "Cannot resolve Wodel domain metamodel '"
            + value
            + "' from project "
            + project);
    }
	
	public MutatorEnvironment
	loadWodelMutatorChecked(
	        String mutatorPath,
	        String wodelProjectPath)
	        throws IOException {

	    Path mutator =
	        Paths.get(mutatorPath)
	             .toAbsolutePath()
	             .normalize();

	    Path project =
	        Paths.get(wodelProjectPath)
	             .toAbsolutePath()
	             .normalize();

	    /*
	     * Wodel's own metamodel must be globally available
	     * before the Xtext injector is created.
	     */
	    MutatorenvironmentPackage.eINSTANCE.eClass();

	    EPackage.Registry.INSTANCE.put(
	        MutatorenvironmentPackage.eNS_URI,
	        MutatorenvironmentPackage.eINSTANCE);

	    Injector injector =
	        new WodelStandaloneSetup()
	            .createInjectorAndDoEMFRegistration();

	    XtextResourceSet resourceSet =
	        injector.getInstance(
	            XtextResourceSet.class);

	    resourceSet
	        .getPackageRegistry()
	        .put(
	            MutatorenvironmentPackage.eNS_URI,
	            MutatorenvironmentPackage.eINSTANCE);

	    /*
	     * Parse the syntax.
	     *
	     * Xtext cross-references are lazy, so do not validate
	     * or resolve anything yet.
	     */
	    Resource resource =
	        resourceSet.getResource(
	            URI.createFileURI(
	                mutator.toString()),
	            true);

	    if (resource.getContents().isEmpty()) {
	        throw new IOException(
	            "Empty Wodel program: "
	            + mutator);
	    }

	    EObject root =
	        resource.getContents().get(0);

	    if (!(root instanceof MutatorEnvironment)) {
	        throw new IOException(
	            "Expected MutatorEnvironment but found "
	            + root.eClass().getName());
	    }

	    MutatorEnvironment environment =
	        (MutatorEnvironment) root;

	    if (!(environment.getDefinition()
	            instanceof Program)) {

	        throw new IOException(
	            "The Wodel program has no Program definition");
	    }

	    Program program =
	        (Program)
	            environment.getDefinition();

	    /*
	     * CRITICAL HEADLESS FIX.
	     */
	    String originalMetamodel =
	        program.getMetamodel();

	    Path metamodel =
	        resolveHeadlessMetamodelPath(
	            originalMetamodel,
	            project);

	    /*
	     * Use forward slashes because this string is later
	     * inserted directly into generated Java source.
	     */
	    String headlessMetamodel =
	        metamodel.toString()
	                 .replace('\\', '/');

	    System.out.println(
	        "Wodel metamodel path: "
	        + originalMetamodel
	        + " -> "
	        + headlessMetamodel);

	    /*
	     * This is the crucial statement.
	     *
	     * WodelScopeProvider will now call
	     * ModelManager.loadMetaModel() with a real filesystem
	     * path instead of /eduPy/data/...
	     */
	    program.setMetamodel(
	        headlessMetamodel);

	    /*
	     * Now load/register the domain EPackage.
	     */
	    registerDomainMetamodel(
	        resourceSet,
	        environment,
	        project.toString());

	    /*
	     * NOW it is safe to trigger lazy Xtext linking.
	     */
	    EcoreUtil.resolveAll(
	        resourceSet);

	    /*
	     * Check Xtext parse/linking diagnostics before
	     * generating anything.
	     */
	    if (!resource.getErrors().isEmpty()) {

	        StringBuilder message =
	            new StringBuilder(
	                "Wodel linking errors:");

	        for (Resource.Diagnostic error :
	                resource.getErrors()) {

	            message.append(
	                    System.lineSeparator())
	                .append("  ")
	                .append(error.getMessage());

	            if (error.getLine() > 0) {
	                message.append(
	                    " [line ")
	                    .append(error.getLine())
	                    .append("]");
	            }
	        }

	        throw new IOException(
	            message.toString());
	    }

	    IResourceValidator validator =
	        injector.getInstance(
	            IResourceValidator.class);

	    List<Issue> issues =
	        validator.validate(
	            resource,
	            CheckMode.ALL,
	            CancelIndicator.NullImpl);

	    for (Issue issue : issues) {
	        if (issue.getSeverity()
	                == Severity.ERROR) {

	            throw new IOException(
	                "Invalid Wodel program: "
	                + issue);
	        }
	    }

	    return environment;
	}
}

