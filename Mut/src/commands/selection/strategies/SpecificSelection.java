package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import commands.ObjectEmitter;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * SpecificSelection selects an specific object
 */
public abstract class SpecificSelection extends ObSelectionStrategy{
	
	public SpecificSelection(ArrayList<EPackage> metaModel, Resource model){
		super(metaModel, model);
	}
}
