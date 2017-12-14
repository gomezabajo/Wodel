package commands.strategies;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ReferenceConfigurationStrategy reference configuration father class
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

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
	
	public boolean isRemoval() {
		return false;
	}
}
