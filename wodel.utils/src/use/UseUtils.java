package use;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import manager.ModelManager;
import mutator.MutatorUtils;
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
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.StringType;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.MetaModelNotFoundException;
import exceptions.ReferenceNonExistingException;

public class UseUtils {
	
	public static String[] useWords = { "model", "constraints", "enum", "abstract", "class", "attributes", "operations", "end", "association", 
		"composition", "aggregation", "between", "role", "ordered", "associationclass", "context", "inv", "pre",
		"post", "Set", "Bag", "Sequence", "Integer", "Real", "Boolean", "String", "from", "min", "max", "states", "transitions"};
	
	private static class Constraint {
		String name = "";
		String text = "";
		HashMap<String, Integer> sizeByBlock = new HashMap<String, Integer>();
		String type = "";
		List<String> variables = new ArrayList<String>();
		String className = ""; 
	}
	
	private static class Mandatory {
		String className = "";
		String featureName = "";
		String value = "";
		String type = "";
	}

	private static HashMap<String, Boolean> closures = new HashMap<String, Boolean>();
	
	private static String dummyClassName = "Dummy";
	
	private static MutatorDependencies mutatorDependencies;
	
	private static HashMap<String, HashMap<String, List<Constraint>>> mutConstraint = new HashMap<String, HashMap<String, List<Constraint>>>();

	private static String getUniqueName(String newName, List<String> names, int n) {
	   	String returnName = newName;
	   	ArrayList<String> nextNames = new ArrayList<String>();
	   	if (names.size() > 0) {
	   		if (names.contains(newName)) {
	   			returnName = newName + n;
	   			nextNames.addAll(names);
	   			nextNames.remove(newName);
	   			returnName = getUniqueName(returnName, nextNames, n + 1);
	   		}
	   	}
	   	return returnName;
	}
	
	private static int maxSize(Constraint constraint) {
		int max = 0;
		for (String blockName : constraint.sizeByBlock.keySet()) {
			if (constraint.sizeByBlock.get(blockName) > max) {
				max = constraint.sizeByBlock.get(blockName);
			}
		}
		return max;
	}

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
	
	private static void getSizeConstraints(EClass rootClass, EClass eClass, List<EPackage> packages, List<Constraint> constraints, boolean inc, EReference ref, String blockName, String mutName, boolean isContainer) {
		try {
			Constraint constraint = new Constraint();
			constraint.text = encodeWord(eClass.getName()) + ".allInstances()->size()";
			constraint.name = mutName; 
			constraint.type = "size";
			constraint.className = eClass.getName();
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
					constraints.add(constraint);
					List<EClassifier> containers = ModelManager.getContainerTypes(packages, eClass.getName());
					if (containers.size()	== 1) {
						EClass container = (EClass) containers.get(0);
						EReference contRef;
						contRef = ModelManager.getContainingReference(container, eClass);
						getSizeConstraints(rootClass, container, packages, constraints, containerInc, contRef, blockName, "", true);
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
					List<EClassifier> containers = ModelManager.getContainerTypes(packages, eClass.getName());
					if (containers.size() == 1) {
						EClass container = (EClass) containers.get(0);
						EReference contRef = ModelManager.getContainingReference(container, eClass);
						getSizeConstraints(rootClass, container, packages, constraints, containerInc, contRef, blockName, "", true);
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getClassName(ObSelectionStrategy object) {
		String className = "";
		if (object != null) {
       		if (object instanceof RandomTypeSelection) {
   				className = object.getType().getName();
   			}
   			if (object instanceof CompleteTypeSelection) {
       			className = object.getType().getName();
       		}
			if (object instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) object;
				if (selection.getObjSel() instanceof CreateObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectObjectMutator) {
					className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					ModifyInformationMutator modifyMutator = (ModifyInformationMutator) selection.getObjSel();
					if (modifyMutator.getObject() instanceof RandomTypeSelection) {
						className = modifyMutator.getObject().getType().getName();
					}
					if (modifyMutator.getObject() instanceof CompleteTypeSelection) {
						className = modifyMutator.getObject().getType().getName();
					}
					if (modifyMutator.getObject() instanceof SpecificObjectSelection) {
						className = getClassName(modifyMutator.getObject());
					}
					if (modifyMutator.getObject() instanceof SpecificClosureSelection) {
						className = getClassName(modifyMutator.getObject());						
					}
				}
			}
   			if (object instanceof SpecificClosureSelection) {
    	   		SpecificClosureSelection selection = (SpecificClosureSelection) object;
	     		if (selection.getObjSel() instanceof CreateObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectObjectMutator) {
       				className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				className = selection.getObjSel().getType().getName();
    	   		}
    	   		if (selection.getObjSel() instanceof ModifyInformationMutator) {
					className = selection.getObjSel().getType().getName();
				}
	       	}
       	}
		return className;
	}
	
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
		constraints.add(constraint);
		nameConstraint.put(mutName, constraints);
		mutConstraint.put(blockName, nameConstraint);
	}

	public static HashMap<String, HashMap<String, String>> getUseReferences(List<EPackage> packages) {
		HashMap<String, HashMap<String, String>> useReferences = new HashMap<String, HashMap<String, String>>();
		HashMap<String, Integer> associationNames = new HashMap<String, Integer>();
		HashMap<String, Integer> roleNames = new HashMap<String, Integer>();
		for (EClass eClass : ModelManager.getEClasses(packages)) {
			List<EReference> refs = eClass.getEReferences();
			if (refs.size() > 0) {
				for (EReference ref : refs) {
					String associationName = eClass.getName() + ref.getEType().getName();
					if (associationNames.get(associationName) != null) {
						associationNames.put(associationName, associationNames.get(associationName) + 1);
						associationName += associationNames.get(associationName);
					}
					else {
						associationNames.put(associationName, 0);
					}
					String srcRoleName = eClass.getName().toLowerCase() + ref.getEType().getName().toLowerCase();
					if (roleNames.get(srcRoleName) != null) {
						roleNames.put(srcRoleName, roleNames.get(srcRoleName) + 1);
						srcRoleName += roleNames.get(srcRoleName);
					}
					else {
						roleNames.put(srcRoleName, 0);
					}
					HashMap<String, String> useReference = null;
					String tarRoleName = ref.getName();
					if (useReferences.get(eClass.getName()) != null) {
						useReference = useReferences.get(eClass.getName());
					}
					else {
						useReference = new HashMap<String, String>();
					}
					if (roleNames.get(tarRoleName) != null) {
						roleNames.put(tarRoleName, roleNames.get(tarRoleName) + 1);
						tarRoleName += roleNames.get(tarRoleName);
					}
					else {
						roleNames.put(tarRoleName, 0);
					}
					useReference.put(ref.getName(), tarRoleName);
					useReferences.put(eClass.getName(), useReference);
				}
			}
		}
		return useReferences;
	}
	
	public static String getUseReference(EReference ref, HashMap<String, HashMap<String, String>> useReferences) {
		String refName = "";
		EClass container = (EClass) ref.eContainer();
		if (useReferences.get(container.getName()) != null && useReferences.get(container.getName()).get(ref.getName()) != null) {
			refName = useReferences.get(container.getName()).get(ref.getName());
		}
		else {
			refName = ref.getName();
		}
		return refName;
	}
	
	public static String encodeWord(String word) {
		if (Arrays.asList(useWords).contains(word)) {
			return word + "_";
		}
		return word;
	}

	public static String decodeWord(String word) {
		if (word.endsWith("_")) {
			if (Arrays.asList(useWords).contains(word.substring(0, word.length() - 2))) {
				return word.substring(0, word.length() - 2);
			}
		}
		return word;
	}
	// constraint: an object cannot be contained in two containers
	// [NOTE: we do this because the USE Validator does not take into account the semantics of composition]
	public static String compositionConstraint (List<EReference> references) {
		String constraints = "";

		// obtain the containment references that can contain each class
		Hashtable<String,List<EReference>> containers = new Hashtable<String,List<EReference>>();
		for (EReference ref : references) {
			if (ref.isContainment()) {
				String classname = ref. getEReferenceType().getName();
				if (!containers.containsKey(classname))
					containers.put(classname, new ArrayList<EReference>());
				containers.get(classname).add(ref);
			}
			if (ref.getEOpposite()!=null &&
					ref.getEOpposite().isContainment()) {
				String classname =
						ref.getEOpposite().getEReferenceType().getName();
				if (!containers.containsKey(classname))
					containers.put(classname, new ArrayList<EReference>());
				containers.get(classname).add(ref.getEOpposite());
			}
		}

		// if a class can potentially be in more than two containers, add a constraint
		for (Entry<String,List<EReference>> entry : 
			containers.entrySet()) {
			if (entry.getValue().size()>1) {
				constraints += "\n\ncontext " + entry.getKey() + " inv single_container:\n";
				for (EReference ref : entry.getValue())
					constraints += "\t" +
							ref.getEContainingClass().getName() + ".allInstances()->collect(o | o." 
							+ ref.getName() + ")->count(self) +\n";
				constraints = constraints.substring(0,
						constraints.lastIndexOf("+")) + "<= 1";
			}
		}
		if (!constraints.isEmpty()) constraints += "\n";

		return constraints;
	}
	
	// constraint: an object cannot be contained itself through a composition relation, directly or indirectly
	// [NOTE: we do this because the USE Validator does not take into account the semantics of composition]
	public static String compositionConstraint (EReference ref) {
		String constraint = "";

		if (ref!=null && ref.isContainment() &&
				(ref.getEContainingClass()==ref.getEReferenceType() ||
				ref.getEContainingClass().getESuperTypes().contains(ref.getEReferenceType())))
		{
			List<String> terms = new ArrayList<String>();
			int      num_terms = 5;
			String   type      = ref.getEContainingClass().getName();
			String   setOpen   = ref.getUpperBound()==1? "Set{":""; //add monovalued features to a set
			String   setClose  = ref.getUpperBound()==1? "}"   :"";
			for (int term=1; term<=num_terms; term++)    {
				String expression = "";
				for (int index=1; index<=term; index++) {
					if (index==1) {
						expression = setOpen + (index<term? 
								ref.getName() + index + ".oclAsType(" + type + ")." : "self.") +
								ref.getName() + setClose + "->includes(self)";
					}
					else {
						String select1 = "", select2 = "";
						if (index>1) {
							select1 = setOpen + (index<term? 
									ref.getName() + index + ".oclAsType(" + type + ")." : "self.") +
									ref.getName() + setClose + "->exists(" + ref.getName() + (index-1) + " |\n";
							select2 = ")";
						}
						expression = select1 +
								"if " + ref.getName() + (index-1) + ".oclIsKindOf(" + type + ") then\n" +
								"\t" + expression + "\n" +
								"\t else false endif" +
								select2;
					}
				}
				terms.add("not " + expression);
			}

			constraint = "\n\ncontext " +
					ref.getEContainingClass().getName() + " inv non_contains_itself_" +
					ref.getName() + ":\n";
			for (String term : terms) constraint += term + "\nand\n";
			constraint = constraint.substring(0,
					constraint.lastIndexOf("and")) + "\n";
		}

		return constraint;
	}
	
	private static void subsume(List<Constraint> constraints, Constraint constraint) {
 		if (constraint != null && !constraint.text.equals("")) {
			for (Constraint c : constraints) {
				if (c.type.equals("exists")) {
					String clause1 = c.text.substring(c.text.indexOf("exists(") + "exists(".length(), c.text.lastIndexOf(")"));
					if (c.variables != null && c.variables.size() > 1 && constraint.variables != null && constraint.variables.size() > 1) {
						String v1 = c.variables.get(0);
						String v2 = c.variables.get(1);
						String clause2 = constraint.text.substring(constraint.text.indexOf("exists(") + "exists(".length(), constraint.text.lastIndexOf(")"));
						String v3 = constraint.variables.get(1);
						String newClause = clause2.replace("| ", "| " + clause1.substring(clause1.indexOf("|") + 1, clause1.length()) + " and ");
						newClause = newClause.replace(newClause.substring(0, newClause.indexOf("|") + 1), clause1.substring(0, clause1.indexOf("|") + 1));
						newClause = newClause.replace(v3, v2);
						System.out.println(newClause);
						constraint.variables.remove(1);
						constraint.variables.add(v2);
						constraint.text = c.text.replace(clause1, newClause);
						System.out.println(constraint.text);
						constraints.remove(c);
						constraints.add(constraint);
						return;
					}
				}
			}
		}
	}
	
	private static Constraint join(List<Constraint> constraints, Constraint constraint, String className, String mutatorName) {
		if (constraint != null && !constraint.text.equals("")) {
			Constraint c = null; 
			for (Constraint cnst : constraints) {
				if (cnst.type.equals("exists") && cnst.className.equals(className) && cnst.name.length() > 0 && cnst.name.equals(mutatorName)) {
					c = cnst;
				}
			}
			if (c == null) {
				for (Constraint cnst : constraints) {
					if (cnst.type.equals("exists") && cnst.className.equals(className)) {
						c = cnst;
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
					String newClause = constraint.text.substring(0, constraint.text.indexOf("| ") + "| ".length()) + c.text.substring(0, c.text.lastIndexOf(")")) + " and " + clause1.substring(clause1.indexOf("| ") + "| ".length(), clause1.length()) + " and " + clause2.substring(clause2.indexOf("| ") + "| ".length(), clause2.length()) + "))";
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
					System.out.println(constraint.text);
					return constraint;
				}
			}
		}
		return null;
	}
	
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
				System.out.println(constraint.text);
				constraints.remove(c);
			}
		}
		constraints.add(constraint);
	}

