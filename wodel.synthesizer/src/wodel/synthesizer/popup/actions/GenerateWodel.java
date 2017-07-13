package wodel.synthesizer.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;

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
		wizard.setFile((IFile) ((IStructuredSelection) selection).getFirstElement());
	}

}
