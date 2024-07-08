package wodel.project.properties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;

import wodel.extension.generator.IGenerator;

public class WodelPropertiesPage extends PropertyPage {

	private static final String PATH_TITLE = "Path:";
	private static final String MODEL_FOLDER_TITLE = "&Models folder:";
	private static final String DEFAULT_MODEL_FOLDER = "data/model";
	private static final String MUTANT_FOLDER_TITLE = "&Mutants folder:";
	private static final String DEFAULT_MUTANT_FOLDER = "data/out";
	private static final String WODEL_COMBO_TITLE = "&Extensions:";

	private static final int TEXT_FIELD_WIDTH = 50;

	public static final String MODEL_FOLDER_PROPERTY = "MODELS";
	public static final String MUTANT_FOLDER_PROPERTY = "MUTANTS";
	public static final String WODEL_EXTENSION_PROPERTY = "EXTENSION";
	public static final String DEFAULT_WODEL_EXTENSION = "";

	private Text modelFolderText;
	private Text mutantFolderText;
	private Combo wodelExtensionCombo;
	
	private IProject project;

	private Map<String, Boolean> wodelExtensions = new LinkedHashMap<String, Boolean>();

	/**
	 * Constructor for SamplePropertyPage.
	 */
	public WodelPropertiesPage() {
		super();
	}
	
	public void setModelFolder(String modelFolder) {
		modelFolderText.setText(modelFolder);
	}
	
	public void setMutantFolder(String mutantFolder) {
		mutantFolderText.setText(mutantFolder);
	}

	private void addFirstSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		//Label for path field
		Label pathLabel = new Label(composite, SWT.NONE);
		pathLabel.setText(PATH_TITLE);

		// Path text field
		Text pathValueText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		
		if (getElement() instanceof IJavaProject) {
			project = ((IJavaProject) getElement()).getProject();
		}
		if (getElement() instanceof IProject) {
			project = (IProject) getElement();
		}
		if (project != null) {
			pathValueText.setText(project.getLocation().toFile().toPath().toString());
		}
	}

	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	private void addSecondSection(Composite parent) {
		if (project == null) {
			return;
		}
		Composite composite = createDefaultComposite(parent);

		// Label for model folder field
		Label modelFolderLabel = new Label(composite, SWT.NONE);
		modelFolderLabel.setText(MODEL_FOLDER_TITLE);

		// Model folder text field
		modelFolderText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		modelFolderText.setLayoutData(gd);

		// Populate model folder text field
		try {
			String modelFolder =
				((IResource) project).getPersistentProperty(
					new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), MODEL_FOLDER_PROPERTY));
			modelFolderText.setText((modelFolder != null) ? modelFolder : DEFAULT_MODEL_FOLDER);
		} catch (CoreException e) {
			modelFolderText.setText(DEFAULT_MODEL_FOLDER);
		}

		// Label for mutant folder field
		Label mutantFolderLabel = new Label(composite, SWT.NONE);
		mutantFolderLabel.setText(MUTANT_FOLDER_TITLE);

		// Mutant folder text field
		mutantFolderText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		mutantFolderText.setLayoutData(gd);

		// Populate mutant folder text field
		try {
			String mutantFolder =
				((IResource) project).getPersistentProperty(
					new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), MUTANT_FOLDER_PROPERTY));
			mutantFolderText.setText((mutantFolder != null) ? mutantFolder : DEFAULT_MUTANT_FOLDER);
		} catch (CoreException e) {
			mutantFolderText.setText(DEFAULT_MUTANT_FOLDER);
		}
		
		List<String> exts = new ArrayList<String>();

		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.extension.MutApplication");
			for (int j = 0; j < extensions.length; j++) {
				try {
					final IGenerator src = (IGenerator) extensions[j]
							.createExecutableExtension("class");
					exts.add(src.getName());
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		String[] values = new String[exts.size() + 1];
		int index = 0;
		values[index] = DEFAULT_WODEL_EXTENSION;
		index++;
		for (String ext : exts) {
			values[index] = ext;
			index++;
		}
		
		// Label for extensions drop down list field
		Label extensionsLabel = new Label(composite, SWT.NONE);
		extensionsLabel.setText(WODEL_COMBO_TITLE);

		// Extensions drop down list field
		final String[] valueList = exts.toArray(new String[exts.size()]); 
		wodelExtensionCombo = new Combo(composite, SWT.NONE);
		for (String value : values) {
			wodelExtensionCombo.add(value);
		}
		// Populate extensions drop down list field
		try {
			String wodelExtension =
					((IResource) project).getPersistentProperty(
							new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), WODEL_EXTENSION_PROPERTY));
			if (wodelExtension == null) {
				wodelExtension = DEFAULT_WODEL_EXTENSION;
			}
			wodelExtensionCombo.setText(wodelExtension);
			for (String value : valueList) {
	    		if (wodelExtension.equals(value)) {
		            wodelExtensions.put(value, true);
	    		}
	    		else {
	    			wodelExtensions.put(value, false);
	    		}
	    	}
		} catch (CoreException e) {
			wodelExtensionCombo.setText(DEFAULT_WODEL_EXTENSION);
		}
		
		wodelExtensionCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		    	String eventValue = (String) e.getSource();
	        	for (String value : valueList) {
	        		if (eventValue.equals(value)) {
	    	            wodelExtensions.put(value, true);
	        		}
	        		else {
	        			wodelExtensions.put(value, false);
	        		}
	        	}
	        }
	    });
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		addFirstSection(composite);
		addSeparator(composite);
		addSecondSection(composite);
		return composite;
	}

	private Composite createDefaultComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		return composite;
	}

	protected void performDefaults() {
		super.performDefaults();
		// Populate the text fields with the default values
		modelFolderText.setText(DEFAULT_MODEL_FOLDER);
		mutantFolderText.setText(DEFAULT_MUTANT_FOLDER);
		wodelExtensionCombo.setText(DEFAULT_WODEL_EXTENSION);
	}
	
	public boolean performOk() {
		if (project == null) {
			return false;
		}
		// store the values in the text fields
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), MODEL_FOLDER_PROPERTY),
				modelFolderText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), MUTANT_FOLDER_PROPERTY),
				mutantFolderText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(new QualifiedName(Platform.getBundle("wodel.project").getSymbolicName(), WodelPropertiesPage.WODEL_EXTENSION_PROPERTY), wodelExtensionCombo.getText());
		} catch (CoreException e1) {
			return false;
		}
		return true;
	}
	
	public Map<String, Boolean> getWodelExtensions() {
		return wodelExtensions;
	}

}