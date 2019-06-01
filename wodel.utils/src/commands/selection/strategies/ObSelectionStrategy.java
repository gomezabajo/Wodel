package commands.selection.strategies;

import java.util.ArrayList;
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
	 * Loaded models
	 */
	
	private List<Resource> models;
	
	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public ObSelectionStrategy(List<EPackage> metaModel, Resource model){
		this.metaModel = metaModel;
		this.model = model;
	}
	
	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public ObSelectionStrategy(List<EPackage> metaModel, List<Resource> models){
		this.metaModel = metaModel;
		this.models = models;
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
		if (this.model == null) {
			if (this.models != null) {
				return this.models.get(0);
			}
		}
		return model;
	}
	
	public void setModel(Resource model) {
		this.model = model;
	}

	public List<Resource> getModels() {
		if (this.models == null) {
			List<Resource> ret = new ArrayList<Resource>();
			ret.add(this.model);
			return ret;
		}
		return models;
	}
	public void setModels(List<Resource> models) {
		this.models = models;
	}
}
