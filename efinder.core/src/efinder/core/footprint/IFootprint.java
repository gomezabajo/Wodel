package efinder.core.footprint;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

import efinder.ir.AbstractFunction;
import efinder.ir.EFClass;
import efinder.ir.EFType;

public interface IFootprint {

	static final IFootprint NULL_FOOTPRINT = new NullFootprint();
	
	public boolean hasClass(@NonNull EClass c);
	public boolean hasFeature(@NonNull EStructuralFeature f);
	/** 
	 * Refers to derived properties and operations.
	 */
	public boolean hasFunction(@NonNull AbstractFunction f);
	
	public static class MutableFootprint implements IFootprint {
		private Set<EClass> classes = new HashSet<>();
		private Set<EStructuralFeature> features = new HashSet<>();
		private Set<AbstractFunction> functions = new HashSet<>();
		
		@Override
		public boolean hasClass(@NonNull EClass c) {
			return classes.contains(c);
		}
		
		@Override
		public boolean hasFeature(@NonNull EStructuralFeature f) {
			return features.contains(f);
		}
		
		@Override
		public boolean hasFunction(@NonNull AbstractFunction f) {
			return functions.contains(f);
		}
		
		public boolean addClass(@NonNull EClass c) {
			Preconditions.checkNotNull(c);
			return classes.add(c);
		}
		
		public boolean addFeature(@NonNull EStructuralFeature f) {
			Preconditions.checkNotNull(f);
			addClass(f.getEContainingClass());
			if (f instanceof EReference) 
				addClass(((EReference) f).getEReferenceType());
			return features.add(f);
		}
		
		public boolean addFunction(@NonNull AbstractFunction function) {
			Preconditions.checkNotNull(function);
			EFType type = function.getContext();
			if (type instanceof EFClass) 
				addClass(((EFClass) type).getKlass());			
			return functions.add(function);
		}

		public Set<? extends EClass> getClasses() {
			return this.classes;
		}
		
		public Set<? extends EStructuralFeature> getFeatures() {
			return features;
		}
	}

	public static class NullFootprint implements IFootprint {

		@Override
		public boolean hasClass(@NonNull EClass c) {
			return true;
		}

		@Override
		public boolean hasFeature(@NonNull EStructuralFeature f) {
			return true;
		}
		
		@Override
		public boolean hasFunction(@NonNull AbstractFunction f) {
			return true;
		}
		
	}
}
