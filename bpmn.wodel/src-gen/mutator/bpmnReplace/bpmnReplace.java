package mutator.bpmnReplace;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import manager.IWodelTest;
import manager.ModelManager;
import manager.MutatorMetricsGenerator;
import manager.DebugMutatorMetricsGenerator;
import manager.NetMutatorMetricsGenerator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;
import exceptions.*;
import appliedMutations.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.eclipse.core.runtime.IProgressMonitor;
import manager.MutatorUtils;

public class bpmnReplace extends MutatorUtils {
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Activity");
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
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m1"));
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Sequence");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "to";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("a0");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
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
			mut.setId("m2");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m2"));
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Sequence");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "from";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("a0");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
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
			mut.setId("m3");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m3"));
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Activity");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = null;
		((ReferenceEvaluation) exp0.first).container = false;
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("a0");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
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
			mut.setId("m4");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m4"));
		return appMut;
	}

	private List<Mutator> mutation5(List<EPackage> packages, Resource model,
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Sequence");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "to";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("a1");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
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
			mut.setId("m5");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m5"));
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
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Sequence");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "from";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "equals";
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_0 = hmObjects.get("a1");
		if (entry_0 != null) {
			((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(entry_0.getValue().getValue(),
					entry_0.getValue().getKey(), entry_0.getKey()).getObject();
		}
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
			mut.setId("m6");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m6"));
		return appMut;
	}

	private List<Mutator> mutation7(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("src0") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_src0 = hmObjects.get("src0");
			objectSelection = new SpecificObjectSelection(entry_src0.getValue().getValue(),
					entry_src0.getValue().getKey(), entry_src0.getKey());
		} else {
			if (hmList.get("src0") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_src0 = hmList.get("src0");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_src0) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_src0.get(0).getValue().getValue(),
						listEntry_src0.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("a1") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("to") != null) {
					refs = refsList.get("to");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a1 = hmObjects.get("a1");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_a1.getValue().getKey(),
						objectSelection.getObject(), entry_a1.getKey(), "to"));
				refsList.put("to", refs);
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
				mut.setId("m7");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private AppMutation registry7(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("to");
		refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious("to");
		next = ((ModifyInformationMutator) mut).getNext("to");
		if (previous != null) {
			refMut0.setFrom(previous);
		}
		if (next != null) {
			refMut0.setTo(next);
		}
		refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut0.setDef(hmMutator.get("m7"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m7"));
		appMut = icMut;
		return appMut;
	}

	private List<Mutator> mutation8(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("tar0") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_tar0 = hmObjects.get("tar0");
			objectSelection = new SpecificObjectSelection(entry_tar0.getValue().getValue(),
					entry_tar0.getValue().getKey(), entry_tar0.getKey());
		} else {
			if (hmList.get("tar0") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_tar0 = hmList.get("tar0");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_tar0) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_tar0.get(0).getValue().getValue(),
						listEntry_tar0.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("a1") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("from") != null) {
					refs = refsList.get("from");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a1 = hmObjects.get("a1");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_a1.getValue().getKey(),
						objectSelection.getObject(), entry_a1.getKey(), "from"));
				refsList.put("from", refs);
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
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("from");
		refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious("from");
		next = ((ModifyInformationMutator) mut).getNext("from");
		if (previous != null) {
			refMut0.setFrom(previous);
		}
		if (next != null) {
			refMut0.setTo(next);
		}
		refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut0.setDef(hmMutator.get("m8"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m8"));
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
		if (hmObjects.get("src1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_src1 = hmObjects.get("src1");
			objectSelection = new SpecificObjectSelection(entry_src1.getValue().getValue(),
					entry_src1.getValue().getKey(), entry_src1.getKey());
		} else {
			if (hmList.get("src1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_src1 = hmList.get("src1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_src1) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_src1.get(0).getValue().getValue(),
						listEntry_src1.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("a0") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("to") != null) {
					refs = refsList.get("to");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a0 = hmObjects.get("a0");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_a0.getValue().getKey(),
						objectSelection.getObject(), entry_a0.getKey(), "to"));
				refsList.put("to", refs);
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
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("to");
		refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious("to");
		next = ((ModifyInformationMutator) mut).getNext("to");
		if (previous != null) {
			refMut0.setFrom(previous);
		}
		if (next != null) {
			refMut0.setTo(next);
		}
		refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut0.setDef(hmMutator.get("m9"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m9"));
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
		if (hmObjects.get("tar1") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_tar1 = hmObjects.get("tar1");
			objectSelection = new SpecificObjectSelection(entry_tar1.getValue().getValue(),
					entry_tar1.getValue().getKey(), entry_tar1.getKey());
		} else {
			if (hmList.get("tar1") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_tar1 = hmList.get("tar1");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_tar1) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_tar1.get(0).getValue().getValue(),
						listEntry_tar1.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("a0") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("from") != null) {
					refs = refsList.get("from");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a0 = hmObjects.get("a0");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_a0.getValue().getKey(),
						objectSelection.getObject(), entry_a0.getKey(), "from"));
				refsList.put("from", refs);
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
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("from");
		refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious("from");
		next = ((ModifyInformationMutator) mut).getNext("from");
		if (previous != null) {
			refMut0.setFrom(previous);
		}
		if (next != null) {
			refMut0.setTo(next);
		}
		refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut0.setDef(hmMutator.get("m10"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m10"));
		appMut = icMut;
		return appMut;
	}

	public int block_replace(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants,
			Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int k,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/simplebpmn.ecore";
		String modelURI = "C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/";
		String modelsURI = "C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/";
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
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages,
					URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/bpmnReplace.model")
							.toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/replace/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/replace/Output" + i + "vs";
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
					k = 0;
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> la054 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (la054 != null) {
							for (Mutator mut : la054) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("a0", entry);
										}
										AppMutation appMut = registry1(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lsrc055 = mutation2(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lsrc055 != null) {
							for (Mutator mut : lsrc055) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("src0", entry);
										}
										AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> ltar056 = mutation3(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ltar056 != null) {
							for (Mutator mut : ltar056) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("tar0", entry);
										}
										AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> la157 = mutation4(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (la157 != null) {
							for (Mutator mut : la157) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("a1", entry);
										}
										AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lsrc158 = mutation5(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lsrc158 != null) {
							for (Mutator mut : lsrc158) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("src1", entry);
										}
										AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> ltar159 = mutation6(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ltar159 != null) {
							for (Mutator mut : ltar159) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("tar1", entry);
										}
										AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
										if (appMut != null) {
											muts.getMuts().add(appMut);
										}
									}
								}
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l60 = mutation7(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l60 != null) {
							for (Mutator mut : l60) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_7.model";
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
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l61 = mutation8(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l61 != null) {
							for (Mutator mut : l61) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_8.model";
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
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l62 = mutation9(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l62 != null) {
							for (Mutator mut : l62) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_9.model";
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
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l63 = mutation10(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l63 != null) {
							for (Mutator mut : l63) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_10.model";
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
								k++;
							}
						}
					}
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, seed, model, rules,
							muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames,
							hashmapModelFolders, "replace", fromNames, i, mutPaths, hashmapMutVersions, project,
							serialize, test, classes);
					if (isRepeated == false) {
						numMutantsGenerated++;
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
			String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test,
			TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException,
			MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException,
			ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		MutationResults mutationResults = new MutationResults();
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 1;
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("replace") == true)) {
			monitor.subTask("Generating mutants for block replace (1/1)");
			int numMutantsGenerated = block_replace(maxAttempts, numMutants, registry, packages, registeredPackages,
					fromNames, hashmapMutants, hashmapMutVersions, project, monitor, 0, serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("replace");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
		String metricsecore = FileLocator.resolve(fileURL).getFile();
		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages,
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/",
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/simplebpmn.ecore",
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnReplace.java",
					hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages,
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/",
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/simplebpmn.ecore",
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnReplace.java",
					hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
