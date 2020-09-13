package wodeledu.dsls.ui.customize;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

/**
 * @author Pablo Gomez-Abajo - Wodel-Edu General preferences page
 *
 */

public class WodelEduGeneralPreferencePage extends LanguageRootPreferencePage {
	
    @Override
    protected void createFieldEditors() {
    	Composite composite = getFieldEditorParent();
		String[][] values = new String[3][2];
		values[0][0] = "";
		values[0][1] = "";
		values[1][0] = "Web";
		values[1][1] = "Web";
		values[2][0] = "Moodle";
		values[2][1] = "Moodle";
	    	
    	new LabelFieldEditor("Wodel-Edu mode", composite);
    	ComboFieldEditor combo = new ComboFieldEditor("Wodel-Edu mode", "", values, composite);
    	addField(combo);
    }
    @Override
    public void init(IWorkbench workbench) {
    	getPreferenceStore().setDefault("Wodel-Edu mode", "Web");
    }
}
