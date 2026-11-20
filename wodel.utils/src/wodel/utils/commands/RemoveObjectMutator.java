package wodel.utils.commands;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RemoveObjectMutator removes objects from the
 * diagram
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RemoveObjectMutator extends Mutator {

	/**
	 * Object to delete
	 */
	private ObSelectionStrategy objSelection;

	/**
	 * Reference we are going to select the object in
	 */
	private ObSelectionStrategy referenceSelection;
	/**
	 * Object that contains the selected object
	 */
	private ObSelectionStrategy containerSelection;
	/**
	 * Object to delete
	 */
	private List<EObject> obj;

	/**
	 * Deleted object
	 */
	private List<EObject> result;

	/**
	 * Saved object
	 */
	private List<EObject> saved;
	
	/**
	 * Identification
	 */
	/*
	private String identification;
	*/
	
	/**
	 * URI
	 */
	/*
	private URI uri;
	*/
	
	/**
	 * Type of the removed object 
	 */
	/*
	private EClass eType;
	*/
	
	/*
	 * Registry information captured BEFORE the object is removed.
	 */
	private EObject registryObject;
	private EObject registryObjectByID;
	private EObject registryObjectByURI;

	private String identification;
	private URI uri;
	private EClass eType;

	
	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, List<EPackage> metaModel,
			ObSelectionStrategy objSelection, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(model, metaModel, "ObjectRemoved");
		this.objSelection = objSelection;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, List<EPackage> metaModel,
			EObject obj, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(model, metaModel, "ObjectRemoved");
		this.obj = new ArrayList<EObject>();
		this.obj.add(obj);
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
	}

	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, List<EPackage> metaModel,
			EObject obj) {
		super(model, metaModel, "ObjectRemoved");
		this.obj = new ArrayList<EObject>();
		this.obj.add(obj);
		this.identification = "";
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, List<EPackage> metaModel,
			List<EObject> obj, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(model, metaModel, "ObjectRemoved");
		this.obj = new ArrayList<EObject>();
		this.obj.addAll(obj);
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
	}

	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, List<EPackage> metaModel,
			List<EObject> obj) {
		super(model, metaModel, "ObjectRemoved");
		this.obj = new ArrayList<EObject>();
		this.obj.addAll(obj);
		this.identification = "";
	}

	
	/*
	public Object mutate() throws ReferenceNonExistingException {
		// All the references of each object
		List<EObject> tmpDeletedObj = new ArrayList<EObject>();

		if (this.obj == null || (this.obj != null && this.obj.size() == 0)) {
			if (this.objSelection == null) {
				return null;
			}
			if (this.objSelection != null && this.objSelection.getObject() == null && this.objSelection.getObjects() == null) {
				return null;
			}
			if (this.objSelection.getObject() != null) {
				tmpDeletedObj.add(this.objSelection.getObject());
			}
			if (this.objSelection.getObjects() != null) {
				tmpDeletedObj.addAll(this.objSelection.getObjects());
			}
		} else {
			tmpDeletedObj.addAll(this.obj);
		}
		
		//We select the container of the new Object
		EObject container = null;
		if (containerSelection != null) {
			container = containerSelection.getObject();
		}
		//We select the container of the new Object
		EReference reference = null;
		if (referenceSelection != null) {
			reference = (EReference) referenceSelection.getObject();
		}

		// removes lost null objects
		List<EObject> deletedObj = new ArrayList<EObject>();
		for (EObject deletedOb : tmpDeletedObj) {
			if (deletedOb != null) {
				deletedObj.add(deletedOb);
			}
		}
		if (deletedObj == null || (deletedObj != null && deletedObj.size() == 0)) {
			result = null;
			return null;
		}
		
		saved = new ArrayList<EObject>();
		for (EObject deletedOb : deletedObj) {
			saved.add(EcoreUtil.copy(deletedOb));
			identification = EcoreUtil.getIdentification(deletedOb);
		}
		uri = EcoreUtil.getURI(deletedObj.get(0));
		eType = deletedObj.get(0).eClass();
		
		if ((container == null) && (reference == null)) {
			for (EObject deletedOb : deletedObj) {
				EcoreUtil.remove(deletedOb);
				
				// For each object of the model
				for (EObject o : ModelManager.getAllObjects(this.getModel())) {
					// We check their references looking for the deleted object
					for (EReference r : ModelManager.getReferences(o)) {
						// Multivalued
						if (r.getUpperBound() > 1 || r.getUpperBound() < 0) {
							// We save the referenced objects of the reference
							List<EObject> referenced = (List<EObject>) o.eGet(r, true);
							List<EObject> auxList = new ArrayList<EObject>();
							for (EObject aux : referenced) {
								// If the object pointed is the selected
								if (EcoreUtil.equals(aux, deletedOb)) {
									// We save what we want to delete (cannot do it in
									// this for)
									auxList.add(aux);
								}
							}
							// And then we delete what we saved (outside the for)
							for (EObject aux : auxList) {
								referenced.remove(aux);
							}
						}
						// Monovalued
						else {
							EObject auxObj = (EObject) o.eGet(r, true);
							if (auxObj == null) {
								continue;
							}

							// If the object pointed is the selected
							if (EcoreUtil.equals(auxObj, deletedOb)) {
								// We delete the reference
								o.eSet(r, null);
							}
						}
					}
				}
			}
		}
		if ((container != null) && (reference != null)) {
			if (container.eGet(reference) instanceof List<?>) {
				List<EObject> objects = (List<EObject>) container.eGet(reference);
				for (EObject deletedOb : deletedObj) {
					for (EObject obj : objects) {
						if (EcoreUtil.equals(obj, deletedOb)) {
							objects.remove(obj);
							break;
						 }
					}
				}
			}
			else {
				EObject obj = (EObject) container.eGet(reference);
				for (EObject deletedOb : deletedObj) {
					if (EcoreUtil.equals(obj, deletedOb)) {
						ModelManager.unsetReference(reference.getName(), container);
					}
				}
			}
		}
		result = new ArrayList<EObject>();
		result.addAll(saved);

		if (this.result != null && this.result.size() > 0) {
			return this.result;
		}
		return null;
	}
	*/

	

	/** True when {@code owner.reference} points to this exact EObject. */
	private static boolean containsReferenceValue(EObject owner, EReference reference, EObject value) {
		Object current = owner.eGet(reference, true);
		if (reference.isMany()) {
			if (!(current instanceof List<?>)) {
				return false;
			}
			for (Object entry : (List<?>) current) {
				if (entry == value) {
					return true;
				}
			}
			return false;
		}
		return current == value;
	}

	/**
	 * Removes the selected object(s) from the model.
	 */
	@Override
	public Object mutate()
	        throws ReferenceNonExistingException {

		// Perform the selected deletion.

		/*
	     * Reset state in case the mutator instance is reused.
	     */
	    result = null;
	    saved = null;

	    registryObject = null;
	    registryObjectByID = null;
	    registryObjectByURI = null;

	    identification = null;
	    uri = null;
	    eType = null;


	    /*
	     * =========================================================
	     * 1. Determine the object(s) to delete.
	     * =========================================================
	     */
	    List<EObject> tmpDeletedObj =
	        new ArrayList<EObject>();

	    if (obj == null || obj.isEmpty()) {

	        if (objSelection == null) {
	            return null;
	        }

	        EObject selectedObject =
	            objSelection.getObject();

	        List<EObject> selectedObjects =
	            objSelection.getObjects();

	        if (selectedObject == null
	                && (selectedObjects == null
	                    || selectedObjects.isEmpty())) {

	            return null;
	        }

	        if (selectedObject != null) {
	            tmpDeletedObj.add(
	                selectedObject);
	        }

	        if (selectedObjects != null) {
	            tmpDeletedObj.addAll(
	                selectedObjects);
	        }
	    }
	    else {
	        tmpDeletedObj.addAll(
	            obj);
	    }


	    /*
	     * Remove null entries.
	     */
	    List<EObject> deletedObj =
	        new ArrayList<EObject>();

	    java.util.Set<EObject> distinct = java.util.Collections
	            .newSetFromMap(new java.util.IdentityHashMap<EObject, Boolean>());
	    for (EObject candidate : tmpDeletedObj) {
	        if (candidate != null && distinct.add(candidate)) {
	            deletedObj.add(candidate);
	        }
	    }

	    if (deletedObj.isEmpty()) {
	        return null;
	    }


	    /*
	     * =========================================================
	     * 2. Resolve optional container/reference selections.
	     * =========================================================
	     */
	    EObject container = null;

	    if (containerSelection != null) {
	        container =
	            containerSelection.getObject();
	    }


	    EReference reference = null;

	    if (referenceSelection != null) {

	        EObject selectedReference =
	            referenceSelection.getObject();

	        if (selectedReference
	                instanceof EReference) {

	            reference =
	                (EReference) selectedReference;
	        }
	    }


	    /*
	     * =========================================================
	     * 3. CAPTURE REGISTRY IDENTITY BEFORE DELETION.
	     * =========================================================
	     *
	     * This is the critical part.
	     *
	     * The generated Wodel registry later calls:
	     *
	     *     mut.getObject()
	     *     mut.getObjectByID()
	     *     mut.getObjectByURI()
	     *
	     * These values must therefore be captured while the object
	     * still belongs to the model.
	     *
	     * The registry API is singular, so all three identities refer
	     * consistently to the FIRST removed object.
	     */
	    EObject primaryObject =
	        deletedObj.get(0);

	    registryObject =
	        primaryObject;

	    eType =
	        primaryObject.eClass();


	    /*
	     * Identification-based handle.
	     */
	    identification =
	        EcoreUtil.getIdentification(
	            primaryObject);

	    if (identification != null
	            && !identification.isBlank()) {

	        registryObjectByID =
	            ModelManager.getObjectByID(
	                this.getModel(),
	                identification);
	    }


	    /*
	     * URI-based handle.
	     */
	    uri =
	        EcoreUtil.getURI(
	            primaryObject);

	    if (uri != null) {

	        registryObjectByURI =
	            ModelManager.getObjectByURI(
	                this.getModel(),
	                uri);
	    }


	    /*
	     * Defensive fallbacks.
	     *
	     * At this point primaryObject is still attached to the model,
	     * so it is a much better registry handle than null.
	     */
	    if (registryObjectByID == null) {
	        registryObjectByID =
	            primaryObject;
	    }

	    if (registryObjectByURI == null) {
	        registryObjectByURI =
	            primaryObject;
	    }


	    /*
	     * =========================================================
	     * 4. Save detached copies as the mutation RESULT.
	     * =========================================================
	     *
	     * These copies are kept separate from the registry handles.
	     */
	    saved =
	        new ArrayList<EObject>();

	    for (EObject deletedOb :
	            deletedObj) {

	        saved.add(
	            EcoreUtil.copy(
	                deletedOb));
	    }

		/*
		 * 5. Apply the deletion or unlink operation.
		 *
		 * Wodel's `remove ... from owner->reference` has two meanings:
		 *  - containment: delete the selected EObject(s) and their contents;
		 *  - non-containment: remove only the selected reference link(s).
		 *    The referenced EObject(s) remain in their actual containment.
		 * A plain `remove ...` without `from` always deletes the object.
		 */
		if ((container == null) != (reference == null)) {
			throw new IllegalStateException(
					"Container and reference must either both be specified or both be null.");
		}

		boolean unlinkOnly = false;
		EReference effectiveReference = reference;

		if (container != null) {
			if (!container.eClass().getEAllReferences().contains(reference)) {
				throw new IllegalStateException("Reference '" + reference.getName()
						+ "' does not belong to the selected container type '"
						+ container.eClass().getName() + "'.");
			}
			if (!reference.isChangeable() || reference.isDerived()) {
				throw new IllegalStateException("Reference '" + reference.getName()
						+ "' is not changeable.");
			}

			boolean allInProvidedReference = true;
			for (EObject deletedOb : deletedObj) {
				if (!containsReferenceValue(container, reference, deletedOb)) {
					allInProvidedReference = false;
					break;
				}
			}

			if (!allInProvidedReference) {
				// Guarded recovery for a wrongly generated reference selection:
				// it is safe only if EVERY selected object is actually contained
				// by this exact owner, under the SAME containment reference.
				EReference actualContainment = null;
				boolean sameActualContainment = true;
				for (EObject deletedOb : deletedObj) {
					if (deletedOb.eContainer() != container
							|| !(deletedOb.eContainingFeature() instanceof EReference)) {
						sameActualContainment = false;
						break;
					}
					EReference candidate = (EReference) deletedOb.eContainingFeature();
					if (!candidate.isContainment()
							|| (actualContainment != null && actualContainment != candidate)) {
						sameActualContainment = false;
						break;
					}
					actualContainment = candidate;
				}
				if (!sameActualContainment || actualContainment == null) {
					throw new IllegalStateException("Selected object(s) are not referenced by '"
							+ reference.getName() + "' of '" + container.eClass().getName()
							+ "'. Verify the reference and owner passed by generated Wodel code.");
				}
				effectiveReference = actualContainment;
				System.err.println("[WODEL] Correcting generated reference selection '"
						+ reference.getName() + "' to actual containment '"
						+ effectiveReference.getName() + "' for " + container.eClass().getName());
			}

			if (effectiveReference.isContainment()) {
				for (EObject deletedOb : deletedObj) {
					if (deletedOb.eContainer() != container
							|| deletedOb.eContainingFeature() != effectiveReference) {
						throw new IllegalStateException("Selected object does not belong to '"
								+ effectiveReference.getName() + "' containment of '"
								+ container.eClass().getName() + "'.");
					}
				}
			} else {
				unlinkOnly = true;
			}
		}

		if (unlinkOnly) {
			// Only disconnect the links from this owner. In particular, removing
			// an Action from BotInteraction.actions must NOT delete Bot.actions.
			if (effectiveReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> values = (List<EObject>) container.eGet(effectiveReference);
				for (EObject deletedOb : deletedObj) {
					for (int i = values.size() - 1; i >= 0; i--) {
						if (values.get(i) == deletedOb) {
							values.remove(i);
						}
					}
				}
			} else {
				container.eUnset(effectiveReference);
			}
		} else {
			// Remember deleted objects and their contained descendants BEFORE
			// detaching them, so dangling non-containment links can be cleaned.
			java.util.Set<EObject> removedObjects = java.util.Collections
					.newSetFromMap(new java.util.IdentityHashMap<EObject, Boolean>());
			for (EObject deletedOb : deletedObj) {
				removedObjects.add(deletedOb);
				org.eclipse.emf.common.util.TreeIterator<EObject> it = deletedOb.eAllContents();
				while (it.hasNext()) {
					removedObjects.add(it.next());
				}
			}

			for (EObject deletedOb : deletedObj) {
				EcoreUtil.remove(deletedOb);
			}

			for (EObject modelObject : ModelManager.getAllObjects(this.getModel())) {
				for (EReference modelReference : modelObject.eClass().getEAllReferences()) {
					if (modelReference.isContainment() || modelReference.isContainer()
							|| modelReference.isDerived() || !modelReference.isChangeable()) {
						continue;
					}
					if (modelReference.isMany()) {
						@SuppressWarnings("unchecked")
						List<EObject> values = (List<EObject>) modelObject.eGet(modelReference);
						for (int i = values.size() - 1; i >= 0; i--) {
							if (removedObjects.contains(values.get(i))) {
								values.remove(i);
							}
						}
					} else {
						Object referenced = modelObject.eGet(modelReference);
						if (referenced instanceof EObject && removedObjects.contains(referenced)) {
							modelObject.eUnset(modelReference);
						}
					}
				}
			}
		}

	    /*
	     * =========================================================
	     * 7. Return snapshots of the deleted objects.
	     * =========================================================
	     */
	    result =
	        new ArrayList<EObject>(
	            saved);

		return result.isEmpty()
	        ? null
	        : result;
	}


	/*
	 * =============================================================
	 * Registry getters
	 * =============================================================
	 */

	/**
	 * Returns the original object handle captured before deletion.
	 *
	 * This is intentionally NOT the detached copy returned as the
	 * mutation result.
	 */
	@Override
	public EObject getObject() {
	    return registryObject;
	}


	/**
	 * Returns the ID-based object handle captured before deletion.
	 */
	@Override
	public EObject getObjectByID() {
	    return registryObjectByID;
	}


	/**
	 * Returns the URI-based object handle captured before deletion.
	 */
	@Override
	public EObject getObjectByURI() {
	    return registryObjectByURI;
	}

	/**
	 * Returns the type of the removed object.
	 */
	@Override
	public EClass getEType() {
	    return eType;
	}

	/*
	// GETTERS AND SETTERS
	public EObject getObject() {
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	// END GETTERS AND SETTERS
	
	public EObject getObjectByID() {
		return ModelManager.getObjectByID(this.getModel(), identification);
	}
	public EObject getObjectByURI() {
		return ModelManager.getObjectByURI(this.getModel(), uri);
	}
	public EClass getEType() {
		return eType;
	}
	*/
	
}
