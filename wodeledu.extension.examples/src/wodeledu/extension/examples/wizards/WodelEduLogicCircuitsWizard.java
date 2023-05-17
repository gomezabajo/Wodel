package wodeledu.extension.examples.wizards;

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

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodel.dsls.WodelUtils;
import wodeledu.dsls.ModelTextUtils;
import wodeledu.dsls.MutaTextUtils;
import wodeledu.extension.examples.utils.EclipseHelper;

/**
 * @author Pablo Gomez-Abajo - Wodel new Wodel-Edu for logic circuits example project Wizard.
 * 
 * Wodel new Wodel-Edu for logic circuits example project Wizard.
 *  
 */

public class WodelEduLogicCircuitsWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public WodelEduLogicCircuitsWizardPage _pageOne;

	private static final String WIZARD_NAME = "Wodel-Edu Logic Circuits Example";

	public WodelEduLogicCircuitsWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new WodelEduLogicCircuitsWizardPage(selection);
		_pageOne.setTitle("Wodel-Edu Logic Circuits Example");
		_pageOne.setDescription("Create a Wodel-Edu Logic Circuits Example");
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
			final File jarFile = new File(WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/wodeledulc")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/wodeledulc", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/wodeledulc", ""));
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
				srcName = WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/wodeledulc";
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
			String def = "generate exhaustive mutants\n"
					+ "in \"" + mutantName + "/\"\n"
					+ "from \"" + modelName + "/\"\n";
			def += "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += "with blocks {\n";
			def += "\tmtg1 {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t} [1]\n";
			def += "\tmtg2 from mtg1 repeat=no {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t} [3]\n";
			def += "\tmtg3 from mtg1 repeat=no {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t} [3]\n";
			def += "\tmtg4 from mtg1 repeat=no {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t} [3]\n";
			def += "\tmtgs1 {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t} [4]\n";
			def += "\tmtgs2 {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t}\n";
			def += "\tmtgs3 {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t}\n";
			def += "\tmtgs4 {\n";
			def += "\t\tretype one [AND, OR] as [AND, OR]\n";
			def += "\t}\n";
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
			
			def += "LogicCircuit: diagram {\n";
			def += "\tGate: node shape=logic\n"
				+ "\tInputPin(src == null): node shape=circle\n"
				+ "\tOutputPin(tar == null): node shape=circle\n"
				+ "\tInputPin(src == null) -> Gate: edge tar_decoration=none\n"
				+ "\tGate -> OutputPin(tar == null): edge tar_decoration=none\n"
				+ "\tGate(output->tar) -> Gate: edge tar_decoration=none\n"
			+ "}";
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
			String def = "navigation=free\n"
					+ "AlternativeTextResponse mtg1 {\n"
					+ "\tretry=yes, text='bool-exp'\n"
					+ "\tdescription for 'lc1.model' = 'Does this logic circuit correspond to the below boolean expression?'\n"
					+ "\tdescription for 'lc2.model' = 'Does this logic circuit correspond to the below boolean expression?'\n"
					+ "}\n"
					+ "MultiChoiceDiagram mtg1 {\n"
					+ "\tretry=no\n"
					+ "\tdescription for 'lc3.model' = 'Select which of the following logic circuits corresponds to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(c&#8743;&#172;d)'\n"
					+ "\tdescription for 'lc4.model' = 'Select which of the following logic circuits corresponds to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(&#172;(&#172;c&#8743;d))'\n"
					+ "}\n"
					+ "MultiChoiceText mtg1 {\n"
					+ "\tretry=no, text='bool-exp'\n"
					+ "\tdescription for 'lc5.model' = 'Select which of the following boolean expressions corresponds to this logic circuit'\n"
					+ "\tdescription for 'lc6.model' = 'Select which of the following boolean expressions corresponds to this logic circuit'\n"
					+ "}\n"
					+ "MultiChoiceEmendation mtg1 {\n"
					+ "\tretry=no, weighted=no, penalty=0.0,\n"
					+ "\torder=options-descending, mode=checkbox\n"
					+ "\tdescription for 'lc3.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(c&#8743;&#172;d)'\n"
					+ "\tdescription for 'lc4.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(&#172;(&#172;c&#8743;d))'\n"
					+ "}\n"
					+ "MissingWords mtg1 {\n"
					+ "\tretry=no\n"
					+ "\tdescription for 'lc4.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(&#172;(&#172;c&#8743;d))'\n"
					+ "\tdescription for 'lc6.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (a&#8743;&#172;b)&#8744;&#172;c'\n"
					+ "}\n"
					+ "DragAndDropText mtg1 {\n"
					+ "\tretry=no\n"
					+ "\tdescription for 'lc3.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(c&#8743;&#172;d)'\n"
					+ "\tdescription for 'lc4.model' = 'Which changes shall be applied to this logic circuit to correspond to the boolean expression f = (&#172;a&#8744;&#172;b)&#8744;(&#172;(&#172;c&#8743;d))'\n"
					+ "}\n"
					+ "MatchPairs mtgs1, mtgs2, mtgs3 {\n"
					+ "\tretry=no, text='bool-exp'\n"
					+ "\tdescription for 'lc2.model' = 'Match the correct option on the right that modifies the below logic circuit to correspond with each of the boolean expressions on the left'\n"
					+ "\tdescription for 'lc4.model' = 'Match the correct option on the right that modifies the below logic circuit to correspond with each of the boolean expressions on the left'\n"
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
			def += ">Gate: %type gate\n";
			def += ">Gate(input->src == null): input\n";
			def += ">Gate(output->tar == null): output\n";
			def += ">InputPin: input pin %name\n";
			def += ">OutputPin: output pin %name\n";
			def += ">InputPin.src: source\n";
			def += ">OutputPin.tar: target\n";
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
		xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + project.getFolder(new Path("/src/" + idelemsFileName)).getFullPath();
		xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + project.getFolder(new Path('/' + mutantName + '/' + idelemsFileName.replaceAll(".modeltext", "_modeltext.model"))).getFullPath();
		ModelTextUtils.serialize(xTextFileName, xmiFileName);

		final IFile cfgoptsFile = srcFolder.getFile(new Path(cfgoptsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += ">ObjectRetyped: Change %object to %toObject /\n";
			def += "\tChange %toObject to %object\n";
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
		
		xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + project.getFolder(new Path("/src/" + cfgoptsFileName)).getFullPath();
		xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + project.getFolder(new Path('/' + mutantName + '/' + cfgoptsFileName.replaceAll(".mutatext", "_mutatext.model"))).getFullPath();
		MutaTextUtils.serialize(xTextFileName, xmiFileName);
		
		final IFile configFile = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = configFile.getContents();
			if (configFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += "\nWodel-Edu: Generation of a web environment with test exercises for education";
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
		final File jarFile = new File(WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("content")) {
		    			final String name = entry.getName();
		    			final File f = htmlFolder.getRawLocation().makeAbsolute().toFile();
		    			File path = new File(f.getPath() + '/' + entry.getName().replace("content/", "").split("/")[0]);
		    			if (!path.exists()) {
		    				path.mkdir();
		    			}
		    			File dest = new File(f.getPath() + '/' + entry.getName().replace("content/", ""));
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
			srcName = WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "content";
			final File src = new Path(srcName).toFile();
			final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}

//		final IFolder configurationsFolder = project.getFolder(new Path("data/configurations"));
//		try {
//			configurationsFolder.create(true, true, monitor);
//		} catch (CoreException e) {
//		}
//		try {
//		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
//		//URL fileURL = bundle.getEntry("content");
//		final File jarFile = new File(WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//		String srcName = "";
//		if (jarFile.isFile()) {
//			final JarFile jar = new JarFile(jarFile);
//			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
//		    while(entries.hasMoreElements()) {
//		    	JarEntry entry = entries.nextElement();
//		    	if (! entry.isDirectory()) {
//		    		if (entry.getName().startsWith("configurations")) {
//		    			final String name = entry.getName();
//		    			final File f = configurationsFolder.getRawLocation().makeAbsolute().toFile();
//		    			File path = new File(f.getPath() + '/' + entry.getName().replace("configurations/", "").split("/")[0]);
//		    			if (!path.exists()) {
//		    				path.mkdir();
//		    			}
//		    			File dest = new File(f.getPath() + '/' + entry.getName().replace("configurations/", ""));
//		    			InputStream input = jar.getInputStream(entry);
//		    			FileOutputStream output = new FileOutputStream(dest);
//		    			while (input.available() > 0) {
//		    				output.write(input.read());
//		    			}
//		    			output.close();
//		    			input.close();
//		    		}
//	    		}
//		    }
//		    jar.close();
//		}
//		else {
//			srcName = WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "configurations";
//			
//			final File src = new Path(srcName).toFile();
//			final File dest = configurationsFolder.getRawLocation().makeAbsolute().toFile();
//			if ((src != null) && (dest != null)) {
//				IOUtils.copyFolder(src, dest);
//			}
//		}
//		} catch (IOException e) {
//		}
//		
//		final IFolder initialFolder = project.getFolder(new Path("data/initial"));
//		try {
//			initialFolder.create(true, true, monitor);
//		} catch (CoreException e) {
//		}
//		try {
//		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
//		//URL fileURL = bundle.getEntry("content");
//		final File jarFile = new File(WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//		String srcName = "";
//		if (jarFile.isFile()) {
//			final JarFile jar = new JarFile(jarFile);
//			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
//		    while(entries.hasMoreElements()) {
//		    	JarEntry entry = entries.nextElement();
//		    	if (! entry.isDirectory()) {
//		    		if (entry.getName().startsWith("initial")) {
//		    			final String name = entry.getName();
//		    			final File f = initialFolder.getRawLocation().makeAbsolute().toFile();
//		    			File path = new File(f.getPath() + '/' + entry.getName().replace("initial/", "").split("/")[0]);
//		    			if (!path.exists()) {
//		    				path.mkdir();
//		    			}
//		    			File dest = new File(f.getPath() + '/' + entry.getName().replace("initial/", ""));
//		    			InputStream input = jar.getInputStream(entry);
//		    			FileOutputStream output = new FileOutputStream(dest);
//		    			while (input.available() > 0) {
//		    				output.write(input.read());
//		    			}
//		    			output.close();
//		    			input.close();
//		    		}
//	    		}
//		    }
//		    jar.close();
//		}
//		else {
//			srcName = WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "initial";
//			final File src = new Path(srcName).toFile();
//			final File dest = initialFolder.getRawLocation().makeAbsolute().toFile();
//			if ((src != null) && (dest != null)) {
//				IOUtils.copyFolder(src, dest);
//			}
//		}
//		} catch (IOException e) {
//			
//		}

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
		
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("mobile")) {
		    			final File f = mobileFolder.getRawLocation().makeAbsolute().toFile();
		    			File path = new File(f.getPath() + '/' + entry.getName().replace("mobile/", "").split("/")[0]);
		    			if (!path.exists()) {
		    				path.mkdir();
		    			}
		    			File dest = new File(f.getPath() + '/' + entry.getName().replace("mobile/", ""));
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
			srcName = WodelEduLogicCircuitsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "mobile";
			final File src = new Path(srcName).toFile();
			final File dest = mobileFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
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
