package wodel.dsls.generator.mutators.exhaustive;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.dsls.runner.WodelUtils;

@SuppressWarnings("all")
public class WodelGeneratorCloneObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof CloneObjectMutator)) {
        _builder.append("\t");
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
        _builder.append("return numMutantsGenerated;");
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
                _builder.append("List<EObject> objects = rts.getObjects();");
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
                _builder.append("\t");
                _builder.append("Expression exp");
                Integer _get = expressionList.get(0);
                _builder.append(_get, "\t");
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//");
                int[] nReference = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//");
                int _set_2 = nReference[0] = 0;
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
                _builder.append("\t");
                Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation);
                _builder.append(_method, "\t");
                _builder.newLineIfNotEmpty();
                {
                  boolean _get_1 = evaluation[0];
                  boolean _equals = (_get_1 == false);
                  if (_equals) {
                    _builder.append("\t");
                    _builder.append("objects = evaluate(objects, exp");
                    Integer _get_2 = expressionList.get(0);
                    _builder.append(_get_2, "\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("objects = auxObjects;");
                    _builder.newLine();
                  }
                }
              }
            }
          } else {
            ObSelectionStrategy _object_2 = mut.getObject();
            if ((_object_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection cts = new RandomTypeSelection(packages, model, \"");
              ObSelectionStrategy _object_3 = mut.getObject();
              String _name_1 = ((CompleteTypeSelection) _object_3).getType().getName();
              _builder.append(_name_1, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("List<EObject> objects = cts.getObjects();");
              _builder.newLine();
              {
                Expression _expression_1 = mut.getObject().getExpression();
                boolean _tripleEquals_1 = (_expression_1 == null);
                if (_tripleEquals_1) {
                  _builder.append("\t");
                  _builder.append("List<EObject> objects = cts.getObjects();");
                  _builder.newLine();
                } else {
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
                  _builder.append("Expression exp");
                  Integer _get_3 = expressionList_1.get(0);
                  _builder.append(_get_3, "\t");
                  _builder.append(" = new Expression();");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("//");
                  int[] nReference_1 = new int[1];
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("//");
                  int _set_5 = nReference_1[0] = 0;
                  _builder.append(_set_5, "\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("//");
                  boolean[] evaluation_1 = new boolean[1];
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("//");
                  String _xblockexpression_1 = null;
                  {
                    evaluation_1[0] = false;
                    _xblockexpression_1 = "";
                  }
                  _builder.append(_xblockexpression_1, "\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  Object _method_1 = this.method(mut.getObject().getExpression(), mut, nReference_1, expressionList_1, nExpression_1, recursionIndexExpression_1, true, false, false, evaluation_1);
                  _builder.append(_method_1, "\t");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _get_4 = evaluation_1[0];
                    boolean _equals_1 = (_get_4 == false);
                    if (_equals_1) {
                      _builder.append("\t");
                      _builder.append("objects = evaluate(objects, exp");
                      Integer _get_5 = expressionList_1.get(0);
                      _builder.append(_get_5, "\t");
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("\t");
                      _builder.append("objects = auxObjects;");
                      _builder.newLine();
                    }
                  }
                }
              }
            } else {
              ObSelectionStrategy _object_4 = mut.getObject();
              if ((_object_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t\t\t    ");
                _builder.append("List<EObject> objects = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (hmObjects.get(\"");
                ObSelectionStrategy _object_5 = mut.getObject();
                String _name_2 = ((SpecificObjectSelection) _object_5).getObjSel().getName();
                _builder.append(_name_2, "\t");
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _object_6 = mut.getObject();
                String _name_3 = ((SpecificObjectSelection) _object_6).getObjSel().getName();
                _builder.append(_name_3, "\t\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _object_7 = mut.getObject();
                String _name_4 = ((SpecificObjectSelection) _object_7).getObjSel().getName();
                _builder.append(_name_4, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                ObSelectionStrategy _object_8 = mut.getObject();
                String _name_5 = ((SpecificObjectSelection) _object_8).getObjSel().getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(packages, model, recovered);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (hmList.get(\"");
                ObSelectionStrategy _object_9 = mut.getObject();
                String _name_6 = ((SpecificObjectSelection) _object_9).getObjSel().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                ObSelectionStrategy _object_10 = mut.getObject();
                String _name_7 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t\t");
                _builder.append(" = hmList.get(\"");
                ObSelectionStrategy _object_11 = mut.getObject();
                String _name_8 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                _builder.append(_name_8, "\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                ObSelectionStrategy _object_12 = mut.getObject();
                String _name_9 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                _builder.append(_name_9, "\t\t\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("EObject obj = ModelManager.getObject(model, ent.getKey());");
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
                _builder.append("objectSelection = new SpecificObjectSelection(packages, model, objs);");
                _builder.newLine();
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
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (objectSelection != null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("objects.add(objectSelection.getObject());");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType = mut.getObject().getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("\t");
                    _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                    String _name_10 = mut.getObject().getRefType().getName();
                    _builder.append(_name_10, "\t");
                    _builder.append("\", objects.get(0));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("EObject object = o.get(ModelManager.getRandomIndex(o));");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("objects.clear();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("objects.add(object);");
                    _builder.newLine();
                  }
                }
              } else {
                ObSelectionStrategy _object_13 = mut.getObject();
                if ((_object_13 instanceof SpecificClosureSelection)) {
                  {
                    if (((((SpecificClosureSelection) mut.getObject()).getObjSel() != null) && (((SpecificClosureSelection) mut.getObject()).getRefType() != null))) {
                      _builder.append("\t");
                      _builder.append("List<EObject> objects = new ArrayList<EObject>();");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("ObSelectionStrategy objectSelection = null;");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("if (hmObjects.get(\"");
                      ObSelectionStrategy _object_14 = mut.getObject();
                      String _name_11 = ((SpecificClosureSelection) _object_14).getObjSel().getName();
                      _builder.append(_name_11, "\t");
                      _builder.append("\") != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      ObSelectionStrategy _object_15 = mut.getObject();
                      String _name_12 = ((SpecificClosureSelection) _object_15).getObjSel().getName();
                      _builder.append(_name_12, "\t\t");
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _object_16 = mut.getObject();
                      String _name_13 = ((SpecificClosureSelection) _object_16).getObjSel().getName();
                      _builder.append(_name_13, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                      ObSelectionStrategy _object_17 = mut.getObject();
                      String _name_14 = ((SpecificClosureSelection) _object_17).getObjSel().getName();
                      _builder.append(_name_14, "\t\t");
                      _builder.append(".getKey());");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("if (recovered == null) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("return numMutantsGenerated;");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("objectSelection = new SpecificObjectSelection(packages, model, recovered);");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("} else {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("if (hmList.get(\"");
                      ObSelectionStrategy _object_18 = mut.getObject();
                      String _name_15 = ((SpecificClosureSelection) _object_18).getObjSel().getName();
                      _builder.append(_name_15, "\t\t");
                      _builder.append("\") != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                      ObSelectionStrategy _object_19 = mut.getObject();
                      String _name_16 = ((SpecificClosureSelection) _object_19).getObjSel().getName();
                      _builder.append(_name_16, "\t\t\t");
                      _builder.append(" = hmList.get(\"");
                      ObSelectionStrategy _object_20 = mut.getObject();
                      String _name_17 = ((SpecificClosureSelection) _object_20).getObjSel().getName();
                      _builder.append(_name_17, "\t\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                      ObSelectionStrategy _object_21 = mut.getObject();
                      String _name_18 = ((SpecificClosureSelection) _object_21).getObjSel().getName();
                      _builder.append(_name_18, "\t\t\t");
                      _builder.append(") {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t\t\t");
                      _builder.append("EObject obj = ModelManager.getObject(model, ent.getKey());");
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
                      _builder.append("objectSelection = new SpecificObjectSelection(packages, model, objs);");
                      _builder.newLine();
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
                      _builder.append("return numMutantsGenerated;");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("if (objectSelection != null) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("objects.add(objectSelection.getObject());");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                      {
                        EReference _refType_1 = mut.getObject().getRefType();
                        boolean _tripleNotEquals_1 = (_refType_1 != null);
                        if (_tripleNotEquals_1) {
                          _builder.append("\t");
                          _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                          String _name_19 = mut.getObject().getRefType().getName();
                          _builder.append(_name_19, "\t");
                          _builder.append("\", objectSelection.getObject());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("EObject object = o.get(ModelManager.getRandomIndex(o));");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("objects.add(object);");
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
        {
          ObSelectionStrategy _container = mut.getContainer();
          boolean _tripleEquals_2 = (_container == null);
          if (_tripleEquals_2) {
            _builder.append("if (objects == null || objects.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("return numMutantsGenerated;");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("String tempModel =");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
            _builder.append("WodelTempModelContext.nextModelPath(");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\"");
            _builder.append(methodName, "\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("for (int obn = 0; obn < objects.size(); obn++) {");
            _builder.newLine();
            _builder.append("    \t");
            _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t");
            _builder.append("Resource resource = owned.own(");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t                    ");
            _builder.append("ModelManager.cloneModel(");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t                        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("    \t\t\t\t\t\t\t                        ");
            _builder.append("tempModel));");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Resource m = EMFCopier.copyResource(resource);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("models.add(m);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            {
              if (((mut.getObject() instanceof SpecificObjectSelection) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("\t");
                _builder.append("List<EObject> mObjects = ModelManager.getObjects(m, objects);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_22 = mut.getObject();
              if ((_object_22 instanceof RandomTypeSelection)) {
                _builder.append("\t");
                _builder.append("rts = new RandomTypeSelection(packages, m, \"");
                ObSelectionStrategy _object_23 = mut.getObject();
                String _name_20 = ((RandomTypeSelection) _object_23).getType().getName();
                _builder.append(_name_20, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("List<EObject> mObjects = rts.getObjects();");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_24 = mut.getObject();
              if ((_object_24 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.append("cts = new RandomTypeSelection(packages, m, \"");
                ObSelectionStrategy _object_25 = mut.getObject();
                String _name_21 = ((CompleteTypeSelection) _object_25).getType().getName();
                _builder.append(_name_21, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("List<EObject> mObjects = cts.getObjects();");
                _builder.newLine();
              }
            }
            {
              if (((mut.getObject() instanceof SpecificObjectSelection) || (mut.getObject() instanceof SpecificClosureSelection))) {
                _builder.append("\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_26 = mut.getObject();
              if ((_object_26 instanceof RandomTypeSelection)) {
                _builder.append("\t\t");
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_27 = mut.getObject();
              if ((_object_27 instanceof CompleteTypeSelection)) {
                _builder.append("\t\t");
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("if (mObjects.size() > obn) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("EObject container = ModelManager.getContainer(m, objectSelection.getObject());");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof RandomTypeSelection)) {
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, m, \"");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_22 = ((RandomTypeSelection) _container_2).getType().getName();
                _builder.append(_name_22);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);");
                _builder.newLine();
                {
                  EReference _refType_2 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_2 = (_refType_2 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, \"");
                    String _name_23 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_23);
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_3 = mut.getContainer();
              if ((_container_3 instanceof CompleteTypeSelection)) {
                _builder.newLine();
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, m, \"");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_24 = ((CompleteTypeSelection) _container_4).getType().getName();
                _builder.append(_name_24);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);");
                _builder.newLine();
                {
                  EReference _refType_3 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_3 = (_refType_3 != null);
                  if (_tripleNotEquals_3) {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, \"");
                    String _name_25 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_25);
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);");
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
                String _name_26 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                _builder.append(_name_26);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_27 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_27);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_28 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_28);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                ObSelectionStrategy _container_9 = mut.getContainer();
                String _name_29 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                _builder.append(_name_29, "\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_4 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_4 = (_refType_4 != null);
                  if (_tripleNotEquals_4) {
                    _builder.append("containerSelection = new SpecificObjectSelection(packages, m, recovered);");
                    _builder.newLine();
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, m, \"");
                    String _name_30 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_30);
                    _builder.append("\", recovered);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, m, null, null);");
                    _builder.newLine();
                  }
                }
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_10 = mut.getContainer();
              if ((_container_10 instanceof SpecificClosureSelection)) {
                _builder.append("ObSelectionStrategy containerSelection = null;");
                _builder.newLine();
                _builder.append("SpecificReferenceSelection referenceSelection = null;");
                _builder.newLine();
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_11 = mut.getContainer();
                String _name_31 = ((SpecificClosureSelection) _container_11).getObjSel().getName();
                _builder.append(_name_31);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_12 = mut.getContainer();
                String _name_32 = ((SpecificClosureSelection) _container_12).getObjSel().getName();
                _builder.append(_name_32);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _container_13 = mut.getContainer();
                String _name_33 = ((SpecificClosureSelection) _container_13).getObjSel().getName();
                _builder.append(_name_33);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                ObSelectionStrategy _container_14 = mut.getContainer();
                String _name_34 = ((SpecificClosureSelection) _container_14).getObjSel().getName();
                _builder.append(_name_34, "\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_5 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_5 = (_refType_5 != null);
                  if (_tripleNotEquals_5) {
                    _builder.append("containerSelection = new SpecificClosureSelection(packages, m, recovered, \"");
                    ObSelectionStrategy _container_15 = mut.getContainer();
                    String _name_35 = ((SpecificClosureSelection) _container_15).getObjSel().getName();
                    _builder.append(_name_35);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("referenceSelection = new SpecificReferenceSelection(pakages, m, \"");
                    String _name_36 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_36);
                    _builder.append("\", recovered);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, m, null, null);");
                    _builder.newLine();
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
        _builder.append("Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();");
        _builder.newLine();
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER:");
        String _xblockexpression_2 = null;
        {
          counter[0] = 0;
          _xblockexpression_2 = "";
        }
        _builder.append(_xblockexpression_2);
        _builder.newLineIfNotEmpty();
        _builder.append("//POSITION:");
        int position = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeSet> _attributes = mut.getAttributes();
          for(final AttributeSet c : _attributes) {
            _builder.append("//COUNTER:");
            String _xblockexpression_3 = null;
            {
              int _get_6 = counter[0];
              int _plus = (_get_6 + 1);
              counter[0] = _plus;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3);
            _builder.newLineIfNotEmpty();
            _builder.append("//POSITION");
            String _xblockexpression_4 = null;
            {
              position++;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4);
            _builder.newLineIfNotEmpty();
            CharSequence _method_2 = this.method(c, false, false, counter, position, true, "objectSelection");
            _builder.append(_method_2);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();");
        _builder.newLine();
        {
          EList<ReferenceSet> _references = mut.getReferences();
          for(final ReferenceSet c_1 : _references) {
            _builder.append("//COUNTER:");
            String _xblockexpression_5 = null;
            {
              int _get_6 = counter[0];
              int _plus = (_get_6 + 1);
              counter[0] = _plus;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5);
            _builder.newLineIfNotEmpty();
            _builder.append("//EXPRESSION LIST: ");
            List<Integer> expressionList_2 = new ArrayList<Integer>();
            _builder.newLineIfNotEmpty();
            _builder.append("//EXPRESSION LEVEL: ");
            boolean _add_2 = expressionList_2.add(Integer.valueOf(0));
            _builder.append(_add_2);
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression_2 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int _set_6 = nExpression_2[0] = 0;
            _builder.append(_set_6);
            _builder.newLineIfNotEmpty();
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression_2 = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_7 = recursionIndexExpression_2[0] = 0;
            _builder.append(_set_7);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//");
            boolean[] evaluation_2 = new boolean[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//");
            String _xblockexpression_6 = null;
            {
              evaluation_2[0] = false;
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6, "\t\t");
            _builder.newLineIfNotEmpty();
            CharSequence _method_3 = this.method(c_1, mut, counter, expressionList_2, nExpression_2, recursionIndexExpression_2, true, false, false, evaluation_2);
            _builder.append(_method_3);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          ObSelectionStrategy _container_16 = mut.getContainer();
          boolean _tripleNotEquals_6 = (_container_16 != null);
          if (_tripleNotEquals_6) {
            {
              ObSelectionStrategy _object_28 = mut.getObject();
              if ((_object_28 instanceof RandomTypeSelection)) {
                _builder.append("CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), ");
                boolean _isContents = mut.isContents();
                _builder.append(_isContents);
                _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                ObSelectionStrategy _object_29 = mut.getObject();
                String _name_37 = ((RandomTypeSelection) _object_29).getType().getName();
                _builder.append(_name_37);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                ObSelectionStrategy _object_30 = mut.getObject();
                if ((_object_30 instanceof CompleteTypeSelection)) {
                  _builder.append("CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), ");
                  boolean _isContents_1 = mut.isContents();
                  _builder.append(_isContents_1);
                  _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                  ObSelectionStrategy _object_31 = mut.getObject();
                  String _name_38 = ((CompleteTypeSelection) _object_31).getType().getName();
                  _builder.append(_name_38);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                } else {
                  ObSelectionStrategy _object_32 = mut.getObject();
                  if ((_object_32 instanceof SpecificObjectSelection)) {
                    _builder.append("CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), ");
                    boolean _isContents_2 = mut.isContents();
                    _builder.append(_isContents_2);
                    _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                    ObSelectionStrategy _object_33 = mut.getObject();
                    ObjectEmitter _objSel = ((SpecificObjectSelection) _object_33).getObjSel();
                    String _name_39 = ((SelectObjectMutator) _objSel).getObject().getType().getName();
                    _builder.append(_name_39);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    ObSelectionStrategy _object_34 = mut.getObject();
                    if ((_object_34 instanceof SpecificClosureSelection)) {
                      _builder.append("CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), ");
                      boolean _isContents_3 = mut.isContents();
                      _builder.append(_isContents_3);
                      _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                      ObSelectionStrategy _object_35 = mut.getObject();
                      ObjectEmitter _objSel_1 = ((SpecificClosureSelection) _object_35).getObjSel();
                      String _name_40 = ((SelectObjectMutator) _objSel_1).getObject().getType().getName();
                      _builder.append(_name_40);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
        {
          ObSelectionStrategy _container_17 = mut.getContainer();
          boolean _tripleEquals_3 = (_container_17 == null);
          if (_tripleEquals_3) {
            {
              ObSelectionStrategy _object_36 = mut.getObject();
              if ((_object_36 instanceof RandomTypeSelection)) {
                _builder.append("CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), ");
                boolean _isContents_4 = mut.isContents();
                _builder.append(_isContents_4);
                _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                ObSelectionStrategy _object_37 = mut.getObject();
                String _name_41 = ((RandomTypeSelection) _object_37).getType().getName();
                _builder.append(_name_41);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                ObSelectionStrategy _object_38 = mut.getObject();
                if ((_object_38 instanceof CompleteTypeSelection)) {
                  _builder.append("CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), ");
                  boolean _isContents_5 = mut.isContents();
                  _builder.append(_isContents_5);
                  _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                  ObSelectionStrategy _object_39 = mut.getObject();
                  String _name_42 = ((CompleteTypeSelection) _object_39).getType().getName();
                  _builder.append(_name_42);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                } else {
                  ObSelectionStrategy _object_40 = mut.getObject();
                  if ((_object_40 instanceof SpecificObjectSelection)) {
                    _builder.append("CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), ");
                    boolean _isContents_6 = mut.isContents();
                    _builder.append(_isContents_6);
                    _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                    ObSelectionStrategy _object_41 = mut.getObject();
                    ObjectEmitter _objSel_2 = ((SpecificObjectSelection) _object_41).getObjSel();
                    String _name_43 = ((SelectObjectMutator) _objSel_2).getObject().getType().getName();
                    _builder.append(_name_43);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    ObSelectionStrategy _object_42 = mut.getObject();
                    if ((_object_42 instanceof SpecificClosureSelection)) {
                      _builder.append("CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), ");
                      boolean _isContents_7 = mut.isContents();
                      _builder.append(_isContents_7);
                      _builder.append(", referenceSelection, containerSelection, atts, refs, \"");
                      ObSelectionStrategy _object_43 = mut.getObject();
                      ObjectEmitter _objSel_3 = ((SpecificClosureSelection) _object_43).getObjSel();
                      String _name_44 = ((SelectObjectMutator) _objSel_3).getObject().getType().getName();
                      _builder.append(_name_44);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
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
        int _get_6 = nRegistryMutation[0];
        int _plus = (_get_6 + 1);
        int _set_8 = nRegistryMutation[0] = _plus;
        _builder.append(_set_8);
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER: ");
        int _get_7 = nRegistryMethodCall[0];
        int _plus_1 = (_get_7 + 1);
        int _set_9 = nRegistryMethodCall[0] = _plus_1;
        _builder.append(_set_9);
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
            _builder.append("\t            ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (mutated != null) {");
            _builder.newLine();
            {
              String _name_45 = mut.getName();
              boolean _tripleNotEquals_7 = (_name_45 != null);
              if (_tripleNotEquals_7) {
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                _builder.newLine();
                {
                  ObSelectionStrategy _container_18 = mut.getContainer();
                  boolean _not = (!(_container_18 instanceof CompleteTypeSelection));
                  if (_not) {
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.put(\"");
                    String _name_46 = mut.getName();
                    _builder.append(_name_46, "\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.remove(\"");
                    String _name_47 = mut.getName();
                    _builder.append(_name_47, "\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("hmList.put(\"");
                    String _name_48 = mut.getName();
                    _builder.append(_name_48, "\t\t\t");
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
        int _get_8 = nMethodCall[0];
        int _plus_2 = (_get_8 + 1);
        int _set_10 = nMethodCall[0] = _plus_2;
        _builder.append(_set_10, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("//MUTATION METHOD NAME:");
        String _string_1 = Integer.valueOf((nMethodCall[0])).toString();
        String nMethodName = ("mutation" + _string_1);
        _builder.newLineIfNotEmpty();
        {
          if ((last == false)) {
            {
              ObSelectionStrategy _container_19 = mut.getContainer();
              boolean _tripleNotEquals_8 = (_container_19 != null);
              if (_tripleNotEquals_8) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t");
                    _builder.append(nMethodName, "\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append(nMethodName, "\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, k, serialize, test, classes);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t");
                _builder.append("numMutantsGenerated = k[0];");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_20 = mut.getContainer();
              boolean _tripleEquals_4 = (_container_20 == null);
              if (_tripleEquals_4) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t");
                    _builder.append(nMethodName, "\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append(nMethodName, "\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
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
            _builder.append("\t\t\t\t\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t");
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
                String _name_49 = constraint.getType().getName();
                _builder.append(_name_49, "\t\t");
                _builder.append("\") == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("rules.put(\"");
                String _name_50 = constraint.getType().getName();
                _builder.append(_name_50, "\t\t\t");
                _builder.append("\", new ArrayList<String>());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("List<String> newrules = rules.get(\"");
                String _name_51 = constraint.getType().getName();
                _builder.append(_name_51, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InvariantCS> _expressions = constraint.getExpressions();
                  boolean _tripleNotEquals_9 = (_expressions != null);
                  if (_tripleNotEquals_9) {
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
                  boolean _tripleNotEquals_10 = (_rules != null);
                  if (_tripleNotEquals_10) {
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
                String _name_52 = constraint.getType().getName();
                _builder.append(_name_52, "\t\t");
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
                  boolean _equals_2 = (_size == 0);
                  if (_equals_2) {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_53 = b.getName();
                    _builder.append(_name_53);
                    _builder.append("/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_54 = b.getName();
                    _builder.append(_name_54);
                    _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
            _builder.newLine();
            {
              if ((b == null)) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, executionSeed);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_55 = project.getName();
                    _builder.append(_name_55, "\t\t   \t\t\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t\t   \t\t\t");
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
                    String _name_56 = b.getName();
                    _builder.append(_name_56);
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_57 = b.getName();
                    _builder.append(_name_57, "\t");
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_58 = project.getName();
                    _builder.append(_name_58, "\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t");
                    _builder.append(".class, true, false);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (isRepeated == false) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("numMutantsGenerated++;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("monitor.worked(1);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("k[0] = k[0] + 1;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("//if (muts != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("//\tmuts.getMuts().clear();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("//}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("}\t\t\t\t\t\t\t");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
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
