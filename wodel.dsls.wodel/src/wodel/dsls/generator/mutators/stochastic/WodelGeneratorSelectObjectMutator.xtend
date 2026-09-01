package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import java.util.ArrayList
import java.util.List
import mutatorenvironment.Source
import java.io.File
import org.eclipse.core.resources.IProject
import mutatorenvironment.Program
import mutatorenvironment.Resource
import mutatorenvironment.Mutator

class WodelGeneratorSelectObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof SelectObjectMutator»
		//«var SelectObjectMutator mut = mt as SelectObjectMutator»

		//SELECT OBJECT «methodName»
		
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		//«var boolean rts = false»
		//«var int i = 0»
		//«var int j = 0»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object.resource === null»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
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
					containerSelection = new SpecificObjectSelection(packages, model, container);
					referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						List<EObject> recovered = new ArrayList<EObject>();
						recovered.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«IF mut.container.refType !== null»
							//«var refName = mut.container.refType.name»
							«IF mut.container.refRefType !== null»
							Object ob = ModelManager.getReferenced("«mut.container.refType.name»", recovered.get(0));
							if (ob instanceof EObject) {
								recovered.add((EObject) ob);
							}
							else {
								recovered.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
							}
							//«refName = mut.container.refRefType.name»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(1));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(1));
							«IF mut.container.refRefRefType !== null»
							ob = ModelManager.getReferenced("«mut.container.refRefType.name»", recovered.get(1));
							List<EObject> tmp = new ArrayList<EObject>();
							tmp.add(recovered.get(1));
							if (ob instanceof EObject) {
								tmp.add((EObject) ob);
							}
							else {
								tmp.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
							}
							recovered = tmp;
							//«refName = mut.container.refRefRefType.name»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(1));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(1));
							«ENDIF»
							«ELSE»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(0));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(0));
							«ENDIF»
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey());
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						} else {
							return mutations;
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					EObject object = rts.getObject();
				«ENDIF»
			«ENDIF»
			«IF ((mut.object.expression === null) && (mut.container === null))»
				EObject object = rts.getObject();
			«ENDIF»
			«IF mut.object.refType !== null»
			Object o = object.eGet("«mut.object.refType»");
			if (o instanceof EObject) {
				object = (EObject) o;
			}
			if (o instanceof List<?>) {
				object = ((List<EObject) o).get(ModelManager.getRandomIndex((List<EObject) o));
			}
			«ENDIF»
			«ELSE»
			//«val List<String> resourceURIs = new ArrayList<String>()»
			//«val List<String> ecoreURIs = new ArrayList<String>()»
			//«val String resourceName = mut.object.resource»
			//«var mutatorenvironment.Resource resource = null»
			«FOR res : program.resources»
				«IF res.name.equals(resourceName)»
					//«resource = res» 
				«ENDIF»
			«ENDFOR»
			«IF resource !== null»
			//«val Source source = resource.path»
			//«val String resourcePath = project.getLocation.toFile.getPath + "/" + source.path»
			«IF (new File(resourcePath)).exists()»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			«ENDIF»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + project.name + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + project.name + "/") + ("/" + project.name + "/").length(), metamodelPath.length()) : metamodelPath»";
			relativeMetamodelPath = relativeMetamodelPath.startsWith("/") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; 
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeMetamodelPath;
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + project.name + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, "file:/" + URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, "file:/" + URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					EObject object = rts.getObject();
				«ENDIF»
			«ENDIF»
			«IF ((mut.object.expression === null) && (mut.container === null))»
				EObject object = rts.getObject();
			«ENDIF»
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
			object = o.get(ModelManager.getRandomIndex(o));
			«ENDIF»
			«ENDIF»
			«ENDIF»
			
			//«val List<String> resourceURIs = new ArrayList<String>()»
			//«val List<String> ecoreURIs = new ArrayList<String>()»
			//«val String resourceName = mut.object.resource»
			//«var mutatorenvironment.Resource resource = null»
			«FOR Resource res : program.resources»
				«IF res.name.equals(resourceName)»
					//«resource = res» 
				«ENDIF»
			«ENDFOR»
			«IF resource !== null»
			List<EPackage> savedPackages = new ArrayList<EPackage>();
			savedPackages.addAll(packages);
			packages.clear();
			List<EPackage> objectPackages = null;
			resources = new ArrayList<Resource>();
			//«val Source source = resource.path»
			//«val String resourcePath = project.getLocation.toFile.getPath + "/" + source.path»
			«IF (new File(resourcePath)).exists()»
			«FOR File resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			«ENDIF»
			«FOR String resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + project.name + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = "file:/" + absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR String ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, "file:/" + URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, "file:/" + URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeObjectMetamodelPath = "«metamodelPath.substring(metamodelPath.lastIndexOf("/"  + project.name + "/") + ("/" + project.name + "/").length(), metamodelPath.length())»";
			String absoluteObjectMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeObjectMetamodelPath;
			«IF standalone == false»
			objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, this.getClass());
			«ELSE»
			objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, «className».class);
			«ENDIF»
			packages.addAll(objectPackages);
			«ENDIF»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] nReference = newIntArrayOfSize(1)»
				//REFERENCE LIST: «nReference.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»

				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
«IF evaluation.get(0)»
					List<EObject> selectedObjects = auxObjects;
«ELSE»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ELSEIF (mut.container.expression === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «var List<Integer> nExpression = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				//EXPRESSION LEVEL: «nExpression.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE COUNTER: «var List<Integer> nReference = new ArrayList<Integer>()»
				//REFERENCE COUNTER: «nReference.add(0)»
				//RECURSION EXPRESSION COUNTER: «var List<Integer> recursionIndexExpression = new ArrayList<Integer>()»
				//RECURSION EXPRESSION COUNTER: «recursionIndexExpression.add(0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
«IF evaluation.get(0)»
					List<EObject> selectedObjects = auxObjects;
«ELSE»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
«ENDIF»
   				«IF mut.object instanceof RandomTypeSelection»
EObject object = null;
if (selectedObjects.size() > 0) {
object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF (mut.object.expression === null)»
				«IF ((mut.container !== null) && (mut.container.expression !== null))»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] nReference = newIntArrayOfSize(1)»
				//REFERENCE LIST: «nReference.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
				«mut.container.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
«IF evaluation.get(0)»
					List<EObject> selectedObjects = auxObjects;
«ELSE»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
«ENDIF»
   				«IF mut.object instanceof RandomTypeSelection»
EObject object = null;
if (selectedObjects.size() > 0) {
object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF resource !== null»
			packages.clear();
			packages.addAll(savedPackages);
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null; 
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
			}
			«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				EObject object = rts.getObject();
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ELSEIF mut.object instanceof SpecificObjectSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return mutations;
				}
			«ELSE»
				List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
				EObject container = containers.get(ModelManager.getRandomIndex(objects));
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
for (EObject obj : objects) {
SelectObjectMutator mut = new SelectObjectMutator(resources, resourcePackages, referenceSelection, containerSelection, obj);
//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
if (mut != null) {
mut.setId("m«nMutation»");
mutations.add(mut);
}
}
			«ELSE»
SelectObjectMutator mut = null;
if (objectSelection != null) {
mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, containerSelection, objectSelection);
}
//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
if (mut != null) {
mut.setId("m«nMutation.get(0)»");
mutations.add(mut);
}
			«ENDIF»
			//END SELECT OBJECT «methodName»
		«ENDIF»
	'''
	
}