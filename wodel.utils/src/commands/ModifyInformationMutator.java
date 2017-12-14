package commands;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import manager.ModelManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.CopyAttributeConfigurationStrategy;
import commands.strategies.CopyReferenceConfigurationStrategy;
import commands.strategies.RandomReferenceConfigurationStrategy;
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
	private HashMap<String, List<AttributeConfigurationStrategy>> newAttributeConfig;
	/**
	 * New configuration settings
	 */
	private HashMap<String, List<ReferenceConfigurationStrategy>> newReferenceConfig;
	/**
	 * Modified object
	 */
	private EObject result;

	private EObject previous;
	
	private EObject next;

	private EObject eobjother;
	private EObject eobjatt;
	
	private EObject eobjref;
	
	private EObject othereobjsrc;
	private String othereobjsrcname;
	private EObject othereobjtar;
	private String othereobjtarname;
	
	private List<EObject> objsAttRef;
	private HashMap<String, List<AttributeConfigurationStrategy>> attsRef;
	
	private EObject objRefAttOld;
	private EObject objRefAttNew;
	
	private String srcRefType;
	
	private int index = 0;

	/**
	 * @param model
	 * @param metaModel
	 * @param object
	 * @param newAttributeConfig
	 *            Normal constructor
	 */
	public ModifyInformationMutator(Resource model,
			List<EPackage> metaModel, ObSelectionStrategy object,
			HashMap<String, List<AttributeConfigurationStrategy>> newAttributeConfig,
			HashMap<String, List<ReferenceConfigurationStrategy>> newReferenceConfig) {
		super(model, metaModel, "InformationChanged");
		this.object = object;
		this.newAttributeConfig = newAttributeConfig;
		this.newReferenceConfig = newReferenceConfig;
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
			HashMap<String, List<AttributeConfigurationStrategy>> newAttributeConfig,
			HashMap<String, List<ReferenceConfigurationStrategy>> newReferenceConfig,
			List<EObject> objsAttRef,
			HashMap<String, List<AttributeConfigurationStrategy>> attsRef) {
		super(model, metaModel, "InformationChanged");
		this.object = object;
		this.newAttributeConfig = newAttributeConfig;
		this.newReferenceConfig = newReferenceConfig;
		this.objsAttRef = objsAttRef;
		this.attsRef = attsRef;
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

							//oldAttValue = sacs.getPrevious(object);
						}
						else {
							if (attConfig instanceof CopyAttributeConfigurationStrategy) {
								CopyAttributeConfigurationStrategy cacs = (CopyAttributeConfigurationStrategy) attConfig;
								eobjatt = cacs.getAttObject();
								//oldAttValue = cacs.getPrevious(object);
							}
							else {
								eobjatt = EcoreUtil.copy(object);
								//oldAttValue = ModelManager.getAttribute(e.getKey(), object);
							}
						}
						if (e.getValue() == null) {
							ModelManager.unsetAttribute(e.getKey(), object);
							//newAttValue = null;
						} else {
							ModelManager.setAttribute(e.getKey(), object, attConfig);
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
							previous = (EObject) srcf.getPrevious(eobjref);
							next = (EObject) srcf.getNext(eobjref);
							othereobjsrc = srcf.getOtherSource();
							othereobjsrcname = srcf.getOtherSourceName();
							othereobjtar = srcf.getOtherTarget();
							othereobjtarname = srcf.getOtherTargetName();
						}
						else {
							if (refConfig instanceof CopyReferenceConfigurationStrategy) {
								CopyReferenceConfigurationStrategy crcf = (CopyReferenceConfigurationStrategy) refConfig;
								eobjref = EcoreUtil.copy(crcf.getRefObject());
								previous = (EObject) crcf.getPrevious(eobjref);
								next = (EObject) crcf.getNext(eobjref);
							}
							else {
								if (refConfig instanceof RandomReferenceConfigurationStrategy) {
									RandomReferenceConfigurationStrategy rrcf = (RandomReferenceConfigurationStrategy) refConfig;
									if (rrcf.getPrevious() instanceof List<?>) {
										List<EObject> prev = (List<EObject>) rrcf.getPrevious();
										if (prev != null) {
											if (prev.size() > 0) {
												previous = prev.get(0);
											}
										}
									}
									if (rrcf.getPrevious() instanceof EObject) {
										previous = (EObject) rrcf.getPrevious();
									}
									if (rrcf.getNext() instanceof List<?>) {
										List<EObject> nxt = (List<EObject>) rrcf.getNext();
										if (nxt != null) {
											if (nxt.size() > 0) {
												next = nxt.get(0);
											}
										}
									}
									if (rrcf.getNext() instanceof EObject) {
										next = (EObject) rrcf.getNext();
									}
									srcRefType = rrcf.getSrcRefType(); 
								}
								eobjref = EcoreUtil.copy(object);
								//previous = ModelManager.getReference(e.getKey(), object);
							}
						}
						if (refConfig == null) {
							ModelManager.unsetReference(e.getKey(), object);
							//next = null;
						} else {
							ModelManager.setReference(e.getKey(), object, refConfig);
							//next = ModelManager.getReference(e.getKey(), object);
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
								if (attConfig == null) {
									ModelManager.unsetAttribute(e.getKey(), obj);
									//newAttValue = null;
								} else {
									ModelManager.setAttribute(e.getKey(), obj, attConfig);
									//newAttValue = ModelManager.getAttribute(e.getKey(), object);
								}
							}
						}
						objRefAttNew = obj;
					}
				}
			}
		}
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
		EList<EAttribute> atts = ModelManager.getAttributes(eobjatt);
		for (EAttribute att : atts) {
			if (att.getName().equals(attName)) {
				return eobjatt.eGet(att);
			}
		}
		return null;
	}

	public Object getNewAttValue(String attName) {
		//return newAttValue;
		EList<EAttribute> atts = ModelManager.getAttributes(result);
		for (EAttribute att : atts) {
			if (att.getName().equals(attName)) {
				return result.eGet(att);
			}
		}
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


	public EObject getPrevious() {
		return previous;
	}

	public EObject getNext() {
		return next;
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
	
	public EObject getOtherSource() {
		return othereobjsrc;
	}
	
	public String getOtherSourceName() {
		return othereobjsrcname;
	}

	public EObject getOtherTarget() {
		return othereobjtar;
	}
	
	public String getOtherTargetName() {
		return othereobjtarname;
	}
}
