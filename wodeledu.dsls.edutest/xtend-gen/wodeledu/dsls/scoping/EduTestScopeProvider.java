/**
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.scoping;

import edutest.MutatorTests;
import edutest.Program;
import edutest.TestConfiguration;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.Block;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osgi.framework.Bundle;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Scope provider for the eduTest language.
 */
@SuppressWarnings("all")
public class EduTestScopeProvider extends AbstractEduTestScopeProvider {
  /**
   * MutatorTests.block can refers to any block declared in the .mutator file.
   */
  public IScope scope_MutatorTests_block(final MutatorTests mts, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
        String _plus = ("file:/" + _workspaceAbsolutePath);
        String _plus_1 = (_plus + "/");
        String _name = ProjectUtils.getProject().getName();
        String _plus_2 = (_plus_1 + _name);
        String _plus_3 = (_plus_2 + "/");
        String _outputFolder = ModelManager.getOutputFolder();
        String _plus_4 = (_plus_3 + _outputFolder);
        String _plus_5 = (_plus_4 + "/");
        String _replaceAll = mts.eResource().getURI().lastSegment().replaceAll("test", "model");
        final String xmiFileName = (_plus_5 + _replaceAll);
        final Bundle bundle = Platform.getBundle("wodel.models");
        final URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
        final String ecore = FileLocator.resolve(fileURL).getFile();
        final List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
        final Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
        final List<EObject> eobjects = ModelManager.getObjectsOfType("Block", mutatormodel);
        List<Block> blocks = new ArrayList<Block>();
        for (final EObject eobject : eobjects) {
          blocks.add(((Block) eobject));
        }
        _xblockexpression = Scopes.scopeFor(blocks);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public IScope scope_TestConfiguration_statement(final TestConfiguration test, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = test.eContainer();
      EObject _eContainer_1 = ((MutatorTests) _eContainer).eContainer();
      scope.addAll(this.getRootEClasses(((Program) _eContainer_1).getMetamodel()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  public IScope scope_TestConfiguration_answers(final TestConfiguration test, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = test.eContainer();
      EObject _eContainer_1 = ((MutatorTests) _eContainer).eContainer();
      scope.addAll(this.getRootEClasses(((Program) _eContainer_1).getMetamodel()));
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
