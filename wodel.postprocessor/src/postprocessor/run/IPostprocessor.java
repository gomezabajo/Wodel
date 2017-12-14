package postprocessor.run;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo - Wodel mutants postprocessing extension point
 * 
 */

public interface IPostprocessor extends IExecutableExtension {

	public String getName();
	
	public boolean doProcess(Resource model, String filename);

}
