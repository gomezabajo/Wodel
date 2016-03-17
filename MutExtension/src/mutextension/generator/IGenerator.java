package mutextension.generator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IGenerator extends IExecutableExtension {
	
	public String getName();
	
	public boolean doGenerate(String fileName, IProject project, IFolder srcPath, IFolder configPath, IProgressMonitor monitor);
	
	public void doRun(IFile file);
}
