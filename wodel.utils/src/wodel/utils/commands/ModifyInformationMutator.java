package wodel.utils.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.commands.strategies.AttributeConfigurationStrategy;
import wodel.utils.commands.strategies.CopyReferenceConfigurationStrategy;
import wodel.utils.commands.strategies.NullReferenceConfigurationStrategy;
import wodel.utils.commands.strategies.RandomReferenceConfigurationStrategy;
import wodel.utils.commands.strategies.ReferenceConfigurationStrategy;
import wodel.utils.commands.strategies.SpecificReferenceConfigurationStrategy;
import wodel.utils.commands.strategies.SwapAttributeConfigurationStrategy;
import wodel.utils.commands.strategies.SwapReferenceConfigurationStrategy;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ModifyInformationMutator Modify the attributes of
 * the objects
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ModifyInformationMutator extends Mutator {

	/**
	 * Object that will be modified
	 */
	private ObSelectionStrategy object;
	/**
	 * New configuration settings
	 */
	private Map<String, List<AttributeConfigurationStrategy>> newAttributeConfig;
	/**
	 * New configuration settings
	 */
	private Map<String, List<ReferenceConfigurationStrategy>> newReferenceConfig;
	/**
	 * Modified object
	 */
	private EObject result;

	private EObject eobjother;
	private EObject eobjatt;
	
	private List<EObject> objectcopies;
	
	private EObject eobjref;
	
	private List<EObject> objsAttRef;
	private Map<String, List<AttributeConfigurationStrategy>> attsRef;
	
	private EObject objRefAttOld;
	private EObject objRefAttNew;
	
	private String srcRefType;
	
	private int index = 0;
	
	private Map<String, Object> previous;
	private Map<String, Object> next;

	private Map<String, Object> oldAttValue;
	private Map<String, Object> newAttValue;

	private Map<String, Object> oldRefValue;
	private Map<String, String> oldRefNameValue;
	private Map<String, Object> newRefValue;
	private Map<String, String> newRefNameValue;

	/**
	 * @param model
	 * @param metaModel
	 * @param object
	 * @param newAttributeConfig
	 *            Normal constructor
	 */
	public ModifyInformationMutator(Resource model,
			List<EPackage> metaModel, ObSelectionStrategy object,
			Map<String, List<AttributeConfigurationStrategy>> newAttributeConfig,
			Map<String, List<ReferenceConfigurationStrategy>> newReferenceConfig) {
		super(model, metaModel, "InformationChanged");
		this.object = object;
		this.objectcopies = new ArrayList<EObject>();
		try {
			if (object.getObject() != null) {
				this.objectcopies.add(EMFCopier.copy(object.getObject()));
			}
			if (object.getObjects() != null) {
				List<EObject> objs = object.getObjects();
				for (EObject obj : objs) {
					this.objectcopies.add(EMFCopier.copy(obj));
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.newAttributeConfig = newAttributeConfig;
		this.newReferenceConfig = newReferenceConfig;
		this.oldAttValue = new HashMap<String, Object>();
		this.newAttValue = new HashMap<String, Object>();
		this.previous = new HashMap<String, Object>();
		this.next = new HashMap<String, Object>();
		this.oldRefValue = new HashMap<String, Object>();
		this.oldRefNameValue = new HashMap<String, String>();
		this.newRefValue = new HashMap<String, Object>();
		this.newRefNameValue = new HashMap<String, String>();
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param object
	 * @param newAttributeConfig
	 *            Normal constructor
	 */
	public ModifyInformationMutator(Resource model,
			List<EPackage> metaModel, ObSelectionStrategy object,
			Map<String, List<AttributeConfigurationStrategy>> newAttributeConfig,
			Map<String, List<ReferenceConfigurationStrategy>> newReferenceConfig,
			List<EObject> objsAttRef,
			Map<String, List<AttributeConfigurationStrategy>> attsRef) {
		super(model, metaModel, "InformationChanged");
		this.object = object;
		this.objectcopies = new ArrayList<EObject>();
		try {
			if (object.getObject() != null) {
				this.objectcopies.add(EMFCopier.copy(object.getObject()));
			}
			if (object.getObjects() != null) {
				List<EObject> objs = object.getObjects();
				for (EObject obj : objs) {
					this.objectcopies.add(EMFCopier.copy(obj));
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.newAttributeConfig = newAttributeConfig;
		this.newReferenceConfig = newReferenceConfig;
		this.objsAttRef = objsAttRef;
		this.attsRef = attsRef;
		this.oldAttValue = new HashMap<String, Object>();
		this.newAttValue = new HashMap<String, Object>();
		this.previous = new HashMap<String, Object>();
		this.next = new HashMap<String, Object>();
		this.oldRefValue = new HashMap<String, Object>();
		this.oldRefNameValue = new HashMap<String, String>();
		this.newRefNameValue = new HashMap<String, String>();
		this.newRefValue = new HashMap<String, Object>();
	}

//	/**
//	 * Completes the model with mandatory features
//	 * @param packages
//	 * @param model
//	 * @return
//	 */
//	private void complete(List<EPackage> packages, Resource model) {
//		TreeIterator<EObject> tree = model.getAllContents();
//		while (tree.hasNext()) {
//			EObject eObject = (EObject) tree.next();
//			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
//			if (diagnostic.getSeverity() != Diagnostic.OK) {
//				int code = ((BasicDiagnostic) diagnostic.getChildren().get(0)).getCode();
//				if (code == 0 || code == 1) {
//					try {
//						// COMPLETES THE CARDINALITIES
//						TreeIterator<Object> nested = EcoreUtil.getAllContents(eObject, true);
//						List<EObject> processed = new ArrayList<EObject>();
//						while (nested.hasNext()) {
//							EObject obj = (EObject) nested.next();
//							if (processed.contains(obj)) {
//								break;
//							}
//							processed.add(obj);
//							for (EAttribute att : obj.eClass().getEAllAttributes()) {
//								if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
//									try { 
//										if (att.getEType().getInstanceClassName().equals(String.class.getCanonicalName())) {
//											ModelManager.setAttribute(att.getName(), obj, new RandomStringConfigurationStrategy(4, 5, false));
//										}
//										if (att.getEType().getInstanceClassName().equals(boolean.class.getCanonicalName())) {
//											ModelManager.setAttribute(att.getName(), obj, new RandomBooleanConfigurationStrategy());
//										}
//										if (att.getEType().getInstanceClassName().equals(double.class.getCanonicalName())) {
//											ModelManager.setAttribute(att.getName(), obj, new RandomDoubleConfigurationStrategy(1, 100, false));
//										}
//										if (att.getEType().getInstanceClassName().equals(int.class.getCanonicalName())) {
//											ModelManager.setAttribute(att.getName(), obj, new RandomIntegerConfigurationStrategy(1, 100, false));
//										}
//									} catch (WrongAttributeTypeException e) {
//										e.printStackTrace();
//									}
//								}
//							}
//							for (EReference ref : obj.eClass().getEAllReferences()) {
//								if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
//									try {
//										if (ref.isChangeable()) {
//											ModelManager.setReference(ref.getName(), obj, new RandomTypeSelection(packages, model, ref.getEReferenceType().getName()));
//										}
//									} catch (WrongAttributeTypeException e) {
//									} catch (ReferenceNonExistingException e) {
//									} catch (ClassCastException e) {
//									}
//								}
//							}
//						}
//					} catch (Exception ex) {
//					}
//				}
//			}
//		}
//	}

	@Override
	public Object mutate() throws ReferenceNonExistingException,
			WrongAttributeTypeException {
		if (this.object == null) {
			return null;
		}

		// getObject() denotes a single selected object. A collection returned
		// by getObjects() must not be reduced to a random single element:
		// generated `modify all` commands depend on visiting the entire set.
		EObject selected = this.object.getObject();
		if (selected != null) {
			this.index = 0;
			mutateSelectedObject(selected);
		} else {
			List<EObject> selectedObjects = this.object.getObjects();
			if (selectedObjects == null || selectedObjects.isEmpty()) {
				return null;
			}
			// Selection strategies may return live ELists. Snapshot before any
			// mutation moves objects between containment references.
			List<EObject> snapshot = new ArrayList<EObject>(selectedObjects);
			for (int i = 0; i < snapshot.size(); i++) {
				this.index = i;
				mutateSelectedObject(snapshot.get(i));
			}
		}

		// Referenced-object attribute edits are a separate part of the command.
		// Apply them once, not once for each element of `modify all`.
		if (this.objsAttRef != null && this.attsRef != null) {
			for (EObject target : new ArrayList<EObject>(this.objsAttRef)) {
				if (target == null) continue;
				objRefAttOld = EMFCopier.copy(target);
				for (Entry<String, List<AttributeConfigurationStrategy>> entry : this.attsRef.entrySet()) {
					Object old = ModelManager.getAttribute(entry.getKey(), target);
					oldAttValue.put(entry.getKey(), old);
					if (entry.getValue() == null || entry.getValue().isEmpty()) {
						ModelManager.unsetAttribute(entry.getKey(), target);
					} else {
						for (AttributeConfigurationStrategy strategy : entry.getValue()) {
							if (strategy == null) ModelManager.unsetAttribute(entry.getKey(), target);
							else ModelManager.setAttribute(entry.getKey(), target, strategy);
						}
					}
					newAttValue.put(entry.getKey(), ModelManager.getAttribute(entry.getKey(), target));
				}
				objRefAttNew = target;
			}
		}
		return result;
	}

	private void mutateSelectedObject(EObject target)
			throws ReferenceNonExistingException, WrongAttributeTypeException {
		if (target == null) return;

		if (newAttributeConfig != null) {
			for (Entry<String, List<AttributeConfigurationStrategy>> entry : newAttributeConfig.entrySet()) {
				String name = entry.getKey();
				List<AttributeConfigurationStrategy> configs = entry.getValue();
				if (configs == null || configs.isEmpty()) {
					oldAttValue.put(name, ModelManager.getAttribute(name, target));
					ModelManager.unsetAttribute(name, target);
					newAttValue.put(name, null);
					continue;
				}
				for (AttributeConfigurationStrategy config : configs) {
					if (config instanceof SwapAttributeConfigurationStrategy) {
						SwapAttributeConfigurationStrategy swap = (SwapAttributeConfigurationStrategy) config;
						eobjatt = swap.getAttObject();
						eobjother = swap.getOtherObject();
						oldAttValue.put(name, swap.getPrevious());
					} else {
						eobjatt = EMFCopier.copy(target);
						oldAttValue.put(name, ModelManager.getAttribute(name, target));
					}
					if (config == null) ModelManager.unsetAttribute(name, target);
					else ModelManager.setAttribute(name, target, config);
					newAttValue.put(name, ModelManager.getAttribute(name, target));
				}
			}
		}

		if (newReferenceConfig != null) {
			for (Entry<String, List<ReferenceConfigurationStrategy>> entry : newReferenceConfig.entrySet()) {
				String name = entry.getKey();
				EStructuralFeature structuralFeature = target.eClass().getEStructuralFeature(name);
				if (!(structuralFeature instanceof EReference)) {
					throw new IllegalArgumentException("Reference '" + name + "' does not exist on "
							+ target.eClass().getName());
				}
				EReference reference = (EReference) structuralFeature;
				List<ReferenceConfigurationStrategy> configs = entry.getValue();
				if (configs == null || configs.isEmpty()) {
					rememberPrevious(name, target, reference);
					target.eUnset(reference);
					next.put(name, null);
					continue;
				}
				for (ReferenceConfigurationStrategy config : configs) {
					rememberPrevious(name, target, reference);
					Object proposed = configuredReferenceValue(name, config, target);
					if (proposed == null && config != null
							&& !(config instanceof NullReferenceConfigurationStrategy)) {
						throw new IllegalStateException("Selected reference target is null for " + name);
					}
					applyReferenceValue(target, reference, proposed);
					rememberNext(name, target, reference);
				}
			}
		}
		this.result = target;
	}

	/** Retrieve the strategy's chosen target once, without cloning live targets. */
	private Object configuredReferenceValue(String refName, ReferenceConfigurationStrategy config, EObject target) {
		if (config == null || config instanceof NullReferenceConfigurationStrategy) {
			if (config instanceof NullReferenceConfigurationStrategy) {
				srcRefType = ((NullReferenceConfigurationStrategy) config).getSrcRefType();
			}
			return null;
		}
		if (config instanceof SpecificReferenceConfigurationStrategy) {
			SpecificReferenceConfigurationStrategy specific = (SpecificReferenceConfigurationStrategy) config;
			srcRefType = specific.getSrcRefType();
			eobjref = target;
			return specific.getNext();
		}
		if (config instanceof RandomReferenceConfigurationStrategy) {
			RandomReferenceConfigurationStrategy random = (RandomReferenceConfigurationStrategy) config;
			srcRefType = random.getSrcRefType();
			eobjref = target;
			return random.getNext();
		}
		if (config instanceof CopyReferenceConfigurationStrategy) {
			CopyReferenceConfigurationStrategy copy = (CopyReferenceConfigurationStrategy) config;
			eobjref = copy.getRefObject();
			return copy.getNext(eobjref);
		}
		if (config instanceof SwapReferenceConfigurationStrategy) {
			SwapReferenceConfigurationStrategy swap = (SwapReferenceConfigurationStrategy) config;
			eobjref = swap.getTargetObject();
			oldRefValue.put("swap", swap.getOtherSource());
			newRefValue.put("swap", swap.getOtherTarget());
			return swap.getNext(target);
		}
		throw new IllegalArgumentException("Unsupported Wodel reference strategy: "
				+ config.getClass().getName());
	}

	/**
	 * For multi-valued features the Wodel += case adds the chosen objects.
	 * Snapshot a list before moving containment objects (otherwise an EMF
	 * EList may shrink while it is being traversed). Single-valued features
	 * are assigned directly. Containment targets must not be deep-copied:
	 * adding the existing EObject reparents it to the destination owner.
	 */
	@SuppressWarnings("unchecked")
	private void applyReferenceValue(EObject owner, EReference reference, Object value) {
		if (value == null) {
			owner.eUnset(reference);
			return;
		}
		List<EObject> proposed = new ArrayList<EObject>();
		if (value instanceof EObject) {
			proposed.add(resolveTarget((EObject) value));
		} else if (value instanceof List<?>) {
			for (Object item : new ArrayList<Object>((List<?>) value)) {
				if (!(item instanceof EObject)) {
					throw new IllegalArgumentException("Expected EObject for reference " + reference.getName());
				}
				proposed.add(resolveTarget((EObject) item));
			}
		} else {
			throw new IllegalArgumentException("Expected EObject/list for reference "
					+ reference.getName() + "; received " + value.getClass().getName());
		}
		if (reference.isMany()) {
			List<EObject> existing = (List<EObject>) owner.eGet(reference);
			for (EObject candidate : proposed) {
				if (!existing.contains(candidate)) existing.add(candidate);
			}
		} else {
			if (proposed.size() != 1) {
				throw new IllegalArgumentException("Expected exactly one target for " + reference.getName());
			}
			owner.eSet(reference, proposed.get(0));
		}
	}

	/** Map a selected EObject into the mutant resource before linking it. */
	private EObject resolveTarget(EObject candidate) {
		if (candidate == null || candidate.eIsProxy() || candidate.eResource() == null
				|| candidate.eResource() == getModel()) return candidate;
		EObject mapped = ModelManager.getObjectByURIEnding(getModel(), EcoreUtil.getURI(candidate));
		if (mapped == null) mapped = ModelManager.getObjectByName(getModel(), candidate);
		if (mapped == null) {
			throw new IllegalArgumentException("Cannot locate the selected reference target in the mutated model: "
					+ EcoreUtil.getURI(candidate));
		}
		return mapped;
	}

	private void rememberPrevious(String name, EObject target, EReference reference) {
		Object old = target.eGet(reference, false);
		EObject first = firstReferenceObject(old);
		previous.put(name, first == null ? null : EMFCopier.copy(first));
	}

	private void rememberNext(String name, EObject target, EReference reference) {
		EObject first = firstReferenceObject(target.eGet(reference, false));
		next.put(name, first);
	}

	private static EObject firstReferenceObject(Object value) {
		if (value instanceof EObject) return (EObject) value;
		if (value instanceof List<?>) {
			for (Object element : (List<?>) value) {
				if (element instanceof EObject) return (EObject) element;
			}
		}
		return null;
	}

	public EObject getObject() {
		try {
			Object obj = object.getObject();
			if (obj == null && object.getObjects() != null) {
				obj = object.getObjects().get(index);
			}
			return (EObject) obj;
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object getOldAttValue(String attName) {
		//return oldAttValue;
		for (String savedAttName : oldAttValue.keySet()) {
			if (savedAttName.equals(attName)) {
				return oldAttValue.get(savedAttName);
			}
		}
//		EList<EAttribute> atts = ModelManager.getAttributes(eobjatt);
//		for (EAttribute att : atts) {
//			if (att.getName().equals(attName)) {
//				return eobjatt.eGet(att);
//			}
//		}
		return null;
	}

	public Object getNewAttValue(String attName) {
		//return newAttValue;
		for (String savedAttName : newAttValue.keySet()) {
			if (savedAttName.equals(attName)) {
				return newAttValue.get(savedAttName);
			}
		}
//		EList<EAttribute> atts = ModelManager.getAttributes(result);
//		for (EAttribute att : atts) {
//			if (att.getName().equals(attName)) {
//				return result.eGet(att);
//			}
//		}
		return null;
	}
	
	public Object getOldRefAttValue(String attName) {
		//return oldAttValue;
		if (objRefAttOld != null) {
		List<EAttribute> atts = ModelManager.getAttributes(objRefAttOld);
		for (EAttribute att : atts) {
			if (att.getName().equals(attName)) {
				return objRefAttOld.eGet(att);
			}
		}
		}
		return null;
	}

	public Object getNewRefAttValue(String attName) {
		//return newAttValue;
		if (objRefAttNew != null) {
		List<EAttribute> atts = ModelManager.getAttributes(objRefAttNew);
		for (EAttribute att : atts) {
			if (att.getName().equals(attName)) {
				return objRefAttNew.eGet(att);
			}
		}
		}
		return null;
	}
	
	public String getSrcRefType() {
		return srcRefType;
	}


	public EObject getPrevious(String refName) {
		for (String prevRefName : previous.keySet()) {
			if (prevRefName.equals(refName)) {
				if (previous.get(refName) instanceof EObject) {
					return (EObject) previous.get(refName);
				}
				else if (previous.get(refName) instanceof List<?> && ((List<EObject>) previous.get(refName)).size() > 0){
					return ((List<EObject>) previous.get(refName)).get(0);
				}
			}
		}
		return null;
	}

	public EObject getNext(String refName) {
		for (String nextRefName : next.keySet()) {
			if (nextRefName.equals(refName)) {
				if (next.get(refName) instanceof EObject) {
					return (EObject) next.get(refName);
				}
				else if (next.get(refName) instanceof List<?> && ((List<EObject>) next.get(refName)).size() > 0){
					return ((List<EObject>) next.get(refName)).get(0);
				}
			}
		}
		return null;
	}

	public EObject getAttObject() {
		return eobjatt;
	}
	
	public EObject getOtherObject() {
		return eobjother;
	}
	
	public EObject getRefObject() {
		return eobjref;
	}
	
	public EObject getRefAttObject() {
		return objRefAttNew;
	}
	
	public EObject getOtherSource(String refName) {
		for (String oldRef : oldRefValue.keySet()) {
			if (oldRef.equals(refName)) {
				if (oldRefValue.get(refName) instanceof EObject) {
					return (EObject) oldRefValue.get(refName);
				}
				else if (oldRefValue.get(refName) instanceof List<?>){
					return ((List<EObject>) oldRefValue.get(refName)).get(0);
				}
			}
		}
		return null;
	}
	
	public String getOtherSourceName(String refName) {
		for (String oldRefName : oldRefNameValue.keySet()) {
			if (oldRefName.equals(refName)) {
				return oldRefNameValue.get(refName);
			}
		}
		return null;
	}

	public EObject getOtherTarget(String refName) {
		for (String newRef : newRefValue.keySet()) {
			if (newRef.equals(refName)) {
				if (newRefValue.get(refName) instanceof EObject) {
					return (EObject) newRefValue.get(refName);
				}
				else if (newRefValue.get(refName) instanceof List<?>){
					return ((List<EObject>) newRefValue.get(refName)).get(0);
				}
			}
		}
		return null;
	}
	
	public String getOtherTargetName(String refName) {
		for (String newRefName : newRefNameValue.keySet()) {
			if (newRefName.equals(refName)) {
				return newRefNameValue.get(refName);
			}
		}
		return null;
	}
}
