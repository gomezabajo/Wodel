/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package wodel.synthesizer.generator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kodkod.ast.Relation;
import kodkod.instance.TupleSet;
import manager.IOUtils;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.UseUtils;
import manager.WodelContext;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.tzi.use.kodkod.UseScrollingKodkodModelValidator;
import org.tzi.use.kodkod.plugin.KodkodScrollingValidateCmd;
import org.tzi.use.main.Session;
import org.tzi.use.main.shell.Shell;
import org.tzi.use.main.shell.runtime.IPluginShellCmd;
import org.tzi.use.runtime.impl.PluginRuntime;
import org.tzi.use.uml.mm.MAttribute;
import org.tzi.use.uml.ocl.value.Value;
import org.tzi.use.uml.sys.MLink;
import org.tzi.use.uml.sys.MObject;
import org.tzi.use.uml.sys.MObjectState;
import org.tzi.use.uml.sys.MSystemState;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import commands.CreateObjectMutator;
import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.SpecificObjectSelection;
import commands.selection.strategies.SpecificReferenceSelection;
import commands.strategies.AttributeConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.ContainerNotFoundException;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.USEImportException;
import exceptions.WrongAttributeTypeException;

public class GenerateWodelWizard extends Wizard implements IImportWizard {
	
	GenerateWodelWizardPage mainPage;

	private ISelection selection;

	private static final String WIZARD_NAME = "Seed Models Generator";
	
	private static String initialPath = "";
	private static IFile file;
	private static int numSeeds = 5;
	private static String customOCL = "";

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		super.addPages();
		mainPage = new GenerateWodelWizardPage(selection);
		mainPage.setTitle("Seed Models Generator");
		mainPage.setDescription("Generates seed models");
		addPage(mainPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
		addPages();
	}

