package wodel.syntactic.comparison.run;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Comparison equivalence extension point
 * 
 */

public abstract class SyntacticComparison implements IExecutableExtension {
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}
	
	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean doCompare(String metamodel, String model1, String model2, IProject project, Class<?> cls);
}
