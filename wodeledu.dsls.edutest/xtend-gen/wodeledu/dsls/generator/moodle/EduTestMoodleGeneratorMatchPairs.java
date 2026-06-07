package wodeledu.dsls.generator.moodle;

import edutest.MatchPairs;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import wodel.utils.manager.HTMLUtils;
import wodel.utils.manager.ModelManager;
import wodeledu.dsls.generator.EduTestSuperGenerator;
import wodeledu.dsls.generator.TestOption;

@SuppressWarnings("all")
public class EduTestMoodleGeneratorMatchPairs {
  private MatchPairs exercise;

  private IProject project;

  private String projectPath;

  private String outputFolder;

  private String projectName;

  private String workspacePath;

  private EduTestSuperGenerator generator;

  private Program program;

  private List<Integer> li;

  private List<EClass> roots;

  private String fileName;

  protected static IProject projectOf(final Resource r) {
    URI uri = r.getURI();
    if (((uri != null) && uri.isPlatformResource())) {
      String projectName = uri.segment(1);
      return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    }
    return null;
  }

  public String setUpAndCompile(final EduTestSuperGenerator generator, final MatchPairs exercise, final Program program, final Resource resource, final List<Integer> li, final List<EClass> roots) {
    this.project = EduTestMoodleGeneratorMatchPairs.projectOf(resource);
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
    this.fileName = this.fileName;
    return this.compile(resource).toString();
  }

