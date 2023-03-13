package mutator.wodeltest.[@**@].utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import mutator.wodeltest.[@**@].builder.SampleNature;

/**
 * @author Pablo Gomez-Abajo - Wodel project examples creation Eclipse Helper.
 * 
 * Wodel project examples creation.
 * 
 */

public class EclipseHelper {

	public static final String ISO_8859_1 = "iso-8859-1";
	
	public static void addWodelTestNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String natures[] = description.getNatureIds();
			String wodelTestNature = SampleNature.NATURE_ID;
			if (!Arrays.asList(natures).contains(wodelTestNature)) {
				int newNaturesLength = natures.length + 1;
				String newNatures[] = new String[newNaturesLength];
				System.arraycopy(natures, 0, newNatures, 0, natures.length);
				newNatures[natures.length] = wodelTestNature;
				description.setNatureIds(newNatures);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static IProject createJavaProject(final String projectName, final List<String> srcFolders,
			final List<IProject> referencedProjects, final List<String> containerEntries, final IProgressMonitor progressMonitor, final Shell theShell, final boolean sut) {
		IProject project = null;
		try {
			progressMonitor.beginTask("", 10);
			progressMonitor.subTask("Creating project " + projectName);
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);

			// Clean up any old project information.
			if (project.exists()) {
				final boolean[] result = new boolean[1];
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
					public void run() {
						result[0] = MessageDialog.openQuestion(theShell, "Do you want to overwrite the project "
								+ projectName, "Note that everything inside the project '" + projectName
								+ "' will be deleted if you confirm this dialog.");
					}
				});
				if (result[0]) {
					project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));
				}
				else
					return null;
			}

			final IJavaProject javaProject = JavaCore.create(project);
			final IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(
					projectName);
			projectDescription.setLocation(null);
			project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
			final List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
			if (referencedProjects.size() != 0) {
				projectDescription.setReferencedProjects(referencedProjects.toArray(new IProject[referencedProjects
				                                                                                 .size()]));
				for (final IProject referencedProject : referencedProjects) {
					final IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(referencedProject
							.getFullPath());
					classpathEntries.add(referencedProjectClasspathEntry);
				}
			}

			if (sut == true) {
				projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "wodeltest.extension.sampleNature" });
			}
			else {
				projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID });
			}

			final ICommand java = projectDescription.newCommand();
			java.setBuilderName(JavaCore.BUILDER_ID);

			projectDescription.setBuildSpec(new ICommand[] { java });

			project.open(new SubProgressMonitor(progressMonitor, 1));
			project.setDescription(projectDescription, new SubProgressMonitor(progressMonitor, 1));

			Collections.reverse(srcFolders);
			for (final String src : srcFolders) {
				final IFolder srcContainer = project.getFolder(src);
				if (!srcContainer.exists()) {
					srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
				}
				final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
				classpathEntries.add(0, srcClasspathEntry);
			}

			classpathEntries
					.add(JavaCore
							.newContainerEntry(new Path(
									"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-11")));
			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
			
			for (String containerEntry : containerEntries) {
				classpathEntries.add(JavaCore.newContainerEntry(new Path(containerEntry)));
			}

			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					new SubProgressMonitor(progressMonitor, 1));

			javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor,
					1));
		}
		catch (final Exception exception) {
			exception.printStackTrace();			
		}
		finally {
			progressMonitor.done();
		}

		return project;
	}
}
