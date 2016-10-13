package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sun.org.apache.xerces.internal.util.URI;

import commands.ObjectEmitter;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * SpecificSelection selects an specific object
 */
public class SpecificReferenceSelection extends SpecificSelection{
	
	private EObject oe;
	private String refType;
	
	public SpecificReferenceSelection(ArrayList<EPackage> metaModel, Resource model, String refType, EObject oe){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if(oe == null) return null;
		return ModelManager.getReferenceByName(refType, oe);
	}
}
