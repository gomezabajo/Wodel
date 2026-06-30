package efinder.core.footprint;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;
import efinder.core.footprint.IFootprint.MutableFootprint;
import efinder.ir.Constraint;
import efinder.ir.DefinedOperationRef;
import efinder.ir.DerivedPropertyRef;
import efinder.ir.EFClass;
import efinder.ir.EFType;
import efinder.ir.MetaTypeRef;
import efinder.ir.MetamodelFeatureRef;
import efinder.ir.OperationFeatureRef;
import efinder.ir.PropertyFeatureRef;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclInvariant;
import efinder.ir.ocl.OclOperation;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.PropertyCallExp;

/**
 * This algorithm currently assumes that everything is OCL-based.
 * (i.e., it does arbitrary casts to OCL-specific subclasses).
 * 
 * @author jesus
 *
 */
public class FootprintComputation {

	public static final FootprintComputation INSTANCE = new FootprintComputation();
	
	public IFootprint compute(@NonNull EFinderModel model) {
		MutableFootprint footprint = new IFootprint.MutableFootprint();
		
		for (Constraint constraint : model.getSpecification().getConstraints()) {
			OclInvariant oclConstraint = (OclInvariant) constraint;
			visitElement(oclConstraint, footprint); 
		}
		
		// Introduce intermediate, empty classes if needed to have a proper (implicit)
		// inheritance hierarchy in the footprint
		boolean changed = true;
		while (changed) {
			changed = false;
			Set<? extends EClass> allClasses = footprint.getClasses();
			for (EClass sub : allClasses) {
				// TODO: Maybe this can be done a bit better checking each super-type individually to reduce the footprint size a bit
				List<? extends EClass> superTypes = sub.getEAllSuperTypes();
				if (!Collections.disjoint(allClasses, superTypes)) {
					for (EClass sup : sub.getESuperTypes()) {
						changed = changed || footprint.addClass(sup);						
					}
					if (changed)
						break;
				}			
			}					
		}
				
		return footprint;
	}

	// Done generically to handle operations (with arguments), derived properties and expressions in one go
	private void visitElement(EObject element, MutableFootprint footprint) {
		element.eAllContents().forEachRemaining(o -> {
			if (o instanceof MetaTypeRef) {
				outMetaTypeRef((MetaTypeRef) o, footprint);
			} else if (o instanceof PropertyCallExp) {
				outPropertyCallExp((PropertyCallExp) o, footprint);
			} else if (o instanceof OperationCallExp) {
				outOperationCallExp((OperationCallExp) o, footprint);
			}
		});
	}

	private void outPropertyCallExp(@NonNull PropertyCallExp o, MutableFootprint footprint) {
		PropertyFeatureRef f = o.getFeature();
		// This should always be non-null if this is correctly type checked, but...
		if (f instanceof MetamodelFeatureRef) {			
			footprint.addFeature(((MetamodelFeatureRef) f).getFeature());
		} else if (f instanceof DerivedPropertyRef) {
			OclDerivedProperty p = (OclDerivedProperty) ((DerivedPropertyRef) f).getProperty();
			if (footprint.addFunction(p)) {
				visitElement(p, footprint);
			}
		}
	}

	private void outOperationCallExp(OperationCallExp o, MutableFootprint footprint) {
		OperationFeatureRef f = o.getFeature();
		if (f instanceof DefinedOperationRef) {
			OclOperation op = (OclOperation) ((DefinedOperationRef) f).getOperation();			
			if (footprint.addFunction(op))
				visitElement(op, footprint);
		}	
	}

	private void outMetaTypeRef(@NonNull MetaTypeRef o, MutableFootprint footprint) {
		EFType t = o.getType();
		if (t instanceof EFClass) {
			footprint.addClass(((EFClass) t).getKlass());
		}
	}
	
}
