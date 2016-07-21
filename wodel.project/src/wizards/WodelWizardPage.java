package wizards;

import generator.IGenerator;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class WodelWizardPage extends WizardPage {

	private Text fileText;
	private Text projectText;
	private Text modelText;
	private Text mutantText;
	private HashMap<String, Boolean> wodelExtensions = new HashMap<String, Boolean>();

	private ISelection selection;

	/**
	 * Constructor for WodelWizardPage.
	 * 
	 * @param pageName
	 */
	public WodelWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("New Wodel Project");
		setDescription("This wizard creates a new Wodel project.");
		this.selection = selection;
	}
	
	//TODO Definir parametros de la primera pagina y de la segunda si la hubiera. 
	//TODO Mirar como crear dependencias en un proyecto creado.

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
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
		
	    Group exts = new Group(contents, SWT.FILL);
	    layout = new GridLayout();
		exts.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
	    exts.setText("&Extensions");

		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.extension.MutApplication");
			for (int j = 0; j < extensions.length; j++) {
				try {
					final IGenerator src = (IGenerator) extensions[j]
							.createExecutableExtension("class");
					Button button = new Button(exts, SWT.CHECK);
					button.addSelectionListener(new SelectionAdapter() {
					        public void widgetSelected(SelectionEvent event) {
					            Button btn = (Button) event.getSource();
					            wodelExtensions.put(src.getName(), btn.getSelection());
					        }
					    });
					button.setText("&" + src.getName());
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		gd = new GridData(GridData.FILL_HORIZONTAL);
	    gd.horizontalAlignment = SWT.FILL;
		exts.setLayoutData(gd);
		
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
		this.projectText.setText("NewWodelProject");
		this.fileText.setText("NewFile.mutator");
		this.modelText.setText("model");
		this.mutantText.setText("out");
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
	
	public HashMap<String, Boolean> getWodelExtensions() {
		return wodelExtensions;
	}
}