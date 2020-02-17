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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import kodkod.ast.Relation;
import kodkod.instance.TupleSet;
import manager.EMFUtils;
import manager.IOUtils;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.UseGeneratorUtils;
import manager.WodelContext;
import mutatorenvironment.Block;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import wodel.dsls.WodelStandaloneSetup;
import wodel.dsls.generator.WodelUseGenerator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.osgi.framework.Bundle;
import org.tzi.use.kodkod.UseScrollingKodkodModelValidator;
import org.tzi.use.kodkod.plugin.KodkodScrollingValidateCmd;
import org.tzi.use.kodkod.plugin.PluginModelFactory;
import org.tzi.use.main.Session;
import org.tzi.use.main.shell.Shell;
import org.tzi.use.main.shell.runtime.IPluginShellCmd;
import org.tzi.use.runtime.impl.PluginRuntime;
import org.tzi.use.uml.mm.MAttribute;
import org.tzi.use.uml.ocl.value.Value;
import org.tzi.use.uml.sys.MLink;
import org.tzi.use.uml.sys.MObject;
import org.tzi.use.uml.sys.MSystemState;
import com.google.inject.Injector;
import exceptions.ContainerNotFoundException;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel seed models synthesizer Wizard.
 * 
 */

public class GenerateWodelWizard extends Wizard implements IImportWizard {
	
	GenerateWodelWizardPage mainPage;

	private IStructuredSelection selection;

	private static final String WIZARD_NAME = "Seed Models Generator";
	
	private static String initialPath = "";
	public static IFile file;
	private static int numSeeds = 3;
	private static String customOCL = "";
	private static boolean forceRoot = true;
	private static List<String> blockNames = null;
	
	
	
	private static StringAdapter adapter = null;
	
	private static IStatus status = null;
	
	/**
	 * Adding the page to the wizard.
	 */

