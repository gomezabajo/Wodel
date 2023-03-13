package wodel.dsls.validation;

import com.google.common.base.Objects;
import java.io.File;
import java.util.List;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeType;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.BooleanType;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.DoubleType;
import mutatorenvironment.IntegerType;
import mutatorenvironment.ListStringType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.Program;
import mutatorenvironment.StringType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Exceptions;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo - Wodel editor validator.
 * 
 * Validates the Wodel code.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 */
@SuppressWarnings("all")
public class WodelValidator extends AbstractWodelValidator {
  public static final String INVALID_NAME = "invalidName";

  public static final String INVALID_METAMODEL = "invalidMetamodel";

  public static final String INVALID_MODEL = "invalidModel";

  public static final String INVALID_UNSET = "invalidUnset";

  public static final String INVALID_SWAP = "invalidSwap";

  public static final String INVALID_COPY = "invalidCopy";

  public static final String INVALID_TYPE = "invalidType";

  public static final String WARNING_MODIFY_SOURCE = "warningModifySource";

  public static final String INVALID_EXPRESSION = "invalidExpression";

  public static final String INVALID_REVERSE = "invalidReverse";

  private List<EPackage> packages;

  private String lastMetamodel = "";

  @Check
  public void checkProgramModel(final Program p) {
    boolean _endsWith = p.getSource().getPath().endsWith("/");
    boolean _not = (!_endsWith);
    if (_not) {
      boolean _checkModel = ModelManager.checkModel(p.getSource().getPath());
      boolean _not_1 = (!_checkModel);
      if (_not_1) {
        String _path = p.getSource().getPath();
        String _plus = ("Cannot find model" + _path);
        this.error(_plus, null, WodelValidator.INVALID_MODEL);
      }
    }
    boolean _endsWith_1 = p.getSource().getPath().endsWith("/");
    if (_endsWith_1) {
      String _path_1 = p.getSource().getPath();
      final File[] files = new File(_path_1).listFiles();
      for (final File file : files) {
        boolean _isFile = file.isFile();
        boolean _equals = (_isFile == true);
        if (_equals) {
          boolean _endsWith_2 = file.getPath().endsWith(".model");
          boolean _equals_1 = (_endsWith_2 == true);
          if (_equals_1) {
            boolean _checkModel_1 = ModelManager.checkModel(file.getPath());
            boolean _not_2 = (!_checkModel_1);
            if (_not_2) {
              String _path_2 = file.getPath();
              String _plus_1 = ("Cannot find model " + _path_2);
              this.error(_plus_1, null, WodelValidator.INVALID_MODEL);
            }
          }
        }
      }
    }
  }

