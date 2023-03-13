package wodel.utils.commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * StringConfigurationStrategy configures the String attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public abstract class StringConfigurationStrategy extends AttributeConfigurationStrategy{
	
	/**
	 * Attribute value
	 */
	protected String value;
	
	public StringConfigurationStrategy(String a2m) {
		super(a2m);
	}

	public StringConfigurationStrategy(String value, String a2m) {
		super(a2m);
		this.value = value;
	}
	
	@Override
	public boolean sameType(EClassifier c) {
		if (c.getInstanceClass()== value.getClass()) {
			return true;
		}
		return false;
	}
	
	public String getValue(){
		return value;
	}
	public String getValue(EObject o){
		return value;
	}
}
