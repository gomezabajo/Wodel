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
	private static String fileName;
	
	private WodelContext(){
	}
	
	
	public static Display getDisplay() {
		Display display = Display.getCurrent();
		//may be null if outside the UI thread
		if (display == null)
			display = Display.getDefault();
		return display;		
	}

	public static String getProject() {
		if (project == null) {
			getDisplay().syncExec(new WodelContext());
		}
		return project;
	}
	public static void setProject(String project) {
		WodelContext.project = project;
	}
	
	public static String getFileName() {
		if (fileName == null) {
			getDisplay().syncExec(new WodelContext());
		}
		return fileName;
	}

	@Override
	public void run() {
		IWorkbenchWindow ww = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		IWorkbenchPage wp = ww.getPages()[0];		
		IEditorPart wbp = wp.getActiveEditor();
		if (wbp != null) {
			IFile file = (IFile)wbp.getEditorInput().getAdapter(IFile.class);
			IProject ip = file.getProject();
			WodelContext.project = ip.getName();
			WodelContext.fileName = file.getName();
		}
	}
}
