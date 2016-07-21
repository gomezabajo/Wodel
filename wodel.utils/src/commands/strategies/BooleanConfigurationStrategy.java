package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Victor Lopez Rivero
 * BooleanConfigurationStrategy configures the boolean attributes
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
		if(c.getInstanceClassName().equals("boolean")) return true;
		return false;
	}
	
	public Boolean getValue(){
		return value;
	}
	
	public Boolean getValue(EObject o){
		return value;
	}	
}
