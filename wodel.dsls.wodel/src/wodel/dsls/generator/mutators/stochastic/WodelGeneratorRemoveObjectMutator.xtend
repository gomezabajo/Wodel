package wodel.dsls.generator.mutators.stochastic

import java.util.List
import mutatorenvironment.RemoveObjectMutator
import mutatorenvironment.RandomTypeSelection
import org.eclipse.emf.ecore.EClass
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import java.util.ArrayList
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorRemoveObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof RemoveObjectMutator»
		//«var RemoveObjectMutator mut = mt as RemoveObjectMutator»
			// REMOVE OBJECT «methodName»
					Resource model = MutatorUtils.currentModel(models);
							if (model == null) {
								return mutations;
							}
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			List<String> mutTypes = new ArrayList<String>();
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
			//«var boolean rts = false»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
				«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
				«ENDIF»
				«ELSE»
					«IF mut.container instanceof RandomTypeSelection»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, model, container);
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
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
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						} else {
							return mutations;
						}
						«IF mut.container.refType !== null»
							if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							} else {
								return mutations;
							}
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ENDIF»
					«IF rts == true»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), mutTypes, referenceSelection, containerSelection);
					«ELSE»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), mutTypes, referenceSelection, containerSelection);
					«ENDIF»
					«IF ((mut.object.expression === null) && (mut.container.expression === null))»
						EObject object = rts.getObject();
					«ENDIF»	
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container === null))»
				«IF mut.object instanceof RandomTypeSelection»
					EObject object = rts.getObject();
				«ENDIF»
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
				«IF mut.object.expression !== null»
					«IF mut.container === null»
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
					«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression,  false, false, false, evaluation)»
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
					«ELSEIF mut.container.expression === null»
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
					«IF ((mut.container !== null) && (mut.container.expression === null))»
					List<EObject> objects = rts.getObjects();
					«ENDIF»
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy objectSelection = null; 
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
				«ENDIF»
				«ELSEIF mut.object instanceof SpecificObjectSelection»
				«IF mut.container === null»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
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
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«IF mut.container.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return mutations;
					}
				«IF mut.container.refType !== null»
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ENDIF»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey(), referenceSelection, containerSelection);
				} else {
					return mutations;
				}
				«ENDIF»
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
					«IF mut.object.expression === null»
					«IF mut.container === null»
						CompleteTypeSelection objectsSelection = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
						objects = objectsSelection.getObjects();
					«ENDIF»
					«ELSE»
						objects = selectedObjects;
					«ENDIF»
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
					if (objects != null) {
						for (EObject obj : objects) {
							if (mutatedObjects != null) {
								mutatedObjects.add(obj);
							}
							RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
							//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		   					//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
							if (mut != null) {
						   		mut.setId("m«nMutation.get(0)»");
								mutations.add(mut);
							}
						}
					}
				«ELSE»
					RemoveObjectMutator mut = null;
					if (objectSelection != null) {
						if (mutatedObjects != null) {
							mutatedObjects.add(objectSelection.getObject());
						}
						mut = new RemoveObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, referenceSelection, containerSelection);
					}
					//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
					if (mut != null) {
				   		mut.setId("m«nMutation.get(0)»");
						mutations.add(mut);
					}
			«ENDIF»
		//END REMOVE OBJECT «methodName»
	«ENDIF»
	'''
	
}