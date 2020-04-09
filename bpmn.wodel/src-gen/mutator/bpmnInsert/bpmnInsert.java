package mutator.bpmnInsert;

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

public class bpmnInsert extends MutatorUtils {
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
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Sequence");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "to";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).attName = null;
		((ReferenceEvaluation) exp0.first).operator = "not";
		((ReferenceEvaluation) exp0.first).value = new TypedSelection(packages, model, "EndEv").getObject();
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
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_s = hmObjects.get("s");
		if (entry_s != null) {
			resourcePackages = entry_s.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_s.getValue().getKey());
			containerSelection = new SpecificObjectSelection(entry_s.getValue().getValue(), entry_s.getValue().getKey(),
					entry_s.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_s = hmList.get("s");
			if (listEntry_s != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_s.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_s.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_s) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				containerSelection = new SpecificObjectSelection(listEntry_s.get(0).getValue().getValue(),
						listEntry_s.get(0).getValue().getKey(), objs);
			} else {
				return mutations;
			}
		}
		if (entry_s != null) {
			resourcePackages = entry_s.getValue().getValue();
			resources = new ArrayList<Resource>();
			resources.add(entry_s.getValue().getKey());
			List<EObject> recovered = new ArrayList<EObject>();
			recovered.add(entry_s.getKey());
			containerSelection = new SpecificObjectSelection(entry_s.getValue().getValue(), entry_s.getValue().getKey(),
					recovered.get(0));
			referenceSelection = new SpecificReferenceSelection(entry_s.getValue().getValue(),
					entry_s.getValue().getKey(), "to", recovered.get(0));
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_s = hmList.get("s");
			if (listEntry_s != null) {
				List<EObject> objs = new ArrayList<EObject>();
				resourcePackages = listEntry_s.get(0).getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(listEntry_s.get(0).getValue().getKey());
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_s) {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				referenceSelection = new SpecificReferenceSelection(listEntry_s.get(0).getValue().getValue(),
						listEntry_s.get(0).getValue().getKey(), "to", listEntry_s.get(0).getKey());
			} else {
				return mutations;
			}
		}
		RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(),
				containerSelection.getModel(), "FlowObject", referenceSelection, containerSelection);
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
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Activity");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		atts.put("name", new SpecificStringConfigurationStrategy("newActivity"));
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Activity");
		if (mut != null) {
			mut.setId("m3");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry3(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		cMut.setDef(hmMutator.get("m3"));
		appMut = cMut;
		return appMut;
	}

	private List<Mutator> mutation4(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy sourceSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_s = hmObjects.get("s");
		if (entry_s != null) {
			sourceSelection = new SpecificObjectSelection(entry_s.getValue().getValue(), entry_s.getValue().getKey(),
					entry_s.getKey());
		} else {
			return mutations;
		}
		ObSelectionStrategy newTargetSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a = hmObjects.get("a");
		if (entry_a != null) {
			newTargetSelection = new SpecificObjectSelection(entry_a.getValue().getValue(), entry_a.getValue().getKey(),
					entry_a.getKey());
		} else {
			return mutations;
		}
		ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(),
				sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "to");
		if (mut != null) {
			mut.setId("m4");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry4(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		trcMut.getObject().add(mut.getObject());
		trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
		trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
		trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
		trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
		trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
		trcMut.setDef(hmMutator.get("m4"));
		appMut = trcMut;
		return appMut;
	}

	private List<Mutator> mutation5(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<EObject> containers = ModelManager.getParentObjects(packages, model, "Sequence");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		atts.put("name", new SpecificStringConfigurationStrategy("newSeq"));
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		ObSelectionStrategy refSelection5 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_a_5 = hmObjects.get("a");
		if (entry_a_5 != null) {
			refSelection5 = new SpecificObjectSelection(packages, model, entry_a_5.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_a_5 = hmList.get("a");
			if (listEntry_a_5 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_a_5) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection5 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return mutations;
			}
		}
		refs.put("from", refSelection5);
		ObSelectionStrategy refSelection6 = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_f_6 = hmObjects.get("f");
		if (entry_f_6 != null) {
			refSelection6 = new SpecificObjectSelection(packages, model, entry_f_6.getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_f_6 = hmList.get("f");
			if (listEntry_f_6 != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_f_6) {
					EObject obj = ModelManager.getObject(model, ent.getKey());
					objs.add(obj);
				}
				refSelection6 = new SpecificObjectSelection(packages, model, objs);
			} else {
				return mutations;
			}
		}
		refs.put("to", refSelection6);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "Sequence");
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
					cMut.getObject().add(mut.getObject());
				}
			} catch (ModelNotFoundException e) {
				e.printStackTrace();
			}
		}
		cMut.setDef(hmMutator.get("m5"));
		appMut = cMut;
		return appMut;
	}

	public int block_insert(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
					URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/bpmnInsert.model")
							.toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/insert/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/insert/Output" + i + "vs";
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
						List<Mutator> ls70 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (ls70 != null) {
							for (Mutator mut : ls70) {
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
						List<Mutator> lf71 = mutation2(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (lf71 != null) {
							for (Mutator mut : lf71) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("f", entry);
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
						List<Mutator> la72 = mutation3(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (la72 != null) {
							for (Mutator mut : la72) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(
													mut.getModel(), mut.getMetaModel());
											SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(
													mut.getObject(), resourceEntry);
											hashmapEObject.put("a", entry);
										}
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_3.model";
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
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l73 = mutation4(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l73 != null) {
							for (Mutator mut : l73) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_4.model";
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
								k++;
							}
						}
					}
					max = 1;
					for (int j = 0; j < max; j++) {
						List<Mutator> l74 = mutation5(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l74 != null) {
							for (Mutator mut : l74) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_5.model";
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
								k++;
							}
						}
					}
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, seed, model, rules,
							muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames,
							hashmapModelFolders, "insert", fromNames, i, mutPaths, hashmapMutVersions, project,
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("insert") == true)) {
			monitor.subTask("Generating mutants for block insert (1/1)");
			int numMutantsGenerated = block_insert(maxAttempts, numMutants, registry, packages, registeredPackages,
					fromNames, hashmapMutants, hashmapMutVersions, project, monitor, 0, serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("insert");
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
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnInsert.java",
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
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnInsert.java",
					hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
