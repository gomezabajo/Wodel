package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.RetypeObjectMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import java.util.List
import org.eclipse.emf.common.util.URI
import mutatorenvironment.Constraint
import mutatorenvironment.Mutator
import wodel.dsls.runner.WodelUtils

class WodelGeneratorRetypeObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	
	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof RetypeObjectMutator»
		//«var RetypeObjectMutator mut = mt as RetypeObjectMutator»
		
		//RETYPE OBJECT «methodName»
		List<String> mutTypes = new ArrayList<String>();
		//«var boolean definedObjects = false»
		«IF mut.object instanceof RandomTypeSelection»
		//«var RandomTypeSelection selection = mut.object as RandomTypeSelection»
		«IF selection.types !== null && selection.types.size > 0»
		«FOR EClass type : selection.types»
		mutTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF selection.type !== null»
		mutTypes.add("«selection.type.name»");
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		//«var CompleteTypeSelection selection = mut.object as CompleteTypeSelection»
		«IF selection.types !== null && selection.types.size > 0»
		«FOR EClass type : selection.types»
		mutTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF selection.type !== null»
		mutTypes.add("«selection.type.name»");
		«ENDIF»
		«ENDIF»
		List<String> targetTypes = new ArrayList<String>();
		«IF mut.types !== null && mut.types.size > 0»
		«FOR EClass type : mut.types»
		targetTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF mut.type !== null»
		targetTypes.add("«mut.type.name»");
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, models, mutTypes);
		«IF mut.object.expression === null»
		List<EObject> objects = rts.getObjects();
		//«definedObjects = true»
		«ELSE»
		List<EObject> objects = rts.getObjects();
		//«definedObjects = true»
		//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
		//EXPRESSION LEVEL: «expressionList.add(0)»
		//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
		//INDEX EXPRESSION: «nExpression.set(0, 0)»
		//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
		//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
		Expression exp«expressionList.get(0)» = new Expression();
		//«var int[] nReference = newIntArrayOfSize(1)»
		//«nReference.set(0, 0)»
		//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
		//«{evaluation.set(0, false); ""}»
		«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
«IF evaluation.get(0)»
		List<EObject> selectedObjects = auxObjects;
«ELSE»
		List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
«ENDIF»
		«IF definedObjects == false»
		List<EObject> objects = null;
		//«definedObjects = true»
		«ENDIF»
		if (selectedObjects.size() > 0) {
			objects = selectedObjects;
		}
		«ENDIF»
		ObSelectionStrategy objectSelection = null; 
		if (objects != null && objects.size() > 0) {
			objectSelection = new SpecificObjectSelection(packages, models, objects.get(0));
		}
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, models, mutTypes);
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, models, objects.get(0));
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
		if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
			objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
			if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
			}
			else {
				return numMutantsGenerated;
			}
		}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
			objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
		} else {
			return numMutantsGenerated;
		}
		«ENDIF»
		EObject container = null;
		ObSelectionStrategy containerSelection = null;
		if (objectSelection != null) {
		«IF mut.container === null»
			container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ELSE»
		«IF mut.container instanceof RandomTypeSelection»
			RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as RandomTypeSelection).type.name»");
			container = rtsContainer.getObject();
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ENDIF»
		«IF mut.container instanceof CompleteTypeSelection»
			«/* THE SAME AS RANDOM */»
			RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as CompleteTypeSelection).type.name»");
			container = rtsContainer.getObject();
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ENDIF»
		«IF mut.container instanceof SpecificObjectSelection»
			«IF mut.refType !== null»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
			} else {
				return numMutantsGenerated;
			}
			«ENDIF»
		«ENDIF»
		«IF mut.container instanceof SpecificClosureSelection»
			«IF mut.refType !== null»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
			} else {
				return numMutantsGenerated;
			}
			«ENDIF»
		«ENDIF»
		«ENDIF»
		}
		«IF mut.refType !== null»
		SpecificReferenceSelection referenceSelection = null;
		«IF mut.container instanceof SpecificObjectSelection»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
			referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
		} else {
			return mutations;
		}
		«ELSEIF mut.container instanceof SpecificClosureSelection»
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
			referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
		} else {
			return numMutantsGenerated;
		}
		«ELSE»
		SpecificReferenceSelection referenceSelection = null;
		if (containerSelection != null) {
			referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.refType.name»", containerSelection);
		}
		«ENDIF»
		«ELSE»
		SpecificReferenceSelection referenceSelection = null;
		if (containerSelection != null) {
			referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);
		}
		«ENDIF»
		«IF mut.container === null»
		«IF mut.object instanceof SpecificObjectSelection»
		List<EObject> objects =  null;
		if (objectSelection != null) {
			objects = objectSelection.getObjects();
			if (objects == null) {
				objects = new ArrayList<EObject>();
				objects.add(objectSelection.getObject());
			}
		}
		«ENDIF»
