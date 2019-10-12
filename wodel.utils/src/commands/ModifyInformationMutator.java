package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import manager.EMFCopier;
import manager.EMFUtils;
import manager.ModelManager;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.RandomTypeSelection;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.CopyReferenceConfigurationStrategy;
import commands.strategies.RandomBooleanConfigurationStrategy;
import commands.strategies.RandomDoubleConfigurationStrategy;
import commands.strategies.RandomIntegerConfigurationStrategy;
import commands.strategies.RandomReferenceConfigurationStrategy;
import commands.strategies.RandomStringConfigurationStrategy;
import commands.strategies.ReferenceConfigurationStrategy;
import commands.strategies.SwapAttributeConfigurationStrategy;
import commands.strategies.SwapReferenceConfigurationStrategy;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

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
	public Object mutate() throws ReferenceNonExistingException,
			WrongAttributeTypeException {
		if (this.object == null) {
			return null;
		}
		EObject object = this.object.getObject();
		if (object == null) {
			List<EObject> objects = this.object.getObjects();
			if (objects != null) {
				index = ModelManager.getRandomIndex(objects);
				object = objects.get(index);
			}
		}
		if (object != null) {
			// Attributes setting
			if (this.newAttributeConfig != null) {
				Iterator<Entry<String, List<AttributeConfigurationStrategy>>> atts = this.newAttributeConfig.entrySet().iterator();
				while (atts.hasNext()) {
					Map.Entry<String, List<AttributeConfigurationStrategy>> e = atts.next();
					for (AttributeConfigurationStrategy attConfig : e.getValue()) {
						if (attConfig instanceof SwapAttributeConfigurationStrategy) {
							SwapAttributeConfigurationStrategy sacs = (SwapAttributeConfigurationStrategy) attConfig;
							eobjatt = sacs.getAttObject();
							eobjother = sacs.getOtherObject();

							oldAttValue.put(e.getKey(), sacs.getPrevious());
							//oldAttValue = sacs.getPrevious(object);
						}
						else {
							oldAttValue.put(e.getKey(), ModelManager.getAttribute(e.getKey(), object));
							eobjatt = EcoreUtil.copy(object);
						}
						if (e.getValue() == null) {
							ModelManager.unsetAttribute(e.getKey(), object);
							newAttValue.put(e.getKey(), null);
							//newAttValue = null;
						} else {
							ModelManager.setAttribute(e.getKey(), object, attConfig);
							newAttValue.put(e.getKey(), ModelManager.getAttribute(e.getKey(), object));
							//newAttValue = ModelManager.getAttribute(e.getKey(), object);

						}
					}
				}
				result = object;
			}
			if (this.newReferenceConfig != null) {
				// References setting
				Iterator<Entry<String, List<ReferenceConfigurationStrategy>>> refs = this.newReferenceConfig.entrySet().iterator();
				while (refs.hasNext()) {
					Map.Entry<String, List<ReferenceConfigurationStrategy>> e = refs.next();
					for (ReferenceConfigurationStrategy refConfig : e.getValue()) {
						if (refConfig instanceof SwapReferenceConfigurationStrategy) {
							SwapReferenceConfigurationStrategy srcf = (SwapReferenceConfigurationStrategy) refConfig;
							eobjref = EcoreUtil.copy(srcf.getRefObject());
							previous.put(e.getKey(), (EObject) srcf.getPrevious(eobjref));
							next.put(e.getKey(), (EObject) srcf.getNext(eobjref));
							oldRefValue.put(e.getKey(), srcf.getOtherSource());
							oldRefNameValue.put(e.getKey(), srcf.getOtherSourceName());
							newRefValue.put(e.getKey(), srcf.getOtherTarget());
							newRefNameValue.put(e.getKey(), srcf.getOtherTargetName());
						}
						else {
							if (refConfig instanceof CopyReferenceConfigurationStrategy) {
								CopyReferenceConfigurationStrategy crcf = (CopyReferenceConfigurationStrategy) refConfig;
								eobjref = EcoreUtil.copy(crcf.getRefObject());
								previous.put(e.getKey(), (EObject) crcf.getPrevious(eobjref));
								next.put(e.getKey(), (EObject) crcf.getNext(eobjref));
							}
							else {
								if (refConfig instanceof RandomReferenceConfigurationStrategy) {
									RandomReferenceConfigurationStrategy rrcf = (RandomReferenceConfigurationStrategy) refConfig;
									if (rrcf.getPrevious() instanceof List<?>) {
										List<EObject> prev = (List<EObject>) rrcf.getPrevious();
										if (prev != null) {
											if (prev.size() > 0) {
												previous.put(e.getKey(), prev.get(0));
											}
										}
									}
									if (rrcf.getPrevious() instanceof EObject) {
										previous.put(e.getKey(), (EObject) rrcf.getPrevious());
									}
									if (rrcf.getNext() instanceof List<?>) {
										List<EObject> nxt = (List<EObject>) rrcf.getNext();
										if (nxt != null) {
											if (nxt.size() > 0) {
												next.put(e.getKey(), nxt.get(0));
											}
										}
									}
									if (rrcf.getNext() instanceof EObject) {
										next.put(e.getKey(), (EObject) rrcf.getNext());
									}
									srcRefType = rrcf.getSrcRefType(); 
								}
								eobjref = EcoreUtil.copy(object);
								try {
									previous.put(e.getKey(), ModelManager.getReference(e.getKey(), object));
								}
								catch (ClassCastException ex) {
									previous.put(e.getKey(), ModelManager.getReferences(e.getKey(), object));
								}
							}
						}
						if (refConfig == null) {
							ModelManager.unsetReference(e.getKey(), object);
							next.put(e.getKey(), null);
						} else {
							EReference r = (EReference) ModelManager.getReferenceByName(e.getKey(), object);
							Object ob = object.eGet(r);
							if (ob instanceof EObject) {
								//EObject eObject = EMFCopier.process(this.getModel(), (EObject) refConfig.getValue(object));
								//EMFUtils.setReference(object.eClass().getEPackage(), object, e.getKey(), eObject);
								EMFUtils.setReference(object.eClass().getEPackage(), object, e.getKey(), (EObject) refConfig.getValue(object));
							}
							else {
								List<EObject> list = (List<EObject>) ob;
								if (refConfig.getValue(object) instanceof EObject) {
									//EObject eObject = EMFCopier.process(this.getModel(), (EObject) refConfig.getValue(object));
									//list.add(eObject);
									list.add((EObject) refConfig.getValue(object));
								}
								else {
									//List<EObject> processed = new ArrayList<EObject>();
									//List<EObject> copies = new ArrayList<EObject>();
									//copies.addAll((List<EObject>) refConfig.getValue(object));
									//for (EObject o : copies) {
									//	EObject eObject = EMFCopier.process(this.getModel(), o);
									//	processed.add(eObject);
									//}
									list.addAll((List<EObject>) refConfig.getValue(object));
									//list.addAll((List<EObject>) refConfig.getValue(object));
								}
							}
							//ModelManager.setReference(e.getKey(), object, refConfig);
							next.put(e.getKey(), object);
							//ModelManager.setReference(e.getKey(), object, refConfig);
							//next.put(e.getKey(), object);
						}
					}
				}
				result = object;
			}

			if (this.objsAttRef != null && this.attsRef != null) {
				if (this.objsAttRef.size() > 0 && this.attsRef.size() > 0) {
					for (EObject obj : this.objsAttRef) {
						objRefAttOld = EcoreUtil.copy(obj);
						Iterator<Entry<String, List<AttributeConfigurationStrategy>>> atts = this.attsRef.entrySet().iterator();
						while (atts.hasNext()) {
							Map.Entry<String, List<AttributeConfigurationStrategy>> e = atts.next();
							for (AttributeConfigurationStrategy attConfig : e.getValue()) {
								oldAttValue.put(e.getKey(), ModelManager.getAttribute(e.getKey(), object));
								if (attConfig == null) {
									ModelManager.unsetAttribute(e.getKey(), obj);
									newAttValue.put(e.getKey(), null);
									//newAttValue = null;
								} else {
									ModelManager.setAttribute(e.getKey(), obj, attConfig);
									newAttValue.put(e.getKey(), ModelManager.getAttribute(e.getKey(), obj));
									//newAttValue = ModelManager.getAttribute(e.getKey(), object);
								}
							}
						}
						objRefAttNew = obj;
					}
				}
			}
		}
		//complete(this.getMetaModel(), this.getModel());
		return this.result;
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
		EList<EAttribute> atts = ModelManager.getAttributes(objRefAttOld);
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
		EList<EAttribute> atts = ModelManager.getAttributes(objRefAttNew);
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
				else if (previous.get(refName) instanceof List<?>){
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
				else if (next.get(refName) instanceof List<?>){
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
