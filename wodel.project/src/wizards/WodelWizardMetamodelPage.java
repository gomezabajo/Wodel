package wizards;

import manager.ModelManager;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class WodelWizardMetamodelPage extends WizardPage {

	private String[] extensions;
	public String file;
	private Label label;
	private Label fileLabel;
	private Label descriptionLabel;
	private Button button;
	private Button validate;
	private Label separator;
	private Composite container;
	private ScrolledComposite scrolledComposite;
	private int height;

	private ISelection selection;
	
	public boolean valid = false;

	/**
	 * Constructor for WodelWizardMetamodelPage.
	 * 
	 * @param pageName
	 */
	public WodelWizardMetamodelPage(ISelection selection) {
		super("wizardMetamodelPage");
		setTitle("Select ecore metamodel");
		setDescription("Select ecore metamodel.");
		setMessage("");
		setFileExtensions(new String[] { "*.ecore" });
		this.selection = selection;
		file = null;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		scrolledComposite = new ScrolledComposite(parent, SWT.BORDER
				| SWT.V_SCROLL);
		setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite container = new Composite(scrolledComposite, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		this.container = container;
		
		initialize();
		dialogChanged();
		setControls();
	}

	public void setControls() {
		for (Control c : container.getChildren())
			c.dispose();

		if (file != null) {
			validate = new Button(container, SWT.NONE);
			validate.setText("Validate ecore metamodel");
			validate.addSelectionListener(new MetamodelValidationAdapter());
			validate.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
			label = new Label(container, SWT.NONE);
			label.setText(file.substring(file.lastIndexOf("\\") + 1));
			label.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		}
		if (file == null) {
			button = new Button(container, SWT.NONE);
			button.setText("Load file");
			button.addSelectionListener(new FileSelectionAdapter());
			button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
			descriptionLabel = new Label(container, SWT.WRAP);
			descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 2, 1));
			descriptionLabel.setText("Select the ecore file.");
		}
		fileLabel = new Label(container, SWT.NONE);
		fileLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		fileLabel.setText("");
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		container.layout();
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,	SWT.DEFAULT));
	}

	protected void setFileExtensions(String[] extensions) {
		this.extensions = extensions;
	}

	protected String getFile() {

		return file;
	}
	
	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}


	private class MyMouseTrackAdapter extends MouseTrackAdapter {

		public MyMouseTrackAdapter() {
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			Point size = getShell().computeSize(getShell().getSize().x,
					SWT.DEFAULT);
			size.x = getShell().getSize().x;
			if (size.y > height)
				getShell().setSize(size);
			height = getShell().getSize().y;
		}

		@Override
		public void mouseExit(MouseEvent e) {
		}
	}

	private class FileSelectionAdapter extends SelectionAdapter {

		FileSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
			dlg.setFilterNames(extensions);
			dlg.setFilterExtensions(extensions);
			String fileName = dlg.open();
			if (fileName != null) {
				file = fileName;
				fileLabel.setText(fileName);
			}
			setControls();
//			else {
//				DirectoryDialog dirdlg = new DirectoryDialog(getShell());
//				String dir = dirdlg.open();
//				if (dir != null) {
//					file = dir;
//					fileLabel.setText(dir);
//				}
//			}
		}
	}
	
	private class MetamodelValidationAdapter extends SelectionAdapter {

		MetamodelValidationAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (file != null) {
				try {
					valid = ModelManager.validateMetaModel(file);
				} catch (MetaModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			IWizardContainer container = getContainer();
			container.updateButtons();
		}
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
}