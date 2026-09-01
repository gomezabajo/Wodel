package wodel.dsls.generator.mutators.exhaustive;

import mutatorenvironment.Block;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorRemoveSpecificReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RemoveSpecificReferenceMutator)) {
        _builder.append("//");
        RemoveSpecificReferenceMutator mut = ((RemoveSpecificReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("// REMOVE SPECIFIC REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("//END REMOVE SPECIFIC REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
