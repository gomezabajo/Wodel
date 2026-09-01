package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import java.util.ArrayList
import java.util.List
import mutatorenvironment.Source
import java.io.File
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import mutatorenvironment.Program
import mutatorenvironment.Mutator
import mutatorenvironment.SelectObjectMutator
import wodel.dsls.runner.WodelUtils
import wodel.utils.manager.MutatorUtils

class WodelGeneratorSelectObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {

	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''	
		
		
		
		«IF mt instanceof SelectObjectMutator»
		//«var SelectObjectMutator mut = mt as SelectObjectMutator»


		//SELECT OBJECT «methodName»

		//«var boolean rts = false»
		//«var int i = 0»
		//«var int j = 0»
		//«var boolean hasAdditionalResources = MutatorUtils.selectionOriginatesFromAdditionalResources(mut)»
		//«var boolean closureHasAdditionalResources = MutatorUtils.closureHasAdditionalResources(mut)»
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
		Resource model = MutatorUtils.currentModel(models);
		if (model == null) {
			return numMutantsGenerated;
		}
		«IF mut.container !== null && mut.container instanceof SpecificObjectSelection»
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = null;
		«ENDIF» 
				//«val List<String> resourceURIs = new ArrayList<String>()»
							//«val List<String> ecoreURIs = new ArrayList<String>()»
							//«val String resourceName = mut.object.resource»
							//«var mutatorenvironment.Resource resource = null»
							«FOR res : program.resources»
								«IF res.name.equals(resourceName)»
									//«resource = res» 
								«ENDIF»
							«ENDFOR»
		«IF resource === null»
		resources.addAll(models);
		resourcePackages.addAll(packages);
		«ELSE»
			//«val Source source = resource.path»
			//«val String resourcePath = project.getLocation.toFile.getPath + "/" + source.path»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + project.name + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + project.name + "/") + ("/" + project.name).length()) : metamodelPath»";
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "") + relativeMetamodelPath;
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + project.name + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name).length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "") + relativeResourceURI_«i»;
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI("file:/" + absoluteResourceURI_«i»).toFileString()));
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name).length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "") + relativeEcoreURI_«j»;
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI("file:/" + absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI("file:/" + absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
		«ENDIF»
		List<EPackage> selectionPackages = new ArrayList<EPackage>();
		List<Resource> selection = new ArrayList<Resource>();
		selectionPackages.addAll(resourcePackages);
		«IF mut.container === null && (hasAdditionalResources || closureHasAdditionalResources)»
		«IF (mut.object.expression !== null)»
		«IF mut.object instanceof RandomTypeSelection»
		«/*mut.object.expression.addResources(mut)*/»
		«ENDIF»
		«IF mut.object instanceof CompleteTypeSelection»
		«/*mut.object.expression.addResources(mut)*/»
		«ENDIF»
		«ENDIF»
		«ENDIF»
		«IF mut.container !== null && (hasAdditionalResources || closureHasAdditionalResources)»
		«IF mut.container instanceof SpecificObjectSelection»
		entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
		if (entry_«(mut.container as SpecificObjectSelection).objSel.name» == null) {
			return numMutantsGenerated;
		}
		selectionPackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
		«ENDIF»
		«ENDIF»
		«IF !(hasAdditionalResources || closureHasAdditionalResources)»
		selection.addAll(models);
		«ENDIF»
		«IF hasAdditionalResources || closureHasAdditionalResources»
		selection.addAll(resources);
		«ENDIF»
		«IF mut.container !== null && (hasAdditionalResources || closureHasAdditionalResources)»
		«IF mut.container instanceof SpecificObjectSelection»
		entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
		if (entry_«(mut.container as SpecificObjectSelection).objSel.name» == null) {
			return numMutantsGenerated;
		}
		if (entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey() == null) {
			return numMutantsGenerated;
		}
		selection.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
		«ENDIF»
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
		«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF mut.container !== null»
			«IF mut.container instanceof RandomTypeSelection»
				//«rts = true»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, "«(mut.container as RandomTypeSelection).type.name»");
				«ENDIF»
				EObject container = rts.getObject();
				«IF mut.container.refType !== null»
					//«var refName = mut.container.refType.name»
					«IF mut.container.refRefType !== null»
					container = ModelManager.getReference("«mut.container.refType.name»", container);
					//«refName = mut.container.refRefType.name»
					«IF mut.container.refRefRefType !== null»
					container = ModelManager.getReference("«mut.container.refRefType.name»", container);
					//«refName = mut.container.refRefRefType.name»
					«ENDIF»
					«ENDIF»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
					if (container == null) {
						return numMutantsGenerated;
					}
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", containerSelection);
					«ELSE»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«refName»", containerSelection);
					«ENDIF»
					containerSelectionList.add(containerSelection);
					referenceSelectionList.add(referenceSelection);
				«ELSE»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
					if (container == null) {
						return numMutantsGenerated;
					}
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ELSE»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);
					«ENDIF»
					containerSelectionList.add(containerSelection);
					referenceSelectionList.add(referenceSelection);
				«ENDIF»
			«ELSEIF mut.container instanceof CompleteTypeSelection»
				//«rts = true»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
					if (container == null) {
						return numMutantsGenerated;
					}
					
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, "«(mut.container as CompleteTypeSelection).type.name»");
				«ENDIF»
				EObject container = rts.getObject();
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«ELSE»
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);
				«ENDIF»
				containerSelectionList.add(containerSelection);
				«IF mut.container.refType !== null»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«mut.container.refType.name»", containerSelection);
				«ENDIF»
					referenceSelectionList.add(referenceSelection);
				«ELSE»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);
				«ENDIF»
					referenceSelectionList.add(referenceSelection);
				«ENDIF»
			«ELSEIF mut.container instanceof SpecificObjectSelection»
					entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
						EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«ELSE»
						EObject recovered = MutatorUtils.recoverLocalObject(selection, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«ENDIF»
				if (recovered == null) {
					return numMutantsGenerated;
				}
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
						«ELSE»
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);
						«ENDIF»
						containerSelectionList.add(containerSelection);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								«IF mut.container.resource === null»
								EObject obj = ModelManager.getObject(model, ent.getKey());
								«ELSE»
								EObject obj = ModelManager.getObject(selection, ent.getKey());
								«ENDIF»
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
							ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
							«ELSE»
							ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, objs);
							«ENDIF»
							containerSelectionList.add(containerSelection);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
