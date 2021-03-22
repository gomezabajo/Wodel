package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import edutest.Program;
import exceptions.ModelNotFoundException;
import java.net.URL;
import java.util.List;
import manager.ModelManager;
import manager.WodelContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.osgi.framework.Bundle;
import wodeledu.dsls.generator.EduTestSuperGenerator;

@SuppressWarnings("all")
public class EduTestMobileAppGenerator extends EduTestSuperGenerator {
  private List<EObject> blocks;
  
  private String fileName;
  
  private String pageName;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      try {
        int i = 0;
        String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
        String _plus = ("file:/" + _workspaceAbsolutePath);
        String _plus_1 = (_plus + "/");
        String _project = WodelContext.getProject();
        String _plus_2 = (_plus_1 + _project);
        String _plus_3 = (_plus_2 + 
          "/");
        String _outputFolder = ModelManager.getOutputFolder();
        String _plus_4 = (_plus_3 + _outputFolder);
        String _plus_5 = (_plus_4 + "/");
        String _replaceAll = resource.getURI().lastSegment().replaceAll(".test", ".model");
        String xmiFileName = (_plus_5 + _replaceAll);
        final Bundle bundle = Platform.getBundle("wodel.models");
        final URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
        final String mutatorecore = FileLocator.resolve(fileURL).getFile();
        final List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
        final Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
        this.blocks = ModelManager.getObjectsOfType("Block", mutatormodel);
        Iterable<Program> _filter = Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class);
        for (final Program p : _filter) {
          {
            if ((i == 0)) {
              String _replaceAll_1 = resource.getURI().lastSegment().replaceAll(".test", "");
              String _plus_6 = ("mobile/" + _replaceAll_1);
              String _plus_7 = (_plus_6 + ".app");
              this.fileName = _plus_7;
              String _replaceAll_2 = resource.getURI().lastSegment().replaceAll(".test", "");
              String _plus_8 = (_replaceAll_2 + ".app");
              this.pageName = _plus_8;
            } else {
              String _replaceAll_3 = resource.getURI().lastSegment().replaceAll(".test", "");
              String _plus_9 = ("mobile/" + _replaceAll_3);
              String _plus_10 = (_plus_9 + Integer.valueOf(i));
              String _plus_11 = (_plus_10 + ".app");
              this.fileName = _plus_11;
              String _replaceAll_4 = resource.getURI().lastSegment().replaceAll(".test", "");
              String _plus_12 = (_replaceAll_4 + Integer.valueOf(i));
              String _plus_13 = (_plus_12 + ".app");
              this.pageName = _plus_13;
            }
            fsa.generateFile(this.fileName, this.compile(p, resource));
            i++;
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof ModelNotFoundException) {
          final ModelNotFoundException e = (ModelNotFoundException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence compile(final Program program, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MobileApp code will be generated here!!");
    _builder.newLine();
    return _builder;
  }
}
