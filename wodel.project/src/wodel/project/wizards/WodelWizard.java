package wodel.project.wizards;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import wodel.project.utils.EclipseHelper;
import wodel.dsls.WodelUtils;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.extension.generator.IGenerator;

/**
 * @author Pablo Gomez-Abajo - Wodel new project Wizard.
 * 
 * Wodel new project Wizard.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class WodelWizard extends Wizard implements INewWizard {
	private ISelection selection;

	public WodelWizardPage _pageOne;
	public WodelWizardMetamodelPage _pageTwo;

	private static final String WIZARD_NAME = "Wodel Project";

	/**
	 * Constructor for WodelWizard.
	 */
	public WodelWizard() {
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
		// this.setDefaultPageImageDescriptor(ImageDescriptor.createFromImage(new
		// Image(Display.getDefault(),
		// "C:/proyectos/mutation/MutatorProject/icons/wodel4.jpg")));
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		super.addPages();
		_pageOne = new WodelWizardPage(selection);
		_pageOne.setTitle("Wodel Project");
		_pageOne.setDescription("Create a Wodel Project");
		addPage(_pageOne);
		_pageTwo = new WodelWizardMetamodelPage(selection);
		_pageTwo.setTitle("Choose Metamodel");
		_pageTwo.setDescription("Choose Metamodel for Wodel Project");
		addPage(_pageTwo);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String fileName = _pageOne.getFileName();
		final String projectName = _pageOne.getProjectName();
		final String modelName = _pageOne.getModelName();
		final String mutantName = _pageOne.getMutantName();
		final HashMap<String, Boolean> wodelExtensions = _pageOne
				.getWodelExtensions();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(fileName, projectName, modelName, mutantName,
							monitor, wodelExtensions);
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
			String modelName, String mutantName, IProgressMonitor monitor,
			HashMap<String, Boolean> wodelExtensions) throws CoreException {

		ProjectUtils.projectName = projectName;
		
		List<String> folders = new ArrayList<String>();
		folders.add("src");
		folders.add("src-gen");

		List<IProject> referencedProjects = new ArrayList<IProject>();
		Set<String> requiredBundles = new HashSet<String>();
		Set<String> importPackages = new HashSet<String>();
		List<String> exportedPackages = new ArrayList<String>();

		requiredBundles.add("wodel.utils");
		requiredBundles.add("wodel.models");
		requiredBundles.add("org.eclipse.emf.ecore.xmi");
		requiredBundles.add("org.eclipse.emf.ecore");
		requiredBundles.add("org.eclipse.emf.compare");
		requiredBundles.add("com.google.guava");
		requiredBundles.add("org.apache.log4j");
		requiredBundles.add("org.eclipse.ocl");
		requiredBundles.add("org.eclipse.ocl.ecore");
		requiredBundles.add("org.eclipse.emf.common");
		requiredBundles.add("org.eclipse.core.runtime");
		requiredBundles.add("org.eclipse.core.resources");
		requiredBundles.add("org.eclipse.text");
		requiredBundles.add("org.eclipse.ui");
		requiredBundles.add("org.eclipse.e4.ui.workbench");
		requiredBundles.add("org.eclipse.e4.ui.model.workbench");
		requiredBundles.add("org.eclipse.e4.core.di");
		
		List<String> additionalRequiredBundles = new ArrayList<String>();
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.extension.MutApplication");
			for (int j = 0; j < extensions.length; j++) {
				try {
					final IGenerator src = (IGenerator) extensions[j]
							.createExecutableExtension("class");
					if (wodelExtensions.containsKey(src.getName())) {
						// create a sample file
						monitor.beginTask("Creating " + src.getName()
								+ " files", 6);
						if (wodelExtensions.get(src.getName()) == true) {
							List<String> bundles = src.requiredBundles();
							if (bundles != null && bundles.size() > 0) {
								additionalRequiredBundles.addAll(bundles);
							}
						}
					}
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (additionalRequiredBundles.size() > 0) {
			requiredBundles.addAll(additionalRequiredBundles);
		}

		IProject project = EclipseHelper.createWodelProject(projectName,
				folders, referencedProjects, requiredBundles, importPackages,
				exportedPackages, monitor, this.getShell());

		monitor.beginTask("Creating data folder", 9);
		final IFolder dataFolder = project.getFolder(new Path("data"));
		dataFolder.create(true, true, monitor);
		
		monitor.beginTask("Creating config folder", 8);
		final IFolder configFolder = dataFolder.getFolder(new Path("config"));
		configFolder.create(true, true, monitor);

		final IFile config = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = openConfigStream(modelName, mutantName, fileName);
			if (config.exists()) {
				config.setContents(stream, true, true, monitor);
			} else {
				config.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		
		Bundle bundle = Platform.getBundle("wodel.models");
		final IFile mutatorEnvironment = configFolder.getFile(new Path("mutatorEnvironment.bundle"));
		try {
			InputStream stream = openBundleStream(FileLocator.resolve(bundle.getEntry("/model/MutatorEnvironment.ecore")).getFile());
			if (mutatorEnvironment.exists()) {
				mutatorEnvironment.setContents(stream, true, true, monitor);
			} else {
				mutatorEnvironment.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		
		final IFile metricsEnvironment = configFolder.getFile(new Path("metricsEnvironment.bundle"));
		try {
			InputStream stream = openBundleStream(FileLocator.resolve(bundle.getEntry("/model/MutatorMetrics.ecore")).getFile());
			if (metricsEnvironment.exists()) {
				metricsEnvironment.setContents(stream, true, true, monitor);
			} else {
				metricsEnvironment.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}

		monitor.beginTask("Creating model folder", 8);
		final IFolder modelFolder = project.getFolder(new Path(modelName));
		modelFolder.create(true, true, monitor);
		String metamodel = null;
		//Copies the selected meta-model
		if (_pageTwo.file != null) {
			metamodel = _pageTwo.file.substring(_pageTwo.file.lastIndexOf(File.separator) + 1);
			IFile file = modelFolder.getFile(new Path(metamodel));
			try {
				FileReader fr = new FileReader(_pageTwo.file);
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
				file.create(stream, true, monitor);
				stream.close();
			} catch (IOException e) {
			}
		}

		monitor.beginTask("Creating mutant folder", 8);
		final IFolder mutantFolder = project.getFolder(new Path(mutantName));
		mutantFolder.create(true, true, monitor);
		// create a sample file
		monitor.beginTask("Creating " + fileName, 7);

		final IFolder srcFolder = project.getFolder(new Path("src"));

		final IFile file = srcFolder.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			String def = "generate 2 mutants\n"
					+ "in \"" + mutantName + "/\"\n"
					+ "from \"" + modelName + "/\"\n";
			if (metamodel != null) {
				def += "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			}
			else {
				def += "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			if (metamodel != null) {
				List<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getWorkspaceAbsolutePath() + modelFolder.getFullPath().toOSString() + "/" + metamodel);
				List<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(0);
				def += "with commands {\n";
				def += "\tcreate " + eclass.getName() + "\n";
			}
			else {
				def += "\t//fill this with mutation commands\n";
			}
			def += "}";
			if (file.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}
		String xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + project.getFolder(new Path("/src/" + fileName)).getFullPath();
		String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + project.getFolder(new Path('/' + mutantName + '/' + fileName.replaceAll("mutator", "model"))).getFullPath();
		WodelUtils.serialize(xTextFileName, xmiFileName);

		boolean postProcessing = false;
		if (registry != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.extension.MutApplication");
			for (int j = 0; j < extensions.length; j++) {
				try {
					final IGenerator src = (IGenerator) extensions[j]
							.createExecutableExtension("class");
					if (wodelExtensions.containsKey(src.getName())) {
						// create a sample file
						monitor.beginTask("Creating " + src.getName()
								+ " files", 6);
						if (wodelExtensions.get(src.getName()) == true) {
							src.doGenerate(fileName, metamodel, projectName, mutantName, project, srcFolder,
									configFolder, monitor);
						}
						postProcessing = true;
					}
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
		monitor.setTaskName("Opening file for editing...");
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
		
		if (postProcessing == false) {
			createPlugin(monitor, project);
		}
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * Toggles the finish button
	 */
	@Override
	public boolean canFinish()
	{
		if(getContainer().getCurrentPage() == _pageTwo) {
			if (_pageTwo.valid == true) {
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

	private InputStream openConfigStream(String modelName, String mutantName, String fileName) {
		String contents = modelName + "\n" + mutantName + "\n" + fileName;
		return new ByteArrayInputStream(contents.getBytes());
	}

	private InputStream openBundleStream(String bundlePath) {
		String contents = bundlePath + "\n";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openTestStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
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