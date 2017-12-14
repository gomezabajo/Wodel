package commands.strategies;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ArithmeticOperationConfigurationStrategy father of all
 * arithmetic operation strategies
 *  
 */

public abstract class ArithmeticOperationConfigurationStrategy extends AttributeConfigurationStrategy {
	
	protected EObject object;
	protected Object value;

	public ArithmeticOperationConfigurationStrategy(String a2m, EObject object, Object value) {
		super(a2m);
		this.object = object;
		this.value = value;
		// TODO Auto-generated constructor stub
	}

}
