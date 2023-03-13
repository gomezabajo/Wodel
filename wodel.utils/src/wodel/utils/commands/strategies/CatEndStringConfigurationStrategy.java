package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CatEndStringConfigurationStrategy concatenates a string
 * at the end of the given one
 *  
 */

public class CatEndStringConfigurationStrategy extends StringConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	public CatEndStringConfigurationStrategy(String value, String a2m){
		super(a2m);
		this.value = value;
	}
	
	public String getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				String str = (String) (o.eGet(a)) + value;
				return str;
			}
		}		
		return "";
	}	
}
