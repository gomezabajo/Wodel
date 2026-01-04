package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      this.standalone = false;
      IProject project = WodelDynamicMutatorGenerator.projectOf(resource);
      IProject _xifexpression = null;
      if ((project != null)) {
        _xifexpression = project;
      } else {
        _xifexpression = ProjectUtils.getProject();
      }
      this.project = _xifexpression;
      this.standalone = false;
      String _xifexpression_1 = null;
      if ((this.project != null)) {
        String _replace = this.project.getLocation().toFile().getPath().replace("\\", "/");
        _xifexpression_1 = (_replace + "/");
      } else {
        String _workspaceAbsolutePathWithProjectName = ModelManager.getWorkspaceAbsolutePathWithProjectName();
        _xifexpression_1 = (_workspaceAbsolutePathWithProjectName + "/");
      }
      String projectFolderName = _xifexpression_1;
      File projectFolder = new File(projectFolderName);
      File[] files = projectFolder.listFiles();
      MutatorEnvironment mutatorEnvironment = null;
      this.fileURI = resource.getURI();
      Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
      for (final MutatorEnvironment e : _filter) {
        {
          Definition _definition = ((MutatorEnvironment) e).getDefinition();
          this.program = ((Program) _definition);
          String _replaceAll = this.fileURI.lastSegment().replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
          String fileName = (_replaceAll + ".mutator");
          fileName = fileName.replace(".mutator", "Dynamic.java");
          this.className = fileName.replace("Dynamic.java", "Dynamic");
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
          fsa.generateFile(((("mutator/" + this.className) + "/") + fileName), JavaUtils.format(this.compile(e, this.project), false));
          mutatorEnvironment = e;
        }
      }
      final Function1<IFile, String> _function = (IFile it) -> {
        return it.getName().replace(".mutator", "");
      };
      List<String> mutators = ListExtensions.<IFile, String>map(ProjectUtils.getMutatorFiles(this.project), _function);
      String _replaceAll = this.project.getName().replaceAll("[.]", "/");
      String _plus = ("mutator/" + _replaceAll);
      String _plus_1 = (_plus + "/");
      String _replaceAll_1 = this.project.getName().replaceAll("[.]", "_");
      String _plus_2 = (_plus_1 + _replaceAll_1);
      String _plus_3 = (_plus_2 + "DynamicLauncher.java");
      boolean _isFile = fsa.isFile(_plus_3);
      if (_isFile) {
        String _replaceAll_2 = this.project.getName().replaceAll("[.]", "/");
        String _plus_4 = ("mutator/" + _replaceAll_2);
        String _plus_5 = (_plus_4 + "/");
        String _replaceAll_3 = this.project.getName().replaceAll("[.]", "_");
        String _plus_6 = (_plus_5 + _replaceAll_3);
        String _plus_7 = (_plus_6 + "DynamicLauncher.java");
        fsa.deleteFile(_plus_7);
      }
      String _replaceAll_4 = this.project.getName().replaceAll("[.]", "/");
      String _plus_8 = ("mutator/" + _replaceAll_4);
      String _plus_9 = (_plus_8 + "/");
      String _replaceAll_5 = this.project.getName().replaceAll("[.]", "_");
      String _plus_10 = (_plus_9 + _replaceAll_5);
      String _plus_11 = (_plus_10 + "DynamicLauncher.java");
      fsa.generateFile(_plus_11, JavaUtils.format(this.launcherDynamic(mutatorEnvironment, this.project, mutators), false));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
