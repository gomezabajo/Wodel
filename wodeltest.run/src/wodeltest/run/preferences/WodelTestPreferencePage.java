package wodeltest.run.preferences;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodeltest.run.utils.MutatorHelper;
import wodeltest.run.utils.SeparatorFieldEditor;

public class WodelTestPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	protected List<BooleanFieldEditor> fieldEditors = new ArrayList<BooleanFieldEditor>();
	protected List<String> labelNames = new ArrayList<String>();
	protected RadioGroupFieldEditor selectAll = null;
	protected BooleanFieldEditor parallelize = null;
	protected StringFieldEditor parallel = null;
	
	@Override
    protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();

		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		}
		IProject project = null;
		if (window != null) {
			if (window != null && window.getPages() != null && window.getPages()[0] != null && window.getPages()[0].getEditorReferences() != null && window.getPages()[0].getEditorReferences() != null && window.getPages()[0].getEditorReferences().length > 0 && window.getPages()[0].getEditorReferences()[0] instanceof IEditorReference) {
		    	IEditorReference[] editors = window.getActivePage().getEditorReferences();
		    	if (editors != null && editors.length > 0) {
		    		for (IEditorReference editor : editors) {
		    			IEditorPart part = editor.getEditor(true);
		    			if (part != null) {
		    				IFile file = (IFile) part.getEditorInput().getAdapter(IFile.class);
		    				if (file != null) {
		    					project = file.getProject();
		    					break;
		    				}
		    			}
		    		}
		    	}
			}
		}
	    if (project == null && window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        if (selection == null) {
	        	return;
	        }
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable)
	        {
	            project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	        }
			if (project == null && selection.getFirstElement() instanceof IProject) {
				project = (IProject) selection.getFirstElement();
			}
			if (project == null && selection.getFirstElement() instanceof IFile) {
				project = ((IFile) selection.getFirstElement()).getProject();
			}
			if (project == null && selection.getFirstElement() instanceof IJavaProject) {
				project = ((IJavaProject) selection.getFirstElement()).getProject();
			}
			if (project == null) {
				return;
			}
	    }
	    final IProject sourceProject = project;
	    //final List<String> testSuitesNames = WodelTestUtils.getTestSuitesNames(sourceProject);
	    
	    Map<String, Map<String, Class<?>>> valueMap = new HashMap<String, Map<String, Class<?>>>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodeltest.extension.MutTesting");
			for (int j = 0; j < extensions.length; j++) {
				String projectName = "";
				Map<String, Class<?>> mutators = null;
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					IWodelTest test =  (IWodelTest) extensionClass.getDeclaredConstructor().newInstance();
					projectName = test.getProjectName();
					MutatorHelper mutatorHelper = new MutatorHelper(test);
					mutators = mutatorHelper.getMutators();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (projectName != null && projectName.length() > 0) {
					valueMap.put(projectName, mutators);
				}
			}
			List<String> valueList = new ArrayList<String>();
			for (String value : valueMap.keySet()) {
				valueList.add(value);
			}

			try {
				addField(new LabelFieldEditor("Wodel-Test plugin extension", composite));
				addField(new SeparatorFieldEditor(composite));
				String ecore = FileLocator.resolve(fileURL).getFile();
				List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
				IPreferenceStore preferenceStore = getPreferenceStore();

				/*
				String[][] values = new String[testSuitesNames.size()][2];
				int index = 0;
				for (String value : testSuitesNames) {
					values[index][0] = value;
					values[index][1] = value;
					index++;
				}
				addField(new LabelFieldEditor("Select the current test-suite shown in Wodel-Test views", composite));
				ComboFieldEditor testSuiteSelector = new ComboFieldEditor("Current test-suite", "", values, composite);
			    addField(testSuiteSelector);
			    preferenceStore.setDefault("Current test-suite", testSuitesNames.get(0));
			    */
			    
				addField(new LabelFieldEditor(" ", composite));
				parallelize = new BooleanFieldEditor("Parallelize mutants execution", "Parallelize mutants execution", composite);
		    	addField(parallelize);
		    	preferenceStore.setDefault("Parallelize mutants execution", false);
		    	List<String> parallelizationModeList = new ArrayList<String>();
		    	parallelizationModeList.add("Static basic");
		    	parallelizationModeList.add("Static improved");
		    	parallelizationModeList.add("Dynamic");
		    	String[][] values = new String[parallelizationModeList.size()][2];
				int index = 0;
				for (String value : parallelizationModeList) {
					values[index][0] = value;
					values[index][1] = value;
					index++;
				}
				new LabelFieldEditor("\n\nParallelization mode", composite);
				ComboFieldEditor combo = new ComboFieldEditor("Parallelization mode", "", values, composite);
				addField(combo);
				preferenceStore.setDefault("Parallelization mode", "Static");
		    	new LabelFieldEditor("\n\nInput the maximum number of mutants that will we executed in parallel", composite);
		    	parallel = new StringFieldEditor("Parallel mutants", "", 10, composite);
		    	addField(parallel);
		    	preferenceStore.setDefault("Parallel mutants", 10);
		    	new LabelFieldEditor(" \n\n", composite);
				String[][] selection = new String[][] {
					{"Select all", "all"},
					{"Deselect all", "none"} };
				selectAll = new RadioGroupFieldEditor("selection", "Selection helper", 1, selection, composite); 
				addField(selectAll);
				preferenceStore.setDefault("selection", true);
				labelNames.clear();
				for (String projectName : valueList) {
					addField(new LabelFieldEditor(projectName, composite));
					for (String mutatorName : valueMap.get(projectName).keySet()) {
						Class<?> cls = valueMap.get(projectName).get(mutatorName);
						Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath(cls) + "/" + mutatorName + ".model");
						EObject program = ModelManager.getObjectsOfType("Program", model).get(0);
						String description = ModelManager.getStringAttribute("description", program);
						String label = mutatorName + (description != null ? ": " + description : "");
						addField(new LabelFieldEditor(label, composite));
						List<EObject> blocks = MutatorUtils.getBlocks(model);
						for (EObject block : blocks) {
							String name = ModelManager.getStringAttribute("name", block);
							description = ModelManager.getStringAttribute("description", block);
							label = name + (description != null ? ": " + description : "");
							BooleanFieldEditor fieldEditor = new BooleanFieldEditor(name, label, composite);
							addField(fieldEditor);
							fieldEditors.add(fieldEditor);
							labelNames.add(name);
							preferenceStore.setDefault(name, true);
						}
						addField(new SeparatorFieldEditor(composite));
					}
				}
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
	
	private class SelectDeselectAll implements IPropertyChangeListener {

		private FieldEditorPreferencePage page;
		private Composite parent;

	    public SelectDeselectAll(FieldEditorPreferencePage page, Composite composite) {
	        this.page = page;
	        this.parent = composite;
	    }
	    
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			IPreferenceStore preferenceStore = getPreferenceStore();
			String value = (String) event.getNewValue();
			if (value.equals("all")) {
				for (String labelName : labelNames) {
					preferenceStore.setValue(labelName, true);
				}
				for (BooleanFieldEditor fieldEditor : fieldEditors) {
					fieldEditor.load();
				}
			}
			if (value.equals("none")) {
				for (String labelName : labelNames) {
					preferenceStore.setValue(labelName, false);
				}
				for (BooleanFieldEditor fieldEditor : fieldEditors) {
					fieldEditor.load();
				}
			}
		}
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, "WodelTest"));
        setDescription("Parallelize execution and select which mutation operators you would like to apply");
	}
	
	@Override
	protected void initialize() {
	    super.initialize();
	    if (selectAll != null) {
		    selectAll.setPropertyChangeListener(new SelectDeselectAll(this, getFieldEditorParent()));
	    }
	}
}
