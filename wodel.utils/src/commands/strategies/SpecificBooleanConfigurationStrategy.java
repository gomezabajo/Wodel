package commands.strategies;

/**
 * @author Victor Lopez Rivero
 * BooleanConfigurationStrategy configures the boolean attributes
 */
public class SpecificBooleanConfigurationStrategy extends BooleanConfigurationStrategy {
	
/**
	 * @param value
	 * Normal constructor
	 */
	public SpecificBooleanConfigurationStrategy(boolean value){
		super("");
		this.value = value;		
	}
	
	public SpecificBooleanConfigurationStrategy(String a2m, boolean value){
		super(a2m);
		this.value = value;		
	}
}
