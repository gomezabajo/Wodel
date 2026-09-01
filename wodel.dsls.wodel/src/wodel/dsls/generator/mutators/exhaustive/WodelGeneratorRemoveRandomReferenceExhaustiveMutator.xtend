package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.RemoveRandomReferenceMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.Mutator
import mutatorenvironment.Program

class WodelGeneratorRemoveRandomReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {

	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof RemoveRandomReferenceMutator»
		//«var RemoveRandomReferenceMutator mut = mt as RemoveRandomReferenceMutator»
		// REMOVE RANDOM REFERENCE «methodName»
		//END REMOVE RANDOM REFERENCE «methodName»
		«ENDIF»
	'''
}