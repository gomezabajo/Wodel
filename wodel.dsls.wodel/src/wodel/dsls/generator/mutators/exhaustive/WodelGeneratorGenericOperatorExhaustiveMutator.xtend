package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.Mutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import org.eclipse.emf.common.util.URI
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import wodel.dsls.generator.mutators.WodelGeneratorGenericOperatorMutator

abstract class WodelGeneratorGenericOperatorExhaustiveMutator extends WodelGeneratorGenericOperatorMutator {
	def CharSequence apply(Mutator mut, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone)
	
}