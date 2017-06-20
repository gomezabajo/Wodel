package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class UseUtils {
	
	public static String[] useWords = { "model", "constraints", "enum", "abstract", "class", "attributes", "operations", "end", "association", 
		"composition", "aggregation", "between", "role", "ordered", "associationclass", "context", "inv", "pre",
		"post", "Set", "Bag", "Sequence", "Integer", "Real", "Boolean", "String", "from", "min", "max", "states", "transitions"};	

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


}
