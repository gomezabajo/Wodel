package wodel.synthesizer.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
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
import manager.ModelManager;
import wodel.synthesizer.utils.MultiLineStringFieldEditor;

public class GenerateWodelWizardFinalPage extends WizardPage {

	private String[] extensions;
	private ISelection selection;
	private String metamodel;
	private Composite container;
	private ScrolledComposite scrolledComposite;
	private Label label;
	public List<String> classNames = new ArrayList<String>();
	public Map<String, Integer> numObjects = new HashMap<String, Integer>();
	public Map<String, SimpleEntry<String, String>> tagsByClass = new HashMap<String, SimpleEntry<String, String>>();
	private Label separator;
	public String customOCL = "";
	private MultiLineStringFieldEditor customOCLFieldEditor;
	public String file;
	private Label fileLabel;
	private Button button;
	private Label descriptionLabel;
	private int height;
	public boolean forceRoot = true;
	public List<String> selectedBlockNames = new ArrayList<String>();
	public int numSeeds = 3;
	public boolean valid = false;

	protected GenerateWodelWizardFinalPage(ISelection selection) {
		super("finalWizardPage");
		this.selection = selection;
		this.metamodel = ModelManager.getMetaModel();
	}

	@Override
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

		if (GenerateWodelWizard.configurationFile != null) {
			GenerateWodelWizard.savedConfiguration = new ConfigurationFile(GenerateWodelWizard.configurationFile);
			numObjects = GenerateWodelWizard.savedConfiguration.numObjects;
			tagsByClass = GenerateWodelWizard.savedConfiguration.tagsByClass;
			file = GenerateWodelWizard.savedConfiguration.file;
		}

		customOCLFieldEditor = new MultiLineStringFieldEditor("Add OCL constraint", "Add OCL constraint", 20, container);
		if (GenerateWodelWizard.savedConfiguration != null) {
			try {
				Method methodSetStringValue = MultiLineStringFieldEditor.class.getDeclaredMethod("setStringValue", String.class);
				methodSetStringValue.setAccessible(true);
				methodSetStringValue.invoke(customOCLFieldEditor, GenerateWodelWizard.savedConfiguration.customOCL);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customOCL = GenerateWodelWizard.savedConfiguration.customOCL;
		}
		customOCLFieldEditor.setStringValue(customOCL);
		customOCLFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				customOCL = event.getNewValue().toString();
			}
		});
		separator = new Label(container, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		if (GenerateWodelWizard.savedConfiguration != null && GenerateWodelWizard.savedConfiguration.file != null) {
			file = GenerateWodelWizard.savedConfiguration.file;
		}
		
		if (file != null) {
			label = new Label(container, SWT.NONE);
			label.setText(file.substring(file.lastIndexOf("\\") + 1));
			label.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		}
		button = new Button(container, SWT.NONE);
		button.setText("Load initial model file");
		button.addSelectionListener(new FileInitialModelSelectionAdapter());
		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		if (file == null) {
			descriptionLabel = new Label(container, SWT.WRAP);
			descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 2, 1));
			descriptionLabel.setText("Select the initial model file.");
			fileLabel = new Label(container, SWT.NONE);
			fileLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			fileLabel.setText("");
		}

//		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
//		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
//		Map<String, String> labelsMap = new HashMap<String, String>();
//		String configurationsFolder = ModelManager.getWorkspaceAbsolutePath() + '/' + WodelContext.getProject() + "/data/configurations/";
//		File configurationsFolderAccess = new File(configurationsFolder);
//		if (configurationsFolderAccess.exists()) {
//			for (File configurationsFileAccess : configurationsFolderAccess.listFiles()) {
//				//String label = configurationsFileAccess.getName().substring(configurationsFileAccess.getName().indexOf(".") + 1, configurationsFileAccess.getName().length());
//				//label = label.substring(0, 1).toUpperCase() + label.substring(1, label.length());
//				String label = configurationsFileAccess.getName();
//				label = label.substring(0, 1).toUpperCase() + label.substring(1, label.length());
//				labelsMap.put(label, configurationsFileAccess.getAbsolutePath());
//			}
//		}
//		String[][] labelAndValues = new String[labelsMap.keySet().size()][2];
//		int i = 0;
//		for (String label : labelsMap.keySet()) {
//			labelAndValues[i][0] = label;
//			labelAndValues[i][1] = labelsMap.get(label);
//			i++;
//		}
		
//		comboFieldEditor = new ComboFieldEditor("Load configuration", "Load configuration", labelAndValues, container);
//		if (GenerateWodelWizard.configurationFile != null) {
//			try {
//				Method methodUpdateComboForValue = ComboFieldEditor.class.getDeclaredMethod("updateComboForValue", String.class);
//				methodUpdateComboForValue.setAccessible(true);
//				methodUpdateComboForValue.invoke(comboFieldEditor, GenerateWodelWizard.configurationFile);
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		comboFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
//			@Override
//			public void propertyChange(PropertyChangeEvent event) {
//				// TODO Auto-generated method stub
//				GenerateWodelWizard.configurationFile = event.getNewValue().toString();
//				setControls();
//				GenerateWodelWizard.secondPage.setControls();
//				GenerateWodelWizard.finalPage.setControls();
//			}
//		});
//		
//		button = new Button(container, SWT.NONE);
//		button.setText("Save configuration");
//		button.addSelectionListener(new FileConfigurationSelectionAdapter());
//		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
//		if (GenerateWodelWizard.configurationFile != null) {
//			configurationDescriptionLabel = new Label(container, SWT.WRAP);
//			configurationDescriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
//					false, 2, 1));
//			configurationDescriptionLabel.setText("The current configuration was saved.");
//			configurationFileLabel = new Label(container, SWT.NONE);
//			configurationFileLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
//			configurationFileLabel.setText("");
//		}
//		else {
//			configurationDescriptionLabel = new Label(container, SWT.WRAP);
//			configurationDescriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
//					false, 2, 1));
//			configurationDescriptionLabel.setText("Set the new configuration file name.");
//			configurationFileLabel = new Label(container, SWT.NONE);
//			configurationFileLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
//			configurationFileLabel.setText("");
//		}
		
//		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
//		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		container.layout();
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,	SWT.DEFAULT));
		
		GenerateWodelWizard.initialPath = file;
		GenerateWodelWizard.customOCL = customOCL;

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

	private class FileInitialModelSelectionAdapter extends SelectionAdapter {

		FileInitialModelSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			file = null;
			if (GenerateWodelWizard.savedConfiguration != null) {
				GenerateWodelWizard.savedConfiguration.file = null;
			}
			FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
			dlg.setFilterNames(extensions);
			dlg.setFilterExtensions(extensions);
			file = dlg.open();
			if (file != null) {
				try {
					valid = ModelManager.validateModel(metamodel, file);
				} catch (MetaModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (valid != true) {
					updateStatus("The model is not valid.");
				}
			}
			else {
				updateStatus(null);
			}
			if (GenerateWodelWizard.savedConfiguration != null) {
				GenerateWodelWizard.savedConfiguration.file = file;
			}
			setControls();
			IWizardContainer container = getContainer();
			container.updateButtons();
		}
	}
	
	private void dialogChanged() {
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
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
