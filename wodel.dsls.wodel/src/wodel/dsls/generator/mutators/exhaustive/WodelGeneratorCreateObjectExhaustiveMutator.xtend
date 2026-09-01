package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import wodel.dsls.runner.WodelUtils

class WodelGeneratorCreateObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof CreateObjectMutator»
		//«var CreateObjectMutator mut = mt as CreateObjectMutator»
		//CREATE OBJECT «methodName»
		Resource model = MutatorUtils.currentModel(models);

		if (model == null) {
			return numMutantsGenerated;
		}
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION:«var int position = 0»
		«FOR AttributeSet c : mut.attributes»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			«c.method(false, false, counter, position, true, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
		//COUNTER:«{counter = newIntArrayOfSize(1); ""}»
		//COUNTER:«{counter.set(0, 0); ""}»
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
				String tempModel =
																	    WodelTempModelContext.nextModelPath(
																	        model,
																	        "«methodName»");
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
				    							Resource resource = owned.own(
				    							                    ModelManager.cloneModel(
				    							                        model,
				    							                        tempModel));
				    							                        models.add(resource);
		«IF mut.container === null»
			List<EObject> containers = ModelManager.getParentObjects(packages, resource, "«mut.type.name»");
			if (containers == null || containers.isEmpty()) {
			    return numMutantsGenerated;
			}
			ModelManager.sortEObjectsDeterministically(containers);
			EObject container = containers.get(ModelManager.getRandomIndex(containers));
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, resource, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, resource, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(
						                models,
						                entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					}
					if (recovered == null) {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(packages, resource, recovered);
					referenceSelection = new SpecificReferenceSelection(packages, resource, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);
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
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(
						                models,
						                entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					}
					if (recovered == null) {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(packages, resource, recovered, "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(pakages, resource, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
		«ENDIF»
	try {
		CreateObjectMutator mut = new CreateObjectMutator(resource, packages, referenceSelection, containerSelection, atts, refs, "«mut.type.name»");
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
				            containerSelection.getObject(),
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
				}
				«ENDIF»
				mutator = mut;
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
									} finally {
									models.remove(resource);
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
					//if (muts != null) {
					//	muts.getMuts().clear();
					//}
					}
					} finally {
						     MutatorUtils.rollbackMutations(
						        muts,
						        mutsMark);
						}
									} finally {
									models.remove(resource);
									}
		«ENDIF»
		}
		//END CREATE OBJECT «methodName»
	«ENDIF»
	'''
}