EObject obRecovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							«ELSE»
EObject obRecovered = MutatorUtils.recoverLocalObject(selection, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							«ENDIF»
							Object valueRecovered = obRecovered;
							Object valueRec = null;
							//«var refName = mut.container.refType.name»
							«IF mut.container.refRefType !== null»
							valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
							if (valueRec instanceof EObject) {
								valueRecovered = (EObject) valueRec;
							}
							if (valueRec instanceof List<?>) {
								valueRecovered = (List<EObject>) valueRec;
							}
							//«refName = mut.container.refRefType.name»
							«ENDIF»
							«IF mut.container.refRefRefType !== null»
							if (valueRecovered instanceof EObject) {
								valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
							}
							if (valueRecovered instanceof List<?>) {
								valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (List<EObject>) valueRecovered);
							}
							if (valueRec instanceof EObject) {
								valueRecovered = (EObject) valueRec;
							}
							if (valueRec instanceof List<?>) {
								valueRecovered = (List<EObject>) valueRec;
							}
							//«refName = mut.container.refRefRefType.name»
							«ENDIF»
							if (valueRecovered == null) {
								obRecovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
								valueRecovered = obRecovered;
								valueRec = null;
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefType.name»
								«ENDIF»
								«IF mut.container.refRefRefType !== null»
								if (valueRecovered instanceof EObject) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
								}
								if (valueRecovered instanceof List<?>) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefRefType.name»", (List<EObject>) valueRecovered);
								}
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
							}
							if (valueRecovered instanceof EObject) {
								EObject recovered = (EObject) valueRecovered;
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
								ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
								«ELSE»
								ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);
								«ENDIF»
								containerSelectionList.clear();
								containerSelectionList.add(containerSelection);
								SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«refName»", recovered);
								referenceSelectionList.clear();
								referenceSelectionList.add(referenceSelection);
							}
							if (valueRecovered instanceof List<?>) {
								List<EObject> recoveredList = (List<EObject>) valueRecovered;
								containerSelectionList.clear();
								referenceSelectionList.clear();
								for (EObject recovered : recoveredList) {
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
								«ELSE»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);
								«ENDIF»
									containerSelectionList.add(containerSelection);
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«refName»", recovered);
									referenceSelectionList.add(referenceSelection);
								}
							}
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» == null || listEntry_«(mut.container as SpecificObjectSelection).objSel.name».isEmpty()) {
									return numMutantsGenerated;
								}
								containerSelectionList.clear();
								referenceSelectionList.clear();
								
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
									
									
								EObject recovered = MutatorUtils.recoverLocalObject(selection, ent.getKey());
								if (recovered == null) {
									«IF mut.container === null»
											return numMutantsGenerated;
										«ELSE»
												continue;
										«ENDIF»
						
								}
								Object valueRec = null;
								Object valueRecovered = recovered;
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefType.name»
								«IF mut.container.refRefRefType !== null»
								if (valueRecovered instanceof EObject) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
								}
								if (valueRecovered instanceof List<?>) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefRefType.name»", (List<EObject>) valueRecovered);
								}
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
								«ENDIF»
								if (valueRecovered instanceof EObject) {
									EObject obRecovered = (EObject) valueRecovered;
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, obRecovered);
								«ELSE»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, obRecovered);
								«ENDIF»
									containerSelectionList.add(containerSelection);
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", obRecovered);
								«ELSE»
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«refName»", obRecovered);
								«ENDIF»
									referenceSelectionList.add(referenceSelection);
								}
								if (valueRecovered instanceof List<?>) {
									List<EObject> recoveredList = (List<EObject>) valueRecovered;
									containerSelectionList.clear();
									referenceSelectionList.clear();
									for (EObject recoveredIt : recoveredList) {
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
										ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recoveredIt);
										SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", recoveredIt);
								«ELSE»
										ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);
										SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«refName»", recoveredIt);
								«ENDIF»
										containerSelectionList.add(containerSelection);
										referenceSelectionList.add(referenceSelection);
									}
								}
							}
							if (containerSelectionList.isEmpty()) {
								return numMutantsGenerated;
							}
							}
							else {
								return numMutantsGenerated;
							}
						}
					«ELSE»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						referenceSelectionList.add(referenceSelection);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				if (recovered == null) {
					return numMutantsGenerated;
				}
						ObSelectionStrategy containerSelection = new SpecificClosureSelection(selectionPackages, selection, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
						containerSelectionList.add(containerSelection);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ModelManager.getObject(selection, ent.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							ObSelectionStrategy containerSelection = new SpecificClosureSelection(selectionPackages, selection, objs, "«(mut.container as SpecificClosureSelection).refType.name»");
							containerSelectionList.add(containerSelection);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
							EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					«ELSE»
							EObject recovered = MutatorUtils.recoverLocalObject(selection, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					«ENDIF»
				if (recovered == null) {
					return numMutantsGenerated;
				}
							SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, "«mut.container.refType.name»", recovered);
							referenceSelectionList.add(referenceSelection);
						} else {
							return numMutantsGenerated;
						}
					«ELSE»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ELSE»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);
					«ENDIF»
						referenceSelectionList.add(referenceSelection);
					«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
		«IF mut.container !== null»
		for (int j = 0; j < containerSelectionList.size(); j++) {
		«ENDIF»
			«IF rts == true»
			«IF mut.container !== null»
			rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), "«mut.object.type.name»", referenceSelectionList.get(j), containerSelectionList.get(j));
			«ELSE»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
			rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»");
			«ELSE»
			rts = new RandomTypeSelection(selectionPackages, selection, "«mut.object.type.name»");
			«ENDIF»
			«ENDIF»
			«ELSE»
			«IF mut.container !== null»
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), "«mut.object.type.name»", referenceSelectionList.get(j), containerSelectionList.get(j));
			//«rts = true»
			«ELSE»
				«IF mut.object.resource === null && !hasAdditionalResources && !closureHasAdditionalResources»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, "«mut.object.type.name»");
			«ENDIF»
			//«rts = true»
			«ENDIF»
			«ENDIF»
			«IF mut.container !== null»
				«IF ((mut.object.expression === null) && (mut.container.expression === null) && !(mut.object instanceof CompleteTypeSelection))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
			«ELSE»
			«IF ((mut.object.expression === null) && (mut.container === null) && !(mut.object instanceof CompleteTypeSelection))»
				List<EObject> objects = rts.getObjects();
			«ENDIF»
			«ENDIF»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
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
				«IF mut.object.resource === null»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, mut.container !== null, evaluation)»
				«ELSE»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, true, mut.container !== null, evaluation)»
				//«/*val ReferenceEvaluation refev = mut.object.expression.first as ReferenceEvaluation*/»
				«ENDIF»
				«IF evaluation.get(0) == false»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSE»
				objects = auxObjects;
				«ENDIF»
				«ELSEIF (mut.container.expression === null)»
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
				«IF mut.object.resource === null»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, mut.container !== null, evaluation)»
				«ELSE»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, true, mut.container !== null, evaluation)»
				«ENDIF»
				«IF evaluation.get(0) == false»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSE»
				objects = auxObjects;
				«ENDIF»
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
				«IF mut.object.resource === null || !closureHasAdditionalResources»
				«mut.container.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, mut.container !== null, evaluation)»
				«ELSE»
				«mut.container.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, true, mut.container !== null, evaluation)»
				«ENDIF»
				«IF evaluation.get(0) == false»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSE»
				objects = auxObjects;
				«ENDIF»
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF mut.object.resource !== null || closureHasAdditionalResources»
			//packages.clear();
			//packages.addAll(savedPackages);
			«ENDIF»
		«IF mut.name !== null»
						«IF mut.object instanceof CompleteTypeSelection»
						if (objects == null || objects.isEmpty()) {
«IF mut.container === null»
		return numMutantsGenerated;
	«ELSE»
			continue;
	«ENDIF»
	}
						«IF mut.object.resource !== null || closureHasAdditionalResources»
						        Resource readOnlyResource = null;
						        	readOnlyResource =
						        	        ModelManager.findModel(
						        	            selection,
						        	            object);
						        	
						        «ENDIF»
						
