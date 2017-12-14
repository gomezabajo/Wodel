package commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.strategies.AttributeConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo - Clone object mutation.
 * 
 */

public class CloneObjectMutator extends Mutator {
	/**
	 * Reference we are going to add the object in
	 */
	private ObSelectionStrategy referenceSelection;
	/**
	 * Object that contains the new object
	 */
	private ObSelectionStrategy containerSelection;
	/**
	 * Configuration of the attributes of the new object
	 */
	private HashMap<String, AttributeConfigurationStrategy> attributeConfig;
	/**
	 * Configuration of the references of the new object
	 */
	private HashMap<String, ObSelectionStrategy> referenceConfig;
	/**
	 * Object to clone
	 */
	private EObject object;
	/**
	 * Contents flag
	 */
	private boolean contents;
	/**
	 * Created object
	 */
	private EObject result;
	/**
	 * If the reference points to an abstract class, we need to specify the name if the new class
	 */
	private String objName = null;

	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public CloneObjectMutator(Resource model, List<EPackage> metaModel, EObject object, boolean contents,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig){
		super(model, metaModel, "ObjectCreated");
		this.object = object;
		this.contents = contents;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * @param inheritedName
	 * Constructor that specifies the class name
	 */
	public CloneObjectMutator(Resource model, List<EPackage> metaModel, EObject object, boolean contents, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig, String objName){
		super(model, metaModel, "ObjectCreated");
		this.object = object;
		this.contents = contents;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
		this.objName = objName;
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * @param inheritedName
	 * Constructor that specifies the class name
	 */
	public CloneObjectMutator(Resource model, List<EPackage> metaModel, EObject object, boolean contents, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig, HashMap<String, ObSelectionStrategy> referenceConfig, String objName){
		super(model, metaModel, "ObjectCreated");
		this.object = object;
		this.contents = contents;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		this.objName = objName;
	}
	
	@Override
	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNotContainedException {		

		//We select the container of the new Object
		EObject container = containerSelection.getObject();
		//We select the container of the new Object
		EReference reference = (EReference) referenceSelection.getObject();
		
		if(container==null){
			result = null;
			return null;
		}
		
		EObject obj = object;
		
		if(obj==null){
			result = null;
			return null;
		}
		
		//If there is not a selected reference we choose a random one
		if(reference == null && objName != null){
			ArrayList<EReference> refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
			Collections.shuffle(refs);
			for (EReference ref : refs) {
				if (ref.getEType().getName().equals(objName)) {
					reference = ref;
					break;
				}
			}
			if (reference == null) {
				reference = refs.get(ModelManager.getRandomIndex(refs));
			}
		}

		
		//We create the object
		EObject newObj = EcoreUtil.copy(obj);
		if (contents == false) {
			for (EReference ref : newObj.eClass().getEReferences()) {
				if (ref.isContainment() == true) {
					ModelManager.unsetReference(ref.getName(), newObj);
				}
			}
		}

		if(!reference.getEType().getName().equals(newObj.eClass().getName())){
			/*for (EClass c : newObj.eClass().getEAllSuperTypes()){
				if(reference.getEType().getName().equals(c.getName())){
					sup=true;
				}
			}*/
			if (! newObj.eClass().getEAllSuperTypes().contains(reference.getEType())) {			
				result = null;
				throw new ObjectNotContainedException("The object "+newObj.eClass().getName()+ " is not contained in "+ container.eClass().getName());
			}
		}
		
		//Attributes configuration
		Iterator<Entry<String, AttributeConfigurationStrategy>> att = this.attributeConfig.entrySet().iterator();
		while (att.hasNext()) {
			Map.Entry<String, AttributeConfigurationStrategy> e = att.next();			
			ModelManager.setAttribute(e.getKey(), newObj, e.getValue());
		}
		
		//Reference configuration
		Iterator<Entry<String, ObSelectionStrategy>> ref = this.referenceConfig.entrySet().iterator();
		while (ref.hasNext()) {
			Map.Entry<String, ObSelectionStrategy> e = ref.next();
			if (!obj.eClass().isInstance(container.eGet(reference)) && !(container.eGet(reference) instanceof List<?>)) {
				ModelManager.setReference(e.getKey(), newObj, EcoreUtil.copy(e.getValue().getObject()));
			}
			else {
				ModelManager.setReference(e.getKey(), newObj, e.getValue());
			}
		}
		
		//Multivalued
		if(reference.getUpperBound() < 0 || reference.getUpperBound() > 1){
			List<EObject> o = null;
			try{
				o = (List<EObject>) container.eGet(reference, true);
			} catch(Exception e){
				result = null;
				throw new ReferenceNonExistingException("No reference "+reference.getName()+ " found in "+ container.eClass().getName());
			}
			o.add(newObj);
			this.result = newObj;
		}
		//Monovalued
		else{
			EObject o = null;
			try{
				o = (EObject) container.eGet(reference, true);
			} catch(Exception e){
				result=null;
				throw new ReferenceNonExistingException("No reference "+reference.getName()+ " found in "+ container.eClass().getName());
			}
			container.eSet(reference, newObj);
			this.result = newObj;
		}
		
		return newObj;
	}
	
	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	//END GETTERS AND SETTERS
	
}
