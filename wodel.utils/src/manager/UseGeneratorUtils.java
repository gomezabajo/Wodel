package manager;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.MetaModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import manager.ModelManager;
import manager.MutatorUtils;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeType;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.Block;
import mutatorenvironment.BooleanType;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.DoubleType;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.IntegerType;
import mutatorenvironment.ListStringType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.Operator;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.StringType;

/**
 * @author Pablo Gomez-Abajo
 * 
 * UseGeneratorUtils
 * 
 * Utils for generate the .use and .properties files
 * 
 */
public class UseGeneratorUtils {

		
		public static String[] useWords = {
				"model",
				"constraints",
				"enum",
				"abstract",
				"class",
				"attributes",
				"operations",
				"end",
				"association",
				"composition",
				"aggregation",
				"between",
				"role",
				"ordered",
				"associationclass",
				"context",
				"inv",
				"pre",
				"post",
				"Set",
				"Bag",
				"Sequence",
				"Integer",
				"Real",
				"Boolean",
				"String",
				"from",
				"min",
				"max",
				"states",
				"transitions",
				"if",
				"else",
				"for",
				"derived" };
		
		private static class Constraint {
			String name = "";
			String text = "";
			HashMap<String, Integer> sizeByBlock = new HashMap<String, Integer>();
			String type = "";
			List<String> variables = new ArrayList<String>();
			String className = "";
			boolean list = false;
			boolean nested = false;
			List<String> clauses = new ArrayList<String>();
			
			public void print() {
				if (this.type.equals("size")) {
					System.out.println(this.text + " > " + maxSize(this));
				}
				else {
					System.out.println(this.text);
				}
			}
		}
		
		private static HashMap<URI, Boolean> closures = new HashMap<URI, Boolean>();
		
		private static String dummyClassName = "Dummy";
		
		private static MutatorDependencies mutatorDependencies;
		
		private static HashMap<String, HashMap<String, List<Constraint>>> mutConstraint = new HashMap<String, HashMap<String, List<Constraint>>>();

		/**
		 * Returns unique USE name
		 * @param newName
		 * @param names
		 * @param n
		 * @return
		 */
		private static String getUniqueName(String newName, HashMap<URI, String> names, int n) {
		   	String returnName = newName;
		   	HashMap<URI, String> nextNames = new HashMap<URI, String>();
		   	if (names.size() > 0) {
		   		if (names.containsValue(newName)) {
		   			returnName = newName + n;
		   			for (URI uri : names.keySet()) {
		   				if (!names.get(uri).equals(newName)) {
		   					nextNames.put(uri, names.get(uri));
		   				}
		   			}
		   			returnName = getUniqueName(returnName, nextNames, n + 1);
		   		}
		   	}
		   	return returnName;
		}
		
		/**
		 * Returns max size for the given constraint
		 * @param constraint
		 * @return
		 */
		private static int maxSize(Constraint constraint) {
			int max = 0;
			for (String blockName : constraint.sizeByBlock.keySet()) {
				if (constraint.sizeByBlock.get(blockName) > max) {
					max = constraint.sizeByBlock.get(blockName);
				}
			}
			return max;
		}

		/**
		 * Gets the constraint from the given list
		 * @param constraints
		 * @param constraint
		 * @return
		 */
		private static Constraint getConstraint(List<Constraint> constraints, Constraint constraint) {
			if (constraint != null && !constraint.text.equals("")) {
				for (Constraint c : constraints) {
					if (c.type.equals(constraint.type)) {
						if (c.text.equals(constraint.text)) {
							return c;
						}
					}
				}
			}
			return null;
		}
		
		/**
		 * Counts the ending parentheses
		 * @param constraint
		 * @return
		 */
		private static int countEndParentheses(Constraint constraint) {
			int count = 0;
			if (constraint != null && !constraint.text.equals("")) {
				String text = constraint.text;
				int position = text.lastIndexOf(")");
				while (position == text.length() - 1) {
					count ++;
					text = text.substring(0, position);
					position = text.lastIndexOf(")");
				}
			}
			return count;
		}
		
		/**
		 * Counts the necessary ending parentheses
		 * @param clause
		 * @return
		 */
		private static int countRemainingParentheses(String clause) {
			int close = 0;
			int open = 0;
			if (clause != null && !clause.equals("")) {
				String text = clause;
				int position = text.lastIndexOf(")");
				while (position > 0) {
					close ++;
					text = text.substring(0, position);
					position = text.lastIndexOf(")");
				}
				text = clause;
				position = text.lastIndexOf("(");
				while (position > 0) {
					open ++;
					text = text.substring(0, position);
					position = text.lastIndexOf("(");
				}
			}
			return open - close;
		}

		/**
		 * Adds the constraint to the given list
		 * @param constraints
		 * @param constraint
		 */
		private static void addConstraint(List<Constraint> constraints, Constraint constraint) {
			boolean found = false;
			if (constraint != null && constraint.text.length() > 0) {
				for (Constraint c : constraints) {
					if (c.text.equals(constraint.text)) {
						found = true;
						break;
					}
				}
			}
			if (found == false && constraint != null && constraint.text.length() > 0) {
				constraints.add(constraint);
			}
		}

