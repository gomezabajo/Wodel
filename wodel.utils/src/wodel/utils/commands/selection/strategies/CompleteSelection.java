package wodel.utils.commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CompleteSelection selects all objects that match the given parameters
 *  
 */

public abstract class CompleteSelection extends ObSelectionStrategy {

	public CompleteSelection(List<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
