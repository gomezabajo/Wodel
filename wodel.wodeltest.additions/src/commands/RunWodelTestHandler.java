package commands;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;

import manager.IOUtils;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.MutatorUtils.MutationResults;
import registry.run.IRegistryPostprocessor;
//import test.views.WodelTestClassResultsViewPart;
import test.views.WodelTestGlobalGraphicalResultsViewPart;
//import test.views.WodelTestMutatorResultsViewPart;
//import test.views.WodelTestResultsTestViewPart;
import utils.MutatorHelper;
//import utils.ComboDialog;
import manager.IWodelTest;
import manager.WodelTestClass;
import manager.WodelTestClassInfo;
import manager.WodelTestGlobalResult;
import manager.WodelTestResultClass;
import manager.WodelTestUtils;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import builder.WodelTestProjectNature;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class RunWodelTestHandler extends AbstractHandler {

	private static class RunWodelTestWithProgress implements IRunnableWithProgress {

		private ExecutionEvent event = null;
		public RunWodelTestWithProgress(ExecutionEvent event) {
			this.event = event;
		}

		private void deleteDirectory(File file) {
			File[] contents = file.listFiles();
			if (contents != null) {
				for (File f : contents) {
					deleteDirectory(f);
				}
			}
			file.delete();
		}
		
		/**
		 * @see IActionDelegate#run(IAction)
		 */
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException,
		InterruptedException {

			List<IWodelTest> tests = new ArrayList<IWodelTest>();
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodel.wodeltest.MutTest");
				for (int j = 0; j < extensions.length; j++) {
					IWodelTest test = null;
					try {
						test = (IWodelTest) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tests.add(test);
				}
			}

			try {
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
				IProject sourceProject = (IProject) selection.getFirstElement();
				IWodelTest test = null;
				for (IWodelTest t : tests) {
					if (sourceProject.hasNature(t.getNatureId())) {
						test = t;
						break;
					}
				}
				if (test == null) {
					return;
				}
				String testSuiteName = WodelTestUtils.getTestSuiteName(sourceProject);
				
				MutatorHelper mutatorHelper = new MutatorHelper(test);
				String projectName = sourceProject.getName();
				SimpleEntry<String, Class<?>> mutatorLauncher = mutatorHelper.getLauncher();
				String path = ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getFullPath().toFile().getPath().toString();
				IOUtils.deleteFile(ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getName() + "/data/classes.txt");
				IOUtils.deleteFile(ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getName() + "/data/classes.results.txt");
				long currentTimeMillis = System.currentTimeMillis();
				int numMutatorsSelected = 0;
				int numMutatorsApplied = 0;
				List<String> mutatorsApplied = new ArrayList<String>();
				int numMutantsGenerated = 0;
				int numMutantsNonCompiling = 0;
				String resultsPath = path + "/data/classes.results.txt";
				String testsResultsPath = path + "/data/" + projectName + ".tests.results.txt";
				WodelTestGlobalResult.resetValues(testsResultsPath);
				String metamodel = null;
				List<EPackage> packages = null;
				String metamodelpath = null;
				test.projectToModel(projectName, mutatorLauncher.getValue());
				String outputPath = ModelManager.getOutputPath(mutatorLauncher.getValue());
				File outputFolder = new File(outputPath);
				for (File outputFile : outputFolder.listFiles()) {
					if (outputFile.isDirectory()) {
						deleteDirectory(outputFile);
					}
				}

				metamodel = ModelManager.getMetaModel(mutatorLauncher.getValue());
				metamodelpath = ModelManager.getMetaModelPath(mutatorLauncher.getValue());
				Bundle bundle = Platform.getBundle("wodel.models");
				URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
				List<EPackage> mutatorpackages = null;
				List<Resource> models = null;
				String ecore = null;
				try {
					ecore = FileLocator.resolve(fileURL).getFile();
					mutatorpackages = ModelManager.loadMetaModel(ecore);
					packages = ModelManager.loadMetaModel(metamodel);
				} catch (MetaModelNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Class<?> cls = mutatorLauncher.getValue();
				File folder = new File(path + "/data");
				if (!folder.exists()) {
					folder.mkdir();
				}
				String projectNamePath = path + "/data/project.txt";
				WodelTestResultClass.storeProjectInfo(projectNamePath, test.getProjectName(), test.getNatureId());

				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				if (sourceProject.hasNature(JavaCore.NATURE_ID)) {
					IProject testSuiteProject = workspaceRoot.getProject(testSuiteName);
					IJavaProject javaTestSuiteProject = JavaCore.create(testSuiteProject);
					IClasspathEntry projectDependency = JavaCore.newProjectEntry(new Path("/" + projectName));
					IClasspathEntry[] classpathEntries = javaTestSuiteProject.getRawClasspath();
					boolean found = false;
					for (IClasspathEntry classpathEntry : classpathEntries) {
						if (classpathEntry.getPath().equals(projectDependency.getPath())) {
							found = true;
							break;
						}
					}
					if (!found) {
						IClasspathEntry[] newClasspathEntries = Arrays.copyOf(classpathEntries, classpathEntries.length + 1);
						newClasspathEntries[classpathEntries.length] = projectDependency;
						javaTestSuiteProject.setRawClasspath(newClasspathEntries, new NullProgressMonitor());
					}
				}
				IProjectDescription description = sourceProject.getDescription();
				String[] natures = description.getNatureIds();
				String[] newNatures = new String[natures.length + 1];
				System.arraycopy(natures, 0, newNatures, 0, natures.length);
				newNatures[natures.length] = WodelTestProjectNature.NATURE_ID;
				// validate the natures
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IStatus status = workspace.validateNatureSet(newNatures);
				// only apply new nature, if the status is ok
				if (status.getCode() == IStatus.OK) {
					description.setNatureIds(newNatures);
					sourceProject.setDescription(description, null);
				}
				int maxAttempts = 10;
				int numMutants = 3;
				boolean registry = false;
				boolean metrics = false;
				boolean debugMetrics = false;
				Object ob = null;
				List<EObject> blocks = null;
				List<String> blockNames = null;
				MutationResults mutationResults = null;
				String classesPath = ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getName() + "/data/classes.txt";
				TreeMap<String, List<String>> classes = WodelTestUtils.loadClasses(classesPath);
				boolean serialize = true;
				try {
					ob = cls.newInstance();
					Method m = cls.getMethod("execute", new Class[]{int.class, int.class, boolean.class, boolean.class, boolean.class, String[].class, IProject.class, IProgressMonitor.class, boolean.class, Object.class, TreeMap.class});
					maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "0", null));
					numMutants = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null));
					registry = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", false, null);
					metrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null);
					debugMetrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null);
					serialize = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Serialize models", true, null);
					models = ModelManager.loadModels(mutatorpackages, ModelManager.getOutputPath(cls) + "/");
					blocks = MutatorUtils.getBlocks(models);
					blockNames = new ArrayList<String>();
					for (EObject block : blocks) {
						String blockName = ModelManager.getStringAttribute("name", block);
						boolean included = Platform.getPreferencesService().getBoolean("WodelTest", blockName, true, null);
						if (included == true) {
							blockNames.add(blockName);
							numMutatorsSelected++;
						}
					}
					String[] blockNamesArray = new String[blockNames.size()];
					blockNames.toArray(blockNamesArray);
					mutationResults = (MutationResults) m.invoke(ob, maxAttempts, numMutants, registry, metrics, debugMetrics, blockNamesArray, sourceProject, monitor, serialize, test, classes);
					// ime = (IMutatorExecutor)ob;
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
				
				long mutationTimeMillis = System.currentTimeMillis() - currentTimeMillis;
				if (mutationResults != null) {
					numMutatorsApplied += mutationResults.numMutatorsApplied;
					if (mutationResults.mutatorsApplied != null) {
						mutatorsApplied.addAll(mutationResults.mutatorsApplied);
					}
					//numMutantsGenerated += mutationResults.numMutantsGenerated;

					try {
						IRegistryPostprocessor postprocessor = null;
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
									postprocessor = src;
								}
							}
						}
						if (postprocessor != null) {
						File[] files = null;
						//HashMap<String, Resource> hashmap_regpostseed = new HashMap<String, Resource>();
						//HashMap<String, Resource> hashmap_regpostmutant = new HashMap<String, Resource>();
						List<String> modelpaths = ModelManager.getModels(cls);
						for (String ecoreURI : modelpaths) {
							Resource modelfile = ModelManager.loadModel(packages, ecoreURI);
							files = new File(ModelManager.getOutputPath(cls) + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length())).listFiles();
							if (files != null) {
								for (int i = 0; i < files.length; i++) {
									if (files[i].isDirectory() == true) {
										if (files[i].getName().equals("registry") == true) {
											File[] regfiles = files[i].listFiles();
											for (int j = 0; j < regfiles.length; j++) {
												String pathfile = regfiles[j].getPath();
												if (pathfile.endsWith(".model") == true) {
													//hashmap_regpostseed.put(pathfile, modelfile);
													Resource mutant = ModelManager.loadModel(packages, ModelManager.getOutputPath(cls) + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length()) + "/" + regfiles[j].getName().replace("Registry", "")); 
													postprocessor.doProcess(modelfile, mutant, pathfile);
													//hashmap_regpostmutant.put(pathfile, mutant);
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
																//hashmap_regpostseed.put(pathfile, blockmodelfile);
																Resource mutant = ModelManager.loadModel(packages, files[i].getPath() + "/" + regfiles[k].getName().replace("Registry", "")); 
																postprocessor.doProcess(blockmodelfile, mutant, pathfile);
																//hashmap_regpostmutant.put(pathfile, mutant);
															}
														}
													}
													else {
														String blockModelFolder = ModelManager.getOutputPath(cls) + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length()) + "/" + regFilesBlock[j].getName();
														MutatorUtils.generateRegistryPaths(regFilesBlock[j], packages, files[i], blockModelFolder, postprocessor);
													}
												}
											}
										}
									}
								}
							}
						}
					}
					} catch (Exception e) {
						e.printStackTrace();
					}

					String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants postprocessing extension", "", null);
					Method doProcess = null;
					Object postprocessing =  null;
					if (Platform.getExtensionRegistry() != null) {
						IConfigurationElement[] extensions = Platform
								.getExtensionRegistry().getConfigurationElementsFor(
										"wodel.postprocessor.MutPostprocessor");
						IConfigurationElement appropriateExtension = null;
						for (IConfigurationElement extension : extensions) {
							Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
							postprocessing = extensionClass.newInstance();
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
						Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
						postprocessing = extensionClass.newInstance();
						Method getName = extensionClass.getDeclaredMethod("getName");
						if (getName.invoke(postprocessing).equals(extensionName) ) {
							doProcess = extensionClass.getDeclaredMethod("doProcess", new Class[]{String.class, String.class, Resource.class, String.class});
						}
					}
					//HashMap<Resource, String> hashmap_postproc = new HashMap<Resource, String>();
					File[] files = null;
					List<String> modelpaths = ModelManager.getModels(cls);
					File[] sourcefiles = new File(metamodelpath).listFiles();
					for (File file : sourcefiles) {
						if (file.isFile() == true) {
							String pathfile = file.getPath();
							if (pathfile.endsWith(".model") == true) {
								Resource modelfile = ModelManager.loadModel(packages, pathfile);
								String targetfile = new File(metamodelpath + "/" + pathfile.substring(pathfile.lastIndexOf(File.separator) + 1)).getPath();
								File f = new File(targetfile);
								if(!f.isDirectory()) { 
									if (doProcess != null) {
										doProcess.invoke(postprocessing, metamodelpath, metamodel, modelfile, targetfile);
									}
									AnnotateMutations.annotateMutationsProcess(sourceProject, metamodelpath, metamodel, modelfile);
								}
								//hashmap_postproc.put(modelfile, targetfile);
							}
						}
					}
					for (String ecoreURI : modelpaths) {
						files = new File(ModelManager.getOutputPath(cls) + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length())).listFiles();
						if (files != null) {
							for (int i = 0; i < files.length; i++) {
								if (files[i].isFile() == true) {
									String pathfile = files[i].getPath();
									if (pathfile.endsWith(".model") == true) {
										Resource modelfile = ModelManager.loadModel(packages,
												pathfile);
										File f = new File(pathfile);
										if(!f.isDirectory()) {
											if (doProcess != null) {
												doProcess.invoke(postprocessing, metamodelpath, metamodel, modelfile, pathfile);
											}
											AnnotateMutations.annotateMutationsProcess(sourceProject, metamodelpath, metamodel, modelfile);
										}
										//hashmap_postproc.put(modelfile, pathfile);
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
													//hashmap_postproc.put(modelfileblock, pathfileblock);
													File f = new File(pathfileblock);
													if(!f.isDirectory()) {
														if (doProcess != null) {
															doProcess.invoke(postprocessing, metamodelpath, metamodel, modelfileblock, pathfileblock);
														}
														AnnotateMutations.annotateMutationsProcess(sourceProject, metamodelpath, metamodel, modelfileblock);
													}
												}
											}
											else {
												MutatorUtils.generatePostprocessingPaths(filesBlock[j], packages, doProcess, postprocessing, metamodelpath, metamodel);
											}
										}
									}
								}
							}
						}
					}

					if (serialize == true) {
						if (outputFolder.isDirectory()) {
							for (File modelFolder : outputFolder.listFiles()) {
								if (modelFolder.isDirectory()) {
									for (File modelFile : modelFolder.listFiles()) {
										if (blocks.size() > 0) {
											if (modelFile.isDirectory() && blockNames.contains(modelFile.getName())) {
												for (File blockModelFile : modelFile.listFiles()) {
													if (blockModelFile.isFile() && blockModelFile.getName().endsWith(".model")) {
														Resource model = ModelManager.loadModel(packages, blockModelFile.getPath());
														boolean value = test.modelToProject(modelFolder.getName(), model, modelFile.getName(), blockModelFile.getName(), projectName, cls);
														if (value && classes.size() > 0) {
															String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/" + modelFolder.getName() + "/" + modelFile.getName() + "/" + blockModelFile.getName().replace(".model", "") + "/src/";
															WodelTestUtils.addPathToClasses(sourceProject.getName(), classes, projectPath);
														}
													}
												}
											}
										}
										else {
											if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
												Resource model = ModelManager.loadModel(packages, modelFile.getPath());
												boolean value = test.modelToProject(modelFolder.getName(), model, modelFolder.getName(), modelFile.getName(), projectName, cls);
												if (value && classes.size() > 0) {
													String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/" + modelFolder.getName() + "/" + modelFile.getName().replace(".model", "") + "/src/";
													WodelTestUtils.addPathToClasses(sourceProject.getName(), classes, projectPath);
												}
											}
										}
									}
								}
							}
						}
					}
					test.compile(sourceProject);
					WodelTestUtils.storeClasses(classesPath, classes);
					
					IProject testSuiteProject = workspaceRoot.getProject(testSuiteName);
					
					File mutantFolder = new File(path);
					List<String> artifactPaths = test.artifactPaths(sourceProject, path, mutantFolder, blockNames);
					for (String artifactPath : artifactPaths) {
						boolean found = false;
						for (String blockName : blockNames) {
							if (artifactPath.replaceAll("\\\\", "/").contains("/" + blockName + "/")) {
								found = true;
								break;
							}
						}
						if (found != true) {
							continue;
						}
						WodelTestGlobalResult globalResult = test.run(sourceProject, testSuiteProject, artifactPath);
						if (globalResult != null) {
							numMutantsGenerated++;
							if (globalResult.getStatus() == WodelTestGlobalResult.Status.OK) {
								WodelTestResultClass.storeFile(resultsPath, globalResult.getResults());
								WodelTestGlobalResult.storeValues(testsResultsPath, globalResult);
							}
							else {
								numMutantsNonCompiling++;
							}
						}
						
					}
					test.compile(sourceProject);
					
					//test.artifactPaths(sourceProject, projectPath, outputFolder, blockNames)
					//WodelTestGlobalResult globalResult = test.run(sourceProject, testSuiteProject, outputFolder, blockNames);
					
					boolean discardEquivalent = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Discard semantic equivalent mutants", false, null);
					Method doCompare = null;
					Object equivalence = null;
					if (discardEquivalent == true) {
						String discardExtensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Semantic equivalent mutants detection extension", "", null);
						if (Platform.getExtensionRegistry() != null) {
							IConfigurationElement[] extensions = Platform
									.getExtensionRegistry().getConfigurationElementsFor(
											"wodel.equivalence.MutEquivalence");
							IConfigurationElement appropriateExtension = null;
							for (IConfigurationElement extension : extensions) {
								Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
								equivalence =  extensionClass.newInstance();
								Method getURI = extensionClass.getDeclaredMethod("getURI");
								String uri = (String) getURI.invoke(equivalence);
								Method getName = extensionClass.getDeclaredMethod("getName");
								String name = (String) getName.invoke(equivalence);
								if (name.equals(discardExtensionName) && uri.equals("")) {
									appropriateExtension = extension;
									break;
								}
								if (name.equals(discardExtensionName) && uri.equals(packages.get(0).getNsURI())) {
									appropriateExtension = extension;
									break;
								}
								if (uri.equals("")) {
									appropriateExtension = extension;
								}
							}
							if (appropriateExtension != null) {
								Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
								equivalence = extensionClass.newInstance();
								Method getName = extensionClass.getDeclaredMethod("getName");
								outputPath = outputPath.substring(outputPath.indexOf(test.getProjectName()) + test.getProjectName().length() + 1, outputPath.length());
								if (getName.invoke(equivalence).equals(discardExtensionName) ) {
									doCompare = extensionClass.getDeclaredMethod("doCompare", new Class[]{String.class, String.class, String.class, IProject.class});
								}
							}
						}
						//HashMap<Resource, String> hashmap_seeds = new HashMap<Resource, String>();
						//HashMap<Resource, String> hashmap_mutants = new HashMap<Resource, String>();
						String classpath = ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getFullPath().toFile().getPath().toString() + "/data/classes.txt";
					    Map<String, List<WodelTestClass>> packageClasses = WodelTestUtils.getPackageClasses(test, sourceProject.getName(), classpath, resultsPath);
					    List<String> liveMutantPaths = new ArrayList<String>();
					    for (String packagename : packageClasses.keySet()) {
					    	List<WodelTestClass> values = packageClasses.get(packagename);
					    	for (WodelTestClass value : values) {
					    		for (WodelTestClassInfo valueInfo : value.info) {
					    			if (valueInfo.getNumFailedTests() == 0) {
					    				if (!liveMutantPaths.contains(valueInfo.path)) {
					    					liveMutantPaths.add(valueInfo.path);
					    				}
					    			}
					    			else {
					    				liveMutantPaths.remove(valueInfo.path);
					    			}
					    		}
					    	}
					    }
						files = null;
						String equivalentpath = ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getFullPath().toFile().getPath().toString() + "/data/classes.equivalent.txt";
						if (doCompare != null) {
							for (File file : sourcefiles) {
								if (file.isFile() == true) {
									String pathfile = file.getPath();
									if (pathfile.endsWith(".model") == true) {
										String targetfile = new File(metamodelpath + "/" + pathfile.substring(pathfile.lastIndexOf(File.separator) + 1)).getPath();
										String equivalentPaths = "";
										for (String ecoreURI : modelpaths) {
											files = new File(ModelManager.getOutputPath(mutatorLauncher.getValue()) + "/" + ecoreURI.substring(ecoreURI.lastIndexOf(File.separator) + 1, ecoreURI.length() - ".model".length())).listFiles();
											if (files != null) {
												for (int i = 0; i < files.length; i++) {
													if (files[i].isFile() == true) {
														String mutpathfile = files[i].getPath();
														if (mutpathfile.endsWith(".model") == true && !mutpathfile.substring(mutpathfile.lastIndexOf("\\"), mutpathfile.length()).contains("_")) {
															String mutantName = pathfile.substring(mutpathfile.lastIndexOf("\\"));
															mutantName = mutantName.substring(1, mutantName.indexOf(".model"));
															String mutatorName = files[i].getName();
															String mutantPath = mutatorName + "/" + mutantName;
															for (String liveMutantPath : liveMutantPaths) {
																if (liveMutantPath.contains(mutantPath)) {
																	File f = new File(mutpathfile);
																	if(!f.isDirectory() && !f.getName().contains("_")) { 
																		boolean result = (boolean) doCompare.invoke(equivalence, metamodel, targetfile, mutpathfile, sourceProject);
																		if (result == true) {
																			String equivalentPath = mutpathfile.replaceAll("\\\\", "/");
																			equivalentPath = equivalentPath.substring(equivalentPath.indexOf(outputPath) + outputPath.length(), equivalentPath.length()).replace(".model", "") + "/src/";
																			equivalentPaths += equivalentPath + "|";
																		}
																	}
																	//hashmap_mutants.put(mutantfile, mutpathfile);
																	break;
																}
															}
														}
													}
													else {
														if (files[i].getName().equals("registry") != true) {
															File[] filesBlock = files[i].listFiles();
															for (int j = 0; j < filesBlock.length; j++) {
																if (filesBlock[j].isFile() == true) {
																	String pathfileblock = filesBlock[j].getPath();
																	if (pathfileblock.endsWith(".model") == true && !pathfileblock.substring(pathfileblock.lastIndexOf("\\"), pathfileblock.length()).contains("_")) {
																		String mutantName = pathfileblock.substring(pathfileblock.lastIndexOf("\\"));
																		mutantName = mutantName.substring(1, mutantName.indexOf(".model"));
																		String mutatorName = files[i].getName();
																		String mutantPath = mutatorName + "/" + mutantName;
																		for (String liveMutantPath : liveMutantPaths) {
																			if (liveMutantPath.contains(mutantPath)) {
																				File f = new File(pathfileblock);
																				if(!f.isDirectory() && !f.getName().contains("_")) { 
																					boolean result = (boolean) doCompare.invoke(equivalence, metamodel, targetfile, pathfileblock, sourceProject);
																					if (result == true) {
																						String equivalentPath = pathfileblock.replaceAll("\\\\", "/");
																						equivalentPath = equivalentPath.substring(equivalentPath.indexOf(outputPath) + outputPath.length(), equivalentPath.length()).replace(".model", "") + "/src/";
																						equivalentPaths += equivalentPath + "|";
																					}
																				}
																				//hashmap_mutants.put(modelfileblock, pathfileblock);
																				break;
																			}
																		}
																	}
																}
																else {
																	equivalentPaths += MutatorUtils.generateLiveMutantPaths(filesBlock[j], packages, liveMutantPaths, doCompare, equivalence, metamodel, targetfile, sourceProject, outputPath);
																}
															}
														}
													}
													if (equivalentPaths.length() > 0) {
														equivalentPaths = equivalentPaths.substring(0, equivalentPaths.length() - 1);
													}
													WodelTestUtils.storeFile(equivalentpath, equivalentPaths);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				String mutatorNames = "";
				for (String mutatorName : mutatorsApplied) {
					mutatorNames += mutatorName + "|";
				}
				if (mutatorNames.length() > 0) {
					mutatorNames = mutatorNames.substring(0, mutatorNames.lastIndexOf("|"));
				}
				WodelTestUtils.storeFile(ModelManager.getWorkspaceAbsolutePath() + "/" + sourceProject.getName() + "/data/mutators.txt", mutatorNames);


				currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
				String globalResultsData = String.format("%d", currentTimeMillis) + "\n";
				globalResultsData += String.format("%d", mutationTimeMillis) + "\n";
				globalResultsData += numMutatorsSelected + "\n";
				globalResultsData += numMutatorsApplied + "\n";
				globalResultsData += numMutantsGenerated + "\n";
				globalResultsData += numMutantsNonCompiling + "\n";
				String globalResultsPath = path + "/data/" + projectName + ".global.results.txt";
				WodelTestUtils.storeFile(globalResultsPath, globalResultsData);

				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					public void run() {
						try {
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]; 
							PackageExplorerPart view = PackageExplorerPart.openInActivePerspective();
							view.selectAndReveal(sourceProject);
							page.showView(WodelTestGlobalGraphicalResultsViewPart.ID);
							//view = PackageExplorerPart.openInActivePerspective();
							//view.selectAndReveal(sourceProject);
							//page.showView(WodelTestClassResultsViewPart.ID);
							//view = PackageExplorerPart.openInActivePerspective();
							//view.selectAndReveal(sourceProject);
							//page.showView(WodelTestResultsTestViewPart.ID);
							//view = PackageExplorerPart.openInActivePerspective();
							//view.selectAndReveal(sourceProject);
							//page.showView(WodelTestMutatorResultsViewPart.ID);
						} catch (PartInitException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			} catch (JavaModelException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (CoreException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidRegistryObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			RunWodelTestWithProgress runWodelTestWithProgress = new RunWodelTestWithProgress(event);
			Thread.currentThread().getThreadGroup().setDaemon(true);
			new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(true, true, runWodelTestWithProgress);
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
