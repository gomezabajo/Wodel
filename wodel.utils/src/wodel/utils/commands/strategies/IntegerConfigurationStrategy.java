package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IntegerConfigurationStrategy configures the int attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class IntegerConfigurationStrategy extends AttributeConfigurationStrategy {
	
	/**
	 * Attribute value
	 */
	protected Integer value;
	
	public IntegerConfigurationStrategy(String a2m) {
		super(a2m);
	}
	
	public IntegerConfigurationStrategy(Integer value, String a2m) {
		super(a2m);
		this.value = value;
	}
	
	@Override
	public boolean sameType(EClassifier c) {
		if(c.getInstanceClassName().equals("int") || c.getInstanceClassName().equals("java.lang.Integer")) return true;
		return false;
	}
	
	public Integer getValue(){
		return value;
	}
	public Integer getValue(EObject o){
		return value;
	}
}
