package wodel.dsls.generator.mutators.stochastic;

import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorModifyTargetReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof ModifyTargetReferenceMutator)) {
        _builder.append("\t");
        _builder.append("//");
        ModifyTargetReferenceMutator mut = ((ModifyTargetReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//MODIFY TARGET REFERENCE ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("return mutations;");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        {
          ObSelectionStrategy _source = mut.getSource();
          if ((_source instanceof RandomTypeSelection)) {
            _builder.append("\t\t");
            _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _source_1 = mut.getSource();
            String _name = ((RandomTypeSelection) _source_1).getType().getName();
            _builder.append(_name, "\t\t");
            _builder.append("\");\t\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _source_2 = mut.getSource();
            if ((_source_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t\t");
              _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, \"");
              ObSelectionStrategy _source_3 = mut.getSource();
              String _name_1 = ((RandomTypeSelection) _source_3).getType().getName();
              _builder.append(_name_1, "\t\t");
              _builder.append("\");\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("List<EObject> objects = new ArrayList<EObject>();");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("for (EObject sourceSelection.getObjects()) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("EObject obj = ent.getKey();");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("objects.add(obj);");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              ObSelectionStrategy _source_4 = mut.getSource();
              if ((_source_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t\t");
                _builder.append("SpecificObjectSelection sourceSelection = null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _source_5 = mut.getSource();
                String _name_2 = ((SpecificObjectSelection) _source_5).getObjSel().getName();
                _builder.append(_name_2, "\t\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _source_6 = mut.getSource();
                String _name_3 = ((SpecificObjectSelection) _source_6).getObjSel().getName();
                _builder.append(_name_3, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _source_7 = mut.getSource();
                String _name_4 = ((SpecificObjectSelection) _source_7).getObjSel().getName();
                _builder.append(_name_4, "\t\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("sourceSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _source_8 = mut.getSource();
                String _name_5 = ((SpecificObjectSelection) _source_8).getObjSel().getName();
                _builder.append(_name_5, "\t\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _source_9 = mut.getSource();
                String _name_6 = ((SpecificObjectSelection) _source_9).getObjSel().getName();
                _builder.append(_name_6, "\t\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _source_10 = mut.getSource();
                String _name_7 = ((SpecificObjectSelection) _source_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}\t\t\t");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("List<EObject> objects = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("objects.add(sourceSelection.getObject());");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);");
                _builder.newLine();
              }
            }
          }
        }
        {
          ObSelectionStrategy _newTarget = mut.getNewTarget();
          if ((_newTarget instanceof RandomTypeSelection)) {
            _builder.append("\t\t");
            _builder.append("RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _newTarget_1 = mut.getNewTarget();
            String _name_8 = ((RandomTypeSelection) _newTarget_1).getType().getName();
            _builder.append(_name_8, "\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            ObSelectionStrategy _newTarget_2 = mut.getNewTarget();
            if ((_newTarget_2 instanceof OtherTypeSelection)) {
              _builder.append("\t\t");
              _builder.append("EObject otherSourceSelection = null; ");
              _builder.newLine();
              {
                ObSelectionStrategy _source_11 = mut.getSource();
                if ((_source_11 instanceof CompleteTypeSelection)) {
                  _builder.append("\t\t");
                  _builder.append("otherSourceSelection = sourceSelection.getObject();");
                  _builder.newLine();
                } else {
                  _builder.append("\t\t");
                  _builder.append("otherSourceSelection = sourceSelection.getObject();");
                  _builder.newLine();
                }
              }
              _builder.append("\t\t");
              _builder.append("Object otherRef = null;");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("if (otherSourceSelection != null) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("if (ref.getName().equals(\"");
              String _name_9 = mut.getRefType().getName();
              _builder.append(_name_9, "\t\t\t\t");
              _builder.append("\")) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("otherRef = otherSourceSelection.eGet(ref);");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("break;");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, \"");
              ObSelectionStrategy _newTarget_3 = mut.getNewTarget();
              String _name_10 = ((OtherTypeSelection) _newTarget_3).getType().getName();
              _builder.append(_name_10, "\t\t");
              _builder.append("\", otherRef);");
              _builder.newLineIfNotEmpty();
            } else {
              ObSelectionStrategy _newTarget_4 = mut.getNewTarget();
              if ((_newTarget_4 instanceof CompleteTypeSelection)) {
                _builder.append("\t\t");
                _builder.append("RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, \"");
                ObSelectionStrategy _newTarget_5 = mut.getNewTarget();
                String _name_11 = ((CompleteTypeSelection) _newTarget_5).getType().getName();
                _builder.append(_name_11, "\t\t");
                _builder.append("\");\t\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                ObSelectionStrategy _newTarget_6 = mut.getNewTarget();
                if ((_newTarget_6 instanceof SpecificObjectSelection)) {
                  _builder.append("\t\t");
                  _builder.append("SpecificObjectSelection newTargetSelection = null;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _newTarget_7 = mut.getNewTarget();
                  String _name_12 = ((SpecificObjectSelection) _newTarget_7).getObjSel().getName();
                  _builder.append(_name_12, "\t\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _newTarget_8 = mut.getNewTarget();
                  String _name_13 = ((SpecificObjectSelection) _newTarget_8).getObjSel().getName();
                  _builder.append(_name_13, "\t\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _newTarget_9 = mut.getNewTarget();
                  String _name_14 = ((SpecificObjectSelection) _newTarget_9).getObjSel().getName();
                  _builder.append(_name_14, "\t\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("newTargetSelection = new SpecificObjectSelection(entry_");
                  ObSelectionStrategy _newTarget_10 = mut.getNewTarget();
                  String _name_15 = ((SpecificObjectSelection) _newTarget_10).getObjSel().getName();
                  _builder.append(_name_15, "\t\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _newTarget_11 = mut.getNewTarget();
                  String _name_16 = ((SpecificObjectSelection) _newTarget_11).getObjSel().getName();
                  _builder.append(_name_16, "\t\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _newTarget_12 = mut.getNewTarget();
                  String _name_17 = ((SpecificObjectSelection) _newTarget_12).getObjSel().getName();
                  _builder.append(_name_17, "\t\t\t");
                  _builder.append(".getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return mutations;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("}\t\t\t");
                  _builder.newLine();
                } else {
                  _builder.append("\t\t");
                  _builder.append("ObSelectionStrategy newTargetSelection = new SpecificObjectSelection(packages, model, (EObject) null);");
                  _builder.newLine();
                }
              }
            }
          }
        }
        {
          ObSelectionStrategy _source_12 = mut.getSource();
          if ((_source_12 instanceof CompleteTypeSelection)) {
            _builder.append("\t\t");
            _builder.append("for (ObSelectionStrategy sourceSelection : listSourceSelection) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (sourceSelection != null && newTargetSelection != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("EObject source = sourceSelection.getObject();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("EObject target = newTargetSelection.getObject();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("// We avoid cycles");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (source != null && target != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("EObject previous = source.eContainer();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("while (previous != null && !EcoreUtil.equals(previous, target)) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("previous = previous.eContainer();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (EcoreUtil.equals(previous, target)) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("continue;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("mutations.add(ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, \"");
            String _name_18 = mut.getRefType().getName();
            _builder.append(_name_18, "\t\t\t");
            _builder.append("\"));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("if (sourceSelection == null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return mutations;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("EObject source = sourceSelection.getObject();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (source == null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return mutations;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (newTargetSelection == null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return mutations;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("EObject target = newTargetSelection.getObject();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (target == null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return mutations;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("// We avoid cycles");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("EObject previous = source.eContainer();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("while (previous != null && !EcoreUtil.equals(previous, target)) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("previous = previous.eContainer();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (!EcoreUtil.equals(previous, target)) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, \"");
            String _name_19 = mut.getRefType().getName();
            _builder.append(_name_19, "\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//INC COUNTER: ");
            int _get = nMutation[0];
            int _plus = (_get + 1);
            int _set = nMutation[0] = _plus;
            _builder.append(_set, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_1 = nRegistryMutation[0];
            int _plus_1 = (_get_1 + 1);
            int _set_1 = nRegistryMutation[0] = _plus_1;
            _builder.append(_set_1, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("mut.setId(\"m");
            int _get_2 = nMutation[0];
            _builder.append(_get_2, "\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("//END MODIFY TARGET REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
