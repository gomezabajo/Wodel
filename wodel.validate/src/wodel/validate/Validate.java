package wodel.validate;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Validate extension point
 * 
 */

public abstract class Validate implements IExecutableExtension {
	
	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean isValid(String metamodel, String seed, String model, Class<?> cls, IProject project);
}
