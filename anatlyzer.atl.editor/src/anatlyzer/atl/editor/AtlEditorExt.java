package anatlyzer.atl.editor;

import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.ui.texteditor.ITextEditor;

public class AtlEditorExt extends AtlEditor implements ITextEditor {

	public AtlEditorExt() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void initializeEditor() {
		// TODO Auto-generated method stub
		super.initializeEditor();

		setSourceViewerConfiguration(new AtlSourceViewerConfigurationExt(
				AtlUIPlugin.getDefault().getTextTools(), this));
	}

}
