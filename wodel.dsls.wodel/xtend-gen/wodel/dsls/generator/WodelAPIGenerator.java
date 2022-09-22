package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import manager.JavaUtils;
import manager.ModelManager;
import manager.ProjectUtils;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.dsls.WodelUtils;

@SuppressWarnings("all")
public class WodelAPIGenerator extends AbstractGenerator {
  private String fileName;
  
  private Program program;
  
  private IProject project = null;
  
  private String path;
  
  private String xmiFileName;
  
  private Map<String, List<String>> mutMap = new HashMap<String, List<String>>();
  
  public List<String> getMutators(final File[] files) {
    List<String> mutators = new ArrayList<String>();
    int i = 0;
    while (((files != null) && (i < ((List<File>)Conversions.doWrapArray(files)).size()))) {
      {
        File file = files[i];
        boolean _isFile = file.isFile();
        boolean _equals = (_isFile == true);
        if (_equals) {
          boolean _endsWith = file.getName().endsWith(".mutator");
          if (_endsWith) {
            String mutator = file.getName().replaceAll(".mutator", "");
            boolean _contains = mutators.contains(mutator);
            boolean _not = (!_contains);
            if (_not) {
              mutators.add(mutator);
            }
          }
        } else {
          boolean _isDirectory = file.isDirectory();
          boolean _equals_1 = (_isDirectory == true);
          if (_equals_1) {
            List<String> nextMutators = new ArrayList<String>();
            nextMutators.addAll(this.getMutators(file.listFiles()));
            for (final String nextMutator : nextMutators) {
              boolean _contains_1 = mutators.contains(nextMutator);
              boolean _not_1 = (!_contains_1);
              if (_not_1) {
                mutators.add(nextMutator);
              }
            }
          }
        }
        i++;
      }
    }
    return mutators;
  }
  
