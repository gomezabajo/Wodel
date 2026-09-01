package wodel.dsls.generator.mutators.stochastic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.Resource;
import mutatorenvironment.SampleClause;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class WodelGeneratorSelectSampleMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof SelectSampleMutator)) {
        _builder.append("//");
        SelectSampleMutator mut = ((SelectSampleMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
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
        _builder.append("//SELECT SAMPLE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("List<EPackage> resourcePackages = packages;");
        _builder.newLine();
        _builder.append("List<Resource> resources = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("resources.add(model);");
        _builder.newLine();
        _builder.append("SpecificReferenceSelection referenceSelection = null;");
        _builder.newLine();
        _builder.append("//");
        int i = 0;
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        int j = 0;
        _builder.newLineIfNotEmpty();
        {
          String _resource = mut.getObject().getResource();
          boolean _tripleEquals = (_resource == null);
          if (_tripleEquals) {
            {
              if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
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
                  }
                }
                {
                  ObSelectionStrategy _object_2 = mut.getObject();
                  if ((_object_2 instanceof CompleteTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                    ObSelectionStrategy _object_3 = mut.getObject();
                    String _name_1 = ((CompleteTypeSelection) _object_3).getType().getName();
                    _builder.append(_name_1, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  Expression _expression = mut.getObject().getExpression();
                  boolean _tripleEquals_1 = (_expression == null);
                  if (_tripleEquals_1) {
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
                    int[] counter = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("//REFERENCE LIST: ");
                    int _set_1 = counter[0] = 0;
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
                    _builder.append("\t");
                    _builder.append("//");
                    boolean[] evaluation = new boolean[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//");
                    String _xblockexpression = null;
                    {
                      evaluation[0] = false;
                      _xblockexpression = "";
                    }
                    _builder.append(_xblockexpression, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    Object _method = this.method(mut.getObject().getExpression(), mut, counter, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation);
                    _builder.append(_method, "\t");
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
                      ObSelectionStrategy _object_4 = mut.getObject();
                      if ((_object_4 instanceof RandomTypeSelection)) {
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
                    {
                      ObSelectionStrategy _object_5 = mut.getObject();
                      if ((_object_5 instanceof CompleteTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("objects = selectedObjects;");
                        _builder.newLine();
                      }
                    }
                  }
                }
                {
                  ObSelectionStrategy _object_6 = mut.getObject();
                  if ((_object_6 instanceof RandomTypeSelection)) {
                    _builder.append("ObSelectionStrategy objectSelection = null; ");
                    _builder.newLine();
                    _builder.append("if (object != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("objectSelection = new SpecificObjectSelection(packages, model, object);");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                ObSelectionStrategy _object_7 = mut.getObject();
                if ((_object_7 instanceof CompleteTypeSelection)) {
                  _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                  ObSelectionStrategy _object_8 = mut.getObject();
                  String _name_2 = ((CompleteTypeSelection) _object_8).getType().getName();
                  _builder.append(_name_2);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("EObject object = rts.getObject();");
                  _builder.newLine();
                  _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
                  _builder.newLine();
                } else {
                  ObSelectionStrategy _object_9 = mut.getObject();
                  if ((_object_9 instanceof SpecificObjectSelection)) {
                    _builder.append("ObSelectionStrategy objectSelection = null;");
                    _builder.newLine();
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    ObSelectionStrategy _object_10 = mut.getObject();
                    String _name_3 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                    _builder.append(_name_3);
                    _builder.append(" = hmObjects.get(\"");
                    ObSelectionStrategy _object_11 = mut.getObject();
                    String _name_4 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                    _builder.append(_name_4);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (entry_");
                    ObSelectionStrategy _object_12 = mut.getObject();
                    String _name_5 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                    _builder.append(_name_5);
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("resourcePackages = entry_");
                    ObSelectionStrategy _object_13 = mut.getObject();
                    String _name_6 = ((SpecificObjectSelection) _object_13).getObjSel().getName();
                    _builder.append(_name_6, "\t");
                    _builder.append(".getValue().getValue();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("resources = new ArrayList<Resource>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("resources.add(entry_");
                    ObSelectionStrategy _object_14 = mut.getObject();
                    String _name_7 = ((SpecificObjectSelection) _object_14).getObjSel().getName();
                    _builder.append(_name_7, "\t");
                    _builder.append(".getValue().getKey());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                    ObSelectionStrategy _object_15 = mut.getObject();
                    String _name_8 = ((SpecificObjectSelection) _object_15).getObjSel().getName();
                    _builder.append(_name_8, "\t");
                    _builder.append(".getValue().getValue(), entry_");
                    ObSelectionStrategy _object_16 = mut.getObject();
                    String _name_9 = ((SpecificObjectSelection) _object_16).getObjSel().getName();
                    _builder.append(_name_9, "\t");
                    _builder.append(".getValue().getKey(), entry_");
                    ObSelectionStrategy _object_17 = mut.getObject();
                    String _name_10 = ((SpecificObjectSelection) _object_17).getObjSel().getName();
                    _builder.append(_name_10, "\t");
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                    ObSelectionStrategy _object_18 = mut.getObject();
                    String _name_11 = ((SpecificObjectSelection) _object_18).getObjSel().getName();
                    _builder.append(_name_11, "\t");
                    _builder.append(" = hmList.get(\"");
                    ObSelectionStrategy _object_19 = mut.getObject();
                    String _name_12 = ((SpecificObjectSelection) _object_19).getObjSel().getName();
                    _builder.append(_name_12, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("if (listEntry_");
                    ObSelectionStrategy _object_20 = mut.getObject();
                    String _name_13 = ((SpecificObjectSelection) _object_20).getObjSel().getName();
                    _builder.append(_name_13, "\t");
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("resourcePackages = listEntry_");
                    ObSelectionStrategy _object_21 = mut.getObject();
                    String _name_14 = ((SpecificObjectSelection) _object_21).getObjSel().getName();
                    _builder.append(_name_14, "\t\t");
                    _builder.append(".get(0).getValue().getValue();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("resources = new ArrayList<Resource>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("resources.add(listEntry_");
                    ObSelectionStrategy _object_22 = mut.getObject();
                    String _name_15 = ((SpecificObjectSelection) _object_22).getObjSel().getName();
                    _builder.append(_name_15, "\t\t");
                    _builder.append(".get(0).getValue().getKey());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                    ObSelectionStrategy _object_23 = mut.getObject();
                    String _name_16 = ((SpecificObjectSelection) _object_23).getObjSel().getName();
                    _builder.append(_name_16, "\t\t");
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
                    ObSelectionStrategy _object_24 = mut.getObject();
                    String _name_17 = ((SpecificObjectSelection) _object_24).getObjSel().getName();
                    _builder.append(_name_17, "\t\t");
                    _builder.append(".get(0).getValue().getValue(), listEntry_");
                    ObSelectionStrategy _object_25 = mut.getObject();
                    String _name_18 = ((SpecificObjectSelection) _object_25).getObjSel().getName();
                    _builder.append(_name_18, "\t\t");
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
                  } else {
                    ObSelectionStrategy _object_26 = mut.getObject();
                    if ((_object_26 instanceof SpecificClosureSelection)) {
                      _builder.append("ObSelectionStrategy objectSelection = null;");
                      _builder.newLine();
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      ObSelectionStrategy _object_27 = mut.getObject();
                      String _name_19 = ((SpecificClosureSelection) _object_27).getObjSel().getName();
                      _builder.append(_name_19);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _object_28 = mut.getObject();
                      String _name_20 = ((SpecificClosureSelection) _object_28).getObjSel().getName();
                      _builder.append(_name_20);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry_");
                      ObSelectionStrategy _object_29 = mut.getObject();
                      String _name_21 = ((SpecificClosureSelection) _object_29).getObjSel().getName();
                      _builder.append(_name_21);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("resourcePackages = entry_");
                      ObSelectionStrategy _object_30 = mut.getObject();
                      String _name_22 = ((SpecificClosureSelection) _object_30).getObjSel().getName();
                      _builder.append(_name_22, "\t");
                      _builder.append(".getValue().getValue();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("resources = new ArrayList<Resource>();");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("resources.add(entry_");
                      ObSelectionStrategy _object_31 = mut.getObject();
                      String _name_23 = ((SpecificClosureSelection) _object_31).getObjSel().getName();
                      _builder.append(_name_23, "\t");
                      _builder.append(".getValue().getKey());");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                      ObSelectionStrategy _object_32 = mut.getObject();
                      String _name_24 = ((SpecificClosureSelection) _object_32).getObjSel().getName();
                      _builder.append(_name_24, "\t");
                      _builder.append(".getValue().getValue(), entry_");
                      ObSelectionStrategy _object_33 = mut.getObject();
                      String _name_25 = ((SpecificClosureSelection) _object_33).getObjSel().getName();
                      _builder.append(_name_25, "\t");
                      _builder.append(".getValue().getKey(), entry_");
                      ObSelectionStrategy _object_34 = mut.getObject();
                      String _name_26 = ((SpecificClosureSelection) _object_34).getObjSel().getName();
                      _builder.append(_name_26, "\t");
                      _builder.append(".getKey(), \"");
                      ObSelectionStrategy _object_35 = mut.getObject();
                      String _name_27 = ((SpecificClosureSelection) _object_35).getRefType().getName();
                      _builder.append(_name_27, "\t");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("} else {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("return mutations;");
                      _builder.newLine();
                      _builder.append("}");
                      _builder.newLine();
                    } else {
                      _builder.append("List<EObject> objects = ModelManager.getParentObjects(packages, model, \"");
                      String _name_28 = mut.getType().getName();
                      _builder.append(_name_28);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("EObject container = containers.get(ModelManager.getRandomIndex(objects));");
                      _builder.newLine();
                      _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
            _builder.append("if (objectSelection != null) {");
            _builder.newLine();
            {
              EReference _refType = mut.getObject().getRefType();
              boolean _tripleNotEquals = (_refType != null);
              if (_tripleNotEquals) {
                _builder.append("referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                String _name_29 = mut.getObject().getRefType().getName();
                _builder.append(_name_29);
                _builder.append("\", objectSelection.getObject());");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);");
                _builder.newLine();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _builder.append("List<String> features = new ArrayList<String>();");
            _builder.newLine();
            {
              SampleClause _clause = mut.getClause();
              boolean _equals = Objects.equals(_clause, SampleClause.EQUALS);
              if (_equals) {
                _builder.append("boolean equals = true;");
                _builder.newLine();
              }
            }
            {
              SampleClause _clause_1 = mut.getClause();
              boolean _equals_1 = Objects.equals(_clause_1, SampleClause.DISTINCT);
              if (_equals_1) {
                _builder.append("boolean equals = false;");
                _builder.newLine();
              }
            }
            {
              int _size = mut.getFeatures().size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                {
                  EList<EStructuralFeature> _features = mut.getFeatures();
                  for(final EStructuralFeature feature : _features) {
                    _builder.append("if (!features.contains(\"");
                    String _name_30 = feature.getName();
                    _builder.append(_name_30);
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("features.add(\"");
                    String _name_31 = feature.getName();
                    _builder.append(_name_31, "\t");
                    _builder.append("\");\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                _builder.append("equals = false;");
                _builder.newLine();
              }
            }
            {
              Expression _expression_1 = mut.getObject().getExpression();
              boolean _tripleNotEquals_1 = (_expression_1 != null);
              if (_tripleNotEquals_1) {
                {
                  Evaluation _first = mut.getObject().getExpression().getFirst();
                  if ((_first instanceof ReferenceEvaluation)) {
                    _builder.append("//");
                    Evaluation _first_1 = mut.getObject().getExpression().getFirst();
                    ReferenceEvaluation ev = ((ReferenceEvaluation) _first_1);
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (!features.contains(\"");
                    String _name_32 = ev.getName().getName();
                    _builder.append(_name_32);
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("features.add(\"");
                    String _name_33 = ev.getName().getName();
                    _builder.append(_name_33, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  Evaluation _first_2 = mut.getObject().getExpression().getFirst();
                  if ((_first_2 instanceof AttributeEvaluation)) {
                    _builder.append("//");
                    Evaluation _first_3 = mut.getObject().getExpression().getFirst();
                    AttributeEvaluation ev_1 = ((AttributeEvaluation) _first_3);
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (!features.contains(\"");
                    String _name_34 = ev_1.getName().getName();
                    _builder.append(_name_34);
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("features.add(\"");
                    String _name_35 = ev_1.getName().getName();
                    _builder.append(_name_35, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  if (((mut.getObject().getExpression().getSecond() != null) && (mut.getObject().getExpression().getSecond().size() > 0))) {
                    {
                      EList<Evaluation> _second = mut.getObject().getExpression().getSecond();
                      for(final Evaluation ev_2 : _second) {
                        {
                          if ((ev_2 instanceof ReferenceEvaluation)) {
                            _builder.append("if (!features.contains(\"");
                            String _name_36 = ((ReferenceEvaluation)ev_2).getName().getName();
                            _builder.append(_name_36);
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("features.add(\"");
                            String _name_37 = ((ReferenceEvaluation)ev_2).getName().getName();
                            _builder.append(_name_37, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        {
                          if ((ev_2 instanceof AttributeEvaluation)) {
                            _builder.append("if (!features.contains(\"");
                            String _name_38 = ((AttributeEvaluation)ev_2).getName().getName();
                            _builder.append(_name_38);
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("features.add(\"");
                            String _name_39 = ((AttributeEvaluation)ev_2).getName().getName();
                            _builder.append(_name_39, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
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
          } else {
            _builder.append("//");
            final List<String> resourceURIs = new ArrayList<String>();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            final List<String> ecoreURIs = new ArrayList<String>();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            final String resourceName = mut.getObject().getResource();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            Resource resource = null;
            _builder.newLineIfNotEmpty();
            {
              EList<Resource> _resources = program.getResources();
              for(final Resource res : _resources) {
                {
                  boolean _equals_2 = res.getName().equals(resourceName);
                  if (_equals_2) {
                    _builder.append("//");
                    _builder.append(resource = res);
                    _builder.append(" ");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              if ((resource != null)) {
                _builder.append("\t");
                _builder.append("//");
                final Source source = resource.getPath();
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("//");
                String _path = project.getLocation().toFile().getPath();
                String _plus = (_path + "/");
                String _path_1 = source.getPath();
                final String resourcePath = (_plus + _path_1);
                _builder.newLineIfNotEmpty();
                {
                  File[] _listFiles = new File(resourcePath).listFiles();
                  for(final File resourceFile : _listFiles) {
                    {
                      boolean _endsWith = resourceFile.getName().endsWith(".model");
                      if (_endsWith) {
                        _builder.append("\t");
                        _builder.append("//");
                        boolean _add_1 = resourceURIs.add(resourceFile.getPath());
                        _builder.append(_add_1, "\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      boolean _endsWith_1 = resourceFile.getName().endsWith(".ecore");
                      if (_endsWith_1) {
                        _builder.append("\t");
                        _builder.append("//");
                        boolean _add_2 = ecoreURIs.add(resourceFile.getPath());
                        _builder.append(_add_2, "\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t");
                _builder.append("//");
                final String metamodelPath = resource.getMetamodel().replace("\\", "/");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("String relativeMetamodelPath = \"");
                String _xifexpression = null;
                String _name_40 = project.getName();
                String _plus_1 = ("/" + _name_40);
                String _plus_2 = (_plus_1 + "/");
                int _indexOf = metamodelPath.indexOf(_plus_2);
                boolean _notEquals = (_indexOf != (-1));
                if (_notEquals) {
                  String _name_41 = project.getName();
                  String _plus_3 = ("/" + _name_41);
                  String _plus_4 = (_plus_3 + "/");
                  int _lastIndexOf = metamodelPath.lastIndexOf(_plus_4);
                  String _name_42 = project.getName();
                  String _plus_5 = ("/" + _name_42);
                  int _length = (_plus_5 + "/").length();
                  int _plus_6 = (_lastIndexOf + _length);
                  _xifexpression = metamodelPath.substring(_plus_6, metamodelPath.length());
                } else {
                  _xifexpression = metamodelPath;
                }
                _builder.append(_xifexpression, "\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("relativeMetamodelPath = relativeMetamodelPath.startsWith(\"/\") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("String absoluteMetamodelPath = ");
                _builder.append(className, "\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeMetamodelPath;");
                _builder.newLineIfNotEmpty();
                {
                  if ((standalone == false)) {
                    _builder.append("\t");
                    _builder.append("List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());");
                    _builder.newLine();
                  } else {
                    _builder.append("\t");
                    _builder.append("List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, ");
                    _builder.append(className, "\t");
                    _builder.append(".class);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("List<Resource> resources = new ArrayList<Resource>();");
                _builder.newLine();
                {
                  for(final String resourceURI : resourceURIs) {
                    _builder.append("\t");
                    _builder.append("String relativeResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(" = \"");
                    String _xifexpression_1 = null;
                    String _replace = resourceURI.replace("\\", "/");
                    String _name_43 = project.getName();
                    String _plus_7 = ("/" + _name_43);
                    String _plus_8 = (_plus_7 + "/");
                    int _indexOf_1 = _replace.indexOf(_plus_8);
                    boolean _notEquals_1 = (_indexOf_1 != (-1));
                    if (_notEquals_1) {
                      String _replace_1 = resourceURI.replace("\\", "/");
                      String _replace_2 = resourceURI.replace("\\", "/");
                      String _name_44 = project.getName();
                      String _plus_9 = ("/" + _name_44);
                      String _plus_10 = (_plus_9 + "/");
                      int _lastIndexOf_1 = _replace_2.lastIndexOf(_plus_10);
                      String _name_45 = project.getName();
                      String _plus_11 = ("/" + _name_45);
                      int _length_1 = (_plus_11 + "/").length();
                      int _plus_12 = (_lastIndexOf_1 + _length_1);
                      _xifexpression_1 = _replace_1.substring(_plus_12, resourceURI.replace("\\", "/").length());
                    } else {
                      _xifexpression_1 = resourceURI;
                    }
                    _builder.append(_xifexpression_1, "\t");
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("String absoluteResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(" = ");
                    _builder.append(className, "\t");
                    _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("absoluteResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(" = \"file:/\" + absoluteResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(".substring(1, absoluteResourceURI_");
                    _builder.append(i, "\t");
                    _builder.append(".length()); ");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((standalone == false)) {
                        _builder.append("\t");
                        _builder.append("resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_");
                        _builder.append(i, "\t");
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_");
                        _builder.append(i, "\t");
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    String _xblockexpression_1 = null;
                    {
                      i++;
                      _xblockexpression_1 = "";
                    }
                    _builder.append(_xblockexpression_1, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  for(final String ecoreURI : ecoreURIs) {
                    _builder.append("\t");
                    _builder.append("String relativeEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(" = \"");
                    String _replace_3 = ecoreURI.replace("\\", "/");
                    String _replace_4 = ecoreURI.replace("\\", "/");
                    String _name_46 = project.getName();
                    String _plus_13 = ("/" + _name_46);
                    String _plus_14 = (_plus_13 + "/");
                    int _lastIndexOf_2 = _replace_4.lastIndexOf(_plus_14);
                    String _name_47 = project.getName();
                    String _plus_15 = ("/" + _name_47);
                    int _length_2 = (_plus_15 + "/").length();
                    int _plus_16 = (_lastIndexOf_2 + _length_2);
                    String _substring = _replace_3.substring(_plus_16, ecoreURI.replace("\\", "/").length());
                    _builder.append(_substring, "\t");
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("String absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(" = ");
                    _builder.append(className, "\t");
                    _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(" = \"file:/\" + absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(".substring(1, absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(".length()); ");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((standalone == false)) {
                        _builder.append("\t");
                        _builder.append("resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_");
                        _builder.append(j, "\t");
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_");
                        _builder.append(j, "\t");
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    String _xblockexpression_2 = null;
                    {
                      j++;
                      _xblockexpression_2 = "";
                    }
                    _builder.append(_xblockexpression_2, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
                    {
                      ObSelectionStrategy _object_36 = mut.getObject();
                      if ((_object_36 instanceof RandomTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                        ObSelectionStrategy _object_37 = mut.getObject();
                        String _name_48 = ((RandomTypeSelection) _object_37).getType().getName();
                        _builder.append(_name_48, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_38 = mut.getObject();
                      if ((_object_38 instanceof CompleteTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                        ObSelectionStrategy _object_39 = mut.getObject();
                        String _name_49 = ((CompleteTypeSelection) _object_39).getType().getName();
                        _builder.append(_name_49, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      Expression _expression_2 = mut.getObject().getExpression();
                      boolean _tripleEquals_2 = (_expression_2 == null);
                      if (_tripleEquals_2) {
                        _builder.append("\t");
                        _builder.append("EObject object = rts.getObject();");
                        _builder.newLine();
                      } else {
                        _builder.append("\t");
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LIST: ");
                        List<Integer> expressionList_1 = new ArrayList<Integer>();
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LIST: ");
                        boolean _add_3 = expressionList_1.add(Integer.valueOf(0));
                        _builder.append(_add_3, "\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LEVEL: ");
                        int[] nExpression_1 = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LEVEL: ");
                        int _set_3 = nExpression_1[0] = 0;
                        _builder.append(_set_3, "\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("Expression exp");
                        Integer _get_3 = expressionList_1.get(0);
                        _builder.append(_get_3, "\t");
                        _builder.append(" = new Expression();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//REFERENCE LIST: ");
                        int[] counter_1 = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//REFERENCE LIST: ");
                        int _set_4 = counter_1[0] = 0;
                        _builder.append(_set_4, "\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//RECURSION EXPRESSION LIST: ");
                        int[] recursionIndexExpression_1 = new int[1];
                        _builder.append("»");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("//REFERENCE LIST: ");
                        int _set_5 = recursionIndexExpression_1[0] = 0;
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
                        String _xblockexpression_3 = null;
                        {
                          evaluation_1[0] = false;
                          _xblockexpression_3 = "";
                        }
                        _builder.append(_xblockexpression_3, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        Object _method_1 = this.method(mut.getObject().getExpression(), mut, counter_1, expressionList_1, nExpression_1, recursionIndexExpression_1, false, false, false, evaluation_1);
                        _builder.append(_method_1, "\t");
                        _builder.newLineIfNotEmpty();
                        {
                          boolean _get_4 = evaluation_1[0];
                          if (_get_4) {
                            _builder.append("List<EObject> selectedObjects = auxObjects;");
                            _builder.newLine();
                          } else {
                            _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                            Integer _get_5 = expressionList_1.get(0);
                            _builder.append(_get_5);
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          ObSelectionStrategy _object_40 = mut.getObject();
                          if ((_object_40 instanceof RandomTypeSelection)) {
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
                        {
                          ObSelectionStrategy _object_41 = mut.getObject();
                          if ((_object_41 instanceof CompleteTypeSelection)) {
                            _builder.append("\t");
                            _builder.append("objects = selectedObjects;");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                    {
                      ObSelectionStrategy _object_42 = mut.getObject();
                      if ((_object_42 instanceof RandomTypeSelection)) {
                        _builder.append("ObSelectionStrategy objectSelection = null; ");
                        _builder.newLine();
                        _builder.append("if (object != null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                  } else {
                    ObSelectionStrategy _object_43 = mut.getObject();
                    if ((_object_43 instanceof CompleteTypeSelection)) {
                      _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                      ObSelectionStrategy _object_44 = mut.getObject();
                      String _name_50 = ((CompleteTypeSelection) _object_44).getType().getName();
                      _builder.append(_name_50);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("EObject object = rts.getObject();");
                      _builder.newLine();
                      _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);");
                      _builder.newLine();
                    } else {
                      ObSelectionStrategy _object_45 = mut.getObject();
                      if ((_object_45 instanceof SpecificObjectSelection)) {
                        _builder.append("ObSelectionStrategy objectSelection = null;");
                        _builder.newLine();
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        ObSelectionStrategy _object_46 = mut.getObject();
                        String _name_51 = ((SpecificObjectSelection) _object_46).getObjSel().getName();
                        _builder.append(_name_51);
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _object_47 = mut.getObject();
                        String _name_52 = ((SpecificObjectSelection) _object_47).getObjSel().getName();
                        _builder.append(_name_52);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("if (entry_");
                        ObSelectionStrategy _object_48 = mut.getObject();
                        String _name_53 = ((SpecificObjectSelection) _object_48).getObjSel().getName();
                        _builder.append(_name_53);
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("resourcePackages = entry_");
                        ObSelectionStrategy _object_49 = mut.getObject();
                        String _name_54 = ((SpecificObjectSelection) _object_49).getObjSel().getName();
                        _builder.append(_name_54, "\t");
                        _builder.append(".getValue().getValue();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("resources = new ArrayList<Resource>();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("resources.add(entry_");
                        ObSelectionStrategy _object_50 = mut.getObject();
                        String _name_55 = ((SpecificObjectSelection) _object_50).getObjSel().getName();
                        _builder.append(_name_55, "\t");
                        _builder.append(".getValue().getKey());");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                        ObSelectionStrategy _object_51 = mut.getObject();
                        String _name_56 = ((SpecificObjectSelection) _object_51).getObjSel().getName();
                        _builder.append(_name_56, "\t");
                        _builder.append(".getValue().getValue(), entry_");
                        ObSelectionStrategy _object_52 = mut.getObject();
                        String _name_57 = ((SpecificObjectSelection) _object_52).getObjSel().getName();
                        _builder.append(_name_57, "\t");
                        _builder.append(".getValue().getKey(), entry_");
                        ObSelectionStrategy _object_53 = mut.getObject();
                        String _name_58 = ((SpecificObjectSelection) _object_53).getObjSel().getName();
                        _builder.append(_name_58, "\t");
                        _builder.append(".getKey());");
                        _builder.newLineIfNotEmpty();
                        _builder.append("} else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                        ObSelectionStrategy _object_54 = mut.getObject();
                        String _name_59 = ((SpecificObjectSelection) _object_54).getObjSel().getName();
                        _builder.append(_name_59, "\t");
                        _builder.append(" = hmList.get(\"");
                        ObSelectionStrategy _object_55 = mut.getObject();
                        String _name_60 = ((SpecificObjectSelection) _object_55).getObjSel().getName();
                        _builder.append(_name_60, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("if (listEntry_");
                        ObSelectionStrategy _object_56 = mut.getObject();
                        String _name_61 = ((SpecificObjectSelection) _object_56).getObjSel().getName();
                        _builder.append(_name_61, "\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("resourcePackages = listEntry_");
                        ObSelectionStrategy _object_57 = mut.getObject();
                        String _name_62 = ((SpecificObjectSelection) _object_57).getObjSel().getName();
                        _builder.append(_name_62, "\t\t");
                        _builder.append(".get(0).getValue().getValue();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("resources = new ArrayList<Resource>();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("resources.add(listEntry_");
                        ObSelectionStrategy _object_58 = mut.getObject();
                        String _name_63 = ((SpecificObjectSelection) _object_58).getObjSel().getName();
                        _builder.append(_name_63, "\t\t");
                        _builder.append(".get(0).getValue().getKey());");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                        ObSelectionStrategy _object_59 = mut.getObject();
                        String _name_64 = ((SpecificObjectSelection) _object_59).getObjSel().getName();
                        _builder.append(_name_64, "\t\t");
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
                        ObSelectionStrategy _object_60 = mut.getObject();
                        String _name_65 = ((SpecificObjectSelection) _object_60).getObjSel().getName();
                        _builder.append(_name_65, "\t\t");
                        _builder.append(".get(0).getValue().getValue(), listEntry_");
                        ObSelectionStrategy _object_61 = mut.getObject();
                        String _name_66 = ((SpecificObjectSelection) _object_61).getObjSel().getName();
                        _builder.append(_name_66, "\t\t");
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
                      } else {
                        ObSelectionStrategy _object_62 = mut.getObject();
                        if ((_object_62 instanceof SpecificClosureSelection)) {
                          _builder.append("ObSelectionStrategy objectSelection = null;");
                          _builder.newLine();
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _object_63 = mut.getObject();
                          String _name_67 = ((SpecificClosureSelection) _object_63).getObjSel().getName();
                          _builder.append(_name_67);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _object_64 = mut.getObject();
                          String _name_68 = ((SpecificClosureSelection) _object_64).getObjSel().getName();
                          _builder.append(_name_68);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry_");
                          ObSelectionStrategy _object_65 = mut.getObject();
                          String _name_69 = ((SpecificClosureSelection) _object_65).getObjSel().getName();
                          _builder.append(_name_69);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("resourcePackages = entry_");
                          ObSelectionStrategy _object_66 = mut.getObject();
                          String _name_70 = ((SpecificObjectSelection) _object_66).getObjSel().getName();
                          _builder.append(_name_70, "\t");
                          _builder.append(".getValue().getValue();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("resources = new ArrayList<Resource>();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("resources.add(entry_");
                          ObSelectionStrategy _object_67 = mut.getObject();
                          String _name_71 = ((SpecificObjectSelection) _object_67).getObjSel().getName();
                          _builder.append(_name_71, "\t");
                          _builder.append(".getValue().getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                          ObSelectionStrategy _object_68 = mut.getObject();
                          String _name_72 = ((SpecificClosureSelection) _object_68).getObjSel().getName();
                          _builder.append(_name_72, "\t");
                          _builder.append(".getValue().getValue(), entry_");
                          ObSelectionStrategy _object_69 = mut.getObject();
                          String _name_73 = ((SpecificClosureSelection) _object_69).getObjSel().getName();
                          _builder.append(_name_73, "\t");
                          _builder.append(".getValue().getKey(), entry_");
                          ObSelectionStrategy _object_70 = mut.getObject();
                          String _name_74 = ((SpecificClosureSelection) _object_70).getObjSel().getName();
                          _builder.append(_name_74, "\t");
                          _builder.append(".getKey(), \"");
                          ObSelectionStrategy _object_71 = mut.getObject();
                          String _name_75 = ((SpecificClosureSelection) _object_71).getRefType().getName();
                          _builder.append(_name_75, "\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("return mutations;");
                          _builder.newLine();
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          _builder.append("List<EObject> objects = ModelManager.getParentObjects(packages, model, \"");
                          String _name_76 = mut.getType().getName();
                          _builder.append(_name_76);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject container = containers.get(ModelManager.getRandomIndex(objects));");
                          _builder.newLine();
                          _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
                _builder.append("if (objectSelection != null) {");
                _builder.newLine();
                {
                  EReference _refType_1 = mut.getObject().getRefType();
                  boolean _tripleNotEquals_2 = (_refType_1 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), \"");
                    String _name_77 = mut.getObject().getRefType().getName();
                    _builder.append(_name_77);
                    _builder.append("\", objectSelection.getObject());");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);");
                    _builder.newLine();
                  }
                }
                _builder.append("}");
                _builder.newLine();
                _builder.append("List<String> features = new ArrayList<String>();");
                _builder.newLine();
                {
                  SampleClause _clause_2 = mut.getClause();
                  boolean _equals_3 = Objects.equals(_clause_2, SampleClause.EQUALS);
                  if (_equals_3) {
                    _builder.append("boolean equals = true;");
                    _builder.newLine();
                  }
                }
                {
                  SampleClause _clause_3 = mut.getClause();
                  boolean _equals_4 = Objects.equals(_clause_3, SampleClause.DISTINCT);
                  if (_equals_4) {
                    _builder.append("boolean equals = false;");
                    _builder.newLine();
                  }
                }
                {
                  int _size_1 = mut.getFeatures().size();
                  boolean _greaterThan_1 = (_size_1 > 0);
                  if (_greaterThan_1) {
                    {
                      EList<EStructuralFeature> _features_1 = mut.getFeatures();
                      for(final EStructuralFeature feature_1 : _features_1) {
                        _builder.append("if (!features.contains(\"");
                        String _name_78 = feature_1.getName();
                        _builder.append(_name_78);
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("features.add(\"");
                        String _name_79 = feature_1.getName();
                        _builder.append(_name_79, "\t");
                        _builder.append("\");\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                  } else {
                    _builder.append("equals = false;");
                    _builder.newLine();
                  }
                }
                {
                  Expression _expression_3 = mut.getObject().getExpression();
                  boolean _tripleNotEquals_3 = (_expression_3 != null);
                  if (_tripleNotEquals_3) {
                    {
                      Evaluation _first_4 = mut.getObject().getExpression().getFirst();
                      if ((_first_4 instanceof ReferenceEvaluation)) {
                        _builder.append("//");
                        Evaluation _first_5 = mut.getObject().getExpression().getFirst();
                        ReferenceEvaluation ev_3 = ((ReferenceEvaluation) _first_5);
                        _builder.newLineIfNotEmpty();
                        _builder.append("if (!features.contains(\"");
                        String _name_80 = ev_3.getName().getName();
                        _builder.append(_name_80);
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("features.add(\"");
                        String _name_81 = ev_3.getName().getName();
                        _builder.append(_name_81, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      Evaluation _first_6 = mut.getObject().getExpression().getFirst();
                      if ((_first_6 instanceof AttributeEvaluation)) {
                        _builder.append("//");
                        Evaluation _first_7 = mut.getObject().getExpression().getFirst();
                        AttributeEvaluation ev_4 = ((AttributeEvaluation) _first_7);
                        _builder.newLineIfNotEmpty();
                        _builder.append("if (!features.contains(\"");
                        String _name_82 = ev_4.getName().getName();
                        _builder.append(_name_82);
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("features.add(\"");
                        String _name_83 = ev_4.getName().getName();
                        _builder.append(_name_83, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      if (((mut.getObject().getExpression().getSecond() != null) && (mut.getObject().getExpression().getSecond().size() > 0))) {
                        {
                          EList<Evaluation> _second_1 = mut.getObject().getExpression().getSecond();
                          for(final Evaluation ev_5 : _second_1) {
                            {
                              if ((ev_5 instanceof ReferenceEvaluation)) {
                                _builder.append("if (!features.contains(\"");
                                String _name_84 = ((ReferenceEvaluation)ev_5).getName().getName();
                                _builder.append(_name_84);
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("features.add(\"");
                                String _name_85 = ((ReferenceEvaluation)ev_5).getName().getName();
                                _builder.append(_name_85, "\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            {
                              if ((ev_5 instanceof AttributeEvaluation)) {
                                _builder.append("if (!features.contains(\"");
                                String _name_86 = ((AttributeEvaluation)ev_5).getName().getName();
                                _builder.append(_name_86);
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("features.add(\"");
                                String _name_87 = ((AttributeEvaluation)ev_5).getName().getName();
                                _builder.append(_name_87, "\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
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
              }
            }
          }
        }
        _builder.append("SelectSampleMutator mut = null;");
        _builder.newLine();
        _builder.append("if (objectSelection != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mut = new SelectSampleMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, objectSelection, equals, features);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("//INC COUNTER: ");
        int _get_6 = nMutation[0];
        int _plus_17 = (_get_6 + 1);
        int _set_6 = nMutation[0] = _plus_17;
        _builder.append(_set_6);
        _builder.newLineIfNotEmpty();
        _builder.append("//INC COUNTER: ");
        int _get_7 = nRegistryMutation[0];
        int _plus_18 = (_get_7 + 1);
        int _set_7 = nRegistryMutation[0] = _plus_18;
        _builder.append(_set_7);
        _builder.newLineIfNotEmpty();
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mut.setId(\"m");
        int _get_8 = nMutation[0];
        _builder.append(_get_8, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("mutations.add(mut);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("//END SELECT SAMPLE OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
