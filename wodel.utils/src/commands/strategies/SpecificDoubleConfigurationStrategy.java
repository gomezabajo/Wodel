package commands.strategies;

/**
 * @author Victor Lopez Rivero
 * DoubleConfigurationStrategy configures the Double attributes
 */
public class SpecificDoubleConfigurationStrategy extends DoubleConfigurationStrategy {
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public SpecificDoubleConfigurationStrategy(Double value){
		super("");
		this.value = value;		
	}
	public SpecificDoubleConfigurationStrategy(Double value, String a2m){
		super(value, a2m);
	}
}
