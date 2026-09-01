package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.Mutator;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import wodel.dsls.generator.mutators.WodelGeneratorGenericOperatorMutator;

@SuppressWarnings("all")
public abstract class WodelGeneratorGenericOperatorStochasticMutator extends WodelGeneratorGenericOperatorMutator {
  public abstract CharSequence apply(final Mutator mut, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone);
}
