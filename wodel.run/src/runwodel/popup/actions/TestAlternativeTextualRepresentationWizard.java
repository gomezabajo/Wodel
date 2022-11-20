package runwodel.popup.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.handlers.HandlerUtil;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;

public class TestAlternativeTextualRepresentationWizard extends AbstractHandler {
	
	public class WodelAlternativeTextualRepresentationWizard extends Wizard implements INewWizard {

		private ISelection selection;

		private Shell shell;
		
		private ExecutionEvent event;
		
		private TestAlternativeTextualRepresentationWizardPage _pageOne;
		
		private static final String WIZARD_NAME = "Test Alternative Textual Representation Wizard";

		/**
		 * Constructor for TestAlternativeTextualRepresentationWizard.
		 */
		public WodelAlternativeTextualRepresentationWizard(Shell shell, ExecutionEvent event) {
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
			_pageOne = new TestAlternativeTextualRepresentationWizardPage(selection);
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

		private List<File> getModels(File[] files, String projectName) {
			List<File> models = new ArrayList<File>();
			int i = 0;
			while (files != null && i < files.length) {
				File file = files[i];
				String fileName = file.getName();
				if (file.isFile() && fileName.endsWith(".model") && !file.getAbsolutePath().contains("registry") && !fileName.contains("vs") && !fileName.contains(projectName) && !models.contains(file)) {
					models.add(file);
				}
				else if (file.isDirectory()) {
					List<File> nextModels = new ArrayList<File>();
					nextModels.addAll(getModels(file.listFiles(), projectName));
					for (File nextModel : nextModels) {
						if (!models.contains(nextModel)) {
							models.add(nextModel);
						}
					}
				}
				i++;
			}
			return models;
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
			String outputFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/" + ModelManager.getOutputFolder();
			File outputFolder = new File(outputFolderName);
			
			List<File> models = getModels(outputFolder.listFiles(), project.getName());
			Map<File, Resource> modelsMap = new TreeMap<File, Resource>();
			
			String metamodel = ModelManager.getMetaModel();
			try {
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				for (File model : models) {
					Resource resource = ModelManager.loadModel(packages, model.getAbsolutePath());
					if (resource != null) {
						modelsMap.put(model, resource);
					}
				}
			} catch (MetaModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				for (String model2TextID : _pageOne.selectedAlternativeTextualRepresentations.keySet()) {
					for (File model : modelsMap.keySet()) {
						Object model2Text = _pageOne.selectedAlternativeTextualRepresentations.get(model2TextID).getValue().getKey();
						Method getText = _pageOne.selectedAlternativeTextualRepresentations.get(model2TextID).getValue().getValue();
						System.out.println(model2TextID + ": " + (String) getText.invoke(model2Text, metamodel, model.getAbsolutePath()));
					}
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		WodelAlternativeTextualRepresentationWizard wodelAlternativeTextualRepresentationWizard = new WodelAlternativeTextualRepresentationWizard(shell, event);
		WizardDialog wd = new WizardDialog(shell, wodelAlternativeTextualRepresentationWizard);
		wd.setTitle(wodelAlternativeTextualRepresentationWizard.getWindowTitle());
		wd.open();
		return null;
	}
}
