	package commands;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.AbstractCreationException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Victor Lopez Rivero
 * Mutator is the father class of all the commands/mutations.  
 */
public abstract class Mutator implements Cloneable, ObjectEmitter{
	
	/**
	 * Loaded model
	 */
	private Resource model;	
	/**
	 * Loades metamodel
	 */
	private ArrayList<EPackage> metaModel;
	
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
	public Mutator(Resource model, ArrayList<EPackage> metaModel, String type){
		this.metaModel = metaModel;
		this.model = model;
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
	public Resource getModel() {
		return model;
	}
	public void setModel(Resource model) {
		this.model = model;
	}
	public ArrayList<EPackage> getMetaModel() {
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
	//END GETTERS AND SETTERS

}
