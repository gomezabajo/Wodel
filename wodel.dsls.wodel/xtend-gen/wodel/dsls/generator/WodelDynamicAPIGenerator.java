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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
    this.standalone = false;
    IProject project = WodelDynamicAPIGenerator.projectOf(resource);
    IProject _xifexpression = null;
    if ((project != null)) {
      _xifexpression = project;
    } else {
      _xifexpression = ProjectUtils.getProject();
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
    this.fileURI = resource.getURI();
    Map<String, List<String>> mutMap = new LinkedHashMap<String, List<String>>();
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        String xTextFileName = this.getMutatorPath(e, this.project, files);
        Definition _definition = ((MutatorEnvironment) e).getDefinition();
        this.program = ((Program) _definition);
        String _output = this.program.getOutput();
        String _plus = (("file:/" + projectFolderName) + _output);
        String _replaceAll = this.fileURI.lastSegment().replaceAll(".mutator", ".model");
        String _plus_1 = (_plus + _replaceAll);
        this.xmiFileName = _plus_1;
        WodelUtils.serialize(xTextFileName, this.xmiFileName);
        String _replaceAll_1 = this.fileURI.lastSegment().replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_");
        String fileName = (_replaceAll_1 + ".mutator");
        mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
        String _replaceAll_2 = mutatorName.replaceAll("[.]", "_");
        String _plus_2 = (_replaceAll_2 + "DynamicAPI.java");
        fileName = _plus_2;
        this.className = fileName.replaceAll(".java", "");
        String key = this.className.replace("DynamicAPI", "");
        EList<Block> _blocks = e.getBlocks();
        for (final Block b : _blocks) {
          {
            List<String> values = new ArrayList<String>();
            boolean _contains = mutMap.keySet().contains(key);
            if (_contains) {
              values = mutMap.get(key);
            }
            if ((((b.getName() != null) && (!b.getName().isEmpty())) && (!values.contains(b.getName())))) {
              values.add(b.getName());
            }
            mutMap.put(key, values);
          }
        }
        boolean _isFile = fsa.isFile(((("mutator/" + mutatorName) + "/") + fileName));
        if (_isFile) {
          fsa.deleteFile(((("mutator/" + mutatorName) + "/") + fileName));
        }
        fsa.generateFile(((("mutator/" + mutatorName) + "/") + fileName), JavaUtils.format(this.compile(e, this.project, mutatorName, this.className), false));
      }
    }
  }
}
