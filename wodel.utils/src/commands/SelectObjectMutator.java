package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.strategies.AttributeConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

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
	public SelectObjectMutator(Resource model, ArrayList<EPackage> metaModel,
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
	public SelectObjectMutator(Resource model, ArrayList<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, EObject obj){
		super(model, metaModel, "ObjectSelected");
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
						System.out.println(ModelManager.getStringAttribute("name", obj));
						System.out.println(ModelManager.getStringAttribute("name", object));
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
