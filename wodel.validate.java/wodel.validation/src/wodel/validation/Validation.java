package wodel.validation;

import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Model validation extension point
 * 
 */

public abstract class Validation implements IExecutableExtension {
	
	public abstract String getName();
	
	public abstract boolean isValid(String metamodel, String uri);
}
