package wodel.dsls.generator.mutators;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeType;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.BooleanType;
import mutatorenvironment.CatEndStringType;
import mutatorenvironment.CatStartStringType;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.DoubleType;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.IntegerType;
import mutatorenvironment.ListStringType;
import mutatorenvironment.ListType;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.LowerStringType;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.NullTypeSelection;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.Operator;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.RandomBooleanType;
import mutatorenvironment.RandomDoubleNumberType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerNumberType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomStringNumberType;
import mutatorenvironment.RandomStringType;
import mutatorenvironment.RandomType;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceAdd;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.ReplaceStringType;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.StringType;
import mutatorenvironment.TypedSelection;
import mutatorenvironment.UpperStringType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import wodel.utils.manager.MutatorUtils;

@SuppressWarnings("all")
public abstract class WodelGeneratorGenericOperatorMutator {
  public CharSequence method(final AttributeSet e, final boolean flag, final boolean isList, final int[] counter, final int position, final boolean exhaustive, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//NAME:");
    String attributeName = "";
    _builder.newLineIfNotEmpty();
    {
      if ((isList == true)) {
        {
          EAttribute _get = e.getAttribute().get(0);
          boolean _tripleNotEquals = (_get != null);
          if (_tripleNotEquals) {
            final EAttribute attribute = e.getAttribute().get(0);
            _builder.newLineIfNotEmpty();
            _builder.append("//NAME:");
            _builder.append(attributeName = attribute.getName());
            _builder.newLineIfNotEmpty();
            {
              int _get_1 = counter[0];
              boolean _equals = (_get_1 == 1);
              if (_equals) {
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
              } else {
                {
                  if ((position == 1)) {
                    _builder.append("List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("//NAME:");
            _builder.append(attributeName = attribute.getName());
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            _builder.append(attributeName = "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeScalar)) {
            CharSequence _method = this.method(((AttributeScalar)e).getValue(), attributeName, flag, counter, exhaustive, obSelectionVariableName);
            _builder.append(_method);
            _builder.newLineIfNotEmpty();
            _builder.append("atts.add(attConfig);");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof AttributeUnset)) {
            _builder.append("atts.add(attConfig);");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof AttributeReverse)) {
            {
              int _get_2 = counter[0];
              boolean _equals_1 = (_get_2 == 1);
              if (_equals_1) {
                _builder.append("AttributeConfigurationStrategy attConfig = new ReverseBooleanConfigurationStrategy(\"");
                _builder.append(attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("attConfig = new ReverseBooleanConfigurationStrategy(\"");
                _builder.append(attributeName);
                _builder.append("\"); ");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("atts.add(attConfig);");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof AttributeCopy)) {
            {
              int _get_3 = counter[0];
              boolean _equals_2 = (_get_3 == 1);
              if (_equals_2) {
                _builder.append("AttributeConfigurationStrategy attConfig = null;");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object = ((AttributeCopy)e).getObject();
              if ((_object instanceof RandomTypeSelection)) {
                _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                _builder.append(obSelectionVariableName);
                _builder.append(" != null ? ");
                _builder.append(obSelectionVariableName);
                _builder.append(".getObject() : null), \"");
                ObSelectionStrategy _object_1 = ((AttributeCopy)e).getObject();
                String _name = ((RandomTypeSelection) _object_1).getType().getName();
                _builder.append(_name);
                _builder.append("\", \"");
                _builder.append(attributeName);
                _builder.append("\", \"");
                String _name_1 = ((AttributeCopy)e).getAttribute().get(1).getName();
                _builder.append(_name_1);
                _builder.append("\"); ");
                _builder.newLineIfNotEmpty();
                _builder.append("atts.add(attConfig);");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_2 = ((AttributeCopy)e).getObject();
              if ((_object_2 instanceof SpecificObjectSelection)) {
                {
                  if (((counter[0] == 1) && (!(e instanceof AttributeCopy)))) {
                    _builder.append("AttributeConfigurationStrategy attConfig = null;");
                    _builder.newLine();
                  }
                }
                {
                  if ((exhaustive == false)) {
                    _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), (hmObjects.get(\"");
                    ObSelectionStrategy _object_3 = ((AttributeCopy)e).getObject();
                    String _name_2 = ((SpecificObjectSelection) _object_3).getObjSel().getName();
                    _builder.append(_name_2);
                    _builder.append("\") != null ? hmObjects.get(\"");
                    ObSelectionStrategy _object_4 = ((AttributeCopy)e).getObject();
                    String _name_3 = ((SpecificObjectSelection) _object_4).getObjSel().getName();
                    _builder.append(_name_3);
                    _builder.append("\").getKey() : null), \"");
                    _builder.append(attributeName);
                    _builder.append("\", \"");
                    String _name_4 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_4);
                    _builder.append("\"); ");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), (hmObjects.get(\"");
                    ObSelectionStrategy _object_5 = ((AttributeCopy)e).getObject();
                    String _name_5 = ((SpecificObjectSelection) _object_5).getObjSel().getName();
                    _builder.append(_name_5);
                    _builder.append("\") != null ? hmObjects.get(\"");
                    ObSelectionStrategy _object_6 = ((AttributeCopy)e).getObject();
                    String _name_6 = ((SpecificObjectSelection) _object_6).getObjSel().getName();
                    _builder.append(_name_6);
                    _builder.append("\").getKey() : null), \"");
                    _builder.append(attributeName);
                    _builder.append("\", \"");
                    String _name_7 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_7);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("   \t\t");
                _builder.append("atts.add(attConfig);");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts);");
        _builder.newLineIfNotEmpty();
      } else {
        {
          EAttribute _get_4 = e.getAttribute().get(0);
          boolean _tripleNotEquals_1 = (_get_4 != null);
          if (_tripleNotEquals_1) {
            final EAttribute attribute_1 = e.getAttribute().get(0);
            _builder.newLineIfNotEmpty();
            _builder.append("//NAME:");
            _builder.append(attributeName = attribute_1.getName());
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            _builder.append(attributeName = "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeScalar)) {
            CharSequence _method_1 = this.method(((AttributeScalar)e).getValue(), attributeName, flag, counter, exhaustive, obSelectionVariableName);
            _builder.append(_method_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("atts.put(\"");
            _builder.append(attributeName);
            _builder.append("\", attConfig);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeUnset)) {
            _builder.append("atts.put(\"");
            _builder.append(attributeName);
            _builder.append("\", null);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeReverse)) {
            _builder.append("attConfig = new ReverseBooleanConfigurationStrategy(\"");
            _builder.append(attributeName);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("atts.put(\"");
            _builder.append(attributeName);
            _builder.append("\", attConfig);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeCopy)) {
            {
              int _get_5 = counter[0];
              boolean _equals_3 = (_get_5 == 1);
              if (_equals_3) {
                _builder.append("AttributeConfigurationStrategy attConfig = null;");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _object_7 = ((AttributeCopy)e).getObject();
              if ((_object_7 instanceof RandomTypeSelection)) {
                _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                _builder.append(obSelectionVariableName);
                _builder.append(" != null ? ");
                _builder.append(obSelectionVariableName);
                _builder.append(".getObject() : null), \"");
                ObSelectionStrategy _object_8 = ((AttributeCopy)e).getObject();
                String _name_8 = ((RandomTypeSelection) _object_8).getType().getName();
                _builder.append(_name_8);
                _builder.append("\", \"");
                _builder.append(attributeName);
                _builder.append("\", \"");
                String _name_9 = ((AttributeCopy)e).getAttribute().get(1).getName();
                _builder.append(_name_9);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("atts.put(\"");
                _builder.append(attributeName);
                _builder.append("\", attConfig);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              ObSelectionStrategy _object_9 = ((AttributeCopy)e).getObject();
              if ((_object_9 instanceof SpecificObjectSelection)) {
                {
                  if ((exhaustive == false)) {
                    _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), (hmObjects.get(\"");
                    ObSelectionStrategy _object_10 = ((AttributeCopy)e).getObject();
                    String _name_10 = ((SpecificObjectSelection) _object_10).getObjSel().getName();
                    _builder.append(_name_10);
                    _builder.append("\") != null ? hmObjects.get(\"");
                    ObSelectionStrategy _object_11 = ((AttributeCopy)e).getObject();
                    String _name_11 = ((SpecificObjectSelection) _object_11).getObjSel().getName();
                    _builder.append(_name_11);
                    _builder.append("\").getKey() : null), \"");
                    _builder.append(attributeName);
                    _builder.append("\", \"");
                    String _name_12 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_12);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("atts.put(\"");
                    _builder.append(attributeName);
                    _builder.append("\", attConfig);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("attConfig = new CopyAttributeConfigurationStrategy((");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), (hmObjects.get(\"");
                    ObSelectionStrategy _object_12 = ((AttributeCopy)e).getObject();
                    String _name_13 = ((SpecificObjectSelection) _object_12).getObjSel().getName();
                    _builder.append(_name_13);
                    _builder.append("\") != null ? hmObjects.get(\"");
                    ObSelectionStrategy _object_13 = ((AttributeCopy)e).getObject();
                    String _name_14 = ((SpecificObjectSelection) _object_13).getObjSel().getName();
                    _builder.append(_name_14);
                    _builder.append("\").getKey() : null), \"");
                    _builder.append(attributeName);
                    _builder.append("\", \"");
                    String _name_15 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_15);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("atts.put(\"");
                    _builder.append(attributeName);
                    _builder.append("\", attConfig);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final ObSelectionStrategy e, final Mutator mut, final String referenceName, final int[] nReference, final List<Integer> expressionList, final int[] nExpression, final int[] recursionIndexExpression, final boolean exhaustive, final boolean resources, final boolean insideLoop, final boolean[] evaluation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  \t\t");
    _builder.append("//REFERENCES COMPILES\t");
    int _get = nReference[0];
    int _plus = (_get + 1);
    int _set = nReference[0] = _plus;
    _builder.append(_set, "  \t\t");
    _builder.newLineIfNotEmpty();
    {
      if ((e instanceof RandomTypeSelection)) {
        _builder.append("RandomTypeSelection refRts");
        int _get_1 = nReference[0];
        _builder.append(_get_1);
        _builder.append(" = new RandomTypeSelection(packages, model, \"");
        String _name = ((RandomTypeSelection) e).getType().getName();
        _builder.append(_name);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          if (((((RandomTypeSelection)e).getExpression() != null) && (expressionList != null))) {
            _builder.append("List<EObject> refObjects");
            int _get_2 = nReference[0];
            _builder.append(_get_2);
            _builder.append(" = refRts");
            int _get_3 = nReference[0];
            _builder.append(_get_3);
            _builder.append(".getObjects();");
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int _size = expressionList.size();
            int indexExpression = (_size - 1);
            _builder.newLineIfNotEmpty();
            _builder.append("Expression exp");
            Integer _get_4 = expressionList.get(indexExpression);
            _builder.append(_get_4);
            _builder.append(" = new Expression();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            Object _method = this.method(((RandomTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation);
            _builder.append(_method, "\t   \t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            _builder.append("List<EObject> refSelectedObjects");
            int _get_5 = nReference[0];
            _builder.append(_get_5, "\t   \t\t");
            _builder.append(" = evaluate(refObjects");
            int _get_6 = nReference[0];
            _builder.append(_get_6, "\t   \t\t");
            _builder.append(", exp");
            Integer _get_7 = expressionList.get(indexExpression);
            _builder.append(_get_7, "\t   \t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("EObject refObject");
            int _get_8 = nReference[0];
            _builder.append(_get_8);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refSelectedObjects");
            int _get_9 = nReference[0];
            _builder.append(_get_9);
            _builder.append(".size() > 0) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("refObject");
            int _get_10 = nReference[0];
            _builder.append(_get_10, "\t");
            _builder.append(" = refSelectedObjects");
            int _get_11 = nReference[0];
            _builder.append(_get_11, "\t");
            _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
            int _get_12 = nReference[0];
            _builder.append(_get_12, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("EObject refObject");
            int _get_13 = nReference[0];
            _builder.append(_get_13);
            _builder.append(" = refRts");
            int _get_14 = nReference[0];
            _builder.append(_get_14);
            _builder.append(".getObject();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("ObSelectionStrategy refSelection");
        int _get_15 = nReference[0];
        _builder.append(_get_15);
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("if (refObject");
        int _get_16 = nReference[0];
        _builder.append(_get_16);
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("refSelection");
        int _get_17 = nReference[0];
        _builder.append(_get_17);
        _builder.append(" = ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new SpecificObjectSelection(packages, model, refObject");
        int _get_18 = nReference[0];
        _builder.append(_get_18, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      } else {
        if ((e instanceof OtherTypeSelection)) {
          _builder.append("OtherTypeSelection refOts");
          int _get_19 = nReference[0];
          _builder.append(_get_19);
          _builder.append(" = new OtherTypeSelection(packages, model, \"");
          String _name_1 = ((OtherTypeSelection) e).getType().getName();
          _builder.append(_name_1);
          _builder.append("\", ModelManager.getReference(\"");
          _builder.append(referenceName);
          _builder.append("\", objectSelection.getObject()));");
          _builder.newLineIfNotEmpty();
          {
            if (((((OtherTypeSelection)e).getExpression() != null) && (expressionList != null))) {
              _builder.append("List<EObject> refObjects");
              int _get_20 = nReference[0];
              _builder.append(_get_20);
              _builder.append(" = refOts");
              int _get_21 = nReference[0];
              _builder.append(_get_21);
              _builder.append(".getObjects();");
              _builder.newLineIfNotEmpty();
              _builder.append("//INDEX EXPRESSION: ");
              int _size_1 = expressionList.size();
              int indexExpression_1 = (_size_1 - 1);
              _builder.newLineIfNotEmpty();
              _builder.append("Expression exp");
              Integer _get_22 = expressionList.get(indexExpression_1);
              _builder.append(_get_22);
              _builder.append(" = new Expression();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t   \t\t");
              Object _method_1 = this.method(((OtherTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation);
              _builder.append(_method_1, "\t   \t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t   \t\t");
              _builder.append("List<EObject> refSelectedObjects");
              int _get_23 = nReference[0];
              _builder.append(_get_23, "\t   \t\t");
              _builder.append(" = evaluate(refObjects");
              int _get_24 = nReference[0];
              _builder.append(_get_24, "\t   \t\t");
              _builder.append(", exp");
              Integer _get_25 = expressionList.get(indexExpression_1);
              _builder.append(_get_25, "\t   \t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_26 = nReference[0];
              _builder.append(_get_26);
              _builder.append(" = null;");
              _builder.newLineIfNotEmpty();
              _builder.append("if (refSelectedObjects");
              int _get_27 = nReference[0];
              _builder.append(_get_27);
              _builder.append(".size() > 0) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("refObject");
              int _get_28 = nReference[0];
              _builder.append(_get_28, "\t");
              _builder.append(" = refSelectedObjects");
              int _get_29 = nReference[0];
              _builder.append(_get_29, "\t");
              _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
              int _get_30 = nReference[0];
              _builder.append(_get_30, "\t");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("EObject refObject");
              int _get_31 = nReference[0];
              _builder.append(_get_31);
              _builder.append(" = refOts");
              int _get_32 = nReference[0];
              _builder.append(_get_32);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("ObSelectionStrategy refSelection");
          int _get_33 = nReference[0];
          _builder.append(_get_33);
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
          _builder.append("if (refObject");
          int _get_34 = nReference[0];
          _builder.append(_get_34);
          _builder.append(" != null) {");
          _builder.newLineIfNotEmpty();
          _builder.append("refSelection");
          int _get_35 = nReference[0];
          _builder.append(_get_35);
          _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
          int _get_36 = nReference[0];
          _builder.append(_get_36);
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          if ((e instanceof NullTypeSelection)) {
            _builder.append("NullTypeSelection refNts");
            int _get_37 = nReference[0];
            _builder.append(_get_37);
            _builder.append(" = new NullTypeSelection(packages, model, \"");
            String _name_2 = ((NullTypeSelection) e).getType().getName();
            _builder.append(_name_2);
            _builder.append("\", ModelManager.getReference(\"");
            _builder.append(referenceName);
            _builder.append("\", objectSelection.getObject()));");
            _builder.newLineIfNotEmpty();
            {
              if (((((NullTypeSelection)e).getExpression() != null) && (expressionList != null))) {
                _builder.append("List<EObject> refObjects");
                int _get_38 = nReference[0];
                _builder.append(_get_38);
                _builder.append(" = refNts");
                int _get_39 = nReference[0];
                _builder.append(_get_39);
                _builder.append(".getObjects();");
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int _size_2 = expressionList.size();
                int indexExpression_2 = (_size_2 - 1);
                _builder.newLineIfNotEmpty();
                _builder.append("Expression exp");
                Integer _get_40 = expressionList.get(indexExpression_2);
                _builder.append(_get_40);
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                Object _method_2 = this.method(((NullTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation);
                _builder.append(_method_2, "\t   \t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                _builder.append("List<EObject> refSelectedObjects");
                int _get_41 = nReference[0];
                _builder.append(_get_41, "\t   \t\t");
                _builder.append(" = evaluate(refObjects");
                int _get_42 = nReference[0];
                _builder.append(_get_42, "\t   \t\t");
                _builder.append(", exp");
                Integer _get_43 = expressionList.get(indexExpression_2);
                _builder.append(_get_43, "\t   \t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject refObject");
                int _get_44 = nReference[0];
                _builder.append(_get_44);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("if (refSelectedObjects");
                int _get_45 = nReference[0];
                _builder.append(_get_45);
                _builder.append(".size() > 0) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("refObject");
                int _get_46 = nReference[0];
                _builder.append(_get_46, "\t");
                _builder.append(" = refSelectedObjects");
                int _get_47 = nReference[0];
                _builder.append(_get_47, "\t");
                _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
                int _get_48 = nReference[0];
                _builder.append(_get_48, "\t");
                _builder.append("));");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("EObject refObject");
                int _get_49 = nReference[0];
                _builder.append(_get_49);
                _builder.append(" = refOts");
                int _get_50 = nReference[0];
                _builder.append(_get_50);
                _builder.append(".getObject();");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("ObSelectionStrategy refSelection");
            int _get_51 = nReference[0];
            _builder.append(_get_51);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refObject");
            int _get_52 = nReference[0];
            _builder.append(_get_52);
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("refSelection");
            int _get_53 = nReference[0];
            _builder.append(_get_53);
            _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
            int _get_54 = nReference[0];
            _builder.append(_get_54);
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            if ((e instanceof CompleteTypeSelection)) {
              _builder.append("RandomTypeSelection refRts");
              int _get_55 = nReference[0];
              _builder.append(_get_55);
              _builder.append(" = new RandomTypeSelection(packages, model, \"");
              String _name_3 = ((CompleteTypeSelection) e).getType().getName();
              _builder.append(_name_3);
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_56 = nReference[0];
              _builder.append(_get_56);
              _builder.append(" = refRts");
              int _get_57 = nReference[0];
              _builder.append(_get_57);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
              _builder.append("ObSelectionStrategy refSelection");
              int _get_58 = nReference[0];
              _builder.append(_get_58);
              _builder.append(" = new SpecificObjectSelection(packages, model,\trefObject");
              int _get_59 = nReference[0];
              _builder.append(_get_59);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              if ((e instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy refSelection");
                int _get_60 = nReference[0];
                _builder.append(_get_60);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                {
                  if ((exhaustive == false)) {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    String _name_4 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_4);
                    _builder.append("_");
                    int _get_61 = nReference[0];
                    _builder.append(_get_61);
                    _builder.append(" = hmObjects.get(\"");
                    String _name_5 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_5);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    String _name_6 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_6);
                    _builder.append("_");
                    int _get_62 = nReference[0];
                    _builder.append(_get_62);
                    _builder.append(" = hmObjects.get(\"");
                    String _name_7 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_7);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("if (entry_");
                String _name_8 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_8);
                _builder.append("_");
                int _get_63 = nReference[0];
                _builder.append(_get_63);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("EObject localT =");
                _builder.newLine();
                _builder.append("\t        ");
                _builder.append("MutatorUtils.recoverLocalObject(");
                _builder.newLine();
                _builder.append("\t            ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t            ");
                _builder.append("entry_");
                String _name_9 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_9, "\t            ");
                _builder.append("_");
                int _get_64 = nReference[0];
                _builder.append(_get_64, "\t            ");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t    ");
                _builder.append("if (localT == null) {");
                _builder.newLine();
                _builder.append("\t        ");
                _builder.append("localT =");
                _builder.newLine();
                _builder.append("\t            ");
                _builder.append("ModelManager.getObject(");
                _builder.newLine();
                _builder.append("\t                ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t                ");
                _builder.append("entry_");
                String _name_10 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_10, "\t                ");
                _builder.append("_");
                int _get_65 = nReference[0];
                _builder.append(_get_65, "\t                ");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t    ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t    ");
                _builder.append("if (localT == null) {");
                _builder.newLine();
                {
                  if ((insideLoop == false)) {
                    {
                      if ((exhaustive == true)) {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                      } else {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return mutations;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    _builder.append("   \t\t\t\t\t\t\t\t\t");
                    _builder.append("continue;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t    ");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType = ((SpecificObjectSelection)e).getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("refSelection");
                    int _get_66 = nReference[0];
                    _builder.append(_get_66);
                    _builder.append(" = new SpecificObjectSelection(packages, model, localT, \"");
                    String _name_11 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_11);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("refSelection");
                    int _get_67 = nReference[0];
                    _builder.append(_get_67);
                    _builder.append(" = new SpecificObjectSelection(packages, model, localT);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("} else {");
                _builder.newLine();
                {
                  if ((exhaustive == false)) {
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                    String _name_12 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_12);
                    _builder.append("_");
                    int _get_68 = nReference[0];
                    _builder.append(_get_68);
                    _builder.append(" = hmList.get(\"");
                    String _name_13 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_13);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                    String _name_14 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_14);
                    _builder.append("_");
                    int _get_69 = nReference[0];
                    _builder.append(_get_69);
                    _builder.append(" = hmList.get(\"");
                    String _name_15 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_15);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("if (listEntry_");
                String _name_16 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_16, "\t");
                _builder.append("_");
                int _get_70 = nReference[0];
                _builder.append(_get_70, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                String _name_17 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_17, "\t\t");
                _builder.append("_");
                int _get_71 = nReference[0];
                _builder.append(_get_71, "\t\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("EObject obj =");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("MutatorUtils.recoverLocalObject(");
                _builder.newLine();
                _builder.append("\t\t\t            ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t\t\t            ");
                _builder.append("ent.getKey());");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.newLine();
                _builder.append("\t\t\t    ");
                _builder.append("if (obj == null) {");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("obj =");
                _builder.newLine();
                _builder.append("\t\t\t            ");
                _builder.append("ModelManager.getObject(");
                _builder.newLine();
                _builder.append("\t\t\t                ");
                _builder.append("model,");
                _builder.newLine();
                _builder.append("\t\t\t                ");
                _builder.append("ent.getKey());");
                _builder.newLine();
                _builder.append("\t\t\t    ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.newLine();
                _builder.append("\t\t\t    ");
                _builder.append("if (obj != null) {");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("objs.add(obj);");
                _builder.newLine();
                _builder.append("\t\t\t    ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("if (objs.isEmpty()) {");
                _builder.newLine();
                {
                  if ((insideLoop == false)) {
                    {
                      if ((exhaustive == true)) {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                      } else {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return mutations;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    _builder.append("   \t\t\t\t\t\t\t\t\t");
                    _builder.append("continue;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_1 = ((SpecificObjectSelection)e).getRefType();
                  boolean _tripleNotEquals_1 = (_refType_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t");
                    _builder.append("refSelection");
                    int _get_72 = nReference[0];
                    _builder.append(_get_72, "\t");
                    _builder.append(" = new SpecificObjectSelection(packages, model, objs, \"");
                    String _name_18 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_18, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("refSelection");
                    int _get_73 = nReference[0];
                    _builder.append(_get_73, "\t");
                    _builder.append(" = new SpecificObjectSelection(packages, model, objs);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                {
                  if ((insideLoop == false)) {
                    {
                      if ((exhaustive == true)) {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                      } else {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return mutations;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    _builder.append("   \t\t\t\t\t\t\t\t\t");
                    _builder.append("continue;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final ReferenceSet e, final Mutator mut, final int[] nReference, final List<Integer> expressionList, final int[] nExpression, final int[] recursionIndexExpression, final boolean exhaustive, final boolean resources, final boolean insideLoop, final boolean[] evaluation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//NAME:");
    String referenceName = "";
    _builder.newLineIfNotEmpty();
    {
      EReference _get = e.getReference().get(0);
      boolean _tripleNotEquals = (_get != null);
      if (_tripleNotEquals) {
        final EReference reference = e.getReference().get(0);
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
      if ((e instanceof ReferenceInit)) {
        CharSequence _method = this.method(((ReferenceInit) e).getObject(), mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
        _builder.append(_method);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((e instanceof ReferenceRemove)) {
        CharSequence _method_1 = this.method(((ReferenceRemove) e).getObject(), mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
        _builder.append(_method_1);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((e instanceof ReferenceAdd)) {
        CharSequence _method_2 = this.method(((ReferenceAdd) e).getObject(), mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
        _builder.append(_method_2);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   \t\t");
    _builder.append("refs.put(\"");
    _builder.append(referenceName, "   \t\t");
    _builder.append("\", refSelection");
    int _get_1 = nReference[0];
    _builder.append(_get_1, "   \t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence method(final AttributeType e, final String attributeName, final boolean flag, final int[] counter, final boolean exhaustive, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        {
          if ((e instanceof StringType)) {
            CharSequence _method = this.method(((StringType) e), attributeName, exhaustive, counter);
            _builder.append(_method);
            _builder.newLineIfNotEmpty();
          } else {
            if ((e instanceof DoubleType)) {
              CharSequence _method_1 = this.method(((DoubleType) e), exhaustive, counter);
              _builder.append(_method_1);
              _builder.newLineIfNotEmpty();
            } else {
              if ((e instanceof BooleanType)) {
                CharSequence _method_2 = this.method(((BooleanType) e), exhaustive, counter);
                _builder.append(_method_2);
                _builder.newLineIfNotEmpty();
              } else {
                if ((e instanceof IntegerType)) {
                  CharSequence _method_3 = this.method(((IntegerType) e), exhaustive, counter);
                  _builder.append(_method_3);
                  _builder.newLineIfNotEmpty();
                } else {
                  if ((e instanceof ListStringType)) {
                    CharSequence _method_4 = this.method(((ListStringType) e), attributeName, flag, exhaustive, counter, obSelectionVariableName);
                    _builder.append(_method_4);
                    _builder.newLineIfNotEmpty();
                  } else {
                    if ((e instanceof ListType)) {
                      CharSequence _method_5 = this.method(((ListType) e), attributeName, flag, exhaustive, counter, obSelectionVariableName);
                      _builder.append(_method_5);
                      _builder.newLineIfNotEmpty();
                    } else {
                      if ((e instanceof RandomType)) {
                        CharSequence _method_6 = this.method(((RandomType) e), attributeName, flag, exhaustive, counter, obSelectionVariableName);
                        _builder.append(_method_6);
                        _builder.newLineIfNotEmpty();
                      } else {
                        if ((e instanceof MinValueType)) {
                          CharSequence _method_7 = this.method(((MinValueType) e), exhaustive, counter);
                          _builder.append(_method_7);
                          _builder.newLineIfNotEmpty();
                        } else {
                          if ((e instanceof MaxValueType)) {
                            CharSequence _method_8 = this.method(((MaxValueType) e), exhaustive, counter);
                            _builder.append(_method_8);
                            _builder.newLineIfNotEmpty();
                          } else {
                            if ((e instanceof RandomIntegerNumberType)) {
                              CharSequence _method_9 = this.method(((RandomIntegerNumberType) e), exhaustive, counter);
                              _builder.append(_method_9);
                              _builder.newLineIfNotEmpty();
                            } else {
                              if ((e instanceof RandomDoubleNumberType)) {
                                CharSequence _method_10 = this.method(((RandomDoubleNumberType) e), exhaustive, counter);
                                _builder.append(_method_10);
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
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final StringType e, final String attributeName, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        {
          int _get = counter[0];
          boolean _equals = (_get == 1);
          if (_equals) {
            _builder.append("AttributeConfigurationStrategy attConfig = null;");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof SpecificStringType)) {
            _builder.append("attConfig = new SpecificStringConfigurationStrategy(\"");
            String _value = ((SpecificStringType) e).getValue();
            _builder.append(_value);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          } else {
            if ((e instanceof RandomStringType)) {
              _builder.append("\t\t    ");
              RandomStringType r = ((RandomStringType) e);
              _builder.newLineIfNotEmpty();
              _builder.append("attConfig = new RandomStringConfigurationStrategy(");
              int _min = r.getMin();
              _builder.append(_min);
              _builder.append(", ");
              int _max = r.getMax();
              _builder.append(_max);
              _builder.append(", false);");
              _builder.newLineIfNotEmpty();
            } else {
              if ((e instanceof UpperStringType)) {
                {
                  boolean _equals_1 = attributeName.equals("");
                  boolean _not = (!_equals_1);
                  if (_not) {
                    _builder.append("attConfig = new UpperStringConfigurationStrategy(\"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                if ((e instanceof LowerStringType)) {
                  {
                    boolean _equals_2 = attributeName.equals("");
                    boolean _not_1 = (!_equals_2);
                    if (_not_1) {
                      _builder.append("attConfig = new LowerStringConfigurationStrategy(\"");
                      _builder.append(attributeName);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  if ((e instanceof CatStartStringType)) {
                    {
                      boolean _equals_3 = attributeName.equals("");
                      boolean _not_2 = (!_equals_3);
                      if (_not_2) {
                        _builder.append("attConfig = new CatStartStringConfigurationStrategy(\"");
                        String _value_1 = ((CatStartStringType) e).getValue();
                        _builder.append(_value_1);
                        _builder.append("\", \"");
                        _builder.append(attributeName);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    if ((e instanceof CatEndStringType)) {
                      {
                        boolean _equals_4 = attributeName.equals("");
                        boolean _not_3 = (!_equals_4);
                        if (_not_3) {
                          _builder.append("attConfig = new CatEndStringConfigurationStrategy(\"");
                          String _value_2 = ((CatEndStringType) e).getValue();
                          _builder.append(_value_2);
                          _builder.append("\", \"");
                          _builder.append(attributeName);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    } else {
                      if ((e instanceof ReplaceStringType)) {
                        {
                          boolean _equals_5 = attributeName.equals("");
                          boolean _not_4 = (!_equals_5);
                          if (_not_4) {
                            _builder.append("attConfig = new ReplaceStringConfigurationStrategy(\"");
                            _builder.append(attributeName);
                            _builder.append("\", \"");
                            String _oldstring = ((ReplaceStringType) e).getOldstring();
                            _builder.append(_oldstring);
                            _builder.append("\", \"");
                            String _newstring = ((ReplaceStringType) e).getNewstring();
                            _builder.append(_newstring);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      } else {
                        if ((e instanceof RandomStringNumberType)) {
                          _builder.append("\t\t    ");
                          RandomStringNumberType r_1 = ((RandomStringNumberType) e);
                          _builder.newLineIfNotEmpty();
                          _builder.append("attConfig = new RandomStringNumberConfigurationStrategy(");
                          int _min_1 = r_1.getMin();
                          _builder.append(_min_1);
                          _builder.append(", ");
                          int _max_1 = r_1.getMax();
                          _builder.append(_max_1);
                          _builder.append(", false);");
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
    }
    return _builder;
  }

  public CharSequence method(final DoubleType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof SpecificDoubleType)) {
        _builder.append("attConfig = new SpecificDoubleConfigurationStrategy(");
        double _value = ((SpecificDoubleType) e).getValue();
        _builder.append(_value);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        if ((e instanceof RandomDoubleType)) {
          RandomDoubleType r = ((RandomDoubleType) e);
          _builder.newLineIfNotEmpty();
          _builder.append("attConfig = new RandomDoubleConfigurationStrategy(");
          double _min = r.getMin();
          _builder.append(_min);
          _builder.append(", ");
          double _max = r.getMax();
          _builder.append(_max);
          _builder.append(", false);");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final BooleanType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof SpecificBooleanType)) {
        _builder.append("attConfig = new SpecificBooleanConfigurationStrategy(");
        boolean _isValue = ((SpecificBooleanType) e).isValue();
        _builder.append(_isValue);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        if ((e instanceof RandomBooleanType)) {
          _builder.append("attConfig = new RandomBooleanConfigurationStrategy();");
          _builder.newLine();
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final IntegerType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof SpecificIntegerType)) {
        _builder.append("attConfig = new SpecificIntegerConfigurationStrategy(");
        int _value = ((SpecificIntegerType) e).getValue();
        _builder.append(_value);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        if ((e instanceof RandomIntegerType)) {
          RandomIntegerType r = ((RandomIntegerType) e);
          _builder.newLineIfNotEmpty();
          _builder.append("attConfig = new RandomIntegerConfigurationStrategy(");
          int _min = r.getMin();
          _builder.append(_min);
          _builder.append(", ");
          int _max = r.getMax();
          _builder.append(_max);
          _builder.append(", false);\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final ListStringType e, final String attributeName, final boolean flag, final boolean exhaustive, final int[] counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        {
          int _get = counter[0];
          boolean _equals = (_get == 1);
          if (_equals) {
            _builder.append("AttributeConfigurationStrategy attConfig = null;");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof ListStringType)) {
            {
              boolean _equals_1 = attributeName.equals("");
              boolean _not = (!_equals_1);
              if (_not) {
                {
                  if ((flag == false)) {
                    _builder.append("attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", (");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null) ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), \"");
                    EList<String> _value = ((ListStringType) e).getValue();
                    _builder.append(_value);
                    _builder.append("\", \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", refObjectSelected), \"");
                    EList<String> _value_1 = ((ListStringType) e).getValue();
                    _builder.append(_value_1);
                    _builder.append("\", \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final ListType e, final String attributeName, final boolean flag, final boolean exhaustive, final int[] counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        {
          int _get = counter[0];
          boolean _equals = (_get == 1);
          if (_equals) {
            _builder.append("AttributeConfigurationStrategy attConfig = null;");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof ListType)) {
            {
              boolean _equals_1 = attributeName.equals("");
              boolean _not = (!_equals_1);
              if (_not) {
                {
                  if ((flag == false)) {
                    _builder.append("attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", (");
                    _builder.append(obSelectionVariableName);
                    _builder.append(" != null) ? ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject() : null), \"");
                    EList<EObject> _value = ((ListType) e).getValue();
                    _builder.append(_value);
                    _builder.append("\", \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", refObjectSelected), \"");
                    EList<EObject> _value_1 = ((ListType) e).getValue();
                    _builder.append(_value_1);
                    _builder.append("\", \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("null");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final RandomType e, final String attributeName, final boolean flag, final boolean exhaustive, final int[] counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        {
          int _get = counter[0];
          boolean _equals = (_get == 1);
          if (_equals) {
            _builder.append("AttributeConfigurationStrategy attConfig = null;");
            _builder.newLine();
          }
        }
        {
          if ((e instanceof RandomType)) {
            {
              boolean _equals_1 = attributeName.equals("");
              boolean _not = (!_equals_1);
              if (_not) {
                {
                  if ((flag == false)) {
                    _builder.append("attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", ");
                    _builder.append(obSelectionVariableName);
                    _builder.append(".getObject()), \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute(\"");
                    _builder.append(attributeName);
                    _builder.append("\", refObjectSelected), \"");
                    _builder.append(attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("null");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final MinValueType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    _builder.append("attConfig = new MinValueConfigurationStrategy(packages, model, \"");
    String _typeName = MutatorUtils.getTypeName(e);
    _builder.append(_typeName);
    _builder.append("\", \"");
    String _name = e.getAttribute().getName();
    _builder.append(_name);
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence method(final MaxValueType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    _builder.append("attConfig = new MaxValueConfigurationStrategy(packages, model, \"");
    String _typeName = MutatorUtils.getTypeName(e);
    _builder.append(_typeName);
    _builder.append("\", \"");
    String _name = e.getAttribute().getName();
    _builder.append(_name);
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence method(final RandomIntegerNumberType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      ObSelectionStrategy _object = e.getObject();
      if ((_object instanceof SpecificObjectSelection)) {
        _builder.append("//");
        ObSelectionStrategy _object_1 = e.getObject();
        SpecificObjectSelection sel = ((SpecificObjectSelection) _object_1);
        _builder.newLineIfNotEmpty();
        {
          if ((exhaustive == false)) {
            _builder.append("attConfig = new RandomIntegerConfigurationStrategy(");
            int _min = e.getMin();
            _builder.append(_min);
            _builder.append(", ModelManager.getIntAttribute(\"");
            String _name = e.getMax().getName();
            _builder.append(_name);
            _builder.append("\", (hmObjects.get(\"");
            String _name_1 = sel.getObjSel().getName();
            _builder.append(_name_1);
            _builder.append("\") != null ? hmObjects.get(\"");
            String _name_2 = sel.getObjSel().getName();
            _builder.append(_name_2);
            _builder.append("\").getKey() : null)), false);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("attConfig = new RandomIntegerConfigurationStrategy(");
            int _min_1 = e.getMin();
            _builder.append(_min_1);
            _builder.append(", ModelManager.getIntAttribute(\"");
            String _name_3 = e.getMax().getName();
            _builder.append(_name_3);
            _builder.append("\", (hmObjects.get(\"");
            String _name_4 = sel.getObjSel().getName();
            _builder.append(_name_4);
            _builder.append("\") != null ? hmObjects.get(\"");
            String _name_5 = sel.getObjSel().getName();
            _builder.append(_name_5);
            _builder.append("\").getKey() : null)), false);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final RandomDoubleNumberType e, final boolean exhaustive, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _get = counter[0];
      boolean _equals = (_get == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      ObSelectionStrategy _object = e.getObject();
      if ((_object instanceof SpecificObjectSelection)) {
        _builder.append("//");
        ObSelectionStrategy _object_1 = e.getObject();
        SpecificObjectSelection sel = ((SpecificObjectSelection) _object_1);
        _builder.newLineIfNotEmpty();
        _builder.append("attConfig = new RandomDoubleConfigurationStrategy(");
        double _min = e.getMin();
        _builder.append(_min);
        _builder.append(", ModelManager.getDoubleAttribute(\"");
        String _name = e.getMax().getName();
        _builder.append(_name);
        _builder.append("\", (hmObjects.get(\"");
        String _name_1 = sel.getObjSel().getName();
        _builder.append(_name_1);
        _builder.append("\") != null ? hmObjects.get(\"");
        String _name_2 = sel.getObjSel().getName();
        _builder.append(_name_2);
        _builder.append("\").getKey() : null)), false);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence add(final AttributeOperation op, final String attributeName, final String obSelectionVariableName, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        _builder.append("atts.add(new AddOperationConfigurationStrategy(");
        _builder.append(obSelectionVariableName);
        _builder.append(".getMetaModel(), ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getModel(), \"");
        String _typeName = MutatorUtils.getTypeName(op);
        _builder.append(_typeName);
        _builder.append("\", \"");
        _builder.append(attributeName);
        _builder.append("\", ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getObject(), value));");
        _builder.newLineIfNotEmpty();
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence subtract(final AttributeOperation op, final String attributeName, final String obSelectionVariableName, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        _builder.append("atts.add(new SubtractOperationConfigurationStrategy(");
        _builder.append(obSelectionVariableName);
        _builder.append(".getMetaModel(), ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getModel(), \"");
        String _typeName = MutatorUtils.getTypeName(op);
        _builder.append(_typeName);
        _builder.append("\", \"");
        _builder.append(attributeName);
        _builder.append("\", ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getObject(), value));");
        _builder.newLineIfNotEmpty();
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts); ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence multiply(final AttributeOperation op, final String attributeName, final String obSelectionVariableName, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        _builder.append("atts.add(new MultiplyOperationConfigurationStrategy(");
        _builder.append(obSelectionVariableName);
        _builder.append(".getMetaModel(), ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getModel(), \"");
        String _typeName = MutatorUtils.getTypeName(op);
        _builder.append(_typeName);
        _builder.append("\", \"");
        _builder.append(attributeName);
        _builder.append("\", ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getObject(), value));");
        _builder.newLineIfNotEmpty();
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts); ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence divide(final AttributeOperation op, final String attributeName, final String obSelectionVariableName, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        _builder.append("atts.add(new DivideOperationConfigurationStrategy(");
        _builder.append(obSelectionVariableName);
        _builder.append(".getMetaModel(), ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getModel(), \"");
        String _typeName = MutatorUtils.getTypeName(op);
        _builder.append(_typeName);
        _builder.append("\", \"");
        _builder.append(attributeName);
        _builder.append("\", ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getObject(), value));");
        _builder.newLineIfNotEmpty();
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts); ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence module(final AttributeOperation op, final String attributeName, final String obSelectionVariableName, final int[] counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((attributeName != null)) {
        _builder.append("atts.add(new ModuleOperationConfigurationStrategy(");
        _builder.append(obSelectionVariableName);
        _builder.append(".getMetaModel(), ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getModel(), \"");
        String _typeName = MutatorUtils.getTypeName(op);
        _builder.append(_typeName);
        _builder.append("\", \"");
        _builder.append(attributeName);
        _builder.append("\", ");
        _builder.append(obSelectionVariableName);
        _builder.append(".getObject(), value));");
        _builder.newLineIfNotEmpty();
        _builder.append("attsList.put(\"");
        _builder.append(attributeName);
        _builder.append("\", atts); ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence method(final ObSelectionStrategy e, final Mutator mut, final String referenceName, final boolean exhaustive, final List<Integer> expressionList, final int[] nReference, final boolean resources, final boolean insideLoop, final boolean[] evaluation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  \t\t");
    _builder.append("//REFERENCES COMPILES\t");
    int _get = nReference[0];
    int _plus = (_get + 1);
    int _set = nReference[0] = _plus;
    _builder.append(_set, "  \t\t");
    _builder.newLineIfNotEmpty();
    {
      if ((e instanceof RandomTypeSelection)) {
        _builder.append("RandomTypeSelection refRts");
        int _get_1 = nReference[0];
        _builder.append(_get_1);
        _builder.append(" = new RandomTypeSelection(packages, model, \"");
        String _name = ((RandomTypeSelection) e).getType().getName();
        _builder.append(_name);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          if (((((RandomTypeSelection)e).getExpression() != null) && (expressionList != null))) {
            _builder.append("List<EObject> refObjects");
            int _get_2 = nReference[0];
            _builder.append(_get_2);
            _builder.append(" = refRts");
            int _get_3 = nReference[0];
            _builder.append(_get_3);
            _builder.append(".getObjects();");
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int _size = expressionList.size();
            int indexExpression = (_size - 1);
            _builder.newLineIfNotEmpty();
            _builder.append("Expression exp");
            Integer _get_4 = expressionList.get(indexExpression);
            _builder.append(_get_4);
            _builder.append(" = new Expression();");
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int _set_1 = nExpression[0] = 0;
            _builder.append(_set_1);
            _builder.newLineIfNotEmpty();
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_2 = recursionIndexExpression[0] = 0;
            _builder.append(_set_2);
            _builder.newLineIfNotEmpty();
            Object _method = this.method(((RandomTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation);
            _builder.append(_method);
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            _builder.append("List<EObject> refSelectedObjects");
            int _get_5 = nReference[0];
            _builder.append(_get_5, "\t   \t\t");
            _builder.append(" = evaluate(refObjects");
            int _get_6 = nReference[0];
            _builder.append(_get_6, "\t   \t\t");
            _builder.append(", exp");
            Integer _get_7 = expressionList.get(indexExpression);
            _builder.append(_get_7, "\t   \t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("EObject refObject");
            int _get_8 = nReference[0];
            _builder.append(_get_8);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refSelectedObjects");
            int _get_9 = nReference[0];
            _builder.append(_get_9);
            _builder.append(".size() > 0) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("refObject");
            int _get_10 = nReference[0];
            _builder.append(_get_10, "\t");
            _builder.append(" = refSelectedObjects");
            int _get_11 = nReference[0];
            _builder.append(_get_11, "\t");
            _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
            int _get_12 = nReference[0];
            _builder.append(_get_12, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("EObject refObject");
            int _get_13 = nReference[0];
            _builder.append(_get_13);
            _builder.append(" = refRts");
            int _get_14 = nReference[0];
            _builder.append(_get_14);
            _builder.append(".getObject();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("ObSelectionStrategy refSelection");
        int _get_15 = nReference[0];
        _builder.append(_get_15);
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("if (refObject");
        int _get_16 = nReference[0];
        _builder.append(_get_16);
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("refSelection");
        int _get_17 = nReference[0];
        _builder.append(_get_17);
        _builder.append(" = ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new SpecificObjectSelection(packages, model, refObject");
        int _get_18 = nReference[0];
        _builder.append(_get_18, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      } else {
        if ((e instanceof OtherTypeSelection)) {
          _builder.append("OtherTypeSelection refOts");
          int _get_19 = nReference[0];
          _builder.append(_get_19);
          _builder.append(" = new OtherTypeSelection(packages, model, \"");
          String _name_1 = ((OtherTypeSelection) e).getType().getName();
          _builder.append(_name_1);
          _builder.append("\", ModelManager.getReference(\"");
          _builder.append(referenceName);
          _builder.append("\", objectSelection.getObject()));");
          _builder.newLineIfNotEmpty();
          {
            if (((((OtherTypeSelection)e).getExpression() != null) && (expressionList != null))) {
              _builder.append("List<EObject> refObjects");
              int _get_20 = nReference[0];
              _builder.append(_get_20);
              _builder.append(" = refOts");
              int _get_21 = nReference[0];
              _builder.append(_get_21);
              _builder.append(".getObjects();");
              _builder.newLineIfNotEmpty();
              _builder.append("//INDEX EXPRESSION: ");
              int _size_1 = expressionList.size();
              int indexExpression_1 = (_size_1 - 1);
              _builder.newLineIfNotEmpty();
              _builder.append("Expression exp");
              Integer _get_22 = expressionList.get(indexExpression_1);
              _builder.append(_get_22);
              _builder.append(" = new Expression();");
              _builder.newLineIfNotEmpty();
              _builder.append("//INDEX EXPRESSION: ");
              int[] nExpression_1 = new int[1];
              _builder.newLineIfNotEmpty();
              _builder.append("//INDEX EXPRESSION: ");
              int _set_3 = nExpression_1[0] = 0;
              _builder.append(_set_3);
              _builder.newLineIfNotEmpty();
              _builder.append("//RECURSION INDEX EXPRESSION: ");
              int[] recursionIndexExpression_1 = new int[1];
              _builder.newLineIfNotEmpty();
              _builder.append("//RECURSION INDEX EXPRESSION: ");
              int _set_4 = recursionIndexExpression_1[0] = 0;
              _builder.append(_set_4);
              _builder.newLineIfNotEmpty();
              Object _method_1 = this.method(((OtherTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression_1, recursionIndexExpression_1, false, resources, insideLoop, evaluation);
              _builder.append(_method_1);
              _builder.newLineIfNotEmpty();
              _builder.append("\t   \t\t");
              _builder.append("List<EObject> refSelectedObjects");
              int _get_23 = nReference[0];
              _builder.append(_get_23, "\t   \t\t");
              _builder.append(" = evaluate(refObjects");
              int _get_24 = nReference[0];
              _builder.append(_get_24, "\t   \t\t");
              _builder.append(", exp");
              Integer _get_25 = expressionList.get(indexExpression_1);
              _builder.append(_get_25, "\t   \t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_26 = nReference[0];
              _builder.append(_get_26);
              _builder.append(" = null;");
              _builder.newLineIfNotEmpty();
              _builder.append("if (refSelectedObjects");
              int _get_27 = nReference[0];
              _builder.append(_get_27);
              _builder.append(".size() > 0) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("refObject");
              int _get_28 = nReference[0];
              _builder.append(_get_28, "\t");
              _builder.append(" = refSelectedObjects");
              int _get_29 = nReference[0];
              _builder.append(_get_29, "\t");
              _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
              int _get_30 = nReference[0];
              _builder.append(_get_30, "\t");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("EObject refObject");
              int _get_31 = nReference[0];
              _builder.append(_get_31);
              _builder.append(" = refOts");
              int _get_32 = nReference[0];
              _builder.append(_get_32);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("ObSelectionStrategy refSelection");
          int _get_33 = nReference[0];
          _builder.append(_get_33);
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
          _builder.append("if (refObject");
          int _get_34 = nReference[0];
          _builder.append(_get_34);
          _builder.append(" != null) {");
          _builder.newLineIfNotEmpty();
          _builder.append("refSelection");
          int _get_35 = nReference[0];
          _builder.append(_get_35);
          _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
          int _get_36 = nReference[0];
          _builder.append(_get_36);
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          if ((e instanceof NullTypeSelection)) {
            _builder.append("NullTypeSelection refNts");
            int _get_37 = nReference[0];
            _builder.append(_get_37);
            _builder.append(" = new NullTypeSelection(packages, model, \"");
            String _name_2 = ((NullTypeSelection) e).getType().getName();
            _builder.append(_name_2);
            _builder.append("\", ModelManager.getReference(\"");
            _builder.append(referenceName);
            _builder.append("\", objectSelection.getObject()));");
            _builder.newLineIfNotEmpty();
            {
              if (((((NullTypeSelection)e).getExpression() != null) && (expressionList != null))) {
                _builder.append("List<EObject> refObjects");
                int _get_38 = nReference[0];
                _builder.append(_get_38);
                _builder.append(" = refNts");
                int _get_39 = nReference[0];
                _builder.append(_get_39);
                _builder.append(".getObjects();");
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int _size_2 = expressionList.size();
                int indexExpression_2 = (_size_2 - 1);
                _builder.newLineIfNotEmpty();
                _builder.append("Expression exp");
                Integer _get_40 = expressionList.get(indexExpression_2);
                _builder.append(_get_40);
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int[] nExpression_2 = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int _set_5 = nExpression_2[0] = 0;
                _builder.append(_set_5);
                _builder.newLineIfNotEmpty();
                _builder.append("//RECURSION INDEX EXPRESSION: ");
                int[] recursionIndexExpression_2 = new int[1];
                _builder.newLineIfNotEmpty();
                _builder.append("//RECURSION INDEX EXPRESSION: ");
                int _set_6 = recursionIndexExpression_2[0] = 0;
                _builder.append(_set_6);
                _builder.newLineIfNotEmpty();
                Object _method_2 = this.method(((NullTypeSelection)e).getExpression(), mut, nReference, expressionList, nExpression_2, recursionIndexExpression_2, false, resources, insideLoop, evaluation);
                _builder.append(_method_2);
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                _builder.append("List<EObject> refSelectedObjects");
                int _get_41 = nReference[0];
                _builder.append(_get_41, "\t   \t\t");
                _builder.append(" = evaluate(refObjects");
                int _get_42 = nReference[0];
                _builder.append(_get_42, "\t   \t\t");
                _builder.append(", exp");
                Integer _get_43 = expressionList.get(indexExpression_2);
                _builder.append(_get_43, "\t   \t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject refObject");
                int _get_44 = nReference[0];
                _builder.append(_get_44);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("if (refSelectedObjects");
                int _get_45 = nReference[0];
                _builder.append(_get_45);
                _builder.append(".size() > 0) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("refObject");
                int _get_46 = nReference[0];
                _builder.append(_get_46, "\t");
                _builder.append(" = refSelectedObjects");
                int _get_47 = nReference[0];
                _builder.append(_get_47, "\t");
                _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
                int _get_48 = nReference[0];
                _builder.append(_get_48, "\t");
                _builder.append("));");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("EObject refObject");
                int _get_49 = nReference[0];
                _builder.append(_get_49);
                _builder.append(" = refOts");
                int _get_50 = nReference[0];
                _builder.append(_get_50);
                _builder.append(".getObject();");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("ObSelectionStrategy refSelection");
            int _get_51 = nReference[0];
            _builder.append(_get_51);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refObject");
            int _get_52 = nReference[0];
            _builder.append(_get_52);
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("refSelection");
            int _get_53 = nReference[0];
            _builder.append(_get_53);
            _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
            int _get_54 = nReference[0];
            _builder.append(_get_54);
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            if ((e instanceof CompleteTypeSelection)) {
              _builder.append("RandomTypeSelection refRts");
              int _get_55 = nReference[0];
              _builder.append(_get_55);
              _builder.append(" = new RandomTypeSelection(packages, model, \"");
              String _name_3 = ((CompleteTypeSelection) e).getType().getName();
              _builder.append(_name_3);
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_56 = nReference[0];
              _builder.append(_get_56);
              _builder.append(" = refRts");
              int _get_57 = nReference[0];
              _builder.append(_get_57);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
              _builder.append("ObSelectionStrategy refSelection");
              int _get_58 = nReference[0];
              _builder.append(_get_58);
              _builder.append(" = new SpecificObjectSelection(packages, model,\trefObject");
              int _get_59 = nReference[0];
              _builder.append(_get_59);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              if ((e instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy refSelection");
                int _get_60 = nReference[0];
                _builder.append(_get_60);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                {
                  if ((exhaustive == false)) {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    String _name_4 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_4);
                    _builder.append("_");
                    int _get_61 = nReference[0];
                    _builder.append(_get_61);
                    _builder.append(" = hmObjects.get(\"");
                    String _name_5 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_5);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    String _name_6 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_6);
                    _builder.append("_");
                    int _get_62 = nReference[0];
                    _builder.append(_get_62);
                    _builder.append(" = hmObjects.get(\"");
                    String _name_7 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_7);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("if (entry_");
                String _name_8 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_8);
                _builder.append("_");
                int _get_63 = nReference[0];
                _builder.append(_get_63);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                {
                  EReference _refType = ((SpecificObjectSelection)e).getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("refSelection");
                    int _get_64 = nReference[0];
                    _builder.append(_get_64);
                    _builder.append(" = new SpecificObjectSelection(packages, model, entry_");
                    String _name_9 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_9);
                    _builder.append("_");
                    int _get_65 = nReference[0];
                    _builder.append(_get_65);
                    _builder.append(".getKey(), \"");
                    String _name_10 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_10);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("refSelection");
                    int _get_66 = nReference[0];
                    _builder.append(_get_66);
                    _builder.append(" = new SpecificObjectSelection(packages, model, entry_");
                    String _name_11 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_11);
                    _builder.append("_");
                    int _get_67 = nReference[0];
                    _builder.append(_get_67);
                    _builder.append(".getKey());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("} else {");
                _builder.newLine();
                {
                  if ((exhaustive == false)) {
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                    String _name_12 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_12);
                    _builder.append("_");
                    int _get_68 = nReference[0];
                    _builder.append(_get_68);
                    _builder.append(" = hmList.get(\"");
                    String _name_13 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_13);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                    String _name_14 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_14);
                    _builder.append("_");
                    int _get_69 = nReference[0];
                    _builder.append(_get_69);
                    _builder.append(" = hmList.get(\"");
                    String _name_15 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_15);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("if (listEntry_");
                String _name_16 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_16, "\t");
                _builder.append("_");
                int _get_70 = nReference[0];
                _builder.append(_get_70, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                String _name_17 = ((SpecificObjectSelection) e).getObjSel().getName();
                _builder.append(_name_17, "\t\t");
                _builder.append("_");
                int _get_71 = nReference[0];
                _builder.append(_get_71, "\t\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("EObject obj = ModelManager.getObject(model, ent.getKey());");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("objs.add(obj);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_1 = ((SpecificObjectSelection)e).getRefType();
                  boolean _tripleNotEquals_1 = (_refType_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t");
                    _builder.append("refSelection");
                    int _get_72 = nReference[0];
                    _builder.append(_get_72, "\t");
                    _builder.append(" = new SpecificObjectSelection(packages, model, objs, \"");
                    String _name_18 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_18, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("refSelection");
                    int _get_73 = nReference[0];
                    _builder.append(_get_73, "\t");
                    _builder.append(" = new SpecificObjectSelection(packages, model, objs);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                {
                  if ((insideLoop == false)) {
                    {
                      if ((exhaustive == true)) {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                      } else {
                        _builder.append("   \t\t\t\t\t\t\t\t\t");
                        _builder.append("return mutations;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    _builder.append("   \t\t\t\t\t\t\t\t\t");
                    _builder.append("continue;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public String compileAuxiliarExpression(final int expressionPosition, final List<Integer> expressionList) {
    int _size = expressionList.size();
    int indexExpression = (_size - 1);
    List<Integer> expressionArray = new ArrayList<Integer>();
    int i = 0;
    while ((i < expressionPosition)) {
      {
        expressionArray.add(Integer.valueOf(i));
        i++;
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Integer expressionCounter : expressionArray) {
        {
          if (((expressionCounter).intValue() == 0)) {
            _builder.append("Expression auxExp");
            Integer _get = expressionList.get(indexExpression);
            _builder.append(_get);
            _builder.append(" = new Expression();");
            _builder.newLineIfNotEmpty();
            _builder.append("auxExp");
            Integer _get_1 = expressionList.get(indexExpression);
            _builder.append(_get_1);
            _builder.append(".first = exp");
            Integer _get_2 = expressionList.get(indexExpression);
            _builder.append(_get_2);
            _builder.append(".first;");
            _builder.newLineIfNotEmpty();
            _builder.append("auxExp");
            Integer _get_3 = expressionList.get(indexExpression);
            _builder.append(_get_3);
            _builder.append(".operator = new ArrayList<Operator>();");
            _builder.newLineIfNotEmpty();
          } else {
            {
              if (((expressionCounter).intValue() == 1)) {
                _builder.append("Operator op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_4 = expressionList.get(indexExpression);
                _builder.append(_get_4);
                _builder.append(" = new Operator();");
                _builder.newLineIfNotEmpty();
                _builder.append("op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_5 = expressionList.get(indexExpression);
                _builder.append(_get_5);
                _builder.append(".type = exp");
                Integer _get_6 = expressionList.get(indexExpression);
                _builder.append(_get_6);
                _builder.append(".operator.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append(").type;");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_7 = expressionList.get(indexExpression);
                _builder.append(_get_7);
                _builder.append(".operator.add(op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_8 = expressionList.get(indexExpression);
                _builder.append(_get_8);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_9 = expressionList.get(indexExpression);
                _builder.append(_get_9);
                _builder.append(".second = new ArrayList<Evaluation>();");
                _builder.newLineIfNotEmpty();
                _builder.append("exp");
                Integer _get_10 = expressionList.get(indexExpression);
                _builder.append(_get_10);
                _builder.append(".second.add(exp");
                Integer _get_11 = expressionList.get(indexExpression);
                _builder.append(_get_11);
                _builder.append(".second.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("));");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("Operator op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_12 = expressionList.get(indexExpression);
                _builder.append(_get_12);
                _builder.append(" = new Operator();");
                _builder.newLineIfNotEmpty();
                _builder.append("op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_13 = expressionList.get(indexExpression);
                _builder.append(_get_13);
                _builder.append(".type = exp");
                Integer _get_14 = expressionList.get(indexExpression);
                _builder.append(_get_14);
                _builder.append(".operator.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append(").type;");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_15 = expressionList.get(indexExpression);
                _builder.append(_get_15);
                _builder.append(".operator.add(op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_16 = expressionList.get(indexExpression);
                _builder.append(_get_16);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("exp");
                Integer _get_17 = expressionList.get(indexExpression);
                _builder.append(_get_17);
                _builder.append(".second.add(exp");
                Integer _get_18 = expressionList.get(indexExpression);
                _builder.append(_get_18);
                _builder.append(".second.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("));");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder.toString();
  }

  public Object method(final Expression exp, final Mutator mut, final int[] nReference, final List<Integer> expressionList, final int[] nExpression, final int[] recursionIndexExpression, final boolean exhaustive, final boolean resources, final boolean insideLoop, final boolean[] evaluation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  \t\t");
    _builder.append("//INDEX EXPRESSION: ");
    int _size = expressionList.size();
    final int indexExpression = (_size - 1);
    _builder.newLineIfNotEmpty();
    {
      Evaluation _first = exp.getFirst();
      if ((_first instanceof AttributeEvaluation)) {
        {
          Evaluation _first_1 = exp.getFirst();
          AttributeEvaluationType _value = ((AttributeEvaluation) _first_1).getValue();
          if ((_value instanceof ObjectAttributeType)) {
            _builder.append("  \t\t");
            _builder.append("exp");
            Integer _get = expressionList.get(indexExpression);
            _builder.append(_get, "  \t\t");
            _builder.append(".first = new AttributeEvaluation();");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("//ATTRIBUTE: ");
            Evaluation _first_2 = exp.getFirst();
            final AttributeEvaluation attev = ((AttributeEvaluation) _first_2);
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_1 = expressionList.get(indexExpression);
            _builder.append(_get_1, "  \t\t");
            _builder.append(".first).name = \"");
            String _name = attev.getName().getName();
            _builder.append(_name, "  \t\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_2 = expressionList.get(indexExpression);
            _builder.append(_get_2, "  \t\t");
            _builder.append(".first).operator = \"");
            AttributeEvaluationType _value_1 = attev.getValue();
            Operator _operator = ((ObjectAttributeType) _value_1).getOperator();
            _builder.append(_operator, "  \t\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_3 = expressionList.get(indexExpression);
            _builder.append(_get_3, "  \t\t");
            _builder.append(".first).values = new ArrayList<Object>();");
            _builder.newLineIfNotEmpty();
            {
              if (((((ObjectAttributeType) attev.getValue()).getAttribute().getUpperBound() > 1) || (((ObjectAttributeType) attev.getValue()).getAttribute().getUpperBound() == (-1)))) {
                _builder.append("  \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_4 = expressionList.get(indexExpression);
                _builder.append(_get_4, "  \t\t");
                _builder.append(".first).values.addAll(ModelManager.getStringAttributes(\"");
                AttributeEvaluationType _value_2 = attev.getValue();
                String _name_1 = ((ObjectAttributeType) _value_2).getAttribute().getName();
                _builder.append(_name_1, "  \t\t");
                _builder.append("\", hmObjects.get(\"");
                AttributeEvaluationType _value_3 = attev.getValue();
                String _name_2 = ((ObjectAttributeType) _value_3).getObjSel().getName();
                _builder.append(_name_2, "  \t\t");
                _builder.append("\") != null ? hmObjects.get(\"");
                AttributeEvaluationType _value_4 = attev.getValue();
                String _name_3 = ((ObjectAttributeType) _value_4).getObjSel().getName();
                _builder.append(_name_3, "  \t\t");
                _builder.append("\").getKey() : null));");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("  \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_5 = expressionList.get(indexExpression);
                _builder.append(_get_5, "  \t\t");
                _builder.append(".first).values.add(ModelManager.getStringAttribute(\"");
                AttributeEvaluationType _value_5 = attev.getValue();
                String _name_4 = ((ObjectAttributeType) _value_5).getAttribute().getName();
                _builder.append(_name_4, "  \t\t");
                _builder.append("\", hmObjects.get(\"");
                AttributeEvaluationType _value_6 = attev.getValue();
                String _name_5 = ((ObjectAttributeType) _value_6).getObjSel().getName();
                _builder.append(_name_5, "  \t\t");
                _builder.append("\") != null ? hmObjects.get(\"");
                AttributeEvaluationType _value_7 = attev.getValue();
                String _name_6 = ((ObjectAttributeType) _value_7).getObjSel().getName();
                _builder.append(_name_6, "  \t\t");
                _builder.append("\").getKey() : null));");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          Evaluation _first_3 = exp.getFirst();
          AttributeEvaluationType _value_8 = ((AttributeEvaluation) _first_3).getValue();
          if ((_value_8 instanceof AttributeType)) {
            _builder.append("exp");
            Integer _get_6 = expressionList.get(indexExpression);
            _builder.append(_get_6);
            _builder.append(".first = new AttributeEvaluation();");
            _builder.newLineIfNotEmpty();
            _builder.append("//ATTRIBUTE: ");
            Evaluation _first_4 = exp.getFirst();
            final AttributeEvaluation attev_1 = ((AttributeEvaluation) _first_4);
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_7 = expressionList.get(indexExpression);
            _builder.append(_get_7);
            _builder.append(".first).name = \"");
            String _name_7 = attev_1.getName().getName();
            _builder.append(_name_7);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_8 = expressionList.get(indexExpression);
            _builder.append(_get_8);
            _builder.append(".first).operator = \"");
            AttributeEvaluationType _value_9 = attev_1.getValue();
            Operator _operator_1 = ((AttributeType) _value_9).getOperator();
            _builder.append(_operator_1);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_9 = expressionList.get(indexExpression);
            _builder.append(_get_9);
            _builder.append(".first).values = new ArrayList<Object>();");
            _builder.newLineIfNotEmpty();
            {
              AttributeEvaluationType _value_10 = attev_1.getValue();
              if ((_value_10 instanceof StringType)) {
                _builder.append("   \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_10 = expressionList.get(indexExpression);
                _builder.append(_get_10, "   \t\t");
                _builder.append(".first).values.add(\"");
                AttributeEvaluationType _value_11 = attev_1.getValue();
                String _value_12 = ((SpecificStringType) _value_11).getValue();
                _builder.append(_value_12, "   \t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("   \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_11 = expressionList.get(indexExpression);
                _builder.append(_get_11, "   \t\t");
                _builder.append(".first).type = \"String\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_13 = attev_1.getValue();
              if ((_value_13 instanceof DoubleType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_12 = expressionList.get(indexExpression);
                _builder.append(_get_12);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_14 = attev_1.getValue();
                double _value_15 = ((SpecificDoubleType) _value_14).getValue();
                _builder.append(_value_15);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_13 = expressionList.get(indexExpression);
                _builder.append(_get_13);
                _builder.append(".first).type = \"double\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_16 = attev_1.getValue();
              if ((_value_16 instanceof BooleanType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_14 = expressionList.get(indexExpression);
                _builder.append(_get_14);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_17 = attev_1.getValue();
                boolean _isValue = ((SpecificBooleanType) _value_17).isValue();
                _builder.append(_isValue);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_15 = expressionList.get(indexExpression);
                _builder.append(_get_15);
                _builder.append(".first).type = \"Boolean\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_18 = attev_1.getValue();
              if ((_value_18 instanceof IntegerType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_16 = expressionList.get(indexExpression);
                _builder.append(_get_16);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_19 = attev_1.getValue();
                int _value_20 = ((SpecificIntegerType) _value_19).getValue();
                _builder.append(_value_20);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_17 = expressionList.get(indexExpression);
                _builder.append(_get_17);
                _builder.append(".first).type = \"int\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_21 = attev_1.getValue();
              if ((_value_21 instanceof MinValueType)) {
                _builder.append("//");
                int expressionPosition = 0;
                _builder.newLineIfNotEmpty();
                {
                  if ((resources == false)) {
                    {
                      if ((expressionPosition == 0)) {
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_18 = expressionList.get(indexExpression);
                        _builder.append(_get_18);
                        _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_22 = attev_1.getValue();
                        String _typeName = MutatorUtils.getTypeName(((MinValueType) _value_22));
                        _builder.append(_typeName);
                        _builder.append("\", \"");
                        AttributeEvaluationType _value_23 = attev_1.getValue();
                        String _name_8 = ((MinValueType) _value_23).getAttribute().getName();
                        _builder.append(_name_8);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        String _compileAuxiliarExpression = this.compileAuxiliarExpression(expressionPosition, expressionList);
                        _builder.append(_compileAuxiliarExpression);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_19 = expressionList.get(indexExpression);
                        _builder.append(_get_19);
                        _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_24 = attev_1.getValue();
                        String _typeName_1 = MutatorUtils.getTypeName(((MinValueType) _value_24));
                        _builder.append(_typeName_1);
                        _builder.append("\", sameValue, \"");
                        AttributeEvaluationType _value_25 = attev_1.getValue();
                        String _name_9 = ((MinValueType) _value_25).getAttribute().getName();
                        _builder.append(_name_9);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_20 = expressionList.get(indexExpression);
                    _builder.append(_get_20);
                    _builder.append(".first).values.add(min");
                    Integer _get_21 = expressionList.get(indexExpression);
                    _builder.append(_get_21);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                    String _xblockexpression = null;
                    {
                      evaluation[0] = true;
                      _xblockexpression = "";
                    }
                    _builder.append(_xblockexpression);
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      if ((expressionPosition == 0)) {
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_22 = expressionList.get(indexExpression);
                        _builder.append(_get_22);
                        _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                        AttributeEvaluationType _value_26 = attev_1.getValue();
                        String _typeName_2 = MutatorUtils.getTypeName(((MinValueType) _value_26));
                        _builder.append(_typeName_2);
                        _builder.append("\", \"");
                        AttributeEvaluationType _value_27 = attev_1.getValue();
                        String _name_10 = ((MinValueType) _value_27).getAttribute().getName();
                        _builder.append(_name_10);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        String _compileAuxiliarExpression_1 = this.compileAuxiliarExpression(expressionPosition, expressionList);
                        _builder.append(_compileAuxiliarExpression_1);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_23 = expressionList.get(indexExpression);
                        _builder.append(_get_23);
                        _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, model, \"");
                        AttributeEvaluationType _value_28 = attev_1.getValue();
                        String _typeName_3 = MutatorUtils.getTypeName(((MinValueType) _value_28));
                        _builder.append(_typeName_3);
                        _builder.append("\", sameValue, \"");
                        AttributeEvaluationType _value_29 = attev_1.getValue();
                        String _name_11 = ((MinValueType) _value_29).getAttribute().getName();
                        _builder.append(_name_11);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_1 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_1 = "";
                        }
                        _builder.append(_xblockexpression_1);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_24 = expressionList.get(indexExpression);
                    _builder.append(_get_24);
                    _builder.append(".first).values.add(min");
                    Integer _get_25 = expressionList.get(indexExpression);
                    _builder.append(_get_25);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_30 = attev_1.getValue();
                  boolean _equals = ((MinValueType) _value_30).getAttribute().getEType().getName().equals("EInt");
                  if (_equals) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_26 = expressionList.get(indexExpression);
                    _builder.append(_get_26);
                    _builder.append(".first).type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_31 = attev_1.getValue();
                  boolean _equals_1 = ((MinValueType) _value_31).getAttribute().getEType().getName().equals("EFloat");
                  if (_equals_1) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_27 = expressionList.get(indexExpression);
                    _builder.append(_get_27);
                    _builder.append(".first).type = \"float\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_32 = attev_1.getValue();
                  boolean _equals_2 = ((MinValueType) _value_32).getAttribute().getEType().getName().equals("EDouble");
                  if (_equals_2) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_28 = expressionList.get(indexExpression);
                    _builder.append(_get_28);
                    _builder.append(".first).type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                String _xblockexpression_2 = null;
                {
                  evaluation[0] = true;
                  _xblockexpression_2 = "";
                }
                _builder.append(_xblockexpression_2);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_33 = attev_1.getValue();
              if ((_value_33 instanceof MaxValueType)) {
                _builder.append("//");
                int expressionPosition_1 = 0;
                _builder.newLineIfNotEmpty();
                {
                  if ((resources == false)) {
                    {
                      if ((expressionPosition_1 == 0)) {
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_29 = expressionList.get(indexExpression);
                        _builder.append(_get_29);
                        _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_34 = attev_1.getValue();
                        String _typeName_4 = MutatorUtils.getTypeName(((MaxValueType) _value_34));
                        _builder.append(_typeName_4);
                        _builder.append("\", \"");
                        AttributeEvaluationType _value_35 = attev_1.getValue();
                        String _name_12 = ((MaxValueType) _value_35).getAttribute().getName();
                        _builder.append(_name_12);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        String _compileAuxiliarExpression_2 = this.compileAuxiliarExpression(expressionPosition_1, expressionList);
                        _builder.append(_compileAuxiliarExpression_2);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_30 = expressionList.get(indexExpression);
                        _builder.append(_get_30);
                        _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_36 = attev_1.getValue();
                        String _typeName_5 = MutatorUtils.getTypeName(((MaxValueType) _value_36));
                        _builder.append(_typeName_5);
                        _builder.append("\", sameValue, \"");
                        AttributeEvaluationType _value_37 = attev_1.getValue();
                        String _name_13 = ((MaxValueType) _value_37).getAttribute().getName();
                        _builder.append(_name_13);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_31 = expressionList.get(indexExpression);
                    _builder.append(_get_31);
                    _builder.append(".first).values.add(max");
                    Integer _get_32 = expressionList.get(indexExpression);
                    _builder.append(_get_32);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                    String _xblockexpression_3 = null;
                    {
                      evaluation[0] = true;
                      _xblockexpression_3 = "";
                    }
                    _builder.append(_xblockexpression_3);
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      if ((expressionPosition_1 == 0)) {
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_33 = expressionList.get(indexExpression);
                        _builder.append(_get_33);
                        _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, resources, \"");
                        AttributeEvaluationType _value_38 = attev_1.getValue();
                        String _typeName_6 = MutatorUtils.getTypeName(((MaxValueType) _value_38));
                        _builder.append(_typeName_6);
                        _builder.append("\", \"");
                        AttributeEvaluationType _value_39 = attev_1.getValue();
                        String _name_14 = ((MaxValueType) _value_39).getAttribute().getName();
                        _builder.append(_name_14);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        String _compileAuxiliarExpression_3 = this.compileAuxiliarExpression(expressionPosition_1, expressionList);
                        _builder.append(_compileAuxiliarExpression_3);
                        _builder.newLineIfNotEmpty();
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_34 = expressionList.get(indexExpression);
                        _builder.append(_get_34);
                        _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, model, \"");
                        AttributeEvaluationType _value_40 = attev_1.getValue();
                        String _typeName_7 = MutatorUtils.getTypeName(((MaxValueType) _value_40));
                        _builder.append(_typeName_7);
                        _builder.append("\", sameValue, \"");
                        AttributeEvaluationType _value_41 = attev_1.getValue();
                        String _name_15 = ((MaxValueType) _value_41).getAttribute().getName();
                        _builder.append(_name_15);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_4 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_4 = "";
                        }
                        _builder.append(_xblockexpression_4);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_35 = expressionList.get(indexExpression);
                    _builder.append(_get_35);
                    _builder.append(".first).values.add(max");
                    Integer _get_36 = expressionList.get(indexExpression);
                    _builder.append(_get_36);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_42 = attev_1.getValue();
                  boolean _equals_3 = ((MaxValueType) _value_42).getAttribute().getEType().getName().equals("EInt");
                  if (_equals_3) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_37 = expressionList.get(indexExpression);
                    _builder.append(_get_37);
                    _builder.append(".first).type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_43 = attev_1.getValue();
                  boolean _equals_4 = ((MaxValueType) _value_43).getAttribute().getEType().getName().equals("EFloat");
                  if (_equals_4) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_38 = expressionList.get(indexExpression);
                    _builder.append(_get_38);
                    _builder.append(".first).type = \"float\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_44 = attev_1.getValue();
                  boolean _equals_5 = ((MaxValueType) _value_44).getAttribute().getEType().getName().equals("EDouble");
                  if (_equals_5) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_39 = expressionList.get(indexExpression);
                    _builder.append(_get_39);
                    _builder.append(".first).type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                String _xblockexpression_5 = null;
                {
                  evaluation[0] = true;
                  _xblockexpression_5 = "";
                }
                _builder.append(_xblockexpression_5);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_45 = attev_1.getValue();
              if ((_value_45 instanceof ListStringType)) {
                _builder.append("//");
                AttributeEvaluationType _value_46 = attev_1.getValue();
                final ListStringType list = ((ListStringType) _value_46);
                _builder.newLineIfNotEmpty();
                {
                  EList<String> _value_47 = list.getValue();
                  for(final String item : _value_47) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_40 = expressionList.get(indexExpression);
                    _builder.append(_get_40);
                    _builder.append(".first).values.add(\"");
                    _builder.append(item);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_41 = expressionList.get(indexExpression);
                _builder.append(_get_41);
                _builder.append(".first).type = \"String\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_48 = attev_1.getValue();
              if ((_value_48 instanceof ListType)) {
                _builder.append("//");
                AttributeEvaluationType _value_49 = attev_1.getValue();
                final ListType list_1 = ((ListType) _value_49);
                _builder.newLineIfNotEmpty();
                {
                  EList<EObject> _value_50 = list_1.getValue();
                  for(final EObject item_1 : _value_50) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_42 = expressionList.get(indexExpression);
                    _builder.append(_get_42);
                    _builder.append(".first).values.add(\"");
                    _builder.append(item_1);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_43 = expressionList.get(indexExpression);
                _builder.append(_get_43);
                _builder.append(".first).type = \"String\";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    {
      Evaluation _first_5 = exp.getFirst();
      if ((_first_5 instanceof ReferenceEvaluation)) {
        _builder.append("exp");
        Integer _get_44 = expressionList.get(indexExpression);
        _builder.append(_get_44);
        _builder.append(".first = new ReferenceEvaluation();");
        _builder.newLineIfNotEmpty();
        _builder.append("//REFERENCE: ");
        Evaluation _first_6 = exp.getFirst();
        final ReferenceEvaluation refev = ((ReferenceEvaluation) _first_6);
        _builder.newLineIfNotEmpty();
        {
          EReference _name_16 = refev.getName();
          boolean _tripleNotEquals = (_name_16 != null);
          if (_tripleNotEquals) {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_45 = expressionList.get(indexExpression);
            _builder.append(_get_45);
            _builder.append(".first).name = \"");
            String _name_17 = refev.getName().getName();
            _builder.append(_name_17);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            {
              if (((refev.getValue() instanceof TypedSelection) && (recursionIndexExpression[0] != 0))) {
                _builder.append("refNames");
                Integer _get_46 = expressionList.get(recursionIndexExpression[0]);
                _builder.append(_get_46);
                _builder.append(".add(\"");
                String _name_18 = refev.getName().getName();
                _builder.append(_name_18);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_47 = expressionList.get(indexExpression);
            _builder.append(_get_47);
            _builder.append(".first).name = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_48 = expressionList.get(indexExpression);
            _builder.append(_get_48);
            _builder.append(".first).container = ");
            boolean _isContainer = refev.isContainer();
            _builder.append(_isContainer);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EReference _refName = refev.getRefName();
          boolean _tripleNotEquals_1 = (_refName != null);
          if (_tripleNotEquals_1) {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_49 = expressionList.get(indexExpression);
            _builder.append(_get_49);
            _builder.append(".first).refName = \"");
            String _name_19 = refev.getRefName().getName();
            _builder.append(_name_19);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            {
              EReference _refRefName = refev.getRefRefName();
              boolean _tripleNotEquals_2 = (_refRefName != null);
              if (_tripleNotEquals_2) {
                _builder.append("((ReferenceEvaluation) exp");
                Integer _get_50 = expressionList.get(indexExpression);
                _builder.append(_get_50);
                _builder.append(".first).refRefName = \"");
                String _name_20 = refev.getRefRefName().getName();
                _builder.append(_name_20);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("((ReferenceEvaluation) exp");
                Integer _get_51 = expressionList.get(indexExpression);
                _builder.append(_get_51);
                _builder.append(".first).refRefName = null;");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_52 = expressionList.get(indexExpression);
            _builder.append(_get_52);
            _builder.append(".first).refName = null;");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EAttribute _attName = refev.getAttName();
          boolean _tripleNotEquals_3 = (_attName != null);
          if (_tripleNotEquals_3) {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_53 = expressionList.get(indexExpression);
            _builder.append(_get_53);
            _builder.append(".first).attName = \"");
            String _name_21 = refev.getAttName().getName();
            _builder.append(_name_21);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_54 = expressionList.get(indexExpression);
            _builder.append(_get_54);
            _builder.append(".first).attName = null;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("((ReferenceEvaluation) exp");
        Integer _get_55 = expressionList.get(indexExpression);
        _builder.append(_get_55);
        _builder.append(".first).operator = \"");
        Operator _operator_2 = refev.getOperator();
        _builder.append(_operator_2);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        {
          ObSelectionStrategy _value_51 = refev.getValue();
          boolean _tripleEquals = (_value_51 == null);
          if (_tripleEquals) {
            {
              AttributeEvaluationType _attValue = refev.getAttValue();
              boolean _tripleEquals_1 = (_attValue == null);
              if (_tripleEquals_1) {
                _builder.append("((ReferenceEvaluation) exp");
                Integer _get_56 = expressionList.get(indexExpression);
                _builder.append(_get_56);
                _builder.append(".first).value = null;");
                _builder.newLineIfNotEmpty();
              } else {
                {
                  AttributeEvaluationType _attValue_1 = refev.getAttValue();
                  if ((_attValue_1 instanceof ObjectAttributeType)) {
                    _builder.append("((ReferenceEvaluation) exp");
                    Integer _get_57 = expressionList.get(indexExpression);
                    _builder.append(_get_57);
                    _builder.append(".first).value = ModelManager.getStringAttribute(\"");
                    AttributeEvaluationType _attValue_2 = refev.getAttValue();
                    String _name_22 = ((ObjectAttributeType) _attValue_2).getAttribute().getName();
                    _builder.append(_name_22);
                    _builder.append("\", (hmObjects.get(\"");
                    AttributeEvaluationType _attValue_3 = refev.getAttValue();
                    String _name_23 = ((ObjectAttributeType) _attValue_3).getObjSel().getName();
                    _builder.append(_name_23);
                    _builder.append("\") != null ? hmObjects.get(\"");
                    AttributeEvaluationType _attValue_4 = refev.getAttValue();
                    String _name_24 = ((ObjectAttributeType) _attValue_4).getObjSel().getName();
                    _builder.append(_name_24);
                    _builder.append("\").getKey() : null));");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _attValue_5 = refev.getAttValue();
                  if ((_attValue_5 instanceof AttributeType)) {
                    {
                      AttributeEvaluationType _attValue_6 = refev.getAttValue();
                      if ((_attValue_6 instanceof StringType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_58 = expressionList.get(indexExpression);
                        _builder.append(_get_58, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_7 = refev.getAttValue();
                        String _value_52 = ((SpecificStringType) _attValue_7).getValue();
                        _builder.append(_value_52, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_8 = refev.getAttValue();
                      if ((_attValue_8 instanceof DoubleType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_59 = expressionList.get(indexExpression);
                        _builder.append(_get_59, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_9 = refev.getAttValue();
                        double _value_53 = ((SpecificDoubleType) _attValue_9).getValue();
                        _builder.append(_value_53, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_10 = refev.getAttValue();
                      if ((_attValue_10 instanceof BooleanType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_60 = expressionList.get(indexExpression);
                        _builder.append(_get_60, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_11 = refev.getAttValue();
                        boolean _isValue_1 = ((SpecificBooleanType) _attValue_11).isValue();
                        _builder.append(_isValue_1, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_12 = refev.getAttValue();
                      if ((_attValue_12 instanceof IntegerType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_61 = expressionList.get(indexExpression);
                        _builder.append(_get_61, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_13 = refev.getAttValue();
                        int _value_54 = ((SpecificIntegerType) _attValue_13).getValue();
                        _builder.append(_value_54, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_14 = refev.getAttValue();
                      if ((_attValue_14 instanceof MinValueType)) {
                        {
                          if ((resources == false)) {
                            {
                              if ((indexExpression == 0)) {
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_62 = expressionList.get(indexExpression);
                                _builder.append(_get_62);
                                _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                                AttributeEvaluationType _attValue_15 = refev.getAttValue();
                                String _typeName_8 = MutatorUtils.getTypeName(((MinValueType) _attValue_15));
                                _builder.append(_typeName_8);
                                _builder.append("\", \"");
                                AttributeEvaluationType _attValue_16 = refev.getAttValue();
                                String _name_25 = ((MinValueType) _attValue_16).getAttribute().getName();
                                _builder.append(_name_25);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              } else {
                                String _compileAuxiliarExpression_4 = this.compileAuxiliarExpression(indexExpression, expressionList);
                                _builder.append(_compileAuxiliarExpression_4);
                                _builder.newLineIfNotEmpty();
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_63 = expressionList.get(indexExpression);
                                _builder.append(_get_63);
                                _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                                AttributeEvaluationType _attValue_17 = refev.getAttValue();
                                String _typeName_9 = MutatorUtils.getTypeName(((MinValueType) _attValue_17));
                                _builder.append(_typeName_9);
                                _builder.append("\", sameValue, \"");
                                AttributeEvaluationType _attValue_18 = refev.getAttValue();
                                String _name_26 = ((MinValueType) _attValue_18).getAttribute().getName();
                                _builder.append(_name_26);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("((ReferenceEvaluation) exp");
                            Integer _get_64 = expressionList.get(indexExpression);
                            _builder.append(_get_64, "\t");
                            _builder.append(".first).value = min");
                            Integer _get_65 = expressionList.get(indexExpression);
                            _builder.append(_get_65, "\t");
                            _builder.append(".getValue();");
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_6 = null;
                            {
                              evaluation[0] = true;
                              _xblockexpression_6 = "";
                            }
                            _builder.append(_xblockexpression_6);
                            _builder.newLineIfNotEmpty();
                          } else {
                            {
                              if ((indexExpression == 0)) {
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_66 = expressionList.get(indexExpression);
                                _builder.append(_get_66);
                                _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                                AttributeEvaluationType _attValue_19 = refev.getAttValue();
                                String _typeName_10 = MutatorUtils.getTypeName(((MinValueType) _attValue_19));
                                _builder.append(_typeName_10);
                                _builder.append("\", \"");
                                AttributeEvaluationType _attValue_20 = refev.getAttValue();
                                String _name_27 = ((MinValueType) _attValue_20).getAttribute().getName();
                                _builder.append(_name_27);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              } else {
                                String _compileAuxiliarExpression_5 = this.compileAuxiliarExpression(indexExpression, expressionList);
                                _builder.append(_compileAuxiliarExpression_5);
                                _builder.newLineIfNotEmpty();
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_67 = expressionList.get(indexExpression);
                                _builder.append(_get_67);
                                _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                                AttributeEvaluationType _attValue_21 = refev.getAttValue();
                                String _typeName_11 = MutatorUtils.getTypeName(((MinValueType) _attValue_21));
                                _builder.append(_typeName_11);
                                _builder.append("\", sameValue, \"");
                                AttributeEvaluationType _attValue_22 = refev.getAttValue();
                                String _name_28 = ((MinValueType) _attValue_22).getAttribute().getName();
                                _builder.append(_name_28);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("((ReferenceEvaluation) exp");
                            Integer _get_68 = expressionList.get(indexExpression);
                            _builder.append(_get_68, "\t");
                            _builder.append(".first).value = min");
                            Integer _get_69 = expressionList.get(indexExpression);
                            _builder.append(_get_69, "\t");
                            _builder.append(".getValue();");
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_7 = null;
                            {
                              evaluation[0] = true;
                              _xblockexpression_7 = "";
                            }
                            _builder.append(_xblockexpression_7);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_23 = refev.getAttValue();
                          if ((_attValue_23 instanceof MaxValueType)) {
                            _builder.append("//");
                            int expressionPosition_2 = 0;
                            _builder.newLineIfNotEmpty();
                            {
                              if ((resources == false)) {
                                {
                                  if ((expressionPosition_2 == 0)) {
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_70 = expressionList.get(indexExpression);
                                    _builder.append(_get_70);
                                    _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                                    AttributeEvaluationType _attValue_24 = refev.getAttValue();
                                    String _typeName_12 = MutatorUtils.getTypeName(((MaxValueType) _attValue_24));
                                    _builder.append(_typeName_12);
                                    _builder.append("\", \"");
                                    AttributeEvaluationType _attValue_25 = refev.getAttValue();
                                    String _name_29 = ((MaxValueType) _attValue_25).getAttribute().getName();
                                    _builder.append(_name_29);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    String _compileAuxiliarExpression_6 = this.compileAuxiliarExpression(expressionPosition_2, expressionList);
                                    _builder.append(_compileAuxiliarExpression_6);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_71 = expressionList.get(indexExpression);
                                    _builder.append(_get_71);
                                    _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                                    AttributeEvaluationType _attValue_26 = refev.getAttValue();
                                    String _typeName_13 = MutatorUtils.getTypeName(((MaxValueType) _attValue_26));
                                    _builder.append(_typeName_13);
                                    _builder.append("\", sameValue, \"");
                                    AttributeEvaluationType _attValue_27 = refev.getAttValue();
                                    String _name_30 = ((MaxValueType) _attValue_27).getAttribute().getName();
                                    _builder.append(_name_30);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("((ReferenceEvaluation) exp");
                                Integer _get_72 = expressionList.get(indexExpression);
                                _builder.append(_get_72, "\t");
                                _builder.append(".first).value = max");
                                Integer _get_73 = expressionList.get(indexExpression);
                                _builder.append(_get_73, "\t");
                                _builder.append(".getValue();");
                                _builder.newLineIfNotEmpty();
                                String _xblockexpression_8 = null;
                                {
                                  evaluation[0] = true;
                                  _xblockexpression_8 = "";
                                }
                                _builder.append(_xblockexpression_8);
                                _builder.newLineIfNotEmpty();
                              } else {
                                {
                                  if ((expressionPosition_2 == 0)) {
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_74 = expressionList.get(indexExpression);
                                    _builder.append(_get_74);
                                    _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, resources, \"");
                                    AttributeEvaluationType _attValue_28 = refev.getAttValue();
                                    String _typeName_14 = MutatorUtils.getTypeName(((MaxValueType) _attValue_28));
                                    _builder.append(_typeName_14);
                                    _builder.append("\", \"");
                                    AttributeEvaluationType _attValue_29 = refev.getAttValue();
                                    String _name_31 = ((MaxValueType) _attValue_29).getAttribute().getName();
                                    _builder.append(_name_31);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    String _compileAuxiliarExpression_7 = this.compileAuxiliarExpression(expressionPosition_2, expressionList);
                                    _builder.append(_compileAuxiliarExpression_7);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_75 = expressionList.get(indexExpression);
                                    _builder.append(_get_75);
                                    _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, model, \"");
                                    AttributeEvaluationType _attValue_30 = refev.getAttValue();
                                    String _typeName_15 = MutatorUtils.getTypeName(((MaxValueType) _attValue_30));
                                    _builder.append(_typeName_15);
                                    _builder.append("\", sameValue, \"");
                                    AttributeEvaluationType _attValue_31 = refev.getAttValue();
                                    String _name_32 = ((MaxValueType) _attValue_31).getAttribute().getName();
                                    _builder.append(_name_32);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("((ReferenceEvaluation) exp");
                                Integer _get_76 = expressionList.get(indexExpression);
                                _builder.append(_get_76, "\t");
                                _builder.append(".first).value = max");
                                Integer _get_77 = expressionList.get(indexExpression);
                                _builder.append(_get_77, "\t");
                                _builder.append(".getValue();");
                                _builder.newLineIfNotEmpty();
                                String _xblockexpression_9 = null;
                                {
                                  evaluation[0] = true;
                                  _xblockexpression_9 = "";
                                }
                                _builder.append(_xblockexpression_9);
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
          } else {
            ObSelectionStrategy _value_55 = refev.getValue();
            if ((_value_55 instanceof SpecificObjectSelection)) {
              {
                if (((refev.getRefType() == null) && (refev.getValue().getRefType() == null))) {
                  {
                    if (((((((mut instanceof ModifyInformationMutator) || (mut instanceof CreateObjectMutator)) || (mut instanceof SelectObjectMutator)) || (mut instanceof RemoveObjectMutator)) || (mut instanceof SelectSampleMutator)) || (mut instanceof CloneObjectMutator))) {
                      _builder.append("            ");
                      _builder.append("//");
                      boolean hasAdditionalResources = false;
                      _builder.newLineIfNotEmpty();
                      {
                        if ((mut instanceof ModifyInformationMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          ModifyInformationMutator modMut = ((ModifyInformationMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(modMut.getObject()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if ((mut instanceof CreateObjectMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          CreateObjectMutator crMut = ((CreateObjectMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(crMut.getContainer()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if ((mut instanceof SelectObjectMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          SelectObjectMutator selMut = ((SelectObjectMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(selMut.getObject()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if ((mut instanceof RemoveObjectMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          RemoveObjectMutator delMut = ((RemoveObjectMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(delMut.getObject()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if ((mut instanceof SelectSampleMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          SelectSampleMutator samMut = ((SelectSampleMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(samMut.getObject()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if ((mut instanceof CloneObjectMutator)) {
                          _builder.append("            ");
                          _builder.append("//");
                          CloneObjectMutator clnMut = ((CloneObjectMutator) mut);
                          _builder.newLineIfNotEmpty();
                          _builder.append("            ");
                          _builder.append("//");
                          _builder.append(hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(clnMut.getObject()), "            ");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        if (hasAdditionalResources) {
                          _builder.append("            ");
                          _builder.append("List<EObject> sameValue = new ArrayList<EObject>();");
                          _builder.newLine();
                          _builder.append("            ");
                          _builder.append("List<EObject> referenceValues = new ArrayList<EObject>();");
                          _builder.newLine();
                          _builder.append("   \t\t\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          Integer _get_78 = expressionList.get(indexExpression);
                          _builder.append(_get_78, "   \t\t\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_56 = refev.getValue();
                          String _name_33 = ((SpecificObjectSelection) _value_56).getObjSel().getName();
                          _builder.append(_name_33, "   \t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t");
                          _builder.append("if (entry_");
                          Integer _get_79 = expressionList.get(indexExpression);
                          _builder.append(_get_79, "   \t\t\t");
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.append("EObject localV1 =");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                    ");
                          _builder.append("MutatorUtils.recoverLocalObject(");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                        ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                        ");
                          _builder.append("entry_");
                          Integer _get_80 = expressionList.get(indexExpression);
                          _builder.append(_get_80, "   \t\t\t\t   \t\t\t\t                        ");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                ");
                          _builder.append("if (localV1 == null) {");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                    ");
                          _builder.append("localV1 =");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                        ");
                          _builder.append("ModelManager.getObject(");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                            ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t                            ");
                          _builder.append("entry_");
                          Integer _get_81 = expressionList.get(indexExpression);
                          _builder.append(_get_81, "   \t\t\t\t   \t\t\t\t                            ");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t   \t\t\t\t                ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t\t\t\t\t");
                          _builder.append("if (localV1 == null) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("   \t\t\t\t   \t\t\t\t\t\t\t\t\t");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("   \t\t\t\t   \t\t\t\t\t\t\t\t\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("   \t\t\t\t   \t\t\t\t\t\t\t\t\t");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("   \t\t\t\t   \t\t\t\t\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t");
                          _builder.append("for (EObject candidate : objects) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t ");
                          _builder.append("EStructuralFeature feature =");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("candidate.eClass()");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                 ");
                          _builder.append(".getEStructuralFeature(\"");
                          String _name_34 = refev.getName().getName();
                          _builder.append(_name_34, "\t\t\t\t                 ");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("if (!(feature instanceof EReference)) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("continue;");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("Object refValue =");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("candidate.eGet(feature);");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("if (!(refValue instanceof EObject)) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("continue;");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("EObject referencedValue =");
                          _builder.newLine();
                          _builder.append("\t\t\t\t            ");
                          _builder.append("(EObject) refValue;");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("EObject localRefValue =");
                          _builder.newLine();
                          _builder.append("\t\t\t\t            ");
                          _builder.append("MutatorUtils.recoverLocalObject(");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("referencedValue);");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("if (localRefValue == null) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t        ");
                          _builder.append("localRefValue =");
                          _builder.newLine();
                          _builder.append("\t\t\t\t            ");
                          _builder.append("ModelManager.getObject(");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("referencedValue);");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("if (localRefValue != null");
                          _builder.newLine();
                          _builder.append("\t\t\t\t            ");
                          _builder.append("&& EcoreUtil.equals(");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("localRefValue,");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                ");
                          _builder.append("localV1)) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t                \t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("if (!referenceValues.contains(referencedValue)) {");
                          _builder.newLine();
                          _builder.append("\t\t\t\t    ");
                          _builder.append("referenceValues.add(referencedValue);");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("sameValue.add(candidate);");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("if (sameValue.isEmpty()) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("    ");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("    ");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("    ");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.append("//EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                          Integer _get_82 = expressionList.get(indexExpression);
                          _builder.append(_get_82, "   \t\t\t\t");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("                ");
                          _builder.append("//((ReferenceEvaluation) exp");
                          Integer _get_83 = expressionList.get(indexExpression);
                          _builder.append(_get_83, "                ");
                          _builder.append(".first).value = sameValue;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("                ");
                          _builder.newLine();
                          _builder.append("\t                ");
                          _builder.append("/*");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("* Set the RHS of:");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("*");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("*     candidate.refValue = refValue");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("*");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("* using the current values returned by");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("* candidate.intent1 in the annotation ResourceSet.");
                          _builder.newLine();
                          _builder.append("                     ");
                          _builder.append("*/");
                          _builder.newLine();
                          _builder.append("                    ");
                          _builder.append("if (referenceValues.size() == 1) {");
                          _builder.newLine();
                          _builder.append("                ");
                          _builder.newLine();
                          _builder.append("                        ");
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_84 = expressionList.get(indexExpression);
                          _builder.append(_get_84, "                        ");
                          _builder.append(".first).value =");
                          _builder.newLineIfNotEmpty();
                          _builder.append("                            ");
                          _builder.append("referenceValues.get(0);");
                          _builder.newLine();
                          _builder.append("                ");
                          _builder.newLine();
                          _builder.append("                    ");
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("                ");
                          _builder.newLine();
                          _builder.append("                        ");
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_85 = expressionList.get(indexExpression);
                          _builder.append(_get_85, "                        ");
                          _builder.append(".first).value =");
                          _builder.newLineIfNotEmpty();
                          _builder.append("                            ");
                          _builder.append("referenceValues;");
                          _builder.newLine();
                          _builder.append("                    ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("//}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.newLine();
                          _builder.newLine();
                          _builder.append("   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("//((ReferenceEvaluation) exp");
                          Integer _get_86 = expressionList.get(indexExpression);
                          _builder.append(_get_86, "\t\t\t\t");
                          _builder.append(".first).value = new SpecificObjectSelection(packages, model, recovered).getObject();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t            ");
                          _builder.append("//}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t            ");
                          _builder.append("//break;");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t            ");
                          _builder.append("//}");
                          _builder.newLine();
                          _builder.append("   \t\t\t\t            ");
                          _builder.append("//}");
                          _builder.newLine();
                        }
                      }
                      {
                        if ((!hasAdditionalResources)) {
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          Integer _get_87 = expressionList.get(indexExpression);
                          _builder.append(_get_87);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_57 = refev.getValue();
                          String _name_35 = ((SpecificObjectSelection) _value_57).getObjSel().getName();
                          _builder.append(_name_35);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry_");
                          Integer _get_88 = expressionList.get(indexExpression);
                          _builder.append(_get_88);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.newLine();
                          _builder.append("\t                ");
                          _builder.append("EObject localValue =");
                          _builder.newLine();
                          _builder.append("\t                    ");
                          _builder.append("MutatorUtils.recoverLocalObject(");
                          _builder.newLine();
                          _builder.append("\t                        ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t                        ");
                          _builder.append("entry_");
                          Integer _get_89 = expressionList.get(indexExpression);
                          _builder.append(_get_89, "\t                        ");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.newLine();
                          _builder.append("\t                ");
                          _builder.append("if (localValue == null) {");
                          _builder.newLine();
                          _builder.append("\t                    ");
                          _builder.append("localValue =");
                          _builder.newLine();
                          _builder.append("\t                        ");
                          _builder.append("ModelManager.getObject(");
                          _builder.newLine();
                          _builder.append("\t                            ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t                            ");
                          _builder.append("entry_");
                          Integer _get_90 = expressionList.get(indexExpression);
                          _builder.append(_get_90, "\t                            ");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t                ");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t\t\t\t");
                          _builder.append("if (localValue == null) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t\t\t\t\t\t");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t\t\t\t\t\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t\t\t\t\t\t");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.newLine();
                          _builder.append("                ");
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_91 = expressionList.get(indexExpression);
                          _builder.append(_get_91, "                ");
                          _builder.append(".first).value = localValue;");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("else {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                  Integer _get_92 = expressionList.get(indexExpression);
                  _builder.append(_get_92, "\t");
                  _builder.append(" = hmList.get(\"");
                  ObSelectionStrategy _value_58 = refev.getValue();
                  String _name_36 = ((SpecificObjectSelection) _value_58).getObjSel().getName();
                  _builder.append(_name_36, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("if (listEntry_");
                  Integer _get_93 = expressionList.get(indexExpression);
                  _builder.append(_get_93, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                  Integer _get_94 = expressionList.get(indexExpression);
                  _builder.append(_get_94, "\t");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  {
                    if ((resources == false)) {
                      _builder.append("\t");
                      _builder.append("EObject obj = MutatorUtils.recoverLocalObject(model, ent.getKey());");
                      _builder.newLine();
                    } else {
                      _builder.append("\t");
                      _builder.append("EObject obj = MutatorUtils.recoverLocalObject(selection, ent.getKey());");
                      _builder.newLine();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("if (obj == null) {");
                  _builder.newLine();
                  {
                    if ((resources == false)) {
                      _builder.append("\t");
                      _builder.append("obj = ModelManager.getObject(model, ent.getKey());");
                      _builder.newLine();
                    } else {
                      _builder.append("\t");
                      _builder.append("obj = ModelManager.getObject(selection, ent.getKey());");
                      _builder.newLine();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("if (obj != null) {");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("objs.add(obj);");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("((ReferenceEvaluation) exp");
                  Integer _get_95 = expressionList.get(indexExpression);
                  _builder.append(_get_95, "\t");
                  _builder.append(".first).value = objs;");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("else {");
                  _builder.newLine();
                  {
                    if ((insideLoop == false)) {
                      {
                        if ((exhaustive == true)) {
                          _builder.append("   \t\t\t\t\t\t\t\t\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                        } else {
                          _builder.append("   \t\t\t\t\t\t\t\t\t");
                          _builder.append("return mutations;");
                          _builder.newLine();
                        }
                      }
                    } else {
                      _builder.append("   \t\t\t\t\t\t\t\t\t");
                      _builder.append("continue;");
                      _builder.newLine();
                    }
                  }
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  {
                    EReference _refType = refev.getRefType();
                    boolean _tripleNotEquals_4 = (_refType != null);
                    if (_tripleNotEquals_4) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      Integer _get_96 = expressionList.get(indexExpression);
                      _builder.append(_get_96);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_59 = refev.getValue();
                      String _name_37 = ((SpecificObjectSelection) _value_59).getObjSel().getName();
                      _builder.append(_name_37);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry_");
                      Integer _get_97 = expressionList.get(indexExpression);
                      _builder.append(_get_97);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.append("EObject srcObjExp =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t        ");
                      _builder.append("entry_");
                      Integer _get_98 = expressionList.get(indexExpression);
                      _builder.append(_get_98, "   \t\t\t\t        ");
                      _builder.append(".getKey();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.append("EStructuralFeature feature =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t    ");
                      _builder.append("srcObjExp.eClass()");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t               ");
                      _builder.append(".getEStructuralFeature(");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                   ");
                      _builder.append("\"");
                      String _name_38 = refev.getRefType().getName();
                      _builder.append(_name_38, "   \t\t\t\t                   ");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t                   ");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                   ");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("if (!(feature instanceof EReference)) {");
                      _builder.newLine();
                      {
                        if ((insideLoop == false)) {
                          {
                            if ((exhaustive == true)) {
                              _builder.append("   \t\t\t    ");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                            } else {
                              _builder.append("   \t\t\t    ");
                              _builder.append("return mutations;");
                              _builder.newLine();
                            }
                          }
                        } else {
                          _builder.append("   \t\t\t    ");
                          _builder.append("continue;");
                          _builder.newLine();
                        }
                      }
                      _builder.append("   \t\t\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("Object value =");
                      _builder.newLine();
                      _builder.append("   \t\t\t    ");
                      _builder.append("srcObjExp.eGet(feature);");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("if (!(value instanceof EObject)) {");
                      _builder.newLine();
                      {
                        if ((insideLoop == false)) {
                          {
                            if ((exhaustive == true)) {
                              _builder.append("   \t\t\t    ");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                            } else {
                              _builder.append("   \t\t\t    ");
                              _builder.append("return mutations;");
                              _builder.newLine();
                            }
                          }
                        } else {
                          _builder.append("   \t\t\t    ");
                          _builder.append("continue;");
                          _builder.newLine();
                        }
                      }
                      _builder.append("   \t\t\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("EObject external =");
                      _builder.newLine();
                      _builder.append("   \t\t\t    ");
                      _builder.append("(EObject) value;");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("EObject external2Local =");
                      _builder.newLine();
                      _builder.append("   \t\t\t    ");
                      _builder.append("MutatorUtils.recoverLocalObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t        ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t        ");
                      _builder.append("external);");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("if (external2Local == null) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t    ");
                      _builder.append("external2Local =");
                      _builder.newLine();
                      _builder.append("   \t\t\t        ");
                      _builder.append("ModelManager.getObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t            ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t            ");
                      _builder.append("external);");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t");
                      _builder.append("if (external2Local == null) {");
                      _builder.newLine();
                      {
                        if ((insideLoop == false)) {
                          {
                            if ((exhaustive == true)) {
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                            } else {
                              _builder.append("return mutations;");
                              _builder.newLine();
                            }
                          }
                        } else {
                          _builder.append("continue;");
                          _builder.newLine();
                        }
                      }
                      _builder.append("   \t\t\t       \t\t\t\t\t\t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t       \t\t\t\t");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t ");
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_99 = expressionList.get(indexExpression);
                      _builder.append(_get_99, "   \t\t\t ");
                      _builder.append(".first).value = external2Local;      \t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t      ");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                  {
                    EReference _refType_1 = refev.getValue().getRefType();
                    boolean _tripleNotEquals_5 = (_refType_1 != null);
                    if (_tripleNotEquals_5) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      Integer _get_100 = expressionList.get(indexExpression);
                      _builder.append(_get_100);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_60 = refev.getValue();
                      String _name_39 = ((SpecificObjectSelection) _value_60).getObjSel().getName();
                      _builder.append(_name_39);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry_");
                      Integer _get_101 = expressionList.get(indexExpression);
                      _builder.append(_get_101);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.append("EObject srcObjExp =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t        ");
                      _builder.append("entry_");
                      Integer _get_102 = expressionList.get(indexExpression);
                      _builder.append(_get_102, "   \t\t\t\t        ");
                      _builder.append(".getKey();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.append("EStructuralFeature feature =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t    ");
                      _builder.append("srcObjExp.eClass()");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t             ");
                      _builder.append(".getEStructuralFeature(\"");
                      String _name_40 = refev.getValue().getRefType().getName();
                      _builder.append(_name_40, "   \t\t\t\t             ");
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t");
                      _builder.append("if (feature != null) {");
                      _builder.newLine();
                      _builder.append("\t\t   \t\t\t\t\t\t");
                      _builder.append("Object value =  srcObjExp.eGet(feature);");
                      _builder.newLine();
                      _builder.append("                ");
                      _builder.append("if (value instanceof EObject) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                ");
                      _builder.append("EObject referenced =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                    ");
                      _builder.append("(EObject) value;");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                ");
                      _builder.append("EObject localValue =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                    ");
                      _builder.append("MutatorUtils.recoverLocalObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                        ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                        ");
                      _builder.append("referenced);");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                ");
                      _builder.append("if (localValue == null) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                    ");
                      _builder.append("localValue =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                        ");
                      _builder.append("ModelManager.getObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                            ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                            ");
                      _builder.append("referenced);");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t                ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.append("//EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                      Integer _get_103 = expressionList.get(indexExpression);
                      _builder.append(_get_103, "   \t\t\t\t");
                      _builder.append(".getKey());");
                      _builder.newLineIfNotEmpty();
                      _builder.append("                ");
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_104 = expressionList.get(indexExpression);
                      _builder.append(_get_104, "                ");
                      _builder.append(".first).value =");
                      _builder.newLineIfNotEmpty();
                      _builder.append("                    ");
                      _builder.append("localValue != null");
                      _builder.newLine();
                      _builder.append("                    ");
                      _builder.append("? localValue");
                      _builder.newLine();
                      _builder.append("                    ");
                      _builder.append(": referenced;");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t");
                      _builder.newLine();
                      _builder.append("\t\t\t\t");
                      _builder.append("//((ReferenceEvaluation) exp");
                      Integer _get_105 = expressionList.get(indexExpression);
                      _builder.append(_get_105, "\t\t\t\t");
                      _builder.append(".first).value = new SpecificObjectSelection(packages, model, recovered).getObject();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t            ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            ");
                      _builder.append("if (value instanceof List<?>) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.append("List<EObject> localValues =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("new ArrayList<EObject>();");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t        ");
                      _builder.append("for (Object element :");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("(List<?>) value) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("if (!(element instanceof EObject)) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("continue;");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("EObject referenced =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("(EObject) element;");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("EObject localValue =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("MutatorUtils.recoverLocalObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                    ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                    ");
                      _builder.append("referenced);");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("if (localValue == null) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("localValue =");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                    ");
                      _builder.append("ModelManager.getObject(");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                        ");
                      _builder.append("model,");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                        ");
                      _builder.append("referenced);");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("if (localValue != null) {");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t                ");
                      _builder.append("localValues.add(localValue);");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t        ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t        ");
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_106 = expressionList.get(indexExpression);
                      _builder.append(_get_106, "   \t\t\t\t            \t   \t\t   \t\t\t\t            \t        ");
                      _builder.append(".first).value =");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            \t            ");
                      _builder.append("localValues;");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t            \t   \t\t   \t\t\t\t            ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t           ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("   \t\t\t\t           ");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            } else {
              {
                ObSelectionStrategy _value_61 = refev.getValue();
                if ((_value_61 instanceof RandomTypeSelection)) {
                  {
                    Expression _expression = refev.getValue().getExpression();
                    if ((_expression instanceof Expression)) {
                      _builder.append("//EXPRESSION LEVEL: ");
                      int _get_107 = nExpression[0];
                      int _plus = (_get_107 + 1);
                      int _set = nExpression[0] = _plus;
                      _builder.append(_set);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//EXPRESSION LEVEL: ");
                      boolean _add = expressionList.add(Integer.valueOf(nExpression[0]));
                      _builder.append(_add);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//INDEX EXPRESSION: ");
                      final int[] nestedIndexExpression = new int[1];
                      _builder.newLineIfNotEmpty();
                      _builder.append("//INDEX EXPRESSION: ");
                      int _size_1 = expressionList.size();
                      int _minus = (_size_1 - 1);
                      int _set_1 = nestedIndexExpression[0] = _minus;
                      _builder.append(_set_1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("RandomTypeSelection expRts");
                      Integer _get_108 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_108);
                      _builder.append(" = new RandomTypeSelection(packages, model, \"");
                      ObSelectionStrategy _value_62 = refev.getValue();
                      String _name_41 = ((RandomTypeSelection) _value_62).getType().getName();
                      _builder.append(_name_41);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("List<EObject> expObjects");
                      Integer _get_109 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_109);
                      _builder.append(" = expRts");
                      Integer _get_110 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_110);
                      _builder.append(".getObjects();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("Expression exp");
                      Integer _get_111 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_111);
                      _builder.append(" = new Expression();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t   \t\t");
                      Object _method = this.method(refev.getValue().getExpression(), mut, nReference, ((List<Integer>)Conversions.doWrapArray(nestedIndexExpression)), nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
                      _builder.append(_method, "\t   \t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("List<EObject> selectedObjects");
                      Integer _get_112 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_112);
                      _builder.append(" = evaluate(expObjects");
                      Integer _get_113 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_113);
                      _builder.append(", exp");
                      Integer _get_114 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_114);
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("EObject object");
                      Integer _get_115 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_115);
                      _builder.append(" = null;");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (selectedObjects");
                      Integer _get_116 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_116);
                      _builder.append(".size() > 0) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("object");
                      Integer _get_117 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_117, "\t");
                      _builder.append(" = selectedObjects");
                      Integer _get_118 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_118, "\t");
                      _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                      Integer _get_119 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_119, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_120 = expressionList.get(indexExpression);
                      _builder.append(_get_120);
                      _builder.append(".first).value = new SpecificObjectSelection(packages, model, object");
                      Integer _get_121 = expressionList.get(nestedIndexExpression[0]);
                      _builder.append(_get_121);
                      _builder.append(").getObject();");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_122 = expressionList.get(indexExpression);
                      _builder.append(_get_122);
                      _builder.append(".first).value = new RandomTypeSelection(packages, model, \"");
                      ObSelectionStrategy _value_63 = refev.getValue();
                      String _name_42 = ((RandomTypeSelection) _value_63).getType().getName();
                      _builder.append(_name_42);
                      _builder.append("\").getObject();");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  {
                    ObSelectionStrategy _value_64 = refev.getValue();
                    if ((_value_64 instanceof TypedSelection)) {
                      {
                        Expression _expression_1 = refev.getValue().getExpression();
                        if ((_expression_1 instanceof Expression)) {
                          _builder.append("//EXPRESSION LEVEL: ");
                          int _get_123 = nExpression[0];
                          int _plus_1 = (_get_123 + 1);
                          int _set_2 = nExpression[0] = _plus_1;
                          _builder.append(_set_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//EXPRESSION LEVEL: ");
                          boolean _add_1 = expressionList.add(Integer.valueOf(nExpression[0]));
                          _builder.append(_add_1);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          final int[] nestedIndexExpression_1 = new int[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          int _size_2 = expressionList.size();
                          int _minus_1 = (_size_2 - 1);
                          int _set_3 = nestedIndexExpression_1[0] = _minus_1;
                          _builder.append(_set_3);
                          _builder.newLineIfNotEmpty();
                          _builder.append("TypedSelection expRts");
                          Integer _get_124 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_124);
                          _builder.append(" = new TypedSelection(packages, model, \"");
                          ObSelectionStrategy _value_65 = refev.getValue();
                          String _name_43 = ((TypedSelection) _value_65).getType().getName();
                          _builder.append(_name_43);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> expObjects");
                          Integer _get_125 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_125);
                          _builder.append(" = expRts");
                          Integer _get_126 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_126);
                          _builder.append(".getObjects();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Expression exp");
                          Integer _get_127 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_127);
                          _builder.append(" = new Expression();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<String> refNames");
                          Integer _get_128 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_128);
                          _builder.append(" = new ArrayList<String>();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t");
                          Object _method_1 = this.method(refev.getValue().getExpression(), mut, nReference, ((List<Integer>)Conversions.doWrapArray(nestedIndexExpression_1)), nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
                          _builder.append(_method_1, "\t   \t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> selectedObjects");
                          Integer _get_129 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_129);
                          _builder.append(" = evaluate(expObjects");
                          Integer _get_130 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_130);
                          _builder.append(", exp");
                          Integer _get_131 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_131);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("refNames");
                          Integer _get_132 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_132);
                          _builder.append(".add(\"");
                          String _name_44 = refev.getName().getName();
                          _builder.append(_name_44);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Collections.reverse(refNames");
                          Integer _get_133 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_133);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("selectedObjects");
                          Integer _get_134 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_134);
                          _builder.append(" = ModelManager.getReferredObjects(refNames");
                          Integer _get_135 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_135);
                          _builder.append(", objects, selectedObjects1);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject object");
                          Integer _get_136 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_136);
                          _builder.append(" = null;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (selectedObjects");
                          Integer _get_137 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_137);
                          _builder.append(".size() > 0) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("object");
                          Integer _get_138 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_138, "\t");
                          _builder.append(" = selectedObjects");
                          Integer _get_139 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_139, "\t");
                          _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                          Integer _get_140 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_140, "\t");
                          _builder.append("));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_141 = expressionList.get(indexExpression);
                          _builder.append(_get_141);
                          _builder.append(".first).value = new SpecificObjectSelection(packages, model, object");
                          Integer _get_142 = expressionList.get(nestedIndexExpression_1[0]);
                          _builder.append(_get_142);
                          _builder.append(").getObject();");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_143 = expressionList.get(indexExpression);
                          _builder.append(_get_143);
                          _builder.append(".first).value = new TypedSelection(packages, model, \"");
                          ObSelectionStrategy _value_66 = refev.getValue();
                          String _name_45 = ((TypedSelection) _value_66).getType().getName();
                          _builder.append(_name_45);
                          _builder.append("\").getObject();");
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
    }
    _builder.append("exp");
    Integer _get_144 = expressionList.get(indexExpression);
    _builder.append(_get_144);
    _builder.append(".operator = new ArrayList<Operator>();");
    _builder.newLineIfNotEmpty();
    _builder.append("//OPNAME: ");
    int opName = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<BinaryOperator> _operator_3 = exp.getOperator();
      for(final BinaryOperator op : _operator_3) {
        _builder.append("Operator op");
        _builder.append(opName);
        _builder.append("_");
        Integer _get_145 = expressionList.get(indexExpression);
        _builder.append(_get_145);
        _builder.append(" = new Operator();");
        _builder.newLineIfNotEmpty();
        _builder.append("op");
        _builder.append(opName);
        _builder.append("_");
        Integer _get_146 = expressionList.get(indexExpression);
        _builder.append(_get_146);
        _builder.append(".type = \"");
        LogicOperator _type = op.getType();
        _builder.append(_type);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("exp");
        Integer _get_147 = expressionList.get(indexExpression);
        _builder.append(_get_147);
        _builder.append(".operator.add(op");
        _builder.append(opName);
        _builder.append("_");
        Integer _get_148 = expressionList.get(indexExpression);
        _builder.append(_get_148);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("//OPNAME + 1: ");
        _builder.append(opName = (opName + 1));
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("exp");
    Integer _get_149 = expressionList.get(indexExpression);
    _builder.append(_get_149);
    _builder.append(".second = new ArrayList<Evaluation>();");
    _builder.newLineIfNotEmpty();
    _builder.append("//EVNAME: ");
    int evName = 0;
    _builder.newLineIfNotEmpty();
    _builder.append("//EVCOUNTER: ");
    int expressionPosition_3 = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<Evaluation> _second = exp.getSecond();
      for(final Evaluation ev : _second) {
        _builder.append("   \t\t");
        _builder.append("//");
        int _plusPlus = expressionPosition_3++;
        _builder.append(_plusPlus, "   \t\t");
        _builder.newLineIfNotEmpty();
        {
          if ((ev instanceof AttributeEvaluation)) {
            {
              AttributeEvaluationType _value_67 = ((AttributeEvaluation) ev).getValue();
              if ((_value_67 instanceof ObjectAttributeType)) {
                _builder.append("AttributeEvaluation ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_150 = expressionList.get(indexExpression);
                _builder.append(_get_150);
                _builder.append(" = new AttributeEvaluation();");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_151 = expressionList.get(indexExpression);
                _builder.append(_get_151);
                _builder.append(".name = \"");
                String _name_46 = ((AttributeEvaluation)ev).getName().getName();
                _builder.append(_name_46);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_152 = expressionList.get(indexExpression);
                _builder.append(_get_152);
                _builder.append(".operator = \"");
                AttributeEvaluationType _value_68 = ((AttributeEvaluation)ev).getValue();
                Operator _operator_4 = ((ObjectAttributeType) _value_68).getOperator();
                _builder.append(_operator_4);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_153 = expressionList.get(indexExpression);
                _builder.append(_get_153);
                _builder.append(".values = new ArrayList<Object>();");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_69 = ((AttributeEvaluation) ev).getValue();
              if ((_value_69 instanceof AttributeType)) {
                _builder.append("AttributeEvaluation ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_154 = expressionList.get(indexExpression);
                _builder.append(_get_154);
                _builder.append(" = new AttributeEvaluation();");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_155 = expressionList.get(indexExpression);
                _builder.append(_get_155);
                _builder.append(".name = \"");
                String _name_47 = ((AttributeEvaluation)ev).getName().getName();
                _builder.append(_name_47);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_156 = expressionList.get(indexExpression);
                _builder.append(_get_156);
                _builder.append(".operator = \"");
                AttributeEvaluationType _value_70 = ((AttributeEvaluation)ev).getValue();
                Operator _operator_5 = ((AttributeType) _value_70).getOperator();
                _builder.append(_operator_5);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_157 = expressionList.get(indexExpression);
                _builder.append(_get_157);
                _builder.append(".values = new ArrayList<Object>();");
                _builder.newLineIfNotEmpty();
                {
                  AttributeEvaluationType _value_71 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_71 instanceof StringType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_158 = expressionList.get(indexExpression);
                    _builder.append(_get_158);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_72 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_6 = ((SpecificStringType) _value_72).getOperator();
                    _builder.append(_operator_6);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_159 = expressionList.get(indexExpression);
                    _builder.append(_get_159);
                    _builder.append(".values.add(\"");
                    AttributeEvaluationType _value_73 = ((AttributeEvaluation)ev).getValue();
                    String _value_74 = ((SpecificStringType) _value_73).getValue();
                    _builder.append(_value_74);
                    _builder.append("\");;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_160 = expressionList.get(indexExpression);
                    _builder.append(_get_160);
                    _builder.append(".type = \"String\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_75 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_75 instanceof DoubleType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_161 = expressionList.get(indexExpression);
                    _builder.append(_get_161);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_76 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_7 = ((SpecificDoubleType) _value_76).getOperator();
                    _builder.append(_operator_7);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_162 = expressionList.get(indexExpression);
                    _builder.append(_get_162);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_77 = ((AttributeEvaluation)ev).getValue();
                    double _value_78 = ((SpecificDoubleType) _value_77).getValue();
                    _builder.append(_value_78);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_163 = expressionList.get(indexExpression);
                    _builder.append(_get_163);
                    _builder.append(".type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_79 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_79 instanceof BooleanType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_164 = expressionList.get(indexExpression);
                    _builder.append(_get_164);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_80 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_8 = ((SpecificBooleanType) _value_80).getOperator();
                    _builder.append(_operator_8);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_165 = expressionList.get(indexExpression);
                    _builder.append(_get_165);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_81 = ((AttributeEvaluation)ev).getValue();
                    boolean _isValue_2 = ((SpecificBooleanType) _value_81).isValue();
                    _builder.append(_isValue_2);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_166 = expressionList.get(indexExpression);
                    _builder.append(_get_166);
                    _builder.append(".type = \"Boolean\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_82 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_82 instanceof IntegerType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_167 = expressionList.get(indexExpression);
                    _builder.append(_get_167);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_83 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_9 = ((SpecificIntegerType) _value_83).getOperator();
                    _builder.append(_operator_9);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_168 = expressionList.get(indexExpression);
                    _builder.append(_get_168);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_84 = ((AttributeEvaluation)ev).getValue();
                    int _value_85 = ((SpecificIntegerType) _value_84).getValue();
                    _builder.append(_value_85);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_169 = expressionList.get(indexExpression);
                    _builder.append(_get_169);
                    _builder.append(".type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_86 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_86 instanceof MinValueType)) {
                    {
                      if ((exhaustive == false)) {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_170 = expressionList.get(indexExpression);
                            _builder.append(_get_170);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_87 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_16 = MutatorUtils.getTypeName(((MinValueType) _value_87));
                            _builder.append(_typeName_16);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_88 = ((AttributeEvaluation)ev).getValue();
                            String _name_48 = ((MinValueType) _value_88).getAttribute().getName();
                            _builder.append(_name_48);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_8 = this.compileAuxiliarExpression(expressionPosition_3, expressionList);
                            _builder.append(_compileAuxiliarExpression_8);
                            _builder.newLineIfNotEmpty();
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_171 = expressionList.get(indexExpression);
                            _builder.append(_get_171);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_89 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_17 = MutatorUtils.getTypeName(((MinValueType) _value_89));
                            _builder.append(_typeName_17);
                            _builder.append("\", sameValue, \"");
                            AttributeEvaluationType _value_90 = ((AttributeEvaluation)ev).getValue();
                            String _name_49 = ((MinValueType) _value_90).getAttribute().getName();
                            _builder.append(_name_49);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_172 = expressionList.get(indexExpression);
                        _builder.append(_get_172);
                        _builder.append(").values.add(min");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_173 = expressionList.get(indexExpression);
                        _builder.append(_get_173);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_10 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_10 = "";
                        }
                        _builder.append(_xblockexpression_10);
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_174 = expressionList.get(indexExpression);
                            _builder.append(_get_174);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_91 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_18 = MutatorUtils.getTypeName(((MinValueType) _value_91));
                            _builder.append(_typeName_18);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_92 = ((AttributeEvaluation)ev).getValue();
                            String _name_50 = ((MinValueType) _value_92).getAttribute().getName();
                            _builder.append(_name_50);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_9 = this.compileAuxiliarExpression(expressionPosition_3, expressionList);
                            _builder.append(_compileAuxiliarExpression_9);
                            _builder.newLineIfNotEmpty();
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_175 = expressionList.get(indexExpression);
                            _builder.append(_get_175);
                            _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                            AttributeEvaluationType _value_93 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_19 = MutatorUtils.getTypeName(((MinValueType) _value_93));
                            _builder.append(_typeName_19);
                            _builder.append("\", sameValue, \"");
                            AttributeEvaluationType _value_94 = ((AttributeEvaluation)ev).getValue();
                            String _name_51 = ((MinValueType) _value_94).getAttribute().getName();
                            _builder.append(_name_51);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_176 = expressionList.get(indexExpression);
                        _builder.append(_get_176);
                        _builder.append(").values.add(min");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_177 = expressionList.get(indexExpression);
                        _builder.append(_get_177);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_11 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_11 = "";
                        }
                        _builder.append(_xblockexpression_11);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_95 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_6 = ((MinValueType) _value_95).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_6) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_178 = expressionList.get(indexExpression);
                        _builder.append(_get_178);
                        _builder.append(").type = \"int\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_12 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_12 = "";
                        }
                        _builder.append(_xblockexpression_12);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_96 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_7 = ((MinValueType) _value_96).getAttribute().getEType().getName().equals("EFloat");
                      if (_equals_7) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_179 = expressionList.get(indexExpression);
                        _builder.append(_get_179);
                        _builder.append(").type = \"float\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_13 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_13 = "";
                        }
                        _builder.append(_xblockexpression_13);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_97 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_8 = ((MinValueType) _value_97).getAttribute().getEType().getName().equals("EDouble");
                      if (_equals_8) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_180 = expressionList.get(indexExpression);
                        _builder.append(_get_180);
                        _builder.append(").type = \"double\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_14 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_14 = "";
                        }
                        _builder.append(_xblockexpression_14);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  AttributeEvaluationType _value_98 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_98 instanceof MaxValueType)) {
                    {
                      if ((exhaustive == false)) {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_181 = expressionList.get(indexExpression);
                            _builder.append(_get_181);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_99 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_20 = MutatorUtils.getTypeName(((MaxValueType) _value_99));
                            _builder.append(_typeName_20);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_100 = ((AttributeEvaluation)ev).getValue();
                            String _name_52 = ((MaxValueType) _value_100).getAttribute().getName();
                            _builder.append(_name_52);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_10 = this.compileAuxiliarExpression(expressionPosition_3, expressionList);
                            _builder.append(_compileAuxiliarExpression_10);
                            _builder.newLineIfNotEmpty();
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_182 = expressionList.get(indexExpression);
                            _builder.append(_get_182);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_101 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_21 = MutatorUtils.getTypeName(((MaxValueType) _value_101));
                            _builder.append(_typeName_21);
                            _builder.append("\", sameValue, \"");
                            AttributeEvaluationType _value_102 = ((AttributeEvaluation)ev).getValue();
                            String _name_53 = ((MaxValueType) _value_102).getAttribute().getName();
                            _builder.append(_name_53);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_183 = expressionList.get(indexExpression);
                        _builder.append(_get_183);
                        _builder.append(").values.add(max");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_184 = expressionList.get(indexExpression);
                        _builder.append(_get_184);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_15 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_15 = "";
                        }
                        _builder.append(_xblockexpression_15);
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_185 = expressionList.get(indexExpression);
                            _builder.append(_get_185);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_103 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_22 = MutatorUtils.getTypeName(((MaxValueType) _value_103));
                            _builder.append(_typeName_22);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_104 = ((AttributeEvaluation)ev).getValue();
                            String _name_54 = ((MaxValueType) _value_104).getAttribute().getName();
                            _builder.append(_name_54);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_11 = this.compileAuxiliarExpression(expressionPosition_3, expressionList);
                            _builder.append(_compileAuxiliarExpression_11);
                            _builder.newLineIfNotEmpty();
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_186 = expressionList.get(indexExpression);
                            _builder.append(_get_186);
                            _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, resources, \"");
                            AttributeEvaluationType _value_105 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_23 = MutatorUtils.getTypeName(((MaxValueType) _value_105));
                            _builder.append(_typeName_23);
                            _builder.append("\", sameValue, \"");
                            AttributeEvaluationType _value_106 = ((AttributeEvaluation)ev).getValue();
                            String _name_55 = ((MaxValueType) _value_106).getAttribute().getName();
                            _builder.append(_name_55);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_187 = expressionList.get(indexExpression);
                        _builder.append(_get_187);
                        _builder.append(").values.add(max");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_188 = expressionList.get(indexExpression);
                        _builder.append(_get_188);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_16 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_16 = "";
                        }
                        _builder.append(_xblockexpression_16);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_107 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_9 = ((MaxValueType) _value_107).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_9) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_189 = expressionList.get(indexExpression);
                        _builder.append(_get_189);
                        _builder.append(").type = \"int\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_17 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_17 = "";
                        }
                        _builder.append(_xblockexpression_17);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_108 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_10 = ((MaxValueType) _value_108).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_10) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_190 = expressionList.get(indexExpression);
                        _builder.append(_get_190);
                        _builder.append(").type = \"float\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_18 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_18 = "";
                        }
                        _builder.append(_xblockexpression_18);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_109 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_11 = ((MaxValueType) _value_109).getAttribute().getEType().getName().equals("EDouble");
                      if (_equals_11) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_191 = expressionList.get(indexExpression);
                        _builder.append(_get_191);
                        _builder.append(").type = \"double\";");
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_19 = null;
                        {
                          evaluation[0] = true;
                          _xblockexpression_19 = "";
                        }
                        _builder.append(_xblockexpression_19);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        {
          if ((ev instanceof ReferenceEvaluation)) {
            _builder.append("   \t\t\t");
            _builder.append("ReferenceEvaluation ev");
            _builder.append(evName, "   \t\t\t");
            _builder.append("_");
            Integer _get_192 = expressionList.get(indexExpression);
            _builder.append(_get_192, "   \t\t\t");
            _builder.append(" = new ReferenceEvaluation();");
            _builder.newLineIfNotEmpty();
            {
              EReference _name_56 = ((ReferenceEvaluation)ev).getName();
              boolean _tripleNotEquals_6 = (_name_56 != null);
              if (_tripleNotEquals_6) {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_193 = expressionList.get(indexExpression);
                _builder.append(_get_193);
                _builder.append(".name = \"");
                String _name_57 = ((ReferenceEvaluation)ev).getName().getName();
                _builder.append(_name_57);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                {
                  if (((((ReferenceEvaluation)ev).getValue() instanceof TypedSelection) && (recursionIndexExpression[0] != 0))) {
                    _builder.append("\t\t\t\t");
                    _builder.append("refNames");
                    Integer _get_194 = expressionList.get(recursionIndexExpression[0]);
                    _builder.append(_get_194, "\t\t\t\t");
                    _builder.append(".add(\"");
                    String _name_58 = ((ReferenceEvaluation)ev).getName().getName();
                    _builder.append(_name_58, "\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_195 = expressionList.get(indexExpression);
                _builder.append(_get_195, "\t   \t\t");
                _builder.append(".name = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_196 = expressionList.get(indexExpression);
                _builder.append(_get_196, "\t   \t\t");
                _builder.append(".container = ");
                boolean _isContainer_1 = ((ReferenceEvaluation)ev).isContainer();
                _builder.append(_isContainer_1, "\t   \t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EReference _refName_1 = ((ReferenceEvaluation)ev).getRefName();
              boolean _tripleNotEquals_7 = (_refName_1 != null);
              if (_tripleNotEquals_7) {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_197 = expressionList.get(indexExpression);
                _builder.append(_get_197);
                _builder.append(".refName = \"");
                String _name_59 = ((ReferenceEvaluation)ev).getRefName().getName();
                _builder.append(_name_59);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_198 = expressionList.get(indexExpression);
                _builder.append(_get_198, "\t   \t\t");
                _builder.append(".refName = null;");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EAttribute _attName_1 = ((ReferenceEvaluation)ev).getAttName();
              boolean _tripleNotEquals_8 = (_attName_1 != null);
              if (_tripleNotEquals_8) {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_199 = expressionList.get(indexExpression);
                _builder.append(_get_199);
                _builder.append(".attName = \"");
                String _name_60 = ((ReferenceEvaluation)ev).getAttName().getName();
                _builder.append(_name_60);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_200 = expressionList.get(indexExpression);
                _builder.append(_get_200);
                _builder.append(".attName = null;");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t   \t");
            _builder.append("ev");
            _builder.append(evName, "\t\t   \t");
            _builder.append("_");
            Integer _get_201 = expressionList.get(indexExpression);
            _builder.append(_get_201, "\t\t   \t");
            _builder.append(".operator = \"");
            Operator _operator_10 = ((ReferenceEvaluation)ev).getOperator();
            _builder.append(_operator_10, "\t\t   \t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            {
              ObSelectionStrategy _value_110 = ((ReferenceEvaluation)ev).getValue();
              boolean _tripleEquals_2 = (_value_110 == null);
              if (_tripleEquals_2) {
                {
                  AttributeEvaluationType _attValue_32 = ((ReferenceEvaluation)ev).getAttValue();
                  boolean _tripleEquals_3 = (_attValue_32 == null);
                  if (_tripleEquals_3) {
                    _builder.append("   \t\t\t");
                    _builder.append("ev");
                    _builder.append(evName, "   \t\t\t");
                    _builder.append("_");
                    Integer _get_202 = expressionList.get(indexExpression);
                    _builder.append(_get_202, "   \t\t\t");
                    _builder.append(".value = null;");
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      AttributeEvaluationType _attValue_33 = ((ReferenceEvaluation)ev).getAttValue();
                      if ((_attValue_33 instanceof ObjectAttributeType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("ev");
                        _builder.append(evName, "   \t\t\t");
                        _builder.append("_");
                        Integer _get_203 = expressionList.get(indexExpression);
                        _builder.append(_get_203, "   \t\t\t");
                        _builder.append(".value = ModelManager.getStringAttribute(\"");
                        AttributeEvaluationType _attValue_34 = ((ReferenceEvaluation)ev).getAttValue();
                        String _name_61 = ((ObjectAttributeType) _attValue_34).getAttribute().getName();
                        _builder.append(_name_61, "   \t\t\t");
                        _builder.append("\", (hmObjects.get(\"");
                        AttributeEvaluationType _attValue_35 = ((ReferenceEvaluation)ev).getAttValue();
                        String _name_62 = ((ObjectAttributeType) _attValue_35).getObjSel().getName();
                        _builder.append(_name_62, "   \t\t\t");
                        _builder.append("\") != null ? hmObjects.get(\"");
                        AttributeEvaluationType _attValue_36 = ((ReferenceEvaluation)ev).getAttValue();
                        String _name_63 = ((ObjectAttributeType) _attValue_36).getObjSel().getName();
                        _builder.append(_name_63, "   \t\t\t");
                        _builder.append("\").getKey() : null));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_37 = ((ReferenceEvaluation)ev).getAttValue();
                      if ((_attValue_37 instanceof AttributeType)) {
                        {
                          if (((((((ReferenceEvaluation)ev).getAttValue() instanceof StringType) || (((ReferenceEvaluation)ev).getAttValue() instanceof DoubleType)) || (((ReferenceEvaluation)ev).getAttValue() instanceof BooleanType)) || (((ReferenceEvaluation)ev).getAttValue() instanceof IntegerType))) {
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_204 = expressionList.get(indexExpression);
                            _builder.append(_get_204);
                            _builder.append(".value = \"");
                            AttributeEvaluationType _attValue_38 = ((ReferenceEvaluation)ev).getAttValue();
                            String _value_111 = ((SpecificStringType) _attValue_38).getValue();
                            _builder.append(_value_111);
                            _builder.append("\";");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_39 = ((ReferenceEvaluation)ev).getAttValue();
                          if ((_attValue_39 instanceof MinValueType)) {
                            _builder.append("MinValueConfigurationStrategy min_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_205 = expressionList.get(indexExpression);
                            _builder.append(_get_205);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _attValue_40 = ((ReferenceEvaluation)ev).getAttValue();
                            String _typeName_24 = MutatorUtils.getTypeName(((MinValueType) _attValue_40));
                            _builder.append(_typeName_24);
                            _builder.append("\", \"");
                            AttributeEvaluationType _attValue_41 = ((ReferenceEvaluation)ev).getAttValue();
                            String _name_64 = ((MinValueType) _attValue_41).getAttribute().getName();
                            _builder.append(_name_64);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_206 = expressionList.get(indexExpression);
                            _builder.append(_get_206);
                            _builder.append(".value = min_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_207 = expressionList.get(indexExpression);
                            _builder.append(_get_207);
                            _builder.append(".getValue().toString();");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_42 = ((ReferenceEvaluation)ev).getAttValue();
                          if ((_attValue_42 instanceof MaxValueType)) {
                            _builder.append("MaxValueConfigurationStrategy max_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_208 = expressionList.get(indexExpression);
                            _builder.append(_get_208);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _attValue_43 = ((ReferenceEvaluation)ev).getAttValue();
                            String _typeName_25 = MutatorUtils.getTypeName(((MaxValueType) _attValue_43));
                            _builder.append(_typeName_25);
                            _builder.append("\", \"");
                            AttributeEvaluationType _attValue_44 = ((ReferenceEvaluation)ev).getAttValue();
                            String _name_65 = ((MaxValueType) _attValue_44).getAttribute().getName();
                            _builder.append(_name_65);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_209 = expressionList.get(indexExpression);
                            _builder.append(_get_209);
                            _builder.append(".value = max_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_210 = expressionList.get(indexExpression);
                            _builder.append(_get_210);
                            _builder.append(".getValue().toString();");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              } else {
                ObSelectionStrategy _value_112 = ((ReferenceEvaluation)ev).getValue();
                if ((_value_112 instanceof SpecificObjectSelection)) {
                  {
                    if (((((ReferenceEvaluation)ev).getRefType() == null) && (((ReferenceEvaluation)ev).getValue().getRefType() == null))) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry");
                      _builder.append(evName);
                      _builder.append("_");
                      Integer _get_211 = expressionList.get(indexExpression);
                      _builder.append(_get_211);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_113 = ((ReferenceEvaluation)ev).getValue();
                      String _name_66 = ((SpecificObjectSelection) _value_113).getObjSel().getName();
                      _builder.append(_name_66);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry");
                      _builder.append(evName);
                      _builder.append("_");
                      Integer _get_212 = expressionList.get(indexExpression);
                      _builder.append(_get_212);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t\t\t");
                      _builder.append("ev");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_213 = expressionList.get(indexExpression);
                      _builder.append(_get_213, "   \t\t\t\t\t\t");
                      _builder.append(".value = new SpecificObjectSelection(entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_214 = expressionList.get(indexExpression);
                      _builder.append(_get_214, "   \t\t\t\t\t\t");
                      _builder.append(".getValue().getValue(), entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_215 = expressionList.get(indexExpression);
                      _builder.append(_get_215, "   \t\t\t\t\t\t");
                      _builder.append(".getValue().getKey(), entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_216 = expressionList.get(indexExpression);
                      _builder.append(_get_216, "   \t\t\t\t\t\t");
                      _builder.append(".getKey()).getObject();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t\t");
                      _builder.append("}");
                      _builder.newLine();
                    } else {
                      {
                        EReference _refType_2 = ((ReferenceEvaluation)ev).getRefType();
                        boolean _tripleNotEquals_9 = (_refType_2 != null);
                        if (_tripleNotEquals_9) {
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_217 = expressionList.get(indexExpression);
                          _builder.append(_get_217);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_114 = ((ReferenceEvaluation)ev).getValue();
                          String _name_67 = ((SpecificObjectSelection) _value_114).getObjSel().getName();
                          _builder.append(_name_67);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_218 = expressionList.get(indexExpression);
                          _builder.append(_get_218);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("EObject srcObjExp =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t        ");
                          _builder.append("entry");
                          _builder.append(evName, "\t\t   \t\t   \t\t\t\t        ");
                          _builder.append("_");
                          Integer _get_219 = expressionList.get(indexExpression);
                          _builder.append(_get_219, "\t\t   \t\t   \t\t\t\t        ");
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t");
                          _builder.append("EStructuralFeature feature =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t    ");
                          _builder.append("srcObjExp.eClass()");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t               ");
                          _builder.append(".getEStructuralFeature(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.append("\"");
                          String _name_68 = ((ReferenceEvaluation)ev).getRefType().getName();
                          _builder.append(_name_68, "\t\t   \t\t   \t\t\t\t                   ");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (!(feature instanceof EReference)) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t\t   \t\t   \t\t\t    ");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("Object value =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("srcObjExp.eGet(feature);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (!(value instanceof EObject)) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t\t   \t\t   \t\t\t    ");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("EObject external =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("(EObject) value;");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("EObject external2Local =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("MutatorUtils.recoverLocalObject(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("external);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (external2Local == null) {");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("external2Local =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("ModelManager.getObject(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t            ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t            ");
                          _builder.append("external);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (external2Local == null) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t       \t\t\t\t\t\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t       \t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t ");
                          _builder.append("ev");
                          _builder.append(evName, "\t\t   \t\t   \t\t\t ");
                          _builder.append("_");
                          Integer _get_220 = expressionList.get(indexExpression);
                          _builder.append(_get_220, "\t\t   \t\t   \t\t\t ");
                          _builder.append(".value = external2Local;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t   \t\t\t\t\tEObject srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_221 = expressionList.get(indexExpression);
                          _builder.append(_get_221);
                          _builder.append(" = entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_222 = expressionList.get(indexExpression);
                          _builder.append(_get_222);
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//   \t\t\t\t\t\tfor (EReference ref : srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_223 = expressionList.get(indexExpression);
                          _builder.append(_get_223);
                          _builder.append(".eClass().getEAllReferences()) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//   \t\t\t\t\t\t\tif (ref.getName().equals(\"");
                          String _name_69 = ((ReferenceEvaluation)ev).getRefType().getName();
                          _builder.append(_name_69);
                          _builder.append("\")) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//   \t\t\t\t\t\t\t\tev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_224 = expressionList.get(indexExpression);
                          _builder.append(_get_224);
                          _builder.append(".value = srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_225 = expressionList.get(indexExpression);
                          _builder.append(_get_225);
                          _builder.append(".eGet(ref);\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//   \t\t\t\t\t\t\t}");
                          _builder.newLine();
                          _builder.append("//\t   \t\t\t\t\t}");
                          _builder.newLine();
                          _builder.append("\t   \t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                      {
                        EReference _refType_3 = ((ReferenceEvaluation)ev).getValue().getRefType();
                        boolean _tripleNotEquals_10 = (_refType_3 != null);
                        if (_tripleNotEquals_10) {
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_226 = expressionList.get(indexExpression);
                          _builder.append(_get_226);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_115 = ((ReferenceEvaluation)ev).getValue();
                          String _name_70 = ((SpecificObjectSelection) _value_115).getObjSel().getName();
                          _builder.append(_name_70);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_227 = expressionList.get(indexExpression);
                          _builder.append(_get_227);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("EObject srcObjExp =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t        ");
                          _builder.append("entry");
                          _builder.append(evName, "\t\t   \t\t   \t\t\t\t        ");
                          _builder.append("_");
                          Integer _get_228 = expressionList.get(indexExpression);
                          _builder.append(_get_228, "\t\t   \t\t   \t\t\t\t        ");
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t   \t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t");
                          _builder.append("EStructuralFeature feature =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t    ");
                          _builder.append("srcObjExp.eClass()");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t               ");
                          _builder.append(".getEStructuralFeature(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.append("\"");
                          String _name_71 = ((ReferenceEvaluation)ev).getValue().getRefType().getName();
                          _builder.append(_name_71, "\t\t   \t\t   \t\t\t\t                   ");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t\t                   ");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (!(feature instanceof EReference)) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t\t   \t\t   \t\t\t    ");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("Object value =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("srcObjExp.eGet(feature);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (!(value instanceof EObject)) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t\t   \t\t   \t\t\t    ");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t\t   \t\t   \t\t\t    ");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("EObject external =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("(EObject) value;");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("EObject external2Local =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("MutatorUtils.recoverLocalObject(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("external);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (external2Local == null) {");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t    ");
                          _builder.append("external2Local =");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t        ");
                          _builder.append("ModelManager.getObject(");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t            ");
                          _builder.append("model,");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t            ");
                          _builder.append("external);");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t");
                          _builder.append("if (external2Local == null) {");
                          _builder.newLine();
                          {
                            if ((insideLoop == false)) {
                              {
                                if ((exhaustive == true)) {
                                  _builder.append("\t");
                                  _builder.append("return numMutantsGenerated;");
                                  _builder.newLine();
                                } else {
                                  _builder.append("\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              _builder.append("\t");
                              _builder.append("continue;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t   \t\t   \t\t\t       \t\t\t\t\t\t\t\t\t");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t       \t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t\t   \t\t   \t\t\t ");
                          _builder.append("ev");
                          _builder.append(evName, "\t\t   \t\t   \t\t\t ");
                          _builder.append("_");
                          Integer _get_229 = expressionList.get(indexExpression);
                          _builder.append(_get_229, "\t\t   \t\t   \t\t\t ");
                          _builder.append(".value = external2Local;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t\t   \t\t\t\tEObject srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_230 = expressionList.get(indexExpression);
                          _builder.append(_get_230);
                          _builder.append(" = entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_231 = expressionList.get(indexExpression);
                          _builder.append(_get_231);
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t\t   \t\t\t\tfor (EReference ref : srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_232 = expressionList.get(indexExpression);
                          _builder.append(_get_232);
                          _builder.append(".eClass().getEAllReferences()) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t   \t\t\t\t\t\tif (ref.getName().equals(\"");
                          String _name_72 = ((ReferenceEvaluation)ev).getValue().getRefType().getName();
                          _builder.append(_name_72);
                          _builder.append("\")) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t   \t\t\t\t\t\t\tev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_233 = expressionList.get(indexExpression);
                          _builder.append(_get_233);
                          _builder.append(".value = srcObjExp");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_234 = expressionList.get(indexExpression);
                          _builder.append(_get_234);
                          _builder.append(".eGet(ref);\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("//\t   \t\t\t\t\t\t}");
                          _builder.newLine();
                          _builder.append("//\t   \t\t\t\t\t}");
                          _builder.newLine();
                          _builder.append("\t   \t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                } else {
                  {
                    ObSelectionStrategy _value_116 = ((ReferenceEvaluation)ev).getValue();
                    if ((_value_116 instanceof RandomTypeSelection)) {
                      {
                        Expression _expression_2 = ((ReferenceEvaluation)ev).getValue().getExpression();
                        if ((_expression_2 instanceof Expression)) {
                          _builder.append("//EXPRESSION LEVEL: ");
                          int _get_235 = nExpression[0];
                          int _plus_2 = (_get_235 + 1);
                          int _set_4 = nExpression[0] = _plus_2;
                          _builder.append(_set_4);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//EXPRESSION LEVEL: ");
                          boolean _add_2 = expressionList.add(Integer.valueOf(nExpression[0]));
                          _builder.append(_add_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          final int[] nestedIndexExpression_2 = new int[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          int _size_3 = expressionList.size();
                          int _minus_2 = (_size_3 - 1);
                          int _set_5 = nestedIndexExpression_2[0] = _minus_2;
                          _builder.append(_set_5);
                          _builder.newLineIfNotEmpty();
                          _builder.append("RandomTypeSelection expRts");
                          Integer _get_236 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_236);
                          _builder.append(" = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _value_117 = ((ReferenceEvaluation)ev).getValue();
                          String _name_73 = ((RandomTypeSelection) _value_117).getType().getName();
                          _builder.append(_name_73);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> expObjects");
                          Integer _get_237 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_237);
                          _builder.append(" = expRts");
                          Integer _get_238 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_238);
                          _builder.append(".getObjects();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Expression exp");
                          Integer _get_239 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_239);
                          _builder.append(" = new Expression();");
                          _builder.newLineIfNotEmpty();
                          Object _method_2 = this.method(((ReferenceEvaluation)ev).getValue().getExpression(), mut, nReference, ((List<Integer>)Conversions.doWrapArray(nestedIndexExpression_2)), nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
                          _builder.append(_method_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> selectedObjects");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_240 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_240);
                          _builder.append(" = evaluate(expObjects");
                          Integer _get_241 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_241);
                          _builder.append(", exp");
                          Integer _get_242 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_242);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject object");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_243 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_243);
                          _builder.append(" = null;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (selectedObjects");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_244 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_244);
                          _builder.append(".size() > 0) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("object");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_245 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_245, "\t");
                          _builder.append(" = selectedObjects");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_246 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_246, "\t");
                          _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_247 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_247, "\t");
                          _builder.append("));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("ev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_248 = expressionList.get(indexExpression);
                          _builder.append(_get_248);
                          _builder.append(".value = new SpecificObjectSelection(packages, model, object");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_249 = expressionList.get(nestedIndexExpression_2[0]);
                          _builder.append(_get_249);
                          _builder.append(").getObject();");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("ev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_250 = expressionList.get(indexExpression);
                          _builder.append(_get_250);
                          _builder.append(".value = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _value_118 = ((ReferenceEvaluation)ev).getValue();
                          String _name_74 = ((RandomTypeSelection) _value_118).getType().getName();
                          _builder.append(_name_74);
                          _builder.append("\").getObject();");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    } else {
                      {
                        ObSelectionStrategy _value_119 = ((ReferenceEvaluation)ev).getValue();
                        if ((_value_119 instanceof TypedSelection)) {
                          {
                            Expression _expression_3 = ((ReferenceEvaluation)ev).getValue().getExpression();
                            if ((_expression_3 instanceof Expression)) {
                              _builder.append("//EXPRESSION LEVEL: ");
                              int _get_251 = nExpression[0];
                              int _plus_3 = (_get_251 + 1);
                              int _set_6 = nExpression[0] = _plus_3;
                              _builder.append(_set_6);
                              _builder.newLineIfNotEmpty();
                              _builder.append("//EXPRESSION LEVEL: ");
                              boolean _add_3 = expressionList.add(Integer.valueOf(nExpression[0]));
                              _builder.append(_add_3);
                              _builder.newLineIfNotEmpty();
                              _builder.append("//INDEX EXPRESSION: ");
                              final int[] nestedIndexExpression_3 = new int[1];
                              _builder.newLineIfNotEmpty();
                              _builder.append("//INDEX EXPRESSION: ");
                              int _size_4 = expressionList.size();
                              int _minus_3 = (_size_4 - 1);
                              int _set_7 = nestedIndexExpression_3[0] = _minus_3;
                              _builder.append(_set_7);
                              _builder.newLineIfNotEmpty();
                              _builder.append("TypedSelection expRts");
                              Integer _get_252 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_252);
                              _builder.append(" = new TypedSelection(packages, model, \"");
                              ObSelectionStrategy _value_120 = ((ReferenceEvaluation)ev).getValue();
                              String _name_75 = ((TypedSelection) _value_120).getType().getName();
                              _builder.append(_name_75);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<EObject> expObjects");
                              Integer _get_253 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_253);
                              _builder.append(" = expRts");
                              Integer _get_254 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_254);
                              _builder.append(".getObjects();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("Expression exp");
                              Integer _get_255 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_255);
                              _builder.append(" = new Expression();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<String> refNames");
                              Integer _get_256 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_256);
                              _builder.append(" = new ArrayList<String>();");
                              _builder.newLineIfNotEmpty();
                              Object _method_3 = this.method(((ReferenceEvaluation)ev).getValue().getExpression(), mut, nReference, ((List<Integer>)Conversions.doWrapArray(nestedIndexExpression_3)), nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation);
                              _builder.append(_method_3);
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<EObject> selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_257 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_257);
                              _builder.append(" = evaluate(expObjects");
                              Integer _get_258 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_258);
                              _builder.append(", exp");
                              Integer _get_259 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_259);
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("refNames");
                              Integer _get_260 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_260);
                              _builder.append(".add(\"");
                              String _name_76 = ((ReferenceEvaluation)ev).getName().getName();
                              _builder.append(_name_76);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("Collections.reverse(refNames");
                              Integer _get_261 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_261);
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_262 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_262);
                              _builder.append(" = ModelManager.getReferredObjects(refNames");
                              Integer _get_263 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_263);
                              _builder.append(", objects, selectedObjects1);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("EObject object");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_264 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_264);
                              _builder.append(" = null;");
                              _builder.newLineIfNotEmpty();
                              _builder.append("if (selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_265 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_265);
                              _builder.append(".size() > 0) {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("object");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_266 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_266, "\t");
                              _builder.append(" = selectedObjects");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_267 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_267, "\t");
                              _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_268 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_268, "\t");
                              _builder.append("));");
                              _builder.newLineIfNotEmpty();
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("ev");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_269 = expressionList.get(indexExpression);
                              _builder.append(_get_269);
                              _builder.append(".value = new SpecificObjectSelection(packages, model, object");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_270 = expressionList.get(nestedIndexExpression_3[0]);
                              _builder.append(_get_270);
                              _builder.append(").getObject();");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("ev");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_271 = expressionList.get(indexExpression);
                              _builder.append(_get_271);
                              _builder.append(".value = new TypedSelection(packages, model, \"");
                              ObSelectionStrategy _value_121 = ((ReferenceEvaluation)ev).getValue();
                              String _name_77 = ((TypedSelection) _value_121).getType().getName();
                              _builder.append(_name_77);
                              _builder.append("\").getObject();");
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
        }
        _builder.append("   \t\t");
        _builder.append("exp");
        Integer _get_272 = expressionList.get(indexExpression);
        _builder.append(_get_272, "   \t\t");
        _builder.append(".second.add(ev");
        _builder.append(evName, "   \t\t");
        _builder.append("_");
        Integer _get_273 = expressionList.get(indexExpression);
        _builder.append(_get_273, "   \t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t");
        _builder.append("//EVNAME + 1: ");
        _builder.append(evName = (evName + 1), "   \t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _get_274 = evaluation[0];
      if (_get_274) {
        _builder.append("List<EObject> auxObjects = evaluate(objects, exp");
        Integer _get_275 = expressionList.get(indexExpression);
        _builder.append(_get_275);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence each(final Expression exp, final List<Integer> expressionList) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//INDEX EXPRESSION: ");
    int _size = expressionList.size();
    final int indexExpression = (_size - 1);
    _builder.newLineIfNotEmpty();
    {
      Evaluation _first = exp.getFirst();
      if ((_first instanceof AttributeEvaluation)) {
        _builder.append("//ATTRIBUTE: ");
        Evaluation _first_1 = exp.getFirst();
        final AttributeEvaluation attev = ((AttributeEvaluation) _first_1);
        _builder.newLineIfNotEmpty();
        _builder.append("selectedObjects = unique(selectedObjects, \"");
        String _name = attev.getName().getName();
        _builder.append(_name);
        _builder.append("\", false);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Evaluation _first_2 = exp.getFirst();
      if ((_first_2 instanceof ReferenceEvaluation)) {
        _builder.append("exp");
        Integer _get = expressionList.get(indexExpression);
        _builder.append(_get);
        _builder.append(".first = new ReferenceEvaluation();");
        _builder.newLineIfNotEmpty();
        _builder.append("//REFERENCE: ");
        Evaluation _first_3 = exp.getFirst();
        final ReferenceEvaluation refev = ((ReferenceEvaluation) _first_3);
        _builder.newLineIfNotEmpty();
        _builder.append("selectedObjects = unique(selectedObjects, \"");
        String _name_1 = refev.getName().getName();
        _builder.append(_name_1);
        _builder.append("\", true);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Evaluation> _second = exp.getSecond();
      for(final Evaluation ev : _second) {
        {
          if ((ev instanceof AttributeEvaluation)) {
            _builder.append("selectedObjects = unique(selectedObjects, \"");
            String _name_2 = ((AttributeEvaluation)ev).getName().getName();
            _builder.append(_name_2);
            _builder.append("\", false);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((ev instanceof ReferenceEvaluation)) {
            _builder.append("selectedObjects = unique(selectedObjects, \"");
            String _name_3 = ((ReferenceEvaluation)ev).getName().getName();
            _builder.append(_name_3);
            _builder.append("\", true);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("   \t\t");
    _builder.append("objects = selectedObjects;");
    _builder.newLine();
    return _builder;
  }

  public CharSequence addResources(final Expression exp, final Mutator mut) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mut instanceof SelectObjectMutator)) {
        {
          Evaluation _first = exp.getFirst();
          if ((_first instanceof ReferenceEvaluation)) {
            _builder.append("//");
            Evaluation _first_1 = exp.getFirst();
            ReferenceEvaluation refev = ((ReferenceEvaluation) _first_1);
            _builder.newLineIfNotEmpty();
            {
              ObSelectionStrategy _value = refev.getValue();
              if ((_value instanceof SpecificObjectSelection)) {
                _builder.append("            ");
                _builder.append("//");
                ObSelectionStrategy _value_1 = refev.getValue();
                SpecificObjectSelection sel = ((SpecificObjectSelection) _value_1);
                _builder.newLineIfNotEmpty();
                _builder.append("            ");
                _builder.append("//");
                Mutator selMut = MutatorUtils.getMutator(sel);
                _builder.newLineIfNotEmpty();
                {
                  if ((selMut instanceof SelectObjectMutator)) {
                    _builder.append("            ");
                    _builder.append("//");
                    SelectObjectMutator selMutator = ((SelectObjectMutator) selMut);
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _or = false;
                      String _resource = selMutator.getObject().getResource();
                      boolean _tripleNotEquals = (_resource != null);
                      if (_tripleNotEquals) {
                        _or = true;
                      } else {
                        ObSelectionStrategy _container = selMutator.getContainer();
                        String _resource_1 = null;
                        if (_container!=null) {
                          _resource_1=_container.getResource();
                        }
                        boolean _tripleNotEquals_1 = (_resource_1 != null);
                        _or = _tripleNotEquals_1;
                      }
                      if (_or) {
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                        String _name = sel.getObjSel().getName();
                        _builder.append(_name);
                        _builder.append(" = hmObjects.get(\"");
                        String _name_1 = sel.getObjSel().getName();
                        _builder.append(_name_1);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("if (entry_");
                        String _name_2 = sel.getObjSel().getName();
                        _builder.append(_name_2);
                        _builder.append(" == null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("selectionPackages = entry_");
                        String _name_3 = sel.getObjSel().getName();
                        _builder.append(_name_3);
                        _builder.append(".getValue().getValue();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("selection.add(entry_");
                        String _name_4 = sel.getObjSel().getName();
                        _builder.append(_name_4);
                        _builder.append(".getValue().getKey());");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  EList<Evaluation> _second = exp.getSecond();
                  for(final Evaluation ev : _second) {
                    {
                      if ((ev instanceof ReferenceEvaluation)) {
                        _builder.append("//");
                        ObSelectionStrategy _value_2 = ((ReferenceEvaluation)ev).getValue();
                        _builder.append(sel = ((SpecificObjectSelection) _value_2));
                        _builder.newLineIfNotEmpty();
                        {
                          boolean _selectionOriginatesFromAdditionalResources = MutatorUtils.selectionOriginatesFromAdditionalResources(MutatorUtils.getMutator(sel));
                          if (_selectionOriginatesFromAdditionalResources) {
                            _builder.append("//");
                            _builder.append(selMut = MutatorUtils.getMutator(sel));
                            _builder.newLineIfNotEmpty();
                            {
                              if ((selMut instanceof SelectObjectMutator)) {
                                _builder.append("//");
                                SelectObjectMutator selMutator_1 = ((SelectObjectMutator) selMut);
                                _builder.newLineIfNotEmpty();
                                {
                                  boolean _or_1 = false;
                                  String _resource_2 = selMutator_1.getObject().getResource();
                                  boolean _tripleNotEquals_2 = (_resource_2 != null);
                                  if (_tripleNotEquals_2) {
                                    _or_1 = true;
                                  } else {
                                    ObSelectionStrategy _container_1 = selMutator_1.getContainer();
                                    String _resource_3 = null;
                                    if (_container_1!=null) {
                                      _resource_3=_container_1.getResource();
                                    }
                                    boolean _tripleNotEquals_3 = (_resource_3 != null);
                                    _or_1 = _tripleNotEquals_3;
                                  }
                                  if (_or_1) {
                                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                                    String _name_5 = sel.getObjSel().getName();
                                    _builder.append(_name_5);
                                    _builder.append(" = hmObjects.get(\"");
                                    String _name_6 = sel.getObjSel().getName();
                                    _builder.append(_name_6);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("if (entry_");
                                    String _name_7 = sel.getObjSel().getName();
                                    _builder.append(_name_7);
                                    _builder.append(" == null) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("return numMutantsGenerated;");
                                    _builder.newLine();
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("selectionPackages = entry_");
                                    String _name_8 = sel.getObjSel().getName();
                                    _builder.append(_name_8);
                                    _builder.append(".getValue().getValue();");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("selection.add(entry_");
                                    String _name_9 = sel.getObjSel().getName();
                                    _builder.append(_name_9);
                                    _builder.append(".getValue().getKey());");
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
                _builder.append("            ");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
}
