package wodeledu.dsls.generator.moodle;

import edutest.MissingWords;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.util.AbstractMap;
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
import wodeledu.dsls.generator.ComparableSimpleEntry;
import wodeledu.dsls.generator.EduTestSuperGenerator;
import wodeledu.dsls.generator.TestOption;

@SuppressWarnings("all")
public class EduTestMoodleGeneratorMissingWords {
  private MissingWords exercise;

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

  public String setUpAndCompile(final EduTestSuperGenerator generator, final MissingWords exercise, final Program program, final Resource resource, final List<Integer> li, final List<EClass> roots) {
    this.project = EduTestMoodleGeneratorMissingWords.projectOf(resource);
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
    {
      EList<Test> _tests = this.exercise.getTests();
      for(final Test test : _tests) {
        _builder.append("<!-- ");
        int k = 0;
        _builder.append("-->");
        _builder.newLineIfNotEmpty();
        _builder.append("<!-- ");
        int solution = 0;
        _builder.append("-->");
        _builder.newLineIfNotEmpty();
        _builder.append("<!-- ");
        String textWithGaps = "";
        _builder.append("-->");
        _builder.newLineIfNotEmpty();
        _builder.append("<!-- ");
        TestOption op = null;
        _builder.append("-->");
        _builder.newLineIfNotEmpty();
        {
          int _size = this.generator.getOptions().get(this.exercise).get(test).size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            int rndIndex = ModelManager.getRandomIndex(this.generator.getOptions().get(this.exercise).get(test));
            _builder.newLineIfNotEmpty();
            {
              List<TestOption> _get = this.generator.getOptions().get(this.exercise).get(test).get(rndIndex);
              for(final TestOption opt : _get) {
                {
                  boolean _contains = opt.path.contains(this.exercise.getMarkedBlocks().get(0).getBlock().getName());
                  if (_contains) {
                    _builder.append("<!--");
                    _builder.append(op = opt);
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
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
                  int _size_1 = this.roots.size();
                  int _minus = (_size_1 - 1);
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
                  int _size_1 = this.roots.size();
                  boolean _greaterThan_1 = (_size_1 > 1);
                  if (_greaterThan_1) {
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
              if ((op != null)) {
                _builder.append("<!-- ");
                String diagram = op.path;
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!-- ");
                String code = op.path.replace("diagram/", "code/");
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!-- ");
                UUID uuid = UUID.randomUUID();
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                {
                  if ((op.options != null)) {
                    {
                      Set<String> _keySet = op.options.keySet();
                      for(final String key : _keySet) {
                        _builder.append("<!-- ");
                        int tmp = k;
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        String opWithGaps = "";
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        {
                          List<String> _get_1 = op.text.get(key);
                          for(final String text : _get_1) {
                            _builder.append("<!--");
                            int _plusPlus = k++;
                            _builder.append(_plusPlus);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            _builder.append("<!--");
                            String _opWithGaps = opWithGaps;
                            String _plus = opWithGaps = (_opWithGaps + (((text + "%") + Integer.valueOf(k)) + " "));
                            _builder.append(_plus);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("<!-- ");
                        _builder.append(k = tmp);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!-- ");
                        List<ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>>> entries = op.options.get(key);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        {
                          for(final ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>> entry : entries) {
                            _builder.append("<!--");
                            int _plusPlus_1 = solution++;
                            _builder.append(_plusPlus_1);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              Boolean _value = entry.getValue().getValue().getValue().getValue();
                              boolean _equals_2 = ((_value).booleanValue() == true);
                              if (_equals_2) {
                                _builder.append("<!-- ");
                                int _plusPlus_2 = k++;
                                _builder.append(_plusPlus_2);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!-- ");
                                _builder.append(opWithGaps = opWithGaps.replace(("%" + Integer.valueOf(k)), (("[[" + Integer.valueOf(solution)) + "]]")));
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        _builder.append("<!-- ");
                        int _plusPlus_3 = k++;
                        _builder.append(_plusPlus_3);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!-- ");
                        _builder.append(opWithGaps = opWithGaps.replace((" %" + Integer.valueOf(k)), ""));
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!-- ");
                        String _textWithGaps = textWithGaps;
                        String _trim = opWithGaps.trim();
                        String _plus_1 = (_trim + ".<br>");
                        String _plus_2 = textWithGaps = (_textWithGaps + _plus_1);
                        _builder.append(_plus_2);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      int _length = diagram.length();
                      boolean _greaterThan_2 = (_length > 0);
                      if (_greaterThan_2) {
                        _builder.append("<!--");
                        int _indexOf = diagram.indexOf("/data/out/");
                        int _length_1 = "/data/out/".length();
                        int _plus_3 = (_indexOf + _length_1);
                        String data = diagram.substring(_plus_3, diagram.lastIndexOf("/"));
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        String model = data.substring(0, data.lastIndexOf("/"));
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        int _indexOf_1 = data.indexOf((model + "/"));
                        int _length_2 = (model + "/").length();
                        int _plus_4 = (_indexOf_1 + _length_2);
                        String mutOperator = data.substring(_plus_4, data.length());
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        String _name = statementClass.getName();
                        String _plus_5 = ((((("diagrams/" + model) + "/") + mutOperator) + "/") + _name);
                        String _plus_6 = (_plus_5 + "_");
                        int _lastIndexOf = diagram.lastIndexOf("/");
                        int _plus_7 = (_lastIndexOf + 1);
                        String _substring = diagram.substring(_plus_7, diagram.length());
                        String _plus_8 = (_plus_6 + _substring);
                        _builder.append(diagram = _plus_8);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        String _name_1 = statementClass.getName();
                        String _plus_9 = ((((("code/" + model) + "/") + mutOperator) + "/") + _name_1);
                        String _plus_10 = (_plus_9 + "_");
                        int _lastIndexOf_1 = code.lastIndexOf("/");
                        int _plus_11 = (_lastIndexOf_1 + 1);
                        String _replace = code.substring(_plus_11, code.length()).replace(".png", ".py");
                        String _plus_12 = (_plus_10 + _replace);
                        _builder.append(code = _plus_12);
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        _builder.append("<!--");
                        File file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + diagram));
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        {
                          if ((file.isFile() && file.exists())) {
                            _builder.append("<question type=\"gapselect\">");
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
                            _builder.append("<text><![CDATA[<p>");
                            String _replace_2 = test.getQuestion().replace("\"", "\'");
                            _builder.append(_replace_2);
                            _builder.append("<br></p><p>");
                            String _trim_1 = textWithGaps.trim();
                            _builder.append(_trim_1);
                            _builder.append("<br></p><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                            String _stringBase64 = this.generator.getStringBase64(diagram);
                            _builder.append(_stringBase64);
                            _builder.append("\"><br></p><!--<p><img src=\"@@PLUGINFILE@@/exercise_");
                            _builder.append(uuid);
                            _builder.append(".png\" alt=\"\" width=\"20%\" height=\"20%\" role=\"presentation\" class=\"img-responsive atto_image_button_text-bottom\"><br><br></p><p>");
                            String _trim_2 = textWithGaps.trim();
                            _builder.append(_trim_2);
                            _builder.append("<br></p>-->]]></text>");
                            _builder.newLineIfNotEmpty();
                            _builder.append("<!--<file name=\"exercise_");
                            _builder.append(uuid);
                            _builder.append(".png\" path=\"/\" encoding=\"base64\">");
                            String _stringBase64_1 = this.generator.getStringBase64(diagram);
                            _builder.append(_stringBase64_1);
                            _builder.append("</file>-->");
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
                            _builder.append("<penalty>0.3333333</penalty>");
                            _builder.newLine();
                            _builder.append("<hidden>0</hidden>");
                            _builder.newLine();
                            _builder.append("<idnumber></idnumber>");
                            _builder.newLine();
                            _builder.append("<shuffleanswers>0</shuffleanswers>");
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
                            {
                              Set<String> _keySet_1 = op.options.keySet();
                              for(final String key_1 : _keySet_1) {
                                _builder.append("<!-- ");
                                List<ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>>> entries_1 = op.options.get(key_1);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                {
                                  for(final ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>> entry_1 : entries_1) {
                                    _builder.append("<selectoption>");
                                    _builder.newLine();
                                    _builder.append("<text>");
                                    String _trim_3 = entry_1.getKey().trim();
                                    _builder.append(_trim_3);
                                    _builder.append("</text>");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("<group>");
                                    Integer _key = entry_1.getValue().getValue().getValue().getKey();
                                    _builder.append(_key);
                                    _builder.append("</group>");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("</selectoption>");
                                    _builder.newLine();
                                  }
                                }
                              }
                            }
                            _builder.append("</question>");
                            _builder.newLine();
                          } else {
                            _builder.append("<!--");
                            File _file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + code));
                            File _file_1 = file = _file;
                            _builder.append(_file_1);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              if ((file.isFile() && file.exists())) {
                                _builder.append("<question type=\"gapselect\">");
                                _builder.newLine();
                                _builder.append("<name>");
                                _builder.newLine();
                                _builder.append("<text><![CDATA[<p>");
                                String _replace_3 = test.getQuestion().replace("\"", "\'");
                                _builder.append(_replace_3);
                                _builder.append("<br></p>]]></text>");
                                _builder.newLineIfNotEmpty();
                                _builder.append("</name>");
                                _builder.newLine();
                                _builder.append("<questiontext format=\"html\">");
                                _builder.newLine();
                                _builder.append("<text><![CDATA[<p>");
                                String _replace_4 = test.getQuestion().replace("\"", "\'");
                                _builder.append(_replace_4);
                                _builder.append("<br></p><p>");
                                String _trim_4 = textWithGaps.trim();
                                _builder.append(_trim_4);
                                _builder.append("<br></p><p>");
                                String _pythonHtmlCode = this.generator.getPythonHtmlCode(code);
                                _builder.append(_pythonHtmlCode);
                                _builder.append("</p>]]></text>");
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
                                _builder.append("<penalty>0.3333333</penalty>");
                                _builder.newLine();
                                _builder.append("<hidden>0</hidden>");
                                _builder.newLine();
                                _builder.append("<idnumber></idnumber>");
                                _builder.newLine();
                                _builder.append("<shuffleanswers>0</shuffleanswers>");
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
                                {
                                  Set<String> _keySet_2 = op.options.keySet();
                                  for(final String key_2 : _keySet_2) {
                                    _builder.append("<!-- ");
                                    List<ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>>> entries_2 = op.options.get(key_2);
                                    _builder.append("-->");
                                    _builder.newLineIfNotEmpty();
                                    {
                                      for(final ComparableSimpleEntry<String, AbstractMap.SimpleEntry<EClass, AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Boolean>>>> entry_2 : entries_2) {
                                        _builder.append("<selectoption>");
                                        _builder.newLine();
                                        _builder.append("<text>");
                                        String _trim_5 = entry_2.getValue().getValue().getKey().trim();
                                        _builder.append(_trim_5);
                                        _builder.append("</text>");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("<group>");
                                        Integer _key_1 = entry_2.getValue().getValue().getValue().getKey();
                                        _builder.append(_key_1);
                                        _builder.append("</group>");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("</selectoption>");
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
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
}
