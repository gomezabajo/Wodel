
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

public class wcl2 extends mutator.MutatorUtils implements manager.IMutatorExecutor {
	
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
//CREATE OBJECT mutation2
ArrayList<EObject> containers = ModelManager.getParentObjects(packages, model, "AssociationClass");
EObject container = containers.get(ModelManager.getRandomIndex(containers));
ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
ObSelectionStrategy objectSelection = null;
HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
//NAME:features
  		//REFERENCES COMPILES	4
ObSelectionStrategy refSelection4 = null;
if (hmObjects.get("cl") != null) {
refSelection4 = new SpecificObjectSelection(packages, model, hmObjects.get("cl"), "features");
} else {
	if (hmList.get("cl") != null) {
	refSelection4 = new SpecificObjectSelection(packages, model, hmList.get("cl"), "features");
	}
	else {
		return mutations;
	}
}
   		refs.put("features", refSelection4);
//NAME:super
  		//REFERENCES COMPILES	5
ObSelectionStrategy refSelection5 = null;
if (hmObjects.get("cl") != null) {
refSelection5 = new SpecificObjectSelection(packages, model, hmObjects.get("cl"), "super");
} else {
	if (hmList.get("cl") != null) {
	refSelection5 = new SpecificObjectSelection(packages, model, hmList.get("cl"), "super");
	}
	else {
		return mutations;
	}
}
   		refs.put("super", refSelection5);
//NAME:supplier
  		//REFERENCES COMPILES	6
ObSelectionStrategy refSelection6 = null;
if (hmObjects.get("cl") != null) {
refSelection6 = new SpecificObjectSelection(packages, model, hmObjects.get("cl"), "supplier");
} else {
	if (hmList.get("cl") != null) {
	refSelection6 = new SpecificObjectSelection(packages, model, hmList.get("cl"), "supplier");
	}
	else {
		return mutations;
	}
}
   		refs.put("supplier", refSelection6);
CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "AssociationClass");
//INC COUNTER: 1
if (mut != null) {
	mut.setId("m2");
	mutations.add(mut);
}
//END CREATE OBJECT mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
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
cMut.setDef(hmMutator.get("m2"));
appMut = cMut;
	return appMut;
}
//COUNTER: 3
//METHOD NAME:mutation3
	private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY INFORMATION mutation3
	ObSelectionStrategy objectSelection = null;
	if (hmObjects.get("ac") != null) {
		objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("ac"));
	} else {
		if (hmList.get("ac") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmList.get("ac"));
		}
		else {
			return mutations;
		}
	}
			
	HashMap<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
	//COUNTER:
	//COUNTER:0
	//NAME:abstract
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("cl") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("abstract") != null) {
				   					atts = attsList.get("abstract");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("cl"), "abstract", "abstract"));
				   				attsList.put("abstract", atts);
	} else {
		return mutations;
	}
}
	//COUNTER:1
	//NAME:derived
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("cl") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("derived") != null) {
				   					atts = attsList.get("derived");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("cl"), "derived", "derived"));
				   				attsList.put("derived", atts);
	} else {
		return mutations;
	}
}
	//COUNTER:2
	//NAME:name
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("cl") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("name") != null) {
				   					atts = attsList.get("name");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("cl"), "name", "name"));
				   				attsList.put("name", atts);
	} else {
		return mutations;
	}
}
	//COUNTER:3
	//NAME:scope
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("cl") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("scope") != null) {
				   					atts = attsList.get("scope");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("cl"), "scope", "scope"));
				   				attsList.put("scope", atts);
	} else {
		return mutations;
	}
}
	//COUNTER:4
	//NAME:visibility
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("cl") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("visibility") != null) {
				   					atts = attsList.get("visibility");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("cl"), "visibility", "visibility"));
				   				attsList.put("visibility", atts);
	} else {
		return mutations;
	}
}
	   				
	HashMap<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
	HashMap<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
	ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
	//COUNTER:0
