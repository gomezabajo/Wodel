package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import edutest.AlternativeResponse;
import edutest.MultiChoiceDiagram;
import edutest.MultiChoiceEmendation;
import edutest.MutatorTests;
import edutest.Program;
import edutest.Test;
import exceptions.ModelNotFoundException;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import manager.IOUtils;
import manager.ModelManager;
import manager.WodelContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
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
  
  private String localProperties;
  
  private String xmlFileName;
  
  private String fileName;
  
  private String stringXmlFileName;
  
  private String stringXmlFileNameEs;
  
  private String userProfile = "C\\:\\\\Users\\\\User";
  
  private String currentDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).format(new Date(System.currentTimeMillis()));
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      WodelContext.setProject(null);
      ModelManager.setProjectNameByResource(resource);
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
        String userProfileValue = System.getenv("USERPROFILE");
        if (((userProfileValue != null) && (userProfileValue.length() > 0))) {
          String _substring = userProfileValue.substring(0, 1);
          String _plus_6 = (_substring + "\\");
          this.userProfile = _plus_6;
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
                int _plus_7 = (_indexOf_1 + 1);
                indexOfSlash = _plus_7;
              } else {
                int _length = userProfileValue.length();
                int _plus_8 = (_length + 1);
                indexOfSlash = _plus_8;
              }
              String _userProfile_2 = this.userProfile;
              String _substring_1 = userProfileValue.substring(0, (indexOfSlash - 1));
              String _plus_9 = (_substring_1 + "\\\\");
              this.userProfile = (_userProfile_2 + _plus_9);
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
          final ModelNotFoundException e = (ModelNotFoundException)_t;
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
      String _xblockexpression = null;
      {
        this.buildOptions(program, resource, this.blocks, program.getClass());
        _xblockexpression = "";
      }
      _builder.append(_xblockexpression);
      _builder.newLineIfNotEmpty();
      _builder.append("//");
      List<String> drawable = new ArrayList<String>();
      _builder.newLineIfNotEmpty();
      _builder.append("//");
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
                      _builder.append("//");
                      String diagram = this.rand.get(exercise).get(test).get(0);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//");
                      String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
                      String _plus = (_workspaceAbsolutePath + "/");
                      String _project = WodelContext.getProject();
                      String _plus_1 = (_plus + _project);
                      String _plus_2 = (_plus_1 + "/src-gen/html/diagrams/");
                      String _replace = test.getSource().replace(".model", "");
                      String _plus_3 = (_plus_2 + _replace);
                      String _plus_4 = (_plus_3 + "/");
                      String _plus_5 = (_plus_4 + diagram);
                      File _file = new File(_plus_5);
                      String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_6 = (_workspaceAbsolutePath_1 + "/");
                      String _project_1 = WodelContext.getProject();
                      String _plus_7 = (_plus_6 + _project_1);
                      String _plus_8 = (_plus_7 + "/app/mobile/app/src/main/res/drawable/q");
                      String _plus_9 = (_plus_8 + Integer.valueOf(i));
                      String _plus_10 = (_plus_9 + "_enunciado.png");
                      File _file_1 = new File(_plus_10);
                      IOUtils.copyFile(_file, _file_1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//");
                      boolean _add = drawable.add((("q" + Integer.valueOf(i)) + "_enunciado.png"));
                      _builder.append(_add);
                      _builder.newLineIfNotEmpty();
                      String _xblockexpression_1 = null;
                      {
                        i++;
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
      _builder.append("package org.example.esquematfg;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import androidx.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import androidx.appcompat.app.AlertDialog;");
      _builder.newLine();
      _builder.append("import androidx.appcompat.app.AppCompatActivity;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import android.content.DialogInterface;");
      _builder.newLine();
      _builder.append("import android.content.res.Resources;");
      _builder.newLine();
      _builder.append("import android.graphics.Bitmap;");
      _builder.newLine();
      _builder.append("import android.graphics.BitmapFactory;");
      _builder.newLine();
      _builder.append("import android.graphics.drawable.BitmapDrawable;");
      _builder.newLine();
      _builder.append("import android.graphics.drawable.Drawable;");
      _builder.newLine();
      _builder.append("import android.media.Image;");
      _builder.newLine();
      _builder.append("import android.os.Bundle;");
      _builder.newLine();
      _builder.append("import android.util.DisplayMetrics;");
      _builder.newLine();
      _builder.append("import android.util.Log;");
      _builder.newLine();
      _builder.append("import android.view.View;");
      _builder.newLine();
      _builder.append("import android.widget.Button;");
      _builder.newLine();
      _builder.append("import android.widget.CheckBox;");
      _builder.newLine();
      _builder.append("import android.widget.ImageView;");
      _builder.newLine();
      _builder.append("import android.widget.RadioButton;");
      _builder.newLine();
      _builder.append("import android.widget.RadioGroup;");
      _builder.newLine();
      _builder.append("import android.widget.TextView;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.io.FileOutputStream;");
      _builder.newLine();
      _builder.append("import java.io.IOException;");
      _builder.newLine();
      _builder.append("import java.io.InputStream;");
      _builder.newLine();
      _builder.append("import java.net.HttpURLConnection;");
      _builder.newLine();
      _builder.append("import java.net.URL;");
      _builder.newLine();
      _builder.append("import java.net.URLConnection;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class MainActivity extends AppCompatActivity {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private int ids_answers_false_true[] = {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("R.id.true_solution, R.id.false_solution");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("};");
      _builder.newLine();
      _builder.append("            ");
      _builder.newLine();
      {
        int _size_1 = drawable.size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          _builder.append("private int statements[] = {");
          _builder.newLine();
          _builder.append("\t");
          String _xblockexpression_2 = null;
          {
            i = 0;
            _xblockexpression_2 = "";
          }
          _builder.append(_xblockexpression_2, "\t");
          _builder.newLineIfNotEmpty();
          {
            for(final String d : drawable) {
              {
                int _size_2 = drawable.size();
                int _minus = (_size_2 - 1);
                boolean _lessThan = (i < _minus);
                if (_lessThan) {
                  _builder.append("\t");
                  _builder.append("R.drawable.q");
                  _builder.append(i, "\t");
                  _builder.append("_enunciado,");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _xblockexpression_3 = null;
                  {
                    i++;
                    _xblockexpression_3 = "";
                  }
                  _builder.append(_xblockexpression_3, "\t");
                  _builder.append(" ");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("R.drawable.q");
          _builder.append(i, "\t");
          _builder.append("_enunciado");
          _builder.newLineIfNotEmpty();
          _builder.append("};");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private String[] all_questions;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private TextView text_question;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private RadioGroup radio_true_false;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private Button btn_next, btn_previous;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private int type = -1;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private String correct_answer;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private int current_question;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private boolean[] answer_is_correct;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private String[] user_all_answers;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private int current_statement = 0;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("protected void onSaveInstanceState(@NonNull Bundle outState) {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("super.onSaveInstanceState(outState);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("outState.putString(\"correct_answer\", correct_answer);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("outState.putInt(\"current_question\", current_question);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("outState.putBooleanArray(\"answer_is_correct\", answer_is_correct);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("outState.putStringArray(\"user_all_answers\", user_all_answers);");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("protected void onCreate(Bundle savedInstanceState) {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("super.onCreate(savedInstanceState);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("setContentView(R.layout.activity_main);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("text_question = (TextView) findViewById(R.id.text_question);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("radio_true_false = (RadioGroup) findViewById(R.id.answer_true_false);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("btn_next = (Button) findViewById(R.id.btn_check);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("btn_previous = (Button) findViewById(R.id.btn_previous);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("all_questions = getResources().getStringArray(R.array.all_questions);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("correct_answer = \"0000\";");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("if (savedInstanceState == null){");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("reset();");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("correct_answer = savedInstanceState.getString(\"correct_answer\");");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("current_question = savedInstanceState.getInt(\"current_question\");");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("answer_is_correct = savedInstanceState.getBooleanArray(\"answer_is_correct\");");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("user_all_answers = savedInstanceState.getStringArray(\"user_all_answers\");");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("               ");
      _builder.append("btn_next.setOnClickListener(new View.OnClickListener() {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("public void onClick(View v) {");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("checkAnswer();");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("current_statement = current_statement < statements.length - 1 ? current_statement + 1 : statements.length - 1;");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("if (current_question < all_questions.length - 1) {");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("current_question++;");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("                          ");
      _builder.append("checkResults();");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("btn_previous.setOnClickListener(new View.OnClickListener() {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("public void onClick(View v) {");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("checkAnswer();");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("current_statement = current_statement > 0 ? current_statement - 1 : 0;");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("if (current_question > 0) {");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("current_question--;");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private void reset() {");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("answer_is_correct = new boolean[all_questions.length];");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("user_all_answers = new String[all_questions.length];");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("correct_answer = \"0000\";");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("for (int i = 0; i < user_all_answers.length; i++) {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("user_all_answers[i] = \"0000\";");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("current_question = 0;");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("current_statement = 0;");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("showQuestion();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("private void checkResults() {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("int correctas = 0, incorrectas = 0, nocontestadas = 0;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("for (int i = 0; i < all_questions.length; i++) {");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("if (answer_is_correct[i]) correctas++;");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("else if (user_all_answers[i] == \"0000\") nocontestadas++;");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("else incorrectas++;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("// TODO: Traduccion del texto mediante recusos");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("String res = String.format(\"Correctas: %d\\nIncorrectas: %d\\nNo contestadas: %d\",");
      _builder.newLine();
      _builder.append("                            ");
      _builder.append("correctas, incorrectas, nocontestadas);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("AlertDialog.Builder builder = new AlertDialog.Builder(this);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("builder.setTitle(R.string.results);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("builder.setMessage(res);");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("//Suele haber el boton negativo(cancel) y el positivo(ok)");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("builder.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("public void onClick(DialogInterface dialog, int which) {");
      _builder.newLine();
      _builder.append("                        ");
      _builder.append("finish();");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() {");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("public void onClick(DialogInterface dialog, int which) {");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("reset();");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("builder.create().show();");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("           ");
      _builder.append("private void checkAnswer() {");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("String response_user = \"0000\";");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("if (type == 2) {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("int id = radio_true_false.getCheckedRadioButtonId();");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("for (int i = 0; i < ids_answers_false_true.length; i++) {");
      _builder.newLine();
      _builder.append("                        ");
      _builder.append("if (ids_answers_false_true[i] == id) {");
      _builder.newLine();
      _builder.append("                            ");
      _builder.append("char[] aux = response_user.toCharArray();");
      _builder.newLine();
      _builder.append("                            ");
      _builder.append("aux[i] = \'1\';");
      _builder.newLine();
      _builder.append("                            ");
      _builder.append("response_user = new String(aux);");
      _builder.newLine();
      _builder.append("                        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("answer_is_correct[current_question] = (response_user.equals(correct_answer));");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("user_all_answers[current_question] = response_user;");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("           ");
      _builder.append("private void showQuestion() {");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("String q = all_questions[current_question];");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("//Partimos el string con la pregunta y respuestas en trozos");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("String[] parts = q.split(\";\");");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("text_question.setText(parts[1]);");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);");
      _builder.newLine();
      _builder.append("               ");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("if (parts[0].charAt(0) == \'2\') {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("type = 2;");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("radio_true_false.setVisibility((View.VISIBLE));");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("correct_answer = \"0000\";");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("radio_true_false.clearCheck();");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("Drawable img2 = text_question.getContext().getResources().getDrawable(statements[current_statement]);");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("Bitmap b = ((BitmapDrawable) img2).getBitmap();");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth() / 2, b.getHeight() / 2, true));");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("Bitmap b2 = ((BitmapDrawable) d).getBitmap();");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, new BitmapDrawable(getResources(), b2));");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("for (int i = 0; i < parts.length - 2; i++) {");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("RadioButton rb = (RadioButton) findViewById(ids_answers_false_true[i]);");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("String answer = parts[i+2];");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("if (answer.charAt(0) == \'*\') {");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("char[] aux = correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("aux[i] = \'1\';");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("correct_answer = new String(aux);");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("answer = answer.substring(1);");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("char[] aux = correct_answer.toCharArray();");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("aux[i] = \'0\';");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("correct_answer = new String(aux);");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("rb.setText(answer);");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("if (user_all_answers[current_question].charAt(i) == \'1\') {");
      _builder.newLine();
      _builder.append("                           ");
      _builder.append("rb.setChecked(true);");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("if (current_question == 0) {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("btn_previous.setVisibility(View.GONE);");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("btn_previous.setVisibility(View.VISIBLE);");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("if (current_question == all_questions.length - 1) {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("btn_next.setText(R.string.finish);");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("btn_next.setText(R.string.next);");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("       ");
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
    _builder.append("        ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("android:layout_height=\"match_parent\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<LinearLayout");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("android:orientation=\"vertical\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<TextView");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:id=\"@+id/text_question\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_height=\"190dp\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:text=\"TextView\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:textColor=\"?android:attr/textColorPrimary\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:textSize=\"18sp\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<!--");
    boolean visible = false;
    _builder.append("-->");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("<View");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:id=\"@+id/ruler\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_width=\"match_parent\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_height=\"1dp\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_below=\"@id/text_question\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:background=\"#070707\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("tools:ignore=\"MissingConstraints\" />");
    _builder.newLine();
    {
      if ((true_false_questions == true)) {
        {
          if ((visible == false)) {
            _builder.append("\t\t");
            String _xblockexpression_3 = null;
            {
              visible = true;
              _xblockexpression_3 = "";
            }
            _builder.append(_xblockexpression_3, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("<RadioGroup");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer_true_false\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"188dp\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("\t\t        ");
            _builder.append("android:visibility=\"visible\">");
            _builder.newLine();
          } else {
            _builder.append("\t\t        ");
            _builder.append("android:visibility=\"gone\">");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/true_solution\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"True\" />");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/false_solution\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"False\" />");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</RadioGroup>");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      if ((single_option_questions == true)) {
        {
          if ((visible == false)) {
            _builder.append("\t\t");
            String _xblockexpression_4 = null;
            {
              visible = true;
              _xblockexpression_4 = "";
            }
            _builder.append(_xblockexpression_4, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("<RadioGroup");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer_group\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"match_parent\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("\t\t        ");
            _builder.append("android:visibility=\"visible\">");
            _builder.newLine();
          } else {
            _builder.append("\t\t        ");
            _builder.append("android:visibility=\"gone\">");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("<!--");
        _builder.append("-->");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer1\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\" \" />");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t        ");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer2\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\" \" />");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t        ");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer3\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"match_parent\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\" \" />");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t        ");
        _builder.append("<RadioButton");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/answer4\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\" \" />");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t        ");
        _builder.append("</RadioGroup>");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      if ((multiple_option_questions == true)) {
        {
          if ((visible == false)) {
            _builder.append("\t\t");
            String _xblockexpression_5 = null;
            {
              visible = true;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("<!--");
        _builder.append("-->");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("<CheckBox");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/check_box1\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"CheckBox\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("tools:visibility=\"visible\" />");
            _builder.newLine();
          } else {
            _builder.append("tools:visibility=\"gone\" />");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("                ");
        _builder.append("<CheckBox");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/check_box2\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"CheckBox\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("tools:visibility=\"visible\" />");
            _builder.newLine();
          } else {
            _builder.append("tools:visibility=\"gone\" />");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("                ");
        _builder.append("<CheckBox");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/check_box3\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"CheckBox\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("tools:visibility=\"visible\" />");
            _builder.newLine();
          } else {
            _builder.append("tools:visibility=\"gone\" />");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("                ");
        _builder.append("<CheckBox");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:id=\"@+id/check_box4\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_width=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:layout_height=\"wrap_content\"");
        _builder.newLine();
        _builder.append("\t\t                    ");
        _builder.append("android:text=\"CheckBox\"");
        _builder.newLine();
        {
          if ((visible == true)) {
            _builder.append("tools:visibility=\"visible\" />");
            _builder.newLine();
          } else {
            _builder.append("tools:visibility=\"gone\" />");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<Button");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:id=\"@+id/btn_check\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:text=\"@string/next\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<Button");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:id=\"@+id/btn_previous\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_width=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:layout_height=\"wrap_content\"");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("android:text=\"@string/previous\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</LinearLayout>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</ScrollView>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</androidx.constraintlayout.widget.ConstraintLayout>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * String values XML MobileApp code will be generated here!!
   */
  public CharSequence stringXmlCompile(final Program program, final Resource resource) {
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
                    String diagram = this.rand.get(exercise).get(test).get(0);
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
            _builder.append("\t");
            _builder.append("<!--");
            _builder.append("-->");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<!--<item>0;Aqui iria el enunciado de la pregunta 1?(seleccion unica);Esta seria la opcion 1 e incorrecta;Esta seria la opcion 2 e incorrecta;*Esta seria la opcion 3 y correcta;Esta seria la opcion 4 e incorrecta</item>-->");
            _builder.newLine();
          }
        }
        {
          if ((exercise instanceof MultiChoiceEmendation)) {
            _builder.append("\t");
            _builder.append("<!--");
            _builder.append("-->");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->");
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
  }
  
  /**
   * String values XML MobileApp code will be generated here!!
   */
  public CharSequence stringXmlCompileEs(final Program program, final Resource resource) {
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
                    String diagram = this.rand.get(exercise).get(test).get(0);
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
            _builder.append("\t");
            _builder.append("<!--");
            _builder.append("-->");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<!--<item>0;Aqui iria el enunciado de la pregunta 1?(seleccion unica);Esta seria la opcion 1 e incorrecta;Esta seria la opcion 2 e incorrecta;*Esta seria la opcion 3 y correcta;Esta seria la opcion 4 e incorrecta</item>-->");
            _builder.newLine();
          }
        }
        {
          if ((exercise instanceof MultiChoiceEmendation)) {
            _builder.append("\t");
            _builder.append("<!--");
            _builder.append("-->");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->");
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
  }
}
