package wodel.utils.commands;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SelectObjectMutator selects an object
 *  
 */

public class SelectObjectMutator extends Mutator {

	/**
	 * Object that will be selected
	 */
	private ObSelectionStrategy objectSelection;
	/**
	 * Reference we are going to select the object in
	 */
	private ObSelectionStrategy referenceSelection;
	/**
	 * Object that contains the selected object
	 */
	private ObSelectionStrategy containerSelection;
	/**
	 * Selected object
	 */
	private EObject result;
	
	private EObject selectedObject;

	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectObjectMutator(Resource model, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, ObSelectionStrategy object){
		super(model, metaModel, "ObjectSelected");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objectSelection = object;
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectObjectMutator(List<Resource> models, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, ObSelectionStrategy object){
		super(models, metaModel, "ObjectSelected");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objectSelection = object;
	}

	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectObjectMutator(Resource model, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, EObject obj){
		super(model, metaModel, "ObjectSelected");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.selectedObject = obj;
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectObjectMutator(List<Resource> models, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, EObject obj){
		super(models, metaModel, "ObjectSelected");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.selectedObject = obj;
	}

	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNotContainedException {		

		if (objectSelection == null && selectedObject == null) {
			return null;
		}
		EObject object = null;
		if (objectSelection != null) {
			object = objectSelection.getObject();
		}
		if (selectedObject != null) {
			object = selectedObject;
		}
		//We select the container of the new Object
		EObject container = null;
		if (containerSelection != null) {
			container = containerSelection.getObject();
		}
		if (container != null) {
			//We select the container of the new Object
			EReference reference = null;
			if (referenceSelection != null) {
				reference = (EReference) referenceSelection.getObject();
			}
			if (reference != null) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject obj : objects) {
						if (EcoreUtil.getURI(obj).equals(EcoreUtil.getURI(object))) {
							object = obj;
							break;
						}
					}
				}
				else {
					EObject obj = (EObject) container.eGet(reference);
					if (EcoreUtil.getURI(obj).equals(EcoreUtil.getURI(object))) {
						object = obj;
					}
				}
			}
		}
		else {
			List<EObject> containers = null;
			if (containerSelection != null) {
				containers = containerSelection.getObjects();
				
				if (containers != null) {
					//We select the containers of the new Object
					EReference reference = null;
					if (referenceSelection != null) {
						reference = (EReference) referenceSelection.getObject();
					}
					if (reference != null) {
						for (EObject cont : containers) {
							if (cont.eGet(reference) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) cont.eGet(reference);
								for (EObject obj : objects) {
									if (EcoreUtil.getURI(obj).equals(EcoreUtil.getURI(object))) {
										object = obj;
										break;
									}
								}
								if (object != null) {
									break;
								}
							}
							else {
								EObject obj = (EObject) cont.eGet(reference);
								if (EcoreUtil.getURI(obj).equals(EcoreUtil.getURI(object))) {
									object = obj;
									break;
								}
							}
						}
					}
				}
			}
		}
		
		if(object==null){
			result = null;
			return null;
		}

		//We get the new Object
		if(((EClass) object.eClass()).isAbstract()==true){
			throw new AbstractCreationException("The object '"+((EClass)object.eClass()).getName()+"' is abstract and cannot be instantiated.");
		}
		
		this.result = object;
		return this.result;
	}

	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	//END GETTERS AND SETTERS
}
