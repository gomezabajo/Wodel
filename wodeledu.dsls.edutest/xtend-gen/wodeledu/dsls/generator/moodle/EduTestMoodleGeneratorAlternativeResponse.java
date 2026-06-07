package wodeledu.dsls.generator.moodle;

import edutest.AlternativeResponse;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.utils.manager.ModelManager;
import wodeledu.dsls.generator.EduTestSuperGenerator;

@SuppressWarnings("all")
public class EduTestMoodleGeneratorAlternativeResponse {
  private AlternativeResponse exercise;

  private IProject project;

  private String projectPath;

  private String outputFolder;

  private String projectName;

  private String workspacePath;

  private EduTestSuperGenerator generator;

  private Program program;

  private List<Integer> li;

  private List<EClass> roots;

  protected static IProject projectOf(final Resource r) {
    URI uri = r.getURI();
    if (((uri != null) && uri.isPlatformResource())) {
      String projectName = uri.segment(1);
      return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    }
    return null;
  }

  public String setUpAndCompile(final EduTestSuperGenerator generator, final AlternativeResponse exercise, final Program program, final Resource resource, final List<Integer> li, final List<EClass> roots) {
    this.project = EduTestMoodleGeneratorAlternativeResponse.projectOf(resource);
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
    this.generator = generator;
    this.exercise = exercise;
    this.program = program;
    this.li = li;
    this.roots = roots;
    return this.compile(resource).toString();
  }

