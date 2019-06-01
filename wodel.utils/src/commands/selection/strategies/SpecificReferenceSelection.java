package commands.selection.strategies;

import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificReferenceSelection selects an specific reference
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class SpecificReferenceSelection extends SpecificSelection{
	
	private EObject oe;
	private String refType;
	
	public SpecificReferenceSelection(List<EPackage> metaModel, Resource model, String refType, EObject oe){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}

	public SpecificReferenceSelection(List<EPackage> metaModel, List<Resource> models, String refType, EObject oe){
		super(metaModel, models);
		this.oe = oe;
		this.refType = refType;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if(oe == null) return null;
		return ModelManager.getReferenceByName(refType, oe);
	}
}
