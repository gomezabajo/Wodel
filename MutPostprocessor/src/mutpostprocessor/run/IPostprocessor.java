package mutpostprocessor.run;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

public interface IPostprocessor extends IExecutableExtension {

	public String getName();
	
	public boolean doProcess(Resource model, String filename);

}
