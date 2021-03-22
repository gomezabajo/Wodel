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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import exceptions.MetaModelNotFoundException;
import manager.ModelManager;

public class GenerateWodelWizardSecondPage extends WizardPage {

	private ISelection selection;
	private String metamodel;
	public String file;
	private List<StringFieldEditor> numberOfObjectsForEachClass = new ArrayList<StringFieldEditor>();
	private List<StringFieldEditor> tagsOfObjectsForEachClass = new ArrayList<StringFieldEditor>();
	private static String attName = "";
	public List<String> classNames = new ArrayList<String>();
	public Map<String, Integer> numObjects = new HashMap<String, Integer>();
	public Map<String, SimpleEntry<String, String>> tagsByClass = new HashMap<String, SimpleEntry<String, String>>();
	private Label separator;
	private Composite container;
	private ScrolledComposite scrolledComposite;
	public boolean forceRoot = true;
	public int numSeeds = 3;
	public String customOCL = "";
	public List<String> selectedBlockNames = new ArrayList<String>();

	protected GenerateWodelWizardSecondPage(ISelection selection) {
		super("secondWizardPage");
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
		}

		Map<String, List<String>> stringAttributes = new HashMap<String, List<String>>();
		classNames.clear();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			List<EClass> eClasses = new ArrayList<EClass>();
			for (EPackage pck : packages) {
				for (EClassifier classifier : pck.getEClassifiers()) {
					if (classifier instanceof EClass && !eClasses.contains(classifier)) {
						eClasses.add((EClass) classifier);
					}
				}
			}
			for (EClass eClass : eClasses) {
				classNames.add(eClass.getName());
				for (EAttribute att : eClass.getEAllAttributes()) {
					if (att.getEType().getName().equals("EString")) {
						List<String> values = new ArrayList<String>();
						if (stringAttributes.containsKey(eClass.getName())) {
							values = stringAttributes.get(eClass.getName());
						}
						values.add(att.getName());
						stringAttributes.put(eClass.getName(), values);
					}
				}
			}
		} catch (MetaModelNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		numberOfObjectsForEachClass.clear();
		for (String className : classNames) {
			StringFieldEditor numberOfObjectsForCurrentClass = new StringFieldEditor("Objects of class " + className, "Objects of class " + className, 8, container);
			int num = 1;
			if (numObjects.containsKey(className)) {
				num = numObjects.get(className);
			}
			else {
				numObjects.put(className, num);
			}
			numberOfObjectsForCurrentClass.setStringValue(String.format("%d", numObjects.get(className)));
			numberOfObjectsForCurrentClass.setPropertyChangeListener(new IPropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent event) {
					numObjects.put(className, Integer.parseInt(event.getNewValue().toString())); 
				}
			});
			numberOfObjectsForEachClass.add(numberOfObjectsForCurrentClass);
		}
		
		tagsOfObjectsForEachClass.clear();
		for (String className : classNames) {
			if (stringAttributes.containsKey(className)) {
				String[][] values = new String[stringAttributes.get(className).size()][2];
	    		int index = 0;
	    		for (String value : stringAttributes.get(className)) {
	    			values[index][0] = value;
	    			values[index][1] = value;
	    			index++;
	    		}
				ComboFieldEditor stringAttributeForCurrentClassName = new ComboFieldEditor("Select string attribute for " + className, "Select string attribute for " + className, values, container);
				if (GenerateWodelWizard.savedConfiguration != null && GenerateWodelWizard.savedConfiguration.tagsByClass.containsKey(className)) {
					try {
						Method methodUpdateComboForValue = ComboFieldEditor.class.getDeclaredMethod("updateComboForValue", String.class);
						methodUpdateComboForValue.setAccessible(true);
						methodUpdateComboForValue.invoke(stringAttributeForCurrentClassName, GenerateWodelWizard.savedConfiguration.tagsByClass.get(className).getKey());
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
					if (tagsByClass.containsKey(className)) {
						attName = tagsByClass.get(className).getKey();
					}
				}
				stringAttributeForCurrentClassName.setPropertyChangeListener(new IPropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent event1) {
						attName = event1.getNewValue().toString();
					}
				});
				stringAttributeForCurrentClassName.loadDefault();
				StringFieldEditor tagsOfObjectsForCurrentClass = new StringFieldEditor("String labels for " + className, "String labels for " + className, 20, container);
				String tags = "";
				if (tagsByClass.containsKey(className)) {
					tags = tagsByClass.get(className).getValue();  
				}
				tagsOfObjectsForCurrentClass.setStringValue(tags);
				tagsOfObjectsForCurrentClass.setPropertyChangeListener(new IPropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent event2) {
						if (attName != null && attName.length() > 0)
						tagsByClass.put(className, new SimpleEntry<String, String>(attName, event2.getNewValue().toString())); 
					}
				});
				tagsOfObjectsForEachClass.add(tagsOfObjectsForCurrentClass);
			}
		}

		separator = new Label(container, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
//
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
//				GenerateWodelWizard.mainPage.setControls();
//				setControls();
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
		
		GenerateWodelWizard.classNames = classNames;
		GenerateWodelWizard.numObjects = numObjects;
		GenerateWodelWizard.tagsByClass = tagsByClass;

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