Resource resource = null;
            SelectObjectMutator mut = null;
            SpecificObjectSelection objectSelection = null;
List<
    SimpleEntry<
        EObject,
        SimpleEntry<
            Resource,
            List<EPackage>>>> entries =
                new ArrayList<>();



if (objects == null || objects.isEmpty()) {
			«IF mut.container === null»
					return numMutantsGenerated;
				«ELSE»
						continue;
				«ENDIF»
		}
String tempModel =
        WodelTempModelContext.nextModelPath(
            model,
            "«methodName»");
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
			resource = owned.own(
			    											                    ModelManager.cloneModel(
			    											                        model,
			    											                        tempModel));
models.add(resource);
try {      
for (EObject selected :
        objects) {

    EObject recovered =
        MutatorUtils.recoverLocalObject(
               «IF mut.object.resource !== null»
               	readOnlyResource,
                  	«ELSE»
                   resource,
               «ENDIF»
            selected);
    if (recovered == null) {
    	recovered =
    		ModelManager.getObject(
    		«IF mut.object.resource !== null»
    		               	readOnlyResource,
    		                  	«ELSE»
    		                   resource,
    		               «ENDIF»
    		               selected);
    }
    «IF closureHasAdditionalResources»
    if (recovered == null) {
    	recovered =
    	        MutatorUtils.recoverLocalObject(
    	               	readOnlyResource,
    	            selected);
    }
        	    if (recovered == null) {
        	    	recovered =
        	    		ModelManager.getObject(
        	    		               	readOnlyResource,
        	    		               selected);
        	    }
    
    «ENDIF»

    if (recovered != null) {

        SimpleEntry<Resource, List<EPackage>>
            resourceEntry =
                new SimpleEntry<>(
                    resource,
                    packages);

        entries.add(
            new SimpleEntry<>(
                recovered,
                resourceEntry));
    }
}
if (entries.isEmpty()) {
    «IF mut.container === null»
    		return numMutantsGenerated;
    	«ELSE»
    			continue;
    	«ENDIF»
}

hmObjects.remove(
    "«mut.name»");

hmList.put(
    "«mut.name»",
    entries);
					«IF closureHasAdditionalResources»
					    boolean belongsToAdditionalResources = false;
					    «ENDIF»
    
					«IF mut.container !== null»
					    EObject oldContainer =
					                containerSelectionList
					                    .get(j)
					                    .getObject();
					    
					            EObject localContainer =
					                MutatorUtils.recoverLocalObject(
					«IF mut.object.resource !== null»
					readOnlyResource,
					«ELSE»
					                    resource,
					                    «ENDIF»
					                    oldContainer);
					    
					            if (localContainer == null) {
					                localContainer =
					                    ModelManager.getObject(
					«IF mut.object.resource !== null»
					readOnlyResource,
					«ELSE»
					                        resource,
					                        «ENDIF»
					                        oldContainer);
					            }
					«IF closureHasAdditionalResources»
					if (localContainer == null) {
					            localContainer =
					                MutatorUtils.recoverLocalObject(
					readOnlyResource,
					                    oldContainer);
					                    if (localContainer != null) {
					                    	belongsToAdditionalResources = true;
					                    }
					 }
					    
					            if (localContainer == null) {
					                localContainer =
					                    ModelManager.getObject(
					readOnlyResource,
					                        oldContainer);
					                    if (localContainer != null) {
					                    	belongsToAdditionalResources = true;
					                    }
					            }
					    «ENDIF»    
					            if (localContainer == null) {
					                «IF mut.container === null»
					                		return numMutantsGenerated;
					                	«ELSE»
					                			continue;
					                	«ENDIF»
					        
					            }
					            ObSelectionStrategy
					                localContainerSelection = null;
					            SpecificReferenceSelection
					                localReferenceSelection = null;
					 «IF closureHasAdditionalResources»             
					 if (!belongsToAdditionalResources) {
					 «ENDIF»
					                
					    
					            ObSelectionStrategy
					                localContainerSelection =
					                    new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        localContainer);
					    
					            SpecificReferenceSelection
					                localReferenceSelection =
					                    new SpecificReferenceSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        «IF mut.container?.refType !== null»
					                        "«mut.container.refType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefType !== null»
					                        "«mut.container.refRefType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefRefType !== null»
					                        "«mut.container.refRefRefType.name»",
					                        «ELSE»
					                        null,
					                        «ENDIF»
					                        «ENDIF»
					                        «ENDIF»
					                        localContainer);
					    
					                objectSelection =
					                    new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        localObject);
					    
					            mut =
					                new SelectObjectMutator(
					«IF mut.object.resource !== null»
					readOnlyResource,
					selectionPackages,
					«ELSE»
					                        resource,
					                        packages,
					                        «ENDIF»
					                    localReferenceSelection,
					                    localContainerSelection,
					                    objectSelection);
					 «IF closureHasAdditionalResources»
					 }
					 if (belongsToAdditionalResources) {
					                
					    
					            ObSelectionStrategy
					                localContainerSelection =
					                    new SpecificObjectSelection(
					selectionPackages,
					readOnlyResource,
					                        localContainer);
					    
					            SpecificReferenceSelection
					                localReferenceSelection =
					                    new SpecificReferenceSelection(
					selectionPackages,
					readOnlyResource,
					                        «IF mut.container?.refType !== null»
					                        "«mut.container.refType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefType !== null»
					                        "«mut.container.refRefType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefRefType !== null»
					                        "«mut.container.refRefRefType.name»",
					                        «ELSE»
					                        null,
					                        «ENDIF»
					                        «ENDIF»
					                        «ENDIF»
					                        localContainer);
					    
					                objectSelection =
					                    new SpecificObjectSelection(
					selectionPackages,
					readOnlyResource,
					                        localObject);
					    
					            mut =
					                new SelectObjectMutator(
					readOnlyResource,
					selectionPackages,
					                    localReferenceSelection,
					                    localContainerSelection,
					                    objectSelection);
					 }
					 «ENDIF»
					                    «ELSE»
					                    «IF closureHasAdditionalResources»
				if (!belongsToAdditionalResources) {
					«ENDIF»
objectSelection =
					                    new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        objects);					
					            mut =
					                new SelectObjectMutator(
					«IF mut.object.resource !== null»
					readOnlyResource,
					selectionPackages,
					«ELSE»
					                        resource,
					                        packages,
					                        «ENDIF»
					                    null,
					                    null,
					                    objectSelection);
					«IF closureHasAdditionalResources»
					}
					if (belongsToAdditionalResources) {
					objectSelection =
										                    new SpecificObjectSelection(
										selectionPackages,
										readOnlyResource,
										                        objects);					
										            mut =
										                new SelectObjectMutator(
										readOnlyResource,
										selectionPackages,
										                    null,
										                    null,
										                    objectSelection);
										}
					«ENDIF»
					«ENDIF»

