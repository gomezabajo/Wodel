package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CompleteTypeSelection selects all objects that match the given parameters
 *  
 */

public class CompleteTypeSelection extends CompleteSelection {

	/**
	 * Object type
	 */
	private String type;
	
	private EObject container;
	
	private EReference reference;

	private List<EObject> excludedObjects;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public CompleteTypeSelection(List<EPackage> metaModel, Resource model, String type){
		super(metaModel, model);
		this.type = type;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public CompleteTypeSelection(List<EPackage> metaModel, Resource model, String type, List<EObject> excludedObjects){
		super(metaModel, model);
		this.type = type;
		this.excludedObjects = excludedObjects;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public CompleteTypeSelection(List<EPackage> metaModel, Resource model, String type,ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
		super(metaModel, model);
		try {
			this.type = type;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public CompleteTypeSelection(List<EPackage> metaModel, Resource model, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, List<EObject> excludedObjects){
		super(metaModel, model);
		try {
			this.type = type;
			this.excludedObjects = excludedObjects;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<EObject> getObjects() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if (excludedObjects != null) {
			ModelManager.removeEObjects(l, excludedObjects);
		}
		if(l==null || l.size()==0) return null;
		List<EObject> ret = new ArrayList<EObject>();
		if ((container == null) && (reference == null)) {
			ret.addAll(l);
		}
		if ((container != null) && (reference != null)) {
			if (container.eGet(reference) instanceof List<?>) {
				List<EObject> objects = (List<EObject>) container.eGet(reference);
				for (EObject obj : objects) {
					for (EObject ob : l) {
						if (EcoreUtil.equals(obj, ob)) {
							ret.add(ob);
						}
						else if (ob.equals(obj)) {
							ret.add(ob);
						}
					}
				}
			}
			else {
				EObject obj = (EObject) container.eGet(reference);
				if (obj != null) {
					URI objURI = EcoreUtil.getURI(obj);
					for (EObject ob : l) {
						if (EcoreUtil.equals(obj, ob)) {
							ret.add(ob);
						}
						else if (ob.equals(obj)) {
							ret.add(ob);
						}
					}
				}
			}
		}
		else if (reference != null) {
			for (EObject o : l) {
				if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
					ret.add(o);
				}
			}
		}
		return ret;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if (excludedObjects != null) {
			ModelManager.removeEObjects(l, excludedObjects);
		}
		if (l==null || l.size()==0) return null;
		if(l==null || l.size()==0) return null;
		List<EObject> ret = new ArrayList<EObject>();
		if ((container == null) && (reference == null)) {
			ret.addAll(l);
		}
		if ((container != null) && (reference != null)) {
			if (container.eGet(reference) instanceof List<?>) {
				List<EObject> objects = (List<EObject>) container.eGet(reference);
				for (EObject obj : objects) {
					for (EObject ob : l) {
						if (EcoreUtil.equals(obj, ob)) {
							ret.add(ob);
						}
						else if (ob.equals(obj)) {
							ret.add(ob);
						}
					}
				}
			}
			else {
				EObject obj = (EObject) container.eGet(reference);
				if (obj != null) {
					for (EObject ob : l) {
						if (EcoreUtil.equals(obj, ob)) {
							ret.add(ob);
						}
						else if (ob.equals(obj)) {
							ret.add(ob);
						}
					}
				}
			}
		}
		else if (reference != null) {
			for (EObject o : l) {
				if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
					ret.add(o);
				}
			}
		}
		return ret.get(ModelManager.getRandomIndex(ret));
	}
}
