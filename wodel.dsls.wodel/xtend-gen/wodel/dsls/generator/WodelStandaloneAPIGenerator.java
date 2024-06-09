package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.utils.manager.JavaUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (standalone mode).
 */
@SuppressWarnings("all")
public class WodelStandaloneAPIGenerator extends WodelAPIGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    ProjectUtils.resetProject();
    this.project = ProjectUtils.getProject();
    this.standalone = true;
    String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath(resource);
    String _plus = (_workspaceAbsolutePath + "/");
    String _projectName = this.getProjectName();
    String _plus_1 = (_plus + _projectName);
    String projectFolderName = (_plus_1 + "/");
    File projectFolder = new File(projectFolderName);
    File[] files = projectFolder.listFiles();
    String mutatorName = "";
    List<String> mutators = this.getMutators(files);
    MutatorEnvironment mutatorEnvironment = null;
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _replaceAll = this.fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _plus_2 = (_replaceAll + ".mutator");
        this.fileName = _plus_2;
        mutatorName = this.fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _replaceAll_1 = mutatorName.replaceAll("[.]", "_");
        String _plus_3 = (_replaceAll_1 + "StandaloneAPI.java");
        this.fileName = _plus_3;
        this.className = this.fileName.replaceAll(".java", "");
        int i = 1;
        String key = this.className.replace("StandaloneAPI", "");
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
        fsa.generateFile(((("mutator/" + mutatorName) + "/") + this.fileName), JavaUtils.format(this.compile(e, mutatorName, this.className), false));
        mutatorEnvironment = e;
      }
    }
    String _replaceAll = this.getProjectName().replaceAll("[.]", "/");
    String _plus_2 = ("mutator/" + _replaceAll);
    String _plus_3 = (_plus_2 + "/");
    String _replaceAll_1 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_4 = (_plus_3 + _replaceAll_1);
    String _plus_5 = (_plus_4 + "StandaloneAPILauncher.java");
    boolean _isFile = fsa.isFile(_plus_5);
    if (_isFile) {
      String _replaceAll_2 = this.getProjectName().replaceAll("[.]", "/");
      String _plus_6 = ("mutator/" + _replaceAll_2);
      String _plus_7 = (_plus_6 + "/");
      String _replaceAll_3 = this.getProjectName().replaceAll("[.]", "_");
      String _plus_8 = (_plus_7 + _replaceAll_3);
      String _plus_9 = (_plus_8 + "StandaloneAPILauncher.java");
      fsa.deleteFile(_plus_9);
    }
    String _replaceAll_4 = this.getProjectName().replaceAll("[.]", "/");
    String _plus_10 = ("mutator/" + _replaceAll_4);
    String _plus_11 = (_plus_10 + "/");
    String _replaceAll_5 = this.getProjectName().replaceAll("[.]", "_");
    String _plus_12 = (_plus_11 + _replaceAll_5);
    String _plus_13 = (_plus_12 + "StandaloneAPILauncher.java");
    fsa.generateFile(_plus_13, JavaUtils.format(this.launcher(mutatorEnvironment, mutators), false));
  }
}
