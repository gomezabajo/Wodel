package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import commands.ObjectEmitter;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * ObSelectionStrategy is the father class of all the selection strategies
 */
public abstract class ObSelectionStrategy implements ObjectEmitter{
	
	/**
	 * Loades metamodel
	 */
	private ArrayList<EPackage> metaModel;
	/**
	 * Loaded model
	 */
	private Resource model;
	
	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public ObSelectionStrategy(ArrayList<EPackage> metaModel, Resource model){
		this.metaModel = metaModel;
		this.model = model;
	}
	
	public abstract EObject getObject() throws ReferenceNonExistingException;

	public List<EObject> getObjects() throws ReferenceNonExistingException { return null; };
	
	public ArrayList<EPackage> getMetaModel() {
		return metaModel;
	}
	public void setMetaModel(ArrayList<EPackage> metaModel) {
		this.metaModel = metaModel;
	}
	public Resource getModel() {
		return model;
	}
	public void setModel(Resource model) {
		this.model = model;
	}
	
	//public boolean sameType(EClassifier c) throws ReferenceNonExistingException {
	//	if(c.getName().equals(this.getObject().eClass().getName())) return true;
	//	return false;
	//}
}
