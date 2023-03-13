package wodel.utils.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * NullMutator does nothing. But it is helpful that it saves
 * something in its result attribute.  
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class NullMutator extends Mutator{
	
	/**
	 * Saves the target of the null operation
	 */
	private EObject result;
	/**
	 * Select an object
	 */
	private ObSelectionStrategy object;
	
	/**
	 * @param model
	 * @param metaModel
	 * @param object
	 * Normal constructor
	 */
	public NullMutator(Resource model, List<EPackage> metaModel, ObSelectionStrategy object) {
		super(model, metaModel, "Null");
		this.object = object;
	}
	
	@Override
	public Object mutate() throws ReferenceNonExistingException{
		if (object == null) {
			return null;
		}
		result = object.getObject();
		return this.result;
	}
}
