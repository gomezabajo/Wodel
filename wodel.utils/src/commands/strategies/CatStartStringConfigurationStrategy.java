package commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CatStartStringConfigurationStrategy concatenates a string
 * at the start of the given one
 *  
 */

public class CatStartStringConfigurationStrategy extends StringConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	public CatStartStringConfigurationStrategy(String value, String a2m){
		super(a2m);
		this.value = value;
	}
	
	public String getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				String str = value + (String) (o.eGet(a));
				return str;
			}
		}		
		return "";
	}
}
