package efinder.usemv.ir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import efinder.core.footprint.IRFootprintedModel;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EFMetamodel;
import efinder.ir.EFPackage;

/**
 * Instantiation of a given mapping.
 * 
 * @author jesus
 *
 */
public class UseMapping {

	@NonNull
	private final Map<String, AssociationData> associations = new HashMap<>();
	
	@NonNull
	private final Map<String, String> strings2new = new HashMap<String, String>();
	@NonNull
	private final Map<String, String> new2Strings = new HashMap<String, String>();	
	@NonNull
	private final BiMap<EClassifier, String> eclassifier2use = HashBiMap.create();
	@NonNull
	private final Map<String, String> useToEcoreLiteralName = new HashMap<String, String>();
	@NonNull
	private final Set<String> temporaryClassNames = new HashSet<String>();	
	@NonNull
	private final String modelName;	

	public UseMapping(IRFootprintedModel ir) {
		List<? extends EFMetamodel> metamodels = ir.getSpecification().getMetamodels();
		mapMetamodels(metamodels);
		ir.getSpecification().getTemporary().getClasses().forEach(c -> eclassifier2use.put(c.getKlass(), UseReservedWords.toUseName(c.getKlass().getName())));
		ir.getSpecification().getTemporary().getClasses().forEach(c -> temporaryClassNames.add(UseReservedWords.toUseName(c.getKlass().getName())));
		this.modelName = UseReservedWords.toUseName(metamodels.get(0).getRoots().get(0).getPkg().getName());
	}

	public boolean isTemporary(@NonNull EClass c) {
		return temporaryClassNames.contains(c.getName());
	}
	
	private void mapMetamodels(@NonNull List<? extends EFMetamodel> metamodels) {
		Function<EClassifier, String> nameMapper = metamodels.size() > 1 ?
				(c) -> UseReservedWords.toUseName(c.getEPackage().getName() + "_" + c.getName()) :
				(c) -> UseReservedWords.toUseName(c.getName());
		
		for (EFMetamodel m : metamodels) {
			for(EFPackage pkg : m.getRoots()) {
				for(EFClass c : pkg.getClasses()) {
					String name = nameMapper.apply(c.getKlass());
					eclassifier2use.put(c.getKlass(), name);
				}
				
				for(EFEnum e : pkg.getEnumerations()) {
					String name = nameMapper.apply(e.getEnum_());
					eclassifier2use.put(e.getEnum_(), name);
				}				
			}
		}
	}

	public String addStringConstant(@NonNull String string) {
		String newString = strings2new.get(string);
		if (newString == null) {
			newString = "string" + (strings2new.size() + 1);
			strings2new.put(string, newString);
			new2Strings.put(newString, string);
		}
		return newString;
	}

	public String undoStringConstant(String v) {		
		return new2Strings.getOrDefault(v, v);
	}

	public int getStringCount() {
		return strings2new.size();
	}
	
	@NonNull
	public String toUseTypeName(@NonNull EFClass klass) {		
		return toUseTypeName(klass.getKlass());
	}

	@NonNull
	public String toUseLiteralName(@NonNull EFEnumLiteral literal) {
		String original = literal.getName();
		String name = UseReservedWords.toUseName(original);
		useToEcoreLiteralName.put(name, original);
		return name;
	}
	
	@NonNull
	public String toUseTypeName(@NonNull EFEnum enum_) {
		return toUseTypeName(enum_.getEnum_());
	}
	
	@NonNull
	public String toModelName() {
		return this.modelName;
	}

	@NonNull
	public String toUseTypeName(@NonNull EClassifier c) {
		String name = eclassifier2use.get(c);
		Preconditions.checkNotNull(name, "No mapping for " + c.getName());
		return name;
	}

	@NonNull
	public String toUsePropertyName(@NonNull EReference reference) {
		return UseReservedWords.toUseName(reference.getName());
	}
	
	public String toUsePropertyName(EAttribute feature) {
		return UseReservedWords.toUseName(feature.getName());
	}

