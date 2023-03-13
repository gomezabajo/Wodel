package wodel.utils.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Mutator is the father class of all the commands/mutations.  
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class Mutator implements Cloneable, ObjectEmitter{
	
	/**
	 * Loaded model
	 */
	private Resource model;
	
	/**
	 * Loaded model
	 */
	private List<Resource> models;	
	/**
	 * Loades metamodel
	 */
	private List<EPackage> metaModel;
	
	/**
	 * Mutator identifier
	 */
	private String id;
	
	/**
	 * Mutator type
	 */
	private String type;
	
	/**
	 * @param model
	 * @param mtaModel
	 * Normal constructor
	 */
	public Mutator(Resource model, List<EPackage> metaModel, String type){
		this.metaModel = metaModel;
		this.model = model;
		this.type = type;
	}
	
	/**
	 * @param model
	 * @param mtaModel
	 * Normal constructor
	 */
	public Mutator(List<Resource> models, List<EPackage> metaModel, String type){
		this.metaModel = metaModel;
		this.models = models;
		this.type = type;
	}

	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException {
		return null;
	}

	public Mutator cloneMutator(){
		//The mutators implements Cloneable so it wont happen
		try {
			return (Mutator) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	//GETTERS AND SETTERS
	public EObject getObject(){
		return null;
	}
	public List<EObject> getObjects(){
		return null;
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
	public List<EPackage> getMetaModel() {
		return metaModel;
	}
	public void setMetaModel(ArrayList<EPackage> metaModel) {
		this.metaModel = metaModel;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public EObject getObjectByID(){
		return null;
	}
	public EObject getObjectByURI(){
		return null;
	}
	public List<EObject> getObjectsByIdentification(){
		return null;
	}
	public EObject getRemovedObject() {
		return null;
	}
	
	public EClass getEType() {
		return null;
	}
	
	public EClass getNewEType() {
		return null;
	}
	//END GETTERS AND SETTERS

}
