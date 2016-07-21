package commands;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ObjectNoTargetableException;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero ModifyTargetReferenceMutator Modify the target of
 *         references
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
	private EObject oldTarget;

	/**
	 * @param model
	 * @param metaModel
	 * @param source
	 * @param newTarget
	 * @param refType
	 *            Normal constructor
	 */
	public ModifyTargetReferenceMutator(Resource model,
			ArrayList<EPackage> metaModel, ObSelectionStrategy source,
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

		// We get the specified references
		ArrayList<EStructuralFeature> refs = ModelManager
				.getAllReferencesByName(refType, this.getModel());

		if (refs == null) {
			result = null;
			return null;
		}

		// We select a random source
		if (container == null) {
			ArrayList<EObject> sources = new ArrayList<EObject>();
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
			result = null;
			return null;
		}
		
		// We select a random new Target
		if (newTarget == null) {
			ArrayList<EObject> newTargets = new ArrayList<EObject>();
			EReference r = (EReference) ModelManager.getReferenceByName(
					refType, container);
			for (EObject o : ModelManager.getAllObjects(this.getModel())) {
				if (r.getEType().getName().equals(o.eClass().getName())) {
					newTargets.add(o);
				}
			}
			// Random object
			if (newTargets.size() > 0) {
				newTarget = newTargets.get(ModelManager
						.getRandomIndex(newTargets));
			}
		}

		if (container == null || newTarget == null) {
			result = null;
			return null;
		}

		// We get a different object
		EStructuralFeature ref = null;
		for (EStructuralFeature r : refs) {
			oldTarget = (EObject) container.eGet(r);
			if (!EcoreUtil.equals(oldTarget, newTarget)) {
				ref = r;
				break;
			}
		}
		if (EcoreUtil.equals(oldTarget, newTarget)) {
			result = null;
			return null;
		}

		object = EcoreUtil.copy(container);

		if (!ref.getEType().getName().equals(newTarget.eClass().getName())) {
			result = null;
			throw new ObjectNoTargetableException("The reference '"
					+ ref.getName() + "' cannot contain the object '"
					+ newTarget.eClass().getName() + "'.");
		}

		// Multivalued
		if (ref.getUpperBound() > 1 || ref.getUpperBound() < 0) {
			System.out.println("Multivalued");
			List<EObject> aux = null;
			try {
				// We get the referenced objects of the source
				aux = (List<EObject>) container.eGet(ref, true);
			}
			// Source has not that kind of reference
			catch (Exception e) {
				result = null;
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
			System.out.println("Monovalued");
			System.out.println("ref: " + ref + ", newTarget: " + newTarget);
			try {
				container.eSet(ref, newTarget);
			}
			// Source has not that kind of reference
			catch (Exception e) {
				result = null;
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
				srcObject = (EObject) container.eGet(r, true);
				srcRefType = r.getName();
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
		return srcObject;
	}
	
	public String getSrcRefType() {
		return srcRefType;
	}

	public EObject getObject() {
		return object;
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
		return result;
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
	
	public EObject getOldTarget() {
		return oldTarget;
	}

	public String getRefType() {
		return refType;
	}
	// END GETTERS AND SETTERS
}
