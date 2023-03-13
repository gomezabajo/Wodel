package wodel.utils.manager;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorChangeListener manages the project changes
 * in Wodel IDE
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class MutatorChangeListener implements IResourceChangeListener {

	
	private static void refreshMutator() {
		IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (ww != null) {
			IWorkbenchPage wp = ww.getActivePage();		
			IEditorPart wbp = wp.getActiveEditor();
			if (wbp != null) {
				IFile file = (IFile)wbp.getEditorInput().getAdapter(IFile.class);
				// refresh the use generated file
				try {
					InputStream stream = file.getContents();
					if (file.exists()) {
						String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
						stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
						file.setContents(stream, true, true, null);
					}
					stream.close();
				} catch (CoreException e) {
				} catch (IOException e) {
				}
			}
		}
	}
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		ProjectUtils.resetProject();
		ProjectUtils.getProject();
		refreshMutator();
		//WodelContext.getProject();
	}
 }