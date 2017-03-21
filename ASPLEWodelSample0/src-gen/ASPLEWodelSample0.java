
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

public class ASPLEWodelSample0 extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "BinaryOperator");
	List<EObject> objects = rts.getObjects();
			   	//EXPRESSION LIST: []
			   	//EXPRESSION LEVEL: 0
			   	//EXPRESSION LEVEL: true
			   	Expression exp0 = new Expression();
			   	//INDEX EXPRESSION: 
			   	  		exp0.first = new AttributeEvaluation();
			   	  		//ATTRIBUTE: 
			   	   		((AttributeEvaluation) exp0.first).name = "operator";
			   	   		((AttributeEvaluation) exp0.first).operator = "in";
			   	((AttributeEvaluation) exp0.first).values = new ArrayList<String>();
			   	//
			   	((AttributeEvaluation) exp0.first).values.add("add");
			   	((AttributeEvaluation) exp0.first).values.add("subtract");
			   	((AttributeEvaluation) exp0.first).values.add("multiply");
			   	((AttributeEvaluation) exp0.first).values.add("divide");
			   	((AttributeEvaluation) exp0.first).values.add("module");
			   	   			((AttributeEvaluation) exp0.first).type = "String";
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
	//COUNTER:0
	//NAME:operator
	if (objectSelection != null) {
		//NAME:operator
		atts.put("operator", (ModelManager.getAttribute("operator", (objectSelection != null) ? objectSelection.getObject() : null) instanceof String) ? new ListStringConfigurationStrategy((String) ModelManager.getAttribute("operator", (objectSelection != null) ? objectSelection.getObject() : null), "[add, subtract, multiply, divide, module]", "operator") : null
		);
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
attMut0.setAttName("operator");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("operator");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("operator");
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
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics) throws ReferenceNonExistingException, WrongAttributeTypeException, 
											  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
	if (maxAttempts <= 0) {
		maxAttempts = 1;
	}
	
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/Asple.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/resources/";
	    
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
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/out/ASPLEWodelSample0.model").toFileString());
	   	
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
	   	   	   			//COMMAND: 49
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:49
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> l49 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (l49 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l49) {
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
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/out/", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/Asple.ecore", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/", "ASPLEWodelSample0", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0", hashmapMutVersions);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/out/", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/Asple.ecore", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0/data/model/", "ASPLEWodelSample0", "C:/eclipse/runtime-EclipseApplication/ASPLEWodelSample0", hashmapMutVersions);   			
   		}
   	}
}

