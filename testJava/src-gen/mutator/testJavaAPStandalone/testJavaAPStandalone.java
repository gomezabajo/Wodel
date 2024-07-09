package mutator.testJavaAPStandalone;

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

public class testJavaAPStandalone extends MutatorUtils {
	private static Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	private static List<EObject> mutatedObjects = null;

	private int mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "MethodInvocation").getObject();
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
						hmObjects.put("stmt", entry);
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
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize,
							test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_stmt = hmObjects.get("stmt");
		if (entry_stmt != null) {
			EObject recovered = ModelManager.getObject(model, entry_stmt.getKey());
			if (recovered == null) {
				recovered = entry_stmt.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_stmt = hmList.get("stmt");
			if (listEntry_stmt != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_stmt) {
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
		if (entry_stmt != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_stmt.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_stmt.getKey();
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
						resources, "expression", recovered);
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
							resources, "expression", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_stmt = hmList.get("stmt");
			if (listEntry_stmt != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_stmt.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_stmt.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"expression", recovered);
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
								"expression", recovered);
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
					containerSelectionList.get(j).getModel(), "MethodInvocation", referenceSelectionList.get(j),
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
							hmObjects.put("method", entry);
							AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation3(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
								hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor,
								k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_method = hmObjects.get("method");
		if (entry_method != null) {
			EObject recovered = ModelManager.getObject(model, entry_method.getKey());
			if (recovered == null) {
				recovered = entry_method.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_method) {
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
		if (entry_method != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_method.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_method.getKey();
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
						resources, "arguments", recovered);
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
							resources, "arguments", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_method.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_method.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"arguments", recovered);
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
								"arguments", recovered);
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
					containerSelectionList.get(j).getModel(), "SingleVariableAccess", referenceSelectionList.get(j),
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
							hmObjects.put("param", entry);
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
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor,
								k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("stmt") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_stmt = hmObjects.get("stmt");
			EObject recovered = ModelManager.getObject(model, entry_stmt.getKey());
			if (recovered == null) {
				recovered = entry_stmt.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("stmt") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_stmt = hmList.get("stmt");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_stmt) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaAPStandalone.class);
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
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("param") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("expression") != null) {
							refs = refsList.get("expression");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_param = hmObjects
								.get("param");
						EObject recovered = ModelManager.getObject(resource, entry_param.getKey());
						if (recovered == null) {
							recovered = entry_param.getKey();
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
						AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/apmrt/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "apmrt",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaAPStandalone.class, true, false);
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

	private static AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
		if (hmMutator.get("m4") != null) {
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
			refMut0.setDef(hmMutator.get("m4"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m4"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_apmrt(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaAP.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation1(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test,
					classes);
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "MethodInvocation").getObject();
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
						hmObjects.put("exp0", entry);
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
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize,
							test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp0 = hmObjects.get("exp0");
		if (entry_exp0 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp0.getKey());
			if (recovered == null) {
				recovered = entry_exp0.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp0 = hmList.get("exp0");
			if (listEntry_exp0 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp0) {
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
		if (entry_exp0 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp0.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp0.getKey();
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
						resources, "rightOperand", recovered);
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
							resources, "rightOperand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp0 = hmList.get("exp0");
			if (listEntry_exp0 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp0.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp0.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"rightOperand", recovered);
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
								"rightOperand", recovered);
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
					containerSelectionList.get(j).getModel(), "MethodInvocation", referenceSelectionList.get(j),
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
							hmObjects.put("method", entry);
							AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation7(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths,
								hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders,
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor,
								k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_method = hmObjects.get("method");
		if (entry_method != null) {
			EObject recovered = ModelManager.getObject(model, entry_method.getKey());
			if (recovered == null) {
				recovered = entry_method.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_method) {
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
		if (entry_method != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_method.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_method.getKey();
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
						resources, "arguments", recovered);
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
							resources, "arguments", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_method.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_method.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"arguments", recovered);
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
								"arguments", recovered);
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
					containerSelectionList.get(j).getModel(), "SingleVariableAccess", referenceSelectionList.get(j),
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
							hmObjects.put("param", entry);
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
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor,
								k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp0") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp0 = hmObjects.get("exp0");
			EObject recovered = ModelManager.getObject(model, entry_exp0.getKey());
			if (recovered == null) {
				recovered = entry_exp0.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp0") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp0 = hmList.get("exp0");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp0) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaAPStandalone.class);
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
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("param") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("rightOperand") != null) {
							refs = refsList.get("rightOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_param = hmObjects
								.get("param");
						EObject recovered = ModelManager.getObject(resource, entry_param.getKey());
						if (recovered == null) {
							recovered = entry_param.getKey();
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
						AppMutation appMut = registry8(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/apmir/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "apmir",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaAPStandalone.class, true, false);
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

	private static AppMutation registry8(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
		if (hmMutator.get("m8") != null) {
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

	public int block_apmir(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaAP.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation5(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test,
					classes);
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "MethodInvocation").getObject();
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
						hmObjects.put("exp1", entry);
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
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize,
							test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp1 = hmObjects.get("exp1");
		if (entry_exp1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp1.getKey());
			if (recovered == null) {
				recovered = entry_exp1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp1 = hmList.get("exp1");
			if (listEntry_exp1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp1) {
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
		if (entry_exp1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp1.getKey();
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
						resources, "leftOperand", recovered);
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
							resources, "leftOperand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp1 = hmList.get("exp1");
			if (listEntry_exp1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp1.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"leftOperand", recovered);
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
								"leftOperand", recovered);
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
					containerSelectionList.get(j).getModel(), "MethodInvocation", referenceSelectionList.get(j),
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
							hmObjects.put("method", entry);
							AppMutation appMut = registry10(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation11(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry10(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m10") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m10"));
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_method = hmObjects.get("method");
		if (entry_method != null) {
			EObject recovered = ModelManager.getObject(model, entry_method.getKey());
			if (recovered == null) {
				recovered = entry_method.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_method) {
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
		if (entry_method != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_method.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_method.getKey();
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
						resources, "arguments", recovered);
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
							resources, "arguments", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_method.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_method.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"arguments", recovered);
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
								"arguments", recovered);
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
					containerSelectionList.get(j).getModel(), "SingleVariableAccess", referenceSelectionList.get(j),
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
							hmObjects.put("param", entry);
							AppMutation appMut = registry11(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation12(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
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

	private int mutation12(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("exp1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp1 = hmObjects.get("exp1");
			EObject recovered = ModelManager.getObject(model, entry_exp1.getKey());
			if (recovered == null) {
				recovered = entry_exp1.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("exp1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp1 = hmList.get("exp1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp1) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaAPStandalone.class);
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
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("param") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("leftOperand") != null) {
							refs = refsList.get("leftOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_param = hmObjects
								.get("param");
						EObject recovered = ModelManager.getObject(resource, entry_param.getKey());
						if (recovered == null) {
							recovered = entry_param.getKey();
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
						AppMutation appMut = registry12(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/apmil/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "apmil",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaAPStandalone.class, true, false);
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
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("leftOperand");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m12") != null) {
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

	public int block_apmil(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaAP.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation9(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test,
					classes);
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

	private int mutation13(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "MethodInvocation").getObject();
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
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize,
							test, classes);
					numMutantsGenerated = k[0];
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry13(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a = hmObjects.get("a");
		if (entry_a != null) {
			EObject recovered = ModelManager.getObject(model, entry_a.getKey());
			if (recovered == null) {
				recovered = entry_a.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a = hmList.get("a");
			if (listEntry_a != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_a) {
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
		if (entry_a != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_a.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_a.getKey();
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
						resources, "rightHandSide", recovered);
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
							resources, "rightHandSide", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a = hmList.get("a");
			if (listEntry_a != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_a.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_a.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"rightHandSide", recovered);
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
								"rightHandSide", recovered);
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
					containerSelectionList.get(j).getModel(), "MethodInvocation", referenceSelectionList.get(j),
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
							hmObjects.put("method", entry);
							AppMutation appMut = registry14(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation15(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry14(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m14") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m14"));
		}
		return appMut;
	}

	private int mutation15(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		resourcePackages.addAll(packages);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_method = hmObjects.get("method");
		if (entry_method != null) {
			EObject recovered = ModelManager.getObject(model, entry_method.getKey());
			if (recovered == null) {
				recovered = entry_method.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_method) {
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
		if (entry_method != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_method.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_method.getKey();
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
						resources, "arguments", recovered);
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
							resources, "arguments", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_method = hmList.get("method");
			if (listEntry_method != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_method.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_method.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"arguments", recovered);
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
								"arguments", recovered);
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
					containerSelectionList.get(j).getModel(), "SingleVariableAccess", referenceSelectionList.get(j),
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
							hmObjects.put("param", entry);
							AppMutation appMut = registry15(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					mutator = mut;
					if (mutator != null) {
						mutation16(packages, resource, hmObjects, hmList, hashmapModelFilenames, modelFilename,
								mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages,
								hashmapModelFolders, ecoreURI, registry, hashsetMutantsBlock, fromNames,
								hashmapMutVersions, muts, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private static AppMutation registry15(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException,
			MetaModelNotFoundException, ModelNotFoundException, ObjectNotContainedException,
			ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaAPStandalone.class);
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
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("param") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("rightHandSide") != null) {
							refs = refsList.get("rightHandSide");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_param = hmObjects
								.get("param");
						EObject recovered = ModelManager.getObject(resource, entry_param.getKey());
						if (recovered == null) {
							recovered = entry_param.getKey();
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
						AppMutation appMut = registry16(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/apmas/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "apmas",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaAPStandalone.class, true, false);
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

	private static AppMutation registry16(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
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
		if (hmMutator.get("m16") != null) {
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

	public int block_apmas(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaAP.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			Resource model = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			Resource seed = ModelManager.loadModelNoException(packages,
					URI.createURI("file:/" + modelFilename).toFileString());
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			mutation13(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
					hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
					registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test,
					classes);
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
			Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor,
			boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		MutationResults mutationResults = new MutationResults();
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 4;
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("apmrt") == true)) {
			monitor.subTask("Generating mutants for block apmrt (1/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_apmrt(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("apmrt");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("apmir") == true)) {
			monitor.subTask("Generating mutants for block apmir (2/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_apmir(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("apmir");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("apmil") == true)) {
			monitor.subTask("Generating mutants for block apmil (3/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_apmil(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("apmil");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("apmas") == true)) {
			monitor.subTask("Generating mutants for block apmas (4/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_apmas(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("apmas");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testJavaAPStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testJava/data/model/java.ecore",
					testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testJava/data/model/",
					"testJavaAPStandalone.java", hashmapMutVersions, testJavaAPStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testJavaAPStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testJava/data/model/java.ecore",
					testJavaAPStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testJava/data/model/",
					"testJavaAPStandalone.java", hashmapMutVersions, testJavaAPStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
