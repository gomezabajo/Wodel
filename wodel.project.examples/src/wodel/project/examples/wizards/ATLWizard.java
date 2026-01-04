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
 * @author Pablo Gomez-Abajo - Wodel new ATL Atlas Transformation Language example project Wizard.
 * 
 * Wodel new ATL Atlas Transformation Language example project Wizard.
 *  
 */

public class ATLWizard extends Wizard implements INewWizard {
	private ISelection selection;

	public ATLWizardPage _pageOne;

	private static final String WIZARD_NAME = "ATL Atlas Transformation Language Example";

	public ATLWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new ATLWizardPage(selection);
		_pageOne.setTitle("ATL Atlas Transformation Language Example");
		_pageOne.setDescription("Create a Wodel ATL Atlas Transformation Language Example");
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
			final File jarFile = new File(ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/atl")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/atl", ""));
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
				srcName = ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/atl";
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
			def += "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n";
			def += "with resources from\n";
			def += "{input=\"" + modelName + "/in\" metamodel=\"/" + projectName + "/" + modelName + "/MyEcore.ecore\"},\n";
			def += "{output=\"" + modelName + "/out\" metamodel=\"/" + projectName + "/" + modelName + "/MyEcore.ecore\"}\n";
			def += "\n";
			def += "with blocks {\n";
			def += "\tcb \"Create binding\" {\n";
			def += "\t\tsope = select one SimpleOutPatternElement\n";
			def += "\t\ttype = select one OclModelElement in sope->type\n";
			def += "\t\tcl = select one EClass from output resources where {name = type.name}\n";
			def += "\t\tatt = select one EAttribute in cl->eAllAttributes\n";
			def += "\t\tb = create Binding in sope->bindings with {isAssignment = false, copy(propertyName, att.name)}\n";
			def += "\t\tcreate StringExp in b->value with {stringSymbol = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "\trb \"Remove binding\" {\n";
			def += "\t\tremove one Binding\n";
			def += "\t} \n";
			def += "\tvcb \"Value change binding\" {\n";
			def += "\t\tb = select one Binding where {value is typed OperatorCallExp}\n";
			def += "\t\tcreate StringExp in b->value with {stringSymbol = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "\tfc \"Feature change binding\" {\n";
			def += "\t\tsope = select one SimpleOutPatternElement\n";
			def += "\t\ttype = select one OclModelElement in sope->type\n";
			def += "\t\tcl = select one EClass from output resources where {name = type.name}\n";
			def += "\t\tb = select one Binding in sope->bindings\n";
			def += "\t\tatt = select one EAttribute in cl->eAllAttributes where {name <> b.propertyName}\n";
			def += "\t\tmodify b with {copy(propertyName, att.name)}\n";
			def += "\t}\n";
			def += "\tcf \"Create filter\" {\n";
			def += "\t\tp = select one InPattern where {filter is typed OperatorCallExp}\n";
			def += "\t\topce = select one OperatorCallExp in p->filter\n";
			def += "\t\tfeat = select one OclFeature\n";
			def += "\t\tsipe = select one SimpleInPatternElement in p->elements\n";
			def += "\t\tconj = create OperatorCallExp with {operationName = \"and\"}\n";
			def += "\t\tcall = create OperationCallExp in conj->^source with {copy(operationName, feat.name)}\n";
			def += "\t\texp = create VariableExp in call->^source\n";
			def += "\t\tmodify sipe with {variableExp += exp}\n";
			def += "\t\tmodify conj with {arguments += opce}\n";
			def += "\t\tmodify p with {filter += conj}\n";
			def += "\t}\n";
			def += "\trf \"Remove filter\" {\n";
			def += "\t\tremove one OclExpression where {container is typed InPattern}\n";
			def += "\t}\n";
			def += "\tccf \"Condition change filter\" {\n";
			def += "\t\tp = select all InPattern where {filter <> null}\n";
			def += "\t\topce = select one OperationCallExp in p->filter where {operationName <> ['not', 'and', 'or']}\n";
			def += "\t\tfeat = select one OclFeature where {name <> opce.operationName}\n";
			def += "\t\tmodify opce with {copy(operationName, feat.name)}\n";
			def += "\t}\n";
			def += "\tcipe \"In pattern addition\" {\n";
			def += "\t\tcl = select one EClass from input resources\n";
			def += "\t\tp = select one InPattern\n";
			def += "\t\tmod = select one OclModel in p->elements->type->model\n";
			def += "\t\tipe = create SimpleInPatternElement in p->elements\n";
			def += "\t\t\twith {varName = random-string(2, 4)}\n";
			def += "\t\telem = create OclModelElement in ipe->type\n";
			def += "\t\t\twith {copy(name, cl.name), variableDeclaration = ipe}\n";
			def += "\t\tmodify mod with {elements += elem}\n";
			def += "\t}\n";
			def += "\tripe \"Remove in pattern\" {\n";
			def += "\t\tremove one InPatternElement\n";
			def += "\t}\n";
			def += "\tccipe \"Class change in pattern\" {\n";
			def += "\t\tsipe = select one SimpleInPatternElement\n";
			def += "\t\ttype = select one OclModelElement in sipe->type\n";
			def += "\t\tcl = select one EClass from input resources where {name <> type.name}\n";
			def += "\t\tmodify type with {copy(name, cl.name)}\n";
			def += "\t}\n";
			def += "\tncipe \"Name change in pattern\" {\n";
			def += "\t\tmodify one InPatternElement with {varName = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "\tcmr \"Create matched rule\" {\n";
			def += "\t\tdeep clone one MatchedRule with {name = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "//\tcmr \"Create matched rule\" {\n";
			def += "//\t\tmain = select one Module\n";
			def += "//\t\tim = select one OclModel where {name = 'IN'}\n";
			def += "//\t\timod = select one OclModel in im->^metamodel\n";
			def += "//\t\tincl = select one EClass from input resources\n";
			def += "//\t\tmr = create MatchedRule in main->elements with {name = random-string(4, 6)}\n";
			def += "//\t\tip = create InPattern in mr->inPattern\n";
			def += "//\t\tsipe = create SimpleInPatternElement in ip->elements with {varName = random-string(2, 4)}\n";
			def += "//\t\tielem = create OclModelElement in imod->elements with {copy(name, incl.name), variableDeclaration = sipe}\n";
			def += "//\t\tmodify imod with {elements += ielem}\n";
			def += "//\t\tfeat = select one OclFeature\n";
			def += "//\t\topce = create OperationCallExp in ip->filter with {copy(operationName, feat.name)}\n";
			def += "//\t\texp = create VariableExp in opce->^source\n";
			def += "//\t\tmodify sipe with {variableExp += exp}\n";
			def += "//\t\tom = select one OclModel where {name = 'OUT'}\n";
			def += "//\t\tomod = select one OclModel in om->^metamodel\n";
			def += "//\t\toutcl = select one EClass from output resources\n";
			def += "//\t\top = create OutPattern in mr->outPattern\n";
			def += "//\t\tsope = create SimpleOutPatternElement in op->elements with {varName = random-string(2, 4)}\n";
			def += "//\t\toelem = create OclModelElement in omod->elements with {copy(name, outcl.name), variableDeclaration = sope}\n";
			def += "//\t\tmodify sope with {type = oelem}\n";
			def += "//\t\tatt = select one EAttribute in outcl->eAllAttributes\n";
			def += "//\t\tb = create Binding in sope->bindings with {isAssignment = false, copy(propertyName, att.name)}\n";
			def += "//\t\tcreate StringExp in b->value with {stringSymbol = random-string(4, 6)}\n";
			def += "//\t}\n";
			def += "\trmr \"Remove matched rule\" {\n";
			def += "\t\tremove one MatchedRule\n";
			def += "\t}\n";
			def += "\tncmr \"Name change matched rule\" {\n";
			def += "\t\tmodify one MatchedRule with {name = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "\tcope \"Create out pattern\" {\n";
			def += "\t\tcl = select one EClass from output resources\n";
			def += "\t\tp = select one OutPattern\n";
			def += "\t\tmod = select one OclModel in p->elements->type->model\n";
			def += "\t\tope = create SimpleOutPatternElement in p->elements\n";
			def += "\t\t\twith {varName = random-string(2, 4)}\n";
			def += "\t\telem = create OclModelElement in ope->type\n";
			def += "\t\t\twith {copy(name, cl.name), variableDeclaration = ope}\n";
			def += "\t\tmodify mod with {elements += elem}\n";
			def += "\t}\n";
			def += "\trope \"Remove out pattern\" {\n";
			def += "\t\tremove one OutPatternElement\n";
			def += "\t}\n";
			def += "\tccope \"Class change out pattern\" {\n";
			def += "\t\tp = select one OutPattern\n";
			def += "\t\ttype = select one OclModelElement in p->elements->type\n";
			def += "\t\tcl = select one EClass from output resources where {name <> type.name}\n";
			def += "\t\tmodify type with {copy(name, cl.name)}\n";
			def += "\t}\n";
			def += "\tncope \"Name change out pattern\" {\n";
			def += "\t\tmodify one OutPatternElement with {varName = random-string(4, 6)}\n";
			def += "\t}\n";
			def += "}";
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
			File jarFile = new File(ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
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
			jarFile = new File(ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = ATLWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
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
