package wodel.dsls.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import manager.ModelManager;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;

@SuppressWarnings("all")
public abstract class WodelAPIGenerator extends AbstractGenerator {
  protected String fileName;
  
  protected Program program;
  
  protected IProject project = null;
  
  protected String path;
  
  protected String xmiFileName;
  
  protected String className = "";
  
  protected Map<String, List<String>> mutMap = new HashMap<String, List<String>>();
  
  protected boolean standalone = false;
  
  public List<String> getMutators(final File[] files) {
    List<String> mutators = new ArrayList<String>();
    if ((files != null)) {
      for (final File file : files) {
        if ((file != null)) {
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
        }
      }
    }
    return mutators;
  }
  
  public String getMutatorPath(final File[] files) {
    String mutatorPath = null;
    if (((mutatorPath == null) && (files != null))) {
      for (final File file : files) {
        {
          if ((mutatorPath != null)) {
            return mutatorPath;
          }
          if ((file != null)) {
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
          }
        }
      }
    }
    return mutatorPath;
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
    {
      if ((this.standalone == false)) {
        _builder.append("import mutator.");
        _builder.append(mutatorName);
        _builder.append("Dynamic.");
        _builder.append(mutatorName);
        _builder.append("Dynamic;");
        _builder.newLineIfNotEmpty();
        _builder.append("import manager.MutatorAPI;");
        _builder.newLine();
      } else {
        _builder.append("import mutator.");
        _builder.append(mutatorName);
        _builder.append("Standalone.");
        _builder.append(mutatorName);
        _builder.append("Standalone;");
        _builder.newLineIfNotEmpty();
        _builder.append("import org.eclipse.core.runtime.NullProgressMonitor;");
        _builder.newLine();
        _builder.append("import manager.MutatorStandaloneAPI;");
        _builder.newLine();
      }
    }
    _builder.append("import manager.MutatorUtils;");
    _builder.newLine();
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("public class ");
        _builder.append(className);
        _builder.append(" extends MutatorAPI {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void createMutants(String[] mutationOperators, IProject project, IProgressMonitor monitor)");
        _builder.newLine();
        _builder.append("\t \t");
        _builder.append("throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
        _builder.newLine();
      } else {
        _builder.append("public class ");
        _builder.append(className);
        _builder.append(" extends MutatorStandaloneAPI {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void createMutants(String[] mutationOperators)");
        _builder.newLine();
        _builder.append("\t \t");
        _builder.append("throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {");
        _builder.newLine();
      }
    }
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
    _builder.append("String ecoreURI = \"");
    String _metaModel = ModelManager.getMetaModel();
    _builder.append(_metaModel, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<EPackage> packages = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("\t\t\t");
        _builder.append("packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("packages = ModelManager.loadMetaModel(ecoreURI, ");
        _builder.append(className, "\t\t\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    }
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
    _builder.newLine();
    {
      if ((this.standalone == false)) {
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
        _builder.append("MutatorUtils mut");
        _builder.append(mutatorName, "\t\t");
        _builder.append(" = new ");
        _builder.append(mutatorName, "\t\t");
        _builder.append("Dynamic();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mut");
        _builder.append(mutatorName, "\t\t");
        _builder.append(".execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, project, monitor, true, null, new TreeMap<String, List<String>>());");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("boolean metrics = false;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("boolean debugMetrics = false;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("MutatorUtils mut");
        _builder.append(mutatorName, "\t\t");
        _builder.append(" = new ");
        _builder.append(mutatorName, "\t\t");
        _builder.append("Standalone();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mut");
        _builder.append(mutatorName, "\t\t");
        _builder.append(".execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, new NullProgressMonitor(), true, null, new TreeMap<String, List<String>>());");
        _builder.newLineIfNotEmpty();
      }
    }
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
    _builder.append("\t\t");
    _builder.newLine();
    {
      if ((this.standalone == true)) {
        _builder.append("\t\t");
        _builder.append("System.out.println(\"");
        _builder.append(mutatorName, "\t\t");
        _builder.append(" Mutant generation process finished.\");");
        _builder.newLineIfNotEmpty();
      }
    }
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
    {
      if ((this.standalone == false)) {
        _builder.append("import manager.MutatorAPILauncher;");
        _builder.newLine();
      } else {
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
        _builder.append("import java.io.IOException;");
        _builder.newLine();
        _builder.append("import java.io.File;");
        _builder.newLine();
        _builder.append("import manager.IOUtils;");
        _builder.newLine();
        _builder.append("import manager.MutatorUtils;");
        _builder.newLine();
        {
          for(final String mutator : mutators) {
            _builder.append("import mutator.");
            _builder.append(mutator);
            _builder.append(".");
            _builder.append(mutator);
            _builder.append("StandaloneAPI;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      if ((this.standalone == false)) {
        _builder.append("public class ");
        String _replaceAll = this.project.getName().replaceAll("[.]", "_");
        _builder.append(_replaceAll);
        _builder.append("DynamicAPILauncher {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public static void main(String[] args) ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
      } else {
        _builder.append("public class ");
        String _replaceAll_1 = this.project.getName().replaceAll("[.]", "_");
        _builder.append(_replaceAll_1);
        _builder.append("StandaloneAPILauncher {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public static void createMutants(String inputFolder, String outputFolder) throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String ecoreURI = \"");
    String _metaModel = ModelManager.getMetaModel();
    _builder.append(_metaModel, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<String> mutatorNames = new ArrayList<String>();");
    _builder.newLine();
    {
      Set<String> _keySet = this.mutMap.keySet();
      for(final String mutatorName : _keySet) {
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
      Set<String> _keySet_1 = this.mutMap.keySet();
      for(final String mut : _keySet_1) {
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
    {
      if ((this.standalone == false)) {
        _builder.append("\t\t");
        _builder.append("MutatorAPILauncher.createMutants(\"");
        String _name_1 = this.project.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\", ecoreURI, ");
        String _replaceAll_2 = this.project.getName().replaceAll("[.]", "_");
        _builder.append(_replaceAll_2, "\t\t");
        _builder.append("APILauncher.class, arrMutatorNames, arrOperatorNames, \"D:\\\\seed\", \"D:\\\\mutants\");");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("String inputWodelFolder = \"");
        String _modelsFolder = ModelManager.getModelsFolder();
        _builder.append(_modelsFolder, "\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("IOUtils.deleteFolder(inputWodelFolder, \"model\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("File seedWodelFolder = new File(inputWodelFolder);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("File inputCustomizedFolder = new File(inputFolder);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("IOUtils.copyFolder(inputCustomizedFolder, seedWodelFolder, \"model\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} catch (IOException e1) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("e1.printStackTrace();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("File projectFolder = new File(\"");
        String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
        _builder.append(_workspaceAbsolutePath, "\t\t");
        _builder.append("/");
        String _name_2 = this.project.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("String outputWodelFolder = \"");
        String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath();
        _builder.append(_workspaceAbsolutePath_1, "\t\t");
        _builder.append("/");
        String _name_3 = this.project.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("/");
        String _outputFolder = ModelManager.getOutputFolder();
        _builder.append(_outputFolder, "\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("// clean-up output folder preserving xtext auto generated models");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("IOUtils.deleteFolder(outputWodelFolder, \"model\", mutatorList);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("i = 0;");
        _builder.newLine();
        {
          Set<String> _keySet_2 = this.mutMap.keySet();
          for(final String mutatorName_1 : _keySet_2) {
            _builder.append("\t\t");
            _builder.append(mutatorName_1, "\t\t");
            _builder.append("StandaloneAPI.createMutants(arrOperatorNames[i]);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("i++;");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("File mutantWodelFolder = new File(outputWodelFolder);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("File outputCustomizedFolder = new File(outputFolder);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("IOUtils.copyFolder(mutantWodelFolder, outputCustomizedFolder, \"model\", mutatorList);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} catch (IOException e1) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("e1.printStackTrace();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Complete mutant generation process finished.\");");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      if ((this.standalone == true)) {
        _builder.append("\t");
        _builder.append("public static void main(String[] args) throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (args.length != 2) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Use: args[0] = inputFolder; args[1] = outputFolder\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("createMutants(args[0], args[1]);");
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
}
