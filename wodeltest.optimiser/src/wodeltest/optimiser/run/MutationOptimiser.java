package wodeltest.optimiser.run;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

public abstract class MutationOptimiser implements IExecutableExtension {

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub

	}
	
	public abstract String getName();
		
	public abstract String getURI();

	public abstract boolean doOptimise(IProject project);

}
