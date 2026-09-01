package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.CloneObjectMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import org.eclipse.emf.common.util.URI
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import java.util.List
import java.util.ArrayList
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.Mutator
import wodel.dsls.runner.WodelUtils

class WodelGeneratorCloneObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	
		override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof CloneObjectMutator»
			//«var CloneObjectMutator mut = mt as CloneObjectMutator»
			//CLONE OBJECT «methodName»
		Resource model = MutatorUtils.currentModel(models);
		if (model == null) {
			return numMutantsGenerated;
		}
			«IF mut.object instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
				«IF mut.object.expression === null»
					List<EObject> objects = rts.getObjects();
				«ELSE»
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
				«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection cts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				List<EObject> objects = cts.getObjects();
				«IF mut.object.expression === null»
					List<EObject> objects = cts.getObjects();
				«ELSE»
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
			«ENDIF»
			«ELSEIF mut.object instanceof SpecificObjectSelection»
			    List<EObject> objects = new ArrayList<EObject>();
				ObSelectionStrategy objectSelection = null;
				if (hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						return numMutantsGenerated;
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered);
				} else {
					if (hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
							EObject obj = ModelManager.getObject(model, ent.getKey());
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(packages, model, objs);
					}
					else {
						return numMutantsGenerated;
					}
				}
				if (objectSelection != null) {
					objects.add(objectSelection.getObject());
				}
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objects.get(0));
				EObject object = o.get(ModelManager.getRandomIndex(o));
				objectSelection = new SpecificObjectSelection(packages, model, object);
				objects.clear();
				objects.add(object);
				«ENDIF»
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				«IF ((mut.object as SpecificClosureSelection).objSel !== null && (mut.object as SpecificClosureSelection).refType !== null)»
				List<EObject> objects = new ArrayList<EObject>();
				ObSelectionStrategy objectSelection = null;
				if (hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
					EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						return numMutantsGenerated;
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered);
				} else {
					if (hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»");
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificClosureSelection).objSel.name») {
							EObject obj = ModelManager.getObject(model, ent.getKey());
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(packages, model, objs);
					}
					else {
						return numMutantsGenerated;
					}
				}
				if (objectSelection != null) {
					objects.add(objectSelection.getObject());
				}
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
				EObject object = o.get(ModelManager.getRandomIndex(o));
				objectSelection = new SpecificObjectSelection(packages, model, object);
				objects.add(object);
				«ENDIF»
				«ENDIF»
			«ENDIF»
		«IF mut.container === null»
		if (objects == null || objects.isEmpty()) {
			return numMutantsGenerated;
		}
		String tempModel =
															    WodelTempModelContext.nextModelPath(
															        model,
															        "«methodName»");
		    for (int obn = 0; obn < objects.size(); obn++) {
		    	try (OwnedResourceScope owned = new OwnedResourceScope()) {
		    							Resource resource = owned.own(
		    							                    ModelManager.cloneModel(
		    							                        model,
		    							                        tempModel));
			Resource m = EMFCopier.copyResource(resource);
			models.add(m);
			try {
			«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
			rts = new RandomTypeSelection(packages, m, "«(mut.object as RandomTypeSelection).type.name»");
			List<EObject> mObjects = rts.getObjects();
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			cts = new RandomTypeSelection(packages, m, "«(mut.object as CompleteTypeSelection).type.name»");
			List<EObject> mObjects = cts.getObjects();
			«ENDIF»
				«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy objectSelection = null;
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				ObSelectionStrategy objectSelection = null;
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				EObject container = ModelManager.getContainer(m, objectSelection.getObject());
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, m, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, m, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(packages, m, recovered);
					referenceSelection = new SpecificReferenceSelection(packages, m, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
				«ENDIF»
				} else {
					return numMutantsGenerated;
				}
			«ENDIF»
			«IF mut.container instanceof SpecificClosureSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(models, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(packages, m, recovered, "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(pakages, m, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION:«var int position = 0»
		«FOR AttributeSet c : mut.attributes»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			«c.method(false, false, counter, position, true, "objectSelection")»
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
			«c.method(mut, counter, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
		«ENDFOR»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as CompleteTypeSelection).type.name»");
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificClosureSelection).objSel as SelectObjectMutator).object.type.name»");
		«ENDIF»
		«ENDIF»
		«IF mut.container === null»
		«IF mut.object instanceof RandomTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as CompleteTypeSelection).type.name»");
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificClosureSelection).objSel as SelectObjectMutator).object.type.name»");
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
						«IF !(mut.container instanceof CompleteTypeSelection)»
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
				«ENDIF»
				mutator = mut;
				try {
				if (mutator != null) {
				//COUNTER: «nMethodCall.set(0, nMethodCall.get(0) + 1)»
				//MUTATION METHOD NAME:«var String nMethodName = "mutation" + nMethodCall.get(0).toString()»
				«IF last == false»
				«IF mut.container !== null»
				«IF standalone == false»
				«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF mut.container === null»
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
				«ENDIF»
				} finally {
									     MutatorUtils.rollbackMutations(
									        muts,
									        mutsMark);
									}
									}
									
									} finally {
																		models.remove(resource);
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
		   		//System.out.println("ecoreURI: " + ecoreURI);
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, executionSeed);
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
																			models.remove(resource);
																			}
					}
		«ENDIF»
				}
			//END CLONE OBJECT «methodName»
		«ENDIF»
	'''
	
}