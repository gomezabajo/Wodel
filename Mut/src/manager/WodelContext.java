package manager;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Auxiliary class that returns the project the current file being edited belongs to  
 * @author Juan
 *
 */
public class WodelContext implements Runnable {
	private static String project;

	private WodelContext(){}
	
	public static String getProject() {		
		Display.getDefault().syncExec(new WodelContext());					
		return project;
	}
	public static void setProject(String project) {
		WodelContext.project = project;
	}
	
	@Override
	public void run() {
		IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    IWorkbenchPage wp = ww.getActivePage();		
		IEditorPart wbp = wp.getActiveEditor();
		if (wbp != null) {
			IFile file = (IFile)wbp.getEditorInput().getAdapter(IFile.class);
			IProject ip = file.getProject();
			WodelContext.project = ip.getName();
		}
	}
}
