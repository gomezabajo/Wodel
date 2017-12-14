package wodel.synthesizer.popup.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import wodel.synthesizer.generator.GenerateWodelWizard;

public class GenerateWodel implements IObjectActionDelegate {

	private Shell shell;
	private GenerateWodelWizard wizard = null;
	
	/**
	 * Constructor for Action1.
	 */
	public GenerateWodel() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		wizard = new GenerateWodelWizard();
		WizardDialog wd = new WizardDialog(shell, wizard);
		wd.setTitle(wizard.getWindowTitle());
		wd.open();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
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
		wizard.setFile(file);
	}

}
