package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Victor Lopez Rivero
 * DoubleConfigurationStrategy configures the Double attributes
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
		System.out.println("c.getInstanceClass(): " + c.getInstanceClass() + ", value.getClass(): " + value.getClass());
		//if(c.getInstanceClass() == value.getClass()) return true;
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
