
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import manager.ModelManager;
import metrics.MutatorMetrics;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;

import exceptions.*;

import appliedMutations.*;

import mutatorenvironment.MutatorEnvironment;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;

import org.eclipse.core.runtime.IProgressMonitor;

public class mcl extends mutator.MutatorUtils implements manager.IMutatorExecutor {
	
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
	//
	//true
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Class");
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
	// REMOVE OBJECT mutation2
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		//true
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Relation");
		List<EObject> objects = rts.getObjects();
   					//EXPRESSION LIST: []
   					//EXPRESSION LEVEL: 0
   					//EXPRESSION LEVEL: true
   					Expression exp0 = new Expression();
   					//INDEX EXPRESSION: 
   					exp0.first = new ReferenceEvaluation();
   					//REFERENCE: 
   					((ReferenceEvaluation) exp0.first).name = "src";
   					((ReferenceEvaluation) exp0.first).refName = null;
   					((ReferenceEvaluation) exp0.first).operator = "equals";
   					((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("cl")).getObject();
   					   		exp0.operator = new ArrayList<Operator>();
   					   		//OPNAME: 
   					   		exp0.second = new ArrayList<Evaluation>();
   					   		//EVNAME: 
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
			if (objects != null) {
				for (EObject obj : objects) {
					RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
			   		//INC COUNTER: 1
			   		if (mut != null) {
			   			mut.setId("m2");
						mutations.add(mut);
					}
				}
			}
		//END REMOVE OBJECT mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m2"));
appMut = rMut;
	return appMut;
}
//COUNTER: 3
//METHOD NAME:mutation3
	private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation3
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		//true
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Relation");
		List<EObject> objects = rts.getObjects();
   					//EXPRESSION LIST: []
   					//EXPRESSION LEVEL: 0
   					//EXPRESSION LEVEL: true
   					Expression exp0 = new Expression();
   					//INDEX EXPRESSION: 
   					exp0.first = new ReferenceEvaluation();
   					//REFERENCE: 
   					((ReferenceEvaluation) exp0.first).name = "tar";
   					((ReferenceEvaluation) exp0.first).refName = null;
   					((ReferenceEvaluation) exp0.first).operator = "equals";
   					((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("cl")).getObject();
   					   		exp0.operator = new ArrayList<Operator>();
   					   		//OPNAME: 
   					   		exp0.second = new ArrayList<Evaluation>();
   					   		//EVNAME: 
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
			if (objects != null) {
				for (EObject obj : objects) {
					RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
			   		//INC COUNTER: 2
			   		if (mut != null) {
			   			mut.setId("m3");
						mutations.add(mut);
					}
				}
			}
		//END REMOVE OBJECT mutation3
		return mutations;	
	}
//COUNTER: 3
//METHOD NAME:registry3
//REGISTRY COUNTER: 2
private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m3"));
appMut = rMut;
	return appMut;
}
//COUNTER: 4
//METHOD NAME:mutation4
	private ArrayList<Mutator> mutation4(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation4
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		//true
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Operation");
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
   					((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("cl")).getObject();
   					   		exp0.operator = new ArrayList<Operator>();
   					   		//OPNAME: 
   					   		exp0.second = new ArrayList<Evaluation>();
   					   		//EVNAME: 
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
			if (objects != null) {
				for (EObject obj : objects) {
					RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
			   		//INC COUNTER: 3
			   		if (mut != null) {
			   			mut.setId("m4");
						mutations.add(mut);
					}
				}
			}
		//END REMOVE OBJECT mutation4
		return mutations;	
	}
//COUNTER: 4
//METHOD NAME:registry4
//REGISTRY COUNTER: 3
private AppMutation registry4(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m4"));
appMut = rMut;
	return appMut;
}
//COUNTER: 5
//METHOD NAME:mutation5
	private ArrayList<Mutator> mutation5(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation5
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		//true
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Feature");
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
   					((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("cl")).getObject();
   					   		exp0.operator = new ArrayList<Operator>();
   					   		//OPNAME: 
   					   		exp0.second = new ArrayList<Evaluation>();
   					   		//EVNAME: 
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
			if (objects != null) {
				for (EObject obj : objects) {
					RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
			   		//INC COUNTER: 4
			   		if (mut != null) {
			   			mut.setId("m5");
						mutations.add(mut);
					}
				}
			}
		//END REMOVE OBJECT mutation5
		return mutations;	
	}
//COUNTER: 5
//METHOD NAME:registry5
//REGISTRY COUNTER: 4
private AppMutation registry5(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m5"));
appMut = rMut;
	return appMut;
}
//COUNTER: 6
//METHOD NAME:mutation6
	private ArrayList<Mutator> mutation6(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation6
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		//true
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "AssociationClass");
		List<EObject> objects = rts.getObjects();
   					//EXPRESSION LIST: []
   					//EXPRESSION LEVEL: 0
   					//EXPRESSION LEVEL: true
   					Expression exp0 = new Expression();
   					//INDEX EXPRESSION: 
   					exp0.first = new ReferenceEvaluation();
   					//REFERENCE: 
   					((ReferenceEvaluation) exp0.first).name = "association";
   					((ReferenceEvaluation) exp0.first).refName = null;
   					((ReferenceEvaluation) exp0.first).operator = "equals";
   					((ReferenceEvaluation) exp0.first).value = null;
   					   		exp0.operator = new ArrayList<Operator>();
   					   		//OPNAME: 
   					   		exp0.second = new ArrayList<Evaluation>();
   					   		//EVNAME: 
		List<EObject> selectedObjects = evaluate(objects, exp0);
		objects = selectedObjects;
			if (objects != null) {
				for (EObject obj : objects) {
					RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
			   		//INC COUNTER: 5
			   		if (mut != null) {
			   			mut.setId("m6");
						mutations.add(mut);
					}
				}
			}
		//END REMOVE OBJECT mutation6
		return mutations;	
	}
//COUNTER: 6
//METHOD NAME:registry6
//REGISTRY COUNTER: 5
private AppMutation registry6(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m6"));
appMut = rMut;
	return appMut;
}
//COUNTER: 7
//METHOD NAME:mutation7
	private ArrayList<Mutator> mutation7(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation7
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("cl") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("cl"));
	   			} else {
			return mutations;
		}
			RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, objectSelection, referenceSelection, containerSelection);
			   		//INC COUNTER: 6
			   		if (mut != null) {
				   		mut.setId("m7");
				mutations.add(mut);
			}
		//END REMOVE OBJECT mutation7
		return mutations;	
	}
