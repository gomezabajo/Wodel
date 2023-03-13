package wodel.syntactic.validation.run;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Syntactic validation extension point
 * 
 */

public abstract class SyntacticValidation implements IExecutableExtension {

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
	}

	public abstract String getName();

	public abstract String getURI();
	
	public abstract boolean isValid(String metamodel, String uri, Class<?> cls);
}
