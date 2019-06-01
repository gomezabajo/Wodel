package comparison.run;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Comparison equivalence extension point
 * 
 */

public abstract class Comparison implements IExecutableExtension {
	
	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean doCompare(String metamodel, String model1, String model2, IProject project);
}
