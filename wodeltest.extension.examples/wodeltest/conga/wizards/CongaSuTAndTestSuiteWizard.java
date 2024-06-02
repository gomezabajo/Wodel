package mutator.wodeltest.[@**@].wizards;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import wodel.utils.manager.IOUtils;
import mutator.wodeltest.[@**@].utils.EclipseHelper;

public class CongaSuTAndTestSuiteWizard extends Wizard implements INewWizard {

	private ISelection selection;

	private static final String WIZARD_NAME = "Wodel-Test for Conga Example";
	
	public CongaSuTAndTestSuiteWizardPage _pageOne;

	public CongaSuTAndTestSuiteWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new CongaSuTAndTestSuiteWizardPage(selection);
		_pageOne.setTitle("Wodel-Test for Conga Example");
		_pageOne.setDescription("Create the Wodel-Test for Conga Example");
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
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(monitor);
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

	private void doFinish(IProgressMonitor monitor) throws CoreException {

		List<String> folders = new ArrayList<String>();
		folders.add("src");
		folders.add("src-gen");

		List<IProject> referencedProjects = new ArrayList<IProject>();
		List<String> containerEntries = new ArrayList<String>();
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
		
		IProject sut = EclipseHelper.createJavaProject("Chatbots", folders, referencedProjects, requiredBundles, importPackages, exportedPackages, bundleClasspath, containerEntries, monitor, this.getShell(), true);

		final IFolder srcSut = sut.getFolder(new Path("src"));
		//srcSut.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/sut")) {
							final File f = srcSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/sut", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/sut";
				final File src = new Path(srcName).toFile();
				final File dest = srcSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder dataSut = sut.getFolder(new Path("data"));
		dataSut.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String dataName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/data")) {
							final File f = dataSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/data", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				dataName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/data";
				final File src = new Path(dataName).toFile();
				final File dest = dataSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		try {
			sut.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		final IFolder zipSut = sut.getFolder(new Path("zip"));
		zipSut.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String dataName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/zip")) {
							final File f = zipSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/zip", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				dataName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/zip";
				final File src = new Path(dataName).toFile();
				final File dest = zipSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

/*
		final IFolder libSut = sut.getFolder(new Path("lib"));
		libSut.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String dataName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/lib")) {
							final File f = libSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/lib", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				dataName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/lib";
				final File src = new Path(dataName).toFile();
				final File dest = libSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		try {
			sut.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
*/		
		createPlugin(monitor, sut);
		
		referencedProjects.add(sut);
		IProject testBotiumAuto = EclipseHelper.createJavaProject("CheckChatbotsBotiumAuto", folders, referencedProjects, requiredBundles, importPackages, exportedPackages, bundleClasspath, containerEntries, monitor, this.getShell(), true);
		
		final IFolder dataTestBotiumAuto = testBotiumAuto.getFolder(new Path("data"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsBotiumAuto/data")) {
							final File f = dataTestBotiumAuto.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsBotiumAuto/data", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsBotiumAuto/data";
				final File src = new Path(srcName).toFile();
				final File dest = dataTestBotiumAuto.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

		final IFolder srcTestBotiumAuto = testBotiumAuto.getFolder(new Path("yassinelamarti-bot"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsBotiumAuto/yassinelamarti-bot")) {
							final File f = srcTestBotiumAuto.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsBotiumAuto/yassinelamarti-bot", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsBotiumAuto/yassinelamarti-bot";
				final File src = new Path(srcName).toFile();
				final File dest = srcTestBotiumAuto.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		createPlugin(monitor, testBotiumAuto);

		IProject testBotiumByHand = EclipseHelper.createJavaProject("CheckChatbotsBotiumByHand", folders, referencedProjects, requiredBundles, importPackages, exportedPackages, bundleClasspath, containerEntries, monitor, this.getShell(), true);
		
		final IFolder dataTestBotiumByHand = testBotiumByHand.getFolder(new Path("data"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsBotiumByHand/data")) {
							final File f = dataTestBotiumByHand.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsBotiumByHand/data", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsBotiumByHand/data";
				final File src = new Path(srcName).toFile();
				final File dest = dataTestBotiumByHand.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder srcTestBotiumByHand = testBotiumByHand.getFolder(new Path("yassinelamarti-bot"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsBotiumByHand/yassinelamarti-bot")) {
							final File f = srcTestBotiumByHand.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsBotiumByHand/yassinelamarti-bot", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsBotiumByHand/yassinelamarti-bot";
				final File src = new Path(srcName).toFile();
				final File dest = srcTestBotiumByHand.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

		createPlugin(monitor, testBotiumByHand);

		IProject testRasa = EclipseHelper.createJavaProject("CheckChatbotsRasa", folders, referencedProjects, requiredBundles, importPackages, exportedPackages, bundleClasspath, containerEntries, monitor, this.getShell(), true);
		
		final IFolder dataTestRasa = testRasa.getFolder(new Path("data"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsRasa/data")) {
							final File f = dataTestRasa.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsRasa/data", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsRasa/data";
				final File src = new Path(srcName).toFile();
				final File dest = dataTestRasa.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

		final IFolder srcTestRasa = testRasa.getFolder(new Path("yassinelamarti-bot"));
		//srcTest.create(true, true, monitor);
		try {
			final File jarFile = new File(CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/conga/test/CheckChatbotsRasa/yassinelamarti-bot")) {
							final File f = srcTestRasa.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/conga/test/CheckChatbotsRasa/yassinelamarti-bot", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
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
				srcName = CongaSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/conga/test/CheckChatbotsRasa/yassinelamarti-bot";
				final File src = new Path(srcName).toFile();
				final File dest = srcTestRasa.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}

		createPlugin(monitor, testRasa);
		monitor.worked(1);
		
		try {
			testBotiumAuto.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		try {
			testBotiumByHand.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		try {
			testRasa.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Toggles the finish button
	 */
	public boolean canFinish()
	{
		return true;
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

	private InputStream openConfigStream(String modelName, String mutantName) {
		String contents = modelName + "\n" + mutantName;
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
		pContent.append("</plugin>");
		pContent.append("\n");
		createFile("plugin.xml", project, pContent.toString(), progressMonitor);
	}
}

