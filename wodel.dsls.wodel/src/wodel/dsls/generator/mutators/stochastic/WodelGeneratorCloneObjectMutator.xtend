package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.CloneObjectMutator
import java.util.List
import mutatorenvironment.RandomTypeSelection
import java.util.ArrayList
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorCloneObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof CloneObjectMutator»
		//«var CloneObjectMutator mut = mt as CloneObjectMutator»
			//CLONE OBJECT «methodName»
		Resource model = MutatorUtils.currentModel(models);
		if (model == null) {
			return mutations;
		}
			«IF mut.object instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
				«IF mut.object.expression === null»
					EObject object = rts.getObject();
				«ELSE»
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
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
				«ENDIF»
				ObSelectionStrategy objectSelection = null; 
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				EObject object = rts.getObject();
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
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
						return mutations;
					}
				}
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
					objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return mutations;
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
					RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as RandomTypeSelection).type.name»");
					container = rts.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as CompleteTypeSelection).type.name»");
					container = rts.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ENDIF»
				«IF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return mutations;
					}
				«ENDIF»
			«ENDIF»
			}
			«IF mut.container !== null && mut.container.refType !== null»
				SpecificReferenceSelection referenceSelection = null;
				«IF mut.container instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSEIF mut.container instanceof SpecificClosureSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.container.refType.name»", containerSelection);
				}
				«ENDIF»
			«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);
				}
			«ENDIF»
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
			//COUNTER:«{counter.set(0, 0); ""}»
			//POSITION: «var int position = 0»
			«FOR AttributeSet c : mut.attributes»
				//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
				//POSITION«{position++; ""}»
				«c.method(false, false, counter, position, false, "objectSelection")»
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
				«c.method(mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
			«ENDFOR»
			CloneObjectMutator mut = null;
			if (objectSelection != null && objectSelection.getObject() != null) {
			«IF mut.object instanceof SpecificObjectSelection»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof SelectObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
			«ENDIF»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof CreateObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as CreateObjectMutator).type.name»");
			«ENDIF»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof CloneObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as CloneObjectMutator).object.type.name»");
			«ENDIF»
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			}
			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
  			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
			if (mut != null) {
				mut.setId("m«nMutation.get(0)»");
				mutations.add(mut);
			}
			//END CLONE OBJECT «methodName»
		«ENDIF»
	'''
}