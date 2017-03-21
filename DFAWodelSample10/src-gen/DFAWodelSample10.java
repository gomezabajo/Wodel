
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import manager.ModelManager;
import manager.MutatorMetrics;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;

import exceptions.*;

import appliedMutations.*;

import mutatorenvironment.MutatorEnvironment;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;

public class DFAWodelSample10 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
	//RESET COUNTER: 0
//COUNTER: 1
//METHOD NAME:mutation1
	private ArrayList<Mutator> mutation1(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
//CREATE OBJECT mutation1
ArrayList<EObject> containers = ModelManager.getParentObjects(packages, model, "State");
EObject container = containers.get(ModelManager.getRandomIndex(containers));
ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
ObSelectionStrategy objectSelection = null;
//NAME:name
atts.put("name", new SpecificStringConfigurationStrategy("f")
);
//NAME:isFinal
atts.put("isFinal", new SpecificBooleanConfigurationStrategy(true)
);
HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "State");
//INC COUNTER: 0
if (mut != null) {
	mut.setId("m1");
	mutations.add(mut);
}
//END CREATE OBJECT mutation1
		return mutations;	
	}
//COUNTER: 1
//METHOD NAME:registry1
//REGISTRY COUNTER: 0
private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
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
				System.out.println("FOUND!!!");
				break;
			}
			//Reload input
	    			try {
				mutant.unload();
				mutant.load(null); 
			} catch (Exception e) {}
		}
		if (object != null) {
			cMut.getObject().add(object);
		}
		else {
			cMut.getObject().add(mut.getObject());
		}
	} catch (ModelNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
cMut.setDef(hmMutator.get("m1"));
appMut = cMut;
	return appMut;
}
//COUNTER: 2
//METHOD NAME:mutation2
	private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY TARGET REFERENCE mutation2
		RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "Transition");			
		ObSelectionStrategy newTargetSelection = null;
		if (hmObjects.get("s") != null) {
			newTargetSelection = new SpecificObjectSelection(packages, model, hmObjects.get("s"));
	   			} else {
			return mutations;
		}
		ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(model, packages, sourceSelection, newTargetSelection, "tar");
			   	//INC COUNTER: 1
			   	if (mut != null) {
			   		mut.setId("m2");
			mutations.add(mut);
		}
	//END MODIFY TARGET REFERENCE mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
trcMut.getObject().add(mut.getObject());
trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
trcMut.setDef(hmMutator.get("m2"));
appMut = trcMut;
	return appMut;
}
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics) throws ReferenceNonExistingException, WrongAttributeTypeException, 
											  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
	if (maxAttempts <= 0) {
		maxAttempts = 1;
	}
	
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/DFAAutomaton.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/resources/";
	    
	    HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
	    File[] files = new File(modelURI).listFiles();
	    for (int i = 0; i < files.length; i++) {
	    	if (files[i].isFile() == true) {
	    		String pathfile = files[i].getPath();
	    		if (pathfile.endsWith(".model") == true) {
	    			hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
	    		}
	    	}
	    }
	    
	    //Load MetaModel
	    ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
	    
	    //Load Model
	    Set<String> modelFilenames = hashmapModelFilenames.keySet();
	    for (String modelFilename : modelFilenames) {
	    	HashSet<String> hashsetMutants = new HashSet<String>();
	    	hashsetMutants.add(modelFilename);
	    	Resource model = ModelManager.loadModel(packages, modelFilename);
	    	Resource seed = ModelManager.loadModel(packages, modelFilename);
	    
	    //2
	   	numMutants = 2;
	   	
	   	   		//Generate metrics model
	   	Bundle bundle = Platform.getBundle("wodel.models");
	   		   	URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   	
	   	//Load MetaModel
	   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/out/DFAWodelSample10.model").toFileString());
	   	
	   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
	   			
	   	   	   	for (int i = 0; i < numMutants; i++) {
	   	   	   		HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
	   		HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
	   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
	   	   	   		String mutPath = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + "vs";
	   	   	   		boolean isRepeated = true;
	   	   			int attempts = 0;
	   	   			int max = 0;
	   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
	   			List<String> mutPaths = new ArrayList<String>();
	   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
	   	   				attempts++;
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	
	   	   	   			   	   	//COUNTER: 1	
	   	   	   			//COMMAND: 17
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:s17
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> ls17 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (ls17 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : ls17) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   						hashmapEObject.put("s", mut.getObject());
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
	   	   	   			   	   	//COUNTER: 2	
	   	   	   			//COMMAND: 18
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:18
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> l18 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (l18 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l18) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
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
	   	      
	   	      
	   	      			//MUTANT COMPLETION AND REGISTRY
	   	       			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
	   	      			
	   			isRepeated = registryMutant(packages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, i, mutPaths, hashmapMutVersions);
	   	
	   		    		//Reload input
	   		    		try {
	   				model.unload();
	   				model.load(null); 
	   			} catch (Exception e) {}
	   	   			}
	   	   		}
	
	}

	//Generate metrics model
	Bundle bundle = Platform.getBundle("wodel.models");
   	URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
   	String metricsecore = FileLocator.resolve(fileURL).getFile();
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/out/", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/DFAAutomaton.ecore", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/", "DFAWodelSample10", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10", hashmapMutVersions);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/out/", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/DFAAutomaton.ecore", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10/data/model/", "DFAWodelSample10", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample10", hashmapMutVersions);   			
   		}
   	}
}

