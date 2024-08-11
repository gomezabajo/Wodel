package mutator.wodeltest.[@**@].wizards;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

public class JavaSuTAndTestSuiteWizardjUnit5 extends Wizard implements INewWizard {

	private ISelection selection;

	private static final String WIZARD_NAME = "Wodel-Test for jUnit5";
	
	public JavaSuTAndTestSuiteWizardPagejUnit5 _pageOne;

	public JavaSuTAndTestSuiteWizardjUnit5() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new JavaSuTAndTestSuiteWizardPagejUnit5(selection);
		_pageOne.setTitle("Wodel-Test for jUnit5");
		_pageOne.setDescription("Create the Wodel-Test for jUnit5 example");
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

		List<IProject> referencedProjects = new ArrayList<IProject>();
		List<String> containerEntries = new ArrayList<String>();
		containerEntries.add("org.eclipse.jdt.junit.JUNIT_CONTAINER/5");
		
		IProject sut = EclipseHelper.createJavaProject("tool", folders, referencedProjects, containerEntries, monitor, this.getShell(), true);

		final IFolder srcSut = sut.getFolder(new Path("src"));
		//srcSut.create(true, true, monitor);
		final IFolder comSut = srcSut.getFolder(new Path("com"));
		comSut.create(true, true, monitor);
		final IFolder exampleSut = comSut.getFolder(new Path("example"));
		exampleSut.create(true, true, monitor);
		final IFolder toolSut = exampleSut.getFolder(new Path("tool"));
		toolSut.create(true, true, monitor);
		try {
			final File jarFile = new File(JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/junit5/sut/com/example/tool")) {
							final File f = toolSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/junit5/sut/com/example/tool", ""));
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
				srcName = JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/junit5/sut/com/example/tool";
				final File src = new Path(srcName).toFile();
				final File dest = toolSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder internalSut = toolSut.getFolder(new Path("internal"));
		internalSut.create(true, true, monitor);
		try {
			final File jarFile = new File(JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/junit5/sut/com/example/tool/internal")) {
							final File f = internalSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/junit5/sut/com/example/tool/internal", ""));
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
				srcName = JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/junit5/sut/com/example/tool/internal";
				final File src = new Path(srcName).toFile();
				final File dest = internalSut.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder dataSut = sut.getFolder(new Path("data"));
		dataSut.create(true, true, monitor);
		try {
			final File jarFile = new File(JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String dataName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/junit5/data")) {
							final File f = dataSut.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/junit5/data", ""));
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
				dataName = JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/junit5/data";
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

		
		referencedProjects.add(sut);
		IProject test = EclipseHelper.createJavaProject("tool-test", folders, referencedProjects, containerEntries, monitor, this.getShell(), false);
		
		final IFolder srcTest = test.getFolder(new Path("src"));
		//srcTest.create(true, true, monitor);
		final IFolder comTest = srcTest.getFolder(new Path("com"));
		comTest.create(true, true, monitor);
		final IFolder exampleTest = comTest.getFolder(new Path("example"));
		exampleTest.create(true, true, monitor);
		final IFolder toolTest = exampleTest.getFolder(new Path("tool"));
		toolTest.create(true, true, monitor);
		final IFolder testJUnit5 = toolTest.getFolder(new Path("test"));
		testJUnit5.create(true, true, monitor);
		try {
			final File jarFile = new File(JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/junit5/test/com/example/tool/test/")) {
							final File f = testJUnit5.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/junit5/test/com/example/tool/test/", ""));
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
				srcName = JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/junit5/test/com/example/tool/test/";
				final File src = new Path(srcName).toFile();
				final File dest = testJUnit5.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder internalTest = testJUnit5.getFolder(new Path("internal"));
		internalTest.create(true, true, monitor);
		try {
			final File jarFile = new File(JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/junit5/test/com/example/tool/test/internal")) {
							final File f = internalTest.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/junit5/test/com/example/tool/test/internal", ""));
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
				srcName = JavaSuTAndTestSuiteWizardjUnit5.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/junit5/test/com/example/tool/test/internal";
				final File src = new Path(srcName).toFile();
				final File dest = internalTest.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		monitor.worked(1);
		
		try {
			test.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
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
}

