package commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class LowerStringConfigurationStrategy extends StringConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	public LowerStringConfigurationStrategy(String a2m){
		super(a2m);
		this.value = "";
	}
	
	public String getValue(EObject o){
		int i = 0;
		System.out.println("attribute2mutate: " + this.attribute2mutate);
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			System.out.println("atributo " + (i++) + ": " + a.getName());
			if (a.getName().equals(this.attribute2mutate)) {
				String str = (String) (o.eGet(a));
				return str.toLowerCase();
			}
		}		
		return "";
	}	
}
