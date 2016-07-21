package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Victor Lopez Rivero
 * StringConfigurationStrategy configures the String attributes
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
		//if(c.getInstanceClass() == value.getClass()) {
		System.out.println("c.getInstanceClass(): " + c.getInstanceClass() + ", value.getClass(): " + value.getClass());
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
