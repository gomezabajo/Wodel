package efinder.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import efinder.core.footprint.IFootprint;
import efinder.core.ir.IRBuilder;
import efinder.ir.AbstractFunction;
import efinder.ir.EFTupleType;
import efinder.ir.EFType;
import efinder.ir.EfinderFactory;
import efinder.ir.FeatureRef;
import efinder.ir.MetamodelFeatureRef;
import efinder.ir.Specification;
import efinder.ir.TupleTypeElement;
import efinder.ir.TypeRef;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclOperation;

public class IRUtils {

	@NonNull
	public static Map<EFType, Collection<OclDerivedProperty>> getDerivedPropertiesAsMap(@NonNull Specification spec, @NonNull IFootprint footprint) {
		return asMap(spec.getProperties(), footprint, OclDerivedProperty.class);
	}

	@NonNull
	public static Map<EFType, Collection<OclOperation>> getOperationsAsMap(@NonNull Specification spec, @NonNull IFootprint footprint) {
		return asMap(spec.getOperations(), footprint, OclOperation.class);
	}

	@NonNull
	private static <T extends AbstractFunction, R> Map<EFType, Collection<R>> asMap(@NonNull Collection<? extends T> elements, @NonNull IFootprint footprint, Class<? extends R> type) {
		Map<EFType, Collection<R>> map = new HashMap<>();
		for (T e : elements) {
			if (type.isInstance(e)) {
				EFType ctx = e.getContext();
				if (!footprint.hasFunction(e))
					continue;
				// if (ctx instanceof EFClass && !footprint.hasClass(((EFClass) ctx).getKlass())) {
				//	continue;
				//}
				
				map.computeIfAbsent(ctx, (k) -> new ArrayList<>());
				map.get(ctx).add(type.cast(e));
			}
		}
		return map;
	}

	@Nullable
	public static EStructuralFeature getMetamodelFeatureOrNull(@NonNull FeatureRef ref) {
		if (ref instanceof MetamodelFeatureRef) {
			return ((MetamodelFeatureRef) ref).getFeature();
		}
		return null;
	}

	@NonNull
	public static TupleTypeHandler getTupleTypeHandler(@NonNull Map<String, TypeRef> prop2types) {
		return new TupleTypeHandler(prop2types);
	}
	
	public static class TupleTypeHandler {

		private @NonNull Map<String, TypeRef> prop2types;

		public TupleTypeHandler(@NonNull Map<String, TypeRef> prop2types) {
			this.prop2types = new HashMap<>(prop2types);
		}

		public String getId() {
			return prop2types.keySet().stream().sorted().collect(Collectors.joining("_"));
		}

		public EFTupleType toType() {
			EFTupleType tt = EfinderFactory.eINSTANCE.createEFTupleType();
			tt.setId(getId());
			
			prop2types.forEach((k, v) -> {
				TupleTypeElement elem = EfinderFactory.eINSTANCE.createTupleTypeElement();
				elem.setName(k);
				elem.setType(v);
				tt.getElements().add(elem);
			});
			
			return tt;
		}
		
	}
	
}
