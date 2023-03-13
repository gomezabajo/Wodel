package wodel.utils.commands.strategies;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DoubleConfigurationStrategy specific double configuration
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
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
