package commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomSelection selects a random object
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class RandomSelection extends ObSelectionStrategy{

	/**
	 * @param metaModel
	 * @param model
	 * Normal constructor
	 */
	public RandomSelection(List<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
