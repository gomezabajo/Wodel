
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

public class DFAWodelSample11 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
	//MODIFY INFORMATION mutation1
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
	List<EObject> objects = rts.getObjects();
			   	//EXPRESSION LIST: []
			   	//EXPRESSION LEVEL: 0
			   	//EXPRESSION LEVEL: true
			   	Expression exp0 = new Expression();
			   	//INDEX EXPRESSION: 
			   	  		exp0.first = new AttributeEvaluation();
			   	  		//ATTRIBUTE: 
			   	   		((AttributeEvaluation) exp0.first).name = "isInitial";
			   	   		((AttributeEvaluation) exp0.first).operator = "equals";
			   	((AttributeEvaluation) exp0.first).values = new ArrayList<String>();
			   	((AttributeEvaluation) exp0.first).values.add("true");
			   	((AttributeEvaluation) exp0.first).type = "Boolean";
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
	hmObjects.put("s0", object);
		objectSelection = new SpecificObjectSelection(packages, model, object);
	}
			
	HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
	//COUNTER:
	//COUNTER:0
	//NAME:isInitial
	if (objectSelection != null) {
		//NAME:isInitial
		   		atts.put("isInitial", new ReverseBooleanConfigurationStrategy("isInitial"));
	}
	   				
	HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
	HashMap<String, AttributeConfigurationStrategy> attsRef = new HashMap<String, AttributeConfigurationStrategy>();
	ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
	//COUNTER:0
if (objectSelection != null) {
	ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs, objsAttRef, attsRef);
	//INC COUNTER: 0
	if (mut != null) {
		mut.setId("m1");
				mutations.add(mut);
			}
}
	//END MODIFY INFORMATION mutation1
		return mutations;	
	}
//COUNTER: 1
//METHOD NAME:registry1
//REGISTRY COUNTER: 0
private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
	InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
	icMut.setObject(mut.getObject());
	EList<AttributeChanged> attsMut = icMut.getAttChanges();
	Object oldAttVal = null;
	Object newAttVal = null;
	//ATTRIBUTE COUNTER: 
//
//
AttributeChanged attMut0 = null;
attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut0.setAttName("isInitial");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("isInitial");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("isInitial");
if (oldAttVal != null) {
	attMut0.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut0.setNewVal(newAttVal.toString());
}
attMut0.setDef(hmMutator.get("m1"));
attsMut.add(attMut0);
icMut.setDef(hmMutator.get("m1"));
//ATTRIBUTE COUNTER INC: 0
	appMut = icMut;
	return appMut;
}
//COUNTER: 2
//METHOD NAME:mutation2
	private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY INFORMATION mutation2
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
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
			   	((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("s0")).getObject();
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
	hmObjects.put("s1", object);
		objectSelection = new SpecificObjectSelection(packages, model, object);
	}
			
	HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
	//COUNTER:
	//COUNTER:0
	//NAME:isInitial
	if (objectSelection != null) {
		//NAME:isInitial
		atts.put("isInitial", new SpecificBooleanConfigurationStrategy(true)
		);
	}
	   				
	HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
	HashMap<String, AttributeConfigurationStrategy> attsRef = new HashMap<String, AttributeConfigurationStrategy>();
	ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
	//COUNTER:0
if (objectSelection != null) {
	ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs, objsAttRef, attsRef);
	//INC COUNTER: 1
	if (mut != null) {
		mut.setId("m2");
				mutations.add(mut);
			}
}
	//END MODIFY INFORMATION mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
	InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
	icMut.setObject(mut.getObject());
	EList<AttributeChanged> attsMut = icMut.getAttChanges();
	Object oldAttVal = null;
	Object newAttVal = null;
	//ATTRIBUTE COUNTER: 
