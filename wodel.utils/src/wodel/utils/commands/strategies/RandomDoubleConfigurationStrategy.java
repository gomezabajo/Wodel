package wodel.utils.commands.strategies;

import wodel.utils.manager.MutatorUtils;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DoubleConfigurationStrategy configures the Double attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class RandomDoubleConfigurationStrategy extends DoubleConfigurationStrategy {
	
	public RandomDoubleConfigurationStrategy(double min, double max, boolean allowsNul){
		super("");
		this.value = MutatorUtils.getRandomDouble(min, max);
	}

	public RandomDoubleConfigurationStrategy(double min, double max, boolean allowsNul, String a2m){
		super(a2m);
		this.value = MutatorUtils.getRandomDouble(min, max);
	}
}
