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
		if (min == 0.0 && max == 0.0) {
			this.value = 0.0;
		}
		int minInt = (int) Math.floor(min * 100);
		int maxInt = (int) Math.floor(max * 100);
		int rn = ModelManager.rn.nextInt(maxInt - minInt) + minInt;
		this.value = rn / 100.0;
		//this.value = ModelManager.rn.nextDouble()*(max-min)+min;
		// TO-DO: Consider allowsNull
	}

	public RandomDoubleConfigurationStrategy(double min, double max, boolean allowsNul, String a2m){
		super(a2m);
		if (min == 0.0 && max == 0.0) {
			this.value = 0.0;
		}
		int minInt = (int) Math.floor(min * 100);
		int maxInt = (int) Math.floor(max * 100);
		int rn = ModelManager.rn.nextInt(maxInt - minInt) + minInt;
		this.value = rn / 100.0;
		//this.value = ModelManager.rn.nextDouble()*(max-min)+min;
		// TO-DO: Consider allowsNull
	}
}
