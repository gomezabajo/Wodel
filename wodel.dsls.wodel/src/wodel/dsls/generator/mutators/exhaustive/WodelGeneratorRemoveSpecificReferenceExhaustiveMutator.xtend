package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.RemoveSpecificReferenceMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.Mutator
import mutatorenvironment.Program

class WodelGeneratorRemoveSpecificReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {

	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof RemoveSpecificReferenceMutator»
		//«var RemoveSpecificReferenceMutator mut = mt as RemoveSpecificReferenceMutator»
		// REMOVE SPECIFIC REFERENCE «methodName»
		//END REMOVE SPECIFIC REFERENCE «methodName»
		«ENDIF»
	'''
	
}