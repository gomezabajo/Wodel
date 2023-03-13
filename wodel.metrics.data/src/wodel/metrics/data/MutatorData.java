package wodel.metrics.data;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import appliedMutations.AppMutation;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import mutatorenvironment.Mutator;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorInfo applied mutation information
 * 
 */

public class MutatorData {

	public static class MutatorDataClass {
		public Mutator mutator;
		
		private MutatorDataFeature[] features = new MutatorDataFeature[1];

		public List<MutatorDataSeed> seeds = new ArrayList<MutatorDataSeed>();

		public String getName() {
			return mutator.eClass().getName();
		}
		public MutatorDataFeature[] getFeatures() {
			return features;
		}
		
		public MutatorDataSeed[] getSeeds() {
			MutatorDataSeed[] ret = new MutatorDataSeed[seeds.size()];
			seeds.toArray(ret);
			return ret;
		}
		
		public boolean addSeed(MutatorDataSeed seed) {
			return seeds.add(seed);
		}
		
		public boolean addSeeds(List<MutatorDataSeed> seeds) {
			return this.seeds.addAll(seeds);
		}
		
		public MutatorDataClass() {
			features[0] = new MutatorDataFeature(this, "Seeds");
		}
	}
	
	public static class MutatorDataFeature {
		private MutatorDataClass metric = null;
		private MutatorDataSeed seed = null;
		private String name = null;
		
		public String getName() {
			return name;
		}
		
		public MutatorDataFeature(MutatorDataClass metric, String name) {
			this.metric = metric;
			this.name = name; 
		}
		
		public MutatorDataFeature(MutatorDataSeed seed, String name) {
			this.seed = seed;
			this.name = name;
		}
		
		public MutatorDataSeed[] getSeeds() {
			return this.metric.getSeeds();
		}
		
		public MutatorDataMutant[] getMutants() {
			return this.seed.getMutants();
		}
		
	}
	
	public static class MutatorDataSeed {
		private String path = null;

		private MutatorDataFeature[] features = new MutatorDataFeature[1];
		
		public List<MutatorDataMutant> mutants = new ArrayList<MutatorDataMutant>();

		public void setPath(String path) {
			this.path = path;
		}
		public String getPath() {
			return path;
		}
		
		public MutatorDataMutant[] getMutants() {
			MutatorDataMutant[] ret = new MutatorDataMutant[mutants.size()];
			mutants.toArray(ret);
			return ret;
		}
		
		public boolean addMutant(MutatorDataMutant mutant) {
			return mutants.add(mutant);
		}
		
		public boolean addMutants(List<MutatorDataMutant> mutants) {
			return this.mutants.addAll(mutants);
		}

		public MutatorDataSeed() {
			features[0] = new MutatorDataFeature(this, "Mutants");
		}
	}
	
	public static class MutatorDataMutant {
		private String path = null;

		public void setPath(String path) {
			this.path = path;
		}
		public String getPath() {
			return path;
		}
		
		public MutatorDataMutant() {
			
		}
	}

	public static MutatorDataClass[] createMutatorInfoMetrics(String xmiFileName, String metamodel) {
		try {
			
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
	   		String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			bundle = Platform.getBundle("wodel.models");
	   		fileURL = bundle.getEntry("/model/AppliedMutations.ecore");
	   		String registryecore = FileLocator.resolve(fileURL).getFile();
	   		List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			List<EObject> objects = ModelManager.getAllObjects(program);
			List<EObject> muts = MutatorUtils.getMutatorList(objects);
			String output = ModelManager.getOutputPath();
			HashMap<String, Resource> registryModels = new HashMap<String, Resource>();
			MutatorUtils.getRegistryModels(new File(output), registrypackages, registryModels);

			LinkedHashMap<String, MutatorDataClass> metrics = new LinkedHashMap<String, MutatorDataClass>();
			
			for (EObject mut : muts) {
				MutatorDataClass metric = new MutatorDataClass();
				metric.mutator = (Mutator) mut;
				String mutURI = EcoreUtil.getURI(mut).toString().replace("//", "/");
				mutURI = mutURI.substring(mutURI.indexOf("#"));
				//run over the history registry
				for (String registryFilename : registryModels.keySet()) {
					Resource registry = registryModels.get(registryFilename);
					List<EObject> registryObjects = ModelManager.getAllObjects(registry);
					for (EObject registryObject : registryObjects) {
						if (registryObject instanceof AppMutation) {
							AppMutation appMutation = (AppMutation) registryObject;
							EObject command = appMutation.getDef();
							String commandURI = EcoreUtil.getURI(command).toString().replace("//", "/");
							commandURI = commandURI.substring(commandURI.indexOf("#"));
							if (commandURI.equals(mutURI)) {
								if (metric.seeds == null) {
									metric.seeds = new ArrayList<MutatorDataSeed>();
								}
								String seedFilename = MutatorUtils.getSeedFromRegistry(registryFilename);
								MutatorDataSeed infoSeed = null;
								for (MutatorDataSeed minfo : metric.seeds) {
									if (minfo.getPath().equals(seedFilename)) {
										infoSeed = minfo;
										break;
									}
								}
								if (infoSeed == null) {
									infoSeed = new MutatorDataSeed();
									infoSeed.setPath(seedFilename);
									metric.seeds.add(infoSeed);
								}
								List<String> mutantFilenames = MutatorUtils.getMutantsFromRegistry(registryFilename);
								for (String mutantFilename : mutantFilenames) {
									MutatorDataMutant infoMutant = null;
									for (MutatorDataMutant minfo : infoSeed.mutants) {
										if (minfo.getPath().equals(mutantFilename)) {
											infoMutant = minfo;
											break;
										}
									}
									if (infoMutant == null) {
										infoMutant = new MutatorDataMutant();
										infoMutant.setPath(mutantFilename);
										infoSeed.mutants.add(infoMutant);
									}
								}
							}
						}
					}
				}
				metrics.put(mutURI, metric);
			}
			MutatorDataClass[] ret = new MutatorDataClass[metrics.values().size()];
			metrics.values().toArray(ret);
			return ret;
			
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
