/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package wodel.synthesizer.generator;

import manager.ModelManager;
import manager.MutatorUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel seed models synthesizer Wizard page.
 * 
 */

public class GenerateWodelWizardMainPage extends WizardPage {
	
	private String[] extensions;
	private StringFieldEditor numberOfSeedsFieldEditor;
	private Button forceSeedRoot;
	private Label separator;
	private Composite container;
	private ScrolledComposite scrolledComposite;

	private ISelection selection;
	private String metamodel;
	private org.eclipse.swt.widgets.List mutatorBlockSelector;
	private List<String> blockNames = new ArrayList<String>();
	
	public boolean valid = false;
	public int numSeeds = 3;
	public String customOCL = "";
	public boolean forceRoot = true;
	public List<String> selectedBlockNames = new ArrayList<String>();
	public Map<String, Integer> numObjects = new HashMap<String, Integer>();
	public Map<String, SimpleEntry<String, String>> tagsByClass = new HashMap<String, SimpleEntry<String, String>>();
	public String file;


	/**
	 * Constructor for GenerateWodelWizardPage.
	 * 
	 * @param selection
	 */
	public GenerateWodelWizardMainPage(ISelection selection) {
		super("wizardMainPage");
		setTitle("Seed Models Generator");
		setDescription("This wizard generates seed models.");
		this.selection = selection;
		this.metamodel = ModelManager.getMetaModel();
		IFile mutatorFile = GenerateWodelWizard.file;
		Bundle bundle = Platform.getBundle("wodel.models");
		URL mutatorURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		blockNames.add("*");
		try {
			String mutatorecore = FileLocator.resolve(mutatorURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath() + "/" + mutatorFile.getName().replace(".mutator", ".model"));
			List<EObject> blocks = MutatorUtils.getBlocks(model);
			for (EObject block : blocks) {
				String name = ModelManager.getStringAttribute("name", block);
				blockNames.add(name);
			}
//			if (Platform.getExtensionRegistry() != null) {
//				IConfigurationElement[] extensions = Platform
//						.getExtensionRegistry().getConfigurationElementsFor(
//								"wodel.ocl.synthesizer.OCLSynthesizer");
//				
//				IConfigurationElement appropriateExtension = null;
//				for (IConfigurationElement extension : extensions) {
//					Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
//					Object oclSynthesizer =  extensionClass.newInstance();
//					Method getURI = extensionClass.getDeclaredMethod("getURI");
//					List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
//					String uri = (String) getURI.invoke(oclSynthesizer);
//					if (uri.equals(packages.get(0).getNsURI())) {
//						appropriateExtension = extension;
//						break;
//					}
//				}
//				if (appropriateExtension != null) {
//					Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
//					oclSynthesizer = extensionClass.newInstance();
//					Method getEClassNames = extensionClass.getDeclaredMethod("getEClassNames", new Class[]{String.class});
//					classNames = Arrays.asList((String[]) getEClassNames.invoke(oclSynthesizer, metamodel));
//					for (String className : classNames) {
//						System.out.println(className);
//					}
//					Method getEClassesWithAttributeName = extensionClass.getDeclaredMethod("getEClassesWithAttributeName", new Class[] {String.class});
//					classesWithAttributeName = Arrays.asList((String[]) getEClassesWithAttributeName.invoke(oclSynthesizer, metamodel));
//					Method getOCLCode = extensionClass.getDeclaredMethod("getOCLCode", new Class[] {});
//					specificOCLCode = Arrays.asList((String[]) getOCLCode.invoke(oclSynthesizer));
//					Method getClassesWithSpecificNames = extensionClass.getDeclaredMethod("getEClassesWithSpecificNames", new Class[] {String.class});
//					classesWithSpecificNames = Arrays.asList((String[]) getClassesWithSpecificNames.invoke(oclSynthesizer, metamodel));
//					propertiesNamesMethod = extensionClass.getDeclaredMethod("getPropertiesPossibleNames", new Class[] {int[].class});
//					specificOCLCode = Arrays.asList((String[]) getOCLCode.invoke(oclSynthesizer));
//				}
//				//List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
//				//Resource model = ModelManager.loadModel(packages, URI.createURI("file://" + ModelManager.getModelsFolder() + "/" + fileName).toFileString());
//				//Resource model = ModelManager.loadModel(packages, fileName);
//				//if (packages.get(0).getNsURI().equals("http://dfaAutomaton/1.0")) {
//				//	text = DFA2Regex.toRegExp(DFAUtils.convertToDFA(packages, model));
//				//}
//			}
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (InvalidRegistryObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	
//	public Object oclSynthesizer = null;
//	
//	public List<String> classesWithAttributeName = null;
//	
//	public List<String> specificOCLCode = null;
//	
//	public List<String> classesWithSpecificNames = null;
//	
//	public Method propertiesNamesMethod = null;

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
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
		numberOfSeedsFieldEditor = new StringFieldEditor("Number of seed models", "Number of seed models", 8, container);
		if (GenerateWodelWizard.savedConfiguration != null) {
			try {
				Method methodSetStringValue = StringFieldEditor.class.getDeclaredMethod("setStringValue", String.class);
				methodSetStringValue.setAccessible(true);
				methodSetStringValue.invoke(numberOfSeedsFieldEditor, String.format("%s", GenerateWodelWizard.savedConfiguration.numSeeds));
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
			numSeeds = GenerateWodelWizard.savedConfiguration.numSeeds;
		}
		numberOfSeedsFieldEditor.setStringValue(String.format("%d", numSeeds));
		numberOfSeedsFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				numSeeds = Integer.parseInt(event.getNewValue().toString()); 
			}
		});
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		forceSeedRoot = new Button(shell, SWT.CHECK);
		forceSeedRoot.setText("Force the root object");
		if (GenerateWodelWizard.savedConfiguration != null) {
			forceRoot = GenerateWodelWizard.savedConfiguration.forceRoot;
		}
		forceSeedRoot.setSelection(forceRoot);
		forceSeedRoot.addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e)
		    {
		        Button button = (Button) e.widget;
		        forceRoot = button.getSelection();
		    }
		});
		forceSeedRoot.setParent(container);

		separator = new Label(container, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		selectedBlockNames.clear();
		if (GenerateWodelWizard.configurationFile != null) {
			selectedBlockNames.addAll(Arrays.asList(GenerateWodelWizard.savedConfiguration.selectedBlockNames));
		}
		Label mutatorBlockSelectorLabel = new Label(container, SWT.NONE);
		mutatorBlockSelectorLabel.setText("Select mutation operator(s)");
    	mutatorBlockSelector = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
    	for (String blockName : blockNames) {
    		mutatorBlockSelector.add(blockName);
    	}
		if (GenerateWodelWizard.savedConfiguration != null) {
			mutatorBlockSelector.setSelection(GenerateWodelWizard.savedConfiguration.selectedBlockNames);
		}

    	mutatorBlockSelector.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			selectedBlockNames.clear();
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
    			if (selectionIndices[0] == 0) {
    				selectedBlockNames.add(blockNames.get(0));
    			}
    			else {
    				for (int i = 0; i < selectionIndices.length; i++) {
    					selectedBlockNames.add(blockNames.get(selectionIndices[i]));
    				}
    			}
		    }
    	});

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
//		
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
		
		GenerateWodelWizard.numSeeds = numSeeds;
		GenerateWodelWizard.customOCL = customOCL;
		GenerateWodelWizard.forceRoot = forceRoot;
		if (selectedBlockNames != null && selectedBlockNames.size() > 0) {
			GenerateWodelWizard.blockNames = selectedBlockNames;
		}
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
