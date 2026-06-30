package tinytools.metamodel.staticfacade.ui;

import org.eclipse.jface.wizard.Wizard;

public class ConfigureWrapperWizard extends Wizard {

	public ConfigureWrapperWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
		addPage(new ConfigureWrapperWizardPage());
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
