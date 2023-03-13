package wodel.utils.commands.strategies;

/**
 * @author Juan de Lara
 * IntegerConfigurationStrategy configures the int attributes
 */
public class SpecificIntegerConfigurationStrategy extends IntegerConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	public SpecificIntegerConfigurationStrategy(int value){
		super("");
		this.value = value;		
	}
	public SpecificIntegerConfigurationStrategy(int value, String a2m){
		super(value, a2m);
	}
}
