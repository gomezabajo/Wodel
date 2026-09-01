package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.RemoveRandomReferenceMutator
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorRemoveRandomReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {

	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof RemoveRandomReferenceMutator»
		//«var RemoveRandomReferenceMutator mut = mt as RemoveRandomReferenceMutator»
		// REMOVE RANDOM REFERENCE «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
			RandomTypeSelection containerSelection = new RandomTypeSelection(packages, model, "«mut.type.name»");			
			RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, containerSelection, "«mut.refType.name»");
   			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
   			if (mut != null) {
   				mut.setId("m«nMutation.get(0)»");
   				mutations.add(mut);
   			}
		//END REMOVE RANDOM REFERENCE «methodName»
		«ENDIF»
	'''
	
}