  @Check
  public List<EPackage> checkProgramMetaModel(final Program p) {
    List<EPackage> _xblockexpression = null;
    {
      String path = p.getMetamodel();
      List<EPackage> _xtrycatchfinallyexpression = null;
      try {
        List<EPackage> _xifexpression = null;
        boolean _equals = this.lastMetamodel.equals(path);
        boolean _not = (!_equals);
        if (_not) {
          List<EPackage> _xblockexpression_1 = null;
          {
            this.lastMetamodel = path;
            _xblockexpression_1 = this.packages = ModelManager.loadMetaModel(path);
          }
          _xifexpression = _xblockexpression_1;
        }
        _xtrycatchfinallyexpression = _xifexpression;
      } catch (final Throwable _t) {
        if (_t instanceof MetaModelNotFoundException) {
          final MetaModelNotFoundException e = (MetaModelNotFoundException)_t;
          this.error(e.toString(), null, WodelValidator.INVALID_METAMODEL);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }

  @Check
  public void checkCreateObjectMutatorMin(final CreateObjectMutator com) {
    int _min = ((Mutator) com).getMin();
    int _max = ((Mutator) com).getMax();
    boolean _greaterThan = (_min > _max);
    if (_greaterThan) {
      this.error("The min value must me lower or equal than the max value.", null, WodelValidator.INVALID_NAME);
    }
    EList<AttributeSet> attributes = com.getAttributes();
    for (final AttributeSet attset : attributes) {
      {
        if ((attset instanceof AttributeUnset)) {
          EAttribute att = ((AttributeUnset)attset).getAttribute().get(0);
          if (((att.isUnsettable() == false) && (att.getLowerBound() != 0))) {
            this.error("The attribute is not unsettable and the lower bound is not 0", null, WodelValidator.INVALID_UNSET);
          }
          boolean _isUnsettable = att.isUnsettable();
          boolean _equals = (_isUnsettable == false);
          if (_equals) {
            this.error("The attribute is not unsettable", null, WodelValidator.INVALID_UNSET);
          }
          int _lowerBound = att.getLowerBound();
          boolean _notEquals = (_lowerBound != 0);
          if (_notEquals) {
            this.error("The lower bound is not 0", null, WodelValidator.INVALID_UNSET);
          }
        }
        if ((attset instanceof AttributeSwap)) {
          EAttribute att0 = ((AttributeSwap)attset).getAttribute().get(0);
          EAttribute att1 = ((AttributeSwap)attset).getAttribute().get(1);
          Class<?> _instanceClass = att0.getEType().getInstanceClass();
          Class<?> _instanceClass_1 = att1.getEType().getInstanceClass();
          boolean _notEquals_1 = (!Objects.equal(_instanceClass, _instanceClass_1));
          if (_notEquals_1) {
            this.error("The attributes are not of the same type", null, WodelValidator.INVALID_SWAP);
          }
        }
        if ((attset instanceof AttributeCopy)) {
          EAttribute att0_1 = ((AttributeCopy)attset).getAttribute().get(0);
          EAttribute att1_1 = ((AttributeCopy)attset).getAttribute().get(1);
          Class<?> _instanceClass_2 = att0_1.getEType().getInstanceClass();
          Class<?> _instanceClass_3 = att1_1.getEType().getInstanceClass();
          boolean _notEquals_2 = (!Objects.equal(_instanceClass_2, _instanceClass_3));
          if (_notEquals_2) {
            this.error("The attributes are not of the same type", null, WodelValidator.INVALID_COPY);
          }
        }
        if ((attset instanceof AttributeScalar)) {
          EAttribute att0_2 = ((AttributeScalar)attset).getAttribute().get(0);
          AttributeType att_type = ((AttributeScalar)attset).getValue();
          if ((att_type instanceof IntegerType)) {
            if (((!att0_2.getEType().getInstanceClassName().equals("int")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Integer")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof BooleanType)) {
            if (((!att0_2.getEType().getInstanceClassName().equals("boolean")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Boolean")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof StringType)) {
            boolean _equals_1 = att0_2.getEType().getInstanceClassName().equals("java.lang.String");
            boolean _not = (!_equals_1);
            if (_not) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof DoubleType)) {
            if (((!att0_2.getEType().getInstanceClassName().equals("double")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Double")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof ListStringType)) {
            boolean _equals_2 = att0_2.getEType().getInstanceClassName().equals("java.lang.String");
            boolean _not_1 = (!_equals_2);
            if (_not_1) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
        }
      }
    }
  }

  @Check
  public void checkModifyInformationMutatorUnset(final ModifyInformationMutator com) {
    EList<AttributeSet> attributes = com.getAttributes();
    for (final AttributeSet attset : attributes) {
      {
        if ((attset instanceof AttributeUnset)) {
          EAttribute att = ((AttributeUnset)attset).getAttribute().get(0);
          if (((att.isUnsettable() == false) && (att.getLowerBound() != 0))) {
            this.error("The attribute is not unsettable and the lower bound is not 0", null, WodelValidator.INVALID_UNSET);
          }
          boolean _isUnsettable = att.isUnsettable();
          boolean _equals = (_isUnsettable == false);
          if (_equals) {
            this.error("The attribute is not unsettable", null, WodelValidator.INVALID_UNSET);
          }
          int _lowerBound = att.getLowerBound();
          boolean _notEquals = (_lowerBound != 0);
          if (_notEquals) {
            this.error("The lower bound is not 0", null, WodelValidator.INVALID_UNSET);
          }
        }
        if ((attset instanceof AttributeSwap)) {
          EAttribute att0 = ((AttributeSwap)attset).getAttribute().get(0);
          EAttribute att1 = ((AttributeSwap)attset).getAttribute().get(1);
          Class<?> _instanceClass = att0.getEType().getInstanceClass();
          Class<?> _instanceClass_1 = att1.getEType().getInstanceClass();
          boolean _notEquals_1 = (!Objects.equal(_instanceClass, _instanceClass_1));
          if (_notEquals_1) {
            this.error("The attributes are not of the same type", null, WodelValidator.INVALID_SWAP);
          }
        }
        if ((attset instanceof AttributeCopy)) {
          EAttribute att0_1 = ((AttributeCopy)attset).getAttribute().get(0);
          EAttribute att1_1 = ((AttributeCopy)attset).getAttribute().get(1);
          Class<?> _instanceClass_2 = att0_1.getEType().getInstanceClass();
          Class<?> _instanceClass_3 = att1_1.getEType().getInstanceClass();
          boolean _notEquals_2 = (!Objects.equal(_instanceClass_2, _instanceClass_3));
          if (_notEquals_2) {
            this.error("The attributes are not of the same type", null, WodelValidator.INVALID_COPY);
          }
        }
        if ((attset instanceof AttributeScalar)) {
          EAttribute att0_2 = ((AttributeScalar)attset).getAttribute().get(0);
          AttributeType att_type = ((AttributeScalar)attset).getValue();
          if ((att_type instanceof IntegerType)) {
            if (((!att0_2.getEType().getInstanceClassName().equals("int")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Integer")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof BooleanType)) {
            String className = att0_2.getEType().getInstanceClassName();
            if (((!att0_2.getEType().getInstanceClassName().equals("boolean")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Boolean")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof StringType)) {
            boolean _equals_1 = att0_2.getEType().getInstanceClassName().equals("java.lang.String");
            boolean _not = (!_equals_1);
            if (_not) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof DoubleType)) {
            if (((!att0_2.getEType().getInstanceClassName().equals("double")) && (!att0_2.getEType().getInstanceClassName().equals("java.lang.Double")))) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
          if ((att_type instanceof ListStringType)) {
            boolean _equals_2 = att0_2.getEType().getInstanceClassName().equals("java.lang.String");
            boolean _not_1 = (!_equals_2);
            if (_not_1) {
              this.error("The attributes are not of the same type", null, WodelValidator.INVALID_TYPE);
            }
          }
        }
      }
    }
  }

  @Check
  public void checkAttributeSet(final AttributeSet attset) {
    if ((attset instanceof AttributeReverse)) {
      boolean _equals = ((AttributeReverse)attset).getAttribute().get(0).getEType().getInstanceClassName().equals("boolean");
      boolean _not = (!_equals);
      if (_not) {
        String _instanceClassName = ((AttributeReverse)attset).getAttribute().get(0).getEType().getInstanceClassName();
        String _plus = ("The reverse operator is only valid for boolean arguments, not for " + _instanceClassName);
        this.error(_plus, null, WodelValidator.INVALID_REVERSE);
      }
    }
  }
}
