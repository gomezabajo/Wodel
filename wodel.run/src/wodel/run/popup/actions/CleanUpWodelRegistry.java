package wodel.run.popup.actions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

public class CleanUpWodelRegistry extends AbstractHandler {

    private static Resource wodelLocal = null;
    
    private ClassLoader projectClassLoader;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
    	
    	try {
			Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, new NullProgressMonitor());
		} catch (OperationCanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        IFile file = getSelectedFile(event);
        if (file == null) {
            return null;
        }

        final IProject project = file.getProject();
        final String workspacePath = Platform.getLocation().toFile().getPath().replace("\\", "/");

        // --- Load wodel model ---
        String filename = ProjectUtils.getActiveFile().get().getFullPath().toString();
        String xmiFilename = buildXmiPath(filename);
        List<EPackage> wodelPackages = loadWodelPackages(project.getName());
        if (wodelPackages == null || wodelPackages.isEmpty()) {
            return null;
        }

        wodelLocal = loadWodelModel(wodelPackages, xmiFilename);
        if (wodelLocal == null) {
            return null;
        }
        
        String pathToModels = ModelManager.getOutputPath().replace("\\", "/");
        
        File folderToModels = new File(pathToModels);
        if (folderToModels != null && folderToModels.exists() && folderToModels.isDirectory()) {
        	File[] filesToModels = folderToModels.listFiles();
        	if (filesToModels != null && filesToModels.length > 0) {
        		for (File fileToModels : filesToModels) {
        			if (fileToModels != null && fileToModels.exists() && fileToModels.isDirectory()) {
        				cleanFollowupsRegistry(fileToModels);
        			}
        		}
        	}
        }        return null;
    }
    
    // ------------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------------

    private IFile getSelectedFile(ExecutionEvent event) {
        try {
            IStructuredSelection selection =
                    (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
            Object element = selection.getFirstElement();
            if (element instanceof IFile) {
                return (IFile) element;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private List<EPackage> loadWodelPackages(String projectName) {
        try {
            Bundle bundle = Platform.getBundle("wodel.models");
            URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
            String ecore = FileLocator.resolve(fileURL).getFile();
            return ModelManager.loadMetaModel(ecore);
        } catch (MetaModelNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Resource loadWodelModel(List<EPackage> gottenPackages, String xmiFilename) {
        try {
            return ModelManager.loadModel(gottenPackages, xmiFilename.replace("\\", "/"));
        } catch (ModelNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private String buildXmiPath(String wodelFileName) {
        // safer than replaceAll(".gotten", ".model") because "." is regex
        String base = wodelFileName;
        int idx = base.lastIndexOf(".mutator");
        if (idx != -1) {
            base = base.substring(0, idx);
        }
        return ModelManager.getOutputPath().replace("\\", "/") + "/" + base + ".model";
    }
    
    private void cleanFollowupsRegistry(File folder) {
    	if (folder != null && folder.exists() && folder.isDirectory()) {
    		if (folder.getName().equals("registry")) {
    			IOUtils.deleteFolder(folder.getPath().replace("\\", "/"));
    		}
    		else {
    			File[] files = folder.listFiles();
    			if (files != null && files.length > 0) {
    				for (File file : files) {
    					if (file != null && file.exists() && file.isDirectory()) {
    						cleanFollowupsRegistry(file);
    					}
    				}
    			}
    		}
    	}
    }
}
