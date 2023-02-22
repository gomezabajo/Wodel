package manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ProjectUtils {
	
	public static final String NATURE_ID = "wodel.project.sampleNature";
	
	private static IProject project = null;
	private static IFile file = null;
	private static ISelection selection = null;
	private static IWorkbenchWindow window = null;
	
	public static String projectName = null;
	
	private static IResource extractSelection(ISelection sel) {
		if (!(sel instanceof IStructuredSelection))
			return null;
		IStructuredSelection ss = (IStructuredSelection) sel;
		Object element = ss.getFirstElement();
		if (element instanceof IResource)
			return (IResource) element;
		if (!(element instanceof IAdaptable))
			return null;
		IAdaptable adaptable = (IAdaptable)element;
		Object adapter = adaptable.getAdapter(IResource.class);
		return (IResource) adapter;
	}


	private static IFile getFile(IEditorPart part)
	{
		return (IFile) part.getEditorInput().getAdapter(IFile.class);
	}

	private static IFile getFile(ISelection structuredSelection)
	{
		IResource element = extractSelection(structuredSelection);
		IFile file = null;
		if (element instanceof IFile) {
			file = (IFile) element;
		}
		return file;
	}
	
	public static boolean isReadyProject() {
        if (project != null) {
            return true;
        }
        try {
            String workspacePath = ModelManager.getWorkspaceAbsolutePath();
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            File workspaceFolder = new File(workspacePath);
            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
                if (workspaceProjectFolder.isDirectory()) {
                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
                    if (workspaceProject.exists() && workspaceProject.isOpen() && workspaceProject.hasNature(JavaCore.NATURE_ID) && workspaceProject.hasNature(NATURE_ID)) {
                        project = workspaceProject;
                        break;
                    }
                }
            }
		} catch (Exception e) {
		}

	    if (project == null) {
	    	return false;
	    }
	    return true;
	}
	
	public static boolean isReadyFile() {
		window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		}
	    if (window != null && window.getSelectionService().getSelection() instanceof IStructuredSelection)
	    {
	        selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        if (selection != null) {
	        	file = getFile(selection);
	        }
	    }
	    if (window != null && window.getSelectionService().getSelection() instanceof ITextSelection) {
	    	IEditorPart part = window.getActivePage().getActiveEditor();
	    	if (part == null) {
	    		part = window.getActivePage().getEditorReferences()[0].getEditor(true);
	    	}
	    	if (part != null) {
	    		file = getFile(part);
	    	}
	    }
	    if (file == null) {
	    	return false;
	    }
	    return true;
	}

	public static IProject getProject() {
		if (isReadyProject() == false) {
			return null;
		}
		return project;
	}
	
	public static void resetProject() {
		project = null;
	}
	
	public static IFile getFile() {
		if (isReadyFile() == false) {
			return null;
		}
		return file;
	}
	
	public static IWorkbenchWindow getWorkbenchWindow() {
		if (isReadyFile() == false) {
			return null;
		}
		return window;
	}

	public static ISelection getSelection() {
		if (isReadyFile() == false) {
			return null;
		}
		return selection;
	}
	
	private static List<String> getFiles(File[] files, String extension) {
		List<String> fs = new ArrayList<String>();
		int i = 0;
		while (files != null && i < files.length) {
			File file = files[i];
			if (file.isFile() == true) {
				if (file.getName().endsWith("." + extension)) {
					String f = file.getName();
					if (!fs.contains(f)) {
						fs.add(f);
					}
				}
			}
			else {
				List<String> nextFiles = getFiles(file.listFiles(), extension);
				for (String nextFile : nextFiles) {
					if (!fs.contains(nextFile)) {
						fs.add(nextFile);
					}
				}
			}
			i++;
		}
		return fs;
	}

	public static List<String> getFiles(String extension) {
		List<String> fs = new ArrayList<String>();
		if (project == null) {
			return fs;
		}
		File projectFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toOSString());
		if (projectFolder.listFiles() == null || projectFolder.listFiles().length == 0) {
			return fs;
		}
		fs = getFiles(projectFolder.listFiles(), extension);
		return fs;
	}

	
	public static String getFileName() {
		String filename = null;
		if (file != null) {
			filename = WodelContext.getFileName();
			if (filename == null) {
				filename = file.getName();
			}
			if (!filename.endsWith(".mutator") && project != null) {
				List<String> fileNames = ProjectUtils.getFiles("mutator");
				if (fileNames == null || fileNames.size() == 0) {
					return null;
				}
				filename = fileNames.get(0);
			}
		}
		else if (project != null) {
			List<String> fileNames = ProjectUtils.getFiles("mutator");
			if (fileNames == null || fileNames.size() == 0) {
				return null;
			}
			filename = fileNames.get(0);
		}
		return filename;
	}
}
