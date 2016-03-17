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
	
	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNotContainedException {		

		if (objectSelection == null) {
			return null;
		}
		if (containerSelection == null) {
			return null;
		}
		if (referenceSelection == null) {
			return null;
		}
		EObject object = objectSelection.getObject();
		//We select the container of the new Object
		EObject container = containerSelection.getObject();
		//We select the container of the new Object
		EReference reference = (EReference) referenceSelection.getObject();
		
		if(object==null){
			result = null;
			return null;
		}

		//We get the new Object
		if(((EClass) object.eClass()).isAbstract()==true){
			throw new AbstractCreationException("The object '"+((EClass)object.eClass()).getName()+"' is abstract and cannot be instantiated.");
		}
		if(object==null){
			result = null;
			return null;
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
