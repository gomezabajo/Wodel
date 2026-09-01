package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.RemoveCompleteReferenceMutator
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorRemoveCompleteReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof RemoveCompleteReferenceMutator»
		//«var RemoveCompleteReferenceMutator mut = mt as RemoveCompleteReferenceMutator»
		// REMOVE COMPLETE REFERENCE «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
			CompleteTypeSelection containersSelection = new CompleteTypeSelection(packages, model, "«mut.type.name»");
			List<EObject> objects = containersSelection.getObjects();
			for (EObject obj : objects) {
				RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, obj, "«mut.refType.name»");
	   			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
	   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
	   			if (mut != null) {
	   				mut.setId("m«nMutation.get(0)»");
	   				mutations.add(mut);
	   			}
			}
		//END REMOVE COMPLETE REFERENCE «methodName»
		«ENDIF»
	'''


}