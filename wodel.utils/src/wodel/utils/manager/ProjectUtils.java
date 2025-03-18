package wodel.utils.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ProjectUtils {
	
	public static final String NATURE_ID = "wodel.project.wodelNature";
	
	private static ISelection selection = null;
	private static IWorkbenchWindow window = null;
	private static IProject currentProject = null;
	
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

	private static IFile getSelectedFile()
	{
		IFile file = null;
		String fileName = null;
		if (currentProject != null) {
			List<String> fileNames = new ArrayList<String>(ProjectUtils.getFiles("mutator"));
			if (fileNames == null || fileNames.size() == 0) {
				return null;
			}
			fileName = new ArrayList<String>(fileNames).get(0);
		}
		else if (projectsAreReady() != null) {
			List<String> fileNames = new ArrayList<String>(ProjectUtils.getFiles("mutator"));
			if (fileNames == null || fileNames.size() == 0) {
				return null;
			}
			fileName = new ArrayList<String>(fileNames).get(0);
		}
		else {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
			ISelectionService selectionService = windows[0].getSelectionService();
			ISelection structuredSelection = selectionService.getSelection();
			IResource element = extractSelection(structuredSelection);
			if (element instanceof IFile) {
				file = (IFile) element;
				fileName = file.getName();
				setProject(file.getProject());
			}
		}
		if (currentProject != null && fileName != null && fileName.length() > 0) {
			file = currentProject.getFolder("src").getFile(fileName);
		}
		return file;
	}
	
	private static IProject getSelectedProject() {
		if (currentProject != null) {
			return currentProject;
		}
		else if (projectsAreReady() != null) {
			return currentProject;
		}
		else {
            try {
    			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
                String workspacePath = workspaceRoot.getLocation().toFile().getPath();
				workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	            File workspaceFolder = new File(workspacePath);
	            if (workspaceFolder.listFiles() != null) {
		            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
		                if (workspaceProjectFolder.isDirectory()) {
		                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
		                    if (isWodelProject(workspaceProject)) {
		                        setProject(workspaceProject);
		                        return workspaceProject;
		                    }
		                }
		            }
	            }
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return currentProject;
	}
	
	public static IProject projectsAreReady() {
		currentProject = null;
       	IProject project = null;
       	IFile file = null;
       	if ((file = isReadyFile()) != null) {
       		currentProject = file.getProject();
       		return currentProject;
       	}
    	try {
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            String workspacePath = workspaceRoot.getLocation().toFile().getPath();
            workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            File workspaceFolder = new File(workspacePath);
            if (workspaceFolder.listFiles() != null) {
	            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
	                if (workspaceProjectFolder.isDirectory()) {
	                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
	                    if (isWodelProject(workspaceProject)) {
	                        project = workspaceProject;
	                        setProject(project);
	                        return project;
	                    }
	                }
	            }
            }
		} catch (Exception e) {
		}

	    return project;
	}
	
	public static IFile isReadyFile() {
		try {
			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		} catch (Exception ex) {
			return null;
		}
		if (window == null) {
			window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		}
//	    if (window != null && window.getActivePage() != null && window.getActivePage().getSelection() != null && window.getActivePage().getSelection() instanceof IStructuredSelection)
//	    {
//	        selection = (IStructuredSelection) window.getActivePage().getSelection();
//	        if (selection != null) {
//	        	file = getFile(selection);
//	        }
//	    }
		IFile file = null;
	    if (window != null && window.getPages() != null && window.getPages()[0] != null && window.getPages()[0].getEditorReferences() != null && window.getPages()[0].getEditorReferences() != null && window.getPages()[0].getEditorReferences().length > 0 && window.getPages()[0].getEditorReferences()[0] instanceof IEditorReference) {
	    	IEditorReference[] editors = window.getPages()[0].getEditorReferences();
	    	if (editors != null && editors.length > 0) {
	    		for (IEditorReference editor : editors) {
	    			IEditorPart part = editor.getEditor(true);
	    			if (part != null) {
	    				file = getFile(part);
	    				if (file != null && file.getFileExtension().equals("mutator")) {
	    					break;
	    				}
	    			}
	    		}
	    	}
	    }
	    if (file != null && !isWodelProject(file.getProject())) {
	    	return null;
	    }
	    return file;
	}

	public static IProject getProject() {
		if (currentProject != null) {
			return currentProject;
		}
		IProject project = getSelectedProject();
		IFile file = null;
		if (project == null) {
			file = isReadyFile();
			if (file != null) {
				project = file.getProject();
			}
		}
		try {
			if (project == null || !(project.hasNature(JavaCore.NATURE_ID) && project.hasNature(NATURE_ID))) {
				project = projectsAreReady();
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (project != null && project.hasNature(JavaCore.NATURE_ID) && project.hasNature(NATURE_ID)) {
				setProject(project);
				Set<String> fileNames = ProjectUtils.getFiles("mutator");
				if (fileNames == null || fileNames.size() == 0) {
					return project;
				}
				String fileName = new ArrayList<String>(fileNames).get(0);
				if (currentProject != null) {
					file = currentProject.getFolder("src").getFile(fileName);
				}
				else {
					file = project.getFolder("src").getFile(fileName);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}
	
	public static void setProject(IProject project) {
		if (isWodelProject(project)) {
			currentProject = project;
		}
	}
	
	public static IFile getFile() {
		IFile file = null;
		if ((file = isReadyFile()) == null) {
			return null;
		}
		return file;
	}
	
	public static IWorkbenchWindow getWorkbenchWindow() {
		if (isReadyFile() == null) {
			return null;
		}
		return window;
	}

	public static ISelection getSelection() {
		if (isReadyFile() == null) {
			return null;
		}
		return selection;
	}
	
	private static Set<String> getFiles(File[] files, String extension) {
		Set<String> fs = new LinkedHashSet<String>();
		int i = 0;
		while (files != null && i < files.length) {
			File file = files[i];
			if (file.isFile() == true) {
				if (file.getName().endsWith("." + extension)) {
					String f = file.getName();
					fs.add(f);
				}
			}
			else {
				Set<String> nextFiles = getFiles(file.listFiles(), extension);
				fs.addAll(nextFiles);
			}
			i++;
		}
		return fs;
	}

	public static Set<String> getFiles(String extension) {
		Set<String> fs = new LinkedHashSet<String>();
		if (currentProject == null) {
			return fs;
		}
		else if (currentProject != null) {
			File projectFolder = new File(currentProject.getLocation().toFile().getPath());
			if (!(projectFolder.listFiles() == null || projectFolder.listFiles().length == 0)) {
				fs.addAll(getFiles(projectFolder.listFiles(), extension));
			}
		}
		return fs;
	}

	
	public static String getFileName() {
		String filename = null;
		if (currentProject == null) {
			return filename;
		}
		IFile currentFile = getFile();
		IProject currentProject = getProject(); 
		if (currentFile != null) {
			//filename = WodelContext.getFileName();
			filename = currentFile.getName();
			if (!filename.endsWith(".mutator") && currentProject != null) {
				Set<String> fileNames = ProjectUtils.getFiles("mutator");
				if (fileNames == null || fileNames.size() == 0) {
					return null;
				}
				filename = new ArrayList<String>(fileNames).get(0);
			}
		}
		else if (currentProject != null) {
			Set<String> fileNames = ProjectUtils.getFiles("mutator");
			if (fileNames == null || fileNames.size() == 0) {
				return null;
			}
			filename = new ArrayList<String>(fileNames).get(0);
		}
		return filename;
	}

	
	public static boolean isWodelProject(IProject project) {
		try {
			if (project != null && project.exists() && project.isOpen() && project.hasNature(JavaCore.NATURE_ID) && project.hasNature(NATURE_ID) && !project.hasNature("wodeltest.extension.wodelTestSUTNature")) {
				return true;
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
