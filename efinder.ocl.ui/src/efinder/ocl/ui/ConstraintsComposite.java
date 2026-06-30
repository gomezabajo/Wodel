package efinder.ocl.ui;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import efinder.core.IBoundsProvider;
import efinder.ocl.ui.ConstraintsContentProvider.InvariantData;

public class ConstraintsComposite extends Composite implements IConstraintsConfiguration {
	private Text txtOclModel;
	private Table table;
	private TableViewer tableViewer;
	private StyledText txtInfo;
	private IProject project;

	private ActionSupport actionSupport = new ActionSupport(this);
	protected boolean useScrolling;
	private Spinner numExamples;
	private StyledText logText;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ConstraintsComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		Composite composite_4 = new Composite(this, SWT.NONE);
		composite_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_4.setLayout(new GridLayout(3, false));

		Label lblOclModel = new Label(composite_4, SWT.NONE);
		lblOclModel.setSize(61, 17);
		lblOclModel.setText("OCL model");

		txtOclModel = new Text(composite_4, SWT.BORDER);
		txtOclModel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtOclModel.setSize(578, 30);

		Button btnBrowse = new Button(composite_4, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceFileSelectionDialog dialog = new ResourceFileSelectionDialog("OCL model", "Pick an OCL model", new String[] { "ocl" });
				int x = dialog.open();
				if (x == org.eclipse.jface.window.Window.OK) {
					IResource r = (IResource) dialog.getFirstResult();
					if (r instanceof IFile) {
						ResourceSet rs = new ResourceSetImpl();
						Resource res = rs.getResource(URI.createPlatformResourceURI(r.getFullPath().toOSString(), true), true);
						EObject obj = res.getContents().get(0);
						if (obj instanceof CompleteOCLDocumentCS) {
							setInput((CompleteOCLDocumentCS) obj, r.getProject());
						}
					}
				}
			}
		});
		btnBrowse.setSize(69, 34);
		btnBrowse.setText("Browse...");

		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TabItem tbmConstraints = new TabItem(tabFolder, SWT.NONE);
		tbmConstraints.setText("Constraints");

		tableViewer = new TableViewer(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		tableViewer.setContentProvider(new ConstraintsContentProvider());
		tbmConstraints.setControl(table);

		TableViewerColumn selectCheckBox = createTableViewerColumn("Select", 0, tableViewer);
		selectCheckBox.getColumn().setResizable(false);
		selectCheckBox.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof InvariantData && element != null) {
					if (((InvariantData) element).isSelected()) {
						return Character.toString((char) 0x2611);
					} else {
						return Character.toString((char) 0x2610);
					}
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				/*
				 * if(element instanceof TableMetaData && element != null){
				 * if(((TableMetaData)element).getIsSelected()){ return checked; }else{ return
				 * unChecked; } } return super.getImage(element);
				 */
				return null;
			}
		});

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE | SWT.CHECK);
		TableColumn tblclmnConstraint = tableViewerColumn.getColumn();
		tblclmnConstraint.setWidth(100);
		tblclmnConstraint.setResizable(true);
		tblclmnConstraint.setText("Constraint");
		tableViewerColumn.setLabelProvider(new ConstraintsLabelProviders.FirstColumnViewLabelProvider());
		// tableViewerColumn.setEditingSupport(new
		// InvariantCheckEditingSupport(tableViewer));

		TableViewerColumn tableViewerColumn2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnConstraint2 = tableViewerColumn2.getColumn();
		tblclmnConstraint2.setWidth(100);
		tblclmnConstraint2.setResizable(true);
		tblclmnConstraint2.setText("Class");
		tableViewerColumn2.setLabelProvider(new ConstraintsLabelProviders.SecondColumnViewLabelProvider());

		selectCheckBox.getColumn().setWidth(50);

		// Set column type (checkbox)
		selectCheckBox.setEditingSupport(new InvariantCheckEditingSupport(tableViewer));

		TabItem tbtmConfiguration = new TabItem(tabFolder, SWT.NONE);
		tbtmConfiguration.setText("Configuration");

		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmConfiguration.setControl(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		new Label(composite_2, SWT.NONE);

		Group grpScrollingConfiguration = new Group(composite_2, SWT.NONE);
		grpScrollingConfiguration.setText("Scrolling configuration");
		GridData gd_grpScrollingConfiguration = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpScrollingConfiguration.verticalIndent = 2;
		grpScrollingConfiguration.setLayoutData(gd_grpScrollingConfiguration);
		grpScrollingConfiguration.setLayout(new GridLayout(2, false));
		new Label(grpScrollingConfiguration, SWT.NONE);

		Button btnUseScrolling = new Button(grpScrollingConfiguration, SWT.CHECK);
		btnUseScrolling.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnUseScrolling.setSize(614, 17);
		btnUseScrolling.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConstraintsComposite.this.useScrolling = ((Button) e.getSource()).getSelection();
			}
		});
		btnUseScrolling.setText("Scrolling");

		Label lblMaxExamples = new Label(grpScrollingConfiguration, SWT.NONE);
		lblMaxExamples.setSize(84, 17);
		lblMaxExamples.setText("Max. Examples");

		numExamples = new Spinner(grpScrollingConfiguration, SWT.BORDER);
		numExamples.setSize(139, 32);
		numExamples.setMaximum(1000000);
		numExamples.setMinimum(1);

		TabItem tbtmLog = new TabItem(tabFolder, SWT.NONE);
		tbtmLog.setText("Log");

		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmLog.setControl(composite_3);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));

		TextViewer textViewer = new TextViewer(composite_3, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		logText = textViewer.getTextWidget();

		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Composite composite = new Composite(composite_1, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		Button btnVerifyConstraints = new Button(composite, SWT.NONE);
		btnVerifyConstraints.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				actionSupport.generateExample(false, 1);
			}
		});
		btnVerifyConstraints.setText("Verify constraints");

		Button btnGenExample = new Button(composite, SWT.NONE);
		btnGenExample.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int numExamples = Integer.parseInt(ConstraintsComposite.this.numExamples.getText());				
				actionSupport.generateExample(ConstraintsComposite.this.useScrolling, numExamples);
			}
		});
		btnGenExample.setText("Generate example");

		Button btnComplete = new Button(composite, SWT.NONE);
		btnComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IResource r = UIUtils.showChooseChooseFileDialog(getShell());
				int numExamples = Integer.parseInt(ConstraintsComposite.this.numExamples.getText());
				actionSupport.completeModel(r, ConstraintsComposite.this.useScrolling, numExamples);
			}
		});
		btnComplete.setText("Complete model");

		txtInfo = new StyledText(composite_1, SWT.BORDER);
	}

	// Creates the column
	private TableViewerColumn createTableViewerColumn(String header, int idx, TableViewer tableViewer2) {
		// To put checkbox centered in cell.
		int infoLocation = SWT.LEFT;
		if (idx == 1) {
			infoLocation = SWT.CENTER;
		}
		TableViewerColumn column = new TableViewerColumn(tableViewer2, infoLocation, idx);
		column.getColumn().setText(header);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);

		return column;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setInput(CompleteOCLDocumentCS doc, IProject project) {
		this.project = project;
		txtOclModel.setText(doc.eResource().getURI().toString());
		tableViewer.setInput(new OclDocumentData(doc));
		tableViewer.refresh();
	}

	//
	// IConstraintsConfiguration
	//

	@Override
	public @Nullable IProject getProject() {
		return project;
	}

	@Override
	public @NonNull IFolder getOutputFolder() {
		IFolder outputs = project.getFolder("outputs-efinder");
		if (!outputs.exists()) {
			try {
				outputs.create(true, true, null);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return outputs;
	}

	@Override
	public @NonNull OclDocumentData getDocument() {
		return (OclDocumentData) tableViewer.getInput();
	}

	@Override
	public void showMessage(String message) {
		txtInfo.setText(message);
	}
	
	@Override
	public void log(String msg) {
		System.out.println("===> " + msg);
		logText.append(msg + "\n");
	}
}