		/**
		 * Gets the size constraints
		 * @param rootClass
		 * @param eClass
		 * @param packages
		 * @param constraints
		 * @param inc
		 * @param ref
		 * @param blockName
		 * @param mutName
		 * @param isContainer
		 * @param classNames
		 * @param recursion
		 */
		private static void getSizeConstraints(EClass rootClass, EClass eClass, List<EPackage> packages, List<Constraint> constraints, boolean inc, EReference ref, String blockName, String mutName, boolean isContainer, HashMap<URI, String> classNames, List<EClass> recursion) {
			try {
				if (classNames.get(EcoreUtil.getURI(eClass)) != null) {
					String className = classNames.get(EcoreUtil.getURI(eClass));
					Constraint constraint = new Constraint();
					constraint.text = encodeWord(className) + ".allInstances()->size()";
					constraint.name = mutName; 
					constraint.type = "size";
					constraint.className = className;
					if (!eClass.getName().equals(rootClass.getName())) {
						boolean b = false;
						for (Constraint c : constraints) {
							if (constraint.text.equals(c.text)) {
								b = true;
								constraint = c;
							}
						}
						if (b == false) {
							boolean containerInc = false;
							if (inc == true) {
								if (constraint.sizeByBlock.get(blockName) != null) {
									if (isContainer == false) {
										constraint.sizeByBlock.put(blockName, constraint.sizeByBlock.get(blockName) + 1);
									}
								}
								else {
									if (isContainer == false) {
										constraint.sizeByBlock.put(blockName, 1);
									}
								}
							}
							else {
								constraint.sizeByBlock.put(blockName, 0);
							}
							if (ref != null) {
								if (ref.getUpperBound() != -1 && constraint.sizeByBlock.get(blockName) > ref.getUpperBound()) {
									containerInc = true;
								}
							}
							addConstraint(constraints, constraint);
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eClass));
							if (containers.size() == 1) {
								EClass container = (EClass) containers.get(0);
								EReference contRef = ModelManager.getContainingReference(container, eClass);
								boolean previous = false;
								for (EClass rec : recursion) {
									if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(container))) {
										previous = true;
										break;
									}
								}
								if (previous == false) {
									recursion.add(container);
									getSizeConstraints(rootClass, container, packages, constraints, containerInc, contRef, blockName, "", true, classNames, recursion);
								}
							}
						}
						if (b == true) {
							boolean containerInc = false;
							if (constraint.sizeByBlock.get(blockName) == null) {
								constraint.sizeByBlock.put(blockName, 0);
							}
							else {
								if (isContainer == false) {
									constraint.sizeByBlock.put(blockName, constraint.sizeByBlock.get(blockName) + 1);
								}
							}
							if (ref != null) {
								if (ref.getUpperBound() != -1 && constraint.sizeByBlock.get(blockName) > ref.getUpperBound()) {
									containerInc = true;
								}
							}
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eClass));
							if (containers.size() == 1) {
								EClass container = (EClass) containers.get(0);
								EReference contRef = ModelManager.getContainingReference(container, eClass);
								boolean previous = false;
								for (EClass rec : recursion) {
									if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(container))) {
										previous = true;
										break;
									}
								}
								if (previous == false) {
									recursion.add(container);
									getSizeConstraints(rootClass, container, packages, constraints, containerInc, contRef, blockName, "", true, classNames, recursion);
								}
							}
						}
					}
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * Gets the type of the given ObSelectionStrategy object
		 * @param object
		 * @return
		 */
		private static EClass getClassType(ObSelectionStrategy object) {
			EClass eClass = null;
			if (object != null) {
	       		if (object instanceof RandomTypeSelection) {
	   				eClass = object.getType();
	   			}
	   			if (object instanceof CompleteTypeSelection) {
	       			eClass = object.getType();
	       		}
				if (object instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) object;
					if (selection.getObjSel() instanceof CreateObjectMutator) {
						eClass = selection.getObjSel().getType();
					}
					if (selection.getObjSel() instanceof SelectObjectMutator) {
						eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
					}
					if (selection.getObjSel() instanceof SelectSampleMutator) {
						eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
					}
					if (selection.getObjSel() instanceof CloneObjectMutator) {
						eClass = selection.getObjSel().getType();
					}
					if (selection.getObjSel() instanceof RetypeObjectMutator) {
						eClass = selection.getObjSel().getType();
					}
					if (selection.getObjSel() instanceof ModifyInformationMutator) {
						ModifyInformationMutator modifyMutator = (ModifyInformationMutator) selection.getObjSel();
						if (modifyMutator.getObject() instanceof RandomTypeSelection) {
							eClass = modifyMutator.getObject().getType();
						}
						if (modifyMutator.getObject() instanceof CompleteTypeSelection) {
							eClass = modifyMutator.getObject().getType();
						}
						if (modifyMutator.getObject() instanceof SpecificObjectSelection) {
							eClass = getClassType(modifyMutator.getObject());
						}
						if (modifyMutator.getObject() instanceof SpecificClosureSelection) {
							eClass = getClassType(modifyMutator.getObject());						
						}
					}
				}
	   			if (object instanceof SpecificClosureSelection) {
	    	   		SpecificClosureSelection selection = (SpecificClosureSelection) object;
		     		if (selection.getObjSel() instanceof CreateObjectMutator) {
	       				eClass = selection.getObjSel().getType();
	       			}
	       			if (selection.getObjSel() instanceof SelectObjectMutator) {
	       				eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
	       			}
	       			if (selection.getObjSel() instanceof SelectSampleMutator) {
						eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
					}
	       			if (selection.getObjSel() instanceof CloneObjectMutator) {
	       				eClass = selection.getObjSel().getType();
	    	   		}
	    	   		if (selection.getObjSel() instanceof ModifyInformationMutator) {
						eClass = selection.getObjSel().getType();
					}
					if (selection.getObjSel() instanceof RetypeObjectMutator) {
						eClass = selection.getObjSel().getType();
					}
		       	}
	       	}
			return eClass;
		}

		/**
		 * Stores mutator name with its corresponding constraints
		 * @param constraint
		 * @param blockName
		 * @param mutName
		 */
		private static void storeMutatorName(Constraint constraint, String blockName, String mutName) {
			HashMap<String, List<Constraint>> nameConstraint = null;
			if (mutConstraint.get(blockName) == null) {
				nameConstraint = new HashMap<String, List<Constraint>>();
			}
			else {
				nameConstraint = mutConstraint.get(blockName);
			}
			List<Constraint> constraints = null;
			if (nameConstraint.get(mutName) == null) {
				constraints = new ArrayList<Constraint>();
			}
			else {
				constraints = nameConstraint.get(mutName);
			}
			addConstraint(constraints, constraint);
			nameConstraint.put(mutName, constraints);
			mutConstraint.put(blockName, nameConstraint);
		}
		
		/**
		 * Gets USE references
		 * @param packages
		 * @param classNames
		 * @return
		 */
		public static HashMap<URI, HashMap<URI, Entry<String, String>>> getUseReferences(List<EPackage> packages, HashMap<URI, String> classNames) {
			HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences = new HashMap<URI, HashMap<URI, Entry<String, String>>>();
			HashMap<String, Integer> associationNames = new HashMap<String, Integer>();
			HashMap<String, Integer> roleNames = new HashMap<String, Integer>();
			for (EClass eClass : ModelManager.getEClasses(packages)) {
				String clName = classNames.get(EcoreUtil.getURI(eClass));
				List<EReference> refs = eClass.getEReferences();
				if (refs.size() > 0) {
					for (EReference ref : refs) {
						String refETypeName = classNames.get(EcoreUtil.getURI(ref.getEType()));
						String associationName = clName + "XxxX" + refETypeName;
						if (associationNames.get(associationName) != null) {
							associationNames.put(associationName, associationNames.get(associationName) + 1);
							associationName += associationNames.get(associationName);
						}
						else {
							associationNames.put(associationName, 0);
						}
						HashMap<URI, Entry<String, String>> uriUseReference = null;
						if (useReferences.get(EcoreUtil.getURI(eClass)) != null) {
							uriUseReference = useReferences.get(EcoreUtil.getURI(eClass));
						}
						else {
							uriUseReference = new HashMap<URI, Entry<String, String>>();
						}
						String srcRoleName = clName.toLowerCase() + "xxxx" + ref.getName();
						if (roleNames.get(srcRoleName) != null) {
							roleNames.put(srcRoleName, roleNames.get(srcRoleName) + 1);
							srcRoleName += roleNames.get(srcRoleName);
						}
						else {
							roleNames.put(srcRoleName, 0);
						}
						String tarRoleName = ref.getName();
						if (roleNames.get(tarRoleName) != null) {
							roleNames.put(tarRoleName, roleNames.get(tarRoleName) + 1);
							tarRoleName += roleNames.get(tarRoleName);
						}
						else {
							roleNames.put(tarRoleName, 0);
						}
						Entry<String, String> useReference = new AbstractMap.SimpleEntry<String, String>(encodeWord(srcRoleName), encodeWord(tarRoleName));
						uriUseReference.put(EcoreUtil.getURI(ref), useReference);
						useReferences.put(EcoreUtil.getURI(eClass), uriUseReference);
					}
				}
			}
			return useReferences;
		}

		/**
		 * Gets target USE references
		 * @param ref
		 * @param uriUseReferences
		 * @return
		 */
		public static String getTarUseReference(EReference ref, HashMap<URI, HashMap<URI, Entry<String, String>>> uriUseReferences) {
			String refName = "";
			if (ref != null && ref.eContainer() != null) {
				EClass container = (EClass) ref.eContainer();
				if (uriUseReferences.get(EcoreUtil.getURI(container)) != null && uriUseReferences.get(EcoreUtil.getURI(container)).get(EcoreUtil.getURI(ref)) != null) {
					refName = uriUseReferences.get(EcoreUtil.getURI(container)).get(EcoreUtil.getURI(ref)).getValue();
				}
				else {
					refName = ref.getName();
				}
				refName = encodeWord(refName);
			}
			return refName;
		}
		
		/**
		 * Gets source USE references
		 * @param ref
		 * @param uriUseReferences
		 * @return
		 */
		public static String getSrcUseReference(EReference ref, HashMap<URI, HashMap<URI, Entry<String, String>>> uriUseReferences) {
			String refName = "";
			if (ref != null && ref.eContainer() != null) {
				EClass container = (EClass) ref.eContainer();
				if (uriUseReferences.get(EcoreUtil.getURI(container)) != null && uriUseReferences.get(EcoreUtil.getURI(container)).get(EcoreUtil.getURI(ref)) != null) {
					refName = uriUseReferences.get(EcoreUtil.getURI(container)).get(EcoreUtil.getURI(ref)).getKey();
				}
				else {
					refName = ref.getName();
				}
				refName = encodeWord(refName);
			}
			return refName;
		}

		/**
		 * Encodes given word to USE word
		 * @param word
		 * @return
		 */
		public static String encodeWord(String word) {
			if (Arrays.asList(useWords).contains(word)) {
				return "xxxx" + word;
			}
			return word;
		}

		/**
		 * Decodes given USE word
		 * @param word
		 * @return
		 */
		public static String decodeWord(String word) {
			String decodedWord = word;
			if (word.startsWith("xxxx")) {
				if (Arrays.asList(useWords).contains(word.substring(4, word.length()))) {
					decodedWord = word.substring(4, word.length());
				}
			}
			return decodedWord;
		}

		/**
		 * Ensures every object has a container
		 * @param packages
		 * @param classes
		 * @param useReferences
		 * @param classNames
		 * @return
		 */
		public static String ensureContainer(List<EPackage> packages, List<EClass> classes, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames) {
			String constraints = "";
			for (EClass eClass : classes) {
				if (!eClass.isAbstract() && classNames.get(EcoreUtil.getURI(eClass)) != null) {
					String className = classNames.get(EcoreUtil.getURI(eClass));
					List<EReference> references = new ArrayList<EReference>();
					List<EClassifier> classifiers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eClass));
					if (classifiers.size() > 1) {
						for (EClassifier classifier : classifiers) {
							if (classifier instanceof EClass) {
								EClass container = (EClass) classifier;
								for (EReference ref : container.getEAllReferences()) {
									if (ref.isContainment()	&&
										ref.getEReferenceType().isSuperTypeOf(eClass)	&&
										classNames.get(EcoreUtil.getURI(ref.getEContainingClass())) != null &&
										!references.contains(ref)) {
										references.add(ref);
									}
								}
							}
						}
					}
					if (references.size() > 1) {
						constraints += "\n\ncontext " + encodeWord(className) + " inv ensure_container:\n\t(";
						for (EReference ref : references) {
							if (classNames.get(EcoreUtil.getURI(ref.getEContainingClass())) != null) {
								for (EReference reff : references) {
									if (EcoreUtil.equals(reff, ref)) {
										constraints += "not " + getSrcUseReference(reff, useReferences) + ".oclIsUndefined() and\n\t";
									}
									else {
										constraints += getSrcUseReference(reff, useReferences) + ".oclIsUndefined() and\n\t";
									}
								}
								constraints = constraints.substring(0,
										constraints.lastIndexOf(" and")) + ") or \n\t(";
							}
						}
						constraints = constraints.substring(0,
							constraints.lastIndexOf(" or")) + "\n";
					}
				}
			}
			return constraints;
		}
		
		// constraint: an object cannot be contained in two containers
		// [NOTE: we do this because the USE Validator does not take into account the semantics of composition]
		public static String compositionConstraint (List<EPackage> packages, List<EReference> references, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames) {
			String constraints = "";

			// obtain the containment references that can contain each class
			Hashtable<EClass,List<EReference>> containers = new Hashtable<EClass,List<EReference>>();
			for (EReference ref : references) {
				if (ref.isContainment()) {
					EClass eClass = ref. getEReferenceType();
					List<EClass> types = new ArrayList<EClass>();
	                types.add(eClass);
					types.addAll(ModelManager.getESubClasses(packages, eClass));
					for (EClass type : types) {
						if (!type.isAbstract()) {
							if (!containers.containsKey(type))
								containers.put(type, new ArrayList<EReference>());
							containers.get(type).add(ref);
						}
					}
				}
				if (ref.getEOpposite()!=null &&
						ref.getEOpposite().isContainment()) {
					EClass eClass = ref.getEOpposite().getEReferenceType();
					List<EClass> types = new ArrayList<EClass>();
	                types.add(eClass);
					types.addAll(ModelManager.getESubClasses(packages, eClass));
					for (EClass type : types) {
						if (!type.isAbstract()) {
							if (!containers.containsKey(type))
								containers.put(type, new ArrayList<EReference>());
							containers.get(type).add(ref.getEOpposite());
						}
					}
				}
			}

			// if a class can potentially be in more than two containers, add a constraint
			for (Entry<EClass,List<EReference>> entry : 
				containers.entrySet()) {
				if (entry.getValue().size()>1) {
					String classname = classNames.get(EcoreUtil.getURI(entry.getKey()));
					constraints += "\n\ncontext " + encodeWord(classname) + " inv single_container:\n";
					for (EReference ref : entry.getValue()) {
						String containingClassName = classNames.get(EcoreUtil.getURI(ref.getEContainingClass()));
						constraints += "\t" +
								encodeWord(containingClassName) + ".allInstances()->collect(o | o." 
								+ getTarUseReference(ref, useReferences) + ")->count(self) +\n";
					}
					constraints = constraints.substring(0,
							constraints.lastIndexOf("+")) + "<= 1";
					
				}
			}
			if (!constraints.isEmpty()) constraints += "\n";

			return constraints;
		}
		
		// constraint: an object cannot be contained itself through a composition relation, directly or indirectly
		// [NOTE: we do this because the USE Validator does not take into account the semantics of composition]
		public static String compositionConstraint (EReference ref, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames) {
			String constraint = "";

			if (ref!=null && ref.isContainment() &&
					(ref.getEContainingClass()==ref.getEReferenceType() ||
					ref.getEContainingClass().getESuperTypes().contains(ref.getEReferenceType())))
			{
				List<String> terms = new ArrayList<String>();
				int      num_terms = 5;
				if (classNames.get(EcoreUtil.getURI(ref.getEContainingClass())) != null) {
					String className = classNames.get(EcoreUtil.getURI(ref.getEContainingClass()));
					String   type      = encodeWord(className);
					String   setOpen   = ref.getUpperBound()==1? "Set{":""; //add monovalued features to a set
					String   setClose  = ref.getUpperBound()==1? "}"   :"";
					for (int term=1; term<=num_terms; term++)    {
						String expression = "";
						for (int index=1; index<=term; index++) {
							if (index==1) {
								expression = setOpen + (index<term? 
										getTarUseReference(ref, useReferences) + index + ".oclAsType(" + type + ")." : "self.") +
										getTarUseReference(ref, useReferences) + setClose + "->includes(self)";
							}
							else {
								String select1 = "", select2 = "";
								if (index>1) {
									select1 = setOpen + (index<term? 
											getTarUseReference(ref, useReferences) + index + ".oclAsType(" + type + ")." : "self.") +
											getTarUseReference(ref, useReferences) + setClose + "->exists(" + getTarUseReference(ref, useReferences) + (index-1) + " |\n";
									select2 = ")";
								}
								expression = select1 +
										"if " + getTarUseReference(ref, useReferences) + (index-1) + ".oclIsKindOf(" + type + ") then\n" +
										"\t" + expression + "\n" +
										"\t else false endif" +
										select2;
							}
						}
						terms.add("not " + expression);
					}

					constraint = "\n\ncontext " +
							encodeWord(className) + " inv non_contains_itself_" +
							getTarUseReference(ref, useReferences) + ":\n";
					for (String term : terms) constraint += term + "\nand\n";
					constraint = constraint.substring(0,
							constraint.lastIndexOf("and")) + "\n";
				}
			}

			return constraint;
		}
		
		/**
		 * Unites the given constraint with the given list
		 * @param constraints
		 * @param constraint
		 * @return
		 */
		private static Constraint unite(List<Constraint> constraints, Constraint constraint) {
	 		if (constraint != null && !constraint.text.equals("")) {
				for (Constraint c : constraints) {
					if (c.type.equals("exists") && c.list == true && c.className.equals(constraint.className) && !c.text.equals(constraint.text)) {
						for (String clause : c.clauses) {
							if (clause.equals(constraint.text)) {
								return c;
							}
						}
						String[] variables = new String[constraint.variables.size() + c.variables.size()];
						Hashtable<String, String> constraintvars = new Hashtable<String, String>();
						int i = 0;
						for (String v : constraint.variables) {
							variables[i] = v.substring(0, 1) + i;
							constraintvars.put(v, variables[i]);
							i++;
						}
						Hashtable<String, String> cvars = new Hashtable<String, String>();
						for (String v : c.variables) {
							variables[i] = v.substring(0, 1) + i;
							cvars.put(v, variables[i]);
							i++;
						}
						String clause = c.className + ".allInstances()->exists(";
						for (String v : variables) {
							clause += v + ", ";
						}
						clause = clause.substring(0, clause.lastIndexOf(",")) + " | ";
						String v1 = variables[0];
						for (String v2 : Arrays.asList(variables).subList(1, variables.length)) {
							clause += v1 + " <> " + v2 + " and ";
						}
						String clauseConstraint = constraint.text.substring(constraint.text.indexOf("|") + 2, constraint.text.lastIndexOf(")"));
						for (String v : constraintvars.keySet()) {
							clauseConstraint = clauseConstraint.replaceAll(v + "\\.", constraintvars.get(v) + ".");
						}
						String clauseC = c.text.substring(c.text.indexOf("|") + 2, c.text.lastIndexOf(")"));
						for (String v : cvars.keySet()) {
							clauseC = clauseC.replaceAll(v + "\\.", cvars.get(v) + ".");
						}
						clause += "(" + clauseConstraint + ") and (" + clauseC + "))";
						constraints.remove(c);
						Constraint newConstraint = new Constraint();
						newConstraint.variables.addAll(Arrays.asList(variables));
						newConstraint.list = true;
						newConstraint.type = "exists";
						newConstraint.className = c.className;
						newConstraint.text = clause;
						newConstraint.clauses.add(constraint.text);
						newConstraint.clauses.add(c.text);
						return newConstraint;
					}
				}
			}
	 		return constraint;
		}

		/**
		 * Subsume the given constraint with the given list
		 * @param constraints
		 * @param constraint
		 */
		private static void subsume(List<Constraint> constraints, Constraint constraint) {
	 		if (constraint != null && !constraint.text.equals("")) {
				for (Constraint c : constraints) {
					if (c.nested == false) {
						if (c.type.equals("exists")) {
							String clause1 = c.text.substring(c.text.indexOf("exists(") + "exists(".length(), c.text.lastIndexOf(")"));
							if (c.variables != null && c.variables.size() > 1 && constraint.variables != null && constraint.variables.size() > 1) {
								String v1 = c.variables.get(0);
								String v2 = c.variables.get(1);
								String clause2 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
								while (clause1.endsWith(")")) {
									clause1 = clause1.substring(0, clause1.lastIndexOf(")"));
								}
								String v3 = constraint.variables.get(1);
								String newClause = clause2.replace("| ", "| " + clause1.substring(clause1.indexOf("|") + 1, clause1.length()) + " and ");
								newClause = newClause.replace(newClause.substring(0, newClause.indexOf("|") + 1), clause1.substring(0, clause1.indexOf("|") + 1));
								newClause = newClause.replace(v3, v2);
								constraint.variables.clear();
								constraint.variables.add(v1);
								constraint.variables.add(v2);
								constraint.text = c.text.replace(clause1, newClause);
								constraints.remove(c);
								addConstraint(constraints, constraint);
								return;
							}
						}
					}
					if (c.nested == true) {
						if (c.type.equals("exists")) {
							String clause1 = c.text.substring(c.text.indexOf("exists(") + "exists(".length(), c.text.lastIndexOf(")"));
							if (c.variables != null && c.variables.size() > 1 && constraint.variables != null && constraint.variables.size() > 1) {
								String v1 = c.variables.get(0);
								String v2 = c.variables.get(1);
								String clause2 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
								String tmpClause = clause1;
								while (clause1.endsWith(")")) {
									clause1 = clause1.substring(0, clause1.lastIndexOf(")"));
								}
								String newClause = clause1 + " and " + clause2.substring(clause2.lastIndexOf("|") + 1, clause2.length());
								constraint.variables.clear();
								constraint.variables.add(v1);
								constraint.variables.add(v2);
								constraint.text = c.text.replace(tmpClause, newClause);
								constraints.remove(c);
								addConstraint(constraints, constraint);
								return;
							}
						}
					}
				}
			}
		}
		
		/**
		 * Joins the given constraint with the given list
		 * @param constraints
		 * @param constraint
		 * @param className
		 * @param mutatorName
		 * @return
		 */
		private static Constraint join(List<Constraint> constraints, Constraint constraint, String className, String mutatorName) {
			if (constraint != null && !constraint.text.equals("")) {
				Constraint c = null; 
				for (Constraint cnst : constraints) {
					if (cnst.type != null && cnst.type.equals("exists") && cnst.className != null && cnst.className.equals(className) && cnst.name != null && cnst.name.length() > 0 && cnst.name.equals(mutatorName)) {
						c = cnst;
						break;
					}
				}
				if (c == null) {
					for (Constraint cnst : constraints) {
						if (cnst.type.equals("exists") && cnst.className.equals(className)) {
							c = cnst;
							break;
						}
					}
				}
				if (c != null) {
					if (c.variables != null && c.variables.size() > 1 && constraint.variables != null && constraint.variables.size() > 1) {
						String clause1 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
						String v1 = c.variables.get(0);
						String v2 = c.variables.get(1);
						String v3 = constraint.variables.get(0);
						String v4 = constraint.variables.get(1);
						String v5 = v3.substring(0, 1) + (Integer.parseInt(v4.substring(1, v4.length())) + 1);
						String clause2 = clause1.replace(v3, v5).replace(v4, v2);
						String newClause = constraint.text.substring(0, constraint.text.indexOf("| ") + "| ".length()) + c.text.substring(0, c.text.length() - countEndParentheses(c)) + " and " + clause1.substring(clause1.indexOf("| ") + "| ".length(), clause1.length()) + " and " + clause2.substring(clause2.indexOf("| ") + "| ".length(), clause2.length());
						int countRemainingParentheses = countRemainingParentheses(newClause);
						for (int i = 0; i < countRemainingParentheses; i++) {
							newClause += ")";
						}
						newClause = newClause.replace(v4, v1);
						String vars = clause1.substring(0, clause1.indexOf(" |") + " |".length());
						String newVars = vars.replace(" |", ", " + v5 + " |");
						constraint.text = newClause.replace(vars, newVars);
						constraint.variables.clear();
						constraint.variables.add(v3);
						constraint.variables.add(v5);
						constraint.variables.add(v1);
						constraint.variables.add(v2);
						return constraint;
					}
					if (c.variables != null && c.variables.size() > 0 && constraint.variables != null && constraint.variables.size() > 1) {
						String clause1 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
						String v1 = c.variables.get(0);
						String v2 = constraint.variables.get(0);
						String v3 = constraint.variables.get(1);
						String newClause = constraint.text.substring(0, constraint.text.indexOf("| ") + "| ".length()) + c.text.substring(0, c.text.lastIndexOf(")")) + " and " + clause1.substring(clause1.indexOf("| ") + "| ".length(), clause1.length()) + "))";
						newClause = newClause.replace(v3, v1);
						constraint.text = newClause;
						constraint.variables.clear();
						constraint.variables.add(v1);
						constraint.variables.add(v2);
						return constraint;
					}
				}
			}
			return constraint;
		}
		
		/**
		 * Includes the given constraint in the given list
		 * @param constraints
		 * @param constraint
		 */
		private static void include(List<Constraint> constraints, Constraint constraint) {
			List<Constraint> tmpConstraints = new ArrayList<Constraint>();
			tmpConstraints.addAll(constraints);
			for (Constraint c : tmpConstraints) {
				String clause1 = c.text.substring(c.text.indexOf("exists(") + "exists(".length(), c.text.lastIndexOf(")"));
				if (c.variables != null && c.variables.size() > 1 && constraint.variables != null && constraint.variables.size() > 1) {
					String v2 = c.variables.get(1);
					String v3 = constraint.variables.get(1);
					String clause2 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
					String newClause = clause2.replace("| ", "| " + clause1.substring(clause1.indexOf("|") + 1, clause1.length()) + " and ");
					newClause = newClause.replace(v2, v3);
					
					constraint.text = c.text.replace(clause1, newClause);
					constraints.remove(c);
				}
			}
			addConstraint(constraints, constraint);
		}
		
		/**
		 * Compiles the attribute type expression to OCL
		 * @param attev
		 * @param constraints
		 * @param attConstraint
		 * @param className
		 */
		private static void compileAttributeType(AttributeEvaluation attev, List<Constraint> constraints, Constraint attConstraint, String className) {
			String operator = "";
			if ((((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.EQUALS.getLiteral()))) {
				operator = "=";
			}
			if ((((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral()))) {
				operator = "<>";
			}
			if (attev.getValue() instanceof StringType) {
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + encodeWord(attev.getName().getName()) + " " + operator + " '" + ((SpecificStringType) attev.getValue()).getValue() + "')";
				attConstraint.variables.add(className.substring(0, 1).toLowerCase());
			}
			if (attev.getValue() instanceof DoubleType) {
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + ((SpecificDoubleType) attev.getValue()).getValue() + ")";
				attConstraint.variables.add(className.substring(0, 1).toLowerCase());  
			}
			if (attev.getValue() instanceof BooleanType) {
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + ((SpecificBooleanType) attev.getValue()).isValue() + ")";
				attConstraint.variables.add(className.substring(0, 1).toLowerCase());  
			}
			if (attev.getValue() instanceof IntegerType) {
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + ((SpecificIntegerType) attev.getValue()).getValue() + ")";
				attConstraint.variables.add(className.substring(0, 1).toLowerCase());  
			}
			if (attev.getValue() instanceof ListStringType) {
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | ";
				ListStringType listStringType = (ListStringType) attev.getValue();
				for (String value : listStringType.getValue()) {
					attConstraint.text += className.substring(0, 1).toLowerCase() + "." + encodeWord(attev.getName().getName()) + " = '" + value + "' or ";
				}
				attConstraint.text = attConstraint.text.substring(0, attConstraint.text.lastIndexOf(" or ")) + ")";
				attConstraint.variables.add(className.substring(0, 1).toLowerCase());
				attConstraint.list = true;
				attConstraint.clauses.add(attConstraint.text);
				attConstraint = unite(constraints, attConstraint);
			}
		}
		
		/**
		 * Compiles the object attribute type expression to OCL
		 * @param model
		 * @param attev
		 * @param eClass
		 * @param attConstraint
		 * @param className
		 */
		private static void compileObjectAttributeType(Resource model, AttributeEvaluation attev, EClass eClass, Constraint attConstraint, String className) {
			String operator = "";
			ObjectAttributeType objectAttributeType = (ObjectAttributeType) attev.getValue();
			if (objectAttributeType.getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
				operator = "=";
			}
			if (objectAttributeType.getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
				operator = "<>";
			}
			EClass type = MutatorUtils.getMutatorType(model, objectAttributeType.getObjSel().getName());
			if (EcoreUtil.equals(type, eClass)) {
				String v1 = className.substring(0, 1).toLowerCase() + "0";
				String v2 = className.substring(0, 1).toLowerCase() + "1";
				attConstraint.variables.add(v1);
				attConstraint.variables.add(v2);
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + ")";  
			}
			else {
				String v1 = className.substring(0, 1).toLowerCase() + "0";
				String v2 = type.getName().substring(0, 1).toLowerCase() + "1";
				attConstraint.variables.add(v1);
				attConstraint.variables.add(v2);
				attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + encodeWord(type.getName()) + ".allInstances()->exists(" + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + "))";
			}		
		}
		
		/**
		 * Compiles first attribute expression to OCL
		 * @param attev
		 * @param eClass
		 * @param constraints
		 * @param expConstraints
		 * @param mutName
		 * @param className
		 */
		private static void compileAttributeExpression(Resource model, AttributeEvaluation attev, EClass eClass, List<Constraint> constraints, List<Constraint> expConstraints, String mutName, String className, boolean isFirst) {
			Constraint attConstraint = new Constraint();
			attConstraint.name = mutName;
			attConstraint.type = "exists";
			attConstraint.className = className;
			if (attev.getValue() instanceof AttributeType) {
				compileAttributeType(attev, constraints, attConstraint, className);
			}
			if (attev.getValue() instanceof ObjectAttributeType) {
				compileObjectAttributeType(model, attev, eClass, attConstraint, className);
				if (isFirst == false) {
					subsume(expConstraints, attConstraint);
				}
			}
			if (getConstraint(constraints, attConstraint) == null) {
				addConstraint(expConstraints, attConstraint);
			}
		}
		
		/**
		 * Compiles the refered constraint to OCL
		 * @param constraints
		 * @param expConstraints
		 * @param refConstraint
		 * @param selection
		 * @param blockName
		 * @param className
		 * @param operator
		 */
		private static void compileReferedConstraint(List<Constraint> constraints, List<Constraint> expConstraints, Constraint refConstraint, SpecificObjectSelection selection, String blockName, String className, String operator) {
			String v1 = className.substring(0, 1).toLowerCase() + "0";
			String v2 = className.substring(0, 1).toLowerCase() + "1";
			List<Constraint> referedConstraints = mutConstraint.get(blockName).get(selection.getObjSel().getName());
			for (Constraint referedConstraint : referedConstraints) {
				if (referedConstraint.type.equals("exists") && referedConstraint.className.equals(className)) {
					if (referedConstraint.type.equals("exists") && referedConstraint.className.equals(className)) {
						String vref = referedConstraint.variables.get(referedConstraint.variables.size() - 1);
						String vrepref = "";
						if (vref.length() > 1) {
							vrepref = vref.substring(0, 1) + (Integer.parseInt(vref.substring(1, vref.length())) + 1);
						}
						else {
							vrepref = vref + referedConstraint.variables.size();
						}
						if (referedConstraint.variables.size() == 1) {
							String constraintText = referedConstraint.text.replaceAll(vref + " ", vrepref + " ").replaceAll(vref + "[.]", vrepref + ".").replaceAll(vref + "[)]", vrepref + ")");
							refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + constraintText.substring(0, constraintText.length() - 1) + " and " + v1 + " " + operator + " " + vrepref + "))";
							refConstraint.variables.add(v1);
							refConstraint.variables.add(vrepref);
							if (getConstraint(constraints, refConstraint) == null) {
								addConstraint(expConstraints, refConstraint);
							}
						}
						if (referedConstraint.variables.size() == 2) {
							String constraintText = referedConstraint.text.replaceAll(vref + " ", vrepref + " ").replaceAll(vref + "[.]", vrepref + ".").replaceAll(vref + "[)]", vrepref + ")");
							refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v2 + " | " + constraintText.substring(0, constraintText.length() - 1) + " and " + v2 + " " + operator + " " + vrepref + "))";
							refConstraint.variables.add(v1);
							refConstraint.variables.add(vrepref);
							if (getConstraint(constraints, refConstraint) == null) {
								addConstraint(expConstraints, refConstraint);
							}
						}
					}
				}
			}
		}
		
		/**
		 * Compiles reference expression with refev.name == null to OCL 
		 * @param refev
		 * @param eClass
		 * @param constraints
		 * @param expConstraints
		 * @param blockName
		 * @param mutName
		 * @param className
		 * @param useReferences
		 * @param classNames
		 * @param operator
		 */
		private static void compileReferenceExpressionNoName(ReferenceEvaluation refev, EClass eClass, List<Constraint> constraints, List<Constraint> expConstraints, String blockName, String mutName, String className, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames, String operator, boolean isFirst) {
			String v1 = className.substring(0, 1).toLowerCase() + "0";
			String v2 = className.substring(0, 1).toLowerCase() + "1";
			Constraint refConstraint = new Constraint();
			refConstraint.name = mutName;
			refConstraint.type = "exists";
			refConstraint.className = className;
			if (refev.getValue() instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) refev.getValue();
				// if this mutation refers to previous one
				if (mutConstraint.get(blockName) != null && mutConstraint.get(blockName).get(selection.getObjSel().getName()) != null) {
					compileReferedConstraint(constraints, expConstraints, refConstraint, selection, blockName, className, operator);
				}
				else {
					refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
					refConstraint.variables.add(v1);
					refConstraint.variables.add(v2);
					if (isFirst == true) {
						if (getConstraint(constraints, refConstraint) == null) {
							addConstraint(expConstraints, refConstraint);
						}
					}
					else {
						if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
							include(expConstraints, refConstraint);
						}					
					}
				}
			}
			else {
				refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
				refConstraint.variables.add(v1);
				refConstraint.variables.add(v2);
				if (getConstraint(constraints, refConstraint) == null) {
					addConstraint(expConstraints, refConstraint);
				}
			}
		}
		
		/**
		 * Compiles reference expression with refev.name != null to OCL
		 * @param refev
		 * @param eClass
		 * @param constraints
		 * @param expConstraints
		 * @param blockName
		 * @param mutName
		 * @param className
		 * @param useReferences
		 * @param classNames
		 * @param operator
		 */
		private static void compileReferenceExpressionName(ReferenceEvaluation refev, EClass eClass, List<Constraint> constraints, List<Constraint> expConstraints, String blockName, String mutName, String className, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames, String operator, boolean isFirst) {
			String v1 = className.substring(0, 1).toLowerCase() + "0";
			String refName = getTarUseReference(refev.getName(), useReferences);
			boolean multiple = refev.getName().getUpperBound() > 1 || refev.getName().getUpperBound() == -1;
			Constraint refConstraint = new Constraint();
			refConstraint.name = mutName;
			if (refev.getValue() == null) {
				if (operator.equals("<>")) {
					refConstraint.type = "exists";
					refConstraint.className = className;
					if (refev.getRefName() == null) {
						refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + " " + operator + " null)";
						refConstraint.variables.add(v1);
					}
					else {
						String v3 = refev.getRefName().getEType().getName().substring(0, 1).toLowerCase() + "2";
						String innerRefName = getTarUseReference(refev.getRefName(), useReferences);
						if (refev.getRefName().getUpperBound() > 1 || refev.getRefName().getUpperBound() == -1) {
							refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + "->size() > 0))";
						}
						else {
							refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + " " + operator + " null))";
						}
						refConstraint.variables.add(v1);
						refConstraint.variables.add(v3);
					}
					if (getConstraint(constraints, refConstraint) == null) {
						addConstraint(expConstraints, refConstraint);
					}
				}
			} 
			else {
				ObSelectionStrategy selection = refev.getValue();
				refConstraint.type = "exists";
				refConstraint.className = className;
				if (operator.equals("IN")) {
					if (selection instanceof SpecificObjectSelection) {
						String v3 = className.substring(0, 1).toLowerCase() + "2";
						if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(eClass.getName())) {
							EClass refClass = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType();
							if (classNames.get(EcoreUtil.getURI(refClass)) != null) {
								String refClassName = classNames.get(EcoreUtil.getURI(refClass));
								String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
								if (selection.getRefType() != null) {
									String obRefTypeName = selection.getRefType().getName();
									String v5 = selection.getRefType().getEType().getName().substring(0, 1).toLowerCase() + "4";
									refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v4 + "." + encodeWord(obRefTypeName) + "->exists(" + v5 + " | " + v5 + " = " + v3 + "." + encodeWord(refName) + ")))"; 
									refConstraint.variables.add(v3);
									refConstraint.variables.add(v4);
									refConstraint.variables.add(v5);
								}
							}
						}
					}
				}
				else {
					EClass targetClass = null;
					String targetClassName = "";
					if (selection instanceof RandomTypeSelection) {
						targetClass = ((RandomTypeSelection) refev.getValue()).getType();
						if (classNames.get(EcoreUtil.getURI(targetClass)) != null) {
							targetClassName = classNames.get(EcoreUtil.getURI(targetClass));
							String v3 = targetClassName.substring(0, 1).toLowerCase() + "2";
							if (multiple == false) {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + encodeWord(targetClassName) + ".allInstances()->exists(" + v3 + " | " + v1 + "." + encodeWord(refName) + " " + operator + " " + v3 + "))"; 
								refConstraint.variables.add(v1);
								refConstraint.variables.add(v3);
							}
							else {
								String v4 = targetClassName.substring(0, 1).toLowerCase() + "3";
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + encodeWord(targetClassName) + ".allInstances()->exists(" + v3 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v4 + " | " + v3 + " " + operator + " " + v4 +"))"; 
								refConstraint.variables.add(v1);
								refConstraint.variables.add(v3);
								refConstraint.variables.add(v4);
							}
						}
					}
					if (selection instanceof SpecificObjectSelection) {
						if (refev.getRefName() == null) {
							String v3 = className.substring(0, 1).toLowerCase() + "2";
							if (selection.getRefType() == null) {
								if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(eClass.getName())) {
									EClass refClass = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType();
									if (classNames.get(EcoreUtil.getURI(refClass)) != null) {
										String refClassName = classNames.get(EcoreUtil.getURI(refClass));
										String refMutName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getName();
										String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
										if (multiple == false) {
											refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v3 + "." + encodeWord(refName) + " " + operator + " " + v4 + "))";
											refConstraint.variables.add(v3);
											refConstraint.variables.add(v4);
											refConstraint.nested = true;
											refConstraint = join(constraints, refConstraint, refClassName, refMutName);
										}
										else {
											String v5 = refClassName.substring(0, 1).toLowerCase() + "4";
											refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + v3 + "." + encodeWord(refName) + "->exists(" + v5 + " | " + v4 + " " + operator + " " + v5 +"))";
											refConstraint.variables.add(v3);
											refConstraint.variables.add(v4);
											refConstraint.variables.add(v5);
											refConstraint = join(constraints, refConstraint, refClassName, refMutName);
										}
									}
								}
								else {
									if (multiple == false) {
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(refName) + " " + operator + " " + v3 + ")"; 
										refConstraint.variables.add(v1);
										refConstraint.variables.add(v3);
									}
									else {
										String v4 = className.substring(0, 1).toLowerCase() + "3";
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v4 + " | " + v3 + " " + operator + " " + v4 +"))";
										refConstraint.variables.add(v1);
										refConstraint.variables.add(v3);
										refConstraint.variables.add(v4);
									}
								}
							}
							else {
								if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(eClass.getName())) {
									EClass refClass = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType();
									if (classNames.get(EcoreUtil.getURI(refClass)) != null) {
										String refClassName = classNames.get(EcoreUtil.getURI(refClass));
										String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
										if (multiple == false) {
											refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v3 + "." + encodeWord(refName) + " " + operator + " " + v4 + "))"; 
											refConstraint.variables.add(v3);
											refConstraint.variables.add(v4);
										}
										else {
											String v5 = refClassName.substring(0, 1).toLowerCase() + "4";
											refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v3 + "." + encodeWord(refName) + "->exists(" + v5 + " | " + v4 + " " + operator + " " + v5 +")))"; 
											refConstraint.variables.add(v3);
											refConstraint.variables.add(v4);
											refConstraint.variables.add(v5);
										}
									}
								}
								else {
									String selectionRefName =  getTarUseReference(selection.getRefType(), useReferences);
									boolean mult = selection.getRefType().getUpperBound() > 1 || selection.getRefType().getUpperBound() == -1;
									if (multiple == false || (multiple == true && mult == true)) {
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(refName) + " " + operator + " " + v3 + "." + encodeWord(selectionRefName) + ")";
										refConstraint.variables.add(v1);
										refConstraint.variables.add(v3);
									}
									else {
										String v4 = className.substring(0, 1).toLowerCase() + "3";
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v4 + " | " + v3 + "." + encodeWord(selectionRefName) + " " + operator + " " + v4 +"))";
										refConstraint.variables.add(v1);
										refConstraint.variables.add(v3);
										refConstraint.variables.add(v4);
									}
								}
							}
						}
						else {
							String ref1Name =  getTarUseReference(refev.getRefName(), useReferences);
							String ref2Name =  getTarUseReference(selection.getRefType(), useReferences);
							String v3 = className.substring(0, 1).toLowerCase() + "2";
							if ((((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator) && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(eClass.getName())) {
								EClass refClass = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType();
								if (classNames.get(EcoreUtil.getURI(refClass)) != null) {
									String refClassName = classNames.get(EcoreUtil.getURI(refClass));
									String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
									if (multiple == false) {
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v3 + "." + encodeWord(refName) + " " + operator + " " + v4 + "))"; 
										refConstraint.variables.add(v3);
										refConstraint.variables.add(v4);
									}
									else {
										String v5 = refClassName.substring(0, 1).toLowerCase() + "4";
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + encodeWord(refClassName) + ".allInstances()->exists(" + v4 + " | " + v3 + "." + encodeWord(refName) + "->exists(" + v5 + " | " + v4 + " " + operator + " " + v5 +")))";
										refConstraint.variables.add(v3);
										refConstraint.variables.add(v4);
										refConstraint.variables.add(v5);
									}
								}
							}
							else {
								if (multiple == false) {
									refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(ref1Name) + " " + operator + " " + v3 + "." + encodeWord(ref2Name) + ")"; 
									refConstraint.variables.add(v1);
									refConstraint.variables.add(v3);
								}
								else {
									String v4 = className.substring(0, 1).toLowerCase() + "3";
									refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v3 + " | " + v1 + "." + encodeWord(ref1Name) + "->exists(" + v4 + " | " + v3 + "." + encodeWord(ref2Name) + " " + operator + " " + v4 +"))";
									refConstraint.variables.add(v1);
									refConstraint.variables.add(v3);
									refConstraint.variables.add(v4);
								}
							}
						}
					}
				}
			}
			if (refev.getValue() != null) {
				if (isFirst == true) {
					if (getConstraint(constraints, refConstraint) == null) {
						addConstraint(expConstraints, refConstraint);
					}
				}
				else {
					if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
						subsume(expConstraints, refConstraint);
					}
				}
			}
		}


		/**
		 * Compiles first reference expression to OCL
		 * @param refev
		 * @param eClass
		 * @param constraints
		 * @param expConstraints
		 * @param mutName
		 * @param className
		 */
		private static void compileReferenceExpression(ReferenceEvaluation refev, EClass eClass, List<Constraint> constraints, List<Constraint> expConstraints, String blockName, String mutName, String className, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames, boolean isFirst) {
			String operator = "";
			if (refev.getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
				operator = "=";
			}
			if (refev.getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
				operator = "<>";
			}
			if (refev.getOperator().getLiteral().equals(Operator.IN.getLiteral())) {
				operator = "IN";
			}
			if (refev.getName() == null) {
				compileReferenceExpressionNoName(refev, eClass, constraints, expConstraints, blockName, mutName, className, useReferences, classNames, operator, isFirst);
			}
			else {
				compileReferenceExpressionName(refev, eClass, constraints, expConstraints, blockName, mutName, className, useReferences, classNames, operator, isFirst);
			}		
		}
		
		/**
		 * Compiles the given Wodel program to USE OCL constraints 
		 * @param model
		 * @param exp
		 * @param eClass
		 * @param constraints
		 * @param blockName
		 * @param mutName
		 * @param useReferences
		 * @param classNames
		 */
		private static void compile(Resource model, Expression exp, EClass eClass, List<Constraint> constraints, String blockName, String mutName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames)
		{
			List<Constraint> expConstraints = new ArrayList<Constraint>();
			if (classNames.get(EcoreUtil.getURI(eClass)) != null) {
				String className = classNames.get(EcoreUtil.getURI(eClass));
				if (exp.getFirst() instanceof AttributeEvaluation) {
					compileAttributeExpression(model, (AttributeEvaluation) exp.getFirst(), eClass, constraints, expConstraints, mutName, className, true);
				}
				if (exp.getFirst() instanceof ReferenceEvaluation) {
					compileReferenceExpression((ReferenceEvaluation) exp.getFirst(), eClass, constraints, expConstraints, blockName, mutName, className, useReferences, classNames, true);
				}
				if (exp.getSecond() != null) {
					for (Evaluation ev : exp.getSecond()) {
						if (ev instanceof AttributeEvaluation) {
							compileAttributeExpression(model, (AttributeEvaluation) ev, eClass, constraints, expConstraints, mutName, className, false);
						}
						if (ev instanceof ReferenceEvaluation) {
							compileReferenceExpression((ReferenceEvaluation) ev, eClass, constraints, expConstraints, blockName, mutName, className, useReferences, classNames, false);
						}
					}
				}
				for (Constraint constraint : expConstraints) {
					if (getConstraint(constraints, constraint) == null && constraint.text.length() > 0) {
						addConstraint(constraints, constraint);
						storeMutatorName(constraint, blockName, mutName);
					}
				}
			}
		}
		
		/**
		 * Compiles the given Wodel expression to USE OCL constraints
		 * @param model
		 * @param exp
		 * @param eClass
		 * @param attributes
		 * @param constraints
		 * @param blockName
		 * @param mutName
		 * @param useReferences
		 * @param classNames
		 */
		public static void compile(Resource model, Expression exp, EClass eClass, List<AttributeSet> attributes, List<Constraint> constraints, String blockName, String mutName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames) {
			String className = classNames.get(EcoreUtil.getURI(eClass));
			if (exp.getFirst() instanceof AttributeEvaluation) {
				String operator = "";
				Constraint attConstraint = new Constraint();
				attConstraint.name = mutName;
				attConstraint.className = className;
				AttributeEvaluation attev = (AttributeEvaluation) exp.getFirst();
				if (attev.getValue() instanceof AttributeType) {
					if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
						operator = "=";
					}
					if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
						operator = "<>";
					}
					boolean isChanged = isChanged(attev, attributes);
					if (isChanged == false) {
						attConstraint.type = "exists";
						if (attev.getValue() instanceof StringType) {
							attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " '" + ((SpecificStringType) attev.getValue()).getValue() + "')"; 
						}
						if (attev.getValue() instanceof DoubleType) {
							attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificDoubleType) attev.getValue()).getValue() + ")"; 
						}
						if (attev.getValue() instanceof BooleanType) {
							attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificBooleanType) attev.getValue()).isValue() + ")"; 
						}
						if (attev.getValue() instanceof IntegerType) {
							attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificIntegerType) attev.getValue()).getValue() + ")"; 
						}
					}
				}
				if (attev.getValue() instanceof ObjectAttributeType) {
					ObjectAttributeType objectAttributeType = (ObjectAttributeType) attev.getValue();
					if (objectAttributeType.getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
						operator = "=";
					}
					if (objectAttributeType.getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
						operator = "<>";
					}
					EClass type = MutatorUtils.getMutatorType(model, objectAttributeType.getObjSel().getName());
					if (EcoreUtil.equals(type, eClass)) {
						String v1 = className.substring(0, 1).toLowerCase() + "0";
						String v2 = className.substring(0, 1).toLowerCase() + "1";
						attConstraint.variables.add(v1);
						attConstraint.variables.add(v2);
						attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + ")";  
					}
					else {
						String v1 = className.substring(0, 1).toLowerCase() + "0";
						String v2 = type.getName().substring(0, 1).toLowerCase() + "1";
						attConstraint.variables.add(v1);
						attConstraint.variables.add(v2);
						attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + encodeWord(type.getName()) + ".allInstances()->exists(" + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + "))";
					}
				}
				if (getConstraint(constraints, attConstraint) == null && (attConstraint.text.length() > 0)) {
					addConstraint(constraints, attConstraint);
					storeMutatorName(attConstraint, blockName, mutName);
				}
			}
			if (exp.getSecond() != null) {
				for (Evaluation ev : exp.getSecond()) {
					String operator = "";
					Constraint attConstraint = new Constraint();
					attConstraint.name = mutName;
					attConstraint.className = className;
					if (ev instanceof AttributeEvaluation) {
						AttributeEvaluation attev = (AttributeEvaluation) ev;
						if (attev instanceof AttributeType) {
							if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
								operator = "=";
							}
							if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
								operator = "<>";
							}
							boolean isChanged = isChanged(attev, attributes);
							if (isChanged == false) {
								attConstraint.type = "exists";
								if (attev.getValue() instanceof StringType) {
									attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " '" + ((SpecificStringType) attev.getValue()).getValue() + "')"; 
								}
								if (attev.getValue() instanceof DoubleType) {
									attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificDoubleType) attev.getValue()).getValue() + ")"; 
								}
								if (attev.getValue() instanceof BooleanType) {
									attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificBooleanType) attev.getValue()).isValue() + ")"; 
								}
								if (attev.getValue() instanceof IntegerType) {
									attConstraint.text = className + ".allInstances()->exists(" + className.substring(0, 1).toLowerCase() + " | " + className.substring(0, 1).toLowerCase() + "." + attev.getName().getName() + " " + operator + " " + ((SpecificIntegerType) attev.getValue()).getValue() + ")"; 
								}
							}
						}
						if (attev instanceof ObjectAttributeType) {
							ObjectAttributeType objectAttributeType = (ObjectAttributeType) attev.getValue();
							if (objectAttributeType.getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
								operator = "=";
							}
							if (objectAttributeType.getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
								operator = "<>";
							}
							EClass type = MutatorUtils.getMutatorType(model, objectAttributeType.getObjSel().getName());
							if (EcoreUtil.equals(type, eClass)) {
								String v1 = className.substring(0, 1).toLowerCase() + "0";
								String v2 = className.substring(0, 1).toLowerCase() + "1";
								attConstraint.variables.add(v1);
								attConstraint.variables.add(v2);
								attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + ")";  
							}
							else {
								String v1 = className.substring(0, 1).toLowerCase() + "0";
								String v2 = type.getName().substring(0, 1).toLowerCase() + "1";
								attConstraint.variables.add(v1);
								attConstraint.variables.add(v2);
								attConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + encodeWord(type.getName()) + ".allInstances()->exists(" + v2 + " | " + v1 + "." + encodeWord(attev.getName().getName()) + " " + operator + " " + v2 + "." + encodeWord(objectAttributeType.getAttribute().getName()) + "))";
							}
						}
						if (getConstraint(constraints, attConstraint) == null && (attConstraint.text.length() > 0)) {
							addConstraint(constraints, attConstraint);
							storeMutatorName(attConstraint, blockName, mutName);
						}
					}
				}
			}
		}

		/**
		 * Compiles the given Wodel references set to USE OCL constraints
		 * @param model
		 * @param references
		 * @param constraints
		 * @param blockName
		 * @param mutName
		 * @param useReferences
		 * @param classNames
		 */
		public static void compile(Resource model, List<ReferenceSet> references, List<Constraint> constraints, String blockName, String mutName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames) {
			for (ReferenceSet ref : references) {
				Constraint constraint = new Constraint();
				constraint.name = mutName;
				EClass eClass = null;
				if (ref.getObject() != null) {
					constraint.type = "size";
	        		if (ref.getObject() instanceof RandomTypeSelection) {
	       				eClass = ref.getObject().getType();
	    	   			if (ref.getObject().getExpression() != null) {
		       				compile(model, ref.getObject().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
	       				}
	       			}
	       			if (ref.getObject() instanceof CompleteTypeSelection) {
	       				eClass = ref.getObject().getType();
	       			}
					if (ref.getObject() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ref.getObject(); 
						if (selection.getObjSel() instanceof CreateObjectMutator == false) {
							if (selection.getObjSel() instanceof SelectObjectMutator) {
								eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
							}
							if (selection.getObjSel() instanceof SelectSampleMutator) {
								eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
							}
							if (selection.getObjSel() instanceof CloneObjectMutator) {
								eClass = selection.getObjSel().getType();
							}
							if (selection.getObjSel() instanceof ModifyInformationMutator) {
								ModifyInformationMutator modifyMutator = (ModifyInformationMutator) selection.getObjSel();
								if (modifyMutator.getObject() instanceof RandomTypeSelection) {
									eClass = modifyMutator.getObject().getType();
								}
								if (modifyMutator.getObject() instanceof CompleteTypeSelection) {
									eClass = modifyMutator.getObject().getType();
								}
								if (modifyMutator.getObject() instanceof SpecificObjectSelection) {
									eClass = getClassType(((SpecificObjectSelection) modifyMutator.getObject()));
								}
								if (modifyMutator.getObject() instanceof SpecificClosureSelection) {
									eClass = getClassType(modifyMutator.getObject());						
								}
							}
						}
					}
	       			if (ref.getObject() instanceof SpecificClosureSelection) {
	    	   			SpecificClosureSelection selection = (SpecificClosureSelection) ref.getObject();
		     			if (selection.getObjSel() instanceof CreateObjectMutator == false) {
	       					if (selection.getObjSel() instanceof SelectObjectMutator) {
	       						eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
	       					}
	       					if (selection.getObjSel() instanceof SelectSampleMutator) {
								eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
							}
	       					if (selection.getObjSel() instanceof CloneObjectMutator) {
	       						eClass = selection.getObjSel().getType();
	    	   				}
	    	   				if (selection.getObjSel() instanceof ModifyInformationMutator) {
								eClass = selection.getObjSel().getType();
							}
		       			}
		       		}
	       			if (eClass != null && classNames.get(EcoreUtil.getURI(eClass)) != null) {
	       				String className = classNames.get(EcoreUtil.getURI(eClass));
						constraint.text = encodeWord(className) + ".allInstances()->size()";
						constraint.className = className;
					}
	       		}
	       		else {
	       			if (ref instanceof ReferenceInit) {
	       				ReferenceInit refInit = (ReferenceInit) ref;
	       				ObSelectionStrategy object = refInit.getObject();
	       				
	       				constraint.type = "size";
	       				
	       				if (object instanceof RandomTypeSelection) {
	       					eClass = object.getType();
	    	   				if (object.getExpression() != null) {
		       					compile(model, object.getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
	       					}
	       				}
	       				if (object instanceof CompleteTypeSelection) {
	       					eClass = object.getType();
	       					if (object.getExpression() != null) {
	       						compile(model, object.getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
	       					}
	       				}
						if (object instanceof SpecificObjectSelection) {
							SpecificObjectSelection selection = (SpecificObjectSelection) object;
							if (selection.getObjSel() instanceof CreateObjectMutator == false) {
								if (selection.getObjSel() instanceof SelectObjectMutator) {
									eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
								}
								if (selection.getObjSel() instanceof SelectSampleMutator) {
									eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
								}
								if (selection.getObjSel() instanceof CloneObjectMutator) {
									eClass = selection.getObjSel().getType();
								}
								if (selection.getObjSel() instanceof ModifyInformationMutator) {
									eClass = selection.getObjSel().getType();
								}
							}
						}
	       				if (object instanceof SpecificClosureSelection) {
	    	   				SpecificClosureSelection selection = (SpecificClosureSelection) object;
		     				if (selection.getObjSel() instanceof CreateObjectMutator == false) {
		       					if (selection.getObjSel() instanceof SelectObjectMutator) {
	    	   						eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
	       						}
	       						if (selection.getObjSel() instanceof SelectSampleMutator) {
									eClass = MutatorUtils.selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
								}
	       						if (selection.getObjSel() instanceof CloneObjectMutator) {
	       							eClass = selection.getObjSel().getType();
	    	   					}
	    	   					if (selection.getObjSel() instanceof ModifyInformationMutator) {
									eClass = selection.getObjSel().getType();
								}
		       				}
		       			}
		       			if (eClass != null && classNames.get(EcoreUtil.getURI(eClass)) != null) {
		       				String className = classNames.get(EcoreUtil.getURI(eClass));
							constraint.text = encodeWord(className) + ".allInstances()->size()";
							constraint.className = className;
		   				}
	       			}
	       		}
				if (constraint.text.length() > 0) {
					if (getConstraint(constraints, constraint) == null && (constraint.text.length() > 0)) {
						addConstraint(constraints, constraint);
						storeMutatorName(constraint, blockName, mutName);
					}
				}
			}
		}

		/**
		 * Compiles the given Wodel program to USE OCL constraints 
		 * @param model
		 * @param eContainer
		 * @param eClass
		 * @param constraints
		 * @param blockName
		 * @param mutName
		 * @param useReferences
		 * @param classNames
		 */
		private static void compile(Resource model, EClass eContainer, EReference containerReference, EClass eClass, List<Constraint> constraints, String mutName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, HashMap<URI, String> classNames, int times)
		{
			if (containerReference.getLowerBound() > 0) {
				Constraint constraint = new Constraint();
				constraint.name = mutName;
				constraint.type = "exists";
				constraint.className = eContainer.getName();
				String className = classNames.get(EcoreUtil.getURI(eContainer));
				constraint.text = encodeWord(className) + ".allInstances()->exists(" + eClass.getName().substring(0, 1).toLowerCase() + " | " + eClass.getName().substring(0, 1).toLowerCase() + "." + encodeWord(containerReference.getName()) + "->size() > " + (containerReference.getLowerBound() + times) + ")";
				Constraint previous = getConstraint(constraints, constraint);
				if (previous == null) {
					addConstraint(constraints, constraint);
				}
				else {
					int size = Integer.parseInt(previous.text.substring(previous.text.lastIndexOf(">") + 2, previous.text.lastIndexOf(")")));
					previous.text = encodeWord(className) + ".allInstances()->exists(" + eClass.getName().substring(0, 1).toLowerCase() + " | " + eClass.getName().substring(0, 1).toLowerCase() + "." + encodeWord(containerReference.getName()) + "->size() > " + (size + 1) + ")";
				}
			}
		}

		/**
		 * Checks whether the attribute evaluation is changing the value
		 * @param attev
		 * @param attributes
		 * @return
		 */
		private static boolean isChanged(AttributeEvaluation attev, List<AttributeSet> attributes) {
			for (AttributeSet att : attributes) {
				if (att.getAttribute().get(0).getName().equals(attev.getName().getName())) {
					if (att instanceof AttributeScalar) {
						if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
							if (attev.getValue().equals(((AttributeScalar) att).getValue())) {
								return false;
							}
							else {
								return true;
							}
						}
						if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
							if (attev.getValue().equals(((AttributeScalar) att).getValue())) {
								return true;
							}
							else {
								return false;
							}
						}
					}
					if (att instanceof AttributeUnset) {
						if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.EQUALS.getLiteral())) {
							if (attev.getValue() == null) {
								return false;
							}
							else {
								return true;
							}
						}
						if (((AttributeType) attev.getValue()).getOperator().getLiteral().equals(Operator.DIFFERENT.getLiteral())) {
							if (attev.getValue() == null) {
								return true;
							}
							else {
								return false;
							}
						}
					}
					if (att instanceof AttributeSwap) {
						if (((AttributeSwap) att).eContainer() instanceof ModifyInformationMutator) {
							if (attev.getValue() instanceof ObjectAttributeType) {
								ObjectAttributeType value = (ObjectAttributeType) attev.getValue();
								ModifyInformationMutator mut = (ModifyInformationMutator) ((AttributeSwap) att).eContainer();
								if (mut.getObject() instanceof RandomTypeSelection) {
									return false;
								}
				       			if (mut.getObject() instanceof CompleteTypeSelection) {
	       							return true;
	       						}
								if (mut.getObject() instanceof SpecificObjectSelection) {
									SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
									if (selection.getObjSel() instanceof CreateObjectMutator ||
											selection.getObjSel() instanceof SelectObjectMutator ||
											selection.getObjSel() instanceof SelectSampleMutator ||
											selection.getObjSel() instanceof CloneObjectMutator ||
											selection.getObjSel() instanceof RetypeObjectMutator) {
										if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
											return false;
										}
										else {
											return true;
										}
									}
								}
	       						if (mut.getObject() instanceof SpecificClosureSelection) {
	       							SpecificClosureSelection selection = (SpecificClosureSelection) mut.getObject();
									if (selection.getObjSel() instanceof CreateObjectMutator ||
											selection.getObjSel() instanceof SelectObjectMutator ||
											selection.getObjSel() instanceof SelectSampleMutator ||
											selection.getObjSel() instanceof CloneObjectMutator ||
											selection.getObjSel() instanceof RetypeObjectMutator) {
		       							if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
											return false;
										}
										else {
											return true;
										}
	       							}
		       					}
							}
						}
					}
					if (att instanceof AttributeCopy) {
						if (((AttributeCopy) att).eContainer() instanceof ModifyInformationMutator) {
							if (attev.getValue() instanceof ObjectAttributeType) {
								ObjectAttributeType value = (ObjectAttributeType) attev.getValue();
								ModifyInformationMutator mut = (ModifyInformationMutator) ((AttributeCopy) att).eContainer();
								if (mut.getObject() instanceof RandomTypeSelection) {
									return false;
								}
				       			if (mut.getObject() instanceof CompleteTypeSelection) {
	       							return true;
	       						}
								if (mut.getObject() instanceof SpecificObjectSelection) {
									SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
									if (selection.getObjSel() instanceof CreateObjectMutator ||
											selection.getObjSel() instanceof SelectObjectMutator ||
											selection.getObjSel() instanceof SelectSampleMutator ||
											selection.getObjSel() instanceof CloneObjectMutator ||
											selection.getObjSel() instanceof RetypeObjectMutator) {
										if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
											return false;
										}
										else {
											return true;
										}
									}
								}
	       						if (mut.getObject() instanceof SpecificClosureSelection) {
	       							SpecificClosureSelection selection = (SpecificClosureSelection) mut.getObject();
									if (selection.getObjSel() instanceof CreateObjectMutator ||
											selection.getObjSel() instanceof SelectObjectMutator ||
											selection.getObjSel() instanceof SelectSampleMutator ||
											selection.getObjSel() instanceof CloneObjectMutator ||
											selection.getObjSel() instanceof RetypeObjectMutator) {
		       							if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
											return false;
										}
										else {
											return true;
										}
	       							}
		       					}
							}
						}
					}
					if (att instanceof AttributeReverse) {
						return true;
					}
					if (att instanceof AttributeOperation) {
						return true;
					}
				}
			}
			return false;
		}

		/**
		 * Compiles the Wodel commands to USE OCL constraints
		 * @param model
		 * @param commands
		 * @param rootClass
		 * @param packages
		 * @param classNames
		 * @param constraints
		 * @param blockName
		 * @param useReferences
		 */
		public static void compile(Resource model, List<Mutator> commands, EClass rootClass, List<EPackage> packages, HashMap<URI, String> classNames, List<Constraint> constraints, String blockName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
			for (Mutator mut : commands) {
				Integer times = mutatorDependencies.needsOCLConstraints(mut);
				if (times != null && times > 0) {
					String mutName = MutatorUtils.getMutatorName(mut);
					if (mut instanceof CreateObjectMutator) {
						if (mut.getType() != null) {
							EClass type = mut.getType();
							String name = classNames.get(EcoreUtil.getURI(type));
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(type));
							for (EClassifier container : containers) {
								EReference containerReference = null;
								for (EReference ref : ((EClass) container).getEAllReferences()) {
									if (ref.isContainment() == true && ref.getLowerBound() > 0) {
										List<EClass> types = new ArrayList<EClass>();
										types.add(type);
										types.addAll(type.getEAllSuperTypes());
										for (EClass eClass : types) {
											if (EcoreUtil.getURI(eClass).equals(EcoreUtil.getURI(type))) {
												containerReference = ref;
											}
										}
									}
								}
								if (containerReference != null) {
									if (classNames.containsKey(EcoreUtil.getURI(container))) {
										List<EClass> recursion = new ArrayList<EClass>();
										recursion.add((EClass) container);
										getSizeConstraints(rootClass, (EClass) container, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
									}
								}
							}
							if (((CreateObjectMutator) mut).getReferences() != null) {
								compile(model, ((CreateObjectMutator) mut).getReferences(), constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof RemoveObjectMutator) {
						if (((RemoveObjectMutator) mut).getObject() != null) {
							EClass type = MutatorUtils.getType(mut);
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(type));
							for (EClassifier container : containers) {
								EReference containerReference = null;
								for (EReference ref : ((EClass) container).getEAllReferences()) {
									if (ref.isContainment() == true && ref.getLowerBound() > 0) {
										List<EClass> types = new ArrayList<EClass>();
										types.add(type);
										types.addAll(type.getEAllSuperTypes());
										for (EClass eClass : types) {
											if (EcoreUtil.getURI(eClass).equals(EcoreUtil.getURI(type))) {
												containerReference = ref;
											}
										}
									}
								}
								if (containerReference != null) {
									if (classNames.containsKey(EcoreUtil.getURI(container))) {
										List<EClass> recursion = new ArrayList<EClass>();
										recursion.add((EClass) container);
										getSizeConstraints(rootClass, (EClass) container, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
										compile(model, (EClass) container, containerReference, type, constraints, mutName, useReferences, classNames, times);
									}
								}
							}
							if (classNames.containsKey(EcoreUtil.getURI(type))) {
								for (int i = 0; i < times; i++) {
									List<EClass> recursion = new ArrayList<EClass>();
									recursion.add(type);
									getSizeConstraints(rootClass, type, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
								}
							}
							if (((RemoveObjectMutator) mut).getObject().getExpression() != null) {
								compile(model, ((RemoveObjectMutator) mut).getObject().getExpression(), type, constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof CreateReferenceMutator) {
						if (((CreateReferenceMutator) mut).getTarget() != null) {
							String name = MutatorUtils.getTypeName(((CreateReferenceMutator) mut).getTarget());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((CreateReferenceMutator) mut).getTarget().getExpression() != null) {
								compile(model, ((CreateReferenceMutator) mut).getTarget().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
						if (((CreateReferenceMutator) mut).getSource() != null) {
							String name = MutatorUtils.getTypeName(((CreateReferenceMutator) mut).getSource());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((CreateReferenceMutator) mut).getSource().getExpression() != null) {
								compile(model, ((CreateReferenceMutator) mut).getSource().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof ModifySourceReferenceMutator) {
						if (((ModifySourceReferenceMutator) mut).getSource() != null) {
							String name = MutatorUtils.getTypeName(((ModifySourceReferenceMutator) mut).getSource());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((ModifySourceReferenceMutator) mut).getSource().getExpression() != null) {
								compile(model, ((ModifySourceReferenceMutator) mut).getSource().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
							if (((ModifySourceReferenceMutator) mut).getRefType() != null) {
								EReference ref = ((ModifySourceReferenceMutator) mut).getRefType();
								Constraint refConstraint = new Constraint();
								refConstraint.type = "exists";
								refConstraint.className = eClass.getName();
								String className = classNames.get(EcoreUtil.getURI(eClass));
								String v1 = refConstraint.className.substring(0, 1).toLowerCase() + "0";
								if (ref.getUpperBound() > 1 || ref.getUpperBound() == -1) {
									refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(ref.getName()) + "->size() > 0)";
								}
								else {
									refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(ref.getName()) + " <> null)";
								}
								refConstraint.variables.add(v1);
								if (getConstraint(constraints, refConstraint) == null) {
									addConstraint(constraints, refConstraint);
								}
							}
						}
						if (((ModifySourceReferenceMutator) mut).getNewSource() != null) {
							String name = MutatorUtils.getTypeName(((ModifySourceReferenceMutator) mut).getNewSource());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((ModifySourceReferenceMutator) mut).getNewSource().getExpression() != null) {
								compile(model, ((ModifySourceReferenceMutator) mut).getNewSource().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof ModifyTargetReferenceMutator) {
						if (((ModifyTargetReferenceMutator) mut).getSource() != null) {
							String name = MutatorUtils.getTypeName(((ModifyTargetReferenceMutator) mut).getSource());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((ModifyTargetReferenceMutator) mut).getSource().getExpression() != null) {
								compile(model, ((ModifyTargetReferenceMutator) mut).getSource().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
						if (((ModifyTargetReferenceMutator) mut).getRefType() != null) {
							EReference ref = ((ModifyTargetReferenceMutator) mut).getRefType();
							String name = MutatorUtils.getTypeName(((ModifyTargetReferenceMutator) mut).getSource());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							Constraint refConstraint = new Constraint();
							refConstraint.type = "exists";
							refConstraint.className = eClass.getName();
							String className = classNames.get(EcoreUtil.getURI(eClass));
							String v1 = refConstraint.className.substring(0, 1).toLowerCase() + "0";
							if (ref.getUpperBound() > 1 || ref.getUpperBound() == -1) {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(ref.getName()) + "->size() > 0)";
							}
							else {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(ref.getName()) + " <> null)";
							}
							refConstraint.variables.add(v1);
							if (getConstraint(constraints, refConstraint) == null) {
								addConstraint(constraints, refConstraint);
							}
						}
						if (((ModifyTargetReferenceMutator) mut).getNewTarget() != null) {
							String name = MutatorUtils.getTypeName(((ModifyTargetReferenceMutator) mut).getNewTarget());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								if (((ModifyTargetReferenceMutator) mut).getNewTarget() instanceof OtherTypeSelection) {
									List<EClass> recursion = new ArrayList<EClass>();
									recursion.add(eClass);
									getSizeConstraints(rootClass, eClass, packages, constraints, true, null, blockName, mutName, false, classNames, recursion);
								}
								else {
									List<EClass> recursion = new ArrayList<EClass>();
									recursion.add(eClass);
									getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
								}
							}
							if (((ModifyTargetReferenceMutator) mut).getNewTarget().getExpression() != null) {
								compile(model, ((ModifyTargetReferenceMutator) mut).getNewTarget().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof RemoveCompleteReferenceMutator) {
						if (((RemoveCompleteReferenceMutator) mut).getType() != null) {
							String name = mut.getType().getName();
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
						}
					}
					if (mut instanceof SelectObjectMutator) {
						if (((SelectObjectMutator) mut).getObject() != null) {
							String name = MutatorUtils.getTypeName(((SelectObjectMutator) mut).getObject());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((SelectObjectMutator) mut).getObject().getExpression() != null) {
								compile(model, ((SelectObjectMutator) mut).getObject().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
							if (((SelectObjectMutator) mut).getContainer() != null) {
								if (((SelectObjectMutator) mut).getContainer() instanceof SpecificClosureSelection) {
									closures.put(EcoreUtil.getURI(eClass), true);
								}
							}
						}
					}
					if (mut instanceof SelectSampleMutator) {
						if (((SelectSampleMutator) mut).getObject() != null) {
							String name = MutatorUtils.getTypeName(((SelectSampleMutator) mut).getObject());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
						}
					}
					if (mut instanceof CloneObjectMutator) {
						if (((CloneObjectMutator) mut).getObject() != null) {
							String name = MutatorUtils.getTypeName(((CloneObjectMutator) mut).getObject());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((CloneObjectMutator) mut).getObject().getExpression() != null) {
								compile(model, ((CloneObjectMutator) mut).getObject().getExpression(), eClass, ((CloneObjectMutator) mut).getAttributes(), constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof ModifyInformationMutator) {
						if (((ModifyInformationMutator) mut).getObject() != null) {
							String name = MutatorUtils.getTypeName(((ModifyInformationMutator) mut).getObject());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add(eClass);
								getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
							}
							if (((ModifyInformationMutator) mut).getObject().getExpression() != null) {
								compile(model, ((ModifyInformationMutator) mut).getObject().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
								compile(model, ((ModifyInformationMutator) mut).getObject().getExpression(), eClass, ((ModifyInformationMutator) mut).getAttributes(), constraints, blockName, mutName, useReferences, classNames);
							}
							if (((ModifyInformationMutator) mut).getReferences() != null) {
								compile(model, ((ModifyInformationMutator) mut).getReferences(), constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
					if (mut instanceof RetypeObjectMutator) {
						if (((RetypeObjectMutator) mut).getObject() != null) {
							String name = MutatorUtils.getTypeName(((RetypeObjectMutator) mut).getObject());
							EClass eClass = ModelManager.getEClassByName(packages, name);
							if (classNames.containsKey(EcoreUtil.getURI(eClass))) {
								for (int i = 0; i < times; i++) {
									List<EClass> recursion = new ArrayList<EClass>();
									recursion.add(eClass);
									getSizeConstraints(rootClass, eClass, packages, constraints, false, null, blockName, mutName, false, classNames, recursion);
								}
							}
							if (((RetypeObjectMutator) mut).getObject().getExpression() != null) {
								compile(model, ((RetypeObjectMutator) mut).getObject().getExpression(), eClass, constraints, blockName, mutName, useReferences, classNames);
							}
						}
					}
				}
			}
		}
		
		/**
		 * Generates USE code for the given Wodel program
		 * @param model
		 * @param e
		 * @param modelName
		 * @param useReferences
		 * @return
		 */
		public static String generateUSE(Resource model, MutatorEnvironment e, String modelName, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
			String useText = "";
			try {
				useText = "model " + encodeWord(modelName) + "\n";
				List<EPackage> packages = ModelManager.loadMetaModel(e.getDefinition().getMetamodel());
				List<EClass> classes = ModelManager.getEClasses(packages);
				HashMap<URI, String> classNames = new HashMap<URI, String>();
				List<Constraint> constraints = new ArrayList<Constraint>();
				HashMap<String, Integer> maxSize = new HashMap<String, Integer>();
				
				EClass rootClass = null;
				for (EClass eClass : classes) {
					List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eClass));
					if (containerTypes.size() == 0) {
						rootClass = eClass;
					}
					EPackage pck = eClass.getEPackage();
					String clName = pck.getName() + "XxxX" + eClass.getName();
					classNames.put(EcoreUtil.getURI(eClass), clName);
					closures.put(EcoreUtil.getURI(eClass), false);
				}
				
				for (EClass eClass : classes) {
					HashMap<EClass, String> superClasses = new HashMap<EClass, String>();
					for (EClass superClass : eClass.getESuperTypes()) {
						EPackage pck = superClass.getEPackage();
						String superClName = pck.getName() + "XxxX" + superClass.getName();
						superClasses.put(superClass, superClName);
					}
					String superClassesText = "";
					String abst = "";
					if (eClass.isAbstract() == true) {
						abst = "abstract ";
					}
					String clName = classNames.get(EcoreUtil.getURI(eClass));
					EClass[] superEClasses = new EClass[superClasses.keySet().size()];
					superClasses.keySet().toArray(superEClasses);
					if (superClasses.keySet().size() > 0) {
						superClassesText = superClassesText + encodeWord(superClasses.get(superEClasses[0]));
						if (superClasses.keySet().size() > 1) {
							for (EClass superClass : Arrays.asList(superEClasses).subList(1, superEClasses.length)) {
								superClassesText = superClassesText + ", " + encodeWord(superClasses.get(superClass));
							}
						}
						useText += abst + "class " + encodeWord(clName) + " < " + superClassesText + "\n";
					}
					else {
						useText += abst + "class " + encodeWord(clName) + "\n";
					}
					List<EAttribute> atts = eClass.getEAttributes();
					if (atts.size() > 0) {
						useText += "\tattributes\n";
						for (EAttribute att : atts) {
							if (att.getEType().getName().equals("EString") || att.getEType().getName().equals("EChar") || att.getEType().getName().equals("String")) {
								useText += "\t\t" + encodeWord(att.getName()) + " : String\n";
							}
							if (att.getEType().getName().equals("EBoolean") || att.getEType().getName().equals("EBooleanObject") || att.getEType().getName().equals("Boolean")) {
								useText += "\t\t" + encodeWord(att.getName()) + " : Boolean\n";
							}
							if (att.getEType().getName().equals("EInt") || att.getEType().getName().equals("EIntegerObject") || att.getEType().getName().equals("EBigInteger") || att.getEType().getName().equals("EBigIntegerObject") || att.getEType().getName().equals("Integer")) {
								useText += "\t\t" + encodeWord(att.getName()) +  " : Integer\n";
							}
							if (att.getEType().getName().equals("EDouble") || att.getEType().getName().equals("EDoubleObject") || att.getEType().getName().equals("EFloat") || att.getEType().getName().equals("EFloatObject") || att.getEType().getName().equals("Float") || att.getEType().getName().equals("Double")) {
								useText += "\t\t" + encodeWord(att.getName()) + " : Real\n";
							}
							if (att.getEType() instanceof EEnum) {
								useText += "\t\t" + encodeWord(att.getName()) + " : Integer\n";
							}
						}
					}
					useText += "end\n";
				}
				
				dummyClassName = getUniqueName(dummyClassName, classNames, 0);
				useText += "class " + encodeWord(dummyClassName) + "\n";
				useText += "end\n";
				
				for (EClass eClass : classes) {
					String clName = classNames.get(EcoreUtil.getURI(eClass));
					for (EAttribute att : eClass.getEAllAttributes()) {
						if (att.getLowerBound() > 0) {
							Constraint constraint = new Constraint();
							constraint.text = encodeWord(clName) + ".allInstances()->forAll(" + clName.substring(0, 1).toLowerCase() + " | " + clName.substring(0, 1).toLowerCase() + "." + encodeWord(att.getName()) + " <> null)";
							constraint.type = "forAll";
							constraint.variables.add(clName.substring(0, 1).toLowerCase());
							constraint.className = clName;
							if (getConstraint(constraints, constraint) == null && (constraint.text.length() > 0)) {
								addConstraint(constraints, constraint);
							}
						}
					}
				}
				
				HashMap<String, Integer> associationNames = new HashMap<String, Integer>();
				HashMap<String, Integer> roleNames = new HashMap<String, Integer>();
				List<EReference> references = new ArrayList<EReference>();
				
				for (EClass eClass : classes) {
					String clName = classNames.get(EcoreUtil.getURI(eClass));
					List<EReference> refs = eClass.getEReferences();
					if (refs.size() > 0) {
						for (EReference ref : refs) {
							if (classNames.get(EcoreUtil.getURI(ref.getEType())) != null) {
								String refETypeName = classNames.get(EcoreUtil.getURI(ref.getEType()));
								references.add(ref);
								String associationName = clName + "XxxX" + refETypeName;
								if (associationNames.get(associationName) != null) {
									associationNames.put(associationName, associationNames.get(associationName) + 1);
									associationName += associationNames.get(associationName);
								}
								else {
									associationNames.put(associationName, 0);
								}
								HashMap<URI, Entry<String, String>> uriUseReference = null;
								if (useReferences.get(EcoreUtil.getURI(eClass)) != null) {
									uriUseReference = useReferences.get(EcoreUtil.getURI(eClass));
								}
								else {
									uriUseReference = new HashMap<URI, Entry<String, String>>();
								}
								String srcRoleName = clName.toLowerCase() + "xxxx" + ref.getName();
								if (roleNames.get(srcRoleName) != null) {
									roleNames.put(srcRoleName, roleNames.get(srcRoleName) + 1);
									srcRoleName += roleNames.get(srcRoleName);
								}
								else {
									roleNames.put(srcRoleName, 0);
								}
								String tarRoleName = ref.getName();
								if (roleNames.get(tarRoleName) != null) {
									roleNames.put(tarRoleName, roleNames.get(tarRoleName) + 1);
									tarRoleName += roleNames.get(tarRoleName);
								}
								else {
									roleNames.put(tarRoleName, 0);
								}
								Entry<String, String> useReference = new AbstractMap.SimpleEntry<String, String>(encodeWord(srcRoleName), encodeWord(tarRoleName));
								uriUseReference.put(EcoreUtil.getURI(ref), useReference);
								useReferences.put(EcoreUtil.getURI(eClass), uriUseReference);
								if (ref.isContainment() == false) {
									useText += "association " + encodeWord(associationName) + " between\n";
									useText += "\t" + encodeWord(clName) + "[*] role " + encodeWord(srcRoleName) + "\n";
								}
								if (ref.isContainment() == true) {
									useText += "composition " + encodeWord(associationName) + " between\n";
									useText += "\t" + encodeWord(clName) + "[0..1] role " + encodeWord(srcRoleName) + "\n";
								}
								if (ref.getLowerBound() == 0 && ref.getUpperBound() == -1) {
									useText += "\t" + encodeWord(refETypeName) + "[*] role " + encodeWord(tarRoleName) + "\n";
								}
								else if (ref.getUpperBound() == -1) {
									useText += "\t" + encodeWord(refETypeName) + "[" + ref.getLowerBound() + "..*] role " + encodeWord(tarRoleName) + "\n";
								}
								else if (ref.getLowerBound() != ref.getUpperBound()) {
									useText += "\t" + encodeWord(refETypeName) + "[" + ref.getLowerBound() + ".." + ref.getUpperBound() + "] role " + encodeWord(tarRoleName) + "\n"; 
								}
								else if (ref.getLowerBound() == ref.getUpperBound()) {
									useText += "\t" + encodeWord(refETypeName) + "[" + ref.getLowerBound() + "] role " + encodeWord(tarRoleName) + "\n";
								}
								useText += "end\n";
							}
						}
					}
				}

				if (e.getCommands().size() > 0) {
					mutatorDependencies = new MutatorDependencies(packages, e.getCommands());
					compile(model, e.getCommands(), rootClass, packages, classNames, constraints, "MAIN", useReferences);
				}
				
				if (e.getBlocks().size() > 0) {
					for (Block b : e.getBlocks()) {
						mutatorDependencies = new MutatorDependencies(packages, b.getCommands());
						compile(model, b.getCommands(), rootClass, packages, classNames, constraints, b.getName(), useReferences);
					}
				}
						
				useText += "constraints\n";
				//useText += compositionConstraint(packages, references, useReferences, classNames);
//				for (EReference ref : references) {
//					useText += compositionConstraint(ref, useReferences, classNames);
//				}
				useText += ensureContainer(packages, classes, useReferences, classNames);
				//useText += ensureCardinalities(packages, classes, useReferences, classNames);
				useText += "context " + dummyClassName + "\n";
				int i = 0;
				for (EClass eClass : classes) {
					List<EAnnotation> annotations = eClass.getEAnnotations();
					if (annotations.size() > 0) {
						for (EAnnotation a : annotations) {
							if (a.getSource().equals("http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"));
							EMap<String, String> oclmap = a.getDetails();
							Set<String> keys = oclmap.keySet();
							if (keys.size() > 0) {
								for (String key : keys) {
									String ocl = oclmap.get(key);
									if (ocl.indexOf("self.") != -1 && ocl.indexOf("->") != -1) {
										String refName = ocl.substring(ocl.indexOf("self.") + "self.".length(), ocl.indexOf("->"));
										Constraint constraint = new Constraint();
										for (EReference ref : eClass.getEReferences()) {
											if (ref.getName().equals(refName)) {
												if (classNames.get(EcoreUtil.getURI(ref.getEType())) != null) {
													String refETypeName = classNames.get(EcoreUtil.getURI(ref.getEType()));
													constraint.text = ocl.replace("self." + refName, refETypeName + ".allInstances()");
													constraint.type = "metamodel";
													constraint.className = ref.getEType().getName();
													if (getConstraint(constraints, constraint) == null && (constraint.text.length() > 0)) {
														addConstraint(constraints, constraint);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				for (Constraint constraint : constraints) {
					i++;
					if (constraint.type.equals("size")) {
						useText += "inv mut" + i + " : " + constraint.text + " > " + maxSize(constraint) + "\n";
						maxSize.put(constraint.text.substring(0, constraint.text.indexOf(".")), maxSize(constraint) + 1);
					}
					else {
						useText += "inv mut" + i + " : " + constraint.text + "\n";
					}
				}
			} catch (MetaModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return useText;
		}
		
		/**
		 * Build USE class names
		 * @param classes
		 * @return
		 */
		public static HashMap<URI, String> buildClassNames(List<EClass> classes) {
			HashMap<URI, String> classNames = new HashMap<URI, String>();
			
			for (EClass eClass : classes) {
				EPackage pck = eClass.getEPackage();
				String clName = pck.getName() + "XxxX" + eClass.getName();
				classNames.put(EcoreUtil.getURI(eClass), clName);
			}
			return classNames;
		}
	}
