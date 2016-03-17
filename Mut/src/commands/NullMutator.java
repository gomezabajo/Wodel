package commands;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * NullMutator does nothing. But it is helpful that it saves something in its result attribute.  
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
	public NullMutator(Resource model, ArrayList<EPackage> metaModel, ObSelectionStrategy object) {
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
