package wodeltest.run.utils;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A field editor for adding space to a preference page.
 */
public class SeparatorFieldEditor extends FieldEditor {
	private Label label;

	// All labels can use the same preference name since they don't
	// store any preference.
	public SeparatorFieldEditor(Composite parent) {
		super("label", "", parent);
	}

	// Adjusts the field editor to be displayed correctly
	// for the given number of columns.
	protected void adjustForNumColumns(int numColumns) {
		((GridData) label.getLayoutData()).horizontalSpan = numColumns;
	}

	// Fills the field editor's controls into the given parent.
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));
	}

	// Returns the number of controls in the field editor.
	public int getNumberOfControls() {
		return 1;
	}

	// Labels do not persist any preferences, so these methods are empty.
	protected void doLoad() {
	}
	protected void doLoadDefault() {
	}
	protected void doStore() {
	}
}
