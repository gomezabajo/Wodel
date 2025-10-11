package wodel.utils.manager;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;

public class IsReadyFileRunnable implements Runnable {
	IFile fFile = null;
	IWorkbenchWindow window = null;
	public IsReadyFileRunnable(IWorkbenchWindow window) {
		this.window = window;
	}
	public IFile getfFile() {
		return fFile;
	}
	
	private static IFile getFile(IEditorPart part)
	{
		return (IFile) part.getEditorInput().getAdapter(IFile.class);
	}
	@Override
	public void run() {
    	IEditorReference[] editors = window.getPages()[0].getEditorReferences();
    	if (editors != null && editors.length > 0) {
    		for (IEditorReference editor : editors) {
    			IEditorPart part = editor.getEditor(true);
    			if (part != null) {
    				fFile = getFile(part);
    				if (fFile != null) {
   				    	return;
    				}
    			}
    		}
    	}
	}
}
