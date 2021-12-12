package commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import manager.EMFCopier;
import manager.EMFUtils;
import manager.ModelManager;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.RandomTypeSelection;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.RandomBooleanConfigurationStrategy;
import commands.strategies.RandomDoubleConfigurationStrategy;
import commands.strategies.RandomIntegerConfigurationStrategy;
import commands.strategies.RandomStringConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CreateObjectMutator creates new objects over the diagram. 
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
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
	private Map<String, AttributeConfigurationStrategy> attributeConfig;
	/**
	 * Configuration of the references of the new object
	 */
	private Map<String, ObSelectionStrategy> referenceConfig;
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
	public CreateObjectMutator(Resource model, List<EPackage> metaModel,
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
	public CreateObjectMutator(Resource model, List<EPackage> metaModel, ObSelectionStrategy referenceSelection, 
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
	public CreateObjectMutator(Resource model, List<EPackage> metaModel, ObSelectionStrategy referenceSelection, 
			ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, Map<String, ObSelectionStrategy> referenceConfig, String objName){
		super(model, metaModel, "ObjectCreated");
		this.referenceSelection = referenceSelection;
		this.containerSelection = containerSelection;
		this.attributeConfig = attributeConfig;
		this.referenceConfig = referenceConfig;
		this.objName = objName;
	}
	
	/**
	 * Completes the model with mandatory features
	 * @param packages
	 * @param model
	 * @return
	 */
	private void complete(List<EPackage> packages, Resource model) {
		TreeIterator<EObject> tree = model.getAllContents();
		while (tree.hasNext()) {
			EObject eObject = (EObject) tree.next();
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				int code = ((BasicDiagnostic) diagnostic.getChildren().get(0)).getCode();
				if (code == 0 || code == 1) {
					try {
						// COMPLETES THE CARDINALITIES
						TreeIterator<Object> nested = EcoreUtil.getAllContents(eObject, true);
						List<EObject> processed = new ArrayList<EObject>();
						while (nested.hasNext()) {
							EObject obj = (EObject) nested.next();
							if (processed.contains(obj)) {
								break;
							}
							processed.add(obj);
							for (EAttribute att : obj.eClass().getEAllAttributes()) {
								if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
									try { 
										if (att.getEType().getInstanceClassName().equals(String.class.getCanonicalName())) {
											ModelManager.setAttribute(att.getName(), obj, new RandomStringConfigurationStrategy(4, 5, false));
										}
										if (att.getEType().getInstanceClassName().equals(boolean.class.getCanonicalName())) {
											ModelManager.setAttribute(att.getName(), obj, new RandomBooleanConfigurationStrategy());
										}
										if (att.getEType().getInstanceClassName().equals(double.class.getCanonicalName())) {
											ModelManager.setAttribute(att.getName(), obj, new RandomDoubleConfigurationStrategy(1, 100, false));
										}
										if (att.getEType().getInstanceClassName().equals(int.class.getCanonicalName())) {
											ModelManager.setAttribute(att.getName(), obj, new RandomIntegerConfigurationStrategy(1, 100, false));
										}
									} catch (WrongAttributeTypeException e) {
										e.printStackTrace();
									}
								}
							}
							for (EReference ref : obj.eClass().getEAllReferences()) {
								if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
									try {
										if (ref.isChangeable()) {
											ModelManager.setReference(ref.getName(), obj, new RandomTypeSelection(packages, model, ref.getEReferenceType().getName()));
										}
									} catch (WrongAttributeTypeException e) {
									} catch (ReferenceNonExistingException e) {
									} catch (ClassCastException e) {
									}
								}
							}
						}
					} catch (Exception ex) {
					}
				}
			}
		}
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
		
		//We create the object
		EObject newObj = null;
		//if (this.getMetaModel().get(0).getNsURI().equals("http://www.eclipse.org/emf/2002/Ecore")) {
		//	newObj = EcoreFactory.eINSTANCE.create((EClass) obj);
		//}
		//else {
			newObj = ((EClass) obj).getEPackage().getEFactoryInstance().create((EClass) obj);
			//newObj = EcoreUtil.create((EClass) obj);
		//}

		// Attributes configuration
		Iterator<Entry<String, AttributeConfigurationStrategy>> att = this.attributeConfig.entrySet().iterator();
		while (att.hasNext()) {
			Map.Entry<String, AttributeConfigurationStrategy> e = att.next();
			ModelManager.setAttribute(e.getKey(), newObj, e.getValue());
		}

		// Reference configuration
		Iterator<Entry<String, ObSelectionStrategy>> rf = this.referenceConfig.entrySet().iterator();
		while (rf.hasNext()) {
			Map.Entry<String, ObSelectionStrategy> e = (Map.Entry<String, ObSelectionStrategy>) rf.next();
			if (reference != null) {
				if (!obj.eClass().isInstance(container.eGet(reference))
						&& !(container.eGet(reference) instanceof List<?>)) {
					if (e.getValue().getObject() != null) {
						if (!this.getModel().getContents().contains(e.getValue().getObject())) {
							EObject eObject = ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(e.getValue().getObject()));
							if (eObject == null) {
								eObject = ModelManager.getObjectByName(this.getModel(), e.getValue().getObject());
							}
							if (eObject != null) {
								ModelManager.setReference(e.getKey(), newObj, eObject);
							}
						}
						else {
							EObject eObject = ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(e.getValue().getObject()));
							if (eObject == null) {
								eObject = ModelManager.getObjectByName(this.getModel(), e.getValue().getObject());
							}
							//this.getModel().getContents().remove(e.getValue().getObject());
							ModelManager.setReference(e.getKey(), newObj, eObject);
						}
					}
					if (e.getValue().getObjects() != null) {
						for (EObject o : e.getValue().getObjects()) {
							ModelManager.setReference(e.getKey(), newObj, EMFCopier.copy(o));
						}
					}
				} else {
					if (e.getValue() != null) {
						ModelManager.setReference(e.getKey(), newObj, e.getValue());
					}
				}
			}
			else {
				if (e.getValue().getObject() != null) {
					if (!this.getModel().getContents().contains(e.getValue().getObject())) {
						//EObject eObject = EMFCopier.process(this.getModel(), EMFCopier.copy(e.getValue().getObject()));
						EObject eObject = ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(e.getValue().getObject()));
						if (eObject == null) {
							//eObject = ModelManager.getObjectByPartialID(this.getModel(), EcoreUtil.getIdentification(e.getValue().getObject()));
							eObject = ModelManager.getObjectByName(this.getModel(), e.getValue().getObject());
						}
						if (eObject != null) {
							ModelManager.setReference(e.getKey(), newObj, eObject);
						}
					}
					else {
						EObject eObject = ModelManager.getObjectByURIEnding(this.getModel(), EcoreUtil.getURI(e.getValue().getObject()));
						if (eObject == null) {
							eObject = ModelManager.getObjectByName(this.getModel(), e.getValue().getObject());
						}
//						this.getModel().getContents().remove(e.getValue().getObject());
						ModelManager.setReference(e.getKey(), newObj, eObject);
					}
				}
				if (e.getValue().getObjects() != null) {
					for (EObject o : e.getValue().getObjects()) {
						if (o != null) {
							ModelManager.setReference(e.getKey(), newObj, EMFCopier.copy(o));
						}
					}
				}
				
			}
		}
		
		//If there is not a selected reference we choose a random one
		if(reference == null && objName != null){
			List<EReference> refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
			EClass objType = ModelManager.getEClassByName(this.getMetaModel(), objName);
			Collections.shuffle(refs);
			for (EReference ref : refs) {
				EClass type = (EClass) ref.getEType();
				if (type.isSuperTypeOf(objType)) {
					if (container.eGet(ref) == null) {
						reference = ref;
						break;
					}
					if (container.eGet(ref) instanceof List<?>) {
						List<EObject> objects = (List<EObject>) container.eGet(ref);
						if (ref.getUpperBound() == -1 || ref.getUpperBound() > objects.size()) {
							reference = ref;
							break;
						}
					}
				}
			}
			if (reference == null) {
				//stores the new object in the root object
				List<EObject> o = (List<EObject>) this.getModel().getContents();
				o.add(newObj);		
				this.result = newObj;
				return newObj;
				//reference = refs.get(ModelManager.getRandomIndex(refs));
			}
		}
		
		//boolean sup = false;
		if(!reference.getEType().getName().equals(newObj.eClass().getName())){
			
			/*for (EClass c : newObj.eClass().getEAllSuperTypes()){
				if(reference.getEType().getName().equals(c.getName())){
					sup=true;
				}
			}*/
			boolean found = false;
			for (EClass superType : newObj.eClass().getEAllSuperTypes()) {
				if (superType.getName().equals(reference.getEType().getName())) {
					found = true;
					break;
				}
			}
			if (found == false) {			
				result = null;
				throw new ObjectNotContainedException("The object "+newObj.eClass().getName()+ " is not contained in "+ container.eClass().getName());
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
			try {
				EMFUtils.setReference(container.eClass().getEPackage(), container, reference.getName(), newObj);
			} catch (Exception ex) {
				return null;
			}
			this.result = newObj;
		}
		//complete(this.getMetaModel(), this.getModel());
		return newObj;
	}
	
	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	//END GETTERS AND SETTERS
	
	
}

