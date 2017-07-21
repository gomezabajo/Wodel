package comparation.run;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;


public abstract class Comparation implements IExecutableExtension {
	
	public abstract String getName();

	public abstract boolean doCompare(String metamodel, String model1, String model2);
}
