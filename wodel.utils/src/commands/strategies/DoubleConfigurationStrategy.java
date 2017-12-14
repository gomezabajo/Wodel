package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DoubleConfigurationStrategy configures the Double attributes
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public abstract class DoubleConfigurationStrategy extends AttributeConfigurationStrategy {
	
	/**
	 * Attribute value
	 */
	protected Double value;
	
	public DoubleConfigurationStrategy(String a2m) {
		super(a2m);
	}

	public DoubleConfigurationStrategy(Double value, String a2m) {
		super(a2m);
		this.value = value;
	}
	
	@Override
	public boolean sameType(EClassifier c) {
		if (c.getInstanceClassName().toLowerCase().equals(value.getClass().getSimpleName().toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public Double getValue(){
		return value;
	}
	public Double getValue(EObject o){
		return value;
	}
}
