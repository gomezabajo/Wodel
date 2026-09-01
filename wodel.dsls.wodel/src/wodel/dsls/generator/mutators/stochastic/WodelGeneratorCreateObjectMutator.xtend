package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import java.util.ArrayList
import java.util.List
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorCreateObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {

	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof CreateObjectMutator»
		//«var CreateObjectMutator mut = mt as CreateObjectMutator»
		//CREATE OBJECT «methodName»
		Resource model = MutatorUtils.currentModel(models);
				if (model == null) {
					return mutations;
				}
		«IF mut.container === null»
			List<EObject> containers = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(containers));
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), null, null);
				«ENDIF»
				} else {
					return mutations;
				}
			«ENDIF»
			«IF mut.container instanceof SpecificClosureSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), null, null);
					} else {
					return mutations;
					}
				«ENDIF»
			«ENDIF»
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION: «var int position = 0»
		«FOR AttributeSet c : mut.attributes»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			«c.method(false, false, counter, position, false, "objectSelection")»
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
			«c.method(mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
		«ENDFOR»
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "«mut.type.name»");
		//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		if (mut != null) {
			mut.setId("m«nMutation.get(0)»");
			mutations.add(mut);
		}
		//END CREATE OBJECT «methodName»
	«ENDIF»
	'''
	
}