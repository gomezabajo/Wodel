package wodel.utils.commands.strategies;

import wodel.utils.manager.MutatorUtils;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomIntegerConfigurationStrategy random int attribute
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RandomIntegerConfigurationStrategy extends IntegerConfigurationStrategy {
		
 	public RandomIntegerConfigurationStrategy(int min, int max, boolean allowsNull) {
		super("");
		this.value = MutatorUtils.getRandomInt(min, max);
	}
 	
 	public RandomIntegerConfigurationStrategy(int min, int max, boolean allowsNull, String a2m) {
		super(a2m);
		this.value = MutatorUtils.getRandomInt(min, max);
	}
}
