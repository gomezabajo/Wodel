package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.dsls.WodelUtils;
import wodel.utils.manager.JavaUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (dynamic mode).
 */
@SuppressWarnings("all")
public class WodelDynamicAPIGenerator extends WodelAPIGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.standalone = false;
    String _xifexpression = null;
    IProject _project = ProjectUtils.getProject();
    boolean _tripleNotEquals = (_project != null);
    if (_tripleNotEquals) {
      String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
      _xifexpression = (_path + "/");
    } else {
      String _workspaceAbsolutePathWithProjectName = ModelManager.getWorkspaceAbsolutePathWithProjectName();
      _xifexpression = (_workspaceAbsolutePathWithProjectName + "/");
    }
    String projectFolderName = _xifexpression;
    File projectFolder = new File(projectFolderName);
    File[] files = projectFolder.listFiles();
    String mutatorName = "";
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        String xTextFileName = this.getMutatorPath(e, files);
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _workspaceAbsolutePathWithProjectName_1 = ModelManager.getWorkspaceAbsolutePathWithProjectName();
        String _plus = ("file:/" + _workspaceAbsolutePathWithProjectName_1);
        String _plus_1 = (_plus + "/");
        String _output = this.program.getOutput();
        String _plus_2 = (_plus_1 + _output);
        String _replaceAll = this.fileName.replaceAll(".mutator", ".model");
        String _plus_3 = (_plus_2 + _replaceAll);
        this.xmiFileName = _plus_3;
        WodelUtils.serialize(xTextFileName, this.xmiFileName);
        String _replaceAll_1 = this.fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _plus_4 = (_replaceAll_1 + ".mutator");
        this.fileName = _plus_4;
        mutatorName = this.fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _replaceAll_2 = mutatorName.replaceAll("[.]", "_");
        String _plus_5 = (_replaceAll_2 + "DynamicAPI.java");
        this.fileName = _plus_5;
        this.className = this.fileName.replaceAll(".java", "");
        String key = this.className.replace("DynamicAPI", "");
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
      }
    }
  }
}
