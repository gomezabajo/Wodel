package mutator.testJavaASODynamic;

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

public class testJavaASODynamic extends MutatorUtils {
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("-=");
		((AttributeEvaluation) exp0.first).values.add("*=");
		((AttributeEvaluation) exp0.first).values.add("/=");
		((AttributeEvaluation) exp0.first).values.add("%=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("+=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsp/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsp",
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
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

	public int block_asrsp(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("+=");
		((AttributeEvaluation) exp0.first).values.add("*=");
		((AttributeEvaluation) exp0.first).values.add("/=");
		((AttributeEvaluation) exp0.first).values.add("%=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("-=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsm/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsm",
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
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

	public int block_asrsm(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("+=");
		((AttributeEvaluation) exp0.first).values.add("-=");
		((AttributeEvaluation) exp0.first).values.add("/=");
		((AttributeEvaluation) exp0.first).values.add("%=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("*=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrst/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrst",
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
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

	public int block_asrst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("+=");
		((AttributeEvaluation) exp0.first).values.add("-=");
		((AttributeEvaluation) exp0.first).values.add("*=");
		((AttributeEvaluation) exp0.first).values.add("%=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation4." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("/=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsd/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsd",
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

	private AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m4") != null) {
			attMut0.setDef(hmMutator.get("m4"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m4"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrsd(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("+=");
		((AttributeEvaluation) exp0.first).values.add("-=");
		((AttributeEvaluation) exp0.first).values.add("*=");
		((AttributeEvaluation) exp0.first).values.add("/=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation5." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("%=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsr/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsr",
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

	private AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m5") != null) {
			attMut0.setDef(hmMutator.get("m5"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m5"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrsr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
			mutation5(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("|=");
		((AttributeEvaluation) exp0.first).values.add("^=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("&=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsa/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsa",
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
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

	public int block_asrsa(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("&=");
		((AttributeEvaluation) exp0.first).values.add("^=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation7." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("|=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrso/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrso",
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

	private AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m7") != null) {
			attMut0.setDef(hmMutator.get("m7"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m7"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrso(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("&=");
		((AttributeEvaluation) exp0.first).values.add("|=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation8." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("^=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry8(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrsx/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrsx",
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

	private AppMutation registry8(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m8") != null) {
			attMut0.setDef(hmMutator.get("m8"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m8"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrsx(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
			mutation8(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(">>>=");
		((AttributeEvaluation) exp0.first).values.add("<<=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation9." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy(">>=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry9(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrssr/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrssr",
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

	private AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m9") != null) {
			attMut0.setDef(hmMutator.get("m9"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m9"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrssr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
			mutation9(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(">>=");
		((AttributeEvaluation) exp0.first).values.add("<<=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation10." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy(">>>=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry10(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrssrr/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrssrr",
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
		EList<AttributeChanged> attsMut = icMut.getAttChanges();
		Object oldAttVal = null;
		Object newAttVal = null;
		AttributeChanged attMut0 = null;
		attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m10") != null) {
			attMut0.setDef(hmMutator.get("m10"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m10"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrssrr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
			mutation10(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Assignment", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operator";
		((AttributeEvaluation) exp0.first).operator = "in";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(">>=");
		((AttributeEvaluation) exp0.first).values.add(">>>=");
		((AttributeEvaluation) exp0.first).type = "String";
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		Operator op1_0 = new Operator();
		op1_0.type = "and";
		exp0.operator.add(op1_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "leftHandSide";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
		ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
		ev1_0.name = "rightHandSide";
		ev1_0.refName = null;
		ev1_0.attName = null;
		ev1_0.operator = "different";
		ev1_0.value = null;
		exp0.second.add(ev1_0);
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
							.replace(".model", ".mutation11." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificStringConfigurationStrategy("<<=");
					atts.add(attConfig);
					attsList.put("operator", atts);
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
						AppMutation appMut = registry11(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/asrssl/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "asrssl",
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

	private AppMutation registry11(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("operator");
		oldAttVal = mutator.getOldAttValue("operator");
		newAttVal = mutator.getNewAttValue("operator");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m11") != null) {
			attMut0.setDef(hmMutator.get("m11"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m11"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_asrssl(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaASO.model";
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
		int totalTasks = 11;
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsp") == true)) {
			monitor.subTask("Generating mutants for block asrsp (1/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsp(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsp");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsm") == true)) {
			monitor.subTask("Generating mutants for block asrsm (2/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsm(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsm");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrst") == true)) {
			monitor.subTask("Generating mutants for block asrst (3/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsd") == true)) {
			monitor.subTask("Generating mutants for block asrsd (4/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsd(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsd");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsr") == true)) {
			monitor.subTask("Generating mutants for block asrsr (5/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsa") == true)) {
			monitor.subTask("Generating mutants for block asrsa (6/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsa(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsa");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrso") == true)) {
			monitor.subTask("Generating mutants for block asrso (7/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrso(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrso");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrsx") == true)) {
			monitor.subTask("Generating mutants for block asrsx (8/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrsx(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrsx");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrssr") == true)) {
			monitor.subTask("Generating mutants for block asrssr (9/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrssr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrssr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrssrr") == true)) {
			monitor.subTask("Generating mutants for block asrssrr (10/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrssrr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrssrr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("asrssl") == true)) {
			monitor.subTask("Generating mutants for block asrssl (11/11)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_asrssl(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("asrssl");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testJavaASODynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaASODynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testJavaASODynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaASODynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaASODynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
