
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

public class SecurityPoliciesWodelSampleRTT extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
	ObSelectionStrategy containerSelection = null;
	SpecificReferenceSelection referenceSelection = null;
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "RuleType");
	EObject object = rts.getObject();
	
	ObSelectionStrategy objectSelection = null; 
	if (object != null) {
		objectSelection = new SpecificObjectSelection(packages, model, object);
	}
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
		//INC COUNTER: 0
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		//END SELECT OBJECT mutation1
		return mutations;	
	}
//COUNTER: 1
//METHOD NAME:registry1
//REGISTRY COUNTER: 0
private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
appMut.setDef(hmMutator.get("m1"));
	return appMut;
}
//COUNTER: 2
//METHOD NAME:mutation2
	private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
//SELECT OBJECT mutation2
	ObSelectionStrategy containerSelection = null;
	SpecificReferenceSelection referenceSelection = null;
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "RuleType");
	
	List<EObject> objects = rts.getObjects();
	//EXPRESSION LIST: []
	//EXPRESSION LEVEL: 0
	//EXPRESSION LEVEL: true
	Expression exp0 = new Expression();
	//INDEX EXPRESSION: 
	exp0.first = new ReferenceEvaluation();
	//REFERENCE: 
	((ReferenceEvaluation) exp0.first).name = null;
	((ReferenceEvaluation) exp0.first).refName = null;
	((ReferenceEvaluation) exp0.first).operator = "different";
	((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("t1")).getObject();
	   		exp0.operator = new ArrayList<Operator>();
	   		//OPNAME: 
	Operator op0_0 = new Operator();
	op0_0.type = "and";
	exp0.operator.add(op0_0);
	//OPNAME + 1: 1
	   		exp0.second = new ArrayList<Evaluation>();
	   		//EVNAME: 
	ReferenceEvaluation ev0_0 = new ReferenceEvaluation();
	ev0_0.name = "parameters";
	ev0_0.refName = null;
	   			ev0_0.operator = "equals";
	EObject srcObjExp0_0 = hmObjects.get("t1");
	for (EReference ref : srcObjExp0_0.eClass().getEAllReferences()) {
							if (ref.getName().equals("parameters")) {
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
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
		//INC COUNTER: 1
		if (mut != null) {
			mut.setId("m2");
			mutations.add(mut);
		}
		//END SELECT OBJECT mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
appMut.setDef(hmMutator.get("m2"));
	return appMut;
}
//COUNTER: 3
//METHOD NAME:mutation3
	private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY INFORMATION mutation3
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Rule");
	List<EObject> objects = rts.getObjects();
			   	//EXPRESSION LIST: []
			   	//EXPRESSION LEVEL: 0
			   	//EXPRESSION LEVEL: true
			   	Expression exp0 = new Expression();
			   	//INDEX EXPRESSION: 
			   	exp0.first = new ReferenceEvaluation();
			   	//REFERENCE: 
			   	((ReferenceEvaluation) exp0.first).name = "type";
			   	((ReferenceEvaluation) exp0.first).refName = null;
			   	((ReferenceEvaluation) exp0.first).operator = "equals";
			   	((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("t1")).getObject();
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
			
	HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
	//COUNTER:
	   				
	HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
	HashMap<String, AttributeConfigurationStrategy> attsRef = new HashMap<String, AttributeConfigurationStrategy>();
	ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
	//COUNTER:0
	//COUNTER:0
	//NAME:type
	   			if (objectSelection != null && objectSelection.getObject() != null) {
	   				if (hmObjects.get("t2") != null) {
		   					refs.put("type", new SpecificReferenceConfigurationStrategy(model, objectSelection.getObject(), hmObjects.get("t2"), "type"));
			   			} else {
							return mutations;
						}
	   			}
if (objectSelection != null) {
	ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs, objsAttRef, attsRef);
	//INC COUNTER: 2
	if (mut != null) {
		mut.setId("m3");
				mutations.add(mut);
			}
}
	//END MODIFY INFORMATION mutation3
		return mutations;	
	}
//COUNTER: 3
//METHOD NAME:registry3
//REGISTRY COUNTER: 2
private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
	InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
	icMut.setObject(mut.getObject());
	EList<ReferenceChanged> refsMut = icMut.getRefChanges();
	EObject previous = null;
	EObject next = null;
	//REFERENCE COUNTER: 
//
ReferenceChanged refMut0 = null;
refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
refMut0.setRefName("type");
refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
previous = ((ModifyInformationMutator) mut).getPrevious();
next = ((ModifyInformationMutator) mut).getNext();
if (previous != null) {
	refMut0.setFrom(previous);
}
if (next != null) {
	refMut0.setTo(next);
}
refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
refMut0.setDef(hmMutator.get("m3"));
refsMut.add(refMut0);
icMut.setDef(hmMutator.get("m3"));
//REFERENCE COUNTER INC: 0
	appMut = icMut;
	return appMut;
}
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics) throws ReferenceNonExistingException, WrongAttributeTypeException, 
											  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
	if (maxAttempts <= 0) {
		maxAttempts = 1;
	}
	
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/SecurityPolicy.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/resources/";
	    
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
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/out/SecurityPoliciesWodelSampleRTT.model").toFileString());
	   	
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
	   	   	   			//COMMAND: 4
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:t14
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> lt14 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (lt14 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lt14) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   						hashmapEObject.put("t1", mut.getObject());
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
	   	   	   			//COMMAND: 5
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:t25
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> lt25 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (lt25 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lt25) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   						hashmapEObject.put("t2", mut.getObject());
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
	   	   	   			   	   	//COUNTER: 3	
	   	   	   			//COMMAND: 6
	   	   	   			//REGISTRY COUNTER: 3
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:6
	   	   	   			//METHOD NAME:mutation3
	   	   	   			
	   	   	   			ArrayList<Mutator> l6 = mutation3(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 3
	   	   	   			//REGISTRY METHOD NAME:registry3
	   	   	   			
	   	   	   			if (l6 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l6) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_3.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
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
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/out/", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/SecurityPolicy.ecore", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/", "SecurityPoliciesWodelSampleRTT", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT", hashmapMutVersions);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/out/", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/SecurityPolicy.ecore", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT/data/model/", "SecurityPoliciesWodelSampleRTT", "C:/eclipse/runtime-EclipseApplication/SecurityPoliciesWodelSampleRTT", hashmapMutVersions);   			
   		}
   	}
}

