package wodel.utils.commands.selection.strategies;

import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo
 * 
 * OtherTypeSelection selects a different object with the same
 * type of the given object
 * 
 */

public class OtherTypeSelection extends OtherSelection {
	/**
	 * Object type
	 */
	private String type;
	private Object ob;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public OtherTypeSelection(List<EPackage> metaModel, Resource model, String type, Object ob){
		super(metaModel, model);
		this.type = type;
		this.ob = ob;
	}

	@Override
	public EObject getObject() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		l.remove(ob);
		if(l==null || l.size()==0) return null;
		ModelManager.sortEObjectsDeterministically(l);
		return l.get(ModelManager.getRandomIndex(l));
	}
	@Override
	public List<EObject> getObjects() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		l.remove(ob);
		if(l==null || l.size()==0) return null;
		ModelManager.sortEObjectsDeterministically(l);
		return l;
	}
}
