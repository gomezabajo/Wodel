package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import java.util.ArrayList
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.Mutator
import mutatorenvironment.RemoveObjectMutator
import mutatorenvironment.Program
import wodel.dsls.runner.WodelUtils

class WodelGeneratorRemoveObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	
	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		
		
		«IF mt instanceof RemoveObjectMutator»
		Resource model = MutatorUtils.currentModel(models);
		if (model == null) {
					return numMutantsGenerated;
				}
		//«var RemoveObjectMutator mut = mt as RemoveObjectMutator»
		// REMOVE OBJECT «methodName»
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			//«var boolean rts = false»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
				«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.object as CompleteTypeSelection).type.name»", mutatedObjects);
				«ENDIF»
				«ELSE»
					«IF mut.container instanceof RandomTypeSelection»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.container as RandomTypeSelection).type.name»");
						EObject container = rts.getObject();
						«IF mut.container.resource === null»
						containerSelection = new SpecificObjectSelection(packages, seed, container);
						«ELSE»
						«ENDIF»
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof CompleteTypeSelection»
						«/* THE SAME AS RANDOM */»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.container as CompleteTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, models, container);
						«IF mut.container.refType !== null»
						«IF mut.container.resource === null»
							referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, seed, "«mut.container.refType.name»", containerSelection);
						«ENDIF»
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof SpecificObjectSelection»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						«IF mut.container.resource === null»
							containerSelection = new SpecificObjectSelection(packages, models, recovered);
						«ELSE»
							containerSelection = new SpecificObjectSelection(packages, seed, recovered);
						«ENDIF»
						} else {
							return numMutantsGenerated;
						}
						«IF mut.container.refType !== null»
							if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
								referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", recovered);
							} else {
								return numMutantsGenerated;
							}
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
						«ENDIF»
					«ENDIF»
					«IF rts == true»
					«IF mut.object instanceof RandomTypeSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof CompleteTypeSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as CompleteTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof SpecificObjectSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as SpecificObjectSelection).type.name»", referenceSelection, containerSelection);
					«ENDIF»
					«ELSE»
					«IF mut.object instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof CompleteTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as CompleteTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof SpecificObjectSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as SpecificObjectSelection).type.name»", referenceSelection, containerSelection);
					«ENDIF»
					«ENDIF»
					«IF ((mut.object.expression === null) && (mut.container.expression === null))»
						List<EObject> objects = rts.getObjects();
					«ENDIF»
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container === null))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
				«IF mut.object.expression !== null»
					«IF mut.container === null»
					List<EObject> objects = rts.getObjects();
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
					«IF evaluation.get(0) == false»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSE»
					objects = auxObjects;
					«ENDIF»
					«ELSEIF mut.container.expression === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
					//INDEX EXPRESSION: «nExpression.set(0, 0)»
					//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
					//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
					Expression exp«expressionList.get(0)» = new Expression();
					//«var int[] nReference = newIntArrayOfSize(1)»
					//«nReference.set(0, 0)»
					«ENDIF»
				«ENDIF»
				«IF (mut.object.expression === null)»
					«IF ((mut.container !== null) && (mut.container.expression !== null))»
					List<EObject> objects = rts.getObjects();
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
					«mut.container.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
«IF evaluation.get(0) == false»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSE»
					objects = auxObjects;
