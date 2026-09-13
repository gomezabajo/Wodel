package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.ModifyTargetReferenceMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.Constraint
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import wodel.dsls.runner.WodelUtils

class WodelGeneratorModifyTargetReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	
	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		
		
    	«IF mt instanceof ModifyTargetReferenceMutator»
		//«var ModifyTargetReferenceMutator mut = mt as ModifyTargetReferenceMutator»
		//MODIFY TARGET REFERENCE «methodName»
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			List<EObject> listSources = new ArrayList<EObject>();
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, models, "«(mut.source as RandomTypeSelection).type.name»");
				listSources.addAll(sourceSelection.getObjects());
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, models, "«(mut.source as CompleteTypeSelection).type.name»");
				listSources.addAll(sourceSelection.getObjects());
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				SpecificObjectSelection sourceSelection = null;
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
					listSources.add(sourceSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, models, (EObject) null);
				listSources.addAll(sourceSelection.getObjects());
			«ENDIF»
			Mutator mutator = null;
			if (listSources == null || listSources.isEmpty()) {
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
									
		
			
			for (EObject sourceObject : listSources) {
				try (OwnedResourceScope owned = new OwnedResourceScope()) {
					Resource resource = owned.own(
							    							                    ModelManager.cloneModel(
							    							                        model,
							    							                        tempModel));
					
			Resource sourceModel = null;
					try {
				ObSelectionStrategy srcSelection = new SpecificObjectSelection(packages, resource, sourceObject);
				List<EObject> listTargets = new ArrayList<EObject>();
			«IF mut.newTarget instanceof RandomTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, resource, "«(mut.newTarget as RandomTypeSelection).type.name»");
				listTargets.addAll(newTargetSelection.getObjects());
			«ELSEIF mut.newTarget instanceof OtherTypeSelection»
				Object otherRef = null;
				if (sourceObject != null) {
					for (EReference ref : sourceObject.eClass().getEAllReferences()) {
						if (ref.getName().equals("«mut.refType.name»")) {
							otherRef = sourceObject.eGet(ref);
							break;
						}
					}
					OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, resource, "«(mut.newTarget as OtherTypeSelection).type.name»", otherRef);
					listTargets.addAll(newTargetSelection.getObjects());
				}
			«ELSEIF mut.newTarget instanceof CompleteTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, resource, "«(mut.newTarget as CompleteTypeSelection).type.name»");			
				listTargets.addAll(newTargetSelection.getObjects());
			«ELSEIF mut.newTarget instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newTarget as SpecificObjectSelection).objSel.name»");
				SpecificObjectSelection newTargetSelection = null;
				if (entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» != null) {
					newTargetSelection = new SpecificObjectSelection(entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getKey());
					listTargets.add(newTargetSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
			«ELSE»
				SpecificObjectSelection newTargetSelection = new SpecificObjectSelection(packages, resource, (EObject) null);
				listTargets.add(newTargetSelection.getObject());
			«ENDIF»
				for (EObject targetObject : listTargets) {
					sourceModel =
					    owned.own(
					        ModelManager.cloneModel(
					            model,
					            WodelTempModelContext.nextModelPath(
					                model,
					                "«methodName»")));
					
					String sourceFragment =
					    EcoreUtil.getURI(
					        sourceObject)
					        .fragment();
					
					EObject source =
					    sourceModel.getEObject(
					        sourceFragment);
					
					if (source == null) {
					    continue;
					}
					
					
					String targetFragment =
					    EcoreUtil.getURI(
					        targetObject)
					        .fragment();
					
					EObject target =
					    sourceModel.getEObject(
					        targetFragment);
					
					if (target == null) {
					    continue;
					}
if (source.eResource() != sourceModel) {
    throw new IllegalStateException(
        "mst source does not belong to sourceModel");
}

if (target.eResource() != sourceModel) {
    throw new IllegalStateException(
        "mst target does not belong to sourceModel");
}
ObSelectionStrategy srcSelection2 = new SpecificObjectSelection(packages, sourceModel, source);
					// We avoid cycles
					EObject previous = source.eContainer();
					while (previous != null && !EcoreUtil.equals(previous, target)) {
						previous = previous.eContainer();
					}
					if (EcoreUtil.equals(previous, target)) {
						continue;
					}
					ObSelectionStrategy tarSelection = new SpecificObjectSelection(packages, sourceModel, target);
					ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(srcSelection2.getModel(), srcSelection2.getMetaModel(), srcSelection2, tarSelection, "«mut.refType.name»");
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
				            srcSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				            packages);
				            
				            EReference sourceReference =
				            						    		    (EReference) source
				            						    		        .eClass()
				            						    		        .getEStructuralFeature(
				            						    		            "«mut.refType.name»");
				            
				            						    		EObject oldActualTarget =
				            						    		    sourceReference == null
				            						    		        ? null
				            						    		        : (EObject) source.eGet(
				            						    		            sourceReference);
					Object mutated = mut.mutate();
				            						        EObject newActualTarget =
				            						        	    sourceReference == null
				            						        	        ? null
				            						        	        : (EObject) source.eGet(
				            						        	            sourceReference);
				            
				            						        	boolean actualChanged =
				            						        	    oldActualTarget
				            						        	        != newActualTarget;
if (mutated == null
        || !actualChanged) {

    continue;
}
					if (mutated != null) {
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, srcSelection2.getModel(), clue, mutPaths, packages);
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
			} finally {

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
				//Unload tmp model
				try {
					resource.unload();
				} catch (Exception e) {}
									
				}
				} finally {
													
													}
			}
		«ENDIF»
		}
		//END MODIFY TARGET REFERENCE «methodName»
	«ENDIF»
	'''
	
}