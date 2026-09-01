package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorModifySourceReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof ModifySourceReferenceMutator)) {
        _builder.append("//");
        ModifySourceReferenceMutator mut = ((ModifySourceReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("//MODIFY SOURCE REFERENCE ");
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
            _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _source_1 = mut.getSource();
            String _name = ((RandomTypeSelection) _source_1).getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _source_2 = mut.getSource();
            if ((_source_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
              ObSelectionStrategy _source_3 = mut.getSource();
              String _name_1 = ((CompleteTypeSelection) _source_3).getType().getName();
              _builder.append(_name_1, "\t");
              _builder.append(" = hmList.get(\"");
              ObSelectionStrategy _source_4 = mut.getSource();
              String _name_2 = ((CompleteTypeSelection) _source_4).getType().getName();
              _builder.append(_name_2, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("List<EObject> objects = new ArrayList<EObject>();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
              ObSelectionStrategy _source_5 = mut.getSource();
              String _name_3 = ((CompleteTypeSelection) _source_5).getType().getName();
              _builder.append(_name_3, "\t");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("EObject obj = ent.getKey();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("objects.add(obj);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("List<ObSelectionStrategy> listSourceSelection = new ArrayList<ObSelectionStrategy>();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("for (EObject obj : objects) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("listSourceSelection.add(objectSelection);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              ObSelectionStrategy _source_6 = mut.getSource();
              if ((_source_6 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy sourceSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _source_7 = mut.getSource();
                String _name_4 = ((SpecificObjectSelection) _source_7).getObjSel().getName();
                _builder.append(_name_4, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _source_8 = mut.getSource();
                String _name_5 = ((SpecificObjectSelection) _source_8).getObjSel().getName();
                _builder.append(_name_5, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _source_9 = mut.getSource();
                String _name_6 = ((SpecificObjectSelection) _source_9).getObjSel().getName();
                _builder.append(_name_6, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("sourceSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _source_10 = mut.getSource();
                String _name_7 = ((SpecificObjectSelection) _source_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _source_11 = mut.getSource();
                String _name_8 = ((SpecificObjectSelection) _source_11).getObjSel().getName();
                _builder.append(_name_8, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _source_12 = mut.getSource();
                String _name_9 = ((SpecificObjectSelection) _source_12).getObjSel().getName();
                _builder.append(_name_9, "\t\t");
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
          ObSelectionStrategy _newSource = mut.getNewSource();
          if ((_newSource instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _newSource_1 = mut.getNewSource();
            String _name_10 = ((RandomTypeSelection) _newSource_1).getType().getName();
            _builder.append(_name_10, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _newSource_2 = mut.getNewSource();
            if ((_newSource_2 instanceof OtherTypeSelection)) {
              _builder.append("\t");
              _builder.append("EObject otherSourceSelection = null; ");
              _builder.newLine();
              {
                ObSelectionStrategy _source_13 = mut.getSource();
                if ((_source_13 instanceof CompleteTypeSelection)) {
                  _builder.append("\t");
                  _builder.append("otherSourceSelection = sourceSelection.get(0).getObject();");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("otherSourceSelection = sourceSelection.getObject();");
                  _builder.newLine();
                }
              }
              _builder.append("\t");
              _builder.append("Object otherRef = null;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("if (otherSourceSelection != null) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("if (ref.getName().equals(\"");
              String _name_11 = mut.getRefType().getName();
              _builder.append(_name_11, "\t\t\t");
              _builder.append("\")) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t\t\t");
              _builder.append("otherRef = otherSourceSelection.eGet(ref);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t\t");
              _builder.append("break;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("OtherTypeSelection newSourceSelection = new OtherTypeSelection(packages, model, \"");
              ObSelectionStrategy _newSource_3 = mut.getNewSource();
              String _name_12 = ((OtherTypeSelection) _newSource_3).getType().getName();
              _builder.append(_name_12, "\t");
              _builder.append("\", otherRef);");
              _builder.newLineIfNotEmpty();
            } else {
              ObSelectionStrategy _newSource_4 = mut.getNewSource();
              if ((_newSource_4 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, \"");
                ObSelectionStrategy _newSource_5 = mut.getNewSource();
                String _name_13 = ((CompleteTypeSelection) _newSource_5).getType().getName();
                _builder.append(_name_13, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                ObSelectionStrategy _newSource_6 = mut.getNewSource();
                if ((_newSource_6 instanceof SpecificObjectSelection)) {
                  _builder.append("\t");
                  _builder.append("ObSelectionStrategy newSourceSelection = null;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _newSource_7 = mut.getNewSource();
                  String _name_14 = ((SpecificObjectSelection) _newSource_7).getObjSel().getName();
                  _builder.append(_name_14, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _newSource_8 = mut.getNewSource();
                  String _name_15 = ((SpecificObjectSelection) _newSource_8).getObjSel().getName();
                  _builder.append(_name_15, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _newSource_9 = mut.getNewSource();
                  String _name_16 = ((SpecificObjectSelection) _newSource_9).getObjSel().getName();
                  _builder.append(_name_16, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("newSourceSelection = new SpecificObjectSelection(entry_");
                  ObSelectionStrategy _newSource_10 = mut.getNewSource();
                  String _name_17 = ((SpecificObjectSelection) _newSource_10).getObjSel().getName();
                  _builder.append(_name_17, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _newSource_11 = mut.getNewSource();
                  String _name_18 = ((SpecificObjectSelection) _newSource_11).getObjSel().getName();
                  _builder.append(_name_18, "\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _newSource_12 = mut.getNewSource();
                  String _name_19 = ((SpecificObjectSelection) _newSource_12).getObjSel().getName();
                  _builder.append(_name_19, "\t\t");
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
                  _builder.append("ObSelectionStrategy newSourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);");
                  _builder.newLine();
                }
              }
            }
          }
        }
        {
          ObSelectionStrategy _source_14 = mut.getSource();
          if ((_source_14 instanceof CompleteTypeSelection)) {
            _builder.append("\t");
            _builder.append("for (ObSelectionStrategy sourceSelection : listSourceSelection) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, \"");
            String _name_20 = mut.getRefType().getName();
            _builder.append(_name_20, "\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("   \t");
            _builder.append("//INC COUNTER: ");
            int _get = nMutation[0];
            int _plus = (_get + 1);
            int _set = nMutation[0] = _plus;
            _builder.append(_set, "\t   \t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_1 = nRegistryMutation[0];
            int _plus_1 = (_get_1 + 1);
            int _set_1 = nRegistryMutation[0] = _plus_1;
            _builder.append(_set_1, "\t\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("   \t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("   \t\t");
            _builder.append("mut.setId(\"m");
            int _get_2 = nMutation[0];
            _builder.append(_get_2, "\t   \t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, \"");
            String _name_21 = mut.getRefType().getName();
            _builder.append(_name_21, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INC COUNTER: ");
            int _get_3 = nMutation[0];
            int _plus_2 = (_get_3 + 1);
            int _set_2 = nMutation[0] = _plus_2;
            _builder.append(_set_2, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_4 = nRegistryMutation[0];
            int _plus_3 = (_get_4 + 1);
            int _set_3 = nRegistryMutation[0] = _plus_3;
            _builder.append(_set_3, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("mut.setId(\"m");
            int _get_5 = nMutation[0];
            _builder.append(_get_5, "\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("//END MODIFY SOURCE REFERENCE ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
