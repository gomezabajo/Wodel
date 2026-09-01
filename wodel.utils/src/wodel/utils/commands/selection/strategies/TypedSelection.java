package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.manager.ModelManager;

public class TypedSelection extends ObSelectionStrategy {
	/**
	 * Object type
	 */
	private String type;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public TypedSelection(List<EPackage> metaModel, Resource model, String type){
		super(metaModel, model);
		this.type = type;
	}
	
	public TypedSelection(List<EPackage> metaModel, List<Resource> models, String type) {
		super(metaModel, models);
		this.type = type;
	}

	@Override
	public List<EObject> getObjects() {
		List<EObject> l = new ArrayList<EObject>();
		if (this.getModel() != null) {
			l = ModelManager.getObjectsOfType(type, this.getModel()); 
		}
		else if (this.getModels() != null) {
			l = ModelManager.getObjectsOfType(type, this.getModels());
		}
		if(l==null || l.isEmpty()) return null;
		ModelManager.sortEObjectsDeterministically(l);
		return l;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		List<EObject> l = new ArrayList<EObject>();
		if (this.getModel() != null) {
			l = ModelManager.getObjectsOfType(type, this.getModel()); 
		}
		else if (this.getModels() != null) {
			l = ModelManager.getObjectsOfType(type, this.getModels());
		}
		if(l==null || l.isEmpty()) return null;
		ModelManager.sortEObjectsDeterministically(l);
		return l.get(ModelManager.getRandomIndex(l));
	}
}
