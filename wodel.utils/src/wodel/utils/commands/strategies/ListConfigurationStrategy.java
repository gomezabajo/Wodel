package wodel.utils.commands.strategies;

import java.util.ArrayList;
import java.util.Arrays;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ListConfigurationStrategy configures the eenum literal list attribute
 * 
 */

public class ListConfigurationStrategy extends AttributeConfigurationStrategy {

	protected String value;
	
	protected String att;
	
	protected EObject oldValue;
	
	public ListConfigurationStrategy(String value, String a2m){
		super(a2m);
		this.att = a2m;
		this.value = value;
	}
	
	public ListConfigurationStrategy(EObject oldValue, String value, String a2m){
		super(a2m);
		this.att = a2m;
		this.oldValue = oldValue;
		this.value = value;
	}

	public String getValue(EObject o){
		if (value != null) {
            value = value.trim().replaceAll("'", "").replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", ""); 
            String[] values = value.split(",");
            for (int i = 0; i < values.length; i++) {
            	values[i] = values[i].trim();
            }
            ArrayList<String> vals = new ArrayList<String>();
            if (oldValue != null) {
           		if (oldValue instanceof EEnumLiteral) {
           			for (String v : values) {
           				EEnumLiteral lit = (EEnumLiteral) oldValue;
           				if (!v.equals(lit.getLiteral())) {
           					vals.add(v);
           				}
           			}
           		}
            }
            else {
            	vals.addAll(Arrays.asList(values));
            }
            if (vals.size() == 0) {
            	return "";
            }
            if (vals.size() == 1) {
            	return vals.get(0);
            }
            int index = ModelManager.rn.nextInt()%(vals.size() - 1);
            if (index < 0) index = index*-1;
            if (index < vals.size()) {
            	return vals.get(index).trim();
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