  public CharSequence compile(final Resource resource) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<!-- ");
      int i = (this.li.get(0)).intValue();
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      int min = Integer.MAX_VALUE;
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      int index = 0;
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      _builder.append("<!--");
      int max = Integer.MIN_VALUE;
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      {
        EList<Test> _tests = this.exercise.getTests();
        for(final Test test : _tests) {
          {
            if (((this.generator.getOptions().get(this.exercise) != null) && (this.generator.getOptions().get(this.exercise).get(test) != null))) {
              List<String> textOptions = new ArrayList<String>();
              _builder.newLineIfNotEmpty();
              int k = 0;
              _builder.newLineIfNotEmpty();
              int counter = 0;
              _builder.newLineIfNotEmpty();
              int rndIndex = ModelManager.getRandomIndex(this.generator.getOptions().get(this.exercise).get(test));
              _builder.newLineIfNotEmpty();
              {
                int _size = this.generator.getOptions().get(this.exercise).get(test).size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  {
                    List<TestOption> _get = this.generator.getOptions().get(this.exercise).get(test).get(rndIndex);
                    for(final TestOption opt : _get) {
                      {
                        Set<String> _keySet = opt.text.keySet();
                        for(final String key : _keySet) {
                          {
                            List<String> _get_1 = opt.text.get(key);
                            for(final String text : _get_1) {
                              {
                                boolean _contains = textOptions.contains(text);
                                boolean _not = (!_contains);
                                if (_not) {
                                  String _xblockexpression = null;
                                  {
                                    counter++;
                                    _xblockexpression = "";
                                  }
                                  _builder.append(_xblockexpression);
                                  _builder.newLineIfNotEmpty();
                                  String _xblockexpression_1 = null;
                                  {
                                    textOptions.add(text);
                                    _xblockexpression_1 = "";
                                  }
                                  _builder.append(_xblockexpression_1);
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  {
                    if ((counter > max)) {
                      String _xblockexpression_2 = null;
                      {
                        max = counter;
                        _xblockexpression_2 = "";
                      }
                      _builder.append(_xblockexpression_2);
                      _builder.newLineIfNotEmpty();
                      String _xblockexpression_3 = null;
                      {
                        index = k;
                        _xblockexpression_3 = "";
                      }
                      _builder.append(_xblockexpression_3);
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  String _xblockexpression_4 = null;
                  {
                    k++;
                    _xblockexpression_4 = "";
                  }
                  _builder.append(_xblockexpression_4);
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("<!--");
      Map<Test, Map<TestOption, String>> mapPairOptions = new LinkedHashMap<Test, Map<TestOption, String>>();
      _builder.append("-->");
      _builder.newLineIfNotEmpty();
      {
        EList<Test> _tests_1 = this.exercise.getTests();
        for(final Test test_1 : _tests_1) {
          {
            if (((this.generator.getOptions().get(this.exercise) != null) && (this.generator.getOptions().get(this.exercise).get(test_1) != null))) {
              int k_1 = 0;
              _builder.newLineIfNotEmpty();
              int counter_1 = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("<!--");
              Map<TestOption, String> mapOptions = new LinkedHashMap<TestOption, String>();
              _builder.append("-->");
              _builder.newLineIfNotEmpty();
              int rndIndex_1 = ModelManager.getRandomIndex(this.generator.getOptions().get(this.exercise).get(test_1));
              _builder.newLineIfNotEmpty();
              {
                int _size_1 = this.generator.getOptions().get(this.exercise).get(test_1).size();
                boolean _greaterThan_1 = (_size_1 > 0);
                if (_greaterThan_1) {
                  {
                    List<TestOption> _get_2 = this.generator.getOptions().get(this.exercise).get(test_1).get(rndIndex_1);
                    for(final TestOption opt_1 : _get_2) {
                      List<String> textOptions_1 = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      {
                        Set<String> _keySet_1 = opt_1.text.keySet();
                        for(final String key_1 : _keySet_1) {
                          _builder.append("<!--");
                          String text_1 = opt_1.text.get(key_1).get(0);
                          _builder.append("-->");
                          _builder.newLineIfNotEmpty();
                          {
                            boolean _contains_1 = textOptions_1.contains(text_1);
                            boolean _not_1 = (!_contains_1);
                            if (_not_1) {
                              String _xblockexpression_5 = null;
                              {
                                counter_1++;
                                _xblockexpression_5 = "";
                              }
                              _builder.append(_xblockexpression_5);
                              _builder.newLineIfNotEmpty();
                              String _xblockexpression_6 = null;
                              {
                                textOptions_1.add(text_1);
                                _xblockexpression_6 = "";
                              }
                              _builder.append(_xblockexpression_6);
                              _builder.newLineIfNotEmpty();
                            }
                          }
                        }
                      }
                      String pairOptions = "";
                      _builder.newLineIfNotEmpty();
                      {
                        for(final String textOption : textOptions_1) {
                          _builder.append("<!--");
                          String _pairOptions = pairOptions;
                          String _trim = textOption.trim();
                          String _plus = (_trim + ".<br>");
                          String _plus_1 = pairOptions = (_pairOptions + _plus);
                          _builder.append(_plus_1);
                          _builder.append("-->");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append(mapOptions.put(opt_1, pairOptions));
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append(mapPairOptions.put(test_1, mapOptions));
                  _builder.newLineIfNotEmpty();
                  {
                    if ((min > counter_1)) {
                      String _xblockexpression_7 = null;
                      {
                        min = counter_1;
                        _xblockexpression_7 = "";
                      }
                      _builder.append(_xblockexpression_7);
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  String _xblockexpression_8 = null;
                  {
                    k_1++;
                    _xblockexpression_8 = "";
                  }
                  _builder.append(_xblockexpression_8);
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
                  String _xblockexpression_9 = null;
                  {
                    answersClass = root;
                    _xblockexpression_9 = "";
                  }
                  _builder.append(_xblockexpression_9);
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() == 0))) {
                String _xblockexpression_10 = null;
                {
                  answersClass = root;
                  _xblockexpression_10 = "";
                }
                _builder.append(_xblockexpression_10);
                _builder.newLineIfNotEmpty();
              }
            }
          }
          {
            if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() > 0))) {
              {
                boolean _equals_1 = this.exercise.getConfig().getStatement().get(0).getName().equals(root.getName());
                if (_equals_1) {
                  String _xblockexpression_11 = null;
                  {
                    statementClass = root;
                    _xblockexpression_11 = "";
                  }
                  _builder.append(_xblockexpression_11);
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() == 0))) {
                String _xblockexpression_12 = null;
                {
                  statementClass = root;
                  _xblockexpression_12 = "";
                }
                _builder.append(_xblockexpression_12);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
      {
        if ((answersClass == null)) {
          String _xblockexpression_13 = null;
          {
            int _size_2 = this.roots.size();
            int _minus = (_size_2 - 1);
            answersClass = this.roots.get(_minus);
            _xblockexpression_13 = "";
          }
          _builder.append(_xblockexpression_13);
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if ((statementClass == null)) {
          {
            int _size_2 = this.roots.size();
            boolean _greaterThan_2 = (_size_2 > 1);
            if (_greaterThan_2) {
              String _xblockexpression_14 = null;
              {
                statementClass = this.roots.get(1);
                _xblockexpression_14 = "";
              }
              _builder.append(_xblockexpression_14);
              _builder.newLineIfNotEmpty();
            } else {
              String _xblockexpression_15 = null;
              {
                statementClass = this.roots.get(0);
                _xblockexpression_15 = "";
              }
              _builder.append(_xblockexpression_15);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      int k_2 = 0;
      _builder.newLineIfNotEmpty();
      {
        EList<Test> _tests_2 = this.exercise.getTests();
        for(final Test test_2 : _tests_2) {
          _builder.append("<!--");
          TestOption opt_2 = null;
          _builder.append("-->");
          _builder.newLineIfNotEmpty();
          int rndIndex_2 = ModelManager.getRandomIndex(this.generator.getOptions().get(this.exercise).get(test_2));
          _builder.newLineIfNotEmpty();
          {
            int _size_3 = this.generator.getOptions().get(this.exercise).get(test_2).size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              {
                if (((this.generator.getOptions().get(this.exercise).get(test_2) != null) && (this.generator.getOptions().get(this.exercise).get(test_2).get(rndIndex_2).size() > index))) {
                  _builder.append("<!--");
                  _builder.append(opt_2 = this.generator.getOptions().get(this.exercise).get(test_2).get(rndIndex_2).get(index));
                  _builder.append("-->");
                  _builder.newLineIfNotEmpty();
                }
              }
              {
                if ((opt_2 != null)) {
                  _builder.append("<!--");
                  String seed = "";
                  _builder.append("-->");
                  _builder.newLineIfNotEmpty();
                  _builder.append("<!--");
                  _builder.append(seed = opt_2.path);
                  _builder.append("-->");
                  _builder.newLineIfNotEmpty();
                  String _xblockexpression_16 = null;
                  {
                    int _lastIndexOf = seed.lastIndexOf("/");
                    int _plus_2 = (_lastIndexOf + 1);
                    String _substring = seed.substring(0, _plus_2);
                    String _name = answersClass.getName();
                    String _plus_3 = (_substring + _name);
                    String _plus_4 = (_plus_3 + "_");
                    int _lastIndexOf_1 = seed.lastIndexOf("/");
                    int _plus_5 = (_lastIndexOf_1 + 1);
                    String _substring_1 = seed.substring(_plus_5, seed.length());
                    String _plus_6 = (_plus_4 + _substring_1);
                    seed = _plus_6;
                    _xblockexpression_16 = "";
                  }
                  _builder.append(_xblockexpression_16);
                  _builder.newLineIfNotEmpty();
                  _builder.append("<!--");
                  File file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + seed));
                  _builder.append("-->");
                  _builder.newLineIfNotEmpty();
                  {
                    if ((file.isFile() && file.exists())) {
                      _builder.append("<question type=\"matching\">");
                      _builder.newLine();
                      _builder.append("<name>");
                      _builder.newLine();
                      _builder.append("<text>Question ");
                      int _xblockexpression_17 = (int) 0;
                      {
                        i++;
                        _xblockexpression_17 = i;
                      }
                      _builder.append(_xblockexpression_17);
                      _builder.append("</text>");
                      _builder.newLineIfNotEmpty();
                      _builder.append("</name>");
                      _builder.newLine();
                      _builder.append("<questiontext format=\"html\">");
                      _builder.newLine();
                      _builder.append("<!--");
                      String question = test_2.getQuestion().replace("\"", "\'");
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      _builder.append("<!-- ");
                      UUID uuid = UUID.randomUUID();
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      _builder.append("<text><![CDATA[<p>");
                      String _trim_1 = question.trim();
                      _builder.append(_trim_1);
                      _builder.append("<br></p><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                      String _stringBase64 = this.generator.getStringBase64(seed);
                      _builder.append(_stringBase64);
                      _builder.append("\"><br></p><!--<p><img src=\"@@PLUGINFILE@@/exercise_");
                      _builder.append(uuid);
                      _builder.append(".png\" alt=\"\" width=\"20%\" height=\"20%\" role=\"presentation\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>-->]]></text>");
                      _builder.newLineIfNotEmpty();
                      _builder.append("<!--<text><![CDATA[<p>Empareja cada uno de los enunciados de la izquierda con la opci&#243;n correcta de la derecha<br><img src=\"@@PLUGINFILE@@/exercise_");
                      _builder.append(uuid);
                      _builder.append(".png\" alt=\"\" width=\"20%\" height=\"20%\" role=\"presentation\" class=\"img-responsive atto_image_button_text-bottom\"><br></p>]]></text>-->");
                      _builder.newLineIfNotEmpty();
                      _builder.append("<!--<file name=\"exercise_");
                      _builder.append(uuid);
                      _builder.append(".png\" path=\"/\" encoding=\"base64\">");
                      String _stringBase64_1 = this.generator.getStringBase64(seed);
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
                      _builder.append("<shuffleanswers>true</shuffleanswers>");
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
                      Map<Integer, AbstractMap.SimpleEntry<String, String>> entries = new TreeMap<Integer, AbstractMap.SimpleEntry<String, String>>();
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      _builder.append("<!--");
                      int keyCounter = 0;
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      {
                        List<TestOption> _get_3 = this.generator.getOptions().get(this.exercise).get(test_2).get(rndIndex_2);
                        for(final TestOption op : _get_3) {
                          String key_2 = this.generator.getText(((MatchPairs) this.exercise).getConfig().getIdentifier(), op.entry.getKey().getURI().toFileString(), resource);
                          _builder.newLineIfNotEmpty();
                          {
                            int _length = key_2.length();
                            boolean _lessEqualsThan = (_length <= 127);
                            if (_lessEqualsThan) {
                              boolean found = false;
                              _builder.newLineIfNotEmpty();
                              {
                                Set<Integer> _keySet_2 = entries.keySet();
                                for(final int entryKey : _keySet_2) {
                                  AbstractMap.SimpleEntry<String, String> entry = entries.get(Integer.valueOf(entryKey));
                                  _builder.newLineIfNotEmpty();
                                  {
                                    boolean _equals_2 = entry.getKey().equals(key_2);
                                    if (_equals_2) {
                                      String _xblockexpression_18 = null;
                                      {
                                        found = true;
                                        _xblockexpression_18 = "";
                                      }
                                      _builder.append(_xblockexpression_18);
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                              {
                                if ((found == false)) {
                                  String _trim_2 = mapPairOptions.get(test_2).get(op).trim();
                                  AbstractMap.SimpleEntry<String, String> entry_1 = new AbstractMap.SimpleEntry<String, String>(key_2, _trim_2);
                                  _builder.newLineIfNotEmpty();
                                  String _xblockexpression_19 = null;
                                  {
                                    int _plusPlus = keyCounter++;
                                    entries.put(Integer.valueOf(_plusPlus), entry_1);
                                    _xblockexpression_19 = "";
                                  }
                                  _builder.append(_xblockexpression_19);
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                      int counter_2 = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        Set<Integer> _keySet_3 = entries.keySet();
                        for(final int key_3 : _keySet_3) {
                          {
                            if ((counter_2 < min)) {
                              AbstractMap.SimpleEntry<String, String> entry_2 = entries.get(Integer.valueOf(key_3));
                              _builder.newLineIfNotEmpty();
                              _builder.append("<subquestion format=\"html\">");
                              _builder.newLine();
                              _builder.append("<text><![CDATA[<p>");
                              String _key = entry_2.getKey();
                              _builder.append(_key);
                              _builder.append("<br></p>]]></text>");
                              _builder.newLineIfNotEmpty();
                              _builder.append("<answer>");
                              _builder.newLine();
                              _builder.append("<text><![CDATA[<p>");
                              String _value = entry_2.getValue();
                              _builder.append(_value);
                              _builder.append("<br></p>]]></text>");
                              _builder.newLineIfNotEmpty();
                              _builder.append("</answer>");
                              _builder.newLine();
                              _builder.append("</subquestion>");
                              _builder.newLine();
                              String _xblockexpression_20 = null;
                              {
                                counter_2++;
                                _xblockexpression_20 = "";
                              }
                              _builder.append(_xblockexpression_20);
                              _builder.newLineIfNotEmpty();
                            }
                          }
                        }
                      }
                      _builder.append("</question>");
                      _builder.newLine();
                      String _xblockexpression_21 = null;
                      {
                        k_2++;
                        _xblockexpression_21 = "";
                      }
                      _builder.append(_xblockexpression_21);
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _xblockexpression_22 = null;
                      {
                        String _replace = seed.substring("diagrams/".length(), seed.length()).replace(".png", ".py");
                        String _plus_2 = ("code/" + _replace);
                        seed = _plus_2;
                        _xblockexpression_22 = "";
                      }
                      _builder.append(_xblockexpression_22);
                      _builder.newLineIfNotEmpty();
                      String _xblockexpression_23 = null;
                      {
                        File _file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + seed));
                        file = _file;
                        _xblockexpression_23 = "";
                      }
                      _builder.append(_xblockexpression_23);
                      _builder.newLineIfNotEmpty();
                      {
                        if ((file.isFile() && file.exists())) {
                          _builder.append("<question type=\"matching\">");
                          _builder.newLine();
                          _builder.append("<name>");
                          _builder.newLine();
                          _builder.append("<text>Question ");
                          int _xblockexpression_24 = (int) 0;
                          {
                            i++;
                            _xblockexpression_24 = i;
                          }
                          _builder.append(_xblockexpression_24);
                          _builder.append("</text>");
                          _builder.newLineIfNotEmpty();
                          _builder.append("</name>");
                          _builder.newLine();
                          _builder.append("<questiontext format=\"html\">");
                          _builder.newLine();
                          _builder.append("<!--");
                          String question_1 = test_2.getQuestion().replace("\"", "\'");
                          _builder.append("-->");
                          _builder.newLineIfNotEmpty();
                          _builder.append("<text><![CDATA[<p>");
                          String _trim_3 = question_1.trim();
                          _builder.append(_trim_3);
                          _builder.append("<br></p><div>");
                          String _pythonHtmlCode = this.generator.getPythonHtmlCode(seed);
                          _builder.append(_pythonHtmlCode);
                          _builder.append("</div>]]></text>");
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
                          _builder.append("<shuffleanswers>true</shuffleanswers>");
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
                          TreeMap<Integer, AbstractMap.SimpleEntry<String, String>> entries_1 = new TreeMap<Integer, AbstractMap.SimpleEntry<String, String>>();
                          _builder.append("-->");
                          _builder.newLineIfNotEmpty();
                          _builder.append("<!--");
                          int keyCounter_1 = 0;
                          _builder.append("-->");
                          _builder.newLineIfNotEmpty();
                          {
                            List<TestOption> _get_4 = this.generator.getOptions().get(this.exercise).get(test_2).get(rndIndex_2);
                            for(final TestOption op_1 : _get_4) {
                              String outPath = op_1.entry.getKey().getURI().toFileString().replace("\\", "/");
                              _builder.newLineIfNotEmpty();
                              int _lastIndexOf = seed.lastIndexOf("/");
                              int _plus_2 = (_lastIndexOf + 1);
                              String _substring = seed.substring(0, _plus_2);
                              int _lastIndexOf_1 = outPath.lastIndexOf("/");
                              int _plus_3 = (_lastIndexOf_1 + 1);
                              String _replace = outPath.substring(_plus_3, outPath.length()).replace(".model", (("." + Integer.valueOf(rndIndex_2)) + ".py"));
                              String seedPath = (_substring + _replace);
                              _builder.newLineIfNotEmpty();
                              String _xblockexpression_25 = null;
                              {
                                outPath = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + seedPath);
                                _xblockexpression_25 = "";
                              }
                              _builder.append(_xblockexpression_25);
                              _builder.newLineIfNotEmpty();
                              PrintWriter pw = new PrintWriter(outPath, "UTF-8");
                              _builder.newLineIfNotEmpty();
                              pw.println(this.generator.getText(((MatchPairs) this.exercise).getConfig().getIdentifier(), op_1.entry.getKey().getURI().toFileString(), resource));
                              _builder.newLineIfNotEmpty();
                              pw.close();
                              _builder.newLineIfNotEmpty();
                              String _xblockexpression_26 = null;
                              {
                                this.generator.generateHtmlCode(outPath);
                                _xblockexpression_26 = "";
                              }
                              _builder.append(_xblockexpression_26);
                              _builder.newLineIfNotEmpty();
                              String key_4 = seedPath;
                              _builder.newLineIfNotEmpty();
                              {
                                int _length_1 = key_4.length();
                                boolean _lessEqualsThan_1 = (_length_1 <= 127);
                                if (_lessEqualsThan_1) {
                                  boolean found_1 = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    Set<Integer> _keySet_4 = entries_1.keySet();
                                    for(final int entryKey_1 : _keySet_4) {
                                      AbstractMap.SimpleEntry<String, String> entry_3 = entries_1.get(Integer.valueOf(entryKey_1));
                                      _builder.newLineIfNotEmpty();
                                      {
                                        boolean _equals_3 = entry_3.getKey().equals(key_4);
                                        if (_equals_3) {
                                          String _xblockexpression_27 = null;
                                          {
                                            found_1 = true;
                                            _xblockexpression_27 = "";
                                          }
                                          _builder.append(_xblockexpression_27);
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found_1 == false)) {
                                      String _trim_4 = mapPairOptions.get(test_2).get(op_1).trim();
                                      AbstractMap.SimpleEntry<String, String> entry_4 = new AbstractMap.SimpleEntry<String, String>(key_4, _trim_4);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_28 = null;
                                      {
                                        int _plusPlus = keyCounter_1++;
                                        entries_1.put(Integer.valueOf(_plusPlus), entry_4);
                                        _xblockexpression_28 = "";
                                      }
                                      _builder.append(_xblockexpression_28);
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                          int counter_3 = 0;
                          _builder.newLineIfNotEmpty();
                          {
                            Set<Integer> _keySet_5 = entries_1.keySet();
                            for(final int key_5 : _keySet_5) {
                              {
                                if ((counter_3 < min)) {
                                  AbstractMap.SimpleEntry<String, String> entry_5 = entries_1.get(Integer.valueOf(key_5));
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("<subquestion format=\"html\">");
                                  _builder.newLine();
                                  _builder.append("<text><![CDATA[<p>");
                                  String _pythonHtmlCode_1 = this.generator.getPythonHtmlCode(entry_5.getKey());
                                  _builder.append(_pythonHtmlCode_1);
                                  _builder.append("</p>]]></text>");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("<answer>");
                                  _builder.newLine();
                                  _builder.append("<text><![CDATA[<p>");
                                  String _htmlEntities = HTMLUtils.toHtmlEntities(entry_5.getValue().replace("\\n", "").trim());
                                  _builder.append(_htmlEntities);
                                  _builder.append("<br></p>]]></text>");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("</answer>");
                                  _builder.newLine();
                                  _builder.append("</subquestion>");
                                  _builder.newLine();
                                  String _xblockexpression_29 = null;
                                  {
                                    counter_3++;
                                    _xblockexpression_29 = "";
                                  }
                                  _builder.append(_xblockexpression_29);
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                          _builder.append("</question>");
                          _builder.newLine();
                          String _xblockexpression_30 = null;
                          {
                            k_2++;
                            _xblockexpression_30 = "";
                          }
                          _builder.append(_xblockexpression_30);
                          _builder.newLineIfNotEmpty();
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
      _builder.append("<!-- ");
      Integer _set = this.li.set(0, Integer.valueOf(i));
      _builder.append(_set);
      _builder.append(" -->");
      _builder.newLineIfNotEmpty();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
