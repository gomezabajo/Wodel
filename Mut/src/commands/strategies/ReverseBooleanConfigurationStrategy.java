package commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez
 * ReverseBooleanConfigurationStrategy configures the boolean attributes
 */
public class ReverseBooleanConfigurationStrategy extends BooleanConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	public ReverseBooleanConfigurationStrategy(String a2m) {
		super(a2m);
		System.out.println("this.value=" + this.value);
		System.out.println("this.getValue()=" + this.getValue());
		this.value = !this.value;
		// TO-DO: consider null
	}
	
	public Boolean getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				return ! (Boolean)(o.eGet(a));		
			}
		}		
		return true;
	}	
	
}
