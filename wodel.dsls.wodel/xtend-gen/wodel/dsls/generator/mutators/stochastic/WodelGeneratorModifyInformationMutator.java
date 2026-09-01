package wodel.dsls.generator.mutators.stochastic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mutatorenvironment.ArithmeticOperator;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeType;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Expression;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.NullTypeSelection;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomDoubleNumberType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerNumberType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceAdd;
import mutatorenvironment.ReferenceAtt;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.ReferenceUnset;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.utils.manager.MutatorUtils;

@SuppressWarnings("all")
public class WodelGeneratorModifyInformationMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof ModifyInformationMutator)) {
        _builder.append("//");
        ModifyInformationMutator mut = ((ModifyInformationMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("//MODIFY INFORMATION ");
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
          ObSelectionStrategy _object = mut.getObject();
          if ((_object instanceof RandomTypeSelection)) {
            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
            ObSelectionStrategy _object_1 = mut.getObject();
            String _name = ((RandomTypeSelection) _object_1).getType().getName();
            _builder.append(_name);
            _builder.append("\", mutatedObjects);");
            _builder.newLineIfNotEmpty();
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("EObject object = rts.getObject();");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("//EXPRESSION LIST: ");
                List<Integer> expressionList = new ArrayList<Integer>();
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//EXPRESSION LIST: ");
                boolean _add = expressionList.add(Integer.valueOf(0));
                _builder.append(_add, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int[] nExpression = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//EXPRESSION LEVEL: ");
                int _set = nExpression[0] = 0;
                _builder.append(_set, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("Expression exp");
                Integer _get = expressionList.get(0);
                _builder.append(_get, "\t\t");
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//REFERENCE LIST: ");
                int[] nReference = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_1 = nReference[0] = 0;
                _builder.append(_set_1, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//RECURSION EXPRESSION LIST: ");
                int[] recursionIndexExpression = new int[1];
                _builder.append("»");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("//REFERENCE LIST: ");
                int _set_2 = recursionIndexExpression[0] = 0;
                _builder.append(_set_2, "\t\t");
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
                _builder.append("\t\t");
                Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation);
                _builder.append(_method, "\t\t");
                _builder.newLineIfNotEmpty();
                {
                  boolean _get_1 = evaluation[0];
                  if (_get_1) {
                    _builder.append("\t\t");
                    _builder.append("List<EObject> selectedObjects = auxObjects;");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                    Integer _get_2 = expressionList.get(0);
                    _builder.append(_get_2, "\t\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("EObject object = null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("if (selectedObjects.size() > 0) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("ObSelectionStrategy objectSelection = null;");
            _builder.newLine();
            {
              EReference _refType = mut.getObject().getRefType();
              boolean _tripleNotEquals = (_refType != null);
              if (_tripleNotEquals) {
                _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                String _name_1 = mut.getObject().getRefType().getName();
                _builder.append(_name_1);
                _builder.append("\", object);");
                _builder.newLineIfNotEmpty();
                _builder.append("object = o.get(ModelManager.getRandomIndex(o));");
                _builder.newLine();
              }
            }
            _builder.append("if (object != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          } else {
            ObSelectionStrategy _object_2 = mut.getObject();
            if ((_object_2 instanceof CompleteTypeSelection)) {
              _builder.append("CompleteTypeSelection cts = new CompleteTypeSelection(packages, model, \"");
              ObSelectionStrategy _object_3 = mut.getObject();
              String _name_2 = ((CompleteTypeSelection) _object_3).getType().getName();
              _builder.append(_name_2);
              _builder.append("\", mutatedObjects);");
              _builder.newLineIfNotEmpty();
              _builder.append("List<EObject> objects = cts.getObjects();");
              _builder.newLine();
              {
                Expression _expression_1 = mut.getObject().getExpression();
                boolean _tripleNotEquals_1 = (_expression_1 != null);
                if (_tripleNotEquals_1) {
                  _builder.append("//EXPRESSION LIST: ");
                  List<Integer> expressionList_1 = new ArrayList<Integer>();
                  _builder.newLineIfNotEmpty();
                  _builder.append("//EXPRESSION LIST: ");
                  boolean _add_1 = expressionList_1.add(Integer.valueOf(0));
                  _builder.append(_add_1);
                  _builder.newLineIfNotEmpty();
                  _builder.append("//EXPRESSION LEVEL: ");
                  int[] nExpression_1 = new int[1];
                  _builder.newLineIfNotEmpty();
                  _builder.append("//EXPRESSION LEVEL: ");
                  int _set_3 = nExpression_1[0] = 0;
                  _builder.append(_set_3);
                  _builder.newLineIfNotEmpty();
                  _builder.append("Expression exp");
                  Integer _get_3 = expressionList_1.get(0);
                  _builder.append(_get_3);
                  _builder.append(" = new Expression();");
                  _builder.newLineIfNotEmpty();
                  _builder.append("//REFERENCE LIST: ");
                  int[] nReference_1 = new int[1];
                  _builder.newLineIfNotEmpty();
                  _builder.append("//REFERENCE LIST: ");
                  int _set_4 = nReference_1[0] = 0;
                  _builder.append(_set_4);
                  _builder.newLineIfNotEmpty();
                  _builder.append("//RECURSION EXPRESSION LIST: ");
                  int[] recursionIndexExpression_1 = new int[1];
                  _builder.append("»");
                  _builder.newLineIfNotEmpty();
                  _builder.append("//REFERENCE LIST: ");
                  int _set_5 = recursionIndexExpression_1[0] = 0;
                  _builder.append(_set_5);
                  _builder.newLineIfNotEmpty();
                  _builder.append("//");
                  boolean[] evaluation_1 = new boolean[1];
                  _builder.newLineIfNotEmpty();
                  _builder.append("//");
                  String _xblockexpression_1 = null;
                  {
                    evaluation_1[0] = false;
                    _xblockexpression_1 = "";
                  }
                  _builder.append(_xblockexpression_1);
                  _builder.newLineIfNotEmpty();
                  Object _method_1 = this.method(mut.getObject().getExpression(), mut, nReference_1, expressionList_1, nExpression_1, recursionIndexExpression_1, false, false, false, evaluation_1);
                  _builder.append(_method_1);
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _get_4 = evaluation_1[0];
                    boolean _not = (!_get_4);
                    if (_not) {
                      _builder.append("objects = evaluate(objects, exp");
                      Integer _get_5 = expressionList_1.get(0);
                      _builder.append(_get_5);
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("objects = auxObjects;");
                      _builder.newLine();
                    }
                  }
                }
              }
              {
                EReference _refType_1 = mut.getObject().getRefType();
                boolean _tripleNotEquals_2 = (_refType_1 != null);
                if (_tripleNotEquals_2) {
                  _builder.append("List<EObject> tmpObjects = new ArrayList<EObject>();");
                  _builder.newLine();
                  _builder.append("for (EObject eobject : objects) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                  String _name_3 = mut.getObject().getRefType().getName();
                  _builder.append(_name_3, "\t");
                  _builder.append("\", objectSelection.getObject());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("tmpObjects.addAll(o);");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("objects = tmpObjects;");
                  _builder.newLine();
                }
              }
              {
                String _name_4 = mut.getName();
                boolean _tripleNotEquals_3 = (_name_4 != null);
                if (_tripleNotEquals_3) {
                  _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>();");
                  _builder.newLine();
                  _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(model, packages);");
                  _builder.newLine();
                  _builder.append("for (EObject obj : objects) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>> entry = new SimpleEntry(obj, resourceEntry);");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("listEntry.add(entry);");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("hmList.put(\"");
                  String _name_5 = mut.getName();
                  _builder.append(_name_5);
                  _builder.append("\", listEntry);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("List<ObSelectionStrategy> listSelection = new ArrayList<ObSelectionStrategy>();");
              _builder.newLine();
              _builder.append("for (EObject obj : objects) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("listSelection.add(objectSelection);");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            } else {
              ObSelectionStrategy _object_4 = mut.getObject();
              if ((_object_4 instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("if (hmObjects.get(\"");
                ObSelectionStrategy _object_5 = mut.getObject();
                String _name_6 = ((SpecificObjectSelection) _object_5).getObjSel().getName();
                _builder.append(_name_6);
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _object_6 = mut.getObject();
                String _name_7 = ((SpecificObjectSelection) _object_6).getObjSel().getName();
                _builder.append(_name_7, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _object_7 = mut.getObject();
                String _name_8 = ((SpecificObjectSelection) _object_7).getObjSel().getName();
                _builder.append(_name_8, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _object_8 = mut.getObject();
                String _name_9 = ((SpecificObjectSelection) _object_8).getObjSel().getName();
                _builder.append(_name_9, "\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _object_9 = mut.getObject();
                String _name_10 = ((SpecificObjectSelection) _object_9).getObjSel().getName();
                _builder.append(_name_10, "\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _object_10 = mut.getObject();
                String _name_11 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                _builder.append(_name_11, "\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (hmList.get(\"");
                ObSelectionStrategy _object_11 = mut.getObject();
                String _name_12 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                _builder.append(_name_12, "\t");
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                ObSelectionStrategy _object_12 = mut.getObject();
                String _name_13 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                _builder.append(_name_13, "\t\t");
                _builder.append(" = hmList.get(\"");
                ObSelectionStrategy _object_13 = mut.getObject();
                String _name_14 = ((SpecificObjectSelection) _object_13).getObjSel().getName();
                _builder.append(_name_14, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                ObSelectionStrategy _object_14 = mut.getObject();
                String _name_15 = ((SpecificObjectSelection) _object_14).getObjSel().getName();
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
                ObSelectionStrategy _object_15 = mut.getObject();
                String _name_16 = ((SpecificObjectSelection) _object_15).getObjSel().getName();
                _builder.append(_name_16, "\t\t");
                _builder.append(".get(0).getValue().getValue(), listEntry_");
                ObSelectionStrategy _object_16 = mut.getObject();
                String _name_17 = ((SpecificObjectSelection) _object_16).getObjSel().getName();
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
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_2 = mut.getObject().getRefType();
                  boolean _tripleNotEquals_4 = (_refType_2 != null);
                  if (_tripleNotEquals_4) {
                    _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                    String _name_18 = mut.getObject().getRefType().getName();
                    _builder.append(_name_18);
                    _builder.append("\", objectSelection.getObject());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("EObject object = o.get(ModelManager.getRandomIndex(o));");
                    _builder.newLine();
                    _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
                    _builder.newLine();
                  }
                }
              } else {
                ObSelectionStrategy _object_17 = mut.getObject();
                if ((_object_17 instanceof SpecificClosureSelection)) {
                  {
                    if (((((SpecificClosureSelection) mut.getObject()).getObjSel() != null) && (((SpecificClosureSelection) mut.getObject()).getRefType() != null))) {
                      _builder.append("ObSelectionStrategy objectSelection = null;");
                      _builder.newLine();
                      _builder.append("if (hmObjects.get(\"");
                      ObSelectionStrategy _object_18 = mut.getObject();
                      String _name_19 = ((SpecificClosureSelection) _object_18).getObjSel().getName();
                      _builder.append(_name_19);
                      _builder.append("\") != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      ObSelectionStrategy _object_19 = mut.getObject();
                      String _name_20 = ((SpecificClosureSelection) _object_19).getObjSel().getName();
                      _builder.append(_name_20, "\t");
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _object_20 = mut.getObject();
                      String _name_21 = ((SpecificClosureSelection) _object_20).getObjSel().getName();
                      _builder.append(_name_21, "\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                      ObSelectionStrategy _object_21 = mut.getObject();
                      String _name_22 = ((SpecificClosureSelection) _object_21).getObjSel().getName();
                      _builder.append(_name_22, "\t");
                      _builder.append(".getValue().getValue(), entry_");
                      ObSelectionStrategy _object_22 = mut.getObject();
                      String _name_23 = ((SpecificClosureSelection) _object_22).getObjSel().getName();
                      _builder.append(_name_23, "\t");
                      _builder.append(".getValue().getKey(), entry_");
                      ObSelectionStrategy _object_23 = mut.getObject();
                      String _name_24 = ((SpecificClosureSelection) _object_23).getObjSel().getName();
                      _builder.append(_name_24, "\t");
                      _builder.append(".getKey(), \"");
                      ObSelectionStrategy _object_24 = mut.getObject();
                      String _name_25 = ((SpecificClosureSelection) _object_24).getRefType().getName();
                      _builder.append(_name_25, "\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("else {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("if (hmList.get(\"");
                      ObSelectionStrategy _object_25 = mut.getObject();
                      String _name_26 = ((SpecificClosureSelection) _object_25).getObjSel().getName();
                      _builder.append(_name_26, "\t");
                      _builder.append("\") != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                      ObSelectionStrategy _object_26 = mut.getObject();
                      String _name_27 = ((SpecificClosureSelection) _object_26).getObjSel().getName();
                      _builder.append(_name_27, "\t\t");
                      _builder.append(" = hmList.get(\"");
                      ObSelectionStrategy _object_27 = mut.getObject();
                      String _name_28 = ((SpecificClosureSelection) _object_27).getObjSel().getName();
                      _builder.append(_name_28, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                      ObSelectionStrategy _object_28 = mut.getObject();
                      String _name_29 = ((SpecificClosureSelection) _object_28).getObjSel().getName();
                      _builder.append(_name_29, "\t\t");
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
                      ObSelectionStrategy _object_29 = mut.getObject();
                      String _name_30 = ((SpecificClosureSelection) _object_29).getObjSel().getName();
                      _builder.append(_name_30, "\t\t");
                      _builder.append(".get(0).getValue().getValue(), listEntry_");
                      ObSelectionStrategy _object_30 = mut.getObject();
                      String _name_31 = ((SpecificClosureSelection) _object_30).getObjSel().getName();
                      _builder.append(_name_31, "\t\t");
                      _builder.append(".get(0).getValue().getKey(), objs, \"");
                      ObSelectionStrategy _object_31 = mut.getObject();
                      String _name_32 = ((SpecificClosureSelection) _object_31).getRefType().getName();
                      _builder.append(_name_32, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("else {");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("return mutations;");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("}");
                      _builder.newLine();
                      {
                        EReference _refType_3 = mut.getObject().getRefType();
                        boolean _tripleNotEquals_5 = (_refType_3 != null);
                        if (_tripleNotEquals_5) {
                          _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                          String _name_33 = mut.getObject().getRefType().getName();
                          _builder.append(_name_33);
                          _builder.append("\", objectSelection.getObject());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject object = o.get(ModelManager.getRandomIndex(o));");
                          _builder.newLine();
                          _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        String _xblockexpression_2 = null;
        {
          counter[0] = 0;
          _xblockexpression_2 = "";
        }
        _builder.append(_xblockexpression_2, "\t");
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
            String _xblockexpression_3 = null;
            {
              int _get_6 = counter[0];
              int _plus = (_get_6 + 1);
              counter[0] = _plus;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//POSITION");
            String _xblockexpression_4 = null;
            {
              position++;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//NAME:");
            String attributeName = "";
            _builder.newLineIfNotEmpty();
            {
              EAttribute _get_6 = c.getAttribute().get(0);
              boolean _tripleNotEquals_6 = (_get_6 != null);
              if (_tripleNotEquals_6) {
                _builder.append("\t");
                final EAttribute attribute = c.getAttribute().get(0);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//NAME:");
                _builder.append(attributeName = attribute.getName(), "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("//NAME:");
                _builder.append(attributeName = "", "\t");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((c instanceof AttributeSwap)) {
                _builder.append("\t");
                final AttributeSwap attributeSwap = ((AttributeSwap) c);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_32 = attributeSwap.getObject();
                  boolean _tripleNotEquals_7 = (_object_32 != null);
                  if (_tripleNotEquals_7) {
                    {
                      ObSelectionStrategy _object_33 = attributeSwap.getObject();
                      if ((_object_33 instanceof RandomTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("if (hmObjects.get(\"");
                        ObSelectionStrategy _object_34 = attributeSwap.getObject();
                        String _name_34 = ((RandomTypeSelection) _object_34).getName();
                        _builder.append(_name_34, "\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName, "\t\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t\t\t");
                        _builder.append("\");");
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
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        ObSelectionStrategy _object_35 = attributeSwap.getObject();
                        String _name_35 = ((RandomTypeSelection) _object_35).getName();
                        _builder.append(_name_35, "\t\t");
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _object_36 = attributeSwap.getObject();
                        String _name_36 = ((RandomTypeSelection) _object_36).getName();
                        _builder.append(_name_36, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("atts.add(new SwapAttributeConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_37 = attributeSwap.getObject();
                        String _name_37 = ((RandomTypeSelection) _object_37).getName();
                        _builder.append(_name_37, "\t\t");
                        _builder.append(".getKey(), \"");
                        ObSelectionStrategy _object_38 = attributeSwap.getObject();
                        String _name_38 = ((RandomTypeSelection) _object_38).getType().getName();
                        _builder.append(_name_38, "\t\t");
                        _builder.append("\", \"");
                        String _name_39 = ((AttributeSwap)c).getAttribute().get(0).getName();
                        _builder.append(_name_39, "\t\t");
                        _builder.append("\", \"");
                        String _name_40 = ((AttributeSwap)c).getAttribute().get(1).getName();
                        _builder.append(_name_40, "\t\t");
                        _builder.append("\", entry_");
                        ObSelectionStrategy _object_39 = attributeSwap.getObject();
                        String _name_41 = ((RandomTypeSelection) _object_39).getName();
                        _builder.append(_name_41, "\t\t");
                        _builder.append(".getValue().getKey()));");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("attsList.put(\"");
                        _builder.append(attributeName, "\t\t");
                        _builder.append("\", atts);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                      } else {
                        ObSelectionStrategy _object_40 = attributeSwap.getObject();
                        if ((_object_40 instanceof SpecificObjectSelection)) {
                          _builder.append("\t");
                          _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("if (hmObjects.get(\"");
                          ObSelectionStrategy _object_41 = attributeSwap.getObject();
                          String _name_42 = ((SpecificObjectSelection) _object_41).getObjSel().getName();
                          _builder.append(_name_42, "\t\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("if (attsList.get(\"");
                          _builder.append(attributeName, "\t\t\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("atts = attsList.get(\"");
                          _builder.append(attributeName, "\t\t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("else {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                          _builder.newLine();
                          _builder.append("\t\t\t\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t\t\t\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _object_42 = attributeSwap.getObject();
                          String _name_43 = ((SpecificObjectSelection) _object_42).getObjSel().getName();
                          _builder.append(_name_43, "\t\t\t\t\t\t\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _object_43 = attributeSwap.getObject();
                          String _name_44 = ((SpecificObjectSelection) _object_43).getObjSel().getName();
                          _builder.append(_name_44, "\t\t\t\t\t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("atts.add(new SwapAttributeConfigurationStrategy(objectSelection.getObject(), entry_");
                          ObSelectionStrategy _object_44 = attributeSwap.getObject();
                          String _name_45 = ((SpecificObjectSelection) _object_44).getObjSel().getName();
                          _builder.append(_name_45, "\t\t\t");
                          _builder.append(".getKey(), \"");
                          String _name_46 = ((AttributeSwap)c).getAttribute().get(0).getName();
                          _builder.append(_name_46, "\t\t\t");
                          _builder.append("\", \"");
                          String _name_47 = ((AttributeSwap)c).getAttribute().get(1).getName();
                          _builder.append(_name_47, "\t\t\t");
                          _builder.append("\"));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("attsList.put(\"");
                          _builder.append(attributeName, "\t\t\t");
                          _builder.append("\", atts);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("} else {");
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
                        }
                      }
                    }
                  } else {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (attsList.get(\"");
                    _builder.append(attributeName, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("atts = attsList.get(\"");
                    _builder.append(attributeName, "\t\t\t");
                    _builder.append("\");");
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
                    _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("atts.add(new SwapAttributeConfigurationStrategy(objectSelection.getObject(), \"");
                    String _name_48 = ((AttributeSwap)c).getAttribute().get(0).getName();
                    _builder.append(_name_48, "\t\t");
                    _builder.append("\", \"");
                    String _name_49 = ((AttributeSwap)c).getAttribute().get(1).getName();
                    _builder.append(_name_49, "\t\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("attsList.put(\"");
                    _builder.append(attributeName, "\t\t");
                    _builder.append("\", atts);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                if ((c instanceof AttributeCopy)) {
                  final AttributeCopy attributeCopy = ((AttributeCopy) c);
                  _builder.newLineIfNotEmpty();
                  {
                    ObSelectionStrategy _object_45 = attributeCopy.getObject();
                    boolean _tripleNotEquals_8 = (_object_45 != null);
                    if (_tripleNotEquals_8) {
                      {
                        ObSelectionStrategy _object_46 = attributeCopy.getObject();
                        if ((_object_46 instanceof RandomTypeSelection)) {
                          _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("if (attsList.get(\"");
                          _builder.append(attributeName, "\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("atts = attsList.get(\"");
                          _builder.append(attributeName, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("else {");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), \"");
                          ObSelectionStrategy _object_47 = attributeCopy.getObject();
                          String _name_50 = ((RandomTypeSelection) _object_47).getType().getName();
                          _builder.append(_name_50, "\t");
                          _builder.append("\", \"");
                          String _name_51 = ((AttributeCopy)c).getAttribute().get(0).getName();
                          _builder.append(_name_51, "\t");
                          _builder.append("\", \"");
                          String _name_52 = ((AttributeCopy)c).getAttribute().get(1).getName();
                          _builder.append(_name_52, "\t");
                          _builder.append("\", objectSelection.getModel()));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("attsList.put(\"");
                          _builder.append(attributeName, "\t");
                          _builder.append("\", atts);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          ObSelectionStrategy _object_48 = attributeCopy.getObject();
                          if ((_object_48 instanceof SpecificObjectSelection)) {
                            _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("if (hmObjects.get(\"");
                            ObSelectionStrategy _object_49 = attributeCopy.getObject();
                            String _name_53 = ((SpecificObjectSelection) _object_49).getObjSel().getName();
                            _builder.append(_name_53, "\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("if (attsList.get(\"");
                            _builder.append(attributeName, "\t\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t");
                            _builder.append("atts = attsList.get(\"");
                            _builder.append(attributeName, "\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t   \t\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                            ObSelectionStrategy _object_50 = attributeCopy.getObject();
                            String _name_54 = ((SpecificObjectSelection) _object_50).getObjSel().getName();
                            _builder.append(_name_54, "\t\t\t\t\t   \t\t\t");
                            _builder.append(" = hmObjects.get(\"");
                            ObSelectionStrategy _object_51 = attributeCopy.getObject();
                            String _name_55 = ((SpecificObjectSelection) _object_51).getObjSel().getName();
                            _builder.append(_name_55, "\t\t\t\t\t   \t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), entry_");
                            ObSelectionStrategy _object_52 = attributeCopy.getObject();
                            String _name_56 = ((SpecificObjectSelection) _object_52).getObjSel().getName();
                            _builder.append(_name_56, "\t\t");
                            _builder.append(".getKey(), \"");
                            String _name_57 = ((AttributeCopy)c).getAttribute().get(0).getName();
                            _builder.append(_name_57, "\t\t");
                            _builder.append("\", \"");
                            String _name_58 = ((AttributeCopy)c).getAttribute().get(1).getName();
                            _builder.append(_name_58, "\t\t");
                            _builder.append("\"));");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("attsList.put(\"");
                            _builder.append(attributeName, "\t\t");
                            _builder.append("\", atts);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("} else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("return mutations;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                      }
                    } else {
                      _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("if (attsList.get(\"");
                      _builder.append(attributeName, "\t");
                      _builder.append("\") != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("atts = attsList.get(\"");
                      _builder.append(attributeName, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("else {");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), \"");
                      String _name_59 = ((AttributeCopy)c).getAttribute().get(0).getName();
                      _builder.append(_name_59, "\t");
                      _builder.append("\", \"");
                      String _name_60 = ((AttributeCopy)c).getAttribute().get(1).getName();
                      _builder.append(_name_60, "\t");
                      _builder.append("\"));");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("attsList.put(\"");
                      _builder.append(attributeName, "\t");
                      _builder.append("\", atts);");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                } else {
                  if ((c instanceof AttributeOperation)) {
                    final AttributeOperation attributeOperation = ((AttributeOperation) c);
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    {
                      AttributeEvaluationType _value = attributeOperation.getValue();
                      if ((_value instanceof ObjectAttributeType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_1 = attributeOperation.getValue();
                        final ObjectAttributeType objectAtt = ((ObjectAttributeType) _value_1);
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t   \t\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        String _name_61 = objectAtt.getObjSel().getName();
                        _builder.append(_name_61, "\t\t   \t\t\t");
                        _builder.append(" = hmObjects.get(\"");
                        String _name_62 = objectAtt.getObjSel().getName();
                        _builder.append(_name_62, "\t\t   \t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = ModelManager.getAttribute(\"");
                        String _name_63 = objectAtt.getAttribute().getName();
                        _builder.append(_name_63);
                        _builder.append("\", entry_");
                        String _name_64 = objectAtt.getObjSel().getName();
                        _builder.append(_name_64);
                        _builder.append(".getKey());");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_2 = attributeOperation.getValue();
                      if ((_value_2 instanceof SpecificIntegerType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_3 = attributeOperation.getValue();
                        final SpecificIntegerType specInt = ((SpecificIntegerType) _value_3);
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = ");
                        int _value_4 = specInt.getValue();
                        _builder.append(_value_4);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_5 = attributeOperation.getValue();
                      if ((_value_5 instanceof RandomIntegerType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_6 = attributeOperation.getValue();
                        final RandomIntegerType rnInt = ((RandomIntegerType) _value_6);
                        _builder.newLineIfNotEmpty();
                        _builder.append("int min = ");
                        int _min = rnInt.getMin();
                        _builder.append(_min);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("int max = ");
                        int _max = rnInt.getMax();
                        _builder.append(_max);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;");
                        _builder.newLine();
                      }
                    }
                    {
                      AttributeEvaluationType _value_7 = attributeOperation.getValue();
                      if ((_value_7 instanceof RandomIntegerNumberType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_8 = attributeOperation.getValue();
                        final RandomIntegerNumberType rnNumInt = ((RandomIntegerNumberType) _value_8);
                        _builder.newLineIfNotEmpty();
                        _builder.append("int min = ");
                        int _min_1 = rnNumInt.getMin();
                        _builder.append(_min_1);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("int max = 0;");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _object_53 = rnNumInt.getObject();
                          if ((_object_53 instanceof SpecificObjectSelection)) {
                            _builder.append("\t   \t\t\t\t");
                            _builder.append("//");
                            ObSelectionStrategy _object_54 = rnNumInt.getObject();
                            final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_54);
                            _builder.newLineIfNotEmpty();
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                            String _name_65 = sel.getObjSel().getName();
                            _builder.append(_name_65);
                            _builder.append(" = hmObjects.get(\"");
                            String _name_66 = sel.getObjSel().getName();
                            _builder.append(_name_66);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t   \t\t\t\t");
                            _builder.append("max = ModelManager.getIntAttribute(\"");
                            String _name_67 = rnNumInt.getMax().getName();
                            _builder.append(_name_67, "\t   \t\t\t\t");
                            _builder.append("\", entry_\"");
                            String _name_68 = sel.getObjSel().getName();
                            _builder.append(_name_68, "\t   \t\t\t\t");
                            _builder.append("\".getKey());");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;");
                        _builder.newLine();
                      }
                    }
                    {
                      AttributeEvaluationType _value_9 = attributeOperation.getValue();
                      if ((_value_9 instanceof SpecificDoubleType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_10 = attributeOperation.getValue();
                        final SpecificDoubleType specDouble = ((SpecificDoubleType) _value_10);
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = ");
                        double _value_11 = specDouble.getValue();
                        _builder.append(_value_11);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_12 = attributeOperation.getValue();
                      if ((_value_12 instanceof RandomDoubleType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_13 = attributeOperation.getValue();
                        final RandomDoubleType rnDouble = ((RandomDoubleType) _value_13);
                        _builder.newLineIfNotEmpty();
                        _builder.append("int min = (int) Math.floor(");
                        double _min_2 = rnDouble.getMin();
                        _builder.append(_min_2);
                        _builder.append(" * 100);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("int max = (int) Math.floor(");
                        double _max_1 = rnDouble.getMax();
                        _builder.append(_max_1);
                        _builder.append(" * 100);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = 0.0;");
                        _builder.newLine();
                        _builder.append("if (min != 0 || max != 0) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("int rn = ModelManager.rn.nextInt(max - min) + min;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("value = rn / 100.0;");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      AttributeEvaluationType _value_14 = attributeOperation.getValue();
                      if ((_value_14 instanceof RandomDoubleNumberType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_15 = attributeOperation.getValue();
                        final RandomDoubleNumberType rnNumDouble = ((RandomDoubleNumberType) _value_15);
                        _builder.newLineIfNotEmpty();
                        _builder.append("int min = (int) Math.floor(");
                        double _min_3 = rnNumDouble.getMin();
                        _builder.append(_min_3);
                        _builder.append(" * 100);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("int max = 0;");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _object_55 = rnNumDouble.getObject();
                          if ((_object_55 instanceof SpecificObjectSelection)) {
                            _builder.append("\t   \t\t\t\t");
                            _builder.append("//");
                            ObSelectionStrategy _object_56 = rnNumDouble.getObject();
                            final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_56);
                            _builder.newLineIfNotEmpty();
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                            String _name_69 = sel_1.getObjSel().getName();
                            _builder.append(_name_69);
                            _builder.append(" = hmObjects.get(\"");
                            String _name_70 = sel_1.getObjSel().getName();
                            _builder.append(_name_70);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("max = (int) Math.floor(ModelManager.getDoubleAttribute(\"");
                            String _name_71 = rnNumDouble.getMax().getName();
                            _builder.append(_name_71);
                            _builder.append("\", entry_");
                            String _name_72 = sel_1.getObjSel().getName();
                            _builder.append(_name_72);
                            _builder.append(".getKey()) * 100);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("Object value = 0.0;");
                        _builder.newLine();
                        _builder.append("if (min != 0 || max != 0) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("int rn = ModelManager.rn.nextInt(max - min) + min;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("value = rn / 100.0;");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      AttributeEvaluationType _value_16 = attributeOperation.getValue();
                      if ((_value_16 instanceof MinValueType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_17 = attributeOperation.getValue();
                        final MinValueType minValue = ((MinValueType) _value_17);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MinValueConfigurationStrategy minStrategy = new MinValueConfigurationStrategy(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                        String _typeName = MutatorUtils.getTypeName(minValue);
                        _builder.append(_typeName);
                        _builder.append("\", \"");
                        String _name_73 = minValue.getAttribute().getName();
                        _builder.append(_name_73);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = minStrategy.getValue(); ");
                        _builder.newLine();
                      }
                    }
                    {
                      AttributeEvaluationType _value_18 = attributeOperation.getValue();
                      if ((_value_18 instanceof MaxValueType)) {
                        _builder.append("//");
                        AttributeEvaluationType _value_19 = attributeOperation.getValue();
                        final MaxValueType maxValue = ((MaxValueType) _value_19);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MaxValueConfigurationStrategy maxStrategy = new MaxValueConfigurationStrategy(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                        String _typeName_1 = MutatorUtils.getTypeName(maxValue);
                        _builder.append(_typeName_1);
                        _builder.append("\", \"");
                        String _name_74 = maxValue.getAttribute().getName();
                        _builder.append(_name_74);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("Object value = maxStrategy.getValue(); ");
                        _builder.newLine();
                      }
                    }
                    {
                      ArithmeticOperator _operator = attributeOperation.getOperator();
                      boolean _equals = Objects.equals(_operator, ArithmeticOperator.ADD);
                      if (_equals) {
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        CharSequence _add_2 = this.add(attributeOperation, attributeName, "objectSelection", counter);
                        _builder.append(_add_2);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ArithmeticOperator _operator_1 = attributeOperation.getOperator();
                      boolean _equals_1 = Objects.equals(_operator_1, ArithmeticOperator.SUBTRACT);
                      if (_equals_1) {
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        CharSequence _subtract = this.subtract(attributeOperation, attributeName, "objectSelection", counter);
                        _builder.append(_subtract);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ArithmeticOperator _operator_2 = attributeOperation.getOperator();
                      boolean _equals_2 = Objects.equals(_operator_2, ArithmeticOperator.MULTIPLY);
                      if (_equals_2) {
                        _builder.append("\t   \t\t\t\t");
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t   \t\t\t\t");
                        CharSequence _multiply = this.multiply(attributeOperation, attributeName, "objectSelection", counter);
                        _builder.append(_multiply, "\t   \t\t\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ArithmeticOperator _operator_3 = attributeOperation.getOperator();
                      boolean _equals_3 = Objects.equals(_operator_3, ArithmeticOperator.DIVIDE);
                      if (_equals_3) {
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t   \t\t\t");
                        CharSequence _divide = this.divide(attributeOperation, attributeName, "objectSelection", counter);
                        _builder.append(_divide, "\t   \t\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ArithmeticOperator _operator_4 = attributeOperation.getOperator();
                      boolean _equals_4 = Objects.equals(_operator_4, ArithmeticOperator.MODULE);
                      if (_equals_4) {
                        _builder.append("\t   \t\t\t\t");
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                        _builder.append("if (attsList.get(\"");
                        _builder.append(attributeName);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("atts = attsList.get(\"");
                        _builder.append(attributeName, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("atts = new ArrayList<AttributeConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t   \t\t\t\t");
                        CharSequence _module = this.module(attributeOperation, attributeName, "objectSelection", counter);
                        _builder.append(_module, "\t   \t\t\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("}");
                    _builder.newLine();
                  } else {
                    {
                      ObSelectionStrategy _object_57 = mut.getObject();
                      if ((_object_57 instanceof CompleteTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("for (ObSelectionStrategy objectSelection : listSelection) {");
                        _builder.newLine();
                      }
                    }
                    {
                      if ((position == 1)) {
                        _builder.append("\t");
                        _builder.append("if (objectSelection == null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("return mutations;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    CharSequence _method_2 = this.method(c, false, true, counter, position, false, "objectSelection");
                    _builder.append(_method_2, "\t\t");
                    _builder.newLineIfNotEmpty();
                    {
                      ObSelectionStrategy _object_58 = mut.getObject();
                      if ((_object_58 instanceof CompleteTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        _builder.append("Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();");
        _builder.newLine();
        _builder.append("Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();");
        _builder.newLine();
        _builder.append("List<EObject> objsAttRef = new ArrayList<EObject>();");
        _builder.newLine();
        _builder.append("//COUNTER:");
        String _xblockexpression_5 = null;
        {
          counter[0] = 0;
          _xblockexpression_5 = "";
        }
        _builder.append(_xblockexpression_5);
        _builder.newLineIfNotEmpty();
        _builder.append("//POSITION: ");
        String _xblockexpression_6 = null;
        {
          position = 0;
          _xblockexpression_6 = "";
        }
        _builder.append(_xblockexpression_6);
        _builder.newLineIfNotEmpty();
        _builder.append("//NAME:");
        String referenceName = "";
        _builder.newLineIfNotEmpty();
        {
          EList<ReferenceSet> _references = mut.getReferences();
          for(final ReferenceSet c_1 : _references) {
            _builder.append("//COUNTER:");
            String _xblockexpression_7 = null;
            {
              int _get_7 = counter[0];
              int _plus = (_get_7 + 1);
              counter[0] = _plus;
              _xblockexpression_7 = "";
            }
            _builder.append(_xblockexpression_7);
            _builder.newLineIfNotEmpty();
            _builder.append("//POSITION");
            String _xblockexpression_8 = null;
            {
              position++;
              _xblockexpression_8 = "";
            }
            _builder.append(_xblockexpression_8);
            _builder.newLineIfNotEmpty();
            {
              EReference _get_7 = c_1.getReference().get(0);
              boolean _tripleNotEquals_9 = (_get_7 != null);
              if (_tripleNotEquals_9) {
                final EReference reference = c_1.getReference().get(0);
                _builder.newLineIfNotEmpty();
                _builder.append("//NAME:");
                _builder.append(referenceName = reference.getName());
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("//NAME:");
                _builder.append(referenceName = "");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((c_1 instanceof ReferenceSwap)) {
                final ReferenceSwap referenceSwap = ((ReferenceSwap) c_1);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_59 = referenceSwap.getObject();
                  boolean _tripleNotEquals_10 = (_object_59 != null);
                  if (_tripleNotEquals_10) {
                    {
                      ObSelectionStrategy _object_60 = referenceSwap.getObject();
                      if ((_object_60 instanceof RandomTypeSelection)) {
                        _builder.append("if (hmObjects.get(\"");
                        ObSelectionStrategy _object_61 = referenceSwap.getObject();
                        String _name_75 = ((RandomTypeSelection) _object_61).getName();
                        _builder.append(_name_75);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (refsList.get(\"");
                        _builder.append(referenceName, "\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("refs = refsList.get(\"");
                        _builder.append(referenceName, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        ObSelectionStrategy _object_62 = referenceSwap.getObject();
                        String _name_76 = ((RandomTypeSelection) _object_62).getName();
                        _builder.append(_name_76, "\t");
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _object_63 = referenceSwap.getObject();
                        String _name_77 = ((RandomTypeSelection) _object_63).getName();
                        _builder.append(_name_77, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("refs.add(new SwapReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_64 = referenceSwap.getObject();
                        String _name_78 = ((RandomTypeSelection) _object_64).getName();
                        _builder.append(_name_78, "\t");
                        _builder.append(".getKey(), \"");
                        ObSelectionStrategy _object_65 = referenceSwap.getObject();
                        String _name_79 = ((RandomTypeSelection) _object_65).getType().getName();
                        _builder.append(_name_79, "\t");
                        _builder.append("\", \"");
                        String _name_80 = ((ReferenceSwap)c_1).getReference().get(0).getName();
                        _builder.append(_name_80, "\t");
                        _builder.append("\", \"");
                        String _name_81 = ((ReferenceSwap)c_1).getReference().get(1).getName();
                        _builder.append(_name_81, "\t");
                        _builder.append("\", entry_");
                        ObSelectionStrategy _object_66 = referenceSwap.getObject();
                        String _name_82 = ((RandomTypeSelection) _object_66).getName();
                        _builder.append(_name_82, "\t");
                        _builder.append(".getValue().getKey()));");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("refsList.put(\"");
                        _builder.append(referenceName, "\t");
                        _builder.append(", refs);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                      } else {
                        ObSelectionStrategy _object_67 = referenceSwap.getObject();
                        if ((_object_67 instanceof SpecificObjectSelection)) {
                          _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("if (hmObjects.get(\"");
                          ObSelectionStrategy _object_68 = referenceSwap.getObject();
                          String _name_83 = ((SpecificObjectSelection) _object_68).getObjSel().getName();
                          _builder.append(_name_83, "\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("if (refsList.get(\"");
                          _builder.append(referenceName, "\t\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t");
                          _builder.append("refs = refsList.get(\"");
                          _builder.append(referenceName, "\t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t");
                          _builder.append("else {");
                          _builder.newLine();
                          _builder.append("\t\t\t");
                          _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                          _builder.newLine();
                          _builder.append("   \t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _object_69 = referenceSwap.getObject();
                          String _name_84 = ((SpecificObjectSelection) _object_69).getObjSel().getName();
                          _builder.append(_name_84, "\t\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _object_70 = referenceSwap.getObject();
                          String _name_85 = ((SpecificObjectSelection) _object_70).getObjSel().getName();
                          _builder.append(_name_85, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("refs.add(new SwapReferenceConfigurationStrategy(objectSelection.getObject(), entry_");
                          ObSelectionStrategy _object_71 = referenceSwap.getObject();
                          String _name_86 = ((SpecificObjectSelection) _object_71).getObjSel().getName();
                          _builder.append(_name_86, "\t\t");
                          _builder.append(".getKey(), \"");
                          String _name_87 = ((ReferenceSwap)c_1).getReference().get(0).getName();
                          _builder.append(_name_87, "\t\t");
                          _builder.append("\", \"");
                          String _name_88 = ((ReferenceSwap)c_1).getReference().get(1).getName();
                          _builder.append(_name_88, "\t\t");
                          _builder.append("\"));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("refsList.put(\"");
                          _builder.append(referenceName, "\t\t");
                          _builder.append("\", refs);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("return mutations;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                    }
                  } else {
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("refs.add(new SwapReferenceConfigurationStrategy(objectSelection.getObject(), \"");
                    String _name_89 = ((ReferenceSwap)c_1).getReference().get(0).getName();
                    _builder.append(_name_89, "\t");
                    _builder.append("\", \"");
                    String _name_90 = ((ReferenceSwap)c_1).getReference().get(1).getName();
                    _builder.append(_name_90, "\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if ((c_1 instanceof ReferenceUnset)) {
                final ReferenceUnset referenceUnset = ((ReferenceUnset) c_1);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_72 = referenceUnset.getObject();
                  boolean _tripleNotEquals_11 = (_object_72 != null);
                  if (_tripleNotEquals_11) {
                    {
                      ObSelectionStrategy _object_73 = referenceUnset.getObject();
                      if ((_object_73 instanceof RandomTypeSelection)) {
                        _builder.append("if (hmObjects.get(\"");
                        ObSelectionStrategy _object_74 = referenceUnset.getObject();
                        String _name_91 = ((RandomTypeSelection) _object_74).getName();
                        _builder.append(_name_91);
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (refsList.get(\"");
                        _builder.append(referenceName, "\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("refs = refsList.get(\"");
                        _builder.append(referenceName, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        ObSelectionStrategy _object_75 = referenceUnset.getObject();
                        String _name_92 = ((RandomTypeSelection) _object_75).getName();
                        _builder.append(_name_92, "\t");
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _object_76 = referenceUnset.getObject();
                        String _name_93 = ((RandomTypeSelection) _object_76).getName();
                        _builder.append(_name_93, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("refs.add(new NullReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_77 = referenceUnset.getObject();
                        String _name_94 = ((RandomTypeSelection) _object_77).getName();
                        _builder.append(_name_94, "\t");
                        _builder.append(".getKey(), \"");
                        ObSelectionStrategy _object_78 = referenceUnset.getObject();
                        String _name_95 = ((RandomTypeSelection) _object_78).getType().getName();
                        _builder.append(_name_95, "\t");
                        _builder.append("\", \"");
                        String _name_96 = ((ReferenceUnset)c_1).getReference().get(0).getName();
                        _builder.append(_name_96, "\t");
                        _builder.append("\", entry_");
                        ObSelectionStrategy _object_79 = referenceUnset.getObject();
                        String _name_97 = ((RandomTypeSelection) _object_79).getName();
                        _builder.append(_name_97, "\t");
                        _builder.append(".getValue().getKey()));");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("refsList.put(\"");
                        _builder.append(referenceName, "\t");
                        _builder.append(", refs);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                      } else {
                        ObSelectionStrategy _object_80 = referenceUnset.getObject();
                        if ((_object_80 instanceof SpecificObjectSelection)) {
                          _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("if (hmObjects.get(\"");
                          ObSelectionStrategy _object_81 = referenceUnset.getObject();
                          String _name_98 = ((SpecificObjectSelection) _object_81).getObjSel().getName();
                          _builder.append(_name_98, "\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("if (refsList.get(\"");
                          _builder.append(referenceName, "\t\t");
                          _builder.append("\") != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t");
                          _builder.append("refs = refsList.get(\"");
                          _builder.append(referenceName, "\t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t");
                          _builder.append("else {");
                          _builder.newLine();
                          _builder.append("\t\t\t");
                          _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                          _builder.newLine();
                          _builder.append("   \t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _object_82 = referenceUnset.getObject();
                          String _name_99 = ((SpecificObjectSelection) _object_82).getObjSel().getName();
                          _builder.append(_name_99, "\t\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _object_83 = referenceUnset.getObject();
                          String _name_100 = ((SpecificObjectSelection) _object_83).getObjSel().getName();
                          _builder.append(_name_100, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("refs.add(new NullReferenceConfigurationStrategy(objectSelection.getObject(), entry_");
                          ObSelectionStrategy _object_84 = referenceUnset.getObject();
                          String _name_101 = ((SpecificObjectSelection) _object_84).getObjSel().getName();
                          _builder.append(_name_101, "\t\t");
                          _builder.append(".getKey(), \"");
                          String _name_102 = ((ReferenceUnset)c_1).getReference().get(0).getName();
                          _builder.append(_name_102, "\t\t");
                          _builder.append("\"));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("refsList.put(\"");
                          _builder.append(referenceName, "\t\t");
                          _builder.append("\", refs);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("return mutations;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                    }
                  } else {
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("refs.add(new NullReferenceConfigurationStrategy(objectSelection.getObject(), \"");
                    String _name_103 = ((ReferenceUnset)c_1).getReference().get(0).getName();
                    _builder.append(_name_103, "\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if ((c_1 instanceof ReferenceInit)) {
                _builder.append("\t   \t\t");
                final ReferenceInit referenceInit = ((ReferenceInit) c_1);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_85 = referenceInit.getObject();
                  if ((_object_85 instanceof SpecificObjectSelection)) {
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (hmObjects.get(\"");
                    ObSelectionStrategy _object_86 = referenceInit.getObject();
                    String _name_104 = ((SpecificObjectSelection) _object_86).getObjSel().getName();
                    _builder.append(_name_104, "\t   \t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _object_87 = referenceInit.getObject();
                    String _name_105 = ((SpecificObjectSelection) _object_87).getObjSel().getName();
                    _builder.append(_name_105, "\t\t\t\t\t\t\t");
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _object_88 = referenceInit.getObject();
                    String _name_106 = ((SpecificObjectSelection) _object_88).getObjSel().getName();
                    _builder.append(_name_106, "\t\t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    {
                      ObSelectionStrategy _object_89 = referenceInit.getObject();
                      EReference _refType_4 = ((SpecificObjectSelection) _object_89).getRefType();
                      boolean _tripleEquals_1 = (_refType_4 == null);
                      if (_tripleEquals_1) {
                        _builder.append("refs.add(new SpecificReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_90 = referenceInit.getObject();
                        String _name_107 = ((SpecificObjectSelection) _object_90).getObjSel().getName();
                        _builder.append(_name_107);
                        _builder.append(".getValue().getKey(), objectSelection.getObject(), entry_");
                        ObSelectionStrategy _object_91 = referenceInit.getObject();
                        String _name_108 = ((SpecificObjectSelection) _object_91).getObjSel().getName();
                        _builder.append(_name_108);
                        _builder.append(".getKey(), \"");
                        String _name_109 = referenceInit.getReference().get(0).getName();
                        _builder.append(_name_109);
                        _builder.append("\"));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("refs.add(new SpecificReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_92 = referenceInit.getObject();
                        String _name_110 = ((SpecificObjectSelection) _object_92).getObjSel().getName();
                        _builder.append(_name_110);
                        _builder.append(".getValue().getKey(), objectSelection.getObject(), (EObject) entry_");
                        ObSelectionStrategy _object_93 = referenceInit.getObject();
                        String _name_111 = ((SpecificObjectSelection) _object_93).getObjSel().getName();
                        _builder.append(_name_111);
                        _builder.append(".getKey().eGet(ModelManager.getReferenceByName(\"");
                        ObSelectionStrategy _object_94 = referenceInit.getObject();
                        String _name_112 = ((SpecificObjectSelection) _object_94).getRefType().getName();
                        _builder.append(_name_112);
                        _builder.append("\", entry_");
                        ObSelectionStrategy _object_95 = referenceInit.getObject();
                        String _name_113 = ((SpecificObjectSelection) _object_95).getObjSel().getName();
                        _builder.append(_name_113);
                        _builder.append(".getKey())), \"");
                        String _name_114 = referenceInit.getReference().get(0).getName();
                        _builder.append(_name_114);
                        _builder.append("\", false));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("return mutations;");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _object_96 = referenceInit.getObject();
                  if ((_object_96 instanceof RandomTypeSelection)) {
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("if (obSelection != null && obSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "   \t\t\t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("   \t\t\t\t\t\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "   \t\t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("   \t\t\t\t\t\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t   \t\t\t\t");
                    _builder.append("refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), \"");
                    String _name_115 = referenceInit.getReference().get(0).getName();
                    _builder.append(_name_115, "\t\t   \t\t\t\t");
                    _builder.append("\", \"");
                    ObSelectionStrategy _object_97 = referenceInit.getObject();
                    String _name_116 = ((RandomTypeSelection) _object_97).getType().getName();
                    _builder.append(_name_116, "\t\t   \t\t\t\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("   \t\t\t\t\t\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "   \t\t\t\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _object_98 = referenceInit.getObject();
                  if ((_object_98 instanceof OtherTypeSelection)) {
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), \"");
                    String _name_117 = referenceInit.getReference().get(0).getName();
                    _builder.append(_name_117, "\t   \t\t\t\t");
                    _builder.append("\", \"");
                    ObSelectionStrategy _object_99 = referenceInit.getObject();
                    String _name_118 = ((OtherTypeSelection) _object_99).getType().getName();
                    _builder.append(_name_118, "\t   \t\t\t\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _object_100 = referenceInit.getObject();
                  if ((_object_100 instanceof NullTypeSelection)) {
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refs.add(new NullReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), \"");
                    String _name_119 = referenceInit.getReference().get(0).getName();
                    _builder.append(_name_119, "\t   \t\t\t\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t   \t\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if ((c_1 instanceof ReferenceAdd)) {
                final ReferenceAdd referenceAdd = ((ReferenceAdd) c_1);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_101 = referenceAdd.getObject();
                  if ((_object_101 instanceof SpecificObjectSelection)) {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (hmObjects.get(\"");
                    ObSelectionStrategy _object_102 = referenceAdd.getObject();
                    String _name_120 = ((SpecificObjectSelection) _object_102).getObjSel().getName();
                    _builder.append(_name_120, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _object_103 = referenceAdd.getObject();
                    String _name_121 = ((SpecificObjectSelection) _object_103).getObjSel().getName();
                    _builder.append(_name_121, "\t\t\t\t\t\t\t");
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _object_104 = referenceAdd.getObject();
                    String _name_122 = ((SpecificObjectSelection) _object_104).getObjSel().getName();
                    _builder.append(_name_122, "\t\t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    {
                      ObSelectionStrategy _object_105 = referenceAdd.getObject();
                      EReference _refType_5 = ((SpecificObjectSelection) _object_105).getRefType();
                      boolean _tripleEquals_2 = (_refType_5 == null);
                      if (_tripleEquals_2) {
                        _builder.append("refs.add(new SpecificReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_106 = referenceAdd.getObject();
                        String _name_123 = ((SpecificObjectSelection) _object_106).getObjSel().getName();
                        _builder.append(_name_123);
                        _builder.append(".getValue().getKey(), objectSelection.getObject(), entry_");
                        ObSelectionStrategy _object_107 = referenceAdd.getObject();
                        String _name_124 = ((SpecificObjectSelection) _object_107).getObjSel().getName();
                        _builder.append(_name_124);
                        _builder.append(".getKey(), \"");
                        String _name_125 = referenceAdd.getReference().get(0).getName();
                        _builder.append(_name_125);
                        _builder.append("\", false));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("refs.add(new SpecificReferenceConfigurationStrategy(entry_");
                        ObSelectionStrategy _object_108 = referenceAdd.getObject();
                        String _name_126 = ((SpecificObjectSelection) _object_108).getObjSel().getName();
                        _builder.append(_name_126);
                        _builder.append(".getValue().getKey(), objectSelection.getObject(), (EObject) entry_");
                        ObSelectionStrategy _object_109 = referenceAdd.getObject();
                        String _name_127 = ((SpecificObjectSelection) _object_109).getObjSel().getName();
                        _builder.append(_name_127);
                        _builder.append(".getKey().eGet(ModelManager.getReferenceByName(\"");
                        ObSelectionStrategy _object_110 = referenceAdd.getObject();
                        String _name_128 = ((SpecificObjectSelection) _object_110).getRefType().getName();
                        _builder.append(_name_128);
                        _builder.append("\", entry_");
                        ObSelectionStrategy _object_111 = referenceAdd.getObject();
                        String _name_129 = ((SpecificObjectSelection) _object_111).getObjSel().getName();
                        _builder.append(_name_129);
                        _builder.append(".getKey())), \"");
                        String _name_130 = referenceAdd.getReference().get(0).getName();
                        _builder.append(_name_130);
                        _builder.append("\", false));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("} else {");
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
                  }
                }
                {
                  ObSelectionStrategy _object_112 = referenceAdd.getObject();
                  if ((_object_112 instanceof OtherTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\");");
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
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), \"");
                    String _name_131 = referenceAdd.getReference().get(0).getName();
                    _builder.append(_name_131, "\t");
                    _builder.append("\", \"");
                    ObSelectionStrategy _object_113 = referenceAdd.getObject();
                    String _name_132 = ((OtherTypeSelection) _object_113).getType().getName();
                    _builder.append(_name_132, "\t");
                    _builder.append("\", false));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t   \t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if ((c_1 instanceof ReferenceRemove)) {
                final ReferenceRemove referenceRemove = ((ReferenceRemove) c_1);
                _builder.newLineIfNotEmpty();
                {
                  ObSelectionStrategy _object_114 = referenceRemove.getObject();
                  if ((_object_114 instanceof SpecificObjectSelection)) {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (hmObjects.get(\"");
                    ObSelectionStrategy _object_115 = referenceRemove.getObject();
                    String _name_133 = ((SpecificObjectSelection) _object_115).getObjSel().getName();
                    _builder.append(_name_133, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _object_116 = referenceRemove.getObject();
                    String _name_134 = ((SpecificObjectSelection) _object_116).getObjSel().getName();
                    _builder.append(_name_134, "\t\t\t\t\t\t\t");
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _object_117 = referenceRemove.getObject();
                    String _name_135 = ((SpecificObjectSelection) _object_117).getObjSel().getName();
                    _builder.append(_name_135, "\t\t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs.add(new SpecificReferenceConfigurationStrategy(entry_");
                    ObSelectionStrategy _object_118 = referenceRemove.getObject();
                    String _name_136 = ((SpecificObjectSelection) _object_118).getObjSel().getName();
                    _builder.append(_name_136, "\t\t\t");
                    _builder.append(".getValue().getKey(), objectSelection.getObject(), entry_");
                    ObSelectionStrategy _object_119 = referenceRemove.getObject();
                    String _name_137 = ((SpecificObjectSelection) _object_119).getObjSel().getName();
                    _builder.append(_name_137, "\t\t\t");
                    _builder.append(".getKey(), \"");
                    String _name_138 = referenceRemove.getReference().get(0).getName();
                    _builder.append(_name_138, "\t\t\t");
                    _builder.append("\", true));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("} else {");
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
                  }
                }
                {
                  ObSelectionStrategy _object_120 = referenceRemove.getObject();
                  if ((_object_120 instanceof OtherTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\");");
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
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), \"");
                    String _name_139 = referenceRemove.getReference().get(0).getName();
                    _builder.append(_name_139, "\t\t");
                    _builder.append("\", \"");
                    ObSelectionStrategy _object_121 = referenceRemove.getObject();
                    String _name_140 = ((OtherTypeSelection) _object_121).getType().getName();
                    _builder.append(_name_140, "\t\t");
                    _builder.append("\", true));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _object_122 = referenceRemove.getObject();
                  if ((_object_122 instanceof NullTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("if (objectSelection != null && objectSelection.getObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<ReferenceConfigurationStrategy> refs = null;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (refsList.get(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("refs = refsList.get(\"");
                    _builder.append(referenceName, "\t\t\t");
                    _builder.append("\");");
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
                    _builder.append("refs = new ArrayList<ReferenceConfigurationStrategy>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refs.add(new NullReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), \"");
                    String _name_141 = referenceRemove.getReference().get(0).getName();
                    _builder.append(_name_141, "\t\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("refsList.put(\"");
                    _builder.append(referenceName, "\t\t");
                    _builder.append("\", refs);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("//NAME:");
            String attributeName_1 = "";
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
            {
              if ((c_1 instanceof ReferenceAtt)) {
                final ReferenceAtt referenceAtt = ((ReferenceAtt) c_1);
                _builder.newLineIfNotEmpty();
                {
                  EList<EReference> _reference = referenceAtt.getReference();
                  boolean _tripleNotEquals_12 = (_reference != null);
                  if (_tripleNotEquals_12) {
                    {
                      EAttribute _attribute = referenceAtt.getAttribute();
                      boolean _tripleNotEquals_13 = (_attribute != null);
                      if (_tripleNotEquals_13) {
                        _builder.append("//NAME:");
                        _builder.append(attributeName_1 = referenceAtt.getAttribute().getName());
                        _builder.newLineIfNotEmpty();
                        {
                          AttributeType _value_20 = referenceAtt.getValue();
                          boolean _tripleNotEquals_14 = (_value_20 != null);
                          if (_tripleNotEquals_14) {
                            {
                              EObject _eContainer = referenceAtt.eContainer();
                              ObSelectionStrategy _object_123 = ((ModifyInformationMutator) _eContainer).getObject();
                              if ((_object_123 instanceof SpecificObjectSelection)) {
                                _builder.append("EObject refObjectSelected = null;");
                                _builder.newLine();
                                _builder.append("if (hmObjects.get(\"");
                                EObject _eContainer_1 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_124 = ((ModifyInformationMutator) _eContainer_1).getObject();
                                String _name_142 = ((SpecificObjectSelection) _object_124).getObjSel().getName();
                                _builder.append(_name_142);
                                _builder.append("\") != null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("for (EReference ref : hmObjects.get(\"");
                                EObject _eContainer_2 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_125 = ((ModifyInformationMutator) _eContainer_2).getObject();
                                String _name_143 = ((SpecificObjectSelection) _object_125).getObjSel().getName();
                                _builder.append(_name_143, "\t");
                                _builder.append("\").getKey().eClass().getEReferences()) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t");
                                _builder.append("if (ref.getName().equals(\"");
                                String _name_144 = referenceAtt.getReference().get(0).getName();
                                _builder.append(_name_144, "\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                                EObject _eContainer_3 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_126 = ((ModifyInformationMutator) _eContainer_3).getObject();
                                String _name_145 = ((SpecificObjectSelection) _object_126).getObjSel().getName();
                                _builder.append(_name_145, "\t\t\t");
                                _builder.append(" = hmObjects.get(\"");
                                EObject _eContainer_4 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_127 = ((ModifyInformationMutator) _eContainer_4).getObject();
                                String _name_146 = ((SpecificObjectSelection) _object_127).getObjSel().getName();
                                _builder.append(_name_146, "\t\t\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("refObjectSelected = (EObject) entry_");
                                EObject _eContainer_5 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_128 = ((ModifyInformationMutator) _eContainer_5).getObject();
                                String _name_147 = ((SpecificObjectSelection) _object_128).getObjSel().getName();
                                _builder.append(_name_147, "\t\t\t");
                                _builder.append(".getKey().eGet(ref);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("break;");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("}");
                                _builder.newLine();
                              } else {
                                EObject _eContainer_6 = referenceAtt.eContainer();
                                ObSelectionStrategy _object_129 = ((ModifyInformationMutator) _eContainer_6).getObject();
                                if ((_object_129 instanceof RandomTypeSelection)) {
                                  _builder.append("EObject refObjectSelected = null;");
                                  _builder.newLine();
                                  _builder.append("if (objectSelection != null) {");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("if (objectSelection.getObject() != null) {");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("for (EReference ref : objectSelection.getObject().eClass().getEReferences()) {");
                                  _builder.newLine();
                                  _builder.append("\t\t\t");
                                  _builder.append("if (ref.getName().equals(\"");
                                  String _name_148 = referenceAtt.getReference().get(0).getName();
                                  _builder.append(_name_148, "\t\t\t");
                                  _builder.append("\")) {");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t\t\t");
                                  _builder.append("refObjectSelected = (EObject) objectSelection.getObject().eGet(ref);");
                                  _builder.newLine();
                                  _builder.append("\t\t\t\t");
                                  _builder.append("break;");
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
                                  _builder.append("}");
                                  _builder.newLine();
                                }
                              }
                            }
                            {
                              if ((position == 1)) {
                                _builder.append("if (refObjectSelected == null) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("return mutations;");
                                _builder.newLine();
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("objsAttRef.add(refObjectSelected);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("List<AttributeConfigurationStrategy> attsRef = null;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("if (attsRefList.get(\"");
                            _builder.append(attributeName_1, "\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("attsRef = attsRefList.get(\"");
                            _builder.append(attributeName_1, "\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("attsRef = new ArrayList<AttributeConfigurationStrategy>();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            CharSequence _method_3 = this.method(referenceAtt.getValue(), attributeName_1, true, counter, false, "objectSelection");
                            _builder.append(_method_3, "\t");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("attsRef.add(attConfig);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("attsRefList.put(\"");
                            _builder.append(attributeName_1, "\t");
                            _builder.append("\", attsRef);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        {
          ObSelectionStrategy _object_130 = mut.getObject();
          if ((_object_130 instanceof CompleteTypeSelection)) {
            _builder.append("\t   \t\t");
            _builder.append("for (ObSelectionStrategy objectSelection : listSelection) {");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("if (mutatedObjects != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("mutatedObjects.add(objectSelection.getObject());");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_8 = nMutation[0];
            int _plus = (_get_8 + 1);
            int _set_6 = nMutation[0] = _plus;
            _builder.append(_set_6, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_9 = nRegistryMutation[0];
            int _plus_1 = (_get_9 + 1);
            int _set_7 = nRegistryMutation[0] = _plus_1;
            _builder.append(_set_7, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t   \t\t\t\t");
            _builder.append("mut.setId(\"m");
            int _get_10 = nMutation[0];
            _builder.append(_get_10, "\t   \t\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t\t");
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t   \t\t");
            _builder.append("if (objectSelection != null) {");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("if (mutatedObjects != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("mutatedObjects.add(objectSelection.getObject());");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_11 = nMutation[0];
            int _plus_2 = (_get_11 + 1);
            int _set_8 = nMutation[0] = _plus_2;
            _builder.append(_set_8, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("//INC COUNTER: ");
            int _get_12 = nRegistryMutation[0];
            int _plus_3 = (_get_12 + 1);
            int _set_9 = nRegistryMutation[0] = _plus_3;
            _builder.append(_set_9, "\t   \t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t   \t\t\t\t");
            _builder.append("mut.setId(\"m");
            int _get_13 = nMutation[0];
            _builder.append(_get_13, "\t   \t\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t\t\t");
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("\t   \t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("//END MODIFY INFORMATION ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