«ENDIF»
					«ENDIF»
				«ENDIF»
				«ELSEIF mut.object instanceof SpecificObjectSelection»
				List<EObject> objects = new ArrayList<EObject>();
				«IF mut.container === null»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
					objectSelection = new SpecificObjectSelection(packages, models, recovered);
					objects.add(objectSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
				«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, models, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rts = new RandomTypeSelection(packages, models, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, models, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						containerSelection = new SpecificObjectSelection(packages, models, recovered);
					} else {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", recovered);
					} else {
						return numMutantsGenerated;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						containerSelection = new SpecificClosureSelection(packages, models, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						referenceSelection = new SpecificReferenceSelection(packages, models, "«mut.container.refType.name»", recovered);
					} else {
						return numMutantsGenerated;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, models, null, null);
				«ENDIF»
				«ENDIF»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
					objectSelection = new SpecificObjectSelection(packages, models, recovered, referenceSelection, containerSelection);
					objects.add(objectSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy obSelection = null;
			if (objects == null || objects.isEmpty()) {
						return numMutantsGenerated;
			}
						String tempModel =
																			    WodelTempModelContext.nextModelPath(
																			        model,
																			        "«methodName»");
   			Mutator mutator = null;
			
			if (objects != null) {
				for (EObject ob : objects) {
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
							Resource m = owned.own(
													                    ModelManager.cloneModel(
													                        model,
													                        tempModel));
					models.add(m);
					EObject obToMutate = ModelManager.getObject(m, ob);
					obSelection = new SpecificObjectSelection(packages, m, obToMutate);
					EObject containerToMutate = null;
					if (containerSelection != null && containerSelection.getObject() != null) {
						containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
					}
					ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m, containerToMutate);
					«IF mut.container !== null && mut.container.refType !== null && mut.container.refType.name !== null»
					SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(containerToMutateSelection.getMetaModel(), containerToMutateSelection.getModel(), "«mut.container.refType.name»", containerToMutateSelection.getObject());
					«ELSE»
					SpecificReferenceSelection referenceToMutateSelection = referenceSelection;
					«ENDIF»
					RemoveObjectMutator mut = new RemoveObjectMutator(containerToMutateSelection.getModel(), containerToMutateSelection.getMetaModel(), obToMutate, referenceToMutateSelection, containerToMutateSelection);
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
				            ob,
				            null,
				            null,
				            mutPaths,
				            packages);
				Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, obSelection.getModel(), clue, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				mutator = mut;
			«ENDIF»
			try {
			if (mutator != null) {
			//COUNTER: «nMethodCall.set(0, nMethodCall.get(0) + 1)»
			//MUTATION METHOD NAME:«var String nMethodName = "mutation" + nMethodCall.get(0).toString()»
			«IF last == false»
			«IF standalone == false»
			«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
			«ELSE»
			«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
			«ENDIF»
			numMutantsGenerated = k[0];
			}
			} finally {
											     MutatorUtils.rollbackMutations(
											        muts,
											        mutsMark);
			}
			}
}
			«ENDIF»
			«IF last == true»
			// MUTANT COMPLETION AND REGISTRY
			Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
			«FOR constraint : e.constraints»
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
				«FOR rule : constraint.rules»
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
	   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);
	   		«ELSE»
	   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true, true);
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
				//if (muts != null) {
				//	muts.getMuts().clear();
				//}
			}
				} finally {
				     MutatorUtils.rollbackMutations(
				        muts,
				        mutsMark);
				}
				}
		}
		«ENDIF»
		«ENDIF»
		«IF mut.object instanceof CompleteTypeSelection»
if (objects == null || objects.isEmpty()) {
							return numMutantsGenerated;
						}
						String tempModel =
																			    WodelTempModelContext.nextModelPath(
																			        model,
																			        "«methodName»");
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
									Resource m = owned.own(
															                    ModelManager.cloneModel(
															                        model,
															                        tempModel));
			models.add(m);
			try {
			ObSelectionStrategy obSelection = null;
			Mutator mutator = null;
			if (objects != null) {
				obSelection = new SpecificObjectSelection(packages, model, objects);
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), objects, referenceSelection, containerSelection);
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
				            obSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				            packages);
				Object mutated = mut.mutate();
				if (mutated != null) {
					AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, obSelection.getModel(), clue, mutPaths, packages);
					if (appMut != null) {
						muts.getMuts().add(appMut);
					}
				}
				mutator = mut;
			}
			«ENDIF»
			try {
			if (mutator != null) {
			//COUNTER: «nMethodCall.set(0, nMethodCall.get(0) + 1)»
			//MUTATION METHOD NAME:«var String nMethodName = "mutation" + nMethodCall.get(0).toString()»
			«IF last == false»
			«IF standalone == false»
			«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
			«ELSE»
			«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
			«ENDIF»
			numMutantsGenerated = k[0];
			}
			} finally {
											     MutatorUtils.rollbackMutations(
											        muts,
								        mutsMark);
			}
									
			}
			} finally {
												models.remove(m);
												}
			«ENDIF»
			«IF last == true»
			// MUTANT COMPLETION AND REGISTRY
			Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
			«FOR constraint : e.constraints»
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
				«FOR rule : constraint.rules»
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
	   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);
	   		«ELSE»
	   		//System.out.println("ecoreURI: " + ecoreURI);
	   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true, true);
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
				//if (muts != null) {
				//	muts.getMuts().clear();
				//}
	}
	} finally {
	     MutatorUtils.rollbackMutations(
	        muts,
	        mutsMark);
	}
									
	}
	} finally {
										models.remove(m);
										}
		«ENDIF»
		«ENDIF»
	}

		//END REMOVE OBJECT «methodName»
	«ENDIF»
	'''
}