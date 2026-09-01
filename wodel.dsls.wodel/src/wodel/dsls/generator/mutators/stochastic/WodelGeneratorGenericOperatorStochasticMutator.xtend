package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import wodel.dsls.generator.mutators.WodelGeneratorGenericOperatorMutator

abstract class WodelGeneratorGenericOperatorStochasticMutator extends WodelGeneratorGenericOperatorMutator {
	def CharSequence apply(Mutator mut, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone)
}