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
 * @author Pablo Gomez-Abajo - Wodel new Chatbots example project Wizard.
 * 
 * Wodel new Chatbots example project Wizard.
 *  
 */

public class ChatbotsWizard  extends Wizard implements INewWizard {
	private ISelection selection;

	public ChatbotsWizardPage _pageOne;

	private static final String WIZARD_NAME = "Chatbots Example";

	public ChatbotsWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new ChatbotsWizardPage(selection);
		_pageOne.setTitle("Wodel Chatbots Example");
		_pageOne.setDescription("Create a Wodel Chatbots Example");
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
			final File jarFile = new File(ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/conga")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/conga", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/conga", ""));
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
				srcName = ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/conga";
				final File src = new Path(srcName).toFile();
				final File dest = modelFolder.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
				for (File f: src.listFiles()) {
					if (f.getName().endsWith(".ecore")) {
						srcMetamodel = f.getPath();
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
			def += "{annotation=\"" + modelName + "/Annotation\" metamodel=\"/" + projectName + "/" + modelName + "/Annotation.ecore\"}\n\n";
			def += "with blocks {\n";
			def += "\tdp_max \"Delete training phrase (max similarity)\" {\n";
			def += "\t\ttpi = select one IntentValue from annotation resources\n";
			def += "\t\ti = select one Intent where {self = tpi->intent}\n";
			def += "\t\tli = select one LanguageIntent in i->inputs\n";
			def += "\t\tremove one TrainingPhrase from li->inputs where {self = tpi->max1}\n";
			def += "\t}\n";
			def += "\tdp_min \"Delete training phrase (min similarity)\" {\n";
			def += "\t\ttpi = select one IntentValue from annotation resources\n";
			def += "\t\ti = select one Intent where {self = tpi->intent}\n";
			def += "\t\tli = select one LanguageIntent in i->inputs\n";
			def += "\t\tremove one TrainingPhrase from li->inputs where {self = tpi->min1}\n";
			def += "\t}\n";
			def += "\tdpwp \"Delete training phrases with required parameter\" {\n";
			def += "\t\tp = select one Parameter where {required = true}\n";
			def += "\t\tremove all TrainingPhrase where {tokens->parameter = p}\n";
			def += "\t\tremove all LanguageIntent where {inputs = null}\n";
			def += "\t}\n";
			def += "\tdpwl \"Delete training phrases with literal\" {\n";
			def += "\t\tinput = select one SimpleInput\n";
			def += "\t\tprt = select one ParameterReferenceToken where {textReference = input.values}\n";
			def += "\t\tremove all TrainingPhrase where {tokens = prt}\n";
			def += "\t}\n";
			def += "\tk2p_max \"Keep two training phrases (max similarity)\" {\n";
			def += "\t\ttpi = select one IntentValue from annotation resources\n";
			def += "\t\ti = select one Intent where {self = tpi->intent}\n";
			def += "\t\tli = select one LanguageIntent in i->inputs\n";
			def += "\t\ttp0 = select one TrainingPhrase in li->inputs where {self = tpi->max1}\n";
			def += "\t\ttp1 = select one TrainingPhrase in li->inputs where {self = tpi->max2 and self <> tp0}\n";
			def += "\t\ttp2 = select one TrainingPhrase in li->inputs where {self <> tp0 and self <> tp1}\n";
			def += "\t\tremove all TrainingPhrase from li->inputs where {self <> tp0 and self <> tp1}\n";
			def += "\t}\n";
			def += "\tk2p_min \"Keep two training phrases (min similarity)\" {\n";
			def += "\t\ttpi = select one IntentValue from annotation resources\n";
			def += "\t\ti = select one Intent where {self = tpi->intent}\n";
			def += "\t\tli = select one LanguageIntent in i->inputs\n";
			def += "\t\ttp0 = select one TrainingPhrase in li->inputs where {self = tpi->min1}\n";
			def += "\t\ttp1 = select one TrainingPhrase in li->inputs where {self = tpi->min2 and self <> tp0}\n";
			def += "\t\ttp2 = select one TrainingPhrase in li->inputs where {self <> tp0 and self <> tp1}\n";
			def += "\t\tremove all TrainingPhrase from li->inputs where {self <> tp0 and self <> tp1}\n";
			def += "\t}\n";
			def += "\tmp_max \"Move training phrase (max similarity)\" {\n";
			def += "\t\ti1 = select one Intent where {inputs <> null}\n";
			def += "\t\tiiv = select one IntentIntentValue from annotation resources where {intent1 = i1 and max1Value = max(max1Value)}\n";
			def += "\t\ti2 = select one Intent where {inputs <> null and self = iiv->intent2}\n";
			def += "\t\tli1 = select one LanguageIntent in i1->inputs where {inputs <> null}\n";
			def += "\t\tli2 = select one LanguageIntent in i2->inputs where {self <> li1 and inputs <> null}\n";
			def += "\t\ttp1 = select one TrainingPhrase in li1->inputs where {self = iiv->max1}\n";
			def += "\t\ttp2 = select one TrainingPhrase in li1->inputs where {self <> tp1}\n";
			def += "\t\tmodify li2 with {inputs += tp1}\n";
			def += "\t}\n";
			def += "\tmp_min \"Move training phrase (min similarity)\" {\n";
			def += "\t\ti1 = select one Intent where {inputs <> null}\n";
			def += "\t\tiiv = select one IntentIntentValue from annotation resources where {intent1 = i1 and min1Value = min(min1Value)}\n";
			def += "\t\ti2 = select one Intent where {inputs <> null and self = iiv->intent2}\n";
			def += "\t\tli1 = select one LanguageIntent in i1->inputs where {inputs <> null}\n";
			def += "\t\tli2 = select one LanguageIntent in i2->inputs where {self <> li1 and inputs <> null}\n";
			def += "\t\ttp1 = select one TrainingPhrase in li1->inputs where {self = iiv->min1}\n";
			def += "\t\ttp2 = select one TrainingPhrase in li1->inputs where {self <> tp1}\n";
			def += "\t\tmodify li2 with {inputs += tp1}\n";
			def += "\t}\n";
			def += "\tdip \"Delete intent parameter\" {\n";
			def += "\t\tp = select one Parameter\n";
			def += "\t\tremove all TrainingPhrase where {tokens->parameter = p}\n";
			def += "\t\tremove all ParameterToken where {parameter = p}\n";
			def += "\t\tremove p\n";
			def += "\t\tremove all LanguageIntent where {inputs = null}\n";
			def += "\t}\n";
			def += "\tdpp \"Delete parameter prompt\" {\n";
			def += "\t\tp0 = select one Parameter where {required = true}\n";
			def += "\t\tremove one LanguagePrompt from p0->prompts\n";
			def += "\t}\n";
			def += "\tspo \"Set required parameter to optional\" {\n";
			def += "\t\tmodify one Parameter where {required = true} with {required = false}\n";
			def += "\t}\n";
			def += "\tcre \"Change regular expression\" {\n";
			def += "\t\tmodify one RegexInput with {expresion = catstart('[^'), expresion = catend(']')}\n";
			def += "\t}\n";
			def += "\tdle \"Delete literal from entity\" {\n";
			def += "\t\tremove one SimpleInput\n";
			def += "\t}\n";
			def += "\tdfi \"Delete fallback intent\" {\n";
			def += "\t\ti = select one Intent where {fallbackIntent = true}\n";
			def += "\t\tremove all UserInteraction where {intent = i}\n";
			def += "\t\tremove i\n";
			def += "\t}\n";
			def += "\tda \"Delete actions\" {\n";
			def += "\t\tbi0 = select one BotInteraction where {actions <> null}\n";
			def += "\t\tremove one Action from bi0->actions\n";
			def += "\t}\n";
			def += "\tdpr \"Delete a parameter used in a response\" {\n";
			def += "\t\ttext = select one TextInput where {tokens is typed ParameterToken}\n";
			def += "\t\tremove one ParameterToken from text->tokens\n";
			def += "\t}\n";
			def += "\tso \"Swap outputs\" {\n";
			def += "\t\tbi1 = select one BotInteraction where {actions <> null and outcoming->^target <> null}\n";
			def += "\t\tui1 = select one UserInteraction in bi1->outcoming where {^target <> null}\n";
			def += "\t\tbi2 = select one BotInteraction in ui1->^target where {self <> bi1 and actions <> null and actions <> bi1->actions}\n";
			def += "\t\tmodify bi1 with {swapref(actions, bi2->actions)}\n";
			def += "\t}\n";
			def += "\tdcs \"Delete conversation step\" {\n";
			def += "\t\tui0 = select one UserInteraction where {^target->outcoming->^target is typed BotInteraction}\n";
			def += "\t\tbi0 = select one BotInteraction in ui0->^target->outcoming->^target\n";
			def += "\t\tmodify target ^target from ui0 to bi0\n";
			def += "\t}\n";
			def += "\tdcb \"Delete conversation bifurcation\" {\n";
			def += "\t\tbi = select one BotInteraction where {outcoming <> null}\n";
			def += "\t\tui = select one UserInteraction in bi->outcoming\n";
			def += "\t\tremove one UserInteraction from bi->outcoming where {self <> ui}\n";
			def += "\t}\n";
			def += "}\n";
			def += "//\tso_max \"Swap outputs by intent similarity (max) \" {\n";
			def += "//\t\tui1 = select one UserInteraction where {^target <> null}\n";
			def += "//\t\ti1 = select one Intent in ui1->intent where {inputs <> null}\n";
			def += "//\t\tiiv = select one IntentIntentValue from annotation resources where {intent1 = i1 and max1Value = max(max1Value)}\n";
			def += "//\t\tui2 = select one UserInteraction where {self <> ui1}\n";
			def += "//\t\ti2 = select one Intent in ui2->intent where {inputs <> null and self = iiv->intent2}\n";
			def += "//\t\tbi1 = select one BotInteraction in ui1->^target where {actions <> null}\n";
			def += "//\t\tbi2 = select one BotInteraction in ui2->^target where {self <> bi1 and actions <> null and actions <> bi1->actions}\n";
			def += "//\t\tmodify bi1 with {swapref(actions, bi2->actions)}\n";
			def += "//\t}\n";
			def += "//\tso_min \"Swap outputs by intent similarity (min) \" {\n";
			def += "//\t\tui1 = select one UserInteraction where {^target <> null}\n";
			def += "//\t\ti1 = select one Intent in ui1->intent where {inputs <> null}\n";
			def += "//\t\tiiv = select one IntentIntentValue from annotation resources where {intent1 = i1 and min1Value = min(min1Value)}\n";
			def += "//\t\tui2 = select one UserInteraction where {self <> ui1}\n";
			def += "//\t\ti2 = select one Intent in ui2->intent where {inputs <> null and self = iiv->intent2}\n";
			def += "//\t\tbi1 = select one BotInteraction in ui1->^target where {actions <> null}\n";
			def += "//\t\tbi2 = select one BotInteraction in ui2->^target where {self <> bi1 and actions <> null and actions <> bi1->actions}\n";
			def += "//\t\tmodify bi1 with {swapref(actions, bi2->actions)}\n";
			def += "//\t}\n";
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
			File jarFile = new File(ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
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
			jarFile = new File(ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
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
				srcName = ChatbotsWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
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
