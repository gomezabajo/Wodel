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
public class SpecificReferenceSelection extends SpecificSelection{
	
	private ObjectEmitter oe;
	private String refType;
	
	public SpecificReferenceSelection(ArrayList<EPackage> metaModel, Resource model, String refType, ObjectEmitter oe){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if(oe == null) return null;
		return ModelManager.getReferenceByName(refType, oe.getObject());
	}
}
