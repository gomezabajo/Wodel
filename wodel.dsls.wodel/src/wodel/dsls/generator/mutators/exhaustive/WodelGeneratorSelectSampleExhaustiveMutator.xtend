package wodel.dsls.generator.mutators.exhaustive

import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EStructuralFeature

import mutatorenvironment.AttributeEvaluation
import mutatorenvironment.Block
import mutatorenvironment.Mutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Program
import mutatorenvironment.ReferenceEvaluation
import mutatorenvironment.SampleClause
import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.SpecificObjectSelection

import wodel.dsls.runner.WodelUtils
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference

class WodelGeneratorSelectSampleExhaustiveMutator
        extends WodelGeneratorGenericOperatorExhaustiveMutator {


    override apply(
            Mutator mt,
            MutatorEnvironment e,
            Block b,
            String methodName,
            int[] nMutation,
            int[] nMethodCall,
            int[] nRegistryMutation,
            int[] nRegistryMethodCall,
            boolean executeMutation,
            boolean last,
            String className,
            URI fileURI,
            Program program,
            IProject project,
            boolean standalone) '''

        «IF mt instanceof SelectSampleMutator»

        //«var SelectSampleMutator mut =
            mt as SelectSampleMutator»


        // =====================================================
        // SELECT SAMPLE OBJECT «methodName»
        // =====================================================

        ObSelectionStrategy objectSelection = null;

        List<EPackage> resourcePackages =
            packages;

        List<Resource> resources =
            new ArrayList<Resource>();

        resources.addAll(
            models);


        /*
         * =====================================================
         * Resolve the source collection
         * =====================================================
         */

        «IF mut.object instanceof SpecificObjectSelection»

        SimpleEntry<
            EObject,
            SimpleEntry<Resource, List<EPackage>>>
                sampleEntry =
                    hmObjects.get(
                        "«(mut.object as SpecificObjectSelection)
                            .objSel.name»");


        if (sampleEntry != null) {

            EObject recovered =
                MutatorUtils.recoverLocalObject(
                    models,
                    sampleEntry.getKey());

				if (recovered == null) {
					return numMutantsGenerated;
				}


            objectSelection =
                new SpecificObjectSelection(
                    packages,
                    models,
                    recovered);

        } else {

            List<
                SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>>>
                            sampleEntries =
                                hmList.get(
                                    "«(mut.object as SpecificObjectSelection)
                                        .objSel.name»");


            if (sampleEntries == null
                    || sampleEntries.isEmpty()) {

                return numMutantsGenerated;
            }


            List<EObject> objects =
                new ArrayList<EObject>();


            for (SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>> entry :
                            sampleEntries) {

                EObject recovered =
                    MutatorUtils.recoverLocalObject(
                        models,
                        entry.getKey());

				if (recovered == null) {
					return numMutantsGenerated;
				}


                objects.add(
                    recovered);
            }


            objectSelection =
                new SpecificObjectSelection(
                    packages,
                    models,
                    objects);
        }

        «ELSEIF mut.object instanceof SpecificClosureSelection»

        SimpleEntry<
            EObject,
            SimpleEntry<Resource, List<EPackage>>>
                sampleEntry =
                    hmObjects.get(
                        "«(mut.object as SpecificClosureSelection)
                            .objSel.name»");


        if (sampleEntry != null) {

            EObject recovered =
                MutatorUtils.recoverLocalObject(
                    models,
                    sampleEntry.getKey());

				if (recovered == null) {
					return numMutantsGenerated;
				}


            objectSelection =
                new SpecificClosureSelection(
                    packages,
                    models,
                    recovered,
                    "«(mut.object as SpecificClosureSelection)
                        .refType.name»");

        } else {

            List<
                SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>>>
                            sampleEntries =
                                hmList.get(
                                    "«(mut.object as SpecificClosureSelection)
                                        .objSel.name»");


            if (sampleEntries == null
                    || sampleEntries.isEmpty()) {

                return numMutantsGenerated;
            }


            List<EObject> objects =
                new ArrayList<EObject>();


            for (SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>> entry :
                            sampleEntries) {

                EObject recovered =
                    MutatorUtils.recoverLocalObject(
                        models,
                        entry.getKey());

				if (recovered == null) {
					return numMutantsGenerated;
				}


                objects.add(
                    recovered);
            }


            objectSelection =
                new SpecificClosureSelection(
                    packages,
                    models,
                    objects,
                    "«(mut.object as SpecificClosureSelection)
                        .refType.name»");
        }

        «ELSE»

        /*
         * I would copy here the RandomTypeSelection /
         * CompleteTypeSelection / external-resource resolution
         * block from WodelGeneratorSelectSampleMutator.
         *
         * It can remain almost literally identical because it
         * only constructs objectSelection.
         */

        «ENDIF»


        if (objectSelection == null) {

            return numMutantsGenerated;
        }


        /*
         * =====================================================
         * Reference selection
         * =====================================================
         */

        SpecificReferenceSelection referenceSelection =
            null;


        «IF mut.object.refType !== null»

        referenceSelection =
            new SpecificReferenceSelection(
                objectSelection.getMetaModel(),
                objectSelection.getModel(),
                "«mut.object.refType.name»",
                objectSelection.getObject());

        «ELSE»
                referenceSelection =
                    new SpecificReferenceSelection(
                        objectSelection.getMetaModel(),
                        objectSelection.getModel(),
                        null,
                        null);
        
        «ENDIF»



        /*
         * =====================================================
         * Sample semantics
         * =====================================================
         */

        List<String> features =
            new ArrayList<String>();


        «IF mut.clause == SampleClause.EQUALS»

        boolean equals = true;

        «ELSEIF mut.clause == SampleClause.DISTINCT»

        boolean equals = false;

        «ELSE»

        boolean equals = false;

        «ENDIF»


        «FOR EStructuralFeature feature : mut.features»

        if (!features.contains(
                "«feature.name»")) {

            features.add(
                "«feature.name»");
        }

        «ENDFOR»


        /*
         * Preserve the stochastic generator's convention:
         * features occurring in the selection expression also
         * participate in sample classification.
         */

        «IF mut.object.expression !== null»

        «IF mut.object.expression.first
                instanceof ReferenceEvaluation»

        //«var ReferenceEvaluation ev =
            mut.object.expression.first
                as ReferenceEvaluation»

        if (!features.contains(
                "«ev.name.name»")) {

            features.add(
                "«ev.name.name»");
        }

        «ENDIF»


        «IF mut.object.expression.first
                instanceof AttributeEvaluation»

        //«var AttributeEvaluation ev =
            mut.object.expression.first
                as AttributeEvaluation»

        if (!features.contains(
                "«ev.name.name»")) {

            features.add(
                "«ev.name.name»");
        }

        «ENDIF»


        «IF mut.object.expression.second !== null»

        «FOR ev : mut.object.expression.second»

        «IF ev instanceof ReferenceEvaluation»

        if (!features.contains(
                "«ev.name.name»")) {

            features.add(
                "«ev.name.name»");
        }

        «ENDIF»


        «IF ev instanceof AttributeEvaluation»

        if (!features.contains(
                "«ev.name.name»")) {

            features.add(
                "«ev.name.name»");
        }

        «ENDIF»

        «ENDFOR»

        «ENDIF»
        «ENDIF»


        SelectSampleMutator sampleMutator =
            new SelectSampleMutator(
                objectSelection.getModel(),
                objectSelection.getMetaModel(),
                referenceSelection,
                objectSelection,
                equals,
                features);


        /*
         * IMPORTANT DIFFERENCE FROM STOCHASTIC MODE:
         *
         * stochastic:
         *
         *     sampleMutator.mutate()
         *
         * exhaustive:
         *
         *     enumerate EVERY valid candidate sample.
         */

        List<List<EObject>> candidateSamples =
            sampleMutator.getCandidateSamples();


        if (candidateSamples == null
                || candidateSamples.isEmpty()) {

            return numMutantsGenerated;
        }


        /*
         * =====================================================
         * Generator counters
         * =====================================================
         */

        //COUNTER:
        //«nRegistryMutation.set(
            0,
            nRegistryMutation.get(0) + 1)»

        //COUNTER:
        //«nRegistryMethodCall.set(
            0,
            nRegistryMethodCall.get(0) + 1)»

        //REGISTRY METHOD NAME:
        //«var String registryMethodName =
            "registry"
            + nRegistryMethodCall.get(0).toString()»


        //COUNTER:
        //«nMethodCall.set(
            0,
            nMethodCall.get(0) + 1)»

        //NEXT MUTATION METHOD:
        //«var String nMethodName =
            "mutation"
            + nMethodCall.get(0).toString()»


if (candidateSamples == null || candidateSamples.isEmpty()) {
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

        /*
         * =====================================================
         * Explore every valid sample
         * =====================================================
         */

        for (List<EObject> candidateSample :
                candidateSamples) {


            /*
             * Every exhaustive branch gets its own model.
             *
             * Selection itself does not mutate it, but the next
             * Wodel command normally will.
             */
	try (OwnedResourceScope owned = new OwnedResourceScope()) {
            Resource resource =
            				        owned.own(
            				                ModelManager.cloneModel(
            				                    model,
            				                    tempModel));
            models.add(resource);

try {
            List<
                SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>>>
                            selectedEntries =
                                new ArrayList<
                                    SimpleEntry<
                                        EObject,
                                        SimpleEntry<
                                            Resource,
                                            List<EPackage>>>>();


            for (EObject selectedObject :
                    candidateSample) {

                EObject recovered =
                    MutatorUtils.recoverLocalObject(
                        resource,
                        selectedObject);


                if (recovered == null) {

                    continue;
                }


                SimpleEntry<
                    Resource,
                    List<EPackage>> resourceEntry =
                        new SimpleEntry<
                            Resource,
                            List<EPackage>>(
                                resource,
                                packages);


                SimpleEntry<
                    EObject,
                    SimpleEntry<
                        Resource,
                        List<EPackage>>> entry =
                            new SimpleEntry<
                                EObject,
                                SimpleEntry<
                                    Resource,
                                    List<EPackage>>>(
                                        recovered,
                                        resourceEntry);


                selectedEntries.add(
                    entry);
            }


            if (selectedEntries.isEmpty()) {

                continue;
            }


            /*
             * SelectSample always defines a COLLECTION emitter.
             *
             * This is the key difference from ordinary
             * SelectObjectMutator.
             */
            «IF mut.name !== null»

            hmObjects.remove(
                "«mut.name»");

            hmList.put(
                "«mut.name»",
                selectedEntries);

            «ENDIF»


            /*
             * Selection operations have a generic AppMutation
             * registry entry. The registry method does not need
             * a structural model change.
             */
            if (muts == null) {

                muts =
                    AppliedMutationsFactory.eINSTANCE
                        .createMutations();
            }

	   		int mutsMark = mutationMark(muts);

			if (sampleMutator != null) {
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
				        
            AppMutation appMut =
                «registryMethodName»(
                    sampleMutator,
                    hmMutator,
                    seed,
                    resource,
                    clue,
                    mutPaths,
                    packages);


            if (appMut != null) {

                muts.getMuts()
                    .add(
                        appMut);
            }


			try {
            «IF last == false»

            /*
             * Continue the mutation chain.
             */
            «IF standalone == false»

            «nMethodName»(
                packages,
                models,
                hmObjects,
                hmList,
                hashmapModelFilenames,
                modelFilename,
                mutPaths,
                hmMutator,
                seed,
                registeredPackages,
                localRegisteredPackages,
                hashmapModelFolders,
                ecoreURI,
                registry,
                hashsetMutantsBlock,
                fromNames,
                hashmapMutVersions,
                muts,
                project,
                monitor,
                k,
                serialize,
                test,
                classes);

            «ELSE»

            «nMethodName»(
                packages,
                models,
                hmObjects,
                hmList,
                hashmapModelFilenames,
                modelFilename,
                mutPaths,
                hmMutator,
                seed,
                registeredPackages,
                localRegisteredPackages,
                hashmapModelFolders,
                ecoreURI,
                registry,
                hashsetMutantsBlock,
                fromNames,
                hashmapMutVersions,
                muts,
                monitor,
                k,
                serialize,
                test,
                classes);

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
            numMutantsGenerated =
                k[0];

			}
			}
            «ENDIF»


            «IF last == true»

            /*
             * If a select-sample command is ever the last
             * command, use exactly the same mutant-completion
             * block as SelectObjectExhaustiveMutator, but pass
             * `resource` instead of `mutator.getModel()`.
             *
             * I would factor that duplicated block into a common
             * helper in a later cleanup.
             */

            Map<String, List<String>> rules =
                new LinkedHashMap<String, List<String>>();


            «FOR constraint : e.constraints»

            if (rules.get(
                    "«constraint.type.name»") == null) {

                rules.put(
                    "«constraint.type.name»",
                    new ArrayList<String>());
            }


            List<String> newrules =
                rules.get(
                    "«constraint.type.name»");


            «IF constraint.expressions !== null»

            «FOR expression : constraint.expressions»

            newrules.add(
                "«WodelUtils.getConstraintText(
                    fileURI.lastSegment,
                    expression)»");

            «ENDFOR»
            «ENDIF»


            «IF constraint.rules !== null»

            «FOR rule : constraint.rules»

            newrules.add(
                "«rule»");

            «ENDFOR»
            «ENDIF»


            rules.put(
                "«constraint.type.name»",
                newrules);

            «ENDFOR»


            «IF b === null»

            String mutFilename =
                hashmapModelFilenames.get(
                    modelFilename)
                + "/Output"
                + k[0]
                + ".model";

            «ELSEIF b.from.size == 0»

            String mutFilename =
                hashmapModelFilenames.get(
                    modelFilename)
                + "/«b.name»/Output"
                + k[0]
                + ".model";

            «ELSE»

            String mutFilename =
                hashmapModelFilenames.get(
                    modelFilename)
                + "/«b.name»/"
                + hashmapModelFolders.get(
                    modelFilename)
                + "/Output"
                + k[0]
                + ".model";

            «ENDIF»

			Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);
            «IF b === null»

                «IF standalone == false»

            boolean isRepeated =
                registryMutant(
                    ecoreURI,
                    packages,
                    registeredPackages,
                    localRegisteredPackages,
                    seed,
                    resource,
                    rules,
                    registryMuts,
                    modelFilename,
                    mutFilename,
                    registry,
                    hashsetMutantsBlock,
                    hashmapModelFilenames,
                    k,
                    mutPaths,
                    hashmapMutVersions,
                    project,
                    serialize,
                    test,
                    classes,
                    this.getClass(),
                    true);

                «ELSE»

            boolean isRepeated =
                registryMutantStandalone(
                    ecoreURI,
                    packages,
                    registeredPackages,
                    localRegisteredPackages,
                    seed,
                    resource,
                    rules,
                    registryMuts,
                    modelFilename,
                    mutFilename,
                    registry,
                    hashsetMutantsBlock,
                    hashmapModelFilenames,
                    k,
                    mutPaths,
                    hashmapMutVersions,
                    "«project.name»",
                    serialize,
                    test,
                    classes,
                    «className».class,
                    true);

                «ENDIF»

            «ELSE»

                «IF standalone == false»

            boolean isRepeated =
                registryMutantWithBlocks(
                    ecoreURI,
                    packages,
                    registeredPackages,
                    localRegisteredPackages,
                    seed,
                    resource,
                    rules,
                    registryMuts,
                    modelFilename,
                    mutFilename,
                    registry,
                    hashsetMutantsBlock,
                    hashmapModelFilenames,
                    hashmapModelFolders,
                    "«b.name»",
                    fromNames,
                    k,
                    mutPaths,
                    hashmapMutVersions,
                    project,
                    serialize,
                    test,
                    classes,
                    this.getClass(),
                    true,
                    false);

                «ELSE»

            boolean isRepeated =
                registryMutantWithBlocksStandalone(
                    ecoreURI,
                    packages,
                    registeredPackages,
                    localRegisteredPackages,
                    seed,
                    resource,
                    rules,
                    registryMuts,
                    modelFilename,
                    mutFilename,
                    registry,
                    hashsetMutantsBlock,
                    hashmapModelFilenames,
                    hashmapModelFolders,
                    "«b.name»",
                    fromNames,
                    k,
                    mutPaths,
                    hashmapMutVersions,
                    "«project.name»",
                    serialize,
                    test,
                    classes,
                    «className».class,
                    true,
                    false);

                «ENDIF»

            «ENDIF»


            if (!isRepeated) {

                numMutantsGenerated++;

                monitor.worked(
                    1);

                k[0]++;
            }


            //if (muts != null) {

            //    muts.getMuts()
            //        .clear();
            //}
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


        //END SELECT SAMPLE OBJECT «methodName»

        «ENDIF»
    '''
}