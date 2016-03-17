package runwodel.popup.actions;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import manager.ModelManager;
import mutextension.generator.IGenerator;
import mutpostprocessor.run.IPostprocessor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class RunWodel implements IObjectActionDelegate {

	private Shell shell;
	private IFile file;

	/**
	 * Constructor for Action1.
	 */
	public RunWodel() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		System.out.println("file=" + file);
		Class<?> cls = null;
		String fileName = file.getName();
		String classname = fileName.replaceAll(".mutator", "");

		try {
			cls = Class.forName(classname);
		} catch (ClassNotFoundException e) {
		}

		if (cls == null) {
			try {
				IProject project = file.getProject();
				if (project.hasNature(JavaCore.NATURE_ID)) {
					IJavaProject javaProject = JavaCore.create(project);
					// read class path entries of the project
					String[] classPathEntries = JavaRuntime
							.computeDefaultRuntimeClassPath(javaProject);
					List<URL> urlList = new ArrayList<URL>();
					for (String classPathEntry : classPathEntries) {
						Path path = new Path(classPathEntry);
						urlList.add(path.toFile().toURI().toURL());
					}
					// create url class loader whose parent is the class loader
					// of the project
					// and containing the class path entries of the project
					ClassLoader parentClassLoader = project.getClass()
							.getClassLoader();
					URL[] urls = (URL[]) urlList
							.toArray(new URL[urlList.size()]);
					URLClassLoader classLoader = new URLClassLoader(urls,
							parentClassLoader);
					// load class
					cls = classLoader.loadClass(classname);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int maxAttempts = 10;
		boolean registry = false;
		Object ob = null;
		try {
			ob = cls.newInstance();
			Method m = cls.getMethod("execute", new Class[]{int.class, boolean.class});
			maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("org.mutator.Mutator", "Number of attempts", "0", null));
			registry = Platform.getPreferencesService().getBoolean("org.mutator.Mutator", "Generate registry", false, null);
			m.invoke(ob, maxAttempts, registry);
			// ime = (IMutatorExecutor)ob;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String metamodelpath = ModelManager.getMetaModelPath();
			String metamodel = ModelManager.getMetaModel();
			HashMap<Resource, String> hashmap_postproc = new HashMap<Resource, String>();
			ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			File[] files = null;
			List<String> modelpaths = ModelManager.getModels();
			File[] sourcefiles = new File(metamodelpath).listFiles();
			for (File file : sourcefiles) {
				if (file.isFile() == true) {
					String pathfile = file.getPath();
					if (pathfile.endsWith(".model") == true) {
						Resource modelfile = ModelManager.loadModel(packages, pathfile);
						String targetfile = new File(ModelManager.getOutputPath() + "/" + pathfile.substring(pathfile.lastIndexOf("\\") + 1, pathfile.length() - ".model".length()) + "/" + pathfile.substring(pathfile.lastIndexOf("\\") + 1)).getPath();
						hashmap_postproc.put(modelfile, targetfile);
					}
				}
			}
			for (String ecoreURI : modelpaths) {
				System.out.println("FOLDER: " + ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf("\\") + 1, ecoreURI.length() - ".model".length()));
				files = new File(ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf("\\") + 1, ecoreURI.length() - ".model".length())).listFiles();
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						if (files[i].isFile() == true) {
							String pathfile = files[i].getPath();
							if (pathfile.endsWith(".model") == true) {
								Resource modelfile = ModelManager.loadModel(packages,
										pathfile);
								hashmap_postproc.put(modelfile, pathfile);
							}
						}
					}
				}
			}
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"MutPostprocessor.postprocessor");
				for (int j = 0; j < extensions.length; j++) {
					IPostprocessor src = null;
					try {
						src = (IPostprocessor) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (Platform.getPreferencesService().getBoolean(
							"org.mutator.Mutator", src.getName(), false, null) == true) {
						Set<Resource> resources = hashmap_postproc.keySet();
						for (Resource r : resources) {
							File f = new File(hashmap_postproc.get(r));
							if(!f.isDirectory()) { 
								src.doProcess(r, hashmap_postproc.get(r));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"MutExtension.extension");
			for (int j = 0; j < extensions.length; j++) {
				try {
					final IGenerator src = (IGenerator) extensions[j]
							.createExecutableExtension("class");
					HashSet<String> wodelExtensions = ModelManager.getExtensions();
					if (wodelExtensions.contains(src.getName())) {
						src.doRun(file);
					}
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		file = (IFile) ((IStructuredSelection) selection).getFirstElement();
	}

}
