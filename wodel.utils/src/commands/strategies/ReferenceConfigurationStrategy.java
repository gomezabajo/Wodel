package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public abstract class ReferenceConfigurationStrategy {
	protected String reference2mutate;
	
	public ReferenceConfigurationStrategy(String a2m) {
		this.reference2mutate = a2m;
	}
	
	public abstract boolean sameType();
	
	public Object getValue(){
		return null;
	}
	
	public Object getValue(EObject o){
		return null;
	}	
}
