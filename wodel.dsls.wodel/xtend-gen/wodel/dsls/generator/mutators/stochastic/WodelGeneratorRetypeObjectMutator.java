package wodel.dsls.generator.mutators.stochastic;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorRetypeObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RetypeObjectMutator)) {
        _builder.append("//");
        RetypeObjectMutator mut = ((RetypeObjectMutator) mt);
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
        _builder.newLine();
        _builder.append("//RETYPE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("List<String> mutTypes = new ArrayList<String>();");
        _builder.newLine();
        {
          ObSelectionStrategy _object = mut.getObject();
          if ((_object instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("//");
            ObSelectionStrategy _object_1 = mut.getObject();
            RandomTypeSelection selection = ((RandomTypeSelection) _object_1);
            _builder.newLineIfNotEmpty();
            {
              if (((selection.getTypes() != null) && (selection.getTypes().size() > 0))) {
                {
                  EList<EClass> _types = selection.getTypes();
                  for(final EClass type : _types) {
                    _builder.append("\t");
                    _builder.append("mutTypes.add(\"");
                    String _name = type.getName();
                    _builder.append(_name, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                EClass _type = selection.getType();
                boolean _tripleNotEquals = (_type != null);
                if (_tripleNotEquals) {
                  _builder.append("\t");
                  _builder.append("mutTypes.add(\"");
                  String _name_1 = selection.getType().getName();
                  _builder.append(_name_1, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            ObSelectionStrategy _object_2 = mut.getObject();
            if ((_object_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("//");
              ObSelectionStrategy _object_3 = mut.getObject();
              CompleteTypeSelection selection_1 = ((CompleteTypeSelection) _object_3);
              _builder.newLineIfNotEmpty();
              {
                if (((selection_1.getTypes() != null) && (selection_1.getTypes().size() > 0))) {
                  {
                    EList<EClass> _types_1 = selection_1.getTypes();
                    for(final EClass type_1 : _types_1) {
                      _builder.append("\t");
                      _builder.append("mutTypes.add(\"");
                      String _name_2 = type_1.getName();
                      _builder.append(_name_2, "\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  EClass _type_1 = selection_1.getType();
                  boolean _tripleNotEquals_1 = (_type_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t");
                    _builder.append("mutTypes.add(\"");
                    String _name_3 = selection_1.getType().getName();
                    _builder.append(_name_3, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("List<String> targetTypes = new ArrayList<String>();");
        _builder.newLine();
        {
          if (((mut.getTypes() != null) && (mut.getTypes().size() > 0))) {
            {
              EList<EClass> _types_2 = mut.getTypes();
              for(final EClass type_2 : _types_2) {
                _builder.append("\t");
                _builder.append("targetTypes.add(\"");
                String _name_4 = type_2.getName();
                _builder.append(_name_4, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            EClass _type_2 = mut.getType();
            boolean _tripleNotEquals_2 = (_type_2 != null);
            if (_tripleNotEquals_2) {
              _builder.append("\t");
              _builder.append("targetTypes.add(\"");
              String _name_5 = mut.getType().getName();
              _builder.append(_name_5, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
        {
          ObSelectionStrategy _object_4 = mut.getObject();
          if ((_object_4 instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);");
            _builder.newLine();
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("\t");
                _builder.append("EObject object = rts.getObject();");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("//EXPRESSION LIST: ");
                List<Integer> expressionList = new ArrayList<Integer>();
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//EXPRESSION LIST: ");
                boolean _add = expressionList.add(Integer.valueOf(0));
                _builder.append(_add, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int[] nExpression = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int _set = nExpression[0] = 0;
                _builder.append(_set, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("Expression exp");
                Integer _get = expressionList.get(0);
                _builder.append(_get, "\t");
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//REFERENCE LIST: ");
                int[] nReference = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_1 = nReference[0] = 0;
                _builder.append(_set_1, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//RECURSION EXPRESSION LIST: ");
                int[] recursionIndexExpression = new int[1];
                _builder.append("»");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_2 = recursionIndexExpression[0] = 0;
                _builder.append(_set_2, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//");
                boolean[] evaluation = new boolean[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//");
                String _xblockexpression = null;
                {
                  evaluation[0] = false;
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression, "\t");
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
                _builder.append("\t");
                _builder.append("EObject object = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (selectedObjects.size() > 0) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                _builder.newLine();
                _builder.append("\t");
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
            ObSelectionStrategy _object_5 = mut.getObject();
            if ((_object_5 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("EObject object = rts.getObject();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
              _builder.newLine();
            } else {
              ObSelectionStrategy _object_6 = mut.getObject();
              if ((_object_6 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container = mut.getContainer();
                String _name_6 = ((SpecificObjectSelection) _container).getObjSel().getName();
                _builder.append(_name_6, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_1 = mut.getContainer();
                String _name_7 = ((SpecificObjectSelection) _container_1).getObjSel().getName();
                _builder.append(_name_7, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_8 = ((SpecificObjectSelection) _container_2).getObjSel().getName();
                _builder.append(_name_8, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _container_3 = mut.getContainer();
                String _name_9 = ((SpecificObjectSelection) _container_3).getObjSel().getName();
                _builder.append(_name_9, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_10 = ((SpecificObjectSelection) _container_4).getObjSel().getName();
                _builder.append(_name_10, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _container_5 = mut.getContainer();
                String _name_11 = ((SpecificObjectSelection) _container_5).getObjSel().getName();
                _builder.append(_name_11, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                ObSelectionStrategy _container_6 = mut.getContainer();
                String _name_12 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                _builder.append(_name_12, "\t\t");
                _builder.append(" = hmList.get(\"");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_13 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_13, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (listEntry_");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_14 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_14, "\t\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                ObSelectionStrategy _container_9 = mut.getContainer();
                String _name_15 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                _builder.append(_name_15, "\t\t\t");
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
                ObSelectionStrategy _container_10 = mut.getContainer();
                String _name_16 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                _builder.append(_name_16, "\t\t\t");
                _builder.append(".get(0).getValue().getValue(), listEntry_");
                ObSelectionStrategy _container_11 = mut.getContainer();
                String _name_17 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                _builder.append(_name_17, "\t\t\t");
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
                ObSelectionStrategy _object_7 = mut.getObject();
                if ((_object_7 instanceof SpecificClosureSelection)) {
                  _builder.append("\t");
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _container_12 = mut.getContainer();
                  String _name_18 = ((SpecificClosureSelection) _container_12).getObjSel().getName();
                  _builder.append(_name_18, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _container_13 = mut.getContainer();
                  String _name_19 = ((SpecificClosureSelection) _container_13).getObjSel().getName();
                  _builder.append(_name_19, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _container_14 = mut.getContainer();
                  String _name_20 = ((SpecificClosureSelection) _container_14).getObjSel().getName();
                  _builder.append(_name_20, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                  ObSelectionStrategy _container_15 = mut.getContainer();
                  String _name_21 = ((SpecificClosureSelection) _container_15).getObjSel().getName();
                  _builder.append(_name_21, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _container_16 = mut.getContainer();
                  String _name_22 = ((SpecificClosureSelection) _container_16).getObjSel().getName();
                  _builder.append(_name_22, "\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _container_17 = mut.getContainer();
                  String _name_23 = ((SpecificClosureSelection) _container_17).getObjSel().getName();
                  _builder.append(_name_23, "\t\t");
                  _builder.append(".getKey(), \"");
                  ObSelectionStrategy _object_8 = mut.getObject();
                  String _name_24 = ((SpecificClosureSelection) _object_8).getRefType().getName();
                  _builder.append(_name_24, "\t\t");
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
          ObSelectionStrategy _container_18 = mut.getContainer();
          boolean _tripleEquals_1 = (_container_18 == null);
          if (_tripleEquals_1) {
            _builder.append("\t");
            _builder.append("container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_19 = mut.getContainer();
              if ((_container_19 instanceof RandomTypeSelection)) {
                _builder.append("\t");
                _builder.append("RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_20 = mut.getContainer();
                String _name_25 = ((RandomTypeSelection) _container_20).getType().getName();
                _builder.append(_name_25, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("container = rtsContainer.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_21 = mut.getContainer();
              if ((_container_21 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_22 = mut.getContainer();
                String _name_26 = ((CompleteTypeSelection) _container_22).getType().getName();
                _builder.append(_name_26, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("container = rtsContainer.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_23 = mut.getContainer();
              if ((_container_23 instanceof SpecificObjectSelection)) {
                {
                  EReference _refType = mut.getRefType();
                  boolean _tripleNotEquals_3 = (_refType != null);
                  if (_tripleNotEquals_3) {
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _container_24 = mut.getContainer();
                    String _name_27 = ((SpecificObjectSelection) _container_24).getObjSel().getName();
                    _builder.append(_name_27, "\t");
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _container_25 = mut.getContainer();
                    String _name_28 = ((SpecificObjectSelection) _container_25).getObjSel().getName();
                    _builder.append(_name_28, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("if (entry_");
                    ObSelectionStrategy _container_26 = mut.getContainer();
                    String _name_29 = ((SpecificObjectSelection) _container_26).getObjSel().getName();
                    _builder.append(_name_29, "\t");
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                    ObSelectionStrategy _container_27 = mut.getContainer();
                    String _name_30 = ((SpecificObjectSelection) _container_27).getObjSel().getName();
                    _builder.append(_name_30, "\t\t");
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_28 = mut.getContainer();
                    String _name_31 = ((SpecificObjectSelection) _container_28).getObjSel().getName();
                    _builder.append(_name_31, "\t\t");
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_29 = mut.getContainer();
                    String _name_32 = ((SpecificObjectSelection) _container_29).getObjSel().getName();
                    _builder.append(_name_32, "\t\t");
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
              }
            }
            {
              ObSelectionStrategy _container_30 = mut.getContainer();
              if ((_container_30 instanceof SpecificClosureSelection)) {
                {
                  EReference _refType_1 = mut.getRefType();
                  boolean _tripleNotEquals_4 = (_refType_1 != null);
                  if (_tripleNotEquals_4) {
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _container_31 = mut.getContainer();
                    String _name_33 = ((SpecificClosureSelection) _container_31).getObjSel().getName();
                    _builder.append(_name_33, "\t");
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _container_32 = mut.getContainer();
                    String _name_34 = ((SpecificClosureSelection) _container_32).getObjSel().getName();
                    _builder.append(_name_34, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("if (entry_");
                    ObSelectionStrategy _container_33 = mut.getContainer();
                    String _name_35 = ((SpecificClosureSelection) _container_33).getObjSel().getName();
                    _builder.append(_name_35, "\t");
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                    ObSelectionStrategy _container_34 = mut.getContainer();
                    String _name_36 = ((SpecificClosureSelection) _container_34).getObjSel().getName();
                    _builder.append(_name_36, "\t\t");
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_35 = mut.getContainer();
                    String _name_37 = ((SpecificClosureSelection) _container_35).getObjSel().getName();
                    _builder.append(_name_37, "\t\t");
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_36 = mut.getContainer();
                    String _name_38 = ((SpecificClosureSelection) _container_36).getObjSel().getName();
                    _builder.append(_name_38, "\t\t");
                    _builder.append(".getKey(), \"");
                    ObSelectionStrategy _container_37 = mut.getContainer();
                    String _name_39 = ((SpecificClosureSelection) _container_37).getRefType().getName();
                    _builder.append(_name_39, "\t\t");
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
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          EReference _refType_2 = mut.getRefType();
          boolean _tripleNotEquals_5 = (_refType_2 != null);
          if (_tripleNotEquals_5) {
            _builder.append("\t");
            _builder.append("SpecificReferenceSelection referenceSelection = null;");
            _builder.newLine();
            {
              ObSelectionStrategy _container_38 = mut.getContainer();
              if ((_container_38 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_39 = mut.getContainer();
                String _name_40 = ((SpecificClosureSelection) _container_39).getObjSel().getName();
                _builder.append(_name_40, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_40 = mut.getContainer();
                String _name_41 = ((SpecificClosureSelection) _container_40).getObjSel().getName();
                _builder.append(_name_41, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_41 = mut.getContainer();
                String _name_42 = ((SpecificClosureSelection) _container_41).getObjSel().getName();
                _builder.append(_name_42, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                ObSelectionStrategy _container_42 = mut.getContainer();
                String _name_43 = ((SpecificClosureSelection) _container_42).getObjSel().getName();
                _builder.append(_name_43, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_43 = mut.getContainer();
                String _name_44 = ((SpecificClosureSelection) _container_43).getObjSel().getName();
                _builder.append(_name_44, "\t\t");
                _builder.append(".getValue().getKey(), \"");
                String _name_45 = mut.getRefType().getName();
                _builder.append(_name_45, "\t\t");
                _builder.append("\", entry_");
                ObSelectionStrategy _container_44 = mut.getContainer();
                String _name_46 = ((SpecificClosureSelection) _container_44).getObjSel().getName();
                _builder.append(_name_46, "\t\t");
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
                ObSelectionStrategy _container_45 = mut.getContainer();
                if ((_container_45 instanceof SpecificClosureSelection)) {
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _container_46 = mut.getContainer();
                  String _name_47 = ((SpecificClosureSelection) _container_46).getObjSel().getName();
                  _builder.append(_name_47, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _container_47 = mut.getContainer();
                  String _name_48 = ((SpecificClosureSelection) _container_47).getObjSel().getName();
                  _builder.append(_name_48, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _container_48 = mut.getContainer();
                  String _name_49 = ((SpecificClosureSelection) _container_48).getObjSel().getName();
                  _builder.append(_name_49, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                  ObSelectionStrategy _container_49 = mut.getContainer();
                  String _name_50 = ((SpecificClosureSelection) _container_49).getObjSel().getName();
                  _builder.append(_name_50, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _container_50 = mut.getContainer();
                  String _name_51 = ((SpecificClosureSelection) _container_50).getObjSel().getName();
                  _builder.append(_name_51, "\t\t");
                  _builder.append(".getValue().getKey(), \"");
                  String _name_52 = mut.getRefType().getName();
                  _builder.append(_name_52, "\t\t");
                  _builder.append("\", entry_");
                  ObSelectionStrategy _container_51 = mut.getContainer();
                  String _name_53 = ((SpecificClosureSelection) _container_51).getObjSel().getName();
                  _builder.append(_name_53, "\t\t");
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
                  String _name_54 = mut.getRefType().getName();
                  _builder.append(_name_54, "\t\t");
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
            _builder.append("\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_4 = null;
            {
              int _get_3 = counter[0];
              int _plus = (_get_3 + 1);
              counter[0] = _plus;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LIST: ");
            List<Integer> expressionList_1 = new ArrayList<Integer>();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LEVEL: ");
            boolean _add_1 = expressionList_1.add(Integer.valueOf(0));
            _builder.append(_add_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression_1 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int _set_3 = nExpression_1[0] = 0;
            _builder.append(_set_3, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression_1 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_4 = recursionIndexExpression_1[0] = 0;
            _builder.append(_set_4, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//");
            boolean[] evaluation_1 = new boolean[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//");
            String _xblockexpression_5 = null;
            {
              evaluation_1[0] = false;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _method_2 = this.method(c_1, mut, counter, expressionList_1, nExpression_1, recursionIndexExpression_1, false, false, false, evaluation_1);
            _builder.append(_method_2, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("RetypeObjectMutator mut = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mut = new RetypeObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, targetTypes);");
        _builder.newLine();
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
        _builder.append("//END RETYPE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
