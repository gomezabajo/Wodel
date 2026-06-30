package tinytools.text.textresource2xmi.popup.actions;

import java.io.IOException;

import tinytools.text.textresource2xmi.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class TextResource2XMI implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	
	/**
	 * Constructor for Action1.
	 */
	public TextResource2XMI() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IFile f = (IFile) ((IStructuredSelection) selection).getFirstElement();

		// Perhaps in the future I need to access the extension registry to see specific
		// details of Xtext: 
		/*
		IExtensionRegistry registroExtensiones = Platform.getExtensionRegistry();
		
	    IConfigurationElement[] extensions = registroExtensiones
	            .getConfigurationElementsFor(EXTENSION_POINT_ID);
		
	    for(int i = 0; i < extensions.length; i++) {
	    	extensions[i].getChildren(name)
	    }
	    */

		
        ResourceSet rs = new ResourceSetImpl();

		System.out.print("Exporting file: " + f.getFullPath() + " ... ");
		
        Resource r = rs.getResource(URI.createPlatformResourceURI(f.getFullPath().toPortableString(), true), true);

        String dest = f.getFullPath().toPortableString() + ".xmi";
        Resource target = rs.createResource(URI.createPlatformResourceURI(dest, true));
        target.getContents().addAll(r.getContents());

        try {
            target.save(null);
        } catch (IOException e) {
            e.printStackTrace();
            ErrorDialog.openError(shell, "Error", "Cannot save XMI file.\n" + e.getMessage(), 
            		new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
    	}
        
        System.out.println(" Done!");
        
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
	}

}
