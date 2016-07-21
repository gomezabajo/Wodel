package commands.selection.strategies;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

public abstract class CompleteSelection extends ObSelectionStrategy {

	public CompleteSelection(ArrayList<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
