package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import edutest.AlternativeResponse;
import edutest.MutatorTests;
import edutest.Program;
import edutest.Test;
import exceptions.ModelNotFoundException;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;
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
public class EduTestiOSAppGenerator extends EduTestSuperGenerator {
  private List<EObject> blocks;
  
  private String questionsSwift;
  
  private String viewControllerSwift;
  
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
        Iterable<Program> _filter = Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class);
        for (final Program p : _filter) {
          {
            if ((i == 0)) {
              this.viewControllerSwift = "../app/ios/tfgApp/ViewController.swift";
              this.questionsSwift = "../app/ios/tfgApp/Questions.swift";
            } else {
              this.viewControllerSwift = "../app/ios/tfgApp/ViewController.swift";
              this.questionsSwift = "../app/ios/tfgApp/Questions.swift";
            }
            fsa.generateFile(this.viewControllerSwift, this.compile(p, resource, fsa));
            fsa.generateFile(this.questionsSwift, this.compileQuestions(p, resource));
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
   * iOSApp code will be generated here!!
   */
  public CharSequence compile(final Program program, final Resource resource, final IFileSystemAccess2 fsa) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      String _xblockexpression = null;
      {
        this.buildOptions(program, resource, this.blocks, program.getClass());
        _xblockexpression = "";
      }
      _builder.append(_xblockexpression, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      TreeMap<Integer, String> drawable = new TreeMap<Integer, String>();
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      TreeMap<Integer, TreeMap<Integer, String>> drawableAnswer = new TreeMap<Integer, TreeMap<Integer, String>>();
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
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
                      _builder.append("\t\t");
                      String diagram = this.rand.get(exercise).get(test).get(0);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
                      String _plus = (_workspaceAbsolutePath + "/");
                      String _project = WodelContext.getProject();
                      String _plus_1 = (_plus + _project);
                      String _plus_2 = (_plus_1 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_3 = (_plus_2 + Integer.valueOf(i));
                      String diagramFolderName = (_plus_3 + ".imageset/");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      File diagramFolder = new File(diagramFolderName);
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _exists = diagramFolder.exists();
                        boolean _equals = (_exists == false);
                        if (_equals) {
                          _builder.append("\t\t");
                          String _xblockexpression_1 = null;
                          {
                            diagramFolder.mkdir();
                            _xblockexpression_1 = "";
                          }
                          _builder.append(_xblockexpression_1, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_4 = (_workspaceAbsolutePath_1 + "/");
                      String _project_1 = WodelContext.getProject();
                      String _plus_5 = (_plus_4 + _project_1);
                      String _plus_6 = (_plus_5 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_7 = (_plus_6 + Integer.valueOf(i));
                      String _plus_8 = (_plus_7 + ".imageset/ejercicio");
                      String _plus_9 = (_plus_8 + Integer.valueOf(i));
                      String diagramFileName = (_plus_9 + ".png");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_2 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_10 = (_workspaceAbsolutePath_2 + "/");
                      String _project_2 = WodelContext.getProject();
                      String _plus_11 = (_plus_10 + _project_2);
                      String _plus_12 = (_plus_11 + "/src-gen/html/diagrams/");
                      String _replace = test.getSource().replace(".model", "");
                      String _plus_13 = (_plus_12 + _replace);
                      String _plus_14 = (_plus_13 + "/");
                      String _plus_15 = (_plus_14 + diagram);
                      File _file = new File(_plus_15);
                      File _file_1 = new File(diagramFileName);
                      IOUtils.copyFile(_file, _file_1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String jsonDiagramFileName = (("../app/ios/tfgApp/Assets.xcassets/ejercicio" + Integer.valueOf(i)) + ".imageset/Contents.json");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      int _lastIndexOf = diagramFileName.lastIndexOf("/");
                      int _plus_16 = (_lastIndexOf + 1);
                      fsa.generateFile(jsonDiagramFileName, this.compileJsonDiagramFile(diagramFileName.substring(_plus_16, diagramFileName.length())));
                      _builder.append("  ");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _put = drawable.put(Integer.valueOf(i), (("ejercicio" + Integer.valueOf(i)) + ".png"));
                      _builder.append(_put, "\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _xblockexpression_2 = null;
                      {
                        i++;
                        _xblockexpression_2 = "";
                      }
                      _builder.append(_xblockexpression_2, "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("import UIKit");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ViewController: UIViewController {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//UI TRUE FALSE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var rbtnTrueFalse1: UIButton!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var rbtnTrueFalse2: UIButton!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var labelTrueFalse1: UILabel!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var labelTrueFalse2: UILabel!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//UI MULTISELECCION (usamos las de true/false)");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var imageEx: UIImageView!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var textQuestion : UILabel!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var backButton: UIButton!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBOutlet weak var nextButton: UIButton!");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("// FIN UI");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//private var idsAnswersRadio = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//private var idsanswersCheck = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var idsAnswersFalseTrue = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//private var idsAnswerDesplegable = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("//private var idsAnswerDesplegableText = [Int]()");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("// private var idsAnsweDesplegableSpinner = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var statements = [Int : Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var statementsAnswers = [Int : [Int : Int]]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var btnNext = UIButton()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var btnPrevious = UIButton()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var type : Int = -1");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var correctAnswer = [Int]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var currentQuestion = Int()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var answerIsCorrect = Bool()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var userAllAnswers = [String]()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("private var nAnswers : Int = 0");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("override func viewDidLoad() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("super.viewDidLoad()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("idsAnswersFalseTrue = [rbtnTrueFalse1.tag, rbtnTrueFalse2.tag]");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("correctAnswer=[0,0,0,0,0,0]");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("//Linkear todas las cosas que no tengo");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("reset()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("func reset() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("answerIsCorrect = Bool()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("userAllAnswers = [\"000000\",\"000000\",\"000000\",\"000000\",\"000000\",\"000000\",\"000000\"]");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("currentQuestion = 0");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("func showQuestion() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let question = allQuestions[currentQuestion]");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let partsQuestion = question.components(separatedBy: \";\")");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("textQuestion.text = partsQuestion[1]");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("//ejercicios true false");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (partsQuestion[0] == \"2\") {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse1.isHidden = false");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse2.isHidden = false");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("//rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("correctAnswer = [0,0,0,0,0,0]");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("//ocultar todas las cosas:");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion])!, targetSize : CGSize(width: 300, height: 300))");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("var answer1 = partsQuestion[2]");
      _builder.newLine();
      _builder.append("            ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("var answer2 = partsQuestion[3]");
      _builder.newLine();
      _builder.append("            ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("if(answer1.contains(\"*\")) {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("answer1 = String(answer1.dropFirst())");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("correctAnswer[0] = 1");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("correctAnswer[1] = 0");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("answer2 = String(answer2.dropFirst())");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("correctAnswer[0] = 0");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("correctAnswer[1] = 1");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("labelTrueFalse1.text = answer1");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("labelTrueFalse2.text = answer2");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("if(Array(userAllAnswers[currentQuestion])[0] == \"1\"){");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("rbtnTrueFalse1.isSelected = true");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("rbtnTrueFalse2.isSelected = true");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBAction func rbtnAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if sender.tag == 2 {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse1.isSelected = true");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("else if sender.tag == 4 {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("rbtnTrueFalse2.isSelected = true");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBAction func backButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if(currentQuestion > 0) {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("currentQuestion = currentQuestion - 1");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@IBAction func nextButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("currentQuestion = currentQuestion + 1");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("func ResizeImage(_ image: UIImage, targetSize: CGSize) -> UIImage? {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let size = image.size");
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let widthRatio  = targetSize.width  / image.size.width");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let heightRatio = targetSize.height / image.size.height");
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("// Figure out what our orientation is, and use that to form the rectangle");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("var newSize: CGSize");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if(widthRatio > heightRatio) {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("newSize = CGSize(width: size.width * heightRatio, height: size.height * heightRatio)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("newSize = CGSize(width: size.width * widthRatio, height: size.height * widthRatio)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("// This is the rect that we\'ve calculated out and this is what is actually used below");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let rect = CGRect(x: 0, y: 0, width: newSize.width, height: newSize.height)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("// Actually do the resizing to the rect using the ImageContext stuff");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("UIGraphicsBeginImageContextWithOptions(newSize, false, 1.0)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("image.draw(in: rect)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("let newImage = UIGraphicsGetImageFromCurrentImageContext()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("UIGraphicsEndImageContext()");
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return newImage");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * MobileApp code will be generated here!!
   */
  public CharSequence compileQuestions(final Program program, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    String _xblockexpression = null;
    {
      this.buildOptions(program, resource, this.blocks, program.getClass());
      _xblockexpression = "";
    }
    _builder.append(_xblockexpression, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    TreeMap<Integer, String> drawable = new TreeMap<Integer, String>();
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    TreeMap<Integer, TreeMap<Integer, String>> drawableAnswer = new TreeMap<Integer, TreeMap<Integer, String>>();
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
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
                    _builder.append("\t\t");
                    String diagram = this.rand.get(exercise).get(test).get(0);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.newLine();
                    _builder.append("\t\t");
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
          }
        }
      }
    }
    _builder.append("//");
    _builder.newLine();
    _builder.append("//  Questions.swift");
    _builder.newLine();
    _builder.append("//  tfgApp");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("//  Created by jaime on 5/12/21.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import Foundation");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("let allQuestions  =");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("[\"2;Is this true or false;*True;False\" ,\"2;Is this good or bad;*Good;Bad\"]");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("let allQuestionsImages = [\"ejercicio0\",\"ejercicio1\"]");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * MobileApp code will be generated here!!
   */
  public CharSequence compileJsonDiagramFile(final String diagramFileName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"images\" : [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"filename\" : \"");
    _builder.append(diagramFileName, "      ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("\"idiom\" : \"universal\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"scale\" : \"1x\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"idiom\" : \"universal\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"scale\" : \"2x\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"idiom\" : \"universal\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"scale\" : \"3x\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"info\" : {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"author\" : \"xcode\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"version\" : 1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}\t");
    return _builder;
  }
}
