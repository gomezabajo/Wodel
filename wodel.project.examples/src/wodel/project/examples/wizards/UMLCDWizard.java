package wodel.project.examples.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.google.common.io.CharStreams;

import wodel.dsls.WodelUtils;
import wodel.project.examples.utils.EclipseHelper;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel new UML class diagrams example project Wizard.
 * 
 * Wodel new UML class diagrams example project Wizard.
 *  
 */
public class UMLCDWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public UMLCDWizardPage _pageOne;

	private static final String WIZARD_NAME = "UML Class Diagrams Language Example (2)";

	public UMLCDWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new UMLCDWizardPage(selection);
		_pageOne.setTitle("Wodel UML Class Diagrams Language Example (2)");
		_pageOne.setDescription("Create a Wodel UML Class Diagrams Language Example (2)");
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

		List<String> folders = new ArrayList<String>();
		folders.add("src");
		folders.add("src-gen");

		Set<IProject> referencedProjects = new LinkedHashSet<IProject>();
		Set<String> requiredBundles = new LinkedHashSet<String>();
		Set<String> importPackages = new LinkedHashSet<String>();
		Set<String> exportedPackages = new LinkedHashSet<String>();
		Set<String> bundleClasspath = new LinkedHashSet<String>();

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
		
		bundleClasspath.add(".");
		bundleClasspath.add("lib/use.jar");
		bundleClasspath.add("lib/use-runtime.jar");
		bundleClasspath.add("lib/use-gui.jar");
		bundleClasspath.add("lib/antlr-3.4-complete.jar");
		bundleClasspath.add("lib/combinatoricslib-0.2.jar");
		bundleClasspath.add("lib/gsbase.jar");
		bundleClasspath.add("lib/guava-20.0.jar");
		bundleClasspath.add("lib/itextpdf-5.5.2.jar");
		bundleClasspath.add("lib/jruby-1.7.2.jar");
		bundleClasspath.add("lib/junit.jar");
		bundleClasspath.add("lib/vtd-xml.jar");
		bundleClasspath.add("lib/ModelValidatorPlugin-5.2.0-r1.jar");

		IProject project = EclipseHelper.createWodelProject(projectName,
				folders, referencedProjects, requiredBundles, importPackages,
				exportedPackages, bundleClasspath, monitor, this.getShell());
		
		ProjectUtils.setProject(project);

		monitor.beginTask("Creating data folder", 9);
		final IFolder dataFolder = project.getFolder(new Path("data"));
		dataFolder.create(true, true, monitor);
		
		monitor.beginTask("Creating config folder", 8);
		final IFolder configFolder = dataFolder.getFolder(new Path("config"));
		configFolder.create(true, true, monitor);

		final IFile config = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = openConfigStream(modelName, mutantName);
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
			final File jarFile = new File(UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/umlcd2")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/umlcd2", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/umlcd2", ""));
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
				srcName = UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/umlcd2";
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
			String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
			content += def;
			stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
			metamodelFile.create(stream, true, monitor);
			stream.close();
		} catch (IOException e) {
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
			String def = "generate exhaustive mutants\n"
					+ "in \"" + mutantName + "/\"\n"
					+ "from \"" + modelName + "/\"\n";
			def += "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += "with blocks {\n";
			def += "\tmodAssociation1 {\n";
			def += "\t\tobject = select one Object\n";
			def += "\t\tobjectAssociation = select one ObjectAssociation where {^source = object or ^target = object}\n";
			def += "\t\tclass = select one Class in object->class\n";
			def += "\t\tsuperclass = select one Class in class->superclass\n";
			def += "\t\tsiblingclass = select one Class in superclass->subclasses where {self <> class}\n";
			def += "\t\tmodify object with {class = siblingclass}\n";
			def += "\t} [4]\n";
			def += "\tmodAssociation2 {\n";
			def += "\t\tobject = select one Object\n";
			def += "\t\tclass1 = select one Class in object->class\n";
			def += "\t\tobjectAssociation = select one ObjectAssociation where {^source = object}\n";
			def += "\t\ttargetClass = select one Class in objectAssociation->^target->class\n";
			def += "\t\tclass2 = select one Class where {self <> class1 and self <> targetClass and abstract = false}\n";
			def += "\t\tmodify object with {class = class2}\n";
			def += "\t} [3]\n";
			def += "\tdelAssociation {\n";
			def += "\t\tremove one ObjectAssociation\n";
			def += "\t} [4]\n";
			def += "\taggregation2CompositionFirst {\n";
			def += "\t\taggr = select one ClassAggregation\n";
			def += "\t\tsrc = select one Class in aggr->^source\n";
			def += "\t\ttar = select one Class in aggr->^target\n";
			def += "\t\tcomp = retype aggr as ClassComposition with {constituent = src, composite = tar}\n";
			def += "\t} [3]\n";
			def += "\taggregation2CompositionSecond from aggregation2CompositionFirst repeat=no{\n";
			def += "\t\taggr = select one ClassAggregation\n";
			def += "\t\tsrc = select one Class in aggr->^source\n";
			def += "\t\ttar = select one Class in aggr->^target\n";
			def += "\t\tcomp = retype aggr as ClassComposition with {constituent = src, composite = tar}\n";
			def += "\t} [3]\n";
			def += "\taggregation2CompositionThird from aggregation2CompositionFirst repeat=no{\n";
			def += "\t\taggr = select one ClassAggregation\n";
			def += "\t\tsrc = select one Class in aggr->^source\n";
			def += "\t\ttar = select one Class in aggr->^target\n";
			def += "\t\tcomp = retype aggr as ClassComposition with {constituent = src, composite = tar}\n";
			def += "\t} [3]\n";
			def += "\taggregation2CompositionFourth from aggregation2CompositionFirst repeat=no{\n";
			def += "\t\taggr = select one ClassAggregation\n";
			def += "\t\tsrc = select one Class in aggr->^source\n";
			def += "\t\ttar = select one Class in aggr->^target\n";
			def += "\t\tcomp = retype aggr as ClassComposition with {constituent = src, composite = tar}\n";
			def += "\t} [3]\n";
			def += "\tswapComposition {\n";
			def += "\t\tmodify one ClassComposition with {swapref(constituent, composite)}\n";
			def += "\t} [4]\n";
			def += "\tswapAggregation {\n";
			def += "\t\tmodify one ClassAggregation with {swapref(^source, ^target)}\n";
			def += "\t} [4]\n";
			def += "\tintAtt2String {\n";
			def += "\t\tintType = select one DataType where {name = \"int\"}\n";
			def += "\t\tstringType = select one DataType where {name = \"String\"}\n";
			def += "\t\tintAtt = select one Attribute where {type = intType}\n";
			def += "\t\tmodify intAtt with {type = stringType}\n";
			def += "\t} [4]\n";
			def += "\tconcrete2AbstractInstanceFirst {\n";
			def += "\t\tabstractClass = select one Class where {abstract = true}\n";
			def += "\t\tsubClass = select one Class where {superclass = abstractClass and abstract = false}\n";
			def += "\t\tobject = select one Object where {class = subClass}\n";
			def += "\t\tmodify object with {class = abstractClass}\n";
			def += "\t} [4]\n";
			def += "\tconcrete2AbstractInstanceSecond from concrete2AbstractInstanceFirst repeat = no {\n";
			def += "\t\tabstractClass = select one Class where {abstract = true}\n";
			def += "\t\tsubClass = select one Class where {superclass = abstractClass and abstract = false}\n";
			def += "\t\tobject = select one Object where {class = subClass}\n";
			def += "\t\tmodify object with {class = abstractClass}\n";
			def += "\t} [4]\n";
			def += "\tconcrete2AbstractInstanceThird from concrete2AbstractInstanceFirst repeat = no {\n";
			def += "\t\tabstractClass = select one Class where {abstract = true}\n";
			def += "\t\tsubClass = select one Class where {superclass = abstractClass and abstract = false}\n";
			def += "\t\tobject = select one Object where {class = subClass}\n";
			def += "\t\tmodify object with {class = abstractClass}\n";
			def += "\t} [4]\n";
			def += "\tconcrete2AbstractInstanceFourth from concrete2AbstractInstanceFirst repeat = no {\n";
			def += "\t\tabstractClass = select one Class where {abstract = true}\n";
			def += "\t\tsubClass = select one Class where {superclass = abstractClass and abstract = false}\n";
			def += "\t\tobject = select one Object where {class = subClass}\n";
			def += "\t\tmodify object with {class = abstractClass}\n";
			def += "\t} [4]\n";
			def += "\tbreakCardinality {\n";
			def += "\t\tclassAssociation = select one ClassAssociation where {multiplicityTarget = \"0..2\"}\n";
			def += "\t\tsrcClass = select one Class where {self = classAssociation->^source}\n";
			def += "\t\ttarClass = select one Class where {self = classAssociation->^target}\n";
			def += "\t\tsrcObject = select one Object where {class = srcClass}\n";
			def += "\t\ttarObject = select one Object where {class = tarClass}\n";
			def += "\t\ttarObject2 = clone tarObject with {name = \"clonedObject1\"}\n";
			def += "\t\ttarObject3 = clone tarObject with {name = \"clonedObject2\"}\n";
			def += "\t\tobjectAssociation = select one ObjectAssociation where {^source = srcObject and ^target = tarObject}\n";
			def += "\t\tclone objectAssociation with {name = \"clonedAssociation1\", ^target = tarObject2}\n";
			def += "\t\tclone objectAssociation with {name = \"clonedAssociation2\", ^target = tarObject3}\n";
			def += "\t} [4]\n";
			def += "}\n";
			if (file.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
			
		String xTextFileName = "file:/" + project.getLocation().toFile().getPath() + "/src/" + fileName;
		String xmiFileName = "file:/" + project.getLocation().toFile().getPath() + "/" + mutantName + '/' + fileName.replaceAll("mutator", "model");
		WodelUtils.serialize(xTextFileName, xmiFileName);

		try {
			
			final IFolder libFolder = project.getFolder(new Path("lib"));
			if (!libFolder.exists()) {
				libFolder.create(true, true, monitor);
			}

			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			File jarFile = new File(UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib/")) {
							final String name = entry.getName();
							final File f = libFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("lib".length(), entry.getName().length()).split("/")[1]);
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
				srcName = UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
				final File src = new Path(srcName).toFile();
				for (File f : src.listFiles()) {
					if (!f.isDirectory()) {
						final IFile dest = libFolder.getFile(new Path(f.getName()));
						dest.create(new FileInputStream(f), true, monitor);
						dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
					}
				}
			}
			
			final IFolder modelValidatorPluginFolder = libFolder.getFolder(new Path("modelValidatorPlugin"));
			if (!modelValidatorPluginFolder.exists()) {
				modelValidatorPluginFolder.create(true, true, monitor);
			}
			final IFolder modelValidatorPluginx86Folder = modelValidatorPluginFolder.getFolder(new Path("x86"));
			if (!modelValidatorPluginx86Folder.exists()) {
				modelValidatorPluginx86Folder.create(true, true, monitor);
			}

			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			jarFile = new File(UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib/modelValidatorPlugin/x86/")) {
							final String name = entry.getName();
							final File f = modelValidatorPluginx86Folder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("lib/modelValidatorPlugin/x86".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = modelValidatorPluginx86Folder.getFile(new Path(dest.getName()
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
				srcName = UMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
				final File src = new Path(srcName).toFile();
				for (File f : src.listFiles()) {
					if (!f.isDirectory()) {
						final IFile dest = modelValidatorPluginx86Folder.getFile(new Path(f.getName()));
						dest.create(new FileInputStream(f), true, monitor);
						dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
					}
				}
			}
			
		} catch (IOException e) {
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
		
		createPlugin(monitor, project);

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
