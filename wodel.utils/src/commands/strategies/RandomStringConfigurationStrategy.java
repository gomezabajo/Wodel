package commands.strategies;

import manager.ModelManager;

/**
 * @author Victor Lopez Rivero
 * StringConfigurationStrategy configures the String attributes
 */
public class RandomStringConfigurationStrategy extends StringConfigurationStrategy{
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public RandomStringConfigurationStrategy(int min, int max, boolean allowsNull){
		super("");
		int size = ModelManager.rn.nextInt(max-min)+min;
		this.value = "";
		for (int i=0; i<size; i++) {
			int newchar = ModelManager.rn.nextInt(94)+32;
			while (!Character.isLetter(newchar)) {
				newchar = ModelManager.rn.nextInt(94)+32;
			}
			this.value = this.value + String.valueOf((char)newchar);
		}		
	}

	public RandomStringConfigurationStrategy(int min, int max, boolean allowsNull, String a2m){
		super(a2m);
		int size = ModelManager.rn.nextInt(max-min)+min;
		this.value = "";
		for (int i=0; i<size; i++) {
			int newchar = ModelManager.rn.nextInt(94)+32;
			while (!Character.isLetter(newchar)) {
				newchar = ModelManager.rn.nextInt(94)+32;
			}
			this.value = this.value + String.valueOf((char)newchar);
		}		
	}
}
