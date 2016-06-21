
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
		public void block_first(int maxAttempts, int numMutants, boolean registry, ArrayList<String> fromNames, HashMap<String, HashSet<String>> hashmapMutants) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/exercise1.model";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File[1];
		   files[0] = new File(modelURI);
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
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/DFAWodelSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/first/Output" + i + ".model";
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
		   	   	   			//COMMAND: 41
		   	   	   			//REGISTRY COUNTER: 1
		   	   	   			max = getRandom(3) + 0;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:41
		   	   	   			//METHOD NAME:mutation1
		   	   	   			
		   	   	   			ArrayList<Mutator> l41 = mutation1(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 1
		   	   	   			//REGISTRY METHOD NAME:registry1
		   	   	   			
		   	   	   			if (l41 != null) {
		   	   	   				for (Mutator mut : l41) {
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
		//COUNTER: 2
		//METHOD NAME:mutation2
		private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation2
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
			//INC COUNTER: 0
			mut.setId("m1");
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
		attMut0.setDef(hmMutator.get("m2"));
		attsMut.add(attMut0);
		icMut.setDef(hmMutator.get("m2"));
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
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/exercise1.model";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File[1];
		   files[0] = new File(modelURI);
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
		   
		//1
		   	numMutants = 1;
		   	
		   	
		   	   		Bundle bundle = Platform.getBundle("MutProgram");
		   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
		   	
		   	//Load MetaModel
		   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/DFAWodelSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/second/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + ".model";
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
		   	   	   			//COMMAND: 42
		   	   	   			//REGISTRY COUNTER: 2
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:42
		   	   	   			//METHOD NAME:mutation2
		   	   	   			
		   	   	   			ArrayList<Mutator> l42 = mutation2(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 2
		   	   	   			//REGISTRY METHOD NAME:registry2
		   	   	   			
		   	   	   			if (l42 != null) {
		   	   	   				for (Mutator mut : l42) {
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
		//COUNTER: 3
		//METHOD NAME:mutation3
		private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
			ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		//MODIFY INFORMATION mutation3
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "State");
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
				
			HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//COUNTER:
			//COUNTER:0
			//NAME:name
		//NAME:name
		atts.put("name", new RandomStringConfigurationStrategy(4, 6, false)
		);
		   				
			HashMap<String, ReferenceConfigurationStrategy> refs = new HashMap<String, ReferenceConfigurationStrategy>();
			//COUNTER:0
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, atts, refs);
			//INC COUNTER: 0
			mut.setId("m1");
							mutations.add(mut);
		}
		//END MODIFY INFORMATION mutation3
			return mutations;	
		}
		//COUNTER: 3
		//METHOD NAME:registry3
		//REGISTRY COUNTER: 2
		private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed) {
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
		attMut0.setAttName("name");
		oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("name");
		newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("name");
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
		
		   String ecoreURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/DFAAutomaton.ecore";
		   String modelURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/exercise1.model";
		   String modelsURI = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/";
		   
		   HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		   HashMap<String, String> hashmapModelFolders = new HashMap<String, String>();
		   HashMap<String, String> seedModelFilenames = new HashMap<String, String>();
		   File[] files = new File[1];
		   files[0] = new File(modelURI);
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
		   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out/DFAWodelSample.model").toFileString());
		   	
		   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		   			
		   	   	   	for (int i = 0; i < numMutants; i++) {
		   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/third/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + ".model";
		   	   	   		boolean isRepeated = true;
		   	   			int attempts = 0;
		   	   			int max = 0;
		   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
		   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		   	   				attempts++;
		   	   				//RESET COUNTER: 2
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 2
		   	   				//RESET COUNTER: 2
		   	   				//RESET COUNTER: 0
		   	   				//RESET COUNTER: 0
		   	
		   	   	   			   	   	//COUNTER: 3	
		   	   	   			//COMMAND: 43
		   	   	   			//REGISTRY COUNTER: 3
		   	   	   			max = 1;
		   	   	   			for (int j = 0; j < max; j++) {
		   	   	   			//NAME:43
		   	   	   			//METHOD NAME:mutation3
		   	   	   			
		   	   	   			ArrayList<Mutator> l43 = mutation3(packages, model, hashmapEObject, hashmapList);
		   	   	   			//COUNTER: 3
		   	   	   			//REGISTRY METHOD NAME:registry3
		   	   	   			
		   	   	   			if (l43 != null) {
		   	   	   				for (Mutator mut : l43) {
		   	   	   					if (mut != null) {
		   	   	   						EObject mutated = (EObject) mut.mutate();
		   	   	   						if (mutated != null) {
		   	   	   						AppMutation appMut = registry3(mut, hmMutator, seed);
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
		block_first(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		fromNames.add("first");
		block_second(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
		fromNames = new ArrayList<String>();
		fromNames.add("first");
		block_third(maxAttempts, numMutants, registry, fromNames, hashmapMutants);
	}
	
}

