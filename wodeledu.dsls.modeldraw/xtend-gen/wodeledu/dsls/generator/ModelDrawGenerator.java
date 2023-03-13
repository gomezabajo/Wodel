/**
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import modeldraw.MutatorDraw;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodeledu.dsls.ModelDrawUtils;

/**
 * @author Pablo Gomez-Abajo - Main Model-Draw code generator.
 * 
 * It calls ModelDrawDotGenerator to generate the dot code for the models,
 * or ModelDrawCircuitGenerator to generate the m4 code for the circuit models.
 */
@SuppressWarnings("all")
public class ModelDrawGenerator extends AbstractGenerator {
  @Inject
  private ModelDrawDotGenerator dotGenerator;

  @Inject
  private ModelDrawCircuitGenerator circuitGenerator;

  protected IProject project = null;

  private String fileName;

  private String path;

  private String xmiFileName;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String modelDrawMode = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Model-Draw mode", "", null);
    boolean _equals = modelDrawMode.equals("Dot");
    if (_equals) {
      this.dotGenerator.doGenerate(resource, fsa, context);
    }
    boolean _equals_1 = modelDrawMode.equals("Circuit");
    if (_equals_1) {
      this.circuitGenerator.doGenerate(resource, fsa, context);
    }
    ProjectUtils.resetProject();
    this.project = ProjectUtils.getProject();
    String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
    String _plus = (_workspaceAbsolutePath + "/");
    String _name = this.project.getName();
    String _plus_1 = (_plus + _name);
    this.path = _plus_1;
    Iterable<MutatorDraw> _filter = Iterables.<MutatorDraw>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorDraw.class);
    for (final MutatorDraw e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        String xTextFileName = ((("file:/" + this.path) + "/src/") + this.fileName);
        String _outputFolder = ModelManager.getOutputFolder();
        String _plus_2 = ((("file:/" + this.path) + "/") + _outputFolder);
        String _plus_3 = (_plus_2 + "/");
        String _replaceAll = this.fileName.replaceAll(".draw", "_draw.model");
        String _plus_4 = (_plus_3 + _replaceAll);
        this.xmiFileName = _plus_4;
        ModelDrawUtils.serialize(xTextFileName, this.xmiFileName);
      }
    }
  }
}
