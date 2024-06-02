package mutator.wodeltest.[@**@].wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class CongaSuTAndTestSuiteWizardPage extends WizardPage {

	private ISelection selection;
	
	protected CongaSuTAndTestSuiteWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("Wodel-Test for Conga Example");
		setDescription("Wodel-Test for Conga Example.");
		this.selection = selection;
	}

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
			}
		}
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		initialize();
		setControl(parent);
		
	}
}
