package commands.strategies;

import manager.ModelManager;

/**
 * @author Victor Lopez Rivero
 * DoubleConfigurationStrategy configures the Double attributes
 */
public class RandomDoubleConfigurationStrategy extends DoubleConfigurationStrategy {
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public RandomDoubleConfigurationStrategy(double min, double max, boolean allowsNul){
		super("");
		this.value = ModelManager.rn.nextDouble()*(max-min)+min;
		// TO-DO: Consider allowsNull
	}

	public RandomDoubleConfigurationStrategy(double min, double max, boolean allowsNul, String a2m){
		super(a2m);
		this.value = ModelManager.rn.nextDouble()*(max-min)+min;
		// TO-DO: Consider allowsNull
	}
}
