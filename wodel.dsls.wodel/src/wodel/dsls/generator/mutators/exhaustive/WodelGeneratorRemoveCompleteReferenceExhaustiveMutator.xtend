package wodel.dsls.generator.mutators.exhaustive

import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import mutatorenvironment.RemoveCompleteReferenceMutator

class WodelGeneratorRemoveCompleteReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {

	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof RemoveCompleteReferenceMutator»
		//«var RemoveCompleteReferenceMutator mut = mt as RemoveCompleteReferenceMutator»
	
		// REMOVE COMPLETE REFERENCE «methodName»
		//END REMOVE COMPLETE REFERENCE «methodName»
		
		«ENDIF»
	'''
	
}