package wodel.validation;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo - Model validation extension point
 * 
 */

public abstract class Validation implements IExecutableExtension {
	
	public abstract String getName();
	
	public abstract boolean isValid(Resource model);
}
