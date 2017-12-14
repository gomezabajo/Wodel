package commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import commands.ObjectEmitter;
import exceptions.ReferenceNonExistingException;


/**
 * @author Pablo Gomez-Abajo
 * 
 * ObSelectionStrategy is the father class of all the selection strategies
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class ObSelectionStrategy implements ObjectEmitter{
	
	/**
	 * Loades metamodel
	 */
	private List<EPackage> metaModel;
	/**
	 * Loaded model
	 */
	private Resource model;
	
	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public ObSelectionStrategy(List<EPackage> metaModel, Resource model){
		this.metaModel = metaModel;
		this.model = model;
	}
	
	public abstract EObject getObject() throws ReferenceNonExistingException;

	public List<EObject> getObjects() throws ReferenceNonExistingException { return null; };
	
	public List<EPackage> getMetaModel() {
		return metaModel;
	}
	public void setMetaModel(List<EPackage> metaModel) {
		this.metaModel = metaModel;
	}
	public Resource getModel() {
		return model;
	}
	public void setModel(Resource model) {
		this.model = model;
	}
}
