package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * RandomTypeSelection selects a random object
 */
public class RandomTypeSelection extends RandomSelection{
	
	/**
	 * Object type
	 */
	private String type;
	
	private EObject container;
	
	private EReference reference;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(ArrayList<EPackage> metaModel, Resource model, String type){
		super(metaModel, model);
		this.type = type;
	}
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(ArrayList<EPackage> metaModel, Resource model, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
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

	@Override
	public EObject getObject() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if(l==null || l.size()==0) return null;
		List<EObject> ret = new ArrayList<EObject>();
		if ((container == null) && (reference == null)) {
			ret.addAll(l);
		}
		System.out.println("ret.size(): " + ret.size());
		if ((container != null) && (reference != null)) {
			if (container.eGet(reference) instanceof List<?>) {
				List<EObject> objects = (List<EObject>) container.eGet(reference);
				for (EObject obj : objects) {
					for (EObject ob : l) {
						if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
							ret.add(ob);
						}
					}
				}
			}
			else {
				EObject obj = (EObject) container.eGet(reference);
				for (EObject ob : l) {
					if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
						ret.add(ob);
					}
				}
			}
		}
		int index = ModelManager.getRandomIndex(ret);
		return ret.get(index);
	}
	
	@Override
	public List<EObject> getObjects() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
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
						if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
							ret.add(ob);
						}
					}
				}
			}
			else {
				EObject obj = (EObject) container.eGet(reference);
				for (EObject ob : l) {
					if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
						ret.add(ob);
					}
				}
			}
		}
		return ret;
	}
}
