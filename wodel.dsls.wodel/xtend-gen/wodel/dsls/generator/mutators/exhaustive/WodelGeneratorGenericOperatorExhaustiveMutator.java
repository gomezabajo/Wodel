package wodel.dsls.generator.mutators.exhaustive;

import mutatorenvironment.Block;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import wodel.dsls.generator.mutators.WodelGeneratorGenericOperatorMutator;

@SuppressWarnings("all")
public abstract class WodelGeneratorGenericOperatorExhaustiveMutator extends WodelGeneratorGenericOperatorMutator {
  public abstract CharSequence apply(final Mutator mut, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone);
}