//COUNTER: 7
//METHOD NAME:registry7
//REGISTRY COUNTER: 6
private AppMutation registry7(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
EObject foundObject = findEObjectForRegistry(seed, mut, mutPaths, packages);
if (foundObject != null) {
	rMut.getObject().add(foundObject);
}
rMut.setDef(hmMutator.get("m7"));
appMut = rMut;
	return appMut;
}
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, IProgressMonitor monitor) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
	//2
   	numMutants = 2;

   	int totalMutants = numMutants * 1;
	totalTasks += totalMutants;
	monitor.beginTask("Generating mutants", totalTasks);
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/mcl/data/model/UMLClassDiagram.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/mcl/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/mcl/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/mcl/resources/";
	    
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
	    int count = 0;
	    for (String modelFilename : modelFilenames) {
	    	HashSet<String> hashsetMutants = new HashSet<String>();
	    	hashsetMutants.add(modelFilename);
	    
	   	   		//Generate metrics model
	   	Bundle bundle = Platform.getBundle("wodel.models");
	   		   	URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   	
	   	//Load MetaModel
	   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/mcl/data/out/mcl.model").toFileString());
	   	
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
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	
	   	   	   			   	   	//COUNTER: 1	
	   	   	   			//COMMAND: 8
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:cl8
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> lcl8 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (lcl8 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lcl8) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							if (mutated instanceof EObject) {
	   	   	   							hashmapEObject.put("cl", mut.getObject());
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
	   	   	   			//COMMAND: 9
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:9
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> l9 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (l9 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l9) {
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
	   	   	   			   	   	//COUNTER: 3	
	   	   	   			//COMMAND: 10
	   	   	   			//REGISTRY COUNTER: 3
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:10
	   	   	   			//METHOD NAME:mutation3
	   	   	   			
	   	   	   			ArrayList<Mutator> l10 = mutation3(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 3
	   	   	   			//REGISTRY METHOD NAME:registry3
	   	   	   			
	   	   	   			if (l10 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l10) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
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
	   	   	   			   	   	//COUNTER: 4	
	   	   	   			//COMMAND: 11
	   	   	   			//REGISTRY COUNTER: 4
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:11
	   	   	   			//METHOD NAME:mutation4
	   	   	   			
	   	   	   			ArrayList<Mutator> l11 = mutation4(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 4
	   	   	   			//REGISTRY METHOD NAME:registry4
	   	   	   			
	   	   	   			if (l11 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l11) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_4.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 5	
	   	   	   			//COMMAND: 12
	   	   	   			//REGISTRY COUNTER: 5
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:12
	   	   	   			//METHOD NAME:mutation5
	   	   	   			
	   	   	   			ArrayList<Mutator> l12 = mutation5(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 5
	   	   	   			//REGISTRY METHOD NAME:registry5
	   	   	   			
	   	   	   			if (l12 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l12) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_5.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry5(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 6	
	   	   	   			//COMMAND: 13
	   	   	   			//REGISTRY COUNTER: 6
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:13
	   	   	   			//METHOD NAME:mutation6
	   	   	   			
	   	   	   			ArrayList<Mutator> l13 = mutation6(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 6
	   	   	   			//REGISTRY METHOD NAME:registry6
	   	   	   			
	   	   	   			if (l13 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l13) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_6.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry6(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 7	
	   	   	   			//COMMAND: 14
	   	   	   			//REGISTRY COUNTER: 7
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:14
	   	   	   			//METHOD NAME:mutation7
	   	   	   			
	   	   	   			ArrayList<Mutator> l14 = mutation7(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 7
	   	   	   			//REGISTRY METHOD NAME:registry7
	   	   	   			
	   	   	   			if (l14 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l14) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_7.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry7(mut, hmMutator, seed, mutPaths, packages);
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
	   	      			
	   			isRepeated = registryMutant(ecoreURI, packages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, i, mutPaths, hashmapMutVersions);
	   	
	   		    		//Reload input
	   		    		try {
	   				model.unload();
	   				model.load(null); 
	   				seed.unload();
	   				seed.load(null);
	   			} catch (Exception e) {}
	   	   			}
	   		monitor.worked(1);
	   	   		}
	   	count++;
	
	}

	//Generate metrics model
	Bundle bundle = Platform.getBundle("wodel.models");
   	URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
   	String metricsecore = FileLocator.resolve(fileURL).getFile();
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/mcl/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic net metrics");
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/mcl/data/out/", "C:/eclipse/runtime-EclipseApplication/mcl/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/mcl/data/model/", "mcl", "C:/eclipse/runtime-EclipseApplication/mcl", hashmapMutVersions);
   			monitor.worked(1);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic debug metrics");
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/mcl/data/out/", "C:/eclipse/runtime-EclipseApplication/mcl/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/mcl/data/model/", "mcl", "C:/eclipse/runtime-EclipseApplication/mcl", hashmapMutVersions);
   			monitor.worked(1);   			
   		}
   	}
}

