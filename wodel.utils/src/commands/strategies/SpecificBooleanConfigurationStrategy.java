package commands.strategies;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificBooleanConfigurationStrategy specific boolean configuration
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class SpecificBooleanConfigurationStrategy extends BooleanConfigurationStrategy {
	
	public SpecificBooleanConfigurationStrategy(boolean value){
		super("");
		this.value = value;		
	}
	
	public SpecificBooleanConfigurationStrategy(String a2m, boolean value){
		super(a2m);
		this.value = value;		
	}
}
