package wodel.dsls.generator.mutators.stochastic;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorCreateObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof CreateObjectMutator)) {
        _builder.append("//");
        CreateObjectMutator mut = ((CreateObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("//CREATE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return mutations;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        {
          ObSelectionStrategy _container = mut.getContainer();
          boolean _tripleEquals = (_container == null);
          if (_tripleEquals) {
            _builder.append("List<EObject> containers = ModelManager.getParentObjects(packages, model, \"");
            String _name = mut.getType().getName();
            _builder.append(_name);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("EObject container = containers.get(ModelManager.getRandomIndex(containers));");
            _builder.newLine();
            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
            _builder.newLine();
            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof RandomTypeSelection)) {
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_1 = ((RandomTypeSelection) _container_2).getType().getName();
                _builder.append(_name_1);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
                _builder.newLine();
                {
                  EReference _refType = mut.getContainer().getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                    String _name_2 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_2);
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_3 = mut.getContainer();
              if ((_container_3 instanceof CompleteTypeSelection)) {
                _builder.newLine();
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_3 = ((CompleteTypeSelection) _container_4).getType().getName();
                _builder.append(_name_3);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
                _builder.newLine();
                {
                  EReference _refType_1 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_1 = (_refType_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                    String _name_4 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_4);
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_5 = mut.getContainer();
              if ((_container_5 instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy containerSelection = null;");
                _builder.newLine();
                _builder.append("SpecificReferenceSelection referenceSelection = null;");
                _builder.newLine();
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_6 = mut.getContainer();
                String _name_5 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                _builder.append(_name_5);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_6 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_6);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_7 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_7);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                {
                  EReference _refType_2 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_2 = (_refType_2 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                    ObSelectionStrategy _container_9 = mut.getContainer();
                    String _name_8 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                    _builder.append(_name_8);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_10 = mut.getContainer();
                    String _name_9 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                    _builder.append(_name_9);
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_11 = mut.getContainer();
                    String _name_10 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                    _builder.append(_name_10);
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                    ObSelectionStrategy _container_12 = mut.getContainer();
                    String _name_11 = ((SpecificObjectSelection) _container_12).getObjSel().getName();
                    _builder.append(_name_11);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_13 = mut.getContainer();
                    String _name_12 = ((SpecificObjectSelection) _container_13).getObjSel().getName();
                    _builder.append(_name_12);
                    _builder.append(".getValue().getKey(), \"");
                    String _name_13 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_13);
                    _builder.append("\", entry_");
                    ObSelectionStrategy _container_14 = mut.getContainer();
                    String _name_14 = ((SpecificObjectSelection) _container_14).getObjSel().getName();
                    _builder.append(_name_14);
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                    ObSelectionStrategy _container_15 = mut.getContainer();
                    String _name_15 = ((SpecificObjectSelection) _container_15).getObjSel().getName();
                    _builder.append(_name_15);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_16 = mut.getContainer();
                    String _name_16 = ((SpecificObjectSelection) _container_16).getObjSel().getName();
                    _builder.append(_name_16);
                    _builder.append(".getValue().getKey(), null, null);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_17 = mut.getContainer();
              if ((_container_17 instanceof SpecificClosureSelection)) {
                _builder.append("ObSelectionStrategy containerSelection = null;");
                _builder.newLine();
                _builder.append("SpecificReferenceSelection referenceSelection = null;");
                _builder.newLine();
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_18 = mut.getContainer();
                String _name_17 = ((SpecificClosureSelection) _container_18).getObjSel().getName();
                _builder.append(_name_17);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_19 = mut.getContainer();
                String _name_18 = ((SpecificClosureSelection) _container_19).getObjSel().getName();
                _builder.append(_name_18);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _container_20 = mut.getContainer();
                String _name_19 = ((SpecificClosureSelection) _container_20).getObjSel().getName();
                _builder.append(_name_19);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                {
                  EReference _refType_3 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_3 = (_refType_3 != null);
                  if (_tripleNotEquals_3) {
                    _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                    ObSelectionStrategy _container_21 = mut.getContainer();
                    String _name_20 = ((SpecificClosureSelection) _container_21).getObjSel().getName();
                    _builder.append(_name_20);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_22 = mut.getContainer();
                    String _name_21 = ((SpecificClosureSelection) _container_22).getObjSel().getName();
                    _builder.append(_name_21);
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_23 = mut.getContainer();
                    String _name_22 = ((SpecificClosureSelection) _container_23).getObjSel().getName();
                    _builder.append(_name_22);
                    _builder.append(".getKey(), \"");
                    ObSelectionStrategy _container_24 = mut.getContainer();
                    String _name_23 = ((SpecificClosureSelection) _container_24).getObjSel().getName();
                    _builder.append(_name_23);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                    ObSelectionStrategy _container_25 = mut.getContainer();
                    String _name_24 = ((SpecificClosureSelection) _container_25).getObjSel().getName();
                    _builder.append(_name_24);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_26 = mut.getContainer();
                    String _name_25 = ((SpecificClosureSelection) _container_26).getObjSel().getName();
                    _builder.append(_name_25);
                    _builder.append(".getValue().getKey(), \"");
                    String _name_26 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_26);
                    _builder.append("\", entry_");
                    ObSelectionStrategy _container_27 = mut.getContainer();
                    String _name_27 = ((SpecificClosureSelection) _container_27).getObjSel().getName();
                    _builder.append(_name_27);
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                    ObSelectionStrategy _container_28 = mut.getContainer();
                    String _name_28 = ((SpecificClosureSelection) _container_28).getObjSel().getName();
                    _builder.append(_name_28);
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_29 = mut.getContainer();
                    String _name_29 = ((SpecificClosureSelection) _container_29).getObjSel().getName();
                    _builder.append(_name_29);
                    _builder.append(".getValue().getKey(), null, null);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("return mutations;");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
        _builder.append("Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();");
        _builder.newLine();
        _builder.append("ObSelectionStrategy objectSelection = null;");
        _builder.newLine();
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER:");
        String _xblockexpression = null;
        {
          counter[0] = 0;
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression);
        _builder.newLineIfNotEmpty();
        _builder.append("//POSITION: ");
        int position = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeSet> _attributes = mut.getAttributes();
          for(final AttributeSet c : _attributes) {
            _builder.append("//COUNTER:");
            String _xblockexpression_1 = null;
            {
              int _get = counter[0];
              int _plus = (_get + 1);
              counter[0] = _plus;
              _xblockexpression_1 = "";
            }
            _builder.append(_xblockexpression_1);
            _builder.newLineIfNotEmpty();
            _builder.append("//POSITION");
            String _xblockexpression_2 = null;
            {
              position++;
              _xblockexpression_2 = "";
            }
            _builder.append(_xblockexpression_2);
            _builder.newLineIfNotEmpty();
            CharSequence _method = this.method(c, false, false, counter, position, false, "objectSelection");
            _builder.append(_method);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();");
        _builder.newLine();
        _builder.append("//COUNTER:");
        String _xblockexpression_3 = null;
        {
          counter = new int[1];
          _xblockexpression_3 = "";
        }
        _builder.append(_xblockexpression_3);
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER:");
        String _xblockexpression_4 = null;
        {
          counter[0] = 0;
          _xblockexpression_4 = "";
        }
        _builder.append(_xblockexpression_4);
        _builder.newLineIfNotEmpty();
        {
          EList<ReferenceSet> _references = mut.getReferences();
          for(final ReferenceSet c_1 : _references) {
            _builder.append("\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_5 = null;
            {
              int _get = counter[0];
              int _plus = (_get + 1);
              counter[0] = _plus;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LIST: ");
            List<Integer> expressionList = new ArrayList<Integer>();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LEVEL: ");
            boolean _add = expressionList.add(Integer.valueOf(0));
            _builder.append(_add, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int _set = nExpression[0] = 0;
            _builder.append(_set, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_1 = recursionIndexExpression[0] = 0;
            _builder.append(_set_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            boolean[] evaluation = new boolean[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            String _xblockexpression_6 = null;
            {
              evaluation[0] = false;
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _method_1 = this.method(c_1, mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation);
            _builder.append(_method_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, \"");
        String _name_30 = mut.getType().getName();
        _builder.append(_name_30);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("//INC COUNTER: ");
        int _get = nMutation[0];
        int _plus = (_get + 1);
        int _set_2 = nMutation[0] = _plus;
        _builder.append(_set_2);
        _builder.newLineIfNotEmpty();
        _builder.append("//INC COUNTER: ");
        int _get_1 = nRegistryMutation[0];
        int _plus_1 = (_get_1 + 1);
        int _set_3 = nRegistryMutation[0] = _plus_1;
        _builder.append(_set_3);
        _builder.newLineIfNotEmpty();
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mut.setId(\"m");
        int _get_2 = nMutation[0];
        _builder.append(_get_2, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("//END CREATE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
