package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorRemoveSpecificReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RemoveSpecificReferenceMutator)) {
        _builder.append("//");
        RemoveSpecificReferenceMutator mut = ((RemoveSpecificReferenceMutator) mt);
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
        _builder.append("// REMOVE SPECIFIC REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        {
          ObSelectionStrategy _container = mut.getContainer();
          if ((_container instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("containerSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _container_1 = mut.getContainer();
            String _name = ((RandomTypeSelection) _container_1).getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _container_2 = mut.getContainer();
            if ((_container_2 instanceof SpecificObjectSelection)) {
              _builder.append("\t");
              _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
              ObSelectionStrategy _container_3 = mut.getContainer();
              String _name_1 = ((SpecificObjectSelection) _container_3).getObjSel().getName();
              _builder.append(_name_1, "\t");
              _builder.append(" = hmObjects.get(\"");
              ObSelectionStrategy _container_4 = mut.getContainer();
              String _name_2 = ((SpecificObjectSelection) _container_4).getObjSel().getName();
              _builder.append(_name_2, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("if (entry_");
              ObSelectionStrategy _container_5 = mut.getContainer();
              String _name_3 = ((SpecificObjectSelection) _container_5).getObjSel().getName();
              _builder.append(_name_3, "\t");
              _builder.append(" != null) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("containerSelection = new SpecificObjectSelection(entry_");
              ObSelectionStrategy _container_6 = mut.getContainer();
              String _name_4 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
              _builder.append(_name_4, "\t\t");
              _builder.append(".getValue().getValue(), entry_");
              ObSelectionStrategy _container_7 = mut.getContainer();
              String _name_5 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
              _builder.append(_name_5, "\t\t");
              _builder.append(".getValue().getKey(), entry_");
              ObSelectionStrategy _container_8 = mut.getContainer();
              String _name_6 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
              _builder.append(_name_6, "\t\t");
              _builder.append(".getKey());");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("} else {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return mutations;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              ObSelectionStrategy _container_9 = mut.getContainer();
              if ((_container_9 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.append("containerSelection = new CompleteTypeSelection(packages, model, \"");
                ObSelectionStrategy _container_10 = mut.getContainer();
                String _name_7 = ((CompleteTypeSelection) _container_10).getType().getName();
                _builder.append(_name_7, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, containerSelection, \"");
        String _name_8 = mut.getRefType().getName();
        _builder.append(_name_8, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get = nMutation[0];
        int _plus = (_get + 1);
        int _set = nMutation[0] = _plus;
        _builder.append(_set, "   \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get_1 = nRegistryMutation[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = nRegistryMutation[0] = _plus_1;
        _builder.append(_set_1, "   \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t\t");
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("   \t\t\t\t");
        _builder.append("mut.setId(\"m");
        int _get_2 = nMutation[0];
        _builder.append(_get_2, "   \t\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t\t\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("  \t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("//END REMOVE SPECIFIC REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
