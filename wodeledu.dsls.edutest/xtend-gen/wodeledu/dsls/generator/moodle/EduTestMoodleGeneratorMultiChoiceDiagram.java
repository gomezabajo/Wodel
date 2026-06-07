package wodeledu.dsls.generator.moodle;

import edutest.Mode;
import edutest.MultiChoiceDiagram;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
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
public class EduTestMoodleGeneratorMultiChoiceDiagram {
  private MultiChoiceDiagram exercise;

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

  public String setUpAndCompile(final EduTestSuperGenerator generator, final MultiChoiceDiagram exercise, final Program program, final Resource resource, final List<Integer> li, final List<EClass> roots) {
    this.project = EduTestMoodleGeneratorMultiChoiceDiagram.projectOf(resource);
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
    int i = (this.li.get(0)).intValue();
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    int min = Integer.MAX_VALUE;
    _builder.newLineIfNotEmpty();
    {
      EList<Test> _tests = this.exercise.getTests();
      for(final Test test : _tests) {
        {
          Set<EClass> _keySet = this.generator.getDiagrams().get(this.exercise).get(test).keySet();
          for(final EClass eclass : _keySet) {
            int counter = this.generator.getDiagrams().get(this.exercise).get(test).get(eclass).size();
            _builder.newLineIfNotEmpty();
            {
              if ((min > counter)) {
                String _xblockexpression = null;
                {
                  min = counter;
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
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
                String _xblockexpression_1 = null;
                {
                  answersClass = root;
                  _xblockexpression_1 = "";
                }
                _builder.append(_xblockexpression_1);
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() == 0))) {
              String _xblockexpression_2 = null;
              {
                answersClass = root;
                _xblockexpression_2 = "";
              }
              _builder.append(_xblockexpression_2);
              _builder.newLineIfNotEmpty();
            }
          }
        }
        {
          if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() > 0))) {
            {
              boolean _equals_1 = this.exercise.getConfig().getStatement().get(0).getName().equals(root.getName());
              if (_equals_1) {
                String _xblockexpression_3 = null;
                {
                  statementClass = root;
                  _xblockexpression_3 = "";
                }
                _builder.append(_xblockexpression_3);
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() == 0))) {
              String _xblockexpression_4 = null;
              {
                statementClass = root;
                _xblockexpression_4 = "";
              }
              _builder.append(_xblockexpression_4);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    {
      if ((answersClass == null)) {
        String _xblockexpression_5 = null;
        {
          int _size = this.roots.size();
          int _minus = (_size - 1);
          answersClass = this.roots.get(_minus);
          _xblockexpression_5 = "";
        }
        _builder.append(_xblockexpression_5);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((statementClass == null)) {
        {
          int _size = this.roots.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            String _xblockexpression_6 = null;
            {
              statementClass = this.roots.get(1);
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6);
            _builder.newLineIfNotEmpty();
          } else {
            String _xblockexpression_7 = null;
            {
              statementClass = this.roots.get(0);
              _xblockexpression_7 = "";
            }
            _builder.append(_xblockexpression_7);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Test> _tests_1 = this.exercise.getTests();
      for(final Test test_1 : _tests_1) {
        String _xifexpression = null;
        List<String> _get = this.generator.getDiagrams().get(this.exercise).get(test_1).get(statementClass);
        boolean _tripleNotEquals = (_get != null);
        if (_tripleNotEquals) {
          String _xifexpression_1 = null;
          int _size_1 = this.generator.getDiagrams().get(this.exercise).get(test_1).get(statementClass).size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _xifexpression_1 = this.generator.getDiagrams().get(this.exercise).get(test_1).get(statementClass).get(0);
          } else {
            _xifexpression_1 = null;
          }
          _xifexpression = _xifexpression_1;
        } else {
          _xifexpression = null;
        }
        String statement = _xifexpression;
        _builder.newLineIfNotEmpty();
        String _xifexpression_2 = null;
        List<String> _get_1 = this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass);
        boolean _tripleNotEquals_1 = (_get_1 != null);
        if (_tripleNotEquals_1) {
          String _xifexpression_3 = null;
          int _size_2 = this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass).size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _xifexpression_3 = this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass).get(0);
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
          if (((this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass) != null) && (this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass).size() > 0))) {
            String _xblockexpression_8 = null;
            {
              answersSet.addAll(this.generator.getDiagrams().get(this.exercise).get(test_1).get(answersClass));
              _xblockexpression_8 = "";
            }
            _builder.append(_xblockexpression_8);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_9 = null;
            {
              answers.addAll(answersSet);
              _xblockexpression_9 = "";
            }
            _builder.append(_xblockexpression_9);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_10 = null;
            {
              Collections.shuffle(answers);
              _xblockexpression_10 = "";
            }
            _builder.append(_xblockexpression_10);
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            String _replace = test_1.getSource().replace(".model", "");
            String _plus = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/diagrams/") + _replace);
            String _plus_1 = (_plus + "/");
            String _plus_2 = (_plus_1 + statement);
            File file = new File(_plus_2);
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            {
              if ((file.isFile() && file.exists())) {
                _builder.append("<question type=\"multichoice\">");
                _builder.newLine();
                _builder.append("<name>");
                _builder.newLine();
                _builder.append("<text>Question ");
                int _xblockexpression_11 = (int) 0;
                {
                  i++;
                  _xblockexpression_11 = i;
                }
                _builder.append(_xblockexpression_11);
                _builder.append("</text>");
                _builder.newLineIfNotEmpty();
                _builder.append("</name>");
                _builder.newLine();
                _builder.append("<!-- ");
                UUID uuid = UUID.randomUUID();
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<questiontext format=\"html\">");
                _builder.newLine();
                {
                  if ((((this.exercise.getConfig().getStatement() != null) && (this.roots.size() > 1)) && statementClass.getName().equals(this.roots.get(1).getName()))) {
                    _builder.append("<text><![CDATA[<p>");
                    String _replace_1 = test_1.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_1);
                    _builder.append("<br></p><p><img width=\"30%\" height=\"30%\" src=\"data:image/png;base64,");
                    String _replace_2 = test_1.getSource().replace(".model", "");
                    String _plus_3 = ("diagrams/" + _replace_2);
                    String _plus_4 = (_plus_3 + "/");
                    String _plus_5 = (_plus_4 + statement);
                    String _stringBase64 = this.generator.getStringBase64(_plus_5);
                    _builder.append(_stringBase64);
                    _builder.append("\"><br></p><!--<p><img src=\"@@PLUGINFILE@@/exercise_");
                    _builder.append(uuid);
                    _builder.append(".png\" alt=\"");
                    String _replace_3 = test_1.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_3);
                    _builder.append("\" width=\"30%\" height=\"30%\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>-->]]></text>");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("<text><![CDATA[<p>");
                    String _replace_4 = test_1.getQuestion().replace("\"", "\'");
                    _builder.append(_replace_4);
                    _builder.append("</p>]]></text>");
                    _builder.newLineIfNotEmpty();
                  }
                }
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
                  Mode _mode = this.exercise.getConfig().getMode();
                  boolean _tripleEquals = (_mode == Mode.RADIOBUTTON);
                  if (_tripleEquals) {
                    _builder.append("<single>true</single>");
                    _builder.newLine();
                  } else {
                    Mode _mode_1 = this.exercise.getConfig().getMode();
                    boolean _tripleEquals_1 = (_mode_1 == Mode.CHECKBOX);
                    if (_tripleEquals_1) {
                      _builder.append("<single>false</single>");
                      _builder.newLine();
                    }
                  }
                }
                _builder.append("<shuffleanswers>true</shuffleanswers>");
                _builder.newLine();
                _builder.append("<answernumbering>abc</answernumbering>");
                _builder.newLine();
                _builder.append("<correctfeedback format=\"html\">");
                _builder.newLine();
                _builder.append("<!--<text>Respuesta correcta</text>-->");
                _builder.newLine();
                _builder.append("<text>Right answer.</text>");
                _builder.newLine();
                _builder.append("</correctfeedback>");
                _builder.newLine();
                _builder.append("<partiallycorrectfeedback format=\"html\">");
                _builder.newLine();
                _builder.append("<!--<text>Respuesta parcialmente correcta.</text>-->");
                _builder.newLine();
                _builder.append("<text>Partially right answer.</text>");
                _builder.newLine();
                _builder.append("</partiallycorrectfeedback>");
                _builder.newLine();
                _builder.append("<incorrectfeedback format=\"html\">");
                _builder.newLine();
                _builder.append("<!--<text>Respuesta incorrecta.</text>-->");
                _builder.newLine();
                _builder.append("<text>Wrong answer.</text>");
                _builder.newLine();
                _builder.append("</incorrectfeedback>");
                _builder.newLine();
                _builder.append("<shownumcorrect/>");
                _builder.newLine();
                _builder.append("<!--");
                int counter_1 = 0;
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                int solutions = 1;
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                double fraction = (100.0 / solutions);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                String _xblockexpression_12 = null;
                {
                  counter_1 = 0;
                  _xblockexpression_12 = "";
                }
                _builder.append(_xblockexpression_12);
                _builder.newLineIfNotEmpty();
                {
                  for(final String diagram : answers) {
                    _builder.append("<!--");
                    String _replace_5 = test_1.getSource().replace(".model", "");
                    String _plus_6 = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/diagrams/") + _replace_5);
                    String _plus_7 = (_plus_6 + "/");
                    String _plus_8 = (_plus_7 + diagram);
                    File _file = new File(_plus_8);
                    File _file_1 = file = _file;
                    _builder.append(_file_1);
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((file.isFile() && file.exists())) {
                        _builder.append("<!-- ");
                        _builder.append(uuid = UUID.randomUUID());
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        {
                          if (((diagram.startsWith(answersClass.getName()) || diagram.contains(("/" + answersClass.getName()))) || diagram.contains(("\\" + answersClass.getName())))) {
                            _builder.append("<!--");
                            boolean s = false;
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              List<String> _get_2 = this.generator.getSolutionsMap().get(this.exercise);
                              for(final String sol : _get_2) {
                                {
                                  if ((((diagram.startsWith((sol + "/")) || diagram.startsWith((sol + "\\"))) || diagram.contains((((sol + "/") + answersClass.getName()) + "_"))) || diagram.contains((((sol + "\\") + answersClass.getName()) + "_")))) {
                                    String _xblockexpression_13 = null;
                                    {
                                      s = true;
                                      _xblockexpression_13 = "";
                                    }
                                    _builder.append(_xblockexpression_13);
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            {
                              if ((s == true)) {
                                {
                                  if ((counter_1 < (min - 1))) {
                                    String _xblockexpression_14 = null;
                                    {
                                      counter_1++;
                                      _xblockexpression_14 = "";
                                    }
                                    _builder.append(_xblockexpression_14);
                                    _builder.newLineIfNotEmpty();
                                    String _xblockexpression_15 = null;
                                    {
                                      solutions++;
                                      _xblockexpression_15 = "";
                                    }
                                    _builder.append(_xblockexpression_15);
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            {
                              if ((s || diagram.equals(solution))) {
                                {
                                  if (((100 % solutions) == 0)) {
                                    _builder.append("<answer fraction=\"");
                                    _builder.append((100 / solutions));
                                    _builder.append("\" format=\"html\">");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    _builder.append("<!--");
                                    NumberFormat _numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
                                    DecimalFormat formatter = ((DecimalFormat) _numberInstance);
                                    _builder.append("-->");
                                    _builder.newLineIfNotEmpty();
                                    String _xblockexpression_16 = null;
                                    {
                                      formatter.applyPattern("###.#####");
                                      _xblockexpression_16 = "";
                                    }
                                    _builder.append(_xblockexpression_16);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<answer fraction=\"");
                                    String _format = formatter.format(fraction);
                                    _builder.append(_format);
                                    _builder.append("\" format=\"html\">");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("<!--");
                                String size = "60";
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--<text><![CDATA[<p><img src=\"@@PLUGINFILE@@/exercise_");
                                _builder.append(uuid);
                                _builder.append(".png\" alt=\"\" width=\"");
                                _builder.append(size);
                                _builder.append("%\" height=\"");
                                _builder.append(size);
                                _builder.append("%\" role=\"presentation\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>]]></text>-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<text><![CDATA[<p><img width=\"");
                                _builder.append(size);
                                _builder.append("%\" height=\"");
                                _builder.append(size);
                                _builder.append("%\" src=\"data:image/png;base64,");
                                String _replace_6 = test_1.getSource().replace(".model", "");
                                String _plus_9 = ("diagrams/" + _replace_6);
                                String _plus_10 = (_plus_9 + "/");
                                String _plus_11 = (_plus_10 + diagram);
                                String _stringBase64_1 = this.generator.getStringBase64(_plus_11);
                                _builder.append(_stringBase64_1);
                                _builder.append("\"><br></p>]]></text>");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--<file name=\"exercise_");
                                _builder.append(uuid);
                                _builder.append(".png\" path=\"/\" encoding=\"base64\">");
                                String _replace_7 = test_1.getSource().replace(".model", "");
                                String _plus_12 = ("diagrams/" + _replace_7);
                                String _plus_13 = (_plus_12 + "/");
                                String _plus_14 = (_plus_13 + diagram);
                                String _stringBase64_2 = this.generator.getStringBase64(_plus_14);
                                _builder.append(_stringBase64_2);
                                _builder.append("</file>-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<feedback format=\"html\">");
                                _builder.newLine();
                                _builder.append("<text></text>");
                                _builder.newLine();
                                _builder.append("</feedback>");
                                _builder.newLine();
                                _builder.append("</answer>");
                                _builder.newLine();
                              } else {
                                {
                                  if ((counter_1 < (min - 1))) {
                                    String _xblockexpression_17 = null;
                                    {
                                      counter_1++;
                                      _xblockexpression_17 = "";
                                    }
                                    _builder.append(_xblockexpression_17);
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<!--");
                                    _builder.append(s = false);
                                    _builder.append("-->");
                                    _builder.newLineIfNotEmpty();
                                    {
                                      List<String> _get_3 = this.generator.getSolutionsMap().get(this.exercise);
                                      for(final String sol_1 : _get_3) {
                                        {
                                          if ((((diagram.startsWith((sol_1 + "/")) || diagram.startsWith((sol_1 + "\\"))) || diagram.contains((((sol_1 + "/") + answersClass.getName()) + "_"))) || diagram.contains((((sol_1 + "\\") + answersClass.getName()) + "_")))) {
                                            String _xblockexpression_18 = null;
                                            {
                                              s = true;
                                              _xblockexpression_18 = "";
                                            }
                                            _builder.append(_xblockexpression_18);
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                      }
                                    }
                                    {
                                      if ((s || diagram.equals(solution))) {
                                        {
                                          if (((100 % solutions) == 0)) {
                                            _builder.append("<answer fraction=\"");
                                            _builder.append((100 / solutions));
                                            _builder.append("\" format=\"html\">");
                                            _builder.newLineIfNotEmpty();
                                          } else {
                                            _builder.append("<!--");
                                            NumberFormat _numberInstance_1 = NumberFormat.getNumberInstance(Locale.ENGLISH);
                                            DecimalFormat formatter_1 = ((DecimalFormat) _numberInstance_1);
                                            _builder.append("-->");
                                            _builder.newLineIfNotEmpty();
                                            String _xblockexpression_19 = null;
                                            {
                                              formatter_1.applyPattern("###.#####");
                                              _xblockexpression_19 = "";
                                            }
                                            _builder.append(_xblockexpression_19);
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("<answer fraction=\"");
                                            String _format_1 = formatter_1.format(fraction);
                                            _builder.append(_format_1);
                                            _builder.append("\" format=\"html\">");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                      } else {
                                        _builder.append("<answer fraction=\"0\" format=\"html\">");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("<!--");
                                    String size_1 = "60";
                                    _builder.append("-->");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<!--<text><![CDATA[<p><img src=\"@@PLUGINFILE@@/exercise_");
                                    _builder.append(uuid);
                                    _builder.append(".png\" alt=\"\" width=\"");
                                    _builder.append(size_1);
                                    _builder.append("%\" height=\"");
                                    _builder.append(size_1);
                                    _builder.append("%\" role=\"presentation\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>]]></text>-->");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<!--<file name=\"exercise_");
                                    _builder.append(uuid);
                                    _builder.append(".png\" path=\"/\" encoding=\"base64\">");
                                    String _replace_8 = test_1.getSource().replace(".model", "");
                                    String _plus_15 = ("diagrams/" + _replace_8);
                                    String _plus_16 = (_plus_15 + "/");
                                    String _plus_17 = (_plus_16 + diagram);
                                    String _stringBase64_3 = this.generator.getStringBase64(_plus_17);
                                    _builder.append(_stringBase64_3);
                                    _builder.append("</file>-->");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<text><![CDATA[<p><img width=\"");
                                    _builder.append(size_1);
                                    _builder.append("%\" height=\"");
                                    _builder.append(size_1);
                                    _builder.append("%\" src=\"data:image/png;base64,");
                                    String _replace_9 = test_1.getSource().replace(".model", "");
                                    String _plus_18 = ("diagrams/" + _replace_9);
                                    String _plus_19 = (_plus_18 + "/");
                                    String _plus_20 = (_plus_19 + diagram);
                                    String _stringBase64_4 = this.generator.getStringBase64(_plus_20);
                                    _builder.append(_stringBase64_4);
                                    _builder.append("\"><br></p>]]></text>");
                                    _builder.newLineIfNotEmpty();
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
                          }
                        }
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
    _builder.append("<!-- ");
    Integer _set = this.li.set(0, Integer.valueOf(i));
    _builder.append(_set);
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
