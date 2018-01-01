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

public class wco5 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	private ArrayList<Mutator> mutation1(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "InvariantCS");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "exp";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
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
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection,
				objectSelection);
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m1"));
		return appMut;
	}

	private ArrayList<Mutator> mutation2(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, hmObjects.get("inv"));
		SpecificReferenceSelection referenceSelection = null;
		if (hmObjects.get("inv") != null) {
			referenceSelection = new SpecificReferenceSelection(packages, model, "exp", hmObjects.get("inv"));
		} else {
			return mutations;
		}
		HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		atts.put("op", new SpecificStringConfigurationStrategy("not"));
		HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts,
				refs, "LogicExpCS");
		if (mut != null) {
			mut.setId("m2");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
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
		cMut.setDef(hmMutator.get("m2"));
		appMut = cMut;
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
		String ecoreURI = "C:/eclipse/workspace/wco5/data/model/UMLClassDiagram.ecore";
		String modelURI = "C:/eclipse/workspace/wco5/data/model/";
		String modelsURI = "C:/eclipse/workspace/wco5/data/out/";
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
					URI.createURI("file:/C:/eclipse/workspace/wco5/data/out/wco5.model").toFileString());
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
						ArrayList<Mutator> linv383 = mutation1(packages, model, hashmapEObject, hashmapList);
						if (linv383 != null) {
							int k = 0;
							for (Mutator mut : linv383) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											hashmapEObject.put("inv", mut.getObject());
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
						ArrayList<Mutator> l384 = mutation2(packages, model, hashmapEObject, hashmapList);
						if (l384 != null) {
							int k = 0;
							for (Mutator mut : l384) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_2.model";
										ModelManager.saveOutModel(model, mutatorPath);
										if (mutPaths.contains(mutatorPath) == false) {
											mutPaths.add(mutatorPath);
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
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/wco5/data/out/",
					"C:/eclipse/workspace/wco5/data/model/UMLClassDiagram.ecore",
					"C:/eclipse/workspace/wco5/data/model/", "wco5.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/wco5/data/out/",
					"C:/eclipse/workspace/wco5/data/model/UMLClassDiagram.ecore",
					"C:/eclipse/workspace/wco5/data/model/", "wco5.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
	}
}
