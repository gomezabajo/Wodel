package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

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

	@Override
	public EObject getObject() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		if(l==null || l.size()==0) return null;
		return l.get(ModelManager.getRandomIndex(l));
	}
	
	@Override
	public List<EObject> getObjects() {
		return ModelManager.getObjectsOfType(type, this.getModel());
	}
	
}
