package mutator.testBotGeneratorDynamic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

public class testBotGeneratorDynamic extends MutatorUtils {
	private Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	private List<EObject> mutatedObjects = null;

	private int mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		List<EObject> objects = rts.getObjects();
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("tpi", entry);
						AppMutation appMut = registry1(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation2(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m1") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m1"));
		}
		return appMut;
	}

	private int mutation2(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
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
						hmObjects.put("i", entry);
						AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation3(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m2") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m2"));
		}
		return appMut;
	}

	private int mutation3(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i = hmObjects.get("i");
		if (entry_i != null) {
			EObject recovered = ModelManager.getObject(model, entry_i.getKey());
			if (recovered == null) {
				recovered = entry_i.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li", entry);
							AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation4(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
								hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project,
								monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m3") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m3"));
		}
		return appMut;
	}

	private int mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "inputs", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "TrainingPhrase", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("max1")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation4." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"inputs", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dp_max/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dp_max",
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
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m4") != null) {
			rMut.setDef(hmMutator.get("m4"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dp_max(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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

	private int mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		List<EObject> objects = rts.getObjects();
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("tpi", entry);
						AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation6(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m5") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m5"));
		}
		return appMut;
	}

	private int mutation6(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
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
						hmObjects.put("i", entry);
						AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation7(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m6") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m6"));
		}
		return appMut;
	}

	private int mutation7(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i = hmObjects.get("i");
		if (entry_i != null) {
			EObject recovered = ModelManager.getObject(model, entry_i.getKey());
			if (recovered == null) {
				recovered = entry_i.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li", entry);
							AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation8(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
								hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project,
								monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "inputs", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "TrainingPhrase", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("min1")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation8." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"inputs", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dp_min/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dp_min",
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

	public int block_dp_min(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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

	private int mutation9(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter");
		rts = new RandomTypeSelection(packages, model, "Parameter");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "required";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(true);
		((AttributeEvaluation) exp0.first).type = "Boolean";
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
						hmObjects.put("p", entry);
						AppMutation appMut = registry9(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation10(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m9") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m9"));
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "TrainingPhrase", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "tokens";
		((ReferenceEvaluation) exp0.first).refName = "parameter";
		((ReferenceEvaluation) exp0.first).refRefName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("p");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
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
				mutator = mut;
			}
			if (mutator != null) {
				mutation11(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames, modelFilename,
						mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
						ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor,
						k, serialize, test, classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry10(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m10") != null) {
			rMut.setDef(hmMutator.get("m10"));
			appMut = rMut;
		}
		return appMut;
	}

	private int mutation11(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "LanguageIntent", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
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
				mutator = mut;
			}
			if (mutator != null) {
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dpwp/Output" + k[0] + ".model";
				boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
						localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
						registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dpwp", fromNames, k,
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
		}
		return numMutantsGenerated;
	}

	private AppMutation registry11(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m11") != null) {
			rMut.setDef(hmMutator.get("m11"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dpwp(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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

	private int mutation12(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "SimpleInput");
		rts = new RandomTypeSelection(packages, model, "SimpleInput");
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
						hmObjects.put("input", entry);
						AppMutation appMut = registry12(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation13(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry12(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m12") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m12"));
		}
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "ParameterReferenceToken");
		rts = new RandomTypeSelection(packages, model, "ParameterReferenceToken");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "textReference";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.addAll(ModelManager.getStringAttributes("values",
				hmObjects.get("input") != null ? hmObjects.get("input").getKey() : null));
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
						hmObjects.put("prt", entry);
						AppMutation appMut = registry13(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation14(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry13(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m13") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m13"));
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "TrainingPhrase", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "tokens";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("prt");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
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
				mutator = mut;
			}
			if (mutator != null) {
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dpwl/Output" + k[0] + ".model";
				boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
						localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
						registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dpwl", fromNames, k,
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
		}
		return numMutantsGenerated;
	}

	private AppMutation registry14(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m14") != null) {
			rMut.setDef(hmMutator.get("m14"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dpwl(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation12(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		List<EObject> objects = rts.getObjects();
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("tpi", entry);
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
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
						hmObjects.put("i", entry);
						AppMutation appMut = registry16(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation17(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry16(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m16") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m16"));
		}
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i = hmObjects.get("i");
		if (entry_i != null) {
			EObject recovered = ModelManager.getObject(model, entry_i.getKey());
			if (recovered == null) {
				recovered = entry_i.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li", entry);
							AppMutation appMut = registry17(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation18(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry17(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m17") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m17"));
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("max1")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp0", entry);
							AppMutation appMut = registry18(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation19(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry18(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m18") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m18"));
		}
		return appMut;
	}

	private int mutation19(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("max2")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
			exp0.operator = new ArrayList<Operator>();
			Operator op0_0 = new Operator();
			op0_0.type = "and";
			exp0.operator.add(op0_0);
			exp0.second = new ArrayList<Evaluation>();
			ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
			ev0_0.name = null;
			ev0_0.container = false;
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp0");
			if (entry0_0 != null) {
				ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
						entry0_0.getKey()).getObject();
			}
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp1", entry);
							AppMutation appMut = registry19(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation20(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp0");
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
			ev0_0.name = null;
			ev0_0.container = false;
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp1");
			if (entry0_0 != null) {
				ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
						entry0_0.getKey()).getObject();
			}
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp2", entry);
							AppMutation appMut = registry20(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation21(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry20(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m20") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m20"));
		}
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
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "inputs", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "TrainingPhrase", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp0");
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
		ev0_0.name = null;
		ev0_0.container = false;
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp1");
		if (entry0_0 != null) {
			ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
					entry0_0.getKey()).getObject();
		}
		exp0.second.add(ev0_0);
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry21(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/k2p_max/Output" + k[0] + ".model";
				boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
						localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
						registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "k2p_max", fromNames,
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
		return numMutantsGenerated;
	}

	private AppMutation registry21(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m21") != null) {
			rMut.setDef(hmMutator.get("m21"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_k2p_max(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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

	private int mutation22(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentValue");
		List<EObject> objects = rts.getObjects();
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("tpi", entry);
						AppMutation appMut = registry22(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation23(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry22(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m22") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m22"));
		}
		return appMut;
	}

	private int mutation23(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
		if (entry_0 != null) {
			EObject srcObjExp = entry_0.getKey();
			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent")) {
					((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
				}
			}
		}
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
						hmObjects.put("i", entry);
						AppMutation appMut = registry23(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation24(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry23(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m23") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m23"));
		}
		return appMut;
	}

	private int mutation24(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i = hmObjects.get("i");
		if (entry_i != null) {
			EObject recovered = ModelManager.getObject(model, entry_i.getKey());
			if (recovered == null) {
				recovered = entry_i.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i = hmList.get("i");
			if (listEntry_i != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li", entry);
							AppMutation appMut = registry24(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation25(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry24(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m24") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m24"));
		}
		return appMut;
	}

	private int mutation25(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("min1")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp0", entry);
							AppMutation appMut = registry25(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation26(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry25(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m25") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m25"));
		}
		return appMut;
	}

	private int mutation26(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tpi");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("min2")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
			exp0.operator = new ArrayList<Operator>();
			Operator op0_0 = new Operator();
			op0_0.type = "and";
			exp0.operator.add(op0_0);
			exp0.second = new ArrayList<Evaluation>();
			ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
			ev0_0.name = null;
			ev0_0.container = false;
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp0");
			if (entry0_0 != null) {
				ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
						entry0_0.getKey()).getObject();
			}
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp1", entry);
							AppMutation appMut = registry26(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation27(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry26(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m26") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m26"));
		}
		return appMut;
	}

	private int mutation27(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li = hmList.get("li");
			if (listEntry_li != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp0");
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
			ev0_0.name = null;
			ev0_0.container = false;
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp1");
			if (entry0_0 != null) {
				ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
						entry0_0.getKey()).getObject();
			}
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp2", entry);
							AppMutation appMut = registry27(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation28(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry27(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m27") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m27"));
		}
		return appMut;
	}

	private int mutation28(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li = hmObjects.get("li");
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_li != null) {
			EObject recovered = ModelManager.getObject(model, entry_li.getKey());
			if (recovered == null) {
				recovered = entry_li.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "inputs", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "TrainingPhrase", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp0");
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
		ev0_0.name = null;
		ev0_0.container = false;
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("tp1");
		if (entry0_0 != null) {
			ev0_0.value = new SpecificObjectSelection(entry0_0.getValue().getValue(), entry0_0.getValue().getKey(),
					entry0_0.getKey()).getObject();
		}
		exp0.second.add(ev0_0);
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry28(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/k2p_min/Output" + k[0] + ".model";
				boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
						localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
						registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "k2p_min", fromNames,
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
		return numMutantsGenerated;
	}

	private AppMutation registry28(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m28") != null) {
			rMut.setDef(hmMutator.get("m28"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_k2p_min(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation22(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation29(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
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
						hmObjects.put("i1", entry);
						AppMutation appMut = registry29(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation30(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry29(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m29") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m29"));
		}
		return appMut;
	}

	private int mutation30(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentIntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentIntentValue");
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "intent1";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("i1");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		AttributeEvaluation ev0_0 = new AttributeEvaluation();
		ev0_0.name = "max1Value";
		ev0_0.operator = "equals";
		ev0_0.values = new ArrayList<Object>();
		Expression auxExp0 = new Expression();
		auxExp0.first = exp0.first;
		auxExp0.operator = new ArrayList<Operator>();
		List<EObject> auxObjects = evaluate(objects, auxExp0);
		MaxValueConfigurationStrategy max0_0 = new MaxValueConfigurationStrategy(packages, resources,
				"IntentIntentValue", auxObjects, "max1Value");
		((AttributeEvaluation) ev0_0).values.add(max0_0.getValue());
		exp0.second.add(ev0_0);
		objects = evaluate(objects, exp0);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("iiv", entry);
						AppMutation appMut = registry30(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation31(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry30(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m30") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m30"));
		}
		return appMut;
	}

	private int mutation31(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = null;
		ev0_0.container = false;
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("iiv");
		if (entry0_0 != null) {
			EObject srcObjExp0_0 = entry0_0.getKey();
			for (EReference ref : srcObjExp0_0.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent2")) {
					ev0_0.value = srcObjExp0_0.eGet(ref);
				}
			}
		}
		exp0.second.add(ev0_0);
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
						hmObjects.put("i2", entry);
						AppMutation appMut = registry31(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation32(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry31(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m31") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m31"));
		}
		return appMut;
	}

	private int mutation32(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i1 = hmObjects.get("i1");
		if (entry_i1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_i1.getKey());
			if (recovered == null) {
				recovered = entry_i1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i1 = hmList.get("i1");
			if (listEntry_i1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i1 = hmList.get("i1");
			if (listEntry_i1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = "inputs";
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			((ReferenceEvaluation) exp0.first).value = null;
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li1", entry);
							AppMutation appMut = registry32(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation33(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry32(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m32") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m32"));
		}
		return appMut;
	}

	private int mutation33(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i2 = hmObjects.get("i2");
		if (entry_i2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_i2.getKey());
			if (recovered == null) {
				recovered = entry_i2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i2 = hmList.get("i2");
			if (listEntry_i2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i2) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i2.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i2 = hmList.get("i2");
			if (listEntry_i2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i2.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("li1");
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
			ev0_0.name = "inputs";
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			ev0_0.value = null;
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li2", entry);
							AppMutation appMut = registry33(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation34(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry33(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m33") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m33"));
		}
		return appMut;
	}

	private int mutation34(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li1 = hmObjects.get("li1");
		if (entry_li1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_li1.getKey());
			if (recovered == null) {
				recovered = entry_li1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("iiv");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("max1")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp1", entry);
							AppMutation appMut = registry34(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation35(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry34(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m34") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m34"));
		}
		return appMut;
	}

	private int mutation35(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li1 = hmObjects.get("li1");
		if (entry_li1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_li1.getKey());
			if (recovered == null) {
				recovered = entry_li1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp1");
			if (entry_0 != null) {
				((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
						entry_0.getValue().getKey(), entry_0.getKey()).getObject();
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp2", entry);
							AppMutation appMut = registry35(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation36(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry35(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m35") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m35"));
		}
		return appMut;
	}

	private int mutation36(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("li2") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li2 = hmObjects.get("li2");
			EObject recovered = ModelManager.getObject(model, entry_li2.getKey());
			if (recovered == null) {
				recovered = entry_li2.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("li2") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li2 = hmList.get("li2");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li2) {
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
							.replace(".model", ".mutation36." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("tp1") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("inputs") != null) {
							refs = refsList.get("inputs");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_tp1 = hmObjects.get("tp1");
						EObject recovered = ModelManager.getObject(resource, entry_tp1.getKey());
						if (recovered == null) {
							recovered = entry_tp1.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "inputs", false));
						refsList.put("inputs", refs);
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
						AppMutation appMut = registry36(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/mp_max/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "mp_max",
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

	private AppMutation registry36(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		refMut0.setRefName("inputs");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m36") != null) {
			previous = mutator.getPrevious("inputs");
			next = mutator.getNext("inputs");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m36"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m36"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_mp_max(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation29(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation37(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
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
						hmObjects.put("i1", entry);
						AppMutation appMut = registry37(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation38(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry37(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m37") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m37"));
		}
		return appMut;
	}

	private int mutation38(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		String relativeMetamodelPath = "l/Annotation.ecore";
		String absoluteMetamodelPath = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
		resources = new ArrayList<Resource>();
		String relativeResourceURI_0 = "data/model/Annotation/yassinelamarti-botAnnotated.model";
		String absoluteResourceURI_0 = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeResourceURI_0;
		absoluteResourceURI_0 = "file:/" + absoluteResourceURI_0.substring(1, absoluteResourceURI_0.length());
		resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "IntentIntentValue");
		rts = new RandomTypeSelection(resourcePackages, resources, "IntentIntentValue");
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		packages.addAll(resourcePackages);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "intent1";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("i1");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		AttributeEvaluation ev0_0 = new AttributeEvaluation();
		ev0_0.name = "min1Value";
		ev0_0.operator = "equals";
		ev0_0.values = new ArrayList<Object>();
		Expression auxExp0 = new Expression();
		auxExp0.first = exp0.first;
		auxExp0.operator = new ArrayList<Operator>();
		List<EObject> auxObjects = evaluate(objects, auxExp0);
		MinValueConfigurationStrategy min0_0 = new MinValueConfigurationStrategy(packages, resources,
				"IntentIntentValue", auxObjects, "min1Value");
		((AttributeEvaluation) ev0_0).values.add(min0_0.getValue());
		((AttributeEvaluation) ev0_0).type = "float";
		exp0.second.add(ev0_0);
		objects = evaluate(objects, exp0);
		packages.clear();
		packages.addAll(savedPackages);
		for (EObject object : objects) {
			ObSelectionStrategy objectSelection = null;
			Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
			Resource readOnlyResource = ModelManager.findModel(resources, object);
			object = ModelManager.getObject(readOnlyResource, object);
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
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
						hmObjects.put("iiv", entry);
						AppMutation appMut = registry38(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation39(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry38(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m38") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m38"));
		}
		return appMut;
	}

	private int mutation39(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = null;
		ev0_0.container = false;
		ev0_0.refName = null;
		ev0_0.attName = null;
		ev0_0.operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry0_0 = hmObjects.get("iiv");
		if (entry0_0 != null) {
			EObject srcObjExp0_0 = entry0_0.getKey();
			for (EReference ref : srcObjExp0_0.eClass().getEAllReferences()) {
				if (ref.getName().equals("intent2")) {
					ev0_0.value = srcObjExp0_0.eGet(ref);
				}
			}
		}
		exp0.second.add(ev0_0);
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
						hmObjects.put("i2", entry);
						AppMutation appMut = registry39(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation40(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry39(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m39") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m39"));
		}
		return appMut;
	}

	private int mutation40(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i1 = hmObjects.get("i1");
		if (entry_i1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_i1.getKey());
			if (recovered == null) {
				recovered = entry_i1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i1 = hmList.get("i1");
			if (listEntry_i1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i1 = hmList.get("i1");
			if (listEntry_i1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = "inputs";
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			((ReferenceEvaluation) exp0.first).value = null;
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li1", entry);
							AppMutation appMut = registry40(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation41(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry40(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m40") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m40"));
		}
		return appMut;
	}

	private int mutation41(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i2 = hmObjects.get("i2");
		if (entry_i2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_i2.getKey());
			if (recovered == null) {
				recovered = entry_i2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i2 = hmList.get("i2");
			if (listEntry_i2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_i2) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_i2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_i2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_i2.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_i2 = hmList.get("i2");
			if (listEntry_i2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_i2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_i2.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "LanguageIntent", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("li1");
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
			ev0_0.name = "inputs";
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			ev0_0.value = null;
			exp0.second.add(ev0_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("li2", entry);
							AppMutation appMut = registry41(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation42(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry41(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m41") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m41"));
		}
		return appMut;
	}

	private int mutation42(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li1 = hmObjects.get("li1");
		if (entry_li1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_li1.getKey());
			if (recovered == null) {
				recovered = entry_li1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "equals";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("iiv");
			if (entry_0 != null) {
				EObject srcObjExp = entry_0.getKey();
				for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					if (ref.getName().equals("min1")) {
						((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);
					}
				}
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp1", entry);
							AppMutation appMut = registry42(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation43(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry42(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m42") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m42"));
		}
		return appMut;
	}

	private int mutation43(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li1 = hmObjects.get("li1");
		if (entry_li1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_li1.getKey());
			if (recovered == null) {
				recovered = entry_li1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_li1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_li1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_li1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "inputs", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "inputs", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li1 = hmList.get("li1");
			if (listEntry_li1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_li1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_li1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"inputs", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"inputs", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "TrainingPhrase", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("tp1");
			if (entry_0 != null) {
				((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
						entry_0.getValue().getKey(), entry_0.getKey()).getObject();
			}
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("tp2", entry);
							AppMutation appMut = registry43(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation44(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry43(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m43") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m43"));
		}
		return appMut;
	}

	private int mutation44(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("li2") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_li2 = hmObjects.get("li2");
			EObject recovered = ModelManager.getObject(model, entry_li2.getKey());
			if (recovered == null) {
				recovered = entry_li2.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("li2") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_li2 = hmList.get("li2");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_li2) {
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
							.replace(".model", ".mutation44." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("tp1") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("inputs") != null) {
							refs = refsList.get("inputs");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_tp1 = hmObjects.get("tp1");
						EObject recovered = ModelManager.getObject(resource, entry_tp1.getKey());
						if (recovered == null) {
							recovered = entry_tp1.getKey();
						}
						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(),
								obSelection.getObject(), recovered, "inputs", false));
						refsList.put("inputs", refs);
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
						AppMutation appMut = registry44(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/mp_min/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "mp_min",
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

	private AppMutation registry44(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		refMut0.setRefName("inputs");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m44") != null) {
			previous = mutator.getPrevious("inputs");
			next = mutator.getNext("inputs");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m44"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m44"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_mp_min(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation37(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation45(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter");
		rts = new RandomTypeSelection(packages, model, "Parameter");
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
						hmObjects.put("p", entry);
						AppMutation appMut = registry45(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation46(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry45(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m45") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m45"));
		}
		return appMut;
	}

	private int mutation46(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "TrainingPhrase", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "tokens";
		((ReferenceEvaluation) exp0.first).refName = "parameter";
		((ReferenceEvaluation) exp0.first).refRefName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("p");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry46(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				mutation47(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames, modelFilename,
						mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
						ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor,
						k, serialize, test, classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry46(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m46") != null) {
			rMut.setDef(hmMutator.get("m46"));
			appMut = rMut;
		}
		return appMut;
	}

	private int mutation47(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "ParameterToken", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "parameter";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("p");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry47(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				mutation48(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames, modelFilename,
						mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
						ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor,
						k, serialize, test, classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry47(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m47") != null) {
			rMut.setDef(hmMutator.get("m47"));
			appMut = rMut;
		}
		return appMut;
	}

	private int mutation48(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
		if (entry_p != null) {
			EObject recovered = ModelManager.getObject(model, entry_p.getKey());
			if (recovered == null) {
				recovered = entry_p.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
			objects.add(objectSelection.getObject());
		} else {
			return numMutantsGenerated;
		}
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation48." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = referenceSelection;
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry48(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation49(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
							hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions,
							muts, project, monitor, k, serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry48(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m48") != null) {
			rMut.setDef(hmMutator.get("m48"));
			appMut = rMut;
		}
		return appMut;
	}

	private int mutation49(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "LanguageIntent", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "inputs";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry49(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dip/Output" + k[0] + ".model";
				boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
						localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
						registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dip", fromNames, k,
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
		}
		return numMutantsGenerated;
	}

	private AppMutation registry49(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m49") != null) {
			rMut.setDef(hmMutator.get("m49"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dip(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation45(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation50(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter");
		rts = new RandomTypeSelection(packages, model, "Parameter");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "required";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(true);
		((AttributeEvaluation) exp0.first).type = "Boolean";
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
						hmObjects.put("p0", entry);
						AppMutation appMut = registry50(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation51(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry50(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m50") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m50"));
		}
		return appMut;
	}

	private int mutation51(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p0 = hmObjects.get("p0");
		if (entry_p0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_p0.getKey());
			if (recovered == null) {
				recovered = entry_p0.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_p0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_p0.getKey());
			if (recovered == null) {
				recovered = entry_p0.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "prompts", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "LanguagePrompt", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation51." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"prompts", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry51(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dpp/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dpp", fromNames,
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

	private AppMutation registry51(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m51") != null) {
			rMut.setDef(hmMutator.get("m51"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dpp(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation50(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation52(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "required";
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
							.replace(".model", ".mutation52." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new SpecificBooleanConfigurationStrategy(false);
					atts.add(attConfig);
					attsList.put("required", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
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
						AppMutation appMut = registry52(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/spo/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "spo", fromNames,
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

	private AppMutation registry52(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("required");
		oldAttVal = mutator.getOldAttValue("required");
		newAttVal = mutator.getNewAttValue("required");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m52") != null) {
			attMut0.setDef(hmMutator.get("m52"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m52"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_spo(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation52(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation53(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "RegexInput", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		for (EObject object : objects) {
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
					? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
					: modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\");
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			Resource resource = ModelManager.cloneModel(model,
					model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
							.replace(".model", ".mutation53." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new CatStartStringConfigurationStrategy("[^", "expresion");
					atts.add(attConfig);
					attsList.put("expresion", atts);
				}
				if (obSelection != null) {
					AttributeConfigurationStrategy attConfig = null;
					List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
					attConfig = new CatEndStringConfigurationStrategy("]", "expresion");
					atts.add(attConfig);
					attsList.put("expresion", atts);
				}
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
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
						AppMutation appMut = registry53(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cre/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cre", fromNames,
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

	private AppMutation registry53(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("expresion");
		oldAttVal = mutator.getOldAttValue("expresion");
		newAttVal = mutator.getNewAttValue("expresion");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m53") != null) {
			attMut0.setDef(hmMutator.get("m53"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m53"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		AttributeChanged attMut1 = null;
		attMut1 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
		attMut1.setAttName("expresion");
		oldAttVal = mutator.getOldAttValue("expresion");
		newAttVal = mutator.getNewAttValue("expresion");
		if (oldAttVal != null) {
			attMut1.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut1.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m53") != null) {
			attMut1.setDef(hmMutator.get("m53"));
			attsMut.add(attMut1);
			icMut.setDef(hmMutator.get("m53"));
		} else {
			attMut1 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_cre(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation53(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation54(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "SimpleInput", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation54." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = referenceSelection;
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry54(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dle/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dle", fromNames,
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

	private AppMutation registry54(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m54") != null) {
			rMut.setDef(hmMutator.get("m54"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dle(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation54(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation55(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Intent");
		rts = new RandomTypeSelection(packages, model, "Intent");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "fallbackIntent";
		((AttributeEvaluation) exp0.first).operator = "equals";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(true);
		((AttributeEvaluation) exp0.first).type = "Boolean";
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
						hmObjects.put("i", entry);
						AppMutation appMut = registry55(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation56(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry55(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m55") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m55"));
		}
		return appMut;
	}

	private int mutation56(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "UserInteraction", mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "intent";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("i");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		if (objects != null) {
			obSelection = new SpecificObjectSelection(packages, model, objects);
			RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
					objects, referenceSelection, containerSelection);
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}
			if (mut != null) {
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = registry56(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			if (mutator != null) {
				mutation57(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames, modelFilename,
						mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
						ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor,
						k, serialize, test, classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry56(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m56") != null) {
			rMut.setDef(hmMutator.get("m56"));
			appMut = rMut;
		}
		return appMut;
	}

	private int mutation57(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_i = hmObjects.get("i");
		if (entry_i != null) {
			EObject recovered = ModelManager.getObject(model, entry_i.getKey());
			if (recovered == null) {
				recovered = entry_i.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
			objects.add(objectSelection.getObject());
		} else {
			return numMutantsGenerated;
		}
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation57." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = referenceSelection;
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry57(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dfi/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dfi", fromNames,
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

	private AppMutation registry57(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m57") != null) {
			rMut.setDef(hmMutator.get("m57"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dfi(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation55(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation58(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BotInteraction");
		rts = new RandomTypeSelection(packages, model, "BotInteraction");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "actions";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
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
						hmObjects.put("bi0", entry);
						AppMutation appMut = registry58(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation59(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry58(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m58") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m58"));
		}
		return appMut;
	}

	private int mutation59(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi0 = hmObjects.get("bi0");
		if (entry_bi0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi0.getKey());
			if (recovered == null) {
				recovered = entry_bi0.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_bi0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi0.getKey());
			if (recovered == null) {
				recovered = entry_bi0.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "actions", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "Action", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation59." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"actions", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry59(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/da/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "da", fromNames,
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

	private AppMutation registry59(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m59") != null) {
			rMut.setDef(hmMutator.get("m59"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_da(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation58(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation60(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "TextInput");
		rts = new RandomTypeSelection(packages, model, "TextInput");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "tokens";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "ParameterToken").getObject();
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
						hmObjects.put("text", entry);
						AppMutation appMut = registry60(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation61(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry60(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m60") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m60"));
		}
		return appMut;
	}

	private int mutation61(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_text = hmObjects.get("text");
		if (entry_text != null) {
			EObject recovered = ModelManager.getObject(model, entry_text.getKey());
			if (recovered == null) {
				recovered = entry_text.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_text != null) {
			EObject recovered = ModelManager.getObject(model, entry_text.getKey());
			if (recovered == null) {
				recovered = entry_text.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "tokens", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "ParameterToken", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation61." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"tokens", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry61(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dpr/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dpr", fromNames,
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

	private AppMutation registry61(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m61") != null) {
			rMut.setDef(hmMutator.get("m61"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dpr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation60(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation62(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BotInteraction");
		rts = new RandomTypeSelection(packages, model, "BotInteraction");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "actions";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		Operator op0_0 = new Operator();
		op0_0.type = "and";
		exp0.operator.add(op0_0);
		exp0.second = new ArrayList<Evaluation>();
		ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
		ev0_0.name = "outcoming";
		ev0_0.refName = "target";
		ev0_0.attName = null;
		ev0_0.operator = "different";
		ev0_0.value = null;
		exp0.second.add(ev0_0);
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
						hmObjects.put("bi1", entry);
						AppMutation appMut = registry62(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation63(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry62(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m62") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m62"));
		}
		return appMut;
	}

	private int mutation63(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi1 = hmObjects.get("bi1");
		if (entry_bi1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi1.getKey());
			if (recovered == null) {
				recovered = entry_bi1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_bi1 = hmList.get("bi1");
			if (listEntry_bi1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_bi1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_bi1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_bi1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_bi1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "outcoming", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "outcoming", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_bi1 = hmList.get("bi1");
			if (listEntry_bi1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_bi1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_bi1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"outcoming", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"outcoming", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "UserInteraction", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = "target";
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			((ReferenceEvaluation) exp0.first).value = null;
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
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("ui1", entry);
							AppMutation appMut = registry63(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation64(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry63(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m63") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m63"));
		}
		return appMut;
	}

	private int mutation64(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_ui1 = hmObjects.get("ui1");
		if (entry_ui1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_ui1.getKey());
			if (recovered == null) {
				recovered = entry_ui1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_ui1 = hmList.get("ui1");
			if (listEntry_ui1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_ui1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_ui1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_ui1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_ui1.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "target", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "target", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_ui1 = hmList.get("ui1");
			if (listEntry_ui1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_ui1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_ui1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"target", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"target", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "BotInteraction", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new ReferenceEvaluation();
			((ReferenceEvaluation) exp0.first).name = null;
			((ReferenceEvaluation) exp0.first).container = false;
			((ReferenceEvaluation) exp0.first).refName = null;
			((ReferenceEvaluation) exp0.first).attName = null;
			((ReferenceEvaluation) exp0.first).operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("bi1");
			if (entry_0 != null) {
				((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
						entry_0.getValue().getKey(), entry_0.getKey()).getObject();
			}
			exp0.operator = new ArrayList<Operator>();
			Operator op0_0 = new Operator();
			op0_0.type = "and";
			exp0.operator.add(op0_0);
			Operator op1_0 = new Operator();
			op1_0.type = "and";
			exp0.operator.add(op1_0);
			exp0.second = new ArrayList<Evaluation>();
			ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
			ev0_0.name = "actions";
			ev0_0.refName = null;
			ev0_0.attName = null;
			ev0_0.operator = "different";
			ev0_0.value = null;
			exp0.second.add(ev0_0);
			ReferenceEvaluation ev1_0 = new ReferenceEvaluation();
			ev1_0.name = "actions";
			ev1_0.refName = null;
			ev1_0.attName = null;
			ev1_0.operator = "different";
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry1_0 = hmObjects.get("bi1");
			if (entry1_0 != null) {
				EObject srcObjExp1_0 = entry1_0.getKey();
				for (EReference ref : srcObjExp1_0.eClass().getEAllReferences()) {
					if (ref.getName().equals("actions")) {
						ev1_0.value = srcObjExp1_0.eGet(ref);
					}
				}
			}
			exp0.second.add(ev1_0);
			objects = evaluate(objects, exp0);
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("bi2", entry);
							AppMutation appMut = registry64(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation65(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry64(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m64") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m64"));
		}
		return appMut;
	}

	private int mutation65(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("bi1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi1 = hmObjects.get("bi1");
			EObject recovered = ModelManager.getObject(model, entry_bi1.getKey());
			if (recovered == null) {
				recovered = entry_bi1.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("bi1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_bi1 = hmList.get("bi1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_bi1) {
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
							.replace(".model", ".mutation65." + numMutantsGenerated + ".model"));
			ObSelectionStrategy obSelection = null;
			object = ModelManager.getObject(resource, object);
			if (object != null) {
				obSelection = new SpecificObjectSelection(packages, resource, object);
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("bi2") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("actions") != null) {
							refs = refsList.get("actions");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi2 = hmObjects.get("bi2");
						EObject recovered = ModelManager.getObject(resource, entry_bi2.getKey());
						if (recovered == null) {
							recovered = entry_bi2.getKey();
						}
						refs.add(new SwapReferenceConfigurationStrategy(obSelection.getObject(), recovered, "actions",
								"actions"));
						refsList.put("actions", refs);
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
						AppMutation appMut = registry65(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/so/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "so", fromNames,
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

	private AppMutation registry65(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
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
		refMut0.setFirstName("actions");
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
		refMut0.setRefName("actions");
		refMut0.setOtherFrom(mutator.getOtherSource("actions"));
		refMut0.setOtherFromName(mutator.getOtherSourceName("actions"));
		refMut0.setOtherTo(mutator.getOtherTarget("actions"));
		refMut0.setOtherToName(mutator.getOtherTargetName("actions"));
		if (hmMutator.get("m65") != null) {
			previous = mutator.getPrevious("actions");
			next = mutator.getNext("actions");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m65"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m65"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_so(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation62(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation66(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "UserInteraction");
		rts = new RandomTypeSelection(packages, model, "UserInteraction");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "target";
		((ReferenceEvaluation) exp0.first).refName = "outcoming";
		((ReferenceEvaluation) exp0.first).refRefName = "target";
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "BotInteraction").getObject();
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
						hmObjects.put("ui0", entry);
						AppMutation appMut = registry66(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation67(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry66(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m66") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m66"));
		}
		return appMut;
	}

	private int mutation67(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_ui0 = hmObjects.get("ui0");
		if (entry_ui0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_ui0.getKey());
			if (recovered == null) {
				recovered = entry_ui0.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_ui0 = hmList.get("ui0");
			if (listEntry_ui0 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_ui0) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_ui0 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_ui0.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			valueRec = ModelManager.getReferenced("target", (EObject) valueRecovered);
			if (valueRec instanceof EObject) {
				valueRecovered = (EObject) valueRec;
			}
			if (valueRec instanceof List<?>) {
				valueRecovered = (List<EObject>) valueRec;
			}
			if (valueRecovered instanceof EObject) {
				valueRec = ModelManager.getReferenced("outcoming", (EObject) valueRecovered);
			}
			if (valueRecovered instanceof List<?>) {
				valueRec = ModelManager.getReferenced("outcoming", (List<EObject>) valueRecovered);
			}
			if (valueRec instanceof EObject) {
				valueRecovered = (EObject) valueRec;
			}
			if (valueRec instanceof List<?>) {
				valueRecovered = (List<EObject>) valueRec;
			}
			if (valueRecovered == null) {
				obRecovered = entry_ui0.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
				valueRec = ModelManager.getReferenced("target", (EObject) valueRecovered);
				if (valueRec instanceof EObject) {
					valueRecovered = (EObject) valueRec;
				}
				if (valueRec instanceof List<?>) {
					valueRecovered = (List<EObject>) valueRec;
				}
				if (valueRecovered instanceof EObject) {
					valueRec = ModelManager.getReferenced("outcoming", (EObject) valueRecovered);
				}
				if (valueRecovered instanceof List<?>) {
					valueRec = ModelManager.getReferenced("outcoming", (List<EObject>) valueRecovered);
				}
				if (valueRec instanceof EObject) {
					valueRecovered = (EObject) valueRec;
				}
				if (valueRec instanceof List<?>) {
					valueRecovered = (List<EObject>) valueRec;
				}
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "target", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "target", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_ui0 = hmList.get("ui0");
			if (listEntry_ui0 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_ui0.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_ui0.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				valueRec = ModelManager.getReferenced("target", (EObject) valueRecovered);
				if (valueRec instanceof EObject) {
					valueRecovered = (EObject) valueRec;
				}
				if (valueRec instanceof List<?>) {
					valueRecovered = (List<EObject>) valueRec;
				}
				if (valueRecovered instanceof EObject) {
					valueRec = ModelManager.getReferenced("outcoming", (EObject) valueRecovered);
				}
				if (valueRecovered instanceof List<?>) {
					valueRec = ModelManager.getReferenced("outcoming", (List<EObject>) valueRecovered);
				}
				if (valueRec instanceof EObject) {
					valueRecovered = (EObject) valueRec;
				}
				if (valueRec instanceof List<?>) {
					valueRecovered = (List<EObject>) valueRec;
				}
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"target", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"target", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "BotInteraction", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("bi0", entry);
							AppMutation appMut = registry67(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation68(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry67(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m67") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m67"));
		}
		return appMut;
	}

	private int mutation68(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EObject> listSources = new ArrayList<EObject>();
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_ui0 = hmObjects.get("ui0");
		SpecificObjectSelection sourceSelection = null;
		if (entry_ui0 != null) {
			sourceSelection = new SpecificObjectSelection(entry_ui0.getValue().getValue(),
					entry_ui0.getValue().getKey(), entry_ui0.getKey());
			listSources.add(sourceSelection.getObject());
		} else {
			return numMutantsGenerated;
		}
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		for (EObject sourceObject : listSources) {
			ObSelectionStrategy srcSelection = new SpecificObjectSelection(packages, model, sourceObject);
			List<EObject> listTargets = new ArrayList<EObject>();
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi0 = hmObjects.get("bi0");
			SpecificObjectSelection newTargetSelection = null;
			if (entry_bi0 != null) {
				newTargetSelection = new SpecificObjectSelection(entry_bi0.getValue().getValue(),
						entry_bi0.getValue().getKey(), entry_bi0.getKey());
				listTargets.add(newTargetSelection.getObject());
			} else {
				return numMutantsGenerated;
			}
			for (EObject targetObject : listTargets) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation68." + numMutantsGenerated + ".model"));
				EObject source = ModelManager.getObject(m, sourceObject);
				if (source == null) {
					continue;
				}
				ObSelectionStrategy srcSelection2 = new SpecificObjectSelection(packages, m, source);
				EObject target = ModelManager.getObject(m, targetObject);
				if (target == null) {
					continue;
				}
				EObject previous = source.eContainer();
				while (previous != null && !EcoreUtil.equals(previous, target)) {
					previous = previous.eContainer();
				}
				if (EcoreUtil.equals(previous, target)) {
					continue;
				}
				ObSelectionStrategy tarSelection = new SpecificObjectSelection(packages, m, target);
				ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(srcSelection2.getModel(),
						srcSelection2.getMetaModel(), srcSelection2, tarSelection, "target");
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry68(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dcs/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dcs", fromNames,
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
				try {
					m.unload();
				} catch (Exception e) {
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry68(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
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
		if (hmMutator.get("m68") != null) {
			trcMut.setDef(hmMutator.get("m68"));
			appMut = trcMut;
		}
		return appMut;
	}

	public int block_dcs(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation66(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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

	private int mutation69(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BotInteraction");
		rts = new RandomTypeSelection(packages, model, "BotInteraction");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "outcoming";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
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
						hmObjects.put("bi", entry);
						AppMutation appMut = registry69(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					mutation70(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
							hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k,
							serialize, test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry69(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m69") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m69"));
		}
		return appMut;
	}

	private int mutation70(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi = hmObjects.get("bi");
		if (entry_bi != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi.getKey());
			if (recovered == null) {
				recovered = entry_bi.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_bi = hmList.get("bi");
			if (listEntry_bi != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_bi) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					if (obj == null) {
						obj = ent.getKey();
					}
					objs.add(obj);
				}
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
				containerSelectionList.add(containerSelection);
			} else {
				return numMutantsGenerated;
			}
		}
		if (entry_bi != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_bi.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_bi.getKey();
				valueRecovered = obRecovered;
				valueRec = null;
			}
			if (valueRecovered instanceof EObject) {
				EObject recovered = (EObject) valueRecovered;
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
				containerSelectionList.clear();
				containerSelectionList.add(containerSelection);
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
						resources, "outcoming", recovered);
				referenceSelectionList.clear();
				referenceSelectionList.add(referenceSelection);
			}
			if (valueRecovered instanceof List<?>) {
				List<EObject> recoveredList = (List<EObject>) valueRecovered;
				containerSelectionList.clear();
				referenceSelectionList.clear();
				for (EObject recovered : recoveredList) {
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.add(containerSelection);
					resourcePackages = packages;
					resources = new ArrayList<Resource>();
					resources.add(model);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages,
							resources, "outcoming", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_bi = hmList.get("bi");
			if (listEntry_bi != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_bi.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_bi.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"outcoming", recovered);
					referenceSelectionList.clear();
					referenceSelectionList.add(referenceSelection);
				}
				if (valueRecovered instanceof List<?>) {
					List<EObject> recoveredList = (List<EObject>) valueRecovered;
					containerSelectionList.clear();
					referenceSelectionList.clear();
					for (EObject recovered : recoveredList) {
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model,
								recovered);
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
								"outcoming", recovered);
						containerSelectionList.add(containerSelection);
						referenceSelectionList.add(referenceSelection);
					}
				}
			} else {
				return numMutantsGenerated;
			}
		}
		for (int j = 0; j < containerSelectionList.size(); j++) {
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(),
					containerSelectionList.get(j).getModel(), "UserInteraction", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(),
							objectSelection.getMetaModel(), referenceSelectionList.get(j),
							containerSelectionList.get(j), objectSelection);
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
							hmObjects.put("ui", entry);
							AppMutation appMut = registry70(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation71(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry70(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m70") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m70"));
		}
		return appMut;
	}

	private int mutation71(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_bi = hmObjects.get("bi");
		if (entry_bi != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi.getKey());
			if (recovered == null) {
				recovered = entry_bi.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			return numMutantsGenerated;
		}
		if (entry_bi != null) {
			EObject recovered = ModelManager.getObject(model, entry_bi.getKey());
			if (recovered == null) {
				recovered = entry_bi.getKey();
			}
			referenceSelection = new SpecificReferenceSelection(packages, model, "outcoming", recovered);
		} else {
			return numMutantsGenerated;
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "UserInteraction", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("ui");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		objects = evaluate(objects, exp0);
		ObSelectionStrategy obSelection = null;
		Mutator mutator = null;
		String modelsFolder = ModelManager.getModelsFolder(this.getClass());
		String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0
				? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length())
				: modelsFolder, "temp");
		modelsFolder = modelsFolder.replace("/", "\\");
		tempModelsFolder = tempModelsFolder.replace("/", "\\");
		if (objects != null) {
			for (EObject ob : objects) {
				Resource m = ModelManager.cloneModel(model,
						model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\")
								.replace(".model", ".mutation71." + numMutantsGenerated + ".model"));
				EObject obToMutate = ModelManager.getObject(m, ob);
				obSelection = new SpecificObjectSelection(packages, m, obToMutate);
				EObject containerToMutate = null;
				if (containerSelection != null && containerSelection.getObject() != null) {
					containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
				}
				ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m,
						containerToMutate);
				SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model,
						"outcoming", containerToMutateSelection.getObject());
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(),
						obToMutate, referenceToMutateSelection, containerToMutateSelection);
				if (muts == null) {
					muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				}
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = registry71(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dcb/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dcb", fromNames,
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

	private AppMutation registry71(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(),
				mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m71") != null) {
			rMut.setDef(hmMutator.get("m71"));
			appMut = rMut;
		}
		return appMut;
	}

	public int block_dcb(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/data/model/BotGenerator.ecore";
		String modelURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/out/";
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
			hashsetMutantsBlock = new HashSet<String>();
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}
			numMutants = -1;
			String xmiFilename = testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testBotGenerator.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation69(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
			IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		MutationResults mutationResults = new MutationResults();
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 19;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		monitor.beginTask("Generating mutants", totalTasks);
		Map<String, Set<String>> hashmapMutants = new HashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
		List<String> fromNames = null;
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dp_max") == true)) {
			monitor.subTask("Generating mutants for block dp_max (1/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dp_max(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dp_max");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dp_min") == true)) {
			monitor.subTask("Generating mutants for block dp_min (2/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dp_min(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dp_min");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dpwp") == true)) {
			monitor.subTask("Generating mutants for block dpwp (3/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dpwp(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dpwp");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dpwl") == true)) {
			monitor.subTask("Generating mutants for block dpwl (4/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dpwl(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dpwl");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("k2p_max") == true)) {
			monitor.subTask("Generating mutants for block k2p_max (5/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_k2p_max(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("k2p_max");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("k2p_min") == true)) {
			monitor.subTask("Generating mutants for block k2p_min (6/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_k2p_min(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("k2p_min");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("mp_max") == true)) {
			monitor.subTask("Generating mutants for block mp_max (7/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_mp_max(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("mp_max");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("mp_min") == true)) {
			monitor.subTask("Generating mutants for block mp_min (8/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_mp_min(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("mp_min");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dip") == true)) {
			monitor.subTask("Generating mutants for block dip (9/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dip(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dip");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dpp") == true)) {
			monitor.subTask("Generating mutants for block dpp (10/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dpp(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dpp");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("spo") == true)) {
			monitor.subTask("Generating mutants for block spo (11/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_spo(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("spo");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cre") == true)) {
			monitor.subTask("Generating mutants for block cre (12/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cre(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cre");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dle") == true)) {
			monitor.subTask("Generating mutants for block dle (13/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dle(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dle");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dfi") == true)) {
			monitor.subTask("Generating mutants for block dfi (14/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dfi(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dfi");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("da") == true)) {
			monitor.subTask("Generating mutants for block da (15/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_da(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("da");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dpr") == true)) {
			monitor.subTask("Generating mutants for block dpr (16/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dpr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dpr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("so") == true)) {
			monitor.subTask("Generating mutants for block so (17/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_so(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("so");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dcs") == true)) {
			monitor.subTask("Generating mutants for block dcs (18/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dcs(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dcs");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dcb") == true)) {
			monitor.subTask("Generating mutants for block dcb (19/19)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dcb(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dcb");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testBotGeneratorDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/data/model/BotGenerator.ecore",
					testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testConga/data/model/",
					"testBotGeneratorDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testBotGeneratorDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/data/model/BotGenerator.ecore",
					testBotGeneratorDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testConga/data/model/",
					"testBotGeneratorDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
