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
import java.nio.charset.StandardCharsets;
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

import com.google.common.io.CharStreams;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ProjectUtils;
import wodel.dsls.WodelUtils;
import wodeledu.dsls.ModelTextUtils;
import wodeledu.dsls.MutaTextUtils;
import wodeledu.extension.examples.builder.WodelEduNature;
import wodeledu.extension.examples.utils.EclipseHelper;

/**
 * @author Pablo Gomez-Abajo - Wodel new Wodel-Edu for Python example project Wizard.
 * 
 * Wodel new Wodel-Edu for Python example project Wizard.
 *  
 */

public class WodelEduPythonWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public WodelEduPythonWizardPage _pageOne;

	private static final String WIZARD_NAME = "Wodel-Edu Python Example";

	public WodelEduPythonWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new WodelEduPythonWizardPage(selection);
		_pageOne.setTitle("Wodel-Edu Python Example");
		_pageOne.setDescription("Create a Wodel-Edu Python Example");
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
		
		bundleClasspath.add("lib/plantuml-epl-1.2026.2.jar");

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
			final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/wodeledupy")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/wodeledupy", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/wodeledupy", ""));
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/wodeledupy";
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
			def += "\taor1 {\n";
			def += "\t\tretype one Add as [Sub, Div, Mult, ModOp]\n";
			def += "\t}\n";
			def += "\taor2 {\n";
			def += "\t\tretype one Sub as [Add, Div, Mult, ModOp]\n";
			def += "\t}\n";
			def += "\taor3 {\n";
			def += "\t\tretype one Mult as [Add, Sub, Div, ModOp]\n";
			def += "\t}\n";
			def += "\taor4 {\n";
			def += "\t\tretype one Div as [Add, Sub, Mult, ModOp]\n";
			def += "\t}\n";
			def += "\taor5 {\n";
			def += "\t\tretype one ModOp as [Add, Sub, Mult, Div]\n";
			def += "\t}\n\n";
			def += "\tcor1 {\n";
			def += "\t\tretype one Eq as [NotEq, Lt, LtE, Gt, GtE]\n";
			def += "\t}\n";
			def += "\tcor2 {\n";
			def += "\t\tretype one NotEq as [Eq, Lt, LtE, Gt, GtE]\n";
			def += "\t}\n";
			def += "\tcor3 {\n";
			def += "\t\tretype one Lt as [LtE, Gt, GtE, Eq, NotEq]\n";
			def += "\t}\n";
			def += "\tcor4 {\n";
			def += "\t\tretype one LtE as [Lt, Gt, GtE, Eq, NotEq]\n";
			def += "\t}\n";
			def += "\tcor5 {\n";
			def += "\t\tretype one Gt as [GtE, Lt, LtE, Eq, NotEq]\n";
			def += "\t}\n";
			def += "\tcor6 {\n";
			def += "\t\tretype one GtE as [Gt, Lt, LtE, Eq, NotEq]\n";
			def += "\t}\n\n";
			def += "\tuor1 {\n";
			def += "\t\tretype one USub as [UAdd, Not]\n";
			def += "\t}\n";
			def += "\tuor2 {\n";
			def += "\t\tretype one UAdd as [USub, Not]\n";
			def += "\t}\n";
			def += "\tuor3  {\n";
			def += "\t\tretype one Not as [UAdd, USub]\n";
			def += "\t}\n\n";
			def += "\tcor3fuor1 from uor1 repeat=no {\n";
			def += "\t\tretype one Lt as [LtE, Gt, GtE, Eq, NotEq]\n";
			def += "\t}\n\n";
			def += "\tnc {\n";
			def += "\t\tif1 = select one If where {test <> null}\n";
			def += "\t\tneg = create UnaryOp in if1->test with {operand = if1->test}\n";
			def += "\t\tcreate Not in neg->op\n";
			def += "\t}\n\n";
			def += "\twr {\n";
			def += "\t\tret = select one Return where {value <> null}\n";
			def += "\t\tu = create UnaryOp in ret->value with {operand = ret->value}\n";
			def += "\t\tcreate USub in u->op\n";
			def += "\t}\n\n";
			def += "\tmsifwr from wr repeat=no {\n";
			def += "\t\ts = select one Subscript\n";
			def += "\t\tc = select one Constant in s->slice\n";
			def += "\t\tmodify c with {value in ['0', '1', '-1']}\n";
			def += "\t}\n\n";
			def += "\tfb1 {\n";
			def += "\t\tmodify one Constant where {value = 'True'} with {value = 'False'}\n";
			def += "\t}\n";
			def += "\tfb2 {\n";
			def += "\t\tmodify one Constant where {value = 'False'} with {value = 'True'}\n";
			def += "\t}\n";
			def += "\tzc {\n";
			def += "\t\tmodify one Constant where {value = '0'} with {value in ['1', '-1', '2']}\n";
			def += "\t}\n\n";
			def += "\toc {\n";
			def += "\t\tmodify one Constant where {value = '1'} with {value in ['0', '2']}\n";
			def += "\t}\n\n";
			def += "\ttc {\n";
			def += "\t\tmodify one Constant where {value = '2'} with {value in ['0', '1', '3']}\n";
			def += "\t}\n\n";
			def += "\tcid1 {\n";
			def += "\t\tret = select one Return where {value <> null}\n";
			def += "\t\tn1 = select one Name in ret->value\n";
			def += "\t\tn2 = select one Name where {self <> n1 and id <> n1.id}\n";
			def += "\t\tmodify n1 with {copy (id, n2.id)}\n";
			def += "\t}\n\n";
			def += "\tcid2fcid1 from cid1 repeat=no {\n";
			def += "\t\tn1 = select one Name where {id in ['a', 'b', 'c', 'n', 'x', 'xs', 'total', 'result', 'temp', 'i', '_']}\n";
			def += "\t\tn2 = select one Name where {self <> n1 and id <> n1.id}\n";
			def += "\t\tmodify n1 with {copy (id, n2.id)}\n";
			def += "\t}\n\n";
			def += "\tcid2 {\n";
			def += "\t\tn1 = select one Name where {id in ['a', 'b', 'c', 'n', 'x', 'xs', 'total', 'result', 'temp', 'i', '_']}\n";
			def += "\t\tn2 = select one Name where {self <> n1 and id <> n1.id}\n";
			def += "\t\tmodify n1 with {copy (id, n2.id)}\n";
			def += "\t}\n\n";
			def += "\tcid1fcid2 from cid2 repeat=no {\n";
			def += "\t\tret = select one Return where {value <> null}\n";
			def += "\t\tn1 = select one Name in ret->value\n";
			def += "\t\tn2 = select one Name where {self <> n1 and id <> n1.id}\n";
			def += "\t\tmodify n1 with {copy (id, n2.id)}\n";
			def += "\t}\n\n";
			def += "\tre {\n";
			def += "\t\tif1 = select one If where {orelse <> null}\n";
			def += "\t\tremove all Stmt from if1->orelse\n";
			def += "\t}\n\n";
			def += "\tmae {\n";
			def += "\t\tf = select one FunctionDef where {body <> null}\n";
			def += "\t\ts = select one Assign in f->body\n";
			def += "\t\tmodify f with {body -= s, body += s}\n";
			def += "\t}\n\n";
			def += "\tra {\n";
			def += "\t\tf = select one FunctionDef where {body <> null}\n";
			def += "\t\tremove one Assign from f->body\n";
			def += "\t}\n\n";
			def += "\tmsi {\n";
			def += "\t\ts = select one Subscript\n";
			def += "\t\tc = select one Constant in s->slice\n";
			def += "\t\tmodify c with {value in ['0', '1', '-1']}\n";
			def += "\t}\n\n";
			def += "\twrfmsi from msi repeat=no {\n";
			def += "\t\tret = select one Return where {value <> null}\n";
			def += "\t\tu = create UnaryOp in ret->value with {operand = ret->value}\n";
			def += "\t\tcreate USub in u->op\n";
			def += "\t}\n";
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

			def += "Module: diagram {\n";
			def += "\tNamedElement(lineno): node shape=circle\n";
			def += "}";
			
			if (graphFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				graphFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
				graphFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile testsFile = srcFolder.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n"
					+ "navigation=free\n\n";
			def += "MultiChoiceText cor5 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'max2.model' = 'Please select which of the following Python functions correctly returns the greater of two integers.'\n";
			def += "}\n\n";
			def += "MultiChoiceText aor5 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'iseven.model' = 'Please select which of the following Python functions returns True only for even integers.'\n";
			def += "}\n\n";
			def += "MultiChoiceText cor5 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'ispositive.model' = 'Please select which of the following Python functions correctly checks whether n is positive.'\n";
			def += "}\n\n";
			def += "MultiChoiceText aor2 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'factorialrecursive.model' = 'Please select which recursive Python function correctly computes the factorial of n.'\n";
			def += "}\n\n";
			def += "MultiChoiceText aor1 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'doubleprogram.model' = 'Please select which of the following Python programs correctly doubles the input value and prints the result for x = 3.'\n";
			def += "}\n\n";
			def += "MultiChoiceText cid1 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'sumn.model' = 'Please select which of the following Python functions correctly computes the sum from 0 to n.'\n";
			def += "}\n\n";
			def += "MatchPairs aor1 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'doubleprogram.model' = 'Select which modification has been performed to the below program to produce each of the programs on the left.'\n";
			def += "}\n\n";
			def += "MatchPairs cor5 {\n";
			def += "\tretry=yes, text='py-code'\n";
			def += "\tdescription for 'max2.model' = 'Select which modification has been performed to the below program to produce each of the programs on the left.'\n";
			def += "}\n\n";
			def += "MultiChoiceEmendation cor3=solution, cor3fuor1  {\n";
			def += "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n";
			def += "\tdescription for 'absvalue.model' = 'Please select the edit that repairs the Python function so that it correctly computes the absolute value of x.'\n";
			def += "}\n\n";
			def += "MultiChoiceEmendation cid1=solution, cid1fcid2 {\n";
			def += "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n";
			def += "\tdescription for 'square.model' = 'Please select the edit that repairs the Python function so that it correctly returns the square of x.'\n";
			def += "}\n\n";
			def += "MultiChoiceEmendation cid2=solution, cid2fcid1 {\n";
			def += "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n";
			def += "\tdescription for 'add.model' = 'Please select the edit that repairs the Python function so that it correctly returns the sum of a and b.'\n";
			def += "}\n\n";
			def += "MultiChoiceEmendation msi=solution, msifwr {\n";
			def += "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n";
			def += "\tdescription for 'firstelement.model' = 'Please select the edit that repairs the Python function so that it returns the first element of the list.'\n";
			def += "}\n\n";
			def += "MultiChoiceEmendation wr=solution, wrfmsi {\n";
			def += "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n";
			def += "\tdescription for 'absvalue.model' = 'Please select the edit that repairs the Python function so that negative inputs are converted into their absolute value.'\n";
			def += "}\n\n";
			def += "MissingWords cor5  {\n";
			def += "\tretry=yes\n";
			def += "\tdescription for 'ispositive.model' = 'Complete the missing operator so that the Python function correctly checks whether n is positive.'\n";
			def += "}\n\n";
			def += "MissingWords msi {\n";
			def += "\tretry=yes\n";
			def += "\tdescription for 'firstelement.model' = 'Complete the missing index so that the Python function returns the first element of the list.'\n";
			def += "}\n\n";
			def += "DragAndDropText mae {\n";
			def += "\tretry=yes\n";
			def += "\tdescription for 'swappair.model' = 'Reorder the Python assignment statements so that the function correctly swaps the two values.'\n";
			def += "}\n\n";
			def += "DragAndDropText ra {\n";
			def += "\tretry=yes\n";
			def += "\tdescription for 'factorialiterative.model' = 'Reconstruct the correct sequence of Python assignment statements needed to calculate the factorial.'\n";
			def += "}";
			
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				testsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
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

			def += "Module {\n";
			def += "\t>Add: 'operator +'\n";
			def += "\t>Sub: 'operator -'\n";
			def += "\t>Mult: 'operator *'\n";
			def += "\t>Div: 'operator /'\n";
			def += "\t>ModOp: 'operator %'\n";
			def += "\t>Gt: 'operator >'\n";
			def += "\t>GtE: 'operator >='\n";
			def += "\t>Lt: 'operator <'\n";
			def += "\t>LtE: 'operator <='\n";
			def += "\t>Eq: 'operator =='\n";
			def += "\t>NotEq: 'operator !='\n";
			def += "\t>USub: 'unary operator -'\n";
			def += "\t>UAdd: 'unary operator +'\n";
			def += "\t>Not: 'operator !'\n";
			def += "\t>Return: 'return'\n";
			def += "\t>Constant: %value\n";
			def += "\t>Name: %id\n";
			def += "\t>FunctionDef: 'def'\n";
			def += "\t>Assign: '='\n";
			def += "\t>Stmt: \"statement\"\n";
			def += "}\n";
			
			
			if (idelemsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				idelemsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
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
			def += "\tChange %toObject to %object\n\n";

			def += ">InformationChanged: Change %oldValue to %newValue /\n";
			def += "\tChange %newValue to %oldValue\n\n";

			def += ">AttributeChanged: Change %oldValue to %newValue /\n";
			def += "\tChange %newValue to %oldValue\n\n";

			def += ">ObjectCreated: Create %object /\n";
			def += "\tCreate %object\n\n";

			def += ">ObjectRemoved: Delete %object from %fromObject /\n";
			def += "\tDelete %object from %fromObject\n";
			
			if (cfgoptsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				cfgoptsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
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
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += "\nWodel-Edu: Environment for the automated generation and evaluation of exercises";
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
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
		final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
			srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "content";
			final File src = new Path(srcName).toFile();
			final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
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
		final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
			srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "mobile";
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
		final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
			srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "ios";
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
			File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib/") && !entry.getName().contains("/modelValidatorPlugin/x86/")) {
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
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
			jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
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
			final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic";
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
			final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik";
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
			final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik/extensions";
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
			final File jarFile = new File(WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = WodelEduPythonWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "dpic/batik/lib";
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
