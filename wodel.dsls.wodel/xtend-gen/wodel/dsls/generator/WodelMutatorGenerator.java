package wodel.dsls.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeType;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.BooleanType;
import mutatorenvironment.CatEndStringType;
import mutatorenvironment.CatStartStringType;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.Constraint;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Definition;
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
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.NullTypeSelection;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.Operator;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
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
import mutatorenvironment.ReferenceAtt;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.ReferenceUnset;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RemoveRandomReferenceMutator;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.Repeat;
import mutatorenvironment.ReplaceStringType;
import mutatorenvironment.RetypeObjectMutator;
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
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osgi.framework.Bundle;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCloneObjectExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCreateObjectExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCreateReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorGenericOperatorExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifyInformationExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifySourceReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifyTargetReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveCompleteReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveObjectExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveRandomReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveSpecificReferenceExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRetypeObjectExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorSelectObjectExhaustiveMutator;
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorSelectSampleExhaustiveMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCloneObjectMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCreateObjectMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCreateReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorGenericOperatorStochasticMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifyInformationMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifySourceReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifyTargetReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveCompleteReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveObjectMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveRandomReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveSpecificReferenceMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRetypeObjectMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorSelectObjectMutator;
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorSelectSampleMutator;
import wodel.dsls.runner.WodelUtils;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 */
@SuppressWarnings("all")
public abstract class WodelMutatorGenerator extends AbstractGenerator {
  protected int[] nMethod;

  protected int[] nMethodCall;

  protected int[] nCompositeMethod;

  protected int[] nRegistryMethod;

  protected int[] nRegistryMethodCall;

  protected int[] nCompositeRegistryMethod;

  protected List<String> compositeCommands;

  protected List<String> compositeRegistryCommands;

  protected int[] nCommands;

  protected int[] nMutation;

  protected int[] nRegistryMutation;

  protected int[] nCompositeCommands;

  protected int[] nExpression;

  protected List<Integer> expressionList;

  protected int[] nReference;

  protected String methodName;

  protected String registryMethodName;

  protected String commandName;

  protected String attributeName;

  protected String referenceName;

  protected String compositeMethodName;

  protected String compositeRegistryMethodName;

  protected String compositeCommandName;

  protected boolean executeMutation;

  protected int[] nMut;

  protected boolean standalone = false;

  protected IProject project = null;

  protected URI fileURI;

  protected String className;

  protected Program program;

  protected Map<Mutator, Integer> mutIndexes = new LinkedHashMap<Mutator, Integer>();

  protected Bundle bundle;

  protected WodelGeneratorGenericOperatorExhaustiveMutator wodelExhaustiveMutatorGenerator;

  protected WodelGeneratorGenericOperatorStochasticMutator wodelStochasticMutatorGenerator;

  public WodelMutatorGenerator() {
    this.nMethod = new int[1];
    this.nMethod[0] = 0;
    this.nMethodCall = new int[1];
    this.nMethodCall[0] = 0;
    this.nCompositeMethod = new int[1];
    this.nCompositeMethod[0] = 0;
    this.nRegistryMethod = new int[1];
    this.nRegistryMethod[0] = 0;
    this.nRegistryMethodCall = new int[1];
    this.nRegistryMethodCall[0] = 0;
    this.nCompositeRegistryMethod = new int[1];
    this.nCompositeRegistryMethod[0] = 0;
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.compositeCommands = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.compositeRegistryCommands = _arrayList_1;
    this.nCommands = new int[1];
    this.nCommands[0] = 0;
    this.nMutation = new int[1];
    this.nMutation[0] = 0;
    this.nRegistryMutation = new int[1];
    this.nRegistryMutation[0] = 0;
    this.nCompositeCommands = new int[1];
    this.nCompositeCommands[0] = 0;
    this.nExpression = new int[1];
    this.nExpression[0] = 0;
    this.expressionList = ((List<Integer>)Conversions.doWrapArray(new int[1]));
    this.expressionList.set(0, Integer.valueOf(0));
    this.nReference = new int[1];
    this.nReference[0] = 0;
    this.nMut = new int[1];
    this.nMut[0] = 0;
    this.executeMutation = true;
    this.standalone = false;
    this.project = null;
  }

  /**
   * Explicit project context used by semantic/XMI headless generation.
   */
  public void setGenerationProject(final IProject generationProject) {
    this.project = generationProject;
  }

  public static IProject projectOf(final Resource r) {
    Object _xblockexpression = null;
    {
      URI _uRI = null;
      if (r!=null) {
        _uRI=r.getURI();
      }
      final URI uri = _uRI;
      if (((uri != null) && uri.isPlatformResource())) {
        final String projectName = uri.segment(1);
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
      }
      _xblockexpression = null;
    }
    return ((IProject)_xblockexpression);
  }

  public String getMutatorPath(final MutatorEnvironment e, final IProject project, final File[] files) {
    IProject p = WodelMutatorGenerator.projectOf(e.eResource());
    IProject _xifexpression = null;
    if ((p != null)) {
      _xifexpression = p;
    } else {
      _xifexpression = project;
    }
    p = _xifexpression;
    String mutatorPath = null;
    if (((mutatorPath == null) && (files != null))) {
      for (final File file : files) {
        {
          if ((mutatorPath != null)) {
            return mutatorPath;
          }
          if ((file != null)) {
            if ((file.exists() && (file.isFile() == true))) {
              String path = file.getPath().replace("\\", "/");
              String _name = p.getName();
              String _plus = ("/" + _name);
              String _plus_1 = (_plus + "/");
              int _indexOf = path.indexOf(_plus_1);
              boolean _notEquals = (_indexOf != (-1));
              if (_notEquals) {
                String _name_1 = p.getName();
                String _plus_2 = ("/" + _name_1);
                String _plus_3 = (_plus_2 + "/");
                String mutatorFolderAndFile = path.substring(path.lastIndexOf(_plus_3));
                boolean _equals = mutatorFolderAndFile.equals(this.fileURI.toPlatformString(true));
                if (_equals) {
                  String _replace = p.getLocation().toFile().getPath().replace("\\", "/");
                  String _plus_4 = ("file:/" + _replace);
                  String _plus_5 = (_plus_4 + "/");
                  String _name_2 = p.getName();
                  String _plus_6 = ("/" + _name_2);
                  String _substring = mutatorFolderAndFile.substring((_plus_6 + "/").length());
                  String _plus_7 = (_plus_5 + _substring);
                  mutatorPath = _plus_7;
                }
              }
            }
            if ((file.exists() && file.isDirectory())) {
              mutatorPath = this.getMutatorPath(e, p, file.listFiles());
            }
          }
        }
      }
    }
    return mutatorPath;
  }

  public String resolveMetaModelPath(final EObject metaModel, final IProject project) {
    if ((metaModel instanceof MutatorEnvironment)) {
      final MutatorEnvironment mut = ((MutatorEnvironment) metaModel);
      Definition _definition = mut.getDefinition();
      if ((_definition instanceof Program)) {
        Definition _definition_1 = mut.getDefinition();
        final Program program = ((Program) _definition_1);
        final String value = program.getMetamodel().replace("\\", "/");
        final String projectRoot = project.getLocation().toFile().getAbsolutePath().replace("\\", "/");
        boolean _matches = value.matches("^[A-Za-z]:/.*");
        if (_matches) {
          return value;
        }
        String _name = project.getName();
        String _plus = ("platform:/resource/" + _name);
        final String platformPrefix = (_plus + "/");
        boolean _startsWith = value.startsWith(platformPrefix);
        if (_startsWith) {
          String _substring = value.substring(platformPrefix.length());
          return ((projectRoot + "/") + _substring);
        }
        String _name_1 = project.getName();
        String _plus_1 = ("/" + _name_1);
        final String projectPrefix = (_plus_1 + "/");
        boolean _startsWith_1 = value.startsWith(projectPrefix);
        if (_startsWith_1) {
          String _substring_1 = value.substring(projectPrefix.length());
          return ((projectRoot + "/") + _substring_1);
        }
        boolean _startsWith_2 = value.startsWith("/");
        boolean _not = (!_startsWith_2);
        if (_not) {
          return ((projectRoot + "/") + value);
        }
        return value;
      }
    }
    return null;
  }

