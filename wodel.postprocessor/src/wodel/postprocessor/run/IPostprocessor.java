package wodel.postprocessor.run;

import java.util.List;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo - Wodel mutants postprocessing extension point
 * 
 */

public interface IPostprocessor extends IExecutableExtension {

	public String getName();

	public abstract String getURI();
	
	public boolean doProcess(String metamodelpath, List<String> metamodel, Resource model, String filename);

}
