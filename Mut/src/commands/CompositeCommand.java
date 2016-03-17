package commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.AbstractCreationException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Victor Lopez Rivero
 * CompositeClass gathers commands to execute them together and then
 * create different actions over the model.
 */
public class CompositeCommand extends Mutator{

	/**
	 * Here we attach the added commands
	 */
	private ArrayList<Mutator> commands;
	
	/**
	 * Constructor. initializes the ArrayLists
	 */
	public CompositeCommand(Resource model, ArrayList<EPackage> metaModel) {
		super(model, metaModel, "Composite");
		commands = new ArrayList<Mutator>();
		
	}
	
	/**
	 * @return ArrayList<Command> Attached commands
	 */
	public ArrayList<Mutator> getCommands(){
		return commands;
	}
	
	
	/**
	 * @param c Command to add
	 */
	public void addCommand(Mutator c){
		commands.add(c);
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException {
		List<Object> muts = null;
		//For each command
		for(Mutator c : commands) {
			if (muts == null) {
				muts = new ArrayList<Object>();
			}
			muts.add(c.mutate());
		}
		return muts;
	}
}
