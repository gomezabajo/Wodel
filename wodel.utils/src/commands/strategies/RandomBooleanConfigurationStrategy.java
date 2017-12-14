package commands.strategies;

import manager.ModelManager;

/**
 * @author Juan de Lara
 * BooleanConfigurationStrategy configures the boolean attributes
 */
public class RandomBooleanConfigurationStrategy extends BooleanConfigurationStrategy {
	
	public RandomBooleanConfigurationStrategy(){
		super("");
		this.value = ModelManager.rn.nextBoolean();
		// TO-DO: consider null
	}
	public RandomBooleanConfigurationStrategy(String a2m){
		super(a2m);
		this.value = ModelManager.rn.nextBoolean();
		// TO-DO: consider null
	}
}
