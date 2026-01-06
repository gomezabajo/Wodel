package mutator.testFA1Standalone;

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

public class testFA1Standalone extends MutatorUtils {
	private static Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	private static List<EObject> mutatedObjects = null;

	private static List<Mutator> mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "State");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificBooleanConfigurationStrategy(true);
		;
		atts.put("isFinal", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "State");
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m1") != null) {
			cMut.setDef(hmMutator.get("m1"));
			appMut = cMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation2(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Transition");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection1 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_s_1 = hmObjects.get("s");
		if (entry_s_1 != null) {
			refSelection1 = new SpecificObjectSelection(packages, model, entry_s_1.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_s_1 = hmList.get("s");
			if (listEntry_s_1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_s_1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection1 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return mutations;
			}
		}
		refs.put("tar", refSelection1);
		RandomTypeSelection refRts2 = new RandomTypeSelection(packages, model, "Symbol");
		EObject refObject2 = refRts2.getObject();
		ObSelectionStrategy refSelection2 = null;
		if (refObject2 != null) {
			refSelection2 = new SpecificObjectSelection(packages, model, refObject2);
		}
		refs.put("symbol", refSelection2);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Transition");
		if (mut != null) {
			mut.setId("m2");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m2") != null) {
			cMut.setDef(hmMutator.get("m2"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_cfs(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cfs/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/cfs/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> ls1 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ls1 != null) {
							for (Mutator mut : ls1) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("s", entry);
										}
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_1.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry1(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l2 = mutation2(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l2 != null) {
							for (Mutator mut : l2) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_2.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cfs", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation3(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "State");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new RandomStringConfigurationStrategy(1, 4, false);
		;
		atts.put("name", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "State");
		if (mut != null) {
			mut.setId("m3");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m3") != null) {
			cMut.setDef(hmMutator.get("m3"));
			appMut = cMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Transition");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection3 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_s_3 = hmObjects.get("s");
		if (entry_s_3 != null) {
			refSelection3 = new SpecificObjectSelection(packages, model, entry_s_3.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_s_3 = hmList.get("s");
			if (listEntry_s_3 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_s_3) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection3 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return mutations;
			}
		}
		refs.put("tar", refSelection3);
		RandomTypeSelection refRts4 = new RandomTypeSelection(packages, model, "Symbol");
		EObject refObject4 = refRts4.getObject();
		ObSelectionStrategy refSelection4 = null;
		if (refObject4 != null) {
			refSelection4 = new SpecificObjectSelection(packages, model, refObject4);
		}
		refs.put("symbol", refSelection4);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Transition");
		if (mut != null) {
			mut.setId("m4");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m4") != null) {
			cMut.setDef(hmMutator.get("m4"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_ccs(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/ccs/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/ccs/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> ls3 = mutation3(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ls3 != null) {
							for (Mutator mut : ls3) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("s", entry);
										}
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_3.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lt4 = mutation4(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lt4 != null) {
							for (Mutator mut : lt4) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("t", entry);
										}
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_4.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "ccs", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("Transition");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		RemoveObjectMutator mut = null;
		if (objectSelection != null) {
			if (mutatedObjects != null) {
				mutatedObjects.add(objectSelection.getObject());
			}
			mut = new RemoveObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection,
					referenceSelection, containerSelection);
		}
		if (mut != null) {
			mut.setId("m5");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m5") != null) {
			rMut.setDef(hmMutator.get("m5"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dtr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dtr/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/dtr/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l5 = mutation5(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l5 != null) {
							for (Mutator mut : l5) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_5.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dtr", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation6(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("State");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "isInitial";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(false);
		((AttributeEvaluation) exp0.first).type = "Boolean";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		RemoveObjectMutator mut = null;
		if (objectSelection != null) {
			if (mutatedObjects != null) {
				mutatedObjects.add(objectSelection.getObject());
			}
			mut = new RemoveObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection,
					referenceSelection, containerSelection);
		}
		if (mut != null) {
			mut.setId("m6");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m6") != null) {
			rMut.setDef(hmMutator.get("m6"));
			appMut = rMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation7(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("Transition");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "src";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
		objects = selectedObjects;
		if (objects != null) {
			for (EObject obj : objects) {
				if (mutatedObjects != null) {
					mutatedObjects.add(obj);
				}
				RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection,
						containerSelection);
				if (mut != null) {
					mut.setId("m7");
					mutations.add(mut);
				}
			}
		}
		return mutations;
	}

	private static AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m7") != null) {
			rMut.setDef(hmMutator.get("m7"));
			appMut = rMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation8(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("Transition");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "tar";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
		objects = selectedObjects;
		if (objects != null) {
			for (EObject obj : objects) {
				if (mutatedObjects != null) {
					mutatedObjects.add(obj);
				}
				RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection,
						containerSelection);
				if (mut != null) {
					mut.setId("m8");
					mutations.add(mut);
				}
			}
		}
		return mutations;
	}

	private static AppMutation registry8(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m8") != null) {
			rMut.setDef(hmMutator.get("m8"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dst/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/dst/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l6 = mutation6(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l6 != null) {
							for (Mutator mut : l6) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_6.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l7 = mutation7(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l7 != null) {
							for (Mutator mut : l7) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_7.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l8 = mutation8(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l8 != null) {
							for (Mutator mut : l8) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_8.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry8(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dst", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation9(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "Transition");
		EObject otherSourceSelection = null;
		otherSourceSelection = sourceSelection.getObject();
		Object otherRef = null;
		if (otherSourceSelection != null) {
			for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {
				if (ref.getName().equals("symbol")) {
					otherRef = otherSourceSelection.eGet(ref);
					break;
				}
			}
		}
		OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, "Symbol", otherRef);
		if (sourceSelection == null) {
			return mutations;
		}
		EObject source = sourceSelection.getObject();
		if (source == null) {
			return mutations;
		}
		if (newTargetSelection == null) {
			return mutations;
		}
		EObject target = newTargetSelection.getObject();
		if (target == null) {
			return mutations;
		}
		EObject previous = source.eContainer();
		while (previous != null && !EcoreUtil.equals(previous, target)) {
			previous = previous.eContainer();
		}
		if (!EcoreUtil.equals(previous, target)) {
			ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(),
					sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "symbol");
			if (mut != null) {
				mut.setId("m9");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private static AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		ModifyTargetReferenceMutator mutator = (ModifyTargetReferenceMutator) mut;
		Resource mutant = mutator.getModel();
		EObject object = ModelManager.getObject(seed, mutator.getObject());
		if (object == null) {
			object = ModelManager.getObject(mutant, mutator.getObject());
		}
		if (object != null) {
			trcMut.getObject().add(object);
		}
		EObject from = ModelManager.getObject(seed, mutator.getSource());
		if (from == null) {
			from = ModelManager.getObject(mutant, mutator.getSource());
		}
		if (from != null) {
			trcMut.setFrom(from);
		}
		trcMut.setSrcRefName(mutator.getSrcRefType());
		EObject to = ModelManager.getObject(seed, mutator.getNewTarget());
		if (to == null) {
			to = ModelManager.getObject(mutant, mutator.getNewTarget());
		}
		if (to != null) {
			trcMut.setTo(to);
		}
		EObject oldTo = ModelManager.getObjectByURIEnding(seed, mutator.getOldTargetURI());
		if (oldTo == null) {
			oldTo = ModelManager.getObjectByURIEnding(mutant, mutator.getOldTargetURI());
		}
		if (oldTo != null) {
			trcMut.setOldTo(oldTo);
		}
		trcMut.setRefName(mutator.getRefType());
		if (hmMutator.get("m9") != null) {
			trcMut.setDef(hmMutator.get("m9"));
			appMut = trcMut;
		}
		return appMut;
	}

	public int block_mst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/mst/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/mst/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l9 = mutation9(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l9 != null) {
							for (Mutator mut : l9) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_9.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry9(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "mst", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation10(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "isFinal";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(true);
		((AttributeEvaluation) exp0.first).type = "Boolean";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		if (objectSelection != null) {
			List<AttributeConfigurationStrategy> atts = null;
			if (attsList.get("isFinal") != null) {
				atts = attsList.get("isFinal");
			} else {
				atts = new ArrayList<AttributeConfigurationStrategy>();
			}
			AttributeConfigurationStrategy attConfig = new ReverseBooleanConfigurationStrategy("isFinal");
			atts.add(attConfig);
			attsList.put("isFinal", atts);
		}
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null) {
			if (mutatedObjects != null) {
				mutatedObjects.add(objectSelection.getObject());
			}
			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(),
					objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
			if (mut != null) {
				mut.setId("m10");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private static AppMutation registry10(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
		attMut0.setAttName("isFinal");
		oldAttVal = mutator.getOldAttValue("isFinal");
		newAttVal = mutator.getNewAttValue("isFinal");
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

	public int block_mfs(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/mfs/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/mfs/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l10 = mutation10(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l10 != null) {
							for (Mutator mut : l10) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_10.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry10(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "mfs", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation11(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		}
		SelectObjectMutator mut = null;
		if (objectSelection != null) {
			mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(),
					referenceSelection, containerSelection, objectSelection);
		}
		if (mut != null) {
			mut.setId("m11");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry11(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m11") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m11"));
		}
		return appMut;
	}

	private static List<Mutator> mutation12(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("t");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "src";
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("t");
		if (entry0_0 != null) {
			EObject srcObjExp0_0 = entry0_0.getKey();
			for (EReference ref : srcObjExp0_0.eClass().getEAllReferences()) {
				if (ref.getName().equals("src")) {
					ev0_0.value = srcObjExp0_0.eGet(ref);
				}
			}
		}
		exp0.second.add(ev0_0);
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("t") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("symbol") != null) {
					refs = refsList.get("symbol");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_t = hmObjects.get("t");
				refs.add(new SwapReferenceConfigurationStrategy(objectSelection.getObject(), entry_t.getKey(), "symbol",
						"symbol"));
				refsList.put("symbol", refs);
			} else {
				return mutations;
			}
		}
		if (objectSelection != null) {
			if (mutatedObjects != null) {
				mutatedObjects.add(objectSelection.getObject());
			}
			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(),
					objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
			if (mut != null) {
				mut.setId("m12");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private static AppMutation registry12(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
		Resource mutant = mutator.getModel();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		appliedMutations.ReferenceSwap refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();
		refMut0.setFirstName("symbol");
		EObject refObject = null;
		if (mutator.getRefObject() != null) {
			refObject = ModelManager.getObject(seed, mutator.getRefObject());
			if (refObject == null) {
				refObject = ModelManager.getObject(mutant, mutator.getRefObject());
			}
			if (refObject != null) {
				refMut0.setRefObject(refObject);
			}
		}
		refMut0.setRefName("symbol");
		refMut0.setOtherFrom(mutator.getOtherSource("symbol"));
		refMut0.setOtherFromName(mutator.getOtherSourceName("symbol"));
		refMut0.setOtherTo(mutator.getOtherTarget("symbol"));
		refMut0.setOtherToName(mutator.getOtherTargetName("symbol"));
		if (hmMutator.get("m12") != null) {
			previous = mutator.getPrevious("symbol");
			next = mutator.getNext("symbol");
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

	public int block_sst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/sst/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/sst/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lt11 = mutation11(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lt11 != null) {
							for (Mutator mut : lt11) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("t", entry);
										}
										AppMutation appMut = registry11(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l12 = mutation12(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l12 != null) {
							for (Mutator mut : l12) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_12.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry12(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "sst", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation13(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "State");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("f");
		;
		atts.put("name", attConfig);
		attConfig = new SpecificBooleanConfigurationStrategy(true);
		;
		atts.put("isFinal", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "State");
		if (mut != null) {
			mut.setId("m13");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry13(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m13") != null) {
			cMut.setDef(hmMutator.get("m13"));
			appMut = cMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation14(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "Transition");
		SpecificObjectSelection newTargetSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_s = hmObjects.get("s");
		if (entry_s != null) {
			newTargetSelection = new SpecificObjectSelection(entry_s.getValue().getValue(), entry_s.getValue().getKey(),
					entry_s.getKey());
		} else {
			return mutations;
		}
		if (sourceSelection == null) {
			return mutations;
		}
		EObject source = sourceSelection.getObject();
		if (source == null) {
			return mutations;
		}
		if (newTargetSelection == null) {
			return mutations;
		}
		EObject target = newTargetSelection.getObject();
		if (target == null) {
			return mutations;
		}
		EObject previous = source.eContainer();
		while (previous != null && !EcoreUtil.equals(previous, target)) {
			previous = previous.eContainer();
		}
		if (!EcoreUtil.equals(previous, target)) {
			ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(),
					sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "tar");
			if (mut != null) {
				mut.setId("m14");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private static AppMutation registry14(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		ModifyTargetReferenceMutator mutator = (ModifyTargetReferenceMutator) mut;
		Resource mutant = mutator.getModel();
		EObject object = ModelManager.getObject(seed, mutator.getObject());
		if (object == null) {
			object = ModelManager.getObject(mutant, mutator.getObject());
		}
		if (object != null) {
			trcMut.getObject().add(object);
		}
		EObject from = ModelManager.getObject(seed, mutator.getSource());
		if (from == null) {
			from = ModelManager.getObject(mutant, mutator.getSource());
		}
		if (from != null) {
			trcMut.setFrom(from);
		}
		trcMut.setSrcRefName(mutator.getSrcRefType());
		EObject to = ModelManager.getObject(seed, mutator.getNewTarget());
		if (to == null) {
			to = ModelManager.getObject(mutant, mutator.getNewTarget());
		}
		if (to != null) {
			trcMut.setTo(to);
		}
		EObject oldTo = ModelManager.getObjectByURIEnding(seed, mutator.getOldTargetURI());
		if (oldTo == null) {
			oldTo = ModelManager.getObjectByURIEnding(mutant, mutator.getOldTargetURI());
		}
		if (oldTo != null) {
			trcMut.setOldTo(oldTo);
		}
		trcMut.setRefName(mutator.getRefType());
		if (hmMutator.get("m14") != null) {
			trcMut.setDef(hmMutator.get("m14"));
			appMut = trcMut;
		}
		return appMut;
	}

	public int block_rts(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rts/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/rts/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> ls13 = mutation13(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ls13 != null) {
							for (Mutator mut : ls13) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("s", entry);
										}
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_13.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry13(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l14 = mutation14(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l14 != null) {
							for (Mutator mut : l14) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_14.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry14(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rts", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation15(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Transition");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Transition");
		if (mut != null) {
			mut.setId("m15");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry15(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m15") != null) {
			cMut.setDef(hmMutator.get("m15"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_clt(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/clt/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/clt/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l15 = mutation15(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l15 != null) {
							for (Mutator mut : l15) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_15.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry15(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "clt", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	private static List<Mutator> mutation16(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "symbol";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		}
		SelectObjectMutator mut = null;
		if (objectSelection != null) {
			mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(),
					referenceSelection, containerSelection, objectSelection);
		}
		if (mut != null) {
			mut.setId("m16");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry16(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m16") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m16"));
		}
		return appMut;
	}

	private static List<Mutator> mutation17(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Transition");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection5 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_t_5 = hmObjects.get("t");
		if (entry_t_5 != null) {
			refSelection5 = new SpecificObjectSelection(packages, model, entry_t_5.getKey(), "src");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_t_5 = hmList.get("t");
			if (listEntry_t_5 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_t_5) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection5 = new SpecificObjectSelection(packages, model, objs, "src");
			} else {
				return mutations;
			}
		}
		refs.put("src", refSelection5);
		ObSelectionStrategy refSelection6 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_t_6 = hmObjects.get("t");
		if (entry_t_6 != null) {
			refSelection6 = new SpecificObjectSelection(packages, model, entry_t_6.getKey(), "symbol");
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_t_6 = hmList.get("t");
			if (listEntry_t_6 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_t_6) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection6 = new SpecificObjectSelection(packages, model, objs, "symbol");
			} else {
				return mutations;
			}
		}
		refs.put("symbol", refSelection6);
		RandomTypeSelection refRts7 = new RandomTypeSelection(packages, model, "State");
		List<EObject> refObjects7 = refRts7.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("t");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("tar")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> refSelectedObjects7 = evaluate(refObjects7, exp0);
		EObject refObject7 = null;
		if (refSelectedObjects7.size() > 0) {
			refObject7 = refSelectedObjects7.get(ModelManager.getRandomIndex(refSelectedObjects7));
		}
		ObSelectionStrategy refSelection7 = null;
		if (refObject7 != null) {
			refSelection7 = new SpecificObjectSelection(packages, model, refObject7);
		}
		refs.put("tar", refSelection7);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Transition");
		if (mut != null) {
			mut.setId("m17");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry17(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModelNoException(packages, mutatorPath);
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
		}
		if (hmMutator.get("m17") != null) {
			cMut.setDef(hmMutator.get("m17"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_cst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/WodelTest4FA/data/model/DFAAutomaton.ecore";
		String modelURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 10;
			String xmiFilename = testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testFA1.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cst/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/cst/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModelNoException(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lt16 = mutation16(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lt16 != null) {
							for (Mutator mut : lt16) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("t", entry);
										}
										AppMutation appMut = registry16(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l17 = mutation17(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l17 != null) {
							for (Mutator mut : l17) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_17.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
										}
										AppMutation appMut = registry17(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
							}
						}
					}
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cst", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "WodelTest4FA", serialize, test, classes,
							testFA1Standalone.class, true, false);
					if (isRepeated == false) {
						numMutantsGenerated++;
						k[0] = k[0] + 1;
					}
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
			}
			hashmapMutants.put(modelFilename, hashsetMutantsBlock);
			mutatedObjects = null;
		}
		return numMutantsGenerated;
	}

	@Override
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cfs") == true)) {
			monitor.subTask("Generating mutants for block cfs (1/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cfs(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cfs");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("ccs") == true)) {
			monitor.subTask("Generating mutants for block ccs (2/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_ccs(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("ccs");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dtr") == true)) {
			monitor.subTask("Generating mutants for block dtr (3/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dtr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dtr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dst") == true)) {
			monitor.subTask("Generating mutants for block dst (4/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("mst") == true)) {
			monitor.subTask("Generating mutants for block mst (5/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_mst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("mst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("mfs") == true)) {
			monitor.subTask("Generating mutants for block mfs (6/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_mfs(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("mfs");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("sst") == true)) {
			monitor.subTask("Generating mutants for block sst (7/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_sst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("sst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rts") == true)) {
			monitor.subTask("Generating mutants for block rts (8/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rts(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rts");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("clt") == true)) {
			monitor.subTask("Generating mutants for block clt (9/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_clt(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("clt");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cst") == true)) {
			monitor.subTask("Generating mutants for block cst (10/10)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cst");
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
			metricsGenerator = new NetMutatorMetricsGenerator(
					metricspackages, testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation()
							.getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4FA/data/model/DFAAutomaton.ecore",
					testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "data/model/",
					"testFA1.mutator", hashmapMutVersions, testFA1Standalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(
					metricspackages, testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation()
							.getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4FA/data/model/DFAAutomaton.ecore",
					testFA1Standalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "data/model/",
					"testFA1.mutator", hashmapMutVersions, testFA1Standalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
