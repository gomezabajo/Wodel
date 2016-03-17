package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

	private EObject eobjatt;
	
	private EObject eobjref;
	
	private EObject eobject;

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

	@Override
	public Object mutate() throws ReferenceNonExistingException,
			WrongAttributeTypeException {
		if (this.object == null) {
			return null;
		}
		EObject object = this.object.getObject();
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
					//oldAttValue = sacs.getPrevious(object);
				}
				else {
					if (e.getValue() instanceof CopyAttributeConfigurationStrategy) {
						CopyAttributeConfigurationStrategy cacs = (CopyAttributeConfigurationStrategy) e.getValue();
						//oldAttValue = cacs.getPrevious(object);
					}
					else {
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
				}
				else {
					previous = ModelManager.getReference(e.getKey(), object);
				}
				if (e.getValue() == null) {
					ModelManager.unsetReference(e.getKey(), object);
					next = null;
				} else {
					ModelManager.setReference(e.getKey(), object, e.getValue());
					next = ModelManager.getReference(e.getKey(), object);
				}
			}
			result = object;
		}
		return this.result;
	}

	public EObject getObject() {
		return result;
	}

	public Object getOldAttValue(String attName) {
		//return oldAttValue;
		EList<EAttribute> atts = ModelManager.getAttributes(eobject);
		for (EAttribute att : atts) {
			if (att.getName().equals(attName)) {
				return eobject.eGet(att);
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

	public EObject getPrevious() {
		return previous;
	}

	public EObject getNext() {
		return next;
	}

	public EObject getAttObject() {
		return eobjatt;
	}
	
	public EObject getRefObject() {
		return eobjref;
	}
}
