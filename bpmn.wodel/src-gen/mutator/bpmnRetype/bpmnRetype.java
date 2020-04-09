package mutator.bpmnRetype;

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

public class bpmnRetype extends MutatorUtils {
	private List<EObject> mutatedObjects = null;

	private List<Mutator> mutation1(List<EPackage> packages, Resource model,
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize,
			IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		List<Mutator> mutations = new ArrayList<Mutator>();
		List<String> mutTypes = new ArrayList<String>();
		mutTypes.add("AND");
		mutTypes.add("OR");
		mutTypes.add("XOR");
		List<String> targetTypes = new ArrayList<String>();
		targetTypes.add("AND");
		targetTypes.add("OR");
		targetTypes.add("XOR");
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		EObject container = null;
		ObSelectionStrategy containerSelection = null;
		if (objectSelection != null) {
			container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(),
					container);
		}
		SpecificReferenceSelection referenceSelection = null;
		if (containerSelection != null) {
			referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(),
					containerSelection.getModel(), null, null);
		}
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		RetypeObjectMutator mut = null;
		if (objectSelection != null && objectSelection.getObject() != null) {
			mut = new RetypeObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(),
					objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, targetTypes);
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
		ObjectRetyped rMut = AppliedMutationsFactory.eINSTANCE.createObjectRetyped();
		if (mut.getObject() != null) {
			rMut.getObject().add(mut.getObject());
		}
		EObject foundObject = findEObjectForRegistry(seed, mut.getRemovedObject(), mut.getObjectByID(),
				mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			rMut.getRemovedObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		rMut.setNewType(mut.getNewEType());
		rMut.setDef(hmMutator.get("m1"));
		appMut = rMut;
		return appMut;
	}

	public int block_retype(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages,
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
					URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/out/bpmnRetype.model")
							.toFileString());
			Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			int numMutantsToGenerate = numMutants;
			for (int i = 0; i < numMutantsToGenerate; i++) {
				Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
				Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/retype/Output" + i + ".model";
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/retype/Output" + i + "vs";
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
						List<Mutator> l69 = mutation1(packages, model, hashmapEObject, hashmapList, serialize, test,
								classes);
						if (l69 != null) {
							for (Mutator mut : l69) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_1.model";
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
								k++;
							}
						}
					}
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
					isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, seed, model, rules,
							muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames,
							hashmapModelFolders, "retype", fromNames, i, mutPaths, hashmapMutVersions, project,
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
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("retype") == true)) {
			monitor.subTask("Generating mutants for block retype (1/1)");
			int numMutantsGenerated = block_retype(maxAttempts, numMutants, registry, packages, registeredPackages,
					fromNames, hashmapMutants, hashmapMutVersions, project, monitor, 0, serialize, test, classes);
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("retype");
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
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnRetype.java",
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
					"C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/", "bpmnRetype.java",
					hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		return mutationResults;
	}
}
