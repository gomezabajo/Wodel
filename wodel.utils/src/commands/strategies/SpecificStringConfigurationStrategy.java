package commands.strategies;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificStringConfigurationStrategy configures the String attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class SpecificStringConfigurationStrategy extends StringConfigurationStrategy{
	
	public SpecificStringConfigurationStrategy(String value){
		super("");
		this.value = value;
	}
	public SpecificStringConfigurationStrategy(String value, String a2m){
		super(value, a2m);
	}
}