	@Override
	public void addPages() {
		super.addPages();
		mainPage = new GenerateWodelWizardPage(selection);
		mainPage.setTitle("Seed Models Generator");
		mainPage.setDescription("Generates seed models");
		addPage(mainPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
		this.selection = selection;
		addPages();
	}

	@Override
	public boolean performFinish() {
		try {
			initialPath = mainPage.file;
			numSeeds = mainPage.numSeeds;
			customOCL = mainPage.customOCL;
			forceRoot = mainPage.forceRoot;
			blockNames = mainPage.selectedBlockNames;
			
			GenerateWodelWithProgress generateWodelWithProgress = new GenerateWodelWithProgress();
			new ProgressMonitorDialog(new org.eclipse.swt.widgets.Shell()).run(true, true, generateWodelWithProgress);

			IProject project = file.getProject();
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			ErrorDialog.openError(new org.eclipse.swt.widgets.Shell(), "Error on USE command", e.getMessage(), status);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean canFinish() {
		return true;
	}

	private static class GenerateWodelWithProgress implements IRunnableWithProgress {


		private int timeOut = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Seed models generation timeout", "600", null));

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

//		private static void setAttributes(MObject mObject, EObject object, MObjectState mObjectState) {
//			Map<MAttribute, Value> attributeValueMap = mObjectState.attributeValueMap();
//			for (MAttribute mAtt : attributeValueMap.keySet()) {
//				Value value = attributeValueMap.get(mAtt);
//				if (value != null && object != null) {
//					if (mAtt.type().toString().equals("String")) {
//						ModelManager.setStringAttribute(mAtt.name(), object, value.toString().replaceAll("'", ""));
//					}
//					if (mAtt.type().toString().equals("Boolean")) {
//						ModelManager.setBooleanAttribute(mAtt.name(), object, Boolean.parseBoolean(value.toString()));
//					}
//					if (mAtt.type().toString().equals("Real")) {
//						ModelManager.setDoubleAttribute(mAtt.name(), object, Double.parseDouble(value.toString()));
//					}
//					if (mAtt.type().toString().equals("Integer")) {
//						boolean eenum = false;
//						for (EAttribute att : object.eClass().getEAllAttributes()) {
//							if (att.getName().equals(mAtt.name()) && (att.getEType() instanceof EEnum)) {
//								eenum = true;
//								ModelManager.setEEnumAttribute(mAtt.name(), object, (EEnum) att.getEType(), Integer.parseInt(value.toString()));
//								break;
//							}
//						}
//						if (eenum == false) {
//							ModelManager.setIntAttribute(mAtt.name(), object, Integer.parseInt(value.toString()));
//						}
//					}
//				}
//			}
//		}
		
		// used by method parseOutput2Emf: it removes the initial an final quotes of a phrase 
		private static String trim (String phrase) {
			while (phrase.startsWith("'")) phrase = phrase.substring(1);
			while (phrase.endsWith("'"))   phrase = phrase.substring(0, phrase.length()-1);
			return phrase;
		}
		
		// used by method parseOutput2Emf: it checks whether an object defines a containment reference with the given name
		private static boolean isContainment (EObject object, String refname) {
			return EMFUtils.hasReference(object, refname)? ((EReference) object.eClass().getEStructuralFeature(refname)).isContainment() : false;
		}
		
		private static String[] decode (List<EPackage> packages, String name) {
			String[] decoded = USEUtils.decodeClassName(name);
			String packageName = null;
			String className = null;
			if (decoded.length > 1) {
				packageName = decoded[0];
				className = decoded[1];
			}
			if (packageName == null || className == null) {
				return null;
			}
			return decoded;
		}
		
		private static String decode (String name) {
			String[] decoded = name.split("xxxx");
			if (decoded.length > 0) {
				return decoded[decoded.length - 1];
			}
			return null;
		}
		
		private static EObject getRootEObject(Collection<EObject> eobjects, EClass rootClass) {
			for (EObject eobject : eobjects) {
				if (EcoreUtil.equals(eobject.eClass(), rootClass)) {
					return eobject;
				}
			}
			return null;
		}
		
		private static void getReferenceName(String linkend0, String linkend1, EClass eClass1, EClass eClass2, HashMap<URI, Entry<String, String>> useReferencesClass, String[] linkend) {
			if (useReferencesClass == null) {
				linkend[0] = decode(linkend0);
				linkend[1] = decode(linkend1);
				return;
			}
			for (URI refUri : useReferencesClass.keySet()) {
				Entry<String, String> entry = useReferencesClass.get(refUri);
				if (entry.getKey().equals(linkend0)) {
					EReference ref = ModelManager.getReferenceByURI(refUri, eClass1);
					if (ref != null) {
						linkend[0] = ref.getName();
					}
					ref = ModelManager.getReferenceByURI(refUri, eClass2);
					if (ref != null) {
						linkend[0] = ref.getName();
					}
				}
				if (entry.getValue().equals(linkend1)) {
					EReference ref = ModelManager.getReferenceByURI(refUri, eClass1);
					if (ref != null) {
						linkend[1] = ref.getName();
					}
					ref = ModelManager.getReferenceByURI(refUri, eClass2);
					if (ref != null) {
						linkend[1] = ref.getName();
					}
				}
			}
		}
		
		private static boolean hasContainer(Resource model, EObject eobject) {
			return ModelManager.getContainer(model, eobject) != null ? true : false;
		}
		
		private static void removeContainedEObjectsFromList(Resource model, List<EObject> objects) {
			List<EObject> baseObjects = new ArrayList<EObject>();
			baseObjects.addAll(objects);
			for (EObject object : baseObjects) {
				if (hasContainer(model, object)) objects.remove(object);
			}
		}
		
		/**
		 * It returns the EMF model file that corresponds to the output generated by USE (a model in memory, stored in attribute state).
		 * @param metamodel
		 * @param output_file: this parameter is not used, it is here just for compatibility reasons with the interface
		 * @return name of generated emf file
		 * @throws transException 
		 */
		protected static Resource parseOutput2Emf(List<EPackage> packages, String emf_file, MSystemState result, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, boolean forceRootEObject) {
			
			int i = 0;
			Resource model = null;
			
			try {

				// create emf model
				ResourceSet resourceSet = new ResourceSetImpl();
				EPackage.Registry ePackageRegistry = resourceSet.getPackageRegistry();
				ePackageRegistry.put(packages.get(0).getNsURI(), packages.get(0));
				model  = resourceSet.createResource(URI.createFileURI(emf_file));
				//model = ModelManager.createModel(emf_file);
				
				Hashtable<String,EObject> eobjects  = new Hashtable<String,EObject>();

				// parse objects
				for (MObject useObject : result.allObjects()) {

					String[] decoded = decode(packages, useObject.cls().name());
					if (decoded == null) {
						continue;
					}
					EPackage pck = ModelManager.getEPackage(packages, decoded[0]);
					if (pck == null) {
						return null;
					}
					//EClass eClass = ModelManager.getEClassFromEPackage(pck, decoded[1]);
					EObject object = EMFUtils.createEObject(pck, decoded[1]);
					//EObject object = EcoreUtil.create(eClass);
					// TODO: asignar id
					eobjects.put(useObject.name(), object);
					model.getContents().add(object);
					
					//setAttributes(useObject, object, useObject.state(result));

					// parse attributes
					Map<MAttribute, Value> attributes = useObject.state(result).attributeValueMap();
					for (MAttribute attribute : attributes.keySet()) {
						String field = attribute.name();
						String value = trim( attributes.get(attribute).toString() );
						if (!value.equals("Undefined")) {
							String values[] = {value};
							if (value.startsWith("Set{")) values = value.substring(4,value.length()-1).split(",");
							if  (EMFUtils.hasAttribute(object, field))
								for (String v : values) EMFUtils.setAttribute(pck, object, field, adapter.adapt_use_string( v ));
							else for (String v : values) {
								if (!v.isEmpty()) {
									EObject object2 = eobjects.get(v.substring(1));
									EMFUtils.setReference(pck, object, field, object2);
									if (isContainment(object, field) && hasContainer(model, object2)) model.getContents().remove(object2);
								}
							}
						}
						// we assign a random string value
						else EMFUtils.setAttribute(pck, object, field, /*"s"+*/""+(i++));
					}
				}

				
				EClass rootClass = ModelManager.getRootEClass(packages);
				EObject root = getRootEObject(eobjects.values(), rootClass);
				// parse links
				for (MLink useLink : result.allLinks()) {
					EObject object1 = eobjects.get(useLink.linkedObjects().get(1/*0*/).name()); // TODO: check whether this works in general
					EObject object2 = eobjects.get(useLink.linkedObjects().get(0/*1*/).name());
					EClass eClass1 = object1.eClass();
					EClass eClass2 = object2.eClass();
					HashMap<URI, Entry<String, String>> useReferencesClass1 = useReferences.get(EcoreUtil.getURI(eClass1));
					HashMap<URI, Entry<String, String>> useReferencesClass2 = useReferences.get(EcoreUtil.getURI(eClass2));
					String linkend0 = useLink.association().associationEnds().get(0).name();
					String linkend1 = useLink.association().associationEnds().get(1).name();
					String[] linkend = new String[2];
					getReferenceName(linkend0, linkend1, eClass1, eClass2, useReferencesClass1, linkend);
					getReferenceName(linkend0, linkend1, eClass1, eClass2, useReferencesClass2, linkend);

					if (EMFUtils.hasReference(object1, linkend[0])) {
						if (!EcoreUtil.equals(root, object2)) {
							EMFUtils.setReference(packages, object1, linkend[0], object2);
							if (isContainment(object1, linkend[0]) && hasContainer(model, object2)) model.getContents().remove(object2);
							if (isContainment(object2, linkend[1]) && hasContainer(model, object1)) model.getContents().remove(object1);
						}
					}
					else if (EMFUtils.hasReference(object2, linkend[0])) {
						if (!EcoreUtil.equals(root, object1)) {
							EMFUtils.setReference(packages, object2, linkend[0], object1);
							if (isContainment(object2, linkend[0]) && hasContainer(model, object1)) model.getContents().remove(object1);
							if (isContainment(object1, linkend[1]) && hasContainer(model, object2)) model.getContents().remove(object2);
						}
					}
//					else if (linkend0.startsWith("xxxx")) {
//						EMFUtils.setReference(packages, object2/*1*/, linkend1, object1/*2*/);
//						if (isContainment(object2/*1*/, linkend1)) model.getContents().remove(object1/*2*/);
//					}
//					else if (linkend1.startsWith("xxxx")) {
//						EMFUtils.setReference(metamodel, object1/*2*/, linkend0, object2/*1*/);
//						if (isContainment(object1/*2*/, linkend0)) model.getContents().remove(object2/*1*/);
//					}
				}

				// completes containment references
				if (forceRootEObject == true) {

					List<EObject> values = new ArrayList<EObject>();
					values.addAll(eobjects.values());
					values.remove(root);

					for (EObject eobject : values) {
						if (!hasContainer(model, eobject)) {
							List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eobject.eClass()));
							boolean found = false;
							for (EClassifier containerClass : containers) {
								List<EObject> candidates = ModelManager.getObjectsOfType(containerClass.getName(), model);
								candidates.remove(eobject);
								if (candidates.size() == 0) {
									continue;
								}
								Collections.shuffle(candidates);
								for (EObject candidate : candidates) {
									List<EReference> refs = ModelManager.getContainmentReferencesOfType(packages, candidate, eobject);
									Collections.shuffle(refs);
									for (EReference ref : refs) {
										Object value = candidate.eGet(ref);
										if (value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) value;
											objects.add(eobject);
											found = true;
											break;
										}
										else {
											if (value == null) {
												EMFUtils.setReference(packages, candidate, ref.getName(), eobject);
												found = true;
												break;
											}
										}
									}
									if (found == true) {
										break;
									}
								}
								if (found == true) {
									break;
								}
							}
							if (found == true) {
								model.getContents().remove(eobject);
							}
						}
					}
				}
				
				// complete mandatory non containment references
//				List<EObject> objects = ModelManager.getAllObjects(model);
//				for (EObject obj : objects) {
//					for (EReference ref : obj.eClass().getEAllReferences()) {
//						if (ref.isChangeable() && ref.getLowerBound() > 0 && obj.eGet(ref) == null) {
//							EClass type = ref.getEReferenceType();
//							List<EObject> candidates = ModelManager.getObjectsOfType(type.getName(), model);
//							if (ref.isContainment()) {
//								removeContainedEObjectsFromList(model, candidates);
//							}
//							if (candidates.size() > 0) {
//								EMFUtils.setReference(packages, obj, ref.getName(), candidates.get(ModelManager.getRandomIndex(candidates)));
//							}
//						}
//					}
//				}
				
				// save model
				if (model.getContents().isEmpty())
					 emf_file = null;
				else model.save(null);
			} 
			catch (IOException exception) {
				exception.printStackTrace();
			}
		
		    return model;
		}
		
		private void generateUSEConfigurationFiles(String project, String fileName, String blockName, String useFilePath, String propertiesFilePath) {
			try {
				Bundle bundle = Platform.getBundle("wodel.models");
				URL mutatorURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
				String mutatorecore = FileLocator.resolve(mutatorURL).getFile();
				List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
				Resource mutatormodel = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath() + "/" + fileName.replace(".mutator", ".model"));
				Resource blockmodel = null;
				if (blockName.equals("*")) {
					blockmodel = mutatormodel;
				}
				else {
					blockmodel = ModelManager.createModel("file://" + ModelManager.getWorkspaceAbsolutePath() + '/' + manager.WodelContext.getProject() + '/' + ModelManager.getOutputFolder() + "/" + fileName.replace(".mutator", "") + "_" + blockName + ".model");
					MutatorEnvironment blockMutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment();
					MutatorEnvironment mutMutatorEnvironment = (MutatorEnvironment) mutatormodel.getContents().get(0);
					blockMutatorEnvironment.setDefinition(EcoreUtil.copy(mutMutatorEnvironment.getDefinition()));
					blockMutatorEnvironment.getBlocks().add((Block) MutatorUtils.getBlock(mutatormodel, blockName));
					blockmodel.getContents().add(blockMutatorEnvironment);
				}
				Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				WodelUseGenerator generator = new WodelUseGenerator();
				generator.doGenerate(blockmodel, fsa, null);
				Map<String, Object> map = fsa.getAllFiles();
			
				for (String f : map.keySet()) {
					if (f.endsWith(".use")) {
						PrintWriter pw = new PrintWriter(new FileWriter(useFilePath, false));
						pw.print((String) map.get(f));
						pw.close();
					}
					if (f.endsWith(".properties")) {
						PrintWriter pw = new PrintWriter(new FileWriter(propertiesFilePath, false));
						pw.print((String) map.get(f));
						pw.close();
					}
				}
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		private void processUSEFiles(List<EPackage> packages, Path procUseFilename, Path procPropertiesFilename, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
			try {
				// adds the necessary ocl constraints and properties info for the selected initial model
				String oclNames = "";
				if (initialPath != null && initialPath.length() > 0) {
					Resource initial = ModelManager.loadModel(packages, initialPath);
					String oclText = "inv initial_model : " + USEUtils.xmi2ocl(initial, classNames, useReferences);
					File useFile = procUseFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(useFile, true));
					pw.println(oclText);
					pw.close();
					oclNames = USEUtils.xmi2oclNames(initial, classNames);
				}
				System.out.println("file.getName(): " + file.getName());
				oclNames = USEUtils.oclAddNames(USEUtils.wodel2useNames(file.getName()), oclNames);
				if (customOCL != null & customOCL.length() > 0) {
					String oclText = "inv custom_ocl : " + USEUtils.ocl2use(packages, customOCL, useReferences);
					File useFile = procUseFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(useFile, true));
					pw.println(oclText);
					pw.close();
					oclNames = USEUtils.oclAddNames(oclNames, oclText);
				}
				if (oclNames != null && oclNames.length() > 0) {
					File propertiesFile = procPropertiesFilename.toFile();
					PrintWriter pw = new PrintWriter(new FileWriter(propertiesFile, true));
					pw.println(oclNames);
					pw.close();
				}

				if (forceRoot == false) {
					File propertiesFile = procPropertiesFilename.toFile();
					BufferedReader br = new BufferedReader(new FileReader(propertiesFile));
					EClass rootEClass = ModelManager.getRootEClass(packages);
					//int max = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum cardinality value", "10", null));
					List<String> lines = new ArrayList<String>();
					String line = null;
					while ((line = br.readLine()) != null) {
						line = line.replace(rootEClass.getName() + "_min = 1", rootEClass.getName() + "_min = 0");
						//line = line.replace(rootEClass.getName() + "_max = 1", rootEClass.getName() + "_max = " + max);
						//line = line.replace(rootEClass.getName() + "_max = 1", rootEClass.getName() + "_max = 0");
						lines.add(line);
					}
					br.close();
					PrintWriter pw = new PrintWriter(new FileWriter(propertiesFile, false));
					for (String l : lines) {
						pw.println(l);
					}
					pw.close();
				}
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException,	InterruptedException {
			final String fileName = file.getName();
			final IProgressMonitor progressMonitor = monitor;
			final int numModels = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of seed models", "10", null));
			final int numSeedModels = (numSeeds > 0) ? numSeeds : numModels;
			progressMonitor.beginTask("Creating seed models", numSeedModels);

			PrintWriter fLogWriter = null;
			java.nio.file.Path useFilename = null;
			java.nio.file.Path procUseFilename = null;
			java.nio.file.Path procPropertiesFilename = null;
			final Session fSession = new Session();
			String project = "";
			fSession.reset();
			adapter = new StringAdapter();
			try {
				//String log4jConfigFileName = FileLocator.resolve(Platform.getBundle("org.tzi.use").getEntry("/log4j/log4j.xml")).getFile();
				//PropertyConfigurator.configure(log4jConfigFileName);

				// generates the .use and .properties configuration files
				project = ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject();
				String suffix = "";
				for (String blockName : blockNames) {
					if (!blockName.equals("*")) {
						suffix = "_" + blockName;
					}
					String useFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", suffix + ".use");
					String propertiesFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", suffix + ".properties");
					generateUSEConfigurationFiles(project, fileName, blockName, useFilePath, propertiesFilePath);

					// configuration for the automated seed models synthesis
					fLogWriter = new PrintWriter(project + "/src-gen/" + fileName.replaceAll(".mutator", suffix + ".log"));
					useFilename = Paths.get(useFilePath);
					String procUseFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", suffix + "_proc.use");
					procUseFilename =Paths.get(procUseFilePath);
					String procPropertiesFilePath = project + "/src-gen/" + fileName.replaceAll(".mutator", suffix + "_proc.properties");
					procPropertiesFilename = Paths.get(procPropertiesFilePath);
					final String metamodel = ModelManager.getMetaModel();
					final List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
					List<EClass> classes = ModelManager.getEClasses(packages);
					HashMap<URI, String> classNames = UseGeneratorUtils.buildClassNames(classes);
					HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences = UseGeneratorUtils.getUseReferences(packages, classNames);

					// creates a new use file to operate with the seed models synthesizer
					try {
						FileReader fr = new FileReader (new File(useFilename.toAbsolutePath().toString()));
						BufferedReader br = new BufferedReader(fr);
						br.close();
					} catch (FileNotFoundException e1) {
						status = new Status(IStatus.ERROR, wodel.synthesizer.Activator.PLUGIN_ID, 0, "File not found", null);
						throw new InterruptedException("USE file not found");
					} catch (IOException e) {
					}

					IOUtils.copyFile(useFilePath, procUseFilePath);
					// creates a new properties file to operate with the seed models synthesizer
					IOUtils.copyFile(propertiesFilePath, procPropertiesFilePath);

					// process the .use and the .properties files
					processUSEFiles(packages, procUseFilename, procPropertiesFilename, classNames, useReferences);

					Shell.createInstance(fSession, PluginRuntime.getInstance());
					WrapperErrorConsole.start();  // wrapper for standard error console
					final String use_file = procUseFilename.toAbsolutePath().toString();
					Shell.getInstance().processLineSafely("open " + use_file);
					String error = WrapperErrorConsole.read();

					if (!fSession.hasSystem()) {
						status = new Status(IStatus.ERROR, wodel.synthesizer.Activator.PLUGIN_ID, 0, "Invalid USE file", null);
						throw new InterruptedException("USE file contains errors: " + error);
					}
					final String properties_file = procPropertiesFilename.toAbsolutePath().toString();
					final String suffix_final = suffix;
					WrapperErrorConsole.finish(); // restore standard error console

					final KodkodScrollingValidateCmd c = new KodkodScrollingValidateCmd() {
						@Override
						public void performCommand(IPluginShellCmd pluginCommand) {
							initialize(fSession);
							mSystem = fSession.system();
							mModel = mSystem.model();
							//String arguments = " " + properties_file;
							PluginModelFactory.INSTANCE.onClassInvariantUnloaded(null);
							String[] arguments = {properties_file};
							handleArguments(arguments);
							//System.out.println("current operation: " + mSystem.getCurrentOperation());
							mSystem.registerPPCHandlerOverride(Shell.getInstance());

							try {
								int i = 0;
								while (i < numSeedModels) {
									Field solutionsField = UseScrollingKodkodModelValidator.class.getDeclaredField("solutions");
									solutionsField.setAccessible(true);
									List<Map<Relation, TupleSet>> solutions = (List<Map<Relation, TupleSet>>) solutionsField.get(validator);
									if (solutions.size() > 0) {
										MSystemState mSystemState = mSystem.state();
										String xmiFileName = fileName.replaceAll(".mutator", suffix_final + i + ".model");
										String seedPath = ModelManager.getMetaModelPath() + "/" + xmiFileName;
										progressMonitor.subTask("Seed " + (i + 1) + "/" + numSeedModels + ": " + seedPath);
										Resource seed = parseOutput2Emf(packages, seedPath, mSystemState, useReferences, forceRoot);
										if (seed != null) {
											boolean valid = ModelManager.validateModel(metamodel, seedPath);
											if (valid == true) {
												progressMonitor.worked(1);
												i++;
											}
										}
										if (progressMonitor.isCanceled()) {
											progressMonitor.done();
											break;
										}
										if (i < numSeedModels) {
											validator.nextSolution();
										}
									}
								}
								finalize();
								//System.out.println("done.");
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
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Throwable e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					};

					ExecutorService executor = Executors.newCachedThreadPool();
					Callable<Object> task = new Callable<Object>() {
						public Object call() {
							c.performCommand(null);
							return null;
						}
					};

					Future<Object> future = executor.submit(task);
					try {
						Object result = future.get(timeOut, TimeUnit.SECONDS); 
					} catch (TimeoutException ex) {
						// handle the timeout
					} catch (InterruptedException e) {
						// handle the interrupts
					} catch (ExecutionException e) {
						// handle other exceptions
					} finally {
						future.cancel(true); // may or may not desire this
					}
				}

			} catch (IOException ex) {
				fLogWriter.println("File '" + useFilename.toAbsolutePath().toString() + "' not found.");
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void setFile(IFile f) {
		file = f;
	}
}
