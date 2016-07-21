package commands.strategies;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Victor Lopez Rivero
 * AttributeConfigurationStrategy is the father of all the attributes configuration
 */
public abstract class AttributeConfigurationStrategy {

	protected String attribute2mutate;
	
	public AttributeConfigurationStrategy(String a2m) {
		this.attribute2mutate = a2m;
	}
	
	public abstract boolean sameType(EClassifier c);
	
	public Object getValue(){
		return null;
	}
	
	public Object getValue(EObject o){
		return null;
	}	
}
