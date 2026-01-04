package wodel.utils.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Multi-project-safe utilities for Wodel projects.
 *
 * Key idea: DO NOT keep a single global "currentProject".
 * Resolve project/file from the active UI context (editor/selection) and
 * keep per-window "last used project" as a fallback.
 */
public final class ProjectUtils {

	public static final String NATURE_ID = "wodel.project.wodelNature";
	private static final String EXCLUDED_NATURE = "wodeltest.extension.wodelTestSUTNature";

	/**
	 * Remembers the last resolved Wodel project per workbench window.
	 * WeakHashMap avoids leaking windows.
	 */
	private static final Map<IWorkbenchWindow, IProject> LAST_PROJECT_BY_WINDOW =
			Collections.synchronizedMap(new WeakHashMap<>());

	private ProjectUtils() {}

	// ---------------------------------------------------------------------
	// Public API: project resolution
	// ---------------------------------------------------------------------

	/** Returns all OPEN Wodel projects in the workspace. */
	public static List<IProject> getOpenWodelProjects() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject[] projects = root.getProjects();

		List<IProject> wodelProjects = new ArrayList<>();
		for (IProject p : projects) {
			if (isWodelProject(p)) {
				wodelProjects.add(p);
			}
		}
		wodelProjects.sort(Comparator.comparing(IProject::getName, String.CASE_INSENSITIVE_ORDER));
		return wodelProjects;
	}

	/**
	 * Best-effort resolution of the active Wodel project:
	 * 1) active editor -> file -> project
	 * 2) selection -> resource -> project
	 * 3) per-window last project
	 * 4) if exactly one Wodel project exists -> it
	 * Otherwise: empty (caller should decide what to do).
	 */
	public static Optional<IProject> getActiveWodelProject() {
		return ui(() -> {
			IWorkbenchWindow window = getActiveWindowInternal();
			if (window == null) return Optional.empty();

			// 1) Active editor
			Optional<IFile> activeFile = getActiveFileInternal(window);
			if (activeFile.isPresent()) {
				IProject p = activeFile.get().getProject();
				if (isWodelProject(p)) {
					remember(window, p);
					return Optional.of(p);
				}
			}

			// 2) Selection
				Optional<IProject> fromSelection = getProjectFromSelectionInternal(window);
				if (fromSelection.isPresent()) {
					IProject p = fromSelection.get();
					if (isWodelProject(p)) {
						remember(window, p);
						return Optional.of(p);
					}
				}

				// 3) Last used in this window
				IProject last = LAST_PROJECT_BY_WINDOW.get(window);
				if (isWodelProject(last)) {
					return Optional.of(last);
				}

				// 4) Unique Wodel project fallback
				List<IProject> wodelProjects = getOpenWodelProjects();
				if (wodelProjects.size() == 1) {
					remember(window, wodelProjects.get(0));
					return Optional.of(wodelProjects.get(0));
				}

				return Optional.empty();
		});
	}

	/**
	 * Allows callers (e.g., handlers) to explicitly set the "current" project
	 * for the ACTIVE window only (safe with multiple projects).
	 */
	public static void setActiveWindowProject(IProject project) {
		if (!isWodelProject(project)) return;
		ui(() -> {
			IWorkbenchWindow window = getActiveWindowInternal();
			if (window != null) {
				remember(window, project);
			}
			return null;
		});
	}

	// ---------------------------------------------------------------------
	// Public API: file resolution
	// ---------------------------------------------------------------------

	/** Best-effort active file (from active editor first, then selection). */
	public static Optional<IFile> getActiveFile() {
		return ui(() -> {
			IWorkbenchWindow window = getActiveWindowInternal();
			if (window == null) return Optional.empty();
			Optional<IFile> f = getActiveFileInternal(window);
			if (f.isPresent()) return f;

			// from selection if editor doesn't provide a file
			ISelectionService ss = window.getSelectionService();
			if (ss == null) return Optional.empty();
			ISelection sel = ss.getSelection();
			IResource res = extractResource(sel);
			if (res instanceof IFile) return Optional.of((IFile) res);
			return Optional.empty();
		});
	}

	/**
	 * Finds all files with a given extension under a container (project/folder).
	 * Uses proxy visitor (fast, avoids materializing all resources).
	 */
	public static Set<IFile> findFilesByExtension(IContainer root, String extension) throws CoreException {
		Objects.requireNonNull(root, "root");
		Objects.requireNonNull(extension, "extension");

		Set<IFile> result = new LinkedHashSet<>();

		root.accept((IResourceProxyVisitor) proxy -> {
			if (proxy.getType() == IResource.FILE) {
				String name = proxy.getName();
				if (name != null && name.endsWith("." + extension)) {
					IResource r = proxy.requestResource();
					if (r instanceof IFile) {
						result.add((IFile) r);
					}
				}
				return false; // no children under files
			}
			return true; // visit children
		}, IResource.DEPTH_INFINITE);

		return result;
	}

	/**
	 * Convenience: all *.mutator files in <project>/src (or whole project if src missing).
	 */
	public static List<IFile> getMutatorFiles(IProject project) throws CoreException {
		if (!isWodelProject(project)) return List.of();

		IContainer base = project.getFolder("src");
		if (base == null || !base.exists()) {
			base = project;
		}

		List<IFile> files = new ArrayList<>(findFilesByExtension(base, "mutator"));
		files.sort(Comparator.comparing(f -> f.getProjectRelativePath().toString(), String.CASE_INSENSITIVE_ORDER));
		return files;
	}

	/**
	 * Default mutator file choice for a project:
	 * - if active file is a *.mutator in the same project -> it
	 * - else first mutator (sorted) in that project
	 */
	public static Optional<IFile> getDefaultMutatorFile(IProject project) throws CoreException {
		if (!isWodelProject(project)) return Optional.empty();

		Optional<IFile> active = getActiveFile();
		if (active.isPresent()) {
			IFile f = active.get();
			if (project.equals(f.getProject()) && "mutator".equalsIgnoreCase(f.getFileExtension())) {
				return Optional.of(f);
			}
		}

		List<IFile> mutators = getMutatorFiles(project);
		return mutators.isEmpty() ? Optional.empty() : Optional.of(mutators.get(0));
	}

	// ---------------------------------------------------------------------
	// Compatibility helpers (avoid global state)
	// ---------------------------------------------------------------------

	public static IProject getProject() {
		return getActiveWodelProject().orElse(null);
	}

	public static void setProject(IProject project) {
		setActiveWindowProject(project);
	}

	// ---------------------------------------------------------------------
	// Wodel project check
	// ---------------------------------------------------------------------

	public static boolean isWodelProject(IProject project) {
		try {
			return project != null
					&& project.exists()
					&& project.isOpen()
					&& project.hasNature(JavaCore.NATURE_ID)
					&& project.hasNature(NATURE_ID)
					&& !project.hasNature(EXCLUDED_NATURE);
		} catch (CoreException e) {
			return false;
		}
	}

	// ---------------------------------------------------------------------
	// Internal UI-context helpers
	// ---------------------------------------------------------------------

	private static void remember(IWorkbenchWindow window, IProject project) {
		if (window != null && project != null) {
			LAST_PROJECT_BY_WINDOW.put(window, project);
		}
	}

	private static IWorkbenchWindow getActiveWindowInternal() {
		if (!PlatformUI.isWorkbenchRunning()) return null;
		IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) return null;

		IWorkbenchWindow w = wb.getActiveWorkbenchWindow();
		if (w != null) return w;

		IWorkbenchWindow[] ws = wb.getWorkbenchWindows();
		return (ws != null && ws.length > 0) ? ws[0] : null;
	}

	private static Optional<IFile> getActiveFileInternal(IWorkbenchWindow window) {
		IWorkbenchPage page = (window != null) ? window.getActivePage() : null;
		if (page == null) return Optional.empty();

		IEditorPart editor = page.getActiveEditor();
		if (editor == null) return Optional.empty();

		IEditorInput input = editor.getEditorInput();
		if (input == null) return Optional.empty();

		IFile file = input.getAdapter(IFile.class);
		return Optional.ofNullable(file);
	}

	private static Optional<IProject> getProjectFromSelectionInternal(IWorkbenchWindow window) {
		ISelectionService ss = (window != null) ? window.getSelectionService() : null;
		if (ss == null) return Optional.empty();

		ISelection sel = ss.getSelection();
		IResource res = extractResource(sel);
		if (res == null) return Optional.empty();

		IProject p = res.getProject();
		return Optional.ofNullable(p);
	}

	private static IResource extractResource(ISelection sel) {
		if (!(sel instanceof IStructuredSelection)) return null;

		Object element = ((IStructuredSelection) sel).getFirstElement();
		if (element instanceof IResource) return (IResource) element;

		// Try adaptable pattern
		if (element instanceof org.eclipse.core.runtime.IAdaptable) {
			return ((org.eclipse.core.runtime.IAdaptable) element).getAdapter(IResource.class);
		}
		return null;
	}

	/**
	 * Runs supplier on UI thread (sync) and returns result.
	 * Safe to call from background jobs without deadlocking the workbench thread.
	 */
	private static <T> T ui(Supplier<T> supplier) {
	    // If there is no UI workbench, do not touch SWT at all.
	    if (!PlatformUI.isWorkbenchRunning()) {
	        return supplier.get();
	    }

	    var display = PlatformUI.getWorkbench().getDisplay();
	    if (display == null || display.isDisposed()) {
	        return supplier.get();
	    }

	    // Already on UI thread
	    if (display.getThread() == Thread.currentThread()) {
	        return supplier.get();
	    }

	    AtomicReference<T> ref = new AtomicReference<>();
	    AtomicReference<RuntimeException> err = new AtomicReference<>();

	    display.syncExec(() -> {
	        try {
	            ref.set(supplier.get());
	        } catch (RuntimeException ex) {
	            err.set(ex);
	        }
	    });

	    if (err.get() != null) throw err.get();
	    return ref.get();
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

	public static Set<String> getFiles(IProject project, String extension) {
		Set<String> fs = new LinkedHashSet<String>();
		File projectFolder = new File(project.getLocation().toFile().getPath());
		if (!(projectFolder.listFiles() == null || projectFolder.listFiles().length == 0)) {
			fs.addAll(getFiles(projectFolder.listFiles(), extension));
		}
		return fs;
	}

	
	public static String getFileName(IProject project) {
		String filename = null;

		IFile currentFile = getActiveFile().get();
		if (currentFile != null) {
			//filename = WodelContext.getFileName();
			filename = currentFile.getName();
			if (!filename.endsWith(".mutator") && project != null) {
				Set<String> fileNames = ProjectUtils.getFiles(project, "mutator");
				if (fileNames == null || fileNames.size() == 0) {
					return null;
				}
				filename = new ArrayList<String>(fileNames).get(0);
			}
		}
		else if (project != null) {
			Set<String> fileNames = ProjectUtils.getFiles(project, "mutator");
			if (fileNames == null || fileNames.size() == 0) {
				return null;
			}
			filename = new ArrayList<String>(fileNames).get(0);
		}
		return filename;
	}
}
