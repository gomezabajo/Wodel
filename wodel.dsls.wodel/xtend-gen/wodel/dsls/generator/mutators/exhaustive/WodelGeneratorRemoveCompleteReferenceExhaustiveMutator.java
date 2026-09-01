package wodel.dsls.generator.mutators.exhaustive;

import mutatorenvironment.Block;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorRemoveCompleteReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RemoveCompleteReferenceMutator)) {
        _builder.append("\t");
        _builder.append("//");
        RemoveCompleteReferenceMutator mut = ((RemoveCompleteReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// REMOVE COMPLETE REFERENCE ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//END REMOVE COMPLETE REFERENCE ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
