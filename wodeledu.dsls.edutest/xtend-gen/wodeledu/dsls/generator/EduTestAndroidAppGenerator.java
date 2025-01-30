package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import edutest.AlternativeResponse;
import edutest.MatchPairs;
import edutest.MultiChoiceDiagram;
import edutest.MultiChoiceEmendation;
import edutest.MutatorTests;
import edutest.Program;
import edutest.Test;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.osgi.framework.Bundle;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;

@SuppressWarnings("all")
public class EduTestAndroidAppGenerator extends EduTestSuperGenerator {
  private List<EObject> blocks;

  private String localProperties;

  private String xmlFileName;

  private String fileName;

  private String stringXmlFileName;

  private String stringXmlFileNameEs;

  private String userProfile = "C\\:\\\\Users\\\\User";

  private String currentDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).format(new Date(System.currentTimeMillis()));

  private List<EPackage> metamodel;

  private List<EClass> roots;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      try {
        int i = 0;
        String _replaceAll = resource.getURI().lastSegment().replaceAll(".test", ".model");
        String xmiFileName = ((((("file:/" + this.projectPath) + "/") + this.outputFolder) + "/") + _replaceAll);
        final Bundle bundle = Platform.getBundle("wodel.models");
        final URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
        final String mutatorecore = FileLocator.resolve(fileURL).getFile();
        final List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
        final Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
        this.blocks = ModelManager.getObjectsOfType("Block", mutatormodel);
        String userProfileValue = System.getenv("USERPROFILE");
        if (((userProfileValue != null) && (userProfileValue.length() > 0))) {
          String _substring = userProfileValue.substring(0, 1);
          String _plus = (_substring + "\\");
          this.userProfile = _plus;
          String _userProfile = this.userProfile;
          this.userProfile = (_userProfile + ":");
          String _userProfile_1 = this.userProfile;
          this.userProfile = (_userProfile_1 + "\\\\");
          int indexOfSlash = 3;
          while (((indexOfSlash > 0) && (indexOfSlash < userProfileValue.length()))) {
            {
              userProfileValue = userProfileValue.substring(indexOfSlash, userProfileValue.length());
              int _indexOf = userProfileValue.substring(0, userProfileValue.length()).indexOf("\\");
              boolean _greaterThan = (_indexOf > 0);
              if (_greaterThan) {
                int _indexOf_1 = userProfileValue.substring(0, userProfileValue.length()).indexOf("\\");
                int _plus_1 = (_indexOf_1 + 1);
                indexOfSlash = _plus_1;
              } else {
                int _length = userProfileValue.length();
                int _plus_2 = (_length + 1);
                indexOfSlash = _plus_2;
              }
              String _userProfile_2 = this.userProfile;
              String _substring_1 = userProfileValue.substring(0, (indexOfSlash - 1));
              String _plus_3 = (_substring_1 + "\\\\");
              this.userProfile = (_userProfile_2 + _plus_3);
            }
          }
        }
        Iterable<Program> _filter = Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class);
        for (final Program p : _filter) {
          {
            if ((i == 0)) {
              this.localProperties = "../app/mobile/local.properties";
              this.xmlFileName = "../app/mobile/app/src/main/res/layout/activity_main.xml";
              this.fileName = "../app/mobile/app/src/main/java/org/example/esquematfg/MainActivity.java";
              this.stringXmlFileName = "../app/mobile/app/src/main/res/values/strings.xml";
              this.stringXmlFileNameEs = "../app/mobile/app/src/main/res/values-es/strings.xml";
            } else {
              this.localProperties = "../app/mobile/local.properties";
              this.xmlFileName = "../app/mobile/app/src/main/res/layout/activity_main.xml";
              this.fileName = "../app/mobile/app/src/main/java/org/example/esquematfg/MainActivity.java";
              this.stringXmlFileName = "../app/mobile/app/src/main/res/values/strings.xml";
              this.stringXmlFileNameEs = "../app/mobile/app/src/main/res/values-es/strings.xml";
            }
            ArrayList<EPackage> _arrayList = new ArrayList<EPackage>();
            this.metamodel = _arrayList;
            this.metamodel.addAll(ModelManager.loadMetaModel(p.getMetamodel()));
            ArrayList<EClass> _arrayList_1 = new ArrayList<EClass>();
            this.roots = _arrayList_1;
            this.roots.addAll(ModelManager.getRootEClasses(this.metamodel));
            fsa.generateFile(this.fileName, this.compile(p, resource));
            fsa.generateFile(this.localProperties, this.localPropertiesCompile(p, resource));
            fsa.generateFile(this.xmlFileName, this.xmlCompile(p, resource));
            fsa.generateFile(this.stringXmlFileName, this.stringXmlCompile(p, resource));
            fsa.generateFile(this.stringXmlFileNameEs, this.stringXmlCompileEs(p, resource));
            i++;
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof ModelNotFoundException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * MobileApp code will be generated here!!
   */
  public CharSequence compile(final Program program, final Resource resource) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      String _xblockexpression = null;
      {
        this.buildOptions(program, resource, this.blocks, this.roots, program.getClass());
        _xblockexpression = "";
      }
      _builder.append(_xblockexpression, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      HashMap<Integer, String> drawable = new HashMap<Integer, String>();
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      HashMap<Integer, HashMap<Integer, String>> drawableAnswer = new HashMap<Integer, HashMap<Integer, String>>();
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      int i = 0;
      _builder.newLineIfNotEmpty();
      {
        EList<MutatorTests> _exercises = program.getExercises();
        for(final MutatorTests exercise : _exercises) {
          {
            if ((exercise instanceof AlternativeResponse)) {
              {
                EList<Test> _tests = ((AlternativeResponse)exercise).getTests();
                for(final Test test : _tests) {
                  {
                    int _size = this.rand.get(exercise).get(test).size();
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("\t");
                      List<String> diagram = this.rand.get(exercise).get(test).get(Integer.valueOf(0));
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _replace = test.getSource().replace(".model", "");
                      String _plus = ((this.projectPath + "/src-gen/html/diagrams/") + _replace);
                      String _plus_1 = (_plus + "/");
                      String _plus_2 = (_plus_1 + diagram);
                      File _file = new File(_plus_2);
                      File _file_1 = new File((((this.projectPath + "/app/mobile/app/src/main/res/drawable/q") + Integer.valueOf(i)) + "_enunciado.png"));
                      IOUtils.copyFile(_file, _file_1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _put = drawable.put(Integer.valueOf(i), (("q" + Integer.valueOf(i)) + "_enunciado.png"));
                      _builder.append(_put, "\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _xblockexpression_1 = null;
                      {
                        i++;
                        _xblockexpression_1 = "";
                      }
                      _builder.append(_xblockexpression_1, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
          {
            if ((exercise instanceof MultiChoiceEmendation)) {
              {
                EList<Test> _tests_1 = ((MultiChoiceEmendation)exercise).getTests();
                for(final Test test_1 : _tests_1) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_1) != null))) {
                      {
                        List<List<EduTestSuperGenerator.TestOption>> _get = this.options.get(exercise).get(test_1);
                        boolean _tripleNotEquals = (_get != null);
                        if (_tripleNotEquals) {
                          int rndIndex = ModelManager.getRandomIndex(this.options.get(exercise).get(test_1));
                          _builder.newLineIfNotEmpty();
                          {
                            List<EduTestSuperGenerator.TestOption> _get_1 = this.options.get(exercise).get(test_1).get(rndIndex);
                            for(final EduTestSuperGenerator.TestOption opt : _get_1) {
                              {
                                int _size_1 = opt.text.size();
                                boolean _greaterThan_1 = (_size_1 > 0);
                                if (_greaterThan_1) {
                                  {
                                    if ((opt.solution == true)) {
                                      String diagram_1 = opt.path;
                                      _builder.newLineIfNotEmpty();
                                      File _file_2 = new File(((this.projectPath + "/src-gen/html/") + diagram_1));
                                      File _file_3 = new File((((this.projectPath + "/app/mobile/app/src/main/res/drawable/q") + Integer.valueOf(i)) + "_enunciado.png"));
                                      IOUtils.copyFile(_file_2, _file_3);
                                      _builder.newLineIfNotEmpty();
                                      String _put_1 = drawable.put(Integer.valueOf(i), (("q" + Integer.valueOf(i)) + "_enunciado.png"));
                                      _builder.append(_put_1);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t \t\t\t\t\t\t\t\t");
                                      String _xblockexpression_2 = null;
                                      {
                                        i++;
                                        _xblockexpression_2 = "";
                                      }
                                      _builder.append(_xblockexpression_2, "\t\t \t\t\t\t\t\t\t\t");
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
          {
            if ((exercise instanceof MultiChoiceDiagram)) {
              {
                EList<Test> _tests_2 = ((MultiChoiceDiagram)exercise).getTests();
                for(final Test test_2 : _tests_2) {
                  _builder.append("\t");
                  int j = 0;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  HashMap<Integer, String> diccAux = new HashMap<Integer, String>();
                  _builder.newLineIfNotEmpty();
                  {
                    Set<EClass> _keySet = this.diagrams.get(exercise).get(test_2).keySet();
                    for(final EClass eclass : _keySet) {
                      {
                        List<String> _get_2 = this.diagrams.get(exercise).get(test_2).get(eclass);
                        for(final String diag : _get_2) {
                          _builder.append("\t");
                          String _replace_1 = test_2.getSource().replace(".model", "");
                          String _plus_3 = ((this.projectPath + "/src-gen/html/diagrams/") + _replace_1);
                          String _plus_4 = (_plus_3 + "/");
                          String _plus_5 = (_plus_4 + diag);
                          File _file_4 = new File(_plus_5);
                          File _file_5 = new File((((((this.projectPath + "/app/mobile/app/src/main/res/drawable/q") + Integer.valueOf(i)) + "_respuesta") + Integer.valueOf(j)) + ".png"));
                          IOUtils.copyFile(_file_4, _file_5);
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          String _put_2 = diccAux.put(Integer.valueOf(j), (((("q" + Integer.valueOf(i)) + "_respuesta") + Integer.valueOf(j)) + ".png"));
                          _builder.append(_put_2, "\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          String _xblockexpression_3 = null;
                          {
                            j++;
                            _xblockexpression_3 = "";
                          }
                          _builder.append(_xblockexpression_3, "\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                  _builder.append("\t");
                  HashMap<Integer, String> _put_3 = drawableAnswer.put(Integer.valueOf(i), diccAux);
                  _builder.append(_put_3, "\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _xblockexpression_4 = null;
                  {
                    i++;
                    _xblockexpression_4 = "";
                  }
                  _builder.append(_xblockexpression_4, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          {
            if ((exercise instanceof MatchPairs)) {
              _builder.append("\t\t\t        ");
              int min = Integer.MAX_VALUE;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int index = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int max = Integer.MIN_VALUE;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_3 = ((MatchPairs)exercise).getTests();
                for(final Test test_3 : _tests_3) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_3) != null))) {
                      _builder.append("\t");
                      List<String> textOptions = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      int k = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      int counter = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t        ");
                      int rndIndex_1 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_3));
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_3 = this.options.get(exercise).get(test_3).get(rndIndex_1);
                        for(final EduTestSuperGenerator.TestOption opt_1 : _get_3) {
                          {
                            Set<String> _keySet_1 = opt_1.text.keySet();
                            for(final String key : _keySet_1) {
                              {
                                List<String> _get_4 = opt_1.text.get(key);
                                for(final String text : _get_4) {
                                  {
                                    boolean _contains = textOptions.contains(text);
                                    boolean _not = (!_contains);
                                    if (_not) {
                                      String _xblockexpression_5 = null;
                                      {
                                        counter++;
                                        _xblockexpression_5 = "";
                                      }
                                      _builder.append(_xblockexpression_5);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_6 = null;
                                      {
                                        textOptions.add(text);
                                        _xblockexpression_6 = "";
                                      }
                                      _builder.append(_xblockexpression_6);
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
                          _builder.append("\t");
                          String _xblockexpression_7 = null;
                          {
                            max = counter;
                            _xblockexpression_7 = "";
                          }
                          _builder.append(_xblockexpression_7, "\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          String _xblockexpression_8 = null;
                          {
                            index = k;
                            _xblockexpression_8 = "";
                          }
                          _builder.append(_xblockexpression_8, "\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t");
                      String _xblockexpression_9 = null;
                      {
                        k++;
                        _xblockexpression_9 = "";
                      }
                      _builder.append(_xblockexpression_9, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder.append("\t");
              int k_1 = 0;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_4 = ((MatchPairs)exercise).getTests();
                for(final Test test_4 : _tests_4) {
                  _builder.append("\t");
                  EduTestSuperGenerator.TestOption opt_2 = null;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t        ");
                  int rndIndex_2 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_4));
                  _builder.newLineIfNotEmpty();
                  {
                    if (((this.options.get(exercise).get(test_4) != null) && (this.options.get(exercise).get(test_4).get(rndIndex_2).size() > index))) {
                      _builder.append("\t");
                      _builder.append("//");
                      _builder.append(opt_2 = this.options.get(exercise).get(test_4).get(rndIndex_2).get(index), "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if ((opt_2 != null)) {
                      _builder.append("\t\t\t\t\t    ");
                      String diagram_2 = opt_2.path;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      File _file_6 = new File(((this.projectPath + "/src-gen/html/") + diagram_2));
                      File _file_7 = new File((((this.projectPath + "/app/mobile/app/src/main/res/drawable/q") + Integer.valueOf(i)) + "_enunciado.png"));
                      IOUtils.copyFile(_file_6, _file_7);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _put_4 = drawable.put(Integer.valueOf(i), (("q" + Integer.valueOf(i)) + "_enunciado.png"));
                      _builder.append(_put_4, "\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _xblockexpression_10 = null;
                      {
                        i++;
                        _xblockexpression_10 = "";
                      }
                      _builder.append(_xblockexpression_10, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("package org.example.esquematfg;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import androidx.annotation.NonNull;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import androidx.appcompat.app.AlertDialog;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import androidx.appcompat.app.AppCompatActivity;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.content.DialogInterface;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.graphics.Bitmap;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.graphics.drawable.BitmapDrawable;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.graphics.drawable.Drawable;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.os.Bundle;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.view.View;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.ArrayAdapter;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.Button;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.CheckBox;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.LinearLayout;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.RadioButton;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.RadioGroup;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.Spinner;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import android.widget.TextView;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import java.util.ArrayList;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class MainActivity extends AppCompatActivity {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answers_radio[]={");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4, R.id.answer5, R.id.answer6");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answers_check[]={");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("R.id.check_box1, R.id.check_box2, R.id.check_box3, R.id.check_box4, R.id.check_box5, R.id.check_box6");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answers_false_true[] = {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("R.id.true_solution, R.id.false_solution");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answer_desplegable[]={");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("R.id.desplegable1, R.id.desplegable2, R.id.desplegable3, R.id.desplegable4");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answer_desplegable_text[]={");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("R.id.desplegable_text1, R.id.desplegable_text2, R.id.desplegable_text3, R.id.desplegable_text4");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int ids_answer_desplegable_spinner[]={");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("R.id.desplegable_spinner1, R.id.desplegable_spinner2, R.id.desplegable_spinner3, R.id.desplegable_spinner4");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      {
        int _size_2 = drawable.size();
        boolean _greaterThan_2 = (_size_2 > 0);
        if (_greaterThan_2) {
          _builder.append("\t\t");
          _builder.append("private HashMap<Integer, Integer> statements=new HashMap<Integer,Integer>(){{");
          _builder.newLine();
          {
            Set<Integer> _keySet_2 = drawable.keySet();
            for(final Integer k_2 : _keySet_2) {
              _builder.append("            \t");
              _builder.append("put(");
              _builder.append(k_2, "            \t");
              _builder.append(",R.drawable.");
              String _get_5 = drawable.get(k_2);
              int _length = drawable.get(k_2).length();
              int _minus = (_length - 4);
              String _substring = _get_5.substring(0, _minus);
              _builder.append(_substring, "            \t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("}};");
          _builder.newLine();
        }
      }
      {
        int _size_3 = drawableAnswer.size();
        boolean _greaterThan_3 = (_size_3 > 0);
        if (_greaterThan_3) {
          _builder.append("private HashMap<Integer, HashMap<Integer,Integer>> statementsAnswers=new HashMap<Integer, HashMap<Integer,Integer>>(){{");
          _builder.newLine();
          {
            Set<Integer> _keySet_3 = drawableAnswer.keySet();
            for(final Integer k1 : _keySet_3) {
              _builder.append("\t");
              _builder.append("put(");
              _builder.append(k1, "\t");
              _builder.append(",new HashMap<Integer,Integer>(){{");
              _builder.newLineIfNotEmpty();
              {
                Set<Integer> _keySet_4 = drawableAnswer.get(k1).keySet();
                for(final Integer k2 : _keySet_4) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("put(");
                  _builder.append(k2, "\t\t");
                  _builder.append(",R.drawable.");
                  String _get_6 = drawableAnswer.get(k1).get(k2);
                  int _length_1 = drawableAnswer.get(k1).get(k2).length();
                  int _minus_1 = (_length_1 - 4);
                  String _substring_1 = _get_6.substring(0, _minus_1);
                  _builder.append(_substring_1, "\t\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("}});");
              _builder.newLine();
            }
          }
          _builder.append("}};");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private String[] all_questions;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private TextView text_question;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private RadioGroup radio_true_false;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private Button btn_next, btn_previous;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private RadioGroup radio_group;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int type = -1;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private String correct_answer;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int current_question;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private boolean[] answer_is_correct;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private String[] user_all_answers;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private int n_answers=0;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void onSaveInstanceState(@NonNull Bundle outState) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super.onSaveInstanceState(outState);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("outState.putString(\"correct_answer\", correct_answer);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("outState.putInt(\"current_question\", current_question);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("outState.putBooleanArray(\"answer_is_correct\", answer_is_correct);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("outState.putStringArray(\"user_all_answers\", user_all_answers);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void onCreate(Bundle savedInstanceState) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("super.onCreate(savedInstanceState);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("setContentView(R.layout.activity_main);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("text_question = (TextView) findViewById(R.id.text_question);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("radio_group = (RadioGroup) findViewById(R.id.answer_group);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("radio_true_false = (RadioGroup) findViewById(R.id.answer_true_false);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("btn_next = (Button) findViewById(R.id.btn_check);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("btn_previous = (Button) findViewById(R.id.btn_previous);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("all_questions=getResources().getStringArray(R.array.all_questions);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("correct_answer=\"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if(savedInstanceState == null){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("reset();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}else{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("correct_answer=savedInstanceState.getString(\"correct_answer\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("current_question=savedInstanceState.getInt(\"current_question\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("answer_is_correct=savedInstanceState.getBooleanArray(\"answer_is_correct\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("user_all_answers=savedInstanceState.getStringArray(\"user_all_answers\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("btn_next.setOnClickListener(new View.OnClickListener() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("public void onClick(View v) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("checkAnswer();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if (current_question < all_questions.length - 1) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("current_question++;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("checkResults();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("btn_previous.setOnClickListener(new View.OnClickListener() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("public void onClick(View v) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("checkAnswer();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if (current_question > 0) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("current_question--;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("private void reset() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("answer_is_correct = new boolean[all_questions.length];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("user_all_answers = new String[all_questions.length];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("correct_answer = \"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("for (int i = 0; i < user_all_answers.length; i++) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("user_all_answers[i] = \"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("current_question = 0;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("private void checkResults() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("int correctas = 0, incorrectas = 0, nocontestadas = 0;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("for (int i = 0; i < all_questions.length; i++) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("if (answer_is_correct[i]) correctas++;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("else if (user_all_answers[i].equals(\"000000\")) nocontestadas++;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("else incorrectas++;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("// TODO: Traduccion del texto mediante recusos");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("String res = String.format(\"Correctas: %d\\nIncorrectas: %d\\nNo contestadas: %d\",");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("correctas, incorrectas, nocontestadas);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("AlertDialog.Builder builder = new AlertDialog.Builder(this);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("builder.setTitle(R.string.results);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("builder.setMessage(res);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("//Suele haber el boton negativo(cancel) y el positivo(ok)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("builder.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("public void onClick(DialogInterface dialog, int which) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("finish();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("public void onClick(DialogInterface dialog, int which) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("reset();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("builder.create().show();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("private void checkAnswer() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("String response_user=\"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if(type==0){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("int id = radio_group.getCheckedRadioButtonId();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<ids_answers_radio.length ;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(ids_answers_radio[i]==id){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux=response_user.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i]=\'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("response_user=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else if(type==1){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<ids_answers_check.length ;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox auxCB=(CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(auxCB.isChecked()){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux=response_user.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i]=\'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("response_user=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else if(type==2){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("int id = radio_true_false.getCheckedRadioButtonId();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<ids_answers_false_true.length ;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(ids_answers_false_true[i]==id){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux=response_user.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i]=\'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("response_user=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else if(type==3){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<n_answers ;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("char[] aux=response_user.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("Spinner sp=(Spinner) findViewById(ids_answer_desplegable_spinner[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("aux[i]=Character.forDigit(sp.getSelectedItemPosition(),10);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("response_user=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("answer_is_correct[current_question]=(response_user.equals(correct_answer));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("user_all_answers[current_question]=response_user;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("private void showQuestion() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("String q = all_questions[current_question];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("//Partimos el string con la pregunta y respuestas en trozos");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("String[] parts = q.split(\";\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("text_question.setText(parts[1]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if(parts[0].charAt(0)==\'0\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("type=0;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_group.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i=0;i<ids_answers_radio.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("RadioButton rb = (RadioButton) findViewById(ids_answers_radio[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("rb.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0;i<ids_answers_check.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i = 0;i<ids_answer_desplegable.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ll.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("radio_true_false.setVisibility((View.GONE));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("radio_group.clearCheck();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("int correct= Integer.parseInt(parts[3]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("correct_answer=\"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("char[] aux=correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("aux[correct]=\'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("correct_answer=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("int num_answers= Integer.parseInt(parts[2]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<num_answers;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("RadioButton rb = (RadioButton) findViewById(ids_answers_radio[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("rb.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("//Reescalamos la imagen");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("Drawable img2 = rb.getContext().getResources().getDrawable( statementsAnswers.get(current_question).get(i));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("Bitmap b = ((BitmapDrawable)img2).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth()/2, b.getHeight()/2, true));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("Bitmap b2 =((BitmapDrawable)d).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("rb.setCompoundDrawablesWithIntrinsicBounds( null, null, null, new BitmapDrawable(getResources(), b2));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("if(user_all_answers[current_question].charAt(i)==\'1\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("rb.setChecked(true);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}else if(parts[0].charAt(0)==\'1\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("type=1;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_group.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_true_false.setVisibility((View.GONE));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0;i<ids_answers_check.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i = 0;i<ids_answer_desplegable.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ll.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("correct_answer=\"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable img2=text_question.getContext().getResources().getDrawable(statements.get(current_question));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b = ((BitmapDrawable)img2).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth()/2, b.getHeight()/2, true));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b2 =((BitmapDrawable)d).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,new BitmapDrawable(getResources(), b2));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0; i<parts.length-2;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("String answer = parts[i+2];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("answer= answer.substring(1);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(answer.charAt(0)==\'*\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux=correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i]=\'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("correct_answer=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("answer= answer.substring(1);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("else{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux=correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i]=\'0\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("correct_answer=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setText(answer);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(user_all_answers[current_question].charAt(i)==\'1\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("cb.setChecked(true);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("else{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("cb.setChecked(false);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}else if (parts[0].charAt(0) == \'2\') {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("type = 2;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_group.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_true_false.setVisibility((View.VISIBLE));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0;i<ids_answers_check.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i = 0;i<ids_answer_desplegable.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ll.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("correct_answer = \"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_true_false.clearCheck();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable img2 = text_question.getContext().getResources().getDrawable(statements.get(current_question));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b = ((BitmapDrawable) img2).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth() / 2, b.getHeight() / 2, true));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b2 = ((BitmapDrawable) d).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, new BitmapDrawable(getResources(), b2));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for (int i = 0; i < parts.length - 2; i++) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("RadioButton rb = (RadioButton) findViewById(ids_answers_false_true[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("String answer = parts[i+2];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if (answer.charAt(0) == \'*\') {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux = correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i] = \'1\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("correct_answer = new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("answer = answer.substring(1);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("char[] aux = correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("aux[i] = \'0\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("correct_answer = new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("rb.setText(answer);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if (user_all_answers[current_question].charAt(i) == \'1\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("rb.setChecked(true);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else if(parts[0].charAt(0) == \'3\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("type = 3;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_group.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_true_false.setVisibility((View.GONE));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i =0;i<ids_answers_check.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("cb.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for(int i = 0;i<ids_answer_desplegable.length;i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ll.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("correct_answer = \"000000\";");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("radio_true_false.clearCheck();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable img2 = text_question.getContext().getResources().getDrawable(statements.get(current_question));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b = ((BitmapDrawable) img2).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth() / 2, b.getHeight() / 2, true));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("Bitmap b2 = ((BitmapDrawable) d).getBitmap();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, new BitmapDrawable(getResources(), b2));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("ArrayList<String> optionsaux=new ArrayList<>();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("optionsaux.add(getResources().getString(R.string.choose_option));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("ArrayList<String> spinners = new ArrayList<>();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("ArrayList<Character> solutions = new ArrayList<>();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for (int i = 0; i < parts.length - 2; i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("String answer = parts[i+2];");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if(answer.charAt(1)!=\'*\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("optionsaux.add(answer+\"\\n\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("spinners.add(answer.substring(3));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("solutions.add(Character.forDigit(Integer.parseInt(String.valueOf(answer.charAt(2)))+1,10));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("ArrayAdapter<String> options= new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,optionsaux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for (int i = 0; i < spinners.size(); i++){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ll.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("Spinner sp = (Spinner) findViewById(ids_answer_desplegable_spinner[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("TextView tx=(TextView) findViewById(ids_answer_desplegable_text[i]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("String answer = spinners.get(i);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("tx.setText(answer+\"\\n\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("options.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("sp.setAdapter(options);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("char[] aux=correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("aux[i]=solutions.get(i);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("correct_answer=new String(aux);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("if (user_all_answers[current_question].charAt(i) != \'0\'){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("int selected=Integer.parseInt(String.valueOf(user_all_answers[current_question].charAt(i)));");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("sp.setSelection(selected);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("n_answers=spinners.size();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("btn_next.callOnClick();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if (current_question == 0) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("btn_previous.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("btn_previous.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if (current_question == all_questions.length - 1) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("btn_next.setText(R.string.finish);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("btn_next.setText(R.string.next);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * local.properties code will be generated here!!
   */
  public CharSequence localPropertiesCompile(final Program program, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("## This file must *NOT* be checked into Version Control Systems,");
    _builder.newLine();
    _builder.append("# as it contains information specific to your local configuration.");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("# Location of the SDK. This is only used by Gradle.");
    _builder.newLine();
    _builder.append("# For customization when using a Version Control System, please read the");
    _builder.newLine();
    _builder.append("# header note.");
    _builder.newLine();
    _builder.append("#");
    _builder.append(this.currentDate);
    _builder.newLineIfNotEmpty();
    _builder.append("sdk.dir=");
    _builder.append(this.userProfile);
    _builder.append("AppData\\\\Local\\\\Android\\\\Sdk");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * XML MobileApp code will be generated here!!
   */
  public CharSequence xmlCompile(final Program program, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    _builder.newLine();
    _builder.append("<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xmlns:app=\"http://schemas.android.com/apk/res-auto\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xmlns:tools=\"http://schemas.android.com/tools\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("tools:context=\".MainActivity\">");
    _builder.newLine();
    _builder.append("<!--");
    boolean true_false_questions = false;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("<!--");
    boolean single_option_questions = false;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("<!--");
    boolean multiple_option_questions = false;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    {
      EList<MutatorTests> _exercises = program.getExercises();
      for(final MutatorTests exercise : _exercises) {
        {
          if ((exercise instanceof AlternativeResponse)) {
            {
              EList<Test> _tests = ((AlternativeResponse)exercise).getTests();
              for(final Test test : _tests) {
                {
                  int _size = this.rand.get(exercise).get(test).size();
                  boolean _greaterThan = (_size > 0);
                  if (_greaterThan) {
                    String _xblockexpression = null;
                    {
                      true_false_questions = true;
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
        {
          if ((exercise instanceof MultiChoiceDiagram)) {
            {
              EList<Test> _tests_1 = ((MultiChoiceDiagram)exercise).getTests();
              for(final Test test_1 : _tests_1) {
                {
                  int _size_1 = this.diagrams.get(exercise).get(test_1).size();
                  boolean _greaterThan_1 = (_size_1 > 0);
                  if (_greaterThan_1) {
                    String _xblockexpression_1 = null;
                    {
                      single_option_questions = true;
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
        {
          if ((exercise instanceof MultiChoiceEmendation)) {
            {
              EList<Test> _tests_2 = ((MultiChoiceEmendation)exercise).getTests();
              for(final Test test_2 : _tests_2) {
                {
                  if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                    String _xblockexpression_2 = null;
                    {
                      multiple_option_questions = true;
                      _xblockexpression_2 = "";
                    }
                    _builder.append(_xblockexpression_2);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<ScrollView");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("android:layout_height=\"match_parent\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:orientation=\"vertical\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/text_question\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"190dp\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:textSize=\"18sp\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<View");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/ruler\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"1dp\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_below=\"@id/text_question\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:background=\"#070707\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:ignore=\"MissingConstraints\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box1\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box2\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box3\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box4\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box5\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<CheckBox");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/check_box6\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"CheckBox\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("tools:visibility=\"gone\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<RadioGroup");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/answer_true_false\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"188dp\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:visibility=\"gone\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/true_solution\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\"True\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/false_solution\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\"False\" />");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("</RadioGroup>");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<RadioGroup");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/answer_group\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"match_parent\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:visibility=\"visible\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/answer1\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/answer2\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/answer3\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:id=\"@+id/answer4\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("                            ");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:id=\"@+id/answer5\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("                            \t\t                        ");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("<RadioButton");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:id=\"@+id/answer6\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:text=\" \" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("</RadioGroup>");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("android:id=\"@+id/desplegables\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("android:orientation=\"vertical\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("android:visibility=\"visible\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:id=\"@+id/desplegable1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:orientation=\"horizontal\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:layout_weight=\"2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("android:weightSum=\"2\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:id=\"@+id/desplegable_text1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:layout_weight=\"1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t    ");
    _builder.append("android:textSize=\"16sp\" />");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t\t");
    _builder.append("<Spinner");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t        ");
    _builder.append("android:id=\"@+id/desplegable_spinner1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t        ");
    _builder.append("android:layout_weight=\"1\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("</Spinner>");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("android:id=\"@+id/desplegable2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("android:orientation=\"horizontal\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t\t    ");
    _builder.append("android:layout_weight=\"2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:weightSum=\"2\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_text2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textSize=\"16sp\" />");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<Spinner");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_spinner2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("</Spinner>");
    _builder.newLine();
    _builder.append("    \t\t\t\t    ");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("    \t\t\t\t    ");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:id=\"@+id/desplegable3\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:orientation=\"horizontal\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_weight=\"2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:weightSum=\"2\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_text3\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textSize=\"16sp\" />");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<Spinner");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_spinner3\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("</Spinner>");
    _builder.newLine();
    _builder.append("    \t\t\t\t    ");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("    \t\t\t\t    ");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:id=\"@+id/desplegable4\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:orientation=\"horizontal\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:layout_weight=\"2\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("android:weightSum=\"2\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_text4\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:textSize=\"16sp\" />");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("<Spinner");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:id=\"@+id/desplegable_spinner4\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("    \t\t\t\t            ");
    _builder.append("android:layout_weight=\"1\">");
    _builder.newLine();
    _builder.append("    \t\t\t\t        ");
    _builder.append("</Spinner>");
    _builder.newLine();
    _builder.append("    \t\t\t\t    ");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("    \t\t\t\t");
    _builder.newLine();
    _builder.append("    \t\t\t\t");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<Button");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/btn_check\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"@string/next\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("<Button");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:id=\"@+id/btn_previous\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("android:text=\"@string/previous\" />");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("</ScrollView>");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</androidx.constraintlayout.widget.ConstraintLayout>");
    _builder.newLine();
    return _builder;
  }

  /**
   * String values XML MobileApp code will be generated here!!
   */
  public CharSequence stringXmlCompile(final Program program, final Resource resource) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<resources>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"app_name\">esquemaTFG</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"question\">Question</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"check\">Check</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"next\">Next</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"finish\">Finish</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"previous\">Previous</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"results\">Results</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"start_over\">Reset</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"choose_option\">Choose</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<array name=\"all_questions\">");
      _builder.newLine();
      {
        EList<MutatorTests> _exercises = program.getExercises();
        for(final MutatorTests exercise : _exercises) {
          {
            if ((exercise instanceof AlternativeResponse)) {
              {
                EList<Test> _tests = ((AlternativeResponse)exercise).getTests();
                for(final Test test : _tests) {
                  {
                    int _size = this.rand.get(exercise).get(test).size();
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("\t");
                      _builder.append("<!--");
                      List<String> diagram = this.rand.get(exercise).get(test).get(Integer.valueOf(0));
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _equals = diagram.equals(test.getSource().replace(".model", ".png"));
                        if (_equals) {
                          _builder.append("\t");
                          _builder.append("<item>2;");
                          String _replace = test.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace, "\t");
                          _builder.append(";*True;False</item>");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("<item>2;");
                          String _replace_1 = test.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace_1, "\t");
                          _builder.append(";True;*False</item>");
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
            if ((exercise instanceof MultiChoiceDiagram)) {
              {
                EList<Test> _tests_1 = ((MultiChoiceDiagram)exercise).getTests();
                for(final Test test_1 : _tests_1) {
                  _builder.append("\t");
                  int i = 0;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  int correct = i;
                  _builder.newLineIfNotEmpty();
                  {
                    Set<EClass> _keySet = this.diagrams.get(exercise).get(test_1).keySet();
                    for(final EClass eclass : _keySet) {
                      {
                        List<String> _get = this.diagrams.get(exercise).get(test_1).get(eclass);
                        for(final String diagram_1 : _get) {
                          {
                            boolean _equals_1 = diagram_1.equals(test_1.getSource().replace(".model", ".png"));
                            if (_equals_1) {
                              _builder.append("\t");
                              String _xblockexpression = null;
                              {
                                correct = i;
                                _xblockexpression = "";
                              }
                              _builder.append(_xblockexpression, "\t");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                          _builder.append("\t");
                          _builder.append("\t");
                          String _xblockexpression_1 = null;
                          {
                            i++;
                            _xblockexpression_1 = "";
                          }
                          _builder.append(_xblockexpression_1, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("<item>0;");
                  String _replace_2 = test_1.getQuestion().replace("\"", "\'").replace("\'", "");
                  _builder.append(_replace_2, "\t\t");
                  _builder.append(";");
                  _builder.append(i, "\t\t");
                  _builder.append(";");
                  _builder.append(correct, "\t\t");
                  _builder.append("</item>");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("<!--<tipo;pregunta;n_respuesta;respues_correcta>-->");
                  _builder.newLine();
                }
              }
            }
          }
          {
            if ((exercise instanceof MultiChoiceEmendation)) {
              _builder.append("\t");
              _builder.append("<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->");
              _builder.newLine();
              {
                EList<Test> _tests_2 = ((MultiChoiceEmendation)exercise).getTests();
                for(final Test test_2 : _tests_2) {
                  _builder.append("\t");
                  _builder.append("<item>1;");
                  _builder.newLine();
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      String _replace_3 = test_2.getQuestion().replace("\"", "\'").replace("\'", "");
                      _builder.append(_replace_3, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      int counter = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      List<AbstractMap.SimpleEntry<String, Boolean>> textOptions = new ArrayList<AbstractMap.SimpleEntry<String, Boolean>>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t        ");
                      int rndIndex = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_1 = this.options.get(exercise).get(test_2).get(rndIndex);
                        for(final EduTestSuperGenerator.TestOption opt : _get_1) {
                          {
                            Set<String> _keySet_1 = opt.text.keySet();
                            for(final String key : _keySet_1) {
                              {
                                List<String> _get_2 = opt.text.get(key);
                                for(final String text : _get_2) {
                                  boolean found = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    for(final AbstractMap.SimpleEntry<String, Boolean> entry : textOptions) {
                                      {
                                        boolean _equals_2 = entry.getKey().equals(text);
                                        if (_equals_2) {
                                          String _xblockexpression_2 = null;
                                          {
                                            found = true;
                                            _xblockexpression_2 = "";
                                          }
                                          _builder.append(_xblockexpression_2);
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found == false)) {
                                      String _xblockexpression_3 = null;
                                      {
                                        counter++;
                                        _xblockexpression_3 = "";
                                      }
                                      _builder.append(_xblockexpression_3);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_4 = null;
                                      {
                                        AbstractMap.SimpleEntry<String, Boolean> _simpleEntry = new AbstractMap.SimpleEntry<String, Boolean>(text, Boolean.valueOf(false));
                                        textOptions.add(_simpleEntry);
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
                        }
                      }
                    }
                  }
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      _builder.append("<!--");
                      String diagram_2 = "";
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      {
                        List<List<EduTestSuperGenerator.TestOption>> _get_3 = this.options.get(exercise).get(test_2);
                        boolean _tripleNotEquals = (_get_3 != null);
                        if (_tripleNotEquals) {
                          int rndIndex_1 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                          _builder.newLineIfNotEmpty();
                          {
                            List<EduTestSuperGenerator.TestOption> _get_4 = this.options.get(exercise).get(test_2).get(rndIndex_1);
                            for(final EduTestSuperGenerator.TestOption opt_1 : _get_4) {
                              {
                                int _size_1 = opt_1.text.size();
                                boolean _greaterThan_1 = (_size_1 > 0);
                                if (_greaterThan_1) {
                                  _builder.append("<!--");
                                  _builder.append(diagram_2 = opt_1.path);
                                  _builder.append("-->");
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                      {
                        boolean _equals_3 = diagram_2.equals("");
                        boolean _not = (!_equals_3);
                        if (_not) {
                          {
                            List<List<EduTestSuperGenerator.TestOption>> _get_5 = this.options.get(exercise).get(test_2);
                            boolean _tripleNotEquals_1 = (_get_5 != null);
                            if (_tripleNotEquals_1) {
                              int rndIndex_2 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                              _builder.newLineIfNotEmpty();
                              {
                                List<EduTestSuperGenerator.TestOption> _get_6 = this.options.get(exercise).get(test_2).get(rndIndex_2);
                                for(final EduTestSuperGenerator.TestOption opt_2 : _get_6) {
                                  List<String> textOptions_1 = new ArrayList<String>();
                                  _builder.newLineIfNotEmpty();
                                  {
                                    int _size_2 = opt_2.text.size();
                                    boolean _greaterThan_2 = (_size_2 > 0);
                                    if (_greaterThan_2) {
                                      {
                                        Set<String> _keySet_2 = opt_2.text.keySet();
                                        for(final String key_1 : _keySet_2) {
                                          {
                                            List<String> _get_7 = opt_2.text.get(key_1);
                                            for(final String text_1 : _get_7) {
                                              {
                                                boolean _contains = textOptions_1.contains(text_1);
                                                boolean _not_1 = (!_contains);
                                                if (_not_1) {
                                                  String _xblockexpression_5 = null;
                                                  {
                                                    textOptions_1.add(text_1);
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
                                    }
                                  }
                                }
                              }
                              {
                                List<EduTestSuperGenerator.TestOption> _get_8 = this.options.get(exercise).get(test_2).get(rndIndex_2);
                                for(final EduTestSuperGenerator.TestOption opt_3 : _get_8) {
                                  {
                                    if ((opt_3.solution == true)) {
                                      {
                                        int _size_3 = opt_3.text.size();
                                        boolean _greaterThan_3 = (_size_3 > 0);
                                        if (_greaterThan_3) {
                                          {
                                            Set<String> _keySet_3 = opt_3.text.keySet();
                                            for(final String key_2 : _keySet_3) {
                                              {
                                                List<String> _get_9 = opt_3.text.get(key_2);
                                                for(final String text_2 : _get_9) {
                                                  _builder.append("*");
                                                  String _trim = text_2.trim();
                                                  _builder.append(_trim);
                                                  _builder.append(";");
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
                                    if ((opt_3.solution == false)) {
                                      {
                                        int _size_4 = opt_3.text.size();
                                        boolean _greaterThan_4 = (_size_4 > 0);
                                        if (_greaterThan_4) {
                                          {
                                            Set<String> _keySet_4 = opt_3.text.keySet();
                                            for(final String key_3 : _keySet_4) {
                                              {
                                                List<String> _get_10 = opt_3.text.get(key_3);
                                                for(final String text_3 : _get_10) {
                                                  String _trim_1 = text_3.trim();
                                                  _builder.append(_trim_1);
                                                  _builder.append(";");
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
                  _builder.append("\t");
                  _builder.append("</item>");
                  _builder.newLine();
                }
              }
            }
          }
          {
            if ((exercise instanceof MatchPairs)) {
              _builder.append("\t");
              int min = Integer.MAX_VALUE;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int index = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int max = Integer.MIN_VALUE;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_3 = ((MatchPairs)exercise).getTests();
                for(final Test test_3 : _tests_3) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_3) != null))) {
                      _builder.append("\t\t\t\t\t\t\t");
                      _builder.append("<item>3;Match the correct option on the right with each of the statements on the left;");
                      _builder.newLine();
                      _builder.append("\t\t\t\t\t\t\t");
                      List<String> textOptions_2 = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int k = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int counter_1 = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t        ");
                      int rndIndex_3 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_3));
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_11 = this.options.get(exercise).get(test_3).get(rndIndex_3);
                        for(final EduTestSuperGenerator.TestOption opt_4 : _get_11) {
                          {
                            Set<String> _keySet_5 = opt_4.text.keySet();
                            for(final String key_4 : _keySet_5) {
                              {
                                List<String> _get_12 = opt_4.text.get(key_4);
                                for(final String text_4 : _get_12) {
                                  {
                                    boolean _contains_1 = textOptions_2.contains(text_4);
                                    boolean _not_2 = (!_contains_1);
                                    if (_not_2) {
                                      String _xblockexpression_6 = null;
                                      {
                                        counter_1++;
                                        _xblockexpression_6 = "";
                                      }
                                      _builder.append(_xblockexpression_6);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append(text_4);
                                      _builder.append(";");
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_7 = null;
                                      {
                                        textOptions_2.add(text_4);
                                        _xblockexpression_7 = "";
                                      }
                                      _builder.append(_xblockexpression_7);
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
                        if ((counter_1 > max)) {
                          _builder.append("\t\t\t\t\t\t\t");
                          String _xblockexpression_8 = null;
                          {
                            max = counter_1;
                            _xblockexpression_8 = "";
                          }
                          _builder.append(_xblockexpression_8, "\t\t\t\t\t\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t\t\t\t");
                          String _xblockexpression_9 = null;
                          {
                            index = k;
                            _xblockexpression_9 = "";
                          }
                          _builder.append(_xblockexpression_9, "\t\t\t\t\t\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t\t\t\t\t\t");
                      String _xblockexpression_10 = null;
                      {
                        k++;
                        _xblockexpression_10 = "";
                      }
                      _builder.append(_xblockexpression_10, "\t\t\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      TreeMap<Integer, AbstractMap.SimpleEntry<String, String>> entries = new TreeMap<Integer, AbstractMap.SimpleEntry<String, String>>();
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_13 = this.options.get(exercise).get(test_3).get(rndIndex_3);
                        for(final EduTestSuperGenerator.TestOption op : _get_13) {
                          {
                            boolean _isExpression = test_3.isExpression();
                            boolean _equals_4 = (_isExpression == true);
                            if (_equals_4) {
                              String key_5 = this.getText(test_3.getIdentifier(), op.entry.getKey().getURI().toFileString(), resource);
                              _builder.newLineIfNotEmpty();
                              {
                                int _length = key_5.length();
                                boolean _lessEqualsThan = (_length <= 36);
                                if (_lessEqualsThan) {
                                  boolean found_1 = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    Set<Integer> _keySet_6 = entries.keySet();
                                    for(final int length : _keySet_6) {
                                      AbstractMap.SimpleEntry<String, String> entry_1 = entries.get(Integer.valueOf(length));
                                      _builder.newLineIfNotEmpty();
                                      {
                                        boolean _equals_5 = entry_1.getValue().equals(key_5);
                                        if (_equals_5) {
                                          String _xblockexpression_11 = null;
                                          {
                                            found_1 = true;
                                            _xblockexpression_11 = "";
                                          }
                                          _builder.append(_xblockexpression_11);
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found_1 == false)) {
                                      String _trim_2 = op.text.get(((Object[])Conversions.unwrapArray(op.text.keySet(), Object.class))[index]).get(index).trim();
                                      AbstractMap.SimpleEntry<String, String> entry_2 = new AbstractMap.SimpleEntry<String, String>(key_5, _trim_2);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_12 = null;
                                      {
                                        entries.put(Integer.valueOf(key_5.length()), entry_2);
                                        _xblockexpression_12 = "";
                                      }
                                      _builder.append(_xblockexpression_12);
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                      _builder.append("\t\t\t\t\t\t\t");
                      String question = test_3.getQuestion().replace("\"", "\'");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int counter2 = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        Set<Integer> _keySet_7 = entries.keySet();
                        for(final int length_1 : _keySet_7) {
                          {
                            if ((counter2 < min)) {
                              _builder.append("\t\t\t\t\t\t\t");
                              AbstractMap.SimpleEntry<String, String> entry_3 = entries.get(Integer.valueOf(length_1));
                              _builder.newLineIfNotEmpty();
                              {
                                int _size_5 = textOptions_2.size();
                                int _minus = (_size_5 - 1);
                                IntegerRange _upTo = new IntegerRange(0, _minus);
                                for(final int i_1 : _upTo) {
                                  {
                                    String _get_14 = textOptions_2.get(i_1);
                                    int _length_1 = textOptions_2.get(i_1).length();
                                    int _minus_1 = (_length_1 - 1);
                                    boolean _equals_6 = _get_14.substring(0, _minus_1).equals(entry_3.getValue());
                                    if (_equals_6) {
                                      _builder.append("*");
                                      _builder.append(i_1);
                                      String _key = entry_3.getKey();
                                      String _plus = (question + _key);
                                      _builder.append(_plus);
                                      _builder.append(";");
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                      _builder.append("</item>");
                      _builder.newLine();
                    }
                  }
                }
              }
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("</array>");
      _builder.newLine();
      _builder.append("</resources>");
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * String values XML MobileApp code will be generated here!!
   */
  public CharSequence stringXmlCompileEs(final Program program, final Resource resource) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
      _builder.newLine();
      _builder.append("<resources>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"app_name\">esquemaTFG</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"question\">Pregunta</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"check\">Comprobar</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"next\">Continuar</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"finish\">Acabar</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"previous\">Anterior</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"results\">Resultados</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"start_over\">Reintentar</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<string name=\"choose_option\">Elegir</string>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<array name=\"all_questions\">");
      _builder.newLine();
      {
        EList<MutatorTests> _exercises = program.getExercises();
        for(final MutatorTests exercise : _exercises) {
          {
            if ((exercise instanceof AlternativeResponse)) {
              {
                EList<Test> _tests = ((AlternativeResponse)exercise).getTests();
                for(final Test test : _tests) {
                  {
                    int _size = this.rand.get(exercise).get(test).size();
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("\t");
                      _builder.append("<!--");
                      List<String> diagram = this.rand.get(exercise).get(test).get(Integer.valueOf(0));
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _equals = diagram.equals(test.getSource().replace(".model", ".png"));
                        if (_equals) {
                          _builder.append("\t");
                          _builder.append("<item>2;");
                          String _replace = test.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace, "\t");
                          _builder.append(";*True;False</item>");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("<item>2;");
                          String _replace_1 = test.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace_1, "\t");
                          _builder.append(";True;*False</item>");
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
            if ((exercise instanceof MultiChoiceDiagram)) {
              {
                EList<Test> _tests_1 = ((MultiChoiceDiagram)exercise).getTests();
                for(final Test test_1 : _tests_1) {
                  _builder.append("\t");
                  int i = 0;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  int correct = i;
                  _builder.newLineIfNotEmpty();
                  {
                    Set<EClass> _keySet = this.diagrams.get(exercise).get(test_1).keySet();
                    for(final EClass eclass : _keySet) {
                      {
                        List<String> _get = this.diagrams.get(exercise).get(test_1).get(eclass);
                        for(final String diagram_1 : _get) {
                          {
                            boolean _equals_1 = diagram_1.equals(test_1.getSource().replace(".model", ".png"));
                            if (_equals_1) {
                              _builder.append("\t");
                              String _xblockexpression = null;
                              {
                                correct = i;
                                _xblockexpression = "";
                              }
                              _builder.append(_xblockexpression, "\t");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                          _builder.append("\t");
                          _builder.append("\t");
                          String _xblockexpression_1 = null;
                          {
                            i++;
                            _xblockexpression_1 = "";
                          }
                          _builder.append(_xblockexpression_1, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("<item>0;");
                  String _replace_2 = test_1.getQuestion().replace("\"", "\'").replace("\'", "");
                  _builder.append(_replace_2, "\t\t");
                  _builder.append(";");
                  _builder.append(i, "\t\t");
                  _builder.append(";");
                  _builder.append(correct, "\t\t");
                  _builder.append("</item>");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("<!--<tipo;pregunta;n_respuesta;respues_correcta>-->");
                  _builder.newLine();
                }
              }
            }
          }
          {
            if ((exercise instanceof MultiChoiceEmendation)) {
              _builder.append("\t");
              _builder.append("<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->");
              _builder.newLine();
              {
                EList<Test> _tests_2 = ((MultiChoiceEmendation)exercise).getTests();
                for(final Test test_2 : _tests_2) {
                  _builder.append("\t");
                  _builder.append("<item>1;");
                  _builder.newLine();
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      String _replace_3 = test_2.getQuestion().replace("\"", "\'").replace("\'", "");
                      _builder.append(_replace_3, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      int counter = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      List<AbstractMap.SimpleEntry<String, Boolean>> textOptions = new ArrayList<AbstractMap.SimpleEntry<String, Boolean>>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t        ");
                      int rndIndex = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_1 = this.options.get(exercise).get(test_2).get(rndIndex);
                        for(final EduTestSuperGenerator.TestOption opt : _get_1) {
                          {
                            Set<String> _keySet_1 = opt.text.keySet();
                            for(final String key : _keySet_1) {
                              {
                                List<String> _get_2 = opt.text.get(key);
                                for(final String text : _get_2) {
                                  boolean found = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    for(final AbstractMap.SimpleEntry<String, Boolean> entry : textOptions) {
                                      {
                                        boolean _equals_2 = entry.getKey().equals(text);
                                        if (_equals_2) {
                                          String _xblockexpression_2 = null;
                                          {
                                            found = true;
                                            _xblockexpression_2 = "";
                                          }
                                          _builder.append(_xblockexpression_2);
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found == false)) {
                                      String _xblockexpression_3 = null;
                                      {
                                        counter++;
                                        _xblockexpression_3 = "";
                                      }
                                      _builder.append(_xblockexpression_3);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_4 = null;
                                      {
                                        AbstractMap.SimpleEntry<String, Boolean> _simpleEntry = new AbstractMap.SimpleEntry<String, Boolean>(text, Boolean.valueOf(false));
                                        textOptions.add(_simpleEntry);
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
                        }
                      }
                    }
                  }
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_2) != null))) {
                      _builder.append("\t");
                      _builder.append("<!--");
                      String diagram_2 = "";
                      _builder.append("-->");
                      _builder.newLineIfNotEmpty();
                      {
                        List<List<EduTestSuperGenerator.TestOption>> _get_3 = this.options.get(exercise).get(test_2);
                        boolean _tripleNotEquals = (_get_3 != null);
                        if (_tripleNotEquals) {
                          int rndIndex_1 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                          _builder.newLineIfNotEmpty();
                          {
                            List<EduTestSuperGenerator.TestOption> _get_4 = this.options.get(exercise).get(test_2).get(rndIndex_1);
                            for(final EduTestSuperGenerator.TestOption opt_1 : _get_4) {
                              {
                                int _size_1 = opt_1.text.size();
                                boolean _greaterThan_1 = (_size_1 > 0);
                                if (_greaterThan_1) {
                                  _builder.append("<!--");
                                  _builder.append(diagram_2 = opt_1.path);
                                  _builder.append("-->");
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                      {
                        boolean _equals_3 = diagram_2.equals("");
                        boolean _not = (!_equals_3);
                        if (_not) {
                          {
                            List<List<EduTestSuperGenerator.TestOption>> _get_5 = this.options.get(exercise).get(test_2);
                            boolean _tripleNotEquals_1 = (_get_5 != null);
                            if (_tripleNotEquals_1) {
                              int rndIndex_2 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_2));
                              _builder.newLineIfNotEmpty();
                              {
                                List<EduTestSuperGenerator.TestOption> _get_6 = this.options.get(exercise).get(test_2).get(rndIndex_2);
                                for(final EduTestSuperGenerator.TestOption opt_2 : _get_6) {
                                  List<String> textOptions_1 = new ArrayList<String>();
                                  _builder.newLineIfNotEmpty();
                                  {
                                    int _size_2 = opt_2.text.size();
                                    boolean _greaterThan_2 = (_size_2 > 0);
                                    if (_greaterThan_2) {
                                      {
                                        Set<String> _keySet_2 = opt_2.text.keySet();
                                        for(final String key_1 : _keySet_2) {
                                          {
                                            List<String> _get_7 = opt_2.text.get(key_1);
                                            for(final String text_1 : _get_7) {
                                              {
                                                boolean _contains = textOptions_1.contains(text_1);
                                                boolean _not_1 = (!_contains);
                                                if (_not_1) {
                                                  String _xblockexpression_5 = null;
                                                  {
                                                    textOptions_1.add(text_1);
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
                                    }
                                  }
                                }
                              }
                              {
                                List<EduTestSuperGenerator.TestOption> _get_8 = this.options.get(exercise).get(test_2).get(rndIndex_2);
                                for(final EduTestSuperGenerator.TestOption opt_3 : _get_8) {
                                  {
                                    if ((opt_3.solution == true)) {
                                      {
                                        int _size_3 = opt_3.text.size();
                                        boolean _greaterThan_3 = (_size_3 > 0);
                                        if (_greaterThan_3) {
                                          {
                                            Set<String> _keySet_3 = opt_3.text.keySet();
                                            for(final String key_2 : _keySet_3) {
                                              {
                                                List<String> _get_9 = opt_3.text.get(key_2);
                                                for(final String text_2 : _get_9) {
                                                  _builder.append("*");
                                                  String _trim = text_2.trim();
                                                  _builder.append(_trim);
                                                  _builder.append(";");
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
                                    if ((opt_3.solution == false)) {
                                      {
                                        int _size_4 = opt_3.text.size();
                                        boolean _greaterThan_4 = (_size_4 > 0);
                                        if (_greaterThan_4) {
                                          {
                                            Set<String> _keySet_4 = opt_3.text.keySet();
                                            for(final String key_3 : _keySet_4) {
                                              {
                                                List<String> _get_10 = opt_3.text.get(key_3);
                                                for(final String text_3 : _get_10) {
                                                  String _trim_1 = text_3.trim();
                                                  _builder.append(_trim_1);
                                                  _builder.append(";");
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
                  _builder.append("\t");
                  _builder.append("</item>");
                  _builder.newLine();
                }
              }
            }
          }
          {
            if ((exercise instanceof MatchPairs)) {
              _builder.append("\t");
              int min = Integer.MAX_VALUE;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int index = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t        ");
              int max = Integer.MIN_VALUE;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_3 = ((MatchPairs)exercise).getTests();
                for(final Test test_3 : _tests_3) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_3) != null))) {
                      _builder.append("\t\t\t\t\t\t\t");
                      _builder.append("<item>3;Match the correct option on the right with each of the statements on the left;");
                      _builder.newLine();
                      _builder.append("\t\t\t\t\t\t\t");
                      List<String> textOptions_2 = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int k = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int counter_1 = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t        ");
                      int rndIndex_3 = ModelManager.getRandomIndex(this.options.get(exercise).get(test_3));
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_11 = this.options.get(exercise).get(test_3).get(rndIndex_3);
                        for(final EduTestSuperGenerator.TestOption opt_4 : _get_11) {
                          {
                            Set<String> _keySet_5 = opt_4.text.keySet();
                            for(final String key_4 : _keySet_5) {
                              {
                                List<String> _get_12 = opt_4.text.get(key_4);
                                for(final String text_4 : _get_12) {
                                  {
                                    boolean _contains_1 = textOptions_2.contains(text_4);
                                    boolean _not_2 = (!_contains_1);
                                    if (_not_2) {
                                      String _xblockexpression_6 = null;
                                      {
                                        counter_1++;
                                        _xblockexpression_6 = "";
                                      }
                                      _builder.append(_xblockexpression_6);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append(text_4);
                                      _builder.append(";");
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_7 = null;
                                      {
                                        textOptions_2.add(text_4);
                                        _xblockexpression_7 = "";
                                      }
                                      _builder.append(_xblockexpression_7);
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
                        if ((counter_1 > max)) {
                          _builder.append("\t\t\t\t\t\t\t");
                          String _xblockexpression_8 = null;
                          {
                            max = counter_1;
                            _xblockexpression_8 = "";
                          }
                          _builder.append(_xblockexpression_8, "\t\t\t\t\t\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t\t\t\t");
                          String _xblockexpression_9 = null;
                          {
                            index = k;
                            _xblockexpression_9 = "";
                          }
                          _builder.append(_xblockexpression_9, "\t\t\t\t\t\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t\t\t\t\t\t");
                      String _xblockexpression_10 = null;
                      {
                        k++;
                        _xblockexpression_10 = "";
                      }
                      _builder.append(_xblockexpression_10, "\t\t\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      TreeMap<Integer, AbstractMap.SimpleEntry<String, String>> entries = new TreeMap<Integer, AbstractMap.SimpleEntry<String, String>>();
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_13 = this.options.get(exercise).get(test_3).get(rndIndex_3);
                        for(final EduTestSuperGenerator.TestOption op : _get_13) {
                          {
                            boolean _isExpression = test_3.isExpression();
                            boolean _equals_4 = (_isExpression == true);
                            if (_equals_4) {
                              String key_5 = this.getText(test_3.getIdentifier(), op.entry.getKey().getURI().toFileString(), resource);
                              _builder.newLineIfNotEmpty();
                              {
                                int _length = key_5.length();
                                boolean _lessEqualsThan = (_length <= 36);
                                if (_lessEqualsThan) {
                                  boolean found_1 = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    Set<Integer> _keySet_6 = entries.keySet();
                                    for(final int length : _keySet_6) {
                                      AbstractMap.SimpleEntry<String, String> entry_1 = entries.get(Integer.valueOf(length));
                                      _builder.newLineIfNotEmpty();
                                      {
                                        boolean _equals_5 = entry_1.getValue().equals(key_5);
                                        if (_equals_5) {
                                          String _xblockexpression_11 = null;
                                          {
                                            found_1 = true;
                                            _xblockexpression_11 = "";
                                          }
                                          _builder.append(_xblockexpression_11);
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found_1 == false)) {
                                      String _trim_2 = op.text.get(((Object[])Conversions.unwrapArray(op.text.keySet(), Object.class))[index]).get(index).trim();
                                      AbstractMap.SimpleEntry<String, String> entry_2 = new AbstractMap.SimpleEntry<String, String>(key_5, _trim_2);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_12 = null;
                                      {
                                        entries.put(Integer.valueOf(key_5.length()), entry_2);
                                        _xblockexpression_12 = "";
                                      }
                                      _builder.append(_xblockexpression_12);
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                      _builder.append("\t\t\t\t\t\t\t");
                      String question = test_3.getQuestion().replace("\"", "\'");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t\t\t\t\t");
                      int counter2 = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        Set<Integer> _keySet_7 = entries.keySet();
                        for(final int length_1 : _keySet_7) {
                          {
                            if ((counter2 < min)) {
                              _builder.append("\t\t\t\t\t\t\t");
                              AbstractMap.SimpleEntry<String, String> entry_3 = entries.get(Integer.valueOf(length_1));
                              _builder.newLineIfNotEmpty();
                              {
                                int _size_5 = textOptions_2.size();
                                int _minus = (_size_5 - 1);
                                IntegerRange _upTo = new IntegerRange(0, _minus);
                                for(final int i_1 : _upTo) {
                                  {
                                    String _get_14 = textOptions_2.get(i_1);
                                    int _length_1 = textOptions_2.get(i_1).length();
                                    int _minus_1 = (_length_1 - 1);
                                    boolean _equals_6 = _get_14.substring(0, _minus_1).equals(entry_3.getValue());
                                    if (_equals_6) {
                                      _builder.append("*");
                                      _builder.append(i_1);
                                      String _key = entry_3.getKey();
                                      String _plus = (question + _key);
                                      _builder.append(_plus);
                                      _builder.append(";");
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                      _builder.append("</item>");
                      _builder.newLine();
                    }
                  }
                }
              }
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("</array>");
      _builder.newLine();
      _builder.append("</resources>");
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
