package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * LowerStringConfigurationStrategy configures the string to lower case
 * 
 */

public class LowerStringConfigurationStrategy extends StringConfigurationStrategy {

	public LowerStringConfigurationStrategy(String a2m){
		super(a2m);
		this.value = "";
	}
	
	public String getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				String str = (String) (o.eGet(a));
				return str.toLowerCase();
			}
		}		
		return "";
	}	
}
