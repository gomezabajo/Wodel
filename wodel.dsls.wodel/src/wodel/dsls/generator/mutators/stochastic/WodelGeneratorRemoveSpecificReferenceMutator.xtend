package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.RemoveSpecificReferenceMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.SpecificObjectSelection
import java.util.List
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorRemoveSpecificReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {

	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof RemoveSpecificReferenceMutator»
		//«var RemoveSpecificReferenceMutator mut = mt as RemoveSpecificReferenceMutator»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
		// REMOVE SPECIFIC REFERENCE «methodName»
			ObSelectionStrategy containerSelection = null;
			«IF mut.container instanceof RandomTypeSelection»
				containerSelection = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
			«ELSEIF mut.container instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSEIF mut.container instanceof CompleteTypeSelection»
				containerSelection = new CompleteTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
			«ENDIF»
			RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, containerSelection, "«mut.refType.name»");
   			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
   			if (mut != null) {
   				mut.setId("m«nMutation.get(0)»");
   				mutations.add(mut);
  			}
		//END REMOVE SPECIFIC REFERENCE «methodName»
		«ENDIF»
	'''
}