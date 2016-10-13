package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
	
	private String refType;
	
	
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

	public SpecificObjectSelection(ArrayList<EPackage> metaModel, Resource model, EObject obj, String refType){
		super(metaModel, model);
		this.obj = obj;
		this.refType = refType;
	}
	
	public SpecificObjectSelection(ArrayList<EPackage> metaModel, Resource model, ObjectEmitter oe, String refType){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}


	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if(obj!=null) {
			if (this.refType != null) {
				for (EReference ref : obj.eClass().getEAllReferences()) {
					if (ref.getName().equals(this.refType)) {
						return (EObject) obj.eGet(ref);
					}
				}
			}
			else {
				return this.obj;
			}
		}
		if(oe != null) {
			if (this.refType != null) {
				for (EReference ref : oe.getObject().eClass().getEAllReferences()) {
					if (ref.getName().equals(this.refType)) {
						return (EObject) oe.getObject().eGet(ref);
					}
				}
			}
		}
		else {
			return null;
		}
		return null;
	}
}
