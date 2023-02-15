package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import manager.JavaUtils;
import manager.ModelManager;
import manager.ProjectUtils;
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
import wodel.dsls.WodelUtils;
import wodel.dsls.generator.WodelAPIGenerator;

@SuppressWarnings("all")
public class WodelDynamicAPIGenerator extends WodelAPIGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    ProjectUtils.resetProject();
    this.project = ProjectUtils.getProject();
    this.standalone = false;
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
        String _plus_11 = (_replaceAll_2 + "DynamicAPI.java");
        this.fileName = _plus_11;
        this.className = this.fileName.replaceAll(".java", "");
        int i = 1;
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
        mutatorEnvironment = e;
      }
    }
  }
}
