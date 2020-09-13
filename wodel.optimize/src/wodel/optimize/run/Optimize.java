package wodel.optimize.run;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExecutableExtension;

public abstract class Optimize implements IExecutableExtension {

	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean doOptimize(IProject project);
}
