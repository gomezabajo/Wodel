package wodel.utils.commands.strategies;

import java.util.List;
import java.util.ArrayList;

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

public class RandomStringNumberConfigurationStrategy extends StringConfigurationStrategy {
	
	private List<Double> skipValues;
	private int min;
	private int max;
	
	/**
	 * @param value
	 * Normal constructor
	 */
	public RandomStringNumberConfigurationStrategy(int min, int max, boolean allowsNull){
		super("");
		this.min = min;
		this.max = max;
		this.skipValues = new ArrayList<Double>();
		this.value = String.format("%d", MutatorUtils.getRandomInt(min, max));
	}

	public RandomStringNumberConfigurationStrategy(int min, int max, boolean allowsNull, List<Double> skipValues){
		super("");
		this.min = min;
		this.max = max;
		this.skipValues = new ArrayList<Double>();
		this.skipValues.addAll(skipValues);
		this.value = String.format("%d", MutatorUtils.getRandomInt(min, max, skipValues));
	}

	public RandomStringNumberConfigurationStrategy(int min, int max, boolean allowsNull, String a2m){
		super(a2m);
		this.min = min;
		this.max = max;
		this.skipValues = new ArrayList<Double>();
		this.value = String.format("%d", MutatorUtils.getRandomInt(min, max));
	}

	public RandomStringNumberConfigurationStrategy(int min, int max, boolean allowsNull, String a2m, List<Double> skipValues){
		super(a2m);
		this.min = min;
		this.max = max;
		this.skipValues = new ArrayList<Double>();
		this.skipValues.addAll(skipValues);
		this.value = String.format("%d", MutatorUtils.getRandomInt(min, max, skipValues));
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
}
