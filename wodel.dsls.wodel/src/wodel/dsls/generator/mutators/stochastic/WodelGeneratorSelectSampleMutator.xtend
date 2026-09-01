package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import java.util.ArrayList
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.SampleClause
import org.eclipse.emf.ecore.EStructuralFeature
import mutatorenvironment.ReferenceEvaluation
import mutatorenvironment.AttributeEvaluation
import java.util.List
import mutatorenvironment.Resource
import mutatorenvironment.Source
import java.io.File
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import mutatorenvironment.Mutator

class WodelGeneratorSelectSampleMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof SelectSampleMutator»
		//«var SelectSampleMutator mut = mt as SelectSampleMutator»
		
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
		//SELECT SAMPLE OBJECT «methodName»
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		SpecificReferenceSelection referenceSelection = null;
		//«var int i = 0»
		//«var int j = 0»
		«IF mut.object.resource === null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«IF (mut.object.expression === null)»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] counter = newIntArrayOfSize(1)»
				//REFERENCE LIST: «counter.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
				«mut.object.expression.method(mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
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
		«IF mut.object instanceof RandomTypeSelection»
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			EObject object = rts.getObject();
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
			} else {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					resourcePackages = listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
				}
				else {
					return mutations;
				}
			}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
			} else {
				return mutations;
			}
		«ELSE»
			List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(objects));
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ENDIF»
		if (objectSelection != null) {
		«IF mut.object.refType !== null»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«mut.object.refType.name»", objectSelection.getObject());
		«ELSE»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);
		«ENDIF»
		}
		List<String> features = new ArrayList<String>();
		«IF mut.clause == SampleClause.EQUALS»
		boolean equals = true;
		«ENDIF»
		«IF mut.clause == SampleClause.DISTINCT»
		boolean equals = false;
		«ENDIF»
		«IF mut.features.size > 0»
		«FOR EStructuralFeature feature : mut.features»
		if (!features.contains("«feature.name»")) {
			features.add("«feature.name»");	
		}
		«ENDFOR»
		«ELSE»
		equals = false;
		«ENDIF»
		«IF mut.object.expression !== null»
		«IF mut.object.expression.first instanceof ReferenceEvaluation»
		//«var ReferenceEvaluation ev = mut.object.expression.first as ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.first instanceof AttributeEvaluation»
		//«var AttributeEvaluation ev = mut.object.expression.first as AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.second !== null && mut.object.expression.second.size > 0»
		«FOR ev : mut.object.expression.second»
		«IF ev instanceof ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF ev instanceof AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		«ENDIF»
		«ELSE»
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
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + project.name + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + project.name + "/") + ("/" + project.name + "/").length(), metamodelPath.length()) : metamodelPath»";
			relativeMetamodelPath = relativeMetamodelPath.startsWith("/") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; 
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeMetamodelPath;
			«IF standalone == false»
			List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			List<Resource> resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
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
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + project.name + "/") + ("/" + project.name + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = "file:/" + absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«IF (mut.object.expression === null)»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] counter = newIntArrayOfSize(1)»
				//REFERENCE LIST: «counter.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
				«mut.object.expression.method(mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
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
		«IF mut.object instanceof RandomTypeSelection»
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		}
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			EObject object = rts.getObject();
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
			} else {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					resourcePackages = listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
				}
				else {
					return mutations;
				}
			}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
			} else {
				return mutations;
			}
		«ELSE»
			List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(objects));
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ENDIF»
		if (objectSelection != null) {
		«IF mut.object.refType !== null»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«mut.object.refType.name»", objectSelection.getObject());
		«ELSE»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);
		«ENDIF»
		}
		List<String> features = new ArrayList<String>();
		«IF mut.clause == SampleClause.EQUALS»
		boolean equals = true;
		«ENDIF»
		«IF mut.clause == SampleClause.DISTINCT»
		boolean equals = false;
		«ENDIF»
		«IF mut.features.size > 0»
		«FOR EStructuralFeature feature : mut.features»
		if (!features.contains("«feature.name»")) {
			features.add("«feature.name»");	
		}
		«ENDFOR»
		«ELSE»
		equals = false;
		«ENDIF»
		«IF mut.object.expression !== null»
		«IF mut.object.expression.first instanceof ReferenceEvaluation»
		//«var ReferenceEvaluation ev = mut.object.expression.first as ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.first instanceof AttributeEvaluation»
		//«var AttributeEvaluation ev = mut.object.expression.first as AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.second !== null && mut.object.expression.second.size > 0»
		«FOR ev : mut.object.expression.second»
		«IF ev instanceof ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF ev instanceof AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		«ENDIF»
		«ENDIF»
		«ENDIF»
		SelectSampleMutator mut = null;
		if (objectSelection != null) {
			mut = new SelectSampleMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, objectSelection, equals, features);
		}
		//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		if (mut != null) {
			mut.setId("m«nMutation.get(0)»");
			mutations.add(mut);
		}
		//END SELECT SAMPLE OBJECT «methodName»
	«ENDIF»
	'''
}