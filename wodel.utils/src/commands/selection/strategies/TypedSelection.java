package commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;
import manager.ModelManager;

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

	@Override
	public List<EObject> getObjects() {
		return ModelManager.getObjectsOfType(type, this.getModel());
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if(l==null || l.size()==0) return null;
		return l.get(ModelManager.getRandomIndex(l));
	}
}
