package tinytools.metamodel.merger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import tinytools.metamodel.staticfacade.BaseCompiler;

/**
 * Terminology:
 *  - Receiving: The package which is augmented by the merge
 *  - Merged: The package used to augment the receiving package
 *  - Resulting: The result of the merge
 * 
 * The merge strategy is as follows:
 * <ul>
 * 	<li>...</li>
 * </ul>
 * 
 * @author jesus
 *
 */
public class Merger extends BaseCompiler {
	
	private MergerOptions options;
	private LinkedHashMap<EObject, EObject> trace;
	private Resource merged;
	private Resource receiving;
	private ArrayList<PendingOperation> pending;
	
	public Resource compile(Resource receiving, Resource merged, MergerOptions options)
			throws IOException {
	
		this.options = options;
		this.merged  = merged;
		this.receiving = receiving;
		this.pending = new ArrayList<PendingOperation>();
		
		Resource r = new XMIResourceImpl();
				
		Copier copier = new EcoreUtil.Copier();
		copier.copyAll(receiving.getContents());
		trace = copier;
		
		// Merge happens only at the top level
		List<? extends EPackage> pkgs = filter(merged.getContents(), EPackage.class);
		for (EPackage mergedPkg : pkgs) {
			mergePackage(null, mergedPkg, copier);
		}
		
		copier.copyReferences();
		
		for (PendingOperation p : pending) {
			p.run();
		}
		
		for(EObject obj : trace.values()) {
			if ( obj.eContainer() == null ) {
				r.getContents().add(obj);
			}
		}
		
		// Adjust reference types
		changeReferences(getAllOfType(r, EClass.class));
		
		
		return r;
	}

	private void mergePackage(EPackage parentResultingPkg, EPackage mergedPkg, Copier copier) {
		EPackage resultingPkg = findResulting(mergedPkg);
		if ( resultingPkg != null ) {
			// Modify name
			if ( options.isModifyURI() ) {
				resultingPkg.setName(mergedPkg.getName());
				resultingPkg.setNsURI(mergedPkg.getNsURI());
				resultingPkg.setNsPrefix(mergedPkg.getNsPrefix());
			}
			
			// Merge classes
			EList<EClassifier> classifiers = mergedPkg.getEClassifiers();
			ArrayList<EClassifier> toBeCopied = new ArrayList<EClassifier>();

			for (EClassifier mergedClassifier : classifiers) {
				if ( mergedClassifier instanceof EClass ) {
					EClass resultingClass = findResulting(resultingPkg, (EClass) mergedClassifier);
					if ( resultingClass == null ) {
						toBeCopied.add(mergedClassifier);
					} else {
						mergeClass((EClass) mergedClassifier, resultingClass, copier);
					}
				} else {
					toBeCopied.add(mergedClassifier);
				}
			}
			
			// Copy new classifiers
			Collection<? extends EClassifier> result = copier.copyAll(toBeCopied);
			resultingPkg.getEClassifiers().addAll(result);
			
			// Merge the sub package
			for (EPackage subMergedPkg : mergedPkg.getESubpackages()) {
				mergePackage(resultingPkg, subMergedPkg, copier);
			}
			
		} else {
			// Different package, just copy 
			// TODO: This does not work well if an EClass inherits or uses
			//       a class of the receiving package
			EPackage copiedPkg = (EPackage) copier.copy(mergedPkg);				
			if ( parentResultingPkg != null )
				parentResultingPkg.getESubpackages().add(copiedPkg);
		}
	}
	
	private void changeReferences(Collection<EClass> result) {
		for (EClass eClass : result) {
			for(EReference r : eClass.getEReferences()) {
				EClass c = findResultingAll(r.getEReferenceType());
				if ( c != null ) {
					r.setEType(c);
				}
			}
			
			for(int i = 0; i < eClass.getESuperTypes().size(); i++) {
				EClass sup =  eClass.getESuperTypes().get(i);
				EClass c = findResultingAll(sup);
				if ( c != null ) {
					eClass.getESuperTypes().set(i, c);
				}
			}
		}
	}

	private void mergeClass(EClass mergedClass, EClass resultingClass, Copier copier) {
		for(EStructuralFeature f : mergedClass.getEStructuralFeatures() ) {
			EStructuralFeature copied = (EStructuralFeature) copier.copy(f);
			resultingClass.getEStructuralFeatures().add(copied);
		}
		
		if ( mergedClass.getESuperTypes().size() > 0 ) {
			System.out.println("Extending supertypes with merged class: " + mergedClass.getName());
			
			for(EClass msup : mergedClass.getESuperTypes()) {
				boolean found = false;
				for(EClass rsup : resultingClass.getESuperTypes()) {
					if ( rsup.getName().equals(msup.getName()) ) {
						found = true;
						break;
					}
				}	
				
				// If the superclass is not part of the existing supertypes
				if ( ! found ) {
					pending.add(new SetNewSuperType(resultingClass, msup));
				}
			}
			
		}
	}

	private EClass findResultingAll(EClass mergedClass) {
		List<? extends EClass> classes = getAllOfType(receiving, EClass.class);
		for (EClass receivingClass : classes) {
			if ( receivingClass.getName().equals(mergedClass.getName()) ) {
				EObject c = trace.get(receivingClass);
				if ( c == null )
					throw new IllegalStateException();
				return (EClass) c;
			}
		}
		return null;
	}

	private EClass findResulting(EPackage resultingPackage, EClass mergedClass) {
		List<? extends EClass> classes = filter(resultingPackage.getEClassifiers(), EClass.class);
		for (EClass resultingClass : classes) {
			if ( resultingClass.getName().equals(mergedClass.getName()) ) {
				return resultingClass;
			}
		}
		return null;
	}

	private EPackage findResulting(EPackage mergedPkg) {
		String boundName = getBoundName(mergedPkg);
		List<? extends EPackage> pkgs = getAllPackages(receiving);
		for (EPackage ePackage : pkgs) {
			if ( ePackage.getName().equals(boundName) ) {
				EObject resulting = trace.get(ePackage);
				if ( resulting == null ) 
					throw new IllegalStateException();
				return (EPackage) resulting;
			}
		}
		return null;
	}

	private String getBoundName(EPackage mergedPkg) {
		for(EAnnotation ann : mergedPkg.getEAnnotations()) {
			if ( ann.getSource().equals("merge") ) {
				String name = ann.getDetails().get("name");
				if ( name == null ) 
					throw new IllegalStateException();
				return name;
			}
			
		}
		return mergedPkg.getName();
	}

	private EObject getTrace(EObject src) {
		EObject tgt = this.trace.get(src);
		if ( tgt == null )
			throw new IllegalStateException();
		return tgt;
	}
	
	private interface PendingOperation {
		void run();
	}
	
	private class SetNewSuperType implements PendingOperation {
		private EClass resultingClass;
		private EClass mergedSuperType;

		public SetNewSuperType(EClass resultingClass, EClass mergedSuperType) {
			this.resultingClass = resultingClass;
			this.mergedSuperType = mergedSuperType;
		}

		@Override
		public void run() {
			resultingClass.getESuperTypes().add((EClass) getTrace(mergedSuperType));
		}
	}
	
	
}
