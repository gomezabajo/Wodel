package commands.log;

import java.util.ArrayList;

import commands.Mutator;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CommandLog Storage for commands
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class CommandLog {
	
	/**
	 * Storaged commands
	 */
	private ArrayList<Mutator> commandLog;
	
	/**
	 * Normal constructor
	 */
	public CommandLog(){
		this.commandLog = new ArrayList<Mutator>();
	}
	
	public void logCommand(Mutator m){
		if(m==null) return;
		
		Mutator aux = m.cloneMutator();
		commandLog.add(aux);
	}

}
