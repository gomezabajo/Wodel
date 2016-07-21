package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Victor Lopez Rivero
 * IntegerConfigurationStrategy configures the int attributes
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
		if(c.getInstanceClassName().equals("int")) return true;
		return false;
	}
	
	public Integer getValue(){
		return value;
	}
	public Integer getValue(EObject o){
		return value;
	}
}