	public String toUseVarName(String name) {
		// This is because self is a reserved word but always allowed as variable name
		if (name.equals("self"))
			return name;
		
		// This possibly broader than needed, but this way we are on the safe side
		if (! Character.isAlphabetic(name.charAt(0))) {
			return "v_" + name;
		}
		return UseReservedWords.toUseName(name);
	}

	@NonNull
	public AssociationData getAssociation(@NonNull EReference reference) {
		boolean hasOpposite = reference.getEOpposite() != null;
		String associationName;
		AssociationEndData end1;
		if (hasOpposite) {
			EReference reference0 = reference.getEOpposite();
			// By convention, sort the references 
			if (reference0.getName().compareTo(reference.getName()) < 0) {
				reference0 = reference;
				reference = reference0.getEOpposite();
			}
			
			associationName = reference0.getEContainingClass().getName() + "_" + reference0.getName() + "_" +
							  reference.getEContainingClass().getName() + "_" + reference.getName();
			String end1_type = toUseTypeName(reference0.getEReferenceType());
			String end1_name = toUsePropertyName(reference0);
			String end1_cardinality = cardinalityToString(reference0);
			end1 = new AssociationEndData(end1_name, end1_type, end1_cardinality);			
		} else {
			associationName = reference.getEContainingClass().getName() + "_" + reference.getName();
			String end1_type = toUseTypeName(reference.getEContainingClass());
			String end1_name = associationName + "_source";
			String end1_cardinality = reference.isContainment()? "[0..1]" : "[*]";
			end1 = new AssociationEndData(end1_name, end1_type, end1_cardinality);			
		}
		
		if (associations.containsKey(associationName))
			return associations.get(associationName);
		
		String end2_type = toUseTypeName(reference.getEReferenceType());
		String end2_name = toUsePropertyName(reference);
		String end2_cardinality = cardinalityToString(reference);
		AssociationEndData end2 = new AssociationEndData(end2_name, end2_type, end2_cardinality, reference);
		AssociationData data = new AssociationData(associationName, end1, end2);
		associations.put(associationName, data);
		return data;
	}

	@Nullable
	public AssociationData getAssociationByName(@NonNull String name) {
		return associations.get(name);
	}

	public static class AssociationData {

		private AssociationEndData end1;
		private AssociationEndData end2;
		private String name;

		public AssociationData(String associationName, AssociationEndData end1, AssociationEndData end2) {
			this.name = associationName;
			this.end1 = end1;
			this.end2 = end2;
		}
		
		public String getName() {
			return name;
		}
		
		public AssociationEndData getEnd1() {
			return end1;
		}
		
		public AssociationEndData getEnd2() {
			return end2;
		}		
	}
	
	public static class AssociationEndData {

		private String name;
		private String type;
		private String cardinality;
		@Nullable
		private EReference reference;

		public AssociationEndData(@NonNull String name, @NonNull String type, @NonNull String cardinality) {
			this.name = name;
			this.type = type;
			this.cardinality = cardinality;
		}
		
		public AssociationEndData(@NonNull String name, @NonNull String type, @NonNull String cardinality, @NonNull EReference reference) {
			this(name, type, cardinality);
			this.reference = reference;
		}

		public String getCardinality() {
			return cardinality;
		}
		
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
		
		public EReference getEReference() {
			return reference;
		}
		
	}
	
	@NonNull
	private String cardinalityToString(@NonNull EReference ref) {
		Preconditions.checkNotNull(ref);
		return "[" + 
	           /* lower */ (ref.getLowerBound()==ref.getUpperBound() || (ref.getLowerBound()==0 && ref.getUpperBound()==-1)? "" : ref.getLowerBound() + "..") +
		       /* upper */ (ref.getUpperBound()==-1? "*" : ref.getUpperBound()) +
		       "]";
	}

	/**
	 * Undo the name modification
	 */
	@NonNull 
	public EClassifier getInverseType(@NonNull String name) {
		EClassifier c = eclassifier2use.inverse().get(name);
		Preconditions.checkNotNull(c);
		return c;
	}

	@NonNull 
	public String getInverseLiteralName(@NonNull String name) {
		// This is currently using the same map for everything, but this is only an implementation detail right now
		return useToEcoreLiteralName.getOrDefault(name, name);
	}

}
