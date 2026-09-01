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


	/**
	 * Removes the selected object(s) from the model.
	 */
	@Override
	public Object mutate()
	        throws ReferenceNonExistingException {

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

	    for (EObject candidate :
	            tmpDeletedObj) {

	        if (candidate != null) {
	            deletedObj.add(
	                candidate);
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
	     * =========================================================
	     * 5. Perform the deletion.
	     * =========================================================
	     */
	    if (container == null
	            && reference == null) {

	        for (EObject deletedOb :
	                deletedObj) {

	            /*
	             * Remove from its containment.
	             */
	            EcoreUtil.remove(
	                deletedOb);


	            /*
	             * Remove remaining references to the deleted object.
	             */
	            for (EObject modelObject :
	                    ModelManager.getAllObjects(
	                        this.getModel())) {

	                for (EReference modelReference :
	                        ModelManager.getReferences(
	                            modelObject)) {

	                    /*
	                     * Multivalued reference.
	                     */
	                    if (modelReference.isMany()) {

	                        @SuppressWarnings("unchecked")
	                        List<EObject> referencedObjects =
	                            (List<EObject>) modelObject.eGet(
	                                modelReference,
	                                true);

	                        if (referencedObjects == null
	                                || referencedObjects.isEmpty()) {

	                            continue;
	                        }

	                        /*
	                         * Iterate backwards so removal is safe.
	                         */
	                        for (int i =
	                                referencedObjects.size() - 1;
	                                i >= 0;
	                                i--) {

	                            EObject referenced =
	                                referencedObjects.get(i);

	                            if (referenced != null
	                                    && EcoreUtil.equals(
	                                        referenced,
	                                        deletedOb)) {

	                                referencedObjects.remove(i);
	                            }
	                        }
	                    }

	                    /*
	                     * Single-valued reference.
	                     */
	                    else {

	                        Object value =
	                            modelObject.eGet(
	                                modelReference,
	                                true);

	                        if (!(value instanceof EObject)) {
	                            continue;
	                        }

	                        EObject referenced =
	                            (EObject) value;

	                        if (EcoreUtil.equals(
	                                referenced,
	                                deletedOb)) {

	                            modelObject.eSet(
	                                modelReference,
	                                null);
	                        }
	                    }
	                }
	            }
	        }
	    }


	    /*
	     * =========================================================
	     * 6. Removal through an explicitly selected containment
	     *    reference.
	     * =========================================================
	     */
	    else if (container != null
	            && reference != null) {

	        Object referenceValue =
	            container.eGet(
	                reference);

	        if (referenceValue
	                instanceof List<?>) {

	            @SuppressWarnings("unchecked")
	            List<EObject> objects =
	                (List<EObject>) referenceValue;

	            /*
	             * Do not modify the list from inside an enhanced
	             * for-loop.
	             */
	            for (int i =
	                    objects.size() - 1;
	                    i >= 0;
	                    i--) {

	                EObject contained =
	                    objects.get(i);

	                for (EObject deletedOb :
	                        deletedObj) {

	                    if (contained != null
	                            && EcoreUtil.equals(
	                                contained,
	                                deletedOb)) {

	                        objects.remove(i);
	                        break;
	                    }
	                }
	            }
	        }
	        else if (referenceValue
	                instanceof EObject) {

	            EObject contained =
	                (EObject) referenceValue;

	            for (EObject deletedOb :
	                    deletedObj) {

	                if (EcoreUtil.equals(
	                        contained,
	                        deletedOb)) {

	                    ModelManager.unsetReference(
	                        reference.getName(),
	                        container);

	                    break;
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