  public String getMutatorPath(final File[] files) {
    String mutatorPath = null;
    int i = 0;
    while ((((mutatorPath == null) && (files != null)) && (i < ((List<File>)Conversions.doWrapArray(files)).size()))) {
      {
        File file = files[i];
        boolean _isFile = file.isFile();
        boolean _equals = (_isFile == true);
        if (_equals) {
          boolean _equals_1 = file.getName().equals(this.fileName);
          if (_equals_1) {
            String mutatorFolderAndFile = file.getPath().substring(file.getPath().indexOf(this.project.getName())).replace("\\", "/");
            String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
            String _plus = ("file:/" + _workspaceAbsolutePath);
            String _plus_1 = (_plus + "/");
            String _plus_2 = (_plus_1 + mutatorFolderAndFile);
            mutatorPath = _plus_2;
          }
        } else {
          mutatorPath = this.getMutatorPath(file.listFiles());
        }
        i++;
      }
    }
    return mutatorPath;
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    ProjectUtils.resetProject();
    this.project = ProjectUtils.getProject();
    String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
    String _plus = (_workspaceAbsolutePath + "/");
    String _name = this.project.getName();
    String _plus_1 = (_plus + _name);
    this.path = _plus_1;
    String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath();
    String _plus_2 = (_workspaceAbsolutePath_1 + "/");
    String _name_1 = this.project.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String projectFolderName = (_plus_3 + "/");
    File projectFolder = new File(projectFolderName);
    File[] files = projectFolder.listFiles();
    String className = "";
    String mutatorName = "";
    MutatorEnvironment mutatorEnvironment = null;
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        String xTextFileName = this.getMutatorPath(files);
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _workspaceAbsolutePath_2 = ModelManager.getWorkspaceAbsolutePath();
        String _plus_4 = ("file:/" + _workspaceAbsolutePath_2);
        String _plus_5 = (_plus_4 + "/");
        String _name_2 = this.project.getName();
        String _plus_6 = (_plus_5 + _name_2);
        String _plus_7 = (_plus_6 + "/");
        String _output = this.program.getOutput();
        String _plus_8 = (_plus_7 + _output);
        String _replaceAll = this.fileName.replaceAll(".mutator", ".model");
        String _plus_9 = (_plus_8 + _replaceAll);
        this.xmiFileName = _plus_9;
        WodelUtils.serialize(xTextFileName, this.xmiFileName);
        String _replaceAll_1 = this.fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _plus_10 = (_replaceAll_1 + ".mutator");
        this.fileName = _plus_10;
        mutatorName = this.fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _replaceAll_2 = mutatorName.replaceAll("[.]", "_");
        String _plus_11 = (_replaceAll_2 + "API.java");
        this.fileName = _plus_11;
        className = this.fileName.replaceAll(".java", "");
        int i = 1;
        String key = className.replace("API", "");
        EList<Block> _blocks = e.getBlocks();
        for (final Block b : _blocks) {
          {
            List<String> values = new ArrayList<String>();
            boolean _contains = this.mutMap.keySet().contains(key);
            if (_contains) {
              values = this.mutMap.get(key);
            }
            if ((((b.getName() != null) && (!b.getName().isEmpty())) && (!values.contains(b.getName())))) {
              values.add(b.getName());
            }
            this.mutMap.put(key, values);
          }
        }
        boolean _isFile = fsa.isFile(((("mutator/" + mutatorName) + "/") + this.fileName));
        if (_isFile) {
          fsa.deleteFile(((("mutator/" + mutatorName) + "/") + this.fileName));
        }
        fsa.generateFile(((("mutator/" + mutatorName) + "/") + this.fileName), JavaUtils.format(this.compile(e, mutatorName, className), false));
        mutatorEnvironment = e;
      }
    }
  }
  
  public CharSequence compile(final MutatorEnvironment e, final String mutatorName, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mutator.");
    _builder.append(mutatorName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.TreeMap;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.resources.IProject;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.IProgressMonitor;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EPackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import exceptions.AbstractCreationException;");
    _builder.newLine();
    _builder.append("import exceptions.MaxSmallerThanMinException;");
    _builder.newLine();
    _builder.append("import exceptions.MetaModelNotFoundException;");
    _builder.newLine();
    _builder.append("import exceptions.ModelNotFoundException;");
    _builder.newLine();
    _builder.append("import exceptions.ObjectNoTargetableException;");
    _builder.newLine();
    _builder.append("import exceptions.ObjectNotContainedException;");
    _builder.newLine();
    _builder.append("import exceptions.ReferenceNonExistingException;");
    _builder.newLine();
    _builder.append("import exceptions.WrongAttributeTypeException;");
    _builder.newLine();
    _builder.append("import manager.ModelManager;");
    _builder.newLine();
    _builder.append("import manager.MutatorAPI;");
    _builder.newLine();
    _builder.append("import manager.MutatorUtils;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className);
    _builder.append(" extends MutatorAPI {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void createMutants(String[] mutationOperators, IProject project, IProgressMonitor monitor)");
    _builder.newLine();
    _builder.append("\t \t");
    _builder.append("throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"Wodel mutator file: ");
    _builder.append(mutatorName, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String ecoreURI = ModelManager.getMetaModel();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<EPackage> packages = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean isRegistered = ModelManager.isRegistered(packages);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map<String, EPackage> registeredPackages = ModelManager.registeredMetaModels(packages);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map<String, EPackage> localRegisteredPackages = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (isRegistered == true) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (registeredPackages != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("List<EPackage> packageList = new ArrayList<EPackage>();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("packageList.addAll(registeredPackages.values());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ModelManager.unregisterMetaModel(packageList);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("localRegisteredPackages = ModelManager.unregisterMetaModel(packages);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int maxAttempts = ");
    int _parseInt = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "0", null));
    _builder.append(_parseInt, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("int numMutants = ");
    int _parseInt_1 = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null));
    _builder.append(_parseInt_1, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("boolean registry = ");
    boolean _boolean = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", false, null);
    _builder.append(_boolean, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("boolean metrics = ");
    boolean _boolean_1 = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null);
    _builder.append(_boolean_1, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("boolean debugMetrics = ");
    boolean _boolean_2 = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null);
    _builder.append(_boolean_2, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MutatorUtils mut");
    _builder.append(mutatorName, "\t\t");
    _builder.append(" = new ");
    _builder.append(mutatorName, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("mut");
    _builder.append(mutatorName, "\t\t");
    _builder.append(".execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, project, monitor, true, null, new TreeMap<String, List<String>>());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (isRegistered == true) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ModelManager.registerMetaModel(localRegisteredPackages);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (registeredPackages != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ModelManager.registerMetaModel(registeredPackages);");
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
    return _builder;
  }
  
  public CharSequence launcher(final MutatorEnvironment e, final List<String> mutators) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("package mutator.");
    String _name = this.project.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import manager.MutatorAPILauncher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _replaceAll = this.project.getName().replaceAll("[.]", "_");
    _builder.append(_replaceAll);
    _builder.append("APILauncher {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String ecoreURI = null;");
    _builder.newLine();
    {
      Definition _definition = e.getDefinition();
      if ((_definition instanceof Program)) {
        _builder.append("\t\t");
        _builder.append("ecoreURI = \"");
        String _metamodel = e.getDefinition().getMetamodel();
        _builder.append(_metamodel, "\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("List<String> mutatorNames = new ArrayList<String>();");
    _builder.newLine();
    {
      for(final String mutatorName : mutators) {
        _builder.append("\t\t");
        _builder.append("mutatorNames.add(\"");
        _builder.append(mutatorName, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("List<List<String>> operatorNames = new ArrayList<List<String>>();");
    _builder.newLine();
    {
      Set<String> _keySet = this.mutMap.keySet();
      for(final String mut : _keySet) {
        _builder.append("\t\t");
        _builder.append("List<String> mutatorOperatorNames");
        _builder.append(mut, "\t\t");
        _builder.append(" = new ArrayList<String>();");
        _builder.newLineIfNotEmpty();
        {
          List<String> _get = this.mutMap.get(mut);
          for(final String operator : _get) {
            _builder.append("\t\t");
            _builder.append("mutatorOperatorNames");
            _builder.append(mut, "\t\t");
            _builder.append(".add(\"");
            _builder.append(operator, "\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("operatorNames.add(mutatorOperatorNames");
        _builder.append(mut, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("String[] arrMutatorNames = new String[mutatorNames.size()];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mutatorNames.toArray(arrMutatorNames);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String[][] arrOperatorNames = new String[mutatorNames.size()][];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (List<String> mutOpNames : operatorNames) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String[] arrMutatorOperatorNames = new String[mutOpNames.size()];");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("mutOpNames.toArray(arrMutatorOperatorNames);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("arrOperatorNames[i] = arrMutatorOperatorNames;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MutatorAPILauncher.createMutants(\"");
    String _name_1 = this.project.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append("\", ecoreURI, ");
    String _replaceAll_1 = this.project.getName().replaceAll("[.]", "_");
    _builder.append(_replaceAll_1, "\t\t");
    _builder.append("APILauncher.class, arrMutatorNames, arrOperatorNames, \"D:\\\\seed\", \"D:\\\\mutants\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
