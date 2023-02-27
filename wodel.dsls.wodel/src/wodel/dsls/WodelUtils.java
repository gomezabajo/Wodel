package wodel.dsls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeScalar;
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
//import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

import com.google.inject.Injector;

import exceptions.MetaModelNotFoundException;
import manager.EMFComparison;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.ProjectUtils;
import mutatorenvironment.miniOCL.InvariantCS;
import wodel.dsls.generator.Main;
//import wodel.dsls.generator.WodelGenerator;
//import wodel.dsls.generator.WodelMutatorGenerator;

/**
 * @author Pablo Gomez-Abajo - Utils for serialize and deserialize Wodel programs
 * 
 */

public class WodelUtils {

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void serialize(String xTextURI, String outputURI) {
		EPackage.Registry.INSTANCE.put(MutatorenvironmentPackage.eNS_URI,  MutatorenvironmentPackage.eINSTANCE);
		
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
		if (xTextRS == null) {
			return;
		}
		XtextResource xtextInput = (XtextResource)xTextRS.getResource(URI.createURI(xTextURI), true);
		EcoreUtil.resolveAll(xtextInput);
		
		//create an empty xmi resource
		ResourceSet xmiRS = new ResourceSetImpl();
		Resource xmiOutput = xmiRS.createResource(URI.createURI(outputURI));
		
		xmiOutput.getContents().add(xtextInput.getContents().get(0));
		try {
			xmiOutput.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static String deserialize(EObject eObject) {
//		Injector injector = Guice.createInjector(new  wodel.dsls.WodelRuntimeModule());  
//		Serializer serializer = injector.getInstance(Serializer.class);  
//		return serializer.serialize(eObject);
//	}
	
	public static String deserialize(String xTextURI, EObject eObject) {
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
		XtextResource xtextOutput = (XtextResource)xTextRS.createResource(URI.createURI(xTextURI));
		xtextOutput.getContents().add(eObject);
		ISerializer serializer = xtextOutput.getSerializer();
		return format(serializer.serialize(xtextOutput.getContents().get(0)));
		//return serializer.serialize(xtextOutput.getContents().get(0));
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
		operator = operator.replace("\\r\\n", "").replace("\\r", "").replace("\\n", "");
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
			formatted += " " + operator.substring(i, operator.length()).trim() + "\n";
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
	

	public static void generateMutationOperators(String[] args)  throws MetaModelNotFoundException, IOException {
		String metamodel = null;
		List<EPackage> packages = null;
		boolean exhaustive = false;
		String domainMetamodelPath = "";
		String inputPath = "";
		String wodelProjectPath = "";
		String wodelProjectName = "";
		String wodelProgramPath = "";
		if (args.length < 3) {
			System.out.println("args[0] = domainMetamodelPath, args[1] = inputPath, args[2] = wodelProjectPath (, args[3] = exhaustive == true, optimized == false)?");
			return;
		}
		if (args.length >= 3) {
			domainMetamodelPath = args[0];
			inputPath = args[1];
			wodelProjectPath = args[2];
			wodelProjectName = wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/") + 1, wodelProjectPath.length());
			wodelProgramPath = wodelProjectPath + "/src" + wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/"), wodelProjectPath.length()) + ".mutator"; 
			exhaustive = args.length >= 4 ? Boolean.valueOf(args[3]) : true;
		}
		if (exhaustive == true) {
			MutatorenvironmentPackage.eINSTANCE.getClass();
			metamodel = domainMetamodelPath;
			packages = ModelManager.loadMetaModel(metamodel);
			List<Resource> wodelModels = new ArrayList<Resource>();
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
			wodelOperators.add("select");
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
												doubleType.setMax(10);
												attributeType = doubleType;
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
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
													stringType.setMin(2);
													stringType.setMax(4);
													attributeType = stringType;
												}
												if (attribute.getEType().getName().equals("EInt")) {
													RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
													integerType.setOperator(operator);
													integerType.setMin(2);
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
													doubleType.setMin(2);
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
			
			WodelUtils.serialize("file:/" + wodelProgramPath, "file:/" + wodelProjectPath + "/data/out/" + wodelProjectName + ".model");
			
			System.out.println("Mutation operators created successfully!!");
		}
	}
	
	public static void compileWodelProject(String[] args) {
		String wodelProjectPath = "";
		String wodelProjectName = "";
		String eclipseHomePath = "";
		String compilerName = "";
		String wodelWorkspacePath;
		ProjectUtils.projectName = wodelProjectName;
		if (args.length < 3) {
			System.out.println("args[0] = wodelProjectPath, args[1] = eclipseHomePath, args[2] = compilerName");
			return;
		}
		if (args.length >= 3) {
			wodelProjectPath = args[0];
			eclipseHomePath = args[1];
			compilerName = args[2];
			wodelWorkspacePath = wodelProjectPath.substring(0, wodelProjectPath.lastIndexOf("/"));
			wodelProjectName = wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/") + 1, wodelProjectPath.length());
			MutatorenvironmentPackage.eINSTANCE.getClass();
			Main.main(new String[] {wodelProjectPath + "/src/" + wodelProjectName + ".mutator", wodelProjectPath});
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", eclipseHomePath + "/" + compilerName + " " + String.format("-nosplash -application org.eclipse.jdt.apt.core.aptBuild startup.jar -data %s -build all", wodelWorkspacePath));
			builder.inheritIO();
			try {
				Process process = builder.start();
				int exitCode = process.waitFor();
				if (exitCode != 0) {
					System.out.println("Some errors were found in the compilation of " + wodelProjectPath);
					return;
				}
				else {
					System.out.println("Compilation completed successfully!!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void generateMutants(String[] args) {
		String inputPath = "";
		String outputPath = "";
		String wodelProjectPath = "";
		String wodelProjectName = "";
		String eclipseHomePath = "";
		if (args.length < 4) {
			System.out.println("args[0] = inputPath, args[1] = outputPath, args[2] = wodelProjectPath, args[3] = eclipseHomePath");
			return;
		}
		if (args.length >= 4) {
			inputPath = args[0];
			outputPath = args[1];
			wodelProjectPath = args[2];
			eclipseHomePath = args[3];
			wodelProjectName = wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/") + 1, wodelProjectPath.length());
			System.out.println("Generation of the mutants...");
			String batcompile = wodelProjectPath + "/src-gen/bat/compile.bat";
			File batfolder = new File(wodelProjectPath + "/src-gen/bat");
			if (!batfolder.exists()) {
				batfolder.mkdirs();
			}
			PrintWriter batwriter = null;
			try {
				String currentPath = new java.io.File(".").getCanonicalPath();
				batwriter = new PrintWriter(batcompile, "UTF-8");
				String folders = wodelProjectPath + "/src-gen/mutator/";
				batwriter.println(folders.substring(0, folders.indexOf("/")));
				batwriter.println("cd \\");
				for (String folderName : folders.substring(folders.indexOf("/"), folders.length()).split("/")) {
					batwriter.println("cd " + folderName);
				}
				batwriter.println("javac -source 1.8 -target 1.8 -classpath " + currentPath + "/*;" + currentPath + "/lib/*;" + eclipseHomePath + "/plugins/*;" + eclipseHomePath + "/workspace/wodel.updatesite/plugins/* " + wodelProjectName + "Standalone/" + wodelProjectName + "Standalone.java " + wodelProjectName + "/" + wodelProjectName + "StandaloneAPI.java " + wodelProjectName + "/" + wodelProjectName + "StandaloneAPILauncher.java");
				batwriter.println("cd ..");
				batwriter.println("java -classpath .;" + currentPath + "/*;" + currentPath + "/lib/*;" + eclipseHomePath + "/plugins/*;" + eclipseHomePath + "/workspace/wodel.updatesite/plugins/* mutator/" + wodelProjectName +"/" + wodelProjectName + "StandaloneAPILauncher " + inputPath + " " + outputPath);
				batwriter.println("exit");
				batwriter.close();
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", batcompile);
				builder.inheritIO();
				Process process = builder.start();
				int exitCode = process.waitFor();
				if (exitCode != 0) {
					System.out.println("The compilation of the classes to execute from command line was not completed successfully.");
					return;
				}
				else {
					System.out.println("Mutants generated successfully!!");
				}
			} catch (UnsupportedEncodingException e) {
				//Reload input
				System.out.println("The compilation of the classes to execute from command line was not completed successfully.");
				return;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws MetaModelNotFoundException, IOException {
		String metamodel = null;
		List<EPackage> packages = null;
		boolean exhaustive = false;
		String domainMetamodelPath = "";
		String inputPath = "";
		String outputPath = "";
		String wodelProjectPath = "";
		String wodelProjectName = "";
		String wodelWorkspacePath = "";
		String wodelProgramPath = "";
		String eclipseHomePath = "";
		String compilerName = "";
		if (args.length < 6) {
			System.out.println("args[0] = domainMetamodelPath, args[1] = inputPath, args[2] = outputPath, args[3] = wodelProjectPath, args[4] = eclipseHomePath, args[5] = compilerName (, args[6] = exhaustive == true, optimized == false)?");
			return;
		}
		if (args.length >= 6) {
			domainMetamodelPath = args[0];
			inputPath = args[1];
			outputPath = args[2];
			wodelProjectPath = args[3];
			eclipseHomePath = args[4];
			compilerName = args[5];
			wodelWorkspacePath = wodelProjectPath.substring(0, wodelProjectPath.lastIndexOf("/"));
			wodelProjectName = wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/") + 1, wodelProjectPath.length());
			wodelProgramPath = wodelProjectPath + "/src" + wodelProjectPath.substring(wodelProjectPath.lastIndexOf("/"), wodelProjectPath.length()) + ".mutator"; 
			exhaustive = args.length >= 7 ? Boolean.valueOf(args[6]) : true;
		}
		if (exhaustive == true) {
			MutatorenvironmentPackage.eINSTANCE.getClass();
			metamodel = domainMetamodelPath;
			packages = ModelManager.loadMetaModel(metamodel);
			List<Resource> wodelModels = new ArrayList<Resource>();
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
			wodelOperators.add("select");
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
												doubleType.setMax(10);
												attributeType = doubleType;
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
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
												stringType.setMin(2);
												stringType.setMax(4);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
												integerType.setOperator(operator);
												integerType.setMin(2);
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
												doubleType.setMin(2);
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
													stringType.setMin(2);
													stringType.setMax(4);
													attributeType = stringType;
												}
												if (attribute.getEType().getName().equals("EInt")) {
													RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
													integerType.setOperator(operator);
													integerType.setMin(2);
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
													doubleType.setMin(2);
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
			
			WodelUtils.serialize("file:/" + wodelProgramPath, "file:/" + wodelProjectPath + "/data/out/" + wodelProjectName + ".model");

			try {
				//ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", eclipseHomePath + "/eclipsec " + String.format("-nosplash -application org.eclipse.jdt.apt.core.aptBuild startup.jar -data %s -build all", wodelWorkspacePath));
				//builder.inheritIO();
				//Process process = builder.start();
				//int exitCode = process.waitFor();
				//if (exitCode != 0) {
				//	System.out.println("Some errors were found in the compilation of " + wodelProjectPath);
				//	return;
				//}
				//Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
				//InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				List<EPackage> mutatorPackages = new ArrayList<EPackage>();
				mutatorPackages.add(MutatorenvironmentPackage.eINSTANCE);
				Resource wodelProgram = ModelManager.loadModelNoException(mutatorPackages, wodelProjectPath + "/data/out/" + wodelProjectName + ".model");
				String stringURI = "/resource/" + wodelProjectName;
				stringURI = stringURI + "/src/" + wodelProjectName + ".mutator";
				wodelProgram.setURI(URI.createURI(stringURI));
				ModelManager.saveModel(wodelProgram, "file:/" + wodelProjectPath + "/data/out/" + wodelProjectName + ".model");
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", eclipseHomePath + "/" + compilerName + " " + String.format("-nosplash -application org.eclipse.jdt.apt.core.aptBuild startup.jar -data %s -build all", wodelWorkspacePath));
				builder.inheritIO();
				Process process = builder.start();
				int exitCode = process.waitFor();
				if (exitCode != 0) {
					System.out.println("Some errors were found in the compilation of " + wodelProjectPath);
					return;
				}
				//WodelGenerator wodelGenerator = new WodelGenerator();
				//wodelGenerator.doGenerate(wodelProgram, fsa, null);
				ProjectUtils.projectName = wodelProjectName;
				Main.main(new String[] {wodelProjectPath + "/src/" + wodelProjectName + ".mutator", wodelProjectPath});
				builder = new ProcessBuilder("cmd.exe", "/c", eclipseHomePath + "/" + compilerName + " " + String.format("-nosplash -application org.eclipse.jdt.apt.core.aptBuild startup.jar -data %s -build all", wodelWorkspacePath));
				builder.inheritIO();
				process = builder.start();
				exitCode = process.waitFor();
				if (exitCode != 0) {
					System.out.println("Some errors were found in the compilation of " + wodelProjectPath);
					return;
				}
				else {
					System.out.println("Compilation completed successfully!!");
				}
				System.out.println("Generation of the mutants from the command line...");
				String currentPath = new java.io.File(".").getCanonicalPath();
				String batcompile = wodelProjectPath + "/src-gen/bat/compile.bat";
				File batfolder = new File(wodelProjectPath + "/src-gen/bat");
				if (!batfolder.exists()) {
					batfolder.mkdirs();
				}
				PrintWriter batwriter = null;
				try {
					batwriter = new PrintWriter(batcompile, "UTF-8");
					String folders = wodelProjectPath + "/src-gen/mutator/";
					batwriter.println(folders.substring(0, folders.indexOf("/")));
					batwriter.println("cd \\");
					for (String folderName : folders.substring(folders.indexOf("/"), folders.length()).split("/")) {
						batwriter.println("cd " + folderName);
					}
					batwriter.println("javac -source 1.8 -target 1.8 -classpath " + currentPath + "/*;" + currentPath + "/lib/*;" + eclipseHomePath + "/plugins/*;" + eclipseHomePath + "/workspace/wodel.updatesite/plugins/* " + wodelProjectName + "Standalone/" + wodelProjectName + "Standalone.java " + wodelProjectName + "/" + wodelProjectName + "StandaloneAPI.java " + wodelProjectName + "/" + wodelProjectName + "StandaloneAPILauncher.java");
					batwriter.println("cd ..");
					batwriter.println("java -classpath .;" + currentPath + "/*;" + currentPath + "/lib/*;" + eclipseHomePath + "/plugins/*;" + eclipseHomePath + "/workspace/wodel.updatesite/plugins/* mutator/" + wodelProjectName +"/" + wodelProjectName + "StandaloneAPILauncher " + inputPath + " " + outputPath);
					batwriter.println("exit");
					batwriter.close();
				} catch (UnsupportedEncodingException e) {
					//Reload input
					System.out.println("The compilation of the classes to execute from command line was not completed successfully.");
					return;
				}
				builder = new ProcessBuilder("cmd.exe", "/c", batcompile);
				builder.inheritIO();
				process = builder.start();
				exitCode = process.waitFor();
				if (exitCode != 0) {
					System.out.println("The compilation of the classes to execute from command line was not completed successfully.");
					return;
				}
				else {
					System.out.println("Mutants generated successfully!!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