	private static void compile(Expression exp, String className, List<Constraint> constraints, String blockName, String mutName, HashMap<String, HashMap<String, String>> useReferences)
	{
		List<Constraint> expConstraints = new ArrayList<Constraint>();
		if (exp.getFirst() instanceof AttributeEvaluation) {
			if (((AttributeEvaluation) exp.getFirst()).getValue() instanceof AttributeType) {
				AttributeEvaluation attev = (AttributeEvaluation) exp.getFirst();
				String operator = "";
				Constraint attConstraint = new Constraint();
				attConstraint.name = mutName;
				attConstraint.type = "exists";
				attConstraint.className = className;
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
				if (getConstraint(constraints, attConstraint) == null && getConstraint(expConstraints, attConstraint) == null) {
					expConstraints.add(attConstraint);
				}
			}
		}
		if (exp.getFirst() instanceof ReferenceEvaluation) {
			ReferenceEvaluation refev = (ReferenceEvaluation) exp.getFirst();
			String operator = "";
			String v1 = className.substring(0, 1).toLowerCase() + "0";
			String v2 = className.substring(0, 1).toLowerCase() + "1";
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
				Constraint refConstraint = new Constraint();
				refConstraint.name = mutName;
				refConstraint.type = "exists";
				refConstraint.className = className;
				if (refev.getValue() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) refev.getValue();
					// if this mutation refers to previous one
					if (mutConstraint.get(blockName) != null && mutConstraint.get(blockName).get(selection.getObjSel().getName()) != null) {
						List<Constraint> referedConstraints = mutConstraint.get(blockName).get(selection.getObjSel().getName());
						for (Constraint referedConstraint : referedConstraints) {
							if (referedConstraint.type.equals("exists") && referedConstraint.className.equals(className)) {
								String vref = referedConstraint.variables.get(0);
								String constraintText = referedConstraint.text.replaceAll(vref + " ", v2 + " ").replaceAll(vref + "[.]", v2 + ".").replaceAll(vref + "[)]", v2 + ")");
								refConstraint.text = className + ".allInstances()->exists(" + v1 + " | " + constraintText.substring(0, constraintText.length() - 1) + " and " + v1 + " " + operator + " " + v2 + "))";
								refConstraint.variables.add(v1);
								refConstraint.variables.add(v2);
								if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
									expConstraints.add(refConstraint);
								}
							}
						}
					}
					else {
						refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
						refConstraint.variables.add(v1);
						refConstraint.variables.add(v2);
						if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
							expConstraints.add(refConstraint);
						}
					}
				}
				else {
					refConstraint.text = className + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
					refConstraint.variables.add(v1);
					refConstraint.variables.add(v2);
					if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
						expConstraints.add(refConstraint);
					}
				}
			}
			else {
				String refName = getUseReference(refev.getName(), useReferences);
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
							String innerRefName = getUseReference(refev.getRefName(), useReferences);
							if (refev.getRefName().getUpperBound() > 1 || refev.getRefName().getUpperBound() == -1) {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + "->size() > 0))";
							}
							else {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + " " + operator + " null))";
							}
							refConstraint.variables.add(v1);
							refConstraint.variables.add(v3);
						}
						if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
							expConstraints.add(refConstraint);
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
							if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
								String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
					else {
						String targetClassName = null;
						if (selection instanceof RandomTypeSelection) {
							targetClassName = ((RandomTypeSelection) refev.getValue()).getType().getName();
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
						if (selection instanceof SpecificObjectSelection) {
							if (refev.getRefName() == null) {
								String v3 = className.substring(0, 1).toLowerCase() + "2";
								if (selection.getRefType() == null) {
									if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
										String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
										String refMutName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getName();
										String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
										if (multiple == false) {
											refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + v3 + "." + encodeWord(refName) + " " + operator + " " + v4 + ")";
											refConstraint.variables.add(v3);
											refConstraint.variables.add(v4);
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
									if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
										String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
									else {
										String selectionRefName =  getUseReference(selection.getRefType(), useReferences);
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
								String ref1Name =  getUseReference(refev.getRefName(), useReferences);
								String ref2Name =  getUseReference(selection.getRefType(), useReferences);
								String v3 = className.substring(0, 1).toLowerCase() + "2";
								if ((((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator) && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
									String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
					if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
						expConstraints.add(refConstraint);
					}
				}
			}
		}
		if (exp.getSecond() != null) {
			for (Evaluation ev : exp.getSecond()) {
				if (ev instanceof AttributeEvaluation) {
					AttributeEvaluation attev = (AttributeEvaluation) ev;
					String operator = "";
					Constraint attConstraint = new Constraint();
					attConstraint.name = mutName;
					attConstraint.type = "exists";
					attConstraint.className = className;
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
					if (getConstraint(constraints, attConstraint) == null && getConstraint(expConstraints, attConstraint) == null) {
						expConstraints.add(attConstraint);
					}
				}
				if (ev instanceof ReferenceEvaluation) {
					ReferenceEvaluation refev = (ReferenceEvaluation) ev;
					String operator = "";
					String v1 = className.substring(0, 1).toLowerCase() + "0";
					String v2 = className.substring(0, 1).toLowerCase() + "1";
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
						Constraint refConstraint = new Constraint();
						refConstraint.name = mutName;
						refConstraint.type = "exists";
						refConstraint.className = className;
						if (refev.getValue() instanceof SpecificObjectSelection) {
							SpecificObjectSelection selection = (SpecificObjectSelection) refev.getValue();
							// if this mutation refers to previous one
							if (mutConstraint.get(blockName) != null && mutConstraint.get(blockName).get(selection.getObjSel().getName()) != null) {
								List<Constraint> referedConstraints = mutConstraint.get(blockName).get(selection.getObjSel().getName());
								for (Constraint referedConstraint : referedConstraints) {
									if (referedConstraint.type.equals("exists") && referedConstraint.className.equals(className)) {
										String vref = referedConstraint.variables.get(0);
										String constraintText = referedConstraint.text.replaceAll(vref + " ", v2 + " ").replaceAll(vref + "[.]", v2 + ".").replaceAll(vref + "[)]", v2 + ")");
										refConstraint.text = className + ".allInstances()->exists(" + v1 + " | " + constraintText.substring(0, constraintText.length() - 1) + " and " + v1 + " " + operator + " " + v2 + "))";
										refConstraint.variables.add(v1);
										refConstraint.variables.add(v2);
										if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
											expConstraints.add(refConstraint);
										}
									}
								}
							}
							else {
								refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
								refConstraint.variables.add(v1);
								refConstraint.variables.add(v2);
								if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
									include(expConstraints, refConstraint);
								}
							}
						}
						else {
							refConstraint.text = className + ".allInstances()->exists(" + v1 + ", " + v2 + " | " + v1 + " " + operator + " " + v2 + ")";  
							refConstraint.variables.add(v1);
							refConstraint.variables.add(v2);
							if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
								expConstraints.add(refConstraint);
							}
						}
					}
					else {
						String refName = getUseReference(refev.getName(), useReferences);
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
									String innerRefName = getUseReference(refev.getRefName(), useReferences);
									if (refev.getRefName().getUpperBound() > 1 || refev.getRefName().getUpperBound() == -1) {
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + "->size() > 0))";
									}
									else {
										refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v1 + " | " + v1 + "." + encodeWord(refName) + "->exists(" + v3 + " | " + v3 + "." + encodeWord(innerRefName) + " " + operator + " null))";
									}
									refConstraint.variables.add(v1);
									refConstraint.variables.add(v3);
								}
								if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
									expConstraints.add(refConstraint);
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
									if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
										String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
							else {
								String targetClassName = null;
								if (selection instanceof RandomTypeSelection) {
									targetClassName = ((RandomTypeSelection) refev.getValue()).getType().getName();
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
								if (selection instanceof SpecificObjectSelection) {
									if (refev.getRefName() == null) {
										String v3 = className.substring(0, 1).toLowerCase() + "2";
										if (selection.getRefType() == null) {
											if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
												String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
												String refMutName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getName();
												String v4 = refClassName.substring(0, 1).toLowerCase() + "3";
												if (multiple == false) {
													refConstraint.text = encodeWord(className) + ".allInstances()->exists(" + v3 + " | " + v3 + "." + encodeWord(refName) + " " + operator + " " + v4 + ")";
													refConstraint.variables.add(v3);
													refConstraint.variables.add(v4);
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
											if (((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
												String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
											else {
												String selectionRefName =  getUseReference(selection.getRefType(), useReferences);
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
										String ref1Name =  getUseReference(refev.getRefName(), useReferences);
										String ref2Name =  getUseReference(selection.getRefType(), useReferences);
										String v3 = className.substring(0, 1).toLowerCase() + "2";
										if ((((SpecificObjectSelection) selection).getObjSel() instanceof SelectObjectMutator) && !((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName().equals(className)) {
											String refClassName = ((SelectObjectMutator) ((SpecificObjectSelection) selection).getObjSel()).getObject().getType().getName();
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
							if (getConstraint(constraints, refConstraint) == null && refConstraint.text.length() > 0 && getConstraint(expConstraints, refConstraint) == null) {
								subsume(expConstraints, refConstraint);
							}
						}
					}
				}
			}
		}
		for (Constraint constraint : expConstraints) {
			constraints.add(constraint);
			storeMutatorName(constraint, blockName, mutName);
		}
	}
	
	public static void compile(Expression exp, String className, List<AttributeSet> attributes, List<Constraint> constraints, String blockName, String mutName, HashMap<String, HashMap<String, String>> useReferences) {
		if (exp.getFirst() instanceof AttributeEvaluation) {
			if (((AttributeEvaluation) exp.getFirst()).getValue() instanceof AttributeType) {
				AttributeEvaluation attev = (AttributeEvaluation) exp.getFirst();
				String operator = "";
				Constraint attConstraint = new Constraint();
				attConstraint.name = mutName;
				attConstraint.className = className;
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
					if (getConstraint(constraints, attConstraint) == null) {
						constraints.add(attConstraint);
						storeMutatorName(attConstraint, blockName, mutName);
					}
				}
			}
		}
		if (exp.getSecond() != null) {
			for (Evaluation ev : exp.getSecond()) {
				if (ev instanceof AttributeEvaluation) {
					AttributeEvaluation attev = (AttributeEvaluation) ev;
					String operator = "";
					Constraint attConstraint = new Constraint();
					attConstraint.name = mutName;
					attConstraint.className = className;
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
						if (getConstraint(constraints, attConstraint) == null) {
							constraints.add(attConstraint);
							storeMutatorName(attConstraint, blockName, mutName);
						}
					}
				}
			}
		}
	}


	public static void compile(List<ReferenceSet> references, List<Constraint> constraints, String blockName, String mutName, HashMap<String, HashMap<String, String>> useReferences) {
		for (ReferenceSet ref : references) {
			Constraint constraint = new Constraint();
			constraint.name = mutName;
			String className = "";
			if (ref.getObject() != null) {
				constraint.type = "size";
        		if (ref.getObject() instanceof RandomTypeSelection) {
       				className = encodeWord(ref.getObject().getType().getName());
    	   			if (ref.getObject().getExpression() != null) {
	       				compile(ref.getObject().getExpression(), className, constraints, blockName, mutName, useReferences);
       				}
       			}
       			if (ref.getObject() instanceof CompleteTypeSelection) {
       				className = encodeWord(ref.getObject().getType().getName());
       			}
				if (ref.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) ref.getObject(); 
					if (selection.getObjSel() instanceof CreateObjectMutator == false) {
						if (selection.getObjSel() instanceof SelectObjectMutator) {
							className = encodeWord(((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName());
						}
						if (selection.getObjSel() instanceof SelectSampleMutator) {
							className = encodeWord(MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel()));
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = encodeWord(selection.getObjSel().getType().getName());
						}
						if (selection.getObjSel() instanceof ModifyInformationMutator) {
							ModifyInformationMutator modifyMutator = (ModifyInformationMutator) selection.getObjSel();
							if (modifyMutator.getObject() instanceof RandomTypeSelection) {
								className = encodeWord(modifyMutator.getObject().getType().getName());
							}
							if (modifyMutator.getObject() instanceof CompleteTypeSelection) {
								className = encodeWord(modifyMutator.getObject().getType().getName());
							}
							if (modifyMutator.getObject() instanceof SpecificObjectSelection) {
								className = encodeWord(getClassName(((SpecificObjectSelection) modifyMutator.getObject())));
							}
							if (modifyMutator.getObject() instanceof SpecificClosureSelection) {
								className = encodeWord(getClassName(modifyMutator.getObject()));						
							}
						}
					}
				}
       			if (ref.getObject() instanceof SpecificClosureSelection) {
    	   			SpecificClosureSelection selection = (SpecificClosureSelection) ref.getObject();
	     			if (selection.getObjSel() instanceof CreateObjectMutator == false) {
       					if (selection.getObjSel() instanceof SelectObjectMutator) {
       						className = encodeWord(((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName());
       					}
       					if (selection.getObjSel() instanceof SelectSampleMutator) {
							className = encodeWord(MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel()));
						}
       					if (selection.getObjSel() instanceof CloneObjectMutator) {
       						className = encodeWord(selection.getObjSel().getType().getName());
    	   				}
    	   				if (selection.getObjSel() instanceof ModifyInformationMutator) {
							className = encodeWord(selection.getObjSel().getType().getName());
						}
	       			}
	       		}
	       		if (className.length() > 0) {
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
       					className = object.getType().getName();
    	   				if (object.getExpression() != null) {
	       					compile(object.getExpression(), className, constraints, blockName, mutName, useReferences);
       					}
       				}
       				if (object instanceof CompleteTypeSelection) {
       					className = encodeWord(object.getType().getName());
       					if (object.getExpression() != null) {
       						compile(object.getExpression(), className, constraints, blockName, mutName, useReferences);
       					}
       				}
					if (object instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) object;
						if (selection.getObjSel() instanceof CreateObjectMutator == false) {
							if (selection.getObjSel() instanceof SelectObjectMutator) {
								className = encodeWord(((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName());
							}
							if (selection.getObjSel() instanceof SelectSampleMutator) {
								className = encodeWord(MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel()));
							}
							if (selection.getObjSel() instanceof CloneObjectMutator) {
								className = encodeWord(selection.getObjSel().getType().getName());
							}
							if (selection.getObjSel() instanceof ModifyInformationMutator) {
								className = encodeWord(selection.getObjSel().getType().getName());
							}
						}
					}
       				if (object instanceof SpecificClosureSelection) {
    	   				SpecificClosureSelection selection = (SpecificClosureSelection) object;
	     				if (selection.getObjSel() instanceof CreateObjectMutator == false) {
	       					if (selection.getObjSel() instanceof SelectObjectMutator) {
    	   						className = encodeWord(((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName());
       						}
       						if (selection.getObjSel() instanceof SelectSampleMutator) {
								className = encodeWord(MutatorUtils.selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel()));
							}
       						if (selection.getObjSel() instanceof CloneObjectMutator) {
       							className = encodeWord(selection.getObjSel().getType().getName());
    	   					}
    	   					if (selection.getObjSel() instanceof ModifyInformationMutator) {
								className = encodeWord(selection.getObjSel().getType().getName());
							}
	       				}
	       			}
	       			if (className.length() > 0) {
						constraint.text = encodeWord(className) + ".allInstances()->size()";
						constraint.className = className;
	   				}
       			}
       		}
			if (constraint.text.length() > 0) {
				if (getConstraint(constraints, constraint) == null) {
					constraints.add(constraint);
					storeMutatorName(constraint, blockName, mutName);
				}
			}
		}
	}
	
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
								if (selection.getObjSel() instanceof CreateObjectMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof SelectObjectMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof SelectSampleMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof CloneObjectMutator) {
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
    	 						if (selection.getObjSel() instanceof CreateObjectMutator) {
	       							if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
       							}
       							if (selection.getObjSel() instanceof SelectObjectMutator) {
       								if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
       							}
       							if (selection.getObjSel() instanceof SelectSampleMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
       							if (selection.getObjSel() instanceof CloneObjectMutator) {
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
								if (selection.getObjSel() instanceof CreateObjectMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof SelectObjectMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof SelectSampleMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
								if (selection.getObjSel() instanceof CloneObjectMutator) {
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
    	 						if (selection.getObjSel() instanceof CreateObjectMutator) {
	       							if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
       							}
       							if (selection.getObjSel() instanceof SelectObjectMutator) {
       								if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
       							}
       							if (selection.getObjSel() instanceof SelectSampleMutator) {
									if (value.getObjSel().getName().equals(selection.getObjSel().getName())) {
										return false;
									}
									else {
										return true;
									}
								}
       							if (selection.getObjSel() instanceof CloneObjectMutator) {
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

	
	private static void compile(Expression exp, String className, List<AttributeSet> attributes, List<Constraint> constraints, String blockName, String mutName) {
		if (exp.getFirst() instanceof AttributeEvaluation) {
			if (((AttributeEvaluation) exp.getFirst()).getValue() instanceof AttributeType) {
				AttributeEvaluation attev = (AttributeEvaluation) exp.getFirst();
				String operator = "";
				Constraint attConstraint = new Constraint();
				attConstraint.name = mutName;
				attConstraint.className = className;
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
					if (getConstraint(constraints, attConstraint) == null) {
						constraints.add(attConstraint);
						storeMutatorName(attConstraint, blockName, mutName);
					}
				}
			}
		}
		if (exp.getSecond() != null) {
			for (Evaluation ev : exp.getSecond()) {
				if (ev instanceof AttributeEvaluation) {
					if (((AttributeEvaluation) ev).getValue() instanceof AttributeType) {
						AttributeEvaluation attev = (AttributeEvaluation) ev;
						String operator = "";
						Constraint attConstraint = new Constraint();
						attConstraint.name = mutName;
						attConstraint.className = className;
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
							if (getConstraint(constraints, attConstraint) == null) {
								constraints.add(attConstraint);
								storeMutatorName(attConstraint, blockName, mutName);
							}
						}
					}
				}
			}
		}
	}

	
	public static void compile(List<Mutator> commands, EClass rootClass, List<EPackage> packages, List<String> classNames, List<Constraint> constraints, String blockName, HashMap<String, HashMap<String, String>> useReferences) {
		for (Mutator mut : commands) {
			Integer times = mutatorDependencies.needsOCLConstraints(mut);
			if (times != null && times > 0) {
				String mutName = MutatorUtils.getMutatorName(mut);
				if (mut instanceof CreateObjectMutator) {
					if (mut.getType() != null) {
						String name = mut.getType().getName();
						List<EClassifier> containers = ModelManager.getContainerTypes(packages, name);
						for (EClassifier container : containers) {
							EReference containerReference = null;
							for (EReference ref : ((EClass) container ).getEAllReferences()) {
								if (ref.getEType().getName().equals(name) && ref.isContainment()) {
									containerReference = ref;
								}
							}
							if (containerReference != null) {
								if (classNames.contains(container.getName())) {
									getSizeConstraints(rootClass, (EClass) container, packages, constraints, false, null, blockName, mutName, false);
								}
							}
						}
						if (((CreateObjectMutator) mut).getReferences() != null) {
							compile(((CreateObjectMutator) mut).getReferences(), constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof RemoveObjectMutator) {
					if (((RemoveObjectMutator) mut).getObject() != null) {
						String name = MutatorUtils.getTypeName(((RemoveObjectMutator) mut).getObject());
						if (classNames.contains(name)) {
							for (int i = 0; i < times; i++) {
								getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
							}
						}
						if (((RemoveObjectMutator) mut).getObject().getExpression() != null) {
							compile(((RemoveObjectMutator) mut).getObject().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof CreateReferenceMutator) {
					if (((CreateReferenceMutator) mut).getTarget() != null) {
						String name = MutatorUtils.getTypeName(((CreateReferenceMutator) mut).getTarget());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((CreateReferenceMutator) mut).getTarget().getExpression() != null) {
							compile(((CreateReferenceMutator) mut).getTarget().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
					if (((CreateReferenceMutator) mut).getSource() != null) {
						String name = MutatorUtils.getTypeName(((CreateReferenceMutator) mut).getSource());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((CreateReferenceMutator) mut).getSource().getExpression() != null) {
							compile(((CreateReferenceMutator) mut).getSource().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof ModifySourceReferenceMutator) {
					if (((ModifySourceReferenceMutator) mut).getSource() != null) {
						String name = MutatorUtils.getTypeName(((ModifySourceReferenceMutator) mut).getSource());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((ModifySourceReferenceMutator) mut).getSource().getExpression() != null) {
							compile(((ModifySourceReferenceMutator) mut).getSource().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
					if (((ModifySourceReferenceMutator) mut).getNewSource() != null) {
						String name = MutatorUtils.getTypeName(((ModifySourceReferenceMutator) mut).getNewSource());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((ModifySourceReferenceMutator) mut).getNewSource().getExpression() != null) {
							compile(((ModifySourceReferenceMutator) mut).getNewSource().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof ModifyTargetReferenceMutator) {
					if (((ModifyTargetReferenceMutator) mut).getSource() != null) {
						String name = MutatorUtils.getTypeName(((ModifyTargetReferenceMutator) mut).getSource());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((ModifyTargetReferenceMutator) mut).getSource().getExpression() != null) {
							compile(((ModifyTargetReferenceMutator) mut).getSource().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
					if (((ModifyTargetReferenceMutator) mut).getNewTarget() != null) {
						String name = MutatorUtils.getTypeName(((ModifyTargetReferenceMutator) mut).getNewTarget());
						if (classNames.contains(name)) {
							if (((ModifyTargetReferenceMutator) mut).getNewTarget() instanceof OtherTypeSelection) {
								getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, true, null, blockName, mutName, false);
							}
							else {
								getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
							}
						}
						if (((ModifyTargetReferenceMutator) mut).getNewTarget().getExpression() != null) {
							compile(((ModifyTargetReferenceMutator) mut).getNewTarget().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof RemoveCompleteReferenceMutator) {
					if (((RemoveCompleteReferenceMutator) mut).getType() != null) {
						String name = mut.getType().getName();
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
					}
				}
				if (mut instanceof SelectObjectMutator) {
					if (((SelectObjectMutator) mut).getObject() != null) {
						String name = MutatorUtils.getTypeName(((SelectObjectMutator) mut).getObject());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((SelectObjectMutator) mut).getObject().getExpression() != null) {
							compile(((SelectObjectMutator) mut).getObject().getExpression(), name, constraints, blockName, mutName, useReferences);
						}
						if (((SelectObjectMutator) mut).getContainer() != null) {
							if (((SelectObjectMutator) mut).getContainer() instanceof SpecificClosureSelection) {
								closures.put(name, true);
							}
						}
					}
				}
				if (mut instanceof SelectSampleMutator) {
					if (((SelectSampleMutator) mut).getObject() != null) {
						String name = MutatorUtils.getTypeName(((SelectSampleMutator) mut).getObject());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
					}
				}
				if (mut instanceof CloneObjectMutator) {
					if (((CloneObjectMutator) mut).getObject() != null) {
						String name = MutatorUtils.getTypeName(((CloneObjectMutator) mut).getObject());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((CloneObjectMutator) mut).getObject().getExpression() != null) {
							compile(((CloneObjectMutator) mut).getObject().getExpression(), name, ((CloneObjectMutator) mut).getAttributes(), constraints, blockName, mutName, useReferences);
						}
					}
				}
				if (mut instanceof ModifyInformationMutator) {
					if (((ModifyInformationMutator) mut).getObject() != null) {
						String name = MutatorUtils.getTypeName(((ModifyInformationMutator) mut).getObject());
						if (classNames.contains(name)) {
							getSizeConstraints(rootClass, ModelManager.getEClassByName(packages, name), packages, constraints, false, null, blockName, mutName, false);
						}
						if (((ModifyInformationMutator) mut).getObject().getExpression() != null) {
							compile(((ModifyInformationMutator) mut).getObject().getExpression(), name, constraints, blockName, mutName, useReferences);
							compile(((ModifyInformationMutator) mut).getObject().getExpression(), name, ((ModifyInformationMutator) mut).getAttributes(), constraints, blockName, mutName, useReferences);
						}
						if (((ModifyInformationMutator) mut).getReferences() != null) {
							compile(((ModifyInformationMutator) mut).getReferences(), constraints, blockName, mutName, useReferences);
						}
					}
				}
			}
		}
	}
	
	public static String generateUSE(MutatorEnvironment e, String className, HashMap<String, HashMap<String, String>> useReferences) {
		String useText = "";
		try {
			useText = "model " + encodeWord(className) + "\n";
			ArrayList<EPackage> packages = ModelManager.loadMetaModel(e.getDefinition().getMetamodel());
			ArrayList<EClass> classes = ModelManager.getEClasses(packages);
			ArrayList<String> classNames = new ArrayList<String>();
			List<Constraint> constraints = new ArrayList<Constraint>();
			List<Mandatory> mandatories = new ArrayList<Mandatory>();
			HashMap<String, Integer> maxSize = new HashMap<String, Integer>();
			
			EClass rootClass = null;
			for (EClass eClass : classes) {
				List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, eClass.getName());
				if (containerTypes.size() == 0) {
					rootClass = eClass;
				}
				classNames.add(eClass.getName());
				closures.put(eClass.getName(), false);
			}
			
			for (EClass eClass : classes) {
				ArrayList<String> superClasses = new ArrayList<String>();
				for (EClass superClass : eClass.getESuperTypes()) {
					superClasses.add(superClass.getName());
				}
				String superClassesText = "";
				if (superClasses.size() > 0) {
					superClassesText = superClasses.get(0);
					if (superClasses.size() > 1) {
						for (String superClassName : superClasses.subList(1, superClasses.size() - 1)) {
							superClassesText = superClassesText + ", " + superClassName;
						}
					}
					useText += "class " + encodeWord(eClass.getName()) + " < " + encodeWord(superClassesText) + "\n";
				}
				else {
					useText += "class " + encodeWord(eClass.getName()) + "\n";
				}
				List<EAttribute> atts = eClass.getEAttributes();
				if (atts.size() > 0) {
					useText += "\tattributes\n";
					for (EAttribute att : atts) {
						if (att.getEType().getName().equals("EString")) {
							useText += "\t\t" + encodeWord(att.getName()) + " : String\n";
						}
						if (att.getEType().getName().equals("EBoolean")) {
							useText += "\t\t" + encodeWord(att.getName()) + " : Boolean\n";
						}
						if (att.getEType().getName().equals("EInt")) {
							useText += "\t\t" + encodeWord(att.getName()) +  " : Integer\n";
						}
						if (att.getEType().getName().equals("EDouble")) {
							useText += "\t\t" + encodeWord(att.getName()) + " : Double\n";
						}
					}
				}
				useText += "end\n";
			}
			
			dummyClassName = getUniqueName(dummyClassName, classNames, 0);
			useText += "class " + encodeWord(dummyClassName) + "\n";
			useText += "end\n";
			
			for (EClass eClass : classes) {
				for (EAttribute att : eClass.getEAllAttributes()) {
					if (att.getLowerBound() > 0) {
						Constraint constraint = new Constraint();
						constraint.text = encodeWord(eClass.getName()) + ".allInstances()->forAll(" + eClass.getName().substring(0, 1).toLowerCase() + " | " + eClass.getName().substring(0, 1).toLowerCase() + "." + encodeWord(att.getName()) + " <> null)";
						constraint.type = "forAll";
						constraint.variables.add(eClass.getName().substring(0, 1).toLowerCase());
						constraint.className = eClass.getName();
						if (getConstraint(constraints, constraint) == null) {
							constraints.add(constraint);
						}
					}
				}
			}
			
			if (e.getCommands().size() > 0) {
				mutatorDependencies = new MutatorDependencies(e.getCommands());
				compile(e.getCommands(), rootClass, packages, classNames, constraints, "MAIN", useReferences);
			}
			
			if (e.getBlocks().size() > 0) {
				for (Block b : e.getBlocks()) {
					mutatorDependencies = new MutatorDependencies(b.getCommands());
					compile(b.getCommands(), rootClass, packages, classNames, constraints, b.getName(), useReferences);
				}
			}
			
			HashMap<String, Integer> associationNames = new HashMap<String, Integer>();
			HashMap<String, Integer> roleNames = new HashMap<String, Integer>();
			List<EReference> references = new ArrayList<EReference>();
			
			for (EClass eClass : classes) {
				List<EReference> refs = eClass.getEReferences();
				if (refs.size() > 0) {
					for (EReference ref : refs) {
						references.add(ref);
						String associationName = eClass.getName() + ref.getEType().getName();
						if (associationNames.get(associationName) != null) {
							associationNames.put(associationName, associationNames.get(associationName) + 1);
							associationName += associationNames.get(associationName);
						}
						else {
							associationNames.put(associationName, 0);
						}
						String srcRoleName = eClass.getName().toLowerCase() + ref.getEType().getName().toLowerCase();
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
							HashMap<String, String> useReference = null;
							if (useReferences.get(eClass.getName()) != null) {
								useReference = useReferences.get(eClass.getName());
							}
							else {
								useReference = new HashMap<String, String>();
							}
							useReference.put(ref.getName(), tarRoleName);
							useReferences.put(eClass.getName(), useReference);
						}
						else {
							roleNames.put(tarRoleName, 0);
						}
						if (ref.isContainment() == false) {
							useText += "association " + encodeWord(associationName) + " between\n";
						}
						if (ref.isContainment() == true) {
							useText += "composition " + encodeWord(associationName) + " between\n";
						}
						useText += "\t" + encodeWord(eClass.getName()) + "[*] role " + encodeWord(srcRoleName) + "\n";
						if (ref.getLowerBound() == 0 && ref.getUpperBound() == -1) {
							useText += "\t" + encodeWord(ref.getEType().getName()) + "[*] role " + encodeWord(tarRoleName) + "\n";
						}
						else if (ref.getUpperBound() == -1) {
							useText += "\t" + encodeWord(ref.getEType().getName()) + "[" + ref.getLowerBound() + "..*] role " + encodeWord(tarRoleName) + "\n";
						}
						else if (ref.getLowerBound() != ref.getUpperBound()) {
							useText += "\t" + encodeWord(ref.getEType().getName()) + "[" + ref.getLowerBound() + ".." + ref.getUpperBound() + "] role " + encodeWord(tarRoleName) + "\n"; 
						}
						else if (ref.getLowerBound() == ref.getUpperBound()) {
							useText += "\t" + encodeWord(ref.getEType().getName()) + "[" + ref.getLowerBound() + "] role " + encodeWord(tarRoleName) + "\n";
						}
						useText += "end\n";
					}
				}
			}
					
			useText += "constraints\n";
			useText += "context " + dummyClassName + "\n";
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
											constraint.text = ocl.replace("self." + refName, ref.getEType().getName() + ".allInstances()");
											constraint.type = "metamodel";
											constraint.className = ref.getEType().getName();
											if (constraint.text.indexOf("exists") != -1 || constraint.text.indexOf("one") != -1) {
												Mandatory mandatory = new Mandatory();
												if (constraint.text.indexOf("exists") != -1) {
													mandatory.type = "exists";
												}
												if (constraint.text.indexOf("one") != -1) {
													mandatory.type = "one";
												}
												mandatory.className = ref.getEType().getName();
												String clause = constraint.text.substring(constraint.text.lastIndexOf(".") + 1, constraint.text.lastIndexOf(")"));
												if ((constraint.text.lastIndexOf(".") > constraint.text.lastIndexOf("|")) && (constraint.text.lastIndexOf(".") < constraint.text.lastIndexOf("="))) {
													if (clause.indexOf("=") != -1) {
														String[] clauseParts = clause.split("=");
														int j = 0;
														for (String clausePart : clauseParts) {
															clauseParts[j] = clausePart.trim();
															j++;
														}
														mandatory.featureName = clauseParts[0];
														mandatory.value = clauseParts[1];
													}
													else {
														mandatory.featureName = clause;
														mandatory.value = "true";
													}
												}
												else {
													constraint.text = constraint.text.replace(clause, clause + " = true");
													mandatory.featureName = clause;
													mandatory.value = "true";
												}
												mandatories.add(mandatory);
											}
											if (getConstraint(constraints, constraint) == null) {
												constraints.add(constraint);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			useText += compositionConstraint(references);
			for (EReference ref : references) {
				useText += compositionConstraint(ref);
			}
			int i = 0;
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
	
	private static int getObjectMaxIndex(EObject eObject, HashMap<EObject, String> eObjectNamesHashMap) {
		 String className = eObject.eClass().getName();
		 String varName = className.substring(0, 1).toLowerCase();
		 int max = 0;
		 for (String value : eObjectNamesHashMap.values()) {
			 String v = value.substring(0, 1).toLowerCase();
			 if (varName.equals(v)) {
				 int index = Integer.parseInt(value.substring(1, value.length()));
				 if (index > max) {
					 max = index;
				 }
			 }
		 }
		 max++;
		 return max;
	}
	
	private static void processObjectNames(Object object, HashMap<String, Integer> varNamesHashMap, HashMap<EObject, String> eObjectNamesHashMap) {
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			for (EObject eObject : eObjects) {
				String className = eObject.eClass().getName();
				String varName = className.substring(0, 1).toLowerCase();
				int index = 0;
				if (varNamesHashMap.get(varName) != null) {
					index = varNamesHashMap.get(varName) + 1;
				}
				varNamesHashMap.put(varName, index);
				varName += index;
				varNames.add(varName);
				eObjectNamesHashMap.put(eObject, varName);
			}
			for (EObject eObject : eObjects) {
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						processObjectNames(eObject.eGet(ref), varNamesHashMap, eObjectNamesHashMap);
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String className = eObject.eClass().getName();
			String varName = className.substring(0, 1).toLowerCase();
			int index = 0;
			if (varNamesHashMap.get(varName) != null) {
				index = varNamesHashMap.get(varName) + 1;
			}
			varNamesHashMap.put(varName, index);
			varName += index;
			eObjectNamesHashMap.put(eObject, varName);
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					processObjectNames(eObject.eGet(ref), varNamesHashMap, eObjectNamesHashMap);
				}
			}
		}
	}
	
	private static String processContainmentReferences(Object object, HashMap<EObject, String> eObjectNamesHashMap,  HashMap<String, HashMap<String, String>> useReferences) {
		String constraint = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			if (eObjects.size() > 1) {
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					String varName = eObjectNamesHashMap.get(eObject);
					varNames.add(varName);
					constraint += varName + ", ";
				}
			}
			if (eObjects.size() == 1) {
				String varName = eObjectNamesHashMap.get(eObjects.get(0));
				varNames.add(varName);
				constraint += varName;
			}
			else if (eObjects.size() > 0) {
				String varName = eObjectNamesHashMap.get(eObjects.get(eObjects.size() - 1));
				varNames.add(varName);
				constraint += varName;
			}
			if (constraint.length() > 0) {
				constraint += " | ";
			}
			if (eObjects.size() > 1) {
				int index = 0;
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (ref.isContainment() == true) {
							String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, useReferences);
							if (processed.length() > 0) {
								constraint += varNames.get(index) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(" + processed;
							}
						}
					}
					index++;
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, useReferences);
						if (processed.length() > 0) {
							constraint += varNames.get(0) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(" + processed;
						}
					}
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, useReferences);
						if (processed.length() > 0) {
							constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(" + processed;
						}
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String varName = eObjectNamesHashMap.get(eObject);
			List<EReference> references = eObject.eClass().getEAllReferences();
			constraint = varName + " | ";
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, useReferences);
					if (processed.length() > 0) {
						constraint += varName + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(" + processed;
					}
				}
			}
		}
		return constraint;
	}
	
	private static String completeParentheses(String constraint) {
		int count = 0;
		for (char c : constraint.toCharArray()) {
			if (c == '(') {
				count++;
			}
			if (c == ')') {
				count--;
			}
		}
		for (int i = 0; i < count; i++) {
			constraint += ")";
		}
		return constraint;
	}
	
	private static String getUseReferenceName(EClass eClass, EReference ref,  HashMap<String, HashMap<String, String>> useReferences) {
		String useReferenceName = ref.getName();
		if (useReferences != null) {
			HashMap<String, String> useReference = useReferences.get(eClass.getName());
			if (useReference != null) {
				useReferenceName = useReference.get(ref.getName());
			}
		}
		return useReferenceName;
	}
	
	private static String processObject(Object o) {
		String processed = "";
		if (o instanceof Boolean) {
			processed = o.toString();
		}
		if (o instanceof String) {
			processed = "'" + o.toString() + "'";
		}
		if (o instanceof Double) {
			processed = o.toString();
		}
		if (o instanceof Integer) {
			processed = o.toString();
		}
		return processed;
	}
	
	private static String processObject(Object object, HashMap<EObject, String> eObjectNamesHashMap,  HashMap<String, HashMap<String, String>> useReferences, boolean addAnd) {
		String constraint = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			if (eObjects.size() > 1) {
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					String varName = eObjectNamesHashMap.get(eObject);
					varNames.add(varName);
				}
			}
			if (eObjects.size() == 1) {
				String varName = eObjectNamesHashMap.get(eObjects.get(0));
				varNames.add(varName);
			}
			else if (eObjects.size() > 0) {
				String varName = eObjectNamesHashMap.get(eObjects.get(eObjects.size() - 1));
				varNames.add(varName);
			}
			if (eObjects.size() > 1) {
				int index = 0;
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						if (ref.isContainment() == true) {
							String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, useReferences, addAnd);
							if (processed.length() > 0) {
								constraint += processed; 
								addAnd = true;
							}
						}
						if (ref.isContainment() == false) {
							Object o = eObject.eGet(ref);
							if (o == null) {
								constraint += varNames.get(index) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=null";
								addAnd = true;
							}
							if (o instanceof EObject) {
								EObject obj = (EObject) o;
								constraint += varNames.get(index) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=" + eObjectNamesHashMap.get(obj);
								addAnd = true;
							}
							if (o instanceof List<?>) {
								List<EObject> objs = (List<EObject>) o;
								int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
								constraint += varNames.get(index) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(";
								String className = ref.getEType().getName();
								List<String> localVarNames = new ArrayList<String>();
								String varName = "";
								for (EObject obj : objs.subList(0, objs.size() - 1)) {
									varName = className.substring(0, 1).toLowerCase() + i;
									constraint += varName + ", ";
									localVarNames.add(varName);
									i++;
								}
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + " | ";
								localVarNames.add(varName);
								i = 0;
								for (EObject obj : objs.subList(0, objs.size() - 1)) {
									constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
									i++;
								}
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
								addAnd = true;
							}
						}
					}
					List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
					if (attributes.size() > 1) {
						for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
							if (addAnd == true) {
								constraint += " and ";
								addAnd = false;
							}
							constraint += varNames.get(index) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
							addAnd = true;
						}
					}
					if (attributes.size() == 1) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						EAttribute att = attributes.get(0);
						constraint += varNames.get(index) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
						addAnd = true;
					}
					else if (attributes.size() > 0) {
						if (addAnd == true) {
							constraint += " and ";
						}
						EAttribute att = attributes.get(attributes.size() - 1);
						constraint += varNames.get(index) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					}
					index++;
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					if (ref.isContainment() == true) {
						String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, useReferences, addAnd);
						if (processed.length() > 0) {
							constraint += processed; 
							addAnd = true;
						}
					}
					if (ref.isContainment() == false) {
						Object o = eObject.eGet(ref);
						if (o == null) {
							constraint += varNames.get(0) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=null";
							addAnd = true;
						}
						if (o instanceof EObject) {
							EObject obj = (EObject) o;
							constraint += varNames.get(0) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=" + eObjectNamesHashMap.get(obj);
							addAnd = true;
						}
						if (o instanceof List<?>) {
							List<EObject> objs = (List<EObject>) o;
							int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
							constraint += varNames.get(0) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(";
							String className = ref.getEType().getName();
							List<String> localVarNames = new ArrayList<String>();
							String varName = "";
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + ", ";
								localVarNames.add(varName);
								i++;
							}
							varName = className.substring(0, 1).toLowerCase() + i;
							constraint += varName + " | ";
							localVarNames.add(varName);
							i = 0;
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
								i++;
							}
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
							addAnd = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						constraint += varNames.get(0) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
						addAnd = true;
					}
				}
				if (attributes.size() == 1) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					EAttribute att = attributes.get(0);
					constraint += varNames.get(0) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
				else if (attributes.size() > 0) {
					if (addAnd == true) {
						constraint += " and ";
					}
					EAttribute att = attributes.get(attributes.size() - 1);
					constraint += varNames.get(0) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					if (ref.isContainment() == true) {
						String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, useReferences, addAnd);
						if (processed.length() > 0) {
							constraint += processed; 
							addAnd = true;
						}
					}
					if (ref.isContainment() == false) {
						Object o = eObject.eGet(ref);
						if (o == null) {
							constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=null";
							addAnd = true;
						}
						if (o instanceof EObject) {
							constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
							addAnd = true;
						}
						if (o instanceof List<?>) {
							List<EObject> objs = (List<EObject>) o;
							int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
							constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(";
							String className = ref.getEType().getName();
							List<String> localVarNames = new ArrayList<String>();
							String varName = "";
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + ", ";
								localVarNames.add(varName);
								i++;
							}
							varName = className.substring(0, 1).toLowerCase() + i;
							constraint += varName + " | ";
							localVarNames.add(varName);
							i = 0;
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
								i++;
							}
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
							addAnd = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						if (addAnd == true) {
							constraint += " and ";
						}
						constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					}
				}
				if (attributes.size() == 1) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					EAttribute att = attributes.get(0);
					constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
				else if (attributes.size() > 0) {
					if (addAnd == true) {
						constraint += " and ";
					}
					EAttribute att = attributes.get(attributes.size() - 1);
					constraint += varNames.get(eObjects.size() - 1) + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String varName = eObjectNamesHashMap.get(eObject);
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {
				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				if (ref.isContainment() == true) {
					String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, useReferences, addAnd);
					if (processed.length() > 0) {
						constraint += processed; 
						addAnd = true;
					}
				}
				if (ref.isContainment() == false) {
					Object o = eObject.eGet(ref);
					if (o == null) {
						constraint += varName + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=null";
						addAnd = true;
					}
					if (o instanceof EObject) {
						constraint += varName + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
						addAnd = true;
					}
					if (o instanceof List<?>) {
						List<EObject> objs = (List<EObject>) o;
						int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
						constraint += varName + "." + encodeWord(getUseReferenceName(eObject.eClass(), ref, useReferences)) + "->exists(";
						String className = ref.getEType().getName();
						List<String> localVarNames = new ArrayList<String>();
						String vName = "";
						for (EObject obj : objs.subList(0, objs.size() - 1)) {
							vName = className.substring(0, 1).toLowerCase() + i;
							constraint += vName + ", ";
							localVarNames.add(vName);
							i++;
						}
						vName = className.substring(0, 1).toLowerCase() + i;
						constraint += vName + " | ";
						localVarNames.add(vName);
						i = 0;
						for (EObject obj : objs.subList(0, objs.size() - 1)) {
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
							i++;
						}
						constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
						addAnd = true;
					}
				}
			}
			List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
			if (attributes.size() > 1) {
				for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
			}
			if (attributes.size() == 1) {
				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				EAttribute att = attributes.get(0);
				constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				addAnd = true;
			}
			else if (attributes.size() > 0) {
				if (addAnd == true) {
					constraint += " and ";
				}
				EAttribute att = attributes.get(attributes.size() - 1);
				constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
			}
		}
		return constraint;
	}
	
	public static String xmi2ocl(Resource model, HashMap<String, HashMap<String, String>> useReferences) {
		EObject root = ModelManager.getRoot(model);
		String useText = "";
		String className = root.eClass().getName();
		HashMap<String, Integer> varNamesHashMap = new HashMap<String, Integer>();
		String varName = className.substring(0, 1).toLowerCase();
		varNamesHashMap.put(varName, null);
		HashMap<EObject, String> eObjectNamesHashMap = new HashMap<EObject, String>();
		processObjectNames(root, varNamesHashMap, eObjectNamesHashMap);
		varName = eObjectNamesHashMap.get(root);
		String constraint = className + ".allInstances()->exists(";
		constraint += processContainmentReferences(root, eObjectNamesHashMap, useReferences);
		List<EReference> references = root.eClass().getEAllReferences();
		boolean addAnd = false;
		for (EReference ref : references) {
			if (addAnd == true) {
				constraint += " and ";
				addAnd = false;
			}
			if (ref.isContainment() == true) {
				String processed = processObject(root.eGet(ref), eObjectNamesHashMap, useReferences, addAnd);
				if (processed.length() > 0) {
					constraint += processed; 
					addAnd = true;
				}
			}
			if (ref.isContainment() == false) {
				Object o = root.eGet(ref);
				if (o == null) {
					constraint += varName + "." + encodeWord(getUseReferenceName(root.eClass(), ref, useReferences)) + "=null";
					addAnd = true;
				}
				if (o instanceof EObject) {
					constraint += varName + "." + encodeWord(getUseReferenceName(root.eClass(), ref, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
					addAnd = true;
				}
				if (o instanceof List<?>) {
					List<EObject> objs = (List<EObject>) o;
					int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
					constraint += varName + "." + encodeWord(getUseReferenceName(root.eClass(), ref, useReferences)) + "->exists(";
					String clName = ref.getEType().getName();
					List<String> localVarNames = new ArrayList<String>();
					String vName = "";
					for (EObject obj : objs.subList(0, objs.size() - 1)) {
						vName = clName.substring(0, 1).toLowerCase() + i;
						constraint += vName + ", ";
						localVarNames.add(vName);
						i++;
					}
					vName = clName.substring(0, 1).toLowerCase() + i;
					constraint += vName + " | ";
					localVarNames.add(vName);
					i = 0;
					for (EObject obj : objs.subList(0, objs.size() - 1)) {
						constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
						i++;
					}
					constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
					addAnd = true;
				}
			}
		}
		List<EAttribute> attributes = root.eClass().getEAllAttributes();
		if (attributes.size() > 1) {
			for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
				addAnd = true;
			}
		}
		if (attributes.size() == 1) {
			if (addAnd == true) {
				constraint += " and ";
			}
			EAttribute att = attributes.get(0);
			constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
		}
		else if (attributes.size() > 0) {
			if (addAnd == true) {
				constraint += " and ";
			}
			EAttribute att = attributes.get(attributes.size() - 1);
			constraint += varName + "." + encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
		}
		if (constraint.length() > 0) {
			constraint = completeParentheses(constraint);
			useText += constraint;
		}
		return useText;
	}
	

	private static String getStringName(Object o) {
		String processed = "";
		if (o instanceof String) {
			processed = "'" + o.toString() + "'";
		}
		return processed;
	}
	
	private static String processObjectNames(Object object, HashMap<EObject, String> eObjectNamesHashMap, boolean addComma) {
		String oclNames = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			if (eObjects.size() > 1) {
				int index = 0;
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (ref.isContainment() == true) {
							String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
							if (processed.length() > 0) {
								if (addComma == true) {
									oclNames += ", ";
									addComma = false;
								}
								oclNames += processed; 
								addComma = true;
							}
						}
					}
					List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
					if (attributes.size() > 1) {
						for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
							String processed = getStringName(eObject.eGet(att));
							if (processed.length() > 0) {
								if (addComma == true) {
									oclNames += ", ";
									addComma = false;
								}
								oclNames += processed;
								addComma = true;
							}
						}
					}
					if (attributes.size() == 1) {
						EAttribute att = attributes.get(0);
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
					else if (attributes.size() > 0) {
						EAttribute att = attributes.get(attributes.size() - 1);
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
							}
							oclNames += processed;
						}
					}
					index++;
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed;
							addComma = true;
						}
					}
				}
				if (attributes.size() == 1) {
					EAttribute att = attributes.get(0);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
				else if (attributes.size() > 0) {
					EAttribute att = attributes.get(attributes.size() - 1);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
						}
						oclNames += processed;
					}
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true) {
								oclNames += ", ";
							}
							oclNames += processed;
						}
					}
				}
				if (attributes.size() == 1) {
					EAttribute att = attributes.get(0);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
				else if (attributes.size() > 0) {
					EAttribute att = attributes.get(attributes.size() - 1);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
						}
						oclNames += processed;
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String varName = eObjectNamesHashMap.get(eObject);
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed; 
						addComma = true;
					}
				}
			}
			List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
			if (attributes.size() > 1) {
				for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
			}
			if (attributes.size() == 1) {
				EAttribute att = attributes.get(0);
				String processed = getStringName(eObject.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed;
					addComma = true;
				}
			}
			else if (attributes.size() > 0) {
				EAttribute att = attributes.get(attributes.size() - 1);
				String processed = getStringName(eObject.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
					}
					oclNames += processed;
				}
			}
		}
		return oclNames;
	}

	public static String xmi2oclNames(Resource model) {
		EObject root = ModelManager.getRoot(model);
		String oclNames = "String = Set{";
		String className = root.eClass().getName();
		HashMap<String, Integer> varNamesHashMap = new HashMap<String, Integer>();
		String varName = className.substring(0, 1).toLowerCase();
		varNamesHashMap.put(varName, null);
		HashMap<EObject, String> eObjectNamesHashMap = new HashMap<EObject, String>();
		processObjectNames(root, varNamesHashMap, eObjectNamesHashMap);
		varName = eObjectNamesHashMap.get(root);
		List<EReference> references = root.eClass().getEAllReferences();
		boolean addComma = false;
		for (EReference ref : references) {
			if (ref.isContainment() == true) {
				String processed = processObjectNames(root.eGet(ref), eObjectNamesHashMap, addComma);
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed; 
					addComma = true;
				}
			}
		}
		List<EAttribute> attributes = root.eClass().getEAllAttributes();
		if (attributes.size() > 1) {
			for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
				String processed = getStringName(root.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed;
					addComma = true;
				}
			}
		}
		if (attributes.size() == 1) {
			EAttribute att = attributes.get(0);
			String processed = getStringName(root.eGet(att));
			if (processed.length() > 0) {
				if (addComma == true) {
					oclNames += ", ";
				}
				oclNames += processed;
			}
		}
		else if (attributes.size() > 0) {
			EAttribute att = attributes.get(attributes.size() - 1);
			String processed = getStringName(root.eGet(att));
			if (processed.length() > 0) {
				if (addComma == true) {
					oclNames += ", ";
				}
				oclNames += processed;
			}
		}
		oclNames += "}";
		return oclNames;
	}
	

	public static String ocl2use(String oclText, HashMap<String, HashMap<String, String>> useReferences) {
		String oclUseText = oclText;
		char[] chars = oclUseText.toCharArray();
		for (String className : useReferences.keySet()) {
			if (oclUseText.indexOf(className) != -1) {
				int begin = oclUseText.indexOf(className) + className.length();
				boolean flag = false;
				int i = begin;
				while (i < chars.length) {
					if (chars[i] == '(') {
						if (flag == true) {
							break;
						}
					}
					if (chars[i] == ')') {
						flag = true;
					}
					i++;
				}
				begin = i + 1;
				int end = 0;
				int countParentheses = 1;
				i = begin;
				while (i < chars.length) {
					if (chars[i] == '(') {
						countParentheses ++;
					}
					if (chars[i] == ')') {
						countParentheses --;
					}
					if (countParentheses == 0) {
						end = i;
					}
					i++;
				}
				String part = oclUseText.substring(begin, end);
				String newPart = part;
				for (String refName : useReferences.get(className).keySet()) {
					newPart = newPart.replaceAll(refName, useReferences.get(className).get(refName));
				}
				oclUseText = oclUseText.replace(part, newPart);
			}
		}
		
		return oclUseText;
	}
	
	public static String[] getNames(String text) {
		List<String> names = new ArrayList<String>();
		char[] chars = text.toCharArray();
		int i = 0;
		while (i < chars.length) {
			if (chars[i] == '\'') {
				int j = i + 1;
				String name = "'";
				while (j < chars.length) {
					name += chars[j];
					if (chars[j] == '\'') {
						break;
					}
					j++;
				}
				names.add(name);
				i+= j-1;
			}
			i++;
		}
		String[] ret = null;
		if (names.size() > 0) {
			ret = new String[names.size()];
			names.toArray(ret);
		}
		
		return ret;
	}

	public static String oclAddNames(String names, String oclText) {
		String[] newNames = getNames(oclText);
		if (newNames != null && newNames.length > 0) {
			List<String> nl = new ArrayList<String>();
			for (String newName : newNames) {
				if (names.indexOf(newName) == - 1) {
					nl.add(newName);
				}
			}
			if (nl.size() > 0) {
				if (names.length() == 0 || names.equals("String = Set{}")) {
					names = "String = Set{";
					names += nl.get(0);
					for (String n : nl.subList(1, nl.size() - 1)) {
						names += ", " + n;
					}
				}
				else {
					names = names.replace("}", "");
					for (String n : nl) {
						names += ", " + n;
					}
				}
				names += "}";
			}
		}
		return names;
	}
}