if (mut == null || objectSelection == null) {
	return numMutantsGenerated;
}
Mutator mutator = null;
if (muts == null) {
	muts = AppliedMutationsFactory.eINSTANCE.createMutations();
}
		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//COUNTER: «nRegistryMethodCall.set(0, nRegistryMethodCall.get(0) + 1)»
		//REGISTRY METHOD NAME:«var String registryMethodName = "registry" + nRegistryMethodCall.get(0).toString()»
   		int mutsMark = mutationMark(muts);
		«IF executeMutation == true»
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
				            «IF mut.object.resource === null»
				            model,
			    											                    «ELSE»
			    											                    	readOnlyResource,
			    											                    «ENDIF»
				            objectSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				       «IF mut.object.resource !== null»
				            selectionPackages);
				       «ELSE»
				            packages);
				       «ENDIF»
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						hmObjects.remove("«mut.name»");
						hmList.put("«mut.name»", entries);
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, model, clue, mutPaths, packages);
//						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, model, clue, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				«ENDIF»
				try {
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
												} finally {
																				     MutatorUtils.rollbackMutations(
																				        muts,
																				        mutsMark);
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
			  			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
			  		«ELSE»
			  			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true);
			  		«ENDIF»
					«ELSE»
					«IF standalone == false»
						boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
					«ELSE»
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
	}  finally {
		        MutatorUtils.rollbackMutations(
		            muts,
		            mutsMark);
		    }
									} finally {
									models.remove(resource);
									}
		    }
		«ENDIF»
    	«ENDIF»
		«ENDIF»
		«IF !(mut.name !== null && mut.object instanceof CompleteTypeSelection)»
				«IF mut.object.resource === null && !closureHasAdditionalResources»
