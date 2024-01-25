package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.dsls.WodelUtils;
import wodel.utils.manager.JavaUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (dynamic mode).
 */
@SuppressWarnings("all")
public class WodelDynamicMutatorGenerator extends WodelMutatorGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    ProjectUtils.resetProject();
    this.project = ProjectUtils.getProject();
    String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath(resource);
    String _plus = (_workspaceAbsolutePath + "/");
    String _projectName = this.getProjectName();
    String _plus_1 = (_plus + _projectName);
    this.path = _plus_1;
    this.standalone = false;
    try {
      this.bundle = Platform.getBundle("wodel.models");
      String _file = FileLocator.resolve(this.bundle.getEntry("/model/MutatorMetrics.ecore")).getFile();
      String _plus_2 = ("file:" + _file);
      this.metricsURL = URI.createURI(_plus_2).toFileString().replace("\\", "/");
      String _file_1 = FileLocator.resolve(this.bundle.getEntry("/model/MutatorEnvironment.ecore")).getFile();
      String _plus_3 = ("file:" + _file_1);
      this.mutatorURL = URI.createURI(_plus_3).toFileString().replace("\\", "/");
      ModelManager.saveMetricsEnvironmentBundle(resource, this.metricsURL);
      ModelManager.saveMutatorEnvironmentBundle(resource, this.mutatorURL);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        String _metricsEnvironmentBundle = ModelManager.getMetricsEnvironmentBundle(resource);
        String _plus_4 = ("file:" + _metricsEnvironmentBundle);
        this.metricsURL = URI.createURI(_plus_4).toFileString().replace("\\", "/");
        String _mutatorEnvironmentBundle = ModelManager.getMutatorEnvironmentBundle(resource);
        String _plus_5 = ("file:" + _mutatorEnvironmentBundle);
        this.mutatorURL = URI.createURI(_plus_5).toFileString().replace("\\", "/");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath(resource);
    String _plus_2 = (_workspaceAbsolutePath_1 + "/");
    String _projectName_1 = this.getProjectName();
    String _plus_3 = (_plus_2 + _projectName_1);
    String projectFolderName = (_plus_3 + "/");
    File projectFolder = new File(projectFolderName);
    File[] files = projectFolder.listFiles();
    MutatorEnvironment mutatorEnvironment = null;
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        String xTextFileName = this.getMutatorPath(e, files);
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _workspaceAbsolutePath_2 = ModelManager.getWorkspaceAbsolutePath(resource);
        String _plus_4 = ("file:/" + _workspaceAbsolutePath_2);
        String _plus_5 = (_plus_4 + "/");
        String _projectName_2 = this.getProjectName();
        String _plus_6 = (_plus_5 + _projectName_2);
        String _plus_7 = (_plus_6 + "/");
        String _output = this.program.getOutput();
        String _plus_8 = (_plus_7 + _output);
        String _replaceAll = this.fileName.replaceAll(".mutator", ".model");
        String _plus_9 = (_plus_8 + _replaceAll);
        this.xmiFileName = _plus_9;
        try {
          WodelUtils.serialize(xTextFileName, this.xmiFileName);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        String _replaceAll_1 = this.fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _plus_10 = (_replaceAll_1 + ".mutator");
        this.fileName = _plus_10;
        this.fileName = this.fileName.replaceAll(".mutator", "Dynamic.java");
        this.className = this.fileName.replaceAll("Dynamic.java", "Dynamic");
        int i = 1;
        EList<Mutator> _commands = e.getCommands();
        for (final Mutator mut : _commands) {
          int _plusPlus = i++;
          this.mutIndexes.put(mut, Integer.valueOf(_plusPlus));
        }
        EList<Block> _blocks = e.getBlocks();
        for (final Block b : _blocks) {
          EList<Mutator> _commands_1 = b.getCommands();
          for (final Mutator mut_1 : _commands_1) {
            int _plusPlus_1 = i++;
            this.mutIndexes.put(mut_1, Integer.valueOf(_plusPlus_1));
          }
        }
        boolean _isFile = fsa.isFile(((("mutator/" + this.className) + "/") + this.fileName));
        if (_isFile) {
          fsa.deleteFile(((("mutator/" + this.className) + "/") + this.fileName));
        }
        fsa.generateFile(((("mutator/" + this.className) + "/") + this.fileName), JavaUtils.format(this.compile(e), false));
        mutatorEnvironment = e;
      }
    }
    List<String> mutators = this.getMutators(files);
    String _replaceAll = this.getProjectName().replaceAll("[.]", "/");
    String _plus_4 = ("mutator/" + _replaceAll);
    String _plus_5 = (_plus_4 + "/");
    String _replaceAll_1 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_6 = (_plus_5 + _replaceAll_1);
    String _plus_7 = (_plus_6 + "DynamicLauncher.java");
    boolean _isFile = fsa.isFile(_plus_7);
    if (_isFile) {
      String _replaceAll_2 = this.getProjectName().replaceAll("[.]", "/");
      String _plus_8 = ("mutator/" + _replaceAll_2);
      String _plus_9 = (_plus_8 + "/");
      String _replaceAll_3 = this.getProjectName().replaceAll("[.]", "_");
      String _plus_10 = (_plus_9 + _replaceAll_3);
      String _plus_11 = (_plus_10 + "DynamicLauncher.java");
      fsa.deleteFile(_plus_11);
    }
    String _replaceAll_4 = this.getProjectName().replaceAll("[.]", "/");
    String _plus_12 = ("mutator/" + _replaceAll_4);
    String _plus_13 = (_plus_12 + "/");
    String _replaceAll_5 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_14 = (_plus_13 + _replaceAll_5);
    String _plus_15 = (_plus_14 + "DynamicLauncher.java");
    fsa.generateFile(_plus_15, JavaUtils.format(this.launcher(mutatorEnvironment, mutators), false));
  }
}
