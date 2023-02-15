package wodel.dsls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeType;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.Program;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificStringType;

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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

import com.google.inject.Injector;

import exceptions.MetaModelNotFoundException;
import manager.EMFComparison;
import manager.ModelManager;
import manager.MutatorUtils;
import mutatorenvironment.miniOCL.InvariantCS;

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
		String formatted = "";
		String[] operations = {"create", "deep clone", "clone", "modify", "select", "remove", "retype"};
		int index = -1;
		int begin = Integer.MAX_VALUE;
		int i = 0;
		for (int j = 0; j < operations.length; j++) {
			int current = operator.indexOf(operations[j]);
			if (current != -1 && begin > current) {
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
	
	public static void main(String[] args) throws MetaModelNotFoundException, IOException {
		String metamodel = null;
		List<EPackage> packages = null;
		boolean exhaustive = false;
		String domainMetamodelPath = "";
		String seedModelsPath = "";
		String wodelProgramPath = "";
		if (args.length < 3) {
			System.out.println("args[0] = domainMetamodelPath, args[1] = seedModelsPath, args[2] = wodelProgramPath (, args[3] = exhaustive == true, optimized == false)?");
			return;
		}
		if (args.length >= 3) {
			domainMetamodelPath = args[0];
			seedModelsPath = args[1];
			wodelProgramPath = args[2];
			exhaustive = args.length >= 4 ? Boolean.valueOf(args[3]) : true;
		}
		if (exhaustive == true) {
			metamodel = domainMetamodelPath;
			packages = ModelManager.loadMetaModel(metamodel);
			List<Resource> wodelModels = new ArrayList<Resource>();
			wodelModels.addAll(ModelManager.getModelsNoException(metamodel, seedModelsPath));
			
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
			int i = 0;
			int j = 0;
			for (EClass eClass : eClasses) {
				if (eClass.isAbstract() == true) {
					j++;
					continue;
				}
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
					i++;
					block = MutatorenvironmentFactory.eINSTANCE.createBlock();
					block.setName(blockName);
					blocks.add(block);
					if (wodelOperator.equals("select")) {
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
						int m = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								AttributeEvaluation attributeEvaluation = null;
								ReferenceEvaluation referenceEvaluation = null;
								for (Object ob : lob) {
									m++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
									}
									if (attributeEvaluation != null) {
										if (m == 1) {
											expression.setFirst(attributeEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
									if (referenceEvaluation != null) {
										if (m == 1) {
											expression.setFirst(referenceEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
								}
								selectObjectMutator.setName("p");
								if (m > 0) {
									obSelectionStrategy.setExpression(expression);
								}
								selectObjectMutator.setObject(obSelectionStrategy);
								mutator.add(selectObjectMutator);
							}
						}
					}
					if (wodelOperator.equals("create")) {
						CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
						createObjectMutator.setType(eClass);
						AttributeScalar attributeScalar = null;
						ReferenceInit referenceInit = null;
						int k = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(k);
								k++;
								for (Object ob : lob) {
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeScalar.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										referenceStrategy.setType((EClass) reference.getEType());
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
									}
									if (attributeScalar != null) {
										createObjectMutator.getAttributes().add(attributeScalar);
									}
									if (referenceInit != null) {
										createObjectMutator.getReferences().add(referenceInit);
									}
								}
							}
						}
						mutator.add(createObjectMutator);
					}
					if (wodelOperator.equals("remove")) {
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
						int m = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								AttributeEvaluation attributeEvaluation = null;
								ReferenceEvaluation referenceEvaluation = null;
								for (Object ob : lob) {
									m++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
									}
									if (attributeEvaluation != null) {
										if (m == 1) {
											expression.setFirst(attributeEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
									if (referenceEvaluation != null) {
										if (m == 1) {
											expression.setFirst(referenceEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
								}
								//removeObjectMutator.setName("p");
								if (m > 0) {
									obSelectionStrategy.setExpression(expression);
								}
							}
						}
						removeObjectMutator.setObject(obSelectionStrategy);
						mutator.add(removeObjectMutator);
					}
					if (wodelOperator.equals("modify")) {
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
						int m = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								AttributeEvaluation attributeEvaluation = null;
								ReferenceEvaluation referenceEvaluation = null;
								for (Object ob : lob) {
									m++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
									}
									if (attributeEvaluation != null) {
										if (m == 1) {
											expression.setFirst(attributeEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
									if (referenceEvaluation != null) {
										if (m == 1) {
											expression.setFirst(referenceEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
								}
								modifyInformationMutator.setName("p");
								if (m > 0) {
									obSelectionStrategy.setExpression(expression);
								}
							}
						}
						AttributeScalar attributeScalar = null;
						ReferenceInit referenceInit = null;
						int l = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(l);
								l++;
								for (Object ob : lob) {
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeScalar.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										referenceStrategy.setType((EClass) reference.getEType());
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
									}
									obSelectionStrategy.setType(eClass);
									if (attributeScalar != null) {
										modifyInformationMutator.getAttributes().add(attributeScalar);
									}
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
						int m = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWhereElements.contains(feature.getName())) {
								List<Object> lob = featureWhereValues.get(k);
								k++;
								AttributeEvaluation attributeEvaluation = null;
								ReferenceEvaluation referenceEvaluation = null;
								for (Object ob : lob) {
									m++;
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeEvaluation.setName(attribute);
										attributeEvaluation.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										Operator operator = Operator.EQUALS;
										referenceStrategy.setType((EClass) reference.getEType());
										referenceEvaluation.setName(reference);
										referenceEvaluation.setOperator(operator);
										referenceEvaluation.setValue(referenceStrategy);
									}
									if (attributeEvaluation != null) {
										if (m == 1) {
											expression.setFirst(attributeEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(attributeEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
									if (referenceEvaluation != null) {
										if (m == 1) {
											expression.setFirst(referenceEvaluation);
										}
										if (m > 1) {
											expression.getSecond().add(referenceEvaluation);
											BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
											operator.setType(LogicOperator.OR);
											expression.getOperator().add(operator);
										}
									}
								}
								cloneObjectMutator.setName("p");
								if (m > 0) {
									obSelectionStrategy.setExpression(expression);
								}
							}
						}
						AttributeScalar attributeScalar = null;
						ReferenceInit referenceInit = null;
						int l = 0;
						for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
							if (classWithElements.contains(feature.getName())) {
								List<Object> lob = featureWithValues.get(l);
								l++;
								for (Object ob : lob) {
									if (feature instanceof EAttribute) {
										EAttribute attribute = (EAttribute) feature;
										attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
										attributeScalar.getAttribute().add(attribute);
										Operator operator = Operator.EQUALS;
										AttributeType attributeType = null;
										if (attribute.getEType().getName().equals("EString")) {
											SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
											stringType.setOperator(operator);
											stringType.setValue((String) ob);
											attributeType = stringType;
										}
										if (attribute.getEType().getName().equals("EInt")) {
											SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
											integerType.setOperator(operator);
											integerType.setValue(Integer.valueOf((String) ob));
											attributeType = integerType;
										}
										if (attribute.getEType().getName().equals("EBoolean")) {
											SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
											booleanType.setOperator(operator);
											booleanType.setValue((boolean) ob);
											attributeType = booleanType;
										}
										if (attribute.getEType().getName().equals("EDouble")) {
											SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
											doubleType.setOperator(operator);
											doubleType.setValue(Double.valueOf((String) ob));
											attributeType = doubleType;
										}
										attributeScalar.setValue(attributeType);
									}
									if (feature instanceof EReference) {
										EReference reference = (EReference) feature;
										referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
										ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
										referenceStrategy.setType((EClass) reference.getEType());
										referenceInit.setObject(referenceStrategy);
										referenceInit.getReference().add(reference);
									}
									if (attributeScalar != null) {
										cloneObjectMutator.getAttributes().add(attributeScalar);
									}
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
							retypeObjectMutator.getTypes().addAll(classesToAdd);
							Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
							int k = 0;
							int m = 0;
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								if (classWhereElements.contains(feature.getName())) {
									List<Object> lob = featureWhereValues.get(k);
									k++;
									AttributeEvaluation attributeEvaluation = null;
									ReferenceEvaluation referenceEvaluation = null;
									for (Object ob : lob) {
										m++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (m == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (m > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (m == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (m > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
										}
									}
									retypeObjectMutator.setName("p");
									if (m > 0) {
										obSelectionStrategy.setExpression(expression);
									}
								}
							}
							AttributeScalar attributeScalar = null;
							ReferenceInit referenceInit = null;
							int l = 0;
							for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
								if (classWithElements.contains(feature.getName())) {
									List<Object> lob = featureWithValues.get(l);
									l++;
									for (Object ob : lob) {
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeScalar.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											referenceStrategy.setType((EClass) reference.getEType());
											referenceInit.setObject(referenceStrategy);
											referenceInit.getReference().add(reference);
										}
										if (attributeScalar != null) {
											retypeObjectMutator.getAttributes().add(attributeScalar);
										}
										if (referenceInit != null) {
											retypeObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
							}
							mutator.add(retypeObjectMutator);
						}
					}
					if (mutator.size() > 0) {
						commands.addAll(mutator);
					}
					if (commands.size() > 0) {
						block.getCommands().addAll(commands);
						blocks.add(block);
					}
				}
				j++;
			}

			mutatorEnvironment.getBlocks().addAll(blocks);
			mutatorEnvironment.getCommands().clear();
			
			String mutatorCode = WodelUtils.deserialize("file:/" + wodelProgramPath, mutatorEnvironment);

			int index = 0;
			String mutatorFileName = wodelProgramPath.replace(".mutator", "_auto" + index + ".mutator");
			File mutatorFile = new File(mutatorFileName);
			while (mutatorFile.exists() && mutatorFile.isFile()) {
				index++;
				mutatorFileName = wodelProgramPath.replace(".mutator", "_auto" + index + ".mutator");
				mutatorFile = new File(mutatorFileName);
			}
			FileWriter fileWriter = new FileWriter(mutatorFileName);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(mutatorCode);
			writer.close();
			fileWriter.close();
		}
	}
}
