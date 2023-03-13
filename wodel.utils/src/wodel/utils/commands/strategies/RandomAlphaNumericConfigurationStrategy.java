package wodel.utils.commands.strategies;

import wodel.utils.manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomAlphaNumericConfigurationStrategy configures the String attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RandomAlphaNumericConfigurationStrategy extends RandomStringConfigurationStrategy{
	
	public RandomAlphaNumericConfigurationStrategy(int min, int max, boolean allowsNull, boolean firstUpperCase, boolean firstLowerCase, boolean allUpperCase, boolean allLowerCase){
		super(min, max, allowsNull);
		final char [] alphaNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
								  '_',
								  'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
								  'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
		int size = ModelManager.rn.nextInt(max-min)+min;
	
		int 	lower  = 11,
				upper  = 37;
		
		this.value = "";
		char    newchar;
		
		if (firstUpperCase) {
			newchar = alphaNum[ModelManager.rn.nextInt(25)+upper];
		} else if (firstLowerCase) {
			newchar = alphaNum[ModelManager.rn.nextInt(25)+lower];
		} else {
			newchar = alphaNum[ModelManager.rn.nextInt(alphaNum.length)];
		}
		this.value = this.value + newchar;
		
		for (int i=1; i<size; i++) {
			if (allUpperCase)
				newchar = alphaNum[ModelManager.rn.nextInt(25)+upper];
			else if (allLowerCase) 
				newchar = alphaNum[ModelManager.rn.nextInt(25)+lower];
			else newchar = alphaNum[ModelManager.rn.nextInt(alphaNum.length)];
			this.value = this.value + newchar;
		}		
	}
	public RandomAlphaNumericConfigurationStrategy(int min, int max, boolean allowsNull, boolean firstUpperCase, boolean firstLowerCase, boolean allUpperCase, boolean allLowerCase, String a2m){
		super(min, max, allowsNull, a2m);
		final char [] alphaNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
								  '_',
								  'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
								  'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
		int size = ModelManager.rn.nextInt(max-min)+min;
	
		int 	lower  = 11,
				upper  = 37;
		
		this.value = "";
		char    newchar;
		
		if (firstUpperCase) {
			newchar = alphaNum[ModelManager.rn.nextInt(25)+upper];
		} else if (firstLowerCase) {
			newchar = alphaNum[ModelManager.rn.nextInt(25)+lower];
		} else {
			newchar = alphaNum[ModelManager.rn.nextInt(alphaNum.length)];
		}
		this.value = this.value + newchar;
		
		for (int i=1; i<size; i++) {
			if (allUpperCase)
				newchar = alphaNum[ModelManager.rn.nextInt(25)+upper];
			else if (allLowerCase) 
				newchar = alphaNum[ModelManager.rn.nextInt(25)+lower];
			else newchar = alphaNum[ModelManager.rn.nextInt(alphaNum.length)];
			this.value = this.value + newchar;
		}		
	}
}
