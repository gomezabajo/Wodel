package anatlyzer.atl.editor.compare;
import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.atl.adt.ui.text.AtlSourceViewerConfiguration;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ITextEditor;

import anatlyzer.atl.editor.AtlEditorExt;

public class ATLTextViewer extends TextMergeViewer {
	
	public ATLTextViewer(Composite parent, CompareConfiguration configuration) {
		super(parent, configuration);
	}

	protected void configureTextViewer(TextViewer textViewer) {
		if(textViewer instanceof ISourceViewer){
			ITextEditor editor = (ITextEditor) new AtlEditorExt();		

			AtlSourceViewerConfiguration atlConfiguration = new AtlSourceViewerConfiguration(AtlUIPlugin.getDefault().getTextTools(), editor);
			((ISourceViewer)textViewer).configure(atlConfiguration);
		}
	}

}