if (objects == null || objects.isEmpty()) {
							return numMutantsGenerated;
						}
								Resource model = MutatorUtils.currentModel(models);

						if (model == null) {
							return numMutantsGenerated;
						}
						String tempModel =
																			    WodelTempModelContext.nextModelPath(
																			        model,
																			        "«methodName»");
		    for (int obn = 0; obn < objects.size(); obn++) {
		    	for (String targetType : targetTypes) {
		    		List<String> tTypes = new ArrayList<String>();
		    		tTypes.add(targetType);
try (OwnedResourceScope owned = new OwnedResourceScope()) {
    Resource m = owned.own(
    											                    ModelManager.cloneModel(
    											                        model,
    											                        tempModel));
    		models.add(m);
    		try {
			«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
			rts = new RandomTypeSelection(packages, m, mutTypes);
			List<EObject> mObjects = rts.getObjects();
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			cts = new RandomTypeSelection(packages, m, mutTypes);
			List<EObject> mObjects = cts.getObjects();
			«ENDIF»
				«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy obSelection = null;
				EObject localObject = null;
				if (mObjects.size() > obn) {
				localObject = ModelManager.getObject(m, mObjects.get(obn));
				}
				if (localObject == null) {
					continue;
				}
				obSelection = new SpecificObjectSelection(packages, m, localObject);
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy obSelection = null;
				EObject localObject = null;
				if (mObjects.size() > obn) {

				localObject = ModelManager.getObject(m, mObjects.get(obn));
				}
				if (localObject == null) {
					continue;
				}
				obSelection = new SpecificObjectSelection(packages, m, localObject);
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				ObSelectionStrategy obSelection = null;
				EObject localObject = null;
				if (mObjects.size() > obn) {

				localObject = ModelManager.getObject(m, mObjects.get(obn));
				}
				if (localObject == null) {
					continue;
				}
				obSelection = new SpecificObjectSelection(packages, m, localObject);
				«ENDIF»
				EObject c = ModelManager.getContainer(m, obSelection.getObject());
				ObSelectionStrategy cSelection = new SpecificObjectSelection(packages, m, c);
				SpecificReferenceSelection rSelection = new SpecificReferenceSelection(packages, m, null, null);
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION:«var int position = 0»
		«FOR AttributeSet c : mut.attributes»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			«c.method(false, false, counter, position, true, "obSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		«FOR ReferenceSet c : mut.references»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
			//EXPRESSION LEVEL: «expressionList.add(0)»
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
		//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
		//«{evaluation.set(0, false); ""}»
			«c.method(mut, counter, expressionList, nExpression, recursionIndexExpression, true, false, true, evaluation)»
		«ENDFOR»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
		RetypeObjectMutator mut = new RetypeObjectMutator(model, packages, objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, tTypes);
		«ENDIF»
		«ENDIF»
		«IF mut.container === null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
		RetypeObjectMutator mut = new RetypeObjectMutator(m, packages, obSelection.getObject(), rSelection, cSelection, atts, refs, tTypes);
		«ENDIF»
		«ENDIF»
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}

		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//COUNTER: «nRegistryMethodCall.set(0, nRegistryMethodCall.get(0) + 1)»
		//REGISTRY METHOD NAME:«var String registryMethodName = "registry" + nRegistryMethodCall.get(0).toString()»
   		int mutsMark = mutationMark(muts);
		«IF executeMutation == true»
			if (mut != null) {
					/*
				     * IMPORTANT:
				     * Capture the removed EObject from the PRE-MUTATION
				     * source model. Do not use mut.getObject() here:
				     * RemoveObjectMutator only populates that information
				     * during mutate().
				     */
				    EObject clue =
				        findEObjectForRegistry(
				            seed,
				            model,
				            objectSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				            packages);
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						«IF !(mut.object instanceof CompleteTypeSelection)»
						hmObjects.put("«mut.name»", entry);
						«ELSE»
						hmObjects.remove("«mut.name»");
						hmList.put("«mut.name»", entries);
						«ENDIF»
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, model, clue, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				try {
				if (mutator != null) {
				//COUNTER: «nMethodCall.set(0, nMethodCall.get(0) + 1)»
				//MUTATION METHOD NAME:«var String nMethodName = "mutation" + nMethodCall.get(0).toString()»
				«IF last == false»
				«IF standalone == false»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
						«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
				«ENDIF»
				«ENDIF»
		«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
						«nMethodName»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
				«ENDIF»
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ENDIF»
				«ELSE»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
						«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
				«ENDIF»
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ENDIF»
		«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
						«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
				«ENDIF»
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				«ENDIF»
				} finally {
					     MutatorUtils.rollbackMutations(
									        muts,
								        mutsMark);
				}
									} finally {
									models.remove(m);
									}
				}
				}
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
				«FOR Constraint constraint : e.constraints»
				if (rules.get("«constraint.type.name»") == null) {
					rules.put("«constraint.type.name»", new ArrayList<String>());
				}
				List<String> newrules = rules.get("«constraint.type.name»");
				«IF constraint.expressions !== null»
					«FOR expression : constraint.expressions»
					newrules.add("«WodelUtils.getConstraintText(fileURI.lastSegment, expression)»");
				«ENDFOR»
				«ENDIF»
				«IF constraint.rules !== null»
					«FOR String rule : constraint.rules»
					newrules.add("«rule»");
	       		«ENDFOR»
	       		«ENDIF»
				rules.put("«constraint.type.name»", newrules);
	       		«ENDFOR»
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
			Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);
		   		«IF b === null»
		   		«IF standalone == false»
		   		//System.out.println("ecoreURI: " + ecoreURI);
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   		//System.out.println("ecoreURI: " + ecoreURI);
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
		   		//System.out.println("ecoreURI: " + ecoreURI);
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
				//System.out.println("ecoreURI: " + ecoreURI);
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					}
					//if (muts != null) {
					//	muts.getMuts().clear();
					//}
		} finally {
	        MutatorUtils.rollbackMutations(
	            muts,
	            mutsMark);
	    }
									
		} finally {
											models.remove(m);
											}
		}
		}
		«IF mut.container === null»
			}
		«ENDIF»
		«ENDIF»
			//END RETYPE OBJECT «methodName»
	«ENDIF»
	'''
	
	
}