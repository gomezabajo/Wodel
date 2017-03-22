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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.SpecificObjectSelection;
import commands.strategies.AttributeConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Victor Lopez Rivero
 * CreateObjectMutator creates new objects over the diagram. 
 */
public class CreateObjectMutator extends Mutator {	
	
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
	 * Created object
	 */
	private EObject result;
	/**
	 * If the reference points to an abstract class, we need to specify the name if the new class
	 */
	private String objName = null;
	
	private String refType = null;
	

	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public CreateObjectMutator(Resource model, ArrayList<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig){
		super(model, metaModel, "ObjectCreated");
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
	public CreateObjectMutator(Resource model, ArrayList<EPackage> metaModel, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig, String objName){
		super(model, metaModel, "ObjectCreated");
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
	public CreateObjectMutator(Resource model, ArrayList<EPackage> metaModel, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig, HashMap<String, ObSelectionStrategy> referenceConfig, String objName){
		super(model, metaModel, "ObjectCreated");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
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
	public CreateObjectMutator(Resource model, ArrayList<EPackage> metaModel, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, HashMap<String, AttributeConfigurationStrategy> attributeConfig, HashMap<String, ObSelectionStrategy> referenceConfig, String objName, String refType){
		super(model, metaModel, "ObjectCreated");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		this.objName = objName;
		this.refType = refType;
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
		
		EObject obj;
		
		if(objName!=null){
			//We get the new Object
			obj = ModelManager.getObjectOfType(objName, this.getMetaModel());
		}
		
		else{
			//We get the new Object
			obj = ModelManager.getObjectOfType(reference.getEType().getName(), this.getMetaModel());
			if(((EClass) obj).isAbstract()==true){
				throw new AbstractCreationException("The object '"+((EClass)obj).getName()+"' is abstract and cannot be instantiated.");
			}
		}
		
		
		if(obj==null){
			result = null;
			return null;
		}
		
		//If there is not a selected reference we choose a random one
		if(reference == null && objName != null){
			ArrayList<EReference> refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
			reference = refs.get(ModelManager.getRandomIndex(refs));
		}

		
		//We create the object
		EObject newObj = null;
		
		newObj = EcoreUtil.create((EClass) obj);
		
		boolean sup = false;
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
		Iterator it = this.attributeConfig.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, AttributeConfigurationStrategy> e = (Map.Entry<String, AttributeConfigurationStrategy>)it.next();			
			ModelManager.setAttribute(e.getKey(), newObj, e.getValue());
		}
			
		//Reference configuration
		it = this.referenceConfig.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, ObSelectionStrategy> e = (Map.Entry<String, ObSelectionStrategy>)it.next();
			if (!obj.eClass().isInstance(container.eGet(reference)) && !(container.eGet(reference) instanceof List<?>)) {
				if (e.getValue().getObject() != null) {
					ModelManager.setReference(e.getKey(), newObj, EcoreUtil.copy(e.getValue().getObject()));
				}
				if (e.getValue().getObjects() != null) {
					for (EObject o : e.getValue().getObjects()) {
						ModelManager.setReference(e.getKey(), newObj, EcoreUtil.copy(o));
					}
				}
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
		//	Monovalued
		else{
			EObject o = null;
			try{
				o = (EObject) container.eGet(reference, true);
			} catch(Exception e){
				result=null;
				throw new ReferenceNonExistingException("No reference "+reference.getName()+ " found in "+ container.eClass().getName());
			}
			if (!obj.eClass().isInstance(container.eGet(reference)) && !(container.eGet(reference) instanceof List<?>)) {
				container.eSet(reference, newObj);
			}
			else {
				container.eSet(reference, obj);
			}
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