if (objectSelection != null) {
	ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, attsList, refsList, objsAttRef, attsRefList);
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
	EList<AttributeChanged> attsMut = icMut.getAttChanges();
	Object oldAttVal = null;
	Object newAttVal = null;
	//ATTRIBUTE COUNTER: 
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@13b791de (name: abstract) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: null, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut0 = null;
attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut0.setAttName("abstract");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("abstract");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("abstract");
if (oldAttVal != null) {
	attMut0.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut0.setNewVal(newAttVal.toString());
}
attMut0.setDef(hmMutator.get("m3"));
attsMut.add(attMut0);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 0
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@1b0574d (name: derived) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: false, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut1 = null;
attMut1 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut1.setAttName("derived");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("derived");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("derived");
if (oldAttVal != null) {
	attMut1.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut1.setNewVal(newAttVal.toString());
}
attMut1.setDef(hmMutator.get("m3"));
attsMut.add(attMut1);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 1
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@1e59bbe5 (name: name) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: null, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut2 = null;
attMut2 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut2.setAttName("name");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("name");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("name");
if (oldAttVal != null) {
	attMut2.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut2.setNewVal(newAttVal.toString());
}
attMut2.setDef(hmMutator.get("m3"));
attsMut.add(attMut2);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 2
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@2d6c2643 (name: scope) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: instance, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut3 = null;
attMut3 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut3.setAttName("scope");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("scope");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("scope");
if (oldAttVal != null) {
	attMut3.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut3.setNewVal(newAttVal.toString());
}
attMut3.setDef(hmMutator.get("m3"));
attsMut.add(attMut3);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 3
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@2916cfde (name: visibility) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: private, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut4 = null;
attMut4 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut4.setAttName("visibility");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("visibility");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("visibility");
if (oldAttVal != null) {
	attMut4.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut4.setNewVal(newAttVal.toString());
}
attMut4.setDef(hmMutator.get("m3"));
attsMut.add(attMut4);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 4
	appMut = icMut;
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
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("cl") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("cl"));
	   			} else {
			return mutations;
		}
			RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, objectSelection, referenceSelection, containerSelection);
			   		//INC COUNTER: 3
			   		if (mut != null) {
				   		mut.setId("m4");
				mutations.add(mut);
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
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/UMLClassDiagram.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/wcl2/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/wcl2/resources/";
	    
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
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/wcl2/data/out/wcl2.model").toFileString());
	   	
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
	   	   	   			//COMMAND: 5
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:cl5
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> lcl5 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (lcl5 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lcl5) {
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
	   	   	   			//COMMAND: 6
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:ac6
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> lac6 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (lac6 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lac6) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							if (mutated instanceof EObject) {
	   	   	   							hashmapEObject.put("ac", mut.getObject());
	   	   	   							}
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
	   	   	   			//COMMAND: 7
	   	   	   			//REGISTRY COUNTER: 3
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:7
	   	   	   			//METHOD NAME:mutation3
	   	   	   			
	   	   	   			ArrayList<Mutator> l7 = mutation3(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 3
	   	   	   			//REGISTRY METHOD NAME:registry3
	   	   	   			
	   	   	   			if (l7 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l7) {
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
	   	   	   			//COMMAND: 8
	   	   	   			//REGISTRY COUNTER: 4
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:8
	   	   	   			//METHOD NAME:mutation4
	   	   	   			
	   	   	   			ArrayList<Mutator> l8 = mutation4(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 4
	   	   	   			//REGISTRY METHOD NAME:registry4
	   	   	   			
	   	   	   			if (l8 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l8) {
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
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/wcl2/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic net metrics");
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/wcl2/data/out/", "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/", "wcl2", "C:/eclipse/runtime-EclipseApplication/wcl2", hashmapMutVersions);
   			monitor.worked(1);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic debug metrics");
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/wcl2/data/out/", "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/wcl2/data/model/", "wcl2", "C:/eclipse/runtime-EclipseApplication/wcl2", hashmapMutVersions);
   			monitor.worked(1);   			
   		}
   	}
}

