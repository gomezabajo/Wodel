package commands.strategies;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public class ListStringConfigurationStrategy extends AttributeConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	protected String value;
	
	public ListStringConfigurationStrategy(String value, String a2m){
		super(a2m);
		this.value = value;
	}
	
	public String getValue(EObject o){
		if (value != null) {
            value = value.substring(1, value.length() -1); 
            String[] values = value.split(",");
            int index = ModelManager.rn.nextInt()%(values.length - 1);
            if (index < 0) index = index*-1;
            if (index < values.length) {
            	return values[index].trim();
            }
		}
		return "";
	}

	@Override
	public boolean sameType(EClassifier c) {
		if(c.getInstanceClass() == value.getClass()) {
			return true;
		}
		return false;
	}	
}
