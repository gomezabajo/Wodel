package commands.strategies;

import org.eclipse.emf.ecore.EObject;

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
