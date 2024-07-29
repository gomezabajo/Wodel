package mutator.wodeltest.WodelTest4Java.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import wodel.utils.manager.IOUtils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class MergeJavaProject {
	
	public static void run(IProject project, IProject testSuiteProject, String srcPath, String testPath) {
		if (project == null || testSuiteProject == null || srcPath == null || srcPath.length() == 0 || testPath == null || testPath.length() == 0) {
			return;
		}

		String[] srcFolders = srcPath.split("/");
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
		for (String srcFolder : outFolders.subList(1, outFolders.size())) {
			src = src.getFolder(new Path(srcFolder));
			if (src == null) {
				return;
			}
		}

		String[] testFolders = testPath.split("/");
		if (testFolders == null || testFolders.length == 0) {
			return;
		}
		List<String> inFolders = new ArrayList<String>();
		for (String testFolder : testFolders) {
			if (testFolder != null && testFolder.length() > 0) {
				inFolders.add(testFolder);
			}
		}
		IFolder test = testSuiteProject.getFolder(new Path(inFolders.get(0)));
		if (test == null) {
			return;
		}
		for (String testFolder : inFolders.subList(1, inFolders.size())) {
			test = test.getFolder(new Path(testFolder));
			if (test == null) {
				return;
			}
		}
		
		IProgressMonitor monitor = new NullProgressMonitor();
		try {
			src = project.getFolder(new Path(inFolders.get(0)));
			if (src == null) {
				return;
			}
			if (src.exists() == false) {
				src.create(true, true, monitor);
			}
			for (String testFolder : inFolders.subList(1, inFolders.size())) {
				src = src.getFolder(new Path(testFolder));
				if (src == null) {
					return;
				}
			}
			final File source = test.getRawLocation().makeAbsolute().toFile();
			final File target = src.getRawLocation().makeAbsolute().toFile();
			if ((source != null) && (target != null)) {
				IOUtils.copyFolder(source, target);
			}
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
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
		
		boolean processOK = false;
		try {
			final IJavaProject testSuiteJavaProject = JavaCore.create(testSuiteProject);
			final List<IClasspathEntry> testSuiteClasspathEntries = new ArrayList<IClasspathEntry>();
			IClasspathEntry[] entries = testSuiteJavaProject.getRawClasspath();
			testSuiteClasspathEntries.addAll(Arrays.asList(entries));
			final IJavaProject javaProject = JavaCore.create(project);
			final List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
			IClasspathEntry jUnitContainerEntry = null;
			for (IClasspathEntry classpathEntry : testSuiteClasspathEntries) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
					if (classpathEntry.getPath().toString().startsWith("org.eclipse.jdt.junit.JUNIT_CONTAINER/")) {
						jUnitContainerEntry = classpathEntry;
						break;
					}
				}
			}
			if (jUnitContainerEntry != null) {
				entries = javaProject.getRawClasspath();
				classpathEntries.addAll(Arrays.asList(entries));
				classpathEntries.add(JavaCore.newContainerEntry(jUnitContainerEntry.getPath()));
				javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
						monitor);
				processOK = true;
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (processOK == true) {
				testSuiteProject.delete(true, monitor);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
