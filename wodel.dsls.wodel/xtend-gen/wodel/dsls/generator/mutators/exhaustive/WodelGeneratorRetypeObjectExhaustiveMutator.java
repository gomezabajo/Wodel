package wodel.dsls.generator.mutators.exhaustive;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.Block;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.dsls.runner.WodelUtils;

@SuppressWarnings("all")
public class WodelGeneratorRetypeObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof RetypeObjectMutator)) {
        _builder.append("//");
        RetypeObjectMutator mut = ((RetypeObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//RETYPE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("List<String> mutTypes = new ArrayList<String>();");
        _builder.newLine();
        _builder.append("//");
        boolean definedObjects = false;
        _builder.newLineIfNotEmpty();
        {
          ObSelectionStrategy _object = mut.getObject();
          if ((_object instanceof RandomTypeSelection)) {
            _builder.append("//");
            ObSelectionStrategy _object_1 = mut.getObject();
            RandomTypeSelection selection = ((RandomTypeSelection) _object_1);
            _builder.newLineIfNotEmpty();
            {
              if (((selection.getTypes() != null) && (selection.getTypes().size() > 0))) {
                {
                  EList<EClass> _types = selection.getTypes();
                  for(final EClass type : _types) {
                    _builder.append("mutTypes.add(\"");
                    String _name = type.getName();
                    _builder.append(_name);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                EClass _type = selection.getType();
                boolean _tripleNotEquals = (_type != null);
                if (_tripleNotEquals) {
                  _builder.append("mutTypes.add(\"");
                  String _name_1 = selection.getType().getName();
                  _builder.append(_name_1);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            ObSelectionStrategy _object_2 = mut.getObject();
            if ((_object_2 instanceof CompleteTypeSelection)) {
              _builder.append("//");
              ObSelectionStrategy _object_3 = mut.getObject();
              CompleteTypeSelection selection_1 = ((CompleteTypeSelection) _object_3);
              _builder.newLineIfNotEmpty();
              {
                if (((selection_1.getTypes() != null) && (selection_1.getTypes().size() > 0))) {
                  {
                    EList<EClass> _types_1 = selection_1.getTypes();
                    for(final EClass type_1 : _types_1) {
                      _builder.append("mutTypes.add(\"");
                      String _name_2 = type_1.getName();
                      _builder.append(_name_2);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  EClass _type_1 = selection_1.getType();
                  boolean _tripleNotEquals_1 = (_type_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("mutTypes.add(\"");
                    String _name_3 = selection_1.getType().getName();
                    _builder.append(_name_3);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.append("List<String> targetTypes = new ArrayList<String>();");
        _builder.newLine();
        {
          if (((mut.getTypes() != null) && (mut.getTypes().size() > 0))) {
            {
              EList<EClass> _types_2 = mut.getTypes();
              for(final EClass type_2 : _types_2) {
                _builder.append("targetTypes.add(\"");
                String _name_4 = type_2.getName();
                _builder.append(_name_4);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            EClass _type_2 = mut.getType();
            boolean _tripleNotEquals_2 = (_type_2 != null);
            if (_tripleNotEquals_2) {
              _builder.append("targetTypes.add(\"");
              String _name_5 = mut.getType().getName();
              _builder.append(_name_5);
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
        {
          ObSelectionStrategy _object_4 = mut.getObject();
          if ((_object_4 instanceof RandomTypeSelection)) {
            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, mutTypes);");
            _builder.newLine();
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
                _builder.append("//");
                _builder.append(definedObjects = true);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
                _builder.append("//");
                _builder.append(definedObjects = true);
                _builder.newLineIfNotEmpty();
                _builder.append("//EXPRESSION LIST: ");
                List<Integer> expressionList = new ArrayList<Integer>();
                _builder.newLineIfNotEmpty();
                _builder.append("//EXPRESSION LEVEL: ");
                boolean _add = expressionList.add(Integer.valueOf(0));
                _builder.append(_add);
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int[] nExpression = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int _set = nExpression[0] = 0;
                _builder.append(_set);
                _builder.newLineIfNotEmpty();
                _builder.append("//RECURSION INDEX EXPRESSION: ");
                int[] recursionIndexExpression = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//RECURSION INDEX EXPRESSION: ");
                int _set_1 = recursionIndexExpression[0] = 0;
                _builder.append(_set_1);
                _builder.newLineIfNotEmpty();
                _builder.append("Expression exp");
                Integer _get = expressionList.get(0);
                _builder.append(_get);
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                int[] nReference = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                int _set_2 = nReference[0] = 0;
                _builder.append(_set_2);
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
                Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation);
                _builder.append(_method);
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
                {
                  if ((definedObjects == false)) {
                    _builder.append("List<EObject> objects = null;");
                    _builder.newLine();
                    _builder.append("//");
                    _builder.append(definedObjects = true);
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("if (selectedObjects.size() > 0) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("objects = selectedObjects;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("ObSelectionStrategy objectSelection = null; ");
            _builder.newLine();
            _builder.append("if (objects != null && objects.size() > 0) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("objectSelection = new SpecificObjectSelection(packages, models, objects.get(0));");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          } else {
            ObSelectionStrategy _object_5 = mut.getObject();
            if ((_object_5 instanceof CompleteTypeSelection)) {
              _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, mutTypes);");
              _builder.newLine();
              _builder.append("EObject object = rts.getObject();");
              _builder.newLine();
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, models, objects.get(0));");
              _builder.newLine();
            } else {
              ObSelectionStrategy _object_6 = mut.getObject();
              if ((_object_6 instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _object_7 = mut.getObject();
                String _name_6 = ((SpecificObjectSelection) _object_7).getObjSel().getName();
                _builder.append(_name_6);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _object_8 = mut.getObject();
                String _name_7 = ((SpecificObjectSelection) _object_8).getObjSel().getName();
                _builder.append(_name_7);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _object_9 = mut.getObject();
                String _name_8 = ((SpecificObjectSelection) _object_9).getObjSel().getName();
                _builder.append(_name_8);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _object_10 = mut.getObject();
                String _name_9 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                _builder.append(_name_9, "\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _object_11 = mut.getObject();
                String _name_10 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                _builder.append(_name_10, "\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _object_12 = mut.getObject();
                String _name_11 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                _builder.append(_name_11, "\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                ObSelectionStrategy _object_13 = mut.getObject();
                String _name_12 = ((SpecificObjectSelection) _object_13).getObjSel().getName();
                _builder.append(_name_12, "\t");
                _builder.append(" = hmList.get(\"");
                ObSelectionStrategy _object_14 = mut.getObject();
                String _name_13 = ((SpecificObjectSelection) _object_14).getObjSel().getName();
                _builder.append(_name_13, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (listEntry_");
                ObSelectionStrategy _object_15 = mut.getObject();
                String _name_14 = ((SpecificObjectSelection) _object_15).getObjSel().getName();
                _builder.append(_name_14, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                ObSelectionStrategy _object_16 = mut.getObject();
                String _name_15 = ((SpecificObjectSelection) _object_16).getObjSel().getName();
                _builder.append(_name_15, "\t\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("EObject obj = ent.getKey();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("objs.add(obj);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("objectSelection = new SpecificObjectSelection(listEntry_");
                ObSelectionStrategy _object_17 = mut.getObject();
                String _name_16 = ((SpecificObjectSelection) _object_17).getObjSel().getName();
                _builder.append(_name_16, "\t\t");
                _builder.append(".get(0).getValue().getValue(), listEntry_");
                ObSelectionStrategy _object_18 = mut.getObject();
                String _name_17 = ((SpecificObjectSelection) _object_18).getObjSel().getName();
                _builder.append(_name_17, "\t\t");
                _builder.append(".get(0).getValue().getKey(), objs);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              } else {
                ObSelectionStrategy _object_19 = mut.getObject();
                if ((_object_19 instanceof SpecificClosureSelection)) {
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _object_20 = mut.getObject();
                  String _name_18 = ((SpecificClosureSelection) _object_20).getObjSel().getName();
                  _builder.append(_name_18);
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _object_21 = mut.getObject();
                  String _name_19 = ((SpecificClosureSelection) _object_21).getObjSel().getName();
                  _builder.append(_name_19);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("if (entry_");
                  ObSelectionStrategy _object_22 = mut.getObject();
                  String _name_20 = ((SpecificClosureSelection) _object_22).getObjSel().getName();
                  _builder.append(_name_20);
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                  ObSelectionStrategy _object_23 = mut.getObject();
                  String _name_21 = ((SpecificClosureSelection) _object_23).getObjSel().getName();
                  _builder.append(_name_21, "\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _object_24 = mut.getObject();
                  String _name_22 = ((SpecificClosureSelection) _object_24).getObjSel().getName();
                  _builder.append(_name_22, "\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _object_25 = mut.getObject();
                  String _name_23 = ((SpecificClosureSelection) _object_25).getObjSel().getName();
                  _builder.append(_name_23, "\t");
                  _builder.append(".getKey(), \"");
                  ObSelectionStrategy _object_26 = mut.getObject();
                  String _name_24 = ((SpecificClosureSelection) _object_26).getRefType().getName();
                  _builder.append(_name_24, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
        _builder.append("EObject container = null;");
        _builder.newLine();
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        _builder.append("if (objectSelection != null) {");
        _builder.newLine();
        {
          ObSelectionStrategy _container = mut.getContainer();
          boolean _tripleEquals_1 = (_container == null);
          if (_tripleEquals_1) {
            _builder.append("container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());");
            _builder.newLine();
            _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof RandomTypeSelection)) {
                _builder.append("RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_25 = ((RandomTypeSelection) _container_2).getType().getName();
                _builder.append(_name_25);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("container = rtsContainer.getObject();");
                _builder.newLine();
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_3 = mut.getContainer();
              if ((_container_3 instanceof CompleteTypeSelection)) {
                _builder.newLine();
                _builder.append("RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_26 = ((CompleteTypeSelection) _container_4).getType().getName();
                _builder.append(_name_26);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("container = rtsContainer.getObject();");
                _builder.newLine();
                _builder.append("containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_5 = mut.getContainer();
              if ((_container_5 instanceof SpecificObjectSelection)) {
                {
                  EReference _refType = mut.getRefType();
                  boolean _tripleNotEquals_3 = (_refType != null);
                  if (_tripleNotEquals_3) {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _container_6 = mut.getContainer();
                    String _name_27 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                    _builder.append(_name_27);
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _container_7 = mut.getContainer();
                    String _name_28 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                    _builder.append(_name_28);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (entry_");
                    ObSelectionStrategy _container_8 = mut.getContainer();
                    String _name_29 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                    _builder.append(_name_29);
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                    ObSelectionStrategy _container_9 = mut.getContainer();
                    String _name_30 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                    _builder.append(_name_30, "\t");
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_10 = mut.getContainer();
                    String _name_31 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                    _builder.append(_name_31, "\t");
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_11 = mut.getContainer();
                    String _name_32 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                    _builder.append(_name_32, "\t");
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("return numMutantsGenerated;");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_12 = mut.getContainer();
              if ((_container_12 instanceof SpecificClosureSelection)) {
                {
                  EReference _refType_1 = mut.getRefType();
                  boolean _tripleNotEquals_4 = (_refType_1 != null);
                  if (_tripleNotEquals_4) {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _container_13 = mut.getContainer();
                    String _name_33 = ((SpecificClosureSelection) _container_13).getObjSel().getName();
                    _builder.append(_name_33);
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _container_14 = mut.getContainer();
                    String _name_34 = ((SpecificClosureSelection) _container_14).getObjSel().getName();
                    _builder.append(_name_34);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (entry_");
                    ObSelectionStrategy _container_15 = mut.getContainer();
                    String _name_35 = ((SpecificClosureSelection) _container_15).getObjSel().getName();
                    _builder.append(_name_35);
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                    ObSelectionStrategy _container_16 = mut.getContainer();
                    String _name_36 = ((SpecificClosureSelection) _container_16).getObjSel().getName();
                    _builder.append(_name_36, "\t");
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _container_17 = mut.getContainer();
                    String _name_37 = ((SpecificClosureSelection) _container_17).getObjSel().getName();
                    _builder.append(_name_37, "\t");
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _container_18 = mut.getContainer();
                    String _name_38 = ((SpecificClosureSelection) _container_18).getObjSel().getName();
                    _builder.append(_name_38, "\t");
                    _builder.append(".getKey(), \"");
                    ObSelectionStrategy _container_19 = mut.getContainer();
                    String _name_39 = ((SpecificClosureSelection) _container_19).getRefType().getName();
                    _builder.append(_name_39, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("return numMutantsGenerated;");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
        {
          EReference _refType_2 = mut.getRefType();
          boolean _tripleNotEquals_5 = (_refType_2 != null);
          if (_tripleNotEquals_5) {
            _builder.append("SpecificReferenceSelection referenceSelection = null;");
            _builder.newLine();
            {
              ObSelectionStrategy _container_20 = mut.getContainer();
              if ((_container_20 instanceof SpecificObjectSelection)) {
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_21 = mut.getContainer();
                String _name_40 = ((SpecificClosureSelection) _container_21).getObjSel().getName();
                _builder.append(_name_40);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_22 = mut.getContainer();
                String _name_41 = ((SpecificClosureSelection) _container_22).getObjSel().getName();
                _builder.append(_name_41);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_23 = mut.getContainer();
                String _name_42 = ((SpecificClosureSelection) _container_23).getObjSel().getName();
                _builder.append(_name_42, "\t\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                ObSelectionStrategy _container_24 = mut.getContainer();
                String _name_43 = ((SpecificClosureSelection) _container_24).getObjSel().getName();
                _builder.append(_name_43);
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_25 = mut.getContainer();
                String _name_44 = ((SpecificClosureSelection) _container_25).getObjSel().getName();
                _builder.append(_name_44);
                _builder.append(".getValue().getKey(), \"");
                String _name_45 = mut.getRefType().getName();
                _builder.append(_name_45);
                _builder.append("\", entry_");
                ObSelectionStrategy _container_26 = mut.getContainer();
                String _name_46 = ((SpecificClosureSelection) _container_26).getObjSel().getName();
                _builder.append(_name_46);
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                ObSelectionStrategy _container_27 = mut.getContainer();
                if ((_container_27 instanceof SpecificClosureSelection)) {
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _container_28 = mut.getContainer();
                  String _name_47 = ((SpecificClosureSelection) _container_28).getObjSel().getName();
                  _builder.append(_name_47);
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _container_29 = mut.getContainer();
                  String _name_48 = ((SpecificClosureSelection) _container_29).getObjSel().getName();
                  _builder.append(_name_48);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("if (entry_");
                  ObSelectionStrategy _container_30 = mut.getContainer();
                  String _name_49 = ((SpecificClosureSelection) _container_30).getObjSel().getName();
                  _builder.append(_name_49);
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                  ObSelectionStrategy _container_31 = mut.getContainer();
                  String _name_50 = ((SpecificClosureSelection) _container_31).getObjSel().getName();
                  _builder.append(_name_50, "\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _container_32 = mut.getContainer();
                  String _name_51 = ((SpecificClosureSelection) _container_32).getObjSel().getName();
                  _builder.append(_name_51, "\t");
                  _builder.append(".getValue().getKey(), \"");
                  String _name_52 = mut.getRefType().getName();
                  _builder.append(_name_52, "\t");
                  _builder.append("\", entry_");
                  ObSelectionStrategy _container_33 = mut.getContainer();
                  String _name_53 = ((SpecificClosureSelection) _container_33).getObjSel().getName();
                  _builder.append(_name_53, "\t");
                  _builder.append(".getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("SpecificReferenceSelection referenceSelection = null;");
                  _builder.newLine();
                  _builder.append("if (containerSelection != null) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                  String _name_54 = mut.getRefType().getName();
                  _builder.append(_name_54, "\t");
                  _builder.append("\", containerSelection);");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            _builder.append("SpecificReferenceSelection referenceSelection = null;");
            _builder.newLine();
            _builder.append("if (containerSelection != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          ObSelectionStrategy _container_34 = mut.getContainer();
          boolean _tripleEquals_2 = (_container_34 == null);
          if (_tripleEquals_2) {
            {
              ObSelectionStrategy _object_27 = mut.getObject();
              if ((_object_27 instanceof SpecificObjectSelection)) {
                _builder.append("\t\t");
                _builder.append("List<EObject> objects =  null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("if (objectSelection != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("objects = objectSelection.getObjects();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("if (objects == null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("objects = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("objects.add(objectSelection.getObject());");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("if (objects == null || objects.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("return numMutantsGenerated;");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t");
            _builder.append("Resource model = MutatorUtils.currentModel(models);");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("if (model == null) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("return numMutantsGenerated;");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("String tempModel =");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
            _builder.append("WodelTempModelContext.nextModelPath(");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\"");
            _builder.append(methodName, "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t    ");
            _builder.append("for (int obn = 0; obn < objects.size(); obn++) {");
            _builder.newLine();
            _builder.append("\t\t    \t");
            _builder.append("for (String targetType : targetTypes) {");
            _builder.newLine();
            _builder.append("\t\t    \t\t");
            _builder.append("List<String> tTypes = new ArrayList<String>();");
            _builder.newLine();
            _builder.append("\t\t    \t\t");
            _builder.append("tTypes.add(targetType);");
            _builder.newLine();
            _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("Resource m = owned.own(");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t\t\t\t\t                    ");
            _builder.append("ModelManager.cloneModel(");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("tempModel));");
            _builder.newLine();
            _builder.append("    \t\t");
            _builder.append("models.add(m);");
            _builder.newLine();
            _builder.append("    \t\t");
            _builder.append("try {");
            _builder.newLine();
            {
              if (((mut.getObject() instanceof SpecificObjectSelection) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("\t\t\t");
                _builder.append("List<EObject> mObjects = ModelManager.getObjects(m, objects);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_28 = mut.getObject();
              if ((_object_28 instanceof RandomTypeSelection)) {
                _builder.append("\t\t\t");
                _builder.append("rts = new RandomTypeSelection(packages, m, mutTypes);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("List<EObject> mObjects = rts.getObjects();");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_29 = mut.getObject();
              if ((_object_29 instanceof CompleteTypeSelection)) {
                _builder.append("\t\t\t");
                _builder.append("cts = new RandomTypeSelection(packages, m, mutTypes);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("List<EObject> mObjects = cts.getObjects();");
                _builder.newLine();
              }
            }
            {
              if (((mut.getObject() instanceof SpecificObjectSelection) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("\t\t\t\t");
                _builder.append("ObSelectionStrategy obSelection = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("EObject localObject = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("localObject = ModelManager.getObject(m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (localObject == null) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("obSelection = new SpecificObjectSelection(packages, m, localObject);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_30 = mut.getObject();
              if ((_object_30 instanceof RandomTypeSelection)) {
                _builder.append("\t\t\t\t");
                _builder.append("ObSelectionStrategy obSelection = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("EObject localObject = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("localObject = ModelManager.getObject(m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (localObject == null) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("obSelection = new SpecificObjectSelection(packages, m, localObject);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_31 = mut.getObject();
              if ((_object_31 instanceof CompleteTypeSelection)) {
                _builder.append("\t\t\t\t");
                _builder.append("ObSelectionStrategy obSelection = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("EObject localObject = null;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("localObject = ModelManager.getObject(m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("if (localObject == null) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("obSelection = new SpecificObjectSelection(packages, m, localObject);");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("EObject c = ModelManager.getContainer(m, obSelection.getObject());");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("ObSelectionStrategy cSelection = new SpecificObjectSelection(packages, m, c);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("SpecificReferenceSelection rSelection = new SpecificReferenceSelection(packages, m, null, null);");
            _builder.newLine();
          }
        }
        _builder.append("Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();");
        _builder.newLine();
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER:");
        String _xblockexpression_1 = null;
        {
          counter[0] = 0;
          _xblockexpression_1 = "";
        }
        _builder.append(_xblockexpression_1);
        _builder.newLineIfNotEmpty();
        _builder.append("//POSITION:");
        int position = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeSet> _attributes = mut.getAttributes();
          for(final AttributeSet c : _attributes) {
            _builder.append("//COUNTER:");
            String _xblockexpression_2 = null;
            {
              int _get_3 = counter[0];
              int _plus = (_get_3 + 1);
              counter[0] = _plus;
              _xblockexpression_2 = "";
            }
            _builder.append(_xblockexpression_2);
            _builder.newLineIfNotEmpty();
            _builder.append("//POSITION");
            String _xblockexpression_3 = null;
            {
              position++;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3);
            _builder.newLineIfNotEmpty();
            CharSequence _method_1 = this.method(c, false, false, counter, position, true, "obSelection");
            _builder.append(_method_1);
            _builder.newLineIfNotEmpty();
          }
        }
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
            _builder.append("\t");
            CharSequence _method_2 = this.method(c_1, mut, counter, expressionList_1, nExpression_1, recursionIndexExpression_1, true, false, true, evaluation_1);
            _builder.append(_method_2, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          ObSelectionStrategy _container_35 = mut.getContainer();
          boolean _tripleNotEquals_6 = (_container_35 != null);
          if (_tripleNotEquals_6) {
            {
              if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("RetypeObjectMutator mut = new RetypeObjectMutator(model, packages, objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, tTypes);");
                _builder.newLine();
              }
            }
          }
        }
        {
          ObSelectionStrategy _container_36 = mut.getContainer();
          boolean _tripleEquals_3 = (_container_36 == null);
          if (_tripleEquals_3) {
            {
              if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("RetypeObjectMutator mut = new RetypeObjectMutator(m, packages, obSelection.getObject(), rSelection, cSelection, atts, refs, tTypes);");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("Mutator mutator = null;");
        _builder.newLine();
        _builder.append("if (muts == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("//COUNTER: ");
        int _get_3 = nRegistryMutation[0];
        int _plus = (_get_3 + 1);
        int _set_5 = nRegistryMutation[0] = _plus;
        _builder.append(_set_5);
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER: ");
        int _get_4 = nRegistryMethodCall[0];
        int _plus_1 = (_get_4 + 1);
        int _set_6 = nRegistryMethodCall[0] = _plus_1;
        _builder.append(_set_6);
        _builder.newLineIfNotEmpty();
        _builder.append("//REGISTRY METHOD NAME:");
        String _string = Integer.valueOf((nRegistryMethodCall[0])).toString();
        String registryMethodName = ("registry" + _string);
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t");
        _builder.append("int mutsMark = mutationMark(muts);");
        _builder.newLine();
        {
          if ((executeMutation == true)) {
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("* IMPORTANT:");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("* Capture the removed EObject from the PRE-MUTATION");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("* source model. Do not use mut.getObject() here:");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("* RemoveObjectMutator only populates that information");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("* during mutate().");
            _builder.newLine();
            _builder.append("\t     ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t    ");
            _builder.append("EObject clue =");
            _builder.newLine();
            _builder.append("\t        ");
            _builder.append("findEObjectForRegistry(");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("seed,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("objectSelection.getObject(),");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("mutPaths,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("packages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (mutated != null) {");
            _builder.newLine();
            {
              String _name_55 = mut.getName();
              boolean _tripleNotEquals_7 = (_name_55 != null);
              if (_tripleNotEquals_7) {
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                _builder.newLine();
                {
                  ObSelectionStrategy _object_32 = mut.getObject();
                  boolean _not = (!(_object_32 instanceof CompleteTypeSelection));
                  if (_not) {
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.put(\"");
                    String _name_56 = mut.getName();
                    _builder.append(_name_56, "\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.remove(\"");
                    String _name_57 = mut.getName();
                    _builder.append(_name_57, "\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("hmList.put(\"");
                    String _name_58 = mut.getName();
                    _builder.append(_name_58, "\t\t\t");
                    _builder.append("\", entries);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("AppMutation appMut = ");
            _builder.append(registryMethodName, "\t\t\t");
            _builder.append("(mut, hmMutator, seed, model, clue, mutPaths, packages);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("if (appMut != null) {");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("muts.getMuts().add(appMut);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("mutator = mut;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (mutator != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//COUNTER: ");
        int _get_5 = nMethodCall[0];
        int _plus_2 = (_get_5 + 1);
        int _set_7 = nMethodCall[0] = _plus_2;
        _builder.append(_set_7, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("//MUTATION METHOD NAME:");
        String _string_1 = Integer.valueOf((nMethodCall[0])).toString();
        String nMethodName = ("mutation" + _string_1);
        _builder.newLineIfNotEmpty();
        {
          if ((last == false)) {
            {
              if ((standalone == false)) {
                {
                  ObSelectionStrategy _container_37 = mut.getContainer();
                  boolean _tripleNotEquals_8 = (_container_37 != null);
                  if (_tripleNotEquals_8) {
                    {
                      if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                        _builder.append(nMethodName);
                        _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  ObSelectionStrategy _container_38 = mut.getContainer();
                  boolean _tripleEquals_4 = (_container_38 == null);
                  if (_tripleEquals_4) {
                    {
                      if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                        _builder.append(nMethodName);
                        _builder.append("(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  }
                }
              } else {
                {
                  ObSelectionStrategy _container_39 = mut.getContainer();
                  boolean _tripleNotEquals_9 = (_container_39 != null);
                  if (_tripleNotEquals_9) {
                    {
                      if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                        _builder.append(nMethodName);
                        _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _container_40 = mut.getContainer();
                  boolean _tripleEquals_5 = (_container_40 == null);
                  if (_tripleEquals_5) {
                    {
                      if (((((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection)) || (mut.getObject() instanceof SpecificObjectSelection)) || (mut.getObject() instanceof SpecificClosureSelection))) {
                        _builder.append(nMethodName);
                        _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t");
                _builder.append("numMutantsGenerated = k[0];");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("models.remove(m);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          if ((last == true)) {
            _builder.append("\t\t");
            _builder.append("// MUTANT COMPLETION AND REGISTRY");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
            _builder.newLine();
            {
              EList<Constraint> _constraints = e.getConstraints();
              for(final Constraint constraint : _constraints) {
                _builder.append("\t\t");
                _builder.append("if (rules.get(\"");
                String _name_59 = constraint.getType().getName();
                _builder.append(_name_59, "\t\t");
                _builder.append("\") == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("rules.put(\"");
                String _name_60 = constraint.getType().getName();
                _builder.append(_name_60, "\t\t\t");
                _builder.append("\", new ArrayList<String>());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("List<String> newrules = rules.get(\"");
                String _name_61 = constraint.getType().getName();
                _builder.append(_name_61, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InvariantCS> _expressions = constraint.getExpressions();
                  boolean _tripleNotEquals_10 = (_expressions != null);
                  if (_tripleNotEquals_10) {
                    {
                      EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                      for(final InvariantCS expression : _expressions_1) {
                        _builder.append("\t\t");
                        _builder.append("newrules.add(\"");
                        String _constraintText = WodelUtils.getConstraintText(fileURI.lastSegment(), expression);
                        _builder.append(_constraintText, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  EList<String> _rules = constraint.getRules();
                  boolean _tripleNotEquals_11 = (_rules != null);
                  if (_tripleNotEquals_11) {
                    {
                      EList<String> _rules_1 = constraint.getRules();
                      for(final String rule : _rules_1) {
                        _builder.append("\t\t");
                        _builder.append("newrules.add(\"");
                        _builder.append(rule, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("rules.put(\"");
                String _name_62 = constraint.getType().getName();
                _builder.append(_name_62, "\t\t");
                _builder.append("\", newrules);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((b == null)) {
                _builder.append("\t\t");
                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                _builder.newLine();
              } else {
                {
                  int _size = b.getFrom().size();
                  boolean _equals = (_size == 0);
                  if (_equals) {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_63 = b.getName();
                    _builder.append(_name_63);
                    _builder.append("/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_64 = b.getName();
                    _builder.append(_name_64);
                    _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
            _builder.newLine();
            {
              if ((b == null)) {
                {
                  if ((standalone == false)) {
                    _builder.append("   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);");
                    _builder.newLine();
                  } else {
                    _builder.append("   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_65 = project.getName();
                    _builder.append(_name_65, "   \t\t\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "   \t\t\t");
                    _builder.append(".class, true);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_66 = b.getName();
                    _builder.append(_name_66);
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_67 = b.getName();
                    _builder.append(_name_67, "\t");
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_68 = project.getName();
                    _builder.append(_name_68, "\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t");
                    _builder.append(".class, true, false);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("if (isRepeated == false) {");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("numMutantsGenerated++;");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("monitor.worked(1);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("k[0] = k[0] + 1;");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("//if (muts != null) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("//\tmuts.getMuts().clear();");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("//}");
            _builder.newLine();
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t        ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t            ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t    ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(m);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            {
              ObSelectionStrategy _container_41 = mut.getContainer();
              boolean _tripleEquals_6 = (_container_41 == null);
              if (_tripleEquals_6) {
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("//END RETYPE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