//
//
AttributeChanged attMut0 = null;
attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut0.setAttName("isInitial");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("isInitial");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("isInitial");
if (oldAttVal != null) {
	attMut0.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut0.setNewVal(newAttVal.toString());
}
attMut0.setDef(hmMutator.get("m2"));
attsMut.add(attMut0);
icMut.setDef(hmMutator.get("m2"));
//ATTRIBUTE COUNTER INC: 0
	appMut = icMut;
	return appMut;
}
//COUNTER: 3
//METHOD NAME:mutation3
	private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
//CREATE OBJECT mutation3
ArrayList<EObject> containers = ModelManager.getParentObjects(packages, model, "Transition");
EObject container = containers.get(ModelManager.getRandomIndex(containers));
ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
ObSelectionStrategy objectSelection = null;
HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
//NAME:src
  		//REFERENCES COMPILES	22
ObSelectionStrategy refSelection22 = null;
if (hmObjects.get("s1") != null) {
refSelection22 = new SpecificObjectSelection(packages, model, hmObjects.get("s1"));
} else {
	if (hmList.get("s1") != null) {
	refSelection22 = new SpecificObjectSelection(packages, model, hmList.get("s1"));
	}
	else {
		return mutations;
	}
}
   		refs.put("src", refSelection22);
//NAME:tar
  		//REFERENCES COMPILES	23
ObSelectionStrategy refSelection23 = null;
if (hmObjects.get("s0") != null) {
refSelection23 = new SpecificObjectSelection(packages, model, hmObjects.get("s0"));
} else {
	if (hmList.get("s0") != null) {
	refSelection23 = new SpecificObjectSelection(packages, model, hmList.get("s0"));
	}
	else {
		return mutations;
	}
}
   		refs.put("tar", refSelection23);
//NAME:symbol
  		//REFERENCES COMPILES	24
RandomTypeSelection refRts24 = new RandomTypeSelection(packages, model, "AlphabetSymbol");
EObject refObject24 = refRts24.getObject();
ObSelectionStrategy refSelection24 = null;
if (refObject24 != null) {
refSelection24 = 
	new SpecificObjectSelection(packages, model, refObject24);
}
   		refs.put("symbol", refSelection24);
CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "Transition");
//INC COUNTER: 2
if (mut != null) {
	mut.setId("m3");
	mutations.add(mut);
}
//END CREATE OBJECT mutation3
		return mutations;	
	}
//COUNTER: 3
//METHOD NAME:registry3
//REGISTRY COUNTER: 2
private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
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
cMut.setDef(hmMutator.get("m3"));
appMut = cMut;
	return appMut;
}
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics) throws ReferenceNonExistingException, WrongAttributeTypeException, 
											  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
	if (maxAttempts <= 0) {
		maxAttempts = 1;
	}
	
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/DFAAutomaton.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/resources/";
	    
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
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/out/DFAWodelSample11.model").toFileString());
	   	
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
	   	   	   			//COMMAND: 27
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:s027
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> ls027 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (ls027 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : ls027) {
	   	   	   					if (mut != null) {
	   	   	   						EObject mutated = (EObject) mut.mutate();
	   	   	   						if (mutated != null) {
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
	   	   	   			//COMMAND: 28
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:s128
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> ls128 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (ls128 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : ls128) {
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
	   	   	   			   	   	//COUNTER: 3	
	   	   	   			//COMMAND: 29
	   	   	   			//REGISTRY COUNTER: 3
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:29
	   	   	   			//METHOD NAME:mutation3
	   	   	   			
	   	   	   			ArrayList<Mutator> l29 = mutation3(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 3
	   	   	   			//REGISTRY METHOD NAME:registry3
	   	   	   			
	   	   	   			if (l29 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l29) {
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
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/out/", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/DFAAutomaton.ecore", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/", "DFAWodelSample11", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11", hashmapMutVersions);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/out/", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/DFAAutomaton.ecore", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11/data/model/", "DFAWodelSample11", "C:/eclipse/runtime-EclipseApplication/DFAWodelSample11", hashmapMutVersions);   			
   		}
   	}
}

