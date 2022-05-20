package wodel.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import manager.RunWodelAPI;

/**
 * @author Pablo Gomez-Abajo - Wodel external execution
 * 
 */

public class WodelAPI extends AbstractHandler {
	
	private class WodelTestAPIWithProgress implements IRunnableWithProgress {
		private ExecutionEvent event = null;
		public WodelTestAPIWithProgress(ExecutionEvent event) {
			this.event = event;
		}
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			IFile file = null;
			try {
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
			} catch (ExecutionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String inputPath = "";
			String outputPath = "";
		    try {
		    	if (Platform.getExtensionRegistry() != null) {
					IConfigurationElement[] extensions = Platform
							.getExtensionRegistry().getConfigurationElementsFor(
									"wodel.runner.MutRunner");

					try {
						IConfigurationElement appropriateExtension = extensions[0];
						Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
						Object wodelConfiguration =  extensionClass.newInstance();
						Method getInputPath = extensionClass.getDeclaredMethod("getInputPath");
						Method getOutputPath = extensionClass.getDeclaredMethod("getOutputPath");
						inputPath = (String) getInputPath.invoke(wodelConfiguration);
						outputPath = (String) getOutputPath.invoke(wodelConfiguration);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RunWodelAPI.generateMutants(file.getProject(), inputPath, outputPath);
		    	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
    	try {
    		WodelTestAPIWithProgress wodelTestAPIWithProgress = new WodelTestAPIWithProgress(event);
    		new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, wodelTestAPIWithProgress);
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
