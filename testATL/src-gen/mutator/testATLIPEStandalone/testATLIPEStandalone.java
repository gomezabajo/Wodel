package mutator.testATLIPEStandalone;

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

public class testATLIPEStandalone extends MutatorUtils {
	private static Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	private static List<EObject> mutatedObjects = null;

	private static List<Mutator> mutation1(List<EPackage> packages, Resource model,
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
		String relativeMetamodelPath = "data/model/MyEcore.ecore";
		String absoluteMetamodelPath = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeMetamodelPath;
		resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, testATLIPEStandalone.class);
		resources = new ArrayList<Resource>();
		String relativeEcoreURI_0 = "data/model/in/Families.ecore";
		String absoluteEcoreURI_0 = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeEcoreURI_0;
		absoluteEcoreURI_0 = "file:/" + absoluteEcoreURI_0.substring(1, absoluteEcoreURI_0.length());
		resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages,
				URI.createURI(absoluteEcoreURI_0).toFileString()));
		RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "EClass");
		EObject object = rts.getObject();
		List<EPackage> savedPackages = new ArrayList<EPackage>();
		savedPackages.addAll(packages);
		packages.clear();
		List<EPackage> objectPackages = null;
		resources = new ArrayList<Resource>();
		String relativeEcoreURI_1 = "data/model/in/Families.ecore";
		String absoluteEcoreURI_1 = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath().replace("/bin/", "/") + relativeEcoreURI_1;
		absoluteEcoreURI_1 = "file:/" + absoluteEcoreURI_1.substring(1, absoluteEcoreURI_1.length());
		resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages,
				URI.createURI(absoluteEcoreURI_1).toFileString()));
		String relativeObjectMetamodelPath = "data/model/MyEcore.ecore";
		String absoluteObjectMetamodelPath = testATLIPEStandalone.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath().replace("/bin/", "/") + relativeObjectMetamodelPath;
		objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, testATLIPEStandalone.class);
		packages.addAll(objectPackages);
		packages.clear();
		packages.addAll(savedPackages);
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

	private static AppMutation registry1(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m1") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m1"));
		}
		return appMut;
	}

	private static List<Mutator> mutation2(List<EPackage> packages, Resource model,
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

	private static AppMutation registry2(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m2") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m2"));
		}
		return appMut;
	}

	private static List<Mutator> mutation3(List<EPackage> packages, Resource model,
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
			Object ob = ModelManager.getReferenced("elements", recovered.get(0));
			if (ob instanceof EObject) {
				recovered.add((EObject) ob);
			} else {
				recovered.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
			}
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					recovered.get(1));
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "type", recovered.get(1));
			ob = ModelManager.getReferenced("type", recovered.get(1));
			List<EObject> tmp = new ArrayList<EObject>();
			tmp.add(recovered.get(1));
			if (ob instanceof EObject) {
				tmp.add((EObject) ob);
			} else {
				tmp.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
			}
			recovered = tmp;
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					recovered.get(1));
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "model", recovered.get(1));
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
				containerSelection.getModel(), "OclModel", referenceSelection, containerSelection);
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

	private static AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
			List<String> mutPaths, List<EPackage> packages) {
		AppMutation appMut = null;
		if (hmMutator.get("m3") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m3"));
		}
		return appMut;
	}

	private static List<Mutator> mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_p = hmObjects.get("p");
		if (entry_p != null) {
			containerSelection = new SpecificObjectSelection(entry_p.getValue().getValue(), entry_p.getValue().getKey(),
					entry_p.getKey());
			referenceSelection = new SpecificReferenceSelection(entry_p.getValue().getValue(),
					entry_p.getValue().getKey(), "elements", entry_p.getKey());
		} else {
			return mutations;
		}
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new RandomStringConfigurationStrategy(2, 4, false);
		;
		atts.put("varName", attConfig);
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "SimpleInPatternElement");
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

	private static List<Mutator> mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_ipe = hmObjects.get("ipe");
		if (entry_ipe != null) {
			containerSelection = new SpecificObjectSelection(entry_ipe.getValue().getValue(),
					entry_ipe.getValue().getKey(), entry_ipe.getKey());
			referenceSelection = new SpecificReferenceSelection(entry_ipe.getValue().getValue(),
					entry_ipe.getValue().getKey(), "type", entry_ipe.getKey());
		} else {
			return mutations;
		}
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		AttributeConfigurationStrategy attConfig = null;
		attConfig = new CopyAttributeConfigurationStrategy(
				(objectSelection != null ? objectSelection.getObject() : null), hmObjects.get("cl").getKey(), "name",
				"name");
		atts.put("name", attConfig);
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection3 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_ipe_3 = hmObjects.get("ipe");
		if (entry_ipe_3 != null) {
			refSelection3 = new SpecificObjectSelection(packages, model, entry_ipe_3.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_ipe_3 = hmList.get("ipe");
			if (listEntry_ipe_3 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_ipe_3) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection3 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return mutations;
			}
		}
		refs.put("variableDeclaration", refSelection3);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "OclModelElement");
		if (mut != null) {
			mut.setId("m5");
			mutations.add(mut);
		}
		return mutations;
	}

	private static AppMutation registry5(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
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
		if (hmMutator.get("m5") != null) {
			cMut.setDef(hmMutator.get("m5"));
			appMut = cMut;
		}
		return appMut;
	}

	private static List<Mutator> mutation6(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("mod") != null) {
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_mod = hmObjects.get("mod");
			objectSelection = new SpecificObjectSelection(entry_mod.getValue().getValue(),
					entry_mod.getValue().getKey(), entry_mod.getKey());
		} else {
			if (hmList.get("mod") != null) {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_mod = hmList.get("mod");
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_mod) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_mod.get(0).getValue().getValue(),
						listEntry_mod.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("elem") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("elements") != null) {
					refs = refsList.get("elements");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_elem = hmObjects.get("elem");
				refs.add(new SpecificReferenceConfigurationStrategy(entry_elem.getValue().getKey(),
						objectSelection.getObject(), entry_elem.getKey(), "elements", false));
				refsList.put("elements", refs);
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
				mut.setId("m6");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private static AppMutation registry6(Mutator mut, Map<String, EObject> hmMutator, Resource seed,
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
		refMut0.setRefName("elements");
		refMut0.getObject().add(mutator.getObject());
		refMut0.getMutantObject().add(mutator.getObject());
		if (hmMutator.get("m6") != null) {
			previous = mutator.getPrevious("elements");
			next = mutator.getNext("elements");
			if (previous != null) {
				refMut0.setFrom(previous);
				refMut0.setMutantFrom(previous);
			}
			if (next != null) {
				refMut0.setTo(next);
				refMut0.setMutantTo(next);
			}
			refMut0.setSrcRefName(mutator.getSrcRefType());
			refMut0.setDef(hmMutator.get("m6"));
			refsMut.add(refMut0);
			icMut.setDef(hmMutator.get("m6"));
		} else {
			refMut0 = null;
			icMut = null;
		}
		appMut = icMut;
		return appMut;
	}

	public int block_cipe(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
		String ecoreURI = "/testATL/data/model/ATL.ecore";
		String modelURI = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				.replace("/bin/", "/") + "data/model/";
		String modelsURI = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
			String xmiFilename = testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation()
					.getPath().replace("/bin/", "/") + "data/out/testATLIPE.model";
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
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/cipe/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/cipe/Output" + i + "vs";
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
						List<Mutator> lcl67 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lcl67 != null) {
							for (Mutator mut : lcl67) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("cl", entry);
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
						List<Mutator> lp68 = mutation2(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lp68 != null) {
							for (Mutator mut : lp68) {
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
						List<Mutator> lmod69 = mutation3(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lmod69 != null) {
							for (Mutator mut : lmod69) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("mod", entry);
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
						List<Mutator> lipe70 = mutation4(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lipe70 != null) {
							for (Mutator mut : lipe70) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("ipe", entry);
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
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> lelem71 = mutation5(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lelem71 != null) {
							for (Mutator mut : lelem71) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("elem", entry);
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
						List<Mutator> l72 = mutation6(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l72 != null) {
							for (Mutator mut : l72) {
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
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					int[] mutantIndex = new int[1];
					mutantIndex[0] = i;
					isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages,
							localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry,
							hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "cipe", fromNames,
							mutantIndex, mutPaths, hashmapMutVersions, "testATL", serialize, test, classes,
							testATLIPEStandalone.class, true, false);
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
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("cipe") == true)) {
			monitor.subTask("Generating mutants for block cipe (1/1)");
			int[] k = new int[1];
			k[0] = 0;
			int numMutantsGenerated = block_cipe(maxAttempts, numMutants, registry, packages, registeredPackages,
					localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test,
					classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("cipe");
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, testATLIPEStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testATL/data/model/ATL.ecore",
					testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testATL/data/model/",
					"testATLIPEStandalone.java", hashmapMutVersions, testATLIPEStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, testATLIPEStandalone.class
					.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "data/out/",
					"/testATL/data/model/ATL.ecore",
					testATLIPEStandalone.class.getProtectionDomain().getCodeSource().getLocation().getPath()
							.replace("/bin/", "/") + "testATL/data/model/",
					"testATLIPEStandalone.java", hashmapMutVersions, testATLIPEStandalone.class);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
