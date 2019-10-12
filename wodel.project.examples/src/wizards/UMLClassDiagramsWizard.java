package wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import manager.IOUtils;
import manager.ModelManager;
import utils.EclipseHelper;
import wodel.dsls.WodelUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel new UML class diagrams example project Wizard.
 * 
 * Wodel new UML class diagrams example project Wizard.
 *  
 */
public class UMLClassDiagramsWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public UMLClassDiagramsWizardPage _pageOne;

	private static final String WIZARD_NAME = "UML Class Diagrams Example";

	public UMLClassDiagramsWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new UMLClassDiagramsWizardPage(selection);
		_pageOne.setTitle("Wodel UML Class Diagrams Example");
		_pageOne.setDescription("Create a Wodel UML Class Diagrams Example");
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

		requiredBundles.add("wodel.utils;bundle-version=\"1.0.0\"");
		requiredBundles.add("wodel.models;bundle-version=\"1.0.0\"");
		requiredBundles
				.add("org.eclipse.emf.ecore.xmi;bundle-version=\"2.9.0\"");
		requiredBundles.add("org.eclipse.emf.ecore");
		requiredBundles.add("org.eclipse.emf.compare;bundle-version=\"3.1.2\"");
		requiredBundles.add("com.google.guava;bundle-version=\"15.0.0\"");
		requiredBundles.add("org.apache.log4j;bundle-version=\"1.2.15\"");
		requiredBundles.add("org.eclipse.ocl;bundle-version=\"3.4.2\"");
		requiredBundles.add("org.eclipse.ocl.ecore;bundle-version=\"3.3.100\"");
		requiredBundles.add("org.eclipse.core.resources");
		requiredBundles.add("org.eclipse.emf.common");
		requiredBundles.add("org.eclipse.core.runtime;bundle-version=\"3.10.0\"");
		requiredBundles.add("org.eclipse.text");

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
			final File jarFile = new File(AutomataWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/umlcd")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/umlcd", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/umlcd", ""));
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
				srcName = AutomataWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/umlcd";
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
		// create a sample file
		monitor.beginTask("Creating " + fileName, 7);

		final IFolder srcFolder = project.getFolder(new Path("src"));

		final IFile file = srcFolder.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			String def = "generate 2 mutants\n"
					+ "in \"" + mutantName + "/\"\n"
					+ "from \"" + modelName + "/\"\n";
			def += "metamodel \"" + ModelManager.getMetaModelPath(projectName) + "/" + metamodel + "\"\n\n";
			def += "with blocks {\n";
			def += "\tuco1 {\n";
			def += "\t\tclone contents one Constraint\n";
			def += "\t}\n";
			def += "\tuco2 {\n";
			def += "\t\tcreate Constraint with {type = one Class, id = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tuas1 {\n";
			def += "\t\tclone one Association\n";
			def += "\t}\n";
			def += "\tuas2 {\n";
			def += "\t\ta1 = select one Association\n";
			def += "\t\ta2 = select one Association where {src = a1->tar}\n";
			def += "\t\ta3 = create Association with {\n";
			def += "\t\t\tname = random-string(1, 4),\n";
			def += "\t\t\tsrc = a1->src, tar = a2->tar,\n";
			def += "\t\t\tcopy(nsrc, a1.nsrc), copy(ntar, a2.ntar),\n";
			def += "\t\t\tderived = true\n";
			def += "\t\t}\n";
			def += "\t}\n";
			def += "\tuas3 {\n";
			def += "\t\tcreate Association with {src = one Class, tar = one Class, name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tuas4 {\n";
			def += "\t\tcreate Association with {src = one Class, tar = one Class, name = random-string(1, 4), derived = true}\n";
			def += "\t}\n";
			def += "\tuge1 {\n";
			def += "\t\tcl = select one Class where {super <> null and super->super <> null}\n";
			def += "\t\tsup1 = select one Class in cl->super where {super <> null}\n";
			def += "\t\tsup2 = select one Class in sup1->super where {self <> cl->super}\n";
			def += "\t\tmodify cl with {super = sup2}\n";
			def += "\t}\n";
			def += "\tuge2 {\n";
			def += "\t\tcl1 = select one Class where {super <> null}\n";
			def += "\t\tsup = select all Class in closure(cl1->super)\n";
			def += "\t\tcl2 = select one Class where {self <> sup}\n";
			def += "\t\tmodify cl1 with {super = cl2}\n";
			def += "\t}\n";
			def += "\tucl1 {\n";
			def += "\t\tclone contents one Class\n";
			def += "\t}\n";
			def += "\tucl2 {\n";
			def += "\t\tcreate Class with {name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tucl3 {\n";
			def += "\t\tclone one AssociationClass\n";
			def += "\t}\n";
			def += "\tucl4 {\n";
			def += "\t\tcreate AssociationClass with {name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tuat1 {\n";
			def += "\t\tclone one Attribute\n";
			def += "\t}\n";
			def += "\tuat2 {\n";
			def += "\t\tcreate Attribute with {type = one Class, name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tuop1 {\n";
			def += "\t\tclone contents one Operation\n";
			def += "\t}\n";
			def += "\tuop2 {\n";
			def += "\t\tcreate Operation with {type = one Class, name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\tupa1 {\n";
			def += "\t\tclone one Parameter\n";
			def += "\t}\n";
			def += "\tupa2 {\n";
			def += "\t\tcreate Parameter with {name = random-string(1, 4)}\n";
			def += "\t}\n";
			def += "\twco1 {\n";
			def += "\t\tremove one PathElementCS where {pathName = one Attribute}\n";
			def += "\t}\n";
			def += "\twco2 {\n";
			def += "\t\tpath = select one PathElementCS where {pathName = one Attribute}\n";
			def += "\t\tatt = select one Attribute in path->pathName\n";
			def += "\t\tmodify att with {type = other Class}\n";
			def += "\t}\n";
			def += "\twco3 {\n";
			def += "\t\tremove one OperationCS\n";
			def += "\t}\n";
			def += "\twco4 {\n";
			def += "\t\tmodify one IntLiteralExpCS with {op in ['add', 'subtract', 'multiply', 'divide']}\n";
			def += "\t}\n";
			def += "\twco5 {\n";
			def += "\t\tinv = select one InvariantCS where {exp <> null}\n";
			def += "\t\tcreate LogicExpCS in inv->exp with {op = 'not'}\n";
			def += "\t}\n";
			def += "\twco6a {\n";
			def += "\t\tmodify one BooleanExpCS where {op = 'and'} with {op = 'or'}\n";
			def += "\t}\n";
			def += "\twco6b {\n";
			def += "\t\tmodify one BooleanExpCS where {op = 'or'} with {op = 'and'}\n";
			def += "\t}\n";
			def += "\twco7 {\n";
			def += "\t\tremove one LogicExpCS where {op = 'not'}\n";
			def += "\t}\n";
			def += "\twco8 {\n";
			def += "\t\tmodify one BooleanExpCS where {op in ['lt', 'lte', 'gt', 'gte', 'equals', 'distinct']}\n";
			def += "\t\t\twith {op in ['lt', 'lte', 'gt', 'gte', 'equals', 'distinct']}\n";
			def += "\t}\n";
			def += "\twco9 {\n";
			def += "\t\tmodify one IntLiteralExpCS where {op = 'negative'} with {op = ''}\n";
			def += "\t}\n";
			def += "\twas1 {\n";
			def += "\t\tmodify one Association with {swapref(src, tar)}\n";
			def += "\t}\n";
			def += "\twas2a {\n";
			def += "\t\tretype one Association as Aggregation\n";
			def += "\t}\n";
			def += "\twas2b {\n";
			def += "\t\tretype one Aggregation as Association\n";
			def += "\t}\n";
			def += "\twas2c {\n";
			def += "\t\tretype one Association as Composition\n";
			def += "\t}\n";
			def += "\twas2d {\n";
			def += "\t\tretype one Composition as Association\n";
			def += "\t}\n";
			def += "\twas2e {\n";
			def += "\t\tretype one Association as Dependency\n";
			def += "\t}\n";
			def += "\twas2f {\n";
			def += "\t\tretype one Dependency as Association\n";
			def += "\t}\n";
			def += "\twas2g {\n";
			def += "\t\tretype one Aggregation as Composition\n";
			def += "\t}\n";
			def += "\twas2h {\n";
			def += "\t\tretype one Composition as Aggregation\n";
			def += "\t}\n";
			def += "\twas2i {\n";
			def += "\t\tretype one Aggregation as Dependency\n";
			def += "\t}\n";
			def += "\twas2j {\n";
			def += "\t\tretype one Dependency as Aggregation\n";
			def += "\t}\n";
			def += "\twas2k {\n";
			def += "\t\tretype one Composition as Dependency\n";
			def += "\t}\n";
			def += "\twas2l {\n";
			def += "\t\tretype one Dependency as Composition\n";
			def += "\t}\n";
			def += "\twas3 {\n";
			def += "\t\tmodify one Association with {ntar in ['*', '0..1', '1..1', '1..*']}\n";
			def += "\t}\n";
			def += "\twge {\n";
			def += "\t\tmodify one Class with {super = other Class}\n";
			def += "\t}\n";
			def += "\twcl1 {\n";
			def += "\t\tmodify one Class with {visibility in {public, private, protected, package}}\n";
			def += "\t}\n";
			def += "\twcl2 {\n";
			def += "\t\tretype one Class as AssociationClass with {association = one Association}\n";
			def += "\t}\n";
			def += "\twcl3 {\n";
			def += "\t\tretype one AssociationClass as Class\n";
			def += "\t}\n";
			def += "\twcl4 {\n";
			def += "\t\tmodify one Class where {abstract = false} with {abstract = true}\n";
			def += "\t}\n";
			def += "\twat1 {\n";
			def += "\t\tmodify one Attribute where {derived = false} with {derived = true}\n";
			def += "\t}\n";
			def += "\twat2 {\n";
			def += "\t\tmodify one Attribute where {derived = true} with {derived = false}\n";
			def += "\t}\n";
			def += "\twat3 {\n";
			def += "\t\tmodify one Attribute with {type = other NamedElement}\n";
			def += "\t}\n";
			def += "\twat4 {\n";
			def += "\t\tmodify one Attribute with {visibility in {public, private, protected, package}}\n";
			def += "\t}\n";
			def += "\twop1 {\n";
			def += "\t\toper = select one Operation where {params <> null}\n";
			def += "\t\tp = select one Parameter in oper->params\n";
			def += "\t\tmodify oper with {params -= p, params += p}\n";
			def += "\t}\n";
			def += "\twop2 {\n";
			def += "\t\tmodify one Operation with {visibility in {public, private, protected, package}}\n";
			def += "\t}\n";
			def += "\twop3 {\n";
			def += "\t\tmodify one Operation with {type = other NamedElement}\n";
			def += "\t}\n";
			def += "\twpa {\n";
			def += "\t\tmodify one Parameter with {type = other NamedElement}\n";
			def += "\t}\n";
			def += "\tmco {\n";
			def += "\t\tremove one Constraint\n";
			def += "\t}\n";
			def += "\tmas {\n";
			def += "\t\tremove one Association\n";
			def += "\t}\n";
			def += "\tmge {\n";
			def += "\t\tcl = select one Class where {super <> null}\n";
			def += "\t\tremove one Class from cl->super\n";
			def += "\t}\n";
			def += "\tmcl {\n";
			def += "\t\tcl = select one Class\n";
			def += "\t\tremove all Relation where {src = cl or tar = cl}\n";
			def += "\t\tremove all Operation where {type = cl}\n";
			def += "\t\tremove all Feature where {type = cl}\n";
			def += "\t\tremove all AssociationClass where {association = null}\n";
			def += "\t\tremove cl\n";
			def += "\t}\n";
			def += "\tmat {\n";
			def += "\t\tremove one Attribute\n";
			def += "\t}\n";
			def += "\tmop {\n";
			def += "\t\tremove one Operation\n";
			def += "\t}\n";
			def += "\tmpa {\n";
			def += "\t\tremove one Parameter\n";
			def += "\t}\n";
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
		} catch (IOException e) {
		}
			
		String xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + project.getFolder(new Path("/src/" + fileName)).getFullPath();
		String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + project.getFolder(new Path('/' + mutantName + '/' + fileName.replaceAll("mutator", "model"))).getFullPath();
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
}
