package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.dsls.WodelUtils;
import wodel.utils.manager.JavaUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (standalone mode).
 */
@SuppressWarnings("all")
public class WodelStandaloneMutatorGenerator extends WodelMutatorGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.standalone = true;
    String _xifexpression = null;
    IProject _project = ProjectUtils.getProject();
    boolean _tripleNotEquals = (_project != null);
    if (_tripleNotEquals) {
      String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
      _xifexpression = (_path + "/");
    } else {
      String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
      _xifexpression = (_workspaceAbsolutePath + "/");
    }
    String projectFolderName = _xifexpression;
    File projectFolder = new File(projectFolderName);
    File[] files = projectFolder.listFiles();
    MutatorEnvironment mutatorEnvironment = null;
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String xTextFileName = this.getMutatorPath(e, files);
        String _workspaceAbsolutePathWithProjectName = ModelManager.getWorkspaceAbsolutePathWithProjectName();
        String _plus = ("file:/" + _workspaceAbsolutePathWithProjectName);
        String _plus_1 = (_plus + "/");
        String _output = this.program.getOutput();
        String _plus_2 = (_plus_1 + _output);
        String _replaceAll = this.fileName.replaceAll(".mutator", ".model");
        String xmiFileName = (_plus_2 + _replaceAll);
        WodelUtils.serialize(xTextFileName, xmiFileName);
        String _replaceAll_1 = this.fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _plus_3 = (_replaceAll_1 + ".mutator");
        this.fileName = _plus_3;
        this.fileName = this.fileName.replaceAll(".mutator", "Standalone.java");
        this.className = this.fileName.replaceAll("Standalone.java", "Standalone");
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
    String _plus = ("mutator/" + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _replaceAll_1 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "StandaloneLauncher.java");
    boolean _isFile = fsa.isFile(_plus_3);
    if (_isFile) {
      String _replaceAll_2 = this.getProjectName().replaceAll("[.]", "/");
      String _plus_4 = ("mutator/" + _replaceAll_2);
      String _plus_5 = (_plus_4 + "/");
      String _replaceAll_3 = this.getProjectName().replaceAll("[.]", "_");
      String _plus_6 = (_plus_5 + _replaceAll_3);
      String _plus_7 = (_plus_6 + "StandaloneLauncher.java");
      fsa.deleteFile(_plus_7);
    }
    String _replaceAll_4 = this.getProjectName().replaceAll("[.]", "/");
    String _plus_8 = ("mutator/" + _replaceAll_4);
    String _plus_9 = (_plus_8 + "/");
    String _replaceAll_5 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_10 = (_plus_9 + _replaceAll_5);
    String _plus_11 = (_plus_10 + "StandaloneLauncher.java");
    fsa.generateFile(_plus_11, JavaUtils.format(this.launcher(mutatorEnvironment, mutators), false));
  }
}
