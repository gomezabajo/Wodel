package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import commands.ObjectEmitter;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * SpecificSelection selects an specific object
 */
public class SpecificObjectSelection extends SpecificSelection{
	
	/**
	 * Object to select
	 */
	private EObject obj;
	
	private ObjectEmitter oe;
	
	
	/**
	 * @param metaModel
	 * @param model
	 * @param obj
	 * Normal constructor
	 */
	public SpecificObjectSelection(ArrayList<EPackage> metaModel, Resource model, EObject obj){
		super(metaModel, model);
		this.obj = obj;
	}
	
	public SpecificObjectSelection(ArrayList<EPackage> metaModel, Resource model, ObjectEmitter oe){
		super(metaModel, model);
		this.oe = oe;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {		
		if(obj!=null) return this.obj;
		if(oe == null) return null;
		else return oe.getObject();
	}
}
