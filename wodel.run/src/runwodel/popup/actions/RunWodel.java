package runwodel.popup.actions;

import generator.IGenerator;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import manager.ModelManager;
import mutator.MutatorUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import postprocessor.run.IPostprocessor;
import registry.run.IRegistryPostprocessor;

public class RunWodel implements IObjectActionDelegate {

	/**
	 * Constructor for Action1.
	 */
	public RunWodel() {
		super();
	}

	private static class RunWodelWithProgress implements IRunnableWithProgress {
		private Shell shell;
		private static IFile file;


		/**
		 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
		 */
		public void setActivePart(IAction action, IWorkbenchPart targetPart) {
			shell = targetPart.getSite().getShell();
		}

		/**
		 * @see IActionDelegate#run(IAction)
		 */
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException,
		InterruptedException {
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
			int numMutants = 3;
			boolean registry = false;
			boolean metrics = false;
			boolean debugMetrics = false;
			Object ob = null;
			try {
				ob = cls.newInstance();
				Method m = cls.getMethod("execute", new Class[]{int.class, int.class, boolean.class, boolean.class, boolean.class, IProgressMonitor.class});
				maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "0", null));
				numMutants = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null));
				registry = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", false, null);
				metrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate mutant metrics", false, null);
				debugMetrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant metrics", false, null);
				m.invoke(ob, maxAttempts, numMutants, registry, metrics, debugMetrics, monitor);
				// ime = (IMutatorExecutor)ob;
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				File[] files = null;
				HashMap<String, Resource> hashmap_regpostseed = new HashMap<String, Resource>();
				HashMap<String, Resource> hashmap_regpostmutant = new HashMap<String, Resource>();
				String metamodel = ModelManager.getMetaModel();
				ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				List<String> modelpaths = ModelManager.getModels();
				for (String ecoreURI : modelpaths) {
					Resource modelfile = ModelManager.loadModel(packages, ecoreURI);
					files = new File(ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length())).listFiles();
					if (files != null) {
						for (int i = 0; i < files.length; i++) {
							if (files[i].isDirectory() == true) {
								if (files[i].getName().equals("registry") == true) {
									File[] regfiles = files[i].listFiles();
									for (int j = 0; j < regfiles.length; j++) {
										String pathfile = regfiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmap_regpostseed.put(pathfile, modelfile);
											Resource mutant = ModelManager.loadModel(packages, ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length()) + "/" + regfiles[j].getName().replace("Registry", "")); 
											hashmap_regpostmutant.put(pathfile, mutant);
										}
									}
								}
								else {
									File[] regFilesBlock = files[i].listFiles();
									for (int j = 0; j < regFilesBlock.length; j++) {
										if (regFilesBlock[j].isDirectory() == true) {
											if (regFilesBlock[j].getName().equals("registry") == true) {
												File[] regfiles = regFilesBlock[j].listFiles();
												for (int k = 0; k < regfiles.length; k++) {
													String pathfile = regfiles[k].getPath();
													if (pathfile.endsWith(".model") == true) {
														Resource blockmodelfile = ModelManager.loadModel(packages, ecoreURI);
														hashmap_regpostseed.put(pathfile, blockmodelfile);
														System.out.println(files[i].getPath() + "/" + regfiles[k].getName().replace("Registry", ""));
														Resource mutant = ModelManager.loadModel(packages, files[i].getPath() + "/" + regfiles[k].getName().replace("Registry", "")); 
														hashmap_regpostmutant.put(pathfile, mutant);
													}
												}
											}
											else {
												String blockModelFolder = ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length()) + "/" + regFilesBlock[j].getName();
												MutatorUtils.generateRegistryPaths(regFilesBlock[j], packages, hashmap_regpostseed, hashmap_regpostmutant, files[i], blockModelFolder);
											}
										}
									}
								}
							}
						}
					}
				}
				if (Platform.getExtensionRegistry() != null) {
					IConfigurationElement[] extensions = Platform
							.getExtensionRegistry().getConfigurationElementsFor(
									"wodel.registry.MutRegistryPostprocessor");
					for (int j = 0; j < extensions.length; j++) {
						IRegistryPostprocessor src = null;
						try {
							src = (IRegistryPostprocessor) extensions[j]
									.createExecutableExtension("class");
						} catch (CoreException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (Platform.getPreferencesService().getBoolean(
								"wodel.dsls.Wodel", src.getName(), false, null) == true) {
							for (String filename : hashmap_regpostseed.keySet()) {
								src.doProcess(hashmap_regpostseed.get(filename), hashmap_regpostmutant.get(filename), filename);
							}
						}
					}
				}
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
							String targetfile = new File(ModelManager.getOutputPath() + "/" + pathfile.substring(pathfile.lastIndexOf(File.separator) + 1, pathfile.length() - ".model".length()) + "/" + pathfile.substring(pathfile.lastIndexOf(File.separator) + 1)).getPath();
							hashmap_postproc.put(modelfile, targetfile);
						}
					}
				}
				for (String ecoreURI : modelpaths) {
					System.out.println("FOLDER: " + ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length()));
					files = new File(ModelManager.getOutputPath() + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length())).listFiles();
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
							else {
								if (files[i].getName().equals("registry") != true) {
									File[] filesBlock = files[i].listFiles();
									for (int j = 0; j < filesBlock.length; j++) {
										if (filesBlock[j].isFile() == true) {
											String pathfileblock = filesBlock[j].getPath();
											if (pathfileblock.endsWith(".model") == true) {
												Resource modelfileblock = ModelManager.loadModel(packages,  pathfileblock);
												hashmap_postproc.put(modelfileblock, pathfileblock);
											}
										}
										else {
											MutatorUtils.generateJSONPaths(filesBlock[j], packages, hashmap_postproc);
										}
									}
								}
							}
						}
					}
				}
				if (Platform.getExtensionRegistry() != null) {
					IConfigurationElement[] extensions = Platform
							.getExtensionRegistry().getConfigurationElementsFor(
									"wodel.postprocessor.MutPostprocessor");
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
								"wodel.dsls.Wodel", src.getName(), false, null) == true) {
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
								"wodel.extension.MutApplication");
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

		public static void setFile(IFile f) {
			file = f;
		}
	}

	public void run(IAction action) {
		try {
			RunWodelWithProgress runWodelWithProgress = new RunWodelWithProgress();
			new ProgressMonitorDialog(new org.eclipse.swt.widgets.Shell()).run(true, true, runWodelWithProgress);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		RunWodelWithProgress.setFile((IFile) ((IStructuredSelection) selection).getFirstElement());
	}
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}

}
