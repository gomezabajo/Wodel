package wodel.dsls.generator.mutators.stochastic;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorCloneObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof CloneObjectMutator)) {
        _builder.append("//");
        CloneObjectMutator mut = ((CloneObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//CLONE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return mutations;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        {
          ObSelectionStrategy _object = mut.getObject();
          if ((_object instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _object_1 = mut.getObject();
            String _name = ((RandomTypeSelection) _object_1).getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("\t");
                _builder.append("EObject object = rts.getObject();");
                _builder.newLine();
              } else {
                _builder.append("\t\t\t");
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("//EXPRESSION LIST: ");
                List<Integer> expressionList = new ArrayList<Integer>();
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//EXPRESSION LIST: ");
                boolean _add = expressionList.add(Integer.valueOf(0));
                _builder.append(_add, "\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int[] nExpression = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int _set = nExpression[0] = 0;
                _builder.append(_set, "\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("Expression exp");
                Integer _get = expressionList.get(0);
                _builder.append(_get, "\t\t\t");
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//REFERENCE LIST: ");
                int[] nReference = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_1 = nReference[0] = 0;
                _builder.append(_set_1, "\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//RECURSION EXPRESSION LIST: ");
                int[] recursionIndexExpression = new int[1];
                _builder.append("»");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_2 = recursionIndexExpression[0] = 0;
                _builder.append(_set_2, "\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                boolean[] evaluation = new boolean[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                String _xblockexpression = null;
                {
                  evaluation[0] = false;
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression);
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t\t\t");
                Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation);
                _builder.append(_method, "\t   \t\t\t\t");
                _builder.newLineIfNotEmpty();
                {
                  boolean _get_1 = evaluation[0];
                  if (_get_1) {
                    _builder.append("List<EObject> selectedObjects = auxObjects;");
                    _builder.newLine();
                  } else {
                    _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                    Integer _get_2 = expressionList.get(0);
                    _builder.append(_get_2);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("EObject object = null;");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("if (selectedObjects.size() > 0) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("ObSelectionStrategy objectSelection = null; ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("if (object != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            ObSelectionStrategy _object_2 = mut.getObject();
            if ((_object_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
              ObSelectionStrategy _object_3 = mut.getObject();
              String _name_1 = ((CompleteTypeSelection) _object_3).getType().getName();
              _builder.append(_name_1, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("EObject object = rts.getObject();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
              _builder.newLine();
            } else {
              ObSelectionStrategy _object_4 = mut.getObject();
              if ((_object_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _object_5 = mut.getObject();
                String _name_2 = ((SpecificObjectSelection) _object_5).getObjSel().getName();
                _builder.append(_name_2, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _object_6 = mut.getObject();
                String _name_3 = ((SpecificObjectSelection) _object_6).getObjSel().getName();
                _builder.append(_name_3, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _object_7 = mut.getObject();
                String _name_4 = ((SpecificObjectSelection) _object_7).getObjSel().getName();
                _builder.append(_name_4, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _object_8 = mut.getObject();
                String _name_5 = ((SpecificObjectSelection) _object_8).getObjSel().getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _object_9 = mut.getObject();
                String _name_6 = ((SpecificObjectSelection) _object_9).getObjSel().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _object_10 = mut.getObject();
                String _name_7 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                ObSelectionStrategy _object_11 = mut.getObject();
                String _name_8 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                _builder.append(_name_8, "\t\t");
                _builder.append(" = hmList.get(\"");
                ObSelectionStrategy _object_12 = mut.getObject();
                String _name_9 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                _builder.append(_name_9, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (listEntry_");
                ObSelectionStrategy _object_13 = mut.getObject();
                String _name_10 = ((SpecificObjectSelection) _object_13).getObjSel().getName();
                _builder.append(_name_10, "\t\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                ObSelectionStrategy _object_14 = mut.getObject();
                String _name_11 = ((SpecificObjectSelection) _object_14).getObjSel().getName();
                _builder.append(_name_11, "\t\t\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("EObject obj = ent.getKey();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("objs.add(obj);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("objectSelection = new SpecificObjectSelection(listEntry_");
                ObSelectionStrategy _object_15 = mut.getObject();
                String _name_12 = ((SpecificObjectSelection) _object_15).getObjSel().getName();
                _builder.append(_name_12, "\t\t\t");
                _builder.append(".get(0).getValue().getValue(), listEntry_");
                ObSelectionStrategy _object_16 = mut.getObject();
                String _name_13 = ((SpecificObjectSelection) _object_16).getObjSel().getName();
                _builder.append(_name_13, "\t\t\t");
                _builder.append(".get(0).getValue().getKey(), objs);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                ObSelectionStrategy _object_17 = mut.getObject();
                if ((_object_17 instanceof SpecificClosureSelection)) {
                  _builder.append("\t");
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _object_18 = mut.getObject();
                  String _name_14 = ((SpecificClosureSelection) _object_18).getObjSel().getName();
                  _builder.append(_name_14, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _object_19 = mut.getObject();
                  String _name_15 = ((SpecificClosureSelection) _object_19).getObjSel().getName();
                  _builder.append(_name_15, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _object_20 = mut.getObject();
                  String _name_16 = ((SpecificClosureSelection) _object_20).getObjSel().getName();
                  _builder.append(_name_16, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                  ObSelectionStrategy _object_21 = mut.getObject();
                  String _name_17 = ((SpecificClosureSelection) _object_21).getObjSel().getName();
                  _builder.append(_name_17, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _object_22 = mut.getObject();
                  String _name_18 = ((SpecificClosureSelection) _object_22).getObjSel().getName();
                  _builder.append(_name_18, "\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _object_23 = mut.getObject();
                  String _name_19 = ((SpecificClosureSelection) _object_23).getObjSel().getName();
                  _builder.append(_name_19, "\t\t");
                  _builder.append(".getKey(), \"");
                  ObSelectionStrategy _object_24 = mut.getObject();
                  String _name_20 = ((SpecificClosureSelection) _object_24).getRefType().getName();
                  _builder.append(_name_20, "\t\t");
                  _builder.append("\");");
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
                }
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("EObject container = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (objectSelection != null) {");
        _builder.newLine();
        {
          ObSelectionStrategy _container = mut.getContainer();
          boolean _tripleEquals_1 = (_container == null);
          if (_tripleEquals_1) {
            _builder.append("\t");
            _builder.append("container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof RandomTypeSelection)) {
                _builder.append("\t");
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_21 = ((RandomTypeSelection) _container_2).getType().getName();
                _builder.append(_name_21, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("container = rts.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_3 = mut.getContainer();
              if ((_container_3 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_22 = ((CompleteTypeSelection) _container_4).getType().getName();
                _builder.append(_name_22, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("container = rts.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_5 = mut.getContainer();
              if ((_container_5 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_6 = mut.getContainer();
                String _name_23 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                _builder.append(_name_23, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_24 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_24, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_25 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_25, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _container_9 = mut.getContainer();
                String _name_26 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                _builder.append(_name_26, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_10 = mut.getContainer();
                String _name_27 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                _builder.append(_name_27, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _container_11 = mut.getContainer();
                String _name_28 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                _builder.append(_name_28, "\t\t");
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
              }
            }
            {
              ObSelectionStrategy _container_12 = mut.getContainer();
              if ((_container_12 instanceof SpecificClosureSelection)) {
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_13 = mut.getContainer();
                String _name_29 = ((SpecificClosureSelection) _container_13).getObjSel().getName();
                _builder.append(_name_29, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_14 = mut.getContainer();
                String _name_30 = ((SpecificClosureSelection) _container_14).getObjSel().getName();
                _builder.append(_name_30, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_15 = mut.getContainer();
                String _name_31 = ((SpecificClosureSelection) _container_15).getObjSel().getName();
                _builder.append(_name_31, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                ObSelectionStrategy _container_16 = mut.getContainer();
                String _name_32 = ((SpecificClosureSelection) _container_16).getObjSel().getName();
                _builder.append(_name_32, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_17 = mut.getContainer();
                String _name_33 = ((SpecificClosureSelection) _container_17).getObjSel().getName();
                _builder.append(_name_33, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _container_18 = mut.getContainer();
                String _name_34 = ((SpecificClosureSelection) _container_18).getObjSel().getName();
                _builder.append(_name_34, "\t\t");
                _builder.append(".getKey(), \"");
                ObSelectionStrategy _container_19 = mut.getContainer();
                String _name_35 = ((SpecificClosureSelection) _container_19).getRefType().getName();
                _builder.append(_name_35, "\t\t");
                _builder.append("\");");
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
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          if (((mut.getContainer() != null) && (mut.getContainer().getRefType() != null))) {
            _builder.append("\t");
            _builder.append("SpecificReferenceSelection referenceSelection = null;");
            _builder.newLine();
            {
              ObSelectionStrategy _container_20 = mut.getContainer();
              if ((_container_20 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_21 = mut.getContainer();
                String _name_36 = ((SpecificObjectSelection) _container_21).getObjSel().getName();
                _builder.append(_name_36, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_22 = mut.getContainer();
                String _name_37 = ((SpecificObjectSelection) _container_22).getObjSel().getName();
                _builder.append(_name_37, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_23 = mut.getContainer();
                String _name_38 = ((SpecificObjectSelection) _container_23).getObjSel().getName();
                _builder.append(_name_38, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                ObSelectionStrategy _container_24 = mut.getContainer();
                String _name_39 = ((SpecificObjectSelection) _container_24).getObjSel().getName();
                _builder.append(_name_39, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_25 = mut.getContainer();
                String _name_40 = ((SpecificObjectSelection) _container_25).getObjSel().getName();
                _builder.append(_name_40, "\t\t");
                _builder.append(".getValue().getKey(), \"");
                String _name_41 = mut.getContainer().getRefType().getName();
                _builder.append(_name_41, "\t\t");
                _builder.append("\", entry_");
                ObSelectionStrategy _container_26 = mut.getContainer();
                String _name_42 = ((SpecificObjectSelection) _container_26).getObjSel().getName();
                _builder.append(_name_42, "\t\t");
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
                ObSelectionStrategy _container_27 = mut.getContainer();
                if ((_container_27 instanceof SpecificClosureSelection)) {
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _container_28 = mut.getContainer();
                  String _name_43 = ((SpecificClosureSelection) _container_28).getObjSel().getName();
                  _builder.append(_name_43, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _container_29 = mut.getContainer();
                  String _name_44 = ((SpecificClosureSelection) _container_29).getObjSel().getName();
                  _builder.append(_name_44, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _container_30 = mut.getContainer();
                  String _name_45 = ((SpecificClosureSelection) _container_30).getObjSel().getName();
                  _builder.append(_name_45, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                  ObSelectionStrategy _container_31 = mut.getContainer();
                  String _name_46 = ((SpecificClosureSelection) _container_31).getObjSel().getName();
                  _builder.append(_name_46, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _container_32 = mut.getContainer();
                  String _name_47 = ((SpecificClosureSelection) _container_32).getObjSel().getName();
                  _builder.append(_name_47, "\t\t");
                  _builder.append(".getValue().getKey(), \"");
                  String _name_48 = mut.getContainer().getRefType().getName();
                  _builder.append(_name_48, "\t\t");
                  _builder.append("\", entry_");
                  ObSelectionStrategy _container_33 = mut.getContainer();
                  String _name_49 = ((SpecificClosureSelection) _container_33).getObjSel().getName();
                  _builder.append(_name_49, "\t\t");
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
                  _builder.append("SpecificReferenceSelection referenceSelection = null;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("if (containerSelection != null) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                  String _name_50 = mut.getContainer().getRefType().getName();
                  _builder.append(_name_50, "\t\t");
                  _builder.append("\", containerSelection);");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            _builder.append("\t");
            _builder.append("SpecificReferenceSelection referenceSelection = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("if (containerSelection != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        String _xblockexpression_1 = null;
        {
          counter[0] = 0;
          _xblockexpression_1 = "";
        }
        _builder.append(_xblockexpression_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//POSITION: ");
        int position = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeSet> _attributes = mut.getAttributes();
          for(final AttributeSet c : _attributes) {
            _builder.append("\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_2 = null;
            {
              int _get_3 = counter[0];
              int _plus = (_get_3 + 1);
              counter[0] = _plus;
              _xblockexpression_2 = "";
            }
            _builder.append(_xblockexpression_2, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//POSITION");
            String _xblockexpression_3 = null;
            {
              position++;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _method_1 = this.method(c, false, false, counter, position, false, "objectSelection");
            _builder.append(_method_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();");
        _builder.newLine();
        {
          EList<ReferenceSet> _references = mut.getReferences();
          for(final ReferenceSet c_1 : _references) {
            _builder.append("\t\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_4 = null;
            {
              int _get_3 = counter[0];
              int _plus = (_get_3 + 1);
              counter[0] = _plus;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//EXPRESSION LIST: ");
            List<Integer> expressionList_1 = new ArrayList<Integer>();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//EXPRESSION LEVEL: ");
            boolean _add_1 = expressionList_1.add(Integer.valueOf(0));
            _builder.append(_add_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression_1 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//INDEX EXPRESSION: ");
            int _set_3 = nExpression_1[0] = 0;
            _builder.append(_set_3, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression_1 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_4 = recursionIndexExpression_1[0] = 0;
            _builder.append(_set_4, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            boolean[] evaluation_1 = new boolean[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            String _xblockexpression_5 = null;
            {
              evaluation_1[0] = false;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            CharSequence _method_2 = this.method(c_1, mut, counter, expressionList_1, nExpression_1, recursionIndexExpression_1, false, false, false, evaluation_1);
            _builder.append(_method_2, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("CloneObjectMutator mut = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
        _builder.newLine();
        {
          ObSelectionStrategy _object_25 = mut.getObject();
          if ((_object_25 instanceof SpecificObjectSelection)) {
            {
              ObSelectionStrategy _object_26 = mut.getObject();
              ObjectEmitter _objSel = ((SpecificObjectSelection) _object_26).getObjSel();
              if ((_objSel instanceof SelectObjectMutator)) {
                _builder.append("\t");
                _builder.append("mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), ");
                boolean _isContents = mut.isContents();
                _builder.append(_isContents, "\t");
                _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                ObSelectionStrategy _object_27 = mut.getObject();
                ObjectEmitter _objSel_1 = ((SpecificObjectSelection) _object_27).getObjSel();
                String _name_51 = ((SelectObjectMutator) _objSel_1).getObject().getType().getName();
                _builder.append(_name_51, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              ObSelectionStrategy _object_28 = mut.getObject();
              ObjectEmitter _objSel_2 = ((SpecificObjectSelection) _object_28).getObjSel();
              if ((_objSel_2 instanceof CreateObjectMutator)) {
                _builder.append("\t");
                _builder.append("mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), ");
                boolean _isContents_1 = mut.isContents();
                _builder.append(_isContents_1, "\t");
                _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                ObSelectionStrategy _object_29 = mut.getObject();
                ObjectEmitter _objSel_3 = ((SpecificObjectSelection) _object_29).getObjSel();
                String _name_52 = ((CreateObjectMutator) _objSel_3).getType().getName();
                _builder.append(_name_52, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              ObSelectionStrategy _object_30 = mut.getObject();
              ObjectEmitter _objSel_4 = ((SpecificObjectSelection) _object_30).getObjSel();
              if ((_objSel_4 instanceof CloneObjectMutator)) {
                _builder.append("\t");
                _builder.append("mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), ");
                boolean _isContents_2 = mut.isContents();
                _builder.append(_isContents_2, "\t");
                _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                ObSelectionStrategy _object_31 = mut.getObject();
                ObjectEmitter _objSel_5 = ((SpecificObjectSelection) _object_31).getObjSel();
                String _name_53 = ((CloneObjectMutator) _objSel_5).getObject().getType().getName();
                _builder.append(_name_53, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          ObSelectionStrategy _object_32 = mut.getObject();
          if ((_object_32 instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), ");
            boolean _isContents_3 = mut.isContents();
            _builder.append(_isContents_3, "\t");
            _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
            ObSelectionStrategy _object_33 = mut.getObject();
            String _name_54 = ((RandomTypeSelection) _object_33).getType().getName();
            _builder.append(_name_54, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//INC COUNTER: ");
        int _get_3 = nMutation[0];
        int _plus = (_get_3 + 1);
        int _set_5 = nMutation[0] = _plus;
        _builder.append(_set_5, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t\t\t");
        _builder.append("//INC COUNTER: ");
        int _get_4 = nRegistryMutation[0];
        int _plus_1 = (_get_4 + 1);
        int _set_6 = nRegistryMutation[0] = _plus_1;
        _builder.append(_set_6, "  \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mut.setId(\"m");
        int _get_5 = nMutation[0];
        _builder.append(_get_5, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//END CLONE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
