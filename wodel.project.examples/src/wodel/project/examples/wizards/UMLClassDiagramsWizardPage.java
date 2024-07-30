package wodel.project.examples.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Pablo Gomez-Abajo - Wodel new UML class diagrams example project Wizard page.
 * 
 * Wodel new UML class diagrams example project Wizard page.
 *  
 */

public class UMLClassDiagramsWizardPage extends WizardPage {

	private Text fileText;
	private Text projectText;
	private Text modelText;
	private Text mutantText;

	private ISelection selection;
	
	public boolean valid = false;

	protected UMLClassDiagramsWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("New Wodel UML Class Diagrams Example");
		setDescription("This wizard creates a new Wodel UML Class Diagrams Example.");
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		
		Composite contents = new Group(parent, SWT.FILL);
	    contents.setLayout(new GridLayout(1, false));
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    gd.horizontalAlignment = SWT.FILL;
	    contents.setLayoutData(gd);
	    
		Group settings = new Group(contents, SWT.FILL);
		GridLayout layout = new GridLayout();
		settings.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
	    settings.setText("&Settings");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
	    settings.setLayoutData(gd);

		Label label = new Label(settings, SWT.NULL);
		label.setText("&Project name:");

		projectText = new Text(settings, SWT.BORDER | SWT.SINGLE );
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		projectText.setLayoutData(gd);
		projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		label = new Label(settings, SWT.NULL);
		label.setText("&File name:");

		fileText = new Text(settings, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		label = new Label(settings, SWT.NULL);
		label.setText("&Model folder:");

		modelText = new Text(settings, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		modelText.setLayoutData(gd);
		modelText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		label = new Label(settings, SWT.NULL);
		label.setText("&Mutant folder:");

		mutantText = new Text(settings, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		mutantText.setLayoutData(gd);
		mutantText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		initialize();
		dialogChanged();
		setControl(contents);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

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
		this.projectText.setText("umlCD");
		this.fileText.setText("umlCD.mutator");
		this.modelText.setText("data/model");
		this.mutantText.setText("data/out");
	}
	
	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		String fileName = getFileName();
		String projectName = getProjectName();

		if (projectName.length() == 0) {
			updateStatus("Project name must be specified");
			return;
		}	
		if (fileName.length() == 0) {
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("File name must be valid");
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if(dotLoc==-1) return;
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase("mutator") == false) {
				updateStatus("File extension must be \"mutator\"");
				return;
			}
		}
		valid = true;
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getFileName() {
		return fileText.getText();
	}
	
	public String getModelName() {
		return modelText.getText();
	}
	
	public String getMutantName() {
		return mutantText.getText();
	}
	
	public String getProjectName() {
		return projectText.getText();
	}
}
