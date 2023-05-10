package wodel.utils.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.EMFUtils;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.commands.selection.strategies.RandomTypeSelection;
import wodel.utils.commands.strategies.AttributeConfigurationStrategy;
import wodel.utils.commands.strategies.RandomBooleanConfigurationStrategy;
import wodel.utils.commands.strategies.RandomDoubleConfigurationStrategy;
import wodel.utils.commands.strategies.RandomIntegerConfigurationStrategy;
import wodel.utils.commands.strategies.RandomStringConfigurationStrategy;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

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
	private Map<String, AttributeConfigurationStrategy> attributeConfig;
	/**
	 * Configuration of the references of the new object
	 */
	private Map<String, ObSelectionStrategy> referenceConfig;
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
			ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig){
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
			ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, String objName){
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
			ObSelectionStrategy containerSelection, Map<String, AttributeConfigurationStrategy> attributeConfig, Map<String, ObSelectionStrategy> referenceConfig, String objName){
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
		
		//We create the object
		EObject newObj = EMFCopier.clone(obj);
		if (contents == false) {
			for (EReference ref : newObj.eClass().getEReferences()) {
				if (ref.isContainment() == true) {
					ModelManager.unsetReference(ref.getName(), newObj);
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
		Iterator<Entry<String, ObSelectionStrategy>> rf = this.referenceConfig.entrySet().iterator();
		while (rf.hasNext()) {
			Map.Entry<String, ObSelectionStrategy> e = rf.next();
			if (reference != null) {
				if (e.getValue() != null && !obj.eClass().isInstance(container.eGet(reference)) && !(container.eGet(reference) instanceof List<?>)) {
					//EObject eObject = EMFCopier.process(this.getModel(), EcoreUtil.copy(e.getValue().getObject()));
					//ModelManager.setReference(e.getKey(), newObj, eObject);
					EStructuralFeature feature = object.eClass().getEStructuralFeature(e.getKey());
					if (feature instanceof EReference) {
						if (((EReference) feature).getEOpposite() == null) {
							EMFUtils.setReference(object.eClass().getEPackage(), newObj, e.getKey(), EcoreUtil.copy(e.getValue().getObject()));
						}
					}
				}
				else if (e.getValue() != null) {
					//EObject eObject = EMFCopier.process(this.getModel(), e.getValue().getObject());
					//ModelManager.setReference(e.getKey(), newObj, eObject);
					EStructuralFeature feature = object.eClass().getEStructuralFeature(e.getKey());
					if (feature instanceof EReference) {
						if (((EReference) feature).getEOpposite() == null) {
							EMFUtils.setReference(object.eClass().getEPackage(), newObj, e.getKey(), e.getValue().getObject());
						}
					}
				}
			}
			else if (e.getValue() != null) {
				//EObject eObject = EMFCopier.process(this.getModel(), e.getValue().getObject());
				//ModelManager.setReference(e.getKey(), newObj, eObject);
				EStructuralFeature feature = object.eClass().getEStructuralFeature(e.getKey());
				if (feature instanceof EReference) {
					if (((EReference) feature).getEOpposite() == null) {
						EMFUtils.setReference(object.eClass().getEPackage(), newObj, e.getKey(), e.getValue().getObject());
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
		
		if (reference.getEOpposite() == null) {
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
		}
		
		//complete(this.getMetaModel(), this.getModel());
		return this.result;
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
	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	//END GETTERS AND SETTERS
	
}
