
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

public class DFAWodelSample9 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
		//SELECT OBJECT mutation1
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
			EObject object = rts.getObject();
			ObSelectionStrategy objectSelection = null; 
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, model, object);
			}
	
			ArrayList<EObject> containers = ModelManager.getParentObjects(model, "Transition");
			EObject container = containers.get(ModelManager.getRandomIndex(containers));
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
	
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
			
			SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
		   	//INC COUNTER: 0
		   	mut.setId("m1");
			mutations.add(mut);
		//END SELECT OBJECT mutation1
		return mutations;	
	}
	//COUNTER: 1
	//METHOD NAME:registry1
	//REGISTRY COUNTER: 0
	private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
		AppMutation appMut = null;
	appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
	appMut.setDef(hmMutator.get("m1"));
		return appMut;
	}
	//COUNTER: 2
	//METHOD NAME:mutation2
	private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY INFORMATION mutation2
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
	List<EObject> objects = rts.getObjects();
					   	//EXPRESSION LIST: []
					   	//EXPRESSION LEVEL: 0
					   	//EXPRESSION LEVEL: true
					   	Expression exp0 = new Expression();
					   	//INDEX EXPRESSION: 
					   	exp0.first = new ReferenceEvaluation();
					   	//REFERENCE: 
					   	((ReferenceEvaluation) exp0.first).name = null;
					   	((ReferenceEvaluation) exp0.first).operator = "<>";
					   	((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("t")).getObject();
					   	   		exp0.operator = new ArrayList<Operator>();
					   	   		//OPNAME: 
					   	Operator op0_0 = new Operator();
					   	op0_0.type = "and";
					   	exp0.operator.add(op0_0);
					   	//OPNAME + 1: 1
					   	   		exp0.second = new ArrayList<Evaluation>();
					   	   		//EVNAME: 
					   	ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
					   	ev0_0.name = "src";
					   	   			ev0_0.operator = "=";
					   	EObject srcObjExp0_0 = new SpecificObjectSelection(packages, model, hmObjects.get("t")).getObject();
					   	for (EReference ref : srcObjExp0_0.eClass().getEAllReferences()) {
					   							if (ref.getName().equals("src")) {
					   								ev0_0.value = srcObjExp0_0.eGet(ref);		
					   							}
					   						}
					   	   		exp0.second.add(ev0_0);
					   				//EVNAME + 1: 1
				   		List<EObject> selectedObjects = evaluate(objects, exp0);
	EObject object = null;
	if (selectedObjects.size() > 0) {
		object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
	}
	ObSelectionStrategy objectSelection = null; 
	if (object != null) {
		objectSelection = new SpecificObjectSelection(packages, model, object);
	}
			
		HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		//COUNTER:
	   				
		HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
		//COUNTER:0
		//COUNTER:0
		//NAME:symbol
	if (objectSelection != null) {
					   				refs.put("symbol", new SwapReferenceConfigurationStrategy(objectSelection.getObject(), hmObjects.get("t"), "symbol", "symbol"));
	}
				   			
	if (objectSelection != null) {
		ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
		//INC COUNTER: 1
		mut.setId("m2");
						mutations.add(mut);
	}
	//END MODIFY INFORMATION mutation2
		return mutations;	
	}
	//COUNTER: 2
	//METHOD NAME:registry2
	//REGISTRY COUNTER: 1
	private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		//REFERENCE COUNTER: 
	//
	//
	appliedMutations.ReferenceSwap refMut0 = null;
	refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();
	refMut0.setFirstName("symbol");
	if (ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()) != null) {
		refMut0.setRefObject(ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()));
	}
	refMut0.setRefName("symbol");
	refMut0.setOtherFrom(((ModifyInformationMutator) mut).getOtherSource());
	refMut0.setOtherFromName(((ModifyInformationMutator) mut).getOtherSourceName());
	refMut0.setOtherTo(((ModifyInformationMutator) mut).getOtherTarget());
	refMut0.setOtherToName(((ModifyInformationMutator) mut).getOtherTargetName());
	previous = ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getPrevious());
	next = ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getNext());
	if (previous != null) {
		refMut0.setFrom(previous);
	}
	if (next != null) {
		refMut0.setTo(next);
	}
	refMut0.setDef(hmMutator.get("m2"));
	refsMut.add(refMut0);
	icMut.setDef(hmMutator.get("m2"));
	//REFERENCE COUNTER INC: 0
		appMut = icMut;
		return appMut;
	}
	public void execute(int maxAttempts, int numMutants, boolean registry) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		
		    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample9/model/DFAAutomaton.ecore";
		    
		    String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample9/model/";
		    String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample9/out/";
		    String resourcesURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample9/resources/";
		    
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
		    
		    	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		    	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		    //2
		   	numMutants = 2;
		   	
		   	String mutatorecore = resourcesURI + "MutatorEnvironment.ecore";
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample9/out/DFAWodelSample9.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
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
		   	
		   	   	   			   	   	//COUNTER: 1	
		   	   	   			//COMMAND: 18
		   	   	   			//REGISTRY COUNTER: 1
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:t18
		   	   	   			//METHOD NAME:mutation1
		   	   	   			
		   	   	   			ArrayList<Mutator> lt18 = mutation1(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 1
		   	   	   			//REGISTRY METHOD NAME:registry1
		   	   	   			
		   	   	   			if (lt18 != null) {
		   	   	   				for (Mutator mut : lt18) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						hashmapEObject.put("t", mut.getObject());
		   	   	   						AppMutation appMut = registry1(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 2	
		   	   	   			//COMMAND: 19
		   	   	   			//REGISTRY COUNTER: 2
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:19
		   	   	   			//METHOD NAME:mutation2
		   	   	   			
		   	   	   			ArrayList<Mutator> l19 = mutation2(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 2
		   	   	   			//REGISTRY METHOD NAME:registry2
		   	   	   			
		   	   	   			if (l19 != null) {
		   	   	   				for (Mutator mut : l19) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry2(mut, hmMutator, seed);
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
		   		       			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   	       		if (matchesOCL(model, rules) == true) {
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
		   	       			      					if (emuts.size() > 0) {
		   	   	       			      			EObject emutated = emuts.get(0);
		   	   	       			      			emuts.remove(0);
		   	   	       			      			if (ModelManager.getObject(mutant, emutated) != null) {
		   	   	       			      				emuts.add(ModelManager.getObject(mutant, emutated));
		   	   	       			      			}
		   	   	       			      		}
		   								}
		   								if (mut instanceof ReferenceCreated) {
		   	   								List<EReference> emuts = ((ReferenceCreated) mut).getRef();
		   	   								if (emuts.size() > 0) {
		   	   									EReference emutated = emuts.get(0);
		   	   									emuts.remove(0);
		   	   									if (ModelManager.getReference(mutant, emutated) != null) {
		   	   										emuts.add(ModelManager.getReference(mutant, emutated));
		   	   									}
		   	   								}
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

