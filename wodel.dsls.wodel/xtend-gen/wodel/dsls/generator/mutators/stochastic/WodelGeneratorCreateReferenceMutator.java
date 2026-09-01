package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorCreateReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof CreateReferenceMutator)) {
        _builder.append("//");
        CreateReferenceMutator mut = ((CreateReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("//CREATE REFERENCE ");
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
        {
          ObSelectionStrategy _source = mut.getSource();
          if ((_source instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), \"");
            ObSelectionStrategy _source_1 = mut.getSource();
            String _name = ((RandomTypeSelection) _source_1).getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _source_2 = mut.getSource();
            if ((_source_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), \"");
              ObSelectionStrategy _source_3 = mut.getSource();
              String _name_1 = ((CompleteTypeSelection) _source_3).getType().getName();
              _builder.append(_name_1, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            } else {
              ObSelectionStrategy _source_4 = mut.getSource();
              if ((_source_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy sourceSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _source_5 = mut.getSource();
                String _name_2 = ((SpecificObjectSelection) _source_5).getObjSel().getName();
                _builder.append(_name_2, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _source_6 = mut.getSource();
                String _name_3 = ((SpecificObjectSelection) _source_6).getObjSel().getName();
                _builder.append(_name_3, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _source_7 = mut.getSource();
                String _name_4 = ((SpecificObjectSelection) _source_7).getObjSel().getName();
                _builder.append(_name_4, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("sourceSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _source_8 = mut.getSource();
                String _name_5 = ((SpecificObjectSelection) _source_8).getObjSel().getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _source_9 = mut.getSource();
                String _name_6 = ((SpecificObjectSelection) _source_9).getObjSel().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _source_10 = mut.getSource();
                String _name_7 = ((SpecificObjectSelection) _source_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t");
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
                _builder.append("\t");
                _builder.append("ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);");
                _builder.newLine();
              }
            }
          }
        }
        {
          ObSelectionStrategy _target = mut.getTarget();
          if ((_target instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _target_1 = mut.getTarget();
            String _name_8 = ((RandomTypeSelection) _target_1).getType().getName();
            _builder.append(_name_8, "\t");
            _builder.append("\");\t\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _target_2 = mut.getTarget();
            if ((_target_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, \"");
              ObSelectionStrategy _target_3 = mut.getTarget();
              String _name_9 = ((CompleteTypeSelection) _target_3).getType().getName();
              _builder.append(_name_9, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            } else {
              ObSelectionStrategy _target_4 = mut.getTarget();
              if ((_target_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy targetSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _target_5 = mut.getTarget();
                String _name_10 = ((SpecificObjectSelection) _target_5).getObjSel().getName();
                _builder.append(_name_10, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _target_6 = mut.getTarget();
                String _name_11 = ((SpecificObjectSelection) _target_6).getObjSel().getName();
                _builder.append(_name_11, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _target_7 = mut.getTarget();
                String _name_12 = ((SpecificObjectSelection) _target_7).getObjSel().getName();
                _builder.append(_name_12, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("targetSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _target_8 = mut.getTarget();
                String _name_13 = ((SpecificObjectSelection) _target_8).getObjSel().getName();
                _builder.append(_name_13, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _target_9 = mut.getTarget();
                String _name_14 = ((SpecificObjectSelection) _target_9).getObjSel().getName();
                _builder.append(_name_14, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _target_10 = mut.getTarget();
                String _name_15 = ((SpecificObjectSelection) _target_10).getObjSel().getName();
                _builder.append(_name_15, "\t\t");
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
                _builder.append("\t");
                _builder.append("ObSelectionStrategy targetSelection = new SpecificObjectSelection(packages, model, (EObject) null);");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("CreateReferenceMutator mut = new CreateReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, targetSelection, \"");
        String _name_16 = mut.getRefType().getName();
        _builder.append(_name_16, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//INC COUNTER: ");
        int _get = nMutation[0];
        int _plus = (_get + 1);
        int _set = nMutation[0] = _plus;
        _builder.append(_set, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get_1 = nRegistryMutation[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = nRegistryMutation[0] = _plus_1;
        _builder.append(_set_1, "  \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mut.setId(\"m");
        int _get_2 = nMutation[0];
        _builder.append(_get_2, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//END CREATE REFERENCE ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
