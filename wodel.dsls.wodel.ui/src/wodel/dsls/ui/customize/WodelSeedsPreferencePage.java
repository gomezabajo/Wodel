package wodel.dsls.ui.customize;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

/**
 * @author Pablo Gomez-Abajo - Wodel Seeds generation preferences page
 *
 */

public class WodelSeedsPreferencePage extends LanguageRootPreferencePage {
	
    @Override
    protected void createFieldEditors() {
    	Composite composite = getFieldEditorParent();
    	new LabelFieldEditor("Top number of seed models that will be generated by default", composite);
    	StringFieldEditor field = new StringFieldEditor("Number of seed models", "", 8, composite);
    	IPreferenceStore preferenceStore = doGetPreferenceStore();
    	preferenceStore.setDefault("Number of seed models", "10");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Maximum value for integers", composite);
    	field = new StringFieldEditor("Maximum integer value", "", 8, composite);
    	preferenceStore.setDefault("Maximum integer value", "100");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Minimum value for integers", composite);
    	field = new StringFieldEditor("Minimum value for integers", "", 8, composite);
    	preferenceStore.setDefault("Minimum value for integers", "-100");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Maximum value for reals", composite);
    	field = new StringFieldEditor("Maximum real value", "", 8, composite);
    	preferenceStore.setDefault("Maximum real value", "100");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Minimum value for reals", composite);
    	field = new StringFieldEditor("Minimum real value", "", 8, composite);
    	preferenceStore.setDefault("Minimum real value", "0");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Maximum value for strings", composite);
    	field = new StringFieldEditor("Maximum string value", "", 8, composite);
    	preferenceStore.setDefault("Maximum string value", "10");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Maximum cardinality for objects", composite);
    	field = new StringFieldEditor("Maximum cardinality for objects value", "", 8, composite);
    	preferenceStore.setDefault("Maximum cardinality for objects value", "10");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Maximum cardinality for associations", composite);
    	field = new StringFieldEditor("Maximum cardinality for associations value", "", 8, composite);
    	preferenceStore.setDefault("Maximum cardinality for associations value", "10");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Seed models generation timeout (seconds)", composite);
    	field = new StringFieldEditor("Seed models generation timeout", "", 8, composite);
    	preferenceStore.setDefault("Seed models generation timeout", "600");
    	addField(field);
    }
}
