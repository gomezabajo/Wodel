package mutator.wodeltest.[@**@].utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import wodel.utils.manager.IOUtils;

public class SplitJavaProject {

	public static void run(IProject project, String srcPath, String testPath, String relativeTestPath) {
		if (project == null || srcPath == null || srcPath.length() == 0 || testPath == null || testPath.length() == 0 || relativeTestPath.length() == 0) {
			return;
		}
		
		List<String> folders = new ArrayList<String>();
		folders.add("src");

		List<IProject> referencedProjects = new ArrayList<IProject>();
		referencedProjects.add(project);

		IProgressMonitor monitor = new NullProgressMonitor();

		IClasspathEntry jUnitClasspathEntry = null;
		try {
			final IJavaProject javaProject = JavaCore.create(project);
			final List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
			IClasspathEntry[] entries = javaProject.getRawClasspath();
			classpathEntries.addAll(Arrays.asList(entries));
			for (IClasspathEntry classpathEntry : classpathEntries) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
					if (classpathEntry.getPath().toString().startsWith("org.eclipse.jdt.junit.JUNIT_CONTAINER/")) {
						jUnitClasspathEntry = classpathEntry;
						break;
					}
				}
			}
			if (jUnitClasspathEntry != null) {
				classpathEntries.remove(jUnitClasspathEntry);
			}
			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					monitor);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> containerEntries = new ArrayList<String>();
		containerEntries.add(jUnitClasspathEntry.getPath().toString());
		
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		IProject testSuiteProject = EclipseHelper.createJavaProject(project.getName() + "-test", folders, referencedProjects, containerEntries, monitor, shell, false);
		
		String[] srcFolders = relativeTestPath.split("/");
		if (srcFolders == null || srcFolders.length == 0) {
			return;
		}
		List<String> outFolders = new ArrayList<String>();
		for (String srcFolder : srcFolders) {
			if (srcFolder != null && srcFolder.length() > 0) {
				outFolders.add(srcFolder);
			}
		}
		IFolder src = project.getFolder(new Path(outFolders.get(0)));
		if (src == null) {
			return;
		}
		
		try {
			IFolder test = testSuiteProject.getFolder(new Path(outFolders.get(0)));
			if (test.exists() == false) {
				test.create(true, true, monitor);
			}
			for (String outFolder : outFolders.subList(1, outFolders.size())) {
				test = test.getFolder(new Path(outFolder));
				if (test.exists() == false) {
					test.create(true, true, monitor);
				}
			}
			final File source = new Path(testPath).toFile();
			final File target = test.getRawLocation().makeAbsolute().toFile();
			if ((source != null) && (target != null)) {
				if (jUnitClasspathEntry.getPath().toString().equals("org.eclipse.jdt.junit.JUNIT_CONTAINER/4")) {
					if (source.getName().equals(target.getName())) {
						IOUtils.copyFolderStartingWith(source, target, "Test");
						IOUtils.deleteFolderStartingWith(testPath, "Test");
					}
					else {
						IOUtils.copyFolder(source, target);
						IOUtils.deleteFolder(testPath);
					}
				}
				if (jUnitClasspathEntry.getPath().toString().equals("org.eclipse.jdt.junit.JUNIT_CONTAINER/5")) {
					IOUtils.copyFolder(source, target);
					IOUtils.deleteFolder(testPath);
				}
			}

			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				testSuiteProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException ex) {
				ex.printStackTrace();
			}

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
