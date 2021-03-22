package wodel.synthesizer.popup.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import wodel.synthesizer.generator.GenerateWodelWizard;
import wodel.synthesizer.generator.GenerateWodelWizardDialog;

public class GenerateWodel extends AbstractHandler {
	
	private GenerateWodelWizard wodelWizard = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		IFile file = (IFile) selection.getFirstElement();
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
		Shell shell = HandlerUtil.getActiveShell(event);
		wodelWizard = new GenerateWodelWizard();
		wodelWizard.setFile(file);
		GenerateWodelWizardDialog wd = new GenerateWodelWizardDialog(shell, wodelWizard);
		wd.setTitle(wodelWizard.getWindowTitle());
		wd.open();
		return null;
	}
}
