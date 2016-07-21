package commands.strategies;

/**
 * @author Victor Lopez Rivero
 * StringConfigurationStrategy configures the String attributes
 */
public class SpecificStringConfigurationStrategy extends StringConfigurationStrategy{
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public SpecificStringConfigurationStrategy(String value){
		super("");
		this.value = value;
	}
	public SpecificStringConfigurationStrategy(String value, String a2m){
		super(value, a2m);
	}
}
