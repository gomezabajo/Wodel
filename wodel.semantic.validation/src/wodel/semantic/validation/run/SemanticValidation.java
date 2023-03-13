package wodel.semantic.validation.run;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Semantic validation extension point
 * 
 */

public abstract class SemanticValidation implements IExecutableExtension {
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	
	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean isValid(String metamodel, String seed, String model, Class<?> cls, IProject project);
}
