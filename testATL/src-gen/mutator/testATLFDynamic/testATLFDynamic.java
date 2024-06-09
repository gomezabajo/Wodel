package mutator.testATLFDynamic;

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

public class testATLFDynamic extends MutatorUtils {
	private Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	private List<EObject> mutatedObjects = null;

	private List<Mutator> mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "InPattern");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "filter";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "OperatorCallExp").getObject();
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
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation2(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					entry_p.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				containerSelection = new SpecificObjectSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			List<EObject> recovered = new ArrayList<EObject>();
			recovered.add(entry_p.getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					recovered.get(0));
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "filter", recovered.get(0));
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				referenceSelection = new SpecificReferenceSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), "filter", listEntry_p.get(0).getKey());
			} else {
				return mutations;
			}
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "OperatorCallExp", referenceSelection, containerSelection);
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
			mut.setId("m2");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation3(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "OclFeature");
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
			mut.setId("m3");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					entry_p.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				containerSelection = new SpecificObjectSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			List<EObject> recovered = new ArrayList<EObject>();
			recovered.add(entry_p.getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					recovered.get(0));
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "elements", recovered.get(0));
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				referenceSelection = new SpecificReferenceSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), "elements", listEntry_p.get(0).getKey());
			} else {
				return mutations;
			}
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "SimpleInPatternElement", referenceSelection, containerSelection);
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
			mut.setId("m4");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "OperatorCallExp");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new SpecificStringConfigurationStrategy("and");
		;
		atts.put("operationName", attConfig);
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "OperatorCallExp");
		if (mut != null) {
			mut.setId("m5");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation6(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_conj = hmObjects.get("conj");
		if (entry_conj != null) {
			containerSelection = new SpecificObjectSelection(entry_conj.getValue().getValue(),
					entry_conj.getValue().getKey(), entry_conj.getKey());
			referenceSelection = new SpecificReferenceSelection(entry_conj.getValue().getValue(),
					entry_conj.getValue().getKey(), "source", entry_conj.getKey());
		} else {
			return mutations;
		}
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new CopyAttributeConfigurationStrategy(
				(objectSelection != null ? objectSelection.getObject() : null), hmObjects.get("feat").getKey(),
				"operationName", "name");
		atts.put("operationName", attConfig);
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "OperationCallExp");
		if (mut != null) {
			mut.setId("m6");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m6") != null) {
			cMut.setDef(hmMutator.get("m6"));
			appMut = cMut;
		}
		return appMut;
	}

	private List<Mutator> mutation7(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_call = hmObjects.get("call");
		if (entry_call != null) {
			containerSelection = new SpecificObjectSelection(entry_call.getValue().getValue(),
					entry_call.getValue().getKey(), entry_call.getKey());
			referenceSelection = new SpecificReferenceSelection(entry_call.getValue().getValue(),
					entry_call.getValue().getKey(), "source", entry_call.getKey());
		} else {
			return mutations;
		}
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "VariableExp");
		if (mut != null) {
			mut.setId("m7");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		if (hmMutator.get("m7") != null) {
			cMut.setDef(hmMutator.get("m7"));
			appMut = cMut;
		}
		return appMut;
	}

	private List<Mutator> mutation8(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("sipe") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_sipe = hmObjects.get("sipe");
			objectSelection = new SpecificObjectSelection(entry_sipe.getValue().getValue(),
					entry_sipe.getValue().getKey(), entry_sipe.getKey());
		} else {
			if (hmList.get("sipe") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_sipe = hmList.get("sipe");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_sipe) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_sipe.get(0).getValue().getValue(),
						listEntry_sipe.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("exp") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("variableExp") != null) {
					refs = refsList.get("variableExp");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_exp = hmObjects.get("exp");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_exp.getValue().getKey(),
						objectSelection.getObject(), entry_exp.getKey(), "variableExp", false));
				refsList.put("variableExp", refs);
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
				mut.setId("m8");
				mutations.add(mut);
			}
		}
		return mutations;
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
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("variableExp");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m8") != null) {
			previous = mutator.getPrevious("variableExp");
			next = mutator.getNext("variableExp");
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

	private List<Mutator> mutation9(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("conj") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_conj = hmObjects.get("conj");
			objectSelection = new SpecificObjectSelection(entry_conj.getValue().getValue(),
					entry_conj.getValue().getKey(), entry_conj.getKey());
		} else {
			if (hmList.get("conj") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_conj = hmList.get("conj");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_conj) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_conj.get(0).getValue().getValue(),
						listEntry_conj.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("opce") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("arguments") != null) {
					refs = refsList.get("arguments");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_opce = hmObjects.get("opce");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_opce.getValue().getKey(),
						objectSelection.getObject(), entry_opce.getKey(), "arguments", false));
				refsList.put("arguments", refs);
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
				mut.setId("m9");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private AppMutation registry9(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		refMut0.setRefName("arguments");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m9") != null) {
			previous = mutator.getPrevious("arguments");
			next = mutator.getNext("arguments");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m9"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m9"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	private List<Mutator> mutation10(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("p") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
			objectSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					entry_p.getKey());
		} else {
			if (hmList.get("p") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("conj") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("filter") != null) {
					refs = refsList.get("filter");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_conj = hmObjects.get("conj");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_conj.getValue().getKey(),
						objectSelection.getObject(), entry_conj.getKey(), "filter", false));
				refsList.put("filter", refs);
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
				mut.setId("m10");
				mutations.add(mut);
			}
		}
		return mutations;
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
		refMut0.setRefName("filter");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m10") != null) {
			previous = mutator.getPrevious("filter");
			next = mutator.getNext("filter");
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

	public int block_cf(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testATL/data/model/ATL.ecore";
		String modelURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 2;
			String xmiFilename = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testATLF.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cf/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/cf/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lp52 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lp52 != null) {
							for (Mutator mut : lp52) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("p", entry);
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
						List<Mutator> lopce53 = mutation2(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lopce53 != null) {
							for (Mutator mut : lopce53) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("opce", entry);
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lfeat54 = mutation3(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lfeat54 != null) {
							for (Mutator mut : lfeat54) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("feat", entry);
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
						List<Mutator> lsipe55 = mutation4(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lsipe55 != null) {
							for (Mutator mut : lsipe55) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("sipe", entry);
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lconj56 = mutation5(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lconj56 != null) {
							for (Mutator mut : lconj56) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("conj", entry);
										}
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lcall57 = mutation6(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lcall57 != null) {
							for (Mutator mut : lcall57) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("call", entry);
										}
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
						List<Mutator> lexp58 = mutation7(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lexp58 != null) {
							for (Mutator mut : lexp58) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("exp", entry);
										}
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
						List<Mutator> l59 = mutation8(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l59 != null) {
							for (Mutator mut : l59) {
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l60 = mutation9(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l60 != null) {
							for (Mutator mut : l60) {
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l61 = mutation10(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l61 != null) {
							for (Mutator mut : l61) {
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cf", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
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

	private List<Mutator> mutation11(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("OclExpression");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = true;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "is";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "InPattern").getObject();
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
			mut.setId("m11");
			mutations.add(mut);
		}
		return mutations;
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

	public int block_rf(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testATL/data/model/ATL.ecore";
		String modelURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 2;
			String xmiFilename = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testATLF.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/rf/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/rf/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l62 = mutation11(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l62 != null) {
							for (Mutator mut : l62) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0]
												+ "_11.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "rf", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
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

	private List<Mutator> mutation12(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "InPattern");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "filter";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
		for (EObject obj : objects) {
			SelectObjectMutator mut = new SelectObjectMutator(resources, resourcePackages, referenceSelection,
					containerSelection, obj);
			if (mut != null) {
				mut.setId("m12");
				mutations.add(mut);
			}
		}
		return mutations;
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

	private List<Mutator> mutation13(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					entry_p.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				containerSelection = new SpecificObjectSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		if (entry_p != null) {
			resourcePackages = entry_p.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_p.getValue().getKey());
			List<EObject> recovered = new ArrayList<EObject>();
			recovered.add(entry_p.getKey());
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					recovered.get(0));
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "filter", recovered.get(0));
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_p = hmList.get("p");
			if (listEntry_p != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_p.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_p.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_p) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				referenceSelection = new SpecificReferenceSelection(listEntry_p.get(0).getValue().getValue(),
						listEntry_p.get(0).getValue().getKey(), "filter", listEntry_p.get(0).getKey());
			} else {
				return mutations;
			}
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "OperationCallExp", referenceSelection, containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "operationName";
		((AttributeEvaluation) exp0.first).operator = "different";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add("not");
		((AttributeEvaluation) exp0.first).values.add("and");
		((AttributeEvaluation) exp0.first).values.add("or");
		((AttributeEvaluation) exp0.first).type = "String";
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
			mut.setId("m13");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation14(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "OclFeature");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new AttributeEvaluation();
		((AttributeEvaluation) exp0.first).name = "name";
		((AttributeEvaluation) exp0.first).operator = "different";
		((AttributeEvaluation) exp0.first).values = new ArrayList<Object>();
		((AttributeEvaluation) exp0.first).values.add(ModelManager.getStringAttribute("operationName",
				hmObjects.get("opce") != null ? hmObjects.get("opce").getKey() : null));
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
			mut.setId("m14");
			mutations.add(mut);
		}
		return mutations;
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

	private List<Mutator> mutation15(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("opce") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_opce = hmObjects.get("opce");
			objectSelection = new SpecificObjectSelection(entry_opce.getValue().getValue(),
					entry_opce.getValue().getKey(), entry_opce.getKey());
		} else {
			if (hmList.get("opce") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_opce = hmList.get("opce");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_opce) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_opce.get(0).getValue().getValue(),
						listEntry_opce.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("feat") != null) {
				List<AttributeConfigurationStrategy> atts = null;
				if (attsList.get("operationName") != null) {
					atts = attsList.get("operationName");
				} else {
					atts = new ArrayList<AttributeConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_feat = hmObjects.get("feat");
				atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), entry_feat.getKey(),
						"operationName", "name"));
				attsList.put("operationName", atts);
			} else {
				return mutations;
			}
		}
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null) {
			if (mutatedObjects != null) {
				mutatedObjects.add(objectSelection.getObject());
			}
			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(),
					objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
			if (mut != null) {
				mut.setId("m15");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private AppMutation registry15(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		attMut0.setAttName("name");
		oldAttVal = mutator.getOldAttValue("operationName");
		newAttVal = mutator.getNewAttValue("operationName");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		if (hmMutator.get("m15") != null) {
			attMut0.setDef(hmMutator.get("m15"));
			attsMut.add(attMut0);
			icMut.setDef(hmMutator.get("m15"));
		} else {
			attMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_ccf(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testATL/data/model/ATL.ecore";
		String modelURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			numMutants = 2;
			String xmiFilename = testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath()
					.replace("/bin/", "/") + "data/out/testATLF.model";
			xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
			String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "model/MutatorEnvironment.ecore";
			mutatorecore = mutatorecore.substring(1, mutatorecore.length());
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			k[0] = 0;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/ccf/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/ccf/Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					Resource seed = ModelManager.loadModel(packages,
							URI.createURI("file:/" + modelFilename).toFileString());
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lp63 = mutation12(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lp63 != null) {
							for (Mutator mut : lp63) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
											if (hashmapList.get("p") != null) {
												listEObjects = hashmapList.get("p");
											} else {
												listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
											}
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											listEObjects.add(entry);
											hashmapList.put("p", listEObjects);
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lopce64 = mutation13(packages, model, hashmapEObject, hashmapList, serialize,
								test, classes);
						if (lopce64 != null) {
							for (Mutator mut : lopce64) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("opce", entry);
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
						List<Mutator> lfeat65 = mutation14(packages, model, hashmapEObject, hashmapList, serialize,
								test, classes);
						if (lfeat65 != null) {
							for (Mutator mut : lfeat65) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("feat", entry);
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l66 = mutation15(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l66 != null) {
							for (Mutator mut : l66) {
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "ccf", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes,
							this.getClass(), true, false);
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
			Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project,
			IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		MutationResults mutationResults = new MutationResults();
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 3;
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cf") == true)) {
			monitor.subTask("Generating mutants for block cf (1/3)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cf(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cf");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("rf") == true)) {
			monitor.subTask("Generating mutants for block rf (2/3)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_rf(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("rf");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		fromNames = new ArrayList<String>();
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("ccf") == true)) {
			monitor.subTask("Generating mutants for block ccf (3/3)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_ccf(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k,
					serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("ccf");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages,
					testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/",
							"/") + "data/out/",
					"/testATL/data/model/ATL.ecore", testATLFDynamic.class.getProtectionDomain().getCodeSource()
							.getLocation().getPath().replace("/bin/", "/") + "testATL/data/model/",
					"testATLFDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages,
					testATLFDynamic.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/",
							"/") + "data/out/",
					"/testATL/data/model/ATL.ecore", testATLFDynamic.class.getProtectionDomain().getCodeSource()
							.getLocation().getPath().replace("/bin/", "/") + "testATL/data/model/",
					"testATLFDynamic.java", hashmapMutVersions, this.getClass());
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
