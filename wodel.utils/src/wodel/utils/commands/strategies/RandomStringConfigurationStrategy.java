package wodel.utils.commands.strategies;

import wodel.utils.manager.MutatorUtils;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomStringConfigurationStrategy random string configuration
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RandomStringConfigurationStrategy extends StringConfigurationStrategy{
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public RandomStringConfigurationStrategy(int min, int max, boolean allowsNull){
		super("");
		this.value = MutatorUtils.getRandomString(min, max);
	}

	public RandomStringConfigurationStrategy(int min, int max, boolean allowsNull, String a2m){
		super(a2m);
		this.value = MutatorUtils.getRandomString(min, max);
	}
}
