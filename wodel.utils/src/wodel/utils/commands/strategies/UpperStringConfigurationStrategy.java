package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * UpperStringConfigurationStrategy configures the string to upper case
 * 
 */

public class UpperStringConfigurationStrategy extends StringConfigurationStrategy {

	public UpperStringConfigurationStrategy(String a2m){
		super(a2m);
		this.value = "";
	}
	
	public String getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				String str = (String) (o.eGet(a));
				return str.toUpperCase();
			}
		}		
		return "";
	}	
}