  public CharSequence launcher(final List<MutatorEnvironment> mutEnvironment, final IProject project, final List<String> mutators) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      if (((mutEnvironment != null) && (!mutEnvironment.isEmpty()))) {
        _builder.newLine();
        _builder.append("    ");
        _builder.append("//");
        MutatorEnvironment _xifexpression = null;
        int _size = mutEnvironment.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _xifexpression = mutEnvironment.get(0);
        } else {
          _xifexpression = null;
        }
        MutatorEnvironment e = _xifexpression;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        IProject _xifexpression_1 = null;
        if ((project != null)) {
          _xifexpression_1 = project;
        } else {
          _xifexpression_1 = WodelMutatorGenerator.projectOf(mutEnvironment.get(0).eResource());
        }
        IProject _project = this.project = _xifexpression_1;
        _builder.append(_project, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("package mutator.");
        String _name = project.getName();
        _builder.append(_name);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("import java.io.IOException;");
        _builder.newLine();
        _builder.append("import java.util.ArrayList;");
        _builder.newLine();
        _builder.append("import java.util.LinkedHashMap;");
        _builder.newLine();
        _builder.append("import java.util.List;");
        _builder.newLine();
        _builder.append("import java.util.Map;");
        _builder.newLine();
        _builder.append("import java.util.TreeMap;");
        _builder.newLine();
        _builder.append("import java.util.AbstractMap.SimpleEntry;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("import org.eclipse.core.resources.IProject;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.AbstractCreationException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.MaxSmallerThanMinException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.MetaModelNotFoundException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.ModelNotFoundException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.ObjectNoTargetableException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.ObjectNotContainedException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.ReferenceNonExistingException;");
        _builder.newLine();
        _builder.append("import wodel.utils.exceptions.WrongAttributeTypeException;");
        _builder.newLine();
        _builder.append("import org.eclipse.core.runtime.IProgressMonitor;");
        _builder.newLine();
        _builder.append("import org.eclipse.emf.ecore.EPackage;");
        _builder.newLine();
        _builder.newLine();
        {
          for(final String mutatorName : mutators) {
            {
              if ((this.standalone == false)) {
                _builder.append("import mutator.");
                _builder.append(mutatorName);
                _builder.append("Dynamic.");
                _builder.append(mutatorName);
                _builder.append("Dynamic;");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("import mutator.");
                _builder.append(mutatorName);
                _builder.append("Standalone.");
                _builder.append(mutatorName);
                _builder.append("Standalone;");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((this.standalone == false)) {
            _builder.append("import wodel.utils.manager.IMutatorExecutor;");
            _builder.newLine();
          } else {
            _builder.append("import wodel.utils.manager.IMutatorStandaloneExecutor;");
            _builder.newLine();
          }
        }
        _builder.append("import wodel.utils.manager.IWodelTest;");
        _builder.newLine();
        _builder.append("import wodel.utils.manager.ModelManager;");
        _builder.newLine();
        _builder.append("import wodel.utils.manager.MutatorUtils;");
        _builder.newLine();
        _builder.append("import wodel.utils.manager.MutatorUtils.MutationResults;");
        _builder.newLine();
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("public class ");
            String _replaceAll = project.getName().replaceAll("[.]", "_");
            _builder.append(_replaceAll);
            _builder.append("DynamicLauncher implements IMutatorExecutor {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("public class ");
            String _replaceAll_1 = project.getName().replaceAll("[.]", "_");
            _builder.append(_replaceAll_1);
            _builder.append("StandaloneLauncher implements IMutatorStandaloneExecutor {");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("IWodelTest test = testObject != null ? (IWodelTest) testObject : null;");
        _builder.newLine();
        {
          Definition _definition = e.getDefinition();
          if ((_definition instanceof Program)) {
            _builder.append("\t");
            _builder.append("String ecoreURI = \"");
            String _metamodel = e.getDefinition().getMetamodel();
            _builder.append(_metamodel, "\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//Load MetaModel");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("//checks whether the meta-model is dynamically registered");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("boolean isRegistered = ModelManager.isRegistered(packages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Map<String, EPackage> localRegisteredPackages = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("if (isRegistered == true) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (registeredPackages != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("List<EPackage> packageList = new ArrayList<EPackage>();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("packageList.addAll(registeredPackages.values());");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("ModelManager.unregisterMetaModel(packageList);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("localRegisteredPackages = ModelManager.unregisterMetaModel(packages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("MutationResults mutationResults = new MutationResults();");
        _builder.newLine();
        {
          for(final String mutatorName_1 : mutators) {
            {
              if ((this.standalone == false)) {
                _builder.append("\t");
                _builder.append("MutatorUtils mut");
                _builder.append(mutatorName_1, "\t");
                _builder.append(" = new ");
                _builder.append(mutatorName_1, "\t");
                _builder.append("Dynamic();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("MutationResults results");
                _builder.append(mutatorName_1, "\t");
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("try {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("results");
                _builder.append(mutatorName_1, "\t\t");
                _builder.append(" = mut");
                _builder.append(mutatorName_1, "\t\t");
                _builder.append(".execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, project, monitor, serialize, test, classes, executionSeed);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("MutatorUtils mut");
                _builder.append(mutatorName_1, "\t");
                _builder.append(" = new ");
                _builder.append(mutatorName_1, "\t");
                _builder.append("Standalone();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("MutationResults results");
                _builder.append(mutatorName_1, "\t");
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("try {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("results");
                _builder.append(mutatorName_1, "\t\t");
                _builder.append(" = mut");
                _builder.append(mutatorName_1, "\t\t");
                _builder.append(".execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize, test, classes, executionSeed);");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + results");
            _builder.append(mutatorName_1, "\t\t");
            _builder.append(".getNumMutatorsApplied());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + results");
            _builder.append(mutatorName_1, "\t\t");
            _builder.append(".getNumMutantsGenerated());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (results");
            _builder.append(mutatorName_1, "\t\t");
            _builder.append(".getMutatorsApplied() != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("if (mutationResults.getMutatorsApplied() == null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("mutationResults.setMutatorsApplied(new ArrayList<String>());");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("mutationResults.getMutatorsApplied().addAll(results");
            _builder.append(mutatorName_1, "\t\t\t");
            _builder.append(".getMutatorsApplied()); ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("finally {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("if (isRegistered == true) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (localRegisteredPackages != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("ModelManager.registerMetaModel(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t                ");
            _builder.append("localRegisteredPackages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t        ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t        ");
            _builder.append("if (registeredPackages != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("ModelManager.registerMetaModel(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t                ");
            _builder.append("registeredPackages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t        ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return mutationResults;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public int getRandom(final int range) {
    if ((range == 1)) {
      return 0;
    }
    int _intValue = Long.valueOf(System.nanoTime()).intValue();
    int value = (_intValue % range);
    if ((value < 0)) {
      value = (value * (-1));
    }
    return value;
  }

  public CharSequence method(final Mutator mut, final boolean exhaustive, final MutatorEnvironment e, final Block b, final boolean last) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((exhaustive == false)) {
        {
          if ((this.standalone == false)) {
            _builder.append("private List<Mutator> ");
            _builder.append(this.methodName);
            _builder.append("(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("private List<Mutator> ");
            _builder.append(this.methodName);
            _builder.append("(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("List<Mutator> mutations = new ArrayList<Mutator>();");
        _builder.newLine();
        {
          if ((mut instanceof ModifyInformationMutator)) {
            _builder.append("//MODIFY INFORMATION MUTATOR CODE: ");
            String _xblockexpression = null;
            {
              WodelGeneratorModifyInformationMutator _wodelGeneratorModifyInformationMutator = new WodelGeneratorModifyInformationMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorModifyInformationMutator;
              _xblockexpression = "";
            }
            _builder.append(_xblockexpression);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CreateObjectMutator)) {
            _builder.append("//CREATE OBJECT MUTATOR CODE: ");
            String _xblockexpression_1 = null;
            {
              WodelGeneratorCreateObjectMutator _wodelGeneratorCreateObjectMutator = new WodelGeneratorCreateObjectMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorCreateObjectMutator;
              _xblockexpression_1 = "";
            }
            _builder.append(_xblockexpression_1);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof SelectObjectMutator)) {
            _builder.append("//SELECT OBJECT MUTATOR CODE: ");
            String _xblockexpression_2 = null;
            {
              WodelGeneratorSelectObjectMutator _wodelGeneratorSelectObjectMutator = new WodelGeneratorSelectObjectMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorSelectObjectMutator;
              _xblockexpression_2 = "";
            }
            _builder.append(_xblockexpression_2);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof SelectSampleMutator)) {
            _builder.append("//SELECT SAMPLE MUTATOR CODE: ");
            String _xblockexpression_3 = null;
            {
              WodelGeneratorSelectSampleMutator _wodelGeneratorSelectSampleMutator = new WodelGeneratorSelectSampleMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorSelectSampleMutator;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CloneObjectMutator)) {
            _builder.append("//CLONE OBJECT MUTATOR CODE: ");
            String _xblockexpression_4 = null;
            {
              WodelGeneratorCloneObjectMutator _wodelGeneratorCloneObjectMutator = new WodelGeneratorCloneObjectMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorCloneObjectMutator;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RetypeObjectMutator)) {
            _builder.append("//RETYPE OBJECT MUTATOR CODE: ");
            String _xblockexpression_5 = null;
            {
              WodelGeneratorRetypeObjectMutator _wodelGeneratorRetypeObjectMutator = new WodelGeneratorRetypeObjectMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorRetypeObjectMutator;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof ModifySourceReferenceMutator)) {
            _builder.append("//MODIFY SOURCE REFERENCE MUTATOR CODE: ");
            String _xblockexpression_6 = null;
            {
              WodelGeneratorModifySourceReferenceMutator _wodelGeneratorModifySourceReferenceMutator = new WodelGeneratorModifySourceReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorModifySourceReferenceMutator;
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof ModifyTargetReferenceMutator)) {
            _builder.append("//MODIFY TARGET REFERENCE MUTATOR CODE: ");
            String _xblockexpression_7 = null;
            {
              WodelGeneratorModifyTargetReferenceMutator _wodelGeneratorModifyTargetReferenceMutator = new WodelGeneratorModifyTargetReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorModifyTargetReferenceMutator;
              _xblockexpression_7 = "";
            }
            _builder.append(_xblockexpression_7);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CreateReferenceMutator)) {
            _builder.append("//CREATE REFERENCE MUTATOR CODE: ");
            String _xblockexpression_8 = null;
            {
              WodelGeneratorCreateReferenceMutator _wodelGeneratorCreateReferenceMutator = new WodelGeneratorCreateReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorCreateReferenceMutator;
              _xblockexpression_8 = "";
            }
            _builder.append(_xblockexpression_8);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveObjectMutator)) {
            _builder.append("//REMOVE OBJECT MUTATOR CODE: ");
            String _xblockexpression_9 = null;
            {
              WodelGeneratorRemoveObjectMutator _wodelGeneratorRemoveObjectMutator = new WodelGeneratorRemoveObjectMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorRemoveObjectMutator;
              _xblockexpression_9 = "";
            }
            _builder.append(_xblockexpression_9);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveRandomReferenceMutator)) {
            _builder.append("//REMOVE RANDOM REFERENCE MUTATOR CODE: ");
            String _xblockexpression_10 = null;
            {
              WodelGeneratorRemoveRandomReferenceMutator _wodelGeneratorRemoveRandomReferenceMutator = new WodelGeneratorRemoveRandomReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorRemoveRandomReferenceMutator;
              _xblockexpression_10 = "";
            }
            _builder.append(_xblockexpression_10);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveSpecificReferenceMutator)) {
            _builder.append("//REMOVE SPECIFIC REFERENCE MUTATOR CODE: ");
            String _xblockexpression_11 = null;
            {
              WodelGeneratorRemoveSpecificReferenceMutator _wodelGeneratorRemoveSpecificReferenceMutator = new WodelGeneratorRemoveSpecificReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorRemoveSpecificReferenceMutator;
              _xblockexpression_11 = "";
            }
            _builder.append(_xblockexpression_11);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveCompleteReferenceMutator)) {
            _builder.append("//REMOVE COMPLETE REFERENCE MUTATOR CODE: ");
            String _xblockexpression_12 = null;
            {
              WodelGeneratorRemoveCompleteReferenceMutator _wodelGeneratorRemoveCompleteReferenceMutator = new WodelGeneratorRemoveCompleteReferenceMutator();
              this.wodelStochasticMutatorGenerator = _wodelGeneratorRemoveCompleteReferenceMutator;
              _xblockexpression_12 = "";
            }
            _builder.append(_xblockexpression_12);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("//GENERATE CORRESPONDING CODE: ");
        CharSequence _apply = this.wodelStochasticMutatorGenerator.apply(mut, this.methodName, this.nMutation, this.nRegistryMutation, this.program, this.project, this.className, this.standalone);
        _builder.append(_apply, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return mutations;\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("private int ");
            _builder.append(this.methodName, "\t");
            _builder.append("(List<EPackage> packages, List<Resource> models,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("private int ");
            _builder.append(this.methodName, "\t");
            _builder.append("(List<EPackage> packages, List<Resource> models,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("int numMutantsGenerated = 0;");
        _builder.newLine();
        {
          if ((mut instanceof ModifyInformationMutator)) {
            _builder.append("\t");
            _builder.append("//MODIFY INFORMATION EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_13 = null;
            {
              WodelGeneratorModifyInformationExhaustiveMutator _wodelGeneratorModifyInformationExhaustiveMutator = new WodelGeneratorModifyInformationExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorModifyInformationExhaustiveMutator;
              _xblockexpression_13 = "";
            }
            _builder.append(_xblockexpression_13, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CreateObjectMutator)) {
            _builder.append("\t");
            _builder.append("//CREATE OBJECT EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_14 = null;
            {
              WodelGeneratorCreateObjectExhaustiveMutator _wodelGeneratorCreateObjectExhaustiveMutator = new WodelGeneratorCreateObjectExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorCreateObjectExhaustiveMutator;
              _xblockexpression_14 = "";
            }
            _builder.append(_xblockexpression_14, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof SelectObjectMutator)) {
            _builder.append("\t");
            _builder.append("//SELECT OBJECT EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_15 = null;
            {
              WodelGeneratorSelectObjectExhaustiveMutator _wodelGeneratorSelectObjectExhaustiveMutator = new WodelGeneratorSelectObjectExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorSelectObjectExhaustiveMutator;
              _xblockexpression_15 = "";
            }
            _builder.append(_xblockexpression_15, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof SelectSampleMutator)) {
            _builder.append("\t");
            _builder.append("//SELECT SAMPLE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_16 = null;
            {
              WodelGeneratorSelectSampleExhaustiveMutator _wodelGeneratorSelectSampleExhaustiveMutator = new WodelGeneratorSelectSampleExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorSelectSampleExhaustiveMutator;
              _xblockexpression_16 = "";
            }
            _builder.append(_xblockexpression_16, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CloneObjectMutator)) {
            _builder.append("\t");
            _builder.append("//CLONE OBJECT EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_17 = null;
            {
              WodelGeneratorCloneObjectExhaustiveMutator _wodelGeneratorCloneObjectExhaustiveMutator = new WodelGeneratorCloneObjectExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorCloneObjectExhaustiveMutator;
              _xblockexpression_17 = "";
            }
            _builder.append(_xblockexpression_17, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RetypeObjectMutator)) {
            _builder.append("\t");
            _builder.append("//RETYPE OBJECT EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_18 = null;
            {
              WodelGeneratorRetypeObjectExhaustiveMutator _wodelGeneratorRetypeObjectExhaustiveMutator = new WodelGeneratorRetypeObjectExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorRetypeObjectExhaustiveMutator;
              _xblockexpression_18 = "";
            }
            _builder.append(_xblockexpression_18, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof ModifySourceReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//MODIFY SOURCE REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_19 = null;
            {
              WodelGeneratorModifySourceReferenceExhaustiveMutator _wodelGeneratorModifySourceReferenceExhaustiveMutator = new WodelGeneratorModifySourceReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorModifySourceReferenceExhaustiveMutator;
              _xblockexpression_19 = "";
            }
            _builder.append(_xblockexpression_19, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof ModifyTargetReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//MODIFY TARGET REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_20 = null;
            {
              WodelGeneratorModifyTargetReferenceExhaustiveMutator _wodelGeneratorModifyTargetReferenceExhaustiveMutator = new WodelGeneratorModifyTargetReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorModifyTargetReferenceExhaustiveMutator;
              _xblockexpression_20 = "";
            }
            _builder.append(_xblockexpression_20, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof CreateReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//CREATE REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_21 = null;
            {
              WodelGeneratorCreateReferenceExhaustiveMutator _wodelGeneratorCreateReferenceExhaustiveMutator = new WodelGeneratorCreateReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorCreateReferenceExhaustiveMutator;
              _xblockexpression_21 = "";
            }
            _builder.append(_xblockexpression_21, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveObjectMutator)) {
            _builder.append("\t");
            _builder.append("//REMOVE OBJECT EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_22 = null;
            {
              WodelGeneratorRemoveObjectExhaustiveMutator _wodelGeneratorRemoveObjectExhaustiveMutator = new WodelGeneratorRemoveObjectExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorRemoveObjectExhaustiveMutator;
              _xblockexpression_22 = "";
            }
            _builder.append(_xblockexpression_22, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveRandomReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//REMOVE RANDOM REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_23 = null;
            {
              WodelGeneratorRemoveRandomReferenceExhaustiveMutator _wodelGeneratorRemoveRandomReferenceExhaustiveMutator = new WodelGeneratorRemoveRandomReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorRemoveRandomReferenceExhaustiveMutator;
              _xblockexpression_23 = "";
            }
            _builder.append(_xblockexpression_23, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveSpecificReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//REMOVE SPECIFIC REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_24 = null;
            {
              WodelGeneratorRemoveSpecificReferenceExhaustiveMutator _wodelGeneratorRemoveSpecificReferenceExhaustiveMutator = new WodelGeneratorRemoveSpecificReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorRemoveSpecificReferenceExhaustiveMutator;
              _xblockexpression_24 = "";
            }
            _builder.append(_xblockexpression_24, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((mut instanceof RemoveCompleteReferenceMutator)) {
            _builder.append("\t");
            _builder.append("//REMOVE COMPLETE REFERENCE EXHAUSTIVE MUTATOR CODE: ");
            String _xblockexpression_25 = null;
            {
              WodelGeneratorRemoveCompleteReferenceExhaustiveMutator _wodelGeneratorRemoveCompleteReferenceExhaustiveMutator = new WodelGeneratorRemoveCompleteReferenceExhaustiveMutator();
              this.wodelExhaustiveMutatorGenerator = _wodelGeneratorRemoveCompleteReferenceExhaustiveMutator;
              _xblockexpression_25 = "";
            }
            _builder.append(_xblockexpression_25, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("//GENERATE CORRESPONDING CODE: ");
        CharSequence _apply_1 = this.wodelExhaustiveMutatorGenerator.apply(mut, e, b, this.methodName, this.nMutation, this.nMethodCall, this.nRegistryMutation, this.nRegistryMethodCall, this.executeMutation, last, this.className, this.fileURI, this.program, this.project, this.standalone);
        _builder.append(_apply_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return numMutantsGenerated;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence compositeMethod(final CompositeMutator mut, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EObject _eContainer = mut.eContainer();
      if ((_eContainer instanceof MutatorEnvironment)) {
        _builder.append("//INC COUNTER: ");
        int _get = this.nMutation[0];
        int _plus = (_get + 1);
        int _set = this.nMutation[0] = _plus;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//INC COUNTER: ");
        int _get_1 = this.nRegistryMutation[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = this.nRegistryMutation[0] = _plus_1;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((this.standalone == false)) {
        _builder.append("private List<Mutator> ");
        _builder.append(this.compositeMethodName);
        _builder.append("(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("private List<Mutator> ");
        _builder.append(this.compositeMethodName);
        _builder.append("(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("List<Mutator> mutations = new ArrayList<Mutator>();");
    _builder.newLine();
    _builder.append("\t");
    int _get_2 = this.nCompositeMethod[0];
    int localNCompositeMethod = (_get_2 + 1);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    int _get_3 = this.nMethod[0];
    int localNMethod = (_get_3 + 1);
    _builder.newLineIfNotEmpty();
    {
      EList<Mutator> _commands = mut.getCommands();
      for(final Mutator c : _commands) {
        {
          if ((c instanceof CompositeMutator)) {
            _builder.append("\t");
            _builder.append("//COMMAND: ");
            int _set_2 = this.nCompositeCommands[0] = this.nCompositeCommands[0];
            int _plus_2 = (_set_2 + 1);
            _builder.append(_plus_2, "\t");
            _builder.newLineIfNotEmpty();
            {
              int _fixed = ((CompositeMutator)c).getFixed();
              boolean _equals = (_fixed == 0);
              if (_equals) {
                {
                  int _max = ((CompositeMutator)c).getMax();
                  int _min = ((CompositeMutator)c).getMin();
                  int _minus = (_max - _min);
                  boolean _greaterThan = (_minus > 0);
                  if (_greaterThan) {
                    _builder.append("\t");
                    _builder.append("int cmax");
                    int _get_4 = this.nCompositeCommands[0];
                    _builder.append(_get_4, "\t");
                    _builder.append(" = getRandom(");
                    int _max_1 = ((CompositeMutator)c).getMax();
                    int _min_1 = ((CompositeMutator)c).getMin();
                    int _minus_1 = (_max_1 - _min_1);
                    _builder.append(_minus_1, "\t");
                    _builder.append(") + ");
                    int _min_2 = ((CompositeMutator)c).getMin();
                    _builder.append(_min_2, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((((CompositeMutator)c).getMin() == 0) && (((CompositeMutator)c).getMax() == 0))) {
                    _builder.append("\t");
                    _builder.append("int cmax");
                    int _get_5 = this.nCompositeCommands[0];
                    _builder.append(_get_5, "\t");
                    _builder.append(" = 1;");
                    _builder.newLineIfNotEmpty();
                  } else {
                    int _min_3 = ((CompositeMutator)c).getMin();
                    int _max_2 = ((CompositeMutator)c).getMax();
                    boolean _equals_1 = (_min_3 == _max_2);
                    if (_equals_1) {
                      _builder.append("\t");
                      _builder.append("int cmax");
                      int _get_6 = this.nCompositeCommands[0];
                      _builder.append(_get_6, "\t");
                      _builder.append(" = ");
                      int _min_4 = ((CompositeMutator)c).getMin();
                      _builder.append(_min_4, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              } else {
                _builder.append("\t");
                _builder.append("int cmax");
                int _get_7 = this.nCompositeCommands[0];
                _builder.append(_get_7, "\t");
                _builder.append(" = ");
                int _fixed_1 = ((CompositeMutator)c).getFixed();
                _builder.append(_fixed_1, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("for (int j");
            int _get_8 = this.nCompositeCommands[0];
            _builder.append(_get_8, "\t");
            _builder.append(" = 0; j");
            int _get_9 = this.nCompositeCommands[0];
            _builder.append(_get_9, "\t");
            _builder.append(" < cmax");
            int _get_10 = this.nCompositeCommands[0];
            _builder.append(_get_10, "\t");
            _builder.append("; j");
            int _get_11 = this.nCompositeCommands[0];
            _builder.append(_get_11, "\t");
            _builder.append("++) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//COMPOSITE METHOD NAME:");
            String _string = Integer.valueOf(localNCompositeMethod).toString();
            String _plus_3 = ("compositeMutation" + _string);
            String _compositeMethodName = this.compositeMethodName = _plus_3;
            _builder.append(_compositeMethodName, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List<Mutator> l");
            _builder.append(this.compositeMethodName, "\t\t");
            _builder.append(" = ");
            _builder.append(this.compositeMethodName, "\t\t");
            _builder.append("(packages, models, hmObjects, hmList);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//COMPOSITE METHOD INC: ");
            int _plusPlus = localNCompositeMethod++;
            _builder.append(_plusPlus, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (l");
            _builder.append(this.compositeMethodName, "\t\t");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("if (l");
            _builder.append(this.compositeMethodName, "\t\t\t");
            _builder.append(".size() > 0) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("mutations.addAll(l");
            _builder.append(this.compositeMethodName, "\t\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("//COMPOSITE METHOD INC: ");
            int _localNCompositeMethod = localNCompositeMethod;
            int _compositeMutatorSize = MutatorUtils.compositeMutatorSize(((CompositeMutator)c));
            int _minus_2 = (_compositeMutatorSize - 1);
            int _plus_4 = localNCompositeMethod = (_localNCompositeMethod + _minus_2);
            _builder.append(_plus_4, "\t");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("//COMMAND: ");
            int _get_12 = this.nCommands[0];
            int _plus_5 = (_get_12 + 1);
            int _set_3 = this.nCommands[0] = _plus_5;
            _builder.append(_set_3, "\t");
            _builder.newLineIfNotEmpty();
            {
              int _fixed_2 = c.getFixed();
              boolean _equals_2 = (_fixed_2 == 0);
              if (_equals_2) {
                {
                  int _max_3 = c.getMax();
                  int _min_5 = c.getMin();
                  int _minus_3 = (_max_3 - _min_5);
                  boolean _greaterThan_1 = (_minus_3 > 0);
                  if (_greaterThan_1) {
                    _builder.append("\t");
                    _builder.append("int max");
                    int _get_13 = this.nCommands[0];
                    _builder.append(_get_13, "\t");
                    _builder.append(" = getRandom(");
                    int _max_4 = c.getMax();
                    int _min_6 = c.getMin();
                    int _minus_4 = (_max_4 - _min_6);
                    _builder.append(_minus_4, "\t");
                    _builder.append(") + ");
                    int _min_7 = c.getMin();
                    _builder.append(_min_7, "\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((c.getMax() == 0) && (c.getMin() == 0))) {
                    _builder.append("\t");
                    _builder.append("int max");
                    int _get_14 = this.nCommands[0];
                    _builder.append(_get_14, "\t");
                    _builder.append(" = 1;");
                    _builder.newLineIfNotEmpty();
                  } else {
                    int _min_8 = c.getMin();
                    int _max_5 = c.getMax();
                    boolean _equals_3 = (_min_8 == _max_5);
                    if (_equals_3) {
                      _builder.append("\t");
                      _builder.append("int max");
                      int _get_15 = this.nCommands[0];
                      _builder.append(_get_15, "\t");
                      _builder.append(" = ");
                      int _min_9 = c.getMin();
                      _builder.append(_min_9, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              } else {
                _builder.append("\t");
                _builder.append("int max");
                int _get_16 = this.nCommands[0];
                _builder.append(_get_16, "\t");
                _builder.append(" = ");
                int _fixed_3 = c.getFixed();
                _builder.append(_fixed_3, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("for (int j = 0; j < max");
            int _get_17 = this.nCommands[0];
            _builder.append(_get_17, "\t");
            _builder.append("; j++) {");
            _builder.newLineIfNotEmpty();
            {
              String _name = c.getName();
              boolean _tripleNotEquals = (_name != null);
              if (_tripleNotEquals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("//NAME:");
                String _name_1 = c.getName();
                String _string_1 = Integer.valueOf((this.nCommands[0])).toString();
                String _plus_6 = (_name_1 + _string_1);
                String _commandName = this.commandName = _plus_6;
                _builder.append(_commandName, "\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("//NAME:");
                _builder.append(this.commandName = Integer.valueOf((this.nCommands[0])).toString(), "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//METHOD NAME:");
            String _string_2 = Integer.valueOf(localNMethod).toString();
            String _plus_7 = ("mutation" + _string_2);
            String _methodName = this.methodName = _plus_7;
            _builder.append(_methodName, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List<Mutator> l");
            _builder.append(this.commandName, "\t\t");
            _builder.append(" = ");
            _builder.append(this.methodName, "\t\t");
            _builder.append("(packages, models, hmObjects, hmList, serialize, test, classes);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (l");
            _builder.append(this.commandName, "\t\t");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("if (l");
            _builder.append(this.commandName, "\t\t\t");
            _builder.append(".size() > 0) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("mutations.addAll(l");
            _builder.append(this.commandName, "\t\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("//METHOD INC: ");
            int _plusPlus_1 = localNMethod++;
            _builder.append(_plusPlus_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("return mutations;\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public Object generateMethods(final Mutator mut, final boolean exhaustive, final MutatorEnvironment e, final Block b, final boolean last) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mut instanceof CompositeMutator)) {
        _builder.append("//COUNTER COMPOSITE: ");
        int _get = this.nCompositeMethod[0];
        int _plus = (_get + 1);
        int _set = this.nCompositeMethod[0] = _plus;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//COMPOSITE METHOD NAME:");
        String _string = Integer.valueOf((this.nCompositeMethod[0])).toString();
        String _plus_1 = ("compositeMutation" + _string);
        String _compositeMethodName = this.compositeMethodName = _plus_1;
        _builder.append(_compositeMethodName);
        _builder.newLineIfNotEmpty();
        {
          if ((this.compositeCommands == null)) {
            _builder.append("//CREATION ARRAYLIST NUM COMMANDS: ");
            ArrayList<String> _arrayList = new ArrayList<String>();
            List<String> _compositeCommands = this.compositeCommands = _arrayList;
            _builder.append(_compositeCommands);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//ADDING NUM COMMANDS: ");
        boolean _add = this.compositeCommands.add(this.compositeMethodName);
        _builder.append(_add);
        _builder.newLineIfNotEmpty();
        CharSequence _compositeMethod = this.compositeMethod(((CompositeMutator)mut), exhaustive);
        _builder.append(_compositeMethod);
        _builder.newLineIfNotEmpty();
        {
          EList<Mutator> _commands = ((CompositeMutator)mut).getCommands();
          for(final Mutator c : _commands) {
            Object _generateMethods = this.generateMethods(((Mutator) c), exhaustive, e, b, last);
            _builder.append(_generateMethods);
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("//COUNTER: ");
        int _get_1 = this.nMethod[0];
        int _plus_2 = (_get_1 + 1);
        int _set_1 = this.nMethod[0] = _plus_2;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
        _builder.append("//METHOD CALL: ");
        int _set_2 = this.nMethodCall[0] = this.nMethod[0];
        _builder.append(_set_2);
        _builder.newLineIfNotEmpty();
        _builder.append("//METHOD NAME:");
        String _string_1 = Integer.valueOf((this.nMethod[0])).toString();
        String _plus_3 = ("mutation" + _string_1);
        String _methodName = this.methodName = _plus_3;
        _builder.append(_methodName);
        _builder.newLineIfNotEmpty();
        CharSequence _method = this.method(((Mutator) mut), exhaustive, e, b, last);
        _builder.append(_method);
        _builder.append("\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence registryMethod(final Mutator mut, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this.standalone == false)) {
        _builder.append("private AppMutation ");
        _builder.append(this.registryMethodName);
        _builder.append("(Mutator mut, Map<String, EObject> hmMutator, Resource seed, Resource mutant, EObject clue, List<String> mutPaths, List<EPackage> packages) {");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("private AppMutation ");
        _builder.append(this.registryMethodName);
        _builder.append("(Mutator mut, Map<String, EObject> hmMutator, Resource seed, Resource mutant, EObject clue, List<String> mutPaths, List<EPackage> packages) {");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("AppMutation appMut = null;");
    _builder.newLine();
    {
      if ((mut instanceof CreateObjectMutator)) {
        _builder.append("ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();");
        _builder.newLine();
        _builder.append("EObject foundObject = findEObjectForRegistry(seed, mutant, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);");
        _builder.newLine();
        _builder.append("if (foundObject != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("cMut.getObject().add(foundObject);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get = this.nRegistryMutation[0];
        _builder.append(_get);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("cMut.setDef(hmMutator.get(\"m");
        int _get_1 = this.nRegistryMutation[0];
        _builder.append(_get_1, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = cMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof CloneObjectMutator)) {
        _builder.append("ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();");
        _builder.newLine();
        _builder.append("if (mut.getObject() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("cMut.getObject().add(mut.getObject());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_2 = this.nRegistryMutation[0];
        _builder.append(_get_2);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("cMut.setDef(hmMutator.get(\"m");
        int _get_3 = this.nRegistryMutation[0];
        _builder.append(_get_3, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = cMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof RetypeObjectMutator)) {
        _builder.append("ObjectRetyped rMut = AppliedMutationsFactory.eINSTANCE.createObjectRetyped();");
        _builder.newLine();
        _builder.append("if (mut.getObject() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getObject().add(mut.getObject());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("EObject foundObject = findEObjectForRegistry(seed, mutant, mut.getRemovedObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);");
        _builder.newLine();
        _builder.append("if (foundObject != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getRemovedObject().add(foundObject);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("rMut.setType(mut.getEType());");
        _builder.newLine();
        _builder.append("rMut.setNewType(mut.getNewEType());");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_4 = this.nRegistryMutation[0];
        _builder.append(_get_4);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_5 = this.nRegistryMutation[0];
        _builder.append(_get_5, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof RemoveObjectMutator)) {
        _builder.append("ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();");
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Robust fallback for removed objects.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* If the original identity can no longer be reconstructed,");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* derive the removed EObject directly from seed vs mutant.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("EObject foundObject = clue;");
        _builder.newLine();
        _builder.append("if (foundObject == null");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("&& seed != null");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("&& mutant != null) {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("    ");
        _builder.append("EMFDiff.ModelDelta delta =");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("EMFDiff.findAddedAndRemovedEObjects(");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("seed,");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("mutant);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("    ");
        _builder.append("if (delta != null");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("&& delta.getRemoved() != null) {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("        ");
        _builder.append("for (EObject removed :");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("delta.getRemoved()) {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("            ");
        _builder.append("if (removed == null");
        _builder.newLine();
        _builder.append("                    ");
        _builder.append("|| removed.eClass() == null) {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("                ");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("            ");
        _builder.append("EClass expectedType =");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("mut.getEType();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("            ");
        _builder.append("if (expectedType == null) {");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("            ");
        _builder.append("/*");
        _builder.newLine();
        _builder.append("             ");
        _builder.append("* Exact type or compatible subtype.");
        _builder.newLine();
        _builder.append("             ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("if (expectedType == removed.eClass()");
        _builder.newLine();
        _builder.append("                    ");
        _builder.append("|| expectedType.isSuperTypeOf(");
        _builder.newLine();
        _builder.append("                        ");
        _builder.append("removed.eClass())) {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("                ");
        _builder.append("foundObject =");
        _builder.newLine();
        _builder.append("                    ");
        _builder.append("removed;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("                ");
        _builder.append("break;");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (foundObject == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return appMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("rMut.getObject().add(foundObject);");
        _builder.newLine();
        _builder.append("rMut.setType(mut.getEType());");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_6 = this.nRegistryMutation[0];
        _builder.append(_get_6);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_7 = this.nRegistryMutation[0];
        _builder.append(_get_7, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof CreateReferenceMutator)) {
        _builder.append("ReferenceCreated rMut = AppliedMutationsFactory.eINSTANCE.createReferenceCreated();");
        _builder.newLine();
        _builder.append("if (mut.getObject() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getObject().add(mut.getObject());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (((CreateReferenceMutator) mut).getReference() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getRef().add(((CreateReferenceMutator) mut).getReference());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.setRefName(((CreateReferenceMutator) mut).getRefName());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_8 = this.nRegistryMutation[0];
        _builder.append(_get_8);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_9 = this.nRegistryMutation[0];
        _builder.append(_get_9, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof RemoveRandomReferenceMutator)) {
        _builder.append("ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();");
        _builder.newLine();
        _builder.append("List<EObject> objects = new ArrayList<EObject>();");
        _builder.newLine();
        _builder.append("objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));");
        _builder.newLine();
        _builder.append("rMut.getObject().addAll(objects);");
        _builder.newLine();
        _builder.append("if (((RemoveReferenceMutator) mut).getReference() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_10 = this.nRegistryMutation[0];
        _builder.append(_get_10);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_11 = this.nRegistryMutation[0];
        _builder.append(_get_11, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof RemoveSpecificReferenceMutator)) {
        _builder.append("ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();");
        _builder.newLine();
        _builder.append("List<EObject> objects = new ArrayList<EObject>();");
        _builder.newLine();
        _builder.append("objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));");
        _builder.newLine();
        _builder.append("rMut.getObject().addAll(objects);");
        _builder.newLine();
        _builder.append("if (((RemoveReferenceMutator) mut).getReference() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_12 = this.nRegistryMutation[0];
        _builder.append(_get_12);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_13 = this.nRegistryMutation[0];
        _builder.append(_get_13, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof RemoveCompleteReferenceMutator)) {
        _builder.append("ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();");
        _builder.newLine();
        _builder.append("List<EObject> objects = new ArrayList<EObject>();");
        _builder.newLine();
        _builder.append("objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));");
        _builder.newLine();
        _builder.append("rMut.getObject().addAll(objects);");
        _builder.newLine();
        _builder.append("if (((RemoveReferenceMutator) mut).getReference() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_14 = this.nRegistryMutation[0];
        _builder.append(_get_14);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("rMut.setDef(hmMutator.get(\"m");
        int _get_15 = this.nRegistryMutation[0];
        _builder.append(_get_15, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = rMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof ModifyInformationMutator)) {
        _builder.append("\t");
        _builder.append("InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ModifyInformationMutator mutator = (ModifyInformationMutator) mut;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//Resource mutant = mutator.getModel();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("icMut.setObject(mut.getObject());");
        _builder.newLine();
        {
          int _size = ((ModifyInformationMutator) mut).getAttributes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("\t");
            _builder.append("EList<AttributeChanged> attsMut = icMut.getAttChanges();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Object oldAttVal = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Object newAttVal = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("//ATTRIBUTE COUNTER: ");
            int attCounter = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<AttributeSet> _attributes = ((ModifyInformationMutator) mut).getAttributes();
              for(final AttributeSet att : _attributes) {
                _builder.append("//");
                EAttribute eattfirst = att.getAttribute().get(0);
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                EAttribute eattsec = eattfirst;
                _builder.newLineIfNotEmpty();
                {
                  if ((att instanceof AttributeScalar)) {
                    _builder.append("AttributeChanged attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name = eattfirst.getName();
                    _builder.append(_name);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((att instanceof AttributeOperation)) {
                    _builder.append("AttributeChanged attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name_1 = eattfirst.getName();
                    _builder.append(_name_1);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((att instanceof AttributeSwap)) {
                    _builder.append("//");
                    _builder.append(eattsec = ((AttributeSwap)att).getAttribute().get(1));
                    _builder.newLineIfNotEmpty();
                    _builder.append("appliedMutations.AttributeSwap attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeSwap();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setFirstName(\"");
                    String _name_2 = eattsec.getName();
                    _builder.append(_name_2);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("EObject otherObject = null;");
                    _builder.newLine();
                    _builder.append("if (mutator.getOtherObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("otherObject = ModelManager.getObject(seed, mutator.getOtherObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (otherObject == null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("otherObject = ModelManager.getObject(mutant, mutator.getOtherObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (otherObject != null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("attMut");
                    _builder.append(attCounter, "\t\t");
                    _builder.append(".setAttObject(otherObject);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name_3 = eattfirst.getName();
                    _builder.append(_name_3);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((att instanceof AttributeCopy)) {
                    _builder.append("//");
                    _builder.append(eattsec = ((AttributeCopy)att).getAttribute().get(1));
                    _builder.newLineIfNotEmpty();
                    _builder.append("AttributeChanged attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name_4 = eattfirst.getName();
                    _builder.append(_name_4);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((att instanceof AttributeUnset)) {
                    _builder.append("AttributeChanged attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name_5 = eattfirst.getName();
                    _builder.append(_name_5);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((att instanceof AttributeReverse)) {
                    _builder.append("AttributeChanged attMut");
                    _builder.append(attCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("attMut");
                    _builder.append(attCounter);
                    _builder.append(".setAttName(\"");
                    String _name_6 = eattfirst.getName();
                    _builder.append(_name_6);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("oldAttVal = mutator.getOldAttValue(\"");
                String _name_7 = eattfirst.getName();
                _builder.append(_name_7);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("newAttVal = mutator.getNewAttValue(\"");
                String _name_8 = eattfirst.getName();
                _builder.append(_name_8);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (oldAttVal != null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("attMut");
                _builder.append(attCounter, "\t");
                _builder.append(".setOldVal(oldAttVal.toString());");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.append("if (newAttVal != null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("attMut");
                _builder.append(attCounter, "\t");
                _builder.append(".setNewVal(newAttVal.toString());");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.append("if (hmMutator.get(\"m");
                int _get_16 = this.nRegistryMutation[0];
                _builder.append(_get_16);
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("attMut");
                _builder.append(attCounter, "\t");
                _builder.append(".setDef(hmMutator.get(\"m");
                int _get_17 = this.nRegistryMutation[0];
                _builder.append(_get_17, "\t");
                _builder.append("\"));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("attsMut.add(attMut");
                _builder.append(attCounter, "\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("icMut.setDef(hmMutator.get(\"m");
                int _get_18 = this.nRegistryMutation[0];
                _builder.append(_get_18, "\t");
                _builder.append("\"));");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("attMut");
                _builder.append(attCounter, "\t");
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("icMut = null;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("//ATTRIBUTE COUNTER INC: ");
                int _plusPlus = attCounter++;
                _builder.append(_plusPlus);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          int _size_1 = ((ModifyInformationMutator) mut).getReferences().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("\t");
            _builder.append("EList<ReferenceChanged> refsMut = icMut.getRefChanges();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("EObject previous = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("EObject next = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("//REFERENCE COUNTER: ");
            int refCounter = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<ReferenceSet> _references = ((ModifyInformationMutator) mut).getReferences();
              for(final ReferenceSet ref : _references) {
                {
                  if (((((ref instanceof ReferenceInit) || (ref instanceof ReferenceAdd)) || (ref instanceof ReferenceRemove)) || (ref instanceof ReferenceUnset))) {
                    _builder.append("//");
                    EReference eref = ref.getReference().get(0);
                    _builder.newLineIfNotEmpty();
                    _builder.append("ReferenceChanged refMut");
                    _builder.append(refCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setRefName(\"");
                    String _name_9 = eref.getName();
                    _builder.append(_name_9);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".getObject().add(mutator.getObject());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".getMutantObject().add(mutator.getObject());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setFrom(mutator.getPrevious(\"");
                    String _name_10 = ref.getReference().get(0).getName();
                    _builder.append(_name_10);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setTo(mutator.getNext(\"");
                    String _name_11 = ref.getReference().get(0).getName();
                    _builder.append(_name_11);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((ref instanceof ReferenceSwap)) {
                    _builder.append("//");
                    EReference ereffirst = ((ReferenceSwap)ref).getReference().get(0);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//");
                    EReference erefsec = ((ReferenceSwap)ref).getReference().get(1);
                    _builder.newLineIfNotEmpty();
                    _builder.append("appliedMutations.ReferenceSwap refMut");
                    _builder.append(refCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setFirstName(\"");
                    String _name_12 = ereffirst.getName();
                    _builder.append(_name_12);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("EObject refObject = null;");
                    _builder.newLine();
                    _builder.append("if (mutator.getRefObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("refObject = ModelManager.getObject(seed, mutator.getRefObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refObject == null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refObject = ModelManager.getObject(mutant, mutator.getRefObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refObject != null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refMut");
                    _builder.append(refCounter, "\t\t");
                    _builder.append(".setRefObject(refObject);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setRefName(\"");
                    String _name_13 = erefsec.getName();
                    _builder.append(_name_13);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setOtherFrom(mutator.getOtherSource(\"");
                    String _name_14 = ereffirst.getName();
                    _builder.append(_name_14);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setOtherFromName(mutator.getOtherSourceName(\"");
                    String _name_15 = ereffirst.getName();
                    _builder.append(_name_15);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setOtherTo(mutator.getOtherTarget(\"");
                    String _name_16 = ereffirst.getName();
                    _builder.append(_name_16);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setOtherToName(mutator.getOtherTargetName(\"");
                    String _name_17 = ereffirst.getName();
                    _builder.append(_name_17);
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((ref instanceof ReferenceAtt)) {
                    _builder.append("//");
                    EAttribute att_1 = ((ReferenceAtt)ref).getAttribute();
                    _builder.newLineIfNotEmpty();
                    _builder.append("appliedMutations.ReferenceAtt refMut");
                    _builder.append(refCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(" = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setAttName(\"");
                    String _name_18 = att_1.getName();
                    _builder.append(_name_18);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("EObject refAttObject = null;");
                    _builder.newLine();
                    _builder.append("if (mutator.getRefAttObject() != null) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refAttObject == null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("if (refAttObject != null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("refMut");
                    _builder.append(refCounter, "\t\t");
                    _builder.append(".getObject().add(refAttObject);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("refMut");
                    _builder.append(refCounter);
                    _builder.append(".setRefName(\"");
                    String _name_19 = ((ReferenceAtt)ref).getReference().get(0).getName();
                    _builder.append(_name_19);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("Object oldRefAttVal");
                    _builder.append(refCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("Object newRefAttVal");
                    _builder.append(refCounter);
                    _builder.append(" = null;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (((ModifyInformationMutator) mut).getOldRefAttValue(\"");
                    String _name_20 = att_1.getName();
                    _builder.append(_name_20);
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("oldRefAttVal");
                    _builder.append(refCounter, "\t");
                    _builder.append(" = mutator.getOldRefAttValue(\"");
                    String _name_21 = att_1.getName();
                    _builder.append(_name_21, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("if (((ModifyInformationMutator) mut).getNewRefAttValue(\"");
                    String _name_22 = att_1.getName();
                    _builder.append(_name_22);
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("newRefAttVal");
                    _builder.append(refCounter, "\t");
                    _builder.append(" = mutator.getNewRefAttValue(\"");
                    String _name_23 = att_1.getName();
                    _builder.append(_name_23, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("if (oldRefAttVal");
                    _builder.append(refCounter);
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refMut");
                    _builder.append(refCounter, "\t");
                    _builder.append(".setOldVal(oldRefAttVal");
                    _builder.append(refCounter, "\t");
                    _builder.append(".toString());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("if (newRefAttVal");
                    _builder.append(refCounter);
                    _builder.append(" != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refMut");
                    _builder.append(refCounter, "\t");
                    _builder.append(".setNewVal(newRefAttVal");
                    _builder.append(refCounter, "\t");
                    _builder.append(".toString());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("if (hmMutator.get(\"m");
                    int _get_19 = this.nRegistryMutation[0];
                    _builder.append(_get_19);
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("refMut");
                    _builder.append(refCounter, "\t");
                    _builder.append(".setDef(hmMutator.get(\"m");
                    int _get_20 = this.nRegistryMutation[0];
                    _builder.append(_get_20, "\t");
                    _builder.append("\"));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                _builder.append("if (hmMutator.get(\"m");
                int _get_21 = this.nRegistryMutation[0];
                _builder.append(_get_21);
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("previous = mutator.getPrevious(\"");
                String _name_24 = ref.getReference().get(0).getName();
                _builder.append(_name_24, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("next = mutator.getNext(\"");
                String _name_25 = ref.getReference().get(0).getName();
                _builder.append(_name_25, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (previous != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t\t");
                _builder.append(".setFrom(previous);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t\t");
                _builder.append(".setMutantFrom(previous);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (next != null) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t\t");
                _builder.append(".setTo(next);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t\t");
                _builder.append(".setMutantTo(next);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t");
                _builder.append(".setSrcRefName(mutator.getSrcRefType());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t");
                _builder.append(".setDef(hmMutator.get(\"m");
                int _get_22 = this.nRegistryMutation[0];
                _builder.append(_get_22, "\t");
                _builder.append("\"));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("refsMut.add(refMut");
                _builder.append(refCounter, "\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("icMut.setDef(hmMutator.get(\"m");
                int _get_23 = this.nRegistryMutation[0];
                _builder.append(_get_23, "\t");
                _builder.append("\"));");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("refMut");
                _builder.append(refCounter, "\t");
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("icMut = null;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("//REFERENCE COUNTER INC: ");
                int _plusPlus_1 = refCounter++;
                _builder.append(_plusPlus_1);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("appMut = icMut;");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof ModifySourceReferenceMutator)) {
        _builder.append("SourceReferenceChanged srcMut = AppliedMutationsFactory.eINSTANCE.createSourceReferenceChanged();");
        _builder.newLine();
        _builder.append("srcMut.getObject().add(mut.getObject());");
        _builder.newLine();
        _builder.append("srcMut.setFrom(((ModifySourceReferenceMutator) mut).getSource());");
        _builder.newLine();
        _builder.append("srcMut.setTo(((ModifySourceReferenceMutator) mut).getNewSource());");
        _builder.newLine();
        _builder.append("srcMut.setRefName(((ModifySourceReferenceMutator) mut).getRefType());");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_24 = this.nRegistryMutation[0];
        _builder.append(_get_24);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("srcMut.setDef(hmMutator.get(\"m");
        int _get_25 = this.nRegistryMutation[0];
        _builder.append(_get_25, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = srcMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof ModifyTargetReferenceMutator)) {
        _builder.append("TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();");
        _builder.newLine();
        _builder.append("ModifyTargetReferenceMutator mutator = (ModifyTargetReferenceMutator) mut;");
        _builder.newLine();
        _builder.append("//Resource mutant = mutator.getModel();");
        _builder.newLine();
        _builder.append("EObject object = ModelManager.getObject(seed, mutator.getObject());");
        _builder.newLine();
        _builder.append("if (object == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object = ModelManager.getObject(mutant, mutator.getObject());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (object != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("trcMut.getObject().add(object);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("EObject from = ModelManager.getObject(seed, mutator.getSource());");
        _builder.newLine();
        _builder.append("if (from == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("from = ModelManager.getObject(mutant, mutator.getSource());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (from != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("trcMut.setFrom(from);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("trcMut.setSrcRefName(mutator.getSrcRefType());");
        _builder.newLine();
        _builder.append("EObject to = ModelManager.getObject(seed, mutator.getNewTarget());");
        _builder.newLine();
        _builder.append("if (to == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("to = ModelManager.getObject(mutant, mutator.getNewTarget());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (to != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("trcMut.setTo(to);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("EObject oldTo = ModelManager.getObjectByURIEnding(seed, mutator.getOldTargetURI());");
        _builder.newLine();
        _builder.append("if (oldTo == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("oldTo = ModelManager.getObjectByURIEnding(mutant, mutator.getOldTargetURI());");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (oldTo != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("trcMut.setOldTo(oldTo);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("trcMut.setRefName(mutator.getRefType());");
        _builder.newLine();
        _builder.append("if (hmMutator.get(\"m");
        int _get_26 = this.nRegistryMutation[0];
        _builder.append(_get_26);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("trcMut.setDef(hmMutator.get(\"m");
        int _get_27 = this.nRegistryMutation[0];
        _builder.append(_get_27, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = trcMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof SelectObjectMutator)) {
        _builder.append("if (hmMutator.get(\"m");
        int _get_28 = this.nRegistryMutation[0];
        _builder.append(_get_28);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("appMut.setDef(hmMutator.get(\"m");
        int _get_29 = this.nRegistryMutation[0];
        _builder.append(_get_29, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      if ((mut instanceof SelectSampleMutator)) {
        _builder.append("if (hmMutator.get(\"m");
        int _get_30 = this.nRegistryMutation[0];
        _builder.append(_get_30);
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("appMut.setDef(hmMutator.get(\"m");
        int _get_31 = this.nRegistryMutation[0];
        _builder.append(_get_31, "\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return appMut;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence compositeRegistryMethod(final CompositeMutator mut, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EObject _eContainer = mut.eContainer();
      if ((_eContainer instanceof MutatorEnvironment)) {
        _builder.append("//LOCAL COPY REGISTRY COUNTER: ");
        int localNRegistryMutation = this.nRegistryMutation[0];
        _builder.newLineIfNotEmpty();
        {
          if ((this.standalone == false)) {
            _builder.append("private AppMutation ");
            _builder.append(this.compositeRegistryMethodName);
            _builder.append("(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("private AppMutation ");
            _builder.append(this.compositeRegistryMethodName);
            _builder.append("(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("CompositeMutation appMut = AppliedMutationsFactory.eINSTANCE.createCompositeMutation();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("appMut.setSize(");
        int _mutatorSize = MutatorUtils.mutatorSize(mut);
        _builder.append(_mutatorSize, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("List<AppMutation> appMuts = new ArrayList<AppMutation>();");
        _builder.newLine();
        _builder.append("\t");
        int _get = this.nRegistryMethod[0];
        int localNRegistryMethod = (_get + 1);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        int mutCounter = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<Mutator> _commands = mut.getCommands();
          for(final Mutator c : _commands) {
            _builder.append("\t");
            _builder.append("//REGISTRY METHOD NAME:");
            String _string = Integer.valueOf(localNRegistryMethod).toString();
            String _plus = ("registry" + _string);
            String _registryMethodName = this.registryMethodName = _plus;
            _builder.append(_registryMethodName, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//REGISTRY COUNTER INC: ");
            int _plusPlus = localNRegistryMutation++;
            _builder.append(_plusPlus, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("AppMutation appMut");
            _builder.append((mutCounter + 1), "\t");
            _builder.append(" = ");
            _builder.append(this.registryMethodName, "\t");
            _builder.append("(muts.get(");
            _builder.append(mutCounter, "\t");
            _builder.append("), hmMutator, seed, null, null);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("if (hmMutator.get(\"m");
            int _get_1 = this.nRegistryMutation[0];
            _builder.append(_get_1, "\t");
            _builder.append("\") != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("appMut");
            _builder.append((mutCounter + 1), "\t\t");
            _builder.append(".setDef(hmMutator.get(\"m");
            _builder.append(localNRegistryMutation, "\t\t");
            _builder.append("\"));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("appMuts.add(appMut");
            _builder.append((mutCounter + 1), "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//REGISTRY METHOD INC: ");
            int _plusPlus_1 = localNRegistryMethod++;
            _builder.append(_plusPlus_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//COUNTER: ");
            int _plusPlus_2 = mutCounter++;
            _builder.append(_plusPlus_2, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("if (hmMutator.get(\"m");
        int _get_2 = this.nRegistryMutation[0];
        _builder.append(_get_2, "\t");
        _builder.append("\") != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("appMut.getMuts().addAll(appMuts);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("appMut.setDef(hmMutator.get(\"m");
        int _get_3 = this.nRegistryMutation[0];
        _builder.append(_get_3, "\t\t");
        _builder.append("\"));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("appMut = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return appMut;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public Object generateRegistryMethods(final Mutator mut, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mut instanceof CompositeMutator)) {
        _builder.append("//COUNTER COMPOSITE REGISTRY: ");
        int _get = this.nCompositeRegistryMethod[0];
        int _plus = (_get + 1);
        int _set = this.nCompositeRegistryMethod[0] = _plus;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//COMPOSITE REGISTRY METHOD NAME:");
        String _string = Integer.valueOf((this.nCompositeRegistryMethod[0])).toString();
        String _plus_1 = ("compositeRegistry" + _string);
        String _compositeRegistryMethodName = this.compositeRegistryMethodName = _plus_1;
        _builder.append(_compositeRegistryMethodName);
        _builder.newLineIfNotEmpty();
        {
          if ((this.compositeRegistryCommands == null)) {
            _builder.append("//CREATION ARRAYLIST NUM REGISTRY COMMANDS: ");
            ArrayList<String> _arrayList = new ArrayList<String>();
            List<String> _compositeRegistryCommands = this.compositeRegistryCommands = _arrayList;
            _builder.append(_compositeRegistryCommands);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//ADDING NUM COMMANDS: ");
        boolean _add = this.compositeRegistryCommands.add(this.compositeRegistryMethodName);
        _builder.append(_add);
        _builder.newLineIfNotEmpty();
        CharSequence _compositeRegistryMethod = this.compositeRegistryMethod(((CompositeMutator)mut), exhaustive);
        _builder.append(_compositeRegistryMethod);
        _builder.newLineIfNotEmpty();
        {
          EList<Mutator> _commands = ((CompositeMutator)mut).getCommands();
          for(final Mutator c : _commands) {
            Object _generateRegistryMethods = this.generateRegistryMethods(c, exhaustive);
            _builder.append(_generateRegistryMethods);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//COUNTER REGISTRY: ");
        int _get_1 = this.nRegistryMethod[0];
        int _mutatorSize = MutatorUtils.mutatorSize(((CompositeMutator)mut));
        int _plus_2 = (_get_1 + _mutatorSize);
        int _set_1 = this.nRegistryMethod[0] = _plus_2;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("//COUNTER: ");
        int _get_2 = this.nRegistryMethod[0];
        int _plus_3 = (_get_2 + 1);
        int _set_2 = this.nRegistryMethod[0] = _plus_3;
        _builder.append(_set_2);
        _builder.newLineIfNotEmpty();
        _builder.append("//METHOD NAME:");
        String _string_1 = Integer.valueOf((this.nRegistryMethod[0])).toString();
        String _plus_4 = ("registry" + _string_1);
        String _registryMethodName = this.registryMethodName = _plus_4;
        _builder.append(_registryMethodName);
        _builder.newLineIfNotEmpty();
        CharSequence _registryMethod = this.registryMethod(mut, exhaustive);
        _builder.append(_registryMethod);
        _builder.append("\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateBlock(final Block b, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNMethod = this.nMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNCompositeMethod = this.nCompositeMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNMutation = this.nMutation[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNRegistryMutation = this.nRegistryMutation[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNRegistryMethod = this.nRegistryMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNRegistryMethodCall = this.nRegistryMethodCall[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNCompositeRegistryMethod = this.nCompositeRegistryMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//SAVE COUNTER: ");
    int localNCompositeCommands = this.nCompositeCommands[0];
    _builder.newLineIfNotEmpty();
    {
      EList<Mutator> _commands = b.getCommands();
      for(final Mutator c : _commands) {
        _builder.append("\t");
        EObject _eContainer = b.eContainer();
        EList<Mutator> _commands_1 = b.getCommands();
        int _size = b.getCommands().size();
        int _minus = (_size - 1);
        Object _generateMethods = this.generateMethods(c, exhaustive, ((MutatorEnvironment) _eContainer), b, EcoreUtil.equals(c, _commands_1.get(_minus)));
        _builder.append(_generateMethods, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Object _generateRegistryMethods = this.generateRegistryMethods(c, exhaustive);
        _builder.append(_generateRegistryMethods, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((this.standalone == false)) {
        _builder.append("\t");
        _builder.append("public int block_");
        String _name = b.getName();
        _builder.append(_name, "\t");
        _builder.append("(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t\t\t\t\t  ");
        _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t\t\t\t\t  ");
        _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("public int block_");
        String _name_1 = b.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t\t\t\t\t  ");
        _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t\t\t\t\t  ");
        _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("int numMutantsGenerated = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (maxAttempts <= 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("maxAttempts = 1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MutatorUtils.beginRegistryLookupResources();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNMethod = this.nMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNCompositeMethod = this.nCompositeMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNMutation = this.nMutation[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNRegistryMutation = this.nRegistryMutation[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNRegistryMethod = this.nRegistryMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNRegistryMethodCall = this.nRegistryMethodCall[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNCompositeRegistryMethod = this.nCompositeRegistryMethod[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//TEMP COUNTER: ");
    int tempNCompositeCommands = this.nCompositeCommands[0];
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set = this.nMethod[0] = localNMethod;
    _builder.append(_set, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_1 = this.nCompositeMethod[0] = localNCompositeMethod;
    _builder.append(_set_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_2 = this.nMutation[0] = localNMutation;
    _builder.append(_set_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_3 = this.nRegistryMutation[0] = localNRegistryMutation;
    _builder.append(_set_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_4 = this.nRegistryMethod[0] = localNRegistryMethod;
    _builder.append(_set_4, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_5 = this.nRegistryMethodCall[0] = localNRegistryMethodCall;
    _builder.append(_set_5, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_6 = this.nCompositeRegistryMethod[0] = localNCompositeRegistryMethod;
    _builder.append(_set_6, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESET COUNTER: ");
    int _set_7 = this.nCompositeCommands[0] = localNCompositeCommands;
    _builder.append(_set_7, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//");
    EObject _eContainer_1 = b.eContainer();
    MutatorEnvironment e = ((MutatorEnvironment) _eContainer_1);
    _builder.newLineIfNotEmpty();
    {
      Definition _definition = e.getDefinition();
      if ((_definition instanceof Program)) {
        _builder.append("\t");
        CharSequence _multipleBlock = this.multipleBlock(e, b);
        _builder.append(_multipleBlock, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_8 = this.nMethod[0] = tempNMethod;
    _builder.append(_set_8, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_9 = this.nCompositeMethod[0] = tempNCompositeMethod;
    _builder.append(_set_9, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_10 = this.nMutation[0] = tempNMutation;
    _builder.append(_set_10, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_11 = this.nRegistryMutation[0] = tempNRegistryMutation;
    _builder.append(_set_11, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_12 = this.nRegistryMethod[0] = tempNRegistryMethod;
    _builder.append(_set_12, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_13 = this.nRegistryMethodCall[0] = tempNRegistryMethodCall;
    _builder.append(_set_13, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_14 = this.nCompositeRegistryMethod[0] = tempNCompositeRegistryMethod;
    _builder.append(_set_14, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RESTORE COUNTER: ");
    int _set_15 = this.nCompositeCommands[0] = tempNCompositeCommands;
    _builder.append(_set_15, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("MutatorUtils.endRegistryLookupResources();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return numMutantsGenerated;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Computes execution levels for mutation blocks.
   * 
   * Blocks in the same level are independent with respect to the explicit
   * Wodel "from" relation and can therefore be executed in parallel.
   * A block is placed one level after its deepest predecessor.
   */
  public List<List<Block>> getBlockExecutionLevels(final MutatorEnvironment e) {
    final List<List<Block>> levels = new ArrayList<List<Block>>();
    final Map<Block, Integer> cache = new LinkedHashMap<Block, Integer>();
    EList<Block> _blocks = e.getBlocks();
    for (final Block b : _blocks) {
      if (((b.getCommands() != null) && (!b.getCommands().isEmpty()))) {
        ArrayList<Block> _arrayList = new ArrayList<Block>();
        final int level = this.getBlockExecutionLevel(b, cache, _arrayList);
        while ((levels.size() <= level)) {
          ArrayList<Block> _arrayList_1 = new ArrayList<Block>();
          levels.add(_arrayList_1);
        }
        levels.get(level).add(b);
      }
    }
    return levels;
  }

  /**
   * Recursive helper used by getBlockExecutionLevels.
   * It also protects code generation against circular block dependencies.
   */
  private int getBlockExecutionLevel(final Block b, final Map<Block, Integer> cache, final List<Block> visiting) {
    final Integer cached = cache.get(b);
    if ((cached != null)) {
      return (cached).intValue();
    }
    boolean _contains = visiting.contains(b);
    if (_contains) {
      final List<Block> cycleBlocks = new ArrayList<Block>(visiting);
      cycleBlocks.add(b);
      final Function1<Block, String> _function = (Block it) -> {
        return it.getName();
      };
      final String cycle = IterableExtensions.join(ListExtensions.<Block, String>map(cycleBlocks, _function), " -> ");
      throw new IllegalStateException(("Circular Wodel block dependency: " + cycle));
    }
    visiting.add(b);
    int level = 0;
    EList<Block> _from = b.getFrom();
    for (final Block parent : _from) {
      int _blockExecutionLevel = this.getBlockExecutionLevel(parent, cache, visiting);
      int _plus = (_blockExecutionLevel + 1);
      level = Math.max(level, _plus);
    }
    visiting.remove(b);
    cache.put(b, Integer.valueOf(level));
    return level;
  }

  public CharSequence compile(final MutatorEnvironment e, final IProject project, final String mutatorName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("//");
    IProject _xifexpression = null;
    if ((project != null)) {
      _xifexpression = project;
    } else {
      _xifexpression = ProjectUtils.getProject();
    }
    IProject _project = this.project = _xifexpression;
    _builder.append(_project);
    _builder.newLineIfNotEmpty();
    _builder.append("package mutator.");
    _builder.append(this.className);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.Collections;");
    _builder.newLine();
    _builder.append("import java.util.LinkedHashSet;");
    _builder.newLine();
    _builder.append("import java.util.Set;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.LinkedHashMap;");
    _builder.newLine();
    _builder.append("import java.util.AbstractMap.SimpleEntry;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.ExecutorService;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.Executors;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.ExecutionException;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.Future;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import wodel.utils.manager.IWodelTest;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.ModelManager;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.MutatorMetricsGenerator;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.DebugMutatorMetricsGenerator;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.NetMutatorMetricsGenerator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.core.resources.IProject;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EPackage;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EReference;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EStructuralFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.Resource;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.util.EcoreUtil;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import appliedMutations.*;");
    _builder.newLine();
    _builder.append("import wodel.utils.commands.*;");
    _builder.newLine();
    _builder.append("import wodel.utils.commands.selection.strategies.*;");
    _builder.newLine();
    _builder.append("import wodel.utils.commands.strategies.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.AbstractCreationException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.MaxSmallerThanMinException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.MetaModelNotFoundException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.ModelNotFoundException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.ObjectNoTargetableException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.ObjectNotContainedException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.ReferenceNonExistingException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.WrongAttributeTypeException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.common.util.URI;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.common.util.EList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.IProgressMonitor;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.NullProgressMonitor;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import wodel.utils.manager.MutatorUtils;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.MutatorUtils.OwnedResourceScope;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.EMFCopier;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mutatorenvironment.MutatorenvironmentPackage;");
    _builder.newLine();
    _builder.append("import mutatormetrics.MutatormetricsPackage;");
    _builder.newLine();
    _builder.append("import mutatorenvironment.miniOCL.MiniOCLPackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import wodel.utils.manager.EMFDiff;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.EMFDiff.ModelDelta;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.WodelRandomContext;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.WodelTempModelContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.ResourceSet;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.XMLResource;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.random.RandomGenerator;");
    _builder.newLine();
    _builder.append("import java.util.Random;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(this.className);
    _builder.append(" extends MutatorUtils {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("\t");
        _builder.append("private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("\t");
        _builder.append("private List<EObject> mutatedObjects = null;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("private List<EObject> mutatedObjects = null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static long blockSeed(");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("long executionSeed,");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("String blockName) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("long value =");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("executionSeed");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("^ ((long) blockName.hashCode()");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("<< 32)");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("^ blockName.hashCode();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("value ^= value >>> 33;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("value *= 0xff51afd7ed558ccdL;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("value ^= value >>> 33;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("value *= 0xc4ceb9fe1a85ec53L;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("value ^= value >>> 33;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("return value;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static void registerPackage(");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("ResourceSet resourceSet,");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("EPackage ePackage) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if (ePackage == null) {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("String nsURI =");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("ePackage.getNsURI();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if (nsURI != null &&");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("!nsURI.isBlank()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("resourceSet");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append(".getPackageRegistry()");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append(".put(");
    _builder.newLine();
    _builder.append("\t                ");
    _builder.append("nsURI,");
    _builder.newLine();
    _builder.append("\t                ");
    _builder.append("ePackage);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("for (EPackage subpackage :");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("ePackage.getESubpackages()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("registerPackage(");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("resourceSet,");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("subpackage);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* @param packages");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*            MetaModel");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* @param modelURI");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*            URI of the Model");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* @return Resource Loaded Model");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* @throws");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static Resource loadModelHeadless(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("List<EPackage> packages,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("String strURI) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("if (strURI == null ||");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("strURI.isBlank()) {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("File file =");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("new File(strURI);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("if (!file.isFile()) {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("\"Model does not exist: \"");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("+ file.getAbsolutePath());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("ResourceSet resourceSet =");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("ModelManager.initializeResource(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("strURI);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("URI uri =");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("URI.createFileURI(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("file.getAbsolutePath());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("if (packages != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("for (EPackage p : packages) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("registerPackage(");
    _builder.newLine();
    _builder.append("\t\t                ");
    _builder.append("resourceSet,");
    _builder.newLine();
    _builder.append("\t\t                ");
    _builder.append("p);");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("Map<Object, Object> options =");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("resourceSet.getLoadOptions();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_USE_PARSER_POOL,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("new XMLParserPoolImpl());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_USE_DEPRECATED_METHODS,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("Boolean.FALSE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("new LinkedHashMap<Object, Object>());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_DEFER_ATTACHMENT,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("Boolean.TRUE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_DEFER_IDREF_RESOLUTION,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("Boolean.TRUE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("options.put(");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_PROCESS_DANGLING_HREF,");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("Resource model =");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("resourceSet.createResource(uri);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("if (model == null) {");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("\"Loading domain model: \" + strURI);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("\"packages = \"");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("+ (packages == null ? \"null\" : packages.size()));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (packages != null) {");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("for (EPackage p : packages) {");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("\"  package: \"");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("+ p.getName()");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("+ \" -> \"");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("+ p.getNsURI());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("resourceSet");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append(".getPackageRegistry()");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append(".put(");
    _builder.newLine();
    _builder.append("\t\t                ");
    _builder.append("p.getNsURI(),");
    _builder.newLine();
    _builder.append("\t\t                ");
    _builder.append("p);");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("\"pythonast registered locally = \"");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("+ resourceSet");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append(".getPackageRegistry()");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append(".containsKey(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("\"http://www.python.org/pythonast/3.14\"));");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("model.load(options);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("if (!model.getErrors().isEmpty()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("for (Resource.Diagnostic error :");
    _builder.newLine();
    _builder.append("\t\t                    ");
    _builder.append("model.getErrors()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t                ");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t                    ");
    _builder.append("\"Model load error: \"");
    _builder.newLine();
    _builder.append("\t\t                    ");
    _builder.append("+ error.getMessage());");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("return model;");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("System.err.println(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("\"Cannot load model: \"");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("+ file.getAbsolutePath());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("e.printStackTrace(");
    _builder.newLine();
    _builder.append("\t\t            ");
    _builder.append("System.err);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t        ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* Result produced by one block worker. The maps contain only the changes");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* introduced by that block, so merging is performed by the coordinator");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* thread and never concurrently.");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static final class BlockExecutionResult {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private final String blockName;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private int numMutantsGenerated;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private final Map<String, Set<String>> mutantDelta;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private final Map<String, List<String>> mutantVersionDelta;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public BlockExecutionResult(String blockName,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("int numMutantsGenerated,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Map<String, Set<String>> mutantDelta,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Map<String, List<String>> mutantVersionDelta) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.blockName = blockName;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.numMutantsGenerated = numMutantsGenerated;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.mutantDelta = mutantDelta;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.mutantVersionDelta = mutantVersionDelta;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public String getBlockName() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return blockName;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public int getNumMutantsGenerated() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return numMutantsGenerated;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void setNumMutantsGenerated(int value) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("numMutantsGenerated = value;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public Map<String, Set<String>> getMutantDelta() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return mutantDelta;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public Map<String, List<String>> getMutantVersionDelta() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return mutantVersionDelta;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static Map<String, Set<String>> copyMutantMap(Map<String, Set<String>> source) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Map<String, Set<String>> copy = new LinkedHashMap<String, Set<String>>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, Set<String>> entry : source.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("copy.put(entry.getKey(), new LinkedHashSet<String>(entry.getValue()));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return copy;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static Map<String, List<String>> copyMutantVersionMap(Map<String, List<String>> source) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Map<String, List<String>> copy = new LinkedHashMap<String, List<String>>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, List<String>> entry : source.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("copy.put(entry.getKey(), new ArrayList<String>(entry.getValue()));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return copy;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static Map<String, Set<String>> mutantDelta(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, Set<String>> before,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, Set<String>> after) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Map<String, Set<String>> delta = new LinkedHashMap<String, Set<String>>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, Set<String>> entry : after.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Set<String> values = new LinkedHashSet<String>(entry.getValue());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Set<String> oldValues = before.get(entry.getKey());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (oldValues != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("values.removeAll(oldValues);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!values.isEmpty()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("delta.put(entry.getKey(), values);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return delta;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static Map<String, List<String>> mutantVersionDelta(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, List<String>> before,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, List<String>> after) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Map<String, List<String>> delta = new LinkedHashMap<String, List<String>>();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, List<String>> entry : after.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("List<String> values = new ArrayList<String>(entry.getValue());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("List<String> oldValues = before.get(entry.getKey());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (oldValues != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("/* Remove one occurrence for every pre-existing occurrence. */");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("for (String oldValue : oldValues) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("values.remove(oldValue);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!values.isEmpty()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("delta.put(entry.getKey(), values);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return delta;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static void mergeMutants(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, Set<String>> target,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, Set<String>> delta) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, Set<String>> entry : delta.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Set<String> values = target.get(entry.getKey());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (values == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("values = new LinkedHashSet<String>();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("target.put(entry.getKey(), values);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("values.addAll(entry.getValue());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static void mergeMutantVersions(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, List<String>> target,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Map<String, List<String>> delta) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Map.Entry<String, List<String>> entry : delta.entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("List<String> values = target.get(entry.getKey());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (values == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("values = new ArrayList<String>();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("target.put(entry.getKey(), values);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("values.addAll(entry.getValue());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected static BlockExecutionResult getBlockResult(Future<BlockExecutionResult> future)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throws ReferenceNonExistingException, WrongAttributeTypeException,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return future.get();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("catch (InterruptedException exception) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Thread.currentThread().interrupt();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new IOException(\"Parallel Wodel mutant generation was interrupted.\", exception);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("catch (ExecutionException exception) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Throwable cause = exception.getCause();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof ReferenceNonExistingException) throw (ReferenceNonExistingException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof WrongAttributeTypeException) throw (WrongAttributeTypeException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof MaxSmallerThanMinException) throw (MaxSmallerThanMinException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof AbstractCreationException) throw (AbstractCreationException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof ObjectNoTargetableException) throw (ObjectNoTargetableException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof ObjectNotContainedException) throw (ObjectNotContainedException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof MetaModelNotFoundException) throw (MetaModelNotFoundException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof ModelNotFoundException) throw (ModelNotFoundException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof IOException) throw (IOException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof RuntimeException) throw (RuntimeException) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (cause instanceof Error) throw (Error) cause;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new IOException(\"Error during parallel Wodel mutant generation.\", cause);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static boolean isBlockSelected(");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("String blockName,");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("String[] blockNames) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("return blockNames == null");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("|| blockNames.length == 0");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("|| Arrays.asList(blockNames)");
    _builder.newLine();
    _builder.append("\t                 ");
    _builder.append(".contains(blockName);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Definition _definition = e.getDefinition();
      if ((_definition instanceof Program)) {
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set = this.nMethod[0] = 0;
        _builder.append(_set, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_1 = this.nCompositeMethod[0] = 0;
        _builder.append(_set_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_2 = this.nRegistryMethod[0] = 0;
        _builder.append(_set_2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_3 = this.nRegistryMethodCall[0] = 0;
        _builder.append(_set_3, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_4 = this.nCompositeRegistryMethod[0] = 0;
        _builder.append(_set_4, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_5 = this.nMutation[0] = 0;
        _builder.append(_set_5, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_6 = this.nRegistryMutation[0] = 0;
        _builder.append(_set_6, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_7 = this.nCompositeCommands[0] = 0;
        _builder.append(_set_7, "\t");
        _builder.newLineIfNotEmpty();
        {
          int _size = e.getCommands().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            {
              EList<Mutator> _commands = e.getCommands();
              for(final Mutator c : _commands) {
                _builder.append("\t");
                Definition _definition_1 = e.getDefinition();
                EObject _eContainer = c.eContainer();
                EList<Mutator> _commands_1 = e.getCommands();
                int _size_1 = e.getCommands().size();
                int _minus = (_size_1 - 1);
                Object _generateMethods = this.generateMethods(c, ((Program) _definition_1).isExhaustive(), ((MutatorEnvironment) _eContainer), null, EcoreUtil.equals(c, _commands_1.get(_minus)));
                _builder.append(_generateMethods, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                Definition _definition_2 = e.getDefinition();
                Object _generateRegistryMethods = this.generateRegistryMethods(c, ((Program) _definition_2).isExhaustive());
                _builder.append(_generateRegistryMethods, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            {
              if ((this.standalone == false)) {
                _builder.append("\t");
                _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
                _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
                _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
                _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
                _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t  \t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("MutationResults mutationResults = new MutationResults();");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (maxAttempts <= 0) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("maxAttempts = 1;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("int totalTasks = 0;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (metrics == true) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("totalTasks++;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (debugMetrics == true) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("totalTasks++;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            {
              Definition _definition_3 = e.getDefinition();
              boolean _isExhaustive = ((Program) _definition_3).isExhaustive();
              boolean _equals = (_isExhaustive == false);
              if (_equals) {
                _builder.append("\t\t");
                _builder.append("//");
                Definition _definition_4 = e.getDefinition();
                int _set_8 = this.nMut[0] = ((Program) _definition_4).getNum();
                _builder.append(_set_8, "\t\t");
                _builder.newLineIfNotEmpty();
                {
                  int _get = this.nMut[0];
                  boolean _notEquals = (_get != 0);
                  if (_notEquals) {
                    _builder.append("\t   \t");
                    _builder.append("numMutants = ");
                    int _get_1 = this.nMut[0];
                    _builder.append(_get_1, "\t   \t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("numMutants = -1;");
                _builder.newLine();
              }
            }
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("int totalMutants = 0;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_9 = this.nMethod[0] = 0;
            _builder.append(_set_9, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_10 = this.nCompositeMethod[0] = 0;
            _builder.append(_set_10, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_11 = this.nMutation[0] = 0;
            _builder.append(_set_11, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_12 = this.nRegistryMutation[0] = 0;
            _builder.append(_set_12, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_13 = this.nRegistryMethod[0] = 0;
            _builder.append(_set_13, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_14 = this.nRegistryMethodCall[0] = 0;
            _builder.append(_set_14, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_15 = this.nCompositeRegistryMethod[0] = 0;
            _builder.append(_set_15, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("//RESET COUNTER: ");
            int _set_16 = this.nCompositeCommands[0] = 0;
            _builder.append(_set_16, "\t\t");
            _builder.newLineIfNotEmpty();
            {
              Definition _definition_5 = e.getDefinition();
              if ((_definition_5 instanceof Program)) {
                _builder.append("\t\t");
                CharSequence _multiple = this.multiple(e);
                _builder.append(_multiple, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("//Generate metrics model");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + \"model/MutatorMetrics.ecore\";");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("metricsecore = metricsecore.substring(1, metricsecore.length());");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("MutatorMetricsGenerator metricsGenerator = null;");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("if (metrics == true) {");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("monitor.subTask(\"Generating dynamic net metrics\");");
            _builder.newLine();
            {
              if ((this.standalone == false)) {
                _builder.append("\t   \t\t");
                _builder.append("metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_6 = ((MutatorEnvironment) e).getDefinition();
                String _output = ((Program) _definition_6).getOutput();
                _builder.append(_output, "\t   \t\t");
                _builder.append("\", \"");
                Definition _definition_7 = ((MutatorEnvironment) e).getDefinition();
                String _metamodel = ((Program) _definition_7).getMetamodel();
                _builder.append(_metamodel, "\t   \t\t");
                _builder.append("\", ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_8 = ((MutatorEnvironment) e).getDefinition();
                String _path = ((Program) _definition_8).getSource().getPath();
                _builder.append(_path, "\t   \t\t");
                _builder.append("\", \"");
                String _lastSegment = this.fileURI.lastSegment();
                _builder.append(_lastSegment, "\t   \t\t");
                _builder.append("\", hashmapMutVersions, this.getClass());");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t   \t\t");
                _builder.append("metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_9 = ((MutatorEnvironment) e).getDefinition();
                String _output_1 = ((Program) _definition_9).getOutput();
                _builder.append(_output_1, "\t   \t\t");
                _builder.append("\", \"");
                Definition _definition_10 = ((MutatorEnvironment) e).getDefinition();
                String _metamodel_1 = ((Program) _definition_10).getMetamodel();
                _builder.append(_metamodel_1, "\t   \t\t");
                _builder.append("\", ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_11 = ((MutatorEnvironment) e).getDefinition();
                String _path_1 = ((Program) _definition_11).getSource().getPath();
                _builder.append(_path_1, "\t   \t\t");
                _builder.append("\", \"");
                String _lastSegment_1 = this.fileURI.lastSegment();
                _builder.append(_lastSegment_1, "\t   \t\t");
                _builder.append("\", hashmapMutVersions, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class);");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t   \t\t");
            _builder.append("metricsGenerator.run();");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("monitor.worked(1);");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("if (debugMetrics == true) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("monitor.subTask(\"Generating dynamic debug metrics\");");
            _builder.newLine();
            {
              if ((this.standalone == true)) {
                _builder.append("\t   \t\t");
                _builder.append("metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_12 = ((MutatorEnvironment) e).getDefinition();
                String _output_2 = ((Program) _definition_12).getOutput();
                _builder.append(_output_2, "\t   \t\t");
                _builder.append("\", \"");
                Definition _definition_13 = ((MutatorEnvironment) e).getDefinition();
                String _metamodel_2 = ((Program) _definition_13).getMetamodel();
                _builder.append(_metamodel_2, "\t   \t\t");
                _builder.append("\", ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_14 = ((MutatorEnvironment) e).getDefinition();
                String _path_2 = ((Program) _definition_14).getSource().getPath();
                _builder.append(_path_2, "\t   \t\t");
                _builder.append("\", \"");
                String _lastSegment_2 = this.fileURI.lastSegment();
                _builder.append(_lastSegment_2, "\t   \t\t");
                _builder.append("\", hashmapMutVersions, this.getClass());");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t   \t\t");
                _builder.append("metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_15 = ((MutatorEnvironment) e).getDefinition();
                String _output_3 = ((Program) _definition_15).getOutput();
                _builder.append(_output_3, "\t   \t\t");
                _builder.append("\", \"");
                Definition _definition_16 = ((MutatorEnvironment) e).getDefinition();
                String _metamodel_3 = ((Program) _definition_16).getMetamodel();
                _builder.append(_metamodel_3, "\t   \t\t");
                _builder.append("\", ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
                Definition _definition_17 = ((MutatorEnvironment) e).getDefinition();
                String _path_3 = ((Program) _definition_17).getSource().getPath();
                _builder.append(_path_3, "\t   \t\t");
                _builder.append("\", \"");
                String _lastSegment_3 = this.fileURI.lastSegment();
                _builder.append(_lastSegment_3, "\t   \t\t");
                _builder.append("\", hashmapMutVersions, ");
                _builder.append(this.className, "\t   \t\t");
                _builder.append(".class);");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t   \t\t");
            _builder.append("metricsGenerator.run();");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("monitor.worked(1);   \t\t\t");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + 1);");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("if (mutationResults.getMutatorsApplied() == null) {");
            _builder.newLine();
            _builder.append("\t   \t\t");
            _builder.append("mutationResults.setMutatorsApplied(new ArrayList<String>());");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("mutationResults.getMutatorsApplied().add(\"\");");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.newLine();
            _builder.append("\t   \t");
            _builder.append("return mutationResults;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    {
      int _size_2 = e.getBlocks().size();
      boolean _greaterThan_1 = (_size_2 > 0);
      if (_greaterThan_1) {
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_17 = this.nMethod[0] = 0;
        _builder.append(_set_17, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_18 = this.nCompositeMethod[0] = 0;
        _builder.append(_set_18, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_19 = this.nMutation[0] = 0;
        _builder.append(_set_19, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_20 = this.nRegistryMutation[0] = 0;
        _builder.append(_set_20, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_21 = this.nRegistryMethod[0] = 0;
        _builder.append(_set_21, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_22 = this.nRegistryMethodCall[0] = 0;
        _builder.append(_set_22, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_23 = this.nCompositeRegistryMethod[0] = 0;
        _builder.append(_set_23, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//RESET COUNTER: ");
        int _set_24 = this.nCompositeCommands[0] = 0;
        _builder.append(_set_24, "\t");
        _builder.newLineIfNotEmpty();
        {
          EList<Block> _blocks = e.getBlocks();
          for(final Block b : _blocks) {
            {
              int _size_3 = b.getCommands().size();
              boolean _greaterThan_2 = (_size_3 > 0);
              if (_greaterThan_2) {
                _builder.append("\t");
                Definition _definition_18 = e.getDefinition();
                CharSequence _generateBlock = this.generateBlock(b, ((Program) _definition_18).isExhaustive());
                _builder.append(_generateBlock, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t\t  ");
            _builder.append("ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("MutationResults mutationResults = new MutationResults();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (maxAttempts <= 0) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("maxAttempts = 1;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("final int blockMaxAttempts = maxAttempts;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("final int blockNumMutants = numMutants;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("int totalTasks = ");
        int _size_4 = e.getBlocks().size();
        _builder.append(_size_4, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (metrics == true) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("totalTasks++;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (debugMetrics == true) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("totalTasks++;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("monitor.beginTask(\"Generating mutants\", totalTasks);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("/*");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* These two maps are owned by the coordinator thread. Worker blocks");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* receive private copies and return only their deltas. This avoids");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* concurrent writes to LinkedHashMap/ArrayList/LinkedHashSet.");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Map<String, Set<String>> hashmapMutants = new LinkedHashMap<String, Set<String>>();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("final List<EPackage> basePackages =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("packages == null");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("? Collections.emptyList()");
        _builder.newLine();
        _builder.append("        ");
        _builder.append(": Collections.unmodifiableList(");
        _builder.newLine();
        _builder.append("            ");
        _builder.append("new ArrayList<EPackage>(");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("packages));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("/*");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* Java 21: each submitted block runs in its own virtual thread.");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* Explicit Wodel \"from\" dependencies are respected by executing one");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* dependency level at a time and joining the whole level before the");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* next level is submitted.");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("ExecutorService blockExecutor = Executors.newVirtualThreadPerTaskExecutor();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        {
          List<List<Block>> _blockExecutionLevels = this.getBlockExecutionLevels(e);
          for(final List<Block> level : _blockExecutionLevels) {
            _builder.append("\t\t\t");
            _builder.append("/* Dependency level */");
            _builder.newLine();
            {
              for(final Block b_1 : level) {
                _builder.append("\t\t\t");
                _builder.append("Future<BlockExecutionResult> future_");
                String _name = b_1.getName();
                _builder.append(_name, "\t\t\t");
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("if (");
                _builder.append(this.className, "\t\t\t");
                _builder.append(".isBlockSelected(\"");
                String _name_1 = b_1.getName();
                _builder.append(_name_1, "\t\t\t");
                _builder.append("\", blockNames)) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("monitor.subTask(\"Scheduling mutant generation for block ");
                String _name_2 = b_1.getName();
                _builder.append(_name_2, "\t\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("final Map<String, Set<String>> baseMutants_");
                String _name_3 = b_1.getName();
                _builder.append(_name_3, "\t\t\t\t");
                _builder.append(" =");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("copyMutantMap(hashmapMutants);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("final Map<String, List<String>> baseMutantVersions_");
                String _name_4 = b_1.getName();
                _builder.append(_name_4, "\t\t\t\t");
                _builder.append(" =");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("copyMutantVersionMap(hashmapMutVersions);");
                _builder.newLine();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("future_");
                String _name_5 = b_1.getName();
                _builder.append(_name_5, "\t\t\t\t");
                _builder.append(" = blockExecutor.submit(() -> {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t    ");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("RandomGenerator blockRandom =");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t            ");
                _builder.append("new Random(blockSeed(executionSeed, \"");
                String _name_6 = b_1.getName();
                _builder.append(_name_6, "\t\t\t\t\t            ");
                _builder.append("\"));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t        ");
                _builder.append("WodelRandomContext.set(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t            ");
                _builder.append("blockRandom);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t            ");
                _builder.append("WodelTempModelContext.begin(");
                _builder.newLine();
                {
                  if ((this.standalone == false)) {
                    _builder.append("\t\t\t");
                    _builder.append("\t\t            ");
                    _builder.append(mutatorName, "\t\t\t\t\t            ");
                    _builder.append("Dynamic.class,");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append("\t\t            ");
                    _builder.append(mutatorName, "\t\t\t\t\t            ");
                    _builder.append("Standalone.class,");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("\t\t                            ");
                _builder.append("\"");
                String _name_7 = b_1.getName();
                _builder.append(_name_7, "\t\t\t\t\t                            ");
                _builder.append("\",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t                            ");
                _builder.append("executionSeed);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("try {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("//");
                final String metaModel = this.resolveMetaModelPath(e, project);
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("//String ecoreURI = \"");
                _builder.append(metaModel, "\t\t\t\t\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("//List<EPackage> initialPackages = ModelManager.loadMetaModelNoException(\"");
                String _name_8 = project.getName();
                _builder.append(_name_8, "\t\t\t\t\t");
                _builder.append("\", ecoreURI);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("/*");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t ");
                _builder.append("* A fresh generated-mutator instance isolates overallMutators and");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t ");
                _builder.append("* mutatedObjects for this block. The standalone helper methods are");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t ");
                _builder.append("* deliberately generated as instance methods for the same reason.");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append(this.className, "\t\t\t\t\t");
                _builder.append(" worker = new ");
                _builder.append(this.className, "\t\t\t\t\t");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("/*");
                _builder.newLine();
                _builder.append("         ");
                _builder.append("* IMPORTANT:");
                _builder.newLine();
                _builder.append("         ");
                _builder.append("* Every parallel block owns its package-list");
                _builder.newLine();
                _builder.append("         ");
                _builder.append("* container. Mutation code is allowed to replace");
                _builder.newLine();
                _builder.append("         ");
                _builder.append("* its contents without affecting another block.");
                _builder.newLine();
                _builder.append("         ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("List<EPackage> localPackages =");
                _builder.newLine();
                _builder.append("            ");
                _builder.append("new ArrayList<EPackage>(");
                _builder.newLine();
                _builder.append("                ");
                _builder.append("basePackages);");
                _builder.newLine();
                _builder.append("                ");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("Map<String, Set<String>> localMutants =");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("copyMutantMap(baseMutants_");
                String _name_9 = b_1.getName();
                _builder.append(_name_9, "\t\t\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("Map<String, List<String>> localMutantVersions =");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("copyMutantVersionMap(baseMutantVersions_");
                String _name_10 = b_1.getName();
                _builder.append(_name_10, "\t\t\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("List<String> fromNames = new ArrayList<String>();");
                _builder.newLine();
                {
                  EList<Block> _from = b_1.getFrom();
                  for(final Block from : _from) {
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("fromNames.add(\"");
                    String _name_11 = from.getName();
                    _builder.append(_name_11, "\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("List<String> localFromNames = Collections.unmodifiableList(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t            ");
                _builder.append("new ArrayList<String>(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t                ");
                _builder.append("fromNames)); ");
                _builder.newLine();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("int[] k = new int[] { 0 };");
                _builder.newLine();
                {
                  if ((this.standalone == false)) {
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("int generated = worker.block_");
                    String _name_12 = b_1.getName();
                    _builder.append(_name_12, "\t\t\t\t\t");
                    _builder.append("(");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("blockMaxAttempts, blockNumMutants, registry, localPackages,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("registeredPackages, localRegisteredPackages, localFromNames,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("localMutants, localMutantVersions, project,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("new NullProgressMonitor(), k, serialize, test, classes, executionSeed);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("int generated = worker.block_");
                    String _name_13 = b_1.getName();
                    _builder.append(_name_13, "\t\t\t\t\t");
                    _builder.append("(");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("blockMaxAttempts, blockNumMutants, registry, localPackages,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("registeredPackages, localRegisteredPackages, localFromNames,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("localMutants, localMutantVersions,");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("new NullProgressMonitor(), k, serialize, test, classes, executionSeed);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("return new BlockExecutionResult(");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("\"");
                String _name_14 = b_1.getName();
                _builder.append(_name_14, "\t\t\t\t\t\t");
                _builder.append("\",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("generated,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("mutantDelta(baseMutants_");
                String _name_15 = b_1.getName();
                _builder.append(_name_15, "\t\t\t\t\t\t");
                _builder.append(", localMutants),");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("mutantVersionDelta(baseMutantVersions_");
                String _name_16 = b_1.getName();
                _builder.append(_name_16, "\t\t\t\t\t\t");
                _builder.append(", localMutantVersions));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("finally {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("WodelTempModelContext.end();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t            ");
                _builder.append("WodelRandomContext.clear();");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t        ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("});");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("/* Join this level before scheduling blocks that depend on it. */");
            _builder.newLine();
            {
              for(final Block b_2 : level) {
                _builder.append("\t\t\t");
                _builder.append("if (future_");
                String _name_17 = b_2.getName();
                _builder.append(_name_17, "\t\t\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("BlockExecutionResult blockResult_");
                String _name_18 = b_2.getName();
                _builder.append(_name_18, "\t\t\t\t");
                _builder.append(" = getBlockResult(future_");
                String _name_19 = b_2.getName();
                _builder.append(_name_19, "\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("mergeMutants(hashmapMutants, blockResult_");
                String _name_20 = b_2.getName();
                _builder.append(_name_20, "\t\t\t\t");
                _builder.append(".getMutantDelta());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("mergeMutantVersions(hashmapMutVersions, blockResult_");
                String _name_21 = b_2.getName();
                _builder.append(_name_21, "\t\t\t\t");
                _builder.append(".getMutantVersionDelta());");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("if (blockResult_");
                String _name_22 = b_2.getName();
                _builder.append(_name_22, "\t\t\t\t");
                _builder.append(".getNumMutantsGenerated() > 0) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + 1);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("if (mutationResults.getMutatorsApplied() == null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t");
                _builder.append("mutationResults.setMutatorsApplied(new ArrayList<String>());");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("mutationResults.getMutatorsApplied().add(blockResult_");
                String _name_23 = b_2.getName();
                _builder.append(_name_23, "\t\t\t\t\t");
                _builder.append(".getBlockName());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t");
                _builder.append("mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + blockResult_");
                String _name_24 = b_2.getName();
                _builder.append(_name_24, "\t\t\t\t\t");
                _builder.append(".getNumMutantsGenerated());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("monitor.worked(1);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("finally {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("blockExecutor.shutdownNow();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//Generate metrics model");
        _builder.newLine();
        _builder.append("\t   \t");
        _builder.append("String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + \"model/MutatorMetrics.ecore\";");
        _builder.newLine();
        _builder.append("\t   \t");
        _builder.append("metricsecore = metricsecore.substring(1, metricsecore.length());");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("MutatorMetricsGenerator metricsGenerator = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (metrics == true) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("monitor.subTask(\"Generating dynamic net metrics\");");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t\t\t");
            _builder.append("metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_19 = ((MutatorEnvironment) e).getDefinition();
            String _output_4 = ((Program) _definition_19).getOutput();
            _builder.append(_output_4, "\t\t\t");
            _builder.append("\", \"");
            Definition _definition_20 = ((MutatorEnvironment) e).getDefinition();
            String _metamodel_4 = ((Program) _definition_20).getMetamodel();
            _builder.append(_metamodel_4, "\t\t\t");
            _builder.append("\", ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_21 = ((MutatorEnvironment) e).getDefinition();
            String _path_4 = ((Program) _definition_21).getSource().getPath();
            _builder.append(_path_4, "\t\t\t");
            _builder.append("\", \"");
            String _lastSegment_4 = this.fileURI.lastSegment();
            _builder.append(_lastSegment_4, "\t\t\t");
            _builder.append("\", hashmapMutVersions, this.getClass());");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t");
            _builder.append("metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_22 = ((MutatorEnvironment) e).getDefinition();
            String _output_5 = ((Program) _definition_22).getOutput();
            _builder.append(_output_5, "\t\t\t");
            _builder.append("\", \"");
            Definition _definition_23 = ((MutatorEnvironment) e).getDefinition();
            String _metamodel_5 = ((Program) _definition_23).getMetamodel();
            _builder.append(_metamodel_5, "\t\t\t");
            _builder.append("\", ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_24 = ((MutatorEnvironment) e).getDefinition();
            String _path_5 = ((Program) _definition_24).getSource().getPath();
            _builder.append(_path_5, "\t\t\t");
            _builder.append("\", \"");
            String _lastSegment_5 = this.fileURI.lastSegment();
            _builder.append(_lastSegment_5, "\t\t\t");
            _builder.append("\", hashmapMutVersions, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t   \t\t");
        _builder.append("metricsGenerator.run();");
        _builder.newLine();
        _builder.append("\t   \t\t");
        _builder.append("monitor.worked(1);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (debugMetrics == true) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("monitor.subTask(\"Generating dynamic debug metrics\");");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t\t\t");
            _builder.append("metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_25 = ((MutatorEnvironment) e).getDefinition();
            String _output_6 = ((Program) _definition_25).getOutput();
            _builder.append(_output_6, "\t\t\t");
            _builder.append("\", \"");
            Definition _definition_26 = ((MutatorEnvironment) e).getDefinition();
            String _metamodel_6 = ((Program) _definition_26).getMetamodel();
            _builder.append(_metamodel_6, "\t\t\t");
            _builder.append("\", ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_27 = ((MutatorEnvironment) e).getDefinition();
            String _path_6 = ((Program) _definition_27).getSource().getPath();
            _builder.append(_path_6, "\t\t\t");
            _builder.append("\", \"");
            String _lastSegment_6 = this.fileURI.lastSegment();
            _builder.append(_lastSegment_6, "\t\t\t");
            _builder.append("\", hashmapMutVersions, this.getClass());");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t");
            _builder.append("metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_28 = ((MutatorEnvironment) e).getDefinition();
            String _output_7 = ((Program) _definition_28).getOutput();
            _builder.append(_output_7, "\t\t\t");
            _builder.append("\", \"");
            Definition _definition_29 = ((MutatorEnvironment) e).getDefinition();
            String _metamodel_7 = ((Program) _definition_29).getMetamodel();
            _builder.append(_metamodel_7, "\t\t\t");
            _builder.append("\", ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"");
            Definition _definition_30 = ((MutatorEnvironment) e).getDefinition();
            String _path_7 = ((Program) _definition_30).getSource().getPath();
            _builder.append(_path_7, "\t\t\t");
            _builder.append("\", \"");
            String _lastSegment_7 = this.fileURI.lastSegment();
            _builder.append(_lastSegment_7, "\t\t\t");
            _builder.append("\", hashmapMutVersions, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t   \t\t");
        _builder.append("metricsGenerator.run();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("monitor.worked(1);   \t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return mutationResults;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }

  public CharSequence multiple(final MutatorEnvironment e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("    ");
    CharSequence _multipleCompile = this.multipleCompile(e.getDefinition());
    _builder.append(_multipleCompile, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t");
    CharSequence _execute = this.execute(e);
    _builder.append(_execute, "   \t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence multipleBlock(final MutatorEnvironment e, final Block b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("   ");
    CharSequence _multipleBlockCompile = this.multipleBlockCompile(e.getDefinition(), b);
    _builder.append(_multipleBlockCompile, "   ");
    _builder.newLineIfNotEmpty();
    {
      Definition _definition = e.getDefinition();
      boolean _isExhaustive = ((Program) _definition).isExhaustive();
      boolean _equals = (_isExhaustive == false);
      if (_equals) {
        _builder.append("   ");
        int nMut = 0;
        _builder.newLineIfNotEmpty();
        {
          int _fixed = b.getFixed();
          boolean _equals_1 = (_fixed == 0);
          if (_equals_1) {
            {
              int _max = b.getMax();
              int _min = b.getMin();
              int _minus = (_max - _min);
              boolean _greaterThan = (_minus > 0);
              if (_greaterThan) {
                _builder.append("//");
                int _min_1 = b.getMin();
                int _max_1 = b.getMax();
                int _min_2 = b.getMin();
                int _random = this.getRandom((_max_1 - _min_2));
                int _plus = (_min_1 + _random);
                int _nMut = nMut = _plus;
                _builder.append(_nMut);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if (((b.getMin() == 0) && (b.getMax() == 0))) {
                _builder.append("//");
                Definition _definition_1 = e.getDefinition();
                _builder.append(nMut = ((Program) _definition_1).getNum());
                _builder.newLineIfNotEmpty();
              } else {
                int _min_3 = b.getMin();
                int _max_2 = b.getMax();
                boolean _equals_2 = (_min_3 == _max_2);
                if (_equals_2) {
                  _builder.append("//");
                  _builder.append(nMut = b.getMin());
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            _builder.append("//");
            _builder.append(nMut = b.getFixed());
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((nMut != 0)) {
            _builder.append("   ");
            _builder.append("\t");
            _builder.append("numMutants = ");
            _builder.append(nMut, "   \t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("   ");
        _builder.append("numMutants = -1;");
        _builder.newLine();
      }
    }
    _builder.append("   \t");
    _builder.newLine();
    _builder.append("   \t");
    _builder.newLine();
    _builder.append("   \t");
    CharSequence _executeBlock = this.executeBlock(e, b);
    _builder.append(_executeBlock, "   \t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence multipleCompile(final Definition e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//");
    final String projectRoot = this.project.getLocation().toFile().getAbsolutePath().replace("\\", "/");
    _builder.newLineIfNotEmpty();
    {
      if ((e instanceof Program)) {
        _builder.append("\t");
        _builder.append("String ecoreURI = \"");
        String _metamodel = ((Program)e).getMetamodel();
        _builder.append(_metamodel, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          if (this.standalone) {
            _builder.append("\t");
            _builder.append("String modelURI =");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("\"");
            _builder.append(projectRoot, "\t    ");
            _builder.append("/");
            String _path = ((Program)e).getSource().getPath();
            _builder.append(_path, "\t    ");
            _builder.append("\".replace(\"\\\\\", \"/\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("String modelsURI =");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("\"");
            _builder.append(projectRoot, "\t    ");
            _builder.append("/");
            String _output = ((Program)e).getOutput();
            _builder.append(_output, "\t    ");
            _builder.append("\".replace(\"\\\\\", \"/\");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("String modelURI =");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append(this.className, "\t    ");
            _builder.append(".class");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getProtectionDomain()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getCodeSource()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getLocation()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getPath()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".replace(\"/bin/\", \"/\")");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("+ \"");
            String _path_1 = ((Program)e).getSource().getPath();
            _builder.append(_path_1, "\t    ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("String modelsURI =");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append(this.className, "\t    ");
            _builder.append(".class");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getProtectionDomain()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getCodeSource()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getLocation()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".getPath()");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append(".replace(\"/bin/\", \"/\")");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("+ \"");
            String _output_1 = ((Program)e).getOutput();
            _builder.append(_output_1, "\t    ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();");
        _builder.newLine();
        {
          boolean _endsWith = ((Program)e).getSource().getPath().endsWith("/");
          if (_endsWith) {
            _builder.append("\t");
            _builder.append("File[] files = new File(modelURI).listFiles();");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("File[] files = new File[1];");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("files[0] = new File(modelURI);");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("for (int i = 0; i < files.length; i++) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (files[i].isFile() == true) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("String pathfile = files[i].getPath();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("if (pathfile.endsWith(\".model\") == true) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("hashmapModelFilenames.put(pathfile.replace(\"\\\\\", \"/\"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - \".model\".length()));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}");
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
    _builder.append("\t");
    _builder.newLine();
    {
      if ((e instanceof Program)) {
        _builder.append("\t");
        _builder.append("//Load Model");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Set<String> modelFilenames = hashmapModelFilenames.keySet();");
        _builder.newLine();
        _builder.append("\t   \t");
        _builder.append("if (numMutants > 0) {");
        _builder.newLine();
        _builder.append("\t   \t\t");
        _builder.append("totalMutants = numMutants * ");
        EObject _eContainer = ((Program)e).eContainer();
        String _name = this.project.getName();
        String _plus = ((this.className + ".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")") + _name);
        String _plus_1 = (_plus + "/");
        int _numberOfSeedModels = MutatorUtils.getNumberOfSeedModels(((MutatorEnvironment) _eContainer), _plus_1);
        _builder.append(_numberOfSeedModels, "\t   \t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("totalTasks += totalMutants;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("monitor.beginTask(\"Generating mutants\", totalTasks);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("int count = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (String modelFilename : modelFilenames) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Set<String> hashsetMutants = new LinkedHashSet<String>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("hashsetMutants.add(modelFilename);");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence multipleBlockCompile(final Definition e, final Block b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//");
    final String projectRoot = this.project.getLocation().toFile().getAbsolutePath().replace("\\", "/");
    _builder.newLineIfNotEmpty();
    {
      if ((e instanceof Program)) {
        _builder.append("String ecoreURI = \"");
        String _metamodel = ((Program)e).getMetamodel();
        _builder.append(_metamodel);
        _builder.append("\".replace(\"\\\\\", \"/\");");
        _builder.newLineIfNotEmpty();
        {
          if (this.standalone) {
            _builder.append("String modelURI = \"");
            _builder.append(projectRoot);
            _builder.append("/");
            String _path = ((Program)e).getSource().getPath();
            _builder.append(_path);
            _builder.append("\".replace(\"\\\\\", \"/\");");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _builder.append("String modelsURI = \"");
            _builder.append(projectRoot);
            _builder.append("/");
            String _output = ((Program)e).getOutput();
            _builder.append(_output);
            _builder.append("\".replace(\"\\\\\", \"/\");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("String modelURI =");
            _builder.newLine();
            _builder.append("    ");
            _builder.append(this.className, "    ");
            _builder.append(".class");
            _builder.newLineIfNotEmpty();
            _builder.append("        ");
            _builder.append(".getProtectionDomain()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getCodeSource()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getLocation()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getPath()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".replace(\"/bin/\", \"/\")");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("+ \"");
            String _path_1 = ((Program)e).getSource().getPath();
            _builder.append(_path_1, "    ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _builder.append("String modelsURI =");
            _builder.newLine();
            _builder.append("    ");
            _builder.append(this.className, "    ");
            _builder.append(".class");
            _builder.newLineIfNotEmpty();
            _builder.append("        ");
            _builder.append(".getProtectionDomain()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getCodeSource()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getLocation()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".getPath()");
            _builder.newLine();
            _builder.append("        ");
            _builder.append(".replace(\"/bin/\", \"/\")");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("+ \"");
            String _output_1 = ((Program)e).getOutput();
            _builder.append(_output_1, "    ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();");
        _builder.newLine();
        _builder.append("Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();");
        _builder.newLine();
        _builder.append("Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();");
        _builder.newLine();
        {
          boolean _endsWith = ((Program)e).getSource().getPath().endsWith("/");
          if (_endsWith) {
            _builder.append("File[] files = new File(modelURI).listFiles();");
            _builder.newLine();
          } else {
            _builder.append("File[] files = new File[1];");
            _builder.newLine();
            _builder.append("files[0] = new File(modelURI);");
            _builder.newLine();
          }
        }
        _builder.append("for (int i = 0; i < files.length; i++) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (files[i].isFile() == true) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (files[i].getName().endsWith(\".model\") == true) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (fromNames.size() == 0) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("String pathfile = files[i].getPath();");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("if (pathfile.endsWith(\".model\") == true) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("hashmapModelFilenames.put(pathfile.replace(\"\\\\\", \"/\"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - \".model\".length()));");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("seedModelFilenames.put(pathfile.replace(\"\\\\\", \"/\"), files[i].getPath());");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("for (String fromName : fromNames) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - \".model\".length()) + \"/\" + fromName + \"/\";");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("File[] mutFiles = new File(modelFolder).listFiles();");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("if (mutFiles != null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("for (int j = 0; j < mutFiles.length; j++) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("if (mutFiles[j].isFile() == true) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("String pathfile = mutFiles[j].getPath();");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("if (pathfile.endsWith(\".model\") == true) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("hashmapModelFilenames.put(pathfile.replace(\"\\\\\", \"/\"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - \".model\".length()));");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("hashmapModelFolders.put(pathfile.replace(\"\\\\\", \"/\"), fromName + \"/\" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - \".model\".length()));");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t");
        _builder.append("seedModelFilenames.put(pathfile.replace(\"\\\\\", \"/\"), files[i].getPath());");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t");
        _builder.append("generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
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
    _builder.newLine();
    {
      if ((e instanceof Program)) {
        _builder.newLine();
        _builder.append("//Load Model");
        _builder.newLine();
        _builder.append("Set<String> modelFilenames = hashmapModelFilenames.keySet();");
        _builder.newLine();
        _builder.append("for (String modelFilename : modelFilenames) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String seedModelFilename = seedModelFilenames.get(modelFilename);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Set<String> hashsetMutantsBlock = null;");
        _builder.newLine();
        {
          Repeat _repeat = b.getRepeat();
          boolean _equals = Objects.equals(_repeat, Repeat.YES);
          if (_equals) {
            _builder.append("\t");
            _builder.append("hashsetMutantsBlock = new LinkedHashSet<String>();");
            _builder.newLine();
          } else {
            Repeat _repeat_1 = b.getRepeat();
            boolean _equals_1 = Objects.equals(_repeat_1, Repeat.NO);
            if (_equals_1) {
              _builder.append("\t");
              _builder.append("if (seedModelFilename != null) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("if (hashmapMutants.get(seedModelFilename) != null) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("hashsetMutantsBlock = hashmapMutants.get(seedModelFilename);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("if (hashsetMutantsBlock == null) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("hashsetMutantsBlock = new LinkedHashSet<String>();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
        _builder.append("\t");
        _builder.append("if (hashsetMutantsBlock.contains(seedModelFilename) == false) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("hashsetMutantsBlock.add(seedModelFilename);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence method(final AttributeSet e, final boolean flag, final boolean isList, final List<Integer> counter, final int position, final boolean exhaustive, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((isList == true)) {
        {
          EAttribute _get = e.getAttribute().get(0);
          boolean _tripleNotEquals = (_get != null);
          if (_tripleNotEquals) {
            final EAttribute attribute = e.getAttribute().get(0);
            _builder.newLineIfNotEmpty();
            {
              Integer _get_1 = counter.get(0);
              boolean _equals = ((_get_1).intValue() == 1);
              if (_equals) {
                _builder.append("List<AttributeConfigurationStrategy> atts = null;");
                _builder.newLine();
                _builder.append("if (attsList.get(\"");
                _builder.append(this.attributeName);
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("atts = attsList.get(\"");
                _builder.append(this.attributeName, "\t");
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
            _builder.append(this.attributeName = attribute.getName());
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            _builder.append(this.attributeName = "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeScalar)) {
            CharSequence _method = this.method(((AttributeScalar)e).getValue(), flag, counter, exhaustive, obSelectionVariableName);
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
              Integer _get_2 = counter.get(0);
              boolean _equals_1 = ((_get_2).intValue() == 1);
              if (_equals_1) {
                _builder.append("AttributeConfigurationStrategy attConfig = new ReverseBooleanConfigurationStrategy(\"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("attConfig = new ReverseBooleanConfigurationStrategy(\"");
                _builder.append(this.attributeName);
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
              Integer _get_3 = counter.get(0);
              boolean _equals_2 = ((_get_3).intValue() == 1);
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
                _builder.append(this.attributeName);
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
                  if ((((counter.get(0)).intValue() == 1) && (!(e instanceof AttributeCopy)))) {
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
                    _builder.append(this.attributeName);
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
                    _builder.append(this.attributeName);
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
        _builder.append(this.attributeName);
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
            _builder.append(this.attributeName = attribute_1.getName());
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            _builder.append(this.attributeName = "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeScalar)) {
            CharSequence _method_1 = this.method(((AttributeScalar)e).getValue(), flag, counter, exhaustive, obSelectionVariableName);
            _builder.append(_method_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("atts.put(\"");
            _builder.append(this.attributeName);
            _builder.append("\", attConfig);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeUnset)) {
            {
              Integer _get_5 = counter.get(0);
              boolean _equals_3 = ((_get_5).intValue() == 1);
              if (_equals_3) {
                _builder.append("AttributeConfigurationStrategy attConfig = null;");
                _builder.newLine();
              }
            }
            _builder.append("   \t\t");
            _builder.append("atts.put(\"");
            _builder.append(this.attributeName, "   \t\t");
            _builder.append("\", attConfig);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeReverse)) {
            _builder.append("   \t\t");
            _builder.append("attConfig = new ReverseBooleanConfigurationStrategy(\"");
            _builder.append(this.attributeName, "   \t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("   \t\t");
            _builder.append("atts.put(\"");
            _builder.append(this.attributeName, "   \t\t");
            _builder.append("\", attConfig);");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((e instanceof AttributeCopy)) {
            {
              Integer _get_6 = counter.get(0);
              boolean _equals_4 = ((_get_6).intValue() == 1);
              if (_equals_4) {
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
                _builder.append(this.attributeName);
                _builder.append("\", \"");
                String _name_9 = ((AttributeCopy)e).getAttribute().get(1).getName();
                _builder.append(_name_9);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("atts.put(\"");
                _builder.append(this.attributeName);
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
                    _builder.append(this.attributeName);
                    _builder.append("\", \"");
                    String _name_12 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_12);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("atts.put(\"");
                    _builder.append(this.attributeName);
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
                    _builder.append(this.attributeName);
                    _builder.append("\", \"");
                    String _name_15 = ((AttributeCopy)e).getAttribute().get(1).getName();
                    _builder.append(_name_15);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("atts.put(\"");
                    _builder.append(this.attributeName);
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

  public CharSequence method(final ReferenceSet e, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EReference _get = e.getReference().get(0);
      boolean _tripleNotEquals = (_get != null);
      if (_tripleNotEquals) {
        final EReference reference = e.getReference().get(0);
        _builder.newLineIfNotEmpty();
        _builder.append("//NAME:");
        _builder.append(this.referenceName = reference.getName());
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("//NAME:");
        _builder.append(this.referenceName = "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((((e instanceof ReferenceInit) || (e instanceof ReferenceRemove)) || (e instanceof ReferenceAdd))) {
        CharSequence _method = this.method(e.getObject(), this.referenceName, exhaustive);
        _builder.append(_method);
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t");
        _builder.append("refs.put(\"");
        _builder.append(this.referenceName, "   \t\t");
        _builder.append("\", refSelection");
        _builder.append(this.nReference, "   \t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence method(final AttributeType e, final boolean flag, final List<Integer> counter, final boolean exhaustive, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((e instanceof StringType)) {
        CharSequence _method = this.method(((StringType) e), exhaustive, counter);
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
                CharSequence _method_4 = this.method(((ListStringType) e), flag, exhaustive, counter, obSelectionVariableName);
                _builder.append(_method_4);
                _builder.newLineIfNotEmpty();
              } else {
                if ((e instanceof ListType)) {
                  CharSequence _method_5 = this.method(((ListType) e), flag, exhaustive, counter, obSelectionVariableName);
                  _builder.append(_method_5);
                  _builder.newLineIfNotEmpty();
                } else {
                  if ((e instanceof RandomType)) {
                    CharSequence _method_6 = this.method(((RandomType) e), flag, exhaustive, counter, obSelectionVariableName);
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
    return _builder;
  }

  public CharSequence method(final StringType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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
              boolean _equals_1 = this.attributeName.equals("");
              boolean _not = (!_equals_1);
              if (_not) {
                _builder.append("attConfig = new UpperStringConfigurationStrategy(\"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            if ((e instanceof LowerStringType)) {
              {
                boolean _equals_2 = this.attributeName.equals("");
                boolean _not_1 = (!_equals_2);
                if (_not_1) {
                  _builder.append("attConfig = new LowerStringConfigurationStrategy(\"");
                  _builder.append(this.attributeName);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if ((e instanceof CatStartStringType)) {
                {
                  boolean _equals_3 = this.attributeName.equals("");
                  boolean _not_2 = (!_equals_3);
                  if (_not_2) {
                    _builder.append("attConfig = new CatStartStringConfigurationStrategy(\"");
                    String _value_1 = ((CatStartStringType) e).getValue();
                    _builder.append(_value_1);
                    _builder.append("\", \"");
                    _builder.append(this.attributeName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                if ((e instanceof CatEndStringType)) {
                  {
                    boolean _equals_4 = this.attributeName.equals("");
                    boolean _not_3 = (!_equals_4);
                    if (_not_3) {
                      _builder.append("attConfig = new CatEndStringConfigurationStrategy(\"");
                      String _value_2 = ((CatEndStringType) e).getValue();
                      _builder.append(_value_2);
                      _builder.append("\", \"");
                      _builder.append(this.attributeName);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  if ((e instanceof ReplaceStringType)) {
                    {
                      boolean _equals_5 = this.attributeName.equals("");
                      boolean _not_4 = (!_equals_5);
                      if (_not_4) {
                        _builder.append("attConfig = new ReplaceStringConfigurationStrategy(\"");
                        _builder.append(this.attributeName);
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
    return _builder;
  }

  public CharSequence method(final DoubleType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final BooleanType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final IntegerType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final ListStringType e, final boolean flag, final boolean exhaustive, final List<Integer> counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof ListStringType)) {
        {
          boolean _equals_1 = this.attributeName.equals("");
          boolean _not = (!_equals_1);
          if (_not) {
            {
              if ((flag == false)) {
                _builder.append("attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", (");
                _builder.append(obSelectionVariableName);
                _builder.append(" != null) ? ");
                _builder.append(obSelectionVariableName);
                _builder.append(".getObject() : null), \"");
                EList<String> _value = ((ListStringType) e).getValue();
                _builder.append(_value);
                _builder.append("\", \"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", refObjectSelected), \"");
                EList<String> _value_1 = ((ListStringType) e).getValue();
                _builder.append(_value_1);
                _builder.append("\", \"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence method(final ListType e, final boolean flag, final boolean exhaustive, final List<Integer> counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof ListType)) {
        {
          boolean _equals_1 = this.attributeName.equals("");
          boolean _not = (!_equals_1);
          if (_not) {
            {
              if ((flag == false)) {
                _builder.append("attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", (");
                _builder.append(obSelectionVariableName);
                _builder.append(" != null) ? ");
                _builder.append(obSelectionVariableName);
                _builder.append(".getObject() : null), \"");
                EList<EObject> _value = ((ListType) e).getValue();
                _builder.append(_value);
                _builder.append("\", \"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", refObjectSelected), \"");
                EList<EObject> _value_1 = ((ListType) e).getValue();
                _builder.append(_value_1);
                _builder.append("\", \"");
                _builder.append(this.attributeName);
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
    return _builder;
  }

  public CharSequence method(final RandomType e, final boolean flag, final boolean exhaustive, final List<Integer> counter, final String obSelectionVariableName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
      if (_equals) {
        _builder.append("AttributeConfigurationStrategy attConfig = null;");
        _builder.newLine();
      }
    }
    {
      if ((e instanceof RandomType)) {
        {
          boolean _equals_1 = this.attributeName.equals("");
          boolean _not = (!_equals_1);
          if (_not) {
            {
              if ((flag == false)) {
                _builder.append("attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", ");
                _builder.append(obSelectionVariableName);
                _builder.append(".getObject()), \"");
                _builder.append(this.attributeName);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute(\"");
                _builder.append(this.attributeName);
                _builder.append("\", refObjectSelected), \"");
                _builder.append(this.attributeName);
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
    return _builder;
  }

  public CharSequence method(final MinValueType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final MaxValueType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final RandomIntegerNumberType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence method(final RandomDoubleNumberType e, final boolean exhaustive, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Integer _get = counter.get(0);
      boolean _equals = ((_get).intValue() == 1);
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

  public CharSequence add(final AttributeOperation op, final String obSelectionVariableName, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("atts.add(new AddOperationConfigurationStrategy(");
    _builder.append(obSelectionVariableName);
    _builder.append(".getMetaModel(), ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getModel(), \"");
    String _typeName = MutatorUtils.getTypeName(op);
    _builder.append(_typeName);
    _builder.append("\", \"");
    _builder.append(this.attributeName);
    _builder.append("\", ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getObject(), value));");
    _builder.newLineIfNotEmpty();
    _builder.append("attsList.put(\"");
    _builder.append(this.attributeName);
    _builder.append("\", atts); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence subtract(final AttributeOperation op, final String obSelectionVariableName, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("atts.add(new SubtractOperationConfigurationStrategy(");
    _builder.append(obSelectionVariableName);
    _builder.append(".getMetaModel(), ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getModel(), \"");
    String _typeName = MutatorUtils.getTypeName(op);
    _builder.append(_typeName);
    _builder.append("\", \"");
    _builder.append(this.attributeName);
    _builder.append("\", ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getObject(), value));");
    _builder.newLineIfNotEmpty();
    _builder.append("attsList.put(\"");
    _builder.append(this.attributeName);
    _builder.append("\", atts); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence multiply(final AttributeOperation op, final String obSelectionVariableName, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("atts.add(new MultiplyOperationConfigurationStrategy(");
    _builder.append(obSelectionVariableName);
    _builder.append(".getMetaModel(), ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getModel(), \"");
    String _typeName = MutatorUtils.getTypeName(op);
    _builder.append(_typeName);
    _builder.append("\", \"");
    _builder.append(this.attributeName);
    _builder.append("\", ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getObject(), value));");
    _builder.newLineIfNotEmpty();
    _builder.append("attsList.put(\"");
    _builder.append(this.attributeName);
    _builder.append("\", atts); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence divide(final AttributeOperation op, final String obSelectionVariableName, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("atts.add(new DivideOperationConfigurationStrategy(");
    _builder.append(obSelectionVariableName);
    _builder.append(".getMetaModel(), ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getModel(), \"");
    String _typeName = MutatorUtils.getTypeName(op);
    _builder.append(_typeName);
    _builder.append("\", \"");
    _builder.append(this.attributeName);
    _builder.append("\", ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getObject(), value));");
    _builder.newLineIfNotEmpty();
    _builder.append("attsList.put(\"");
    _builder.append(this.attributeName);
    _builder.append("\", atts); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence module(final AttributeOperation op, final String obSelectionVariableName, final List<Integer> counter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("atts.add(new ModuleOperationConfigurationStrategy(");
    _builder.append(obSelectionVariableName);
    _builder.append(".getMetaModel(), ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getModel(), \"");
    String _typeName = MutatorUtils.getTypeName(op);
    _builder.append(_typeName);
    _builder.append("\", \"");
    _builder.append(this.attributeName);
    _builder.append("\", ");
    _builder.append(obSelectionVariableName);
    _builder.append(".getObject(), value));");
    _builder.newLineIfNotEmpty();
    _builder.append("attsList.put(\"");
    _builder.append(this.attributeName);
    _builder.append("\", atts); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence method(final ObSelectionStrategy e, final String referenceName, final boolean exhaustive) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  \t\t");
    _builder.append("//REFERENCES COMPILES: ");
    int _get = this.nReference[0];
    int _plus = (_get + 1);
    int _set = this.nReference[0] = _plus;
    _builder.append(_set, "  \t\t");
    _builder.newLineIfNotEmpty();
    {
      if ((e instanceof RandomTypeSelection)) {
        _builder.append("RandomTypeSelection refRts");
        int _get_1 = this.nReference[0];
        _builder.append(_get_1);
        _builder.append(" = new RandomTypeSelection(packages, model, \"");
        String _name = ((RandomTypeSelection) e).getType().getName();
        _builder.append(_name);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          if (((((RandomTypeSelection)e).getExpression() != null) && (this.expressionList != null))) {
            _builder.append("List<EObject> refObjects");
            int _get_2 = this.nReference[0];
            _builder.append(_get_2);
            _builder.append(" = refRts");
            int _get_3 = this.nReference[0];
            _builder.append(_get_3);
            _builder.append(".getObjects();");
            _builder.newLineIfNotEmpty();
            _builder.append("//INDEX EXPRESSION: ");
            int _size = this.expressionList.size();
            int indexExpression = (_size - 1);
            _builder.newLineIfNotEmpty();
            _builder.append("Expression exp");
            Integer _get_4 = this.expressionList.get(indexExpression);
            _builder.append(_get_4);
            _builder.append(" = new Expression();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            Object _method = this.method(((RandomTypeSelection)e).getExpression(), 0, false);
            _builder.append(_method, "\t   \t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t   \t\t");
            _builder.append("List<EObject> refSelectedObjects");
            int _get_5 = this.nReference[0];
            _builder.append(_get_5, "\t   \t\t");
            _builder.append(" = evaluate(refObjects");
            int _get_6 = this.nReference[0];
            _builder.append(_get_6, "\t   \t\t");
            _builder.append(", exp");
            Integer _get_7 = this.expressionList.get(indexExpression);
            _builder.append(_get_7, "\t   \t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("EObject refObject");
            int _get_8 = this.nReference[0];
            _builder.append(_get_8);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refSelectedObjects");
            int _get_9 = this.nReference[0];
            _builder.append(_get_9);
            _builder.append(".size() > 0) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("refObject");
            int _get_10 = this.nReference[0];
            _builder.append(_get_10, "\t");
            _builder.append(" = refSelectedObjects");
            int _get_11 = this.nReference[0];
            _builder.append(_get_11, "\t");
            _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
            int _get_12 = this.nReference[0];
            _builder.append(_get_12, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("EObject refObject");
            int _get_13 = this.nReference[0];
            _builder.append(_get_13);
            _builder.append(" = refRts");
            int _get_14 = this.nReference[0];
            _builder.append(_get_14);
            _builder.append(".getObject();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("ObSelectionStrategy refSelection");
        int _get_15 = this.nReference[0];
        _builder.append(_get_15);
        _builder.append(" = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("if (refObject");
        int _get_16 = this.nReference[0];
        _builder.append(_get_16);
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("refSelection");
        int _get_17 = this.nReference[0];
        _builder.append(_get_17);
        _builder.append(" = ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new SpecificObjectSelection(packages, model, refObject");
        int _get_18 = this.nReference[0];
        _builder.append(_get_18, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      } else {
        if ((e instanceof OtherTypeSelection)) {
          _builder.append("OtherTypeSelection refOts");
          int _get_19 = this.nReference[0];
          _builder.append(_get_19);
          _builder.append(" = new OtherTypeSelection(packages, model, \"");
          String _name_1 = ((OtherTypeSelection) e).getType().getName();
          _builder.append(_name_1);
          _builder.append("\", ModelManager.getReference(\"");
          _builder.append(referenceName);
          _builder.append("\", objectSelection.getObject()));");
          _builder.newLineIfNotEmpty();
          {
            if (((((OtherTypeSelection)e).getExpression() != null) && (this.expressionList != null))) {
              _builder.append("List<EObject> refObjects");
              int _get_20 = this.nReference[0];
              _builder.append(_get_20);
              _builder.append(" = refOts");
              int _get_21 = this.nReference[0];
              _builder.append(_get_21);
              _builder.append(".getObjects();");
              _builder.newLineIfNotEmpty();
              _builder.append("//INDEX EXPRESSION: ");
              int _size_1 = this.expressionList.size();
              int indexExpression_1 = (_size_1 - 1);
              _builder.newLineIfNotEmpty();
              _builder.append("Expression exp");
              Integer _get_22 = this.expressionList.get(indexExpression_1);
              _builder.append(_get_22);
              _builder.append(" = new Expression();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t   \t\t");
              Object _method_1 = this.method(((OtherTypeSelection)e).getExpression(), 0, false);
              _builder.append(_method_1, "\t   \t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t   \t\t");
              _builder.append("List<EObject> refSelectedObjects");
              int _get_23 = this.nReference[0];
              _builder.append(_get_23, "\t   \t\t");
              _builder.append(" = evaluate(refObjects");
              int _get_24 = this.nReference[0];
              _builder.append(_get_24, "\t   \t\t");
              _builder.append(", exp");
              Integer _get_25 = this.expressionList.get(indexExpression_1);
              _builder.append(_get_25, "\t   \t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_26 = this.nReference[0];
              _builder.append(_get_26);
              _builder.append(" = null;");
              _builder.newLineIfNotEmpty();
              _builder.append("if (refSelectedObjects");
              int _get_27 = this.nReference[0];
              _builder.append(_get_27);
              _builder.append(".size() > 0) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("refObject");
              int _get_28 = this.nReference[0];
              _builder.append(_get_28, "\t");
              _builder.append(" = refSelectedObjects");
              int _get_29 = this.nReference[0];
              _builder.append(_get_29, "\t");
              _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
              int _get_30 = this.nReference[0];
              _builder.append(_get_30, "\t");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("EObject refObject");
              int _get_31 = this.nReference[0];
              _builder.append(_get_31);
              _builder.append(" = refOts");
              int _get_32 = this.nReference[0];
              _builder.append(_get_32);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("ObSelectionStrategy refSelection");
          int _get_33 = this.nReference[0];
          _builder.append(_get_33);
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
          _builder.append("if (refObject");
          int _get_34 = this.nReference[0];
          _builder.append(_get_34);
          _builder.append(" != null) {");
          _builder.newLineIfNotEmpty();
          _builder.append("refSelection");
          int _get_35 = this.nReference[0];
          _builder.append(_get_35);
          _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
          int _get_36 = this.nReference[0];
          _builder.append(_get_36);
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          if ((e instanceof NullTypeSelection)) {
            _builder.append("NullTypeSelection refNts");
            int _get_37 = this.nReference[0];
            _builder.append(_get_37);
            _builder.append(" = new NullTypeSelection(packages, model, \"");
            String _name_2 = ((NullTypeSelection) e).getType().getName();
            _builder.append(_name_2);
            _builder.append("\", ModelManager.getReference(\"");
            _builder.append(referenceName);
            _builder.append("\", objectSelection.getObject()));");
            _builder.newLineIfNotEmpty();
            {
              if (((((NullTypeSelection)e).getExpression() != null) && (this.expressionList != null))) {
                _builder.append("List<EObject> refObjects");
                int _get_38 = this.nReference[0];
                _builder.append(_get_38);
                _builder.append(" = refNts");
                int _get_39 = this.nReference[0];
                _builder.append(_get_39);
                _builder.append(".getObjects();");
                _builder.newLineIfNotEmpty();
                _builder.append("//INDEX EXPRESSION: ");
                int _size_2 = this.expressionList.size();
                int indexExpression_2 = (_size_2 - 1);
                _builder.newLineIfNotEmpty();
                _builder.append("Expression exp");
                Integer _get_40 = this.expressionList.get(indexExpression_2);
                _builder.append(_get_40);
                _builder.append(" = new Expression();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                Object _method_2 = this.method(((NullTypeSelection)e).getExpression(), 0, false);
                _builder.append(_method_2, "\t   \t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                _builder.append("List<EObject> refSelectedObjects");
                int _get_41 = this.nReference[0];
                _builder.append(_get_41, "\t   \t\t");
                _builder.append(" = evaluate(refObjects");
                int _get_42 = this.nReference[0];
                _builder.append(_get_42, "\t   \t\t");
                _builder.append(", exp");
                Integer _get_43 = this.expressionList.get(indexExpression_2);
                _builder.append(_get_43, "\t   \t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("EObject refObject");
                int _get_44 = this.nReference[0];
                _builder.append(_get_44);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("if (refSelectedObjects");
                int _get_45 = this.nReference[0];
                _builder.append(_get_45);
                _builder.append(".size() > 0) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("refObject");
                int _get_46 = this.nReference[0];
                _builder.append(_get_46, "\t");
                _builder.append(" = refSelectedObjects");
                int _get_47 = this.nReference[0];
                _builder.append(_get_47, "\t");
                _builder.append(".get(ModelManager.getRandomIndex(refSelectedObjects");
                int _get_48 = this.nReference[0];
                _builder.append(_get_48, "\t");
                _builder.append("));");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("EObject refObject");
                int _get_49 = this.nReference[0];
                _builder.append(_get_49);
                _builder.append(" = refOts");
                int _get_50 = this.nReference[0];
                _builder.append(_get_50);
                _builder.append(".getObject();");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("ObSelectionStrategy refSelection");
            int _get_51 = this.nReference[0];
            _builder.append(_get_51);
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (refObject");
            int _get_52 = this.nReference[0];
            _builder.append(_get_52);
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("refSelection");
            int _get_53 = this.nReference[0];
            _builder.append(_get_53);
            _builder.append(" = new SpecificObjectSelection(packages, model, refObject");
            int _get_54 = this.nReference[0];
            _builder.append(_get_54);
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            if ((e instanceof CompleteTypeSelection)) {
              _builder.append("RandomTypeSelection refRts");
              int _get_55 = this.nReference[0];
              _builder.append(_get_55);
              _builder.append(" = new RandomTypeSelection(packages, model, \"");
              String _name_3 = ((CompleteTypeSelection) e).getType().getName();
              _builder.append(_name_3);
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject refObject");
              int _get_56 = this.nReference[0];
              _builder.append(_get_56);
              _builder.append(" = refRts");
              int _get_57 = this.nReference[0];
              _builder.append(_get_57);
              _builder.append(".getObject();");
              _builder.newLineIfNotEmpty();
              _builder.append("ObSelectionStrategy refSelection");
              int _get_58 = this.nReference[0];
              _builder.append(_get_58);
              _builder.append(" = new SpecificObjectSelection(packages, model,\trefObject");
              int _get_59 = this.nReference[0];
              _builder.append(_get_59);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              if ((e instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy refSelection");
                int _get_60 = this.nReference[0];
                _builder.append(_get_60);
                _builder.append(" = null;");
                _builder.newLineIfNotEmpty();
                {
                  if ((exhaustive == false)) {
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                    String _name_4 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_4);
                    _builder.append("_");
                    int _get_61 = this.nReference[0];
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
                    int _get_62 = this.nReference[0];
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
                int _get_63 = this.nReference[0];
                _builder.append(_get_63);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                {
                  EReference _refType = ((SpecificObjectSelection)e).getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("refSelection");
                    int _get_64 = this.nReference[0];
                    _builder.append(_get_64);
                    _builder.append(" = new SpecificObjectSelection(packages, model, entry_");
                    String _name_9 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_9);
                    _builder.append("_");
                    int _get_65 = this.nReference[0];
                    _builder.append(_get_65);
                    _builder.append(".getKey(), \"");
                    String _name_10 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_10);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("refSelection");
                    int _get_66 = this.nReference[0];
                    _builder.append(_get_66);
                    _builder.append(" = new SpecificObjectSelection(packages, model, entry_");
                    String _name_11 = ((SpecificObjectSelection) e).getObjSel().getName();
                    _builder.append(_name_11);
                    _builder.append("_");
                    int _get_67 = this.nReference[0];
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
                    int _get_68 = this.nReference[0];
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
                    int _get_69 = this.nReference[0];
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
                int _get_70 = this.nReference[0];
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
                int _get_71 = this.nReference[0];
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
                    int _get_72 = this.nReference[0];
                    _builder.append(_get_72, "\t");
                    _builder.append(" = new SpecificObjectSelection(packages, model, objs, \"");
                    String _name_18 = ((SpecificObjectSelection)e).getRefType().getName();
                    _builder.append(_name_18, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("refSelection");
                    int _get_73 = this.nReference[0];
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
                  if ((exhaustive == false)) {
                    _builder.append("\t\t");
                    _builder.append("return mutations;");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append("return numMutantsGenerated;");
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

  private String compileAuxiliarExpression(final int expressionPosition) {
    int _size = this.expressionList.size();
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
            Integer _get = this.expressionList.get(indexExpression);
            _builder.append(_get);
            _builder.append(" = new Expression();");
            _builder.newLineIfNotEmpty();
            _builder.append("auxExp");
            Integer _get_1 = this.expressionList.get(indexExpression);
            _builder.append(_get_1);
            _builder.append(".first = exp");
            Integer _get_2 = this.expressionList.get(indexExpression);
            _builder.append(_get_2);
            _builder.append(".first;");
            _builder.newLineIfNotEmpty();
            _builder.append("auxExp");
            Integer _get_3 = this.expressionList.get(indexExpression);
            _builder.append(_get_3);
            _builder.append(".operator = new ArrayList<Operator>();");
            _builder.newLineIfNotEmpty();
          } else {
            {
              if (((expressionCounter).intValue() == 1)) {
                _builder.append("Operator op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_4 = this.expressionList.get(indexExpression);
                _builder.append(_get_4);
                _builder.append(" = new Operator();");
                _builder.newLineIfNotEmpty();
                _builder.append("op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_5 = this.expressionList.get(indexExpression);
                _builder.append(_get_5);
                _builder.append(".type = exp");
                Integer _get_6 = this.expressionList.get(indexExpression);
                _builder.append(_get_6);
                _builder.append(".operator.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append(").type;");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_7 = this.expressionList.get(indexExpression);
                _builder.append(_get_7);
                _builder.append(".operator.add(op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_8 = this.expressionList.get(indexExpression);
                _builder.append(_get_8);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_9 = this.expressionList.get(indexExpression);
                _builder.append(_get_9);
                _builder.append(".second = new ArrayList<Evaluation>();");
                _builder.newLineIfNotEmpty();
                _builder.append("exp");
                Integer _get_10 = this.expressionList.get(indexExpression);
                _builder.append(_get_10);
                _builder.append(".second.add(exp");
                Integer _get_11 = this.expressionList.get(indexExpression);
                _builder.append(_get_11);
                _builder.append(".second.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("));");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("Operator op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_12 = this.expressionList.get(indexExpression);
                _builder.append(_get_12);
                _builder.append(" = new Operator();");
                _builder.newLineIfNotEmpty();
                _builder.append("op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_13 = this.expressionList.get(indexExpression);
                _builder.append(_get_13);
                _builder.append(".type = exp");
                Integer _get_14 = this.expressionList.get(indexExpression);
                _builder.append(_get_14);
                _builder.append(".operator.get(");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append(").type;");
                _builder.newLineIfNotEmpty();
                _builder.append("auxExp");
                Integer _get_15 = this.expressionList.get(indexExpression);
                _builder.append(_get_15);
                _builder.append(".operator.add(op");
                _builder.append(((expressionCounter).intValue() - 1));
                _builder.append("_");
                Integer _get_16 = this.expressionList.get(indexExpression);
                _builder.append(_get_16);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("exp");
                Integer _get_17 = this.expressionList.get(indexExpression);
                _builder.append(_get_17);
                _builder.append(".second.add(exp");
                Integer _get_18 = this.expressionList.get(indexExpression);
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

  public Object method(final Expression exp, final int recursionIndexExpression, final boolean resources) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  \t\t");
    _builder.append("//INDEX EXPRESSION: ");
    int _size = this.expressionList.size();
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
            Integer _get = this.expressionList.get(indexExpression);
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
            Integer _get_1 = this.expressionList.get(indexExpression);
            _builder.append(_get_1, "  \t\t");
            _builder.append(".first).name = \"");
            String _name = attev.getName().getName();
            _builder.append(_name, "  \t\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_2 = this.expressionList.get(indexExpression);
            _builder.append(_get_2, "  \t\t");
            _builder.append(".first).operator = \"");
            AttributeEvaluationType _value_1 = attev.getValue();
            Operator _operator = ((ObjectAttributeType) _value_1).getOperator();
            _builder.append(_operator, "  \t\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t\t");
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_3 = this.expressionList.get(indexExpression);
            _builder.append(_get_3, "  \t\t");
            _builder.append(".first).values = new ArrayList<Object>();");
            _builder.newLineIfNotEmpty();
            {
              if (((((ObjectAttributeType) attev.getValue()).getAttribute().getUpperBound() > 1) || (((ObjectAttributeType) attev.getValue()).getAttribute().getUpperBound() == (-1)))) {
                _builder.append("  \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_4 = this.expressionList.get(indexExpression);
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
                Integer _get_5 = this.expressionList.get(indexExpression);
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
            Integer _get_6 = this.expressionList.get(indexExpression);
            _builder.append(_get_6);
            _builder.append(".first = new AttributeEvaluation();");
            _builder.newLineIfNotEmpty();
            _builder.append("//ATTRIBUTE: ");
            Evaluation _first_4 = exp.getFirst();
            final AttributeEvaluation attev_1 = ((AttributeEvaluation) _first_4);
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_7 = this.expressionList.get(indexExpression);
            _builder.append(_get_7);
            _builder.append(".first).name = \"");
            String _name_7 = attev_1.getName().getName();
            _builder.append(_name_7);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_8 = this.expressionList.get(indexExpression);
            _builder.append(_get_8);
            _builder.append(".first).operator = \"");
            AttributeEvaluationType _value_9 = attev_1.getValue();
            Operator _operator_1 = ((AttributeType) _value_9).getOperator();
            _builder.append(_operator_1);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("((AttributeEvaluation) exp");
            Integer _get_9 = this.expressionList.get(indexExpression);
            _builder.append(_get_9);
            _builder.append(".first).values = new ArrayList<Object>();");
            _builder.newLineIfNotEmpty();
            {
              AttributeEvaluationType _value_10 = attev_1.getValue();
              if ((_value_10 instanceof StringType)) {
                _builder.append("   \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_10 = this.expressionList.get(indexExpression);
                _builder.append(_get_10, "   \t\t");
                _builder.append(".first).values.add(\"");
                AttributeEvaluationType _value_11 = attev_1.getValue();
                String _value_12 = ((SpecificStringType) _value_11).getValue();
                _builder.append(_value_12, "   \t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("   \t\t");
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_11 = this.expressionList.get(indexExpression);
                _builder.append(_get_11, "   \t\t");
                _builder.append(".first).type = \"String\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_13 = attev_1.getValue();
              if ((_value_13 instanceof DoubleType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_12 = this.expressionList.get(indexExpression);
                _builder.append(_get_12);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_14 = attev_1.getValue();
                double _value_15 = ((SpecificDoubleType) _value_14).getValue();
                _builder.append(_value_15);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_13 = this.expressionList.get(indexExpression);
                _builder.append(_get_13);
                _builder.append(".first).type = \"double\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_16 = attev_1.getValue();
              if ((_value_16 instanceof BooleanType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_14 = this.expressionList.get(indexExpression);
                _builder.append(_get_14);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_17 = attev_1.getValue();
                boolean _isValue = ((SpecificBooleanType) _value_17).isValue();
                _builder.append(_isValue);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_15 = this.expressionList.get(indexExpression);
                _builder.append(_get_15);
                _builder.append(".first).type = \"Boolean\";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_18 = attev_1.getValue();
              if ((_value_18 instanceof IntegerType)) {
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_16 = this.expressionList.get(indexExpression);
                _builder.append(_get_16);
                _builder.append(".first).values.add(");
                AttributeEvaluationType _value_19 = attev_1.getValue();
                int _value_20 = ((SpecificIntegerType) _value_19).getValue();
                _builder.append(_value_20);
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_17 = this.expressionList.get(indexExpression);
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
                        Integer _get_18 = this.expressionList.get(indexExpression);
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
                        String _compileAuxiliarExpression = this.compileAuxiliarExpression(expressionPosition);
                        _builder.append(_compileAuxiliarExpression);
                        _builder.newLineIfNotEmpty();
                        _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                        Integer _get_19 = this.expressionList.get(indexExpression);
                        _builder.append(_get_19);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_20 = this.expressionList.get(indexExpression);
                        _builder.append(_get_20);
                        _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_24 = attev_1.getValue();
                        String _typeName_1 = MutatorUtils.getTypeName(((MinValueType) _value_24));
                        _builder.append(_typeName_1);
                        _builder.append("\", auxObjects, \"");
                        AttributeEvaluationType _value_25 = attev_1.getValue();
                        String _name_9 = ((MinValueType) _value_25).getAttribute().getName();
                        _builder.append(_name_9);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_21 = this.expressionList.get(indexExpression);
                    _builder.append(_get_21);
                    _builder.append(".first).values.add(min");
                    Integer _get_22 = this.expressionList.get(indexExpression);
                    _builder.append(_get_22);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      if ((expressionPosition == 0)) {
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_23 = this.expressionList.get(indexExpression);
                        _builder.append(_get_23);
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
                        String _compileAuxiliarExpression_1 = this.compileAuxiliarExpression(expressionPosition);
                        _builder.append(_compileAuxiliarExpression_1);
                        _builder.newLineIfNotEmpty();
                        _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                        Integer _get_24 = this.expressionList.get(indexExpression);
                        _builder.append(_get_24);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("MinValueConfigurationStrategy min");
                        Integer _get_25 = this.expressionList.get(indexExpression);
                        _builder.append(_get_25);
                        _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_28 = attev_1.getValue();
                        String _typeName_3 = MutatorUtils.getTypeName(((MinValueType) _value_28));
                        _builder.append(_typeName_3);
                        _builder.append("\", auxObjects, \"");
                        AttributeEvaluationType _value_29 = attev_1.getValue();
                        String _name_11 = ((MinValueType) _value_29).getAttribute().getName();
                        _builder.append(_name_11);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_26 = this.expressionList.get(indexExpression);
                    _builder.append(_get_26);
                    _builder.append(".first).values.add(min");
                    Integer _get_27 = this.expressionList.get(indexExpression);
                    _builder.append(_get_27);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_30 = attev_1.getValue();
                  boolean _equals = ((MinValueType) _value_30).getAttribute().getEType().getName().equals("EInt");
                  if (_equals) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_28 = this.expressionList.get(indexExpression);
                    _builder.append(_get_28);
                    _builder.append(".first).type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_31 = attev_1.getValue();
                  boolean _equals_1 = ((MinValueType) _value_31).getAttribute().getEType().getName().equals("EFloat");
                  if (_equals_1) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_29 = this.expressionList.get(indexExpression);
                    _builder.append(_get_29);
                    _builder.append(".first).type = \"float\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_32 = attev_1.getValue();
                  boolean _equals_2 = ((MinValueType) _value_32).getAttribute().getEType().getName().equals("EDouble");
                  if (_equals_2) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_30 = this.expressionList.get(indexExpression);
                    _builder.append(_get_30);
                    _builder.append(".first).type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
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
                        Integer _get_31 = this.expressionList.get(indexExpression);
                        _builder.append(_get_31);
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
                        String _compileAuxiliarExpression_2 = this.compileAuxiliarExpression(expressionPosition_1);
                        _builder.append(_compileAuxiliarExpression_2);
                        _builder.newLineIfNotEmpty();
                        _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                        Integer _get_32 = this.expressionList.get(indexExpression);
                        _builder.append(_get_32);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_33 = this.expressionList.get(indexExpression);
                        _builder.append(_get_33);
                        _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_36 = attev_1.getValue();
                        String _typeName_5 = MutatorUtils.getTypeName(((MaxValueType) _value_36));
                        _builder.append(_typeName_5);
                        _builder.append("\", auxObjects, \"");
                        AttributeEvaluationType _value_37 = attev_1.getValue();
                        String _name_13 = ((MaxValueType) _value_37).getAttribute().getName();
                        _builder.append(_name_13);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_34 = this.expressionList.get(indexExpression);
                    _builder.append(_get_34);
                    _builder.append(".first).values.add(max");
                    Integer _get_35 = this.expressionList.get(indexExpression);
                    _builder.append(_get_35);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      if ((expressionPosition_1 == 0)) {
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_36 = this.expressionList.get(indexExpression);
                        _builder.append(_get_36);
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
                        String _compileAuxiliarExpression_3 = this.compileAuxiliarExpression(expressionPosition_1);
                        _builder.append(_compileAuxiliarExpression_3);
                        _builder.newLineIfNotEmpty();
                        _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                        Integer _get_37 = this.expressionList.get(indexExpression);
                        _builder.append(_get_37);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("MaxValueConfigurationStrategy max");
                        Integer _get_38 = this.expressionList.get(indexExpression);
                        _builder.append(_get_38);
                        _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                        AttributeEvaluationType _value_40 = attev_1.getValue();
                        String _typeName_7 = MutatorUtils.getTypeName(((MaxValueType) _value_40));
                        _builder.append(_typeName_7);
                        _builder.append("\", auxObjects, \"");
                        AttributeEvaluationType _value_41 = attev_1.getValue();
                        String _name_15 = ((MaxValueType) _value_41).getAttribute().getName();
                        _builder.append(_name_15);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_39 = this.expressionList.get(indexExpression);
                    _builder.append(_get_39);
                    _builder.append(".first).values.add(max");
                    Integer _get_40 = this.expressionList.get(indexExpression);
                    _builder.append(_get_40);
                    _builder.append(".getValue());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_42 = attev_1.getValue();
                  boolean _equals_3 = ((MaxValueType) _value_42).getAttribute().getEType().getName().equals("EInt");
                  if (_equals_3) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_41 = this.expressionList.get(indexExpression);
                    _builder.append(_get_41);
                    _builder.append(".first).type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_43 = attev_1.getValue();
                  boolean _equals_4 = ((MaxValueType) _value_43).getAttribute().getEType().getName().equals("EFloat");
                  if (_equals_4) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_42 = this.expressionList.get(indexExpression);
                    _builder.append(_get_42);
                    _builder.append(".first).type = \"float\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_44 = attev_1.getValue();
                  boolean _equals_5 = ((MaxValueType) _value_44).getAttribute().getEType().getName().equals("EDouble");
                  if (_equals_5) {
                    _builder.append("((AttributeEvaluation) exp");
                    Integer _get_43 = this.expressionList.get(indexExpression);
                    _builder.append(_get_43);
                    _builder.append(".first).type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
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
                    Integer _get_44 = this.expressionList.get(indexExpression);
                    _builder.append(_get_44);
                    _builder.append(".first).values.add(\"");
                    _builder.append(item);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_45 = this.expressionList.get(indexExpression);
                _builder.append(_get_45);
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
                    Integer _get_46 = this.expressionList.get(indexExpression);
                    _builder.append(_get_46);
                    _builder.append(".first).values.add(\"");
                    _builder.append(item_1);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("((AttributeEvaluation) exp");
                Integer _get_47 = this.expressionList.get(indexExpression);
                _builder.append(_get_47);
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
        Integer _get_48 = this.expressionList.get(indexExpression);
        _builder.append(_get_48);
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
            Integer _get_49 = this.expressionList.get(indexExpression);
            _builder.append(_get_49);
            _builder.append(".first).name = \"");
            String _name_17 = refev.getName().getName();
            _builder.append(_name_17);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            {
              if (((refev.getValue() instanceof TypedSelection) && (recursionIndexExpression != 0))) {
                _builder.append("refNames");
                Integer _get_50 = this.expressionList.get(recursionIndexExpression);
                _builder.append(_get_50);
                _builder.append(".add(\"");
                String _name_18 = refev.getName().getName();
                _builder.append(_name_18);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_51 = this.expressionList.get(indexExpression);
            _builder.append(_get_51);
            _builder.append(".first).name = null;");
            _builder.newLineIfNotEmpty();
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_52 = this.expressionList.get(indexExpression);
            _builder.append(_get_52);
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
            Integer _get_53 = this.expressionList.get(indexExpression);
            _builder.append(_get_53);
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
                Integer _get_54 = this.expressionList.get(indexExpression);
                _builder.append(_get_54);
                _builder.append(".first).refRefName = \"");
                String _name_20 = refev.getRefRefName().getName();
                _builder.append(_name_20);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("((ReferenceEvaluation) exp");
                Integer _get_55 = this.expressionList.get(indexExpression);
                _builder.append(_get_55);
                _builder.append(".first).refRefName = null;");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_56 = this.expressionList.get(indexExpression);
            _builder.append(_get_56);
            _builder.append(".first).refName = null;");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EAttribute _attName = refev.getAttName();
          boolean _tripleNotEquals_3 = (_attName != null);
          if (_tripleNotEquals_3) {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_57 = this.expressionList.get(indexExpression);
            _builder.append(_get_57);
            _builder.append(".first).attName = \"");
            String _name_21 = refev.getAttName().getName();
            _builder.append(_name_21);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("((ReferenceEvaluation) exp");
            Integer _get_58 = this.expressionList.get(indexExpression);
            _builder.append(_get_58);
            _builder.append(".first).attName = null;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("((ReferenceEvaluation) exp");
        Integer _get_59 = this.expressionList.get(indexExpression);
        _builder.append(_get_59);
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
                Integer _get_60 = this.expressionList.get(indexExpression);
                _builder.append(_get_60);
                _builder.append(".first).value = null;");
                _builder.newLineIfNotEmpty();
              } else {
                {
                  AttributeEvaluationType _attValue_1 = refev.getAttValue();
                  if ((_attValue_1 instanceof ObjectAttributeType)) {
                    _builder.append("((ReferenceEvaluation) exp");
                    Integer _get_61 = this.expressionList.get(indexExpression);
                    _builder.append(_get_61);
                    _builder.append(".first).value = ModelManager.getStringAttribute(\"");
                    AttributeEvaluationType _attValue_2 = refev.getAttValue();
                    String _name_22 = ((ObjectAttributeType) _attValue_2).getAttribute().getName();
                    _builder.append(_name_22);
                    _builder.append("\", hmObjects.get(\"");
                    AttributeEvaluationType _attValue_3 = refev.getAttValue();
                    String _name_23 = ((ObjectAttributeType) _attValue_3).getObjSel().getName();
                    _builder.append(_name_23);
                    _builder.append("\").getKey());");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _attValue_4 = refev.getAttValue();
                  if ((_attValue_4 instanceof AttributeType)) {
                    {
                      AttributeEvaluationType _attValue_5 = refev.getAttValue();
                      if ((_attValue_5 instanceof StringType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_62 = this.expressionList.get(indexExpression);
                        _builder.append(_get_62, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_6 = refev.getAttValue();
                        String _value_52 = ((SpecificStringType) _attValue_6).getValue();
                        _builder.append(_value_52, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_7 = refev.getAttValue();
                      if ((_attValue_7 instanceof DoubleType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_63 = this.expressionList.get(indexExpression);
                        _builder.append(_get_63, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_8 = refev.getAttValue();
                        double _value_53 = ((SpecificDoubleType) _attValue_8).getValue();
                        _builder.append(_value_53, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_9 = refev.getAttValue();
                      if ((_attValue_9 instanceof BooleanType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_64 = this.expressionList.get(indexExpression);
                        _builder.append(_get_64, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_10 = refev.getAttValue();
                        boolean _isValue_1 = ((SpecificBooleanType) _attValue_10).isValue();
                        _builder.append(_isValue_1, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_11 = refev.getAttValue();
                      if ((_attValue_11 instanceof IntegerType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("((ReferenceEvaluation) exp");
                        Integer _get_65 = this.expressionList.get(indexExpression);
                        _builder.append(_get_65, "   \t\t\t");
                        _builder.append(".first).value = \"");
                        AttributeEvaluationType _attValue_12 = refev.getAttValue();
                        int _value_54 = ((SpecificIntegerType) _attValue_12).getValue();
                        _builder.append(_value_54, "   \t\t\t");
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_13 = refev.getAttValue();
                      if ((_attValue_13 instanceof MinValueType)) {
                        {
                          if ((resources == false)) {
                            {
                              if ((indexExpression == 0)) {
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_66 = this.expressionList.get(indexExpression);
                                _builder.append(_get_66);
                                _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                                AttributeEvaluationType _attValue_14 = refev.getAttValue();
                                String _typeName_8 = MutatorUtils.getTypeName(((MinValueType) _attValue_14));
                                _builder.append(_typeName_8);
                                _builder.append("\", \"");
                                AttributeEvaluationType _attValue_15 = refev.getAttValue();
                                String _name_24 = ((MinValueType) _attValue_15).getAttribute().getName();
                                _builder.append(_name_24);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              } else {
                                String _compileAuxiliarExpression_4 = this.compileAuxiliarExpression(indexExpression);
                                _builder.append(_compileAuxiliarExpression_4);
                                _builder.newLineIfNotEmpty();
                                _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                                Integer _get_67 = this.expressionList.get(indexExpression);
                                _builder.append(_get_67);
                                _builder.append(");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_68 = this.expressionList.get(indexExpression);
                                _builder.append(_get_68);
                                _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                                AttributeEvaluationType _attValue_16 = refev.getAttValue();
                                String _typeName_9 = MutatorUtils.getTypeName(((MinValueType) _attValue_16));
                                _builder.append(_typeName_9);
                                _builder.append("\", auxObjects, \"");
                                AttributeEvaluationType _attValue_17 = refev.getAttValue();
                                String _name_25 = ((MinValueType) _attValue_17).getAttribute().getName();
                                _builder.append(_name_25);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("((ReferenceEvaluation) exp");
                            Integer _get_69 = this.expressionList.get(indexExpression);
                            _builder.append(_get_69, "\t");
                            _builder.append(".first).value = min");
                            Integer _get_70 = this.expressionList.get(indexExpression);
                            _builder.append(_get_70, "\t");
                            _builder.append(".getValue();");
                            _builder.newLineIfNotEmpty();
                          } else {
                            {
                              if ((indexExpression == 0)) {
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_71 = this.expressionList.get(indexExpression);
                                _builder.append(_get_71);
                                _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                                AttributeEvaluationType _attValue_18 = refev.getAttValue();
                                String _typeName_10 = MutatorUtils.getTypeName(((MinValueType) _attValue_18));
                                _builder.append(_typeName_10);
                                _builder.append("\", \"");
                                AttributeEvaluationType _attValue_19 = refev.getAttValue();
                                String _name_26 = ((MinValueType) _attValue_19).getAttribute().getName();
                                _builder.append(_name_26);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              } else {
                                String _compileAuxiliarExpression_5 = this.compileAuxiliarExpression(indexExpression);
                                _builder.append(_compileAuxiliarExpression_5);
                                _builder.newLineIfNotEmpty();
                                _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                                Integer _get_72 = this.expressionList.get(indexExpression);
                                _builder.append(_get_72);
                                _builder.append(");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("MinValueConfigurationStrategy min");
                                Integer _get_73 = this.expressionList.get(indexExpression);
                                _builder.append(_get_73);
                                _builder.append(" = new MinValueConfigurationStrategy(resourcePackages, resources, \"");
                                AttributeEvaluationType _attValue_20 = refev.getAttValue();
                                String _typeName_11 = MutatorUtils.getTypeName(((MinValueType) _attValue_20));
                                _builder.append(_typeName_11);
                                _builder.append("\", auxObjects, \"");
                                AttributeEvaluationType _attValue_21 = refev.getAttValue();
                                String _name_27 = ((MinValueType) _attValue_21).getAttribute().getName();
                                _builder.append(_name_27);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("((ReferenceEvaluation) exp");
                            Integer _get_74 = this.expressionList.get(indexExpression);
                            _builder.append(_get_74, "\t");
                            _builder.append(".first).value = min");
                            Integer _get_75 = this.expressionList.get(indexExpression);
                            _builder.append(_get_75, "\t");
                            _builder.append(".getValue();");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_22 = refev.getAttValue();
                          if ((_attValue_22 instanceof MaxValueType)) {
                            _builder.append("//");
                            int expressionPosition_2 = 0;
                            _builder.newLineIfNotEmpty();
                            {
                              if ((resources == false)) {
                                {
                                  if ((expressionPosition_2 == 0)) {
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_76 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_76);
                                    _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                                    AttributeEvaluationType _attValue_23 = refev.getAttValue();
                                    String _typeName_12 = MutatorUtils.getTypeName(((MaxValueType) _attValue_23));
                                    _builder.append(_typeName_12);
                                    _builder.append("\", \"");
                                    AttributeEvaluationType _attValue_24 = refev.getAttValue();
                                    String _name_28 = ((MaxValueType) _attValue_24).getAttribute().getName();
                                    _builder.append(_name_28);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    String _compileAuxiliarExpression_6 = this.compileAuxiliarExpression(expressionPosition_2);
                                    _builder.append(_compileAuxiliarExpression_6);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                                    Integer _get_77 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_77);
                                    _builder.append(");");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_78 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_78);
                                    _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                                    AttributeEvaluationType _attValue_25 = refev.getAttValue();
                                    String _typeName_13 = MutatorUtils.getTypeName(((MaxValueType) _attValue_25));
                                    _builder.append(_typeName_13);
                                    _builder.append("\", auxObjects, \"");
                                    AttributeEvaluationType _attValue_26 = refev.getAttValue();
                                    String _name_29 = ((MaxValueType) _attValue_26).getAttribute().getName();
                                    _builder.append(_name_29);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("((ReferenceEvaluation) exp");
                                Integer _get_79 = this.expressionList.get(indexExpression);
                                _builder.append(_get_79, "\t");
                                _builder.append(".first).value = max");
                                Integer _get_80 = this.expressionList.get(indexExpression);
                                _builder.append(_get_80, "\t");
                                _builder.append(".getValue();");
                                _builder.newLineIfNotEmpty();
                              } else {
                                {
                                  if ((expressionPosition_2 == 0)) {
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_81 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_81);
                                    _builder.append(" = new MaxValueConfigurationStrategy(resourcePackages, resources, \"");
                                    AttributeEvaluationType _attValue_27 = refev.getAttValue();
                                    String _typeName_14 = MutatorUtils.getTypeName(((MaxValueType) _attValue_27));
                                    _builder.append(_typeName_14);
                                    _builder.append("\", \"");
                                    AttributeEvaluationType _attValue_28 = refev.getAttValue();
                                    String _name_30 = ((MaxValueType) _attValue_28).getAttribute().getName();
                                    _builder.append(_name_30);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    String _compileAuxiliarExpression_7 = this.compileAuxiliarExpression(expressionPosition_2);
                                    _builder.append(_compileAuxiliarExpression_7);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                                    Integer _get_82 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_82);
                                    _builder.append(");");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("MaxValueConfigurationStrategy max");
                                    Integer _get_83 = this.expressionList.get(indexExpression);
                                    _builder.append(_get_83);
                                    _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                                    AttributeEvaluationType _attValue_29 = refev.getAttValue();
                                    String _typeName_15 = MutatorUtils.getTypeName(((MaxValueType) _attValue_29));
                                    _builder.append(_typeName_15);
                                    _builder.append("\", auxObjects, \"");
                                    AttributeEvaluationType _attValue_30 = refev.getAttValue();
                                    String _name_31 = ((MaxValueType) _attValue_30).getAttribute().getName();
                                    _builder.append(_name_31);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("((ReferenceEvaluation) exp");
                                Integer _get_84 = this.expressionList.get(indexExpression);
                                _builder.append(_get_84, "\t");
                                _builder.append(".first).value = max");
                                Integer _get_85 = this.expressionList.get(indexExpression);
                                _builder.append(_get_85, "\t");
                                _builder.append(".getValue();");
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
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  Integer _get_86 = this.expressionList.get(indexExpression);
                  _builder.append(_get_86);
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _value_56 = refev.getValue();
                  String _name_32 = ((SpecificObjectSelection) _value_56).getObjSel().getName();
                  _builder.append(_name_32);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("if (entry_");
                  Integer _get_87 = this.expressionList.get(indexExpression);
                  _builder.append(_get_87);
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t\t");
                  _builder.append("((ReferenceEvaluation) exp");
                  Integer _get_88 = this.expressionList.get(indexExpression);
                  _builder.append(_get_88, "\t\t\t\t");
                  _builder.append(".first).value = new SpecificObjectSelection(entry_");
                  Integer _get_89 = this.expressionList.get(indexExpression);
                  _builder.append(_get_89, "\t\t\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  Integer _get_90 = this.expressionList.get(indexExpression);
                  _builder.append(_get_90, "\t\t\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  Integer _get_91 = this.expressionList.get(indexExpression);
                  _builder.append(_get_91, "\t\t\t\t");
                  _builder.append(".getKey()).getObject();");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  {
                    EReference _refType = refev.getRefType();
                    boolean _tripleNotEquals_4 = (_refType != null);
                    if (_tripleNotEquals_4) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      Integer _get_92 = this.expressionList.get(indexExpression);
                      _builder.append(_get_92);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_57 = refev.getValue();
                      String _name_33 = ((SpecificObjectSelection) _value_57).getObjSel().getName();
                      _builder.append(_name_33);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry_");
                      Integer _get_93 = this.expressionList.get(indexExpression);
                      _builder.append(_get_93);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("EObject srcObjExp = entry_");
                      Integer _get_94 = this.expressionList.get(indexExpression);
                      _builder.append(_get_94, "\t");
                      _builder.append(".getKey();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("for (EReference ref : srcObjExp.eClass().getEAllReferences()) {");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("if (ref.getName().equals(\"");
                      String _name_34 = refev.getRefType().getName();
                      _builder.append(_name_34, "\t\t");
                      _builder.append("\")) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_95 = this.expressionList.get(indexExpression);
                      _builder.append(_get_95, "\t\t");
                      _builder.append(".first).value = srcObjExp.eGet(ref);\t\t");
                      _builder.newLineIfNotEmpty();
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
                  {
                    EReference _refType_1 = refev.getValue().getRefType();
                    boolean _tripleNotEquals_5 = (_refType_1 != null);
                    if (_tripleNotEquals_5) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                      Integer _get_96 = this.expressionList.get(indexExpression);
                      _builder.append(_get_96);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_58 = refev.getValue();
                      String _name_35 = ((SpecificObjectSelection) _value_58).getObjSel().getName();
                      _builder.append(_name_35);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry_");
                      Integer _get_97 = this.expressionList.get(indexExpression);
                      _builder.append(_get_97);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t   \t\t");
                      _builder.append("EObject srcObjExp = entry_");
                      Integer _get_98 = this.expressionList.get(indexExpression);
                      _builder.append(_get_98, "\t\t   \t\t");
                      _builder.append(".getKey();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t   \t\t");
                      _builder.append("for (EReference ref : srcObjExp.eClass().getEAllReferences()) {");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("if (ref.getName().equals(\"");
                      String _name_36 = refev.getValue().getRefType().getName();
                      _builder.append(_name_36, "\t\t");
                      _builder.append("\")) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_99 = this.expressionList.get(indexExpression);
                      _builder.append(_get_99, "\t\t\t");
                      _builder.append(".first).value = srcObjExp.eGet(ref);\t\t");
                      _builder.newLineIfNotEmpty();
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
              }
            } else {
              {
                ObSelectionStrategy _value_59 = refev.getValue();
                if ((_value_59 instanceof RandomTypeSelection)) {
                  {
                    Expression _expression = refev.getValue().getExpression();
                    if ((_expression instanceof Expression)) {
                      _builder.append("//EXPRESSION LEVEL: ");
                      int _get_100 = this.nExpression[0];
                      int _plus = (_get_100 + 1);
                      int _set = this.nExpression[0] = _plus;
                      _builder.append(_set);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//EXPRESSION LEVEL: ");
                      boolean _add = this.expressionList.add(Integer.valueOf(this.nExpression[0]));
                      _builder.append(_add);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//INDEX EXPRESSION: ");
                      int _size_1 = this.expressionList.size();
                      final int nestedIndexExpression = (_size_1 - 1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("RandomTypeSelection expRts");
                      Integer _get_101 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_101);
                      _builder.append(" = new RandomTypeSelection(packages, model, \"");
                      ObSelectionStrategy _value_60 = refev.getValue();
                      String _name_37 = ((RandomTypeSelection) _value_60).getType().getName();
                      _builder.append(_name_37);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("List<EObject> expObjects");
                      Integer _get_102 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_102);
                      _builder.append(" = expRts");
                      Integer _get_103 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_103);
                      _builder.append(".getObjects();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("Expression exp");
                      Integer _get_104 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_104);
                      _builder.append(" = new Expression();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t   \t\t");
                      Object _method = this.method(refev.getValue().getExpression(), nestedIndexExpression, resources);
                      _builder.append(_method, "\t   \t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("List<EObject> selectedObjects");
                      Integer _get_105 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_105);
                      _builder.append(" = evaluate(expObjects");
                      Integer _get_106 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_106);
                      _builder.append(", exp");
                      Integer _get_107 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_107);
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("EObject object");
                      Integer _get_108 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_108);
                      _builder.append(" = null;");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (selectedObjects");
                      Integer _get_109 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_109);
                      _builder.append(".size() > 0) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("object");
                      Integer _get_110 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_110, "\t");
                      _builder.append(" = selectedObjects");
                      Integer _get_111 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_111, "\t");
                      _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                      Integer _get_112 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_112, "\t");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_113 = this.expressionList.get(indexExpression);
                      _builder.append(_get_113);
                      _builder.append(".first).value = new SpecificObjectSelection(packages, model, object");
                      Integer _get_114 = this.expressionList.get(nestedIndexExpression);
                      _builder.append(_get_114);
                      _builder.append(").getObject();");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("((ReferenceEvaluation) exp");
                      Integer _get_115 = this.expressionList.get(indexExpression);
                      _builder.append(_get_115);
                      _builder.append(".first).value = new RandomTypeSelection(packages, model, \"");
                      ObSelectionStrategy _value_61 = refev.getValue();
                      String _name_38 = ((RandomTypeSelection) _value_61).getType().getName();
                      _builder.append(_name_38);
                      _builder.append("\").getObject();");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  {
                    ObSelectionStrategy _value_62 = refev.getValue();
                    if ((_value_62 instanceof TypedSelection)) {
                      {
                        Expression _expression_1 = refev.getValue().getExpression();
                        if ((_expression_1 instanceof Expression)) {
                          _builder.append("//EXPRESSION LEVEL: ");
                          int _get_116 = this.nExpression[0];
                          int _plus_1 = (_get_116 + 1);
                          int _set_1 = this.nExpression[0] = _plus_1;
                          _builder.append(_set_1);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//EXPRESSION LEVEL: ");
                          boolean _add_1 = this.expressionList.add(Integer.valueOf(this.nExpression[0]));
                          _builder.append(_add_1);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          int _size_2 = this.expressionList.size();
                          final int nestedIndexExpression_1 = (_size_2 - 1);
                          _builder.newLineIfNotEmpty();
                          _builder.append("TypedSelection expRts");
                          Integer _get_117 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_117);
                          _builder.append(" = new TypedSelection(packages, model, \"");
                          ObSelectionStrategy _value_63 = refev.getValue();
                          String _name_39 = ((TypedSelection) _value_63).getType().getName();
                          _builder.append(_name_39);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> expObjects");
                          Integer _get_118 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_118);
                          _builder.append(" = expRts");
                          Integer _get_119 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_119);
                          _builder.append(".getObjects();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Expression exp");
                          Integer _get_120 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_120);
                          _builder.append(" = new Expression();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<String> refNames");
                          Integer _get_121 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_121);
                          _builder.append(" = new ArrayList<String>();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t");
                          Object _method_1 = this.method(refev.getValue().getExpression(), nestedIndexExpression_1, resources);
                          _builder.append(_method_1, "\t   \t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> selectedObjects");
                          Integer _get_122 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_122);
                          _builder.append(" = evaluate(expObjects");
                          Integer _get_123 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_123);
                          _builder.append(", exp");
                          Integer _get_124 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_124);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("refNames");
                          Integer _get_125 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_125);
                          _builder.append(".add(\"");
                          String _name_40 = refev.getName().getName();
                          _builder.append(_name_40);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Collections.reverse(refNames");
                          Integer _get_126 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_126);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("selectedObjects");
                          Integer _get_127 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_127);
                          _builder.append(" = ModelManager.getReferredObjects(refNames");
                          Integer _get_128 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_128);
                          _builder.append(", objects, selectedObjects1);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject object");
                          Integer _get_129 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_129);
                          _builder.append(" = null;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (selectedObjects");
                          Integer _get_130 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_130);
                          _builder.append(".size() > 0) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("object");
                          Integer _get_131 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_131, "\t");
                          _builder.append(" = selectedObjects");
                          Integer _get_132 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_132, "\t");
                          _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                          Integer _get_133 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_133, "\t");
                          _builder.append("));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_134 = this.expressionList.get(indexExpression);
                          _builder.append(_get_134);
                          _builder.append(".first).value = new SpecificObjectSelection(packages, model, object");
                          Integer _get_135 = this.expressionList.get(nestedIndexExpression_1);
                          _builder.append(_get_135);
                          _builder.append(").getObject();");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("((ReferenceEvaluation) exp");
                          Integer _get_136 = this.expressionList.get(indexExpression);
                          _builder.append(_get_136);
                          _builder.append(".first).value = new TypedSelection(packages, model, \"");
                          ObSelectionStrategy _value_64 = refev.getValue();
                          String _name_41 = ((TypedSelection) _value_64).getType().getName();
                          _builder.append(_name_41);
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
    Integer _get_137 = this.expressionList.get(indexExpression);
    _builder.append(_get_137);
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
        Integer _get_138 = this.expressionList.get(indexExpression);
        _builder.append(_get_138);
        _builder.append(" = new Operator();");
        _builder.newLineIfNotEmpty();
        _builder.append("op");
        _builder.append(opName);
        _builder.append("_");
        Integer _get_139 = this.expressionList.get(indexExpression);
        _builder.append(_get_139);
        _builder.append(".type = \"");
        LogicOperator _type = op.getType();
        _builder.append(_type);
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("exp");
        Integer _get_140 = this.expressionList.get(indexExpression);
        _builder.append(_get_140);
        _builder.append(".operator.add(op");
        _builder.append(opName);
        _builder.append("_");
        Integer _get_141 = this.expressionList.get(indexExpression);
        _builder.append(_get_141);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("//OPNAME + 1: ");
        _builder.append(opName = (opName + 1));
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("exp");
    Integer _get_142 = this.expressionList.get(indexExpression);
    _builder.append(_get_142);
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
              AttributeEvaluationType _value_65 = ((AttributeEvaluation) ev).getValue();
              if ((_value_65 instanceof ObjectAttributeType)) {
                _builder.append("AttributeEvaluation ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_143 = this.expressionList.get(indexExpression);
                _builder.append(_get_143);
                _builder.append(" = new AttributeEvaluation();");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_144 = this.expressionList.get(indexExpression);
                _builder.append(_get_144);
                _builder.append(".name = \"");
                String _name_42 = ((AttributeEvaluation)ev).getName().getName();
                _builder.append(_name_42);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_145 = this.expressionList.get(indexExpression);
                _builder.append(_get_145);
                _builder.append(".operator = \"");
                AttributeEvaluationType _value_66 = ((AttributeEvaluation)ev).getValue();
                Operator _operator_4 = ((ObjectAttributeType) _value_66).getOperator();
                _builder.append(_operator_4);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_146 = this.expressionList.get(indexExpression);
                _builder.append(_get_146);
                _builder.append(".values = new ArrayList<Object>();");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              AttributeEvaluationType _value_67 = ((AttributeEvaluation) ev).getValue();
              if ((_value_67 instanceof AttributeType)) {
                _builder.append("AttributeEvaluation ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_147 = this.expressionList.get(indexExpression);
                _builder.append(_get_147);
                _builder.append(" = new AttributeEvaluation();");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_148 = this.expressionList.get(indexExpression);
                _builder.append(_get_148);
                _builder.append(".name = \"");
                String _name_43 = ((AttributeEvaluation)ev).getName().getName();
                _builder.append(_name_43);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_149 = this.expressionList.get(indexExpression);
                _builder.append(_get_149);
                _builder.append(".operator = \"");
                AttributeEvaluationType _value_68 = ((AttributeEvaluation)ev).getValue();
                Operator _operator_5 = ((AttributeType) _value_68).getOperator();
                _builder.append(_operator_5);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_150 = this.expressionList.get(indexExpression);
                _builder.append(_get_150);
                _builder.append(".values = new ArrayList<Object>();");
                _builder.newLineIfNotEmpty();
                {
                  AttributeEvaluationType _value_69 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_69 instanceof StringType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_151 = this.expressionList.get(indexExpression);
                    _builder.append(_get_151);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_70 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_6 = ((SpecificStringType) _value_70).getOperator();
                    _builder.append(_operator_6);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_152 = this.expressionList.get(indexExpression);
                    _builder.append(_get_152);
                    _builder.append(".values.add(\"");
                    AttributeEvaluationType _value_71 = ((AttributeEvaluation)ev).getValue();
                    String _value_72 = ((SpecificStringType) _value_71).getValue();
                    _builder.append(_value_72);
                    _builder.append("\");;");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_153 = this.expressionList.get(indexExpression);
                    _builder.append(_get_153);
                    _builder.append(".type = \"String\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_73 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_73 instanceof DoubleType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_154 = this.expressionList.get(indexExpression);
                    _builder.append(_get_154);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_74 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_7 = ((SpecificDoubleType) _value_74).getOperator();
                    _builder.append(_operator_7);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_155 = this.expressionList.get(indexExpression);
                    _builder.append(_get_155);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_75 = ((AttributeEvaluation)ev).getValue();
                    double _value_76 = ((SpecificDoubleType) _value_75).getValue();
                    _builder.append(_value_76);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_156 = this.expressionList.get(indexExpression);
                    _builder.append(_get_156);
                    _builder.append(".type = \"double\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_77 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_77 instanceof BooleanType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_157 = this.expressionList.get(indexExpression);
                    _builder.append(_get_157);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_78 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_8 = ((SpecificBooleanType) _value_78).getOperator();
                    _builder.append(_operator_8);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_158 = this.expressionList.get(indexExpression);
                    _builder.append(_get_158);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_79 = ((AttributeEvaluation)ev).getValue();
                    boolean _isValue_2 = ((SpecificBooleanType) _value_79).isValue();
                    _builder.append(_isValue_2);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_159 = this.expressionList.get(indexExpression);
                    _builder.append(_get_159);
                    _builder.append(".type = \"Boolean\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_80 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_80 instanceof IntegerType)) {
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_160 = this.expressionList.get(indexExpression);
                    _builder.append(_get_160);
                    _builder.append(".operator = \"");
                    AttributeEvaluationType _value_81 = ((AttributeEvaluation)ev).getValue();
                    Operator _operator_9 = ((SpecificIntegerType) _value_81).getOperator();
                    _builder.append(_operator_9);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_161 = this.expressionList.get(indexExpression);
                    _builder.append(_get_161);
                    _builder.append(".values.add(");
                    AttributeEvaluationType _value_82 = ((AttributeEvaluation)ev).getValue();
                    int _value_83 = ((SpecificIntegerType) _value_82).getValue();
                    _builder.append(_value_83);
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("ev");
                    _builder.append(evName);
                    _builder.append("_");
                    Integer _get_162 = this.expressionList.get(indexExpression);
                    _builder.append(_get_162);
                    _builder.append(".type = \"int\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  AttributeEvaluationType _value_84 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_84 instanceof MinValueType)) {
                    {
                      if ((resources == false)) {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_163 = this.expressionList.get(indexExpression);
                            _builder.append(_get_163);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_85 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_16 = MutatorUtils.getTypeName(((MinValueType) _value_85));
                            _builder.append(_typeName_16);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_86 = ((AttributeEvaluation)ev).getValue();
                            String _name_44 = ((MinValueType) _value_86).getAttribute().getName();
                            _builder.append(_name_44);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_8 = this.compileAuxiliarExpression(expressionPosition_3);
                            _builder.append(_compileAuxiliarExpression_8);
                            _builder.newLineIfNotEmpty();
                            _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                            Integer _get_164 = this.expressionList.get(indexExpression);
                            _builder.append(_get_164);
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_165 = this.expressionList.get(indexExpression);
                            _builder.append(_get_165);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_87 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_17 = MutatorUtils.getTypeName(((MinValueType) _value_87));
                            _builder.append(_typeName_17);
                            _builder.append("\", auxObjects, \"");
                            AttributeEvaluationType _value_88 = ((AttributeEvaluation)ev).getValue();
                            String _name_45 = ((MinValueType) _value_88).getAttribute().getName();
                            _builder.append(_name_45);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_166 = this.expressionList.get(indexExpression);
                        _builder.append(_get_166);
                        _builder.append(").values.add(min");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_167 = this.expressionList.get(indexExpression);
                        _builder.append(_get_167);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_168 = this.expressionList.get(indexExpression);
                            _builder.append(_get_168);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_89 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_18 = MutatorUtils.getTypeName(((MinValueType) _value_89));
                            _builder.append(_typeName_18);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_90 = ((AttributeEvaluation)ev).getValue();
                            String _name_46 = ((MinValueType) _value_90).getAttribute().getName();
                            _builder.append(_name_46);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_9 = this.compileAuxiliarExpression(expressionPosition_3);
                            _builder.append(_compileAuxiliarExpression_9);
                            _builder.newLineIfNotEmpty();
                            _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                            Integer _get_169 = this.expressionList.get(indexExpression);
                            _builder.append(_get_169);
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("MinValueConfigurationStrategy min");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_170 = this.expressionList.get(indexExpression);
                            _builder.append(_get_170);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_91 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_19 = MutatorUtils.getTypeName(((MinValueType) _value_91));
                            _builder.append(_typeName_19);
                            _builder.append("\", auxObjects, \"");
                            AttributeEvaluationType _value_92 = ((AttributeEvaluation)ev).getValue();
                            String _name_47 = ((MinValueType) _value_92).getAttribute().getName();
                            _builder.append(_name_47);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_171 = this.expressionList.get(indexExpression);
                        _builder.append(_get_171);
                        _builder.append(").values.add(min");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_172 = this.expressionList.get(indexExpression);
                        _builder.append(_get_172);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_93 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_6 = ((MinValueType) _value_93).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_6) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_173 = this.expressionList.get(indexExpression);
                        _builder.append(_get_173);
                        _builder.append(").type = \"int\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_94 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_7 = ((MinValueType) _value_94).getAttribute().getEType().getName().equals("EFloat");
                      if (_equals_7) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_174 = this.expressionList.get(indexExpression);
                        _builder.append(_get_174);
                        _builder.append(").type = \"float\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_95 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_8 = ((MinValueType) _value_95).getAttribute().getEType().getName().equals("EDouble");
                      if (_equals_8) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_175 = this.expressionList.get(indexExpression);
                        _builder.append(_get_175);
                        _builder.append(").type = \"double\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  AttributeEvaluationType _value_96 = ((AttributeEvaluation)ev).getValue();
                  if ((_value_96 instanceof MaxValueType)) {
                    {
                      if ((resources == false)) {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_176 = this.expressionList.get(indexExpression);
                            _builder.append(_get_176);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_97 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_20 = MutatorUtils.getTypeName(((MaxValueType) _value_97));
                            _builder.append(_typeName_20);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_98 = ((AttributeEvaluation)ev).getValue();
                            String _name_48 = ((MaxValueType) _value_98).getAttribute().getName();
                            _builder.append(_name_48);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_10 = this.compileAuxiliarExpression(expressionPosition_3);
                            _builder.append(_compileAuxiliarExpression_10);
                            _builder.newLineIfNotEmpty();
                            _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                            Integer _get_177 = this.expressionList.get(indexExpression);
                            _builder.append(_get_177);
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_178 = this.expressionList.get(indexExpression);
                            _builder.append(_get_178);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _value_99 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_21 = MutatorUtils.getTypeName(((MaxValueType) _value_99));
                            _builder.append(_typeName_21);
                            _builder.append("\", auxObjects, \"");
                            AttributeEvaluationType _value_100 = ((AttributeEvaluation)ev).getValue();
                            String _name_49 = ((MaxValueType) _value_100).getAttribute().getName();
                            _builder.append(_name_49);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_179 = this.expressionList.get(indexExpression);
                        _builder.append(_get_179);
                        _builder.append(").values.add(max");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_180 = this.expressionList.get(indexExpression);
                        _builder.append(_get_180);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((expressionPosition_3 == 0)) {
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_181 = this.expressionList.get(indexExpression);
                            _builder.append(_get_181);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_101 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_22 = MutatorUtils.getTypeName(((MaxValueType) _value_101));
                            _builder.append(_typeName_22);
                            _builder.append("\", \"");
                            AttributeEvaluationType _value_102 = ((AttributeEvaluation)ev).getValue();
                            String _name_50 = ((MaxValueType) _value_102).getAttribute().getName();
                            _builder.append(_name_50);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            String _compileAuxiliarExpression_11 = this.compileAuxiliarExpression(expressionPosition_3);
                            _builder.append(_compileAuxiliarExpression_11);
                            _builder.newLineIfNotEmpty();
                            _builder.append("List<EObject> auxObjects = evaluate(objects, auxExp");
                            Integer _get_182 = this.expressionList.get(indexExpression);
                            _builder.append(_get_182);
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("MaxValueConfigurationStrategy max");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_183 = this.expressionList.get(indexExpression);
                            _builder.append(_get_183);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, resources, \"");
                            AttributeEvaluationType _value_103 = ((AttributeEvaluation)ev).getValue();
                            String _typeName_23 = MutatorUtils.getTypeName(((MaxValueType) _value_103));
                            _builder.append(_typeName_23);
                            _builder.append("\", auxObjects, \"");
                            AttributeEvaluationType _value_104 = ((AttributeEvaluation)ev).getValue();
                            String _name_51 = ((MaxValueType) _value_104).getAttribute().getName();
                            _builder.append(_name_51);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_184 = this.expressionList.get(indexExpression);
                        _builder.append(_get_184);
                        _builder.append(").values.add(max");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_185 = this.expressionList.get(indexExpression);
                        _builder.append(_get_185);
                        _builder.append(".getValue());");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_105 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_9 = ((MaxValueType) _value_105).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_9) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_186 = this.expressionList.get(indexExpression);
                        _builder.append(_get_186);
                        _builder.append(").type = \"int\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_106 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_10 = ((MaxValueType) _value_106).getAttribute().getEType().getName().equals("EInt");
                      if (_equals_10) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_187 = this.expressionList.get(indexExpression);
                        _builder.append(_get_187);
                        _builder.append(").type = \"float\";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _value_107 = ((AttributeEvaluation)ev).getValue();
                      boolean _equals_11 = ((MaxValueType) _value_107).getAttribute().getEType().getName().equals("EDouble");
                      if (_equals_11) {
                        _builder.append("((AttributeEvaluation) ev");
                        _builder.append(evName);
                        _builder.append("_");
                        Integer _get_188 = this.expressionList.get(indexExpression);
                        _builder.append(_get_188);
                        _builder.append(").type = \"double\";");
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
            Integer _get_189 = this.expressionList.get(indexExpression);
            _builder.append(_get_189, "   \t\t\t");
            _builder.append(" = new ReferenceEvaluation();");
            _builder.newLineIfNotEmpty();
            {
              EReference _name_52 = ((ReferenceEvaluation)ev).getName();
              boolean _tripleNotEquals_6 = (_name_52 != null);
              if (_tripleNotEquals_6) {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_190 = this.expressionList.get(indexExpression);
                _builder.append(_get_190);
                _builder.append(".name = \"");
                String _name_53 = ((ReferenceEvaluation)ev).getName().getName();
                _builder.append(_name_53);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                {
                  if (((((ReferenceEvaluation)ev).getValue() instanceof TypedSelection) && (recursionIndexExpression != 0))) {
                    _builder.append("\t\t\t\t");
                    _builder.append("refNames");
                    Integer _get_191 = this.expressionList.get(recursionIndexExpression);
                    _builder.append(_get_191, "\t\t\t\t");
                    _builder.append(".add(\"");
                    String _name_54 = ((ReferenceEvaluation)ev).getName().getName();
                    _builder.append(_name_54, "\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_192 = this.expressionList.get(indexExpression);
                _builder.append(_get_192, "\t   \t\t");
                _builder.append(".name = null;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_193 = this.expressionList.get(indexExpression);
                _builder.append(_get_193, "\t   \t\t");
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
                Integer _get_194 = this.expressionList.get(indexExpression);
                _builder.append(_get_194);
                _builder.append(".refName = \"");
                String _name_55 = ((ReferenceEvaluation)ev).getRefName().getName();
                _builder.append(_name_55);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t   \t\t");
                _builder.append("ev");
                _builder.append(evName, "\t   \t\t");
                _builder.append("_");
                Integer _get_195 = this.expressionList.get(indexExpression);
                _builder.append(_get_195, "\t   \t\t");
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
                Integer _get_196 = this.expressionList.get(indexExpression);
                _builder.append(_get_196);
                _builder.append(".attName = \"");
                String _name_56 = ((ReferenceEvaluation)ev).getAttName().getName();
                _builder.append(_name_56);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("ev");
                _builder.append(evName);
                _builder.append("_");
                Integer _get_197 = this.expressionList.get(indexExpression);
                _builder.append(_get_197);
                _builder.append(".attName = null;");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t   \t");
            _builder.append("ev");
            _builder.append(evName, "\t\t   \t");
            _builder.append("_");
            Integer _get_198 = this.expressionList.get(indexExpression);
            _builder.append(_get_198, "\t\t   \t");
            _builder.append(".operator = \"");
            Operator _operator_10 = ((ReferenceEvaluation)ev).getOperator();
            _builder.append(_operator_10, "\t\t   \t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            {
              ObSelectionStrategy _value_108 = ((ReferenceEvaluation)ev).getValue();
              boolean _tripleEquals_2 = (_value_108 == null);
              if (_tripleEquals_2) {
                {
                  AttributeEvaluationType _attValue_31 = ((ReferenceEvaluation)ev).getAttValue();
                  boolean _tripleEquals_3 = (_attValue_31 == null);
                  if (_tripleEquals_3) {
                    _builder.append("   \t\t\t");
                    _builder.append("ev");
                    _builder.append(evName, "   \t\t\t");
                    _builder.append("_");
                    Integer _get_199 = this.expressionList.get(indexExpression);
                    _builder.append(_get_199, "   \t\t\t");
                    _builder.append(".value = null;");
                    _builder.newLineIfNotEmpty();
                  } else {
                    {
                      AttributeEvaluationType _attValue_32 = ((ReferenceEvaluation)ev).getAttValue();
                      if ((_attValue_32 instanceof ObjectAttributeType)) {
                        _builder.append("   \t\t\t");
                        _builder.append("ev");
                        _builder.append(evName, "   \t\t\t");
                        _builder.append("_");
                        Integer _get_200 = this.expressionList.get(indexExpression);
                        _builder.append(_get_200, "   \t\t\t");
                        _builder.append(".value = ModelManager.getStringAttribute(\"");
                        AttributeEvaluationType _attValue_33 = ((ReferenceEvaluation)ev).getAttValue();
                        String _name_57 = ((ObjectAttributeType) _attValue_33).getAttribute().getName();
                        _builder.append(_name_57, "   \t\t\t");
                        _builder.append("\", hmObjects.get(\"");
                        AttributeEvaluationType _attValue_34 = ((ReferenceEvaluation)ev).getAttValue();
                        String _name_58 = ((ObjectAttributeType) _attValue_34).getObjSel().getName();
                        _builder.append(_name_58, "   \t\t\t");
                        _builder.append("\").getKey());");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      AttributeEvaluationType _attValue_35 = ((ReferenceEvaluation)ev).getAttValue();
                      if ((_attValue_35 instanceof AttributeType)) {
                        {
                          if (((((((ReferenceEvaluation)ev).getAttValue() instanceof StringType) || (((ReferenceEvaluation)ev).getAttValue() instanceof DoubleType)) || (((ReferenceEvaluation)ev).getAttValue() instanceof BooleanType)) || (((ReferenceEvaluation)ev).getAttValue() instanceof IntegerType))) {
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_201 = this.expressionList.get(indexExpression);
                            _builder.append(_get_201);
                            _builder.append(".value = \"");
                            AttributeEvaluationType _attValue_36 = ((ReferenceEvaluation)ev).getAttValue();
                            String _value_109 = ((SpecificStringType) _attValue_36).getValue();
                            _builder.append(_value_109);
                            _builder.append("\";");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_37 = ((ReferenceEvaluation)ev).getAttValue();
                          if ((_attValue_37 instanceof MinValueType)) {
                            _builder.append("MinValueConfigurationStrategy min_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_202 = this.expressionList.get(indexExpression);
                            _builder.append(_get_202);
                            _builder.append(" = new MinValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _attValue_38 = ((ReferenceEvaluation)ev).getAttValue();
                            String _typeName_24 = MutatorUtils.getTypeName(((MinValueType) _attValue_38));
                            _builder.append(_typeName_24);
                            _builder.append("\", \"");
                            AttributeEvaluationType _attValue_39 = ((ReferenceEvaluation)ev).getAttValue();
                            String _name_59 = ((MinValueType) _attValue_39).getAttribute().getName();
                            _builder.append(_name_59);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_203 = this.expressionList.get(indexExpression);
                            _builder.append(_get_203);
                            _builder.append(".value = min_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_204 = this.expressionList.get(indexExpression);
                            _builder.append(_get_204);
                            _builder.append(".getValue().toString();");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          AttributeEvaluationType _attValue_40 = ((ReferenceEvaluation)ev).getAttValue();
                          if ((_attValue_40 instanceof MinValueType)) {
                            _builder.append("MaxValueConfigurationStrategy max_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_205 = this.expressionList.get(indexExpression);
                            _builder.append(_get_205);
                            _builder.append(" = new MaxValueConfigurationStrategy(packages, model, \"");
                            AttributeEvaluationType _attValue_41 = ((ReferenceEvaluation)ev).getAttValue();
                            String _typeName_25 = MutatorUtils.getTypeName(((MaxValueType) _attValue_41));
                            _builder.append(_typeName_25);
                            _builder.append("\", \"");
                            AttributeEvaluationType _attValue_42 = ((ReferenceEvaluation)ev).getAttValue();
                            String _name_60 = ((MaxValueType) _attValue_42).getAttribute().getName();
                            _builder.append(_name_60);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_206 = this.expressionList.get(indexExpression);
                            _builder.append(_get_206);
                            _builder.append(".value = max_ev");
                            _builder.append(evName);
                            _builder.append("_");
                            Integer _get_207 = this.expressionList.get(indexExpression);
                            _builder.append(_get_207);
                            _builder.append(".getValue().toString();");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              } else {
                ObSelectionStrategy _value_110 = ((ReferenceEvaluation)ev).getValue();
                if ((_value_110 instanceof SpecificObjectSelection)) {
                  {
                    if (((((ReferenceEvaluation)ev).getRefType() == null) && (((ReferenceEvaluation)ev).getValue().getRefType() == null))) {
                      _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry");
                      _builder.append(evName);
                      _builder.append("_");
                      Integer _get_208 = this.expressionList.get(indexExpression);
                      _builder.append(_get_208);
                      _builder.append(" = hmObjects.get(\"");
                      ObSelectionStrategy _value_111 = ((ReferenceEvaluation)ev).getValue();
                      String _name_61 = ((SpecificObjectSelection) _value_111).getObjSel().getName();
                      _builder.append(_name_61);
                      _builder.append("\");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("if (entry");
                      _builder.append(evName);
                      _builder.append("_");
                      Integer _get_209 = this.expressionList.get(indexExpression);
                      _builder.append(_get_209);
                      _builder.append(" != null) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("   \t\t\t\t\t\t");
                      _builder.append("ev");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_210 = this.expressionList.get(indexExpression);
                      _builder.append(_get_210, "   \t\t\t\t\t\t");
                      _builder.append(".value = new SpecificObjectSelection(entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_211 = this.expressionList.get(indexExpression);
                      _builder.append(_get_211, "   \t\t\t\t\t\t");
                      _builder.append(".getValue().getValue(), entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_212 = this.expressionList.get(indexExpression);
                      _builder.append(_get_212, "   \t\t\t\t\t\t");
                      _builder.append(".getValue().getKey(), entry");
                      _builder.append(evName, "   \t\t\t\t\t\t");
                      _builder.append("_");
                      Integer _get_213 = this.expressionList.get(indexExpression);
                      _builder.append(_get_213, "   \t\t\t\t\t\t");
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
                          Integer _get_214 = this.expressionList.get(indexExpression);
                          _builder.append(_get_214);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_112 = ((ReferenceEvaluation)ev).getValue();
                          String _name_62 = ((SpecificObjectSelection) _value_112).getObjSel().getName();
                          _builder.append(_name_62);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_215 = this.expressionList.get(indexExpression);
                          _builder.append(_get_215);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t\t\t\t");
                          _builder.append("EObject srcObjExp");
                          _builder.append(evName, "\t   \t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_216 = this.expressionList.get(indexExpression);
                          _builder.append(_get_216, "\t   \t\t\t\t\t");
                          _builder.append(" = entry");
                          _builder.append(evName, "\t   \t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_217 = this.expressionList.get(indexExpression);
                          _builder.append(_get_217, "\t   \t\t\t\t\t");
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t\t\t");
                          _builder.append("for (EReference ref : srcObjExp");
                          _builder.append(evName, "   \t\t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_218 = this.expressionList.get(indexExpression);
                          _builder.append(_get_218, "   \t\t\t\t\t\t");
                          _builder.append(".eClass().getEAllReferences()) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t\t\t\t");
                          _builder.append("if (ref.getName().equals(\"");
                          String _name_63 = ((ReferenceEvaluation)ev).getRefType().getName();
                          _builder.append(_name_63, "   \t\t\t\t\t\t\t");
                          _builder.append("\")) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t\t\t\t\t");
                          _builder.append("ev");
                          _builder.append(evName, "   \t\t\t\t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_219 = this.expressionList.get(indexExpression);
                          _builder.append(_get_219, "   \t\t\t\t\t\t\t\t");
                          _builder.append(".value = srcObjExp");
                          _builder.append(evName, "   \t\t\t\t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_220 = this.expressionList.get(indexExpression);
                          _builder.append(_get_220, "   \t\t\t\t\t\t\t\t");
                          _builder.append(".eGet(ref);\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("   \t\t\t\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t   \t\t\t\t\t");
                          _builder.append("}");
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
                          Integer _get_221 = this.expressionList.get(indexExpression);
                          _builder.append(_get_221);
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _value_113 = ((ReferenceEvaluation)ev).getValue();
                          String _name_64 = ((SpecificObjectSelection) _value_113).getObjSel().getName();
                          _builder.append(_name_64);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (entry");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_222 = this.expressionList.get(indexExpression);
                          _builder.append(_get_222);
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t\t\t");
                          _builder.append("EObject srcObjExp");
                          _builder.append(evName, "\t\t   \t\t\t\t");
                          _builder.append("_");
                          Integer _get_223 = this.expressionList.get(indexExpression);
                          _builder.append(_get_223, "\t\t   \t\t\t\t");
                          _builder.append(" = entry");
                          _builder.append(evName, "\t\t   \t\t\t\t");
                          _builder.append("_");
                          Integer _get_224 = this.expressionList.get(indexExpression);
                          _builder.append(_get_224, "\t\t   \t\t\t\t");
                          _builder.append(".getKey();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t   \t\t\t\t");
                          _builder.append("for (EReference ref : srcObjExp");
                          _builder.append(evName, "\t\t   \t\t\t\t");
                          _builder.append("_");
                          Integer _get_225 = this.expressionList.get(indexExpression);
                          _builder.append(_get_225, "\t\t   \t\t\t\t");
                          _builder.append(".eClass().getEAllReferences()) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t\t\t\t\t");
                          _builder.append("if (ref.getName().equals(\"");
                          String _name_65 = ((ReferenceEvaluation)ev).getValue().getRefType().getName();
                          _builder.append(_name_65, "\t   \t\t\t\t\t\t");
                          _builder.append("\")) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t\t\t\t\t\t");
                          _builder.append("ev");
                          _builder.append(evName, "\t   \t\t\t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_226 = this.expressionList.get(indexExpression);
                          _builder.append(_get_226, "\t   \t\t\t\t\t\t\t");
                          _builder.append(".value = srcObjExp");
                          _builder.append(evName, "\t   \t\t\t\t\t\t\t");
                          _builder.append("_");
                          Integer _get_227 = this.expressionList.get(indexExpression);
                          _builder.append(_get_227, "\t   \t\t\t\t\t\t\t");
                          _builder.append(".eGet(ref);\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t   \t\t\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t   \t\t\t\t\t");
                          _builder.append("}");
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
                    ObSelectionStrategy _value_114 = ((ReferenceEvaluation)ev).getValue();
                    if ((_value_114 instanceof RandomTypeSelection)) {
                      {
                        Expression _expression_2 = ((ReferenceEvaluation)ev).getValue().getExpression();
                        if ((_expression_2 instanceof Expression)) {
                          _builder.append("//EXPRESSION LEVEL: ");
                          int _get_228 = this.nExpression[0];
                          int _plus_2 = (_get_228 + 1);
                          int _set_2 = this.nExpression[0] = _plus_2;
                          _builder.append(_set_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//EXPRESSION LEVEL: ");
                          boolean _add_2 = this.expressionList.add(Integer.valueOf(this.nExpression[0]));
                          _builder.append(_add_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("//INDEX EXPRESSION: ");
                          int _size_3 = this.expressionList.size();
                          final int nestedIndexExpression_2 = (_size_3 - 1);
                          _builder.newLineIfNotEmpty();
                          _builder.append("RandomTypeSelection expRts");
                          Integer _get_229 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_229);
                          _builder.append(" = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _value_115 = ((ReferenceEvaluation)ev).getValue();
                          String _name_66 = ((RandomTypeSelection) _value_115).getType().getName();
                          _builder.append(_name_66);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> expObjects");
                          Integer _get_230 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_230);
                          _builder.append(" = expRts");
                          Integer _get_231 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_231);
                          _builder.append(".getObjects();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("Expression exp");
                          Integer _get_232 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_232);
                          _builder.append(" = new Expression();");
                          _builder.newLineIfNotEmpty();
                          Object _method_2 = this.method(((ReferenceEvaluation)ev).getValue().getExpression(), nestedIndexExpression_2, resources);
                          _builder.append(_method_2);
                          _builder.newLineIfNotEmpty();
                          _builder.append("List<EObject> selectedObjects");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_233 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_233);
                          _builder.append(" = evaluate(expObjects");
                          Integer _get_234 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_234);
                          _builder.append(", exp");
                          Integer _get_235 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_235);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject object");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_236 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_236);
                          _builder.append(" = null;");
                          _builder.newLineIfNotEmpty();
                          _builder.append("if (selectedObjects");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_237 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_237);
                          _builder.append(".size() > 0) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("object");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_238 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_238, "\t");
                          _builder.append(" = selectedObjects");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_239 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_239, "\t");
                          _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                          _builder.append(evName, "\t");
                          _builder.append("_");
                          Integer _get_240 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_240, "\t");
                          _builder.append("));");
                          _builder.newLineIfNotEmpty();
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("ev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_241 = this.expressionList.get(indexExpression);
                          _builder.append(_get_241);
                          _builder.append(".value = new SpecificObjectSelection(packages, model, object");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_242 = this.expressionList.get(nestedIndexExpression_2);
                          _builder.append(_get_242);
                          _builder.append(").getObject();");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("ev");
                          _builder.append(evName);
                          _builder.append("_");
                          Integer _get_243 = this.expressionList.get(indexExpression);
                          _builder.append(_get_243);
                          _builder.append(".value = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _value_116 = ((ReferenceEvaluation)ev).getValue();
                          String _name_67 = ((RandomTypeSelection) _value_116).getType().getName();
                          _builder.append(_name_67);
                          _builder.append("\").getObject();");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    } else {
                      {
                        ObSelectionStrategy _value_117 = ((ReferenceEvaluation)ev).getValue();
                        if ((_value_117 instanceof TypedSelection)) {
                          {
                            Expression _expression_3 = ((ReferenceEvaluation)ev).getValue().getExpression();
                            if ((_expression_3 instanceof Expression)) {
                              _builder.append("//EXPRESSION LEVEL: ");
                              int _get_244 = this.nExpression[0];
                              int _plus_3 = (_get_244 + 1);
                              int _set_3 = this.nExpression[0] = _plus_3;
                              _builder.append(_set_3);
                              _builder.newLineIfNotEmpty();
                              _builder.append("//EXPRESSION LEVEL: ");
                              boolean _add_3 = this.expressionList.add(Integer.valueOf(this.nExpression[0]));
                              _builder.append(_add_3);
                              _builder.newLineIfNotEmpty();
                              _builder.append("//INDEX EXPRESSION: ");
                              int _size_4 = this.expressionList.size();
                              final int nestedIndexExpression_3 = (_size_4 - 1);
                              _builder.newLineIfNotEmpty();
                              _builder.append("TypedSelection expRts");
                              Integer _get_245 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_245);
                              _builder.append(" = new TypedSelection(packages, model, \"");
                              ObSelectionStrategy _value_118 = ((ReferenceEvaluation)ev).getValue();
                              String _name_68 = ((TypedSelection) _value_118).getType().getName();
                              _builder.append(_name_68);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<EObject> expObjects");
                              Integer _get_246 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_246);
                              _builder.append(" = expRts");
                              Integer _get_247 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_247);
                              _builder.append(".getObjects();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("Expression exp");
                              Integer _get_248 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_248);
                              _builder.append(" = new Expression();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<String> refNames");
                              Integer _get_249 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_249);
                              _builder.append(" = new ArrayList<String>();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t   \t\t\t");
                              Object _method_3 = this.method(((ReferenceEvaluation)ev).getValue().getExpression(), nestedIndexExpression_3, resources);
                              _builder.append(_method_3, "\t   \t\t\t");
                              _builder.newLineIfNotEmpty();
                              _builder.append("List<EObject> selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_250 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_250);
                              _builder.append(" = evaluate(expObjects");
                              Integer _get_251 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_251);
                              _builder.append(", exp");
                              Integer _get_252 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_252);
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("refNames");
                              Integer _get_253 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_253);
                              _builder.append(".add(\"");
                              String _name_69 = ((ReferenceEvaluation)ev).getName().getName();
                              _builder.append(_name_69);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("Collections.reverse(refNames");
                              Integer _get_254 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_254);
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_255 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_255);
                              _builder.append(" = ModelManager.getReferredObjects(refNames");
                              Integer _get_256 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_256);
                              _builder.append(", objects, selectedObjects1);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("EObject object");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_257 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_257);
                              _builder.append(" = null;");
                              _builder.newLineIfNotEmpty();
                              _builder.append("if (selectedObjects");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_258 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_258);
                              _builder.append(".size() > 0) {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("object");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_259 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_259, "\t");
                              _builder.append(" = selectedObjects");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_260 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_260, "\t");
                              _builder.append(".get(ModelManager.getRandomIndex(selectedObjects");
                              _builder.append(evName, "\t");
                              _builder.append("_");
                              Integer _get_261 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_261, "\t");
                              _builder.append("));");
                              _builder.newLineIfNotEmpty();
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("ev");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_262 = this.expressionList.get(indexExpression);
                              _builder.append(_get_262);
                              _builder.append(".value = new SpecificObjectSelection(packages, model, object");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_263 = this.expressionList.get(nestedIndexExpression_3);
                              _builder.append(_get_263);
                              _builder.append(").getObject();");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("ev");
                              _builder.append(evName);
                              _builder.append("_");
                              Integer _get_264 = this.expressionList.get(indexExpression);
                              _builder.append(_get_264);
                              _builder.append(".value = new TypedSelection(packages, model, \"");
                              ObSelectionStrategy _value_119 = ((ReferenceEvaluation)ev).getValue();
                              String _name_70 = ((TypedSelection) _value_119).getType().getName();
                              _builder.append(_name_70);
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
        Integer _get_265 = this.expressionList.get(indexExpression);
        _builder.append(_get_265, "   \t\t");
        _builder.append(".second.add(ev");
        _builder.append(evName, "   \t\t");
        _builder.append("_");
        Integer _get_266 = this.expressionList.get(indexExpression);
        _builder.append(_get_266, "   \t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("   \t\t");
        _builder.append("//EVNAME + 1: ");
        _builder.append(evName = (evName + 1), "   \t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence each(final Expression exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//INDEX EXPRESSION: ");
    int _size = this.expressionList.size();
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
        Integer _get = this.expressionList.get(indexExpression);
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

  public CharSequence execute(final MutatorEnvironment e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    _builder.append("//");
    final String projectRoot = this.project.getLocation().toFile().getAbsolutePath().replace("\\", "/");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t\t");
    String fileName = e.eResource().getURI().lastSegment();
    _builder.newLineIfNotEmpty();
    {
      if (this.standalone) {
        _builder.newLine();
        _builder.append("String xmiFilename =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"");
        _builder.append(projectRoot, "    ");
        _builder.append("/");
        String _output = this.program.getOutput();
        _builder.append(_output, "    ");
        String _replaceAll = fileName.replaceAll(".mutator", ".model");
        _builder.append(_replaceAll, "    ");
        _builder.append("\".replace(\"\\\\\", \"/\");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      } else {
        _builder.newLine();
        _builder.append("String xmiFilename =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append(this.className, "    ");
        _builder.append(".class");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append(".getProtectionDomain()");
        _builder.newLine();
        _builder.append("        ");
        _builder.append(".getCodeSource()");
        _builder.newLine();
        _builder.append("        ");
        _builder.append(".getLocation()");
        _builder.newLine();
        _builder.append("        ");
        _builder.append(".getPath()");
        _builder.newLine();
        _builder.append("        ");
        _builder.append(".replace(\"/bin/\", \"/\")");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("+ \"");
        String _output_1 = this.program.getOutput();
        String _replaceAll_1 = fileName.replaceAll(".mutator", ".model");
        String _plus = (_output_1 + _replaceAll_1);
        _builder.append(_plus, "    ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("xmiFilename = xmiFilename.substring(1, xmiFilename.length());");
        _builder.newLine();
        _builder.newLine();
      }
    }
    {
      if ((this.standalone == false)) {
        _builder.append("   \t\t");
        _builder.append("//Generate metrics model");
        _builder.newLine();
        _builder.append("String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"model/MutatorEnvironment.ecore\";");
        _builder.newLine();
        _builder.append("mutatorecore = mutatorecore.substring(1, mutatorecore.length()); ");
        _builder.newLine();
        _builder.newLine();
        _builder.append("//Load MetaModel");
        _builder.newLine();
        _builder.append("List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);");
        _builder.newLine();
        _builder.append("Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(\"file:/\" + xmiFilename).toFileString());");
        _builder.newLine();
      } else {
        _builder.append("MutatorenvironmentPackage.eINSTANCE.eClass();");
        _builder.newLine();
        _builder.append("MiniOCLPackage.eINSTANCE.eClass();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append("EPackage.Registry.INSTANCE.put(");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eNS_URI,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.append("*/");
        _builder.newLine();
        _builder.newLine();
        _builder.append("List<EPackage> mutatorpackages =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("new ArrayList<EPackage>();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("mutatorpackages.add(");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.append("mutatorpackages.add(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("MiniOCLPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Resource mutatormodel =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("loadModelHeadless(");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("mutatorpackages,");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("URI.createURI(\"file:/\" + xmiFilename)");
        _builder.newLine();
        _builder.append("           ");
        _builder.append(".toFileString()");
        _builder.newLine();
        _builder.append("    ");
        _builder.append(");");
        _builder.newLine();
        _builder.newLine();
        _builder.append("if (mutatormodel == null) {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("throw new IOException(");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"Cannot load standalone Wodel semantic model: \"");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("+ xmiFilename");
        _builder.newLine();
        _builder.append("    ");
        _builder.append(");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));");
    _builder.newLine();
    {
      Definition _definition = e.getDefinition();
      boolean _isExhaustive = ((Program) _definition).isExhaustive();
      boolean _equals = (_isExhaustive == true);
      if (_equals) {
        _builder.append("\t");
        _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("monitor.subTask(\"Mutants generation\");");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("Resource model = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("Resource model = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("List<Resource> models = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("models.add(model);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("Resource seed = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("Resource seed = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("List<String> mutPaths = new ArrayList<String>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.append("//COUNTER: ");
        int _get = this.nMethod[0];
        int _plus_1 = (_get + 1);
        int _set = this.nMethod[0] = _plus_1;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//COMMAND: ");
        int _get_1 = this.nCommands[0];
        int _plus_2 = (_get_1 + 1);
        int _set_1 = this.nCommands[0] = _plus_2;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
        _builder.append("//REGISTRY COUNTER: ");
        int _get_2 = this.nRegistryMethod[0];
        int _plus_3 = (_get_2 + 1);
        int _set_2 = this.nRegistryMethod[0] = _plus_3;
        _builder.append(_set_2);
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        Mutator c = e.getCommands().get(0);
        _builder.newLineIfNotEmpty();
        {
          String _name = c.getName();
          boolean _tripleNotEquals = (_name != null);
          if (_tripleNotEquals) {
            _builder.append("//NAME:");
            String _name_1 = c.getName();
            String _string = Integer.valueOf((this.nCommands[0])).toString();
            String _plus_4 = (_name_1 + _string);
            String _commandName = this.commandName = _plus_4;
            _builder.append(_commandName);
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            String _string_1 = Integer.valueOf((this.nCommands[0])).toString();
            String _plus_5 = ("mut" + _string_1);
            String _commandName_1 = this.commandName = _plus_5;
            _builder.append(_commandName_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//METHOD NAME:");
        String _string_2 = Integer.valueOf((this.nMethod[0])).toString();
        String _plus_6 = ("mutation" + _string_2);
        String _methodName = this.methodName = _plus_6;
        _builder.append(_methodName);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + ");
            _builder.append(this.methodName);
            _builder.append("(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("registry, hashsetMutants, null, hashmapMutVersions, muts, project, monitor, new int[] {0}, serialize, test, classes, executionSeed));");
            _builder.newLine();
          } else {
            _builder.append("mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + ");
            _builder.append(this.methodName);
            _builder.append("(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("registry, hashsetMutants, null, hashmapMutVersions, muts, monitor, new int[] {0}, serialize, test, classes, executionSeed));");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("int numMutantsToGenerate = numMutants;");
        _builder.newLine();
        {
          if ((!(e instanceof Block))) {
            _builder.append("int[] k = new int[1];");
            _builder.newLine();
            _builder.append("k[0] = 0;");
            _builder.newLine();
          } else {
            _builder.append("k[0] = 0;");
            _builder.newLine();
          }
        }
        _builder.append("for (int i = 0; i < numMutantsToGenerate; i++) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + i + \".model\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String mutFilenameRelativePath = mutFilename.indexOf(\"/");
        String _name_2 = this.project.getName();
        _builder.append(_name_2, "\t");
        _builder.append("/\") != -1 ? mutFilename.substring(mutFilename.lastIndexOf(\"/");
        String _name_3 = this.project.getName();
        _builder.append(_name_3, "\t");
        _builder.append("/\"), mutFilename.length()) : mutFilename;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("monitor.subTask(\"Mutant \" + (count * numMutantsToGenerate + i + 1) + \"/\" + totalMutants + \": \" + mutFilenameRelativePath);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String mutPath = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + i + \"vs\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("boolean isRepeated = true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("int attempts = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("int max = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("while ((isRepeated == true) && (attempts < maxAttempts)) {");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t\t");
            _builder.append("Resource model = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("Resource model = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("List<Resource> models = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("models.add(model);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t\t");
            _builder.append("Resource seed = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("Resource seed = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("List<String> mutPaths = new ArrayList<String>();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("attempts++;");
        _builder.newLine();
        {
          EList<Mutator> _commands = e.getCommands();
          for(final Mutator c_1 : _commands) {
            {
              if ((c_1 instanceof Mutator)) {
                _builder.append("   \t   \t\t\t");
                CharSequence _compile = this.compile(c_1);
                _builder.append(_compile, "   \t   \t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//MUTANT COMPLETION AND REGISTRY");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
        _builder.newLine();
        {
          EList<Constraint> _constraints = e.getConstraints();
          for(final Constraint constraint : _constraints) {
            _builder.append("if (rules.get(\"");
            String _name_4 = constraint.getType().getName();
            _builder.append(_name_4);
            _builder.append("\") == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("rules.put(\"");
            String _name_5 = constraint.getType().getName();
            _builder.append(_name_5, "\t");
            _builder.append("\", new ArrayList<String>());");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
            _builder.append("List<String> newrules = rules.get(\"");
            String _name_6 = constraint.getType().getName();
            _builder.append(_name_6);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            {
              EList<InvariantCS> _expressions = constraint.getExpressions();
              boolean _tripleNotEquals_1 = (_expressions != null);
              if (_tripleNotEquals_1) {
                {
                  EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                  for(final InvariantCS expression : _expressions_1) {
                    _builder.append("newrules.add(\"");
                    String _constraintText = WodelUtils.getConstraintText(fileName, expression);
                    _builder.append(_constraintText);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              EList<String> _rules = constraint.getRules();
              boolean _tripleNotEquals_2 = (_rules != null);
              if (_tripleNotEquals_2) {
                {
                  EList<String> _rules_1 = constraint.getRules();
                  for(final String rule : _rules_1) {
                    _builder.append("newrules.add(\"");
                    _builder.append(rule);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("rules.put(\"");
            String _name_7 = constraint.getType().getName();
            _builder.append(_name_7);
            _builder.append("\", newrules);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("int[] mutantIndex = new int[1];");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mutantIndex[0] = i;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t\t");
            _builder.append("isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, \"");
            String _name_8 = this.project.getName();
            _builder.append(_name_8, "\t\t");
            _builder.append("\", serialize, test, classes, ");
            _builder.append(this.className, "\t\t");
            _builder.append(".class, true);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("if (isRepeated == false) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + 1);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//Reload input");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("model.unload();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("model.load(null); ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("seed.unload();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("seed.load(null);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} catch (Exception e) {}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("monitor.worked(1);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("count++;");
    _builder.newLine();
    _builder.append("mutatedObjects = null;");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }

  public CharSequence executeBlock(final MutatorEnvironment e, final Block b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("//");
    final String projectRoot = this.project.getLocation().toFile().getAbsolutePath().replace("\\", "/");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t\t");
    String fileName = e.eResource().getURI().lastSegment();
    _builder.newLineIfNotEmpty();
    {
      if (this.standalone) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String xmiFilename =");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("\"");
        _builder.append(projectRoot, "\t    ");
        _builder.append("/");
        String _output = this.program.getOutput();
        _builder.append(_output, "\t    ");
        String _replaceAll = fileName.replaceAll(".mutator", ".model");
        _builder.append(_replaceAll, "\t    ");
        _builder.append("\".replace(\"\\\\\", \"/\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String xmiFilename =");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append(this.className, "\t    ");
        _builder.append(".class");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append(".getProtectionDomain()");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append(".getCodeSource()");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append(".getLocation()");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append(".getPath()");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append(".replace(\"/bin/\", \"/\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("+ \"");
        String _output_1 = this.program.getOutput();
        String _replaceAll_1 = fileName.replaceAll(".mutator", ".model");
        String _plus = (_output_1 + _replaceAll_1);
        _builder.append(_plus, "\t    ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("xmiFilename = xmiFilename.substring(1, xmiFilename.length());");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("//Generate metrics model");
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("\t");
        _builder.append("String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")+ \"model/MutatorEnvironment.ecore\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("mutatorecore = mutatorecore.substring(1, mutatorecore.length()); ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//Load MetaModel");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(\"file:/\" + xmiFilename).toFileString());");
        _builder.newLine();
      } else {
        _builder.append("MutatorenvironmentPackage.eINSTANCE.eClass();");
        _builder.newLine();
        _builder.append("MiniOCLPackage.eINSTANCE.eClass();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append("EPackage.Registry.INSTANCE.put(");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eNS_URI,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.append("*/");
        _builder.newLine();
        _builder.newLine();
        _builder.newLine();
        _builder.append("List<EPackage> mutatorpackages =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("new ArrayList<EPackage>();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("mutatorpackages.add(");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorenvironmentPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.append("mutatorpackages.add(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("MiniOCLPackage.eINSTANCE");
        _builder.newLine();
        _builder.append(");");
        _builder.newLine();
        _builder.newLine();
        _builder.newLine();
        _builder.append("Resource mutatormodel =");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("loadModelHeadless(");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("mutatorpackages,");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("URI.createURI(\"file:/\" + xmiFilename)");
        _builder.newLine();
        _builder.append("           ");
        _builder.append(".toFileString()");
        _builder.newLine();
        _builder.append("    ");
        _builder.append(");");
        _builder.newLine();
        _builder.newLine();
        _builder.append("if (mutatormodel == null) {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("throw new IOException(");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"Cannot load standalone Wodel semantic model: \"");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("+ xmiFilename");
        _builder.newLine();
        _builder.append("    ");
        _builder.append(");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Definition _definition = e.getDefinition();
      boolean _isExhaustive = ((Program) _definition).isExhaustive();
      boolean _equals = (_isExhaustive == true);
      if (_equals) {
        _builder.append("\t");
        _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("Resource model = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("Resource model = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("List<Resource> models = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("models.add(model);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("Resource seed = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("Resource seed = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("List<String> mutPaths = new ArrayList<String>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER: ");
        int _get = this.nMethod[0];
        int _plus_1 = (_get + 1);
        int _set = this.nMethod[0] = _plus_1;
        _builder.append(_set, "\t");
        _builder.append("\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COMMAND: ");
        int _get_1 = this.nCommands[0];
        int _plus_2 = (_get_1 + 1);
        int _set_1 = this.nCommands[0] = _plus_2;
        _builder.append(_set_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//REGISTRY COUNTER: ");
        int _get_2 = this.nRegistryMethod[0];
        int _plus_3 = (_get_2 + 1);
        int _set_2 = this.nRegistryMethod[0] = _plus_3;
        _builder.append(_set_2, "\t");
        _builder.newLineIfNotEmpty();
        {
          int _size = b.getCommands().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("\t");
            _builder.append("//");
            Mutator c = b.getCommands().get(0);
            _builder.newLineIfNotEmpty();
            {
              String _name = c.getName();
              boolean _tripleNotEquals = (_name != null);
              if (_tripleNotEquals) {
                _builder.append("\t");
                _builder.append("//NAME:");
                String _name_1 = c.getName();
                String _string = Integer.valueOf((this.nCommands[0])).toString();
                String _plus_4 = (_name_1 + _string);
                String _commandName = this.commandName = _plus_4;
                _builder.append(_commandName, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("//NAME:");
                String _string_1 = Integer.valueOf((this.nCommands[0])).toString();
                String _plus_5 = ("mut" + _string_1);
                String _commandName_1 = this.commandName = _plus_5;
                _builder.append(_commandName_1, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("//METHOD NAME:");
        String _string_2 = Integer.valueOf((this.nMethod[0])).toString();
        String _plus_6 = ("mutation" + _string_2);
        String _methodName = this.methodName = _plus_6;
        _builder.append(_methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          Definition _definition_1 = e.getDefinition();
          boolean _isExhaustive_1 = ((Program) _definition_1).isExhaustive();
          boolean _equals_1 = (_isExhaustive_1 == true);
          if (_equals_1) {
            _builder.append("try {");
            _builder.newLine();
          }
        }
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append(this.methodName, "\t");
            _builder.append("(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append(this.methodName, "\t");
            _builder.append("(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("numMutantsGenerated = k[0];");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("int numMutantsToGenerate = numMutants;");
        _builder.newLine();
        {
          if ((!(b instanceof Block))) {
            _builder.append("\t");
            _builder.append("int[] k = new int[1];");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("k[0] = 0;");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("k[0] = 0;");
            _builder.newLine();
          }
        }
        _builder.append("   \t   \t\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (int i = 0; i < numMutantsToGenerate; i++) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();");
        _builder.newLine();
        {
          int _size_1 = b.getFrom().size();
          boolean _equals_2 = (_size_1 == 0);
          if (_equals_2) {
            _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
            String _name_2 = b.getName();
            _builder.append(_name_2);
            _builder.append("/Output\" + i + \".model\";");
            _builder.newLineIfNotEmpty();
            _builder.append("String mutPath = hashmapModelFilenames.get(modelFilename) + \"/");
            String _name_3 = b.getName();
            _builder.append(_name_3);
            _builder.append("/Output\" + i + \"vs\";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
            String _name_4 = b.getName();
            _builder.append(_name_4);
            _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + i + \".model\";");
            _builder.newLineIfNotEmpty();
            _builder.append("String mutPath = hashmapModelFilenames.get(modelFilename) + \"/");
            String _name_5 = b.getName();
            _builder.append(_name_5);
            _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + i + \"vs\";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("boolean isRepeated = true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("int attempts = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("int max = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("while ((isRepeated == true) && (attempts < maxAttempts)) {");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("Resource model = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("Resource model = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("List<Resource> models = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("models.add(model);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("Resource seed = ModelManager.loadModel(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("Resource seed = loadModelHeadless(packages, URI.createURI(\"file:/\" + modelFilename).toFileString());");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("List<String> mutPaths = new ArrayList<String>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("attempts++;");
        _builder.newLine();
        {
          EList<Mutator> _commands = b.getCommands();
          for(final Mutator c_1 : _commands) {
            {
              if ((c_1 instanceof Mutator)) {
                _builder.append("   \t   \t\t\t");
                CharSequence _compile = this.compile(c_1);
                _builder.append(_compile, "   \t   \t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// MUTANT COMPLETION AND REGISTRY");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
        _builder.newLine();
        {
          EList<Constraint> _constraints = e.getConstraints();
          for(final Constraint constraint : _constraints) {
            _builder.append("if (rules.get(\"");
            String _name_6 = constraint.getType().getName();
            _builder.append(_name_6);
            _builder.append("\") == null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("rules.put(\"");
            String _name_7 = constraint.getType().getName();
            _builder.append(_name_7, "\t");
            _builder.append("\", new ArrayList<String>());");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
            _builder.append("List<String> newrules = rules.get(\"");
            String _name_8 = constraint.getType().getName();
            _builder.append(_name_8);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            {
              EList<InvariantCS> _expressions = constraint.getExpressions();
              boolean _tripleNotEquals_1 = (_expressions != null);
              if (_tripleNotEquals_1) {
                {
                  EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                  for(final InvariantCS expression : _expressions_1) {
                    _builder.append("newrules.add(\"");
                    String _constraintText = WodelUtils.getConstraintText(fileName, expression);
                    _builder.append(_constraintText);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              EList<String> _rules = constraint.getRules();
              boolean _tripleNotEquals_2 = (_rules != null);
              if (_tripleNotEquals_2) {
                {
                  EList<String> _rules_1 = constraint.getRules();
                  for(final String rule : _rules_1) {
                    _builder.append("newrules.add(\"");
                    _builder.append(rule);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("rules.put(\"");
            String _name_9 = constraint.getType().getName();
            _builder.append(_name_9);
            _builder.append("\", newrules);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("int[] mutantIndex = new int[1];");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("mutantIndex[0] = i;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
        _builder.newLine();
        {
          if ((this.standalone == false)) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
            String _name_10 = b.getName();
            _builder.append(_name_10, "\t\t\t");
            _builder.append("\", fromNames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
            String _name_11 = b.getName();
            _builder.append(_name_11, "\t\t\t");
            _builder.append("\", fromNames, mutantIndex, mutPaths, hashmapMutVersions, \"");
            String _name_12 = this.project.getName();
            _builder.append(_name_12, "\t\t\t");
            _builder.append("\", serialize, test, classes, ");
            _builder.append(this.className, "\t\t\t");
            _builder.append(".class, true, false);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("if (isRepeated == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("numMutantsGenerated++;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("k[0] = k[0] + 1;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("//Reload input");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("model.unload();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("model.load(null);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("seed.unload();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("seed.load(null);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("} catch (Exception e) {}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}\t\t");
        _builder.newLine();
      }
    }
    {
      Repeat _repeat = b.getRepeat();
      boolean _equals_3 = Objects.equals(_repeat, Repeat.YES);
      if (_equals_3) {
        _builder.append("   \t\t");
        _builder.append("hashmapMutants.put(modelFilename, hashsetMutantsBlock);");
        _builder.newLine();
      }
    }
    {
      Definition _definition_2 = e.getDefinition();
      boolean _isExhaustive_2 = ((Program) _definition_2).isExhaustive();
      boolean _equals_4 = (_isExhaustive_2 == true);
      if (_equals_4) {
        _builder.append("//Frees memory");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("finally {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorUtils.disposeResource(model);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorUtils.disposeResource(seed);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("MutatorUtils.disposeResource(mutatormodel);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("   \t\t");
    _builder.newLine();
    _builder.append("   \t\t");
    _builder.append("mutatedObjects = null;");
    _builder.newLine();
    return _builder;
  }

  public CharSequence compile(final Mutator e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((e instanceof CompositeMutator)) {
        _builder.append("//COUNTER: ");
        int _get = this.nMethod[0];
        int _mutatorSize = MutatorUtils.mutatorSize(((CompositeMutator)e));
        int _plus = (_get + _mutatorSize);
        int _set = this.nMethod[0] = _plus;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//COMPOSITE REGISTRY COUNTER: ");
        int _get_1 = this.nCompositeRegistryMethod[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = this.nCompositeRegistryMethod[0] = _plus_1;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
        {
          int _fixed = ((CompositeMutator)e).getFixed();
          boolean _equals = (_fixed == 0);
          if (_equals) {
            {
              int _max = ((CompositeMutator)e).getMax();
              int _min = ((CompositeMutator)e).getMin();
              int _minus = (_max - _min);
              boolean _greaterThan = (_minus > 0);
              if (_greaterThan) {
                _builder.append("int max");
                int _get_2 = this.nCompositeCommands[0];
                _builder.append(_get_2);
                _builder.append(" = getRandom(");
                int _max_1 = ((CompositeMutator)e).getMax();
                int _min_1 = ((CompositeMutator)e).getMin();
                int _minus_1 = (_max_1 - _min_1);
                _builder.append(_minus_1);
                _builder.append(") + ");
                int _min_2 = ((CompositeMutator)e).getMin();
                _builder.append(_min_2);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if (((((CompositeMutator)e).getMin() == 0) && (((CompositeMutator)e).getMax() == 0))) {
                _builder.append("int max");
                int _get_3 = this.nCompositeCommands[0];
                _builder.append(_get_3);
                _builder.append(" = 1;");
                _builder.newLineIfNotEmpty();
              } else {
                int _min_3 = ((CompositeMutator)e).getMin();
                int _max_2 = ((CompositeMutator)e).getMax();
                boolean _equals_1 = (_min_3 == _max_2);
                if (_equals_1) {
                  _builder.append("int max");
                  int _get_4 = this.nCompositeCommands[0];
                  _builder.append(_get_4);
                  _builder.append(" = ");
                  int _min_4 = ((CompositeMutator)e).getMin();
                  _builder.append(_min_4);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            _builder.append("int max");
            int _get_5 = this.nCompositeCommands[0];
            _builder.append(_get_5);
            _builder.append(" = ");
            int _fixed_1 = ((CompositeMutator)e).getFixed();
            _builder.append(_fixed_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("for (int j");
        int _get_6 = this.nCompositeCommands[0];
        _builder.append(_get_6);
        _builder.append(" = 0; j");
        int _get_7 = this.nCompositeCommands[0];
        _builder.append(_get_7);
        _builder.append(" < max");
        int _get_8 = this.nCompositeCommands[0];
        _builder.append(_get_8);
        _builder.append("; j");
        int _get_9 = this.nCompositeCommands[0];
        _builder.append(_get_9);
        _builder.append("++) {");
        _builder.newLineIfNotEmpty();
        {
          String _name = ((CompositeMutator)e).getName();
          boolean _tripleNotEquals = (_name != null);
          if (_tripleNotEquals) {
            _builder.append("//NAME:");
            String _name_1 = ((CompositeMutator)e).getName();
            String _string = Integer.valueOf((this.nCompositeCommands[0])).toString();
            String _plus_2 = (_name_1 + _string);
            String _compositeCommandName = this.compositeCommandName = _plus_2;
            _builder.append(_compositeCommandName);
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            String _string_1 = Integer.valueOf((this.nCompositeCommands[0])).toString();
            String _plus_3 = ("composite" + _string_1);
            String _compositeCommandName_1 = this.compositeCommandName = _plus_3;
            _builder.append(_compositeCommandName_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("//COMPOSITE METHOD NAME:");
        _builder.append(this.compositeMethodName = this.compositeCommands.get(this.nCompositeCommands[0]));
        _builder.newLineIfNotEmpty();
        _builder.append("//COMMAND: ");
        int _get_10 = this.nCompositeCommands[0];
        int _compositeMutatorSize = MutatorUtils.compositeMutatorSize(((CompositeMutator)e));
        int _plus_4 = (_get_10 + _compositeMutatorSize);
        int _set_2 = this.nCompositeCommands[0] = _plus_4;
        _builder.append(_set_2);
        _builder.newLineIfNotEmpty();
        _builder.append("List<Mutator> l");
        _builder.append(this.compositeCommandName);
        _builder.append(" = ");
        _builder.append(this.compositeMethodName);
        _builder.append("(packages, models, hashmapEObject, hashmapList, serialize, test, classes);");
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER: ");
        int _get_11 = this.nRegistryMutation[0];
        int _plus_5 = (_get_11 + 1);
        int _set_3 = this.nRegistryMutation[0] = _plus_5;
        _builder.append(_set_3);
        _builder.newLineIfNotEmpty();
        _builder.append("//REGISTRY METHOD NAME:");
        String _string_2 = ((List<Integer>)Conversions.doWrapArray(this.nCompositeRegistryMethod)).toString();
        String _plus_6 = ("compositeRegistry" + _string_2);
        String _compositeRegistryMethodName = this.compositeRegistryMethodName = _plus_6;
        _builder.append(_compositeRegistryMethodName);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("if (l");
        _builder.append(this.compositeCommandName);
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("for (Mutator mut : l");
        _builder.append(this.compositeCommandName, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        {
          if ((this.executeMutation == true)) {
            _builder.append("\t\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("AppMutation appMut = ");
        _builder.append(this.compositeRegistryMethodName, "\t");
        _builder.append("(l");
        _builder.append(this.compositeCommandName, "\t");
        _builder.append(", hmMutator, seed);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (appMut != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("muts.getMuts().add(appMut);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("//COUNTER: ");
        int _get_12 = this.nRegistryMutation[0];
        int _mutatorSize_1 = MutatorUtils.mutatorSize(((CompositeMutator)e));
        int _plus_7 = (_get_12 + _mutatorSize_1);
        int _set_4 = this.nRegistryMutation[0] = _plus_7;
        _builder.append(_set_4);
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("//COUNTER: ");
        int _get_13 = this.nMethod[0];
        int _plus_8 = (_get_13 + 1);
        int _set_5 = this.nMethod[0] = _plus_8;
        _builder.append(_set_5);
        _builder.append("\t");
        _builder.newLineIfNotEmpty();
        _builder.append("//COMMAND: ");
        int _get_14 = this.nCommands[0];
        int _plus_9 = (_get_14 + 1);
        int _set_6 = this.nCommands[0] = _plus_9;
        _builder.append(_set_6);
        _builder.newLineIfNotEmpty();
        _builder.append("//REGISTRY COUNTER: ");
        int _get_15 = this.nRegistryMethod[0];
        int _plus_10 = (_get_15 + 1);
        int _set_7 = this.nRegistryMethod[0] = _plus_10;
        _builder.append(_set_7);
        _builder.newLineIfNotEmpty();
        {
          int _fixed_2 = e.getFixed();
          boolean _equals_2 = (_fixed_2 == 0);
          if (_equals_2) {
            {
              int _max_3 = e.getMax();
              int _min_5 = e.getMin();
              int _minus_2 = (_max_3 - _min_5);
              boolean _greaterThan_1 = (_minus_2 > 0);
              if (_greaterThan_1) {
                _builder.append("max = getRandom(");
                int _max_4 = e.getMax();
                int _min_6 = e.getMin();
                int _minus_3 = (_max_4 - _min_6);
                _builder.append(_minus_3);
                _builder.append(") + ");
                int _min_7 = e.getMin();
                _builder.append(_min_7);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if (((e.getMin() == 0) && (e.getMax() == 0))) {
                _builder.append("max = 1;");
                _builder.newLine();
              } else {
                int _min_8 = e.getMin();
                int _max_5 = e.getMax();
                boolean _equals_3 = (_min_8 == _max_5);
                if (_equals_3) {
                  _builder.append("max = ");
                  int _min_9 = e.getMin();
                  _builder.append(_min_9);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            _builder.append("max = ");
            int _fixed_3 = e.getFixed();
            _builder.append(_fixed_3);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EObject _eContainer = e.eContainer();
          boolean _not = (!(_eContainer instanceof Block));
          if (_not) {
            _builder.append("k[0] = 0;");
            _builder.newLine();
          }
        }
        _builder.append("for (int j = 0; j < max; j++) {");
        _builder.newLine();
        {
          String _name_2 = e.getName();
          boolean _tripleNotEquals_1 = (_name_2 != null);
          if (_tripleNotEquals_1) {
            _builder.append("//NAME:");
            String _name_3 = e.getName();
            String _string_3 = Integer.valueOf((this.nCommands[0])).toString();
            String _plus_11 = (_name_3 + _string_3);
            String _commandName = this.commandName = _plus_11;
            _builder.append(_commandName);
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("//NAME:");
            String _string_4 = Integer.valueOf((this.nCommands[0])).toString();
            String _plus_12 = ("com" + _string_4);
            String _commandName_1 = this.commandName = _plus_12;
            _builder.append(_commandName_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("//METHOD NAME:");
        String _string_5 = Integer.valueOf((this.nMethod[0])).toString();
        String _plus_13 = ("mutation" + _string_5);
        String _methodName = this.methodName = _plus_13;
        _builder.append(_methodName);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("List<Mutator> l");
        _builder.append(this.commandName);
        _builder.append(" = ");
        _builder.append(this.methodName);
        _builder.append("(packages, models, hashmapEObject, hashmapList, serialize, test, classes);");
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER: ");
        int _get_16 = this.nRegistryMutation[0];
        int _plus_14 = (_get_16 + 1);
        int _set_8 = this.nRegistryMutation[0] = _plus_14;
        _builder.append(_set_8);
        _builder.newLineIfNotEmpty();
        _builder.append("//REGISTRY METHOD NAME:");
        String _string_6 = Integer.valueOf((this.nRegistryMethod[0])).toString();
        String _plus_15 = ("registry" + _string_6);
        String _registryMethodName = this.registryMethodName = _plus_15;
        _builder.append(_registryMethodName);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("if (l");
        _builder.append(this.commandName);
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("for (Mutator mut : l");
        _builder.append(this.commandName, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        {
          if ((this.executeMutation == true)) {
            _builder.append("\t\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("* IMPORTANT:");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("* Capture the removed EObject from the PRE-MUTATION");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("* source model. Do not use mut.getObject() here:");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("* RemoveObjectMutator only populates that information");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("* during mutate().");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t    ");
            _builder.append("EObject clue =");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("findEObjectForRegistry(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("seed,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("mut.getObject(),");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("mutPaths,");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t\t\t            ");
            _builder.append("packages);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (mutated != null) {");
            _builder.newLine();
            {
              if (((((e instanceof CreateObjectMutator) || (e instanceof SelectObjectMutator)) || (e instanceof CloneObjectMutator)) || (e instanceof RetypeObjectMutator))) {
                {
                  String _name_4 = e.getName();
                  boolean _tripleNotEquals_2 = (_name_4 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("if (mutated instanceof EObject) {");
                    _builder.newLine();
                    {
                      if ((e instanceof CreateObjectMutator)) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapEObject.put(\"");
                        String _name_5 = ((CreateObjectMutator)e).getName();
                        _builder.append(_name_5, "\t\t\t\t");
                        _builder.append("\", entry);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      if ((e instanceof SelectObjectMutator)) {
                        {
                          if (((((SelectObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((SelectObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapEObject.put(\"");
                            String _name_6 = ((SelectObjectMutator)e).getName();
                            _builder.append(_name_6, "\t\t\t\t");
                            _builder.append("\", entry);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          ObSelectionStrategy _object = ((SelectObjectMutator)e).getObject();
                          if ((_object instanceof CompleteTypeSelection)) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("if (hashmapList.get(\"");
                            String _name_7 = ((SelectObjectMutator)e).getName();
                            _builder.append(_name_7, "\t\t\t\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = hashmapList.get(\"");
                            String _name_8 = ((SelectObjectMutator)e).getName();
                            _builder.append(_name_8, "\t\t\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("listEObjects.add(entry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapList.put(\"");
                            String _name_9 = ((SelectObjectMutator)e).getName();
                            _builder.append(_name_9, "\t\t\t\t");
                            _builder.append("\", listEObjects);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      if ((e instanceof CloneObjectMutator)) {
                        {
                          if (((((CloneObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((CloneObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapEObject.put(\"");
                            String _name_10 = ((CloneObjectMutator)e).getName();
                            _builder.append(_name_10, "\t\t\t\t");
                            _builder.append("\", entry);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          ObSelectionStrategy _object_1 = ((CloneObjectMutator)e).getObject();
                          if ((_object_1 instanceof CompleteTypeSelection)) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("if (hashmapList.get(\"");
                            String _name_11 = ((CloneObjectMutator)e).getName();
                            _builder.append(_name_11, "\t\t\t\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = hashmapList.get(\"");
                            String _name_12 = ((CloneObjectMutator)e).getName();
                            _builder.append(_name_12, "\t\t\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("listEObjects.add(entry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapList.put(\"");
                            String _name_13 = ((CloneObjectMutator)e).getName();
                            _builder.append(_name_13, "\t\t\t\t");
                            _builder.append("\", listEObjects);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      if ((e instanceof RetypeObjectMutator)) {
                        {
                          if (((((RetypeObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((RetypeObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapEObject.put(\"");
                            String _name_14 = ((RetypeObjectMutator)e).getName();
                            _builder.append(_name_14, "\t\t\t\t");
                            _builder.append("\", entry);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          ObSelectionStrategy _object_2 = ((RetypeObjectMutator)e).getObject();
                          if ((_object_2 instanceof CompleteTypeSelection)) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("if (hashmapList.get(\"");
                            String _name_15 = ((RetypeObjectMutator)e).getName();
                            _builder.append(_name_15, "\t\t\t\t");
                            _builder.append("\") != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = hashmapList.get(\"");
                            String _name_16 = ((RetypeObjectMutator)e).getName();
                            _builder.append(_name_16, "\t\t\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("listEObjects.add(entry);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("hashmapList.put(\"");
                            String _name_17 = ((RetypeObjectMutator)e).getName();
                            _builder.append(_name_17, "\t\t\t\t");
                            _builder.append("\", listEObjects);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              String _name_18 = e.getName();
              boolean _tripleNotEquals_3 = (_name_18 != null);
              if (_tripleNotEquals_3) {
                {
                  if ((e instanceof SelectSampleMutator)) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("if (mutated instanceof List<?>) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("if (hashmapList.get(\"");
                    String _name_19 = ((SelectSampleMutator)e).getName();
                    _builder.append(_name_19, "\t\t\t\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("listEObjects = hashmapList.get(\"");
                    String _name_20 = ((SelectSampleMutator)e).getName();
                    _builder.append(_name_20, "\t\t\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects.add(entry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("hashmapList.put(\"");
                    String _name_21 = ((SelectSampleMutator)e).getName();
                    _builder.append(_name_21, "\t\t\t\t\t");
                    _builder.append("\", listEObjects);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              if ((((e instanceof SelectObjectMutator) == false) && ((e instanceof SelectSampleMutator) == false))) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("String mutatorPath = mutPath + \"/Output\" + i + \"_\" + j + \"_\" + k[0] + \"_");
                int _get_17 = this.nMethod[0];
                _builder.append(_get_17, "\t\t\t\t");
                _builder.append(".model\";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("ModelManager.saveOutModel(model, mutatorPath);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("if (mutPaths.contains(mutatorPath) == false) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("mutPaths.add(mutatorPath);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("AppMutation appMut = ");
            _builder.append(this.registryMethodName, "\t\t\t\t");
            _builder.append("(mut, hmMutator, seed, model, clue, mutPaths, packages);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("if (appMut != null) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("muts.getMuts().add(appMut);");
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
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence compile(final Mutator e, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//COUNTER: ");
    int _set = this.nMethod[0] = index;
    _builder.append(_set);
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("//COMMAND: ");
    int _get = this.nCommands[0];
    int _plus = (_get + 1);
    int _set_1 = this.nCommands[0] = _plus;
    _builder.append(_set_1);
    _builder.newLineIfNotEmpty();
    _builder.append("//REGISTRY COUNTER: ");
    int _set_2 = this.nRegistryMethod[0] = index;
    _builder.append(_set_2);
    _builder.newLineIfNotEmpty();
    {
      int _fixed = e.getFixed();
      boolean _equals = (_fixed == 0);
      if (_equals) {
        {
          int _max = e.getMax();
          int _min = e.getMin();
          int _minus = (_max - _min);
          boolean _greaterThan = (_minus > 0);
          if (_greaterThan) {
            _builder.append("max = getRandom(");
            int _max_1 = e.getMax();
            int _min_1 = e.getMin();
            int _minus_1 = (_max_1 - _min_1);
            _builder.append(_minus_1);
            _builder.append(") + ");
            int _min_2 = e.getMin();
            _builder.append(_min_2);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if (((e.getMin() == 0) && (e.getMax() == 0))) {
            _builder.append("max = 1;");
            _builder.newLine();
          } else {
            int _min_3 = e.getMin();
            int _max_2 = e.getMax();
            boolean _equals_1 = (_min_3 == _max_2);
            if (_equals_1) {
              _builder.append("max = ");
              int _min_4 = e.getMin();
              _builder.append(_min_4);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      } else {
        _builder.append("max = ");
        int _fixed_1 = e.getFixed();
        _builder.append(_fixed_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EObject _eContainer = e.eContainer();
      boolean _not = (!(_eContainer instanceof Block));
      if (_not) {
        _builder.append("k[0] = 0;");
        _builder.newLine();
      }
    }
    _builder.append("for (int j = 0; j < max; j++) {");
    _builder.newLine();
    {
      String _name = e.getName();
      boolean _tripleNotEquals = (_name != null);
      if (_tripleNotEquals) {
        _builder.append("//NAME:");
        String _name_1 = e.getName();
        String _string = ((List<Integer>)Conversions.doWrapArray(this.nCommands)).toString();
        String _plus_1 = (_name_1 + _string);
        String _commandName = this.commandName = _plus_1;
        _builder.append(_commandName);
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("//NAME:");
        _builder.append(this.commandName = ((List<Integer>)Conversions.doWrapArray(this.nCommands)).toString());
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("//METHOD NAME:");
    String _string_1 = ((List<Integer>)Conversions.doWrapArray(this.nMethod)).toString();
    String _plus_2 = ("mutation" + _string_1);
    String _methodName = this.methodName = _plus_2;
    _builder.append(_methodName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("List<Mutator> l");
    _builder.append(this.commandName);
    _builder.append(" = ");
    _builder.append(this.methodName);
    _builder.append("(packages, models, hashmapEObject, hashmapList, serialize, test, classes);");
    _builder.newLineIfNotEmpty();
    _builder.append("//COUNTER: ");
    int _get_1 = this.nRegistryMutation[0];
    int _plus_3 = (_get_1 + 1);
    int _set_3 = this.nRegistryMutation[0] = _plus_3;
    _builder.append(_set_3);
    _builder.newLineIfNotEmpty();
    _builder.append("//REGISTRY METHOD NAME:");
    String _string_2 = Integer.valueOf((this.nRegistryMethod[0])).toString();
    String _plus_4 = ("registry" + _string_2);
    String _registryMethodName = this.registryMethodName = _plus_4;
    _builder.append(_registryMethodName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("if (l");
    _builder.append(this.commandName);
    _builder.append(" != null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("if (overallMutators.get(");
    _builder.append(index);
    _builder.append(") == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (Mutator mut : l");
    _builder.append(this.commandName, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      if ((this.executeMutation == true)) {
        _builder.append("\t\t");
        _builder.append("if (mut != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("Object mutated = mut.mutate();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (mutated != null) {");
        _builder.newLine();
        {
          if (((((e instanceof CreateObjectMutator) || (e instanceof SelectObjectMutator)) || (e instanceof CloneObjectMutator)) || (e instanceof RetypeObjectMutator))) {
            {
              String _name_2 = e.getName();
              boolean _tripleNotEquals_1 = (_name_2 != null);
              if (_tripleNotEquals_1) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("if (mutated instanceof EObject) {");
                _builder.newLine();
                {
                  if ((e instanceof CreateObjectMutator)) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("hashmapEObject.put(\"");
                    String _name_3 = ((CreateObjectMutator)e).getName();
                    _builder.append(_name_3, "\t\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((e instanceof SelectObjectMutator)) {
                    {
                      if (((((SelectObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((SelectObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapEObject.put(\"");
                        String _name_4 = ((SelectObjectMutator)e).getName();
                        _builder.append(_name_4, "\t\t\t\t");
                        _builder.append("\", entry);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object = ((SelectObjectMutator)e).getObject();
                      if ((_object instanceof CompleteTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("if (hashmapList.get(\"");
                        String _name_5 = ((SelectObjectMutator)e).getName();
                        _builder.append(_name_5, "\t\t\t\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = hashmapList.get(\"");
                        String _name_6 = ((SelectObjectMutator)e).getName();
                        _builder.append(_name_6, "\t\t\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("listEObjects.add(entry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapList.put(\"");
                        String _name_7 = ((SelectObjectMutator)e).getName();
                        _builder.append(_name_7, "\t\t\t\t");
                        _builder.append("\", listEObjects);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  if ((e instanceof CloneObjectMutator)) {
                    {
                      if (((((CloneObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((CloneObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapEObject.put(\"");
                        String _name_8 = ((CloneObjectMutator)e).getName();
                        _builder.append(_name_8, "\t\t\t\t");
                        _builder.append("\", entry);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_1 = ((CloneObjectMutator)e).getObject();
                      if ((_object_1 instanceof CompleteTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("if (hashmapList.get(\"");
                        String _name_9 = ((CloneObjectMutator)e).getName();
                        _builder.append(_name_9, "\t\t\t\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = hashmapList.get(\"");
                        String _name_10 = ((CloneObjectMutator)e).getName();
                        _builder.append(_name_10, "\t\t\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("listEObjects.add(entry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapList.put(\"");
                        String _name_11 = ((CloneObjectMutator)e).getName();
                        _builder.append(_name_11, "\t\t\t\t");
                        _builder.append("\", listEObjects);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  if ((e instanceof RetypeObjectMutator)) {
                    {
                      if (((((RetypeObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((RetypeObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapEObject.put(\"");
                        String _name_12 = ((RetypeObjectMutator)e).getName();
                        _builder.append(_name_12, "\t\t\t\t");
                        _builder.append("\", entry);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_2 = ((RetypeObjectMutator)e).getObject();
                      if ((_object_2 instanceof CompleteTypeSelection)) {
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("if (hashmapList.get(\"");
                        String _name_13 = ((RetypeObjectMutator)e).getName();
                        _builder.append(_name_13, "\t\t\t\t");
                        _builder.append("\") != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = hashmapList.get(\"");
                        String _name_14 = ((RetypeObjectMutator)e).getName();
                        _builder.append(_name_14, "\t\t\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("listEObjects.add(entry);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("hashmapList.put(\"");
                        String _name_15 = ((RetypeObjectMutator)e).getName();
                        _builder.append(_name_15, "\t\t\t\t");
                        _builder.append("\", listEObjects);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          String _name_16 = e.getName();
          boolean _tripleNotEquals_2 = (_name_16 != null);
          if (_tripleNotEquals_2) {
            {
              if ((e instanceof SelectSampleMutator)) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("if (mutated instanceof List<?>) {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("if (hashmapList.get(\"");
                String _name_17 = ((SelectSampleMutator)e).getName();
                _builder.append(_name_17, "\t\t\t\t\t");
                _builder.append("\") != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("listEObjects = hashmapList.get(\"");
                String _name_18 = ((SelectSampleMutator)e).getName();
                _builder.append(_name_18, "\t\t\t\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("else {");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("listEObjects.add(entry);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("hashmapList.put(\"");
                String _name_19 = ((SelectSampleMutator)e).getName();
                _builder.append(_name_19, "\t\t\t\t\t");
                _builder.append("\", listEObjects);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          if ((((e instanceof SelectObjectMutator) == false) && ((e instanceof SelectSampleMutator) == false))) {
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("String mutatorPath = mutPath + \"/Output\" + i + \"_\" + j + \"_\" + k[0] + \"_");
            _builder.append(this.nMethod, "\t\t\t\t");
            _builder.append(".model\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("ModelManager.saveOutModel(model, mutatorPath);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("if (mutPaths.contains(mutatorPath) == false) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("mutPaths.add(mutatorPath);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("AppMutation appMut = ");
        _builder.append(this.registryMethodName, "\t\t\t\t");
        _builder.append("(mut, hmMutator, seed, mutPaths, packages);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("if (appMut != null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("muts.getMuts().add(appMut);");
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
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Mutator mut = overallMutators.get(");
    _builder.append(index, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mut.setModel(model);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object mutated = mut.mutate();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (mutated != null) {");
    _builder.newLine();
    {
      if (((((e instanceof CreateObjectMutator) || (e instanceof SelectObjectMutator)) || (e instanceof CloneObjectMutator)) || (e instanceof RetypeObjectMutator))) {
        {
          String _name_20 = e.getName();
          boolean _tripleNotEquals_3 = (_name_20 != null);
          if (_tripleNotEquals_3) {
            _builder.append("\t\t");
            _builder.append("if (mutated instanceof EObject) {");
            _builder.newLine();
            {
              if ((e instanceof CreateObjectMutator)) {
                _builder.append("\t\t");
                _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("hashmapEObject.put(\"");
                String _name_21 = ((CreateObjectMutator)e).getName();
                _builder.append(_name_21, "\t\t");
                _builder.append("\", entry);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((e instanceof SelectObjectMutator)) {
                {
                  if (((((SelectObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((SelectObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("hashmapEObject.put(\"");
                    String _name_22 = ((SelectObjectMutator)e).getName();
                    _builder.append(_name_22, "\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  ObSelectionStrategy _object_3 = ((SelectObjectMutator)e).getObject();
                  if ((_object_3 instanceof CompleteTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("if (hashmapList.get(\"");
                    String _name_23 = ((SelectObjectMutator)e).getName();
                    _builder.append(_name_23, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = hashmapList.get(\"");
                    String _name_24 = ((SelectObjectMutator)e).getName();
                    _builder.append(_name_24, "\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("listEObjects.add(entry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("hashmapList.put(\"");
                    String _name_25 = ((SelectObjectMutator)e).getName();
                    _builder.append(_name_25, "\t\t");
                    _builder.append("\", listEObjects);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              if ((e instanceof CloneObjectMutator)) {
                {
                  if (((((CloneObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((CloneObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("hashmapEObject.put(\"");
                    String _name_26 = ((CloneObjectMutator)e).getName();
                    _builder.append(_name_26, "\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  ObSelectionStrategy _object_4 = ((CloneObjectMutator)e).getObject();
                  if ((_object_4 instanceof CompleteTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("if (hashmapList.get(\"");
                    String _name_27 = ((CloneObjectMutator)e).getName();
                    _builder.append(_name_27, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = hashmapList.get(\"");
                    String _name_28 = ((CloneObjectMutator)e).getName();
                    _builder.append(_name_28, "\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("listEObjects.add(entry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("hashmapList.put(\"");
                    String _name_29 = ((CloneObjectMutator)e).getName();
                    _builder.append(_name_29, "\t\t");
                    _builder.append("\", listEObjects);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              if ((e instanceof RetypeObjectMutator)) {
                {
                  if (((((RetypeObjectMutator)e).getObject() instanceof SpecificObjectSelection) || (((RetypeObjectMutator)e).getObject() instanceof RandomTypeSelection))) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("hashmapEObject.put(\"");
                    String _name_30 = ((RetypeObjectMutator)e).getName();
                    _builder.append(_name_30, "\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  ObSelectionStrategy _object_5 = ((RetypeObjectMutator)e).getObject();
                  if ((_object_5 instanceof CompleteTypeSelection)) {
                    _builder.append("\t\t");
                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("if (hashmapList.get(\"");
                    String _name_31 = ((RetypeObjectMutator)e).getName();
                    _builder.append(_name_31, "\t\t");
                    _builder.append("\") != null) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = hashmapList.get(\"");
                    String _name_32 = ((RetypeObjectMutator)e).getName();
                    _builder.append(_name_32, "\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("listEObjects.add(entry);");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("hashmapList.put(\"");
                    String _name_33 = ((RetypeObjectMutator)e).getName();
                    _builder.append(_name_33, "\t\t");
                    _builder.append("\", listEObjects);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    {
      String _name_34 = e.getName();
      boolean _tripleNotEquals_4 = (_name_34 != null);
      if (_tripleNotEquals_4) {
        {
          if ((e instanceof SelectSampleMutator)) {
            _builder.append("\t\t");
            _builder.append("if (mutated instanceof List<?>) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (hashmapList.get(\"");
            String _name_35 = ((SelectSampleMutator)e).getName();
            _builder.append(_name_35, "\t\t\t");
            _builder.append("\") != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("listEObjects = hashmapList.get(\"");
            String _name_36 = ((SelectSampleMutator)e).getName();
            _builder.append(_name_36, "\t\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(EMFCopier.clone(mut.getModel()), mut.getMetaModel());");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("listEObjects.add(entry);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("hashmapList.put(\"");
            String _name_37 = ((SelectSampleMutator)e).getName();
            _builder.append(_name_37, "\t\t\t");
            _builder.append("\", listEObjects);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    {
      if ((((e instanceof SelectObjectMutator) == false) && ((e instanceof SelectSampleMutator) == false))) {
        _builder.append("\t\t");
        _builder.append("String mutatorPath = mutPath + \"/Output\" + i + \"_\" + j + \"_\" + k[0] + \"_");
        _builder.append(this.nMethod, "\t\t");
        _builder.append(".model\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("ModelManager.saveOutModel(model, mutatorPath);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (mutPaths.contains(mutatorPath) == false) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("mutPaths.add(mutatorPath);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("AppMutation appMut = ");
    _builder.append(this.registryMethodName, "\t\t");
    _builder.append("(mut, hmMutator, seed, mutPaths, packages);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (appMut != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("muts.getMuts().add(appMut);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
