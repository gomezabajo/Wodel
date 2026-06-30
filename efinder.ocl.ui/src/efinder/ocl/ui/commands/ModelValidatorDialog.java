package efinder.ocl.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ocl.xtext.completeocl.ui.CompleteOCLEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class ModelValidatorDialog extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if ( editor instanceof CompleteOCLEditor ) {
			IXtextDocument xtextDocument = EditorUtils.getActiveXtextEditor().getDocument();
			xtextDocument.readOnly(new IUnitOfWork<Void, XtextResource>() {

				@Override
				public java.lang.Void exec(XtextResource r) throws Exception {
					execDialog(r);
					return null;
				}

			 });			
			
//			CompleteOCLEditor oclEditor = (CompleteOCLEditor) editor;
//			IEditorInput input = oclEditor.getEditorInput();
//			oclEditor.getDocument().get
//			System.out.println(input);
		}
		System.out.println(editor);
		// TODO: Implement a wizard
		return null;
	}

	protected void execDialog(XtextResource r) {		
		// new ResourceToLibrary().translate(doc);
	}

}
