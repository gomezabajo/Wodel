package manager;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ViewUtils {
	
	private static IProject project = null;
	
	public static boolean isReady() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null && window.getSelectionService().getSelection() instanceof IStructuredSelection)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        if (selection != null) {
	        	Object firstElement = selection.getFirstElement();
	        	if (firstElement instanceof IAdaptable)
	        	{
	        		project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	        	}
	        }
	    }
	    if (project == null) {
	    	return false;
	    }
	    return true;
	}
	
	public static IProject getProject() {
		if (project == null) {
			isReady();
		}
		return project;
	}
}
