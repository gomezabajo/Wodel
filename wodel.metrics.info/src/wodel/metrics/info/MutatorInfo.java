package wodel.metrics.info;

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
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.MutatorUtils;
import mutatorenvironment.Mutator;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorInfo applied mutation information
 * 
 */

public class MutatorInfo {

	public static class MutatorInfoClass {
		public Mutator mutator;
		
		private MutatorInfoFeature[] features = new MutatorInfoFeature[1];

		public List<MutatorInfoSeed> seeds = new ArrayList<MutatorInfoSeed>();

		public String getName() {
			return mutator.eClass().getName();
		}
		public MutatorInfoFeature[] getFeatures() {
			return features;
		}
		
		public MutatorInfoSeed[] getSeeds() {
			MutatorInfoSeed[] ret = new MutatorInfoSeed[seeds.size()];
			seeds.toArray(ret);
			return ret;
		}
		
		public boolean addSeed(MutatorInfoSeed seed) {
			return seeds.add(seed);
		}
		
		public boolean addSeeds(List<MutatorInfoSeed> seeds) {
			return this.seeds.addAll(seeds);
		}
		
		public MutatorInfoClass() {
			features[0] = new MutatorInfoFeature(this, "Seeds");
		}
	}
	
	public static class MutatorInfoFeature {
		private MutatorInfoClass metric = null;
		private MutatorInfoSeed seed = null;
		private String name = null;
		
		public String getName() {
			return name;
		}
		
		public MutatorInfoFeature(MutatorInfoClass metric, String name) {
			this.metric = metric;
			this.name = name; 
		}
		
		public MutatorInfoFeature(MutatorInfoSeed seed, String name) {
			this.seed = seed;
			this.name = name;
		}
		
		public MutatorInfoSeed[] getSeeds() {
			return this.metric.getSeeds();
		}
		
		public MutatorInfoMutant[] getMutants() {
			return this.seed.getMutants();
		}
		
	}
	
	public static class MutatorInfoSeed {
		private String path = null;

		private MutatorInfoFeature[] features = new MutatorInfoFeature[1];
		
		public List<MutatorInfoMutant> mutants = new ArrayList<MutatorInfoMutant>();

		public void setPath(String path) {
			this.path = path;
		}
		public String getPath() {
			return path;
		}
		
		public MutatorInfoMutant[] getMutants() {
			MutatorInfoMutant[] ret = new MutatorInfoMutant[mutants.size()];
			mutants.toArray(ret);
			return ret;
		}
		
		public boolean addMutant(MutatorInfoMutant mutant) {
			return mutants.add(mutant);
		}
		
		public boolean addMutants(List<MutatorInfoMutant> mutants) {
			return this.mutants.addAll(mutants);
		}

		public MutatorInfoSeed() {
			features[0] = new MutatorInfoFeature(this, "Mutants");
		}
	}
	
	public static class MutatorInfoMutant {
		private String path = null;

		public void setPath(String path) {
			this.path = path;
		}
		public String getPath() {
			return path;
		}
		
		public MutatorInfoMutant() {
			
		}
	}

	public static MutatorInfoClass[] createMutatorInfoMetrics(String xmiFileName, String metamodel) {
		try {
			
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			bundle = Platform.getBundle("wodel.models");
	   		fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
	   		String registryecore = FileLocator.resolve(fileURL).getFile();
	   		List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			ArrayList<EObject> objects = ModelManager.getAllObjects(program);
			List<EObject> muts = MutatorUtils.getMutatorList(objects);
			String output = ModelManager.getOutputPath();
			HashMap<String, Resource> registryModels = new HashMap<String, Resource>();
			MutatorUtils.getRegistryModels(new File(output), registrypackages, registryModels);

			LinkedHashMap<String, MutatorInfoClass> metrics = new LinkedHashMap<String, MutatorInfoClass>();
			
			for (EObject mut : muts) {
				MutatorInfoClass metric = new MutatorInfoClass();
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
									metric.seeds = new ArrayList<MutatorInfoSeed>();
								}
								String seedFilename = MutatorUtils.getSeedFromRegistry(registryFilename);
								MutatorInfoSeed infoSeed = null;
								for (MutatorInfoSeed minfo : metric.seeds) {
									if (minfo.getPath().equals(seedFilename)) {
										infoSeed = minfo;
										break;
									}
								}
								if (infoSeed == null) {
									infoSeed = new MutatorInfoSeed();
									infoSeed.setPath(seedFilename);
									metric.seeds.add(infoSeed);
								}
								List<String> mutantFilenames = MutatorUtils.getMutantsFromRegistry(registryFilename);
								for (String mutantFilename : mutantFilenames) {
									MutatorInfoMutant infoMutant = null;
									for (MutatorInfoMutant minfo : infoSeed.mutants) {
										if (minfo.getPath().equals(mutantFilename)) {
											infoMutant = minfo;
											break;
										}
									}
									if (infoMutant == null) {
										infoMutant = new MutatorInfoMutant();
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
			MutatorInfoClass[] ret = new MutatorInfoClass[metrics.values().size()];
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
