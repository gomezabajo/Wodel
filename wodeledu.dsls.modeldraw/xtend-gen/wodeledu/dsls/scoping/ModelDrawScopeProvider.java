package wodeledu.dsls.scoping;

import java.util.ArrayList;
import java.util.List;
import modeldraw.Content;
import modeldraw.Edge;
import modeldraw.Information;
import modeldraw.Level;
import modeldraw.MutatorDraw;
import modeldraw.MutatorInstance;
import modeldraw.Node;
import modeldraw.NodeEnumerator;
import modeldraw.ValuedFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import wodel.utils.manager.ModelManager;

@SuppressWarnings("all")
public class ModelDrawScopeProvider extends AbstractDeclarativeScopeProvider {
  public IScope scope_Item_name(final MutatorDraw draw, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      scope.addAll(this.getEClasses(draw.getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Item_name(final MutatorInstance instance, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = instance.eContainer();
      scope.addAll(this.getRootEClasses(((MutatorDraw) _eContainer).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Item_name(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = node.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEClasses(((MutatorDraw) _eContainer_1).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Item_name(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEClasses(((MutatorDraw) _eContainer_1).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Node_reference(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = node.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), node.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Node_targetNode(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = node.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEClasses(((MutatorDraw) _eContainer_1).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_feat(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      EObject _eContainer = node.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_1).getMetamodel(), node.getName().getName()));
      EClass _targetNode = node.getTargetNode();
      boolean _tripleNotEquals = (_targetNode != null);
      if (_tripleNotEquals) {
        EObject _eContainer_2 = node.eContainer();
        EObject _eContainer_3 = ((MutatorInstance) _eContainer_2).eContainer();
        scope.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_3).getMetamodel(), node.getTargetNode().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_refFeature(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
      if (((node.getFeature() != null) && (node.getFeature().size() > 0))) {
        EList<ValuedFeature> _feature = node.getFeature();
        for (final ValuedFeature feature : _feature) {
          EObject _eContainer = node.eContainer();
          EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
          features.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_1).getMetamodel(), feature.getFeat().getEType().getName()));
        }
      }
      if (((node.getTargetFeature() != null) && (node.getTargetFeature().size() > 0))) {
        EList<ValuedFeature> _targetFeature = node.getTargetFeature();
        for (final ValuedFeature feature_1 : _targetFeature) {
          EObject _eContainer_2 = node.eContainer();
          EObject _eContainer_3 = ((MutatorInstance) _eContainer_2).eContainer();
          features.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_3).getMetamodel(), feature_1.getFeat().getEType().getName()));
        }
      }
      scope.addAll(features);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_NamedItem_attName(final Node node, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = node.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), node.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_NamedItem_attName(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_NamedItem_attName(final Content content, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = content.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), content.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_NamedItem_attName(final Level level, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = level.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), level.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Edge_source(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Edge_target(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_reference(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_refType(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      if (((edge.getReference() != null) && (edge.getReference().size() > 0))) {
        EList<EReference> _reference = edge.getReference();
        for (final EReference reference : _reference) {
          EObject _eContainer = edge.eContainer();
          EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
          scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), reference.getEType().getName()));
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_label(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      if (((edge.getReference() != null) && (edge.getReference().size() > 0))) {
        EList<EReference> _reference = edge.getReference();
        for (final EReference reference : _reference) {
          EObject _eContainer = edge.eContainer();
          EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
          scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), reference.getEType().getName()));
        }
      } else {
        EObject _eContainer_2 = edge.eContainer();
        EObject _eContainer_3 = ((MutatorInstance) _eContainer_2).eContainer();
        scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_3).getMetamodel(), edge.getName().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_src_label(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_tar_label(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Relation_targetNode(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEClasses(((MutatorDraw) _eContainer_1).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_feat(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      EObject _eContainer = edge.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_1).getMetamodel(), edge.getName().getName()));
      EClass _targetNode = edge.getTargetNode();
      boolean _tripleNotEquals = (_targetNode != null);
      if (_tripleNotEquals) {
        EObject _eContainer_2 = edge.eContainer();
        EObject _eContainer_3 = ((MutatorInstance) _eContainer_2).eContainer();
        scope.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_3).getMetamodel(), edge.getTargetNode().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_refFeature(final Edge edge, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
      if (((edge.getFeature() != null) && (edge.getFeature().size() > 0))) {
        EList<ValuedFeature> _feature = edge.getFeature();
        for (final ValuedFeature feature : _feature) {
          EObject _eContainer = edge.eContainer();
          EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
          features.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_1).getMetamodel(), feature.getFeat().getEType().getName()));
        }
      }
      if (((edge.getTargetFeature() != null) && (edge.getTargetFeature().size() > 0))) {
        EList<ValuedFeature> _targetFeature = edge.getTargetFeature();
        for (final ValuedFeature feature_1 : _targetFeature) {
          EObject _eContainer_2 = edge.eContainer();
          EObject _eContainer_3 = ((MutatorInstance) _eContainer_2).eContainer();
          features.addAll(this.getEStructuralFeatures(((MutatorDraw) _eContainer_3).getMetamodel(), feature_1.getFeat().getEType().getName()));
        }
      }
      scope.addAll(features);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Level_upper(final Level level, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = level.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), level.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Content_attName(final Content content, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = content.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), content.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_NodeEnumerator_att(final Content content, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = content.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), content.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Enumerator_literal(final NodeEnumerator nodenum, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EEnumLiteral> scope = new ArrayList<EEnumLiteral>();
      EObject _eContainer = nodenum.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getELiterals(((MutatorDraw) _eContainer_1).getMetamodel(), nodenum.getAtt().getEType().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Information_type(final Content content, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = content.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEReferences(((MutatorDraw) _eContainer_1).getMetamodel(), content.getName().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Information_att(final Information info, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = info.eContainer();
      EObject _eContainer_1 = ((MutatorInstance) _eContainer).eContainer();
      scope.addAll(this.getEAttributes(((MutatorDraw) _eContainer_1).getMetamodel(), info.getType().getEType().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * It returns the list of classes defined in a meta-model.
   * @param String file containing the metamodel
   * @return List<EClass>
   */
  private List<EClass> getEClassesSubpackages(final EPackage pck) {
    final List<EClass> classes = new ArrayList<EClass>();
    EList<EClassifier> _eClassifiers = pck.getEClassifiers();
    for (final EClassifier cl : _eClassifiers) {
      if ((cl instanceof EClass)) {
        classes.add(((EClass) cl));
      }
    }
    EList<EPackage> _eSubpackages = pck.getESubpackages();
    for (final EPackage spck : _eSubpackages) {
      {
        final List<EClass> classesSubpackage = this.getEClassesSubpackages(spck);
        for (final EClass cl_1 : classesSubpackage) {
          boolean _contains = classes.contains(cl_1);
          boolean _not = (!_contains);
          if (_not) {
            classes.add(cl_1);
          }
        }
      }
    }
    return classes;
  }

  /**
   * It returns the list of classes defined in a meta-model.
   * @param String file containing the metamodel
   * @return List<EClass>
   */
  private List<EClass> getEClasses(final String metamodelFile) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      final List<EClass> classes = new ArrayList<EClass>();
      for (final EPackage pck : metamodel) {
        {
          EList<EClassifier> _eClassifiers = pck.getEClassifiers();
          for (final EClassifier cl : _eClassifiers) {
            if ((cl instanceof EClass)) {
              classes.add(((EClass) cl));
            }
          }
          EList<EPackage> _eSubpackages = pck.getESubpackages();
          for (final EPackage spck : _eSubpackages) {
            {
              final List<EClass> classesSubpackage = this.getEClassesSubpackages(spck);
              for (final EClass cl_1 : classesSubpackage) {
                boolean _contains = classes.contains(cl_1);
                boolean _not = (!_contains);
                if (_not) {
                  classes.add(cl_1);
                }
              }
            }
          }
        }
      }
      return classes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It return the list of structural features of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EStructuralFeature> list of structural features
   */
  private List<EStructuralFeature> getEStructuralFeatures(final String metamodelFile, final String eclassName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      final ArrayList<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
      if ((eclass != null)) {
        features.addAll(eclass.getEAllStructuralFeatures());
        EList<EClass> _eSuperTypes = eclass.getESuperTypes();
        for (final EClass c : _eSuperTypes) {
          features.addAll(c.getEAllStructuralFeatures());
        }
      }
      return features;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It return the list of attributes of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EAttribute> list of attributes
   */
  private List<EAttribute> getEAttributes(final String metamodelFile, final String eclassName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      final ArrayList<EAttribute> atts = new ArrayList<EAttribute>();
      if ((eclass != null)) {
        atts.addAll(eclass.getEAllAttributes());
        EList<EClass> _eSuperTypes = eclass.getESuperTypes();
        for (final EClass c : _eSuperTypes) {
          atts.addAll(c.getEAllAttributes());
        }
      }
      return atts;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of references of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EReference>
   */
  private List<EReference> getEReferences(final String metamodelFile, final String eclassName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      final ArrayList<EReference> refs = new ArrayList<EReference>();
      if ((eclass != null)) {
        refs.addAll(eclass.getEAllReferences());
        EList<EClass> _eSuperTypes = eclass.getESuperTypes();
        for (final EClass c : _eSuperTypes) {
          refs.addAll(c.getEAllReferences());
        }
      }
      return refs;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of literals of a enum.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EReference>
   */
  private List<EEnumLiteral> getELiterals(final String metamodelFile, final String eenumName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eenumName, metamodel);
      final EEnum eenum = ((EEnum) _objectOfType);
      final ArrayList<EEnumLiteral> lits = new ArrayList<EEnumLiteral>();
      if ((eenum != null)) {
        lits.addAll(eenum.getELiterals());
      }
      return lits;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Gets the root EClass
   */
  public EClass getRootEClass(final List<EPackage> packages) {
    final List<EClass> eclasses = ModelManager.getEClasses(packages);
    for (final EClass eclass : eclasses) {
      boolean _isAbstract = eclass.isAbstract();
      boolean _equals = (_isAbstract == false);
      if (_equals) {
        final List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eclass));
        int _size = containerTypes.size();
        boolean _equals_1 = (_size == 0);
        if (_equals_1) {
          return eclass;
        }
      }
    }
    return null;
  }

  /**
   * It returns the list of root eclasses defined in a meta-model.
   * @param String file containing the metamodel
   * @return List<EClass>
   */
  private List<EClass> getRootEClassesSubpackages(final List<EPackage> subpackages) {
    final List<EClass> roots = new ArrayList<EClass>();
    for (final EPackage pck : subpackages) {
      {
        final List<EPackage> pcks = new ArrayList<EPackage>();
        pcks.add(pck);
        roots.add(this.getRootEClass(pcks));
        if (((pck.getESubpackages() != null) && (pck.getESubpackages().size() > 0))) {
          roots.addAll(this.getRootEClassesSubpackages(pck.getESubpackages()));
        }
      }
    }
    return roots;
  }

  /**
   * Gets the root EClass
   */
  public List<EClass> getRootEClasses(final String metamodelFile) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      final List<EClass> roots = new ArrayList<EClass>();
      roots.add(this.getRootEClass(metamodel));
      final List<EPackage> pcks = new ArrayList<EPackage>();
      pcks.addAll(metamodel);
      for (final EPackage pck : pcks) {
        if (((pck.getESubpackages() != null) && (pck.getESubpackages().size() > 0))) {
          roots.addAll(this.getRootEClassesSubpackages(pck.getESubpackages()));
        }
      }
      return roots;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
