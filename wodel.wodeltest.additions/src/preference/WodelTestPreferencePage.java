package preference;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.MutatorUtils;
import utils.LabelFieldEditor;
import utils.MutatorHelper;
import utils.SeparatorFieldEditor;
import manager.IWodelTest;

public class WodelTestPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	@Override
    protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();

		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IProject project = null;
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable)
	        {
	            project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	        }
	    }
		Map<String, Map<String, Class<?>>> valueMap = new HashMap<String, Map<String, Class<?>>>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.wodeltest.MutTest");
			for (int j = 0; j < extensions.length; j++) {
				String projectName = "";
				Map<String, Class<?>> mutators = null;
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					IWodelTest test =  (IWodelTest) extensionClass.newInstance();
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
				}
				if (projectName.length() > 0) {
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
						IPreferenceStore preferenceStore = getPreferenceStore();
						for (EObject block : blocks) {
							String name = ModelManager.getStringAttribute("name", block);
							description = ModelManager.getStringAttribute("description", block);
							label = name + (description != null ? ": " + description : "");
							addField(new BooleanFieldEditor(name, label, composite));
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

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, "WodelTest"));
        setDescription("Select which mutation operators you would like to apply");
	}
}