if (objects == null || objects.isEmpty()) {
	«IF mut.container === null»
		return numMutantsGenerated;
	«ELSE»
			continue;
	«ENDIF»
		}

		String tempModel =
		        WodelTempModelContext.nextModelPath(
		            model,
		            "«methodName»");
        «ELSE»
if (objects == null || objects.isEmpty()) {
	«IF mut.container === null»
		return numMutantsGenerated;
	«ELSE»
			continue;
	«ENDIF»
		}
		String tempModel =
		        WodelTempModelContext.nextModelPath(
		            model,
		            "«methodName»");
        «ENDIF»
        «ENDIF»
        «IF !(mut.object instanceof CompleteTypeSelection)»
            for (EObject object : objects) {
					                SelectObjectMutator mut = null;
        «IF mut.object.resource !== null || closureHasAdditionalResources»
        Resource readOnlyResource = null;
        	readOnlyResource =
        	        ModelManager.findModel(
        	            selection,
        	            object);
        	
        «ENDIF»
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
		«IF (mut.name !== null) && !(mut.object instanceof CompleteTypeSelection)»
			Resource resource = owned.own(
		«ELSE»
			resource = owned.own(
        «ENDIF»
			    											                    ModelManager.cloneModel(
			    											                        model,
			    											                        tempModel));
			models.add(resource);
			try {
				EObject localObject =
				                ModelManager.getObject(
				                «IF mut.object.resource !== null»
			                    	readOnlyResource,
			                   	«ELSE»
				                    resource,
				                «ENDIF»
			    				
				                    object);
					«IF closureHasAdditionalResources»
					    if (localObject == null) {
					    	localObject = ModelManager.getObject(
					        	    		               	readOnlyResource,
					        	    		               object);
					    }
					    «ENDIF»    
				                    if (localObject == null) {
				                    	continue;
				                    }
				ObSelectionStrategy objectSelection = null;
				EObject selectedObject = null;
				«IF mut.object.refType !== null && mut.object.refType.many»
				List<EObject> l = ModelManager.getReferences("«mut.object.refType.name»", localObject);
				ModelManager.sortEObjectsDeterministically(l);
				selectedObject = l.get(ModelManager.getRandomIndex(l));
				«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
				selectedObject = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", localObject);
				«ELSE»
				selectedObject = localObject;
				«ENDIF»
				if (resource != null) {
					«IF closureHasAdditionalResources»
					    boolean belongsToAdditionalResources = false;
					    «ENDIF»
					«IF !(mut.object instanceof CompleteTypeSelection)»
					«IF mut.container !== null»
					    EObject oldContainer =
					                containerSelectionList
					                    .get(j)
					                    .getObject();
					    EObject localContainer =
					                MutatorUtils.recoverLocalObject(
					«IF mut.object.resource !== null»
					readOnlyResource,
					«ELSE»
					                    resource,
					                    «ENDIF»
					                    oldContainer);
					    
					            if (localContainer == null) {
					                localContainer =
					                    ModelManager.getObject(
					«IF mut.object.resource !== null»
					readOnlyResource,
					«ELSE»
					                        resource,
					                        «ENDIF»
					                        oldContainer);
					            }
					            «IF closureHasAdditionalResources»
					            if (localContainer == null) {
					            localContainer =
					            					                MutatorUtils.recoverLocalObject(
					            					readOnlyResource,
					            					                    oldContainer);
					            					                if (localContainer != null) {
					            					               		belongsToAdditionalResources = true;
					            					                }
					            					            }

					            					    
					            					            if (localContainer == null) {
					            					                localContainer =
					            					                    ModelManager.getObject(
					            					readOnlyResource,
					            					                        oldContainer);
					            					                if (localContainer != null) {
					            					               		belongsToAdditionalResources = true;
					            					                }
					            					            }
					            «ENDIF»
					    
					            if (localContainer == null) {
					                continue;
					            }
					    
					            ObSelectionStrategy
					                localContainerSelection = null;
					            SpecificReferenceSelection
					                localReferenceSelection = null;
					    «IF closureHasAdditionalResources»
					    if (!belongsToAdditionalResources) {
					    «ENDIF»
					                    localContainerSelection = new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        localContainer);
					    
					                    localReferenceSelection = new SpecificReferenceSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        «IF mut.container?.refType !== null»
					                        "«mut.container.refType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefType !== null»
					                        "«mut.container.refRefType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefRefType !== null»
					                        "«mut.container.refRefRefType.name»",
					                        «ELSE»
					                        null,
					                        «ENDIF»
					                        «ENDIF»
					                        «ENDIF»
					                        localContainer);
					    
					                objectSelection =
					                    new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        packages,
					                        resource,
					                        «ENDIF»
					                        selectedObject);
					    
					mut =
					                new SelectObjectMutator(
					«IF mut.object.resource !== null»
					readOnlyResource,
					selectionPackages,
					«ELSE»
					                        resource,
					                        packages,
					                        «ENDIF»
					                    localReferenceSelection,
					                    localContainerSelection,
					                    objectSelection);
«IF closureHasAdditionalResources»
					}
					if (belongsToAdditionalResources) {
	                    localContainerSelection = new SpecificObjectSelection(
					selectionPackages,
					readOnlyResource,
					                        localContainer);
					    
					                    localReferenceSelection = new SpecificReferenceSelection(
					selectionPackages,
					readOnlyResource,
					                        «IF mut.container?.refType !== null»
					                        "«mut.container.refType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefType !== null»
					                        "«mut.container.refRefType.name»",
					                        «ELSE»
					                        «IF mut.container?.refRefRefType !== null»
					                        "«mut.container.refRefRefType.name»",
					                        «ELSE»
					                        null,
					                        «ENDIF»
					                        «ENDIF»
					                        «ENDIF»
					                        localContainer);
					    
					                objectSelection =
					                    new SpecificObjectSelection(
					selectionPackages,
					readOnlyResource,
					                        selectedObject);
					    
mut =
					                new SelectObjectMutator(
					readOnlyResource,
					selectionPackages,
					                    localReferenceSelection,
					                    localContainerSelection,
					                    objectSelection);
					}
					«ENDIF»
					                    «ELSE»

«IF closureHasAdditionalResources» 
					if (!belongsToAdditionalResources) {
						«ENDIF»
objectSelection =
					                    new SpecificObjectSelection(
					«IF mut.object.resource !== null»
					selectionPackages,
					readOnlyResource,
					«ELSE»
					                        
					                        
					                        packages,
					                        resource,
					                        «ENDIF»
					                        selectedObject);
					                        					
mut = new SelectObjectMutator(
					«IF mut.object.resource !== null»
					readOnlyResource,
					selectionPackages,
					«ELSE»
					                        resource,
					                        packages,
					                        «ENDIF»
							null, null, objectSelection);
							«IF closureHasAdditionalResources»
					}
					if (belongsToAdditionalResources) {
objectSelection =
					                    new SpecificObjectSelection(
					selectionPackages,
					readOnlyResource,
					                        selectedObject);
					                        					
mut = new SelectObjectMutator(
					readOnlyResource,
					selectionPackages,
							null, null, objectSelection);
					}
					«ENDIF»
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
				            «IF mut.object.resource === null»
				            resource,
			    											                    «ELSE»
			    											                    	readOnlyResource,
			    											                    «ENDIF»
				            objectSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				       «IF mut.object.resource !== null»
				            selectionPackages);
				       «ELSE»
				            packages);
				       «ENDIF»
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
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, resource, clue, mutPaths, packages);
//						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, resource, clue, mutPaths, packages);
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
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					//if (muts != null) {
					//	muts.getMuts().clear();
					//}
				}
					}  finally {
						        MutatorUtils.rollbackMutations(
						            muts,
						            mutsMark);
						    }
									} finally {
									models.remove(resource);
									}
				

		«ENDIF»
		}
		}
		
		«ENDIF»
		
			}
		}
			«ENDIF»
		«ENDIF»
	«IF mut.container !== null»
	}
	«ENDIF»
		«ENDIF»
	//END SELECT OBJECT «methodName»
	«ENDIF»
	'''
}