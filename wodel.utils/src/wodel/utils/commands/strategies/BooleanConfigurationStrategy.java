package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * BooleanConfigurationStrategy configures the boolean attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class BooleanConfigurationStrategy extends AttributeConfigurationStrategy {
	
	/**
	 * Attribute value
	 */
	protected boolean value;
	
	public BooleanConfigurationStrategy(String a2m) {
		super(a2m);
	}
	
	@Override
	public boolean sameType(EClassifier c) {
		if(c.getInstanceClassName().equals("boolean") || c.getInstanceClassName().equals("java.lang.Boolean")) return true;
		return false;
	}
	
	public Boolean getValue(){
		return value;
	}
	
	public Boolean getValue(EObject o){
		return value;
	}	
}
