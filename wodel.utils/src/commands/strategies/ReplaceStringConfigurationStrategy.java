package commands.strategies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class ReplaceStringConfigurationStrategy extends
		StringConfigurationStrategy {

	protected String oldstring;
	protected String newstring;
	
	public ReplaceStringConfigurationStrategy(String a2m, String oldstring, String newstring){
		super(a2m);
		this.value = "";
		this.oldstring = oldstring;
		this.newstring = newstring;
	}

	public String getValue(EObject o){
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(this.attribute2mutate)) {
				String str = (String) (o.eGet(a));
				return str.replace(oldstring, newstring);
			}
		}		
		return "";
	}	
}
