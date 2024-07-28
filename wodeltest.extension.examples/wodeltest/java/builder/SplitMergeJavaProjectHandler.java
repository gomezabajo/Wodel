package mutator.wodeltest.[@**@].builder;

import java.io.File;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import mutator.wodeltest.[@**@].utils.MergeJavaProject;
import mutator.wodeltest.[@**@].utils.SplitJavaProject;

public class SplitMergeJavaProjectHandler extends AbstractHandler {
	
	private String getTestPath(String srcName, File srcFolder) {
		if (srcFolder == null) {
			return null;
		}
		if (srcFolder.isDirectory()) {
			if (srcFolder.getName().equals("test")) {
				return srcFolder.getPath().replace("\\", "/");
			}
			else {
				File[] srcFiles = srcFolder.listFiles();
				if (srcFiles != null) {
					for (File file : srcFiles) {
						String testPath = getTestPath(srcName, file);
						if (testPath != null) {
							return testPath;
						}
					}
				}
			}
		}
		if (srcFolder.isDirectory()) {
			if (srcFolder.getName().equals(srcName)) {
				return srcFolder.getPath().replace("\\", "/");
			}
		}
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		//
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it
					.hasNext();) {
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IJavaProject) {
					project = ((IJavaProject) element).getProject();
				} else if (element instanceof IAdaptable) {
					project = ((IAdaptable) element).getAdapter(IProject.class);
				}
				if (project != null) {
					try {
						toggleNature(project);
					} catch (CoreException e) {
						//TODO log something
						throw new ExecutionException("Failed to toggle nature",
								e);
					}
				}
			}
			
		}
		return null;
	}
	
	/**
	 * Toggles sample nature on a project
	 *
	 * @param project
	 *            to have sample nature added or removed
	 */
	private void toggleNature(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (WodelTestSplittedJavaProjectNature.NATURE_ID.equals(natures[i])) {
				try {
					if (project.hasNature(WodelTestSplittedJavaProjectNature.NATURE_ID)) {
						IProject testSuiteProject = null;
						IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			            String workspacePath = workspaceRoot.getLocation().toFile().getPath();
			            workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			            File workspaceFolder = new File(workspacePath);
			            if (workspaceFolder.listFiles() != null) {
				            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
				                if (workspaceProjectFolder.isDirectory()) {
				                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
				                    if (workspaceProject.exists() && workspaceProject.isOpen() && workspaceProject.hasNature(JavaCore.NATURE_ID) && !workspaceProject.hasNature(WodelTestSUTNature.NATURE_ID)) {
				                        testSuiteProject = workspaceProject;
				                        break;
				                    }
				                }
				            }
			            }
			            if (testSuiteProject == null) {
			            	return;
			            }
			            IJavaProject javaProject = JavaCore.create(project);
						IClasspathEntry[] entries = javaProject.getRawClasspath();
						IClasspathEntry srcEntry = null;
						for (int j = 0; j < entries.length; j++) {
							IPath entryPath = entries[j].getPath();
							if (entryPath.lastSegment().equals("src")) {
								srcEntry = entries[j];
								break;
							}
						}
						String srcPath = srcEntry.getPath().toFile().getPath().replace("\\", "/");
						srcPath = srcPath.substring(1, srcPath.length());
						srcPath = srcPath.substring(srcPath.indexOf("/"), srcPath.length()); 
						File srcFolder = new File(project.getLocation().toFile().getPath().replace("\\", "/") + srcPath);
						File[] srcFolders = srcFolder.listFiles();
						IJavaProject javaTestSuiteProject = JavaCore.create(testSuiteProject);
						entries = javaTestSuiteProject.getRawClasspath();
						IClasspathEntry testEntry = null;
						for (int j = 0; j < entries.length; i++) {
							IPath entryPath = entries[j].getPath();
							if (entryPath.lastSegment().equals("src")) {
								testEntry = entries[j];
								break;
							}
						}
						String testPath = testEntry.getPath().toFile().getPath().replace("\\", "/");
						testPath = testPath.substring(1, testPath.length());
						testPath = testPath.substring(testPath.indexOf("/"), testPath.length()); 
						File testFolder = new File(testSuiteProject.getLocation().toFile().getPath().replace("\\", "/") + testPath);
						String testSrcPath = getTestPath(srcFolders[0].getName(), testFolder);
						File testSrcFolder = new File(testSrcPath);
						testPath = testSrcFolder.getPath().replace("\\", "/");
						testSrcPath = testEntry.getPath().toFile().getPath().replace("\\", "/") + "/";
						testPath = testPath.substring(testPath.indexOf(testSrcPath), testPath.length());
						testPath = testPath.substring(1, testPath.length());
						testPath = testPath.substring(testPath.indexOf("/"), testPath.length()); 
						
						MergeJavaProject.run(project, testSuiteProject, srcPath, testPath);
					}
				} catch (CoreException e) {
					throw e;
				}
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return;
			}
		}
		
		// Add the nature
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = WodelTestSplittedJavaProjectNature.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
		
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] entries = javaProject.getRawClasspath();
		IClasspathEntry srcEntry = null;
		for (int i = 0; i < entries.length; i++) {
			IPath entryPath = entries[i].getPath();
			if (entryPath.lastSegment().equals("src")) {
				srcEntry = entries[i];
				break;
			}
		}
		String srcPath = srcEntry.getPath().toFile().getPath().replace("\\", "/");
		srcPath = srcPath.substring(1, srcPath.length());
		srcPath = srcPath.substring(srcPath.indexOf("/"), srcPath.length()); 
		File srcFolder = new File(project.getLocation().toFile().getPath().replace("\\", "/") + srcPath);
		File[] srcFolders = srcFolder.listFiles();
		String testPath = getTestPath(srcFolders[0].getName(), srcFolder);
		String testSrcPath = srcFolder.getPath().replace("\\", "/");
		testSrcPath = srcEntry.getPath().toFile().getPath().replace("\\", "/") + "/";
		String relativeTestPath = testPath.substring(testPath.indexOf(testSrcPath), testPath.length());
		relativeTestPath = relativeTestPath.substring(1, relativeTestPath.length());
		relativeTestPath = relativeTestPath.substring(relativeTestPath.indexOf("/"), relativeTestPath.length()); 
		
		SplitJavaProject.run(project, srcFolder.getPath(), testPath, relativeTestPath);
	}
}
