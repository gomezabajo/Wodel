
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

public class DFAWodelSample13 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
			List<EObject> objects = rts.getObjects();
		   					//EXPRESSION LIST: []
		   					//EXPRESSION LEVEL: 0
		   					//EXPRESSION LEVEL: true
		   					Expression exp0 = new Expression();
		   					//INDEX EXPRESSION: 
		   					exp0.first = new ReferenceEvaluation();
		   					//REFERENCE: 
		   					((ReferenceEvaluation) exp0.first).name = "symbol";
		   					((ReferenceEvaluation) exp0.first).operator = "<>";
		   					((ReferenceEvaluation) exp0.first).value = null;
		   					   		exp0.operator = new ArrayList<Operator>();
		   					   		//OPNAME: 
		   					   		exp0.second = new ArrayList<Evaluation>();
		   					   		//EVNAME: 
	   						List<EObject> selectedObjects = evaluate(objects, exp0);
			EObject object = null;
			if (selectedObjects.size() > 0) {
				object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
			}
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
		//CREATE OBJECT mutation2
		ArrayList<EObject> containers = ModelManager.getParentObjects(model, "Transition");
		EObject container = containers.get(ModelManager.getRandomIndex(containers));
		ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		//NAME:src
		  		//REFERENCES COMPILES	13
		ObSelectionStrategy refSelection13 = new SpecificObjectSelection(packages, model, hmObjects.get("t"), "src");
		   		refs.put("src", refSelection13);
		//NAME:symbol
		  		//REFERENCES COMPILES	14
		ObSelectionStrategy refSelection14 = new SpecificObjectSelection(packages, model, hmObjects.get("t"), "symbol");
		   		refs.put("symbol", refSelection14);
		//NAME:tar
		  		//REFERENCES COMPILES	15
		RandomTypeSelection refRts15 = new RandomTypeSelection(packages, model, "State");
		List<EObject> refObjects15 = refRts15.getObjects();
		//INDEX EXPRESSION: 
		Expression exp0 = new Expression();
			   		//INDEX EXPRESSION: 
			   		exp0.first = new ReferenceEvaluation();
			   		//REFERENCE: 
			   		((ReferenceEvaluation) exp0.first).name = null;
			   		((ReferenceEvaluation) exp0.first).operator = "<>";
			   		EObject srcObjExp = new SpecificObjectSelection(packages, model, hmObjects.get("t")).getObject();
			   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
			   						if (ref.getName().equals("tar")) {
			   							((ReferenceEvaluation) exp0.first).value = srcObjExp.eGet(ref);		
			   						}
			   					}
			   		   		exp0.operator = new ArrayList<Operator>();
			   		   		//OPNAME: 
			   		   		exp0.second = new ArrayList<Evaluation>();
			   		   		//EVNAME: 
		   			List<EObject> refSelectedObjects15 = evaluate(refObjects15, exp0);
		EObject refObject15 = null;
		if (refSelectedObjects15.size() > 0) {
			refObject15 = refSelectedObjects15.get(ModelManager.getRandomIndex(refSelectedObjects15));
		}
		ObSelectionStrategy refSelection15 = null;
		if (refObject15 != null) {
		refSelection15 = 
			new SpecificObjectSelection(packages, model, refObject15);
		}
		   		refs.put("tar", refSelection15);
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "Transition");
				   	//INC COUNTER: 1
				   	mut.setId("m2");
		mutations.add(mut);
		//END CREATE OBJECT mutation2
		return mutations;	
	}
	//COUNTER: 2
	//METHOD NAME:registry2
	//REGISTRY COUNTER: 1
	private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
		AppMutation appMut = null;
	ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
	if (mut.getObject() != null) {
		cMut.getObject().add(mut.getObject());
	}
	cMut.setDef(hmMutator.get("m2"));
	appMut = cMut;
		return appMut;
	}
	public void execute(int maxAttempts, int numMutants, boolean registry) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		
		    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample13/model/DFAAutomaton.ecore";
		    
		    String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample13/model/";
		    String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample13/out/";
		    String resourcesURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample13/resources/";
		    
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
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample13/out/DFAWodelSample13.model").toFileString());
		   	
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
		   	   	   			//COMMAND: 39
		   	   	   			//REGISTRY COUNTER: 1
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:t39
		   	   	   			//METHOD NAME:mutation1
		   	   	   			
		   	   	   			ArrayList<Mutator> lt39 = mutation1(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 1
		   	   	   			//REGISTRY METHOD NAME:registry1
		   	   	   			
		   	   	   			if (lt39 != null) {
		   	   	   				for (Mutator mut : lt39) {
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
		   	   	   			//COMMAND: 40
		   	   	   			//REGISTRY COUNTER: 2
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:40
		   	   	   			//METHOD NAME:mutation2
		   	   	   			
		   	   	   			ArrayList<Mutator> l40 = mutation2(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 2
		   	   	   			//REGISTRY METHOD NAME:registry2
		   	   	   			
		   	   	   			if (l40 != null) {
		   	   	   				for (Mutator mut : l40) {
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

