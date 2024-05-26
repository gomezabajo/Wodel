package wodeltest.extension.examples.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.XtextProjectHelper;

import wodeltest.extension.examples.builder.WodelTestBuilder;
import wodeltest.extension.examples.builder.WodelTestNature;
import wodeltest.extension.examples.wizards.WodelTest4CongaWizard;

/**
 * @author Pablo Gomez-Abajo - Wodel project examples creation Eclipse Helper.
 * 
 * Wodel project examples creation.
 * 
 */

public class EclipseHelper {

	public static final String ISO_8859_1 = "iso-8859-1";
	
	public static void addXtextNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String natures[] = description.getNatureIds();
			String xtextNature = XtextProjectHelper.NATURE_ID;
			if (!Arrays.asList(natures).contains(xtextNature)) {
				int newNaturesLength = natures.length + 1;
				String newNatures[] = new String[newNaturesLength];
				System.arraycopy(natures, 0, newNatures, 0, natures.length);
				newNatures[natures.length] = xtextNature;
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "restriction", "deprecation" })
	public static IProject createWodelProject(final String projectName, final List<String> srcFolders,
			final List<IProject> referencedProjects, final Set<String> requiredBundles, final Set<String> importPackages,
			final List<String> exportedPackages, final List<String> bundleClasspath, final ProjectKind projectKind, final IProgressMonitor progressMonitor, final Shell theShell) {
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

			projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", WodelTestNature.NATURE_ID, WodelTestNature.WODEL_NATURE_ID });

			final ICommand java = projectDescription.newCommand();
			java.setBuilderName(JavaCore.BUILDER_ID);

			final ICommand manifest = projectDescription.newCommand();
			manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

			final ICommand schema = projectDescription.newCommand();
			schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

			final ICommand oaw = projectDescription.newCommand();
			oaw.setBuilderName(WodelTestBuilder.BUILDER_ID);

			projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema, oaw });

			project.open(new SubProgressMonitor(progressMonitor, 1));
			project.setDescription(projectDescription, new SubProgressMonitor(progressMonitor, 1));
			addXtextNature(project);

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
									"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-11"), 
									ClasspathEntry.NO_ACCESS_RULES, 
									new IClasspathAttribute[] {	JavaCore.newClasspathAttribute(IClasspathAttribute.MODULE, "true") },
									false));

			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
			
			if (projectKind == ProjectKind.JAVA) {
				classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.jdt.junit.JUNIT_CONTAINER/5")));
/*
				String[] jUnit5Libraries = new String[] {
						"lib/junit-jupiter-api_5.9.2.jar",
						"lib/junit-jupiter-engine_5.9.2.jar",
						"lib/junit-jupiter-migrationsupport_5.9.2.jar",
						"lib/junit-jupiter-params_5.9.2.jar",
						"lib/junit-platform-commons_1.9.2.jar",
						"lib/junit-platform-engine_1.9.2.jar",
						"lib/junit-platform-launcher_1.9.2.jar",
						"lib/junit-platform-runner_1.9.2.jar",
						"lib/junit-platform-suite-api_1.9.2.jar",
						"lib/junit-platform-suite-commons_1.9.2.jar",
						"lib/junit-platform-suite-engine_1.9.2.jar",
						"lib/junit-vintage-engine_5.9.2.jar",
						"lib/org.apiguardian.api_1.1.2.jar",
						"lib/org.hamcrest.core_1.3.0.v20180420-1519.jar",
						"lib/org.junit_4.13.2.v20211018-1956.jar",
						"lib/org.opentest4j_1.2.0.jar"						
				};
				
				for (String jUnit5Library : jUnit5Libraries) {
					/*
 					IClasspathEntry relativeLibraryEntry = new org.eclipse.jdt.internal.core.ClasspathEntry(
					        IPackageFragmentRoot.K_BINARY,
					        IClasspathEntry.CPE_LIBRARY, project.getFile(jUnit5Library).getLocation(),
					        ClasspathEntry.INCLUDE_ALL, // inclusion patterns
					        ClasspathEntry.EXCLUDE_NONE, // exclusion patterns
					        null, null, null, // specific output folder
					        false, // exported
					        ClasspathEntry.NO_ACCESS_RULES, false, // no access rules to combine
					        ClasspathEntry.NO_EXTRA_ATTRIBUTES);
					classpathEntries.add(relativeLibraryEntry);
					*/
/*				
				}
*/
			}
			if (projectKind == ProjectKind.CONGA) {
/*				
				String[] congaLibraries = new String[] {
						 "lib/CONGA_RasaParsers.jar",
						 "lib/commonmark-0.17.1.jar",
						 "lib/jackson-annotations-2.15.2.jar",
						 "lib/jackson-core-2.15.2.jar",
						 "lib/jackson-databind-2.15.2.jar",
						 "lib/jackson-dataformat-xml-2.15.2.jar",
						 "lib/jackson-dataformat-yaml-2.15.2.jar",
						 "lib/jsoup-1.6.0.jar",
						 "lib/org.eclipse.xtext.xbase.lib_2.32.0.v20230827-1315.jar",
						 "lib/snakeyaml-2.0.jar",
						 "lib/woodstox-core-6.5.1.jar",
						 "lib/json-20230618.jar",
						 "lib/gson-2.10.1.jar",
						 "lib/jsr305-3.0.2.jar",
						 "lib/spotbugs-annotations-4.8.0.jar",
						 "lib/winp-1.28.jar"
				};
*/			

				/*
				String[] congaLibraries = new String[] {
						 "wodeltest/lib/conga/CONGA_RasaParsers.jar",
						 "wodeltest/lib/conga/commonmark-0.17.1.jar",
						 "wodeltest/lib/conga/jackson-annotations-2.15.2.jar",
						 "wodeltest/lib/conga/jackson-core-2.15.2.jar",
						 "wodeltest/lib/conga/jackson-databind-2.15.2.jar",
						 "wodeltest/lib/conga/jackson-dataformat-xml-2.15.2.jar",
						 "wodeltest/lib/conga/jackson-dataformat-yaml-2.15.2.jar",
						 "wodeltest/lib/conga/jsoup-1.6.0.jar",
						 "wodeltest/lib/conga/org.eclipse.xtext.xbase.lib_2.32.0.v20230827-1315.jar",
						 "wodeltest/lib/conga/snakeyaml-2.0.jar",
						 "wodeltest/lib/conga/woodstox-core-6.5.1.jar",
						 "wodeltest/lib/conga/json-20230618.jar",
						 "wodeltest/lib/conga/gson-2.10.1.jar",
						 "wodeltest/lib/conga/jsr305-3.0.2.jar",
						 "wodeltest/lib/conga/spotbugs-annotations-4.8.0.jar",
						 "wodeltest/lib/conga/winp-1.28.jar"
				};
				for (String congaLibrary : congaLibraries) {
					classpathEntries.add(JavaCore.newLibraryEntry(new Path(EclipseHelper.class.getProtectionDomain().getCodeSource().getLocation().getPath() + congaLibrary), null, null));
*/
				/*
					IClasspathEntry relativeLibraryEntry = new org.eclipse.jdt.internal.core.ClasspathEntry(
					        IPackageFragmentRoot.K_BINARY,
					        IClasspathEntry.CPE_LIBRARY, project.getFile(congaLibrary).getProjectRelativePath(),
					        ClasspathEntry.INCLUDE_ALL, // inclusion patterns
					        ClasspathEntry.EXCLUDE_NONE, // exclusion patterns
					        null, null, null, // specific output folder
					        false, // exported
					        ClasspathEntry.NO_ACCESS_RULES, false, // no access rules to combine
					        ClasspathEntry.NO_EXTRA_ATTRIBUTES);
					classpathEntries.add(relativeLibraryEntry);
				*/
/*				}*/
			}
			
			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					new SubProgressMonitor(progressMonitor, 1));
			javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor,
					1));
			createManifest(projectName, requiredBundles, importPackages, exportedPackages, bundleClasspath, progressMonitor, project);
			createBuildProps(progressMonitor, project, srcFolders);
		}
		catch (final Exception exception) {
			exception.printStackTrace();			
		}
		finally {
			progressMonitor.done();
		}

		return project;
	}

	public static IFile createFile(final String name, final IContainer container, final String content,
			final IProgressMonitor progressMonitor) {
		final IFile file = container.getFile(new Path(name));
		assertExist(file.getParent());
		try {
			final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (file.exists()) {
				file.setContents(stream, true, true, progressMonitor);
			}
			else {
				file.create(stream, true, progressMonitor);
			}
			stream.close();
		}
		catch (final Exception e) {
			// TO-DO: Something
		}
		progressMonitor.worked(1);

		return file;
	}

	public static IFile createFile(final String name, final IContainer container, final String content,
			final String charSet, final IProgressMonitor progressMonitor) throws CoreException {
		final IFile file = createFile(name, container, content, progressMonitor);
		if (file != null && charSet != null) {
			file.setCharset(charSet, progressMonitor);
		}

		return file;
	}

	private static void createBuildProps(final IProgressMonitor progressMonitor, final IProject project,
			final List<String> srcFolders) {
		final StringBuilder bpContent = new StringBuilder("source.. = ");
		for (final Iterator<String> iterator = srcFolders.iterator(); iterator.hasNext();) {
			bpContent.append(iterator.next()).append('/');
			if (iterator.hasNext()) {
				bpContent.append(",");
			}
		}
		bpContent.append("\n");
		bpContent.append("bin.includes = META-INF/,plugin.xml,.\n");
		createFile("build.properties", project, bpContent.toString(), progressMonitor);
	}

	@SuppressWarnings("deprecation")
	private static void createManifest(final String projectName, final Set<String> requiredBundles, final Set<String> importPackages,
			final List<String> exportedPackages, final List<String> bundleClasspath, final IProgressMonitor progressMonitor, final IProject project)
	throws CoreException {
		final StringBuilder maniContent = new StringBuilder("Manifest-Version: 1.0\n");
		maniContent.append("Automatic-Module-Name: " + projectName + "\n");
		//maniContent.append("Bundle-ActivationPolicy: lazy\n");
		maniContent.append("Bundle-ManifestVersion: 2\n");
		maniContent.append("Bundle-Name: " + projectName + "\n");
		maniContent.append("Bundle-SymbolicName: " + projectName + "; singleton:=true\n");
		maniContent.append("Bundle-Version: 1.0.0\n");
		maniContent.append("Bundle-RequiredExecutionEnvironment: JavaSE-11\n");
		// maniContent.append("Bundle-Localization: plugin\n");
		int nBundles = 0;
		maniContent.append("Require-Bundle: ");
		for (final String entry : requiredBundles) {
			nBundles++;
			if(nBundles==requiredBundles.size()) maniContent.append(" " + entry + "\n");
			else maniContent.append(" " + entry + ",\n");
		}
		//maniContent.append(" org.openarchitectureware.dependencies\n");

		if (exportedPackages != null && !exportedPackages.isEmpty()) {
			maniContent.append("Export-Package: " + exportedPackages.get(0));
			for (int i = 1, x = exportedPackages.size(); i < x; i++) {
				maniContent.append(",\n " + exportedPackages.get(i));
			}
			maniContent.append("\n");
		}
		if (importPackages.size() > 0) {
			int nPackages = 0;
			maniContent.append("Import-Package: ");
			for (final String entry : importPackages) {
				nPackages++;
				if(nPackages==importPackages.size()) maniContent.append(" " + entry + "\n");
				else maniContent.append(" " + entry + ",\n");
			}
		}
		//maniContent.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\r\n");
		if (bundleClasspath != null && !bundleClasspath.isEmpty()) {
			int nBundleClasspath = 0;
			maniContent.append("Bundle-ClassPath: ");
			for (final String entry : bundleClasspath) {
				nBundleClasspath++;
				if (nBundleClasspath == bundleClasspath.size()) maniContent.append(" " + entry + "\n");
				else maniContent.append(" " + entry + ",\n");
			}
		}

		final IFolder metaInf = project.getFolder("META-INF");
		metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		createFile("MANIFEST.MF", metaInf, maniContent.toString(), progressMonitor);
	}

	/**
	 * @param name
	 *            of the destination file
	 * @param container
	 *            directory containing the the destination file
	 * @param contentUrl
	 *            Url pointing to the src of the content
	 * @param progressMonitor
	 *            used to interact with and show the user the current operation
	 *            status
	 * @return
	 */
	public static IFile createFile(final String name, final IContainer container, final URL contentUrl,
			final IProgressMonitor progressMonitor) {

		final IFile file = container.getFile(new Path(name));
		InputStream inputStream = null;
		try {
			inputStream = contentUrl.openStream();
			if (file.exists()) {
				file.setContents(inputStream, true, true, progressMonitor);
			}
			else {
				file.create(inputStream, true, progressMonitor);
			}
			inputStream.close();
		}
		catch (final Exception e) {
			//OawLog.logError(e);
		}
		finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				}
				catch (final IOException e) {
					//OawLog.logError(e);
				}
			}
		}
		progressMonitor.worked(1);

		return file;
	}

	private static void assertExist(final IContainer c) {
		if (!c.exists()) {
			if (!c.getParent().exists()) {
				assertExist(c.getParent());
			}
			if (c instanceof IFolder) {
				try {
					((IFolder) c).create(false, true, new NullProgressMonitor());
				}
				catch (final CoreException e) {
					//OawLog.logError(e);
				}
			}

		}

	}

	public static void openFileToEdit(final Shell s, final IFile file) {
		s.getDisplay().asyncExec(new Runnable() {
			public void run() {
				final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				}
				catch (final PartInitException e) {
					//OawLog.logError(e);
				}
			}
		});
	}
}
