package commands.strategies;

import java.util.ArrayList;
import java.util.Arrays;

import manager.ModelManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ListStringConfigurationStrategy extends AttributeConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	protected String value;
	
	protected String att;
	
	protected String oldValue;
	
	public ListStringConfigurationStrategy(String value, String a2m){
		super(a2m);
		this.att = a2m;
		this.value = value;
	}
	
	public ListStringConfigurationStrategy(String oldValue, String value, String a2m){
		super(a2m);
		this.att = a2m;
		this.oldValue = oldValue;
		this.value = value;
	}

	public String getValue(EObject o){
		if (value != null) {
            value = value.trim().replaceAll("'", "").replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", ""); 
            String[] values = value.split(",");
            ArrayList<String> vals = new ArrayList<String>();
            if (oldValue != null) {
            	for (String v : values) {
           			if (!v.equals(oldValue)) {
           				vals.add(v);
            		}
            	}
            }
            else {
            	vals.addAll(Arrays.asList(values));
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
		System.out.println("Classifier: " + c);
		System.out.println("value: " + value);
		if(c.getInstanceClass() == value.getClass()) {
			return true;
		}
		return false;
	}	
}
