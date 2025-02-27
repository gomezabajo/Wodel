package wodel.dsls.scoping;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.Constraint;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Definition;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomNumberType;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceAdd;
import mutatorenvironment.ReferenceAtt;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RemoveRandomReferenceMutator;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.Resource;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.TypedSelection;
import mutatorenvironment.miniOCL.CallExpCS;
import mutatorenvironment.miniOCL.ExpCS;
import mutatorenvironment.miniOCL.InvariantCS;
import mutatorenvironment.miniOCL.NameExpCS;
import mutatorenvironment.miniOCL.PathCS;
import mutatorenvironment.miniOCL.PathElementCS;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;

@SuppressWarnings("all")
public class WodelScopeProvider extends AbstractDeclarativeScopeProvider {
  /**
   * ObjectEmitter.type can contain any EClass from the input meta-model.
   * Except the RetypeObjectMutator that can contain any compatible EClass.
   */
  public IScope scope_ObjectEmitter_type(final ObjectEmitter obj, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(obj);
      final Definition definition = env.getDefinition();
      List<EClass> classes = null;
      if ((obj instanceof RetypeObjectMutator)) {
        final RetypeObjectMutator retypeObjectMutator = ((RetypeObjectMutator) obj);
        final EClass type = MutatorUtils.getStrategyType(retypeObjectMutator.getObject());
        classes = ModelManager.getSiblingEClasses(definition.getMetamodel(), type);
      } else {
        if (((obj instanceof RandomTypeSelection) && (obj.eContainer() instanceof SelectObjectMutator))) {
          ArrayList<EClass> _arrayList = new ArrayList<EClass>();
          classes = _arrayList;
          classes.addAll(this.getEClasses(definition));
        } else {
          classes = this.getEClasses(definition);
        }
      }
      _xblockexpression = Scopes.scopeFor(classes);
    }
    return _xblockexpression;
  }

  /**
   * ObjectEmitter.type can contain any EClass from the input meta-model.
   * Except the RetypeObjectMutator that can contain any compatible EClass.
   */
  public IScope scope_ObjectEmitter_types(final ObjectEmitter obj, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(obj);
      final Definition definition = env.getDefinition();
      List<EClass> classes = null;
      if ((obj instanceof RetypeObjectMutator)) {
        final RetypeObjectMutator retypeObjectMutator = ((RetypeObjectMutator) obj);
        List<EClass> types = MutatorUtils.getStrategyTypes(retypeObjectMutator.getObject());
        classes = ModelManager.getSiblingEClasses(definition.getMetamodel(), types);
      } else {
        if (((obj instanceof RandomTypeSelection) && (obj.eContainer() instanceof SelectObjectMutator))) {
          ArrayList<EClass> _arrayList = new ArrayList<EClass>();
          classes = _arrayList;
          classes.addAll(this.getEClasses(definition));
        } else {
          classes = this.getEClasses(definition);
        }
      }
      _xblockexpression = Scopes.scopeFor(classes);
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a specific object is used as a container,
   * can contain any previous object whose type is a container for the created object.
   */
  public IScope scope_SpecificObjectSelection_objSel(final ReferenceInit com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(((ReferenceSet) com));
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        String className = com.getReference().get(0).getEType().getName();
        final ArrayList<Mutator> scope = new ArrayList<Mutator>();
        if ((className != null)) {
          EObject _eContainer = com.eContainer();
          final List<Mutator> commands = this.getCommands(((Mutator) _eContainer));
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          List<String> classNames = new ArrayList<String>();
          List<EClass> classes = new ArrayList<EClass>();
          if ((eclass != null)) {
            classes.add(eclass);
          }
          classes.addAll(this.getESubClasses(definition, eclass));
          for (final EClass cl : classes) {
            boolean _contains = classNames.contains(cl.getName());
            boolean _not = (!_contains);
            if (_not) {
              classNames.add(cl.getName());
            }
          }
          for (final Mutator mutator : commands) {
            if (((((mutator.getName() != null) && 
              (commands.indexOf(mutator) < commands.indexOf(((Mutator) com.eContainer())))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
              classNames.contains(mutator.getType().getName()))) {
              scope.add(mutator);
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * CreateObjectMutator.container, when a specific object is used as a container,
   * can contain any previous object whose type is a container for the created object.
   */
  public IScope scope_SpecificObjectSelection_objSel(final CreateObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
        EClass eclass = ModelManager.getEClassByName(packages, com.getType().getName());
        if ((eclass == null)) {
          metamodel = this.getMetamodel(definition, com.getType().getName());
        }
        final List<String> resourceMM = this.getResourceMetamodels(definition);
        List<String> metamodels = new ArrayList<String>();
        metamodels.add(metamodel);
        metamodels.addAll(resourceMM);
        List<String> scontainers = new ArrayList<String>();
        for (final String mm : metamodels) {
          {
            final List<EClass> containers = this.getEContainers(mm, com.getType());
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
            final List<EReference> references = this.getEReferences(definition, com.getType().getName());
            for (final EReference eref : references) {
              scontainers.add(eref.getEType().getName());
            }
          }
        }
        final ArrayList<Mutator> scope = new ArrayList<Mutator>();
        for (final Mutator mutator : commands) {
          if (((((mutator.getName() != null) && 
            (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
            scontainers.contains(mutator.getType().getName()))) {
            scope.add(mutator);
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * SelectObjectMutator.container, when a specific object is used as a container,
   * can contain any previous object whose type is a container for the selected object.
   */
  public IScope scope_SpecificObjectSelection_objSel(final SelectObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
        EClass eclass = ModelManager.getEClassByName(packages, com.getType().getName());
        if ((eclass == null)) {
          metamodel = this.getMetamodel(definition, com.getType().getName());
        }
        final List<String> resourceMM = this.getResourceMetamodels(definition);
        List<String> metamodels = new ArrayList<String>();
        metamodels.add(metamodel);
        metamodels.addAll(resourceMM);
        List<String> scontainers = new ArrayList<String>();
        for (final String mm : metamodels) {
          {
            final List<EClass> containers = this.getEContainers(mm, com.getType());
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
          }
        }
        final ArrayList<Mutator> scope = new ArrayList<Mutator>();
        for (final Mutator mutator : commands) {
          if (((((mutator.getName() != null) && 
            (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
            scontainers.contains(mutator.getType().getName()))) {
            scope.add(mutator);
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * CreateObjectMutator.container, when a specific object is used as a container,
   * can contain any previous object whose type is a container for the created object.
   */
  public IScope scope_SpecificClosureSelection_objSel(final CreateObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
        EClass eclass = ModelManager.getEClassByName(packages, com.getType().getName());
        if ((eclass == null)) {
          metamodel = this.getMetamodel(definition, com.getType().getName());
        }
        final List<String> resourceMM = this.getResourceMetamodels(definition);
        List<String> metamodels = new ArrayList<String>();
        metamodels.add(metamodel);
        metamodels.addAll(resourceMM);
        List<String> scontainers = new ArrayList<String>();
        for (final String mm : metamodels) {
          {
            final List<EClass> containers = this.getEContainers(mm, com.getType());
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
            final List<EReference> references = this.getEReferences(definition, com.getType().getName());
            for (final EReference eref : references) {
              scontainers.add(eref.getEType().getName());
            }
          }
        }
        final ArrayList<Mutator> scope = new ArrayList<Mutator>();
        for (final Mutator mutator : commands) {
          if (((((mutator.getName() != null) && 
            (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
            scontainers.contains(mutator.getType().getName()))) {
            scope.add(mutator);
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * SelectObjectMutator.container, when a specific object is used as a container,
   * can contain any previous object whose type is a container for the selected object.
   */
  public IScope scope_SpecificClosureSelection_objSel(final SelectObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
        EClass eclass = ModelManager.getEClassByName(packages, com.getType().getName());
        if ((eclass == null)) {
          metamodel = this.getMetamodel(definition, com.getType().getName());
        }
        final List<String> resourceMM = this.getResourceMetamodels(definition);
        List<String> metamodels = new ArrayList<String>();
        metamodels.add(metamodel);
        metamodels.addAll(resourceMM);
        List<String> scontainers = new ArrayList<String>();
        for (final String mm : metamodels) {
          {
            final List<EClass> containers = this.getEContainers(mm, com.getType());
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
          }
        }
        final ArrayList<Mutator> scope = new ArrayList<Mutator>();
        for (final Mutator mutator : commands) {
          if (((((mutator.getName() != null) && 
            (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
            scontainers.contains(mutator.getType().getName()))) {
            scope.add(mutator);
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * CompleteTypeSelection.type can contain any EClass from the input meta-model.
   */
  public IScope scope_CompleteTypeSelection_type(final CompleteTypeSelection com, final EReference ref) {
    return this.anyTypeSelection(com);
  }

  /**
   * RandomTypeSelection.type can contain any EClass from the input meta-model.
   */
  public IScope scope_RandomTypeSelection_type(final RandomTypeSelection com, final EReference ref) {
    return this.anyTypeSelection(com);
  }

  /**
   * OtherTypeSelection.type can contain any EClass from the input meta-model.
   */
  public IScope scope_OtherTypeSelection_type(final OtherTypeSelection com, final EReference ref) {
    return this.anyTypeSelection(com);
  }

  /**
   * TypedSelection.type can contain any EClass from the input meta-model.
   */
  public IScope scope_TypeSelection_type(final TypedSelection com, final EReference ref) {
    return this.anyTypeSelection(com);
  }

  /**
   * Common implementation for methods scope_CompleteTypeSelection_type, scope_RandomTypeSelection_type and scope_OtherTypeSelection_type.
   */
  private IScope anyTypeSelection(final ObSelectionStrategy com) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        final ArrayList<EClass> scope = new ArrayList<EClass>();
        EObject _eContainer = com.eContainer();
        if ((_eContainer instanceof ModifyTargetReferenceMutator)) {
          EObject _eContainer_1 = com.eContainer();
          final ModifyTargetReferenceMutator mutator = ((ModifyTargetReferenceMutator) _eContainer_1);
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, mutator.getRefType().getName());
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, com.getType().getName());
          }
          ObSelectionStrategy _source = mutator.getSource();
          boolean _equals = Objects.equals(_source, com);
          if (_equals) {
            scope.addAll(this.getESources(definition, mutator.getRefType().getName()));
          } else {
            ObSelectionStrategy _newTarget = mutator.getNewTarget();
            boolean _equals_1 = Objects.equals(_newTarget, com);
            if (_equals_1) {
              scope.addAll(this.getETargets(definition, mutator.getRefType().getName()));
            }
          }
        } else {
          EObject _eContainer_2 = com.eContainer();
          if ((_eContainer_2 instanceof CreateReferenceMutator)) {
            EObject _eContainer_3 = com.eContainer();
            final CreateReferenceMutator mutator_1 = ((CreateReferenceMutator) _eContainer_3);
            List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
            EClass eclass_1 = ModelManager.getEClassByName(packages_1, mutator_1.getRefType().getName());
            if ((eclass_1 == null)) {
              metamodel = this.getMetamodel(definition, com.getType().getName());
            }
            ObSelectionStrategy _source_1 = mutator_1.getSource();
            boolean _equals_2 = Objects.equals(_source_1, com);
            if (_equals_2) {
              scope.addAll(this.getESources(definition, mutator_1.getRefType().getName()));
            } else {
              ObSelectionStrategy _target = mutator_1.getTarget();
              boolean _equals_3 = Objects.equals(_target, com);
              if (_equals_3) {
                scope.addAll(this.getETargets(definition, mutator_1.getRefType().getName()));
              }
            }
          } else {
            if (((((((com.eContainer() instanceof MutatorEnvironment) || 
              (com.eContainer() instanceof CreateObjectMutator)) || 
              (com.eContainer() instanceof SelectObjectMutator)) || 
              (com.eContainer() instanceof SelectSampleMutator)) || 
              (com.eContainer() instanceof CloneObjectMutator)) || 
              (com.eContainer() instanceof RetypeObjectMutator))) {
              List<EClass> classes = this.getEClasses(definition);
              scope.addAll(classes);
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * SpecificObjectSelection.objSel can contain any EClass from the input meta-model.
   */
  public IScope scope_SpecificObjectSelection_objSel(final SpecificObjectSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<Mutator> scope = new ArrayList<Mutator>();
      IScope _xifexpression = null;
      EObject _eContainer = com.eContainer();
      if ((_eContainer instanceof ModifyTargetReferenceMutator)) {
        IScope _xblockexpression_1 = null;
        {
          EObject _eContainer_1 = com.eContainer();
          final ModifyTargetReferenceMutator mutator = ((ModifyTargetReferenceMutator) _eContainer_1);
          final List<Mutator> commands = this.getCommands(mutator);
          IScope _xifexpression_1 = null;
          ObSelectionStrategy _source = mutator.getSource();
          boolean _equals = Objects.equals(_source, com);
          if (_equals) {
            IScope _xblockexpression_2 = null;
            {
              final List<EClass> containers = this.getESources(definition, mutator.getRefType().getName());
              final List<String> scontainers = new ArrayList<String>();
              for (final EClassifier cl : containers) {
                scontainers.add(cl.getName());
              }
              for (final Mutator c : commands) {
                if (((((c.getName() != null) && 
                  (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  scontainers.contains(c.getType().getName()))) {
                  scope.add(c);
                }
              }
              _xblockexpression_2 = Scopes.scopeFor(scope);
            }
            _xifexpression_1 = _xblockexpression_2;
          } else {
            IScope _xifexpression_2 = null;
            ObSelectionStrategy _newTarget = mutator.getNewTarget();
            boolean _equals_1 = Objects.equals(_newTarget, com);
            if (_equals_1) {
              IScope _xblockexpression_3 = null;
              {
                final List<EClass> containments = this.getETargets(definition, mutator.getRefType().getName());
                final List<String> scontainments = new ArrayList<String>();
                for (final EClassifier cl : containments) {
                  scontainments.add(cl.getName());
                }
                for (final Mutator c : commands) {
                  if (((((c.getName() != null) && 
                    (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                    scontainments.contains(c.getType().getName()))) {
                    scope.add(c);
                  }
                }
                _xblockexpression_3 = Scopes.scopeFor(scope);
              }
              _xifexpression_2 = _xblockexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        IScope _xifexpression_1 = null;
        EObject _eContainer_1 = com.eContainer();
        if ((_eContainer_1 instanceof CreateReferenceMutator)) {
          IScope _xblockexpression_2 = null;
          {
            EObject _eContainer_2 = com.eContainer();
            final CreateReferenceMutator mutator = ((CreateReferenceMutator) _eContainer_2);
            final List<Mutator> commands = this.getCommands(mutator);
            IScope _xifexpression_2 = null;
            ObSelectionStrategy _source = mutator.getSource();
            boolean _equals = Objects.equals(_source, com);
            if (_equals) {
              IScope _xblockexpression_3 = null;
              {
                final List<EClass> containers = this.getESources(definition, mutator.getRefType().getName());
                final List<String> scontainers = new ArrayList<String>();
                for (final EClassifier cl : containers) {
                  scontainers.add(cl.getName());
                }
                for (final Mutator c : commands) {
                  if (((((c.getName() != null) && 
                    (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                    scontainers.contains(c.getType().getName()))) {
                    scope.add(c);
                  }
                }
                _xblockexpression_3 = Scopes.scopeFor(scope);
              }
              _xifexpression_2 = _xblockexpression_3;
            } else {
              IScope _xifexpression_3 = null;
              ObSelectionStrategy _target = mutator.getTarget();
              boolean _equals_1 = Objects.equals(_target, com);
              if (_equals_1) {
                IScope _xblockexpression_4 = null;
                {
                  final List<EClass> containments = this.getETargets(definition, mutator.getRefType().getName());
                  final List<String> scontainments = new ArrayList<String>();
                  for (final EClassifier cl : containments) {
                    scontainments.add(cl.getName());
                  }
                  for (final Mutator c : commands) {
                    if (((((c.getName() != null) && 
                      (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                      scontainments.contains(c.getType().getName()))) {
                      scope.add(c);
                    }
                  }
                  _xblockexpression_4 = Scopes.scopeFor(scope);
                }
                _xifexpression_3 = _xblockexpression_4;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_2 = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * SpecificObjectSelection.objSel can contain any EClass from the input meta-model.
   */
  public IScope scope_SpecificClosureSelection_objSel(final SpecificClosureSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<Mutator> scope = new ArrayList<Mutator>();
      IScope _xifexpression = null;
      EObject _eContainer = com.eContainer();
      if ((_eContainer instanceof ModifyTargetReferenceMutator)) {
        IScope _xblockexpression_1 = null;
        {
          EObject _eContainer_1 = com.eContainer();
          final ModifyTargetReferenceMutator mutator = ((ModifyTargetReferenceMutator) _eContainer_1);
          final List<Mutator> commands = this.getCommands(mutator);
          IScope _xifexpression_1 = null;
          ObSelectionStrategy _source = mutator.getSource();
          boolean _equals = Objects.equals(_source, com);
          if (_equals) {
            IScope _xblockexpression_2 = null;
            {
              final List<EClass> containers = this.getESources(definition, mutator.getRefType().getName());
              final List<String> scontainers = new ArrayList<String>();
              for (final EClassifier cl : containers) {
                scontainers.add(cl.getName());
              }
              for (final Mutator c : commands) {
                if (((((c.getName() != null) && 
                  (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  scontainers.contains(c.getType().getName()))) {
                  scope.add(c);
                }
              }
              _xblockexpression_2 = Scopes.scopeFor(scope);
            }
            _xifexpression_1 = _xblockexpression_2;
          } else {
            IScope _xifexpression_2 = null;
            ObSelectionStrategy _newTarget = mutator.getNewTarget();
            boolean _equals_1 = Objects.equals(_newTarget, com);
            if (_equals_1) {
              IScope _xblockexpression_3 = null;
              {
                final List<EClass> containments = this.getETargets(definition, mutator.getRefType().getName());
                final List<String> scontainments = new ArrayList<String>();
                for (final EClassifier cl : containments) {
                  scontainments.add(cl.getName());
                }
                for (final Mutator c : commands) {
                  if (((((c.getName() != null) && 
                    (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                    scontainments.contains(c.getType().getName()))) {
                    scope.add(c);
                  }
                }
                _xblockexpression_3 = Scopes.scopeFor(scope);
              }
              _xifexpression_2 = _xblockexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        IScope _xifexpression_1 = null;
        EObject _eContainer_1 = com.eContainer();
        if ((_eContainer_1 instanceof CreateReferenceMutator)) {
          IScope _xblockexpression_2 = null;
          {
            EObject _eContainer_2 = com.eContainer();
            final CreateReferenceMutator mutator = ((CreateReferenceMutator) _eContainer_2);
            final List<Mutator> commands = this.getCommands(mutator);
            IScope _xifexpression_2 = null;
            ObSelectionStrategy _source = mutator.getSource();
            boolean _equals = Objects.equals(_source, com);
            if (_equals) {
              IScope _xblockexpression_3 = null;
              {
                final List<EClass> containers = this.getESources(definition, mutator.getRefType().getName());
                final List<String> scontainers = new ArrayList<String>();
                for (final EClassifier cl : containers) {
                  scontainers.add(cl.getName());
                }
                for (final Mutator c : commands) {
                  if (((((c.getName() != null) && 
                    (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                    scontainers.contains(c.getType().getName()))) {
                    scope.add(c);
                  }
                }
                _xblockexpression_3 = Scopes.scopeFor(scope);
              }
              _xifexpression_2 = _xblockexpression_3;
            } else {
              IScope _xifexpression_3 = null;
              ObSelectionStrategy _target = mutator.getTarget();
              boolean _equals_1 = Objects.equals(_target, com);
              if (_equals_1) {
                IScope _xblockexpression_4 = null;
                {
                  final List<EClass> containments = this.getETargets(definition, mutator.getRefType().getName());
                  final List<String> scontainments = new ArrayList<String>();
                  for (final EClassifier cl : containments) {
                    scontainments.add(cl.getName());
                  }
                  for (final Mutator c : commands) {
                    if (((((c.getName() != null) && 
                      (commands.indexOf(c) < commands.indexOf(mutator))) && ((((((c instanceof CreateObjectMutator) || (c instanceof SelectObjectMutator)) || (c instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                      scontainments.contains(c.getType().getName()))) {
                      scope.add(c);
                    }
                  }
                  _xblockexpression_4 = Scopes.scopeFor(scope);
                }
                _xifexpression_3 = _xblockexpression_4;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_2 = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_RandomTypeSelection_type(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_RandomTypeSelection_type(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_RandomTypeSelection_type(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_RandomTypeSelection_type(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_RandomTypeSelection_type(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_OtherTypeSelection_type(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_OtherTypeSelection_type(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_OtherTypeSelection_type(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_OtherTypeSelection_type(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_OtherTypeSelection_type(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_TypeSelection_type(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_TypeSelection_type(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_TypeSelection_type(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_TypeSelection_type(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_TypeSelection_type(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_RandomTypeSelection_types(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_RandomTypeSelection_types(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_RandomTypeSelection_types(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_RandomTypeSelection_types(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_RandomTypeSelection_types(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_OtherTypeSelection_types(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_OtherTypeSelection_types(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_OtherTypeSelection_types(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_OtherTypeSelection_types(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_OtherTypeSelection_types(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the created object.
   */
  public IScope scope_TypeSelection_types(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected object.
   */
  public IScope scope_TypeSelection_types(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the selected objects.
   */
  public IScope scope_TypeSelection_types(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the cloned object.
   */
  public IScope scope_TypeSelection_types(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.container, when a random type is used as a container,
   * can contain any EClass which is a container for the retyped object.
   */
  public IScope scope_TypeSelection_types(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEContainers(definition.getMetamodel(), com.getType()));
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CreateObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = null;
        ObSelectionStrategy _container_1 = com.getContainer();
        if ((_container_1 instanceof RandomTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_2 = com.getContainer();
        if ((_container_2 instanceof CompleteTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_3 = com.getContainer();
        if ((_container_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _container_4 = com.getContainer();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _container_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _container_5 = com.getContainer();
        if ((_container_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _container_6 = com.getContainer();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _container_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _container_7 = com.getContainer();
        if ((_container_7 instanceof TypedSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getType().getName()));
      } else {
        String className = com.getType().getName();
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CreateObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getContainer().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CreateObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getContainer().getRefRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceInit.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final ReferenceInit com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String className = null;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceInit.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final ReferenceInit com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getObject().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CreateObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final ReferenceInit com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getObject().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceAdd.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final ReferenceAdd com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String className = null;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceAdd.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final ReferenceAdd com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getObject().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceAdd.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final ReferenceAdd com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName, com.getObject().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceRemove.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final ReferenceRemove com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String className = null;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceRemove.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final ReferenceRemove com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceRemove.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final ReferenceRemove com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final ReferenceEvaluation refEv, final EReference ref) {
    IScope _xblockexpression = null;
    {
      EObject container = refEv.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      final List<EReference> scope = new ArrayList<EReference>();
      if ((container != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(((Mutator) container));
        final Definition definition = env.getDefinition();
        String className = null;
        ObSelectionStrategy _value = refEv.getValue();
        if ((_value instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _value_1 = refEv.getValue();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _value_1);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
          scope.addAll(this.getEReferences(definition, className));
        }
        ObSelectionStrategy _value_2 = refEv.getValue();
        if ((_value_2 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _value_3 = refEv.getValue();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _value_3);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
          scope.addAll(this.getEReferences(definition, className));
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final ReferenceEvaluation refEv, final EReference ref) {
    IScope _xblockexpression = null;
    {
      EObject container = refEv.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      final List<EReference> scope = new ArrayList<EReference>();
      if ((container != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(((Mutator) container));
        final Definition definition = env.getDefinition();
        scope.addAll(this.getEReferences(definition, refEv.getValue().getRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final ReferenceEvaluation refEv, final EReference ref) {
    IScope _xblockexpression = null;
    {
      EObject container = refEv.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      final List<EReference> scope = new ArrayList<EReference>();
      if ((container != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(((Mutator) container));
        final Definition definition = env.getDefinition();
        scope.addAll(this.getEReferences(definition, refEv.getValue().getRefRefType().getEType().getName()));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = null;
        ObSelectionStrategy _container_1 = com.getContainer();
        if ((_container_1 instanceof RandomTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_2 = com.getContainer();
        if ((_container_2 instanceof CompleteTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_3 = com.getContainer();
        if ((_container_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _container_4 = com.getContainer();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _container_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            sourceClassName = ((SelectObjectMutator) _objSel_2).getObject().getType().getName();
            ObjectEmitter _objSel_3 = selection.getObjSel();
            String _resource = ((SelectObjectMutator) _objSel_3).getObject().getResource();
            boolean _tripleNotEquals = (_resource != null);
            if (_tripleNotEquals) {
              ObjectEmitter _objSel_4 = selection.getObjSel();
              final String resourceName = ((SelectObjectMutator) _objSel_4).getObject().getResource();
              if ((definition instanceof Program)) {
                final Program program = ((Program) definition);
                Resource resource = null;
                EList<Resource> _resources = program.getResources();
                for (final Resource res : _resources) {
                  boolean _equals = res.getName().equals(resourceName);
                  if (_equals) {
                    resource = res;
                  }
                }
              }
            }
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_6 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_6));
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof CloneObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_8 = selection.getObjSel();
          if ((_objSel_8 instanceof RetypeObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_9 = selection.getObjSel();
          if ((_objSel_9 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_10 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_10));
          }
        }
        ObSelectionStrategy _container_5 = com.getContainer();
        if ((_container_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _container_6 = com.getContainer();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _container_6);
          ObjectEmitter _objSel_11 = selection_1.getObjSel();
          if ((_objSel_11 instanceof CreateObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_15 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_15));
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof CloneObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_17 = selection_1.getObjSel();
          if ((_objSel_17 instanceof RetypeObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_18 = selection_1.getObjSel();
          if ((_objSel_18 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_19 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_19));
          }
        }
        ObSelectionStrategy _container_7 = com.getContainer();
        if ((_container_7 instanceof TypedSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, sourceClassName));
      } else {
        String className = null;
        ObSelectionStrategy _object = com.getObject();
        if ((_object instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final SpecificObjectSelection selection_2 = ((SpecificObjectSelection) _object_3);
          ObjectEmitter _objSel_20 = selection_2.getObjSel();
          if ((_objSel_20 instanceof CreateObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_21 = selection_2.getObjSel();
          if ((_objSel_21 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_22 = selection_2.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_22));
          }
          ObjectEmitter _objSel_23 = selection_2.getObjSel();
          if ((_objSel_23 instanceof CloneObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_24 = selection_2.getObjSel();
          if ((_objSel_24 instanceof RetypeObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_25 = selection_2.getObjSel();
          if ((_objSel_25 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_26 = selection_2.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_26));
          }
        }
        ObSelectionStrategy _object_4 = com.getObject();
        if ((_object_4 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_5 = com.getObject();
          final SpecificClosureSelection selection_3 = ((SpecificClosureSelection) _object_5);
          ObjectEmitter _objSel_27 = selection_3.getObjSel();
          if ((_objSel_27 instanceof CreateObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_28 = selection_3.getObjSel();
          if ((_objSel_28 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_29 = selection_3.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_29));
          }
          ObjectEmitter _objSel_30 = selection_3.getObjSel();
          if ((_objSel_30 instanceof CloneObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_31 = selection_3.getObjSel();
          if ((_objSel_31 instanceof RetypeObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_32 = selection_3.getObjSel();
          if ((_objSel_32 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_33 = selection_3.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_33));
          }
        }
        ObSelectionStrategy _object_6 = com.getObject();
        if ((_object_6 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CloneObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = null;
        ObSelectionStrategy _container_1 = com.getContainer();
        if ((_container_1 instanceof RandomTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_2 = com.getContainer();
        if ((_container_2 instanceof CompleteTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_3 = com.getContainer();
        if ((_container_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _container_4 = com.getContainer();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _container_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _container_5 = com.getContainer();
        if ((_container_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _container_6 = com.getContainer();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _container_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _container_7 = com.getContainer();
        if ((_container_7 instanceof TypedSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, sourceClassName));
      } else {
        String className = null;
        ObSelectionStrategy _object = com.getObject();
        if ((_object instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final SpecificObjectSelection selection_2 = ((SpecificObjectSelection) _object_3);
          ObjectEmitter _objSel_18 = selection_2.getObjSel();
          if ((_objSel_18 instanceof CreateObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_19 = selection_2.getObjSel();
          if ((_objSel_19 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_20 = selection_2.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_20));
          }
          ObjectEmitter _objSel_21 = selection_2.getObjSel();
          if ((_objSel_21 instanceof CloneObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_22 = selection_2.getObjSel();
          if ((_objSel_22 instanceof RetypeObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_23 = selection_2.getObjSel();
          if ((_objSel_23 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_24 = selection_2.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_24));
          }
        }
        ObSelectionStrategy _object_4 = com.getObject();
        if ((_object_4 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_5 = com.getObject();
          final SpecificClosureSelection selection_3 = ((SpecificClosureSelection) _object_5);
          ObjectEmitter _objSel_25 = selection_3.getObjSel();
          if ((_objSel_25 instanceof CreateObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_26 = selection_3.getObjSel();
          if ((_objSel_26 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_27 = selection_3.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_27));
          }
          ObjectEmitter _objSel_28 = selection_3.getObjSel();
          if ((_objSel_28 instanceof CloneObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_29 = selection_3.getObjSel();
          if ((_objSel_29 instanceof RetypeObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_30 = selection_3.getObjSel();
          if ((_objSel_30 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_31 = selection_3.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_31));
          }
        }
        ObSelectionStrategy _object_6 = com.getObject();
        if ((_object_6 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CloneObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is CloneObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = null;
        ObSelectionStrategy _container_1 = com.getContainer();
        if ((_container_1 instanceof RandomTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_2 = com.getContainer();
        if ((_container_2 instanceof CompleteTypeSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        ObSelectionStrategy _container_3 = com.getContainer();
        if ((_container_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _container_4 = com.getContainer();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _container_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            sourceClassName = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _container_5 = com.getContainer();
        if ((_container_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _container_6 = com.getContainer();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _container_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            sourceClassName = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _container_7 = com.getContainer();
        if ((_container_7 instanceof TypedSelection)) {
          sourceClassName = com.getContainer().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, sourceClassName));
      } else {
        String className = null;
        ObSelectionStrategy _object = com.getObject();
        if ((_object instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final SpecificObjectSelection selection_2 = ((SpecificObjectSelection) _object_3);
          ObjectEmitter _objSel_18 = selection_2.getObjSel();
          if ((_objSel_18 instanceof CreateObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_19 = selection_2.getObjSel();
          if ((_objSel_19 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_20 = selection_2.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_20));
          }
          ObjectEmitter _objSel_21 = selection_2.getObjSel();
          if ((_objSel_21 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_22 = selection_2.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_22));
          }
          ObjectEmitter _objSel_23 = selection_2.getObjSel();
          if ((_objSel_23 instanceof CloneObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_24 = selection_2.getObjSel();
          if ((_objSel_24 instanceof RetypeObjectMutator)) {
            className = selection_2.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_25 = selection_2.getObjSel();
          if ((_objSel_25 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_26 = selection_2.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_26));
          }
        }
        ObSelectionStrategy _object_4 = com.getObject();
        if ((_object_4 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_5 = com.getObject();
          final SpecificClosureSelection selection_3 = ((SpecificClosureSelection) _object_5);
          ObjectEmitter _objSel_27 = selection_3.getObjSel();
          if ((_objSel_27 instanceof CreateObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_28 = selection_3.getObjSel();
          if ((_objSel_28 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_29 = selection_3.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_29));
          }
          ObjectEmitter _objSel_30 = selection_3.getObjSel();
          if ((_objSel_30 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_31 = selection_3.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_31));
          }
          ObjectEmitter _objSel_32 = selection_3.getObjSel();
          if ((_objSel_32 instanceof CloneObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_33 = selection_3.getObjSel();
          if ((_objSel_33 instanceof RetypeObjectMutator)) {
            className = selection_3.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_34 = selection_3.getObjSel();
          if ((_objSel_34 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_35 = selection_3.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_35));
          }
        }
        ObSelectionStrategy _object_6 = com.getObject();
        if ((_object_6 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _container = com.getContainer();
      if ((_container instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getContainer().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectSampleMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refType(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String className = null;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_4);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_7 = selection.getObjSel();
          if ((_objSel_7 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_8 = selection.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_8));
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_6);
          ObjectEmitter _objSel_9 = selection_1.getObjSel();
          if ((_objSel_9 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_13));
          }
          ObjectEmitter _objSel_14 = selection_1.getObjSel();
          if ((_objSel_14 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_15 = selection_1.getObjSel();
          if ((_objSel_15 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_16 = selection_1.getObjSel();
          if ((_objSel_16 instanceof ModifyInformationMutator)) {
            ObjectEmitter _objSel_17 = selection_1.getObjSel();
            className = MutatorUtils.selectModifyInformationMutatorHelperName(((ModifyInformationMutator) _objSel_17));
          }
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectSampleMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefType(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObSelectionStrategy.refType can contain any EReference defined by the
   * SelectedObject.eContainer whose type is SelectSampleMutator.type.
   */
  public IScope scope_ObSelectionStrategy_refRefRefType(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String sourceClassName = com.getObject().getRefRefType().getEType().getName();
        scope.addAll(this.getEReferences(definition, sourceClassName));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ModifySourceReferenceMutator.refType can contain any EReference in the metamodel.
   */
  public IScope scope_ModifySourceReferenceMutator_refType(final ModifySourceReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      scope.addAll(this.getEReferences(definition));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ModifyTargetReferenceMutator.refType can contain any EReference in the metamodel.
   */
  public IScope scope_ModifyTargetReferenceMutator_refType(final ModifyTargetReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      scope.addAll(this.getEReferences(definition));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * CreateReferenceMutator.refType can contain any EReference in the metamodel.
   */
  public IScope scope_CreateReferenceMutator_refType(final CreateReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EReference> scope = new ArrayList<EReference>();
      scope.addAll(this.getEReferences(definition));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.newSource, when a specific
   * object is used as from/to, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificObjectSelection_objSel(final ModifySourceReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final ArrayList<Mutator> scope = new ArrayList<Mutator>();
      final List<EClass> containers = this.getESources(definition, com.getRefType().getName());
      final List<String> scontainers = new ArrayList<String>();
      for (final EClassifier cl : containers) {
        scontainers.add(cl.getName());
      }
      for (final Mutator mutator : commands) {
        if (((((mutator.getName() != null) && 
          (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
          scontainers.contains(mutator.getType().getName()))) {
          scope.add(mutator);
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.newSource, when a specific
   * object is used as from/to, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificClosureSelection_objSel(final ModifySourceReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final ArrayList<Mutator> scope = new ArrayList<Mutator>();
      final List<EClass> containers = this.getESources(definition, com.getRefType().getName());
      final List<String> scontainers = new ArrayList<String>();
      for (final EClassifier cl : containers) {
        scontainers.add(cl.getName());
      }
      for (final Mutator mutator : commands) {
        if (((((mutator.getName() != null) && 
          (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
          scontainers.contains(mutator.getType().getName()))) {
          scope.add(mutator);
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.to, when a random
   * type is used as from/to, can contain any EClass which defines the modified reference.
   */
  public IScope scope_RandomTypeSelection_type(final ModifySourceReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getESources(definition, com.getRefType().getName()));
    }
    return _xblockexpression;
  }

  /**
   * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.to, when a random
   * type is used as from/to, can contain any EClass which defines the modified reference.
   */
  public IScope scope_TypeSelection_type(final ModifySourceReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getESources(definition, com.getRefType().getName()));
    }
    return _xblockexpression;
  }

  /**
   * Helper to get all the EClasses contained in the processed models.
   */
  private List<EClass> HelperRandomTypeSelectionModelEClasses(final Definition definition, final Program program) {
    final ArrayList<EClass> scope = new ArrayList<EClass>();
    boolean _endsWith = program.getSource().getPath().endsWith("/");
    boolean _not = (!_endsWith);
    if (_not) {
      scope.addAll(this.getModelEClasses(definition, program.getSource().getPath()));
    }
    boolean _endsWith_1 = program.getSource().getPath().endsWith("/");
    if (_endsWith_1) {
      String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
      String _plus = (_path + "/");
      String _path_1 = program.getSource().getPath();
      String _plus_1 = (_plus + _path_1);
      final File[] files = new File(_plus_1).listFiles();
      for (final File file : files) {
        boolean _isFile = file.isFile();
        boolean _equals = (_isFile == true);
        if (_equals) {
          boolean _endsWith_2 = file.getPath().endsWith(".model");
          boolean _equals_1 = (_endsWith_2 == true);
          if (_equals_1) {
            scope.addAll(this.getModelEClasses(definition, file.getPath()));
          }
        }
      }
      return scope;
    }
    return null;
  }

  /**
   * RemoveObjectMutator.object, when a random type is used.
   */
  public IScope scope_RandomTypeSelection_type(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final List<EClass> scope = this.HelperRandomTypeSelectionModelEClasses(definition, program);
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveObjectMutator.object, when a specific selection strategy is used.
   */
  public IScope scope_SpecificObjectSelection_objSel(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(commands);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveObjectMutator.object, when a specific closure selection strategy is used.
   */
  public IScope scope_SpecificClosureSelection_objSel(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(commands);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveObjectMutator.object, when a complete type selection is used.
   */
  public IScope scope_CompleteTypeSelection_type(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final List<EClass> scope = this.HelperRandomTypeSelectionModelEClasses(definition, program);
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveObjectMutator.object, when a complete type selection is used.
   */
  public IScope scope_TypeSelection_type(final RemoveObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final List<EClass> scope = this.HelperRandomTypeSelectionModelEClasses(definition, program);
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ObjectEmitter.type, when a specific selection type
   * is used, can be of any EClass defined in the meta-model.
   */
  public IScope scope_ObjectEmitter_type(final SpecificObjectSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ObjectEmitter.type, when a specific closure selection type
   * is used, can be of any EClass defined in the meta-model.
   */
  public IScope scope_ObjectEmitter_type(final SpecificClosureSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.object, when a specific
   * object is used, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificObjectSelection_objSel(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final ArrayList<Mutator> scope = new ArrayList<Mutator>();
          boolean _endsWith = ((Program)definition).getSource().getPath().endsWith("/");
          boolean _not = (!_endsWith);
          if (_not) {
            String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus = (_path + "/");
            String _path_1 = ((Program)definition).getSource().getPath();
            final String model = (_plus + _path_1);
            final List<EClass> classes = this.getModelEClasses(definition, model);
            final List<String> sclasses = new ArrayList<String>();
            for (final EClassifier cl : classes) {
              sclasses.add(cl.getName());
            }
            {
              final List<Mutator> objects = new ArrayList<Mutator>();
              for (final Mutator mutator : commands) {
                if (((((mutator.getName() != null) && 
                  (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  sclasses.contains(mutator.getType().getName()))) {
                  objects.add(mutator);
                }
              }
              scope.addAll(objects);
            }
          }
          boolean _endsWith_1 = ((Program)definition).getSource().getPath().endsWith("/");
          if (_endsWith_1) {
            final ArrayList<String> models = new ArrayList<String>();
            String _path_2 = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus_1 = (_path_2 + "/");
            String _path_3 = ((Program)definition).getSource().getPath();
            String _plus_2 = (_plus_1 + _path_3);
            final File[] files = new File(_plus_2).listFiles();
            for (final File file : files) {
              boolean _isFile = file.isFile();
              boolean _equals = (_isFile == true);
              if (_equals) {
                boolean _endsWith_2 = file.getPath().endsWith(".model");
                boolean _equals_1 = (_endsWith_2 == true);
                if (_equals_1) {
                  models.add(file.getPath());
                }
              }
            }
            final List<EClass> classes_1 = new ArrayList<EClass>();
            for (final String model_1 : models) {
              classes_1.addAll(this.getModelEClasses(definition, model_1));
            }
            final List<String> sclasses_1 = new ArrayList<String>();
            for (final EClassifier cl_1 : classes_1) {
              sclasses_1.add(cl_1.getName());
            }
            {
              final List<Mutator> objects = new ArrayList<Mutator>();
              for (final Mutator mutator : commands) {
                if (((((mutator.getName() != null) && 
                  (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  sclasses_1.contains(mutator.getType().getName()))) {
                  objects.add(mutator);
                }
              }
              scope.addAll(objects);
            }
          }
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.object, when a specific closure
   * object is used, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificClosureSelection_objSel(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final ArrayList<Mutator> scope = new ArrayList<Mutator>();
          boolean _endsWith = ((Program)definition).getSource().getPath().endsWith("/");
          boolean _not = (!_endsWith);
          if (_not) {
            String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus = (_path + "/");
            String _path_1 = ((Program)definition).getSource().getPath();
            final String model = (_plus + _path_1);
            final List<EClass> classes = this.getModelEClasses(definition, model);
            final List<String> sclasses = new ArrayList<String>();
            for (final EClassifier cl : classes) {
              sclasses.add(cl.getName());
            }
            {
              final List<Mutator> objects = new ArrayList<Mutator>();
              for (final Mutator mutator : commands) {
                if (((((mutator.getName() != null) && 
                  (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  sclasses.contains(mutator.getType().getName()))) {
                  objects.add(mutator);
                }
              }
              scope.addAll(objects);
            }
          }
          boolean _endsWith_1 = ((Program)definition).getSource().getPath().endsWith("/");
          if (_endsWith_1) {
            final ArrayList<String> models = new ArrayList<String>();
            String _path_2 = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus_1 = (_path_2 + "/");
            String _path_3 = ((Program)definition).getSource().getPath();
            String _plus_2 = (_plus_1 + _path_3);
            final File[] files = new File(_plus_2).listFiles();
            for (final File file : files) {
              boolean _isFile = file.isFile();
              boolean _equals = (_isFile == true);
              if (_equals) {
                boolean _endsWith_2 = file.getPath().endsWith(".model");
                boolean _equals_1 = (_endsWith_2 == true);
                if (_equals_1) {
                  models.add(file.getPath());
                }
              }
            }
            final List<EClass> classes_1 = new ArrayList<EClass>();
            for (final String model_1 : models) {
              classes_1.addAll(this.getModelEClasses(definition, model_1));
            }
            final List<String> sclasses_1 = new ArrayList<String>();
            for (final EClassifier cl_1 : classes_1) {
              sclasses_1.add(cl_1.getName());
            }
            {
              final List<Mutator> objects = new ArrayList<Mutator>();
              for (final Mutator mutator : commands) {
                if (((((mutator.getName() != null) && 
                  (commands.indexOf(mutator) < commands.indexOf(com))) && ((((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof SelectSampleMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                  sclasses_1.contains(mutator.getType().getName()))) {
                  objects.add(mutator);
                }
              }
              scope.addAll(objects);
            }
          }
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.type, when a random type is used.
   */
  public IScope scope_RandomTypeSelection_type(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.type, when a random type is used.
   */
  public IScope scope_TypeSelection_type(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveRandomReferenceMutator.refType.
   */
  public IScope scope_RemoveRandomReferenceMutator_refType(final RemoveRandomReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEReferences(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveRandomReferenceMutator.type.
   */
  public IScope scope_RemoveRandomReferenceMutator_type(final RemoveRandomReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * Helper to get all the EClasses contained in the processed models that contain a refTypeName reference.
   */
  private ArrayList<EClass> HelperRandomTypeSelectionModelESources(final Definition definition, final Program program, final String refTypeName) {
    final ArrayList<EClass> scope = new ArrayList<EClass>();
    boolean _endsWith = program.getSource().getPath().endsWith("/");
    boolean _not = (!_endsWith);
    if (_not) {
      scope.addAll(this.getModelEClasses(definition, program.getSource().getPath()));
    }
    boolean _endsWith_1 = program.getSource().getPath().endsWith("/");
    if (_endsWith_1) {
      String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
      String _plus = (_path + "/");
      String _path_1 = program.getSource().getPath();
      String _plus_1 = (_plus + _path_1);
      final File[] files = new File(_plus_1).listFiles();
      for (final File file : files) {
        boolean _isFile = file.isFile();
        boolean _equals = (_isFile == true);
        if (_equals) {
          boolean _endsWith_2 = file.getPath().endsWith(".model");
          boolean _equals_1 = (_endsWith_2 == true);
          if (_equals_1) {
            scope.addAll(this.getModelESources(definition, file.getPath(), refTypeName));
          }
        }
      }
      return scope;
    }
    return null;
  }

  /**
   * RemoveRandomReferenceMutator.container, when a random
   * type is used, can contain any EClass which defines the modified reference.
   */
  public IScope scope_RandomTypeSelection_type(final RemoveRandomReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final ArrayList<EClass> scope = this.HelperRandomTypeSelectionModelESources(definition, program, com.getRefType().getName());
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveRandomReferenceMutator.container, when a random
   * type is used, can contain any EClass which defines the modified reference.
   */
  public IScope scope_TypeSelection_type(final RemoveRandomReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final ArrayList<EClass> scope = this.HelperRandomTypeSelectionModelESources(definition, program, com.getRefType().getName());
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveCompleteReferenceMutator.refType.
   */
  public IScope scope_RemoveCompleteReferenceMutator_refType(final RemoveCompleteReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final ArrayList<EReference> scope = new ArrayList<EReference>();
          scope.addAll(this.getEReferences(definition));
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveCompleteReferenceMutator.type.
   */
  public IScope scope_RemoveCompleteReferenceMutator_type(final RemoveCompleteReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveCompleteReferenceMutator.container, when a random
   * type is used, can contain any EClass which defines the modified reference.
   */
  public IScope scope_RandomTypeSelection_type(final RemoveCompleteReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final ArrayList<EClass> scope = this.HelperRandomTypeSelectionModelESources(definition, program, com.getRefType().getName());
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveCompleteReferenceMutator.container, when a random
   * type is used, can contain any EClass which defines the modified reference.
   */
  public IScope scope_TypeSelection_type(final RemoveCompleteReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final Program program = ((Program) definition);
          final ArrayList<EClass> scope = this.HelperRandomTypeSelectionModelESources(definition, program, com.getRefType().getName());
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveSpecificReferenceMutatorMutator.refType.
   */
  public IScope scope_RemoveSpecificReferenceMutator_refType(final RemoveSpecificReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEReferences(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveSpecificReferenceMutator.container.
   */
  public IScope scope_RemoveSpecificReferenceMutator_container(final RemoveSpecificReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        _xifexpression = Scopes.scopeFor(this.getEClasses(definition));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveSpecificReferenceMutator.container, when a specific
   * object is used, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificObjectSelection_objSel(final RemoveSpecificReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final ArrayList<Mutator> scope = new ArrayList<Mutator>();
          boolean _endsWith = ((Program)definition).getSource().getPath().endsWith("/");
          boolean _not = (!_endsWith);
          if (_not) {
            String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus = (_path + "/");
            String _path_1 = ((Program)definition).getSource().getPath();
            final String model = (_plus + _path_1);
            final List<EClass> containers = this.getModelESources(definition, model, com.getRefType().getName());
            final List<String> scontainers = new ArrayList<String>();
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
            final List<Mutator> objects = new ArrayList<Mutator>();
            for (final Mutator mutator : commands) {
              if (((((mutator.getName() != null) && 
                (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                scontainers.contains(mutator.getType().getName()))) {
                objects.add(mutator);
              }
            }
            scope.addAll(objects);
          }
          boolean _endsWith_1 = ((Program)definition).getSource().getPath().endsWith("/");
          if (_endsWith_1) {
            final ArrayList<String> models = new ArrayList<String>();
            String _path_2 = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus_1 = (_path_2 + "/");
            String _path_3 = ((Program)definition).getSource().getPath();
            String _plus_2 = (_plus_1 + _path_3);
            final File[] files = new File(_plus_2).listFiles();
            for (final File file : files) {
              boolean _isFile = file.isFile();
              boolean _equals = (_isFile == true);
              if (_equals) {
                boolean _endsWith_2 = file.getPath().endsWith(".model");
                boolean _equals_1 = (_endsWith_2 == true);
                if (_equals_1) {
                  models.add(file.getPath());
                }
              }
            }
            final List<EClass> containers_1 = new ArrayList<EClass>();
            for (final String model_1 : models) {
              containers_1.addAll(this.getModelESources(definition, model_1, com.getRefType().getName()));
            }
            final List<String> scontainers_1 = new ArrayList<String>();
            for (final EClassifier cl_1 : containers_1) {
              scontainers_1.add(cl_1.getName());
            }
            final List<Mutator> objects_1 = new ArrayList<Mutator>();
            for (final Mutator mutator_1 : commands) {
              if (((((mutator_1.getName() != null) && 
                (commands.indexOf(mutator_1) < commands.indexOf(com))) && (((((mutator_1 instanceof CreateObjectMutator) || (mutator_1 instanceof SelectObjectMutator)) || (mutator_1 instanceof ModifyInformationMutator)) || (mutator_1 instanceof CloneObjectMutator)) || (mutator_1 instanceof RetypeObjectMutator))) && 
                scontainers_1.contains(mutator_1.getType().getName()))) {
                objects_1.add(mutator_1);
              }
            }
            scope.addAll(objects_1);
          }
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * RemoveSpecificReferenceMutator.container, when a specific closure
   * object is used, can contain any previous object defining the modified reference.
   */
  public IScope scope_SpecificClosureSelection_objSel(final RemoveSpecificReferenceMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      IScope _xifexpression = null;
      if ((definition instanceof Program)) {
        IScope _xblockexpression_1 = null;
        {
          final ArrayList<Mutator> scope = new ArrayList<Mutator>();
          boolean _endsWith = ((Program)definition).getSource().getPath().endsWith("/");
          boolean _not = (!_endsWith);
          if (_not) {
            String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus = (_path + "/");
            String _path_1 = ((Program)definition).getSource().getPath();
            final String model = (_plus + _path_1);
            final List<EClass> containers = this.getModelESources(definition, model, com.getRefType().getName());
            final List<String> scontainers = new ArrayList<String>();
            for (final EClassifier cl : containers) {
              scontainers.add(cl.getName());
            }
            final List<Mutator> objects = new ArrayList<Mutator>();
            for (final Mutator mutator : commands) {
              if (((((mutator.getName() != null) && 
                (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
                scontainers.contains(mutator.getType().getName()))) {
                objects.add(mutator);
              }
            }
            scope.addAll(objects);
          }
          boolean _endsWith_1 = ((Program)definition).getSource().getPath().endsWith("/");
          if (_endsWith_1) {
            final ArrayList<String> models = new ArrayList<String>();
            String _path_2 = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus_1 = (_path_2 + "/");
            String _path_3 = ((Program)definition).getSource().getPath();
            String _plus_2 = (_plus_1 + _path_3);
            final File[] files = new File(_plus_2).listFiles();
            for (final File file : files) {
              boolean _isFile = file.isFile();
              boolean _equals = (_isFile == true);
              if (_equals) {
                boolean _endsWith_2 = file.getPath().endsWith(".model");
                boolean _equals_1 = (_endsWith_2 == true);
                if (_equals_1) {
                  models.add(file.getPath());
                }
              }
            }
            final List<EClass> containers_1 = new ArrayList<EClass>();
            for (final String model_1 : models) {
              containers_1.addAll(this.getModelESources(definition, model_1, com.getRefType().getName()));
            }
            final List<String> scontainers_1 = new ArrayList<String>();
            for (final EClassifier cl_1 : containers_1) {
              scontainers_1.add(cl_1.getName());
            }
            final List<Mutator> objects_1 = new ArrayList<Mutator>();
            for (final Mutator mutator_1 : commands) {
              if (((((mutator_1.getName() != null) && 
                (commands.indexOf(mutator_1) < commands.indexOf(com))) && (((((mutator_1 instanceof CreateObjectMutator) || (mutator_1 instanceof SelectObjectMutator)) || (mutator_1 instanceof ModifyInformationMutator)) || (mutator_1 instanceof CloneObjectMutator)) || (mutator_1 instanceof RetypeObjectMutator))) && 
                scontainers_1.contains(mutator_1.getType().getName()))) {
                objects_1.add(mutator_1);
              }
            }
            scope.addAll(objects_1);
          }
          _xblockexpression_1 = Scopes.scopeFor(scope);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * CreateObjectMutator.attributes must contain attributes of the CreateObjetMutator.type type.
   */
  public IScope scope_AttributeSet_attribute(final CreateObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        String className = com.getType().getName();
        List<EAttribute> attributes = this.getEAttributes(definition, className);
        int _size = com.getAttributes().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          EList<AttributeSet> _attributes = com.getAttributes();
          for (final AttributeSet attSet : _attributes) {
            {
              if ((attSet instanceof AttributeScalar)) {
                attributes.addAll(this.getEAttributes(definition, className));
              }
              if ((attSet instanceof AttributeCopy)) {
                ObSelectionStrategy _object = ((AttributeCopy) attSet).getObject();
                if ((_object instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _object_1 = ((AttributeCopy) attSet).getObject();
                  final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_1);
                  ObjectEmitter _objSel = sel.getObjSel();
                  if ((_objSel instanceof SelectObjectMutator)) {
                    ObjectEmitter _objSel_1 = sel.getObjSel();
                    ObSelectionStrategy _object_2 = ((SelectObjectMutator) _objSel_1).getObject();
                    if ((_object_2 instanceof RandomTypeSelection)) {
                      ObjectEmitter _objSel_2 = sel.getObjSel();
                      ObSelectionStrategy _object_3 = ((SelectObjectMutator) _objSel_2).getObject();
                      final RandomTypeSelection strategy = ((RandomTypeSelection) _object_3);
                      className = strategy.getType().getName();
                      List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                      EClass eclass = ModelManager.getEClassByName(packages, className);
                      if ((eclass == null)) {
                        metamodel = this.getMetamodel(definition, className);
                      }
                      attributes.addAll(this.getEAttributes(definition, className));
                    }
                  }
                }
              }
              if ((attSet instanceof AttributeSwap)) {
                ObSelectionStrategy _object_4 = ((AttributeSwap) attSet).getObject();
                if ((_object_4 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _object_5 = ((AttributeSwap) attSet).getObject();
                  final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_5);
                  ObjectEmitter _objSel_3 = sel_1.getObjSel();
                  if ((_objSel_3 instanceof SelectObjectMutator)) {
                    ObjectEmitter _objSel_4 = sel_1.getObjSel();
                    ObSelectionStrategy _object_6 = ((SelectObjectMutator) _objSel_4).getObject();
                    if ((_object_6 instanceof RandomTypeSelection)) {
                      ObjectEmitter _objSel_5 = sel_1.getObjSel();
                      ObSelectionStrategy _object_7 = ((SelectObjectMutator) _objSel_5).getObject();
                      final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_7);
                      className = strategy_1.getType().getName();
                      List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                      EClass eclass_1 = ModelManager.getEClassByName(packages_1, className);
                      if ((eclass_1 == null)) {
                        metamodel = this.getMetamodel(definition, className);
                      }
                      attributes.addAll(this.getEAttributes(definition, className));
                    }
                  }
                }
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(attributes);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * CreateObjectMutator.references must contain references of the CreateObjetMutator.type type.
   */
  public IScope scope_ReferenceSet_reference(final CreateObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEReferences(definition, com.getType().getName()));
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.attributes must contain attributes of the ModifyInformationMutator.object type.
   */
  public IScope scope_AttributeSet_attribute(final ModifyInformationMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
        ObSelectionStrategy _object = com.getObject();
        if ((_object instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_1 = com.getObject();
          final String name = ((SpecificObjectSelection) _object_1).getObjSel().getName();
          Mutator command = this.getCommand(name, commands, commands.indexOf(com));
          if ((command != null)) {
            scope.addAll(this.getEAttributes(definition, this.getType(command)));
            String className = "";
            int _size = com.getAttributes().size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              EList<AttributeSet> _attributes = com.getAttributes();
              for (final AttributeSet attSet : _attributes) {
                {
                  if ((attSet instanceof AttributeScalar)) {
                    ObSelectionStrategy _object_2 = com.getObject();
                    if ((_object_2 instanceof RandomTypeSelection)) {
                      ObSelectionStrategy _object_3 = com.getObject();
                      RandomTypeSelection strategy = ((RandomTypeSelection) _object_3);
                      EClass type = strategy.getType();
                      scope.addAll(this.getEAttributes(definition, type.getName()));
                    }
                  }
                  if ((attSet instanceof AttributeCopy)) {
                    ObSelectionStrategy _object_4 = ((AttributeCopy) attSet).getObject();
                    if ((_object_4 instanceof SpecificObjectSelection)) {
                      ObSelectionStrategy _object_5 = ((AttributeCopy) attSet).getObject();
                      final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_5);
                      ObjectEmitter _objSel = sel.getObjSel();
                      if ((_objSel instanceof SelectObjectMutator)) {
                        ObjectEmitter _objSel_1 = sel.getObjSel();
                        ObSelectionStrategy _object_6 = ((SelectObjectMutator) _objSel_1).getObject();
                        if ((_object_6 instanceof RandomTypeSelection)) {
                          ObjectEmitter _objSel_2 = sel.getObjSel();
                          ObSelectionStrategy _object_7 = ((SelectObjectMutator) _objSel_2).getObject();
                          final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_7);
                          className = strategy_1.getType().getName();
                          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                          EClass eclass = ModelManager.getEClassByName(packages, className);
                          if ((eclass == null)) {
                            metamodel = this.getMetamodel(definition, className);
                          }
                          scope.addAll(this.getEAttributes(definition, className));
                        }
                      }
                    }
                  }
                  if ((attSet instanceof AttributeSwap)) {
                    ObSelectionStrategy _object_8 = ((AttributeSwap) attSet).getObject();
                    if ((_object_8 instanceof SpecificObjectSelection)) {
                      ObSelectionStrategy _object_9 = ((AttributeSwap) attSet).getObject();
                      final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_9);
                      ObjectEmitter _objSel_3 = sel_1.getObjSel();
                      if ((_objSel_3 instanceof SelectObjectMutator)) {
                        ObjectEmitter _objSel_4 = sel_1.getObjSel();
                        ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_4).getObject();
                        if ((_object_10 instanceof RandomTypeSelection)) {
                          ObjectEmitter _objSel_5 = sel_1.getObjSel();
                          ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_5).getObject();
                          final RandomTypeSelection strategy_2 = ((RandomTypeSelection) _object_11);
                          className = strategy_2.getType().getName();
                          List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                          EClass eclass_1 = ModelManager.getEClassByName(packages_1, className);
                          if ((eclass_1 == null)) {
                            metamodel = this.getMetamodel(definition, className);
                          }
                          scope.addAll(this.getEAttributes(definition, className));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        } else {
          ObSelectionStrategy _object_2 = com.getObject();
          if ((_object_2 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_3 = com.getObject();
            final String name_1 = ((SpecificClosureSelection) _object_3).getObjSel().getName();
            Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(com));
            if ((command_1 != null)) {
              scope.addAll(this.getEAttributes(definition, this.getType(command_1)));
              String className_1 = "";
              int _size_1 = com.getAttributes().size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                EList<AttributeSet> _attributes_1 = com.getAttributes();
                for (final AttributeSet attSet_1 : _attributes_1) {
                  {
                    if ((attSet_1 instanceof AttributeCopy)) {
                      ObSelectionStrategy _object_4 = ((AttributeCopy) attSet_1).getObject();
                      if ((_object_4 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_5 = ((AttributeCopy) attSet_1).getObject();
                        final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_5);
                        ObjectEmitter _objSel = sel.getObjSel();
                        if ((_objSel instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_1 = sel.getObjSel();
                          ObSelectionStrategy _object_6 = ((SelectObjectMutator) _objSel_1).getObject();
                          if ((_object_6 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_2 = sel.getObjSel();
                            ObSelectionStrategy _object_7 = ((SelectObjectMutator) _objSel_2).getObject();
                            final RandomTypeSelection strategy = ((RandomTypeSelection) _object_7);
                            className_1 = strategy.getType().getName();
                            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                            EClass eclass = ModelManager.getEClassByName(packages, className_1);
                            if ((eclass == null)) {
                              metamodel = this.getMetamodel(definition, className_1);
                            }
                            scope.addAll(this.getEAttributes(definition, className_1));
                          }
                        }
                      }
                    }
                    if ((attSet_1 instanceof AttributeSwap)) {
                      ObSelectionStrategy _object_8 = ((AttributeSwap) attSet_1).getObject();
                      if ((_object_8 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_9 = ((AttributeSwap) attSet_1).getObject();
                        final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_9);
                        ObjectEmitter _objSel_3 = sel_1.getObjSel();
                        if ((_objSel_3 instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_4 = sel_1.getObjSel();
                          ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_4).getObject();
                          if ((_object_10 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_5 = sel_1.getObjSel();
                            ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_5).getObject();
                            final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_11);
                            className_1 = strategy_1.getType().getName();
                            List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                            EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_1);
                            if ((eclass_1 == null)) {
                              metamodel = this.getMetamodel(definition, className_1);
                            }
                            scope.addAll(this.getEAttributes(definition, className_1));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          } else {
            ObSelectionStrategy _object_4 = com.getObject();
            if ((_object_4 instanceof CompleteTypeSelection)) {
              ObSelectionStrategy _object_5 = com.getObject();
              final String name_2 = ((CompleteTypeSelection) _object_5).getType().getName();
              scope.addAll(this.getEAttributes(definition, name_2));
              String className_2 = "";
              int _size_2 = com.getAttributes().size();
              boolean _greaterThan_2 = (_size_2 > 0);
              if (_greaterThan_2) {
                EList<AttributeSet> _attributes_2 = com.getAttributes();
                for (final AttributeSet attSet_2 : _attributes_2) {
                  {
                    if ((attSet_2 instanceof AttributeCopy)) {
                      ObSelectionStrategy _object_6 = ((AttributeCopy) attSet_2).getObject();
                      if ((_object_6 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_7 = ((AttributeCopy) attSet_2).getObject();
                        final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_7);
                        ObjectEmitter _objSel = sel.getObjSel();
                        if ((_objSel instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_1 = sel.getObjSel();
                          ObSelectionStrategy _object_8 = ((SelectObjectMutator) _objSel_1).getObject();
                          if ((_object_8 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_2 = sel.getObjSel();
                            ObSelectionStrategy _object_9 = ((SelectObjectMutator) _objSel_2).getObject();
                            final RandomTypeSelection strategy = ((RandomTypeSelection) _object_9);
                            className_2 = strategy.getType().getName();
                            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                            EClass eclass = ModelManager.getEClassByName(packages, className_2);
                            if ((eclass == null)) {
                              metamodel = this.getMetamodel(definition, className_2);
                            }
                            scope.addAll(this.getEAttributes(definition, className_2));
                          }
                        }
                      }
                    }
                    if ((attSet_2 instanceof AttributeSwap)) {
                      ObSelectionStrategy _object_10 = ((AttributeSwap) attSet_2).getObject();
                      if ((_object_10 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_11 = ((AttributeSwap) attSet_2).getObject();
                        final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_11);
                        ObjectEmitter _objSel_3 = sel_1.getObjSel();
                        if ((_objSel_3 instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_4 = sel_1.getObjSel();
                          ObSelectionStrategy _object_12 = ((SelectObjectMutator) _objSel_4).getObject();
                          if ((_object_12 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_5 = sel_1.getObjSel();
                            ObSelectionStrategy _object_13 = ((SelectObjectMutator) _objSel_5).getObject();
                            final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_13);
                            className_2 = strategy_1.getType().getName();
                            List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                            EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_2);
                            if ((eclass_1 == null)) {
                              metamodel = this.getMetamodel(definition, className_2);
                            }
                            scope.addAll(this.getEAttributes(definition, className_2));
                          }
                        }
                      }
                    }
                  }
                }
              }
            } else {
              ObSelectionStrategy _object_6 = com.getObject();
              if ((_object_6 instanceof RandomTypeSelection)) {
                ObSelectionStrategy _object_7 = com.getObject();
                final String name_3 = ((RandomTypeSelection) _object_7).getType().getName();
                scope.addAll(this.getEAttributes(definition, name_3));
                String className_3 = "";
                int _size_3 = com.getAttributes().size();
                boolean _greaterThan_3 = (_size_3 > 0);
                if (_greaterThan_3) {
                  EList<AttributeSet> _attributes_3 = com.getAttributes();
                  for (final AttributeSet attSet_3 : _attributes_3) {
                    {
                      if ((attSet_3 instanceof AttributeCopy)) {
                        ObSelectionStrategy _object_8 = ((AttributeCopy) attSet_3).getObject();
                        if ((_object_8 instanceof SpecificObjectSelection)) {
                          ObSelectionStrategy _object_9 = ((AttributeCopy) attSet_3).getObject();
                          final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_9);
                          ObjectEmitter _objSel = sel.getObjSel();
                          if ((_objSel instanceof SelectObjectMutator)) {
                            ObjectEmitter _objSel_1 = sel.getObjSel();
                            ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_1).getObject();
                            if ((_object_10 instanceof RandomTypeSelection)) {
                              ObjectEmitter _objSel_2 = sel.getObjSel();
                              ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_2).getObject();
                              final RandomTypeSelection strategy = ((RandomTypeSelection) _object_11);
                              className_3 = strategy.getType().getName();
                              List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                              EClass eclass = ModelManager.getEClassByName(packages, className_3);
                              if ((eclass == null)) {
                                metamodel = this.getMetamodel(definition, className_3);
                              }
                              scope.addAll(this.getEAttributes(definition, className_3));
                            }
                          }
                        }
                      }
                      if ((attSet_3 instanceof AttributeSwap)) {
                        ObSelectionStrategy _object_12 = ((AttributeSwap) attSet_3).getObject();
                        if ((_object_12 instanceof SpecificObjectSelection)) {
                          ObSelectionStrategy _object_13 = ((AttributeSwap) attSet_3).getObject();
                          final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_13);
                          ObjectEmitter _objSel_3 = sel_1.getObjSel();
                          if ((_objSel_3 instanceof SelectObjectMutator)) {
                            ObjectEmitter _objSel_4 = sel_1.getObjSel();
                            ObSelectionStrategy _object_14 = ((SelectObjectMutator) _objSel_4).getObject();
                            if ((_object_14 instanceof RandomTypeSelection)) {
                              ObjectEmitter _objSel_5 = sel_1.getObjSel();
                              ObSelectionStrategy _object_15 = ((SelectObjectMutator) _objSel_5).getObject();
                              final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_15);
                              className_3 = strategy_1.getType().getName();
                              List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                              EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_3);
                              if ((eclass_1 == null)) {
                                metamodel = this.getMetamodel(definition, className_3);
                              }
                              scope.addAll(this.getEAttributes(definition, className_3));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              } else {
                ObSelectionStrategy _object_8 = com.getObject();
                if ((_object_8 instanceof TypedSelection)) {
                  ObSelectionStrategy _object_9 = com.getObject();
                  final String name_4 = ((TypedSelection) _object_9).getType().getName();
                  scope.addAll(this.getEAttributes(definition, name_4));
                  {
                    String className_4 = "";
                    int _size_4 = com.getAttributes().size();
                    boolean _greaterThan_4 = (_size_4 > 0);
                    if (_greaterThan_4) {
                      EList<AttributeSet> _attributes_4 = com.getAttributes();
                      for (final AttributeSet attSet_4 : _attributes_4) {
                        {
                          if ((attSet_4 instanceof AttributeCopy)) {
                            ObSelectionStrategy _object_10 = ((AttributeCopy) attSet_4).getObject();
                            if ((_object_10 instanceof SpecificObjectSelection)) {
                              ObSelectionStrategy _object_11 = ((AttributeCopy) attSet_4).getObject();
                              final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_11);
                              ObjectEmitter _objSel = sel.getObjSel();
                              if ((_objSel instanceof SelectObjectMutator)) {
                                ObjectEmitter _objSel_1 = sel.getObjSel();
                                ObSelectionStrategy _object_12 = ((SelectObjectMutator) _objSel_1).getObject();
                                if ((_object_12 instanceof RandomTypeSelection)) {
                                  ObjectEmitter _objSel_2 = sel.getObjSel();
                                  ObSelectionStrategy _object_13 = ((SelectObjectMutator) _objSel_2).getObject();
                                  final RandomTypeSelection strategy = ((RandomTypeSelection) _object_13);
                                  className_4 = strategy.getType().getName();
                                  List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                                  EClass eclass = ModelManager.getEClassByName(packages, className_4);
                                  if ((eclass == null)) {
                                    metamodel = this.getMetamodel(definition, className_4);
                                  }
                                  scope.addAll(this.getEAttributes(definition, className_4));
                                }
                              }
                            }
                          }
                          if ((attSet_4 instanceof AttributeSwap)) {
                            ObSelectionStrategy _object_14 = ((AttributeSwap) attSet_4).getObject();
                            if ((_object_14 instanceof SpecificObjectSelection)) {
                              ObSelectionStrategy _object_15 = ((AttributeSwap) attSet_4).getObject();
                              final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_15);
                              ObjectEmitter _objSel_3 = sel_1.getObjSel();
                              if ((_objSel_3 instanceof SelectObjectMutator)) {
                                ObjectEmitter _objSel_4 = sel_1.getObjSel();
                                ObSelectionStrategy _object_16 = ((SelectObjectMutator) _objSel_4).getObject();
                                if ((_object_16 instanceof RandomTypeSelection)) {
                                  ObjectEmitter _objSel_5 = sel_1.getObjSel();
                                  ObSelectionStrategy _object_17 = ((SelectObjectMutator) _objSel_5).getObject();
                                  final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_17);
                                  className_4 = strategy_1.getType().getName();
                                  List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                                  EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_4);
                                  if ((eclass_1 == null)) {
                                    metamodel = this.getMetamodel(definition, className_4);
                                  }
                                  scope.addAll(this.getEAttributes(definition, className_4));
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
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ModifyInformationMutator.references must contain references of the ModifyInformationMutator.type type.
   */
  public IScope scope_ReferenceSet_reference(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_1 = com.getObject();
        final String name = ((SpecificObjectSelection) _object_1).getObjSel().getName();
        Mutator command = this.getCommand(name, commands, commands.indexOf(com));
        if ((command != null)) {
          scope.addAll(this.getEReferences(definition, this.getType(command)));
        }
      } else {
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final String name_1 = ((SpecificClosureSelection) _object_3).getObjSel().getName();
          Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(com));
          if ((command_1 != null)) {
            scope.addAll(this.getEReferences(definition, this.getType(command_1)));
          }
        } else {
          ObSelectionStrategy _object_4 = com.getObject();
          if ((_object_4 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_5 = com.getObject();
            final String name_2 = ((CompleteTypeSelection) _object_5).getType().getName();
            scope.addAll(this.getEReferences(definition, name_2));
          } else {
            ObSelectionStrategy _object_6 = com.getObject();
            if ((_object_6 instanceof RandomTypeSelection)) {
              ObSelectionStrategy _object_7 = com.getObject();
              final String name_3 = ((RandomTypeSelection) _object_7).getType().getName();
              scope.addAll(this.getEReferences(definition, name_3));
            } else {
              ObSelectionStrategy _object_8 = com.getObject();
              if ((_object_8 instanceof TypedSelection)) {
                ObSelectionStrategy _object_9 = com.getObject();
                final String name_4 = ((TypedSelection) _object_9).getType().getName();
                scope.addAll(this.getEReferences(definition, name_4));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * CloneObjectMutator.attributes must contain attributes of the CloneObjectMutator.object type.
   */
  public IScope scope_AttributeSet_attribute(final CloneObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final List<Mutator> commands = this.getCommands(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
        ObSelectionStrategy _object = com.getObject();
        if ((_object instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_1 = com.getObject();
          final String name = ((SpecificObjectSelection) _object_1).getObjSel().getName();
          Mutator command = this.getCommand(name, commands, commands.indexOf(com));
          if ((command != null)) {
            scope.addAll(this.getEAttributes(definition, this.getType(command)));
            String className = "";
            int _size = com.getAttributes().size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              EList<AttributeSet> _attributes = com.getAttributes();
              for (final AttributeSet attSet : _attributes) {
                {
                  if ((attSet instanceof AttributeScalar)) {
                    ObSelectionStrategy _object_2 = com.getObject();
                    if ((_object_2 instanceof RandomTypeSelection)) {
                      ObSelectionStrategy _object_3 = com.getObject();
                      RandomTypeSelection strategy = ((RandomTypeSelection) _object_3);
                      EClass type = strategy.getType();
                      scope.addAll(this.getEAttributes(definition, type.getName()));
                    }
                  }
                  if ((attSet instanceof AttributeCopy)) {
                    ObSelectionStrategy _object_4 = ((AttributeCopy) attSet).getObject();
                    if ((_object_4 instanceof SpecificObjectSelection)) {
                      ObSelectionStrategy _object_5 = ((AttributeCopy) attSet).getObject();
                      final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_5);
                      ObjectEmitter _objSel = sel.getObjSel();
                      if ((_objSel instanceof SelectObjectMutator)) {
                        ObjectEmitter _objSel_1 = sel.getObjSel();
                        ObSelectionStrategy _object_6 = ((SelectObjectMutator) _objSel_1).getObject();
                        if ((_object_6 instanceof RandomTypeSelection)) {
                          ObjectEmitter _objSel_2 = sel.getObjSel();
                          ObSelectionStrategy _object_7 = ((SelectObjectMutator) _objSel_2).getObject();
                          final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_7);
                          className = strategy_1.getType().getName();
                          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                          EClass eclass = ModelManager.getEClassByName(packages, className);
                          if ((eclass == null)) {
                            metamodel = this.getMetamodel(definition, className);
                          }
                          scope.addAll(this.getEAttributes(definition, className));
                        }
                      }
                    }
                  }
                  if ((attSet instanceof AttributeSwap)) {
                    ObSelectionStrategy _object_8 = ((AttributeSwap) attSet).getObject();
                    if ((_object_8 instanceof SpecificObjectSelection)) {
                      ObSelectionStrategy _object_9 = ((AttributeSwap) attSet).getObject();
                      final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_9);
                      ObjectEmitter _objSel_3 = sel_1.getObjSel();
                      if ((_objSel_3 instanceof SelectObjectMutator)) {
                        ObjectEmitter _objSel_4 = sel_1.getObjSel();
                        ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_4).getObject();
                        if ((_object_10 instanceof RandomTypeSelection)) {
                          ObjectEmitter _objSel_5 = sel_1.getObjSel();
                          ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_5).getObject();
                          final RandomTypeSelection strategy_2 = ((RandomTypeSelection) _object_11);
                          className = strategy_2.getType().getName();
                          List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                          EClass eclass_1 = ModelManager.getEClassByName(packages_1, className);
                          if ((eclass_1 == null)) {
                            metamodel = this.getMetamodel(definition, className);
                          }
                          scope.addAll(this.getEAttributes(definition, className));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        } else {
          ObSelectionStrategy _object_2 = com.getObject();
          if ((_object_2 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_3 = com.getObject();
            final String name_1 = ((SpecificClosureSelection) _object_3).getObjSel().getName();
            Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(com));
            if ((command_1 != null)) {
              scope.addAll(this.getEAttributes(definition, this.getType(command_1)));
              String className_1 = "";
              int _size_1 = com.getAttributes().size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                EList<AttributeSet> _attributes_1 = com.getAttributes();
                for (final AttributeSet attSet_1 : _attributes_1) {
                  {
                    if ((attSet_1 instanceof AttributeCopy)) {
                      ObSelectionStrategy _object_4 = ((AttributeCopy) attSet_1).getObject();
                      if ((_object_4 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_5 = ((AttributeCopy) attSet_1).getObject();
                        final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_5);
                        ObjectEmitter _objSel = sel.getObjSel();
                        if ((_objSel instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_1 = sel.getObjSel();
                          ObSelectionStrategy _object_6 = ((SelectObjectMutator) _objSel_1).getObject();
                          if ((_object_6 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_2 = sel.getObjSel();
                            ObSelectionStrategy _object_7 = ((SelectObjectMutator) _objSel_2).getObject();
                            final RandomTypeSelection strategy = ((RandomTypeSelection) _object_7);
                            className_1 = strategy.getType().getName();
                            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                            EClass eclass = ModelManager.getEClassByName(packages, className_1);
                            if ((eclass == null)) {
                              metamodel = this.getMetamodel(definition, className_1);
                            }
                            scope.addAll(this.getEAttributes(definition, className_1));
                          }
                        }
                      }
                    }
                    if ((attSet_1 instanceof AttributeSwap)) {
                      ObSelectionStrategy _object_8 = ((AttributeSwap) attSet_1).getObject();
                      if ((_object_8 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_9 = ((AttributeSwap) attSet_1).getObject();
                        final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_9);
                        ObjectEmitter _objSel_3 = sel_1.getObjSel();
                        if ((_objSel_3 instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_4 = sel_1.getObjSel();
                          ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_4).getObject();
                          if ((_object_10 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_5 = sel_1.getObjSel();
                            ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_5).getObject();
                            final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_11);
                            className_1 = strategy_1.getType().getName();
                            List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                            EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_1);
                            if ((eclass_1 == null)) {
                              metamodel = this.getMetamodel(definition, className_1);
                            }
                            scope.addAll(this.getEAttributes(definition, className_1));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          } else {
            ObSelectionStrategy _object_4 = com.getObject();
            if ((_object_4 instanceof CompleteTypeSelection)) {
              ObSelectionStrategy _object_5 = com.getObject();
              final String name_2 = ((CompleteTypeSelection) _object_5).getType().getName();
              scope.addAll(this.getEAttributes(definition, name_2));
              String className_2 = "";
              int _size_2 = com.getAttributes().size();
              boolean _greaterThan_2 = (_size_2 > 0);
              if (_greaterThan_2) {
                EList<AttributeSet> _attributes_2 = com.getAttributes();
                for (final AttributeSet attSet_2 : _attributes_2) {
                  {
                    if ((attSet_2 instanceof AttributeCopy)) {
                      ObSelectionStrategy _object_6 = ((AttributeCopy) attSet_2).getObject();
                      if ((_object_6 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_7 = ((AttributeCopy) attSet_2).getObject();
                        final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_7);
                        ObjectEmitter _objSel = sel.getObjSel();
                        if ((_objSel instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_1 = sel.getObjSel();
                          ObSelectionStrategy _object_8 = ((SelectObjectMutator) _objSel_1).getObject();
                          if ((_object_8 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_2 = sel.getObjSel();
                            ObSelectionStrategy _object_9 = ((SelectObjectMutator) _objSel_2).getObject();
                            final RandomTypeSelection strategy = ((RandomTypeSelection) _object_9);
                            className_2 = strategy.getType().getName();
                            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                            EClass eclass = ModelManager.getEClassByName(packages, className_2);
                            if ((eclass == null)) {
                              metamodel = this.getMetamodel(definition, className_2);
                            }
                            scope.addAll(this.getEAttributes(definition, className_2));
                          }
                        }
                      }
                    }
                    if ((attSet_2 instanceof AttributeSwap)) {
                      ObSelectionStrategy _object_10 = ((AttributeSwap) attSet_2).getObject();
                      if ((_object_10 instanceof SpecificObjectSelection)) {
                        ObSelectionStrategy _object_11 = ((AttributeSwap) attSet_2).getObject();
                        final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_11);
                        ObjectEmitter _objSel_3 = sel_1.getObjSel();
                        if ((_objSel_3 instanceof SelectObjectMutator)) {
                          ObjectEmitter _objSel_4 = sel_1.getObjSel();
                          ObSelectionStrategy _object_12 = ((SelectObjectMutator) _objSel_4).getObject();
                          if ((_object_12 instanceof RandomTypeSelection)) {
                            ObjectEmitter _objSel_5 = sel_1.getObjSel();
                            ObSelectionStrategy _object_13 = ((SelectObjectMutator) _objSel_5).getObject();
                            final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_13);
                            className_2 = strategy_1.getType().getName();
                            List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                            EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_2);
                            if ((eclass_1 == null)) {
                              metamodel = this.getMetamodel(definition, className_2);
                            }
                            scope.addAll(this.getEAttributes(definition, className_2));
                          }
                        }
                      }
                    }
                  }
                }
              }
            } else {
              ObSelectionStrategy _object_6 = com.getObject();
              if ((_object_6 instanceof RandomTypeSelection)) {
                ObSelectionStrategy _object_7 = com.getObject();
                final String name_3 = ((RandomTypeSelection) _object_7).getType().getName();
                scope.addAll(this.getEAttributes(definition, name_3));
                String className_3 = "";
                int _size_3 = com.getAttributes().size();
                boolean _greaterThan_3 = (_size_3 > 0);
                if (_greaterThan_3) {
                  EList<AttributeSet> _attributes_3 = com.getAttributes();
                  for (final AttributeSet attSet_3 : _attributes_3) {
                    {
                      if ((attSet_3 instanceof AttributeCopy)) {
                        ObSelectionStrategy _object_8 = ((AttributeCopy) attSet_3).getObject();
                        if ((_object_8 instanceof SpecificObjectSelection)) {
                          ObSelectionStrategy _object_9 = ((AttributeCopy) attSet_3).getObject();
                          final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_9);
                          ObjectEmitter _objSel = sel.getObjSel();
                          if ((_objSel instanceof SelectObjectMutator)) {
                            ObjectEmitter _objSel_1 = sel.getObjSel();
                            ObSelectionStrategy _object_10 = ((SelectObjectMutator) _objSel_1).getObject();
                            if ((_object_10 instanceof RandomTypeSelection)) {
                              ObjectEmitter _objSel_2 = sel.getObjSel();
                              ObSelectionStrategy _object_11 = ((SelectObjectMutator) _objSel_2).getObject();
                              final RandomTypeSelection strategy = ((RandomTypeSelection) _object_11);
                              className_3 = strategy.getType().getName();
                              List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                              EClass eclass = ModelManager.getEClassByName(packages, className_3);
                              if ((eclass == null)) {
                                metamodel = this.getMetamodel(definition, className_3);
                              }
                              scope.addAll(this.getEAttributes(definition, className_3));
                            }
                          }
                        }
                      }
                      if ((attSet_3 instanceof AttributeSwap)) {
                        ObSelectionStrategy _object_12 = ((AttributeSwap) attSet_3).getObject();
                        if ((_object_12 instanceof SpecificObjectSelection)) {
                          ObSelectionStrategy _object_13 = ((AttributeSwap) attSet_3).getObject();
                          final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_13);
                          ObjectEmitter _objSel_3 = sel_1.getObjSel();
                          if ((_objSel_3 instanceof SelectObjectMutator)) {
                            ObjectEmitter _objSel_4 = sel_1.getObjSel();
                            ObSelectionStrategy _object_14 = ((SelectObjectMutator) _objSel_4).getObject();
                            if ((_object_14 instanceof RandomTypeSelection)) {
                              ObjectEmitter _objSel_5 = sel_1.getObjSel();
                              ObSelectionStrategy _object_15 = ((SelectObjectMutator) _objSel_5).getObject();
                              final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_15);
                              className_3 = strategy_1.getType().getName();
                              List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                              EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_3);
                              if ((eclass_1 == null)) {
                                metamodel = this.getMetamodel(definition, className_3);
                              }
                              scope.addAll(this.getEAttributes(definition, className_3));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              } else {
                ObSelectionStrategy _object_8 = com.getObject();
                if ((_object_8 instanceof TypedSelection)) {
                  ObSelectionStrategy _object_9 = com.getObject();
                  final String name_4 = ((TypedSelection) _object_9).getType().getName();
                  scope.addAll(this.getEAttributes(definition, name_4));
                  {
                    String className_4 = "";
                    int _size_4 = com.getAttributes().size();
                    boolean _greaterThan_4 = (_size_4 > 0);
                    if (_greaterThan_4) {
                      EList<AttributeSet> _attributes_4 = com.getAttributes();
                      for (final AttributeSet attSet_4 : _attributes_4) {
                        {
                          if ((attSet_4 instanceof AttributeCopy)) {
                            ObSelectionStrategy _object_10 = ((AttributeCopy) attSet_4).getObject();
                            if ((_object_10 instanceof SpecificObjectSelection)) {
                              ObSelectionStrategy _object_11 = ((AttributeCopy) attSet_4).getObject();
                              final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_11);
                              ObjectEmitter _objSel = sel.getObjSel();
                              if ((_objSel instanceof SelectObjectMutator)) {
                                ObjectEmitter _objSel_1 = sel.getObjSel();
                                ObSelectionStrategy _object_12 = ((SelectObjectMutator) _objSel_1).getObject();
                                if ((_object_12 instanceof RandomTypeSelection)) {
                                  ObjectEmitter _objSel_2 = sel.getObjSel();
                                  ObSelectionStrategy _object_13 = ((SelectObjectMutator) _objSel_2).getObject();
                                  final RandomTypeSelection strategy = ((RandomTypeSelection) _object_13);
                                  className_4 = strategy.getType().getName();
                                  List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                                  EClass eclass = ModelManager.getEClassByName(packages, className_4);
                                  if ((eclass == null)) {
                                    metamodel = this.getMetamodel(definition, className_4);
                                  }
                                  scope.addAll(this.getEAttributes(definition, className_4));
                                }
                              }
                            }
                          }
                          if ((attSet_4 instanceof AttributeSwap)) {
                            ObSelectionStrategy _object_14 = ((AttributeSwap) attSet_4).getObject();
                            if ((_object_14 instanceof SpecificObjectSelection)) {
                              ObSelectionStrategy _object_15 = ((AttributeSwap) attSet_4).getObject();
                              final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_15);
                              ObjectEmitter _objSel_3 = sel_1.getObjSel();
                              if ((_objSel_3 instanceof SelectObjectMutator)) {
                                ObjectEmitter _objSel_4 = sel_1.getObjSel();
                                ObSelectionStrategy _object_16 = ((SelectObjectMutator) _objSel_4).getObject();
                                if ((_object_16 instanceof RandomTypeSelection)) {
                                  ObjectEmitter _objSel_5 = sel_1.getObjSel();
                                  ObSelectionStrategy _object_17 = ((SelectObjectMutator) _objSel_5).getObject();
                                  final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_17);
                                  className_4 = strategy_1.getType().getName();
                                  List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                                  EClass eclass_1 = ModelManager.getEClassByName(packages_1, className_4);
                                  if ((eclass_1 == null)) {
                                    metamodel = this.getMetamodel(definition, className_4);
                                  }
                                  scope.addAll(this.getEAttributes(definition, className_4));
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
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * CloneObjectMutator.references must contain references of the CloneObjectMutator.type type.
   */
  public IScope scope_ReferenceSet_reference(final CloneObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_1 = com.getObject();
        final String name = ((SpecificObjectSelection) _object_1).getObjSel().getName();
        Mutator command = this.getCommand(name, commands, commands.indexOf(com));
        if ((command != null)) {
          scope.addAll(this.getEReferences(definition, this.getType(command)));
        }
      } else {
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final String name_1 = ((SpecificObjectSelection) _object_3).getObjSel().getName();
          Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(com));
          if ((command_1 != null)) {
            scope.addAll(this.getEReferences(definition, this.getType(command_1)));
          }
        } else {
          ObSelectionStrategy _object_4 = com.getObject();
          if ((_object_4 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_5 = com.getObject();
            final String name_2 = ((CompleteTypeSelection) _object_5).getType().getName();
            scope.addAll(this.getEReferences(definition, name_2));
          } else {
            ObSelectionStrategy _object_6 = com.getObject();
            if ((_object_6 instanceof RandomTypeSelection)) {
              ObSelectionStrategy _object_7 = com.getObject();
              final String name_3 = ((RandomTypeSelection) _object_7).getType().getName();
              scope.addAll(this.getEReferences(definition, name_3));
            } else {
              ObSelectionStrategy _object_8 = com.getObject();
              if ((_object_8 instanceof TypedSelection)) {
                ObSelectionStrategy _object_9 = com.getObject();
                final String name_4 = ((TypedSelection) _object_9).getType().getName();
                scope.addAll(this.getEReferences(definition, name_4));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * RetypeObjectMutator.attributes must contain attributes of the CloneObjectMutator.object type.
   */
  public IScope scope_AttributeSet_attribute(final RetypeObjectMutator com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        String _metamodel = null;
        if (definition!=null) {
          _metamodel=definition.getMetamodel();
        }
        String metamodel = _metamodel;
        final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
        scope.addAll(this.getEAttributes(definition, this.getType(com)));
        String className = "";
        int _size = com.getAttributes().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          EList<AttributeSet> _attributes = com.getAttributes();
          for (final AttributeSet attSet : _attributes) {
            {
              if ((attSet instanceof AttributeScalar)) {
                ObSelectionStrategy _object = com.getObject();
                if ((_object instanceof RandomTypeSelection)) {
                  ObSelectionStrategy _object_1 = com.getObject();
                  RandomTypeSelection strategy = ((RandomTypeSelection) _object_1);
                  EClass type = strategy.getType();
                  scope.addAll(this.getEAttributes(definition, type.getName()));
                }
              }
              if ((attSet instanceof AttributeCopy)) {
                ObSelectionStrategy _object_2 = ((AttributeCopy) attSet).getObject();
                if ((_object_2 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _object_3 = ((AttributeCopy) attSet).getObject();
                  final SpecificObjectSelection sel = ((SpecificObjectSelection) _object_3);
                  ObjectEmitter _objSel = sel.getObjSel();
                  if ((_objSel instanceof SelectObjectMutator)) {
                    ObjectEmitter _objSel_1 = sel.getObjSel();
                    ObSelectionStrategy _object_4 = ((SelectObjectMutator) _objSel_1).getObject();
                    if ((_object_4 instanceof RandomTypeSelection)) {
                      ObjectEmitter _objSel_2 = sel.getObjSel();
                      ObSelectionStrategy _object_5 = ((SelectObjectMutator) _objSel_2).getObject();
                      final RandomTypeSelection strategy_1 = ((RandomTypeSelection) _object_5);
                      className = strategy_1.getType().getName();
                      List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
                      EClass eclass = ModelManager.getEClassByName(packages, className);
                      if ((eclass == null)) {
                        metamodel = this.getMetamodel(definition, className);
                      }
                      scope.addAll(this.getEAttributes(definition, className));
                    }
                  }
                }
              }
              if ((attSet instanceof AttributeSwap)) {
                ObSelectionStrategy _object_6 = ((AttributeSwap) attSet).getObject();
                if ((_object_6 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _object_7 = ((AttributeSwap) attSet).getObject();
                  final SpecificObjectSelection sel_1 = ((SpecificObjectSelection) _object_7);
                  ObjectEmitter _objSel_3 = sel_1.getObjSel();
                  if ((_objSel_3 instanceof SelectObjectMutator)) {
                    ObjectEmitter _objSel_4 = sel_1.getObjSel();
                    ObSelectionStrategy _object_8 = ((SelectObjectMutator) _objSel_4).getObject();
                    if ((_object_8 instanceof RandomTypeSelection)) {
                      ObjectEmitter _objSel_5 = sel_1.getObjSel();
                      ObSelectionStrategy _object_9 = ((SelectObjectMutator) _objSel_5).getObject();
                      final RandomTypeSelection strategy_2 = ((RandomTypeSelection) _object_9);
                      className = strategy_2.getType().getName();
                      List<EPackage> packages_1 = ModelManager.loadMetaModel(metamodel);
                      EClass eclass_1 = ModelManager.getEClassByName(packages_1, className);
                      if ((eclass_1 == null)) {
                        metamodel = this.getMetamodel(definition, className);
                      }
                      scope.addAll(this.getEAttributes(definition, className));
                    }
                  }
                }
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(scope);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * RetypeObjectMutator.references must contain references of the RetypeObjectMutator.type type and RetypeObjectMutator.types.
   */
  public IScope scope_ReferenceSet_reference(final RetypeObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEReferences(definition, this.getType(com)));
    }
    return _xblockexpression;
  }

  /**
   * ReferenceInit.refType must contain references of the type of ReferenceInit.object.
   */
  public IScope scope_ReferenceSet_refType(final ReferenceInit com, final EReference container) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
        final List<Mutator> commands = this.getCommands(currentMutator);
        ObSelectionStrategy _object = com.getObject();
        EClass _type = null;
        if (_object!=null) {
          _type=_object.getType();
        }
        String _name = null;
        if (_type!=null) {
          _name=_type.getName();
        }
        String objectName = _name;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_2 = com.getObject();
          ObjectEmitter _objSel = null;
          if (((SpecificObjectSelection) _object_2)!=null) {
            _objSel=((SpecificObjectSelection) _object_2).getObjSel();
          }
          String _name_1 = null;
          if (_objSel!=null) {
            _name_1=_objSel.getName();
          }
          objectName = _name_1;
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          ObjectEmitter _objSel_1 = null;
          if (((SpecificClosureSelection) _object_4)!=null) {
            _objSel_1=((SpecificClosureSelection) _object_4).getObjSel();
          }
          String _name_2 = null;
          if (_objSel_1!=null) {
            _name_2=_objSel_1.getName();
          }
          objectName = _name_2;
        }
        Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
        if ((command != null)) {
          return Scopes.scopeFor(this.getEReferences(definition, this.getType(command)));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceSwap.reference must contain references of the type of ReferenceSwap.object,
   * or of the type of the mutator if no object is specified.
   */
  public IScope scope_ReferenceSet_reference(final ReferenceSwap com, final EReference container) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
        final List<Mutator> commands = this.getCommands(currentMutator);
        ObSelectionStrategy _object = com.getObject();
        boolean _tripleEquals = (_object == null);
        if (_tripleEquals) {
          return Scopes.scopeFor(this.getEReferences(definition, this.getType(currentMutator)));
        }
        ObSelectionStrategy _object_1 = com.getObject();
        EClass _type = null;
        if (_object_1!=null) {
          _type=_object_1.getType();
        }
        String _name = null;
        if (_type!=null) {
          _name=_type.getName();
        }
        String objectName = _name;
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          ObjectEmitter _objSel = null;
          if (((SpecificObjectSelection) _object_3)!=null) {
            _objSel=((SpecificObjectSelection) _object_3).getObjSel();
          }
          String _name_1 = null;
          if (_objSel!=null) {
            _name_1=_objSel.getName();
          }
          objectName = _name_1;
        }
        ObSelectionStrategy _object_4 = com.getObject();
        if ((_object_4 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_5 = com.getObject();
          ObjectEmitter _objSel_1 = null;
          if (((SpecificClosureSelection) _object_5)!=null) {
            _objSel_1=((SpecificClosureSelection) _object_5).getObjSel();
          }
          String _name_2 = null;
          if (_objSel_1!=null) {
            _name_2=_objSel_1.getName();
          }
          objectName = _name_2;
        }
        Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
        if ((command != null)) {
          return Scopes.scopeFor(this.getEReferences(definition, this.getType(command)));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceAtt.attribute must contain attributes of the type of ReferenceAtt.reference.
   */
  public IScope scope_ReferenceAtt_attribute(final ReferenceAtt com, final EReference container) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      ArrayList<EAttribute> atts = new ArrayList<EAttribute>();
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        String className = com.getReference().get(0).getEType().getName();
        atts.addAll(this.getEAttributes(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(atts);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceAdd.refType must contain references of the type of ReferenceAdd.object.
   */
  public IScope scope_ReferenceSet_refType(final ReferenceAdd com, final EReference container) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
        final List<Mutator> commands = this.getCommands(currentMutator);
        ObSelectionStrategy _object = com.getObject();
        EClass _type = null;
        if (_object!=null) {
          _type=_object.getType();
        }
        String _name = null;
        if (_type!=null) {
          _name=_type.getName();
        }
        String objectName = _name;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_2 = com.getObject();
          ObjectEmitter _objSel = null;
          if (((SpecificObjectSelection) _object_2)!=null) {
            _objSel=((SpecificObjectSelection) _object_2).getObjSel();
          }
          String _name_1 = null;
          if (_objSel!=null) {
            _name_1=_objSel.getName();
          }
          objectName = _name_1;
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          ObjectEmitter _objSel_1 = null;
          if (((SpecificClosureSelection) _object_4)!=null) {
            _objSel_1=((SpecificClosureSelection) _object_4).getObjSel();
          }
          String _name_2 = null;
          if (_objSel_1!=null) {
            _name_2=_objSel_1.getName();
          }
          objectName = _name_2;
        }
        Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
        if ((command != null)) {
          return Scopes.scopeFor(this.getEReferences(definition, this.getType(command)));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceRemove.refType must contain references of the type of ReferenceRemove.object.
   */
  public IScope scope_ReferenceSet_refType(final ReferenceRemove com, final EReference container) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
        final List<Mutator> commands = this.getCommands(currentMutator);
        ObSelectionStrategy _object = com.getObject();
        EClass _type = null;
        if (_object!=null) {
          _type=_object.getType();
        }
        String _name = null;
        if (_type!=null) {
          _name=_type.getName();
        }
        String objectName = _name;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_2 = com.getObject();
          ObjectEmitter _objSel = null;
          if (((SpecificObjectSelection) _object_2)!=null) {
            _objSel=((SpecificObjectSelection) _object_2).getObjSel();
          }
          String _name_1 = null;
          if (_objSel!=null) {
            _name_1=_objSel.getName();
          }
          objectName = _name_1;
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          ObjectEmitter _objSel_1 = null;
          if (((SpecificClosureSelection) _object_4)!=null) {
            _objSel_1=((SpecificClosureSelection) _object_4).getObjSel();
          }
          String _name_2 = null;
          if (_objSel_1!=null) {
            _name_2=_objSel_1.getName();
          }
          objectName = _name_2;
        }
        Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
        if ((command != null)) {
          return Scopes.scopeFor(this.getEReferences(definition, this.getType(command)));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final RandomTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        IScope _xifexpression = null;
        if ((env != null)) {
          IScope _xblockexpression_1 = null;
          {
            final Definition definition = env.getDefinition();
            EClass _type = com.getType();
            String _name = null;
            if (_type!=null) {
              _name=_type.getName();
            }
            final String className = _name;
            String _metamodel = null;
            if (definition!=null) {
              _metamodel=definition.getMetamodel();
            }
            String metamodel = _metamodel;
            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
            EClass eclass = ModelManager.getEClassByName(packages, className);
            if ((eclass == null)) {
              metamodel = this.getMetamodel(definition, className);
            }
            _xblockexpression_1 = Scopes.scopeFor(this.getEReferences(definition, className));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          ArrayList<EObject> _arrayList = new ArrayList<EObject>();
          _xifexpression = Scopes.scopeFor(_arrayList);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final OtherTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        IScope _xifexpression = null;
        if ((env != null)) {
          IScope _xblockexpression_1 = null;
          {
            final Definition definition = env.getDefinition();
            EClass _type = com.getType();
            String _name = null;
            if (_type!=null) {
              _name=_type.getName();
            }
            final String className = _name;
            String _metamodel = null;
            if (definition!=null) {
              _metamodel=definition.getMetamodel();
            }
            String metamodel = _metamodel;
            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
            EClass eclass = ModelManager.getEClassByName(packages, className);
            if ((eclass == null)) {
              metamodel = this.getMetamodel(definition, className);
            }
            _xblockexpression_1 = Scopes.scopeFor(this.getEReferences(definition, className));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          ArrayList<EObject> _arrayList = new ArrayList<EObject>();
          _xifexpression = Scopes.scopeFor(_arrayList);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final CompleteTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      IScope _xifexpression = null;
      if ((env != null)) {
        IScope _xblockexpression_1 = null;
        {
          final Definition definition = env.getDefinition();
          EClass _type = com.getType();
          String _name = null;
          if (_type!=null) {
            _name=_type.getName();
          }
          final String className = _name;
          _xblockexpression_1 = Scopes.scopeFor(this.getEReferences(definition, className));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        ArrayList<EObject> _arrayList = new ArrayList<EObject>();
        _xifexpression = Scopes.scopeFor(_arrayList);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final SpecificObjectSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        List<EReference> references = new ArrayList<EReference>();
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
          final List<Mutator> commands = this.getCommands(currentMutator);
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          Set<String> classNames = new HashSet<String>();
          EReference _refType = com.getRefType();
          boolean _tripleEquals = (_refType == null);
          if (_tripleEquals) {
            ObjectEmitter _objSel = com.getObjSel();
            String _name = null;
            if (_objSel!=null) {
              _name=_objSel.getName();
            }
            final String objectName = _name;
            Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
            if ((command != null)) {
              classNames.addAll(this.getType(command));
            }
          } else {
            classNames.add(com.getRefType().getEType().getName());
          }
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          for (final String className : classNames) {
            {
              EClass eclass = ModelManager.getEClassByName(packages, className);
              if ((eclass == null)) {
                metamodel = this.getMetamodel(definition, className);
              }
              references.addAll(this.getEReferences(definition, className));
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(references);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final SpecificClosureSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
        final List<Mutator> commands = this.getCommands(currentMutator);
        EReference _refType = com.getRefType();
        boolean _tripleEquals = (_refType == null);
        if (_tripleEquals) {
          ObjectEmitter _objSel = com.getObjSel();
          String _name = null;
          if (_objSel!=null) {
            _name=_objSel.getName();
          }
          final String objectName = _name;
          Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
          if ((command != null)) {
            return Scopes.scopeFor(this.getEReferences(definition, this.getType(command)));
          }
        } else {
          return Scopes.scopeFor(this.getEReferences(definition, com.getRefType().getEType().getName()));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_name(final TypedSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      IScope _xifexpression = null;
      if ((env != null)) {
        IScope _xblockexpression_1 = null;
        {
          final Definition definition = env.getDefinition();
          EClass _type = com.getType();
          String _name = null;
          if (_type!=null) {
            _name=_type.getName();
          }
          final String className = _name;
          _xblockexpression_1 = Scopes.scopeFor(this.getEReferences(definition, className));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        ArrayList<EObject> _arrayList = new ArrayList<EObject>();
        _xifexpression = Scopes.scopeFor(_arrayList);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final RandomTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        IScope _xifexpression = null;
        if ((env != null)) {
          IScope _xblockexpression_1 = null;
          {
            final Definition definition = env.getDefinition();
            EClass _type = com.getType();
            String _name = null;
            if (_type!=null) {
              _name=_type.getName();
            }
            final String className = _name;
            String _metamodel = null;
            if (definition!=null) {
              _metamodel=definition.getMetamodel();
            }
            String metamodel = _metamodel;
            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
            EClass eclass = ModelManager.getEClassByName(packages, className);
            if ((eclass == null)) {
              metamodel = this.getMetamodel(definition, className);
            }
            _xblockexpression_1 = Scopes.scopeFor(this.getEAttributes(definition, className));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          ArrayList<EObject> _arrayList = new ArrayList<EObject>();
          _xifexpression = Scopes.scopeFor(_arrayList);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final OtherTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        IScope _xifexpression = null;
        if ((env != null)) {
          IScope _xblockexpression_1 = null;
          {
            final Definition definition = env.getDefinition();
            EClass _type = com.getType();
            String _name = null;
            if (_type!=null) {
              _name=_type.getName();
            }
            final String className = _name;
            String _metamodel = null;
            if (definition!=null) {
              _metamodel=definition.getMetamodel();
            }
            String metamodel = _metamodel;
            List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
            EClass eclass = ModelManager.getEClassByName(packages, className);
            if ((eclass == null)) {
              metamodel = this.getMetamodel(definition, className);
            }
            _xblockexpression_1 = Scopes.scopeFor(this.getEAttributes(definition, className));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          ArrayList<EObject> _arrayList = new ArrayList<EObject>();
          _xifexpression = Scopes.scopeFor(_arrayList);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final CompleteTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      IScope _xifexpression = null;
      if ((env != null)) {
        IScope _xblockexpression_1 = null;
        {
          final Definition definition = env.getDefinition();
          EClass _type = com.getType();
          String _name = null;
          if (_type!=null) {
            _name=_type.getName();
          }
          final String className = _name;
          _xblockexpression_1 = Scopes.scopeFor(this.getEAttributes(definition, className));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        ArrayList<EObject> _arrayList = new ArrayList<EObject>();
        _xifexpression = Scopes.scopeFor(_arrayList);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final SpecificObjectSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        List<EAttribute> attributes = new ArrayList<EAttribute>();
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          Set<String> classNames = new HashSet<String>();
          EReference _refType = com.getRefType();
          boolean _tripleEquals = (_refType == null);
          if (_tripleEquals) {
            final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
            final List<Mutator> commands = this.getCommands(currentMutator);
            ObjectEmitter _objSel = com.getObjSel();
            String _name = null;
            if (_objSel!=null) {
              _name=_objSel.getName();
            }
            final String objectName = _name;
            Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
            if ((command != null)) {
              classNames.addAll(this.getType(command));
            }
          } else {
            classNames.add(com.getRefType().getEType().getName());
          }
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          for (final String className : classNames) {
            {
              EClass eclass = ModelManager.getEClassByName(packages, className);
              if ((eclass == null)) {
                metamodel = this.getMetamodel(definition, className);
              }
              attributes.addAll(this.getEAttributes(definition, className));
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(attributes);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final SpecificClosureSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      if ((env != null)) {
        final Definition definition = env.getDefinition();
        EReference _refType = com.getRefType();
        boolean _tripleEquals = (_refType == null);
        if (_tripleEquals) {
          final Mutator currentMutator = EcoreUtil2.<Mutator>getContainerOfType(com, Mutator.class);
          final List<Mutator> commands = this.getCommands(currentMutator);
          ObjectEmitter _objSel = com.getObjSel();
          String _name = null;
          if (_objSel!=null) {
            _name=_objSel.getName();
          }
          final String objectName = _name;
          Mutator command = this.getCommand(objectName, commands, commands.indexOf(currentMutator));
          if ((command != null)) {
            return Scopes.scopeFor(this.getEAttributes(definition, this.getType(command)));
          }
        } else {
          return Scopes.scopeFor(this.getEAttributes(definition, com.getRefType().getEType().getName()));
        }
      }
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      _xblockexpression = Scopes.scopeFor(_arrayList);
    }
    return _xblockexpression;
  }

  /**
   * AttributeEvaluation.name must contain the attributes defined by com.type
   */
  public IScope scope_AttributeEvaluation_name(final TypedSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      IScope _xifexpression = null;
      if ((env != null)) {
        IScope _xblockexpression_1 = null;
        {
          final Definition definition = env.getDefinition();
          EClass _type = com.getType();
          String _name = null;
          if (_type!=null) {
            _name=_type.getName();
          }
          final String className = _name;
          _xblockexpression_1 = Scopes.scopeFor(this.getEAttributes(definition, className));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        ArrayList<EObject> _arrayList = new ArrayList<EObject>();
        _xifexpression = Scopes.scopeFor(_arrayList);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * ModifyInformationMutator.refType must be of the ModifyInformationMutator.object type.
   */
  public IScope scope_ObSelectionStrategy_refType(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_1 = com.getObject();
        final String name = ((SpecificObjectSelection) _object_1).getObjSel().getName();
        Mutator command = this.getCommand(name, commands, commands.indexOf(com));
        if ((command != null)) {
          scope.addAll(this.getEReferences(definition, this.getType(command)));
        }
      } else {
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_3 = com.getObject();
          final String name_1 = ((SpecificClosureSelection) _object_3).getObjSel().getName();
          Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(com));
          if ((command_1 != null)) {
            scope.addAll(this.getEReferences(definition, this.getType(command_1)));
          }
        } else {
          ObSelectionStrategy _object_4 = com.getObject();
          if ((_object_4 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_5 = com.getObject();
            final String name_2 = ((CompleteTypeSelection) _object_5).getType().getName();
            scope.addAll(this.getEReferences(definition, name_2));
          } else {
            ObSelectionStrategy _object_6 = com.getObject();
            if ((_object_6 instanceof RandomTypeSelection)) {
              ObSelectionStrategy _object_7 = com.getObject();
              final String name_3 = ((RandomTypeSelection) _object_7).getType().getName();
              scope.addAll(this.getEReferences(definition, name_3));
            } else {
              ObSelectionStrategy _object_8 = com.getObject();
              if ((_object_8 instanceof TypedSelection)) {
                ObSelectionStrategy _object_9 = com.getObject();
                final String name_4 = ((TypedSelection) _object_9).getType().getName();
                scope.addAll(this.getEReferences(definition, name_4));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refType must be of com.type.
   */
  public IScope scope_ReferenceEvaluation_refType(final RandomTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EObject mut = null;
      if (((((com.eContainer() instanceof ReferenceInit) || 
        (com.eContainer() instanceof ReferenceAdd)) || 
        (com.eContainer() instanceof ReferenceRemove)) && ((com.eContainer().eContainer() instanceof CreateObjectMutator) || 
        (com.eContainer().eContainer() instanceof SelectObjectMutator)))) {
        mut = com.eContainer().eContainer();
      } else {
        if ((((com.eContainer() instanceof CreateObjectMutator) || 
          (com.eContainer() instanceof SelectObjectMutator)) || 
          (com.eContainer() instanceof ModifyInformationMutator))) {
          mut = com.eContainer();
        }
      }
      if ((mut != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        final List<Mutator> commands = this.getCommands(((Mutator) mut));
        Expression _expression = com.getExpression();
        boolean _tripleNotEquals = (_expression != null);
        if (_tripleNotEquals) {
          final Expression exp = com.getExpression();
          Evaluation _first = exp.getFirst();
          if ((_first instanceof ReferenceEvaluation)) {
            Evaluation _first_1 = exp.getFirst();
            final ReferenceEvaluation first = ((ReferenceEvaluation) _first_1);
            ObSelectionStrategy _value = first.getValue();
            boolean _tripleNotEquals_1 = (_value != null);
            if (_tripleNotEquals_1) {
              ObSelectionStrategy _value_1 = first.getValue();
              if ((_value_1 instanceof SpecificObjectSelection)) {
                ObSelectionStrategy _value_2 = first.getValue();
                ObjectEmitter _objSel = ((SpecificObjectSelection) _value_2).getObjSel();
                boolean _tripleNotEquals_2 = (_objSel != null);
                if (_tripleNotEquals_2) {
                  ObSelectionStrategy _value_3 = first.getValue();
                  final String name = ((SpecificObjectSelection) _value_3).getObjSel().getName();
                  Mutator command = this.getCommand(name, commands, commands.indexOf(mut));
                  if ((command != null)) {
                    scope.addAll(this.getEReferences(definition, this.getType(command)));
                  }
                }
              }
            }
            EList<Evaluation> _second = exp.getSecond();
            for (final Evaluation second : _second) {
              if ((second instanceof ReferenceEvaluation)) {
                ObSelectionStrategy _value_4 = ((ReferenceEvaluation)second).getValue();
                if ((_value_4 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _value_5 = ((ReferenceEvaluation)second).getValue();
                  ObjectEmitter _objSel_1 = ((SpecificObjectSelection) _value_5).getObjSel();
                  boolean _tripleNotEquals_3 = (_objSel_1 != null);
                  if (_tripleNotEquals_3) {
                    ObSelectionStrategy _value_6 = ((ReferenceEvaluation)second).getValue();
                    final String name_1 = ((SpecificObjectSelection) _value_6).getObjSel().getName();
                    Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(mut));
                    if ((command_1 != null)) {
                      scope.addAll(this.getEReferences(definition, this.getType(command_1)));
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refType must be of com.type.
   */
  public IScope scope_ReferenceEvaluation_refType(final OtherTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EObject mut = null;
      if (((((com.eContainer() instanceof ReferenceInit) || 
        (com.eContainer() instanceof ReferenceAdd)) || 
        (com.eContainer() instanceof ReferenceRemove)) && ((com.eContainer().eContainer() instanceof CreateObjectMutator) || 
        (com.eContainer().eContainer() instanceof SelectObjectMutator)))) {
        mut = com.eContainer().eContainer();
      } else {
        if ((((com.eContainer() instanceof CreateObjectMutator) || 
          (com.eContainer() instanceof SelectObjectMutator)) || 
          (com.eContainer() instanceof ModifyInformationMutator))) {
          mut = com.eContainer();
        }
      }
      if ((mut != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        final List<Mutator> commands = this.getCommands(((Mutator) mut));
        Expression _expression = com.getExpression();
        boolean _tripleNotEquals = (_expression != null);
        if (_tripleNotEquals) {
          final Expression exp = com.getExpression();
          Evaluation _first = exp.getFirst();
          if ((_first instanceof ReferenceEvaluation)) {
            Evaluation _first_1 = exp.getFirst();
            final ReferenceEvaluation first = ((ReferenceEvaluation) _first_1);
            ObSelectionStrategy _value = first.getValue();
            boolean _tripleNotEquals_1 = (_value != null);
            if (_tripleNotEquals_1) {
              ObSelectionStrategy _value_1 = first.getValue();
              if ((_value_1 instanceof SpecificObjectSelection)) {
                ObSelectionStrategy _value_2 = first.getValue();
                ObjectEmitter _objSel = ((SpecificObjectSelection) _value_2).getObjSel();
                boolean _tripleNotEquals_2 = (_objSel != null);
                if (_tripleNotEquals_2) {
                  ObSelectionStrategy _value_3 = first.getValue();
                  final String name = ((SpecificObjectSelection) _value_3).getObjSel().getName();
                  Mutator command = this.getCommand(name, commands, commands.indexOf(mut));
                  if ((command != null)) {
                    scope.addAll(this.getEReferences(definition, this.getType(command)));
                  }
                }
              }
            }
            EList<Evaluation> _second = exp.getSecond();
            for (final Evaluation second : _second) {
              if ((second instanceof ReferenceEvaluation)) {
                ObSelectionStrategy _value_4 = ((ReferenceEvaluation)second).getValue();
                if ((_value_4 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _value_5 = ((ReferenceEvaluation)second).getValue();
                  ObjectEmitter _objSel_1 = ((SpecificObjectSelection) _value_5).getObjSel();
                  boolean _tripleNotEquals_3 = (_objSel_1 != null);
                  if (_tripleNotEquals_3) {
                    ObSelectionStrategy _value_6 = ((ReferenceEvaluation)second).getValue();
                    final String name_1 = ((SpecificObjectSelection) _value_6).getObjSel().getName();
                    Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(mut));
                    if ((command_1 != null)) {
                      scope.addAll(this.getEReferences(definition, this.getType(command_1)));
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refType must be of com.type.
   */
  public IScope scope_ReferenceEvaluation_refType(final TypedSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EObject mut = null;
      if (((((com.eContainer() instanceof ReferenceInit) || 
        (com.eContainer() instanceof ReferenceAdd)) || 
        (com.eContainer() instanceof ReferenceRemove)) && ((com.eContainer().eContainer() instanceof CreateObjectMutator) || 
        (com.eContainer().eContainer() instanceof SelectObjectMutator)))) {
        mut = com.eContainer().eContainer();
      } else {
        if ((((com.eContainer() instanceof CreateObjectMutator) || 
          (com.eContainer() instanceof SelectObjectMutator)) || 
          (com.eContainer() instanceof ModifyInformationMutator))) {
          mut = com.eContainer();
        }
      }
      if ((mut != null)) {
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        final Definition definition = env.getDefinition();
        final List<Mutator> commands = this.getCommands(((Mutator) mut));
        Expression _expression = com.getExpression();
        boolean _tripleNotEquals = (_expression != null);
        if (_tripleNotEquals) {
          final Expression exp = com.getExpression();
          Evaluation _first = exp.getFirst();
          if ((_first instanceof ReferenceEvaluation)) {
            Evaluation _first_1 = exp.getFirst();
            final ReferenceEvaluation first = ((ReferenceEvaluation) _first_1);
            ObSelectionStrategy _value = first.getValue();
            boolean _tripleNotEquals_1 = (_value != null);
            if (_tripleNotEquals_1) {
              ObSelectionStrategy _value_1 = first.getValue();
              if ((_value_1 instanceof SpecificObjectSelection)) {
                ObSelectionStrategy _value_2 = first.getValue();
                ObjectEmitter _objSel = ((SpecificObjectSelection) _value_2).getObjSel();
                boolean _tripleNotEquals_2 = (_objSel != null);
                if (_tripleNotEquals_2) {
                  ObSelectionStrategy _value_3 = first.getValue();
                  final String name = ((SpecificObjectSelection) _value_3).getObjSel().getName();
                  Mutator command = this.getCommand(name, commands, commands.indexOf(mut));
                  if ((command != null)) {
                    scope.addAll(this.getEReferences(definition, this.getType(command)));
                  }
                }
              }
            }
            EList<Evaluation> _second = exp.getSecond();
            for (final Evaluation second : _second) {
              if ((second instanceof ReferenceEvaluation)) {
                ObSelectionStrategy _value_4 = ((ReferenceEvaluation)second).getValue();
                if ((_value_4 instanceof SpecificObjectSelection)) {
                  ObSelectionStrategy _value_5 = ((ReferenceEvaluation)second).getValue();
                  ObjectEmitter _objSel_1 = ((SpecificObjectSelection) _value_5).getObjSel();
                  boolean _tripleNotEquals_3 = (_objSel_1 != null);
                  if (_tripleNotEquals_3) {
                    ObSelectionStrategy _value_6 = ((ReferenceEvaluation)second).getValue();
                    final String name_1 = ((SpecificObjectSelection) _value_6).getObjSel().getName();
                    Mutator command_1 = this.getCommand(name_1, commands, commands.indexOf(mut));
                    if ((command_1 != null)) {
                      scope.addAll(this.getEReferences(definition, this.getType(command_1)));
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refName(final RandomTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refName(final OtherTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refName(final CompleteTypeSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refName(final SpecificObjectSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_refName(final SpecificClosureSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_refName(final TypedSelection com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EReference> scope = new ArrayList<EReference>();
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      if ((env != null)) {
        Expression _expression = com.getExpression();
        Evaluation _first = null;
        if (_expression!=null) {
          _first=_expression.getFirst();
        }
        if ((_first instanceof ReferenceEvaluation)) {
          Expression _expression_1 = com.getExpression();
          Evaluation _first_1 = null;
          if (_expression_1!=null) {
            _first_1=_expression_1.getFirst();
          }
          final ReferenceEvaluation refEv = ((ReferenceEvaluation) _first_1);
          EClass typeFirst = null;
          boolean _isSelf = refEv.isSelf();
          boolean _equals = (_isSelf == true);
          if (_equals) {
            Mutator mut = null;
            EObject container = com.eContainer();
            while ((((container instanceof Mutator) == false) && (container != null))) {
              container = container.eContainer();
            }
            mut = ((Mutator) container);
            if ((mut instanceof CreateObjectMutator)) {
              typeFirst = ((CreateObjectMutator)mut).getType();
            }
            if ((mut instanceof SelectObjectMutator)) {
              typeFirst = ((SelectObjectMutator)mut).getObject().getType();
            }
            if ((mut instanceof SelectSampleMutator)) {
              typeFirst = MutatorUtils.selectSampleMutatorHelperType(((SelectSampleMutator)mut));
            }
            if ((mut instanceof CloneObjectMutator)) {
              typeFirst = ((CloneObjectMutator)mut).getType();
            }
            if ((mut instanceof RetypeObjectMutator)) {
              typeFirst = ((RetypeObjectMutator)mut).getType();
            }
            if ((mut instanceof ModifyInformationMutator)) {
              typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(((ModifyInformationMutator) mut));
            }
          } else {
            EClassifier _eType = refEv.getName().getEType();
            typeFirst = ((EClass) _eType);
          }
          String className = typeFirst.getName();
          scope.addAll(this.getEReferences(definition, className));
          Expression _expression_2 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_2!=null) {
            _second=_expression_2.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_3 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_3!=null) {
              _second_1=_expression_3.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                EClass type = null;
                boolean _isSelf_1 = ((ReferenceEvaluation)second).isSelf();
                boolean _equals_1 = (_isSelf_1 == true);
                if (_equals_1) {
                  type = typeFirst;
                } else {
                  EClassifier _eType_1 = ((ReferenceEvaluation)second).getName().getEType();
                  type = ((EClass) _eType_1);
                }
                className = type.getName();
                scope.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refRefName(final RandomTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refRefName(final OtherTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_attName(final RandomTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_attName(final OtherTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_attName(final CompleteTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_attName(final SpecificObjectSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_attName(final SpecificClosureSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_attName(final TypedSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EAttribute> atts = new ArrayList<EAttribute>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          atts.addAll(this.getEAttributes(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getName();
                className = reference.getEType().getName();
                atts.addAll(this.getEAttributes(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(atts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refRefName(final CompleteTypeSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.refName must contain the references defined by com.type
   */
  public IScope scope_ReferenceEvaluation_refRefName(final SpecificObjectSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_refRefName(final SpecificClosureSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * ReferenceEvaluation.name must contain the references defined by ...
   */
  public IScope scope_ReferenceEvaluation_refRefName(final TypedSelection com, final EReference ref) {
    try {
      IScope _xblockexpression = null;
      {
        List<EReference> refs = new ArrayList<EReference>();
        final MutatorEnvironment env = this.getMutatorEnvironment(com);
        if ((env != null)) {
          final Definition definition = env.getDefinition();
          Expression _expression = com.getExpression();
          Evaluation _first = null;
          if (_expression!=null) {
            _first=_expression.getFirst();
          }
          EReference reference = ((ReferenceEvaluation) _first).getRefName();
          String className = reference.getEType().getName();
          String _metamodel = null;
          if (definition!=null) {
            _metamodel=definition.getMetamodel();
          }
          String metamodel = _metamodel;
          List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
          EClass eclass = ModelManager.getEClassByName(packages, className);
          if ((eclass == null)) {
            metamodel = this.getMetamodel(definition, className);
          }
          refs.addAll(this.getEReferences(definition, className));
          Expression _expression_1 = com.getExpression();
          EList<Evaluation> _second = null;
          if (_expression_1!=null) {
            _second=_expression_1.getSecond();
          }
          boolean _tripleNotEquals = (_second != null);
          if (_tripleNotEquals) {
            Expression _expression_2 = com.getExpression();
            EList<Evaluation> _second_1 = null;
            if (_expression_2!=null) {
              _second_1=_expression_2.getSecond();
            }
            for (final Evaluation second : _second_1) {
              if ((second instanceof ReferenceEvaluation)) {
                reference = ((ReferenceEvaluation)second).getRefName();
                className = reference.getEType().getName();
                refs.addAll(this.getEReferences(definition, className));
              }
            }
          }
        }
        _xblockexpression = Scopes.scopeFor(refs);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Constraint.type can contain any EClass from the input meta-model.
   */
  public IScope scope_Constraint_type(final Constraint c, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(c);
      final Definition definition = env.getDefinition();
      _xblockexpression = Scopes.scopeFor(this.getEClasses(definition));
    }
    return _xblockexpression;
  }

  /**
   * ListType.value can contain any EEnumLiteral from the input EEnum.
   */
  public IScope scope_ListType_value(final ReferenceAtt refAtt, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EObject> values = new ArrayList<EObject>();
      EAttribute attribute = refAtt.getAttribute();
      EClassifier _eType = attribute.getEType();
      if ((_eType instanceof EEnum)) {
        EClassifier _eType_1 = attribute.getEType();
        final EEnum en = ((EEnum) _eType_1);
        values.addAll(en.getELiterals());
      }
      _xblockexpression = Scopes.scopeFor(values);
    }
    return _xblockexpression;
  }

  /**
   * ListType.value can contain any EEnumLiteral from the input EEnum.
   */
  public IScope scope_ListType_value(final AttributeEvaluation attEv, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EObject> values = new ArrayList<EObject>();
      EAttribute attribute = attEv.getName();
      EClassifier _eType = attribute.getEType();
      if ((_eType instanceof EEnum)) {
        EClassifier _eType_1 = attribute.getEType();
        final EEnum en = ((EEnum) _eType_1);
        values.addAll(en.getELiterals());
      }
      _xblockexpression = Scopes.scopeFor(values);
    }
    return _xblockexpression;
  }

  /**
   * ListType.value can contain any EEnumLiteral from the input EEnum.
   */
  public IScope scope_ListType_value(final AttributeScalar attScal, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EObject> values = new ArrayList<EObject>();
      EAttribute attribute = attScal.getAttribute().get(0);
      EClassifier _eType = attribute.getEType();
      if ((_eType instanceof EEnum)) {
        EClassifier _eType_1 = attribute.getEType();
        final EEnum en = ((EEnum) _eType_1);
        values.addAll(en.getELiterals());
      }
      _xblockexpression = Scopes.scopeFor(values);
    }
    return _xblockexpression;
  }

  /**
   * ObjectAttributeType.objSel can contain the previous defined mutators
   */
  public IScope scope_ObjectAttributeType_objSel(final SelectObjectMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final List<EClass> containers = this.getEContainers(definition.getMetamodel(), com.getType());
      final List<String> scontainers = new ArrayList<String>();
      for (final EClassifier cl : containers) {
        scontainers.add(cl.getName());
      }
      final List<EReference> references = this.getEReferences(definition, com.getType().getName());
      for (final EReference eref : references) {
        scontainers.add(eref.getEType().getName());
      }
      final ArrayList<Mutator> scope = new ArrayList<Mutator>();
      for (final Mutator mutator : commands) {
        if (((((mutator.getName() != null) && 
          (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
          scontainers.contains(mutator.getType().getName()))) {
          scope.add(mutator);
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObjectAttributeType.objSel can contain the previous defined mutators
   */
  public IScope scope_ObjectAttributeType_objSel(final ModifyInformationMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final List<Mutator> commands = this.getCommands(com);
      final Definition definition = env.getDefinition();
      final List<EClass> containers = this.getEContainers(definition.getMetamodel(), com.getType());
      final List<String> scontainers = new ArrayList<String>();
      for (final EClassifier cl : containers) {
        scontainers.add(cl.getName());
      }
      final List<EReference> references = this.getEReferences(definition, com.getType().getName());
      for (final EReference eref : references) {
        scontainers.add(eref.getEType().getName());
      }
      final ArrayList<Mutator> scope = new ArrayList<Mutator>();
      for (final Mutator mutator : commands) {
        if (((((mutator.getName() != null) && 
          (commands.indexOf(mutator) < commands.indexOf(com))) && (((((mutator instanceof CreateObjectMutator) || (mutator instanceof ModifyInformationMutator)) || (mutator instanceof SelectObjectMutator)) || (mutator instanceof CloneObjectMutator)) || (mutator instanceof RetypeObjectMutator))) && 
          scontainers.contains(mutator.getType().getName()))) {
          scope.add(mutator);
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * ObjectAttributeType.attribute must be of the type defined by com.type
   */
  public IScope scope_ObjectAttributeType_attribute(final ObjectAttributeType com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com.getObjSel());
      List<EAttribute> attributes = new ArrayList<EAttribute>();
      Mutator mut = null;
      EObject container = com.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      mut = ((Mutator) container);
      final List<Mutator> commands = this.getCommands(mut);
      Set<String> classNames = new HashSet<String>();
      for (final Mutator command : commands) {
        String _name = command.getName();
        boolean _tripleNotEquals = (_name != null);
        if (_tripleNotEquals) {
          boolean _equals = command.getName().equals(com.getObjSel().getName());
          if (_equals) {
            classNames.addAll(this.getType(command));
          }
        }
      }
      if ((((env != null) && (classNames != null)) && (classNames.size() > 0))) {
        final Definition definition = env.getDefinition();
        EObject sel = com.getObjSel();
        if ((((sel instanceof SelectObjectMutator) && 
          (((SelectObjectMutator) sel).getObject() instanceof RandomTypeSelection)) && 
          (((RandomTypeSelection) ((SelectObjectMutator) sel).getObject()).getResource() != null))) {
          ObSelectionStrategy _object = ((SelectObjectMutator) sel).getObject();
          final String resourceName = ((RandomTypeSelection) _object).getResource();
          if ((definition instanceof Program)) {
            final Program program = ((Program) definition);
            Resource resource = null;
            EList<Resource> _resources = program.getResources();
            for (final Resource res : _resources) {
              boolean _equals_1 = res.getName().equals(resourceName);
              if (_equals_1) {
                resource = res;
              }
            }
          }
        }
        for (final String className : classNames) {
          attributes.addAll(this.getEAttributes(definition, className));
        }
      }
      _xblockexpression = Scopes.scopeFor(attributes);
    }
    return _xblockexpression;
  }

  /**
   * MinValueType.attribute must be of the type defined by com.type
   */
  public IScope scope_MinValueType_attribute(final MinValueType com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EAttribute> scopes = new ArrayList<EAttribute>();
      Mutator mut = null;
      EObject container = com.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      if ((container != null)) {
        mut = ((Mutator) container);
        final MutatorEnvironment env = this.getMutatorEnvironment(mut);
        final Definition definition = env.getDefinition();
        String className = null;
        if ((mut instanceof CreateObjectMutator)) {
          className = ((CreateObjectMutator)mut).getType().getName();
        }
        if ((mut instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object = ((CloneObjectMutator)mut).getObject();
          if ((_object instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_1 = ((CloneObjectMutator)mut).getObject();
            final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_1);
            ObjectEmitter _objSel = selection.getObjSel();
            if ((_objSel instanceof CreateObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_1 = selection.getObjSel();
            if ((_objSel_1 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_2 = selection.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
            }
            ObjectEmitter _objSel_3 = selection.getObjSel();
            if ((_objSel_3 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_4 = selection.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
            }
            ObjectEmitter _objSel_5 = selection.getObjSel();
            if ((_objSel_5 instanceof CloneObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_6 = selection.getObjSel();
            if ((_objSel_6 instanceof RetypeObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_2 = ((CloneObjectMutator)mut).getObject();
          if ((_object_2 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_3 = ((CloneObjectMutator)mut).getObject();
            final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_3);
            ObjectEmitter _objSel_7 = selection_1.getObjSel();
            if ((_objSel_7 instanceof CreateObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_8 = selection_1.getObjSel();
            if ((_objSel_8 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_9 = selection_1.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_9));
            }
            ObjectEmitter _objSel_10 = selection_1.getObjSel();
            if ((_objSel_10 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_11 = selection_1.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_11));
            }
            ObjectEmitter _objSel_12 = selection_1.getObjSel();
            if ((_objSel_12 instanceof CloneObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            if ((_objSel_13 instanceof RetypeObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_4 = ((CloneObjectMutator)mut).getObject();
          if ((_object_4 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_5 = ((CloneObjectMutator)mut).getObject();
            final RandomTypeSelection selection_2 = ((RandomTypeSelection) _object_5);
            className = selection_2.getType().getName();
          }
          ObSelectionStrategy _object_6 = ((CloneObjectMutator)mut).getObject();
          if ((_object_6 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_7 = ((CloneObjectMutator)mut).getObject();
            final CompleteTypeSelection selection_3 = ((CompleteTypeSelection) _object_7);
            className = selection_3.getType().getName();
          }
          ObSelectionStrategy _object_8 = ((CloneObjectMutator)mut).getObject();
          if ((_object_8 instanceof TypedSelection)) {
            ObSelectionStrategy _object_9 = ((CloneObjectMutator)mut).getObject();
            final TypedSelection selection_4 = ((TypedSelection) _object_9);
            className = selection_4.getType().getName();
          }
        }
        if ((mut instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_10 = ((SelectObjectMutator)mut).getObject();
          if ((_object_10 instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_11 = ((SelectObjectMutator)mut).getObject();
            final SpecificObjectSelection selection_5 = ((SpecificObjectSelection) _object_11);
            ObjectEmitter _objSel_14 = selection_5.getObjSel();
            if ((_objSel_14 instanceof CreateObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_15 = selection_5.getObjSel();
            if ((_objSel_15 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_16 = selection_5.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_16));
            }
            ObjectEmitter _objSel_17 = selection_5.getObjSel();
            if ((_objSel_17 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_18 = selection_5.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_18));
            }
            ObjectEmitter _objSel_19 = selection_5.getObjSel();
            if ((_objSel_19 instanceof CloneObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_20 = selection_5.getObjSel();
            if ((_objSel_20 instanceof RetypeObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_12 = ((SelectObjectMutator)mut).getObject();
          if ((_object_12 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_13 = ((SelectObjectMutator)mut).getObject();
            final SpecificClosureSelection selection_6 = ((SpecificClosureSelection) _object_13);
            ObjectEmitter _objSel_21 = selection_6.getObjSel();
            if ((_objSel_21 instanceof CreateObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_22 = selection_6.getObjSel();
            if ((_objSel_22 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_23 = selection_6.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_23));
            }
            ObjectEmitter _objSel_24 = selection_6.getObjSel();
            if ((_objSel_24 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_25 = selection_6.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_25));
            }
            ObjectEmitter _objSel_26 = selection_6.getObjSel();
            if ((_objSel_26 instanceof CloneObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_27 = selection_6.getObjSel();
            if ((_objSel_27 instanceof RetypeObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_14 = ((SelectObjectMutator)mut).getObject();
          if ((_object_14 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_15 = ((SelectObjectMutator)mut).getObject();
            final RandomTypeSelection selection_7 = ((RandomTypeSelection) _object_15);
            className = selection_7.getType().getName();
          }
          ObSelectionStrategy _object_16 = ((SelectObjectMutator)mut).getObject();
          if ((_object_16 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_17 = ((SelectObjectMutator)mut).getObject();
            final CompleteTypeSelection selection_8 = ((CompleteTypeSelection) _object_17);
            className = selection_8.getType().getName();
          }
          ObSelectionStrategy _object_18 = ((SelectObjectMutator)mut).getObject();
          if ((_object_18 instanceof TypedSelection)) {
            ObSelectionStrategy _object_19 = ((SelectObjectMutator)mut).getObject();
            final TypedSelection selection_9 = ((TypedSelection) _object_19);
            className = selection_9.getType().getName();
          }
        }
        if ((mut instanceof ModifyInformationMutator)) {
          ObSelectionStrategy _object_20 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_20 instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_21 = ((ModifyInformationMutator)mut).getObject();
            final SpecificObjectSelection selection_10 = ((SpecificObjectSelection) _object_21);
            ObjectEmitter _objSel_28 = selection_10.getObjSel();
            if ((_objSel_28 instanceof CreateObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_29 = selection_10.getObjSel();
            if ((_objSel_29 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_30 = selection_10.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_30));
            }
            ObjectEmitter _objSel_31 = selection_10.getObjSel();
            if ((_objSel_31 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_32 = selection_10.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_32));
            }
            ObjectEmitter _objSel_33 = selection_10.getObjSel();
            if ((_objSel_33 instanceof CloneObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_34 = selection_10.getObjSel();
            if ((_objSel_34 instanceof RetypeObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_22 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_22 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_23 = ((ModifyInformationMutator)mut).getObject();
            final SpecificClosureSelection selection_11 = ((SpecificClosureSelection) _object_23);
            ObjectEmitter _objSel_35 = selection_11.getObjSel();
            if ((_objSel_35 instanceof CreateObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_36 = selection_11.getObjSel();
            if ((_objSel_36 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_37 = selection_11.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_37));
            }
            ObjectEmitter _objSel_38 = selection_11.getObjSel();
            if ((_objSel_38 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_39 = selection_11.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_39));
            }
            ObjectEmitter _objSel_40 = selection_11.getObjSel();
            if ((_objSel_40 instanceof CloneObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_41 = selection_11.getObjSel();
            if ((_objSel_41 instanceof RetypeObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_24 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_24 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_25 = ((ModifyInformationMutator)mut).getObject();
            final RandomTypeSelection selection_12 = ((RandomTypeSelection) _object_25);
            className = selection_12.getType().getName();
          }
          ObSelectionStrategy _object_26 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_26 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_27 = ((ModifyInformationMutator)mut).getObject();
            final CompleteTypeSelection selection_13 = ((CompleteTypeSelection) _object_27);
            className = selection_13.getType().getName();
          }
          ObSelectionStrategy _object_28 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_28 instanceof TypedSelection)) {
            ObSelectionStrategy _object_29 = ((ModifyInformationMutator)mut).getObject();
            final TypedSelection selection_14 = ((TypedSelection) _object_29);
            className = selection_14.getType().getName();
          }
        }
        if ((className != null)) {
          scopes.addAll(this.getEAttributes(definition, className));
        }
      }
      _xblockexpression = Scopes.scopeFor(scopes);
    }
    return _xblockexpression;
  }

  /**
   * MaxValueType.attribute must be of the type defined by com.type
   */
  public IScope scope_MaxValueType_attribute(final MaxValueType com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EAttribute> scopes = new ArrayList<EAttribute>();
      Mutator mut = null;
      EObject container = com.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        container = container.eContainer();
      }
      if ((container != null)) {
        mut = ((Mutator) container);
        final MutatorEnvironment env = this.getMutatorEnvironment(mut);
        final Definition definition = env.getDefinition();
        String className = null;
        if ((mut instanceof CreateObjectMutator)) {
          className = ((CreateObjectMutator)mut).getType().getName();
        }
        if ((mut instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object = ((CloneObjectMutator)mut).getObject();
          if ((_object instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_1 = ((CloneObjectMutator)mut).getObject();
            final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_1);
            ObjectEmitter _objSel = selection.getObjSel();
            if ((_objSel instanceof CreateObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_1 = selection.getObjSel();
            if ((_objSel_1 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_2 = selection.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
            }
            ObjectEmitter _objSel_3 = selection.getObjSel();
            if ((_objSel_3 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_4 = selection.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
            }
            ObjectEmitter _objSel_5 = selection.getObjSel();
            if ((_objSel_5 instanceof CloneObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_6 = selection.getObjSel();
            if ((_objSel_6 instanceof RetypeObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_2 = ((CloneObjectMutator)mut).getObject();
          if ((_object_2 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_3 = ((CloneObjectMutator)mut).getObject();
            final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_3);
            ObjectEmitter _objSel_7 = selection_1.getObjSel();
            if ((_objSel_7 instanceof CreateObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_8 = selection_1.getObjSel();
            if ((_objSel_8 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_9 = selection_1.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_9));
            }
            ObjectEmitter _objSel_10 = selection_1.getObjSel();
            if ((_objSel_10 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_11 = selection_1.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_11));
            }
            ObjectEmitter _objSel_12 = selection_1.getObjSel();
            if ((_objSel_12 instanceof CloneObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_13 = selection_1.getObjSel();
            if ((_objSel_13 instanceof RetypeObjectMutator)) {
              className = selection_1.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_4 = ((CloneObjectMutator)mut).getObject();
          if ((_object_4 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_5 = ((CloneObjectMutator)mut).getObject();
            final RandomTypeSelection selection_2 = ((RandomTypeSelection) _object_5);
            className = selection_2.getType().getName();
          }
          ObSelectionStrategy _object_6 = ((CloneObjectMutator)mut).getObject();
          if ((_object_6 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_7 = ((CloneObjectMutator)mut).getObject();
            final CompleteTypeSelection selection_3 = ((CompleteTypeSelection) _object_7);
            className = selection_3.getType().getName();
          }
          ObSelectionStrategy _object_8 = ((CloneObjectMutator)mut).getObject();
          if ((_object_8 instanceof TypedSelection)) {
            ObSelectionStrategy _object_9 = ((CloneObjectMutator)mut).getObject();
            final TypedSelection selection_4 = ((TypedSelection) _object_9);
            className = selection_4.getType().getName();
          }
        }
        if ((mut instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_10 = ((SelectObjectMutator)mut).getObject();
          if ((_object_10 instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_11 = ((SelectObjectMutator)mut).getObject();
            final SpecificObjectSelection selection_5 = ((SpecificObjectSelection) _object_11);
            ObjectEmitter _objSel_14 = selection_5.getObjSel();
            if ((_objSel_14 instanceof CreateObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_15 = selection_5.getObjSel();
            if ((_objSel_15 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_16 = selection_5.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_16));
            }
            ObjectEmitter _objSel_17 = selection_5.getObjSel();
            if ((_objSel_17 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_18 = selection_5.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_18));
            }
            ObjectEmitter _objSel_19 = selection_5.getObjSel();
            if ((_objSel_19 instanceof CloneObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_20 = selection_5.getObjSel();
            if ((_objSel_20 instanceof RetypeObjectMutator)) {
              className = selection_5.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_12 = ((SelectObjectMutator)mut).getObject();
          if ((_object_12 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_13 = ((SelectObjectMutator)mut).getObject();
            final SpecificClosureSelection selection_6 = ((SpecificClosureSelection) _object_13);
            ObjectEmitter _objSel_21 = selection_6.getObjSel();
            if ((_objSel_21 instanceof CreateObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_22 = selection_6.getObjSel();
            if ((_objSel_22 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_23 = selection_6.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_23));
            }
            ObjectEmitter _objSel_24 = selection_6.getObjSel();
            if ((_objSel_24 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_25 = selection_6.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_25));
            }
            ObjectEmitter _objSel_26 = selection_6.getObjSel();
            if ((_objSel_26 instanceof CloneObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_27 = selection_6.getObjSel();
            if ((_objSel_27 instanceof RetypeObjectMutator)) {
              className = selection_6.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_14 = ((SelectObjectMutator)mut).getObject();
          if ((_object_14 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_15 = ((SelectObjectMutator)mut).getObject();
            final RandomTypeSelection selection_7 = ((RandomTypeSelection) _object_15);
            className = selection_7.getType().getName();
          }
          ObSelectionStrategy _object_16 = ((SelectObjectMutator)mut).getObject();
          if ((_object_16 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_17 = ((SelectObjectMutator)mut).getObject();
            final CompleteTypeSelection selection_8 = ((CompleteTypeSelection) _object_17);
            className = selection_8.getType().getName();
          }
          ObSelectionStrategy _object_18 = ((SelectObjectMutator)mut).getObject();
          if ((_object_18 instanceof TypedSelection)) {
            ObSelectionStrategy _object_19 = ((SelectObjectMutator)mut).getObject();
            final TypedSelection selection_9 = ((TypedSelection) _object_19);
            className = selection_9.getType().getName();
          }
        }
        if ((mut instanceof ModifyInformationMutator)) {
          ObSelectionStrategy _object_20 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_20 instanceof SpecificObjectSelection)) {
            ObSelectionStrategy _object_21 = ((ModifyInformationMutator)mut).getObject();
            final SpecificObjectSelection selection_10 = ((SpecificObjectSelection) _object_21);
            ObjectEmitter _objSel_28 = selection_10.getObjSel();
            if ((_objSel_28 instanceof CreateObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_29 = selection_10.getObjSel();
            if ((_objSel_29 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_30 = selection_10.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_30));
            }
            ObjectEmitter _objSel_31 = selection_10.getObjSel();
            if ((_objSel_31 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_32 = selection_10.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_32));
            }
            ObjectEmitter _objSel_33 = selection_10.getObjSel();
            if ((_objSel_33 instanceof CloneObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_34 = selection_10.getObjSel();
            if ((_objSel_34 instanceof RetypeObjectMutator)) {
              className = selection_10.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_22 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_22 instanceof SpecificClosureSelection)) {
            ObSelectionStrategy _object_23 = ((ModifyInformationMutator)mut).getObject();
            final SpecificClosureSelection selection_11 = ((SpecificClosureSelection) _object_23);
            ObjectEmitter _objSel_35 = selection_11.getObjSel();
            if ((_objSel_35 instanceof CreateObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_36 = selection_11.getObjSel();
            if ((_objSel_36 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_37 = selection_11.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_37));
            }
            ObjectEmitter _objSel_38 = selection_11.getObjSel();
            if ((_objSel_38 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_39 = selection_11.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_39));
            }
            ObjectEmitter _objSel_40 = selection_11.getObjSel();
            if ((_objSel_40 instanceof CloneObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_41 = selection_11.getObjSel();
            if ((_objSel_41 instanceof RetypeObjectMutator)) {
              className = selection_11.getObjSel().getType().getName();
            }
          }
          ObSelectionStrategy _object_24 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_24 instanceof RandomTypeSelection)) {
            ObSelectionStrategy _object_25 = ((ModifyInformationMutator)mut).getObject();
            final RandomTypeSelection selection_12 = ((RandomTypeSelection) _object_25);
            className = selection_12.getType().getName();
          }
          ObSelectionStrategy _object_26 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_26 instanceof CompleteTypeSelection)) {
            ObSelectionStrategy _object_27 = ((ModifyInformationMutator)mut).getObject();
            final CompleteTypeSelection selection_13 = ((CompleteTypeSelection) _object_27);
            className = selection_13.getType().getName();
          }
          ObSelectionStrategy _object_28 = ((ModifyInformationMutator)mut).getObject();
          if ((_object_28 instanceof TypedSelection)) {
            ObSelectionStrategy _object_29 = ((ModifyInformationMutator)mut).getObject();
            final TypedSelection selection_14 = ((TypedSelection) _object_29);
            className = selection_14.getType().getName();
          }
        }
        if ((className != null)) {
          scopes.addAll(this.getEAttributes(definition, className));
        }
      }
      _xblockexpression = Scopes.scopeFor(scopes);
    }
    return _xblockexpression;
  }

  /**
   * RandomNumberType.attribute must be of the type defined by com.type
   */
  public IScope scope_RandomNumberType_max(final RandomNumberType com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      ArrayList<EAttribute> scopes = new ArrayList<EAttribute>();
      String className = null;
      Definition definition = null;
      Mutator mut = null;
      EObject container = com.eContainer();
      while ((((container instanceof Mutator) == false) && (container != null))) {
        {
          container = container.eContainer();
          mut = ((Mutator) container);
          final MutatorEnvironment env = this.getMutatorEnvironment(mut);
          definition = env.getDefinition();
        }
      }
      ObSelectionStrategy _object = com.getObject();
      boolean _tripleNotEquals = (_object != null);
      if (_tripleNotEquals) {
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_2 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_2);
          ObjectEmitter _objSel = selection.getObjSel();
          if ((_objSel instanceof CreateObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_1 = selection.getObjSel();
          if ((_objSel_1 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_2 = selection.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
          }
          ObjectEmitter _objSel_3 = selection.getObjSel();
          if ((_objSel_3 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_4 = selection.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
          }
          ObjectEmitter _objSel_5 = selection.getObjSel();
          if ((_objSel_5 instanceof CloneObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_6 = selection.getObjSel();
          if ((_objSel_6 instanceof RetypeObjectMutator)) {
            className = selection.getObjSel().getType().getName();
          }
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_4);
          ObjectEmitter _objSel_7 = selection_1.getObjSel();
          if ((_objSel_7 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_8 = selection_1.getObjSel();
          if ((_objSel_8 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_9 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_9));
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_13 = selection_1.getObjSel();
          if ((_objSel_13 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof RandomTypeSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final RandomTypeSelection selection_2 = ((RandomTypeSelection) _object_6);
          className = selection_2.getType().getName();
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof CompleteTypeSelection)) {
          ObSelectionStrategy _object_8 = com.getObject();
          final CompleteTypeSelection selection_3 = ((CompleteTypeSelection) _object_8);
          className = selection_3.getType().getName();
        }
        ObSelectionStrategy _object_9 = com.getObject();
        if ((_object_9 instanceof TypedSelection)) {
          ObSelectionStrategy _object_10 = com.getObject();
          final TypedSelection selection_4 = ((TypedSelection) _object_10);
          className = selection_4.getType().getName();
        }
        scopes.addAll(this.getEAttributes(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scopes);
    }
    return _xblockexpression;
  }

  /**
   * SelectSampleMutator.features must be features of the type defined by com.type
   */
  public IScope scope_SelectSampleMutator_features(final SelectSampleMutator com, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final MutatorEnvironment env = this.getMutatorEnvironment(com);
      final Definition definition = env.getDefinition();
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      ObSelectionStrategy _object = com.getObject();
      if ((_object instanceof ObSelectionStrategy)) {
        String className = null;
        ObSelectionStrategy _object_1 = com.getObject();
        if ((_object_1 instanceof RandomTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_2 = com.getObject();
        if ((_object_2 instanceof CompleteTypeSelection)) {
          className = com.getObject().getType().getName();
        }
        ObSelectionStrategy _object_3 = com.getObject();
        if ((_object_3 instanceof SpecificObjectSelection)) {
          ObSelectionStrategy _object_4 = com.getObject();
          final SpecificObjectSelection selection = ((SpecificObjectSelection) _object_4);
          EReference _refType = selection.getRefType();
          boolean _tripleEquals = (_refType == null);
          if (_tripleEquals) {
            ObjectEmitter _objSel = selection.getObjSel();
            if ((_objSel instanceof CreateObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_1 = selection.getObjSel();
            if ((_objSel_1 instanceof SelectObjectMutator)) {
              ObjectEmitter _objSel_2 = selection.getObjSel();
              className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_2));
            }
            ObjectEmitter _objSel_3 = selection.getObjSel();
            if ((_objSel_3 instanceof SelectSampleMutator)) {
              ObjectEmitter _objSel_4 = selection.getObjSel();
              className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_4));
            }
            ObjectEmitter _objSel_5 = selection.getObjSel();
            if ((_objSel_5 instanceof CloneObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
            ObjectEmitter _objSel_6 = selection.getObjSel();
            if ((_objSel_6 instanceof RetypeObjectMutator)) {
              className = selection.getObjSel().getType().getName();
            }
          } else {
            className = selection.getRefType().getEType().getName();
          }
        }
        ObSelectionStrategy _object_5 = com.getObject();
        if ((_object_5 instanceof SpecificClosureSelection)) {
          ObSelectionStrategy _object_6 = com.getObject();
          final SpecificClosureSelection selection_1 = ((SpecificClosureSelection) _object_6);
          ObjectEmitter _objSel_7 = selection_1.getObjSel();
          if ((_objSel_7 instanceof CreateObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_8 = selection_1.getObjSel();
          if ((_objSel_8 instanceof SelectObjectMutator)) {
            ObjectEmitter _objSel_9 = selection_1.getObjSel();
            className = MutatorUtils.selectObjectMutatorHelperName(((SelectObjectMutator) _objSel_9));
          }
          ObjectEmitter _objSel_10 = selection_1.getObjSel();
          if ((_objSel_10 instanceof SelectSampleMutator)) {
            ObjectEmitter _objSel_11 = selection_1.getObjSel();
            className = MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) _objSel_11));
          }
          ObjectEmitter _objSel_12 = selection_1.getObjSel();
          if ((_objSel_12 instanceof CloneObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
          ObjectEmitter _objSel_13 = selection_1.getObjSel();
          if ((_objSel_13 instanceof RetypeObjectMutator)) {
            className = selection_1.getObjSel().getType().getName();
          }
        }
        ObSelectionStrategy _object_7 = com.getObject();
        if ((_object_7 instanceof TypedSelection)) {
          className = com.getObject().getType().getName();
        }
        scope.addAll(this.getEAttributes(definition, className));
        scope.addAll(this.getEReferences(definition, className));
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * PathElementCS.pathName can contain any EStructuralFeature defined by the
   * constraint.type.name
   */
  public IScope scope_PathElementCS_pathName(final Constraint constraint, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      EObject container = constraint.eContainer();
      while (((container != null) && ((container instanceof MutatorEnvironment) == false))) {
        container = container.eContainer();
      }
      final MutatorEnvironment env = ((MutatorEnvironment) container);
      final Definition definition = env.getDefinition();
      scope.addAll(this.getEStructuralFeatures(definition.getMetamodel(), constraint.getType().getName()));
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * PathElementCS.pathName can contain any EStructuralFeature defined by the
   * expression variable
   */
  public IScope scope_NavigationPathElementCS_pathName(final InvariantCS invariant, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>();
      EObject container = invariant.eContainer();
      while (((container != null) && ((container instanceof MutatorEnvironment) == false))) {
        container = container.eContainer();
      }
      final MutatorEnvironment env = ((MutatorEnvironment) container);
      final Definition definition = env.getDefinition();
      ExpCS _exp = invariant.getExp();
      if ((_exp instanceof CallExpCS)) {
        ExpCS _exp_1 = invariant.getExp();
        final CallExpCS callExpCS = ((CallExpCS) _exp_1);
        CallExpCS _source = callExpCS.getSource();
        if ((_source instanceof NameExpCS)) {
          CallExpCS _source_1 = callExpCS.getSource();
          final NameExpCS nameExpCS = ((NameExpCS) _source_1);
          PathCS _get = nameExpCS.getExpName().getPath().get(0);
          final PathElementCS pathElementCS = ((PathElementCS) _get);
          scope.addAll(this.getEStructuralFeatures(definition.getMetamodel(), pathElementCS.getPathName().getEType().getName()));
        }
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }

  /**
   * It returns the mutator environment that contains an object
   */
  private MutatorEnvironment getMutatorEnvironment(final ObjectEmitter oe) {
    return EcoreUtil2.<MutatorEnvironment>getContainerOfType(oe, MutatorEnvironment.class);
  }

  private MutatorEnvironment getMutatorEnvironment(final ReferenceSet oe) {
    return EcoreUtil2.<MutatorEnvironment>getContainerOfType(oe, MutatorEnvironment.class);
  }

  private MutatorEnvironment getMutatorEnvironment(final Constraint oe) {
    return EcoreUtil2.<MutatorEnvironment>getContainerOfType(oe, MutatorEnvironment.class);
  }

  /**
   * It returns the list of commands in the scope of the received mutator.
   * The scope can be either the environment or a composite mutator.
   * @param Mutator
   * @return List<Mutator>
   */
  private List<Mutator> getCommands(final Mutator com) {
    EObject _eContainer = com.eContainer();
    if ((_eContainer instanceof Block)) {
      EObject _eContainer_1 = com.eContainer();
      return ((Block) _eContainer_1).getCommands();
    }
    EObject _eContainer_2 = com.eContainer();
    if ((_eContainer_2 instanceof CompositeMutator)) {
      EObject _eContainer_3 = com.eContainer();
      return ((CompositeMutator) _eContainer_3).getCommands();
    }
    EObject _eContainer_4 = com.eContainer();
    if ((_eContainer_4 instanceof MutatorEnvironment)) {
      EObject _eContainer_5 = com.eContainer();
      return ((MutatorEnvironment) _eContainer_5).getCommands();
    }
    return new ArrayList<Mutator>();
  }

  /**
   * It returns the type to which a mutator applies.
   */
  private Set<String> getType(final Mutator mutator) {
    Set<String> types = new HashSet<String>();
    if ((mutator instanceof SelectObjectMutator)) {
      ObSelectionStrategy _object = ((SelectObjectMutator) mutator).getObject();
      EClass _type = null;
      if (_object!=null) {
        _type=_object.getType();
      }
      String _name = null;
      if (_type!=null) {
        _name=_type.getName();
      }
      types.add(_name);
    }
    if ((mutator instanceof SelectSampleMutator)) {
      ObSelectionStrategy _object_1 = ((SelectSampleMutator) mutator).getObject();
      if ((_object_1 instanceof RandomTypeSelection)) {
        ObSelectionStrategy _object_2 = ((SelectSampleMutator) mutator).getObject();
        EClass _type_1 = null;
        if (_object_2!=null) {
          _type_1=_object_2.getType();
        }
        String _name_1 = null;
        if (_type_1!=null) {
          _name_1=_type_1.getName();
        }
        types.add(_name_1);
      }
      ObSelectionStrategy _object_3 = ((SelectSampleMutator) mutator).getObject();
      if ((_object_3 instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_4 = ((SelectSampleMutator) mutator).getObject();
        EReference _refType = ((SpecificObjectSelection) _object_4).getRefType();
        boolean _tripleEquals = (_refType == null);
        if (_tripleEquals) {
          ObSelectionStrategy _object_5 = ((SelectSampleMutator) mutator).getObject();
          final ObjectEmitter o = ((SpecificObjectSelection) _object_5).getObjSel();
          if ((o instanceof SelectObjectMutator)) {
            ObSelectionStrategy _object_6 = ((SelectObjectMutator) o).getObject();
            EClass _type_2 = null;
            if (_object_6!=null) {
              _type_2=_object_6.getType();
            }
            String _name_2 = null;
            if (_type_2!=null) {
              _name_2=_type_2.getName();
            }
            types.add(_name_2);
          }
          if ((o instanceof CreateObjectMutator)) {
            EClass _type_3 = ((CreateObjectMutator) o).getType();
            String _name_3 = null;
            if (_type_3!=null) {
              _name_3=_type_3.getName();
            }
            types.add(_name_3);
          }
          if ((o instanceof SelectSampleMutator)) {
            types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o)));
          }
          if ((o instanceof CloneObjectMutator)) {
            ObSelectionStrategy _object_7 = ((CloneObjectMutator) o).getObject();
            EClass _type_4 = null;
            if (_object_7!=null) {
              _type_4=_object_7.getType();
            }
            String _name_4 = null;
            if (_type_4!=null) {
              _name_4=_type_4.getName();
            }
            types.add(_name_4);
          }
          if ((o instanceof RetypeObjectMutator)) {
            ObSelectionStrategy _object_8 = ((RetypeObjectMutator) o).getObject();
            EClass _type_5 = null;
            if (_object_8!=null) {
              _type_5=_object_8.getType();
            }
            String _name_5 = null;
            if (_type_5!=null) {
              _name_5=_type_5.getName();
            }
            types.add(_name_5);
            EClass _type_6 = ((RetypeObjectMutator) o).getType();
            String _name_6 = null;
            if (_type_6!=null) {
              _name_6=_type_6.getName();
            }
            types.add(_name_6);
            EList<EClass> _types = null;
            if (((RetypeObjectMutator) o)!=null) {
              _types=((RetypeObjectMutator) o).getTypes();
            }
            for (final EClass type : _types) {
              types.add(type.getName());
            }
          }
        } else {
          ObSelectionStrategy _object_9 = ((SelectSampleMutator) mutator).getObject();
          types.add(((SpecificObjectSelection) _object_9).getRefType().getEType().getName());
        }
      }
      ObSelectionStrategy _object_10 = ((SelectSampleMutator) mutator).getObject();
      if ((_object_10 instanceof SpecificClosureSelection)) {
        ObSelectionStrategy _object_11 = ((SelectSampleMutator) mutator).getObject();
        EReference _refType_1 = ((SpecificObjectSelection) _object_11).getRefType();
        boolean _tripleEquals_1 = (_refType_1 == null);
        if (_tripleEquals_1) {
          ObSelectionStrategy _object_12 = ((SelectSampleMutator) mutator).getObject();
          final ObjectEmitter o_1 = ((SpecificClosureSelection) _object_12).getObjSel();
          if ((o_1 instanceof SelectObjectMutator)) {
            ObSelectionStrategy _object_13 = ((SelectObjectMutator) o_1).getObject();
            EClass _type_7 = null;
            if (_object_13!=null) {
              _type_7=_object_13.getType();
            }
            String _name_7 = null;
            if (_type_7!=null) {
              _name_7=_type_7.getName();
            }
            types.add(_name_7);
          }
          if ((o_1 instanceof CreateObjectMutator)) {
            EClass _type_8 = ((CreateObjectMutator) o_1).getType();
            String _name_8 = null;
            if (_type_8!=null) {
              _name_8=_type_8.getName();
            }
            types.add(_name_8);
          }
          if ((o_1 instanceof SelectSampleMutator)) {
            types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o_1)));
          }
          if ((o_1 instanceof CloneObjectMutator)) {
            ObSelectionStrategy _object_14 = ((CloneObjectMutator) o_1).getObject();
            EClass _type_9 = null;
            if (_object_14!=null) {
              _type_9=_object_14.getType();
            }
            String _name_9 = null;
            if (_type_9!=null) {
              _name_9=_type_9.getName();
            }
            types.add(_name_9);
          }
          if ((o_1 instanceof RetypeObjectMutator)) {
            ObSelectionStrategy _object_15 = ((RetypeObjectMutator) o_1).getObject();
            EClass _type_10 = null;
            if (_object_15!=null) {
              _type_10=_object_15.getType();
            }
            String _name_10 = null;
            if (_type_10!=null) {
              _name_10=_type_10.getName();
            }
            types.add(_name_10);
            EClass _type_11 = ((RetypeObjectMutator) o_1).getType();
            String _name_11 = null;
            if (_type_11!=null) {
              _name_11=_type_11.getName();
            }
            types.add(_name_11);
            EList<EClass> _types_1 = null;
            if (((RetypeObjectMutator) o_1)!=null) {
              _types_1=((RetypeObjectMutator) o_1).getTypes();
            }
            for (final EClass type_1 : _types_1) {
              types.add(type_1.getName());
            }
          }
        } else {
          ObSelectionStrategy _object_16 = ((SelectSampleMutator) mutator).getObject();
          types.add(((SpecificClosureSelection) _object_16).getRefType().getEType().getName());
        }
      }
      ObSelectionStrategy _object_17 = ((SelectSampleMutator) mutator).getObject();
      if ((_object_17 instanceof TypedSelection)) {
        ObSelectionStrategy _object_18 = ((SelectSampleMutator) mutator).getObject();
        EClass _type_12 = null;
        if (_object_18!=null) {
          _type_12=_object_18.getType();
        }
        String _name_12 = null;
        if (_type_12!=null) {
          _name_12=_type_12.getName();
        }
        types.add(_name_12);
      }
    }
    if ((mutator instanceof ModifyInformationMutator)) {
      ObSelectionStrategy _object_19 = ((ModifyInformationMutator) mutator).getObject();
      if ((_object_19 instanceof RandomTypeSelection)) {
        ObSelectionStrategy _object_20 = ((ModifyInformationMutator) mutator).getObject();
        EClass _type_13 = null;
        if (_object_20!=null) {
          _type_13=_object_20.getType();
        }
        String _name_13 = null;
        if (_type_13!=null) {
          _name_13=_type_13.getName();
        }
        types.add(_name_13);
      }
      ObSelectionStrategy _object_21 = ((ModifyInformationMutator) mutator).getObject();
      if ((_object_21 instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_22 = ((ModifyInformationMutator) mutator).getObject();
        final ObjectEmitter o_2 = ((SpecificObjectSelection) _object_22).getObjSel();
        if ((o_2 instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_23 = ((SelectObjectMutator) o_2).getObject();
          EClass _type_14 = null;
          if (_object_23!=null) {
            _type_14=_object_23.getType();
          }
          String _name_14 = null;
          if (_type_14!=null) {
            _name_14=_type_14.getName();
          }
          types.add(_name_14);
        }
        if ((o_2 instanceof CreateObjectMutator)) {
          EClass _type_15 = ((CreateObjectMutator) o_2).getType();
          String _name_15 = null;
          if (_type_15!=null) {
            _name_15=_type_15.getName();
          }
          types.add(_name_15);
        }
        if ((o_2 instanceof SelectSampleMutator)) {
          types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o_2)));
        }
        if ((o_2 instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object_24 = ((CloneObjectMutator) o_2).getObject();
          EClass _type_16 = null;
          if (_object_24!=null) {
            _type_16=_object_24.getType();
          }
          String _name_16 = null;
          if (_type_16!=null) {
            _name_16=_type_16.getName();
          }
          types.add(_name_16);
        }
        if ((o_2 instanceof RetypeObjectMutator)) {
          ObSelectionStrategy _object_25 = ((RetypeObjectMutator) o_2).getObject();
          EClass _type_17 = null;
          if (_object_25!=null) {
            _type_17=_object_25.getType();
          }
          String _name_17 = null;
          if (_type_17!=null) {
            _name_17=_type_17.getName();
          }
          types.add(_name_17);
          EClass _type_18 = ((RetypeObjectMutator) o_2).getType();
          String _name_18 = null;
          if (_type_18!=null) {
            _name_18=_type_18.getName();
          }
          types.add(_name_18);
          EList<EClass> _types_2 = null;
          if (((RetypeObjectMutator) o_2)!=null) {
            _types_2=((RetypeObjectMutator) o_2).getTypes();
          }
          for (final EClass type_2 : _types_2) {
            types.add(type_2.getName());
          }
        }
      }
      ObSelectionStrategy _object_26 = ((ModifyInformationMutator) mutator).getObject();
      if ((_object_26 instanceof SpecificClosureSelection)) {
        ObSelectionStrategy _object_27 = ((ModifyInformationMutator) mutator).getObject();
        final ObjectEmitter o_3 = ((SpecificClosureSelection) _object_27).getObjSel();
        if ((o_3 instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_28 = ((SelectObjectMutator) o_3).getObject();
          EClass _type_19 = null;
          if (_object_28!=null) {
            _type_19=_object_28.getType();
          }
          String _name_19 = null;
          if (_type_19!=null) {
            _name_19=_type_19.getName();
          }
          types.add(_name_19);
        }
        if ((o_3 instanceof CreateObjectMutator)) {
          EClass _type_20 = ((CreateObjectMutator) o_3).getType();
          String _name_20 = null;
          if (_type_20!=null) {
            _name_20=_type_20.getName();
          }
          types.add(_name_20);
        }
        if ((o_3 instanceof SelectSampleMutator)) {
          types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o_3)));
        }
        if ((o_3 instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object_29 = ((CloneObjectMutator) o_3).getObject();
          EClass _type_21 = null;
          if (_object_29!=null) {
            _type_21=_object_29.getType();
          }
          String _name_21 = null;
          if (_type_21!=null) {
            _name_21=_type_21.getName();
          }
          types.add(_name_21);
        }
        if ((o_3 instanceof RetypeObjectMutator)) {
          ObSelectionStrategy _object_30 = ((RetypeObjectMutator) o_3).getObject();
          EClass _type_22 = null;
          if (_object_30!=null) {
            _type_22=_object_30.getType();
          }
          String _name_22 = null;
          if (_type_22!=null) {
            _name_22=_type_22.getName();
          }
          types.add(_name_22);
          EClass _type_23 = ((RetypeObjectMutator) o_3).getType();
          String _name_23 = null;
          if (_type_23!=null) {
            _name_23=_type_23.getName();
          }
          types.add(_name_23);
          EList<EClass> _types_3 = null;
          if (((RetypeObjectMutator) o_3)!=null) {
            _types_3=((RetypeObjectMutator) o_3).getTypes();
          }
          for (final EClass type_3 : _types_3) {
            types.add(type_3.getName());
          }
        }
      }
      ObSelectionStrategy _object_31 = ((ModifyInformationMutator) mutator).getObject();
      if ((_object_31 instanceof TypedSelection)) {
        ObSelectionStrategy _object_32 = ((ModifyInformationMutator) mutator).getObject();
        EClass _type_24 = null;
        if (_object_32!=null) {
          _type_24=_object_32.getType();
        }
        String _name_24 = null;
        if (_type_24!=null) {
          _name_24=_type_24.getName();
        }
        types.add(_name_24);
      }
    }
    if ((mutator instanceof RetypeObjectMutator)) {
      EClass _type_25 = ((RetypeObjectMutator) mutator).getType();
      String _name_25 = null;
      if (_type_25!=null) {
        _name_25=_type_25.getName();
      }
      types.add(_name_25);
      EList<EClass> _types_4 = ((RetypeObjectMutator) mutator).getTypes();
      for (final EClass type_4 : _types_4) {
        types.add(type_4.getName());
      }
      ObSelectionStrategy _object_33 = ((RetypeObjectMutator) mutator).getObject();
      if ((_object_33 instanceof RandomTypeSelection)) {
        ObSelectionStrategy _object_34 = ((RetypeObjectMutator) mutator).getObject();
        EClass _type_26 = null;
        if (_object_34!=null) {
          _type_26=_object_34.getType();
        }
        String _name_26 = null;
        if (_type_26!=null) {
          _name_26=_type_26.getName();
        }
        types.add(_name_26);
      }
      ObSelectionStrategy _object_35 = ((RetypeObjectMutator) mutator).getObject();
      if ((_object_35 instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_36 = ((RetypeObjectMutator) mutator).getObject();
        ObjectEmitter _objSel = ((SpecificObjectSelection) _object_36).getObjSel();
        EClass _type_27 = null;
        if (_objSel!=null) {
          _type_27=_objSel.getType();
        }
        String _name_27 = null;
        if (_type_27!=null) {
          _name_27=_type_27.getName();
        }
        types.add(_name_27);
      }
      ObSelectionStrategy _object_37 = ((RetypeObjectMutator) mutator).getObject();
      if ((_object_37 instanceof SpecificObjectSelection)) {
        ObSelectionStrategy _object_38 = ((RetypeObjectMutator) mutator).getObject();
        final ObjectEmitter o_4 = ((SpecificObjectSelection) _object_38).getObjSel();
        if ((o_4 instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_39 = ((SelectObjectMutator) o_4).getObject();
          EClass _type_28 = null;
          if (_object_39!=null) {
            _type_28=_object_39.getType();
          }
          String _name_28 = null;
          if (_type_28!=null) {
            _name_28=_type_28.getName();
          }
          types.add(_name_28);
        }
        if ((o_4 instanceof CreateObjectMutator)) {
          EClass _type_29 = ((CreateObjectMutator) o_4).getType();
          String _name_29 = null;
          if (_type_29!=null) {
            _name_29=_type_29.getName();
          }
          types.add(_name_29);
        }
        if ((o_4 instanceof SelectSampleMutator)) {
          types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o_4)));
        }
        if ((o_4 instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object_40 = ((CloneObjectMutator) o_4).getObject();
          EClass _type_30 = null;
          if (_object_40!=null) {
            _type_30=_object_40.getType();
          }
          String _name_30 = null;
          if (_type_30!=null) {
            _name_30=_type_30.getName();
          }
          types.add(_name_30);
        }
        if ((o_4 instanceof RetypeObjectMutator)) {
          ObSelectionStrategy _object_41 = ((RetypeObjectMutator) o_4).getObject();
          EClass _type_31 = null;
          if (_object_41!=null) {
            _type_31=_object_41.getType();
          }
          String _name_31 = null;
          if (_type_31!=null) {
            _name_31=_type_31.getName();
          }
          types.add(_name_31);
          EClass _type_32 = ((RetypeObjectMutator) o_4).getType();
          String _name_32 = null;
          if (_type_32!=null) {
            _name_32=_type_32.getName();
          }
          types.add(_name_32);
          EList<EClass> _types_5 = null;
          if (((RetypeObjectMutator) o_4)!=null) {
            _types_5=((RetypeObjectMutator) o_4).getTypes();
          }
          for (final EClass type_5 : _types_5) {
            types.add(type_5.getName());
          }
        }
      }
      ObSelectionStrategy _object_42 = ((RetypeObjectMutator) mutator).getObject();
      if ((_object_42 instanceof SpecificClosureSelection)) {
        ObSelectionStrategy _object_43 = ((RetypeObjectMutator) mutator).getObject();
        final ObjectEmitter o_5 = ((SpecificClosureSelection) _object_43).getObjSel();
        if ((o_5 instanceof SelectObjectMutator)) {
          ObSelectionStrategy _object_44 = ((SelectObjectMutator) o_5).getObject();
          EClass _type_33 = null;
          if (_object_44!=null) {
            _type_33=_object_44.getType();
          }
          String _name_33 = null;
          if (_type_33!=null) {
            _name_33=_type_33.getName();
          }
          types.add(_name_33);
        }
        if ((o_5 instanceof CreateObjectMutator)) {
          EClass _type_34 = ((CreateObjectMutator) o_5).getType();
          String _name_34 = null;
          if (_type_34!=null) {
            _name_34=_type_34.getName();
          }
          types.add(_name_34);
        }
        if ((o_5 instanceof SelectSampleMutator)) {
          types.add(MutatorUtils.selectSampleMutatorHelperName(((SelectSampleMutator) o_5)));
        }
        if ((o_5 instanceof CloneObjectMutator)) {
          ObSelectionStrategy _object_45 = ((CloneObjectMutator) o_5).getObject();
          EClass _type_35 = null;
          if (_object_45!=null) {
            _type_35=_object_45.getType();
          }
          String _name_35 = null;
          if (_type_35!=null) {
            _name_35=_type_35.getName();
          }
          types.add(_name_35);
        }
        if ((o_5 instanceof RetypeObjectMutator)) {
          ObSelectionStrategy _object_46 = ((RetypeObjectMutator) o_5).getObject();
          EClass _type_36 = null;
          if (_object_46!=null) {
            _type_36=_object_46.getType();
          }
          String _name_36 = null;
          if (_type_36!=null) {
            _name_36=_type_36.getName();
          }
          types.add(_name_36);
          EClass _type_37 = ((RetypeObjectMutator) o_5).getType();
          String _name_37 = null;
          if (_type_37!=null) {
            _name_37=_type_37.getName();
          }
          types.add(_name_37);
          EList<EClass> _types_6 = null;
          if (((RetypeObjectMutator) o_5)!=null) {
            _types_6=((RetypeObjectMutator) o_5).getTypes();
          }
          for (final EClass type_6 : _types_6) {
            types.add(type_6.getName());
          }
        }
      }
      ObSelectionStrategy _object_47 = ((RetypeObjectMutator) mutator).getObject();
      if ((_object_47 instanceof TypedSelection)) {
        ObSelectionStrategy _object_48 = ((RetypeObjectMutator) mutator).getObject();
        EClass _type_38 = null;
        if (_object_48!=null) {
          _type_38=_object_48.getType();
        }
        String _name_38 = null;
        if (_type_38!=null) {
          _name_38=_type_38.getName();
        }
        types.add(_name_38);
        EClass _type_39 = ((RetypeObjectMutator) mutator).getType();
        String _name_39 = null;
        if (_type_39!=null) {
          _name_39=_type_39.getName();
        }
        types.add(_name_39);
        EList<EClass> _types_7 = ((RetypeObjectMutator) mutator).getTypes();
        for (final EClass type_7 : _types_7) {
          types.add(type_7.getName());
        }
      }
    }
    int _size = types.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      EClass _type_40 = mutator.getType();
      String _name_40 = null;
      if (_type_40!=null) {
        _name_40=_type_40.getName();
      }
      types.add(_name_40);
    }
    return types;
  }

  /**
   * It receives a list of commands, and returns the command with the given name in commands[0..maxindex].
   */
  private Mutator getCommand(final String name, final List<Mutator> commands, final int maxindex) {
    Mutator command = null;
    for (final Mutator mutator : commands) {
      boolean _and = false;
      String _name = mutator.getName();
      boolean _equals = false;
      if (_name!=null) {
        _equals=_name.equals(name);
      }
      if (!_equals) {
        _and = false;
      } else {
        int _indexOf = commands.indexOf(mutator);
        boolean _lessThan = (_indexOf < maxindex);
        _and = _lessThan;
      }
      if (_and) {
        command = mutator;
      }
    }
    return command;
  }

  /**
   * Gets the EClass list defined in the given meta-model
   */
  private List<EClass> getEClassesHelper(final List<EPackage> packages) {
    List<EClass> classes = new ArrayList<EClass>();
    for (final EPackage pck : packages) {
      {
        EList<EClassifier> _eClassifiers = pck.getEClassifiers();
        for (final EClassifier cl : _eClassifiers) {
          if ((cl instanceof EClass)) {
            classes.add(((EClass) cl));
          }
        }
        EList<EPackage> _eSubpackages = pck.getESubpackages();
        boolean _tripleNotEquals = (_eSubpackages != null);
        if (_tripleNotEquals) {
          classes.addAll(this.getEClassesHelper(pck.getESubpackages()));
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
  private List<EClass> getEClasses(final Definition definition) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      final List<EClass> classes = new ArrayList<EClass>();
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          for (final EPackage pck : metamodel) {
            {
              EList<EClassifier> _eClassifiers = pck.getEClassifiers();
              for (final EClassifier cl : _eClassifiers) {
                if ((cl instanceof EClass)) {
                  classes.add(((EClass) cl));
                }
              }
              EList<EPackage> _eSubpackages = pck.getESubpackages();
              boolean _tripleNotEquals = (_eSubpackages != null);
              if (_tripleNotEquals) {
                classes.addAll(this.getEClassesHelper(pck.getESubpackages()));
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
   * It returns the list of subclasses of the given class.
   * @param String file containing the metamodel
   * @param EClass given class
   * @return List<EClass>
   */
  private List<EClass> getESubClasses(final Definition definition, final EClass eclass) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      final List<EClass> classes = new ArrayList<EClass>();
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          classes.addAll(ModelManager.getESubClasses(metamodel, eclass));
        }
      }
      return classes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of classes existing in a model.
   * @param String file containing the model
   * @return List<EClass>
   */
  private List<EClass> getModelEClasses(final Definition definition, final String modelFile) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          try {
            final org.eclipse.emf.ecore.resource.Resource model = ModelManager.loadModel(metamodel, modelFile);
            if ((model != null)) {
              final List<EObject> classes = ModelManager.getAllObjects(model);
              final List<EClass> ret = new ArrayList<EClass>();
              for (final EObject o : classes) {
                boolean _contains = ret.contains(o.eClass());
                boolean _not = (!_contains);
                if (_not) {
                  ret.add(o.eClass());
                }
              }
              final List<EClass> mmclasses = ModelManager.getEClasses(metamodel);
              for (final EClass cl : mmclasses) {
                boolean _contains_1 = ret.contains(cl);
                boolean _not_1 = (!_contains_1);
                if (_not_1) {
                  ret.add(cl);
                }
              }
              return ret;
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
      return new ArrayList<EClass>();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of references defined in a meta-model.
   * @param String file containing the metamodel
   * @return List<EReference>
   */
  private List<EReference> getEReferences(final Definition definition) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      final List<EReference> references = new ArrayList<EReference>();
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          for (final EPackage pck : metamodel) {
            {
              EList<EClassifier> _eClassifiers = pck.getEClassifiers();
              for (final EClassifier cl : _eClassifiers) {
                if ((cl instanceof EClass)) {
                  references.addAll(((EClass) cl).getEReferences());
                }
              }
              EList<EPackage> _eSubpackages = pck.getESubpackages();
              for (final EPackage spck : _eSubpackages) {
                EList<EClassifier> _eClassifiers_1 = spck.getEClassifiers();
                for (final EClassifier cl_1 : _eClassifiers_1) {
                  if ((cl_1 instanceof EClass)) {
                    references.addAll(((EClass) cl_1).getEReferences());
                  }
                }
              }
            }
          }
        }
      }
      return references;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of classes which can contain (through a containment relation) the given class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EClass> list of containers
   */
  private List<EClass> getEContainers(final String metamodelFile, final EClass eclass) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      final List<EClassifier> containers = ModelManager.getContainerTypes(metamodel, EcoreUtil.getURI(eclass));
      final List<EClass> classes = new ArrayList<EClass>();
      for (final EClassifier cl : containers) {
        if ((cl instanceof EClass)) {
          classes.add(((EClass) cl));
        }
      }
      return classes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of classes which defines the given relation.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EClass> list of containers
   */
  private List<EClass> getESources(final Definition definition, final String ereferenceName) {
    final List<EClass> eclasses = this.getEClasses(definition);
    final List<EClass> esources = new ArrayList<EClass>();
    for (final EClass cl : eclasses) {
      EStructuralFeature _eStructuralFeature = cl.getEStructuralFeature(ereferenceName);
      boolean _tripleNotEquals = (_eStructuralFeature != null);
      if (_tripleNotEquals) {
        esources.add(cl);
        esources.addAll(this.getESubClasses(definition, cl));
      }
    }
    return esources;
  }

  /**
   * It returns the list of classes which are pointed by the given relation.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EClass> list of containments
   */
  private List<EClass> getETargets(final Definition definition, final String ereferenceName) {
    final List<EClass> eclasses = this.getEClasses(definition);
    final List<EReference> ereferences = this.getEReferences(definition);
    final List<EClass> etargets = new ArrayList<EClass>();
    for (final EClass cl : eclasses) {
      for (final EReference rl : ereferences) {
        if ((cl.getName().equals(rl.getEType().getName()) && rl.getName().equals(ereferenceName))) {
          etargets.add(cl);
          etargets.addAll(this.getESubClasses(definition, cl));
        }
      }
    }
    return etargets;
  }

  /**
   * It returns the list of classes which defines the given relation.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EClass> list of containers
   */
  private List<EClass> getModelESources(final Definition definition, final String modelFile, final String ereferenceName) {
    final List<EClass> eclasses = this.getModelEClasses(definition, modelFile);
    final List<EClass> esources = new ArrayList<EClass>();
    for (final EClass cl : eclasses) {
      EStructuralFeature _eStructuralFeature = cl.getEStructuralFeature(ereferenceName);
      boolean _tripleNotEquals = (_eStructuralFeature != null);
      if (_tripleNotEquals) {
        esources.add(cl);
        esources.addAll(this.getESubClasses(definition, cl));
      }
    }
    return esources;
  }

  /**
   * It returns the list of containment references from a source class to a target class.
   * @param String file containing the metamodel
   * @param String source class name
   * @param String target class name
   * @return List<EReference> list of references
   */
  private List<EReference> getEContainmentReferences(final Definition definition, final String esourceclassName, final String etargetclassName) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      for (final String mmsource : metamodels) {
        {
          final List<EPackage> metamodelsource = ModelManager.loadMetaModel(mmsource);
          EObject _objectOfType = ModelManager.getObjectOfType(esourceclassName, metamodelsource);
          final EClass sourceclass = ((EClass) _objectOfType);
          if ((sourceclass != null)) {
            for (final String mmtarget : metamodels) {
              {
                final List<EPackage> metamodeltarget = ModelManager.loadMetaModel(mmtarget);
                EObject _objectOfType_1 = ModelManager.getObjectOfType(esourceclassName, metamodeltarget);
                final EClass targetclass = ((EClass) _objectOfType_1);
                final List<EReference> references = new ArrayList<EReference>();
                if (((sourceclass != null) && (targetclass != null))) {
                  EList<EReference> _eAllReferences = sourceclass.getEAllReferences();
                  for (final EReference ref : _eAllReferences) {
                    boolean _isSuperTypeOf = ref.getEReferenceType().isSuperTypeOf(targetclass);
                    if (_isSuperTypeOf) {
                      if ((ref.isContainment() && ref.isChangeable())) {
                        references.add(ref);
                      }
                    }
                  }
                  return references;
                }
              }
            }
          }
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It returns the list of containment references from a source class to a target class.
   * @param String file containing the metamodel
   * @param String source class name
   * @param String target class name
   * @return List<EReference> list of references
   */
  private List<EReference> getEReferences(final Definition definition, final String esourceclassName, final String etargetclassName) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      final List<EReference> references = new ArrayList<EReference>();
      for (final String mmsource : metamodels) {
        {
          final List<EPackage> metamodelsource = ModelManager.loadMetaModel(mmsource);
          EObject _objectOfType = ModelManager.getObjectOfType(esourceclassName, metamodelsource);
          final EClass sourceclass = ((EClass) _objectOfType);
          if ((sourceclass != null)) {
            for (final String mmtarget : metamodels) {
              {
                final List<EPackage> metamodeltarget = ModelManager.loadMetaModel(mmtarget);
                EObject _objectOfType_1 = ModelManager.getObjectOfType(etargetclassName, metamodeltarget);
                final EClass targetclass = ((EClass) _objectOfType_1);
                if (((sourceclass != null) && (targetclass != null))) {
                  EList<EReference> _eAllReferences = sourceclass.getEAllReferences();
                  for (final EReference ref : _eAllReferences) {
                    {
                      EClass type = ModelManager.getEClassByName(metamodeltarget, ref.getEReferenceType().getName());
                      if ((type == null)) {
                        type = ref.getEReferenceType();
                      }
                      boolean _isSuperTypeOf = type.isSuperTypeOf(targetclass);
                      if (_isSuperTypeOf) {
                        references.add(ref);
                      }
                    }
                  }
                  return references;
                }
              }
            }
          }
        }
      }
      return null;
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
  private List<EAttribute> getEAttributes(final Definition definition, final String eclassName) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
          final EClass eclass = ((EClass) _objectOfType);
          if ((eclass != null)) {
            final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
            List<EAttribute> attributes = new ArrayList<EAttribute>();
            for (final EClass subclass : subclasses) {
              attributes.addAll(subclass.getEAllAttributes());
            }
            attributes.addAll(eclass.getEAllAttributes());
            return attributes;
          }
        }
      }
      return new ArrayList<EAttribute>();
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
  private List<EAttribute> getEAttributes(final Definition definition, final Set<String> eclassNames) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      List<EAttribute> attributes = new ArrayList<EAttribute>();
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          for (final String eclassName : eclassNames) {
            {
              EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
              final EClass eclass = ((EClass) _objectOfType);
              if ((eclass != null)) {
                final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
                for (final EClass subclass : subclasses) {
                  attributes.addAll(subclass.getEAllAttributes());
                }
                attributes.addAll(eclass.getEAllAttributes());
              }
            }
          }
        }
      }
      return attributes;
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
  private List<EReference> getEReferences(final Definition definition, final String eclassName) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
          final EClass eclass = ((EClass) _objectOfType);
          if ((eclass != null)) {
            final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
            List<EReference> references = new ArrayList<EReference>();
            for (final EClass subclass : subclasses) {
              references.addAll(subclass.getEAllReferences());
            }
            references.addAll(eclass.getEAllReferences());
            return references;
          }
        }
      }
      return new ArrayList<EReference>();
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
  private List<EReference> getEReferences(final Definition definition, final Set<String> eclassNames) {
    try {
      final List<String> resourceMM = this.getResourceMetamodels(definition);
      List<String> metamodels = new ArrayList<String>();
      metamodels.add(definition.getMetamodel());
      metamodels.addAll(resourceMM);
      List<EReference> references = new ArrayList<EReference>();
      for (final String mm : metamodels) {
        {
          final List<EPackage> metamodel = ModelManager.loadMetaModel(mm);
          for (final String eclassName : eclassNames) {
            {
              EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
              final EClass eclass = ((EClass) _objectOfType);
              if ((eclass != null)) {
                final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
                for (final EClass subclass : subclasses) {
                  references.addAll(subclass.getEAllReferences());
                }
                references.addAll(eclass.getEAllReferences());
              }
            }
          }
        }
      }
      return references;
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
  private EReference getEReference(final String metamodelFile, final String eclassName, final String refName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      if ((eclass != null)) {
        final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
        List<EReference> references = new ArrayList<EReference>();
        for (final EClass subclass : subclasses) {
          references.addAll(subclass.getEAllReferences());
        }
        references.addAll(eclass.getEAllReferences());
        for (final EReference ref : references) {
          boolean _equals = ref.getName().equals(refName);
          if (_equals) {
            return ref;
          }
        }
        return null;
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * It return the list of structural features of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EAttribute> list of attributes
   */
  private List<EStructuralFeature> getEStructuralFeatures(final String metamodelFile, final String eclassName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      if ((eclass != null)) {
        if ((eclass != null)) {
          final List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass);
          List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
          for (final EClass subclass : subclasses) {
            features.addAll(subclass.getEAllStructuralFeatures());
          }
          features.addAll(eclass.getEAllStructuralFeatures());
          return features;
        } else {
          return new ArrayList<EStructuralFeature>();
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private String getMetamodel(final Definition definition, final String className) {
    try {
      String _metamodel = null;
      if (definition!=null) {
        _metamodel=definition.getMetamodel();
      }
      String metamodel = _metamodel;
      List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
      EClass eclass = ModelManager.getEClassByName(packages, className);
      if ((eclass == null)) {
        if ((definition instanceof Program)) {
          final Program program = ((Program) definition);
          EList<Resource> _resources = program.getResources();
          for (final Resource resource : _resources) {
            {
              packages = ModelManager.loadMetaModel(resource.getMetamodel());
              eclass = ModelManager.getEClassByName(packages, className);
              if ((eclass != null)) {
                return resource.getMetamodel();
              }
            }
          }
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private List<String> getResourceMetamodels(final Definition definition) {
    List<String> metamodels = new ArrayList<String>();
    if ((definition == null)) {
      return metamodels;
    }
    if ((definition instanceof Program)) {
      final Program program = ((Program) definition);
      EList<Resource> _resources = ((Program)definition).getResources();
      for (final Resource resource : _resources) {
        boolean _contains = metamodels.contains(resource.getMetamodel());
        boolean _not = (!_contains);
        if (_not) {
          metamodels.add(resource.getMetamodel());
        }
      }
    }
    return metamodels;
  }

  private void addResourceClasses(final Definition definition, final EClass type, final List<EClass> classes) {
    if (((classes == null) || (definition == null))) {
      return;
    }
    final List<String> metamodels = this.getResourceMetamodels(definition);
    for (final String metamodel : metamodels) {
      {
        List<EClass> resourceClasses = ModelManager.getSiblingEClasses(metamodel, type);
        for (final EClass resourceClass : resourceClasses) {
          boolean _contains = classes.contains(resourceClass);
          boolean _not = (!_contains);
          if (_not) {
            classes.add(resourceClass);
          }
        }
      }
    }
  }

  /**
   * @param name
   *            Name of the reference
   * @param object
   *            Object one wants to explore
   * @return EStructuralFeature Specified reference
   */
  private EStructuralFeature getReferenceByName(final Definition definition, final String name, final String className) {
    try {
      String _metamodel = null;
      if (definition!=null) {
        _metamodel=definition.getMetamodel();
      }
      String metamodel = _metamodel;
      List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
      EClass eClass = ModelManager.getEClassByName(packages, className);
      EStructuralFeature sf = null;
      if ((eClass != null)) {
        sf = eClass.getEStructuralFeature(name);
      }
      return sf;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
