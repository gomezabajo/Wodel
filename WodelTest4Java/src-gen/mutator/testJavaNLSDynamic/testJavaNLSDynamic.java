package mutator.testJavaNLSDynamic;

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

public class testJavaNLSDynamic extends MutatorUtils {
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
						hmObjects.put("exp2", entry);
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp2) {
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
		if (entry_exp2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp2.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp2.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "NumberLiteral", referenceSelectionList.get(j),
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
							hmObjects.put("n3", entry);
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
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project,
								monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
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
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("n3") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3 = hmObjects.get("n3");
			EObject recovered = ModelManager.getObject(model, entry_n3.getKey());
			if (recovered == null) {
				recovered = entry_n3.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("n3") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3 = hmList.get("n3");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3) {
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
		for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			if (mObjects.size() > obn) {
				objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
			} else {
				continue;
			}
			EObject container = ModelManager.getContainer(m, objectSelection.getObject());
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			AttributeConfigurationStrategy attConfig = null;
			attConfig = new SpecificStringConfigurationStrategy("1");
			;
			atts.put("tokenValue", attConfig);
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
			CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), true,
					referenceSelection, containerSelection, atts, refs, "NumberLiteral");
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
					hmObjects.put("dec", entry);
					AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
			}
			mutator = mut;
			if (mutator != null) {
				mutation4(packages, m, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
						seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
						hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
						classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m3") != null) {
			cMut.setDef(hmMutator.get("m3"));
			appMut = cMut;
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
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
			referenceSelection = new SpecificReferenceSelection(packages, model, "leftOperand", recovered);
		} else {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection1 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3_1 = hmObjects.get("n3");
		if (entry_n3_1 != null) {
			refSelection1 = new SpecificObjectSelection(packages, model, entry_n3_1.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3_1 = hmList.get("n3");
			if (listEntry_n3_1 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3_1) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection1 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("leftOperand", refSelection1);
		ObSelectionStrategy refSelection2 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_dec_2 = hmObjects.get("dec");
		if (entry_dec_2 != null) {
			refSelection2 = new SpecificObjectSelection(packages, model, entry_dec_2.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_dec_2 = hmList.get("dec");
			if (listEntry_dec_2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_dec_2) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection2 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("rightOperand", refSelection2);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "InfixExpression");
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
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dnl/Output" + k[0] + ".model";
			boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
					localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
					registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dnl", fromNames, k,
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

	private AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m4") != null) {
			cMut.setDef(hmMutator.get("m4"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_dnl(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaNLS.model";
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
						hmObjects.put("exp2", entry);
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp2) {
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
		if (entry_exp2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp2.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp2.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "NumberLiteral", referenceSelectionList.get(j),
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
							hmObjects.put("n3", entry);
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
								ecoreURI, registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project,
								monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
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
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("n3") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3 = hmObjects.get("n3");
			EObject recovered = ModelManager.getObject(model, entry_n3.getKey());
			if (recovered == null) {
				recovered = entry_n3.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("n3") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3 = hmList.get("n3");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3) {
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
		for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			if (mObjects.size() > obn) {
				objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
			} else {
				continue;
			}
			EObject container = ModelManager.getContainer(m, objectSelection.getObject());
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			AttributeConfigurationStrategy attConfig = null;
			attConfig = new SpecificStringConfigurationStrategy("1");
			;
			atts.put("tokenValue", attConfig);
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
			CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), true,
					referenceSelection, containerSelection, atts, refs, "NumberLiteral");
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
					hmObjects.put("dec", entry);
					AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
			}
			mutator = mut;
			if (mutator != null) {
				mutation8(packages, m, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
						seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
						hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
						classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m7") != null) {
			cMut.setDef(hmMutator.get("m7"));
			appMut = cMut;
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
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
			referenceSelection = new SpecificReferenceSelection(packages, model, "rightOperand", recovered);
		} else {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection3 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3_3 = hmObjects.get("n3");
		if (entry_n3_3 != null) {
			refSelection3 = new SpecificObjectSelection(packages, model, entry_n3_3.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3_3 = hmList.get("n3");
			if (listEntry_n3_3 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3_3) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection3 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("leftOperand", refSelection3);
		ObSelectionStrategy refSelection4 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_dec_4 = hmObjects.get("dec");
		if (entry_dec_4 != null) {
			refSelection4 = new SpecificObjectSelection(packages, model, entry_dec_4.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_dec_4 = hmList.get("dec");
			if (listEntry_dec_4 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_dec_4) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection4 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("rightOperand", refSelection4);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "InfixExpression");
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
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dnr/Output" + k[0] + ".model";
			boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
					localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
					registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dnr", fromNames, k,
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

	private AppMutation registry8(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m8") != null) {
			cMut.setDef(hmMutator.get("m8"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_dnr(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaNLS.model";
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
						hmObjects.put("exp2", entry);
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp2) {
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
		if (entry_exp2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp2.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp2.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "NumberLiteral", referenceSelectionList.get(j),
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
							hmObjects.put("n3", entry);
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
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry10(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("n3") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3 = hmObjects.get("n3");
			EObject recovered = ModelManager.getObject(model, entry_n3.getKey());
			if (recovered == null) {
				recovered = entry_n3.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("n3") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3 = hmList.get("n3");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3) {
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
		for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			if (mObjects.size() > obn) {
				objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
			} else {
				continue;
			}
			EObject container = ModelManager.getContainer(m, objectSelection.getObject());
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			AttributeConfigurationStrategy attConfig = null;
			attConfig = new SpecificStringConfigurationStrategy("1");
			;
			atts.put("tokenValue", attConfig);
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
			CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), true,
					referenceSelection, containerSelection, atts, refs, "NumberLiteral");
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
					hmObjects.put("dec", entry);
					AppMutation appMut = registry11(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
			}
			mutator = mut;
			if (mutator != null) {
				mutation12(packages, m, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
						seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
						hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
						classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry11(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m11") != null) {
			cMut.setDef(hmMutator.get("m11"));
			appMut = cMut;
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
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
			referenceSelection = new SpecificReferenceSelection(packages, model, "expression", recovered);
		} else {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection5 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3_5 = hmObjects.get("n3");
		if (entry_n3_5 != null) {
			refSelection5 = new SpecificObjectSelection(packages, model, entry_n3_5.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3_5 = hmList.get("n3");
			if (listEntry_n3_5 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3_5) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection5 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("leftOperand", refSelection5);
		ObSelectionStrategy refSelection6 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_dec_6 = hmObjects.get("dec");
		if (entry_dec_6 != null) {
			refSelection6 = new SpecificObjectSelection(packages, model, entry_dec_6.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_dec_6 = hmList.get("dec");
			if (listEntry_dec_6 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_dec_6) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection6 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("rightOperand", refSelection6);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "InfixExpression");
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
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dnrst/Output" + k[0] + ".model";
			boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
					localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
					registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dnrst", fromNames, k,
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

	private AppMutation registry12(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m12") != null) {
			cMut.setDef(hmMutator.get("m12"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_dnrst(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaNLS.model";
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
						hmObjects.put("exp2", entry);
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			resourcePackages = packages;
			resources = new ArrayList<Resource>();
			resources.add(model);
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
			containerSelectionList.add(containerSelection);
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_exp2) {
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
		if (entry_exp2 != null) {
			EObject obRecovered = ModelManager.getObject(model, entry_exp2.getKey());
			Object valueRecovered = obRecovered;
			Object valueRec = null;
			if (valueRecovered == null) {
				obRecovered = entry_exp2.getKey();
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
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_exp2 = hmList.get("exp2");
			if (listEntry_exp2 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = packages;
				resources = new ArrayList<Resource>();
				resources.add(model);
				EObject obRecovered = ModelManager.getObject(resources, listEntry_exp2.get(0).getKey());
				Object valueRec = null;
				if (obRecovered == null) {
					obRecovered = listEntry_exp2.get(0).getKey();
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
					containerSelectionList.get(j).getModel(), "NumberLiteral", referenceSelectionList.get(j),
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
							hmObjects.put("n3", entry);
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
								hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
						numMutantsGenerated = k[0];
					}
				}
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry14(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
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
			Map<String, List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor,
			int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
			ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException,
			WrongAttributeTypeException, IOException {
		int numMutantsGenerated = 0;
		List<EObject> objects = new ArrayList<EObject>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("n3") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3 = hmObjects.get("n3");
			EObject recovered = ModelManager.getObject(model, entry_n3.getKey());
			if (recovered == null) {
				recovered = entry_n3.getKey();
			}
			objectSelection = new SpecificObjectSelection(packages, model, recovered);
		} else {
			if (hmList.get("n3") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3 = hmList.get("n3");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3) {
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
		for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			if (mObjects.size() > obn) {
				objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
			} else {
				continue;
			}
			EObject container = ModelManager.getContainer(m, objectSelection.getObject());
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			AttributeConfigurationStrategy attConfig = null;
			attConfig = new SpecificStringConfigurationStrategy("1");
			;
			atts.put("tokenValue", attConfig);
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
			CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), true,
					referenceSelection, containerSelection, atts, refs, "NumberLiteral");
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
					hmObjects.put("dec", entry);
					AppMutation appMut = registry15(mut, hmMutator, seed, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
			}
			mutator = mut;
			if (mutator != null) {
				mutation16(packages, m, hmObjects, hmList, hashmapModelFilenames, modelFilename, mutPaths, hmMutator,
						seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI, registry,
						hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test,
						classes);
				numMutantsGenerated = k[0];
			}
		}
		return numMutantsGenerated;
	}

	private AppMutation registry15(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m15") != null) {
			cMut.setDef(hmMutator.get("m15"));
			appMut = cMut;
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
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp2 = hmObjects.get("exp2");
		if (entry_exp2 != null) {
			EObject recovered = ModelManager.getObject(model, entry_exp2.getKey());
			if (recovered == null) {
				recovered = entry_exp2.getKey();
			}
			containerSelection = new SpecificObjectSelection(packages, model, recovered);
			referenceSelection = new SpecificReferenceSelection(packages, model, "rightHandSide", recovered);
		} else {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("-");
		;
		atts.put("operator", attConfig);
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection7 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_n3_7 = hmObjects.get("n3");
		if (entry_n3_7 != null) {
			refSelection7 = new SpecificObjectSelection(packages, model, entry_n3_7.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_n3_7 = hmList.get("n3");
			if (listEntry_n3_7 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_n3_7) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection7 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("leftOperand", refSelection7);
		ObSelectionStrategy refSelection8 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_dec_8 = hmObjects.get("dec");
		if (entry_dec_8 != null) {
			refSelection8 = new SpecificObjectSelection(packages, model, entry_dec_8.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_dec_8 = hmList.get("dec");
			if (listEntry_dec_8 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_dec_8) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection8 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return numMutantsGenerated;
			}
		}
		refs.put("rightOperand", refSelection8);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "InfixExpression");
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
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/dna/Output" + k[0] + ".model";
			boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
					localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename,
					registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "dna", fromNames, k,
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

	private AppMutation registry16(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m16") != null) {
			cMut.setDef(hmMutator.get("m16"));
			appMut = cMut;
		}
		return appMut;
	}

	public int block_dna(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String modelURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testJavaNLS.model";
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
			mutation13(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames, modelFilename, mutPaths,
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dnl") == true)) {
			monitor.subTask("Generating mutants for block dnl (1/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dnl(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dnl");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dnr") == true)) {
			monitor.subTask("Generating mutants for block dnr (2/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dnr(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dnr");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dnrst") == true)) {
			monitor.subTask("Generating mutants for block dnrst (3/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dnrst(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dnrst");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("dna") == true)) {
			monitor.subTask("Generating mutants for block dna (4/4)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_dna(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("dna");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testJavaNLSDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaNLSDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testJavaNLSDynamic.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/WodelTest4Java/data/model/java.ecore",
					testJavaNLSDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "WodelTest4Java/data/model/",
					"testJavaNLSDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
