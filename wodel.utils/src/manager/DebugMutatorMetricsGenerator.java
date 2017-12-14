package manager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import appliedMutations.AppMutation;
import appliedMutations.ObjectCloned;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ObjectRetyped;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import manager.MutatorMetricsGenerator.MutationData;
import manager.MutatorMetricsGenerator.WodelMutantMetric;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DebugMutatorMetrics debug dynamic footprints model generator
 * 
 */
public class DebugMutatorMetricsGenerator extends MutatorMetricsGenerator {

	@Override
	protected MutationData getMutationCreationData(List<EObject> regObjects, EObject object) {
		MutationData mutationData = null;
		EObject mutantObject = null;
		for (EObject regObject : regObjects) {
			if (regObject instanceof AppMutation) {
				mutationData = new MutationData();
				if (regObject instanceof ObjectCreated) {
					mutantObject = ((ObjectCreated) regObject).getObject().get(0);
					mutationData.name = "ObjectCreated";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectCreated) regObject).getDef();
				}
				if (regObject instanceof ObjectCloned) {
					mutantObject = ((ObjectCloned) regObject).getObject().get(0);
					mutationData.name = "ObjectCloned";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectCloned) regObject).getDef();
				}
				if (regObject instanceof ObjectRetyped) {
					if (((ObjectRetyped) regObject).getObject().size() > 0) {
						mutantObject = ((ObjectRetyped) regObject).getObject().get(0);
					}
					mutationData.name = "ObjectRetyped";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectRetyped) regObject).getDef();
				}
				String objectURI = EcoreUtil.getURI(object).toString().replace("//", "/");
				//objectURI = objectURI.substring(objectURI.indexOf("#"));
				if (mutantObject != null) {
					String mutantObjectURI = EcoreUtil.getURI(mutantObject).toString().replace("//", "/");
					//mutantObjectURI = mutantObjectURI.substring(mutantObjectURI.indexOf("#"));
					if (mutantObjectURI.equals(objectURI) == true) {
						return mutationData;
					}
				}
			}
		}
		return null;
	}

	@Override
	protected MutationData getMutationDeletionData(List<EObject> regObjects, EObject object) {
		MutationData mutationData = null;
		EObject mutantObject = null;
		for (EObject regObject : regObjects) {
			if (regObject instanceof AppMutation) {
				mutationData = new MutationData();
				if (regObject instanceof ObjectRemoved) {
					if (((ObjectRemoved) regObject).getObject().size() > 0) {
						mutantObject = ((ObjectRemoved) regObject).getObject().get(0);
					}
					mutationData.name = "ObjectRemoved";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectRemoved) regObject).getDef();
				}
				if (regObject instanceof ObjectRetyped) {
					if (((ObjectRetyped) regObject).getRemovedObject().size() > 0) {
						mutantObject = ((ObjectRetyped) regObject).getRemovedObject().get(0);
					}
					mutationData.name = "ObjectRetyped";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectRetyped) regObject).getDef();
				}
				String objectURI = EcoreUtil.getURI(object).toString().replace("//", "/");
				objectURI = objectURI.substring(objectURI.indexOf("#"));
				if (mutantObject != null) {
					String mutantObjectURI = EcoreUtil.getURI(mutantObject).toString().replace("//", "/");
					mutantObjectURI = mutantObjectURI.substring(mutantObjectURI.indexOf("#"));
					if (mutantObjectURI.equals(objectURI) == true) {
						return mutationData;
					}
				}
			}
		}
		return null;
	}
	
	private List<EObject> mutatedSeedObjects(List<EPackage> packages, String mutantPath, List<EObject> seedObjects, List<EObject> mutantObjects) {
		List<EObject> mutatedSeedObjects = new ArrayList<EObject>();
		mutatedSeedObjects.addAll(seedObjects);
		try {
			for (EObject object : seedObjects) {
				for (EObject mutantObject : mutantObjects) {
					if (EcoreUtil.equals(object.eClass(), mutantObject.eClass())) {
						if (EcoreUtil.equals(object,  mutantObject)) {
							mutatedSeedObjects.remove(object);
							break;
						}
					}
				}
			}
			if (hashmapMutVersions.containsKey(mutantPath) == true) {
				List<String> listMutVersions = hashmapMutVersions.get(mutantPath);
				for (String mutVersionPath : listMutVersions) {
					Resource mutVersion = ModelManager.loadModel(packages, mutVersionPath);
					ArrayList<EObject> mutVersionObjects = ModelManager.getAllObjects(mutVersion);
					for (EObject object : mutVersionObjects) {
						boolean exists = false;
						String objectURI = EcoreUtil.getURI(object).toString().replace("//", "/");
						objectURI = objectURI.substring(objectURI.indexOf("#"));
						for (EObject seedObject: mutatedSeedObjects) {
							if (EcoreUtil.equals(object.eClass(), seedObject.eClass())) {
								String seedObjectURI = EcoreUtil.getURI(seedObject).toString().replace("//", "/");
								seedObjectURI = seedObjectURI.substring(seedObjectURI.indexOf("#"));
								if (seedObjectURI.equals(objectURI)) {
									exists = true;
									break;
								}
							}
						}
						if ((exists == false) && (mutatedSeedObjects.contains(object) != true)) {
							mutatedSeedObjects.add(object);
						}
					}
				}
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutatedSeedObjects;
	}

	private List<EObject> totalMutantObjects(List<EPackage> packages, File mutantFile, List<EObject> seedObjects, List<EObject> mutantObjects) {
		List<EObject> totalMutantObjects = new ArrayList<EObject>();
		totalMutantObjects.addAll(mutantObjects);
		try {
			String mutantPath = mutantFile.getPath().replaceAll("\\\\", "/");
			if (hashmapMutVersions.containsKey(mutantPath) == true) {
				List<String> listMutVersions = hashmapMutVersions.get(mutantPath);
				for (String mutVersionPath : listMutVersions) {
					Resource mutVersion = ModelManager.loadModel(packages, mutVersionPath);
					ArrayList<EObject> mutVersionObjects = ModelManager.getAllObjects(mutVersion);
					for (EObject object : mutVersionObjects) {
						if (totalMutantObjects.contains(object) != true) {
							totalMutantObjects.add(object);
						}
					}
				}
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalMutantObjects;
	}
	
	private List<EObject> totalRegistryObjects(List<EPackage> registry, String mutantPath, List<EObject> regObjects) {
		ArrayList<EObject> totalRegObjects = new ArrayList<EObject>();
		totalRegObjects.addAll(regObjects);
		try {
			if (hashmapMutVersions.containsKey(mutantPath) == true) {
				List<String> listMutVersions = hashmapMutVersions.get(mutantPath);
				for (String versionPath : listMutVersions) {
					String versionRegistryPath = versionPath.substring(0, versionPath.lastIndexOf("/")) + "/registry/" + versionPath.substring(versionPath.lastIndexOf("/") + 1, versionPath.length()).replace(".model", "Registry.model");
					if (new File(versionRegistryPath).exists()) {
						Resource versionRegistry = ModelManager.loadModel(registry, versionRegistryPath);
						ArrayList<EObject> versionRegistryObjects = ModelManager.getAllObjects(versionRegistry);
						for (EObject object : versionRegistryObjects) {
							boolean exists = false;
							for (EObject registryObject : totalRegObjects) {
								if (EcoreUtil.equals(object.eClass(), registryObject.eClass())) {
									if (EcoreUtil.equals(object, registryObject)) {
										exists = true;
										break;
									}
								}
							}
							if ((exists == false) && (totalRegObjects.contains(object) != true)) {
								totalRegObjects.add(object);
							}
						}
					}
				}
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalRegObjects;
	}

	@Override
	protected LinkedHashMap<String, WodelMutantMetric> createMetrics(List<EPackage> packages,
			File seedFile, File folder, EObject met, List<EObject> folders, List<EPackage> registry,
			Resource program, boolean filterAbstract) {
		LinkedHashMap<String, WodelMutantMetric> mutantMetrics = null;
		try {
			if (folder != null) {
				for (File mutantFile : folder.listFiles()) {
					if (mutantFile != null) {
						if (mutantFile.isDirectory() == true) {
							mutantMetrics = createRegistryFolderMetrics(packages, mutantFile, met, seedFile, folder, folders, registry, program, filterAbstract);
						}
						if (mutantFile.isFile() && mutantFile.getName().endsWith(".model")) {
							File newSeed = null;
							if (Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Base metrics", false, null) == false) {
								newSeed = MutatorUtils.getSeedModel(seedFile, mutantFile, output);
							}
							else {
								newSeed = seedFile;
							}
							EObject container = getMetricsContainer(metrics, folder, met, folders);
							List<EObject> newMutants = ModelManager.getReferences("mutants", container);

							EObject mutant = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Mutant"));
							ModelManager.setStringAttribute("name", mutant, mutantFile.getName());
							ModelManager.setStringAttribute("path", mutant, mutantFile.getPath());
							newMutants.add(mutant);
							Resource seedResource = ModelManager.loadModel(packages, newSeed.getPath());
							Resource mutantResource = ModelManager.loadModel(packages, mutantFile.getPath());
							Resource registryResource = ModelManager.loadModel(registry, folder.getPath() + "/registry/" + mutantFile.getName().replace(".model", "Registry.model"));
							List<EObject> seedObjects = ModelManager.getAllObjects(seedResource);
							List<EObject> mutantObjects = ModelManager.getAllObjects(mutantResource);
							List<EObject> regObjects = ModelManager.getAllObjects(registryResource);
							mutantMetrics = new LinkedHashMap<String, WodelMutantMetric>();

							for (EClass eclass : ModelManager.getEClasses(packages)) {
								WodelMutantMetric metric = new WodelMutantMetric();
								mutantMetrics.put(eclass.getName(), metric);
							}
							createSeedObjectsMetrics(seedObjects, mutantMetrics);
							createMutantObjectsMetrics(mutantObjects, mutantMetrics);

							String mutantPath = mutantFile.getPath().replaceAll("\\\\", "/");
							List<EObject> mutatedSeedObjects = mutatedSeedObjects(packages, mutantPath, seedObjects, mutantObjects);
							List<EObject> totalMutantObjects = totalMutantObjects(packages, mutantFile, mutatedSeedObjects, mutantObjects);
							List<EObject> totalRegistryObjects = totalRegistryObjects(registry, mutantPath, regObjects);

							// GETS CREATION DEBUG MUTANT METRICS FROM REGISTRY RESOURCE AND WODEL PROGRAM
							getMutantCreationMetrics(totalRegistryObjects, totalMutantObjects, mutantMetrics, program);

							// GETS MODIFICATION DEBUG MUTANT METRICS FROM REGISTRY RESOURCE AND WODEL PROGRAM
							getMutantMetrics(totalRegistryObjects, seedObjects, mutantMetrics);

							// GETS DELETION MUTANT METRICS FROM REGISTRY RESOURCE AND WODEL PROGRAM
							getMutantDeletionMetrics(totalRegistryObjects, mutatedSeedObjects, mutantMetrics, program);
							
							// STORE THE DEBUG DYNAMIC METRICS
							storeDynamicMetrics(packages, met, mutant, container, mutantMetrics);
						}
					}
				}
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutantMetrics;
	}

	@Override
	public void run() throws MetaModelNotFoundException {
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			EObject met = EcoreUtil.create(ModelManager.getEClassByName(metrics, "MutatorMetrics"));
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
	   		String ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registry = ModelManager.loadMetaModel(ecore);
			String xmiFileName = "file:/" + output +  "/" + fileName.replace(".java", ".model");
			fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
			Resource program = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);
			File out = new File(output);
			for (File file : out.listFiles()) {
				if (file != null) {
					if (file.isDirectory() == true) {
						File seed = new File(modelsFolder + "/" + file.getName() +  ".model");
						createMetrics(packages, seed, file, met, null, registry, program, filterAbstract);
					}
				}
			}
			String path = output + fileName.replace(".java", "") + "_debugMetrics.model";
			ModelManager.createModel(met, path);
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DebugMutatorMetricsGenerator(List<EPackage> metrics, String output, String metamodel, String modelsFolder,
			String fileName, HashMap<String, List<String>> hashmapMutVersions) {
		this.metrics = metrics;
		this.output = output;
		this.metamodel = metamodel;
		this.modelsFolder = modelsFolder;
		this.fileName = fileName;
		this.hashmapMutVersions = hashmapMutVersions;
		
	}
}
