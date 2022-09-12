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

import manager.IOUtils;
import mutator.wodeltest.[@**@].utils.EclipseHelper;

public class ATLSuTAndTestSuiteWizard extends Wizard implements INewWizard {

	private ISelection selection;

	private static final String WIZARD_NAME = "Wodel-Test for ATL SuT and Test Suite simple example";
	
	public ATLSuTAndTestSuiteWizardPage _pageOne;

	public ATLSuTAndTestSuiteWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new ATLSuTAndTestSuiteWizardPage(selection);
		_pageOne.setTitle("Wodel-Test for ATL SuT and Test Suite simple example");
		_pageOne.setDescription("Create the Wodel-Test for ATL SuT and Test Suite simple example projects");
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

		List<IProject> referencedProjects = new ArrayList<IProject>();
		List<String> containerEntries = new ArrayList<String>();
		
		IProject sut = EclipseHelper.createATLProject("Families2Persons", folders, referencedProjects, containerEntries, monitor, this.getShell(), true);

		try {
			final File jarFile = new File(ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/sut")) {
							final File f = sut.getLocation().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("sample/sut", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/sut", ""));
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
				srcName = ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/sut";
				final File src = new Path(srcName).toFile();
				final File dest = sut.getLocation().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
			}
		} catch (IOException e) {
		}
		final IFolder dataSut = sut.getFolder(new Path("data"));
		dataSut.create(true, true, monitor);
		try {
			final File jarFile = new File(ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String dataName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/data")) {
							final File f = dataSut.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("sample/data", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/data", ""));
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
				dataName = ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/data";
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
		IProject test = EclipseHelper.createATLProject("ATLCheck", folders, referencedProjects, containerEntries, monitor, this.getShell(), false);
		
		try {
			final File jarFile = new File(ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("sample/test")) {
							final File f = test.getLocation().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("sample/test", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("sample/test", ""));
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
				srcName = ATLSuTAndTestSuiteWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "sample/test";
				final File src = new Path(srcName).toFile();
				final File dest = test.getLocation().toFile();
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

