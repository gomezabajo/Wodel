package wodel.utils.commands;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ModifyTargetReferenceMutator Modify the target of
 * references
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ModifyTargetReferenceMutator extends Mutator {

	/**
	 * Original EObject
	 */
	private EObject object;
	
	/**
	 * Original source
	 */
	private ObSelectionStrategy source;
	
	/**
	 * New target
	 */
	private ObSelectionStrategy newTarget;
	/**
	 * Type of the reference
	 */
	private String refType;
	/**
	 * New target
	 */
	private EObject result;
	
	/**
	 * Source of the relation
	 */
	private EObject srcObject;
	
	/**
	 * Source reference name of the relation
	 */
	private String srcRefType;
	
	/**
	 * Old target
	 */
	private List<EObject> oldTarget;
	
	/**
	 * Identification
	 */
	private String identification;
	
	/**
	 * URI
	 */
	private URI uri;

	/**
	 * Identification
	 */
	private String identificationNewTarget;
	
	/**
	 * URI
	 */
	private URI uriNewTarget;

	/**
	 * Identification
	 */
	private String identificationOldTarget;
	
	/**
	 * URI
	 */
	private URI uriOldTarget;

	/**
	 * @param model
	 * @param metaModel
	 * @param source
	 * @param newTarget
	 * @param refType
	 *            Normal constructor
	 */
	public ModifyTargetReferenceMutator(Resource model,
			List<EPackage> metaModel, ObSelectionStrategy source,
			ObSelectionStrategy newTarget, String refType) {
		super(model, metaModel, "TargetReferenceChanged");
		this.source = source;
		this.newTarget = newTarget;
		this.refType = refType;
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException,
			ObjectNoTargetableException {
		if (this.source == null) {
			return null;
		}
		if (this.newTarget == null) {
			return null;
		}
		EObject container = this.source.getObject();
		EObject newTarget = this.newTarget.getObject();

		this.identification = EcoreUtil.getIdentification(container);
		this.uri = EcoreUtil.getURI(container);

		this.identificationNewTarget = EcoreUtil.getIdentification(newTarget);
		this.uriNewTarget = EcoreUtil.getURI(newTarget);

		// We get the specified references
		List<EStructuralFeature> refs = ModelManager
				.getAllReferencesByName(refType, this.getModel());

		if (refs == null) {
			this.result = null;
			return null;
		}

		// We select a random source
		if (container == null) {
			List<EObject> sources = new ArrayList<EObject>();
			for (EObject o : ModelManager.getAllObjects(this.getModel())) {
				if (ModelManager.getReferenceByName(refType, o) != null) {
					sources.add(o);
				}
			}
			// Random object
			if (sources.size() > 0) {
				container = sources.get(ModelManager.getRandomIndex(sources));
			}
		}
		if (container == null) {
			this.result = null;
			return null;
		}
		
		// We select a random new Target
		if (newTarget == null) {
			List<EObject> newTargets = new ArrayList<EObject>();
			EReference r = (EReference) ModelManager.getReferenceByName(
					this.refType, container);
			for (EObject o : ModelManager.getAllObjects(this.getModel())) {
				if (r.getEType().getName().equals(o.eClass().getName())) {
					newTargets.add(o);
				}
			}
			// Random object
			while (newTargets.size() > 0) {
				int index = ModelManager.getRandomIndex(newTargets);
				newTarget = newTargets.get(index);
			}
		}

		if (container == null || newTarget == null) {
			this.result = null;
			return null;
		}

		// We get a different object
		EStructuralFeature ref = null;
		this.oldTarget = new ArrayList<EObject>();
		for (EStructuralFeature r : refs) {
			this.oldTarget.add((EObject) container.eGet(r));
			if (!EcoreUtil.equals(oldTarget.get(0), newTarget)) {
				ref = r;
				break;
			}
		}
		if (this.oldTarget == null || this.oldTarget.size() == 0 || this.oldTarget.get(0) == null) {
			this.result = null;
			return null;
		}

		if (EcoreUtil.equals(this.oldTarget.get(0), newTarget)) {
			this.result = null;
			return null;
		}

		this.identificationOldTarget = EcoreUtil.getIdentification(this.oldTarget.get(0));
		this.uriOldTarget = EcoreUtil.getURI(this.oldTarget.get(0));
		
		this.object = container;

		if(!ref.getEType().getName().equals(newTarget.eClass().getName())){
			boolean found = false;
			for (EClass superType : newTarget.eClass().getEAllSuperTypes()) {
				if (superType.getName().equals(ref.getEType().getName())) {
					found = true;
					break;
				}
			}
			if (found == false) {			
				this.result = null;
				throw new ObjectNoTargetableException("The reference '"+ref.getName()+"' cannot contain the object '"+newTarget.eClass().getName()+"'.");
			}
		}

		// Multivalued
		if (ref.getUpperBound() > 1 || ref.getUpperBound() < 0) {
			List<EObject> aux = null;
			try {
				// We get the referenced objects of the source
				aux = (List<EObject>) container.eGet(ref, true);
			}
			// Source has not that kind of reference
			catch (Exception e) {
				this.result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ container.eClass().getName());
			}

			aux.clear();

			// We clone the target because the addition would delete the that
			// object in its original container
			EObject clonedTarget = EcoreUtil.copy(newTarget);

			// We add the reference
			aux.add(clonedTarget);

			result = newTarget;
		}

		// Monovalued
		else {
			try {
				container.eSet(ref, newTarget);
			}
			// Source has not that kind of reference
			catch (Exception e) {
				this.result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ container.eClass().getName());
			}

			result = newTarget;
		}

		// Source of the transition
		for (EReference r : ModelManager.getReferences(container)) {
			if (r.getName().equals(refType)) {
				continue;
			}
			if (r.getEType().getName().equals(newTarget.eClass().getName())) {
				this.srcObject = (EObject) container.eGet(r, true);
				this.srcRefType = r.getName();
			}
		}


		return this.result;
	}

	// GETTERS AND SETTERS
	/*
	public EObject getSource() {
		if (source != null) {
			try {
				return source.getObject();
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	*/
	public EObject getSource() {
		return this.srcObject;
	}
	
	public String getSrcRefType() {
		return this.srcRefType;
	}

	public EObject getObject() {
		return this.object;
		//if (source != null) {
		//	try {
		//		return source.getObject();
		//	} catch (ReferenceNonExistingException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//}
		//return null;
	}
	
	public EObject getNewTarget() {
		return this.result;
		//if (newTarget != null) {
		//	try {
		//		return newTarget.getObject();
		//	} catch (ReferenceNonExistingException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//}
		//return null;
	}
	
	public EObject getObjectByID(Resource model) {
		return ModelManager.getObjectByID(model, this.identification);
	}

	public EObject getObjectByURI(Resource model) {
		return ModelManager.getObjectByURI(model, this.uri);
	}

	public EObject getNewTargetByID(Resource model) {
		return ModelManager.getObjectByID(model, this.identificationNewTarget);
	}

	public EObject getNewTargetByURI(Resource model) {
		return ModelManager.getObjectByURI(model, this.uriNewTarget);
	}
	
	public EObject getOldTargetByID(Resource model) {
		return ModelManager.getObjectByID(model, this.identificationOldTarget);
	}

	public EObject getOldTargetByURI(Resource model) {
		return ModelManager.getObjectByURI(model, this.uriOldTarget);
	}
	
	public URI getOldTargetURI() {
		return this.uriOldTarget;
	}

	public EObject getOldTarget() {
		return this.oldTarget != null ? (this.oldTarget.size() > 0 ? this.oldTarget.get(0) : null) : null;
	}

	public String getRefType() {
		return this.refType;
	}
	// END GETTERS AND SETTERS
}
