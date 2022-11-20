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
		String[][] values = new String[5][2];
		values[0][0] = "";
		values[0][1] = "";
		values[1][0] = "Web";
		values[1][1] = "Web";
		values[2][0] = "Moodle";
		values[2][1] = "Moodle";
		values[3][0] = "AndroidApp";
		values[3][1] = "AndroidApp";
		values[4][0] = "iOSApp";
		values[4][1] = "iOSApp";
	    	
    	new LabelFieldEditor("Wodel-Edu mode", composite);
    	ComboFieldEditor combo = new ComboFieldEditor("Wodel-Edu mode", "", values, composite);
    	addField(combo);
    	
    	composite = getFieldEditorParent();
		values = new String[3][2];
		values[0][0] = "";
		values[0][1] = "";
		values[1][0] = "Dot";
		values[1][1] = "Dot";
		values[2][0] = "Circuit";
		values[2][1] = "Circuit";

    	new LabelFieldEditor(" \n\n", composite);
		new LabelFieldEditor("\n\nModel-Draw mode", composite);
    	combo = new ComboFieldEditor("Model-Draw mode", "", values, composite);
    	addField(combo);
    }
    @Override
    public void init(IWorkbench workbench) {
    	getPreferenceStore().setDefault("Wodel-Edu mode", "Moodle");
    	getPreferenceStore().setDefault("Model-Draw mode", "Dot");
    }
}
