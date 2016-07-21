package commands.log;

import java.util.ArrayList;

import commands.Mutator;

/**
 * @author Victor Lopez Rivero
 * CommandLog Storage for commands
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
