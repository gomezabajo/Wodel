package mutator.testJavaDLMDynamic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorMetricsGenerator;
import wodel.utils.manager.DebugMutatorMetricsGenerator;
import wodel.utils.manager.NetMutatorMetricsGenerator;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import appliedMutations.*;
import wodel.utils.commands.*;
import wodel.utils.commands.selection.strategies.*;
import wodel.utils.commands.strategies.*;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.core.runtime.IProgressMonitor;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.EMFCopier;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatormetrics.MutatormetricsPackage;

public class testJavaDLMDynamic extends MutatorUtils {
	private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	private List<EObject> mutatedObjects = null;

	private int mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BooleanLiteral", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "value";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(false);
		((AttributeEvaluation) exp0.first).type = "Boolean";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation1." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificBooleanConfigurationStrategy(true);
					atts.add(attConfig);
					attsList.put("value", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry1(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/bt/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "bt", fromNames,
							k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true,
							false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("value");
		oldAttVal = mutator.getOldAttValue("value");
		newAttVal = mutator.getNewAttValue("value");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m1") != null) {
			attMut0.setDef(hmMutator.get("m1"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m1"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_bt(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation1(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation2(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BooleanLiteral", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "value";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(true);
		((AttributeEvaluation) exp0.first).type = "Boolean";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation2." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificBooleanConfigurationStrategy(false);
					atts.add(attConfig);
					attsList.put("value", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/bf/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "bf", fromNames,
							k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true,
							false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("value");
		oldAttVal = mutator.getOldAttValue("value");
		newAttVal = mutator.getNewAttValue("value");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m2") != null) {
			attMut0.setDef(hmMutator.get("m2"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m2"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_bf(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation2(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation3(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "NumberLiteral", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "tokenValue";
		((AttributeEvaluation) exp0.first).operator = "different";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("1");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation3." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("1");
					atts.add(attConfig);
					attsList.put("tokenValue", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rnl/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rnl", fromNames,
							k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true,
							false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("tokenValue");
		oldAttVal = mutator.getOldAttValue("tokenValue");
		newAttVal = mutator.getNewAttValue("tokenValue");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m3") != null) {
			attMut0.setDef(hmMutator.get("m3"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m3"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rnl(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation3(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "ReturnStatement");
		rts = new RandomTypeSelection(packages, model, "ReturnStatement");
		List<EObject> objects = rts.getObjects();
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, resource, object);
				SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
						objectSelection.getMetaModel(), null, null, objectSelection);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
								mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
								mut.getObject(), resourceEntry);
						hmObjects.put("rtstmt", entry);
						AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation5(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m4") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m4"));
		}
		return appMut;
	}

	private int mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rtstmt = hmObjects.get("rtstmt");
		if (entry_rtstmt != null) {
			EObject recovered = ModelManager.getObject(model, entry_rtstmt.getKey());
			if (recovered == null) {
				recovered = entry_rtstmt.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
			referenceSelection = new SpecificReferenceSelection(packages, model, "expression", recovered);
		} else {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "NullLiteral");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}
		if (mut != null) {
			Object mutated = mut.mutate();
			if (mutated != null) {
				AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
				}
			}
		}
		mutator = mut;
		if (mutator != null) {
			Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/nrst/Output" + k[0] + ".model";
			boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
					localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
					registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "nrst", fromNames, k,
					mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
			if (isRepeated == false) {
				numMutantsGenerated++;
				monitor.worked(1);
				k[0] = k[0] + 1;
			}
			if (muts != null) {
				muts.getMuts().clear();
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			try {
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					mutant = ModelManager.loadModel(packages, mutatorPath);
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					try {
						mutant.unload();
						mutant.load(null);
					} catch (Exception e) {
					}
				}
				if (object != null) {
					cMut.getObject().add(object);
				} else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					} else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (hmMutator.get("m5") != null) {
			cMut.setDef(hmMutator.get("m5"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_nrst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation4(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation6(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "NumberLiteral", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "tokenValue";
		((AttributeEvaluation) exp0.first).operator = "different";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("0");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation6." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("0");
					atts.add(attConfig);
					attsList.put("tokenValue", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rn0/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rn0", fromNames,
							k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true,
							false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("tokenValue");
		oldAttVal = mutator.getOldAttValue("tokenValue");
		newAttVal = mutator.getNewAttValue("tokenValue");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m6") != null) {
			attMut0.setDef(hmMutator.get("m6"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m6"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rn0(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation6(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation7(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "InfixExpression");
		rts = new RandomTypeSelection(packages, model, "InfixExpression");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "leftOperand";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "NumberLiteral").getObject();
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, resource, object);
				SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
						objectSelection.getMetaModel(), null, null, objectSelection);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
								mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
								mut.getObject(), resourceEntry);
						hmObjects.put("exp", entry);
						AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation8(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m7") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m7"));
		}
		return appMut;
	}

	private int mutation8(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects.get("exp");
			EObject recovered = ModelManager.getObject(model, entry_exp.getKey());
			if (recovered == null) {
				recovered = entry_exp.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp = hmList.get("exp");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation8." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				EObject refObjectSelected = null;
				if (hmObjects.get("exp") != null) {
					for (EReference ref : hmObjects.get("exp").getKey().eClass().getEReferences()) {
						if (ref.getName().equals("leftOperand")) {
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects
									.get("exp");
							refObjectSelected = ModelManager.getObject(resource, entry_exp.getKey());
							break;
						}
					}
				}
				if (refObjectSelected != null) {
					objsAttRef.add(refObjectSelected);
					List<AttributeConfigurationStrategy> attsRef = null;
					if (attsRefList.get("tokenValue") != null) {
						attsRef = attsRefList.get("tokenValue");
					} else {
						attsRef = new ArrayList<AttributeConfigurationStrategy>();
					}
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("1");
					attsRef.add(attConfig);
					attsRefList.put("tokenValue", attsRef);
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry8(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation9(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames, modelFilename,
							mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
							ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project,
							monitor, k, serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry8(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		appliedMutations.ReferenceAtt refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
		refMut0.setAttName("tokenValue");
		EObject refAttObject = null;
		if (mutator.getRefAttObject() != null) {
			refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());
			if (refAttObject == null) {
				refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());
			}
			if (refAttObject != null) {
				refMut0.getObject().add(refAttObject);
			}
		}
		refMut0.setRefName("leftOperand");
		Object oldRefAttVal0 = null;
		Object newRefAttVal0 = null;
		if (((ModifyInformationMutator) mut).getOldRefAttValue("tokenValue") != null) {
			oldRefAttVal0 = mutator.getOldRefAttValue("tokenValue");
		}
		if (((ModifyInformationMutator) mut).getNewRefAttValue("tokenValue") != null) {
			newRefAttVal0 = mutator.getNewRefAttValue("tokenValue");
		}
		if (oldRefAttVal0 != null) {
			refMut0.setOldVal(oldRefAttVal0.toString());
		}
		if (newRefAttVal0 != null) {
			refMut0.setNewVal(newRefAttVal0.toString());
		}
		if (hmMutator.get("m8") != null) {
			refMut0.setDef(hmMutator.get("m8"));
		}
		if (hmMutator.get("m8") != null) {
			previous = mutator.getPrevious("leftOperand");
			next = mutator.getNext("leftOperand");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m8"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m8"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	private int mutation9(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "PrefixExpression");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection9 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp_9 = hmObjects.get("exp");
		if (entry_exp_9 != null) {
			refSelection9 = new SpecificObjectSelection(packages, model, entry_exp_9.getKey(), "leftOperand");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp_9 = hmList.get("exp");
			if (listEntry_exp_9 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp_9) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection9 = new SpecificObjectSelection(packages, model, objs, "leftOperand");
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("operand", refSelection9);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "PrefixExpression");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}
		if (mut != null) {
			Object mutated = mut.mutate();
			if (mutated != null) {
				SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
						mut.getMetaModel());
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(),
						resourceEntry);
				hmObjects.put("p", entry);
				AppMutation appMut = registry9(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
				}
			}
		}
		mutator = mut;
		if (mutator != null) {
			mutation10(packages, model, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
					seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
					hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
					classes);
			numMutantsGenerated = k[0];
		}
		return numMutantsGenerated;
	}

	private AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			try {
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					mutant = ModelManager.loadModel(packages, mutatorPath);
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					try {
						mutant.unload();
						mutant.load(null);
					} catch (Exception e) {
					}
				}
				if (object != null) {
					cMut.getObject().add(object);
				} else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					} else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (hmMutator.get("m9") != null) {
			cMut.setDef(hmMutator.get("m9"));
			appMut = cMut;
		}
		return appMut;
	}

	private int mutation10(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects.get("exp");
			EObject recovered = ModelManager.getObject(model, entry_exp.getKey());
			if (recovered == null) {
				recovered = entry_exp.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp = hmList.get("exp");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation10." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("p") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("leftOperand") != null) {
							refs = refsList.get("leftOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
						EObject recovered = ModelManager.getObject(resource, entry_p.getKey());
						if (recovered == null) {
							recovered = entry_p.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "leftOperand"));
						refsList.put("leftOperand", refs);
					} else {
						return numMutantsGenerated;
					}
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry10(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rnn0/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rnn0",
							fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry10(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("leftOperand");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m10") != null) {
			previous = mutator.getPrevious("leftOperand");
			next = mutator.getNext("leftOperand");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m10"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m10"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rnn0(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation7(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation11(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "InfixExpression");
		rts = new RandomTypeSelection(packages, model, "InfixExpression");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "rightOperand";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "NumberLiteral").getObject();
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, resource, object);
				SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
						objectSelection.getMetaModel(), null, null, objectSelection);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
								mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
								mut.getObject(), resourceEntry);
						hmObjects.put("exp", entry);
						AppMutation appMut = registry11(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation12(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry11(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m11") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m11"));
		}
		return appMut;
	}

	private int mutation12(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects.get("exp");
			EObject recovered = ModelManager.getObject(model, entry_exp.getKey());
			if (recovered == null) {
				recovered = entry_exp.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp = hmList.get("exp");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation12." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				EObject refObjectSelected = null;
				if (hmObjects.get("exp") != null) {
					for (EReference ref : hmObjects.get("exp").getKey().eClass().getEReferences()) {
						if (ref.getName().equals("rightOperand")) {
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects
									.get("exp");
							refObjectSelected = ModelManager.getObject(resource, entry_exp.getKey());
							break;
						}
					}
				}
				if (refObjectSelected != null) {
					objsAttRef.add(refObjectSelected);
					List<AttributeConfigurationStrategy> attsRef = null;
					if (attsRefList.get("tokenValue") != null) {
						attsRef = attsRefList.get("tokenValue");
					} else {
						attsRef = new ArrayList<AttributeConfigurationStrategy>();
					}
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("1");
					attsRef.add(attConfig);
					attsRefList.put("tokenValue", attsRef);
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry12(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation13(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
							hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions,
							muts, project, monitor, k, serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry12(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		appliedMutations.ReferenceAtt refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
		refMut0.setAttName("tokenValue");
		EObject refAttObject = null;
		if (mutator.getRefAttObject() != null) {
			refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());
			if (refAttObject == null) {
				refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());
			}
			if (refAttObject != null) {
				refMut0.getObject().add(refAttObject);
			}
		}
		refMut0.setRefName("rightOperand");
		Object oldRefAttVal0 = null;
		Object newRefAttVal0 = null;
		if (((ModifyInformationMutator) mut).getOldRefAttValue("tokenValue") != null) {
			oldRefAttVal0 = mutator.getOldRefAttValue("tokenValue");
		}
		if (((ModifyInformationMutator) mut).getNewRefAttValue("tokenValue") != null) {
			newRefAttVal0 = mutator.getNewRefAttValue("tokenValue");
		}
		if (oldRefAttVal0 != null) {
			refMut0.setOldVal(oldRefAttVal0.toString());
		}
		if (newRefAttVal0 != null) {
			refMut0.setNewVal(newRefAttVal0.toString());
		}
		if (hmMutator.get("m12") != null) {
			refMut0.setDef(hmMutator.get("m12"));
		}
		if (hmMutator.get("m12") != null) {
			previous = mutator.getPrevious("rightOperand");
			next = mutator.getNext("rightOperand");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m12"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m12"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	private int mutation13(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "PrefixExpression");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection10 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp_10 = hmObjects.get("exp");
		if (entry_exp_10 != null) {
			refSelection10 = new SpecificObjectSelection(packages, model, entry_exp_10.getKey(), "rightOperand");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp_10 = hmList.get("exp");
			if (listEntry_exp_10 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp_10) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection10 = new SpecificObjectSelection(packages, model, objs, "rightOperand");
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("operand", refSelection10);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "PrefixExpression");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}
		if (mut != null) {
			Object mutated = mut.mutate();
			if (mutated != null) {
				SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
						mut.getMetaModel());
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(),
						resourceEntry);
				hmObjects.put("p", entry);
				AppMutation appMut = registry13(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
				}
			}
		}
		mutator = mut;
		if (mutator != null) {
			mutation14(packages, model, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
					seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
					hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
					classes);
			numMutantsGenerated = k[0];
		}
		return numMutantsGenerated;
	}

	private AppMutation registry13(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			try {
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					mutant = ModelManager.loadModel(packages, mutatorPath);
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					try {
						mutant.unload();
						mutant.load(null);
					} catch (Exception e) {
					}
				}
				if (object != null) {
					cMut.getObject().add(object);
				} else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					} else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (hmMutator.get("m13") != null) {
			cMut.setDef(hmMutator.get("m13"));
			appMut = cMut;
		}
		return appMut;
	}

	private int mutation14(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects.get("exp");
			EObject recovered = ModelManager.getObject(model, entry_exp.getKey());
			if (recovered == null) {
				recovered = entry_exp.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp = hmList.get("exp");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation14." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("p") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("rightOperand") != null) {
							refs = refsList.get("rightOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
						EObject recovered = ModelManager.getObject(resource, entry_p.getKey());
						if (recovered == null) {
							recovered = entry_p.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "rightOperand"));
						refsList.put("rightOperand", refs);
					} else {
						return numMutantsGenerated;
					}
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry14(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rnn1/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rnn1",
							fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry14(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("rightOperand");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m14") != null) {
			previous = mutator.getPrevious("rightOperand");
			next = mutator.getNext("rightOperand");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m14"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m14"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rnn1(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation11(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation15(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "ReturnStatement");
		rts = new RandomTypeSelection(packages, model, "ReturnStatement");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "expression";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "NumberLiteral").getObject();
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, resource, object);
				SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
						objectSelection.getMetaModel(), null, null, objectSelection);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
								mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
								mut.getObject(), resourceEntry);
						hmObjects.put("rt", entry);
						AppMutation appMut = registry15(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation16(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry15(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m15") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m15"));
		}
		return appMut;
	}

	private int mutation16(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("rt") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt = hmObjects.get("rt");
			EObject recovered = ModelManager.getObject(model, entry_rt.getKey());
			if (recovered == null) {
				recovered = entry_rt.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("rt") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt = hmList.get("rt");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_rt) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation16." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				EObject refObjectSelected = null;
				if (hmObjects.get("rt") != null) {
					for (EReference ref : hmObjects.get("rt").getKey().eClass().getEReferences()) {
						if (ref.getName().equals("expression")) {
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt = hmObjects.get("rt");
							refObjectSelected = ModelManager.getObject(resource, entry_rt.getKey());
							break;
						}
					}
				}
				if (refObjectSelected != null) {
					objsAttRef.add(refObjectSelected);
					List<AttributeConfigurationStrategy> attsRef = null;
					if (attsRefList.get("tokenValue") != null) {
						attsRef = attsRefList.get("tokenValue");
					} else {
						attsRef = new ArrayList<AttributeConfigurationStrategy>();
					}
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("1");
					attsRef.add(attConfig);
					attsRefList.put("tokenValue", attsRef);
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry16(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation17(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
							hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions,
							muts, project, monitor, k, serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry16(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		appliedMutations.ReferenceAtt refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
		refMut0.setAttName("tokenValue");
		EObject refAttObject = null;
		if (mutator.getRefAttObject() != null) {
			refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());
			if (refAttObject == null) {
				refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());
			}
			if (refAttObject != null) {
				refMut0.getObject().add(refAttObject);
			}
		}
		refMut0.setRefName("expression");
		Object oldRefAttVal0 = null;
		Object newRefAttVal0 = null;
		if (((ModifyInformationMutator) mut).getOldRefAttValue("tokenValue") != null) {
			oldRefAttVal0 = mutator.getOldRefAttValue("tokenValue");
		}
		if (((ModifyInformationMutator) mut).getNewRefAttValue("tokenValue") != null) {
			newRefAttVal0 = mutator.getNewRefAttValue("tokenValue");
		}
		if (oldRefAttVal0 != null) {
			refMut0.setOldVal(oldRefAttVal0.toString());
		}
		if (newRefAttVal0 != null) {
			refMut0.setNewVal(newRefAttVal0.toString());
		}
		if (hmMutator.get("m16") != null) {
			refMut0.setDef(hmMutator.get("m16"));
		}
		if (hmMutator.get("m16") != null) {
			previous = mutator.getPrevious("expression");
			next = mutator.getNext("expression");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m16"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m16"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	private int mutation17(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "PrefixExpression");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection11 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt_11 = hmObjects.get("rt");
		if (entry_rt_11 != null) {
			refSelection11 = new SpecificObjectSelection(packages, model, entry_rt_11.getKey(), "expression");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt_11 = hmList.get("rt");
			if (listEntry_rt_11 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_rt_11) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection11 = new SpecificObjectSelection(packages, model, objs, "expression");
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("operand", refSelection11);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "PrefixExpression");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}
		if (mut != null) {
			Object mutated = mut.mutate();
			if (mutated != null) {
				SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
						mut.getMetaModel());
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(),
						resourceEntry);
				hmObjects.put("p", entry);
				AppMutation appMut = registry17(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
				}
			}
		}
		mutator = mut;
		if (mutator != null) {
			mutation18(packages, model, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
					seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
					hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
					classes);
			numMutantsGenerated = k[0];
		}
		return numMutantsGenerated;
	}

	private AppMutation registry17(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			try {
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					mutant = ModelManager.loadModel(packages, mutatorPath);
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					try {
						mutant.unload();
						mutant.load(null);
					} catch (Exception e) {
					}
				}
				if (object != null) {
					cMut.getObject().add(object);
				} else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					} else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (hmMutator.get("m17") != null) {
			cMut.setDef(hmMutator.get("m17"));
			appMut = cMut;
		}
		return appMut;
	}

	private int mutation18(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("rt") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt = hmObjects.get("rt");
			EObject recovered = ModelManager.getObject(model, entry_rt.getKey());
			if (recovered == null) {
				recovered = entry_rt.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("rt") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt = hmList.get("rt");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_rt) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation18." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("p") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("expression") != null) {
							refs = refsList.get("expression");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
						EObject recovered = ModelManager.getObject(resource, entry_p.getKey());
						if (recovered == null) {
							recovered = entry_p.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "expression"));
						refsList.put("expression", refs);
					} else {
						return numMutantsGenerated;
					}
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry18(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rnn2/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rnn2",
							fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry18(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("expression");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m18") != null) {
			previous = mutator.getPrevious("expression");
			next = mutator.getNext("expression");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m18"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m18"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rnn2(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation15(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation19(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment");
		rts = new RandomTypeSelection(packages, model, "Assignment");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "rightHandSide";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "NumberLiteral").getObject();
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, resource, object);
				SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
						objectSelection.getMetaModel(), null, null, objectSelection);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
								mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
								mut.getObject(), resourceEntry);
						hmObjects.put("a", entry);
						AppMutation appMut = registry19(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation20(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry19(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m19") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m19"));
		}
		return appMut;
	}

	private int mutation20(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("a") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a = hmObjects.get("a");
			EObject recovered = ModelManager.getObject(model, entry_a.getKey());
			if (recovered == null) {
				recovered = entry_a.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("a") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a = hmList.get("a");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_a) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation20." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				EObject refObjectSelected = null;
				if (hmObjects.get("a") != null) {
					for (EReference ref : hmObjects.get("a").getKey().eClass().getEReferences()) {
						if (ref.getName().equals("rightHandSide")) {
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a = hmObjects.get("a");
							refObjectSelected = ModelManager.getObject(resource, entry_a.getKey());
							break;
						}
					}
				}
				if (refObjectSelected != null) {
					objsAttRef.add(refObjectSelected);
					List<AttributeConfigurationStrategy> attsRef = null;
					if (attsRefList.get("tokenValue") != null) {
						attsRef = attsRefList.get("tokenValue");
					} else {
						attsRef = new ArrayList<AttributeConfigurationStrategy>();
					}
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("1");
					attsRef.add(attConfig);
					attsRefList.put("tokenValue", attsRef);
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry20(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation21(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
							hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions,
							muts, project, monitor, k, serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry20(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		appliedMutations.ReferenceAtt refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
		refMut0.setAttName("tokenValue");
		EObject refAttObject = null;
		if (mutator.getRefAttObject() != null) {
			refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());
			if (refAttObject == null) {
				refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());
			}
			if (refAttObject != null) {
				refMut0.getObject().add(refAttObject);
			}
		}
		refMut0.setRefName("rightHandSide");
		Object oldRefAttVal0 = null;
		Object newRefAttVal0 = null;
		if (((ModifyInformationMutator) mut).getOldRefAttValue("tokenValue") != null) {
			oldRefAttVal0 = mutator.getOldRefAttValue("tokenValue");
		}
		if (((ModifyInformationMutator) mut).getNewRefAttValue("tokenValue") != null) {
			newRefAttVal0 = mutator.getNewRefAttValue("tokenValue");
		}
		if (oldRefAttVal0 != null) {
			refMut0.setOldVal(oldRefAttVal0.toString());
		}
		if (newRefAttVal0 != null) {
			refMut0.setNewVal(newRefAttVal0.toString());
		}
		if (hmMutator.get("m20") != null) {
			refMut0.setDef(hmMutator.get("m20"));
		}
		if (hmMutator.get("m20") != null) {
			previous = mutator.getPrevious("rightHandSide");
			next = mutator.getNext("rightHandSide");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m20"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m20"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	private int mutation21(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "PrefixExpression");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection12 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a_12 = hmObjects.get("a");
		if (entry_a_12 != null) {
			refSelection12 = new SpecificObjectSelection(packages, model, entry_a_12.getKey(), "rightHandSide");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a_12 = hmList.get("a");
			if (listEntry_a_12 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_a_12) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection12 = new SpecificObjectSelection(packages, model, objs, "rightHandSide");
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("operand", refSelection12);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "PrefixExpression");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}
		if (mut != null) {
			Object mutated = mut.mutate();
			if (mutated != null) {
				SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(),
						mut.getMetaModel());
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(),
						resourceEntry);
				hmObjects.put("p", entry);
				AppMutation appMut = registry21(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
				}
			}
		}
		mutator = mut;
		if (mutator != null) {
			mutation22(packages, model, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
					seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
					hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
					classes);
			numMutantsGenerated = k[0];
		}
		return numMutantsGenerated;
	}

	private AppMutation registry21(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			try {
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					mutant = ModelManager.loadModel(packages, mutatorPath);
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					try {
						mutant.unload();
						mutant.load(null);
					} catch (Exception e) {
					}
				}
				if (object != null) {
					cMut.getObject().add(object);
				} else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					} else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (hmMutator.get("m21") != null) {
			cMut.setDef(hmMutator.get("m21"));
			appMut = cMut;
		}
		return appMut;
	}

	private int mutation22(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("a") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a = hmObjects.get("a");
			EObject recovered = ModelManager.getObject(model, entry_a.getKey());
			if (recovered == null) {
				recovered = entry_a.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("a") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a = hmList.get("a");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_a) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		if (objectSelection != null) {
			objects.add(objectSelection.getObject());
		}
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation22." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("p") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("rightHandSide") != null) {
							refs = refsList.get("rightHandSide");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
						EObject recovered = ModelManager.getObject(resource, entry_p.getKey());
						if (recovered == null) {
							recovered = entry_p.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "rightHandSide"));
						refsList.put("rightHandSide", refs);
					} else {
						return numMutantsGenerated;
					}
				}
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry22(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rnn3/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rnn3",
							fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry22(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("rightHandSide");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m22") != null) {
			previous = mutator.getPrevious("rightHandSide");
			next = mutator.getNext("rightHandSide");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m22"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m22"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rnn3(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation19(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private int mutation23(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "StringLiteral", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "escapedValue";
		((AttributeEvaluation) exp0.first).operator = "different";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation23." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					AttributeConfigurationStrategy attConfig = null;
					attConfig = new SpecificStringConfigurationStrategy("");
					atts.add(attConfig);
					attsList.put("escapedValue", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
						obSelection.getMetaModel(), obSelection, attsList, refsList, objsAttRef, attsRefList);
				Mutator mutator = null;
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry23(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rsl/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rsl", fromNames,
							k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true,
							false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					if (muts != null) {
						muts.getMuts().clear();
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry23(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("escapedValue");
		oldAttVal = mutator.getOldAttValue("escapedValue");
		newAttVal = mutator.getNewAttValue("escapedValue");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m23") != null) {
			attMut0.setDef(hmMutator.get("m23"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m23"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_rsl(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4Java/data/model/java.ecore";
		String modelURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile, modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
						}
					} else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI
									+ files[i].getName().substring(0, files[i].getName().length() - ".model".length())
									+ "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName()
													.substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName()
													.substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
										}
									} else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(),
												hashmapModelFilenames, hashmapModelFolders, seedModelFilenames,
												modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			hashsetMutantsBlock = new LinkedHashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaDLM.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation23(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize,
					test, classes);
			numMutantsGenerated = k[0];
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			try {
				model.unload();
				seed.unload();
			} catch (Exception e) {
			}
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	@Override
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project,
			IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		MutationResults mutationResults = new MutationResults();
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 10;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		monitor.beginTask("Generating mutants", totalTasks);
		Map<String, Set<String>> hashmapMutants = new LinkedHashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();
		List<String> fromNames = null;
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("bt") == true)) {
			monitor.subTask("Generating mutants for block bt (1/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_bt(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("bt");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("bf") == true)) {
			monitor.subTask("Generating mutants for block bf (2/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_bf(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("bf");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rnl") == true)) {
			monitor.subTask("Generating mutants for block rnl (3/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rnl(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rnl");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("nrst") == true)) {
			monitor.subTask("Generating mutants for block nrst (4/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_nrst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("nrst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rn0") == true)) {
			monitor.subTask("Generating mutants for block rn0 (5/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rn0(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rn0");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rnn0") == true)) {
			monitor.subTask("Generating mutants for block rnn0 (6/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rnn0(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rnn0");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rnn1") == true)) {
			monitor.subTask("Generating mutants for block rnn1 (7/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rnn1(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rnn1");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rnn2") == true)) {
			monitor.subTask("Generating mutants for block rnn2 (8/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rnn2(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rnn2");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rnn3") == true)) {
			monitor.subTask("Generating mutants for block rnn3 (9/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rnn3(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rnn3");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rsl") == true)) {
			monitor.subTask("Generating mutants for block rsl (10/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rsl(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rsl");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "model/MutatorMetrics.ecore";
		metricsecore = metricsecore.substring(1, metricsecore.length());
		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testJavaDLMDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaDLMDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testJavaDLMDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaDLMDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaDLMDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
