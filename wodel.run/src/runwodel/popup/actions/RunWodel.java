package runwodel.popup.actions;

import generator.IGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import manager.ModelManager;
import manager.MutatorUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import exceptions.MetaModelNotFoundException;
import registry.run.IRegistryPostprocessor;

/**
 * @author Pablo Gomez-Abajo - Wodel mutations executor
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RunWodel extends AbstractHandler {
	
	private class RunWodelWithProgress implements IRunnableWithProgress {

		private ExecutionEvent event = null;
		public RunWodelWithProgress(ExecutionEvent event) {
			this.event = event;
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			IFile file = null;
			try {
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
			} catch (ExecutionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Class<?> cls = null;
			String mutatorName = file.getProject().getName();
			String classname = "mutator." + mutatorName + "." + mutatorName.replaceAll("[.]", "_") + "Launcher";

			try {
				cls = Class.forName(classname);
			} catch (ClassNotFoundException e) {
			}
			
			IProject project = file.getProject();
			URLClassLoader classLoader = null;
			if (cls == null) {
				try {
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
						classLoader = new URLClassLoader(urls,
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
			String metamodel = ModelManager.getMetaModel();
			String metamodelpath = ModelManager.getMetaModelPath();
			List<EPackage> packages = null;
			try {
				packages = ModelManager.loadMetaModel(metamodel);
			} catch (MetaModelNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				ob = cls.getDeclaredConstructor().newInstance();
				Method m = cls.getMethod("execute", new Class[]{int.class, int.class, boolean.class, boolean.class, boolean.class, String[].class, IProject.class, IProgressMonitor.class, boolean.class, Object.class, TreeMap.class});
				maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "0", null));
				numMutants = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null));
				registry = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", false, null);
				metrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null);
				debugMetrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null);
				m.invoke(ob, maxAttempts, numMutants, registry, metrics, debugMetrics, null, project, monitor, true, null, null);
				// ime = (IMutatorExecutor)ob;
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				File[] files = null;
				HashMap<String, Resource> hashmap_regpostseed = new HashMap<String, Resource>();
				HashMap<String, Resource> hashmap_regpostmutant = new HashMap<String, Resource>();
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
														File check = new File(regfiles[k].getName().replace("Registry", ""));
														if (check.exists()) {
															Resource blockmodelfile = ModelManager.loadModel(packages, ecoreURI);
															hashmap_regpostseed.put(pathfile, blockmodelfile);
															Resource mutant = ModelManager.loadModel(packages, files[i].getPath() + "/" + regfiles[k].getName().replace("Registry", "")); 
															hashmap_regpostmutant.put(pathfile, mutant);
														}
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
				HashMap<Resource, String> hashmap_postproc = new HashMap<Resource, String>();
				File[] files = null;
				List<String> modelpaths = ModelManager.getModels();
				File[] sourcefiles = new File(metamodelpath).listFiles();
				for (File f : sourcefiles) {
					if (f.isFile() == true) {
						String pathfile = f.getPath();
						if (pathfile.endsWith(".model") == true) {
							Resource modelfile = ModelManager.loadModel(packages, pathfile);
							String targetfile = new File(metamodelpath + "/" + pathfile.substring(pathfile.lastIndexOf(File.separator) + 1)).getPath();
							hashmap_postproc.put(modelfile, targetfile);
						}
					}
				}
				for (String ecoreURI : modelpaths) {
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
											MutatorUtils.generatePostprocessingPaths(filesBlock[j], packages, hashmap_postproc);
										}
									}
								}
							}
						}
					}
				}
				String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants postprocessing extension", "", null);
				if (Platform.getExtensionRegistry() != null) {
					IConfigurationElement[] extensions = Platform
							.getExtensionRegistry().getConfigurationElementsFor(
									"wodel.postprocessor.MutPostprocessor");
					IConfigurationElement appropriateExtension = null;
					for (IConfigurationElement extension : extensions) {
						Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
						Object postprocessing =  extensionClass.getDeclaredConstructor().newInstance();
						Method getURI = extensionClass.getDeclaredMethod("getURI");
						String uri = (String) getURI.invoke(postprocessing);
						Method getName = extensionClass.getDeclaredMethod("getName");
						String name = (String) getName.invoke(postprocessing);
						if (name.equals(extensionName) && uri.equals("")) {
							appropriateExtension = extension;
							break;
						}
						if (name.equals(extensionName) && uri.equals(packages.get(0).getNsURI())) {
							appropriateExtension = extension;
							break;
						}
						if (uri.equals("")) {
							appropriateExtension = extension;
						}
					}
					if (appropriateExtension != null) {
						Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
						Object postprocessing =  extensionClass.getDeclaredConstructor().newInstance();
						Method getName = extensionClass.getDeclaredMethod("getName");
						if (getName.invoke(postprocessing).equals(extensionName) ) {
							Method doProcess = extensionClass.getDeclaredMethod("doProcess", new Class[]{String.class, String.class, Resource.class, String.class});
							Set<Resource> resources = hashmap_postproc.keySet();
							for (Resource r : resources) {
								File f = new File(hashmap_postproc.get(r));
								if(!f.isDirectory()) { 
									doProcess.invoke(postprocessing, metamodelpath, metamodel, r, hashmap_postproc.get(r));
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
			
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException ex) {
				ex.printStackTrace();
			}
			try {
				classLoader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
    	try {
    		RunWodelWithProgress runWodelWithProgress = new RunWodelWithProgress(event);
    		new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, runWodelWithProgress);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
