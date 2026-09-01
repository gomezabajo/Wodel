package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.ModifySourceReferenceMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import java.util.List
import org.eclipse.core.resources.IProject
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.emf.common.util.URI

class WodelGeneratorModifySourceReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
		«IF mt instanceof ModifySourceReferenceMutator»
		//«var ModifySourceReferenceMutator mut = mt as ModifySourceReferenceMutator»
		//MODIFY SOURCE REFERENCE «methodName»
		//END MODIFY SOURCE REFERENCE «methodName»
		«ENDIF»
	'''
}