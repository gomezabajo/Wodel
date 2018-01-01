import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import manager.ModelManager;
import manager.MutatorMetricsGenerator;
import manager.DebugMutatorMetricsGenerator;
import manager.NetMutatorMetricsGenerator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;
import exceptions.*;
import appliedMutations.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.eclipse.core.runtime.IProgressMonitor;

public class was2e extends manager.MutatorUtils implements manager.IMutatorExecutor {
	private ArrayList<Mutator> mutation1(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Association");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		EObject container = null;
		ObSelectionStrategy containerSelection = null;
		if (objectSelection != null) {
			container = ModelManager.getContainer(model, objectSelection.getObject());
			containerSelection = new SpecificObjectSelection(packages, model, container);
		}
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		RetypeObjectMutator mut = null;
		if (objectSelection != null && objectSelection.getObject() != null) {
			mut = new RetypeObjectMutator(model, packages, objectSelection.getObject(), referenceSelection,
					containerSelection, atts, refs, "Dependency");
		}
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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

	public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics,
			IProgressMonitor monitor) throws ReferenceNonExistingException, WrongAttributeTypeException,
			MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException,
			ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 0;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		numMutants = 2;
		int totalMutants = numMutants * 1;
		totalTasks += totalMutants;
		monitor.beginTask("Generating mutants", totalTasks);
		HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
		String ecoreURI = "C:/eclipse/workspace/was2e/data/model/UMLClassDiagram.ecore";
		String modelURI = "C:/eclipse/workspace/was2e/data/model/";
		String modelsURI = "C:/eclipse/workspace/was2e/data/out/";
		HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				String pathfile = files[i].getPath();
				if (pathfile.endsWith(".model") == true) {
					hashmapModelFilenames.put(pathfile, modelsURI
							+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
				}
			}
		}
		List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		int count = 0;
		for (String modelFilename : modelFilenames) {
			HashSet<String> hashsetMutants = new HashSet<String>();
			hashsetMutants.add(modelFilename);
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages,
					URI.createURI("file:/C:/eclipse/workspace/was2e/data/out/was2e.model").toFileString());
			HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
			for (int i = 0; i < numMutants; i++) {
				HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
				HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
				monitor.subTask("Mutant " + (count * numMutants + i + 1) + "/" + totalMutants + ": " + mutFilename);
				String mutPath = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + "vs";
				boolean isRepeated = true;
				int attempts = 0;
				int max = 0;
				while ((isRepeated == true) && (attempts < maxAttempts)) {
					Resource model = ModelManager.loadModel(packages, modelFilename);
					Resource seed = ModelManager.loadModel(packages, modelFilename);
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						ArrayList<Mutator> l336 = mutation1(packages, model, hashmapEObject, hashmapList);
						if (l336 != null) {
							int k = 0;
							for (Mutator mut : l336) {
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
					HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
					isRepeated = registryMutant(ecoreURI, packages, seed, model, rules, muts, modelFilename,
							mutFilename, registry, hashsetMutants, hashmapModelFilenames, i, mutPaths,
							hashmapMutVersions);
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
				monitor.worked(1);
			}
			count++;
		}
		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
		String metricsecore = FileLocator.resolve(fileURL).getFile();
		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/was2e/data/out/",
					"C:/eclipse/workspace/was2e/data/model/UMLClassDiagram.ecore",
					"C:/eclipse/workspace/was2e/data/model/", "was2e.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/was2e/data/out/",
					"C:/eclipse/workspace/was2e/data/model/UMLClassDiagram.ecore",
					"C:/eclipse/workspace/was2e/data/model/", "was2e.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
	}
}
