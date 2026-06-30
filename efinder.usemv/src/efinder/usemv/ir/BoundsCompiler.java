package efinder.usemv.ir;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;
import efinder.core.IBoundsProvider;
import efinder.core.IBoundsProvider.Interval;
import efinder.core.IBoundsProvider.RealInterval;
import efinder.core.footprint.IRFootprintedModel;
import efinder.ir.EFClass;
import efinder.ir.EFMetamodel;
import efinder.ir.EFPackage;


public class BoundsCompiler {

	private @NonNull IRFootprintedModel model;
	private @NonNull UseMapping mapping;

	public BoundsCompiler(@NonNull IRFootprintedModel model, @NonNull UseMapping mapping) {
		this.model = model;
		this.mapping = mapping;
	}
	
	public String toProperties(@NonNull IBoundsProvider scopeProvider) {
		StringWriter writer = new StringWriter();
		customGenPropertiesFiles(scopeProvider, writer);
		genDataTypes(scopeProvider, writer);
		
		return writer.toString();
	}
	
	private void genDataTypes(@NonNull IBoundsProvider boundsProvider, @NonNull StringWriter writer) {		
	// Bound of datatypes -----------------------------------------------------------
		int stringMax = Math.max(mapping.getStringCount(), 10);
				
		RealInterval realInterval = boundsProvider.getRealInterval();		
		
		writer.write("Real_min = " + realInterval.getMin() + "\n");
		writer.write("Real_max = " + realInterval.getMax() + "\n");
		writer.write("Real_step = " + realInterval.getStep() + "\n");
		writer.write("String_min = 1\n");
		writer.write("String_max = " + stringMax + "\n");
				// TODO: Compute this using some strategy and/or from the Backend
				//"String_max = " + (15 + (adapter==null? 0 : adapter.getNumberAdaptations())) + "\n" + // heuristic: 15 + number of adapted strings
		writer.write("Integer_min = -10\n");
		writer.write("Integer_max = 10\n");
	}

	protected void customGenPropertiesFiles(IBoundsProvider boundsProvider, StringWriter writer) {		
		try {
			List<EReference> references = new ArrayList<EReference>();
			int index      = 0;
			int lowerBound = 0;
			int upperBound = 0;
					
			for (EFClass efc : model.getAllClasses()) {
				EClass classifier = efc.getKlass();
				// Bounds for non-abstract classes
				if ( ! classifier.isAbstract() ) {
					Interval interval = boundsProvider.getScope((EClass) classifier);
					if ( interval == null ) {
						throw new IllegalStateException();
						//lowerBound = classifier.getName().equals(rootClassName)? 1 : 0; 
						//upperBound = objectUpperBound; 
					} else {
						lowerBound = interval.getMin();
						upperBound = interval.getMax();
					}
					
					writer.write(mapping.toUseTypeName(classifier) + "_min = " + lowerBound + "\n"); 
					writer.write(mapping.toUseTypeName(classifier) + "_max = " + upperBound + "\n");                                					
				}

				// Bound of attributes, including abstract classes
				for (EAttribute feature : model.getAttributes(classifier)) {
					// writer.write(classifier.getName() + "_" + feature.getName() + "_min = 0\n");   // 0 (value changed 03-01-2016, before it was -1)
					
					if (feature.getEAttributeType().getName().toLowerCase().contains("double")) {
						RealInterval realInterval = boundsProvider.getRealInterval();		
						double min = realInterval.getMin();
						double max = realInterval.getMax();
						writer.write(mapping.toUseTypeName(classifier) + "_" + feature.getName() + "_min = " + -1 + "\n");   // 0 (value changed 03-01-2016, before it was -1)
						writer.write(mapping.toUseTypeName(classifier) + "_" + feature.getName() + "_max = " + 1 + "\n");  // unbound
					} else {
						writer.write(mapping.toUseTypeName(classifier) + "_" + feature.getName() + "_min = -1\n");   // 0 (value changed 03-01-2016, before it was -1)
						writer.write(mapping.toUseTypeName(classifier) + "_" + feature.getName() + "_max = -1\n");  // unbound
					}
				}

				for (EReference ref : model.getReferences(classifier)) 
					if (!references.contains(ref.getEOpposite()))
						references.add(ref);				
			}
			
			// Bound of references ----------------------------------------------------------	
			for (EReference ref : references) {
				Interval interval = boundsProvider.getScope(ref);
				if ( interval == null ) {
					throw new IllegalStateException();
					//lowerBound = 0;
					//upperBound = objectUpperBound;					
				} else {
					lowerBound = interval.getMin();
					upperBound = interval.getMax();
				}
				String assoc = getAssociationName(ref);
				writer.write(assoc + "_min = " + lowerBound + "\n");
				writer.write(assoc + "_max = " + upperBound + "\n");
			}
			
			writer.close();
		} catch (IOException e1) { 
			throw new IllegalStateException();
		}
	}

	@NonNull
	private String getAssociationName(@NonNull EReference ref) {
		return mapping.getAssociation(ref).getName();
	}

}
