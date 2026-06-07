package wodeledu.dsls.generator.moodle;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import edutest.AlternativeResponse;
import edutest.AlternativeText;
import edutest.DragAndDropText;
import edutest.MatchPairs;
import edutest.MissingWords;
import edutest.MultiChoiceDiagram;
import edutest.MultiChoiceEmendation;
import edutest.MultiChoiceText;
import edutest.MutatorTests;
import edutest.Program;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.MutatorEnvironment;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.osgi.framework.Bundle;
import wodel.utils.manager.ModelManager;
import wodeledu.dsls.generator.EduTestSuperGenerator;

@SuppressWarnings("all")
public class EduTestMoodleGeneratorTestExercise extends EduTestSuperGenerator {
  @Inject
  private EduTestMoodleGeneratorAlternativeResponse alternativeResponse;

  @Inject
  private EduTestMoodleGeneratorAlternativeText alternativeText;

  @Inject
  private EduTestMoodleGeneratorDragAndDropText dragAndDropText;

  @Inject
  private EduTestMoodleGeneratorMatchPairs matchPairs;

  @Inject
  private EduTestMoodleGeneratorMissingWords missingWords;

  @Inject
  private EduTestMoodleGeneratorMultiChoiceDiagram multiChoiceDiagram;

  @Inject
  private EduTestMoodleGeneratorMultiChoiceEmendation multiChoiceEmendation;

  @Inject
  private EduTestMoodleGeneratorMultiChoiceText multiChoiceText;

  private List<EPackage> metamodel;

  private List<EClass> roots;

  private List<EObject> blocks;

  private List<EObject> mutators;

  private String fileName;

  private String pageName;

