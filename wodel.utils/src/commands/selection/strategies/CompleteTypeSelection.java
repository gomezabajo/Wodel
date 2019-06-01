package commands.selection.strategies;

import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

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

	@Override
	public List<EObject> getObjects() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if (excludedObjects != null) {
			ModelManager.removeEObjects(l, excludedObjects);
		}
		return l;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if (excludedObjects != null) {
			ModelManager.removeEObjects(l, excludedObjects);
		}
		if (l==null || l.size()==0) return null;
		return l.get(ModelManager.getRandomIndex(l));
	}
}