  public CharSequence compile(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- ");
    EClass answersClass = null;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("<!-- ");
    EClass statementClass = null;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    {
      for(final EClass root : this.roots) {
        {
          if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() > 0))) {
            {
              boolean _equals = this.exercise.getConfig().getAnswers().get(0).getName().equals(root.getName());
              if (_equals) {
                String _xblockexpression = null;
                {
                  answersClass = root;
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression);
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() == 0))) {
              String _xblockexpression_1 = null;
              {
                answersClass = root;
                _xblockexpression_1 = "";
              }
              _builder.append(_xblockexpression_1);
              _builder.newLineIfNotEmpty();
            }
          }
        }
        {
          if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() > 0))) {
            {
              boolean _equals_1 = this.exercise.getConfig().getStatement().get(0).getName().equals(root.getName());
              if (_equals_1) {
                String _xblockexpression_2 = null;
                {
                  statementClass = root;
                  _xblockexpression_2 = "";
                }
                _builder.append(_xblockexpression_2);
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() == 0))) {
              String _xblockexpression_3 = null;
              {
                statementClass = root;
                _xblockexpression_3 = "";
              }
              _builder.append(_xblockexpression_3);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    {
      if ((answersClass == null)) {
        String _xblockexpression_4 = null;
        {
          int _size = this.roots.size();
          int _minus = (_size - 1);
          answersClass = this.roots.get(_minus);
          _xblockexpression_4 = "";
        }
        _builder.append(_xblockexpression_4);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((statementClass == null)) {
        {
          int _size = this.roots.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            String _xblockexpression_5 = null;
            {
              statementClass = this.roots.get(1);
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5);
            _builder.newLineIfNotEmpty();
          } else {
            String _xblockexpression_6 = null;
            {
              statementClass = this.roots.get(0);
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Test> _tests = this.exercise.getTests();
      for(final Test test : _tests) {
        String _xifexpression = null;
        List<String> _get = this.generator.getDiagrams().get(this.exercise).get(test).get(statementClass);
        boolean _tripleNotEquals = (_get != null);
        if (_tripleNotEquals) {
          String _xifexpression_1 = null;
          int _size_1 = this.generator.getDiagrams().get(this.exercise).get(test).get(statementClass).size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _xifexpression_1 = this.generator.getDiagrams().get(this.exercise).get(test).get(statementClass).get(0);
          }
          _xifexpression = _xifexpression_1;
        }
        String statement = _xifexpression;
        _builder.newLineIfNotEmpty();
        String _xifexpression_2 = null;
        List<String> _get_1 = this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass);
        boolean _tripleNotEquals_1 = (_get_1 != null);
        if (_tripleNotEquals_1) {
          String _xifexpression_3 = null;
          int _size_2 = this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass).size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _xifexpression_3 = this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass).get(0);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        String solution = _xifexpression_2;
        _builder.newLineIfNotEmpty();
        List<String> answers = new ArrayList<String>();
        _builder.newLineIfNotEmpty();
        Set<String> answersSet = new LinkedHashSet<String>();
        _builder.newLineIfNotEmpty();
        {
          if (((this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass) != null) && (this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass).size() > 0))) {
            String _xblockexpression_7 = null;
            {
              answersSet.addAll(this.generator.getDiagrams().get(this.exercise).get(test).get(answersClass));
              _xblockexpression_7 = "";
            }
            _builder.append(_xblockexpression_7);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_8 = null;
            {
              answers.addAll(answersSet);
              _xblockexpression_8 = "";
            }
            _builder.append(_xblockexpression_8);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_9 = null;
            {
              Collections.shuffle(answers);
              _xblockexpression_9 = "";
            }
            _builder.append(_xblockexpression_9);
            _builder.newLineIfNotEmpty();
            {
              int _size_3 = answers.size();
              boolean _greaterThan_3 = (_size_3 > 0);
              if (_greaterThan_3) {
                _builder.append("<!-- ");
                String diagram = answers.get(0);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                String _replace = test.getSource().replace(".model", "");
                String _plus = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/diagrams/") + _replace);
                String _plus_1 = (_plus + "/");
                String _plus_2 = (_plus_1 + diagram);
                File file = new File(_plus_2);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                {
                  if ((file.isFile() && file.exists())) {
                    _builder.append("<question type=\"truefalse\">");
                    _builder.newLine();
                    _builder.append("<name>");
                    _builder.newLine();
                    _builder.append("<text><![CDATA[<p>");
                    String _replace_1 = test.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_1);
                    _builder.append("<br></p>]]></text>");
                    _builder.newLineIfNotEmpty();
                    _builder.append("</name>");
                    _builder.newLine();
                    _builder.append("<questiontext format=\"html\">");
                    _builder.newLine();
                    _builder.append("<!-- ");
                    UUID uuid = UUID.randomUUID();
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<text><![CDATA[<p>");
                    String _replace_2 = test.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_2);
                    _builder.append("<br></p><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                    String _replace_3 = test.getSource().replace(".model", "");
                    String _plus_3 = ("diagrams/" + _replace_3);
                    String _plus_4 = (_plus_3 + "/");
                    String _plus_5 = (_plus_4 + statement);
                    String _stringBase64 = this.generator.getStringBase64(_plus_5);
                    _builder.append(_stringBase64);
                    _builder.append("\"><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                    String _replace_4 = test.getSource().replace(".model", "");
                    String _plus_6 = ("diagrams/" + _replace_4);
                    String _plus_7 = (_plus_6 + "/");
                    String _plus_8 = (_plus_7 + diagram);
                    String _stringBase64_1 = this.generator.getStringBase64(_plus_8);
                    _builder.append(_stringBase64_1);
                    _builder.append("\"><br></p><!--<p><img src=\"@@PLUGINFILE@@/exercise_");
                    _builder.append(uuid);
                    _builder.append(".png\" alt=\"");
                    String _replace_5 = test.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_5);
                    _builder.append("\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>-->]]></text>");
                    _builder.newLineIfNotEmpty();
                    _builder.append("</questiontext>");
                    _builder.newLine();
                    _builder.append("<generalfeedback format=\"html\">");
                    _builder.newLine();
                    _builder.append("<text></text>");
                    _builder.newLine();
                    _builder.append("</generalfeedback>");
                    _builder.newLine();
                    _builder.append("<defaultgrade>1.0000000</defaultgrade>");
                    _builder.newLine();
                    _builder.append("<penalty>1.0000000</penalty>");
                    _builder.newLine();
                    _builder.append("<hidden>0</hidden>");
                    _builder.newLine();
                    _builder.append("<idnumber></idnumber>");
                    _builder.newLine();
                    {
                      boolean _equals_2 = diagram.equals(solution.replace(".model", ".png"));
                      if (_equals_2) {
                        _builder.append("<answer fraction=\"100\" format=\"moodle_auto_format\">");
                        _builder.newLine();
                        _builder.append("<text>true</text>");
                        _builder.newLine();
                        _builder.append("<feedback format=\"html\">");
                        _builder.newLine();
                        _builder.append("<text></text>");
                        _builder.newLine();
                        _builder.append("</feedback>");
                        _builder.newLine();
                        _builder.append("</answer>");
                        _builder.newLine();
                        _builder.append("<answer fraction=\"0\" format=\"moodle_auto_format\">");
                        _builder.newLine();
                        _builder.append("<text>false</text>");
                        _builder.newLine();
                        _builder.append("<feedback format=\"html\">");
                        _builder.newLine();
                        _builder.append("<text></text>");
                        _builder.newLine();
                        _builder.append("</feedback>");
                        _builder.newLine();
                        _builder.append("</answer>");
                        _builder.newLine();
                      } else {
                        _builder.append("<answer fraction=\"0\" format=\"moodle_auto_format\">");
                        _builder.newLine();
                        _builder.append("<text>true</text>");
                        _builder.newLine();
                        _builder.append("<feedback format=\"html\">");
                        _builder.newLine();
                        _builder.append("<text></text>");
                        _builder.newLine();
                        _builder.append("</feedback>");
                        _builder.newLine();
                        _builder.append("</answer>");
                        _builder.newLine();
                        _builder.append("<answer fraction=\"100\" format=\"moodle_auto_format\">");
                        _builder.newLine();
                        _builder.append("<text>false</text>");
                        _builder.newLine();
                        _builder.append("<feedback format=\"html\">");
                        _builder.newLine();
                        _builder.append("<text></text>");
                        _builder.newLine();
                        _builder.append("</feedback>");
                        _builder.newLine();
                        _builder.append("</answer>");
                        _builder.newLine();
                      }
                    }
                  }
                }
                _builder.append("</question>");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
}
