package wodel.utils.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	private Map<String, ObSelectionStrategy> referenceConfig = Collections.emptyMap();
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
	
	private static String stableKey(
	        EObject object) {

	    if (object == null) {
	        return "<null>";
	    }

	    String nsURI =
	        object.eClass()
	            .getEPackage()
	            .getNsURI();

	    String type =
	        object.eClass()
	            .getName();

	    Resource resource =
	        object.eResource();

	    String fragment =
	        resource != null
	        ? resource.getURIFragment(
	            object)
	        : "<detached>";

	    return nsURI
	        + "#"
	        + type
	        + "#"
	        + fragment;
	}
	
	private static String referenceKey(
	        EReference reference) {

	    if (reference == null) {
	        return "<null>";
	    }

	    EClass owner =
	        reference.getEContainingClass();

	    EPackage pack =
	        owner != null
	        ? owner.getEPackage()
	        : null;

	    return
	        (pack != null
	            ? pack.getNsURI()
	            : "")
	        + "#"
	        + (owner != null
	            ? owner.getName()
	            : "")
	        + "."
	        + reference.getName()
	        + "[containment="
	        + reference.isContainment()
	        + ", many="
	        + reference.isMany()
	        + ", lower="
	        + reference.getLowerBound()
	        + ", upper="
	        + reference.getUpperBound()
	        + "]";
	}
	
	private static String stableReferenceKey(
	        EReference reference) {

	    if (reference == null) {
	        return "";
	    }

	    EClass owner =
	        reference.getEContainingClass();

	    EPackage ePackage =
	        owner != null
	            ? owner.getEPackage()
	            : null;

	    String nsURI =
	        ePackage != null
	            ? String.valueOf(
	                ePackage.getNsURI())
	            : "";

	    String ownerName =
	        owner != null
	            ? String.valueOf(
	                owner.getName())
	            : "";

	    return nsURI
	        + "|"
	        + ownerName
	        + "|"
	        + reference.getName();
	}
	
	private EReference selectApplicableContainmentReference(
	        EObject container,
	        EClass createdType) {

	    if (container == null || createdType == null) {
	        return null;
	    }

	    List<EReference> candidates =
	        new ArrayList<>();

	    for (EReference reference :
	            container.eClass().getEAllContainments()) {

	        EClass expectedType =
	            reference.getEReferenceType();

	        /*
	         * The new object's type must be compatible with
	         * the reference type.
	         */
	        if (expectedType == null
	                || !expectedType.isSuperTypeOf(
	                    createdType)) {

	            continue;
	        }

	        /*
	         * Multi-valued containment:
	         * applicable while its upper bound has not
	         * been reached.
	         */
	        if (reference.isMany()) {

	            @SuppressWarnings("unchecked")
	            List<EObject> values =
	                (List<EObject>)
	                    container.eGet(reference);

	            int upper =
	                reference.getUpperBound();

	            if (upper < 0
	                    || values.size() < upper) {

	                candidates.add(reference);
	            }

	            continue;
	        }

	        /*
	         * Single-valued containment:
	         * a create operation may use it only when
	         * the slot is currently empty.
	         */
	        Object current =
	            container.eGet(reference);

	        if (current == null) {
	            candidates.add(reference);
	        }
	    }

	    if (candidates.isEmpty()) {
	        return null;
	    }

	    /*
	     * Never depend on Ecore/collection traversal order
	     * at a seeded random-selection boundary.
	     */
	    candidates.sort(
	        Comparator.comparing(
	            CreateObjectMutator::
	                stableReferenceKey));

	    return candidates.get(
	        ModelManager.getRandomIndex(
	            candidates));
	}
	
	private boolean isSuccessfullyInserted(
	        EObject created,
	        EObject expectedContainer,
	        Resource expectedResource) {

	    if (created == null) {
	        return false;
	    }

	    if (created.eResource()
	            != expectedResource) {

	        return false;
	    }

	    if (expectedContainer != null
	            && created.eContainer()
	                != expectedContainer) {

	        return false;
	    }

	    return true;
	}

	/**
	 * Retrieve a target in the resource that is actually being mutated.
	 * External unresolved proxies (for example, Event.eventlib.dtp) are
	 * valid cross-resource targets and must not be copied or resolved away.
	 */
	private EObject resolveReferenceTarget(EObject selected) {
		if (selected == null) {
			return null;
		}
		if (selected.eIsProxy() || selected.eResource() == getModel()) {
			return selected;
		}
		Resource origin = selected.eResource();
		if (origin == null) {
			return null; // Cannot safely refer to a detached non-proxy.
		}

		// First attempt a URI-fragment mapping from a prior clone.
		String fragment = origin.getURIFragment(selected);
		if (fragment != null) {
			EObject mapped = getModel().getEObject(fragment);
			if (sameIdentityInformation(selected, mapped)) {
				return mapped;
			}
		}

		// Fallback for models whose containment fragments have changed.
		EObject mapped = ModelManager.getObjectByURIEnding(
				getModel(), EcoreUtil.getURI(selected));
		if (sameIdentityInformation(selected, mapped)) {
			return mapped;
		}

		EStructuralFeature nameFeature =
				selected.eClass().getEStructuralFeature("name");
		if (nameFeature != null && selected.eGet(nameFeature) != null) {
			mapped = ModelManager.getObjectByName(getModel(), selected);
			if (sameIdentityInformation(selected, mapped)) {
				return mapped;
			}
		}
		return null;
	}

	private static boolean sameIdentityInformation(EObject selected,
			EObject mapped) {
		if (selected == null || mapped == null) {
			return false;
		}
		if (!selected.eClass().getName().equals(mapped.eClass().getName())) {
			return false;
		}
		EStructuralFeature sf = selected.eClass().getEStructuralFeature("name");
		EStructuralFeature mf = mapped.eClass().getEStructuralFeature("name");
		if (sf != null && mf != null) {
			Object sn = selected.eGet(sf);
			Object mn = mapped.eGet(mf);
			if (sn != null && !sn.equals(mn)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Assign references explicitly, especially non-containment links such
	 * as With.variables -> VarDeclaration. Never clone their targets.
	 */
	private void applyReferenceConfigurations(EObject newObj)
			throws ReferenceNonExistingException {
		if (referenceConfig == null || referenceConfig.isEmpty()) {
			return;
		}
		for (Entry<String, ObSelectionStrategy> entry : referenceConfig.entrySet()) {
			String name = entry.getKey();
			EStructuralFeature feature = newObj.eClass()
					.getEStructuralFeature(name);
			if (!(feature instanceof EReference)) {
				throw new ReferenceNonExistingException(
						"No EReference '" + name + "' on "
						+ newObj.eClass().getName());
			}
			EReference targetRef = (EReference) feature;
			ObSelectionStrategy selection = entry.getValue();
			if (selection == null) {
				throw new ReferenceNonExistingException(
						"Null selection for " + newObj.eClass().getName()
						+ "." + name);
			}
			List<EObject> selectedObjects = new ArrayList<>();
			EObject one = selection.getObject();
			if (one != null) {
				selectedObjects.add(one);
			} else if (selection.getObjects() != null) {
				for (EObject candidate : selection.getObjects()) {
					if (candidate != null) {
						selectedObjects.add(candidate);
					}
				}
			}
			if (selectedObjects.isEmpty()) {
				throw new ReferenceNonExistingException(
						"Empty selection for " + newObj.eClass().getName()
						+ "." + name);
			}
			if (!targetRef.isMany() && selectedObjects.size() != 1) {
				throw new ReferenceNonExistingException(
						"Expected one object for "
						+ newObj.eClass().getName() + "." + name);
			}

			for (EObject selected : selectedObjects) {
				EObject target = resolveReferenceTarget(selected);
				if (target == null || !targetRef.getEReferenceType().isInstance(target)) {
					throw new ReferenceNonExistingException(
							"Cannot map selected " + selected.eClass().getName()
							+ " into current mutant for "
							+ newObj.eClass().getName() + "." + name);
				}
				// For containment, copy an already contained target rather
				// than moving it out of another parent. Never copy targets
				// of ordinary cross-references such as With.variables.
				if (targetRef.isContainment() && target.eContainer() != null) {
					target = EcoreUtil.copy(target);
				}
				if (targetRef.isMany()) {
					@SuppressWarnings("unchecked")
					List<EObject> list = (List<EObject>) newObj.eGet(targetRef);
					if (!list.contains(target)) {
						list.add(target);
					}
				} else {
					newObj.eSet(targetRef, target);
				}
				System.out.println("[Wodel CREATE] "
						+ newObj.eClass().getName() + "." + name
						+ " -> " + target.eClass().getName()
						+ " (proxy=" + target.eIsProxy() + ")");
			}
		}
	}

	/** Reject incomplete With objects at creation time, not at export. */
	private static void verifyRequiredFordiacReferences(EObject newObj)
			throws ReferenceNonExistingException {
		if (!"With".equals(newObj.eClass().getName())) {
			return;
		}
		EStructuralFeature variables = newObj.eClass()
				.getEStructuralFeature("variables");
		if (variables == null || newObj.eGet(variables, false) == null) {
			throw new ReferenceNonExistingException(
					"Cannot create an IEC 61499 With without "
					+ "a VarDeclaration target (With.variables)");
		}
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNotContainedException {		

		//We select the container of the new Object
		//EObject container = containerSelection.getObject();
		//We select the container of the new Object
		//EReference reference = (EReference) referenceSelection.getObject();
		
		EObject container =
			    containerSelection != null
			        ? containerSelection.getObject()
			        : null;

			EReference reference =
			    referenceSelection != null
			        ? (EReference)
			            referenceSelection.getObject()
			        : null;


		EObject obj = null;
		
		if(objName!=null){
			//We get the new Object
			obj = ModelManager.getObjectOfType(objName, this.getMetaModel());
		}
		
		else if (reference != null) {
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
		
			/*
			 * A container was requested, but no explicit reference
			 * was given: find a currently usable containment slot.
			 */
		if (container != null
		        && reference == null) {

		    reference =
		        selectApplicableContainmentReference(
		            container,
		            (EClass) obj);

		    if (reference == null) {

		        result = null;
		        return null;
		    }
		}
		
		if(container==null){
			result = null;
			return null;
		}
		
		/*System.out.println(
			    "[CREATE BEFORE]"
			    + " type=" + objName
			    + " container=" + stableKey(container)
			    + " reference=" + referenceKey(reference));
		*/
		
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

		System.out.println("[Wodel CREATE] type=" + newObj.eClass().getName()
				+ " configuredReferences="
				+ (referenceConfig == null ? "<null>" : referenceConfig.keySet()));

		// Configure references using actual selected EObjects, not the
		// selection strategy object. This also works when the created
		// EObject is still detached (before containment insertion).
		applyReferenceConfigurations(newObj);
		verifyRequiredFordiacReferences(newObj);

//		//If there is not a selected reference we choose a random one
//		if(reference == null && objName != null){
//			List<EReference> refs = ModelManager.getContainingReferences(this.getMetaModel(), container, objName);
//			EClass objType = ModelManager.getEClassByName(this.getMetaModel(), objName);
//			Collections.shuffle(refs);
//			for (EReference ref : refs) {
//				EClass type = (EClass) ref.getEType();
//				if (type.isSuperTypeOf(objType)) {
//					if (container.eGet(ref) == null) {
//						reference = ref;
//						break;
//					}
//					if (container.eGet(ref) instanceof List<?>) {
//						List<EObject> objects = (List<EObject>) container.eGet(ref);
//						if (ref.getUpperBound() == -1 || ref.getUpperBound() > objects.size()) {
//							reference = ref;
//							break;
//						}
//					}
//				}
//			}
//			if (reference == null) {
//				//stores the new object in the root object
//				List<EObject> o = (List<EObject>) this.getModel().getContents();
//				o.add(newObj);		
//				this.result = newObj;
//				System.out.println(
//					    "[CREATE AFTER]"
//					    + " created=" + stableKey(newObj)
//					    + " eContainer="
//					        + stableKey(
//					        		newObj.eContainer())
//					    + " containmentFeature="
//					        + (newObj.eContainmentFeature()
//					            != null
//					            ? newObj.eContainmentFeature()
//					                .getName()
//					            : "<null>")
//					    + " eResource="
//					        + (newObj.eResource()
//					            != null
//					            ? newObj.eResource()
//					                .getURI()
//					            : "<null>"));
//
//				if (!isSuccessfullyInserted(
//				        newObj,
//				        container,
//				        getModel())) {
//
//				    /*
//				     * Do not expose a detached object as the result
//				     * of a successful creation mutation.
//				     */
//				    result = null;
//				    return null;
//				}
//
//				result = newObj;
//				return newObj;
//				//reference = refs.get(ModelManager.getRandomIndex(refs));
//			}
//		}
		
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
		/*
		System.out.println(
			    "[CREATE AFTER]"
			    + " created=" + stableKey(newObj)
			    + " eContainer="
			        + stableKey(
			        		newObj.eContainer())
			    + " containmentFeature="
			        + (newObj.eContainmentFeature()
			            != null
			            ? newObj.eContainmentFeature()
			                .getName()
			            : "<null>")
			    + " eResource="
			        + (newObj.eResource()
			            != null
			            ? newObj.eResource()
			                .getURI()
			            : "<null>"));
		*/
		//complete(this.getMetaModel(), this.getModel());
		if (!isSuccessfullyInserted(
		        newObj,
		        container,
		        getModel())) {

		    /*
		     * Do not expose a detached object as the result
		     * of a successful creation mutation.
		     */
		    result = null;
		    return null;
		}

		result = newObj;
		return newObj;
	}
	
	//GETTERS AND SETTERS
	public EObject getObject() {
		return result;
	}
	//END GETTERS AND SETTERS
	
	
}

