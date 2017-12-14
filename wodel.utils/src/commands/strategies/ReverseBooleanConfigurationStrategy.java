package commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ReverseBooleanConfigurationStrategy configures the boolean attributes
 * 
 */
public class ReverseBooleanConfigurationStrategy extends BooleanConfigurationStrategy {
	public ReverseBooleanConfigurationStrategy(String a2m) {
		super(a2m);
		this.value = !this.value;
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
