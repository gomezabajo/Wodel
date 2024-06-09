package mutator.testJavaUCODStandalone;

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

public class testJavaUCODStandalone extends MutatorUtils {
	private static Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	private static List<EObject> mutatedObjects = null;

	private int mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
			Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
			Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages,
			Map<String, EPackage> localRegisteredPackages, Map<String, String> hashmapModelFolders, String ecoreURI,
			boolean registry, Set<String> hashsetMutantsBlock, List<String> fromNames,
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "IfStatement");
		rts = new RandomTypeSelection(packages, model, "IfStatement");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "expression";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "PrefixExpression").getObject();
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
						hmObjects.put("if1", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_if1 = hmObjects.get("if1");
		if (entry_if1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_if1.getKey());
			if (recovered == null) {
				recovered = entry_if1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_if1 = hmList.get("if1");
			if (listEntry_if1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_if1) {
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
		if (entry_if1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_if1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_if1.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_if1 = hmList.get("if1");
			if (listEntry_if1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_if1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_if1.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "PrefixExpression", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new AttributeEvaluation();
			((AttributeEvaluation) exp0.first).name = "operator";
			((AttributeEvaluation) exp0.first).operator = "equals";
			((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
			((AttributeEvaluation) exp0.first).values.add("!");
			((AttributeEvaluation) exp0.first).type = "String";
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
							hmObjects.put("pre", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_pre = hmObjects.get("pre");
		if (entry_pre != null) {
			EObject recovered = ModelManager.getObject(model, entry_pre.getKey());
			if (recovered == null) {
				recovered = entry_pre.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_pre) {
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
		if (entry_pre != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_pre.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_pre.getKey();
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
						resources, "operand", recovered);
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
							resources, "operand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_pre.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_pre.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"operand", recovered);
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
								"operand", recovered);
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
					containerSelectionList.get(j).getModel(), "Expression", referenceSelectionList.get(j),
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
							hmObjects.put("exp2", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("if1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_if1 = hmObjects.get("if1");
			EObject recovered = ModelManager.getObject(model, entry_if1.getKey());
			if (recovered == null) {
				recovered = entry_if1.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("if1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_if1 = hmList.get("if1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_if1) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaUCODStandalone.class);
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
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("exp2") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("expression") != null) {
							refs = refsList.get("expression");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
						EObject recovered = ModelManager.getObject(resource, entry_exp2.getKey());
						if (recovered == null) {
							recovered = entry_exp2.getKey();
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cod1/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cod1",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaUCODStandalone.class, true, false);
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

	public int block_cod1(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaUCOD.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "PrefixExpression").getObject();
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
						hmObjects.put("rt1", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt1 = hmObjects.get("rt1");
		if (entry_rt1 != null) {
			EObject recovered = ModelManager.getObject(model, entry_rt1.getKey());
			if (recovered == null) {
				recovered = entry_rt1.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt1 = hmList.get("rt1");
			if (listEntry_rt1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_rt1) {
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
		if (entry_rt1 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_rt1.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_rt1.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt1 = hmList.get("rt1");
			if (listEntry_rt1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_rt1.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_rt1.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "PrefixExpression", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new AttributeEvaluation();
			((AttributeEvaluation) exp0.first).name = "operator";
			((AttributeEvaluation) exp0.first).operator = "equals";
			((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
			((AttributeEvaluation) exp0.first).values.add("!");
			((AttributeEvaluation) exp0.first).type = "String";
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
							hmObjects.put("pre", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_pre = hmObjects.get("pre");
		if (entry_pre != null) {
			EObject recovered = ModelManager.getObject(model, entry_pre.getKey());
			if (recovered == null) {
				recovered = entry_pre.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_pre) {
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
		if (entry_pre != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_pre.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_pre.getKey();
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
						resources, "operand", recovered);
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
							resources, "operand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_pre.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_pre.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"operand", recovered);
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
								"operand", recovered);
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
					containerSelectionList.get(j).getModel(), "Expression", referenceSelectionList.get(j),
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
							hmObjects.put("exp2", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("rt1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_rt1 = hmObjects.get("rt1");
			EObject recovered = ModelManager.getObject(model, entry_rt1.getKey());
			if (recovered == null) {
				recovered = entry_rt1.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("rt1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_rt1 = hmList.get("rt1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_rt1) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaUCODStandalone.class);
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
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("exp2") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("expression") != null) {
							refs = refsList.get("expression");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
						EObject recovered = ModelManager.getObject(resource, entry_exp2.getKey());
						if (recovered == null) {
							recovered = entry_exp2.getKey();
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
						AppMutation appMut = registry8(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cod2/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cod2",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaUCODStandalone.class, true, false);
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
		refMut0.setRefName("expression");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m8") != null) {
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

	public int block_cod2(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaUCOD.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "PrefixExpression").getObject();
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
						hmObjects.put("inf", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_inf = hmObjects.get("inf");
		if (entry_inf != null) {
			EObject recovered = ModelManager.getObject(model, entry_inf.getKey());
			if (recovered == null) {
				recovered = entry_inf.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
			if (listEntry_inf != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_inf) {
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
		if (entry_inf != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_inf.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_inf.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
			if (listEntry_inf != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_inf.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_inf.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "PrefixExpression", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new AttributeEvaluation();
			((AttributeEvaluation) exp0.first).name = "operator";
			((AttributeEvaluation) exp0.first).operator = "equals";
			((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
			((AttributeEvaluation) exp0.first).values.add("!");
			((AttributeEvaluation) exp0.first).type = "String";
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
							hmObjects.put("pre", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_pre = hmObjects.get("pre");
		if (entry_pre != null) {
			EObject recovered = ModelManager.getObject(model, entry_pre.getKey());
			if (recovered == null) {
				recovered = entry_pre.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_pre) {
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
		if (entry_pre != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_pre.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_pre.getKey();
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
						resources, "operand", recovered);
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
							resources, "operand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_pre.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_pre.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"operand", recovered);
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
								"operand", recovered);
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
					containerSelectionList.get(j).getModel(), "Expression", referenceSelectionList.get(j),
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
							hmObjects.put("exp2", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("inf") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_inf = hmObjects.get("inf");
			EObject recovered = ModelManager.getObject(model, entry_inf.getKey());
			if (recovered == null) {
				recovered = entry_inf.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("inf") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_inf) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaUCODStandalone.class);
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
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("exp2") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("rightOperand") != null) {
							refs = refsList.get("rightOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
						EObject recovered = ModelManager.getObject(resource, entry_exp2.getKey());
						if (recovered == null) {
							recovered = entry_exp2.getKey();
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
						AppMutation appMut = registry12(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cod3/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cod3",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaUCODStandalone.class, true, false);
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
		refMut0.setRefName("rightOperand");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
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

	public int block_cod3(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaUCOD.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "PrefixExpression").getObject();
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
						hmObjects.put("inf", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_inf = hmObjects.get("inf");
		if (entry_inf != null) {
			EObject recovered = ModelManager.getObject(model, entry_inf.getKey());
			if (recovered == null) {
				recovered = entry_inf.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
			if (listEntry_inf != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_inf) {
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
		if (entry_inf != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_inf.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_inf.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
			if (listEntry_inf != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_inf.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_inf.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "PrefixExpression", referenceSelectionList.get(j),
					containerSelectionList.get(j));
			List<EObject> objects = rts.getObjects();
			Expression exp0 = new Expression();
			exp0.first = new AttributeEvaluation();
			((AttributeEvaluation) exp0.first).name = "operator";
			((AttributeEvaluation) exp0.first).operator = "equals";
			((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
			((AttributeEvaluation) exp0.first).values.add("!");
			((AttributeEvaluation) exp0.first).type = "String";
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
							hmObjects.put("pre", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_pre = hmObjects.get("pre");
		if (entry_pre != null) {
			EObject recovered = ModelManager.getObject(model, entry_pre.getKey());
			if (recovered == null) {
				recovered = entry_pre.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_pre) {
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
		if (entry_pre != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_pre.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_pre.getKey();
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
						resources, "operand", recovered);
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
							resources, "operand", recovered);
					referenceSelectionList.add(referenceSelection);
				}
			}
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_pre = hmList.get("pre");
			if (listEntry_pre != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_pre.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_pre.get(0).getKey();
				}
				Object valueRecovered = obRecovered;
				if (valueRecovered instanceof EObject) {
					EObject recovered = (EObject) valueRecovered;
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
					containerSelectionList.clear();
					containerSelectionList.add(containerSelection);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model,
							"operand", recovered);
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
								"operand", recovered);
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
					containerSelectionList.get(j).getModel(), "Expression", referenceSelectionList.get(j),
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
							hmObjects.put("exp2", entry);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("inf") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_inf = hmObjects.get("inf");
			EObject recovered = ModelManager.getObject(model, entry_inf.getKey());
			if (recovered == null) {
				recovered = entry_inf.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("inf") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_inf = hmList.get("inf");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_inf) {
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
			String modelsFolder = ModelManager.getModelsFolder(testJavaUCODStandalone.class);
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
				Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
				Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
				List<EObject> objsAttRef = new ArrayList<EObject>();
				if (obSelection != null && obSelection.getObject() != null) {
					if (hmObjects.get("exp2") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("leftOperand") != null) {
							refs = refsList.get("leftOperand");
						} else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
						EObject recovered = ModelManager.getObject(resource, entry_exp2.getKey());
						if (recovered == null) {
							recovered = entry_exp2.getKey();
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
						AppMutation appMut = registry16(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
				if (mutator != null) {
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cod4/Output" + k[0] + ".model";
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
							registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cod4",
							fromNames, k, mutPaths, hashmapMutVersions, "testJava", serialize, test, classes,
							testJavaUCODStandalone.class, true, false);
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
		refMut0.setRefName("leftOperand");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m16") != null) {
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

	public int block_cod4(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
			List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "/testJava/data/model/java.ecore";
		String modelURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testJavaUCOD.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages,
					URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
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
		Map<String, Set<String>> hashmapMutants = new HashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
		List<String> fromNames = null;
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cod1") == true)) {
			monitor.subTask("Generating mutants for block cod1 (1/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cod1(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cod1");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cod2") == true)) {
			monitor.subTask("Generating mutants for block cod2 (2/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cod2(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cod2");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cod3") == true)) {
			monitor.subTask("Generating mutants for block cod3 (3/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cod3(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cod3");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cod4") == true)) {
			monitor.subTask("Generating mutants for block cod4 (4/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cod4(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cod4");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testJavaUCODStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testJava/data/model/java.ecore",
					testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testJava/data/model/",
					"testJavaUCODStandalone.java", hashmapMutVersions, testJavaUCODStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testJavaUCODStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testJava/data/model/java.ecore",
					testJavaUCODStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testJava/data/model/",
					"testJavaUCODStandalone.java", hashmapMutVersions, testJavaUCODStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
