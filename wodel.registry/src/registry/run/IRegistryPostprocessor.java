package registry.run;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo - Wodel registry postprocessing extension point
 * 
 */
public interface IRegistryPostprocessor extends IExecutableExtension {

	public String getName();
	
	public boolean doProcess(Resource seed, Resource mutant, String filename);

}
