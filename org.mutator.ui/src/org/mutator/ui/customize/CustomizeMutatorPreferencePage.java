package org.mutator.ui.customize;

import mutpostprocessor.run.IPostprocessor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

public class CustomizeMutatorPreferencePage extends LanguageRootPreferencePage {

    @Override
    protected void createFieldEditors() {
    	new LabelFieldEditor("Choose wich extension you would like to apply for postprocessing", getFieldEditorParent());
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"MutPostprocessor.postprocessor");
			for (int j = 0; j < extensions.length; j++) {
				IPostprocessor src = null;
				try {
					src = (IPostprocessor) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addField(new BooleanFieldEditor(src.getName(), src.getName(), getFieldEditorParent()));
			}
		}
    	new LabelFieldEditor("Check this box if you want to generate a registry of the mutations", getFieldEditorParent());
    	addField(new BooleanFieldEditor("Generate registry", "Generate registry", getFieldEditorParent()));
    	new LabelFieldEditor("Write which number of attempts will be executed until assuring mutant is unique", getFieldEditorParent());
    	addField(new StringFieldEditor("Number of attempts", "Number of attempts", 8, getFieldEditorParent()));
    }
    @Override
    public void init(IWorkbench workbench) {
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"MutPostprocessor.postprocessor");
			for (int j = 0; j < extensions.length; j++) {
				IPostprocessor src = null;
				try {
					src = (IPostprocessor) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				getPreferenceStore().setDefault(src.getName(), false);
			}
		}
    }
}