package tinytools.metamodel.visitor.ui;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import tinytools.metamodel.visitor.VisitorOptions;

public class VisitorOptionsDialog extends Dialog {
	private Text txtPackage;
	private Text txtFolder;
	private Text txtVisitorclass;
	private VisitorOptions options;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public VisitorOptionsDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));
		
		Label lblPackage = new Label(container, SWT.NONE);
		lblPackage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPackage.setText("Package:");
		
		txtPackage = new Text(container, SWT.BORDER);
		txtPackage.setText("");
		txtPackage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		Label lblVisitorClass = new Label(container, SWT.NONE);
		lblVisitorClass.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVisitorClass.setText("Visitor class:");
		
		txtVisitorclass = new Text(container, SWT.BORDER);
		txtVisitorclass.setText("");
		txtVisitorclass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		Label lblFolder = new Label(container, SWT.NONE);
		lblFolder.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFolder.setText("Folder:");
		
		txtFolder = new Text(container, SWT.BORDER);
		txtFolder.setText("");
		txtFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseFolders();
			}
		});
		btnBrowse.setText("Browse...");

		return container;
	}

	protected void browseFolders() {
		IContainer[] s = WorkspaceResourceDialog.openFolderSelection(this.getShell(), "Select output folder", "Select output folder", false, null, null);
		if ( s != null && s.length > 0 ) {
			txtFolder.setText(s[0].getLocation().toOSString());			
		}
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ok();
			}
		});
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	protected void ok() {
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	@Override
	protected void okPressed() {
		this.options = new VisitorOptions();
		options.setBaseDir(this.txtFolder.getText().trim());
		options.setPackagePrefix(this.txtPackage.getText().trim());
		options.setVisitorClass(this.txtVisitorclass.getText().trim());

		super.okPressed();
	}

	public VisitorOptions show() {
		int result = this.open();
		if ( result == Window.OK ) {
			return this.options;
		}
		return null;
	}

}
