package wodel.dsls.ui.customize;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

/**
 * @author Pablo Gomez-Abajo - Wodel Footprints preferences page
 *
 */

public class WodelFootprintsPreferencePage extends LanguageRootPreferencePage {
	
    @Override
    protected void createFieldEditors() {
    	Composite composite = getFieldEditorParent();
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Filter concrete classes", "Filter concrete classes", composite));
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Generate net mutant footprints", "Generate net mutant footprints", composite));
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Generate debug mutant footprints", "Generate debug mutant footprints", composite));
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Base footprints", "Base footprints", composite));
    }
}
