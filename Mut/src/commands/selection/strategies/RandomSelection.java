package commands.selection.strategies;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Victor Lopez Rivero
 * RandomSelection selects a random object
 */
public abstract class RandomSelection extends ObSelectionStrategy{

	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public RandomSelection(ArrayList<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
