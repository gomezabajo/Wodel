package tinytools.metamodel.visitor.ui;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;

import tinytools.metamodel.visitor.VisitorCreator;
import tinytools.metamodel.visitor.VisitorOptions;

public class GenerateVisitorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if ( selection instanceof IStructuredSelection ) {
			IStructuredSelection s = (IStructuredSelection) selection;
			IFile f = (IFile) s.getFirstElement();
			
			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(URI.createFileURI(f.getLocation().toOSString()), true);
			
			VisitorOptionsDialog dialog = new VisitorOptionsDialog(HandlerUtil.getActiveShell(event));
			VisitorOptions options = dialog.show();
			if ( options != null ) {
				try {
					new VisitorCreator().compile(r, options);
				} catch (IOException e) {
					MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error", e.getMessage());
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}

}
