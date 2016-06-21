package mutregistrypostprocessor.run;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

public interface IRegistryPostprocessor extends IExecutableExtension {

	public String getName();
	
	public boolean doProcess(Resource seed, Resource mutant, String filename);

}
