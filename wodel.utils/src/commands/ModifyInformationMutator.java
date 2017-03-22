package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import manager.ModelManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @author Victor Lopez Rivero ModifyInformationMutator Modify the attributes of
 *         the objects
 */
public class ModifyInformationMutator extends Mutator {

	/**
	 * Object that will be modified
	 */
	private ObSelectionStrategy object;
	/**
	 * New configuration settings
	 */
	private HashMap<String, AttributeConfigurationStrategy> newAttributeConfig;
	/**
	 * New configuration settings
	 */
	private HashMap<String, ReferenceConfigurationStrategy> newReferenceConfig;
	/**
	 * Modified object
	 */
	private EObject result;

	//private Object oldAttValue;

	//private Object newAttValue;

	private EObject previous;
	
	private EObject next;

	private EObject eobjother;
	private EObject eobjatt;
	
	private EObject eobjref;
	
	private EObject eobject;
	
	private EObject othereobjsrc;
	private String othereobjsrcname;
	private EObject othereobjtar;
	private String othereobjtarname;
	
	private ArrayList<EObject> objsAttRef;
	private HashMap<String, AttributeConfigurationStrategy> attsRef;
	
	private EObject objRefAttOld;
	private EObject objRefAttNew;
	
	private String srcRefType;

	/**
	 * @param model
	 * @param metaModel
	 * @param object
	 * @param newAttributeConfig
	 *            Normal constructor
	 */
	public ModifyInformationMutator(Resource model,
			ArrayList<EPackage> metaModel, ObSelectionStrategy object,
			HashMap<String, AttributeConfigurationStrategy> newAttributeConfig,
			HashMap<String, ReferenceConfigurationStrategy> newReferenceConfig) {
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
			ArrayList<EPackage> metaModel, ObSelectionStrategy object,
			HashMap<String, AttributeConfigurationStrategy> newAttributeConfig,
			HashMap<String, ReferenceConfigurationStrategy> newReferenceConfig,
			ArrayList<EObject> objsAttRef,
			HashMap<String, AttributeConfigurationStrategy> attsRef) {
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
		if (object != null) {
			eobject = EcoreUtil.copy(object);
			// Attributes setting
			if (this.newAttributeConfig != null) {
				Iterator it = this.newAttributeConfig.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, AttributeConfigurationStrategy> e = (Map.Entry<String, AttributeConfigurationStrategy>) it
							.next();
					if (e.getValue() instanceof SwapAttributeConfigurationStrategy) {
						SwapAttributeConfigurationStrategy sacs = (SwapAttributeConfigurationStrategy) e.getValue();
						eobjatt = sacs.getAttObject();
						eobjother = sacs.getOtherObject();

						//oldAttValue = sacs.getPrevious(object);
					}
					else {
						if (e.getValue() instanceof CopyAttributeConfigurationStrategy) {
							CopyAttributeConfigurationStrategy cacs = (CopyAttributeConfigurationStrategy) e.getValue();
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
						ModelManager.setAttribute(e.getKey(), object, e.getValue());
						//newAttValue = ModelManager.getAttribute(e.getKey(), object);
					}
				}
				result = object;
			}
			if (this.newReferenceConfig != null) {
				// References setting
				Iterator it = this.newReferenceConfig.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, ReferenceConfigurationStrategy> e = (Map.Entry<String, ReferenceConfigurationStrategy>) it
							.next();
					if (e.getValue() instanceof SwapReferenceConfigurationStrategy) {
						SwapReferenceConfigurationStrategy srcf = (SwapReferenceConfigurationStrategy) e.getValue();
						eobjref = EcoreUtil.copy(srcf.getRefObject());
						previous = (EObject) srcf.getPrevious(eobjref);
						next = (EObject) srcf.getNext(eobjref);
						othereobjsrc = srcf.getOtherSource();
						othereobjsrcname = srcf.getOtherSourceName();
						othereobjtar = srcf.getOtherTarget();
						othereobjtarname = srcf.getOtherTargetName();
					}
					else {
						if (e.getValue() instanceof CopyReferenceConfigurationStrategy) {
							CopyReferenceConfigurationStrategy crcf = (CopyReferenceConfigurationStrategy) e.getValue();
							eobjref = EcoreUtil.copy(crcf.getRefObject());
							previous = (EObject) crcf.getPrevious(eobjref);
							next = (EObject) crcf.getNext(eobjref);
						}
						else {
							if (e.getValue() instanceof RandomReferenceConfigurationStrategy) {
								RandomReferenceConfigurationStrategy rrcf = (RandomReferenceConfigurationStrategy) e.getValue();
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
					if (e.getValue() == null) {
						ModelManager.unsetReference(e.getKey(), object);
						//next = null;
					} else {
						ModelManager.setReference(e.getKey(), object, e.getValue());
						//next = ModelManager.getReference(e.getKey(), object);
					}
				}
				result = object;
			}

			if (this.objsAttRef != null && this.attsRef != null) {
				if (this.objsAttRef.size() > 0 && this.attsRef.size() > 0) {
					for (EObject obj : this.objsAttRef) {
						objRefAttOld = EcoreUtil.copy(obj);
						Iterator it = this.attsRef.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry<String, AttributeConfigurationStrategy> e = (Map.Entry<String, AttributeConfigurationStrategy>) it
									.next();
							if (e.getValue() == null) {
								ModelManager.unsetAttribute(e.getKey(), obj);
								//newAttValue = null;
							} else {
								ModelManager.setAttribute(e.getKey(), obj, e.getValue());
								//newAttValue = ModelManager.getAttribute(e.getKey(), object);
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
			return object.getObject();
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
				System.out.println("attName: " + attName);
				System.out.println("eobjatt: " + eobjatt);
				System.out.println("eobjatt.eGet(att): " + eobjatt.eGet(att));
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
