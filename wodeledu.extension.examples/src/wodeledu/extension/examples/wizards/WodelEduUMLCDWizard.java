package wodeledu.extension.examples.wizards;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
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
import org.eclipse.core.runtime.Platform;
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
import wodel.utils.manager.ProjectUtils;
import wodel.dsls.WodelUtils;
import wodeledu.dsls.ModelTextUtils;
import wodeledu.dsls.MutaTextUtils;
import wodeledu.extension.examples.builder.WodelEduNature;
import wodeledu.extension.examples.utils.EclipseHelper;

/**
 * @author Pablo Gomez-Abajo - Wodel new Wodel-Edu for uml class diagrams example project Wizard.
 * 
 * Wodel new Wodel-Edu for uml class diagrams example project Wizard.
 *  
 */

public class WodelEduUMLCDWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public WodelEduUMLCDWizardPage _pageOne;

	private static final String WIZARD_NAME = "Wodel-Edu UML Class Diagrams Example";

	public WodelEduUMLCDWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new WodelEduUMLCDWizardPage(selection);
		_pageOne.setTitle("Wodel-Edu UML Class Diagrams Example");
		_pageOne.setDescription("Create a Wodel-Edu UML Class Diagrams Example");
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

		List<IProject> referencedProjects = new ArrayList<IProject>();
		Set<String> requiredBundles = new HashSet<String>();
		Set<String> importPackages = new HashSet<String>();
		List<String> exportedPackages = new ArrayList<String>();
		List<String> bundleClasspath = new ArrayList<String>();

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
		requiredBundles.add("wodeledu.extension");
		requiredBundles.add("wodeledu.models");
		
		importPackages.add("org.apache.log4j");
		importPackages.add("org.eclipse.xtext.generator");
		importPackages.add("org.eclipse.xtext.xbase.lib");
		importPackages.add("org.eclipse.xtext.util");
		importPackages.add("wodeledu.dsls.generator");
		importPackages.add("com.google.inject");
		importPackages.add("javax.inject");
		importPackages.add("com.google.common.util.concurrent.internal");
		importPackages.add("org.antlr.runtime");		
		importPackages.add("edutest");
		
		bundleClasspath.add("lib/plantuml-epl-1.2023.13.jar");

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
			final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/wodeleducd")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/wodeleducd", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/wodeleducd", ""));
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/wodeleducd";
				final File src = new Path(srcName).toFile();
				final File dest = modelFolder.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
				if (src != null) {
					for (File f: src.listFiles()) {
						if (f.getName().endsWith(".ecore")) {
							srcMetamodel = f.getPath();
							break;
						}
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
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
			
		String xTextFileName = "file:/" + project.getLocation().toFile().getPath() + "/src/" + fileName;
		String xmiFileName = "file:/" + project.getLocation().toFile().getPath() + "/" + mutantName + '/' + fileName.replaceAll("mutator", "model");
		WodelUtils.serialize(xTextFileName, xmiFileName);

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

		Path filePath = new Path(fileName);
		String fileExtension = filePath.getFileExtension();
		String graphFileName = fileName.replace(fileExtension, "draw");
		// create a sample file
		monitor.beginTask("Creating " + graphFileName, 2);
		String testsFileName = fileName.replace(fileExtension, "test");
		String idelemsFileName = fileName.replace(fileExtension, "modeltext");
		String cfgoptsFileName = fileName.replace(fileExtension, "mutatext");

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		final IFile graphFile = srcFolder.getFile(new Path(graphFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			
			def += "ClassDiagram: diagram {\n"
				+ "\tClass: node shape=record\n"
				+ "\tClass(abstract): node shape=record style=italic\n"
				+ "\tClass -> Class(superclass): edge label=name tar_decoration=triangle\n"
				+ "\tClassAssociation(source, target): edge\n"
				+ "\tClassComposition(constituent, composite): edge\n"
				+ "\tClassAggregation(source, target): edge\n"
				+ "}\n\n"
				+ "ObjectDiagram: diagram {\n"
				+ "\tObject: node shape=record\n"
				+ "\tObjectAssociation(source, target): edge\n"
				+ "\tObjectComposition(constituent, composite): edge\n"
				+ "\tObjectAggregation(source, target): edge\n"
				+ "}\n";
			if (graphFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				graphFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				graphFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile testsFile = srcFolder.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/"+ projectName + "/" + modelName + "/" + metamodel + "\"\n\n" 
					+ "navigation=free\n"
					+ "AlternativeResponse concrete2AbstractInstanceFirst = solution {\n"
					+ "\tretry=yes, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'VehicleShop.model' = 'Select the object diagram that is a valid instance of the class diagram shown below'\n"
					+ "}\n"
					+ "AlternativeResponse concrete2AbstractInstanceFirst = solution {\n"
					+ "\tretry=yes, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'CoffeeShop.model' = 'Select the object diagram that is a valid instance of the class diagram shown below'\n"
					+ "}\n"
					+ "MultiChoiceDiagram concrete2AbstractInstanceFirst {\n"
					+ "\tretry=yes, mode=radiobutton, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'VehicleShop.model' = 'Select which of the following object diagrams is a valid instance of the class diagram shown below'\n"
					+ "}\n"
					+ "MultiChoiceDiagram modAssociation1=solution, delAssociation, modAssociation2 {\n"
					+ "\tretry=yes, mode=checkbox, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'CoffeeShop.model' = 'Select which of the following object diagrams are valid instances of the class diagram shown below'\n"
					+ "}\n"
					+ "MultiChoiceDiagram aggregation2CompositionFirst, swapComposition {\n"
					+ "\tretry=yes, mode=radiobutton, statement=ClassDiagram, answers=ClassDiagram\n"
					+ "\tdescription for 'GUI.model' = 'Select which of the following class diagrams is correct'\n"
					+ "}\n"
					+ "MultiChoiceDiagram aggregation2CompositionFirst, swapComposition {\n"
					+ "\tretry=yes, mode=radiobutton, statement=ClassDiagram, answers=ClassDiagram\n"
					+ "\tdescription for 'CarRental.model' = 'Select which of the following class diagrams is correct'\n"
					+ "}\n"
					+ "MultiChoiceDiagram intAtt2String, concrete2AbstractInstanceFirst, breakCardinality {\n"
					+ "\tretry=yes, mode=radiobutton, statement=ClassDiagram, answers=ClassDiagram\n"
					+ "\tdescription for 'Person2Course.model' = 'Select which of the following object diagrams is a valid instance of the class diagram shown below'\n"
					+ "}\n"
					+ "MultiChoiceEmendation concrete2AbstractInstanceFirst = solution, concrete2AbstractInstanceSecond, concrete2AbstractInstanceThird, concrete2AbstractInstanceFourth {\n"
					+ "\tretry=no, weighted=no, penalty=0.0,\n"
					+ "\torder=options-descending, mode=checkbox, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'Person2Course.model' = 'Which changes shall be applied to this object diagram to match the class diagram shown below'\n"
					+ "}\n"
					+ "MultiChoiceEmendation concrete2AbstractInstanceFirst = solution, concrete2AbstractInstanceSecond, concrete2AbstractInstanceThird, concrete2AbstractInstanceFourth {\n"
					+ "\tretry=no, weighted=no, penalty=0.0,\n"
					+ "\torder=options-descending, mode=checkbox, statement=ClassDiagram, answers=ObjectDiagram\n"
					+ "\tdescription for 'VehicleShop.model' = 'Which changes shall be applied to this object diagram to match the class diagram shown below'\n"
					+ "}";
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				testsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				testsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile idelemsFile = srcFolder.getFile(new Path(idelemsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += "ClassDiagram {\n";
			def += "\t>Class: %name\n";
			def += "\t>Class(not abstract): concrete %name\n";
			def += "\t>Class(abstract): abstract %name\n";
			def += "\t>ClassAggregation: aggregation from %source.name to %target.name\n";
			def += "\t>ClassComposition: composition from %constituent.name to %composite.name\n";
			def += "\t>ClassAssociation: association from %source.name to %target.name\n";
			def += "}\n\n";
			def += "ObjectDiagram {\n";
			def += "\t>Object: object of %class.name\n";
			def += "\t>ObjectAggregation: aggregation from %source.name to %target.name\n";
			def += "\t>ObjectAssociation: association from %source.name to %target.name\n";
			def += "}\n\n";
			if (idelemsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				idelemsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				idelemsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		xTextFileName = "file:/" + Platform.getLocation().toFile().getPath().replace("\\", "/") +'/' + project.getFolder(new Path("/src/" + idelemsFileName)).getFullPath();
		xmiFileName = "file:/" + Platform.getLocation().toFile().getPath().replace("\\", "/") + '/' + project.getFolder(new Path('/' + mutantName + '/' + idelemsFileName.replaceAll(".modeltext", "_modeltext.model"))).getFullPath();
		ModelTextUtils.serialize(xTextFileName, xmiFileName);

		final IFile cfgoptsFile = srcFolder.getFile(new Path(cfgoptsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += ">ObjectRetyped: Change %object to %toObject /\n";
			def += "\tChange %toObject to %object\n";
			def += ">ReferenceChanged: Change %toObject to %fromObject /\n";
			def += "\tChange %fromObject to %toObject\n";
			if (cfgoptsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				cfgoptsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				cfgoptsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		xTextFileName = "file:/" + Platform.getLocation().toFile().getPath().replace("\\", "/") +'/' + project.getFolder(new Path("/src/" + cfgoptsFileName)).getFullPath();
		xmiFileName = "file:/" + Platform.getLocation().toFile().getPath().replace("\\", "/") + '/' + project.getFolder(new Path('/' + mutantName + '/' + cfgoptsFileName.replaceAll(".mutatext", "_mutatext.model"))).getFullPath();
		MutaTextUtils.serialize(xTextFileName, xmiFileName);
		
		final IFile configFile = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = configFile.getContents();
			if (configFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += "\nWodel-Edu: Environment for the automated generation and evaluation of exercises";
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				configFile.setContents(stream, true, true, monitor);
			}
			else {
				configFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		final IFolder srcgenFolder = project.getFolder(new Path("src-gen"));
		try {
			srcgenFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder htmlFolder = srcgenFolder.getFolder(new Path("html"));
		try {
			htmlFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("content")) {
		    			final File f = htmlFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("content/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "content";
			final File src = new Path(srcName).toFile();
			final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}

		final IFolder configurationsFolder = project.getFolder(new Path("data/configurations"));
		try {
			configurationsFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("configurations")) {
		    			final File f = configurationsFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("configurations/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "configurations";
			final File src = new Path(srcName).toFile();
			final File dest = configurationsFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}
		
		final IFolder initialFolder = project.getFolder(new Path("data/initial"));
		try {
			initialFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("initial")) {
		    			final File f = initialFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("initial/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "initial";
			final File src = new Path(srcName).toFile();
			final File dest = initialFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
			
		}

		final IFolder appFolder = project.getFolder(new Path("app"));
		try {
			appFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder mobileFolder = appFolder.getFolder(new Path("mobile"));
		try {
			mobileFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder iOSFolder = appFolder.getFolder(new Path("ios"));
		try {
			iOSFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("mobile")) {
		    			final File f = mobileFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("mobile/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "mobile";
			final File src = new Path(srcName).toFile();
			final File dest = mobileFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}
		
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("ios")) {
		    			final File f = iOSFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("ios/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "ios";
			final File src = new Path(srcName).toFile();
			final File dest = iOSFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}
		
		try {
			
			final IFolder libFolder = project.getFolder(new Path("lib"));
			if (!libFolder.exists()) {
				libFolder.create(true, true, monitor);
			}

			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
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
			jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
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


		
		final IFolder dpicFolder = project.getFolder(new Path("dpic"));
		dpicFolder.create(true, true, monitor);

		try {
			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("dpic")) {
							final String name = entry.getName();
							final File f = dpicFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("dpic".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = dpicFolder.getFile(new Path(dest.getName()
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic";
				final File src = new Path(srcName).toFile();
				if (src != null) {
					for (File f : src.listFiles()) {
						if (f.isFile()) {
							final IFile dest = dpicFolder.getFile(new Path(f.getName()));
							dest.create(new FileInputStream(f), true, monitor);
							dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
						}
					}
				}
			}
		} catch (IOException e) {
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final IFolder batikFolder = dpicFolder.getFolder(new Path("batik"));
		batikFolder.create(true, true, monitor);

		try {
			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("batik")) {
							final String name = entry.getName();
							final File f = batikFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("batik".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = batikFolder.getFile(new Path(dest.getName()
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik";
				final File src = new Path(srcName).toFile();
				if (src != null) {
					for (File f : src.listFiles()) {
						final IFile dest = batikFolder.getFile(new Path(f.getName()));
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


		final IFolder batikExtensionsFolder = batikFolder.getFolder(new Path("extensions"));
		batikExtensionsFolder.create(true, true, monitor);

		try {
			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("extensions")) {
							final String name = entry.getName();
							final File f = batikExtensionsFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("extensions".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = batikExtensionsFolder.getFile(new Path(dest.getName()
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik/extensions";
				final File src = new Path(srcName).toFile();
				if (src != null) {
					for (File f : src.listFiles()) {
						final IFile dest = batikExtensionsFolder.getFile(new Path(f.getName()));
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
		
		final IFolder batikLibFolder = batikFolder.getFolder(new Path("lib"));
		batikLibFolder.create(true, true, monitor);

		try {
			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			final File jarFile = new File(WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib")) {
							final String name = entry.getName();
							final File f = batikLibFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("lib".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = batikLibFolder.getFile(new Path(dest.getName()
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
				srcName = WodelEduUMLCDWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik/lib";
				final File src = new Path(srcName).toFile();
				if (src != null) {
					for (File f : src.listFiles()) {
						final IFile dest = batikLibFolder.getFile(new Path(f.getName()));
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

		try {

			//addTextToFile(configPath, "config.txt", "\n" + this.getName(), monitor);
			
			IProjectDescription description = project.getDescription();

			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = WodelEduNature.NATURE_ID;

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
		IFile mutatorFile = srcFolder.getFile(new Path(fileName));
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, mutatorFile, true);
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
