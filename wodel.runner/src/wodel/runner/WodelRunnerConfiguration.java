package wodel.runner;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Wodel external execution configuration extension point
 * 
 */

public abstract class WodelRunnerConfiguration implements IExecutableExtension {
	
	public abstract String getInputPath();
	
	public abstract String getOutputPath();

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

}