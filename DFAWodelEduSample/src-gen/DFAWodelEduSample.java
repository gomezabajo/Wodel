
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

public class DFAWodelEduSample extends manager.MutatorUtils implements manager.IMutatorExecutor {
	
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
		if (((ModifyTargetReferenceMutator) mut).getObject() != null) {
			trcMut.getObject().add(ModelManager.getObject(seed, ((ModifyTargetReferenceMutator) mut).getObject()));
		}
		trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
		trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
		trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
		trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
		trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
		trcMut.setDef(hmMutator.get("m1"));
		appMut = trcMut;
			return appMut;
		}
		public void block_simple1(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File(modelURI).listFiles();
		   for (int i = 0; i < files.length; i++) {
		   	if (files[i].isFile() == true) {
		   		if (files[i].getName().endsWith(".model") == true) {
		   			if (fromNames.size() == 0) {
		   				String pathfile = files[i].getPath();
		   				if (pathfile.endsWith(".model") == true) {
		   					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   					seedModelFilenames.put(pathfile, files[i].getPath());
		   				}
		   			}
		   			else {
		   				for (String fromName : fromNames) {
		   					String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
		   					System.out.println("modelFolder: " + modelFolder);
		   					File[] mutFiles = new File(modelFolder).listFiles();
		   					if (mutFiles != null) {
		   						for (int j = 0; j < mutFiles.length; j++) {
		   							if (mutFiles[j].isFile() == true) {
		   								String pathfile = mutFiles[j].getPath();
		   								if (pathfile.endsWith(".model") == true) {
		   									hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   									hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
		   									seedModelFilenames.put(pathfile, files[i].getPath());
		   								}
		   							}
		   							else {
		   								generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
		   							}
		   						}
		   					}
		   				}
		   			}
		   		}
		   	}
		   }
		   
		   //Load MetaModel
		   ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	String seedModelFilename = seedModelFilenames.get(modelFilename);
		   	HashSet<String> hashsetMutantsBlock = null;
		   	hashsetMutantsBlock = new HashSet<String>();
		   	if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
		   		hashsetMutantsBlock.add(seedModelFilename);
		   	}
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   
		   	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		//2
		   	numMutants = 2;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/DFAWodelEduSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/simple1/Output" + i + ".model";
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
		   	   	   			//COMMAND: 106
		   	   	   			//REGISTRY COUNTER: 1
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:106
		   	   	   			//METHOD NAME:mutation1
		   	   	   			
		   	   	   			ArrayList<Mutator> l106 = mutation1(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 1
		   	   	   			//REGISTRY METHOD NAME:registry1
		   	   	   			
		   	   	   			if (l106 != null) {
		   	   	   				for (Mutator mut : l106) {
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
		   			
		   			// MUTANT COMPLETION AND REGISTRY
		   			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   		       		if (rules.get("State") == null) {
		   		       			rules.put("State", new ArrayList<String>());
		   		       		}
		   		       		ArrayList<String> newrules = rules.get("State");
		   		       		newrules.add("isInitial or Set{self}->closure(s | Transition.allInstances()->select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)");
		   	       			rules.put("State", newrules);
		   	       			
		   			isRepeated = registryMutantWithBlocks(packages, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "simple1", fromNames, i);
		   	      
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}
		   	   		hashmapMutants.put(modelFilename, hashsetMutantsBlock);
		
		}
	}
		//COUNTER: 2
		//METHOD NAME:mutation2
		private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//SELECT OBJECT mutation2
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
			   					   		((AttributeEvaluation) exp0.first).operator = "=";
			   					((AttributeEvaluation) exp0.first).value = "true";
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
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
		
				ArrayList<EObject> containers = ModelManager.getParentObjects(model, "State");
				EObject container = containers.get(ModelManager.getRandomIndex(containers));
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				
				SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
			   	//INC COUNTER: 0
			   	mut.setId("m1");
				mutations.add(mut);
			//END SELECT OBJECT mutation2
			return mutations;	
		}
		//COUNTER: 2
		//METHOD NAME:registry2
		//REGISTRY COUNTER: 1
		private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m2"));
			return appMut;
		}
		//COUNTER: 3
		//METHOD NAME:mutation3
		private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//SELECT OBJECT mutation3
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
				List<EObject> objects = rts.getObjects();
			   					//EXPRESSION LIST: []
			   					//EXPRESSION LEVEL: 0
			   					//EXPRESSION LEVEL: true
			   					Expression exp0 = new Expression();
			   					//INDEX EXPRESSION: 
			   					  		exp0.first = new AttributeEvaluation();
			   					  		//ATTRIBUTE: 
			   					   		((AttributeEvaluation) exp0.first).name = "isFinal";
			   					   		((AttributeEvaluation) exp0.first).operator = "=";
			   					((AttributeEvaluation) exp0.first).value = "false";
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
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
		
				ArrayList<EObject> containers = ModelManager.getParentObjects(model, "State");
				EObject container = containers.get(ModelManager.getRandomIndex(containers));
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				
				SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
			   	//INC COUNTER: 1
			   	mut.setId("m2");
				mutations.add(mut);
			//END SELECT OBJECT mutation3
			return mutations;	
		}
		//COUNTER: 3
		//METHOD NAME:registry3
		//REGISTRY COUNTER: 2
		private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m3"));
			return appMut;
		}
		//COUNTER: 4
		//METHOD NAME:mutation4
		private ArrayList<Mutator> mutation4(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//SELECT OBJECT mutation4
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
				List<EObject> objects = rts.getObjects();
			   					//EXPRESSION LIST: []
			   					//EXPRESSION LEVEL: 0
			   					//EXPRESSION LEVEL: true
			   					Expression exp0 = new Expression();
			   					//INDEX EXPRESSION: 
			   					exp0.first = new ReferenceEvaluation();
			   					//REFERENCE: 
			   					((ReferenceEvaluation) exp0.first).name = "src";
			   					((ReferenceEvaluation) exp0.first).operator = "=";
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
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
		
				ArrayList<EObject> containers = ModelManager.getParentObjects(model, "Transition");
				EObject container = containers.get(ModelManager.getRandomIndex(containers));
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
		
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				
				SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
			   	//INC COUNTER: 2
			   	mut.setId("m3");
				mutations.add(mut);
			//END SELECT OBJECT mutation4
			return mutations;	
		}
		//COUNTER: 4
		//METHOD NAME:registry4
		//REGISTRY COUNTER: 3
		private AppMutation registry4(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m4"));
			return appMut;
		}
		//COUNTER: 5
		//METHOD NAME:mutation5
		private ArrayList<Mutator> mutation5(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation5
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Transition");
		List<EObject> objects = rts.getObjects();
						   	//EXPRESSION LIST: []
						   	//EXPRESSION LEVEL: 0
						   	//EXPRESSION LEVEL: true
						   	Expression exp0 = new Expression();
						   	//INDEX EXPRESSION: 
						   	exp0.first = new ReferenceEvaluation();
						   	//REFERENCE: 
						   	((ReferenceEvaluation) exp0.first).name = "tar";
						   	((ReferenceEvaluation) exp0.first).operator = "=";
						   	((ReferenceEvaluation) exp0.first).value = new SpecificObjectSelection(packages, model, hmObjects.get("s1")).getObject();
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
			//COUNTER:0
			//COUNTER:0
			//NAME:tar
		if (objectSelection != null) {
						   				refs.put("tar", new SwapReferenceConfigurationStrategy(objectSelection.getObject(), hmObjects.get("t0"), "tar", "tar"));
		}
					   			
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
			//INC COUNTER: 3
			mut.setId("m4");
							mutations.add(mut);
		}
		//END MODIFY INFORMATION mutation5
			return mutations;	
		}
		//COUNTER: 5
		//METHOD NAME:registry5
		//REGISTRY COUNTER: 4
		private AppMutation registry5(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
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
		refMut0.setFirstName("tar");
		if (ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()) != null) {
			refMut0.setRefObject(ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()));
		}
		refMut0.setRefName("tar");
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
		refMut0.setDef(hmMutator.get("m5"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m5"));
		//REFERENCE COUNTER INC: 0
			appMut = icMut;
			return appMut;
		}
		public void block_simple2(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File(modelURI).listFiles();
		   for (int i = 0; i < files.length; i++) {
		   	if (files[i].isFile() == true) {
		   		if (files[i].getName().endsWith(".model") == true) {
		   			if (fromNames.size() == 0) {
		   				String pathfile = files[i].getPath();
		   				if (pathfile.endsWith(".model") == true) {
		   					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   					seedModelFilenames.put(pathfile, files[i].getPath());
		   				}
		   			}
		   			else {
		   				for (String fromName : fromNames) {
		   					String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
		   					System.out.println("modelFolder: " + modelFolder);
		   					File[] mutFiles = new File(modelFolder).listFiles();
		   					if (mutFiles != null) {
		   						for (int j = 0; j < mutFiles.length; j++) {
		   							if (mutFiles[j].isFile() == true) {
		   								String pathfile = mutFiles[j].getPath();
		   								if (pathfile.endsWith(".model") == true) {
		   									hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   									hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
		   									seedModelFilenames.put(pathfile, files[i].getPath());
		   								}
		   							}
		   							else {
		   								generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
		   							}
		   						}
		   					}
		   				}
		   			}
		   		}
		   	}
		   }
		   
		   //Load MetaModel
		   ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	String seedModelFilename = seedModelFilenames.get(modelFilename);
		   	HashSet<String> hashsetMutantsBlock = null;
		   	hashsetMutantsBlock = new HashSet<String>();
		   	if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
		   		hashsetMutantsBlock.add(seedModelFilename);
		   	}
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   
		   	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		//1
		   	numMutants = 1;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/DFAWodelEduSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/simple2/Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 1
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 1
		   	   				//RESET COUNTER: 1
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	
		   	   	   			   	   	//COUNTER: 2	
		   	   	   			//COMMAND: 107
		   	   	   			//REGISTRY COUNTER: 2
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:s0107
		   	   	   			//METHOD NAME:mutation2
		   	   	   			
		   	   	   			ArrayList<Mutator> ls0107 = mutation2(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 2
		   	   	   			//REGISTRY METHOD NAME:registry2
		   	   	   			
		   	   	   			if (ls0107 != null) {
		   	   	   				for (Mutator mut : ls0107) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						hashmapEObject.put("s0", mut.getObject());
		   	   	   						AppMutation appMut = registry2(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 3	
		   	   	   			//COMMAND: 108
		   	   	   			//REGISTRY COUNTER: 3
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:s1108
		   	   	   			//METHOD NAME:mutation3
		   	   	   			
		   	   	   			ArrayList<Mutator> ls1108 = mutation3(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 3
		   	   	   			//REGISTRY METHOD NAME:registry3
		   	   	   			
		   	   	   			if (ls1108 != null) {
		   	   	   				for (Mutator mut : ls1108) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						hashmapEObject.put("s1", mut.getObject());
		   	   	   						AppMutation appMut = registry3(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 4	
		   	   	   			//COMMAND: 109
		   	   	   			//REGISTRY COUNTER: 4
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:t0109
		   	   	   			//METHOD NAME:mutation4
		   	   	   			
		   	   	   			ArrayList<Mutator> lt0109 = mutation4(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 4
		   	   	   			//REGISTRY METHOD NAME:registry4
		   	   	   			
		   	   	   			if (lt0109 != null) {
		   	   	   				for (Mutator mut : lt0109) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						hashmapEObject.put("t0", mut.getObject());
		   	   	   						AppMutation appMut = registry4(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 5	
		   	   	   			//COMMAND: 110
		   	   	   			//REGISTRY COUNTER: 5
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:110
		   	   	   			//METHOD NAME:mutation5
		   	   	   			
		   	   	   			ArrayList<Mutator> l110 = mutation5(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 5
		   	   	   			//REGISTRY METHOD NAME:registry5
		   	   	   			
		   	   	   			if (l110 != null) {
		   	   	   				for (Mutator mut : l110) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry5(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   			
		   			// MUTANT COMPLETION AND REGISTRY
		   			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   		       		if (rules.get("State") == null) {
		   		       			rules.put("State", new ArrayList<String>());
		   		       		}
		   		       		ArrayList<String> newrules = rules.get("State");
		   		       		newrules.add("isInitial or Set{self}->closure(s | Transition.allInstances()->select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)");
		   	       			rules.put("State", newrules);
		   	       			
		   			isRepeated = registryMutantWithBlocks(packages, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "simple2", fromNames, i);
		   	      
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}
		   	   		hashmapMutants.put(modelFilename, hashsetMutantsBlock);
		
		}
	}
		//COUNTER: 6
		//METHOD NAME:mutation6
		private ArrayList<Mutator> mutation6(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//MODIFY TARGET REFERENCE mutation6
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
			//END MODIFY TARGET REFERENCE mutation6
			return mutations;	
		}
		//COUNTER: 6
		//METHOD NAME:registry6
		//REGISTRY COUNTER: 5
		private AppMutation registry6(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		if (((ModifyTargetReferenceMutator) mut).getObject() != null) {
			trcMut.getObject().add(ModelManager.getObject(seed, ((ModifyTargetReferenceMutator) mut).getObject()));
		}
		trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
		trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
		trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
		trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
		trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
		trcMut.setDef(hmMutator.get("m6"));
		appMut = trcMut;
			return appMut;
		}
		//COUNTER: 7
		//METHOD NAME:mutation7
		private ArrayList<Mutator> mutation7(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation7
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
				
			HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//COUNTER:
			//COUNTER:0
			//NAME:isFinal
		//NAME:isFinal
		   		atts.put("isFinal", new ReverseBooleanConfigurationStrategy("isFinal"));
		   				
			HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
			//COUNTER:0
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
			//INC COUNTER: 1
			mut.setId("m2");
							mutations.add(mut);
		}
		//END MODIFY INFORMATION mutation7
			return mutations;	
		}
		//COUNTER: 7
		//METHOD NAME:registry7
		//REGISTRY COUNTER: 6
		private AppMutation registry7(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
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
		attMut0.setAttName("isFinal");
		oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("isFinal");
		newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("isFinal");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		attMut0.setDef(hmMutator.get("m7"));
		attsMut.add(attMut0);
		icMut.setDef(hmMutator.get("m7"));
		//ATTRIBUTE COUNTER INC: 0
			appMut = icMut;
			return appMut;
		}
		public void block_first(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File(modelURI).listFiles();
		   for (int i = 0; i < files.length; i++) {
		   	if (files[i].isFile() == true) {
		   		if (files[i].getName().endsWith(".model") == true) {
		   			if (fromNames.size() == 0) {
		   				String pathfile = files[i].getPath();
		   				if (pathfile.endsWith(".model") == true) {
		   					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   					seedModelFilenames.put(pathfile, files[i].getPath());
		   				}
		   			}
		   			else {
		   				for (String fromName : fromNames) {
		   					String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
		   					System.out.println("modelFolder: " + modelFolder);
		   					File[] mutFiles = new File(modelFolder).listFiles();
		   					if (mutFiles != null) {
		   						for (int j = 0; j < mutFiles.length; j++) {
		   							if (mutFiles[j].isFile() == true) {
		   								String pathfile = mutFiles[j].getPath();
		   								if (pathfile.endsWith(".model") == true) {
		   									hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   									hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
		   									seedModelFilenames.put(pathfile, files[i].getPath());
		   								}
		   							}
		   							else {
		   								generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
		   							}
		   						}
		   					}
		   				}
		   			}
		   		}
		   	}
		   }
		   
		   //Load MetaModel
		   ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	String seedModelFilename = seedModelFilenames.get(modelFilename);
		   	HashSet<String> hashsetMutantsBlock = null;
		   	hashsetMutantsBlock = new HashSet<String>();
		   	if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
		   		hashsetMutantsBlock.add(seedModelFilename);
		   	}
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   
		   	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		//3
		   	numMutants = 3;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/DFAWodelEduSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/first/Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 5
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 5
		   	   				//RESET COUNTER: 5
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	
		   	   	   			   	   	//COUNTER: 6	
		   	   	   			//COMMAND: 111
		   	   	   			//REGISTRY COUNTER: 6
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:111
		   	   	   			//METHOD NAME:mutation6
		   	   	   			
		   	   	   			ArrayList<Mutator> l111 = mutation6(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 6
		   	   	   			//REGISTRY METHOD NAME:registry6
		   	   	   			
		   	   	   			if (l111 != null) {
		   	   	   				for (Mutator mut : l111) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry6(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 7	
		   	   	   			//COMMAND: 112
		   	   	   			//REGISTRY COUNTER: 7
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:112
		   	   	   			//METHOD NAME:mutation7
		   	   	   			
		   	   	   			ArrayList<Mutator> l112 = mutation7(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 7
		   	   	   			//REGISTRY METHOD NAME:registry7
		   	   	   			
		   	   	   			if (l112 != null) {
		   	   	   				for (Mutator mut : l112) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry7(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   			
		   			// MUTANT COMPLETION AND REGISTRY
		   			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   		       		if (rules.get("State") == null) {
		   		       			rules.put("State", new ArrayList<String>());
		   		       		}
		   		       		ArrayList<String> newrules = rules.get("State");
		   		       		newrules.add("isInitial or Set{self}->closure(s | Transition.allInstances()->select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)");
		   	       			rules.put("State", newrules);
		   	       			
		   			isRepeated = registryMutantWithBlocks(packages, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "first", fromNames, i);
		   	      
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}
		   	   		hashmapMutants.put(modelFilename, hashsetMutantsBlock);
		
		}
	}
		//COUNTER: 8
		//METHOD NAME:mutation8
		private ArrayList<Mutator> mutation8(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//MODIFY TARGET REFERENCE mutation8
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
			//END MODIFY TARGET REFERENCE mutation8
			return mutations;	
		}
		//COUNTER: 8
		//METHOD NAME:registry8
		//REGISTRY COUNTER: 7
		private AppMutation registry8(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		if (((ModifyTargetReferenceMutator) mut).getObject() != null) {
			trcMut.getObject().add(ModelManager.getObject(seed, ((ModifyTargetReferenceMutator) mut).getObject()));
		}
		trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
		trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
		trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
		trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
		trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
		trcMut.setDef(hmMutator.get("m8"));
		appMut = trcMut;
			return appMut;
		}
		//COUNTER: 9
		//METHOD NAME:mutation9
		private ArrayList<Mutator> mutation9(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation9
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
				
			HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//COUNTER:
			//COUNTER:0
			//NAME:isFinal
		//NAME:isFinal
		   		atts.put("isFinal", new ReverseBooleanConfigurationStrategy("isFinal"));
		   				
			HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
			//COUNTER:0
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
			//INC COUNTER: 1
			mut.setId("m2");
							mutations.add(mut);
		}
		//END MODIFY INFORMATION mutation9
			return mutations;	
		}
		//COUNTER: 9
		//METHOD NAME:registry9
		//REGISTRY COUNTER: 8
		private AppMutation registry9(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
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
		attMut0.setAttName("isFinal");
		oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("isFinal");
		newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("isFinal");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		attMut0.setDef(hmMutator.get("m9"));
		attsMut.add(attMut0);
		icMut.setDef(hmMutator.get("m9"));
		//ATTRIBUTE COUNTER INC: 0
			appMut = icMut;
			return appMut;
		}
		public void block_second(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File(modelURI).listFiles();
		   for (int i = 0; i < files.length; i++) {
		   	if (files[i].isFile() == true) {
		   		if (files[i].getName().endsWith(".model") == true) {
		   			if (fromNames.size() == 0) {
		   				String pathfile = files[i].getPath();
		   				if (pathfile.endsWith(".model") == true) {
		   					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   					seedModelFilenames.put(pathfile, files[i].getPath());
		   				}
		   			}
		   			else {
		   				for (String fromName : fromNames) {
		   					String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
		   					System.out.println("modelFolder: " + modelFolder);
		   					File[] mutFiles = new File(modelFolder).listFiles();
		   					if (mutFiles != null) {
		   						for (int j = 0; j < mutFiles.length; j++) {
		   							if (mutFiles[j].isFile() == true) {
		   								String pathfile = mutFiles[j].getPath();
		   								if (pathfile.endsWith(".model") == true) {
		   									hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   									hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
		   									seedModelFilenames.put(pathfile, files[i].getPath());
		   								}
		   							}
		   							else {
		   								generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
		   							}
		   						}
		   					}
		   				}
		   			}
		   		}
		   	}
		   }
		   
		   //Load MetaModel
		   ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	String seedModelFilename = seedModelFilenames.get(modelFilename);
		   	HashSet<String> hashsetMutantsBlock = null;
		   	if (seedModelFilename != null) {
		   		if (hashmapMutants.get(seedModelFilename) != null) {
		   			hashsetMutantsBlock = hashmapMutants.get(seedModelFilename);
		   		}
		   	}
		   	if (hashsetMutantsBlock == null) {
		   		hashsetMutantsBlock = new HashSet<String>();
		   	}
		   	if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
		   		hashsetMutantsBlock.add(seedModelFilename);
		   	}
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   
		   	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		//3
		   	numMutants = 3;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/DFAWodelEduSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/second/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 7
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 7
		   	   				//RESET COUNTER: 7
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	
		   	   	   			   	   	//COUNTER: 8	
		   	   	   			//COMMAND: 113
		   	   	   			//REGISTRY COUNTER: 8
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:113
		   	   	   			//METHOD NAME:mutation8
		   	   	   			
		   	   	   			ArrayList<Mutator> l113 = mutation8(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 8
		   	   	   			//REGISTRY METHOD NAME:registry8
		   	   	   			
		   	   	   			if (l113 != null) {
		   	   	   				for (Mutator mut : l113) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry8(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 9	
		   	   	   			//COMMAND: 114
		   	   	   			//REGISTRY COUNTER: 9
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:114
		   	   	   			//METHOD NAME:mutation9
		   	   	   			
		   	   	   			ArrayList<Mutator> l114 = mutation9(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 9
		   	   	   			//REGISTRY METHOD NAME:registry9
		   	   	   			
		   	   	   			if (l114 != null) {
		   	   	   				for (Mutator mut : l114) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry9(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   			
		   			// MUTANT COMPLETION AND REGISTRY
		   			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   		       		if (rules.get("State") == null) {
		   		       			rules.put("State", new ArrayList<String>());
		   		       		}
		   		       		ArrayList<String> newrules = rules.get("State");
		   		       		newrules.add("isInitial or Set{self}->closure(s | Transition.allInstances()->select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)");
		   	       			rules.put("State", newrules);
		   	       			
		   			isRepeated = registryMutantWithBlocks(packages, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "second", fromNames, i);
		   	      
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}
		
		}
	}
		//COUNTER: 10
		//METHOD NAME:mutation10
		private ArrayList<Mutator> mutation10(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
			//MODIFY TARGET REFERENCE mutation10
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
			//END MODIFY TARGET REFERENCE mutation10
			return mutations;	
		}
		//COUNTER: 10
		//METHOD NAME:registry10
		//REGISTRY COUNTER: 9
		private AppMutation registry10(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
			AppMutation appMut = null;
		TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
		if (((ModifyTargetReferenceMutator) mut).getObject() != null) {
			trcMut.getObject().add(ModelManager.getObject(seed, ((ModifyTargetReferenceMutator) mut).getObject()));
		}
		trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
		trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
		trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
		trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
		trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
		trcMut.setDef(hmMutator.get("m10"));
		appMut = trcMut;
			return appMut;
		}
		//COUNTER: 11
		//METHOD NAME:mutation11
		private ArrayList<Mutator> mutation11(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation11
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
				
			HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//COUNTER:
			//COUNTER:0
			//NAME:isFinal
		//NAME:isFinal
		   		atts.put("isFinal", new ReverseBooleanConfigurationStrategy("isFinal"));
		   				
			HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
			//COUNTER:0
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
			//INC COUNTER: 1
			mut.setId("m2");
							mutations.add(mut);
		}
		//END MODIFY INFORMATION mutation11
			return mutations;	
		}
		//COUNTER: 11
		//METHOD NAME:registry11
		//REGISTRY COUNTER: 10
		private AppMutation registry11(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
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
		attMut0.setAttName("isFinal");
		oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("isFinal");
		newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("isFinal");
		if (oldAttVal != null) {
			attMut0.setOldVal(oldAttVal.toString());
		}
		if (newAttVal != null) {
			attMut0.setNewVal(newAttVal.toString());
		}
		attMut0.setDef(hmMutator.get("m11"));
		attsMut.add(attMut0);
		icMut.setDef(hmMutator.get("m11"));
		//ATTRIBUTE COUNTER INC: 0
			appMut = icMut;
			return appMut;
		}
		public void block_third(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/model/";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File(modelURI).listFiles();
		   for (int i = 0; i < files.length; i++) {
		   	if (files[i].isFile() == true) {
		   		if (files[i].getName().endsWith(".model") == true) {
		   			if (fromNames.size() == 0) {
		   				String pathfile = files[i].getPath();
		   				if (pathfile.endsWith(".model") == true) {
		   					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   					seedModelFilenames.put(pathfile, files[i].getPath());
		   				}
		   			}
		   			else {
		   				for (String fromName : fromNames) {
		   					String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
		   					System.out.println("modelFolder: " + modelFolder);
		   					File[] mutFiles = new File(modelFolder).listFiles();
		   					if (mutFiles != null) {
		   						for (int j = 0; j < mutFiles.length; j++) {
		   							if (mutFiles[j].isFile() == true) {
		   								String pathfile = mutFiles[j].getPath();
		   								if (pathfile.endsWith(".model") == true) {
		   									hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
		   									hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
		   									seedModelFilenames.put(pathfile, files[i].getPath());
		   								}
		   							}
		   							else {
		   								generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
		   							}
		   						}
		   					}
		   				}
		   			}
		   		}
		   	}
		   }
		   
		   //Load MetaModel
		   ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		   
		   //Load Model
		   Set<String> modelFilenames = hashmapModelFilenames.keySet();
		   for (String modelFilename : modelFilenames) {
		   	String seedModelFilename = seedModelFilenames.get(modelFilename);
		   	HashSet<String> hashsetMutantsBlock = null;
		   	if (seedModelFilename != null) {
		   		if (hashmapMutants.get(seedModelFilename) != null) {
		   			hashsetMutantsBlock = hashmapMutants.get(seedModelFilename);
		   		}
		   	}
		   	if (hashsetMutantsBlock == null) {
		   		hashsetMutantsBlock = new HashSet<String>();
		   	}
		   	if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
		   		hashsetMutantsBlock.add(seedModelFilename);
		   	}
		   	Resource model = ModelManager.loadModel(packages, modelFilename);
		   	Resource seed = ModelManager.loadModel(packages, modelFilename);
		   
		   	HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
		   	HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
		   
		//3
		   	numMutants = 3;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelEduSample/out/DFAWodelEduSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/third/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 9
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 9
		   	   				//RESET COUNTER: 9
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	
		   	   	   			   	   	//COUNTER: 10	
		   	   	   			//COMMAND: 115
		   	   	   			//REGISTRY COUNTER: 10
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:115
		   	   	   			//METHOD NAME:mutation10
		   	   	   			
		   	   	   			ArrayList<Mutator> l115 = mutation10(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 10
		   	   	   			//REGISTRY METHOD NAME:registry10
		   	   	   			
		   	   	   			if (l115 != null) {
		   	   	   				for (Mutator mut : l115) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry10(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   	   	   			   	   	//COUNTER: 11	
		   	   	   			//COMMAND: 116
		   	   	   			//REGISTRY COUNTER: 11
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:116
		   	   	   			//METHOD NAME:mutation11
		   	   	   			
		   	   	   			ArrayList<Mutator> l116 = mutation11(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 11
		   	   	   			//REGISTRY METHOD NAME:registry11
		   	   	   			
		   	   	   			if (l116 != null) {
		   	   	   				for (Mutator mut : l116) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry11(mut, hmMutator, seed);
		   	   	   						if (appMut != null) {
		   	   	   							muts.getMuts().add(appMut);
		   	   	   						}
		   	   	   						}
		   	   	   					}
		   	   	   				}
		   	   	   			}
		   	   	   			}
		   			
		   			// MUTANT COMPLETION AND REGISTRY
		   			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
		   		       		if (rules.get("State") == null) {
		   		       			rules.put("State", new ArrayList<String>());
		   		       		}
		   		       		ArrayList<String> newrules = rules.get("State");
		   		       		newrules.add("isInitial or Set{self}->closure(s | Transition.allInstances()->select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)");
		   	       			rules.put("State", newrules);
		   	       			
		   			isRepeated = registryMutantWithBlocks(packages, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "third", fromNames, i);
		   	      
		   		    		//Reload input
		   		    		try {
		   				model.unload();
		   				model.load(null); 
		   			} catch (Exception e) {}
		   	   			}
		   	   		}
		
		}
	}
	public void execute(int maxAttempts, int numMutants, boolean registry) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
 		HashMap<String, HashSet<String>> hashmapMutants = new HashMap<String, HashSet<String>>();
		ArrayList<String> fromNames = null;
		fromNames = new ArrayList<String>();
		block_simple1(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		block_simple2(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		block_first(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		fromNames.add("first");
		block_second(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		fromNames.add("first");
		block_third(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
	}
	
}

