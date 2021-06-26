package commands;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.strategies.AttributeConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;
import manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RetypeObjectMutator retypes an object to a different
 * compatible type
 *  
 */

public class RetypeObjectMutator extends Mutator {

	/**
	 * Reference we are going to add the object in
	 */
	private ObSelectionStrategy referenceSelection;
	/**
	 * Object that contains the new object
	 */
	private ObSelectionStrategy containerSelection;

	/**
	 * Object to retype
	 */
	private EObject object;

	/**
	 * Created object
	 */
	private EObject result;
	
	/**
	 * Target class name of the retype
	 */
	private String objName = null;
	
	/**
	 * Target class name of the retype
	 */
	private List<String> objNames = null;

	/**
	 * Configuration of the attributes of the new object
	 */
	private Map<String, AttributeConfigurationStrategy> attributeConfig;
	/**
	 * Configuration of the references of the new object
	 */
	private Map<String, ObSelectionStrategy> referenceConfig;

	/**
	 * Removed object
	 */
	private EObject removed;
	
	/**
	 * Identification
	 */
	private String identification;
	
	/**
	 * URI
	 */
	private URI uri;
	
	/**
	 * Type of the removed object 
	 */
	private EClass eType;
	
	/**
	 * Type of the created object 
	 */
	private EClass newEType;
	
	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
		// TODO Auto-generated constructor stub
	}
	
	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, String objName) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objName = objName;
		this.identification = "";
		// TODO Auto-generated constructor stub
	}
	
	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
		this.attributeConfig = attributeConfig;
		// TODO Auto-generated constructor stub
	}
	
	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, String objName) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objName = objName;
		this.identification = "";
		this.attributeConfig = attributeConfig;
		// TODO Auto-generated constructor stub
	}

	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, Map<String, ObSelectionStrategy> referenceConfig) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.identification = "";
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		// TODO Auto-generated constructor stub
	}
	
	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, Map<String, ObSelectionStrategy> referenceConfig,  String objName) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objName = objName;
		this.identification = "";
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		// TODO Auto-generated constructor stub
	}

	public RetypeObjectMutator(Resource model, List<EPackage> metaModel, EObject object, 
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, Map<String, ObSelectionStrategy> referenceConfig, List<String> objNames) {
		super(model, metaModel, "RetypeObjectMutator");
		this.object = object;
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.objNames = objNames;
		this.identification = "";
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		// TODO Auto-generated constructor stub
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
		if (objNames != null) {
			objNames.remove(obj.eClass().getName());
			int index = ModelManager.getRandomIndex(objNames);
			if (index < objNames.size()) {
				objName = objNames.get(index);
			}
		}
		newEType = ModelManager.getEClassByName(this.getMetaModel(), objName);
		//If there is not a selected reference we choose the reference of the object to be retyped
		if(reference == null && objName != null){
			List<EReference> refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
			EReference initialRef = ModelManager.getContainingReference(container.eClass(), object.eClass());
			//Collections.shuffle(refs);
			for (EReference ref : refs) {
				if (ref.getEReferenceType().isSuperTypeOf(newEType) && EcoreUtil.getURI(ref).equals(EcoreUtil.getURI(initialRef))) {
					reference = ref;
					break;
				}
			}
			if (reference == null) {
				if (refs.size() > 0) {
					reference = refs.get(ModelManager.getRandomIndex(refs));
				}
				else {
					// selects a random compatible container
					List<EObject> containers = ModelManager.getParentObjects(this.getMetaModel(), this.getModel(), objName);
					Collections.shuffle(containers);
					if (containers.size() > 0) {
						container = containers.get(ModelManager.getRandomIndex(containers));
						refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
						Collections.shuffle(refs);
						for (EReference ref : refs) {
							if (ref.getEReferenceType().isSuperTypeOf(newEType)) {
								reference = ref;
								break;
							}
						}
						if (refs.size() > 0) {
							reference = refs.get(ModelManager.getRandomIndex(refs));
						}
					}
				}
			}
		}

		//We create the object
		EObject newObj = EcoreUtil.create(newEType);
		eType = obj.eClass();

		if(!EcoreUtil.getURI(reference.getEReferenceType()).equals(EcoreUtil.getURI(newObj.eClass()))) {
			
			/*for (EClass c : newObj.eClass().getEAllSuperTypes()){
				if(reference.getEType().getName().equals(c.getName())){
					sup=true;
				}
			}*/
			if (! newObj.eClass().getEAllSuperTypes().contains(reference.getEReferenceType())) {			
				result = null;
				throw new ObjectNotContainedException("The object "+newObj.eClass().getName()+ " is not contained in "+ container.eClass().getName());
			}
		}
		

		// copies compatible features
		for (EStructuralFeature sf1 : obj.eClass().getEAllStructuralFeatures()) {
			boolean sameFeature = false;
			for (EStructuralFeature sf2 : newObj.eClass().getEAllStructuralFeatures()) {
				if (EcoreUtil.getURI(sf1.getEType()).equals(EcoreUtil.getURI(sf2.getEType()))) {
					if (sf1.getName().equals(sf2.getName())) {
						sameFeature = true;
						if (sf1.getUpperBound() == 1) {
							if (sf2.getUpperBound() == -1 || sf2.getUpperBound() > 1) {
								List<EObject> newoo = (List<EObject>) newObj.eGet(sf2);
								newoo.add((EObject) obj.eGet(sf1)); 
							}
							else {
								newObj.eSet(sf2, obj.eGet(sf1));
							}
						}
						if (sf1.getUpperBound() == -1 || sf1.getUpperBound() > 1) {
							List<EObject> oo = (List<EObject>) obj.eGet(sf1);
							if (sf2.getUpperBound() == -1 || sf2.getUpperBound() > 1) {
								List<EObject> newoo = (List<EObject>) newObj.eGet(sf2);
								if (sf1.getUpperBound() > 1) {
									newoo = newoo.subList(0, sf1.getUpperBound());
								}
								oo.addAll(newoo);
							}
							else if (oo.size() > 0) {
								newObj.eSet(sf2, oo.get(0));
							}
						}
					}
				}
			}
			if (sameFeature == false) {
				for (EStructuralFeature sf2 : newObj.eClass().getEAllStructuralFeatures()) {
					if (EcoreUtil.getURI(sf1.getEType()).equals(EcoreUtil.getURI(sf2.getEType()))) {
						if (sf1.getUpperBound() == 1) {
							if (sf2.getUpperBound() == -1 || sf2.getUpperBound() > 1) {
								List<EObject> newoo = (List<EObject>) newObj.eGet(sf2);
								newoo.add((EObject) obj.eGet(sf1)); 
							}
							else {
								newObj.eSet(sf2, obj.eGet(sf1));
							}
						}
						if (sf1.getUpperBound() == -1 || sf1.getUpperBound() > 1) {
							List<EObject> oo = (List<EObject>) obj.eGet(sf1);
							if (sf2.getUpperBound() == -1 || sf2.getUpperBound() > 1) {
								List<EObject> newoo = (List<EObject>) newObj.eGet(sf2);
								if (sf1.getUpperBound() > 1) {
									newoo = newoo.subList(0, sf1.getUpperBound());
								}
								oo.addAll(newoo);
							}
							else if (oo.size() > 0) {
								newObj.eSet(sf2, oo.get(0));
							}
						}
					}
				}
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
		
		removed = EcoreUtil.copy(obj);
		identification = EcoreUtil.getIdentification(obj);
		uri = EcoreUtil.getURI(obj);
		
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

		// updates all references to previous object to the new object
		for (EObject o : ModelManager.getAllObjects(this.getModel())) {
			for (EReference r : o.eClass().getEAllReferences()) {
				if (!r.isContainment() && r.getEReferenceType().isSuperTypeOf(newObj.eClass())) {
					if (o.eGet(r) instanceof List<?> && ((List<EObject>) o.eGet(r)).contains(obj)) {
						List<EObject> objects = (List<EObject>) o.eGet(r);
						objects.remove(obj);
						objects.add(newObj);
					}
					else if (o.eGet(r) instanceof EObject && EcoreUtil.equals((EObject) o.eGet(r), obj)) {
						o.eUnset(r);
						o.eSet(r, newObj);
					}
				}
				else if(r.isContainment() && r.getEReferenceType().isSuperTypeOf(newObj.eClass())) {
					if (o.eGet(r) instanceof List<?> && ((List<EObject>) o.eGet(r)).contains(obj)) {
						List<EObject> objects = (List<EObject>) o.eGet(r);
						objects.remove(obj);
						objects.add(newObj);
					}
					else if (o.eGet(r) instanceof EObject && EcoreUtil.equals((EObject) o.eGet(r), obj)) {
						o.eUnset(r);
						o.eSet(r, newObj);
					}
				}
			}
		}
		
		// removes the retyped object
		if (reference != null) {
			if (container.eGet(reference) instanceof List<?>) {
				List<EObject> objects = (List<EObject>) container.eGet(reference);
				for (EObject o : objects) {
					if (ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(o)).equals(ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(obj)))) {
						objects.remove(o);
						break;
					}
				}
			}
			else {
				EObject o = (EObject) container.eGet(reference);
				if (o != null && EcoreUtil.getURI(obj).equals(EcoreUtil.getURI(o))) {
					ModelManager.unsetReference(reference.getName(), container);
				}
			}
		}

		return newObj;
	}

	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	
	public EObject getRemovedObject() {
		return removed;
	}
	//END GETTERS AND SETTERS
	
	public EObject getObjectByID() {
		return ModelManager.getObjectByID(this.getModel(), identification);
	}

	public EObject getObjectByURI() {
		return ModelManager.getObjectByURI(this.getModel(), uri);
	}
	
	public EClass getEType() {
		return eType;
	}

	public EClass getNewEType() {
		return newEType;
	}
}
