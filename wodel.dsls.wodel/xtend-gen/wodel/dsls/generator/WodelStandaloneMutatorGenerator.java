package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import wodel.dsls.runner.WodelUtils;
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
    try {
      this.standalone = true;
      IProject project = WodelMutatorGenerator.projectOf(resource);
      IProject _xifexpression = null;
      if ((project != null)) {
        _xifexpression = project;
      } else {
        _xifexpression = ProjectUtils.getProject();
      }
      project = _xifexpression;
      IProject _xifexpression_1 = null;
      if ((project != null)) {
        _xifexpression_1 = project;
      } else {
        _xifexpression_1 = this.project;
      }
      this.project = _xifexpression_1;
      if ((this.project == null)) {
        throw new IllegalStateException(
          ("Cannot determine the Wodel project for headless generation. " + 
            "Use a platform:/resource URI or run with an Eclipse workspace containing the project."));
      }
      project = this.project;
      String _xifexpression_2 = null;
      if ((this.project != null)) {
        String _replace = this.project.getLocation().toFile().getPath().replace("\\", "/");
        _xifexpression_2 = (_replace + "/");
      } else {
        String _workspaceAbsolutePathWithProjectName = ModelManager.getWorkspaceAbsolutePathWithProjectName();
        _xifexpression_2 = (_workspaceAbsolutePathWithProjectName + "/");
      }
      String projectFolderName = _xifexpression_2;
      this.fileURI = resource.getURI();
      final Function1<MutatorEnvironment, Boolean> _function = (MutatorEnvironment it) -> {
        Definition _definition = it.getDefinition();
        return Boolean.valueOf((_definition instanceof Program));
      };
      Iterable<MutatorEnvironment> _filter = IterableExtensions.<MutatorEnvironment>filter(Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class), _function);
      for (final MutatorEnvironment e : _filter) {
        {
          Definition _definition = ((MutatorEnvironment) e).getDefinition();
          this.program = ((Program) _definition);
          String mutatorName = this.fileURI.lastSegment().replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
          String fileName = (mutatorName + ".mutator");
          fileName = (mutatorName + "Standalone.java");
          this.className = (mutatorName + "Standalone");
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
          boolean _isFile = fsa.isFile(((("mutator/" + this.className) + "/") + fileName));
          if (_isFile) {
            fsa.deleteFile(((("mutator/" + this.className) + "/") + fileName));
          }
          fsa.generateFile(((("mutator/" + this.className) + "/") + fileName), JavaUtils.format(this.compile(e, this.project, mutatorName), false));
        }
      }
      String _replaceAll = this.project.getName().replaceAll("[.]", "/");
      String _plus = ("mutator/" + _replaceAll);
      String _plus_1 = (_plus + "/");
      String _replaceAll_1 = this.project.getName().replaceAll("[.]", "_");
      String _plus_2 = (_plus_1 + _replaceAll_1);
      String _plus_3 = (_plus_2 + "StandaloneLauncher.java");
      boolean _isFile = fsa.isFile(_plus_3);
      if (_isFile) {
        String _replaceAll_2 = this.project.getName().replaceAll("[.]", "/");
        String _plus_4 = ("mutator/" + _replaceAll_2);
        String _plus_5 = (_plus_4 + "/");
        String _replaceAll_3 = this.project.getName().replaceAll("[.]", "_");
        String _plus_6 = (_plus_5 + _replaceAll_3);
        String _plus_7 = (_plus_6 + "StandaloneLauncher.java");
        fsa.deleteFile(_plus_7);
      }
      final Function1<IFile, String> _function_1 = (IFile it) -> {
        return it.getName().replace(".mutator", "");
      };
      List<String> mutators = ListExtensions.<IFile, String>map(WodelUtils.getMutatorFiles(this.project), _function_1);
      String _replaceAll_4 = this.project.getName().replaceAll("[.]", "/");
      String _plus_8 = ("mutator/" + _replaceAll_4);
      String _plus_9 = (_plus_8 + "/");
      String _replaceAll_5 = this.project.getName().replaceAll("[.]", "_");
      String _plus_10 = (_plus_9 + _replaceAll_5);
      String _plus_11 = (_plus_10 + "StandaloneLauncher.java");
      final Function1<MutatorEnvironment, Boolean> _function_2 = (MutatorEnvironment it) -> {
        Definition _definition = it.getDefinition();
        return Boolean.valueOf((_definition instanceof Program));
      };
      fsa.generateFile(_plus_11, JavaUtils.format(this.launcher(IterableExtensions.<MutatorEnvironment>toList(IterableExtensions.<MutatorEnvironment>filter(Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class), _function_2)), this.project, mutators), false));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
