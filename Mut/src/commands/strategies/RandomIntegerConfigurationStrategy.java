package commands.strategies;

import manager.ModelManager;

/**
 * @author Victor Lopez Rivero
 * IntegerConfigurationStrategy configures the int attributes
 */
public class RandomIntegerConfigurationStrategy extends IntegerConfigurationStrategy {
		
	/**
	 * @param value
	 * Normal constructor
	 */
 	public RandomIntegerConfigurationStrategy(int min, int max, boolean allowsNull) {
		super("");
		if (min == 0 && max == 0) {
			this.value = 0;
		}
		else {
			this.value = ModelManager.rn.nextInt(max-min)+min;
		}
		// TO-DO: consider allowsNull
	}
 	
 	public RandomIntegerConfigurationStrategy(int min, int max, boolean allowsNull, String a2m) {
		super(a2m);
		if (min == 0 && max == 0) {
			this.value = 0;
		}
		else {
			this.value = ModelManager.rn.nextInt(max-min)+min;
		}
		// TO-DO: consider allowsNull
	}
}
