package wodel.extension.generator;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Pablo Gomez-Abajo - Wodel postprocessing application extension point
 * 
 */

public interface IGenerator extends IExecutableExtension {
	
	public String getName();
	
	public List<String> requiredBundles();
	
	public boolean doGenerate(String fileName,
			String metamodel, String project,
			String outputPath, IProject mutProject,
			IFolder srcPath, IFolder configPath,
			IProgressMonitor monitor);
	
	public void doRun(IFile file);
}
