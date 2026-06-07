package wodeledu.dsls.generator.moodle;

import edutest.MultiChoiceEmendation;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.utils.manager.HTMLUtils;
import wodel.utils.manager.ModelManager;
import wodeledu.dsls.generator.EduTestSuperGenerator;
import wodeledu.dsls.generator.TestOption;

@SuppressWarnings("all")
public class EduTestMoodleGeneratorMultiChoiceEmendation {
  private MultiChoiceEmendation exercise;

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

  public String setUpAndCompile(final EduTestSuperGenerator generator, final MultiChoiceEmendation exercise, final Program program, final Resource resource, final List<Integer> li, final List<EClass> roots) {
    this.project = EduTestMoodleGeneratorMultiChoiceEmendation.projectOf(resource);
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
    _builder.append("<!--");
    Map<Test, List<AbstractMap.SimpleEntry<String, Boolean>>> mapTextOptions = new LinkedHashMap<Test, List<AbstractMap.SimpleEntry<String, Boolean>>>();
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("<!--");
    int min = Integer.MAX_VALUE;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("<!--");
    int rndIndex = (-1);
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    {
      EList<Test> _tests = this.exercise.getTests();
      for(final Test test : _tests) {
        Test t = test;
        _builder.newLineIfNotEmpty();
        {
          if (((this.generator.getOptions().get(this.exercise) != null) && (this.generator.getOptions().get(this.exercise).get(test) != null))) {
            int counter = 0;
            _builder.newLineIfNotEmpty();
            String _xblockexpression = null;
            {
              rndIndex = ModelManager.getRandomIndex(this.generator.getOptions().get(this.exercise).get(test));
              _xblockexpression = "";
            }
            _builder.append(_xblockexpression);
            _builder.newLineIfNotEmpty();
            List<AbstractMap.SimpleEntry<String, Boolean>> textOptions = new ArrayList<AbstractMap.SimpleEntry<String, Boolean>>();
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
                            boolean found = false;
                            _builder.newLineIfNotEmpty();
                            {
                              for(final AbstractMap.SimpleEntry<String, Boolean> entry : textOptions) {
                                {
                                  boolean _equals = entry.getKey().equals(text);
                                  if (_equals) {
                                    String _xblockexpression_1 = null;
                                    {
                                      found = true;
                                      _xblockexpression_1 = "";
                                    }
                                    _builder.append(_xblockexpression_1);
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            {
                              if ((found == false)) {
                                String _xblockexpression_2 = null;
                                {
                                  counter++;
                                  _xblockexpression_2 = "";
                                }
                                _builder.append(_xblockexpression_2);
                                _builder.newLineIfNotEmpty();
                                String _xblockexpression_3 = null;
                                {
                                  AbstractMap.SimpleEntry<String, Boolean> _simpleEntry = new AbstractMap.SimpleEntry<String, Boolean>(text, Boolean.valueOf(false));
                                  textOptions.add(_simpleEntry);
                                  _xblockexpression_3 = "";
                                }
                                _builder.append(_xblockexpression_3);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                String _xblockexpression_4 = null;
                {
                  mapTextOptions.put(test, textOptions);
                  _xblockexpression_4 = "";
                }
                _builder.append(_xblockexpression_4);
                _builder.newLineIfNotEmpty();
                {
                  if ((min > counter)) {
                    String _xblockexpression_5 = null;
                    {
                      min = counter;
                      _xblockexpression_5 = "";
                    }
                    _builder.append(_xblockexpression_5);
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
        List<EClass> statementClass = new ArrayList<EClass>();
        _builder.append("-->");
        _builder.newLineIfNotEmpty();
        {
          for(final EClass root : this.roots) {
            {
              if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() > 0))) {
                {
                  boolean _equals_1 = this.exercise.getConfig().getAnswers().get(0).getName().equals(root.getName());
                  if (_equals_1) {
                    String _xblockexpression_6 = null;
                    {
                      answersClass = root;
                      _xblockexpression_6 = "";
                    }
                    _builder.append(_xblockexpression_6);
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                if (((this.exercise.getConfig().getAnswers() != null) && (this.exercise.getConfig().getAnswers().size() == 0))) {
                  String _xblockexpression_7 = null;
                  {
                    answersClass = root;
                    _xblockexpression_7 = "";
                  }
                  _builder.append(_xblockexpression_7);
                  _builder.newLineIfNotEmpty();
                }
              }
            }
            {
              if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() > 0))) {
                {
                  EList<EClass> _statement = this.exercise.getConfig().getStatement();
                  for(final EClass st : _statement) {
                    {
                      boolean _equals_2 = st.getName().equals(root.getName());
                      if (_equals_2) {
                        String _xblockexpression_8 = null;
                        {
                          statementClass.add(root);
                          _xblockexpression_8 = "";
                        }
                        _builder.append(_xblockexpression_8);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              } else {
                if (((this.exercise.getConfig().getStatement() != null) && (this.exercise.getConfig().getStatement().size() == 0))) {
                  String _xblockexpression_9 = null;
                  {
                    statementClass.add(root);
                    _xblockexpression_9 = "";
                  }
                  _builder.append(_xblockexpression_9);
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
        {
          if ((answersClass == null)) {
            String _xblockexpression_10 = null;
            {
              int _size_1 = this.roots.size();
              int _minus = (_size_1 - 1);
              answersClass = this.roots.get(_minus);
              _xblockexpression_10 = "";
            }
            _builder.append(_xblockexpression_10);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((statementClass == null)) {
            {
              int _size_1 = this.roots.size();
              boolean _greaterThan_1 = (_size_1 > 1);
              if (_greaterThan_1) {
                String _xblockexpression_11 = null;
                {
                  statementClass.add(this.roots.get(1));
                  _xblockexpression_11 = "";
                }
                _builder.append(_xblockexpression_11);
                _builder.newLineIfNotEmpty();
              } else {
                String _xblockexpression_12 = null;
                {
                  statementClass.add(this.roots.get(0));
                  _xblockexpression_12 = "";
                }
                _builder.append(_xblockexpression_12);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if (((this.generator.getOptions().get(this.exercise) != null) && (this.generator.getOptions().get(this.exercise).get(t) != null))) {
            _builder.append("<!--");
            List<String> diagrams = new ArrayList<String>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<String> codes = new ArrayList<String>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<TestOption> answersOptions = new ArrayList<TestOption>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<String> wrongDiagrams = new ArrayList<String>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<String> wrongCodes = new ArrayList<String>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<TestOption> wrongOptions = new ArrayList<TestOption>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            _builder.append("<!--");
            List<TestOption> selectedOptions = new ArrayList<TestOption>();
            _builder.append("-->");
            _builder.newLineIfNotEmpty();
            {
              List<List<TestOption>> _get_2 = this.generator.getOptions().get(this.exercise).get(t);
              boolean _tripleNotEquals = (_get_2 != null);
              if (_tripleNotEquals) {
                {
                  int _size_2 = this.generator.getOptions().get(this.exercise).get(t).size();
                  boolean _greaterThan_2 = (_size_2 > 0);
                  if (_greaterThan_2) {
                    {
                      List<TestOption> _get_3 = this.generator.getOptions().get(this.exercise).get(t).get(rndIndex);
                      for(final TestOption opt_1 : _get_3) {
                        {
                          int _size_3 = opt_1.text.size();
                          boolean _greaterThan_3 = (_size_3 > 0);
                          if (_greaterThan_3) {
                            {
                              if ((opt_1.solution == true)) {
                                _builder.append("<!--");
                                boolean _add = diagrams.add(opt_1.path);
                                _builder.append(_add);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--");
                                boolean _add_1 = codes.add(opt_1.path.replace(".png", ".py"));
                                _builder.append(_add_1);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--");
                                boolean _add_2 = answersOptions.add(opt_1);
                                _builder.append(_add_2);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                      }
                    }
                    {
                      List<TestOption> _get_4 = this.generator.getOptions().get(this.exercise).get(t).get(rndIndex);
                      for(final TestOption opt_2 : _get_4) {
                        {
                          int _size_4 = opt_2.text.size();
                          boolean _greaterThan_4 = (_size_4 > 0);
                          if (_greaterThan_4) {
                            {
                              if ((opt_2.solution == false)) {
                                _builder.append("<!--");
                                boolean _add_3 = wrongDiagrams.add(opt_2.path);
                                _builder.append(_add_3);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--");
                                boolean _add_4 = wrongCodes.add(opt_2.path.replace(".png", ".py"));
                                _builder.append(_add_4);
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<!--");
                                boolean _add_5 = wrongOptions.add(opt_2);
                                _builder.append(_add_5);
                                _builder.append("-->");
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
            String _xblockexpression_13 = null;
            {
              selectedOptions.addAll(answersOptions);
              _xblockexpression_13 = "";
            }
            _builder.append(_xblockexpression_13);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_14 = null;
            {
              selectedOptions.addAll(wrongOptions);
              _xblockexpression_14 = "";
            }
            _builder.append(_xblockexpression_14);
            _builder.newLineIfNotEmpty();
            String _xblockexpression_15 = null;
            {
              Collections.shuffle(selectedOptions);
              _xblockexpression_15 = "";
            }
            _builder.append(_xblockexpression_15);
            _builder.newLineIfNotEmpty();
            {
              int _size_5 = diagrams.size();
              boolean _greaterThan_5 = (_size_5 > 0);
              if (_greaterThan_5) {
                _builder.append("<!--");
                int rndSolution = (-1);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                String _xblockexpression_16 = null;
                {
                  rndSolution = ModelManager.getRandomIndex(diagrams);
                  _xblockexpression_16 = "";
                }
                _builder.append(_xblockexpression_16);
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                List<String> diagram = new ArrayList<String>();
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                List<String> code = new ArrayList<String>();
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                String d = diagrams.get(rndSolution);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                _builder.append("<!--");
                String c = codes.get(rndSolution);
                _builder.append("-->");
                _builder.newLineIfNotEmpty();
                {
                  if (((d.length() > 0) || (c.length() > 0))) {
                    _builder.append("<!--");
                    int _indexOf = d.indexOf("/data/out/");
                    int _length = "/data/out/".length();
                    int _plus = (_indexOf + _length);
                    String data = d.substring(_plus, d.lastIndexOf("/"));
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    int _indexOf_1 = c.indexOf("/data/out/");
                    int _length_1 = "/data/out/".length();
                    int _plus_1 = (_indexOf_1 + _length_1);
                    String cdata = c.substring(_plus_1, c.lastIndexOf("/"));
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    String model = data.substring(0, data.lastIndexOf("/"));
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    String cmodel = cdata.substring(0, cdata.lastIndexOf("/"));
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    int _indexOf_2 = data.indexOf((model + "/"));
                    int _length_2 = (model + "/").length();
                    int _plus_2 = (_indexOf_2 + _length_2);
                    String mutOperator = data.substring(_plus_2, data.length());
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    int _indexOf_3 = cdata.indexOf((cmodel + "/"));
                    int _length_3 = (cmodel + "/").length();
                    int _plus_3 = (_indexOf_3 + _length_3);
                    String cmutOperator = cdata.substring(_plus_3, cdata.length());
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    String _name = statementClass.get(0).getName();
                    String _plus_4 = ((((("diagrams/" + model) + "/") + mutOperator) + "/") + _name);
                    String _plus_5 = (_plus_4 + "_");
                    int _lastIndexOf = d.lastIndexOf("/");
                    int _plus_6 = (_lastIndexOf + 1);
                    String _substring = d.substring(_plus_6, d.length());
                    String checkd = (_plus_5 + _substring);
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    _builder.append("<!--");
                    String _name_1 = statementClass.get(0).getName();
                    String _plus_7 = ((((("code/" + cmodel) + "/") + cmutOperator) + "/") + _name_1);
                    String _plus_8 = (_plus_7 + "_");
                    int _lastIndexOf_1 = c.lastIndexOf("/");
                    int _plus_9 = (_lastIndexOf_1 + 1);
                    String _replace = c.substring(_plus_9, c.length()).replace(".png", ".py");
                    String checkc = (_plus_8 + _replace);
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    {
                      for(final EClass stClass : statementClass) {
                        String _xblockexpression_17 = null;
                        {
                          int _indexOf_4 = d.indexOf("/data/out/");
                          int _length_4 = "/data/out/".length();
                          int _plus_10 = (_indexOf_4 + _length_4);
                          data = d.substring(_plus_10, d.lastIndexOf("/"));
                          _xblockexpression_17 = "";
                        }
                        _builder.append(_xblockexpression_17);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_18 = null;
                        {
                          int _indexOf_4 = c.indexOf("/data/out/");
                          int _length_4 = "/data/out/".length();
                          int _plus_10 = (_indexOf_4 + _length_4);
                          cdata = c.substring(_plus_10, c.lastIndexOf("/"));
                          _xblockexpression_18 = "";
                        }
                        _builder.append(_xblockexpression_18);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_19 = null;
                        {
                          model = data.substring(0, data.lastIndexOf("/"));
                          _xblockexpression_19 = "";
                        }
                        _builder.append(_xblockexpression_19);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_20 = null;
                        {
                          cmodel = cdata.substring(0, cdata.lastIndexOf("/"));
                          _xblockexpression_20 = "";
                        }
                        _builder.append(_xblockexpression_20);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_21 = null;
                        {
                          int _indexOf_4 = data.indexOf((model + "/"));
                          int _length_4 = (model + "/").length();
                          int _plus_10 = (_indexOf_4 + _length_4);
                          mutOperator = data.substring(_plus_10, data.length());
                          _xblockexpression_21 = "";
                        }
                        _builder.append(_xblockexpression_21);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_22 = null;
                        {
                          int _indexOf_4 = cdata.indexOf((cmodel + "/"));
                          int _length_4 = (cmodel + "/").length();
                          int _plus_10 = (_indexOf_4 + _length_4);
                          cmutOperator = cdata.substring(_plus_10, cdata.length());
                          _xblockexpression_22 = "";
                        }
                        _builder.append(_xblockexpression_22);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_23 = null;
                        {
                          String _name_2 = stClass.getName();
                          String _plus_10 = ((((("diagrams/" + model) + "/") + mutOperator) + "/") + _name_2);
                          String _plus_11 = (_plus_10 + "_");
                          int _lastIndexOf_2 = d.lastIndexOf("/");
                          int _plus_12 = (_lastIndexOf_2 + 1);
                          String _substring_1 = d.substring(_plus_12, d.length());
                          String _plus_13 = (_plus_11 + _substring_1);
                          diagram.add(_plus_13);
                          _xblockexpression_23 = "";
                        }
                        _builder.append(_xblockexpression_23);
                        _builder.newLineIfNotEmpty();
                        String _xblockexpression_24 = null;
                        {
                          String _name_2 = stClass.getName();
                          String _plus_10 = ((((("code/" + cmodel) + "/") + cmutOperator) + "/") + _name_2);
                          String _plus_11 = (_plus_10 + "_");
                          int _lastIndexOf_2 = c.lastIndexOf("/");
                          int _plus_12 = (_lastIndexOf_2 + 1);
                          String _replace_1 = c.substring(_plus_12, c.length()).replace(".png", ".py");
                          String _plus_13 = (_plus_11 + _replace_1);
                          code.add(_plus_13);
                          _xblockexpression_24 = "";
                        }
                        _builder.append(_xblockexpression_24);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("<question type=\"multichoice\">");
                    _builder.newLine();
                    _builder.append("<name>");
                    _builder.newLine();
                    _builder.append("<text>Question ");
                    int _xblockexpression_25 = (int) 0;
                    {
                      i++;
                      _xblockexpression_25 = i;
                    }
                    _builder.append(_xblockexpression_25);
                    _builder.append("</text>");
                    _builder.newLineIfNotEmpty();
                    _builder.append("</name>");
                    _builder.newLine();
                    _builder.append("<!--");
                    File file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + checkd));
                    _builder.append("-->");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((file.isFile() && file.exists())) {
                        _builder.append("<questiontext format=\"html\">");
                        _builder.newLine();
                        {
                          if ((((statementClass != null) && (statementClass.size() > 0)) && (answersClass == null))) {
                            {
                              int _size_6 = statementClass.size();
                              boolean _equals_3 = (_size_6 == 1);
                              if (_equals_3) {
                                _builder.append("<!-- ");
                                UUID uuidStatement = UUID.randomUUID();
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                _builder.append("<text><![CDATA[<p>");
                                String _replace_1 = t.getQuestion().replace("\"", "\'");
                                _builder.append(_replace_1);
                                _builder.append("<br><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                                String _stringBase64 = this.generator.getStringBase64(diagram.get(0));
                                _builder.append(_stringBase64);
                                _builder.append("\"></p><!--<br><img src=\"@@PLUGINFILE@@/exercise_");
                                _builder.append(uuidStatement);
                                _builder.append(".png\" alt=\"multiple choice\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br>--></p>]]></text>");
                                _builder.newLineIfNotEmpty();
                              } else {
                                int _size_7 = statementClass.size();
                                boolean _equals_4 = (_size_7 == 2);
                                if (_equals_4) {
                                  _builder.append("<!-- ");
                                  UUID uuidStatement_1 = UUID.randomUUID();
                                  _builder.append("-->");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("<!-- ");
                                  UUID uuidAnswers = UUID.randomUUID();
                                  _builder.append("-->");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("<text><![CDATA[<p>");
                                  String _replace_2 = t.getQuestion().replace("\"", "\'");
                                  _builder.append(_replace_2);
                                  _builder.append("<br><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                                  String _stringBase64_1 = this.generator.getStringBase64(diagram.get(0));
                                  _builder.append(_stringBase64_1);
                                  _builder.append("\"></p><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                                  String _stringBase64_2 = this.generator.getStringBase64(diagram.get(1));
                                  _builder.append(_stringBase64_2);
                                  _builder.append("\"></p><!--<br><img src=\"@@PLUGINFILE@@/exercise_");
                                  _builder.append(uuidStatement_1);
                                  _builder.append(".png\" alt=\"multiple choice\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br><br><img src=\"@@PLUGINFILE@@/exercise_");
                                  _builder.append(uuidAnswers);
                                  _builder.append(".png\" alt=\"multiple choice\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br>--></p>]]></text>");
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                        {
                          if ((((statementClass != null) && (statementClass.size() > 0)) && (answersClass != null))) {
                            _builder.append("<!-- ");
                            UUID uuidStatement_2 = UUID.randomUUID();
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            _builder.append("<!-- ");
                            UUID uuidAnswers_1 = UUID.randomUUID();
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_26 = null;
                            {
                              String _get_5 = diagrams.get(rndSolution);
                              int _indexOf_4 = diagrams.get(rndSolution).indexOf("/data/out/");
                              int _length_4 = "/data/out/".length();
                              int _plus_10 = (_indexOf_4 + _length_4);
                              data = _get_5.substring(_plus_10, diagrams.get(rndSolution).lastIndexOf("/"));
                              _xblockexpression_26 = "";
                            }
                            _builder.append(_xblockexpression_26);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_27 = null;
                            {
                              model = data.substring(0, data.lastIndexOf("/"));
                              _xblockexpression_27 = "";
                            }
                            _builder.append(_xblockexpression_27);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_28 = null;
                            {
                              int _indexOf_4 = data.indexOf((model + "/"));
                              int _length_4 = (model + "/").length();
                              int _plus_10 = (_indexOf_4 + _length_4);
                              mutOperator = data.substring(_plus_10, data.length());
                              _xblockexpression_28 = "";
                            }
                            _builder.append(_xblockexpression_28);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_29 = null;
                            {
                              String _name_2 = answersClass.getName();
                              String _plus_10 = ((((("diagrams/" + model) + "/") + mutOperator) + "/") + _name_2);
                              String _plus_11 = (_plus_10 + "_");
                              String _get_5 = diagrams.get(rndSolution);
                              int _lastIndexOf_2 = diagrams.get(rndSolution).lastIndexOf("/");
                              int _plus_12 = (_lastIndexOf_2 + 1);
                              String _substring_1 = _get_5.substring(_plus_12, diagrams.get(rndSolution).length());
                              String _plus_13 = (_plus_11 + _substring_1);
                              diagram.add(_plus_13);
                              _xblockexpression_29 = "";
                            }
                            _builder.append(_xblockexpression_29);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_30 = null;
                            {
                              String _get_5 = diagram.get(0);
                              String _plus_10 = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + _get_5);
                              File _file = new File(_plus_10);
                              file = _file;
                              _xblockexpression_30 = "";
                            }
                            _builder.append(_xblockexpression_30);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              if ((file.isFile() && file.exists())) {
                                _builder.append("<text><![CDATA[<p>");
                                String _replace_3 = t.getQuestion().replace("\"", "\'");
                                _builder.append(_replace_3);
                                _builder.append("<br><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                                String _stringBase64_3 = this.generator.getStringBase64(diagram.get(0));
                                _builder.append(_stringBase64_3);
                                _builder.append("\"></p><p><img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
                                String _stringBase64_4 = this.generator.getStringBase64(diagram.get(1));
                                _builder.append(_stringBase64_4);
                                _builder.append("\"></p><!--<br><img src=\"@@PLUGINFILE@@/exercise_");
                                _builder.append(uuidStatement_2);
                                _builder.append(".png\" alt=\"multiple choice\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br><br><img src=\"@@PLUGINFILE@@/exercise_");
                                _builder.append(uuidAnswers_1);
                                _builder.append(".png\" alt=\"multiple choice\" width=\"20%\" height=\"20%\" class=\"img-responsive atto_image_button_text-bottom\"><br>--></p>]]></text>");
                                _builder.newLineIfNotEmpty();
                              }
                            }
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
                        _builder.append("<penalty>0.3333333</penalty>");
                        _builder.newLine();
                        _builder.append("<hidden>0</hidden>");
                        _builder.newLine();
                        _builder.append("<idnumber></idnumber>");
                        _builder.newLine();
                        _builder.append("<single>false</single>");
                        _builder.newLine();
                        _builder.append("<shuffleanswers>true</shuffleanswers>");
                        _builder.newLine();
                        _builder.append("<answernumbering>abc");
                        _builder.append("</answernumbering>");
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
                        List<String> solutions = new ArrayList<String>();
                        _builder.append("-->");
                        _builder.newLineIfNotEmpty();
                        {
                          List<List<TestOption>> _get_5 = this.generator.getOptions().get(this.exercise).get(t);
                          boolean _tripleNotEquals_1 = (_get_5 != null);
                          if (_tripleNotEquals_1) {
                            {
                              int _size_8 = this.generator.getOptions().get(this.exercise).get(t).size();
                              boolean _greaterThan_6 = (_size_8 > 0);
                              if (_greaterThan_6) {
                                {
                                  for(final TestOption opt_3 : selectedOptions) {
                                    _builder.append("<!--");
                                    List<String> textOptions_1 = new ArrayList<String>();
                                    _builder.append("-->");
                                    _builder.newLineIfNotEmpty();
                                    {
                                      int _size_9 = opt_3.text.size();
                                      boolean _greaterThan_7 = (_size_9 > 0);
                                      if (_greaterThan_7) {
                                        {
                                          if ((opt_3.solution == true)) {
                                            {
                                              Set<String> _keySet_1 = opt_3.text.keySet();
                                              for(final String key_1 : _keySet_1) {
                                                {
                                                  List<String> _get_6 = opt_3.text.get(key_1);
                                                  for(final String text_1 : _get_6) {
                                                    _builder.append("<!--");
                                                    String value = text_1.trim();
                                                    _builder.append("-->");
                                                    _builder.newLineIfNotEmpty();
                                                    {
                                                      boolean _contains = textOptions_1.contains(value);
                                                      boolean _not = (!_contains);
                                                      if (_not) {
                                                        String _xblockexpression_31 = null;
                                                        {
                                                          solutions.add(value);
                                                          _xblockexpression_31 = "";
                                                        }
                                                        _builder.append(_xblockexpression_31);
                                                        _builder.newLineIfNotEmpty();
                                                        String _xblockexpression_32 = null;
                                                        {
                                                          textOptions_1.add(value);
                                                          _xblockexpression_32 = "";
                                                        }
                                                        _builder.append(_xblockexpression_32);
                                                        _builder.newLineIfNotEmpty();
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          } else {
                                            if ((opt_3.solution == false)) {
                                              {
                                                Set<String> _keySet_2 = opt_3.text.keySet();
                                                for(final String key_2 : _keySet_2) {
                                                  {
                                                    List<String> _get_7 = opt_3.text.get(key_2);
                                                    for(final String text_2 : _get_7) {
                                                      _builder.append("<!--");
                                                      String value_1 = text_2.trim();
                                                      _builder.append("-->");
                                                      _builder.newLineIfNotEmpty();
                                                      {
                                                        boolean _contains_1 = textOptions_1.contains(value_1);
                                                        boolean _not_1 = (!_contains_1);
                                                        if (_not_1) {
                                                          String _xblockexpression_33 = null;
                                                          {
                                                            textOptions_1.add(value_1);
                                                            _xblockexpression_33 = "";
                                                          }
                                                          _builder.append(_xblockexpression_33);
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
                                    }
                                  }
                                }
                              }
                            }
                            _builder.append("<!--");
                            int nSolutions = 0;
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              int _size_10 = this.generator.getOptions().get(this.exercise).get(t).size();
                              boolean _greaterThan_8 = (_size_10 > 0);
                              if (_greaterThan_8) {
                                {
                                  for(final TestOption opt_4 : selectedOptions) {
                                    {
                                      int _size_11 = opt_4.text.size();
                                      boolean _greaterThan_9 = (_size_11 > 0);
                                      if (_greaterThan_9) {
                                        {
                                          if ((opt_4.solution == true)) {
                                            int counter_1 = 0;
                                            _builder.newLineIfNotEmpty();
                                            {
                                              Set<String> _keySet_3 = opt_4.text.keySet();
                                              for(final String key_3 : _keySet_3) {
                                                {
                                                  List<String> _get_8 = opt_4.text.get(key_3);
                                                  for(final String text_3 : _get_8) {
                                                    boolean found_1 = false;
                                                    _builder.newLineIfNotEmpty();
                                                    {
                                                      List<AbstractMap.SimpleEntry<String, Boolean>> _get_9 = mapTextOptions.get(t);
                                                      for(final AbstractMap.SimpleEntry<String, Boolean> entry_1 : _get_9) {
                                                        {
                                                          if ((entry_1.getKey().equals(text_3) && (!(entry_1.getValue()).booleanValue()))) {
                                                            String _xblockexpression_34 = null;
                                                            {
                                                              found_1 = true;
                                                              _xblockexpression_34 = "";
                                                            }
                                                            _builder.append(_xblockexpression_34);
                                                            _builder.newLineIfNotEmpty();
                                                            String _xblockexpression_35 = null;
                                                            {
                                                              entry_1.setValue(Boolean.valueOf(true));
                                                              _xblockexpression_35 = "";
                                                            }
                                                            _builder.append(_xblockexpression_35);
                                                            _builder.newLineIfNotEmpty();
                                                          }
                                                        }
                                                      }
                                                    }
                                                    {
                                                      if ((found_1 == true)) {
                                                        {
                                                          if (((counter_1 < min) && (counter_1 < (solutions.size() + 1)))) {
                                                            String _xblockexpression_36 = null;
                                                            {
                                                              nSolutions++;
                                                              _xblockexpression_36 = "";
                                                            }
                                                            _builder.append(_xblockexpression_36);
                                                            _builder.newLineIfNotEmpty();
                                                            String _xblockexpression_37 = null;
                                                            {
                                                              counter_1++;
                                                              _xblockexpression_37 = "";
                                                            }
                                                            _builder.append(_xblockexpression_37);
                                                            _builder.newLineIfNotEmpty();
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          } else {
                                            if ((opt_4.solution == false)) {
                                              int counter_2 = 0;
                                              _builder.newLineIfNotEmpty();
                                              {
                                                Set<String> _keySet_4 = opt_4.text.keySet();
                                                for(final String key_4 : _keySet_4) {
                                                  {
                                                    List<String> _get_10 = opt_4.text.get(key_4);
                                                    for(final String text_4 : _get_10) {
                                                      boolean found_2 = false;
                                                      _builder.newLineIfNotEmpty();
                                                      {
                                                        List<AbstractMap.SimpleEntry<String, Boolean>> _get_11 = mapTextOptions.get(t);
                                                        for(final AbstractMap.SimpleEntry<String, Boolean> entry_2 : _get_11) {
                                                          {
                                                            if ((entry_2.getKey().equals(text_4) && (!(entry_2.getValue()).booleanValue()))) {
                                                              String _xblockexpression_38 = null;
                                                              {
                                                                found_2 = true;
                                                                _xblockexpression_38 = "";
                                                              }
                                                              _builder.append(_xblockexpression_38);
                                                              _builder.newLineIfNotEmpty();
                                                              String _xblockexpression_39 = null;
                                                              {
                                                                entry_2.setValue(Boolean.valueOf(true));
                                                                _xblockexpression_39 = "";
                                                              }
                                                              _builder.append(_xblockexpression_39);
                                                              _builder.newLineIfNotEmpty();
                                                            }
                                                          }
                                                        }
                                                      }
                                                      {
                                                        if ((found_2 == true)) {
                                                          {
                                                            if (((counter_2 < min) && (counter_2 < (solutions.size() + 1)))) {
                                                              String _xblockexpression_40 = null;
                                                              {
                                                                counter_2++;
                                                                _xblockexpression_40 = "";
                                                              }
                                                              _builder.append(_xblockexpression_40);
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
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            {
                              List<AbstractMap.SimpleEntry<String, Boolean>> _get_12 = mapTextOptions.get(t);
                              for(final AbstractMap.SimpleEntry<String, Boolean> entry_3 : _get_12) {
                                String _xblockexpression_41 = null;
                                {
                                  entry_3.setValue(Boolean.valueOf(false));
                                  _xblockexpression_41 = "";
                                }
                                _builder.append(_xblockexpression_41);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              int _size_12 = solutions.size();
                              boolean _greaterThan_10 = (_size_12 > min);
                              if (_greaterThan_10) {
                                int _size_13 = solutions.size();
                                int _plus_10 = (_size_13 + min);
                                int _plus_11 = (_plus_10 + 1);
                                int _min = min = _plus_11;
                                _builder.append(_min);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              int _size_14 = this.generator.getOptions().get(this.exercise).get(t).size();
                              boolean _greaterThan_11 = (_size_14 > 0);
                              if (_greaterThan_11) {
                                {
                                  for(final TestOption opt_5 : selectedOptions) {
                                    {
                                      int _size_15 = opt_5.text.size();
                                      boolean _greaterThan_12 = (_size_15 > 0);
                                      if (_greaterThan_12) {
                                        {
                                          if ((opt_5.solution == true)) {
                                            int counter_3 = 0;
                                            _builder.newLineIfNotEmpty();
                                            {
                                              Set<String> _keySet_5 = opt_5.text.keySet();
                                              for(final String key_5 : _keySet_5) {
                                                {
                                                  List<String> _get_13 = opt_5.text.get(key_5);
                                                  for(final String text_5 : _get_13) {
                                                    boolean found_3 = false;
                                                    _builder.newLineIfNotEmpty();
                                                    {
                                                      List<AbstractMap.SimpleEntry<String, Boolean>> _get_14 = mapTextOptions.get(t);
                                                      for(final AbstractMap.SimpleEntry<String, Boolean> entry_4 : _get_14) {
                                                        {
                                                          if ((entry_4.getKey().equals(text_5) && (!(entry_4.getValue()).booleanValue()))) {
                                                            String _xblockexpression_42 = null;
                                                            {
                                                              found_3 = true;
                                                              _xblockexpression_42 = "";
                                                            }
                                                            _builder.append(_xblockexpression_42);
                                                            _builder.newLineIfNotEmpty();
                                                            String _xblockexpression_43 = null;
                                                            {
                                                              entry_4.setValue(Boolean.valueOf(true));
                                                              _xblockexpression_43 = "";
                                                            }
                                                            _builder.append(_xblockexpression_43);
                                                            _builder.newLineIfNotEmpty();
                                                          }
                                                        }
                                                      }
                                                    }
                                                    {
                                                      if ((found_3 == true)) {
                                                        {
                                                          if (((counter_3 < min) && (counter_3 < (solutions.size() + 1)))) {
                                                            _builder.append("<!--");
                                                            double fraction = (100.0 / nSolutions);
                                                            _builder.append("-->");
                                                            _builder.newLineIfNotEmpty();
                                                            {
                                                              if (((100 % nSolutions) == 0)) {
                                                                _builder.append("<answer fraction=\"");
                                                                _builder.append((100 / nSolutions));
                                                                _builder.append("\" format=\"html\">");
                                                                _builder.newLineIfNotEmpty();
                                                                _builder.append("<text><![CDATA[<p>");
                                                                String _trim = text_5.trim();
                                                                _builder.append(_trim);
                                                                _builder.append("<br></p>]]></text>");
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
                                                                _builder.append("<!--");
                                                                NumberFormat _numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
                                                                DecimalFormat formatter = ((DecimalFormat) _numberInstance);
                                                                _builder.append("-->");
                                                                _builder.newLineIfNotEmpty();
                                                                String _xblockexpression_44 = null;
                                                                {
                                                                  formatter.applyPattern("###.#####");
                                                                  _xblockexpression_44 = "";
                                                                }
                                                                _builder.append(_xblockexpression_44);
                                                                _builder.newLineIfNotEmpty();
                                                                _builder.append("<answer fraction=\"");
                                                                String _format = formatter.format(fraction);
                                                                _builder.append(_format);
                                                                _builder.append("\" format=\"html\">");
                                                                _builder.newLineIfNotEmpty();
                                                                _builder.append("<text><![CDATA[<p>");
                                                                String _trim_1 = text_5.trim();
                                                                _builder.append(_trim_1);
                                                                _builder.append("<br></p>]]></text>");
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
                                                            String _xblockexpression_45 = null;
                                                            {
                                                              counter_3++;
                                                              _xblockexpression_45 = "";
                                                            }
                                                            _builder.append(_xblockexpression_45);
                                                            _builder.newLineIfNotEmpty();
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          } else {
                                            if ((opt_5.solution == false)) {
                                              int counter_4 = 0;
                                              _builder.newLineIfNotEmpty();
                                              {
                                                Set<String> _keySet_6 = opt_5.text.keySet();
                                                for(final String key_6 : _keySet_6) {
                                                  {
                                                    List<String> _get_15 = opt_5.text.get(key_6);
                                                    for(final String text_6 : _get_15) {
                                                      boolean found_4 = false;
                                                      _builder.newLineIfNotEmpty();
                                                      {
                                                        List<AbstractMap.SimpleEntry<String, Boolean>> _get_16 = mapTextOptions.get(t);
                                                        for(final AbstractMap.SimpleEntry<String, Boolean> entry_5 : _get_16) {
                                                          {
                                                            if ((entry_5.getKey().equals(text_6) && (!(entry_5.getValue()).booleanValue()))) {
                                                              String _xblockexpression_46 = null;
                                                              {
                                                                found_4 = true;
                                                                _xblockexpression_46 = "";
                                                              }
                                                              _builder.append(_xblockexpression_46);
                                                              _builder.newLineIfNotEmpty();
                                                              String _xblockexpression_47 = null;
                                                              {
                                                                entry_5.setValue(Boolean.valueOf(true));
                                                                _xblockexpression_47 = "";
                                                              }
                                                              _builder.append(_xblockexpression_47);
                                                              _builder.newLineIfNotEmpty();
                                                            }
                                                          }
                                                        }
                                                      }
                                                      {
                                                        if ((found_4 == true)) {
                                                          {
                                                            if (((counter_4 < min) && (counter_4 < (solutions.size() + 1)))) {
                                                              _builder.append("<answer fraction=\"0\" format=\"html\">");
                                                              _builder.newLine();
                                                              _builder.append("<text><![CDATA[<p>");
                                                              String _trim_2 = text_6.trim();
                                                              _builder.append(_trim_2);
                                                              _builder.append("<br></p>]]></text>");
                                                              _builder.newLineIfNotEmpty();
                                                              _builder.append("<feedback format=\"html\">");
                                                              _builder.newLine();
                                                              _builder.append("<text></text>");
                                                              _builder.newLine();
                                                              _builder.append("</feedback>");
                                                              _builder.newLine();
                                                              _builder.append("</answer>");
                                                              _builder.newLine();
                                                              String _xblockexpression_48 = null;
                                                              {
                                                                counter_4++;
                                                                _xblockexpression_48 = "";
                                                              }
                                                              _builder.append(_xblockexpression_48);
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
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      } else {
                        String _xblockexpression_49 = null;
                        {
                          File _file = new File(((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + checkc));
                          file = _file;
                          _xblockexpression_49 = "";
                        }
                        _builder.append(_xblockexpression_49);
                        _builder.newLineIfNotEmpty();
                        {
                          if ((file.isFile() && file.exists())) {
                            _builder.append("<questiontext format=\"html\">");
                            _builder.newLine();
                            _builder.append("<text><![CDATA[<p>");
                            String _replace_4 = t.getQuestion().replace("\"", "\'");
                            _builder.append(_replace_4);
                            _builder.append("<br></p><div>");
                            String _pythonHtmlCode = this.generator.getPythonHtmlCode(checkc);
                            _builder.append(_pythonHtmlCode);
                            _builder.append("</div>]]></text>");
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_50 = null;
                            {
                              String _get_17 = codes.get(rndSolution);
                              int _indexOf_4 = codes.get(rndSolution).indexOf("/data/out/");
                              int _length_4 = "/data/out/".length();
                              int _plus_12 = (_indexOf_4 + _length_4);
                              cdata = _get_17.substring(_plus_12, codes.get(rndSolution).lastIndexOf("/"));
                              _xblockexpression_50 = "";
                            }
                            _builder.append(_xblockexpression_50);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_51 = null;
                            {
                              cmodel = cdata.substring(0, cdata.lastIndexOf("/"));
                              _xblockexpression_51 = "";
                            }
                            _builder.append(_xblockexpression_51);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_52 = null;
                            {
                              int _indexOf_4 = cdata.indexOf((cmodel + "/"));
                              int _length_4 = (cmodel + "/").length();
                              int _plus_12 = (_indexOf_4 + _length_4);
                              cmutOperator = cdata.substring(_plus_12, cdata.length());
                              _xblockexpression_52 = "";
                            }
                            _builder.append(_xblockexpression_52);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_53 = null;
                            {
                              String _name_2 = answersClass.getName();
                              String _plus_12 = ((((("code/" + cmodel) + "/") + cmutOperator) + "/") + _name_2);
                              String _plus_13 = (_plus_12 + "_");
                              String _get_17 = codes.get(rndSolution);
                              int _lastIndexOf_2 = codes.get(rndSolution).lastIndexOf("/");
                              int _plus_14 = (_lastIndexOf_2 + 1);
                              String _replace_5 = _get_17.substring(_plus_14, codes.get(rndSolution).length()).replace(".png", ".py");
                              String _plus_15 = (_plus_13 + _replace_5);
                              code.add(_plus_15);
                              _xblockexpression_53 = "";
                            }
                            _builder.append(_xblockexpression_53);
                            _builder.newLineIfNotEmpty();
                            String _xblockexpression_54 = null;
                            {
                              String _get_17 = code.get(0);
                              String _plus_12 = ((((this.workspacePath + "/") + this.projectName) + "/src-gen/html/") + _get_17);
                              File _file = new File(_plus_12);
                              file = _file;
                              _xblockexpression_54 = "";
                            }
                            _builder.append(_xblockexpression_54);
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              if ((file.isFile() && file.exists())) {
                                _builder.append("<text><![CDATA[<p>");
                                String _replace_5 = t.getQuestion().replace("\"", "\'");
                                _builder.append(_replace_5);
                                _builder.append("<br></p><div>");
                                String _pythonHtmlCode_1 = this.generator.getPythonHtmlCode(code.get(0));
                                _builder.append(_pythonHtmlCode_1);
                                _builder.append("</div>]]></text>");
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
                            _builder.append("<penalty>0.3333333</penalty>");
                            _builder.newLine();
                            _builder.append("<hidden>0</hidden>");
                            _builder.newLine();
                            _builder.append("<idnumber></idnumber>");
                            _builder.newLine();
                            _builder.append("<single>false</single>");
                            _builder.newLine();
                            _builder.append("<shuffleanswers>true</shuffleanswers>");
                            _builder.newLine();
                            _builder.append("<answernumbering>abc");
                            _builder.append("</answernumbering>");
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
                            ArrayList<String> solutions_1 = new ArrayList<String>();
                            _builder.append("-->");
                            _builder.newLineIfNotEmpty();
                            {
                              List<List<TestOption>> _get_17 = this.generator.getOptions().get(this.exercise).get(t);
                              boolean _tripleNotEquals_2 = (_get_17 != null);
                              if (_tripleNotEquals_2) {
                                {
                                  int _size_16 = this.generator.getOptions().get(this.exercise).get(t).size();
                                  boolean _greaterThan_13 = (_size_16 > 0);
                                  if (_greaterThan_13) {
                                    {
                                      for(final TestOption opt_6 : selectedOptions) {
                                        _builder.append("<!--");
                                        List<String> textOptions_2 = new ArrayList<String>();
                                        _builder.append("-->");
                                        _builder.newLineIfNotEmpty();
                                        {
                                          int _size_17 = opt_6.text.size();
                                          boolean _greaterThan_14 = (_size_17 > 0);
                                          if (_greaterThan_14) {
                                            {
                                              if ((opt_6.solution == true)) {
                                                {
                                                  Set<String> _keySet_7 = opt_6.text.keySet();
                                                  for(final String key_7 : _keySet_7) {
                                                    {
                                                      List<String> _get_18 = opt_6.text.get(key_7);
                                                      for(final String text_7 : _get_18) {
                                                        _builder.append("<!--");
                                                        String value_2 = text_7.trim();
                                                        _builder.append("-->");
                                                        _builder.newLineIfNotEmpty();
                                                        {
                                                          boolean _contains_2 = textOptions_2.contains(value_2);
                                                          boolean _not_2 = (!_contains_2);
                                                          if (_not_2) {
                                                            String _xblockexpression_55 = null;
                                                            {
                                                              solutions_1.add(value_2);
                                                              _xblockexpression_55 = "";
                                                            }
                                                            _builder.append(_xblockexpression_55);
                                                            _builder.newLineIfNotEmpty();
                                                            String _xblockexpression_56 = null;
                                                            {
                                                              textOptions_2.add(value_2);
                                                              _xblockexpression_56 = "";
                                                            }
                                                            _builder.append(_xblockexpression_56);
                                                            _builder.newLineIfNotEmpty();
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              } else {
                                                if ((opt_6.solution == false)) {
                                                  {
                                                    Set<String> _keySet_8 = opt_6.text.keySet();
                                                    for(final String key_8 : _keySet_8) {
                                                      {
                                                        List<String> _get_19 = opt_6.text.get(key_8);
                                                        for(final String text_8 : _get_19) {
                                                          _builder.append("<!--");
                                                          String value_3 = text_8.trim();
                                                          _builder.append("-->");
                                                          _builder.newLineIfNotEmpty();
                                                          {
                                                            boolean _contains_3 = textOptions_2.contains(value_3);
                                                            boolean _not_3 = (!_contains_3);
                                                            if (_not_3) {
                                                              String _xblockexpression_57 = null;
                                                              {
                                                                textOptions_2.add(value_3);
                                                                _xblockexpression_57 = "";
                                                              }
                                                              _builder.append(_xblockexpression_57);
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
                                        }
                                      }
                                    }
                                  }
                                }
                                _builder.append("<!--");
                                int nSolutions_1 = 0;
                                _builder.append("-->");
                                _builder.newLineIfNotEmpty();
                                {
                                  int _size_18 = this.generator.getOptions().get(this.exercise).get(t).size();
                                  boolean _greaterThan_15 = (_size_18 > 0);
                                  if (_greaterThan_15) {
                                    {
                                      for(final TestOption opt_7 : selectedOptions) {
                                        {
                                          int _size_19 = opt_7.text.size();
                                          boolean _greaterThan_16 = (_size_19 > 0);
                                          if (_greaterThan_16) {
                                            {
                                              if ((opt_7.solution == true)) {
                                                int counter_5 = 0;
                                                _builder.newLineIfNotEmpty();
                                                {
                                                  Set<String> _keySet_9 = opt_7.text.keySet();
                                                  for(final String key_9 : _keySet_9) {
                                                    {
                                                      List<String> _get_20 = opt_7.text.get(key_9);
                                                      for(final String text_9 : _get_20) {
                                                        boolean found_5 = false;
                                                        _builder.newLineIfNotEmpty();
                                                        {
                                                          List<AbstractMap.SimpleEntry<String, Boolean>> _get_21 = mapTextOptions.get(t);
                                                          for(final AbstractMap.SimpleEntry<String, Boolean> entry_6 : _get_21) {
                                                            {
                                                              if ((entry_6.getKey().equals(text_9) && (!(entry_6.getValue()).booleanValue()))) {
                                                                String _xblockexpression_58 = null;
                                                                {
                                                                  found_5 = true;
                                                                  _xblockexpression_58 = "";
                                                                }
                                                                _builder.append(_xblockexpression_58);
                                                                _builder.newLineIfNotEmpty();
                                                                String _xblockexpression_59 = null;
                                                                {
                                                                  entry_6.setValue(Boolean.valueOf(true));
                                                                  _xblockexpression_59 = "";
                                                                }
                                                                _builder.append(_xblockexpression_59);
                                                                _builder.newLineIfNotEmpty();
                                                              }
                                                            }
                                                          }
                                                        }
                                                        {
                                                          if ((found_5 == true)) {
                                                            {
                                                              if ((counter_5 < (min + 1))) {
                                                                String _xblockexpression_60 = null;
                                                                {
                                                                  nSolutions_1++;
                                                                  _xblockexpression_60 = "";
                                                                }
                                                                _builder.append(_xblockexpression_60);
                                                                _builder.newLineIfNotEmpty();
                                                                String _xblockexpression_61 = null;
                                                                {
                                                                  counter_5++;
                                                                  _xblockexpression_61 = "";
                                                                }
                                                                _builder.append(_xblockexpression_61);
                                                                _builder.newLineIfNotEmpty();
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              } else {
                                                if ((opt_7.solution == false)) {
                                                  int counter_6 = 0;
                                                  _builder.newLineIfNotEmpty();
                                                  {
                                                    Set<String> _keySet_10 = opt_7.text.keySet();
                                                    for(final String key_10 : _keySet_10) {
                                                      {
                                                        List<String> _get_22 = opt_7.text.get(key_10);
                                                        for(final String text_10 : _get_22) {
                                                          boolean found_6 = false;
                                                          _builder.newLineIfNotEmpty();
                                                          {
                                                            List<AbstractMap.SimpleEntry<String, Boolean>> _get_23 = mapTextOptions.get(t);
                                                            for(final AbstractMap.SimpleEntry<String, Boolean> entry_7 : _get_23) {
                                                              {
                                                                if ((entry_7.getKey().equals(text_10) && (!(entry_7.getValue()).booleanValue()))) {
                                                                  String _xblockexpression_62 = null;
                                                                  {
                                                                    found_6 = true;
                                                                    _xblockexpression_62 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_62);
                                                                  _builder.newLineIfNotEmpty();
                                                                  String _xblockexpression_63 = null;
                                                                  {
                                                                    entry_7.setValue(Boolean.valueOf(true));
                                                                    _xblockexpression_63 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_63);
                                                                  _builder.newLineIfNotEmpty();
                                                                }
                                                              }
                                                            }
                                                          }
                                                          {
                                                            if ((found_6 == true)) {
                                                              {
                                                                if ((counter_6 < (min + 1))) {
                                                                  String _xblockexpression_64 = null;
                                                                  {
                                                                    counter_6++;
                                                                    _xblockexpression_64 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_64);
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
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                                {
                                  List<AbstractMap.SimpleEntry<String, Boolean>> _get_24 = mapTextOptions.get(t);
                                  for(final AbstractMap.SimpleEntry<String, Boolean> entry_8 : _get_24) {
                                    String _xblockexpression_65 = null;
                                    {
                                      entry_8.setValue(Boolean.valueOf(false));
                                      _xblockexpression_65 = "";
                                    }
                                    _builder.append(_xblockexpression_65);
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                {
                                  int _size_20 = solutions_1.size();
                                  boolean _greaterThan_17 = (_size_20 > min);
                                  if (_greaterThan_17) {
                                    int _size_21 = solutions_1.size();
                                    int _plus_12 = (_size_21 + min);
                                    int _plus_13 = (_plus_12 + 1);
                                    int _min_1 = min = _plus_13;
                                    _builder.append(_min_1);
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                {
                                  int _size_22 = this.generator.getOptions().get(this.exercise).get(t).size();
                                  boolean _greaterThan_18 = (_size_22 > 0);
                                  if (_greaterThan_18) {
                                    {
                                      for(final TestOption opt_8 : selectedOptions) {
                                        {
                                          int _size_23 = opt_8.text.size();
                                          boolean _greaterThan_19 = (_size_23 > 0);
                                          if (_greaterThan_19) {
                                            {
                                              if ((opt_8.solution == true)) {
                                                int counter_7 = 0;
                                                _builder.newLineIfNotEmpty();
                                                {
                                                  Set<String> _keySet_11 = opt_8.text.keySet();
                                                  for(final String key_11 : _keySet_11) {
                                                    {
                                                      List<String> _get_25 = opt_8.text.get(key_11);
                                                      for(final String text_11 : _get_25) {
                                                        boolean found_7 = false;
                                                        _builder.newLineIfNotEmpty();
                                                        {
                                                          List<AbstractMap.SimpleEntry<String, Boolean>> _get_26 = mapTextOptions.get(t);
                                                          for(final AbstractMap.SimpleEntry<String, Boolean> entry_9 : _get_26) {
                                                            {
                                                              if ((entry_9.getKey().equals(text_11) && (!(entry_9.getValue()).booleanValue()))) {
                                                                String _xblockexpression_66 = null;
                                                                {
                                                                  found_7 = true;
                                                                  _xblockexpression_66 = "";
                                                                }
                                                                _builder.append(_xblockexpression_66);
                                                                _builder.newLineIfNotEmpty();
                                                                String _xblockexpression_67 = null;
                                                                {
                                                                  entry_9.setValue(Boolean.valueOf(true));
                                                                  _xblockexpression_67 = "";
                                                                }
                                                                _builder.append(_xblockexpression_67);
                                                                _builder.newLineIfNotEmpty();
                                                              }
                                                            }
                                                          }
                                                        }
                                                        {
                                                          if ((found_7 == true)) {
                                                            {
                                                              if (((counter_7 < min) && (counter_7 < (solutions_1.size() + 1)))) {
                                                                _builder.append("<!--");
                                                                double fraction_1 = (100.0 / nSolutions_1);
                                                                _builder.append("-->");
                                                                _builder.newLineIfNotEmpty();
                                                                {
                                                                  if (((100 % nSolutions_1) == 0)) {
                                                                    _builder.append("<answer fraction=\"");
                                                                    _builder.append((100 / nSolutions_1));
                                                                    _builder.append("\" format=\"html\">");
                                                                    _builder.newLineIfNotEmpty();
                                                                    _builder.append("<text><![CDATA[<p>");
                                                                    String _htmlEntities = HTMLUtils.toHtmlEntities(text_11.replace("\\n", "").trim());
                                                                    _builder.append(_htmlEntities);
                                                                    _builder.append("<br></p>]]></text>");
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
                                                                    _builder.append("<!--");
                                                                    NumberFormat _numberInstance_1 = NumberFormat.getNumberInstance(Locale.ENGLISH);
                                                                    DecimalFormat formatter_1 = ((DecimalFormat) _numberInstance_1);
                                                                    _builder.append("-->");
                                                                    _builder.newLineIfNotEmpty();
                                                                    String _xblockexpression_68 = null;
                                                                    {
                                                                      formatter_1.applyPattern("###.#####");
                                                                      _xblockexpression_68 = "";
                                                                    }
                                                                    _builder.append(_xblockexpression_68);
                                                                    _builder.newLineIfNotEmpty();
                                                                    _builder.append("<answer fraction=\"");
                                                                    String _format_1 = formatter_1.format(fraction_1);
                                                                    _builder.append(_format_1);
                                                                    _builder.append("\" format=\"html\">");
                                                                    _builder.newLineIfNotEmpty();
                                                                    _builder.append("<text><![CDATA[<p>");
                                                                    String _htmlEntities_1 = HTMLUtils.toHtmlEntities(text_11.replace("\\n", "").trim());
                                                                    _builder.append(_htmlEntities_1);
                                                                    _builder.append("<br></p>]]></text>");
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
                                                                String _xblockexpression_69 = null;
                                                                {
                                                                  counter_7++;
                                                                  _xblockexpression_69 = "";
                                                                }
                                                                _builder.append(_xblockexpression_69);
                                                                _builder.newLineIfNotEmpty();
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              } else {
                                                if ((opt_8.solution == false)) {
                                                  int counter_8 = 0;
                                                  _builder.newLineIfNotEmpty();
                                                  {
                                                    Set<String> _keySet_12 = opt_8.text.keySet();
                                                    for(final String key_12 : _keySet_12) {
                                                      {
                                                        List<String> _get_27 = opt_8.text.get(key_12);
                                                        for(final String text_12 : _get_27) {
                                                          boolean found_8 = false;
                                                          _builder.newLineIfNotEmpty();
                                                          {
                                                            List<AbstractMap.SimpleEntry<String, Boolean>> _get_28 = mapTextOptions.get(t);
                                                            for(final AbstractMap.SimpleEntry<String, Boolean> entry_10 : _get_28) {
                                                              {
                                                                if ((entry_10.getKey().equals(text_12) && (!(entry_10.getValue()).booleanValue()))) {
                                                                  String _xblockexpression_70 = null;
                                                                  {
                                                                    found_8 = true;
                                                                    _xblockexpression_70 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_70);
                                                                  _builder.newLineIfNotEmpty();
                                                                  String _xblockexpression_71 = null;
                                                                  {
                                                                    entry_10.setValue(Boolean.valueOf(true));
                                                                    _xblockexpression_71 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_71);
                                                                  _builder.newLineIfNotEmpty();
                                                                }
                                                              }
                                                            }
                                                          }
                                                          {
                                                            if ((found_8 == true)) {
                                                              {
                                                                if (((counter_8 < min) && (counter_8 < (solutions_1.size() + 1)))) {
                                                                  _builder.append("<answer fraction=\"0\" format=\"html\">");
                                                                  _builder.newLine();
                                                                  _builder.append("<text><![CDATA[<p>");
                                                                  String _htmlEntities_2 = HTMLUtils.toHtmlEntities(text_12.replace("\\n", "").replace("\\n", "").trim());
                                                                  _builder.append(_htmlEntities_2);
                                                                  _builder.append("<br></p>]]></text>");
                                                                  _builder.newLineIfNotEmpty();
                                                                  _builder.append("<feedback format=\"html\">");
                                                                  _builder.newLine();
                                                                  _builder.append("<text></text>");
                                                                  _builder.newLine();
                                                                  _builder.append("</feedback>");
                                                                  _builder.newLine();
                                                                  _builder.append("</answer>");
                                                                  _builder.newLine();
                                                                  String _xblockexpression_72 = null;
                                                                  {
                                                                    counter_8++;
                                                                    _xblockexpression_72 = "";
                                                                  }
                                                                  _builder.append(_xblockexpression_72);
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
