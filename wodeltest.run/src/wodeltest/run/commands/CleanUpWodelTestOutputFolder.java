package wodeltest.run.commands;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;

public class CleanUpWodelTestOutputFolder extends AbstractHandler {

	private class CleanUpWodelTestOutputFolderWithProgress implements IRunnableWithProgress {

		private ExecutionEvent event = null;
		private String projectName = null;

		public CleanUpWodelTestOutputFolderWithProgress(ExecutionEvent event, String projectName) {
			this.event = event;
			this.projectName = projectName;
		}
		
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			File projectFolder = new File(ModelManager.getWorkspaceAbsolutePath());
			List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
			String outputWodelFolder = ModelManager.getWorkspaceAbsolutePath() + "/" + ModelManager.getOutputFolder();
			// clean-up output folder preserving xtext auto generated models
			IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
			IOUtils.deleteFolder(outputWodelFolder, "json", mutatorList);
			
			String modelWodelFolder = ModelManager.getModelsFolder();
			// clean-up model folder preserving ecore
			IOUtils.deleteFolder(modelWodelFolder, "model");
			
			final String textToShow = "Wodel-Test output folder clean-up process finished succesfully";
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setText("Wodel-Test output folder clean-up process completed");
					messageBox.setMessage(textToShow);
					messageBox.open();
				}
			});
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject project = null;
		IWodelTest test = null;
		
		List<IWodelTest> tests = new ArrayList<IWodelTest>();
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodeltest.extension.MutTesting");
			for (int j = 0; j < extensions.length; j++) {
				IWodelTest currentTest = null;
				try {
					currentTest = (IWodelTest) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tests.add(currentTest);
			}
		}
		try {
			IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
			IProject sProject = null;
			
			if (selection.getFirstElement() instanceof IAdaptable)
	        {
	            sProject = (IProject)((IAdaptable) selection.getFirstElement()).getAdapter(IProject.class);
	        }
			if (sProject == null && selection.getFirstElement() instanceof IProject) {
				sProject = (IProject) selection.getFirstElement();
			}
			if (sProject == null && selection.getFirstElement() instanceof IFile) {
				sProject = ((IFile) selection.getFirstElement()).getProject();
			}
			if (sProject == null && selection.getFirstElement() instanceof IJavaProject) {
				sProject = ((IJavaProject) selection.getFirstElement()).getProject();
			}
			
			if (sProject == null) {
				return null;
			}

			for (IWodelTest t : tests) {
				if (sProject.hasNature(t.getNatureId())) {
					test = t;
					break;
				}
			}
			if (test == null) {
				return null;
			}
		} catch (InvalidRegistryObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String projectName = test.getProjectName();
    	try {
    		CleanUpWodelTestOutputFolderWithProgress cleanUpWodelTestOutputFolderWithProgress = new CleanUpWodelTestOutputFolderWithProgress(event, projectName);
    		new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, cleanUpWodelTestOutputFolderWithProgress);
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

