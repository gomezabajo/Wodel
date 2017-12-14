package commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author Pablo Gomez-Abajo
 * 
 * OtherSelection selects a different object with the same
 * type of the given object
 *  
 */

public abstract class OtherSelection extends ObSelectionStrategy {
	
	public OtherSelection(List<EPackage> metaModel, Resource model) {
		super(metaModel, model);
	}
}
