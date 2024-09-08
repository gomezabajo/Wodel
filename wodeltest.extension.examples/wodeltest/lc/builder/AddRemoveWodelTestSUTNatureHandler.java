package mutator.wodeltest.[@**@].builder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.eclipse.core.commands.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import mutator.wodeltest.[@**@].WodelTest;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

public class AddRemoveWodelTestSUTNatureHandler extends AbstractHandler {

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
			if (WodelTestSUTNature.NATURE_ID.equals(natures[i])) {
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
		newNatures[natures.length] = WodelTestSUTNature.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);

		IProject testSuiteProject = null;
		String testSuiteProjectName = null;
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
        if (testSuiteProject.equals(project)) {
        	testSuiteProjectName = project.getName() + "-test";
        }
        else {
        	testSuiteProjectName = testSuiteProject.getName();
        }
        IProgressMonitor monitor = new NullProgressMonitor();
        final IFolder data = project.getFolder(new Path("data"));
        if (!data.exists()) {
        	data.create(true, true, monitor);
        }
        final IFile test = data.getFile(new Path(project.getName() + ".test.txt"));
        try {
			InputStream stream = openTestStream(project.getName(), testSuiteProjectName);
			if (test.exists()) {
				test.setContents(stream, true, true, monitor);
			} else {
				test.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		
		final IFile wodelTest = data.getFile(new Path("project.txt"));
		try {
			InputStream stream = openWodelTestStream(new WodelTest().getProjectName(), JavaCore.NATURE_ID);
			if (wodelTest.exists()) {
				wodelTest.setContents(stream, true, true, monitor);
			} else {
				wodelTest.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
	}
	
	private InputStream openTestStream(String projectName, String testSuiteProjectName) {
		String contents = projectName + "\n" + testSuiteProjectName + "\n";
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	private InputStream openWodelTestStream(String wodelTestProjectName, String natureID) {
		String contents = wodelTestProjectName + "\n" + natureID + "\n";
		return new ByteArrayInputStream(contents.getBytes());
	}
}
