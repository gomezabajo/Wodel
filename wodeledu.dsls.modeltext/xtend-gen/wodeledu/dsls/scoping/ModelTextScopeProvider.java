package wodeledu.dsls.scoping;

import java.util.ArrayList;
import java.util.List;
import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.ValuedFeature;
import modeltext.Variable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import wodel.utils.manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Scope provider for the modelText language.
 */
@SuppressWarnings("all")
public class ModelTextScopeProvider extends AbstractModelTextScopeProvider {
  public IScope scope_Element_type(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = element.eContainer();
      scope.addAll(this.getEClasses(((IdentifyElements) _eContainer).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Element_ref(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EClass _type = element.getType();
      boolean _tripleNotEquals = (_type != null);
      if (_tripleNotEquals) {
        EObject _eContainer = element.eContainer();
        scope.addAll(this.getEReferences(((IdentifyElements) _eContainer).getMetamodel(), element.getType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Variable_id(final Variable variable, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
      EReference _ref = variable.getRef();
      boolean _tripleEquals = (_ref == null);
      if (_tripleEquals) {
        EObject _eContainer = variable.eContainer().eContainer();
        EObject _eContainer_1 = variable.eContainer();
        scope.addAll(this.getEAttributes(((IdentifyElements) _eContainer).getMetamodel(), ((Element) _eContainer_1).getType().getName()));
      }
      EReference _ref_1 = variable.getRef();
      boolean _tripleNotEquals = (_ref_1 != null);
      if (_tripleNotEquals) {
        EObject _eContainer_2 = variable.eContainer().eContainer();
        EReference _ref_2 = variable.getRef();
        scope.addAll(this.getEAttributes(((IdentifyElements) _eContainer_2).getMetamodel(), ((EReference) _ref_2).getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_Variable_ref(final Variable variable, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = variable.eContainer().eContainer();
      EObject _eContainer_1 = variable.eContainer();
      scope.addAll(this.getEReferences(((IdentifyElements) _eContainer).getMetamodel(), ((Element) _eContainer_1).getType().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_feat(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      EObject _eContainer = element.eContainer();
      scope.addAll(this.getEStructuralFeatures(((IdentifyElements) _eContainer).getMetamodel(), element.getType().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_ValuedFeature_refFeature(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
      if (((element.getFeature() != null) && (element.getFeature().size() > 0))) {
        EList<ValuedFeature> _feature = element.getFeature();
        for (final ValuedFeature feature : _feature) {
          EObject _eContainer = element.eContainer();
          features.addAll(this.getEStructuralFeatures(((IdentifyElements) _eContainer).getMetamodel(), feature.getFeat().getEType().getName()));
        }
      }
      scope.addAll(features);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
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
        EList<EClassifier> _eClassifiers = pck.getEClassifiers();
        for (final EClassifier cl : _eClassifiers) {
          if ((cl instanceof EClass)) {
            classes.add(((EClass) cl));
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
      if ((eclass != null)) {
        return eclass.getEAllAttributes();
      } else {
        return new ArrayList<EAttribute>();
      }
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
      if ((eclass != null)) {
        return eclass.getEAllReferences();
      } else {
        return new ArrayList<EReference>();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
