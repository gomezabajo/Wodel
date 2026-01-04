package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  private Map<String, List<String>> mutMap = new LinkedHashMap<String, List<String>>();

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.standalone = true;
    IProject project = ProjectUtils.getProject();
    IProject _xifexpression = null;
    if ((project != null)) {
      _xifexpression = project;
    } else {
      _xifexpression = this.project;
    }
    this.project = _xifexpression;
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
    String mutatorName = "";
    MutatorEnvironment mutatorEnvironment = null;
    this.fileURI = resource.getURI();
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _replaceAll = this.fileURI.lastSegment().replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String fileName = (_replaceAll + ".mutator");
        mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _replaceAll_1 = mutatorName.replaceAll("[.]", "_");
        String _plus = (_replaceAll_1 + "StandaloneAPI.java");
        fileName = _plus;
        this.className = fileName.replaceAll(".java", "");
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
        boolean _isFile = fsa.isFile(((("mutator/" + mutatorName) + "/") + fileName));
        if (_isFile) {
          fsa.deleteFile(((("mutator/" + mutatorName) + "/") + fileName));
        }
        fsa.generateFile(((("mutator/" + mutatorName) + "/") + fileName), JavaUtils.format(this.compile(e, project, mutatorName, this.className), false));
        mutatorEnvironment = e;
      }
    }
    String _replaceAll = project.getName().replaceAll("[.]", "/");
    String _plus = ("mutator/" + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _replaceAll_1 = project.getName().replaceAll("[.]", "_");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "StandaloneAPILauncher.java");
    boolean _isFile = fsa.isFile(_plus_3);
    if (_isFile) {
      String _replaceAll_2 = project.getName().replaceAll("[.]", "/");
      String _plus_4 = ("mutator/" + _replaceAll_2);
      String _plus_5 = (_plus_4 + "/");
      String _replaceAll_3 = project.getName().replaceAll("[.]", "_");
      String _plus_6 = (_plus_5 + _replaceAll_3);
      String _plus_7 = (_plus_6 + "StandaloneAPILauncher.java");
      fsa.deleteFile(_plus_7);
    }
    String _replaceAll_4 = project.getName().replaceAll("[.]", "/");
    String _plus_8 = ("mutator/" + _replaceAll_4);
    String _plus_9 = (_plus_8 + "/");
    String _replaceAll_5 = project.getName().replaceAll("[.]", "_");
    String _plus_10 = (_plus_9 + _replaceAll_5);
    String _plus_11 = (_plus_10 + "StandaloneAPILauncher.java");
    fsa.generateFile(_plus_11, JavaUtils.format(this.launcherStandalone(IterableExtensions.<MutatorEnvironment>toList(Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class)), this.project, this.mutMap), false));
  }
}