  public void setUp(final Resource resource) {
    try {
      this.project = EduTestSuperGenerator.projectOf(resource);
      String _xifexpression = null;
      if ((this.project != null)) {
        _xifexpression = this.project.getLocation().toFile().getPath().replace("\\", "/");
      } else {
        _xifexpression = null;
      }
      this.projectPath = _xifexpression;
      this.outputFolder = ModelManager.getOutputFolder();
      String _xifexpression_1 = null;
      if ((this.project != null)) {
        _xifexpression_1 = this.project.getName();
      } else {
        _xifexpression_1 = null;
      }
      this.projectName = _xifexpression_1;
      this.workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString().replace("\\", "/");
      String _replaceAll = resource.getURI().lastSegment().replaceAll(".test", ".model");
      String xmiFileName = ((((((this.workspacePath + "/") + this.projectName) + "/") + this.outputFolder) + "/") + _replaceAll);
      final Bundle bundle = Platform.getBundle("wodel.models");
      final URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
      final String mutatorecore = FileLocator.resolve(fileURL).getFile();
      final List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
      final Resource mutatormodel = ModelManager.loadModel(mutatorpackages, xmiFileName);
      this.blocks = ModelManager.getObjectsOfType("Block", mutatormodel);
      this.mutators = ModelManager.getObjectsOfType("Mutator", mutatormodel);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      this.setUp(resource);
      int i = 0;
      Iterable<Program> _filter = Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class);
      for (final Program e : _filter) {
        {
          ArrayList<EPackage> _arrayList = new ArrayList<EPackage>();
          this.metamodel = _arrayList;
          this.metamodel.addAll(ModelManager.loadMetaModel(e.getMetamodel()));
          ArrayList<EClass> _arrayList_1 = new ArrayList<EClass>();
          this.roots = _arrayList_1;
          this.roots.addAll(ModelManager.getRootEClasses(this.metamodel));
          if ((i == 0)) {
            String _replaceAll = resource.getURI().lastSegment().replaceAll(".test", "");
            String _plus = ("xml/" + _replaceAll);
            String _plus_1 = (_plus + ".xml");
            this.fileName = _plus_1;
            String _replaceAll_1 = resource.getURI().lastSegment().replaceAll(".test", "");
            String _plus_2 = (_replaceAll_1 + ".xml");
            this.pageName = _plus_2;
          } else {
            String _replaceAll_2 = resource.getURI().lastSegment().replaceAll(".test", "");
            String _plus_3 = ("xml/" + _replaceAll_2);
            String _plus_4 = (_plus_3 + Integer.valueOf(i));
            String _plus_5 = (_plus_4 + ".xml");
            this.fileName = _plus_5;
            String _replaceAll_3 = resource.getURI().lastSegment().replaceAll(".test", "");
            String _plus_6 = (_replaceAll_3 + Integer.valueOf(i));
            String _plus_7 = (_plus_6 + ".xml");
            this.pageName = _plus_7;
          }
          fsa.generateFile(this.fileName, this.compile(e, resource, this.fileName, fsa, context));
          i++;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public CharSequence compile(final Program program, final Resource resource, final String fileName, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      String _xblockexpression = null;
      {
        this.buildOptions(program, resource, this.blocks, this.roots, program.getClass());
        _xblockexpression = "";
      }
      _builder.append(_xblockexpression);
      _builder.newLineIfNotEmpty();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      _builder.newLine();
      _builder.append("<!--");
      EObject main = null;
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      {
        int _size = this.blocks.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _xblockexpression_1 = null;
          {
            main = this.blocks.get(0);
            _xblockexpression_1 = "";
          }
          _builder.append(_xblockexpression_1);
          _builder.newLineIfNotEmpty();
        } else {
          {
            int _size_1 = this.mutators.size();
            boolean _greaterThan_1 = (_size_1 > 0);
            if (_greaterThan_1) {
              String _xblockexpression_2 = null;
              {
                main = this.mutators.get(0);
                _xblockexpression_2 = "";
              }
              _builder.append(_xblockexpression_2);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("<!--");
      EObject _eContainer = main.eContainer();
      List<EPackage> packages = ModelManager.loadMetaModel(((MutatorEnvironment) _eContainer).getDefinition().getMetamodel());
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      String domain = packages.get(0).getNsURI().replace("http://", "");
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      _builder.append(domain = domain.substring(0, domain.lastIndexOf("/")).replace("/", ""));
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      _builder.append("<quiz>");
      _builder.newLine();
      _builder.append("<question type=\"category\">");
      _builder.newLine();
      _builder.append("<category>");
      _builder.newLine();
      _builder.append("<text>$course$/top/");
      _builder.append(domain);
      _builder.append("</text>");
      _builder.newLineIfNotEmpty();
      _builder.append("</category>");
      _builder.newLine();
      _builder.append("<info format=\"moodle_auto_format\">");
      _builder.newLine();
      _builder.append("<text>Default category in the context of deterministic finite automata.</text>");
      _builder.newLine();
      _builder.append("<!--<text>Categoria por defecto para preguntas compartidas en el contexto Aut&#243;matas.</text>-->");
      _builder.newLine();
      _builder.append("</info>");
      _builder.newLine();
      _builder.append("<idnumber></idnumber>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("</question>");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      int i = 0;
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      List<Integer> li = new ArrayList<Integer>();
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      String _xblockexpression_3 = null;
      {
        li.add(0, Integer.valueOf(i));
        _xblockexpression_3 = "";
      }
      _builder.append(_xblockexpression_3);
      _builder.newLineIfNotEmpty();
      {
        EList<MutatorTests> _exercises = program.getExercises();
        for(final MutatorTests exercise : _exercises) {
          {
            if ((exercise instanceof AlternativeResponse)) {
              String _xblockexpression_4 = null;
              {
                String xmlCode = this.alternativeResponse.setUpAndCompile(this, ((AlternativeResponse)exercise), program, resource, li, this.roots);
                _xblockexpression_4 = xmlCode;
              }
              _builder.append(_xblockexpression_4);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof MultiChoiceDiagram)) {
              String _xblockexpression_5 = null;
              {
                String xmlCode = this.multiChoiceDiagram.setUpAndCompile(this, ((MultiChoiceDiagram)exercise), program, resource, li, this.roots);
                _xblockexpression_5 = xmlCode;
              }
              _builder.append(_xblockexpression_5);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof MultiChoiceEmendation)) {
              String _xblockexpression_6 = null;
              {
                String xmlCode = this.multiChoiceEmendation.setUpAndCompile(this, ((MultiChoiceEmendation)exercise), program, resource, li, this.roots);
                _xblockexpression_6 = xmlCode;
              }
              _builder.append(_xblockexpression_6);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof MatchPairs)) {
              String _xblockexpression_7 = null;
              {
                String xmlCode = this.matchPairs.setUpAndCompile(this, ((MatchPairs)exercise), program, resource, li, this.roots);
                _xblockexpression_7 = xmlCode;
              }
              _builder.append(_xblockexpression_7);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof MissingWords)) {
              String _xblockexpression_8 = null;
              {
                String xmlCode = this.missingWords.setUpAndCompile(this, ((MissingWords)exercise), program, resource, li, this.roots);
                _xblockexpression_8 = xmlCode;
              }
              _builder.append(_xblockexpression_8);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof MultiChoiceText)) {
              String _xblockexpression_9 = null;
              {
                String xmlCode = this.multiChoiceText.setUpAndCompile(this, ((MultiChoiceText)exercise), program, resource, li, this.roots);
                _xblockexpression_9 = xmlCode;
              }
              _builder.append(_xblockexpression_9);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof AlternativeText)) {
              String _xblockexpression_10 = null;
              {
                String xmlCode = this.alternativeText.setUpAndCompile(this, ((AlternativeText)exercise), program, resource, li, this.roots);
                _xblockexpression_10 = xmlCode;
              }
              _builder.append(_xblockexpression_10);
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if ((exercise instanceof DragAndDropText)) {
              String _xblockexpression_11 = null;
              {
                String xmlCode = this.dragAndDropText.setUpAndCompile(this, ((DragAndDropText)exercise), program, resource, li, this.roots);
                _xblockexpression_11 = xmlCode;
              }
              _builder.append(_xblockexpression_11);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("</quiz>");
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
