package wodel.dsls.generator.mutators.exhaustive;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.RemoveObjectMutator;
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
public class WodelGeneratorRemoveObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.newLine();
    {
      if ((mt instanceof RemoveObjectMutator)) {
        _builder.append("\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return numMutantsGenerated;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//");
        RemoveObjectMutator mut = ((RemoveObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// REMOVE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("SpecificReferenceSelection referenceSelection = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//");
        boolean rts = false;
        _builder.newLineIfNotEmpty();
        {
          if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
            {
              ObSelectionStrategy _container = mut.getContainer();
              boolean _tripleEquals = (_container == null);
              if (_tripleEquals) {
                {
                  ObSelectionStrategy _object = mut.getObject();
                  if ((_object instanceof RandomTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("//");
                    _builder.append(rts = true, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                    ObSelectionStrategy _object_1 = mut.getObject();
                    String _name = ((RandomTypeSelection) _object_1).getType().getName();
                    _builder.append(_name, "\t\t");
                    _builder.append("\", mutatedObjects);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  ObSelectionStrategy _object_2 = mut.getObject();
                  if ((_object_2 instanceof CompleteTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("//");
                    _builder.append(rts = true, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                    ObSelectionStrategy _object_3 = mut.getObject();
                    String _name_1 = ((CompleteTypeSelection) _object_3).getType().getName();
                    _builder.append(_name_1, "\t\t");
                    _builder.append("\", mutatedObjects);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                {
                  ObSelectionStrategy _container_1 = mut.getContainer();
                  if ((_container_1 instanceof RandomTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("//");
                    _builder.append(rts = true, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                    ObSelectionStrategy _container_2 = mut.getContainer();
                    String _name_2 = ((RandomTypeSelection) _container_2).getType().getName();
                    _builder.append(_name_2, "\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("EObject container = rts.getObject();");
                    _builder.newLine();
                    {
                      String _resource = mut.getContainer().getResource();
                      boolean _tripleEquals_1 = (_resource == null);
                      if (_tripleEquals_1) {
                        _builder.append("\t\t");
                        _builder.append("containerSelection = new SpecificObjectSelection(packages, seed, container);");
                        _builder.newLine();
                      } else {
                      }
                    }
                    {
                      EReference _refType = mut.getContainer().getRefType();
                      boolean _tripleNotEquals = (_refType != null);
                      if (_tripleNotEquals) {
                        _builder.append("\t\t");
                        _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                        String _name_3 = mut.getContainer().getRefType().getName();
                        _builder.append(_name_3, "\t\t");
                        _builder.append("\", containerSelection);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t");
                        _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                        _builder.newLine();
                      }
                    }
                  } else {
                    ObSelectionStrategy _container_3 = mut.getContainer();
                    if ((_container_3 instanceof CompleteTypeSelection)) {
                      _builder.append("\t\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("//");
                      _builder.append(rts = true, "\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                      ObSelectionStrategy _container_4 = mut.getContainer();
                      String _name_4 = ((CompleteTypeSelection) _container_4).getType().getName();
                      _builder.append(_name_4, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("EObject container = rts.getObject();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("containerSelection = new SpecificObjectSelection(packages, models, container);");
                      _builder.newLine();
                      {
                        EReference _refType_1 = mut.getContainer().getRefType();
                        boolean _tripleNotEquals_1 = (_refType_1 != null);
                        if (_tripleNotEquals_1) {
                          {
                            String _resource_1 = mut.getContainer().getResource();
                            boolean _tripleEquals_2 = (_resource_1 == null);
                            if (_tripleEquals_2) {
                              _builder.append("\t\t");
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                              String _name_5 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_5, "\t\t");
                              _builder.append("\", containerSelection);");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("\t\t");
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, seed, \"");
                              String _name_6 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_6, "\t\t");
                              _builder.append("\", containerSelection);");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                        } else {
                          _builder.append("\t\t");
                          _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                          _builder.newLine();
                        }
                      }
                    } else {
                      ObSelectionStrategy _container_5 = mut.getContainer();
                      if ((_container_5 instanceof SpecificObjectSelection)) {
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        ObSelectionStrategy _container_6 = mut.getContainer();
                        String _name_7 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                        _builder.append(_name_7, "\t\t");
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _container_7 = mut.getContainer();
                        String _name_8 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                        _builder.append(_name_8, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("if (entry_");
                        ObSelectionStrategy _container_8 = mut.getContainer();
                        String _name_9 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                        _builder.append(_name_9, "\t\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                        ObSelectionStrategy _container_9 = mut.getContainer();
                        String _name_10 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                        _builder.append(_name_10, "\t\t\t");
                        _builder.append(".getKey());");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("if (recovered == null) {");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          String _resource_2 = mut.getContainer().getResource();
                          boolean _tripleEquals_3 = (_resource_2 == null);
                          if (_tripleEquals_3) {
                            _builder.append("\t\t");
                            _builder.append("containerSelection = new SpecificObjectSelection(packages, models, recovered);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("containerSelection = new SpecificObjectSelection(packages, seed, recovered);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("} else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          EReference _refType_2 = mut.getContainer().getRefType();
                          boolean _tripleNotEquals_2 = (_refType_2 != null);
                          if (_tripleNotEquals_2) {
                            _builder.append("\t\t");
                            _builder.append("if (entry_");
                            ObSelectionStrategy _container_10 = mut.getContainer();
                            String _name_11 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                            _builder.append(_name_11, "\t\t");
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                            ObSelectionStrategy _container_11 = mut.getContainer();
                            String _name_12 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                            _builder.append(_name_12, "\t\t\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t");
                            _builder.append("if (recovered == null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                            String _name_13 = mut.getContainer().getRefType().getName();
                            _builder.append(_name_13, "\t\t\t");
                            _builder.append("\", recovered);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("} else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                  }
                }
                {
                  if ((rts == true)) {
                    {
                      ObSelectionStrategy _object_4 = mut.getObject();
                      if ((_object_4 instanceof RandomTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.append("rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                        ObSelectionStrategy _object_5 = mut.getObject();
                        String _name_14 = ((RandomTypeSelection) _object_5).getType().getName();
                        _builder.append(_name_14, "\t\t");
                        _builder.append("\", referenceSelection, containerSelection);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        ObSelectionStrategy _object_6 = mut.getObject();
                        if ((_object_6 instanceof CompleteTypeSelection)) {
                          _builder.append("\t\t");
                          _builder.append("rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                          ObSelectionStrategy _object_7 = mut.getObject();
                          String _name_15 = ((CompleteTypeSelection) _object_7).getType().getName();
                          _builder.append(_name_15, "\t\t");
                          _builder.append("\", referenceSelection, containerSelection);");
                          _builder.newLineIfNotEmpty();
                        } else {
                          ObSelectionStrategy _object_8 = mut.getObject();
                          if ((_object_8 instanceof SpecificObjectSelection)) {
                            _builder.append("\t\t");
                            _builder.append("rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                            ObSelectionStrategy _object_9 = mut.getObject();
                            String _name_16 = ((SpecificObjectSelection) _object_9).getType().getName();
                            _builder.append(_name_16, "\t\t");
                            _builder.append("\", referenceSelection, containerSelection);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  } else {
                    {
                      ObSelectionStrategy _object_10 = mut.getObject();
                      if ((_object_10 instanceof RandomTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                        ObSelectionStrategy _object_11 = mut.getObject();
                        String _name_17 = ((RandomTypeSelection) _object_11).getType().getName();
                        _builder.append(_name_17, "\t\t");
                        _builder.append("\", referenceSelection, containerSelection);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        ObSelectionStrategy _object_12 = mut.getObject();
                        if ((_object_12 instanceof CompleteTypeSelection)) {
                          _builder.append("\t\t");
                          _builder.append("RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                          ObSelectionStrategy _object_13 = mut.getObject();
                          String _name_18 = ((CompleteTypeSelection) _object_13).getType().getName();
                          _builder.append(_name_18, "\t\t");
                          _builder.append("\", referenceSelection, containerSelection);");
                          _builder.newLineIfNotEmpty();
                        } else {
                          ObSelectionStrategy _object_14 = mut.getObject();
                          if ((_object_14 instanceof SpecificObjectSelection)) {
                            _builder.append("\t\t");
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                            ObSelectionStrategy _object_15 = mut.getObject();
                            String _name_19 = ((SpecificObjectSelection) _object_15).getType().getName();
                            _builder.append(_name_19, "\t\t");
                            _builder.append("\", referenceSelection, containerSelection);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
                {
                  if (((mut.getObject().getExpression() == null) && (mut.getContainer().getExpression() == null))) {
                    _builder.append("\t\t");
                    _builder.append("List<EObject> objects = rts.getObjects();");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if (((mut.getObject().getExpression() == null) && (mut.getContainer() == null))) {
                _builder.append("\t\t");
                _builder.append("List<EObject> objects = rts.getObjects();");
                _builder.newLine();
              }
            }
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleNotEquals_3 = (_expression != null);
              if (_tripleNotEquals_3) {
                {
                  ObSelectionStrategy _container_12 = mut.getContainer();
                  boolean _tripleEquals_4 = (_container_12 == null);
                  if (_tripleEquals_4) {
                    _builder.append("\t\t");
                    _builder.append("List<EObject> objects = rts.getObjects();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("//EXPRESSION LIST: ");
                    List<Integer> expressionList = new ArrayList<Integer>();
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//EXPRESSION LEVEL: ");
                    boolean _add = expressionList.add(Integer.valueOf(0));
                    _builder.append(_add, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//INDEX EXPRESSION: ");
                    int[] nExpression = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//INDEX EXPRESSION: ");
                    int _set = nExpression[0] = 0;
                    _builder.append(_set, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//RECURSION INDEX EXPRESSION: ");
                    int[] recursionIndexExpression = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//RECURSION INDEX EXPRESSION: ");
                    int _set_1 = recursionIndexExpression[0] = 0;
                    _builder.append(_set_1, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("Expression exp");
                    Integer _get = expressionList.get(0);
                    _builder.append(_get, "\t\t");
                    _builder.append(" = new Expression();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    int[] nReference = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    int _set_2 = nReference[0] = 0;
                    _builder.append(_set_2, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    boolean[] evaluation = new boolean[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    String _xblockexpression = null;
                    {
                      evaluation[0] = false;
                      _xblockexpression = "";
                    }
                    _builder.append(_xblockexpression, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation);
                    _builder.append(_method, "\t\t");
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _get_1 = evaluation[0];
                      boolean _equals = (_get_1 == false);
                      if (_equals) {
                        _builder.append("\t\t");
                        _builder.append("objects = evaluate(objects, exp");
                        Integer _get_2 = expressionList.get(0);
                        _builder.append(_get_2, "\t\t");
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t");
                        _builder.append("objects = auxObjects;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    Expression _expression_1 = mut.getContainer().getExpression();
                    boolean _tripleEquals_5 = (_expression_1 == null);
                    if (_tripleEquals_5) {
                      _builder.append("\t\t");
                      _builder.append("List<EObject> objects = rts.getObjects();");
                      _builder.newLine();
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
                      _builder.append("\t\t");
                      _builder.append("Expression exp");
                      Integer _get_3 = expressionList_1.get(0);
                      _builder.append(_get_3, "\t\t");
                      _builder.append(" = new Expression();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      int[] nReference_1 = new int[1];
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      int _set_5 = nReference_1[0] = 0;
                      _builder.append(_set_5, "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
            {
              Expression _expression_2 = mut.getObject().getExpression();
              boolean _tripleEquals_6 = (_expression_2 == null);
              if (_tripleEquals_6) {
                {
                  if (((mut.getContainer() != null) && (mut.getContainer().getExpression() != null))) {
                    _builder.append("\t\t");
                    _builder.append("List<EObject> objects = rts.getObjects();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("//EXPRESSION LIST: ");
                    List<Integer> expressionList_2 = new ArrayList<Integer>();
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//EXPRESSION LEVEL: ");
                    boolean _add_2 = expressionList_2.add(Integer.valueOf(0));
                    _builder.append(_add_2, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//INDEX EXPRESSION: ");
                    int[] nExpression_2 = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//INDEX EXPRESSION: ");
                    int _set_6 = nExpression_2[0] = 0;
                    _builder.append(_set_6, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//RECURSION INDEX EXPRESSION: ");
                    int[] recursionIndexExpression_2 = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//RECURSION INDEX EXPRESSION: ");
                    int _set_7 = recursionIndexExpression_2[0] = 0;
                    _builder.append(_set_7, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("Expression exp");
                    Integer _get_4 = expressionList_2.get(0);
                    _builder.append(_get_4, "\t\t");
                    _builder.append(" = new Expression();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    int[] nReference_2 = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    int _set_8 = nReference_2[0] = 0;
                    _builder.append(_set_8, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    boolean[] evaluation_1 = new boolean[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//");
                    String _xblockexpression_1 = null;
                    {
                      evaluation_1[0] = false;
                      _xblockexpression_1 = "";
                    }
                    _builder.append(_xblockexpression_1, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    Object _method_1 = this.method(mut.getContainer().getExpression(), mut, nReference_2, expressionList_2, nExpression_2, recursionIndexExpression_2, true, false, false, evaluation_1);
                    _builder.append(_method_1, "\t\t");
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _get_5 = evaluation_1[0];
                      boolean _equals_1 = (_get_5 == false);
                      if (_equals_1) {
                        _builder.append("objects = evaluate(objects, exp");
                        Integer _get_6 = expressionList_2.get(0);
                        _builder.append(_get_6);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("objects = auxObjects;");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
          } else {
            ObSelectionStrategy _object_16 = mut.getObject();
            if ((_object_16 instanceof SpecificObjectSelection)) {
              _builder.append("\t\t");
              _builder.append("List<EObject> objects = new ArrayList<EObject>();");
              _builder.newLine();
              {
                ObSelectionStrategy _container_13 = mut.getContainer();
                boolean _tripleEquals_7 = (_container_13 == null);
                if (_tripleEquals_7) {
                  _builder.append("\t\t");
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _object_17 = mut.getObject();
                  String _name_20 = ((SpecificObjectSelection) _object_17).getObjSel().getName();
                  _builder.append(_name_20, "\t\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _object_18 = mut.getObject();
                  String _name_21 = ((SpecificObjectSelection) _object_18).getObjSel().getName();
                  _builder.append(_name_21, "\t\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _object_19 = mut.getObject();
                  String _name_22 = ((SpecificObjectSelection) _object_19).getObjSel().getName();
                  _builder.append(_name_22, "\t\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                  ObSelectionStrategy _object_20 = mut.getObject();
                  String _name_23 = ((SpecificObjectSelection) _object_20).getObjSel().getName();
                  _builder.append(_name_23, "\t\t\t");
                  _builder.append(".getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("if (recovered == null) {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificObjectSelection(packages, models, recovered);");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("objects.add(objectSelection.getObject());");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  {
                    ObSelectionStrategy _container_14 = mut.getContainer();
                    if ((_container_14 instanceof RandomTypeSelection)) {
                      _builder.append("\t\t");
                      _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                      ObSelectionStrategy _container_15 = mut.getContainer();
                      String _name_24 = ((RandomTypeSelection) _container_15).getType().getName();
                      _builder.append(_name_24, "\t\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("EObject container = rts.getObject();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("containerSelection = new SpecificObjectSelection(packages, models, container);");
                      _builder.newLine();
                      {
                        EReference _refType_3 = mut.getContainer().getRefType();
                        boolean _tripleNotEquals_4 = (_refType_3 != null);
                        if (_tripleNotEquals_4) {
                          _builder.append("\t\t\t\t");
                          _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                          String _name_25 = mut.getContainer().getRefType().getName();
                          _builder.append(_name_25, "\t\t\t\t");
                          _builder.append("\", containerSelection);");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t\t\t\t");
                          _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                          _builder.newLine();
                        }
                      }
                    } else {
                      ObSelectionStrategy _container_16 = mut.getContainer();
                      if ((_container_16 instanceof CompleteTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, models, \"");
                        ObSelectionStrategy _container_17 = mut.getContainer();
                        String _name_26 = ((CompleteTypeSelection) _container_17).getType().getName();
                        _builder.append(_name_26, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("EObject container = rts.getObject();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("containerSelection = new SpecificObjectSelection(packages, models, container);");
                        _builder.newLine();
                        {
                          EReference _refType_4 = mut.getContainer().getRefType();
                          boolean _tripleNotEquals_5 = (_refType_4 != null);
                          if (_tripleNotEquals_5) {
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                            String _name_27 = mut.getContainer().getRefType().getName();
                            _builder.append(_name_27, "\t\t\t\t");
                            _builder.append("\", containerSelection);");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                            _builder.newLine();
                          }
                        }
                      } else {
                        ObSelectionStrategy _container_18 = mut.getContainer();
                        if ((_container_18 instanceof SpecificObjectSelection)) {
                          _builder.append("\t\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _container_19 = mut.getContainer();
                          String _name_28 = ((SpecificObjectSelection) _container_19).getObjSel().getName();
                          _builder.append(_name_28, "\t\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _container_20 = mut.getContainer();
                          String _name_29 = ((SpecificObjectSelection) _container_20).getObjSel().getName();
                          _builder.append(_name_29, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("if (entry_");
                          ObSelectionStrategy _container_21 = mut.getContainer();
                          String _name_30 = ((SpecificObjectSelection) _container_21).getObjSel().getName();
                          _builder.append(_name_30, "\t\t");
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                          ObSelectionStrategy _container_22 = mut.getContainer();
                          String _name_31 = ((SpecificObjectSelection) _container_22).getObjSel().getName();
                          _builder.append(_name_31, "\t\t\t");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t");
                          _builder.append("if (recovered == null) {");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("containerSelection = new SpecificObjectSelection(packages, models, recovered);");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          {
                            EReference _refType_5 = mut.getContainer().getRefType();
                            boolean _tripleNotEquals_6 = (_refType_5 != null);
                            if (_tripleNotEquals_6) {
                              _builder.append("\t\t\t\t");
                              _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                              ObSelectionStrategy _container_23 = mut.getContainer();
                              String _name_32 = ((SpecificObjectSelection) _container_23).getObjSel().getName();
                              _builder.append(_name_32, "\t\t\t\t");
                              _builder.append(" = hmObjects.get(\"");
                              ObSelectionStrategy _container_24 = mut.getContainer();
                              String _name_33 = ((SpecificObjectSelection) _container_24).getObjSel().getName();
                              _builder.append(_name_33, "\t\t\t\t");
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t\t");
                              _builder.append("if (entry_");
                              ObSelectionStrategy _container_25 = mut.getContainer();
                              String _name_34 = ((SpecificObjectSelection) _container_25).getObjSel().getName();
                              _builder.append(_name_34, "\t\t\t\t");
                              _builder.append(" != null) {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t\t");
                              _builder.append("\t");
                              _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                              ObSelectionStrategy _container_26 = mut.getContainer();
                              String _name_35 = ((SpecificObjectSelection) _container_26).getObjSel().getName();
                              _builder.append(_name_35, "\t\t\t\t\t");
                              _builder.append(".getKey());");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t\t");
                              _builder.append("if (recovered == null) {");
                              _builder.newLine();
                              _builder.append("\t\t\t\t");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                              _builder.append("\t\t\t\t");
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("\t\t\t\t");
                              _builder.append("\t");
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                              String _name_36 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_36, "\t\t\t\t\t");
                              _builder.append("\", recovered);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t\t");
                              _builder.append("} else {");
                              _builder.newLine();
                              _builder.append("\t\t\t\t");
                              _builder.append("\t");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                              _builder.append("\t\t\t\t");
                              _builder.append("}");
                              _builder.newLine();
                            } else {
                              _builder.append("\t\t\t\t");
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                              _builder.newLine();
                            }
                          }
                        } else {
                          ObSelectionStrategy _container_27 = mut.getContainer();
                          if ((_container_27 instanceof SpecificClosureSelection)) {
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                            ObSelectionStrategy _container_28 = mut.getContainer();
                            String _name_37 = ((SpecificClosureSelection) _container_28).getObjSel().getName();
                            _builder.append(_name_37, "\t\t");
                            _builder.append(" = hmObjects.get(\"");
                            ObSelectionStrategy _container_29 = mut.getContainer();
                            String _name_38 = ((SpecificClosureSelection) _container_29).getObjSel().getName();
                            _builder.append(_name_38, "\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("if (entry_");
                            ObSelectionStrategy _container_30 = mut.getContainer();
                            String _name_39 = ((SpecificClosureSelection) _container_30).getObjSel().getName();
                            _builder.append(_name_39, "\t\t");
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                            ObSelectionStrategy _container_31 = mut.getContainer();
                            String _name_40 = ((SpecificClosureSelection) _container_31).getObjSel().getName();
                            _builder.append(_name_40, "\t\t\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t");
                            _builder.append("if (recovered == null) {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("containerSelection = new SpecificClosureSelection(packages, models, recovered, \"");
                            ObSelectionStrategy _container_32 = mut.getContainer();
                            String _name_41 = ((SpecificClosureSelection) _container_32).getRefType().getName();
                            _builder.append(_name_41, "\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("} else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            {
                              EReference _refType_6 = mut.getContainer().getRefType();
                              boolean _tripleNotEquals_7 = (_refType_6 != null);
                              if (_tripleNotEquals_7) {
                                _builder.append("\t\t\t\t");
                                _builder.append("if (entry_");
                                ObSelectionStrategy _container_33 = mut.getContainer();
                                String _name_42 = ((SpecificClosureSelection) _container_33).getObjSel().getName();
                                _builder.append(_name_42, "\t\t\t\t");
                                _builder.append(" != null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                                ObSelectionStrategy _container_34 = mut.getContainer();
                                String _name_43 = ((SpecificClosureSelection) _container_34).getObjSel().getName();
                                _builder.append(_name_43, "\t\t\t\t\t");
                                _builder.append(".getKey());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (recovered == null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("return numMutantsGenerated;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, \"");
                                String _name_44 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_44, "\t\t\t\t\t");
                                _builder.append("\", recovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("} else {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("return numMutantsGenerated;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t");
                                _builder.append("referenceSelection = new SpecificReferenceSelection(packages, models, null, null);");
                                _builder.newLine();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  _builder.append("\t\t");
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _object_21 = mut.getObject();
                  String _name_45 = ((SpecificObjectSelection) _object_21).getObjSel().getName();
                  _builder.append(_name_45, "\t\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _object_22 = mut.getObject();
                  String _name_46 = ((SpecificObjectSelection) _object_22).getObjSel().getName();
                  _builder.append(_name_46, "\t\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _object_23 = mut.getObject();
                  String _name_47 = ((SpecificObjectSelection) _object_23).getObjSel().getName();
                  _builder.append(_name_47, "\t\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(models, entry_");
                  ObSelectionStrategy _container_35 = mut.getContainer();
                  String _name_48 = ((SpecificObjectSelection) _container_35).getObjSel().getName();
                  _builder.append(_name_48, "\t\t\t");
                  _builder.append(".getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  _builder.append("if (recovered == null) {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificObjectSelection(packages, models, recovered, referenceSelection, containerSelection);");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("objects.add(objectSelection.getObject());");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return numMutantsGenerated;");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
        {
          if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof SpecificObjectSelection))) {
            _builder.append("\t\t");
            _builder.append("ObSelectionStrategy obSelection = null;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (objects == null || objects.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("return numMutantsGenerated;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("String tempModel =");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
            _builder.append("WodelTempModelContext.nextModelPath(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\"");
            _builder.append(methodName, "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("   \t\t\t");
            _builder.append("Mutator mutator = null;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (objects != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("for (EObject ob : objects) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t");
            _builder.append("Resource m = owned.own(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t                    ");
            _builder.append("ModelManager.cloneModel(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("tempModel));");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("models.add(m);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("EObject obToMutate = ModelManager.getObject(m, ob);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("obSelection = new SpecificObjectSelection(packages, m, obToMutate);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("EObject containerToMutate = null;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("if (containerSelection != null && containerSelection.getObject() != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("containerToMutate = ModelManager.getObject(m, containerSelection.getObject());");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m, containerToMutate);");
            _builder.newLine();
            {
              if ((((mut.getContainer() != null) && (mut.getContainer().getRefType() != null)) && (mut.getContainer().getRefType().getName() != null))) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(containerToMutateSelection.getMetaModel(), containerToMutateSelection.getModel(), \"");
                String _name_49 = mut.getContainer().getRefType().getName();
                _builder.append(_name_49, "\t\t\t\t");
                _builder.append("\", containerToMutateSelection.getObject());");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("SpecificReferenceSelection referenceToMutateSelection = referenceSelection;");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("RemoveObjectMutator mut = new RemoveObjectMutator(containerToMutateSelection.getModel(), containerToMutateSelection.getMetaModel(), obToMutate, referenceToMutateSelection, containerToMutateSelection);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("if (muts == null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("//COUNTER: ");
            int _get_7 = nRegistryMutation[0];
            int _plus = (_get_7 + 1);
            int _set_9 = nRegistryMutation[0] = _plus;
            _builder.append(_set_9, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//COUNTER: ");
            int _get_8 = nRegistryMethodCall[0];
            int _plus_1 = (_get_8 + 1);
            int _set_10 = nRegistryMethodCall[0] = _plus_1;
            _builder.append(_set_10, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//REGISTRY METHOD NAME:");
            String _string = Integer.valueOf((nRegistryMethodCall[0])).toString();
            String registryMethodName = ("registry" + _string);
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            _builder.append("int mutsMark = mutationMark(muts);");
            _builder.newLine();
            {
              if ((executeMutation == true)) {
                _builder.append("\t\t");
                _builder.append("if (mut != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("/*");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("* IMPORTANT:");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("* Capture the removed EObject from the PRE-MUTATION");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("* source model. Do not use mut.getObject() here:");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("* RemoveObjectMutator only populates that information");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("* during mutate().");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t     ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t    ");
                _builder.append("EObject clue =");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t        ");
                _builder.append("findEObjectForRegistry(");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("seed,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("ob,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("null,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("null,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("mutPaths,");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t            ");
                _builder.append("packages);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("Object mutated = mut.mutate();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("if (mutated != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("AppMutation appMut = ");
                _builder.append(registryMethodName, "\t\t\t\t\t");
                _builder.append("(mut, hmMutator, seed, obSelection.getModel(), clue, mutPaths, packages);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("if (appMut != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t\t");
                _builder.append("muts.getMuts().add(appMut);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t\t");
                _builder.append("}");
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
                _builder.append("\t");
                _builder.append("mutator = mut;");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (mutator != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("//COUNTER: ");
            int _get_9 = nMethodCall[0];
            int _plus_2 = (_get_9 + 1);
            int _set_11 = nMethodCall[0] = _plus_2;
            _builder.append(_set_11, "\t\t");
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
                    _builder.append("\t\t\t");
                    _builder.append(nMethodName, "\t\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append(nMethodName, "\t\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("numMutantsGenerated = k[0];");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t     ");
                _builder.append("MutatorUtils.rollbackMutations(");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t        ");
                _builder.append("muts,");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t        ");
                _builder.append("mutsMark);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              if ((last == true)) {
                _builder.append("\t");
                _builder.append("// MUTANT COMPLETION AND REGISTRY");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
                _builder.newLine();
                {
                  EList<Constraint> _constraints = e.getConstraints();
                  for(final Constraint constraint : _constraints) {
                    _builder.append("\t");
                    _builder.append("if (rules.get(\"");
                    String _name_50 = constraint.getType().getName();
                    _builder.append(_name_50, "\t");
                    _builder.append("\") == null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("rules.put(\"");
                    String _name_51 = constraint.getType().getName();
                    _builder.append(_name_51, "\t\t");
                    _builder.append("\", new ArrayList<String>());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("List<String> newrules = rules.get(\"");
                    String _name_52 = constraint.getType().getName();
                    _builder.append(_name_52, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    {
                      EList<InvariantCS> _expressions = constraint.getExpressions();
                      boolean _tripleNotEquals_8 = (_expressions != null);
                      if (_tripleNotEquals_8) {
                        {
                          EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                          for(final InvariantCS expression : _expressions_1) {
                            _builder.append("\t");
                            _builder.append("newrules.add(\"");
                            String _constraintText = WodelUtils.getConstraintText(fileURI.lastSegment(), expression);
                            _builder.append(_constraintText, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      EList<String> _rules = constraint.getRules();
                      boolean _tripleNotEquals_9 = (_rules != null);
                      if (_tripleNotEquals_9) {
                        {
                          EList<String> _rules_1 = constraint.getRules();
                          for(final String rule : _rules_1) {
                            _builder.append("\t");
                            _builder.append("newrules.add(\"");
                            _builder.append(rule, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    _builder.append("\t");
                    _builder.append("rules.put(\"");
                    String _name_53 = constraint.getType().getName();
                    _builder.append(_name_53, "\t");
                    _builder.append("\", newrules);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((b == null)) {
                    _builder.append("\t");
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                    _builder.newLine();
                  } else {
                    {
                      int _size = b.getFrom().size();
                      boolean _equals_2 = (_size == 0);
                      if (_equals_2) {
                        _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                        String _name_54 = b.getName();
                        _builder.append(_name_54);
                        _builder.append("/Output\" + k[0] + \".model\";");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                        String _name_55 = b.getName();
                        _builder.append(_name_55);
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
                        _builder.append("\t   \t\t");
                        _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);");
                        _builder.newLine();
                      } else {
                        _builder.append("\t   \t\t");
                        _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                        String _name_56 = project.getName();
                        _builder.append(_name_56, "\t   \t\t");
                        _builder.append("\", serialize, test, classes, ");
                        _builder.append(className, "\t   \t\t");
                        _builder.append(".class, true, true);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    {
                      if ((standalone == false)) {
                        _builder.append("\t   \t\t");
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                        String _name_57 = b.getName();
                        _builder.append(_name_57);
                        _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                        String _name_58 = b.getName();
                        _builder.append(_name_58, "\t");
                        _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                        String _name_59 = project.getName();
                        _builder.append(_name_59, "\t");
                        _builder.append("\", serialize, test, classes, ");
                        _builder.append(className, "\t");
                        _builder.append(".class, true, false);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("if (isRepeated == false) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("numMutantsGenerated++;");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("monitor.worked(1);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("k[0] = k[0] + 1;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("//if (muts != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("//\tmuts.getMuts().clear();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("//}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("\t\t     ");
                _builder.append("MutatorUtils.rollbackMutations(");
                _builder.newLine();
                _builder.append("\t\t        ");
                _builder.append("muts,");
                _builder.newLine();
                _builder.append("\t\t        ");
                _builder.append("mutsMark);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          ObSelectionStrategy _object_24 = mut.getObject();
          if ((_object_24 instanceof CompleteTypeSelection)) {
            _builder.append("if (objects == null || objects.isEmpty()) {");
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
            _builder.append("\t\t");
            _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("Resource m = owned.own(");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    ");
            _builder.append("ModelManager.cloneModel(");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        ");
            _builder.append("tempModel));");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("models.add(m);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("ObSelectionStrategy obSelection = null;");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("Mutator mutator = null;");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("if (objects != null) {");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("obSelection = new SpecificObjectSelection(packages, model, objects);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), objects, referenceSelection, containerSelection);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("if (muts == null) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("//COUNTER: ");
            int _get_10 = nRegistryMutation[0];
            int _plus_3 = (_get_10 + 1);
            int _set_12 = nRegistryMutation[0] = _plus_3;
            _builder.append(_set_12, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("//COUNTER: ");
            int _get_11 = nRegistryMethodCall[0];
            int _plus_4 = (_get_11 + 1);
            int _set_13 = nRegistryMethodCall[0] = _plus_4;
            _builder.append(_set_13, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("//REGISTRY METHOD NAME:");
            String _string_2 = Integer.valueOf((nRegistryMethodCall[0])).toString();
            String registryMethodName_1 = ("registry" + _string_2);
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            _builder.append("int mutsMark = mutationMark(muts);");
            _builder.newLine();
            {
              if ((executeMutation == true)) {
                _builder.append("\t\t\t");
                _builder.append("if (mut != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("/*");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("* IMPORTANT:");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("* Capture the removed EObject from the PRE-MUTATION");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("* source model. Do not use mut.getObject() here:");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("* RemoveObjectMutator only populates that information");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("* during mutate().");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t     ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t    ");
                _builder.append("EObject clue =");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t        ");
                _builder.append("findEObjectForRegistry(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("seed,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("obSelection.getObject(),");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("null,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("null,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("mutPaths,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t            ");
                _builder.append("packages);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("Object mutated = mut.mutate();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("if (mutated != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("AppMutation appMut = ");
                _builder.append(registryMethodName_1, "\t\t\t\t\t");
                _builder.append("(mut, hmMutator, seed, obSelection.getModel(), clue, mutPaths, packages);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("if (appMut != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("muts.getMuts().add(appMut);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("mutator = mut;");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("if (mutator != null) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("//COUNTER: ");
            int _get_12 = nMethodCall[0];
            int _plus_5 = (_get_12 + 1);
            int _set_14 = nMethodCall[0] = _plus_5;
            _builder.append(_set_14, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("//MUTATION METHOD NAME:");
            String _string_3 = Integer.valueOf((nMethodCall[0])).toString();
            String nMethodName_1 = ("mutation" + _string_3);
            _builder.newLineIfNotEmpty();
            {
              if ((last == false)) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t\t");
                    _builder.append(nMethodName_1, "\t\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append(nMethodName_1, "\t\t\t");
                    _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("numMutantsGenerated = k[0];");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t\t\t\t     ");
                _builder.append("MutatorUtils.rollbackMutations(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t\t\t\t        ");
                _builder.append("muts,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t        ");
                _builder.append("mutsMark);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t\t\t\t\t");
                _builder.append("models.remove(m);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t\t\t\t\t");
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
                  EList<Constraint> _constraints_1 = e.getConstraints();
                  for(final Constraint constraint_1 : _constraints_1) {
                    _builder.append("\t\t");
                    _builder.append("if (rules.get(\"");
                    String _name_60 = constraint_1.getType().getName();
                    _builder.append(_name_60, "\t\t");
                    _builder.append("\") == null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("rules.put(\"");
                    String _name_61 = constraint_1.getType().getName();
                    _builder.append(_name_61, "\t\t\t");
                    _builder.append("\", new ArrayList<String>());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("List<String> newrules = rules.get(\"");
                    String _name_62 = constraint_1.getType().getName();
                    _builder.append(_name_62, "\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    {
                      EList<InvariantCS> _expressions_2 = constraint_1.getExpressions();
                      boolean _tripleNotEquals_10 = (_expressions_2 != null);
                      if (_tripleNotEquals_10) {
                        {
                          EList<InvariantCS> _expressions_3 = constraint_1.getExpressions();
                          for(final InvariantCS expression_1 : _expressions_3) {
                            _builder.append("\t\t");
                            _builder.append("newrules.add(\"");
                            String _constraintText_1 = WodelUtils.getConstraintText(fileURI.lastSegment(), expression_1);
                            _builder.append(_constraintText_1, "\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      EList<String> _rules_2 = constraint_1.getRules();
                      boolean _tripleNotEquals_11 = (_rules_2 != null);
                      if (_tripleNotEquals_11) {
                        {
                          EList<String> _rules_3 = constraint_1.getRules();
                          for(final String rule_1 : _rules_3) {
                            _builder.append("\t\t");
                            _builder.append("newrules.add(\"");
                            _builder.append(rule_1, "\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("rules.put(\"");
                    String _name_63 = constraint_1.getType().getName();
                    _builder.append(_name_63, "\t\t");
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
                      int _size_1 = b.getFrom().size();
                      boolean _equals_3 = (_size_1 == 0);
                      if (_equals_3) {
                        _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                        String _name_64 = b.getName();
                        _builder.append(_name_64);
                        _builder.append("/Output\" + k[0] + \".model\";");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                        String _name_65 = b.getName();
                        _builder.append(_name_65);
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
                        _builder.append("   \t\t");
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("   \t\t");
                        _builder.append("\t");
                        _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);");
                        _builder.newLine();
                      } else {
                        _builder.append("   \t\t");
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("   \t\t");
                        _builder.append("\t");
                        _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                        String _name_66 = project.getName();
                        _builder.append(_name_66, "   \t\t\t");
                        _builder.append("\", serialize, test, classes, ");
                        _builder.append(className, "   \t\t\t");
                        _builder.append(".class, true, true);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    {
                      if ((standalone == false)) {
                        _builder.append("\t   \t\t");
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                        String _name_67 = b.getName();
                        _builder.append(_name_67);
                        _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                        String _name_68 = b.getName();
                        _builder.append(_name_68, "\t");
                        _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                        String _name_69 = project.getName();
                        _builder.append(_name_69, "\t");
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
                _builder.append("//if (muts != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("//\tmuts.getMuts().clear();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("//}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("     ");
                _builder.append("MutatorUtils.rollbackMutations(");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("muts,");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("mutsMark);");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("} finally {");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t\t");
                _builder.append("models.remove(m);");
                _builder.newLine();
                _builder.append("\t\t\t\t\t\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//END REMOVE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
