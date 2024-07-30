package wodel.run.popup.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;

public class CleanUpWodelOutputFolder extends AbstractHandler {

	private class CleanUpWodelOutputFolderWithProgress implements IRunnableWithProgress {

		private IProject project = null;

		public CleanUpWodelOutputFolderWithProgress(IProject project) {
			this.project = project;
		}
		
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			String path = ProjectUtils.getProject() != null ? ProjectUtils.getProject().getLocation().toFile().getPath() : ModelManager.getWorkspaceAbsolutePath();
			File projectFolder = new File(path);
			List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
			String outputWodelFolder = path + "/" + ModelManager.getOutputFolder();
			// clean-up output folder preserving xtext auto generated models
			IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
			IOUtils.deleteFolder(outputWodelFolder, "json", mutatorList);
			
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			final String textToShow = "Wodel output folder clean-up process finished succesfully";
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setText("Wodel output folder clean-up process completed");
					messageBox.setMessage(textToShow);
					messageBox.open();
				}
			});
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile file = null;
		try {
			IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
			file = (IFile) selection.getFirstElement();
		} catch (ExecutionException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (file == null) {
			return true;
		}
		
		IProject project = file.getProject();
    	try {
    		CleanUpWodelOutputFolderWithProgress cleanUpWodelOutputFolderWithProgress = new CleanUpWodelOutputFolderWithProgress(project);
    		new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, cleanUpWodelOutputFolderWithProgress);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
