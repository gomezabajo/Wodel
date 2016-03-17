
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import manager.ModelManager;

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
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class DFAWodelSample extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
		//MODIFY TARGET REFERENCE mutation1
			RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "Transition");			
	
			EObject otherSourceSelection = null; 
			otherSourceSelection = sourceSelection.getObject();
			Object otherRef = null;
			if (otherSourceSelection != null) {
				for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {
					if (ref.getName().equals("tar")) {
						otherRef = otherSourceSelection.eGet(ref);
						break;
					}
				}
			}
			OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, "State", otherRef);
	
			ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(model, packages, sourceSelection, newTargetSelection, "tar");
					   	//INC COUNTER: 0
					   	mut.setId("m1");
			mutations.add(mut);
		//END MODIFY TARGET REFERENCE mutation1
		return mutations;	
	}
	//COUNTER: 1
	//METHOD NAME:registry1
	//REGISTRY COUNTER: 0
	private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
		AppMutation appMut = null;
	TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
	trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
	trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
	trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
	trcMut.setDef(hmMutator.get("m1"));
	appMut = trcMut;
		return appMut;
	}
	
	public void execute(int maxAttempts, boolean registry) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/";
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
		   
		   HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	HashSet<String> hashsetMutants = new HashSet<String>();
		   	hashsetMutants.add(modelFilename);
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   //MUTANTS: []
		   
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/DFAWodelSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < 2; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				
		   	   	   			   	   	//COUNTER: 1	
		   	   	   			//COMMAND: 9
		   	   	   			//REGISTRY COUNTER: 1
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:9
		   	   	   			//METHOD NAME:mutation1
		   	   	   			
		   	   	   			ArrayList<Mutator> l9 = mutation1(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 1
		   	   	   			//REGISTRY METHOD NAME:registry1
		   	   	   			
		   	   	   			if (l9 != null) {
		   	   	   				for (Mutator mut : l9) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry1(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	      
		   			// COMPLETES MUTANT
		   	   		int valid = complete(packages, model);
		   		       		if (valid != 1) {
		   		       			// VERIFY THE OCL CONSTRAINTS
		   	       		if (matchesOCL(model) == true) {
		   		   					// VERIFY IF MUTANT IS DIFFERENT
		   	   						isRepeated = different(packages, model, hashsetMutants);
		   	   					
		   	   						System.out.println("isRepeated: " + isRepeated);
		   	   						// IF MUTANT IS DIFFERENT STORES IT AND PROCEEDS
		   	   						if (isRepeated == false) {
		   		      			File outputFolder = new File(hashmapModelFilenames.get(modelFilename));
		   	      						if (outputFolder.exists() != true) {
		   	      							outputFolder.mkdir();
		   	      						}
		   	       						ModelManager.saveOutModel(model, mutFilename);
		   	       			      		hashsetMutants.add(mutFilename);
		   	       			      		if (registry == true) {
		   	       			      			Resource mutant = ModelManager.loadModel(packages, mutFilename);
		   							for (AppMutation mut : muts.getMuts()) {
		   	       			      				if (mut instanceof ObjectCreated) {
		   	       			      					List<EObject> emuts = ((ObjectCreated) mut).getObject();
		   	   	       			      		EObject emutated = emuts.get(0);
		   	   	       			      		emuts.remove(0);
		   	   	       			      		emuts.add(ModelManager.getObject(mutant, emutated));
		   								}
		   								if (mut instanceof ReferenceCreated) {
		   	   								List<EReference> emuts = ((ReferenceCreated) mut).getRef();
		   	   								EReference emutated = emuts.get(0);
		   	   								emuts.remove(0);
		   	   								emuts.add(ModelManager.getReference(mutant, emutated));
		   	   							}
		   	       			      			}
		   		       			      		File registryFolder = new File(hashmapModelFilenames.get(modelFilename) + "/registry");
		   	    	   			      		if (registryFolder.exists() != true) {
		   	       				      			registryFolder.mkdir();
		   	       				      		}
		   	       				      		String registryFilename = hashmapModelFilenames.get(modelFilename) + "/registry/" + "Output" + i + "Registry.model";
		   	       			    	  		ModelManager.createModel(muts, registryFilename);
		   	       			      		}
		   					}
		   				}
		   			}   
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}   
		
		}
	}
	
}