	@Override
	public boolean performFinish() {
		try {
			initialPath = mainPage.file;
			numSeeds = mainPage.numSeeds;
			customOCL = mainPage.customOCL;
	
			GenerateWodelWithProgress generateWodelWithProgress = new GenerateWodelWithProgress();
			new ProgressMonitorDialog(new org.eclipse.swt.widgets.Shell()).run(true, true, generateWodelWithProgress);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean canFinish() {
		return true;
	}

	private void doFinish(IProgressMonitor monitor) {
	}

	private static class GenerateWodelWithProgress implements IRunnableWithProgress {


		private int timeOut = 600;

		private static class WrapperErrorConsole extends PrintStream {

			private static StringBuilder       buffer;
			private static PrintStream         standardConsole;
			private static WrapperErrorConsole wrapperConsole = null;

			private WrapperErrorConsole(StringBuilder sb, OutputStream os, PrintStream ul) {
				super(os);
				buffer          = sb;
				standardConsole = ul;
			}

			// redirect system.err to buffer
			public static WrapperErrorConsole start() {
				try {
					final StringBuilder sb = new StringBuilder();
					Field f = FilterOutputStream.class.getDeclaredField("out");
					f.setAccessible(true);
					OutputStream psout = (OutputStream) f.get(System.err);
					wrapperConsole = new WrapperErrorConsole(
							sb, 
							new FilterOutputStream(psout) {
								public void write(int b) throws IOException {
									super.write(b);
									sb.append((char) b);
								}
							}, 
							System.err);
					System.setErr(wrapperConsole);
				} 
				catch (NoSuchFieldException shouldNotHappen)     {} 
				catch (IllegalArgumentException shouldNotHappen) {} 
				catch (IllegalAccessException shouldNotHappen)   {}
				return null;
			}

			// get content of buffer
			public static String read() {
				if (wrapperConsole!=null) {
					System.err.flush();
					return buffer.toString();
				}
				else return "";
			}

			// restore system.err
			public static void finish() {
				if (standardConsole!=null) {
					System.setErr(standardConsole);
					standardConsole = null;
					wrapperConsole  = null;
				}
			}
		}

		private void setAttributes(MObject mObject, EObject object, MObjectState mObjectState) {
			Map<MAttribute, Value> attributeValueMap = mObjectState.attributeValueMap();
			for (MAttribute mAtt : attributeValueMap.keySet()) {
				Value value = attributeValueMap.get(mAtt);
				System.out.println(mAtt.type().toString());
				if (mAtt.type().toString().equals("String")) {
					ModelManager.setStringAttribute(mAtt.name(), object, value.toString().replaceAll("'", ""));
				}
				if (mAtt.type().toString().equals("Boolean")) {
					ModelManager.setBooleanAttribute(mAtt.name(), object, Boolean.parseBoolean(value.toString()));
				}
			}
		}

		private EObject createObject(EClass containerClass, EClass targetClass, MObject mObject, HashMap<MObject, EObject> hmObjects, ArrayList<EPackage> packages, Resource seed) {
			EObject newObject = null;
			try {
				if (UseUtils.decodeWord(mObject.cls().name()).equals(targetClass.getName())) {
					ObSelectionStrategy containerSelection = null;
					if (containerClass != null) {
						List<EObject> containers = ModelManager.getObjectsOfType(containerClass.getName(), seed);
						if (containers.size() > 0) {
							containerSelection = new SpecificObjectSelection(packages, seed, containers.get(ModelManager.getRandomIndex(containers)));
							SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, seed, null, null);
							HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
							HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
							CreateObjectMutator mut = new CreateObjectMutator(seed, packages, referenceSelection, containerSelection, atts, refs, targetClass.getName());
							mut.mutate();
							newObject = mut.getObject();
						}
					}
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongAttributeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AbstractCreationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectNotContainedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return newObject;
		}

		private void createObjects(EObject object, HashMap<EClass, List<EObject>> hmEClass, HashMap<MObject, EObject> hmObjects, Set<MObject> mObjects, MSystemState mSystemState, ArrayList<EPackage> packages, Resource seed) {
			for (EReference ref : object.eClass().getEReferences()) {
				EClass cl = (EClass) ref.getEType();
				List<EObject> objects = null;
				if (hmEClass.get(cl) == null) {
					objects = new ArrayList<EObject>();
				}
				else {
					objects = hmEClass.get(cl);
				}
				for (MObject mObject : mObjects) {
					if (hmObjects.get(mObject) == null) {
						if (UseUtils.decodeWord(mObject.cls().name()).equals(cl.getName())) {

							MObjectState mObjectState = mObject.state(mSystemState);
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, cl.getName());
							EClass container = null;
							while (container == null && containers.size() > 0) {
								container = (EClass) containers.get(ModelManager.getRandomIndex(containers));
								if (container.getName().equals(cl.getName())) {
									containers.remove(container);
									container = null;
								}
							}
							EObject newObject = null;
							while (newObject == null && containers.size() > 0) {
								newObject = createObject(container, cl, mObject, hmObjects, packages, seed);
								if (newObject == null) {
									containers.remove(container);
									if (containers.size() > 0) {
										container = (EClass) containers.get(ModelManager.getRandomIndex(containers));
									}
								}
							}
							setAttributes(mObject, newObject, mObjectState);
							objects.add(newObject);
							hmObjects.put(mObject, newObject);
							hmEClass.put(cl, objects);
							createObjects(newObject, hmEClass, hmObjects, mObjects, mSystemState, packages, seed);
						}
					}
				}

			}
		}

		private boolean completeModel(MLink activeLink, HashMap<MObject, EObject> hmObjects, ArrayList<EPackage> packages, Resource seed, MSystemState mSystemState, HashMap<EClass, List<EObject>> hmEClass) throws ContainerNotFoundException {
			try {
				MObject activeMObject = activeLink.linkedObjects().get(0);
				EObject activeObject = hmObjects.get(activeMObject);
				MObjectState mObjectState = activeMObject.state(mSystemState);
				String refName = activeLink.association().roleNames().get(1);
				if (activeObject == null) {
					EClass cl = ModelManager.getEClassByName(packages, UseUtils.decodeWord(activeMObject.cls().name()));
					List<EClassifier> containers = ModelManager.getContainerTypes(packages, cl.getName());
					EClass container = null;
					while (container == null && containers.size() > 0) {
						container = (EClass) containers.get(ModelManager.getRandomIndex(containers));
						boolean b = false;
						for (EReference ref : container.getEAllReferences()) {
							if (refName.startsWith(ref.getName())) {
								b = true;
								break;
							}
						}
						if (b == false) {
							containers.remove(container);
							container = null;
						}
					}
					activeObject = createObject(container, cl, activeMObject, hmObjects, packages, seed);
					if (activeObject != null) {
						List<EObject> objects = null;
						if (hmEClass.get(activeObject.eClass()) == null) {
							objects = new ArrayList<EObject>();
						}
						else {
							objects = hmEClass.get(cl);
						}
						setAttributes(activeMObject, activeObject, mObjectState);
						objects.add(activeObject);
						hmObjects.put(activeMObject, activeObject);
						hmEClass.put(cl, objects);
					}
				}
				if (activeObject == null) {
					return false;
				}
				MObject tarMObject = activeLink.linkedObjects().get(1);
				EObject tarObject = hmObjects.get(tarMObject);
				if (tarObject == null) {
					for (EReference ref : activeObject.eClass().getEReferences()) {
						if (refName.startsWith(ref.getName())) {
							mObjectState = tarMObject.state(mSystemState);
							EClass cl = (EClass) ref.getEType();
							tarObject = createObject(activeObject.eClass(), cl, tarMObject, hmObjects, packages, seed);
							setAttributes(tarMObject, tarObject, mObjectState);
							List<EObject> objects = null;
							if (hmEClass.get(cl) == null) {
								objects = new ArrayList<EObject>();
							}	
							else {
								objects = hmEClass.get(cl);
							}
							objects.add(tarObject);
							hmObjects.put(tarMObject, tarObject);
							hmEClass.put(cl, objects);
							break;
						}
					}
				}
				else {
					for (EReference ref : activeObject.eClass().getEReferences()) {
						if (refName.startsWith(ref.getName())) {
							if (activeObject.eGet(ref) instanceof List<?>) {
								List<EObject> activeTars = ModelManager.getReferences(ref.getName(), activeObject);
								activeTars.add(tarObject);
							}
							else {
								ModelManager.setReference(ref.getName(), activeObject, tarObject);
							}
							break;
						}
					}
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongAttributeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException,
		InterruptedException {
			final String fileName = file.getName();
			final IProgressMonitor progressMonitor = monitor;
			final int numModels = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of seed models", "10", null));
			final int numSeedModels = (numSeeds > 0) ? numSeeds : numModels;
			progressMonitor.beginTask("Creating seed models", numSeedModels);

			PrintWriter fLogWriter = null;
			java.nio.file.Path useFilename = null;
			java.nio.file.Path procUseFilename = null;
			java.nio.file.Path propertiesFilename = null;
			java.nio.file.Path procPropertiesFilename = null;
			final Session fSession = new Session();
			String project = "";
			fSession.reset();
			try {
				//String log4jConfigFileName = FileLocator.resolve(Platform.getBundle("org.tzi.use").getEntry("/log4j/log4j.xml")).getFile();
				//PropertyConfigurator.configure(log4jConfigFileName);

				project = ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject();
				fLogWriter = new PrintWriter(project + "/src-gen/" + fileName.replaceAll(".mutator", ".log"));
				String useFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", ".use");
				useFilename = Paths.get(useFilePath);
				String procUseFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", "_proc.use");
				procUseFilename =Paths.get(procUseFilePath);
				String propertiesFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", ".properties");
				propertiesFilename = Paths.get(propertiesFilePath);
				String procPropertiesFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", "_proc.properties");
				procPropertiesFilename = Paths.get(procPropertiesFilePath);
				final String metamodel = ModelManager.getMetaModel();
				final ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				HashMap<String, HashMap<String, String>> useReferences = UseUtils.getUseReferences(packages);
				
				// refresh the use generated file
				try {
					InputStream stream = file.getContents();
					if (file.exists()) {
						String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
						stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
						file.setContents(stream, true, true, null);
					}
					stream.close();
				} catch (CoreException e) {
				} catch (IOException e) {
				}
				
				// creates a new use file to operate with the seed models synthesizer
				IOUtils.copyFile(useFilePath, procUseFilePath);
				// creates a new properties file to operate with the seed models synthesizer
				IOUtils.copyFile(propertiesFilePath, procPropertiesFilePath);

				// adds the necessary ocl constraints and properties info for the selected initial model
				String oclNames = "";
				if (initialPath != null && initialPath.length() > 0) {
					Resource initial = ModelManager.loadModel(packages, initialPath);
					String oclText = "inv initial_model : " + UseUtils.xmi2ocl(initial, useReferences);
					File useFile = procUseFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(useFile, true));
					pw.println(oclText);
					pw.close();
					oclNames = UseUtils.xmi2oclNames(initial);
				}
				if (customOCL != null & customOCL.length() > 0) {
					String oclText = "inv custom_ocl : " + UseUtils.ocl2use(customOCL, useReferences);
					File useFile = procUseFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(useFile, true));
					pw.println(oclText);
					pw.close();
					oclNames = UseUtils.oclAddNames(oclNames, oclText);
				}
				if (oclNames != null && oclNames.length() > 0) {
					File propertiesFile = procPropertiesFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(propertiesFile, true));
					pw.println(oclNames);
					pw.close();
				}
				
				Shell.createInstance(fSession, PluginRuntime.getInstance());
				WrapperErrorConsole.start();  // wrapper for standard error console
				Shell.getInstance().processLineSafely("open " + procUseFilename.toAbsolutePath().toString());
				String error = WrapperErrorConsole.read();

				Status status = new Status(IStatus.ERROR, wodel.synthesizer.Activator.PLUGIN_ID, 0, "Invalid USE file", null);
				if (!fSession.hasSystem()) ErrorDialog.openError(null, "Invalid USE file", "USE file contains errors: " + error, status);
				String root = null;
				try {
					FileReader fr = new FileReader (new File(useFilename.toAbsolutePath().toString()));
					BufferedReader br = new BufferedReader(fr);
					root = br.readLine().split(" ")[1];
					br.close();
				} catch (FileNotFoundException e1) {
					status = new Status(IStatus.ERROR, wodel.synthesizer.Activator.PLUGIN_ID, 0, "File not found", null);
					ErrorDialog.openError(null, "File not found", "USE file not found", status);
				} catch (IOException e) {}

				final String properties_file = procPropertiesFilename.toAbsolutePath().toString();
				WrapperErrorConsole.finish(); // restore standard error console

				final KodkodScrollingValidateCmd c = new KodkodScrollingValidateCmd() {
					@Override
					public void performCommand(IPluginShellCmd pluginCommand) {
						mSystem = fSession.system();
						mModel = mSystem.model();
						String arguments = " "+properties_file;
						handleArguments(arguments);
						System.out.println("current operation: " + mSystem.getCurrentOperation());
						mSystem.registerPPCHandlerOverride(Shell.getInstance());

						try {
							Field solutionsField = UseScrollingKodkodModelValidator.class.getDeclaredField("solutions");
							solutionsField.setAccessible(true);

							int solutionsSize = 0;
							for (int i = 0; i < numSeedModels; i++) {
								List<Map<Relation, TupleSet>> solutions = (List<Map<Relation, TupleSet>>) solutionsField.get(validator);
								int inc = solutions.size();
								// Checks if it is a new solution
								if (inc > solutionsSize) {
									solutionsSize = inc;
								}
								else {
									break;
								}
								MSystemState mSystemState = mSystem.state();
								System.out.println("MObjects:");
								for (MObject mObject : mSystemState.allObjects()) {
									System.out.println(mObject.name());
								}
								String xmiFileName = fileName.replaceAll(".mutator", i + ".model");
								String seedPath = ModelManager.getMetaModelPath() + "/" + xmiFileName;
								progressMonitor.subTask("Seed " + (i + 1) + "/" + numSeedModels + ": " + seedPath);
								List<EClass> classes = ModelManager.getEClasses(packages);
								EClass rootClass = null;
								for (EClass cl : classes) {
									List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, cl.getName());
									if (containerTypes.size() == 0) {
										rootClass = cl;
										break;
									}
								}
								Set<MObject> mObjects = mSystemState.allObjects();
								HashMap<MObject, EObject> hmObjects = new HashMap<MObject, EObject>();
								HashMap<EClass, List<EObject>> hmEClass = new HashMap<EClass, List<EObject>>();
								EObject rootEObject = null;
								for (MObject mObject : mObjects) {
									MObjectState mObjectState = mObject.state(mSystemState);
									if (UseUtils.decodeWord(mObject.cls().name()).equals(rootClass.getName())) {
										List<EObject> objects = null;
										if (hmEClass.get(rootClass) == null) {
											objects = new ArrayList<EObject>();
										}
										else {
											objects = hmEClass.get(rootClass);
										}
										rootEObject = EcoreUtil.create(rootClass);
										setAttributes(mObject, rootEObject, mObjectState);
										objects.add(rootEObject);
										hmObjects.put(mObject, rootEObject);
										hmEClass.put(rootClass, objects);
										break;
									}
								}
								Resource seed = ModelManager.createAndLoadModel(rootEObject, seedPath);
								Set<MLink> mLinks = mSystemState.allLinks();
								createObjects(rootEObject, hmEClass, hmObjects, mObjects, mSystemState, packages, seed);
								List<MLink> tmpMLinks = new ArrayList<MLink>();
								tmpMLinks.addAll(mLinks);
								while (mLinks.size() > 0) {
									int size = mLinks.size();
									for (MLink mLink : tmpMLinks) {
										if (completeModel(mLink, hmObjects, packages, seed, mSystemState, hmEClass) == true) {
											mLinks.remove(mLink);
										}
									}
									if (mLinks.size() == size) {
										throw new USEImportException(xmiFileName);
									}
									tmpMLinks.clear();
									tmpMLinks.addAll(mLinks);
								}
								seed.getContents().clear();
								seed.getContents().add(rootEObject);
								ModelManager.saveOutModel(seed, seedPath);
								progressMonitor.worked(1);
								validator.nextSolution();
							}
							System.out.println("done.");
						} catch (ContainerNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchFieldException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (USEImportException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				};
				
				c.performCommand(null);

			} catch (IOException ex) {
				fLogWriter.println("File '" + useFilename.toAbsolutePath().toString() + "' not found.");
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void setFile(IFile f) {
		file = f;
	}
}
