package wodel.run.popup.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.MutatorAPILauncher;

public class GenerateWodelMutantsWizard extends AbstractHandler {
	
	public class WodelMutantsWizard extends Wizard implements INewWizard {

		private ISelection selection;

		private Shell shell;
		
		private ExecutionEvent event;
		
		private GenerateWodelMutantsWizardPage _pageOne;
		
		private static final String WIZARD_NAME = "Generate Wodel Mutants Wizard";
		
		/**
		 * Constructor for WodelWizard.
		 */
		public WodelMutantsWizard(Shell shell, ExecutionEvent event) {
			super();
			this.shell = shell;
			this.event = event;
			setWindowTitle(WIZARD_NAME);
			setNeedsProgressMonitor(true);
		}
		
		/**
		 * Adding the page to the wizard.
		 */
		@Override
		public void addPages() {
			super.addPages();
			_pageOne = new GenerateWodelMutantsWizardPage(selection);
			_pageOne.setTitle("Generate Wodel Mutants Wizard");
			_pageOne.setDescription("Generate Wodel Mutants Wizard");
			addPage(_pageOne);
		}


		@Override
		public void init(IWorkbench workbench, IStructuredSelection selection) {
			setWindowTitle(WIZARD_NAME);
			setNeedsProgressMonitor(true);
			this.selection = selection;
			addPages();
			
		}

		@Override
		public boolean performFinish() {
			IFile file = null;
			try {
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
			} catch (ExecutionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (file == null) {
				return true;
			}
			
			IProject project = file.getProject();
			String[] arrMutatorNames = new String[_pageOne.selectedWodelPrograms.size()];
			_pageOne.selectedWodelPrograms.toArray(arrMutatorNames);
			String[][] arrOperatorNames = new String[_pageOne.selectedMutationOperators.size()][];
			int i = 0;
			for (List<String> mutOpNames : _pageOne.selectedMutationOperators) {
				String[] arrMutatorOperatorNames = new String[mutOpNames.size()];
				mutOpNames.toArray(arrMutatorOperatorNames);
				arrOperatorNames[i] = arrMutatorOperatorNames;
				i++;
			}
			String inputFolder = _pageOne.inputFolder;
			String outputFolder = _pageOne.outputFolder;
			try {
				MutatorAPILauncher mutatorAPILauncher = new MutatorAPILauncher(event, project, arrMutatorNames, arrOperatorNames, inputFolder, outputFolder);
	    		new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, mutatorAPILauncher);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//MutatorAPILauncher.createMutants(project, arrMutatorNames, arrOperatorNames, "D:\\seed", "D:\\mutants");
			return true;
		}
		
		/**
		 * Toggles the finish button
		 */
		@Override
		public boolean canFinish()
		{
			if(getContainer().getCurrentPage() == _pageOne) {
				if (_pageOne.valid == true) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		WodelMutantsWizard wodelMutantsWizard = new WodelMutantsWizard(shell, event);
		WizardDialog wd = new WizardDialog(shell, wodelMutantsWizard);
		wd.setTitle(wodelMutantsWizard.getWindowTitle());
		wd.open();
		return null;
	}
}

