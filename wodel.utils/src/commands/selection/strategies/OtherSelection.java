package commands.selection.strategies;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

public abstract class OtherSelection extends ObSelectionStrategy {
	
	public OtherSelection(ArrayList<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
