package wodel.utils.manager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
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
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * NetMutatorMetricsGenerator net dynamic footprints model generator
 * 
 */
public class NetMutatorMetricsGenerator extends MutatorMetricsGenerator {

	@Override
	public MutationData getMutationCreationData(List<EObject> regObjects, EObject object) {
		MutationData mutationData = null;
		EObject mutantObject = null;
		for (EObject regObject : regObjects) {
			if (regObject instanceof AppMutation) {
				mutationData = new MutationData();
				if (regObject instanceof ObjectCreated && ((ObjectCreated) regObject).getObject().size() > 0) {
					mutantObject = ((ObjectCreated) regObject).getObject().get(0);
					mutationData.name = "ObjectCreated";
					mutationData.primary = mutantObject;
					mutationData.mutator = ((ObjectCreated) regObject).getDef();
				}
				if (regObject instanceof ObjectCloned && ((ObjectCloned) regObject).getObject().size() > 0) {
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
				if (mutantObject != null) {
					if (EcoreUtil.equals(mutantObject, object)) {
						return mutationData;
					}
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

	@Override
	public MutationData getMutationDeletionData(List<EObject> regObjects, EObject object) {
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
				if (mutantObject != null) {
					if (EcoreUtil.equals(mutantObject, object)) {
						return mutationData;
					}
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

	private List<EObject> totalMutantObjects(List<EPackage> packages, File mutantFile, List<EObject> seedObjects, List<EObject> mutantObjects) {
		List<EObject> totalMutantObjects = new ArrayList<EObject>();
		totalMutantObjects.addAll(mutantObjects);
		for (EObject object : seedObjects) {
			String objectURI = EcoreUtil.getURI(object).toString().replace("//", "/");
			objectURI = objectURI.substring(objectURI.indexOf("#"));
			for (EObject mutantObject : mutantObjects) {
				if (object.eClass().getName().equals(mutantObject.eClass().getName())) {
					String mutantObjectURI = EcoreUtil.getURI(mutantObject).toString().replace("//", "/");
					mutantObjectURI = mutantObjectURI.substring(mutantObjectURI.indexOf("#"));
					if (mutantObjectURI.equals(objectURI)) {
						totalMutantObjects.remove(mutantObject);
						break;
					}
				}
			}
		}
		return totalMutantObjects;
	}


	@Override
	protected LinkedHashMap<String, WodelMutantMetric> createMetrics(List<EPackage> packages,
			File seedFile, File folder, EObject met, List<EObject> folders, List<EPackage> registry,
			Resource program, List<String> blockNames, boolean filterAbstract) {
		LinkedHashMap<String, WodelMutantMetric> mutantMetrics = null;
		try {
			if (folder != null) {
				for (File mutantFile : folder.listFiles()) {
					if (mutantFile != null) {
						boolean included = true;
						if (blockNames.size() > 0) {
							included = blockNames.contains(mutantFile.getName());
						}
						if (mutantFile.isDirectory() == true && included) {
							mutantMetrics = createRegistryFolderMetrics(packages, mutantFile, met, seedFile, folder, folders, registry, program, blockNames, filterAbstract);
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
							//Created, removed and modified objects
							createSeedObjectsMetrics(seedObjects, mutantMetrics);
							createMutantObjectsMetrics(mutantObjects, mutantMetrics);

							List<EObject> totalMutantObjects = totalMutantObjects(packages, mutantFile, seedObjects, mutantObjects);

							// GETS CREATION MUTANT METRICS FROM REGISTRY RESOURCE AND WODEL PROGRAM
							getMutantCreationMetrics(regObjects, totalMutantObjects, mutantMetrics, program);

							// GETS MODIFICATION MUTANT METRICS FROM REGISTRY RESOURCE
							getMutantMetrics(regObjects, seedObjects, mutantMetrics);

							// GETS DELETION MUTANT METRICS FROM REGISTRY RESOURCE AND WODEL PROGRAM
							getMutantDeletionMetrics(regObjects, seedObjects, mutantMetrics, program);

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
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel, cls);
			EObject met = EcoreUtil.create(ModelManager.getEClassByName(metrics, "MutatorMetrics"));
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/model/AppliedMutations.ecore");
	   		String ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registry = ModelManager.loadMetaModel(ecore);
			String xmiFileName = output + fileName.replace(".mutator", ".model");
			fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
			ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
			Resource program = ModelManager.loadModel(mutatorecore, xmiFileName);
			List<EObject> blocks = MutatorUtils.getBlocks(program);
			List<String> blockNames = new ArrayList<String>();
			if (blocks != null && blocks.size() > 0) {
				for (EObject block : blocks) {
					String blockName = ModelManager.getStringAttribute("name", block);
					if (blockName != null) {
						blockNames.add(blockName);
					}
				}
			}
			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);
			File out = new File(output);
			for (File file : out.listFiles()) {
				if (file != null) {
					if (file.isDirectory() == true) {
						File seed = new File(modelsFolder + "/" + file.getName() +  ".model");
						createMetrics(packages, seed, file, met, null, registry, program, blockNames, filterAbstract);
					}
				}
			}
			String path = output + fileName.replace(".mutator", "") + "_metrics.model";
			ModelManager.createModel(met, path);
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NetMutatorMetricsGenerator(List<EPackage> metrics, String output, String metamodel, String modelsFolder,
			String fileName, Map<String, List<String>> hashmapMutVersions, Class<?> cls) {
		this.metrics = metrics;
		this.output = output;
		this.metamodel = metamodel;
		File modelsFolderFile = new File(modelsFolder);
		if (!modelsFolderFile.isDirectory()) {
			if (modelsFolder.lastIndexOf("\\") != -1) {
				this.modelsFolder = modelsFolder.substring(0, modelsFolder.lastIndexOf("\\"));
			}
			else {
				this.modelsFolder = modelsFolder.substring(0, modelsFolder.lastIndexOf("/"));
			}
		}
		else {
			this.modelsFolder = modelsFolder;
		}
		this.fileName = fileName.replace("Dynamic.java", ".java");
		this.hashmapMutVersions = hashmapMutVersions;
		this.cls = cls;
	}
}
