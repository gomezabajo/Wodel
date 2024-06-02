package wodeltest.extension.examples.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodeltest.extension.examples.builder.WodelTestNature;
import wodeltest.extension.examples.utils.EclipseHelper;
import wodeltest.extension.examples.utils.ProjectKind;
import wodel.dsls.WodelUtils;

public class WodelTest4CongaWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public WodelTest4CongaWizardPage _pageOne;

	private static final String WIZARD_NAME = "Wodel-Test for Conga Example";

	public WodelTest4CongaWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new WodelTest4CongaWizardPage(selection);
		_pageOne.setTitle("Wodel-Test for Conga Example");
		_pageOne.setDescription("Create a Wodel-Test for Conga Example project");
		addPage(_pageOne);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		this.selection = selection;

	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {
		final String fileName = _pageOne.getFileName();
		final String projectName = _pageOne.getProjectName();
		final String modelName = _pageOne.getModelName();
		final String mutantName = _pageOne.getMutantName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(fileName, projectName, modelName, mutantName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error",
					realException.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(String fileName, String projectName,
			String modelName, String mutantName, IProgressMonitor monitor) throws CoreException {

		ProjectUtils.projectName = projectName;
		
		List<String> folders = new ArrayList<String>();
		folders.add("src");
		folders.add("src-gen");

		List<IProject> referencedProjects = new ArrayList<IProject>();
		Set<String> requiredBundles = new LinkedHashSet<String>();
		Set<String> importPackages = new LinkedHashSet<String>();
		List<String> exportedPackages = new ArrayList<String>();
		List<String> bundleClasspath = new ArrayList<String>();
		
		requiredBundles.add("wodel.utils");
		requiredBundles.add("wodel.models");
		requiredBundles.add("org.eclipse.emf.ecore.xmi");
		requiredBundles.add("org.eclipse.emf.ecore");
		requiredBundles.add("org.eclipse.emf.compare");
		requiredBundles.add("com.google.guava");
		requiredBundles.add("com.google.inject");
		requiredBundles.add("org.apache.log4j");
		requiredBundles.add("org.eclipse.ocl");
		requiredBundles.add("org.eclipse.ocl.ecore");
		requiredBundles.add("org.eclipse.emf.common");
		requiredBundles.add("org.eclipse.core.runtime");
		requiredBundles.add("org.eclipse.core.resources");
		requiredBundles.add("org.eclipse.text");
		requiredBundles.add("org.eclipse.ui");
		requiredBundles.add("org.eclipse.ui.ide");
		requiredBundles.add("org.eclipse.jface");
		requiredBundles.add("org.eclipse.jface.text");
		requiredBundles.add("org.eclipse.e4.ui.workbench");
		requiredBundles.add("org.eclipse.e4.ui.model.workbench");
		requiredBundles.add("org.eclipse.e4.core.di");
		requiredBundles.add("org.eclipse.jdt.core");
		requiredBundles.add("org.eclipse.jdt.launching");
		requiredBundles.add("wodeltest.extension");
		requiredBundles.add("wodeltest.conga.parsers");
/*		
		String startingPath = EclipseHelper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
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
			bundleClasspath.add(startingPath + congaLibrary);
		}
*/
/*
		bundleClasspath.add("lib/CONGA_RasaParsers.jar");
		bundleClasspath.add("lib/commonmark-0.17.1.jar");
		bundleClasspath.add("lib/jackson-annotations-2.15.2.jar");
		bundleClasspath.add("lib/jackson-core-2.15.2.jar");
		bundleClasspath.add("lib/jackson-databind-2.15.2.jar");
		bundleClasspath.add("lib/jackson-dataformat-xml-2.15.2.jar");
		bundleClasspath.add("lib/jackson-dataformat-yaml-2.15.2.jar");
		bundleClasspath.add("lib/jsoup-1.6.0.jar");
		bundleClasspath.add("lib/org.eclipse.xtext.xbase.lib_2.32.0.v20230827-1315.jar");
		bundleClasspath.add("lib/snakeyaml-2.0.jar");
		bundleClasspath.add("lib/woodstox-core-6.5.1.jar");
		bundleClasspath.add("lib/json-20230618.jar");
		bundleClasspath.add("lib/gson-2.10.1.jar");
		bundleClasspath.add("lib/jsr305-3.0.2.jar");
		bundleClasspath.add("lib/spotbugs-annotations-4.8.0.jar");
		bundleClasspath.add("lib/winp-1.28.jar");
*/
		
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
		
		for (String congaLibrary : congaLibraries) {
			bundleClasspath.add(congaLibrary);
		}
*/
		IProject project = EclipseHelper.createWodelProject(projectName,
				folders, referencedProjects, requiredBundles, importPackages,
				exportedPackages, bundleClasspath, ProjectKind.CONGA, monitor, this.getShell());

		SimpleEntry<String, String> replacement = new SimpleEntry<String, String>("[@**@]", project.getName());
		List<SimpleEntry<String, String>> replacements = new ArrayList<SimpleEntry<String, String>>();
		replacements.add(replacement);
		replacement = new SimpleEntry<String, String>("[(@**@)]", WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		replacements.add(replacement);

		monitor.beginTask("Creating data folder", 9);
		final IFolder dataFolder = project.getFolder(new Path("data"));
		dataFolder.create(true, true, monitor);
		
		monitor.beginTask("Creating config folder", 8);
		final IFolder configFolder = dataFolder.getFolder(new Path("config"));
		configFolder.create(true, true, monitor);

		final IFile config = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = openConfigStream(modelName, mutantName, project);
			if (config.exists()) {
				config.setContents(stream, true, true, monitor);
			} else {
				config.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		
		monitor.beginTask("Creating model folder", 8);
		final IFolder modelFolder = project.getFolder(new Path(modelName));
		modelFolder.create(true, true, monitor);
		String srcMetamodel = "";
		try {
			final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/conga")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/conga", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
							}
							if (entry.getName().endsWith(".ecore")) {
								srcMetamodel = dest.getPath();
							}
							InputStream input = jar.getInputStream(entry);
							FileOutputStream output = new FileOutputStream(dest);
							while (input.available() > 0) {
								output.write(input.read());
							}
							output.close();
							input.close();
						}
					}
				}
				jar.close();
			}
			else {
				srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/conga";
				final File src = new Path(srcName).toFile();
				final File dest = modelFolder.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
				for (File f: src.listFiles()) {
					if (f.getName().endsWith(".ecore")) {
						srcMetamodel = f.getPath();
						break;
					}
				}
			}
		} catch (IOException e) {
		}

		String metamodel = srcMetamodel.substring(srcMetamodel.lastIndexOf(File.separator) + 1);
		final IFile metamodelFile = modelFolder.getFile(new Path(metamodel));
		try {
			FileReader fr = new FileReader(metamodel);
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			String def = "";
			while ((line = br.readLine()) != null) {
				def += line + "\n";
			}
			br.close();
			InputStream stream = openContentStream();
			String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
			content += def;
			stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
			metamodelFile.create(stream, true, monitor);
			stream.close();
		} catch (IOException e) {
		}

		monitor.beginTask("Creating mutant folder", 8);
		final IFolder mutantFolder = project.getFolder(new Path(mutantName));
		mutantFolder.create(true, true, monitor);
		

		//Creating source mutator files
		final IFolder srcFolder = project.getFolder(new Path("src"));
		try {
			srcFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
				if (! entry.isDirectory()) {
	    			if (entry.getName().startsWith("mutator/conga")) {
						final String name = entry.getName();
						final File f = srcFolder.getRawLocation().makeAbsolute().toFile();
						File dest = new File(f.getPath() + '/' + entry.getName().replace("mutator/conga", ""));
						if (!dest.exists()) {
							dest.getParentFile().mkdirs();
						}
						InputStream input = jar.getInputStream(entry);
						InputStreamReader isr = new InputStreamReader(input);
						BufferedReader br = new BufferedReader(isr);
						FileOutputStream output = new FileOutputStream(dest);
						OutputStreamWriter osw = new OutputStreamWriter(output); 
						for (SimpleEntry<String, String> rep: replacements) {
							String line = null;
							while ((line = br.readLine()) != null) {
								if (line.indexOf(rep.getKey()) != -1) {
									line = line.replace(rep.getKey(), rep.getValue());
								}
								osw.write(line + "\n");
							}
						}
						osw.close();
						output.close();
						br.close();
						isr.close();
						input.close();
					}
				}
			}
		    jar.close();
		}
		else {
			srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "mutator/conga";
			final File src = new Path(srcName).toFile();
			final File dest = srcFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolderWithReplacements(src, dest, replacements);
			}
		}
		} catch (IOException e) {
		}
		
		File folder = srcFolder.getRawLocation().makeAbsolute().toFile();
		String mutatorName = "";
		IFile mutFile = null;
		if (folder.listFiles() != null) {
			for (File mutatorFile : folder.listFiles()) {
				if (mutatorFile != null && mutatorFile.isFile() && mutatorFile.getName().endsWith(".mutator")) {
					if (mutatorName.isEmpty()) {
						mutFile = srcFolder.getFile(new Path(mutatorFile.getName()));
					}
					mutatorName = mutatorFile.getName();
					String xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + project.getFolder(new Path("/src/" + mutatorName)).getFullPath();
					String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + project.getFolder(new Path('/' + mutantName + '/' + mutatorName.replaceAll("mutator", "model"))).getFullPath();
					WodelUtils.serialize(xTextFileName, xmiFileName);
				}
			}
		}
		
		final IFolder mutFolder = srcFolder.getFolder(new Path("mutator"));
		try {
			mutFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder wodeltestFolder = mutFolder.getFolder(new Path("wodeltest"));
		try {
			wodeltestFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder wodeltestPackage = wodeltestFolder.getFolder(new Path(project.getName()));
		try {
			wodeltestPackage.create(true, true, monitor);
		} catch (CoreException e) {
		}

		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
				if (! entry.isDirectory()) {
					if (entry.getName().startsWith("wodeltest/conga")) {
						final String name = entry.getName();
						final File f = wodeltestPackage.getRawLocation().makeAbsolute().toFile();
						File dest = new File(f.getPath() + '/' + entry.getName().replace("wodeltest/conga", ""));
						if (!dest.exists()) {
							dest.getParentFile().mkdirs();
						}
						InputStream input = jar.getInputStream(entry);
						InputStreamReader isr = new InputStreamReader(input);
						BufferedReader br = new BufferedReader(isr);
						FileOutputStream output = new FileOutputStream(dest);
						OutputStreamWriter osw = new OutputStreamWriter(output); 
						for (SimpleEntry<String, String> rep: replacements) {
							String line = null;
							while ((line = br.readLine()) != null) {
								if (line.indexOf(rep.getKey()) != -1) {
									line = line.replace(rep.getKey(), rep.getValue());
								}
								osw.write(line + "\n");
							}
						}
						osw.close();
						output.close();
						br.close();
						isr.close();
						input.close();
					}
				}
		    }
			jar.close();
		}
		else {
			srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "wodeltest/conga";
			final File src = new Path(srcName).toFile();
			final File dest = wodeltestPackage.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolderWithReplacements(src, dest, replacements);
			}
		}
		} catch (IOException e) {
		}

		monitor.beginTask("Creating tests folder", 8);
		final IFile test = configFolder.getFile(new Path("test.txt"));
		try {
			InputStream stream = openTestStream();
			if (test.exists()) {
				test.setContents(stream, true, true, monitor);
			} else {
				test.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		
		final IFolder sampleFolder = project.getFolder(new Path("sample"));
		sampleFolder.create(true, true, monitor);

		final IFolder javaFolder = sampleFolder.getFolder(new Path("conga"));
		javaFolder.create(true, true, monitor);

		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
				if (! entry.isDirectory()) {
					if (entry.getName().startsWith("wodeltest/sample/conga")) {
						final String name = entry.getName();
						final File f = javaFolder.getRawLocation().makeAbsolute().toFile();
						File dest = new File(f.getPath() + '/' + entry.getName().replace("wodeltest/sample/conga", ""));
						if (!dest.exists()) {
							dest.getParentFile().mkdirs();
						}
						InputStream input = jar.getInputStream(entry);
						InputStreamReader isr = new InputStreamReader(input);
						BufferedReader br = new BufferedReader(isr);
						FileOutputStream output = new FileOutputStream(dest);
						OutputStreamWriter osw = new OutputStreamWriter(output); 
						for (SimpleEntry<String, String> rep: replacements) {
							String line = null;
							while ((line = br.readLine()) != null) {
								if (line.indexOf(rep.getKey()) != -1) {
									line = line.replace(rep.getKey(), rep.getValue());
								}
								osw.write(line + "\n");
							}
						}
						osw.close();
						output.close();
						br.close();
						isr.close();
						input.close();
					}
				}
		    }
		    jar.close();
		}
		else {
			srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "wodeltest/sample/conga";
			final File src = new Path(srcName).toFile();
			final File dest = javaFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolderWithReplacements(src, dest, replacements);
			}
		}
		} catch (IOException e) {
		}

		final IFolder zipFolder = project.getFolder(new Path("zip"));
		zipFolder.create(true, true, monitor);

		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
				if (! entry.isDirectory()) {
					if (entry.getName().startsWith("wodeltest/zip/conga")) {
						final String name = entry.getName();
						final File f = zipFolder.getRawLocation().makeAbsolute().toFile();
						File dest = new File(f.getPath() + '/' + entry.getName().substring("wodeltest/zip/conga".length(), entry.getName().length()).split("/")[1]);
						InputStream input = jar.getInputStream(entry);
						final IFile output = zipFolder.getFile(new Path(dest.getName()
								.substring(dest.getName().lastIndexOf("/") + 1, dest.getName().length())));
						output.create(input, true, monitor);
						output.refreshLocal(IResource.DEPTH_ZERO, monitor);
						input.close();
					}
				}
		    }
		    jar.close();
		}
		else {
			srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "wodeltest/zip/conga";
			final File src = new Path(srcName).toFile();
			for (File f : src.listFiles()) {
				final IFile dest = zipFolder.getFile(new Path(f.getName()));
				dest.create(new FileInputStream(f), true, monitor);
				dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
			}
		}
		} catch (IOException e) {
		}

		/*
		final IFolder libFolder = project.getFolder(new Path("lib"));
		libFolder.create(true, true, monitor);

		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
				if (! entry.isDirectory()) {
					if (entry.getName().startsWith("wodeltest/lib/conga")) {
						final String name = entry.getName();
						final File f = libFolder.getRawLocation().makeAbsolute().toFile();
						File dest = new File(f.getPath() + '/' + entry.getName().substring("wodeltest/lib/conga".length(), entry.getName().length()).split("/")[1]);
						InputStream input = jar.getInputStream(entry);
						final IFile output = libFolder.getFile(new Path(dest.getName()
								.substring(dest.getName().lastIndexOf("/") + 1, dest.getName().length())));
						output.create(input, true, monitor);
						output.refreshLocal(IResource.DEPTH_ZERO, monitor);
						input.close();
					}
				}
		    }
		    jar.close();
		}
		else {
			srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "wodeltest/lib/conga";
			final File src = new Path(srcName).toFile();
			for (File f : src.listFiles()) {
				final IFile dest = libFolder.getFile(new Path(f.getName()));
				dest.create(new FileInputStream(f), true, monitor);
				dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
			}
		}
		} catch (IOException e) {
		}
		*/
		final IFolder iconsFolder = project.getFolder(new Path("icons"));
		iconsFolder.create(true, true, monitor);
		
		try {
			final File jarFile = new File(WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("icons")) {
							final File f = iconsFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("icons", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("icons", ""));
							InputStream input = jar.getInputStream(entry);
							FileOutputStream output = new FileOutputStream(dest);
							while (input.available() > 0) {
								output.write(input.read());
							}
							output.close();
							input.close();
						}
					}
				}
				jar.close();
			}
			else {
				srcName = WodelTest4CongaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "icons";
				final File src = new Path(srcName).toFile();
				final File dest = iconsFolder.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

		try {

			//addTextToFile(configPath, "config.txt", "\n" + this.getName(), monitor);
			
			IProjectDescription description = project.getDescription();

			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = WodelTestNature.NATURE_ID;

			// validate the natures
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IStatus status = workspace.validateNatureSet(newNatures);

			// only apply new nature, if the status is ok
			if (status.getCode() == IStatus.OK) {
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
			}
			
			//final IFolder metaInf = mutProject.getFolder("META-INF");
			//addTextToFile(metaInf, "MANIFEST.MF", "Export-Package: mutator." + mutProject.getName() + ",\n mutator.wodeltest." + mutProject.getName() + "\n", monitor);
			createPlugin(monitor, project);
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		monitor.setTaskName("Opening file for editing...");
		final IFile file = srcFolder.getFile(new Path(mutFile.getName()));
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
		
/*		
		String[] jUnit5Libraries = new String[] {
				"junit-jupiter-api_5.9.2.jar",
				"junit-jupiter-engine_5.9.2.jar",
				"junit-jupiter-migrationsupport_5.9.2.jar",
				"junit-jupiter-params_5.9.2.jar",
				"junit-platform-commons_1.9.2.jar",
				"junit-platform-engine_1.9.2.jar",
				"junit-platform-launcher_1.9.2.jar",
				"junit-platform-runner_1.9.2.jar",
				"junit-platform-suite-api_1.9.2.jar",
				"junit-platform-suite-commons_1.9.2.jar",
				"junit-platform-suite-engine_1.9.2.jar",
				"junit-vintage-engine_5.9.2.jar",
				"org.apiguardian.api_1.1.2.jar",
				"org.hamcrest.core_1.3.0.v20180420-1519.jar",
				"org.junit_4.13.2.v20211018-1956.jar",
				"org.opentest4j_1.2.0.jar"						
			};
*/
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
/*
		try {
			libFolder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
*/
	}
	
	/**
	 * Toggles the finish button
	 */
	public boolean canFinish()
	{
		if(getContainer().getCurrentPage() == _pageOne) {
			if (_pageOne.valid == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with the name of the model folder and
	 * the name of the mutants folder.
	 */

	private InputStream openConfigStream(String modelName, String mutantName, IProject project) {
		String contents = modelName + "\n" + mutantName + "\n" + project.getName() + ".mutator\nWodel-Test: Generation of a model-based software testing framework\n";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openTestStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
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
	
	private static void createPlugin(final IProgressMonitor progressMonitor, final IProject project) {
		final StringBuilder pContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pContent.append("\n");
		pContent.append("<?eclipse version=\"3.4\"?>");
		pContent.append("\n");
		pContent.append("<plugin>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\t\tpoint=\"wodeltest.extension.MutTesting\">");
		pContent.append("\n");
		pContent.append("\t\t<wodeltest");
		pContent.append("\n");
		pContent.append("\t\t\tclass=\"mutator.wodeltest." + project.getName() + ".WodelTest\">");
		pContent.append("\n");
		pContent.append("\t\t</wodeltest>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Nature\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.natures\">");
		pContent.append("\n");
		pContent.append("\t<runtime>");
		pContent.append("\n");
		pContent.append("\t<run");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".builder.WodelTestSUTNature\">");
		pContent.append("\n");
		pContent.append("\t</run>");
		pContent.append("\n");
		pContent.append("\t</runtime>");
		pContent.append("\n");
		pContent.append("\t<builder");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTBuilder\">");
		pContent.append("\n");
		pContent.append("\t</builder>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTBuilder\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Builder\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.builders\">");
		pContent.append("\n");
		pContent.append("\t<builder");
		pContent.append("\n");
		pContent.append("\thasNature=\"true\">");
		pContent.append("\n");
		pContent.append("\t<run");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".builder.WodelTestSUTBuilder\">");
		pContent.append("\n");
		pContent.append("\t</run>");
		pContent.append("\n");
		pContent.append("\t</builder>");
		pContent.append("\n");
  		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.commands\">");
		pContent.append("\n");
		pContent.append("\t<category");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Nature commands\"");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTNature.category\">");
		pContent.append("\n");
		pContent.append("\t</category>");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tname=\"Add/Remove Wodel-Test SUT Project Nature\"");
		pContent.append("\n");
		pContent.append("\tdefaultHandler=\"mutator.wodeltest." + project.getName() + ".builder.AddRemoveWodelTestSUTNatureHandler\"");
		pContent.append("\n");
		pContent.append("\tcategoryId=\"wodeltest.extension.wodelTestSUTNature.category\"");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.addRemoveWodelTestSUTNature\">");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.menus\">");
		pContent.append("\n");
		pContent.append("\t<menuContribution");
		pContent.append("\n");
		pContent.append("\tlocationURI=\"popup:org.eclipse.ui.projectConfigure?after=additions\">");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tcommandId=\"wodeltest.extension.addRemoveWodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tlabel=\"Disable Wodel-Test SUT Nature\"");
		pContent.append("\n");
		pContent.append("\tstyle=\"push\">");
		pContent.append("\n");
		pContent.append("\t<visibleWhen");
		pContent.append("\n");
		pContent.append("\tcheckEnabled=\"false\">");
		pContent.append("\n");
		pContent.append("\t<with");
		pContent.append("\n");
		pContent.append("\tvariable=\"selection\">");
		pContent.append("\n");
		pContent.append("\t<count");
		pContent.append("\n");
		pContent.append("\tvalue=\"1\">");
		pContent.append("\n");
		pContent.append("\t</count>");
		pContent.append("\n");
		pContent.append("\t<iterate>");
		pContent.append("\n");
		pContent.append("\t<adapt");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.IProject\">");
		pContent.append("\n");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\n");
		pContent.append("\t</adapt>");
		pContent.append("\n");
		pContent.append("\t</iterate>");
		pContent.append("\n");
		pContent.append("\t</with>");
		pContent.append("\n");
		pContent.append("\t</visibleWhen>");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tcommandId=\"wodeltest.extension.addRemoveWodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tlabel=\"Enable Wodel-Test SUT Nature\"");
		pContent.append("\n");
		pContent.append("\tstyle=\"push\">");
		pContent.append("\n");
		pContent.append("\t<visibleWhen");
		pContent.append("\n");
		pContent.append("\tcheckEnabled=\"false\">");
		pContent.append("\n");
		pContent.append("\t<with");
		pContent.append("\n");
		pContent.append("\tvariable=\"selection\">");
		pContent.append("\n");
		pContent.append("\t<count");
		pContent.append("\n");
		pContent.append("\tvalue=\"1\">");
		pContent.append("\n");
		pContent.append("\t</count>");
		pContent.append("\n");
		pContent.append("\t<iterate>");
		pContent.append("\n");
		pContent.append("\t<adapt");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.IProject\">");
		pContent.append("\n");
		pContent.append("\t<not>");
		pContent.append("\n");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\n");
		pContent.append("\t</not>");
		pContent.append("\n");
		pContent.append("\t</adapt>");
		pContent.append("\n");
		pContent.append("\t</iterate>");
		pContent.append("\n");
		pContent.append("\t</with>");
		pContent.append("\n");
		pContent.append("\t</visibleWhen>");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t</menuContribution>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"xmlProblem\"");
		pContent.append("\n");
		pContent.append("\tname=\"XML Problem\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.markers\">");
		pContent.append("\n");
		pContent.append("\t<super");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.problemmarker\">");
		pContent.append("\n");
		pContent.append("\t</super>");
		pContent.append("\n");
		pContent.append("\t<persistent");
		pContent.append("\n");
		pContent.append("\tvalue=\"true\">");
		pContent.append("\n");
		pContent.append("\t</persistent>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.newWizards\">");
		pContent.append("\n");
		pContent.append("\t<category");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.WodelTestProject\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test\">");
		pContent.append("\n");
		pContent.append("\t</category>");
		pContent.append("\n");
		pContent.append("\n");
		pContent.append("\t<wizard");
		pContent.append("\n");
		pContent.append("\tcategory=\"wodeltest.extension.WodelTestProject\"");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".wizards.CongaSuTAndTestSuiteWizard\"");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tid=\"mutator.wodeltest." + project.getName() + ".WodelTest4Conga\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test for Conga example\"");
		pContent.append("\n");
		pContent.append("\tproject=\"true\">");
		pContent.append("\n");
		pContent.append("\t</wizard>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("</plugin>");
		pContent.append("\n");
		createFile("plugin.xml", project, pContent.toString(), progressMonitor);
	}
}

