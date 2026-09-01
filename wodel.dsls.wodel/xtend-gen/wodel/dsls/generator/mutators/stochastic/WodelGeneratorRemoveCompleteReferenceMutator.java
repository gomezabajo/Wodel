package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.Mutator;
import mutatorenvironment.Program;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorRemoveCompleteReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RemoveCompleteReferenceMutator)) {
        _builder.append("//");
        RemoveCompleteReferenceMutator mut = ((RemoveCompleteReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("// REMOVE COMPLETE REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("return mutations;");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("CompleteTypeSelection containersSelection = new CompleteTypeSelection(packages, model, \"");
        String _name = mut.getType().getName();
        _builder.append(_name, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("List<EObject> objects = containersSelection.getObjects();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (EObject obj : objects) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, obj, \"");
        String _name_1 = mut.getRefType().getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get = nMutation[0];
        int _plus = (_get + 1);
        int _set = nMutation[0] = _plus;
        _builder.append(_set, "\t   \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get_1 = nRegistryMutation[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = nRegistryMutation[0] = _plus_1;
        _builder.append(_set_1, "\t   \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t\t\t");
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t   \t\t\t\t");
        _builder.append("mut.setId(\"m");
        int _get_2 = nMutation[0];
        _builder.append(_get_2, "\t   \t\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t\t\t\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("\t   \t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("//END REMOVE COMPLETE REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
