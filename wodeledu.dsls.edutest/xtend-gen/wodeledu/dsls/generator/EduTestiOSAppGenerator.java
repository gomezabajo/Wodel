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
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.osgi.framework.Bundle;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

@SuppressWarnings("all")
public class EduTestiOSAppGenerator extends EduTestSuperGenerator {
  private List<EObject> blocks;

  private String questionsSwift;

  private String examViewControllerSwift;

  private TreeMap<Integer, String> drawable = new TreeMap<Integer, String>();

  private TreeMap<Integer, TreeMap<Integer, String>> drawableAnswer = new TreeMap<Integer, TreeMap<Integer, String>>();

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      ProjectUtils.resetProject();
      this.project = ProjectUtils.getProject();
      try {
        int i = 0;
        String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
        String _plus = ("file:/" + _workspaceAbsolutePath);
        String _plus_1 = (_plus + "/");
        String _name = this.project.getName();
        String _plus_2 = (_plus_1 + _name);
        String _plus_3 = (_plus_2 + 
          "/");
        String _outputFolder = ModelManager.getOutputFolder();
        String _plus_4 = (_plus_3 + _outputFolder);
        String _plus_5 = (_plus_4 + "/");
        String _replaceAll = resource.getURI().lastSegment().replaceAll(".test", ".model");
        String xmiFileName = (_plus_5 + _replaceAll);
        final Bundle bundle = Platform.getBundle("wodel.models");
        final URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
        final String mutatorecore = FileLocator.resolve(fileURL).getFile();
        final List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
        final Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
        this.blocks = ModelManager.getObjectsOfType("Block", mutatormodel);
        Iterable<Program> _filter = Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class);
        for (final Program p : _filter) {
          {
            if ((i == 0)) {
              this.examViewControllerSwift = "../app/ios/tfgApp/ExamViewController.swift";
              this.questionsSwift = "../app/ios/tfgApp/Questions.swift";
            } else {
              this.examViewControllerSwift = "../app/ios/tfgApp/ExamViewController.swift";
              this.questionsSwift = "../app/ios/tfgApp/Questions.swift";
            }
            fsa.generateFile(this.examViewControllerSwift, this.compile(p, resource, fsa));
            fsa.generateFile(this.questionsSwift, this.compileQuestions(p, resource));
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
   * iOSApp code will be generated here!!
   */
  public CharSequence compile(final Program program, final Resource resource, final IFileSystemAccess2 fsa) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      String _xblockexpression = null;
      {
        this.buildOptions(program, resource, this.blocks, program.getClass());
        _xblockexpression = "";
      }
      _builder.append(_xblockexpression);
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
                      String _name = this.project.getName();
                      String _plus_1 = (_plus + _name);
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
                            diagramFolder.mkdirs();
                            _xblockexpression_1 = "";
                          }
                          _builder.append(_xblockexpression_1, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_1 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_4 = (_workspaceAbsolutePath_1 + "/");
                      String _name_1 = this.project.getName();
                      String _plus_5 = (_plus_4 + _name_1);
                      String _plus_6 = (_plus_5 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_7 = (_plus_6 + Integer.valueOf(i));
                      String _plus_8 = (_plus_7 + ".imageset/ejercicio");
                      String _plus_9 = (_plus_8 + Integer.valueOf(i));
                      String diagramFileName = (_plus_9 + ".png");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _workspaceAbsolutePath_2 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_10 = (_workspaceAbsolutePath_2 + "/");
                      String _name_2 = this.project.getName();
                      String _plus_11 = (_plus_10 + _name_2);
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
                      _builder.append("//");
                      int _lastIndexOf = diagramFileName.lastIndexOf("/");
                      int _plus_16 = (_lastIndexOf + 1);
                      fsa.generateFile(jsonDiagramFileName, this.compileJsonDiagramFile(diagramFileName.substring(_plus_16, diagramFileName.length())));
                      _builder.append("  ");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _put = this.drawable.put(Integer.valueOf(i), (("ejercicio" + Integer.valueOf(i)) + ".png"));
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
          {
            if ((exercise instanceof MultiChoiceEmendation)) {
              {
                EList<Test> _tests_1 = ((MultiChoiceEmendation)exercise).getTests();
                for(final Test test_1 : _tests_1) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_1) != null))) {
                      {
                        List<EduTestSuperGenerator.TestOption> _get = this.options.get(exercise).get(test_1);
                        boolean _tripleNotEquals = (_get != null);
                        if (_tripleNotEquals) {
                          {
                            List<EduTestSuperGenerator.TestOption> _get_1 = this.options.get(exercise).get(test_1);
                            for(final EduTestSuperGenerator.TestOption opt : _get_1) {
                              {
                                int _size_1 = opt.text.size();
                                boolean _greaterThan_1 = (_size_1 > 0);
                                if (_greaterThan_1) {
                                  {
                                    if ((opt.solution == true)) {
                                      _builder.append("\t\t");
                                      String _workspaceAbsolutePath_3 = ModelManager.getWorkspaceAbsolutePath();
                                      String _plus_17 = (_workspaceAbsolutePath_3 + "/");
                                      String _name_3 = this.project.getName();
                                      String _plus_18 = (_plus_17 + _name_3);
                                      String _plus_19 = (_plus_18 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                                      String _plus_20 = (_plus_19 + Integer.valueOf(i));
                                      String diagramFolderName_1 = (_plus_20 + ".imageset/");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      File diagramFolder_1 = new File(diagramFolderName_1);
                                      _builder.newLineIfNotEmpty();
                                      {
                                        boolean _exists_1 = diagramFolder_1.exists();
                                        boolean _equals_1 = (_exists_1 == false);
                                        if (_equals_1) {
                                          _builder.append("\t\t");
                                          String _xblockexpression_3 = null;
                                          {
                                            diagramFolder_1.mkdirs();
                                            _xblockexpression_3 = "";
                                          }
                                          _builder.append(_xblockexpression_3, "\t\t");
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      String diagram_1 = opt.path;
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      String _workspaceAbsolutePath_4 = ModelManager.getWorkspaceAbsolutePath();
                                      String _plus_21 = (_workspaceAbsolutePath_4 + "/");
                                      String _name_4 = this.project.getName();
                                      String _plus_22 = (_plus_21 + _name_4);
                                      String _plus_23 = (_plus_22 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                                      String _plus_24 = (_plus_23 + Integer.valueOf(i));
                                      String _plus_25 = (_plus_24 + ".imageset/enunciado");
                                      String _plus_26 = (_plus_25 + Integer.valueOf(i));
                                      String diagramFileName_1 = (_plus_26 + ".png");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      _builder.append("//");
                                      String _workspaceAbsolutePath_5 = ModelManager.getWorkspaceAbsolutePath();
                                      String _plus_27 = (_workspaceAbsolutePath_5 + "/");
                                      String _name_5 = this.project.getName();
                                      String _plus_28 = (_plus_27 + _name_5);
                                      String _plus_29 = (_plus_28 + "/src-gen/html/");
                                      String _plus_30 = (_plus_29 + diagram_1);
                                      File _file_2 = new File(_plus_30);
                                      File _file_3 = new File(diagramFileName_1);
                                      IOUtils.copyFile(_file_2, _file_3);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      String jsonDiagramFileName_1 = (("../app/ios/tfgApp/Assets.xcassets/ejercicio" + Integer.valueOf(i)) + ".imageset/Contents.json");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      _builder.append("//");
                                      int _lastIndexOf_1 = diagramFileName_1.lastIndexOf("/");
                                      int _plus_31 = (_lastIndexOf_1 + 1);
                                      fsa.generateFile(jsonDiagramFileName_1, this.compileJsonDiagramFile(diagramFileName_1.substring(_plus_31, diagramFileName_1.length())));
                                      _builder.append("  ");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      _builder.append("//");
                                      String _put_1 = this.drawable.put(Integer.valueOf(i), (("ejercicio" + Integer.valueOf(i)) + ".png"));
                                      _builder.append(_put_1, "\t\t\t");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("\t");
                                      String _xblockexpression_4 = null;
                                      {
                                        i++;
                                        _xblockexpression_4 = "";
                                      }
                                      _builder.append(_xblockexpression_4, "\t\t\t");
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
                  _builder.append("\t\t");
                  int j = 0;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  TreeMap<Integer, String> diccAux = new TreeMap<Integer, String>();
                  _builder.newLineIfNotEmpty();
                  {
                    List<String> _get_2 = this.diagrams.get(exercise).get(test_2);
                    for(final String diag : _get_2) {
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_6 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_32 = (_workspaceAbsolutePath_6 + "/");
                      String _name_6 = this.project.getName();
                      String _plus_33 = (_plus_32 + _name_6);
                      String _plus_34 = (_plus_33 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_35 = (_plus_34 + Integer.valueOf(i));
                      String _plus_36 = (_plus_35 + "respuesta");
                      String _plus_37 = (_plus_36 + Integer.valueOf(j));
                      String diagramFolderName_2 = (_plus_37 + ".imageset/");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      File diagramFolder_2 = new File(diagramFolderName_2);
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _exists_2 = diagramFolder_2.exists();
                        boolean _equals_2 = (_exists_2 == false);
                        if (_equals_2) {
                          _builder.append("\t\t");
                          String _xblockexpression_5 = null;
                          {
                            diagramFolder_2.mkdirs();
                            _xblockexpression_5 = "";
                          }
                          _builder.append(_xblockexpression_5, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_7 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_38 = (_workspaceAbsolutePath_7 + "/");
                      String _name_7 = this.project.getName();
                      String _plus_39 = (_plus_38 + _name_7);
                      String _plus_40 = (_plus_39 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_41 = (_plus_40 + Integer.valueOf(i));
                      String _plus_42 = (_plus_41 + "respuesta");
                      String _plus_43 = (_plus_42 + Integer.valueOf(j));
                      String _plus_44 = (_plus_43 + ".imageset/ejercicio");
                      String _plus_45 = (_plus_44 + Integer.valueOf(i));
                      String _plus_46 = (_plus_45 + "respuesta");
                      String _plus_47 = (_plus_46 + Integer.valueOf(j));
                      String diagramFileName_2 = (_plus_47 + ".png");
                      _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _workspaceAbsolutePath_8 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_48 = (_workspaceAbsolutePath_8 + "/");
                      String _name_8 = this.project.getName();
                      String _plus_49 = (_plus_48 + _name_8);
                      String _plus_50 = (_plus_49 + "/src-gen/html/diagrams/");
                      String _replace_1 = test_2.getSource().replace(".model", "");
                      String _plus_51 = (_plus_50 + _replace_1);
                      String _plus_52 = (_plus_51 + "/");
                      String _plus_53 = (_plus_52 + diag);
                      File _file_4 = new File(_plus_53);
                      File _file_5 = new File(diagramFileName_2);
                      IOUtils.copyFile(_file_4, _file_5);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String jsonDiagramFileName_2 = (((("../app/ios/tfgApp/Assets.xcassets/ejercicio" + Integer.valueOf(i)) + "respuesta") + Integer.valueOf(j)) + ".imageset/Contents.json");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      int _lastIndexOf_2 = diagramFileName_2.lastIndexOf("/");
                      int _plus_54 = (_lastIndexOf_2 + 1);
                      fsa.generateFile(jsonDiagramFileName_2, this.compileJsonDiagramFile(diagramFileName_2.substring(_plus_54, diagramFileName_2.length())));
                      _builder.append("  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _put_2 = diccAux.put(Integer.valueOf(j), (((("ejercicio" + Integer.valueOf(i)) + "respuesta") + Integer.valueOf(j)) + ".png"));
                      _builder.append(_put_2, "\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _xblockexpression_6 = null;
                      {
                        j++;
                        _xblockexpression_6 = "";
                      }
                      _builder.append(_xblockexpression_6, "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t\t");
                  _builder.append("//");
                  TreeMap<Integer, String> _put_3 = this.drawableAnswer.put(Integer.valueOf(i), diccAux);
                  _builder.append(_put_3, "\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t");
                  String _xblockexpression_7 = null;
                  {
                    i++;
                    _xblockexpression_7 = "";
                  }
                  _builder.append(_xblockexpression_7, "\t\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          {
            if ((exercise instanceof MatchPairs)) {
              _builder.append("\t\t\t\t\t\t\t        ");
              int min = Integer.MAX_VALUE;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t\t\t\t    ");
              int index = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t\t\t\t    ");
              int max = Integer.MIN_VALUE;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_3 = ((MatchPairs)exercise).getTests();
                for(final Test test_3 : _tests_3) {
                  {
                    if (((this.options.get(exercise) != null) && (this.options.get(exercise).get(test_3) != null))) {
                      _builder.append("\t\t");
                      List<String> textOptions = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      int k = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      int counter = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_3 = this.options.get(exercise).get(test_3);
                        for(final EduTestSuperGenerator.TestOption opt_1 : _get_3) {
                          {
                            Set<String> _keySet = opt_1.text.keySet();
                            for(final String key : _keySet) {
                              {
                                List<String> _get_4 = opt_1.text.get(key);
                                for(final String text : _get_4) {
                                  {
                                    boolean _contains = textOptions.contains(text);
                                    boolean _not = (!_contains);
                                    if (_not) {
                                      String _xblockexpression_8 = null;
                                      {
                                        counter++;
                                        _xblockexpression_8 = "";
                                      }
                                      _builder.append(_xblockexpression_8);
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_9 = null;
                                      {
                                        textOptions.add(text);
                                        _xblockexpression_9 = "";
                                      }
                                      _builder.append(_xblockexpression_9);
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
                          _builder.append("\t\t");
                          String _xblockexpression_10 = null;
                          {
                            max = counter;
                            _xblockexpression_10 = "";
                          }
                          _builder.append(_xblockexpression_10, "\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          String _xblockexpression_11 = null;
                          {
                            index = k;
                            _xblockexpression_11 = "";
                          }
                          _builder.append(_xblockexpression_11, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      String _xblockexpression_12 = null;
                      {
                        k++;
                        _xblockexpression_12 = "";
                      }
                      _builder.append(_xblockexpression_12, "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder.append("\t\t");
              int k_1 = 0;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_4 = ((MatchPairs)exercise).getTests();
                for(final Test test_4 : _tests_4) {
                  _builder.append("\t\t");
                  EduTestSuperGenerator.TestOption opt_2 = null;
                  _builder.newLineIfNotEmpty();
                  {
                    if (((this.options.get(exercise).get(test_4) != null) && (this.options.get(exercise).get(test_4).size() > index))) {
                      _builder.append("\t\t");
                      _builder.append("//");
                      _builder.append(opt_2 = this.options.get(exercise).get(test_4).get(index), "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if ((opt_2 != null)) {
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_9 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_55 = (_workspaceAbsolutePath_9 + "/");
                      String _name_9 = this.project.getName();
                      String _plus_56 = (_plus_55 + _name_9);
                      String _plus_57 = (_plus_56 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_58 = (_plus_57 + Integer.valueOf(i));
                      String diagramFolderName_3 = (_plus_58 + ".imageset/");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      File diagramFolder_3 = new File(diagramFolderName_3);
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _exists_3 = diagramFolder_3.exists();
                        boolean _equals_3 = (_exists_3 == false);
                        if (_equals_3) {
                          _builder.append("\t\t");
                          String _xblockexpression_13 = null;
                          {
                            diagramFolder_3.mkdirs();
                            _xblockexpression_13 = "";
                          }
                          _builder.append(_xblockexpression_13, "\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t\t\t\t\t\t\t\t\t    ");
                      String diagram_2 = opt_2.path;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _workspaceAbsolutePath_10 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_59 = (_workspaceAbsolutePath_10 + "/");
                      String _name_10 = this.project.getName();
                      String _plus_60 = (_plus_59 + _name_10);
                      String _plus_61 = (_plus_60 + "/app/ios/tfgApp/Assets.xcassets/ejercicio");
                      String _plus_62 = (_plus_61 + Integer.valueOf(i));
                      String _plus_63 = (_plus_62 + ".imageset/ejercicio");
                      String _plus_64 = (_plus_63 + Integer.valueOf(i));
                      String diagramFileName_3 = (_plus_64 + ".png");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _workspaceAbsolutePath_11 = ModelManager.getWorkspaceAbsolutePath();
                      String _plus_65 = (_workspaceAbsolutePath_11 + "/");
                      String _name_11 = this.project.getName();
                      String _plus_66 = (_plus_65 + _name_11);
                      String _plus_67 = (_plus_66 + "/src-gen/html/");
                      String _plus_68 = (_plus_67 + diagram_2);
                      File _file_6 = new File(_plus_68);
                      File _file_7 = new File(diagramFileName_3);
                      IOUtils.copyFile(_file_6, _file_7);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String jsonDiagramFileName_3 = (("../app/ios/tfgApp/Assets.xcassets/ejercicio" + Integer.valueOf(i)) + ".imageset/Contents.json");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      int _lastIndexOf_3 = diagramFileName_3.lastIndexOf("/");
                      int _plus_69 = (_lastIndexOf_3 + 1);
                      fsa.generateFile(jsonDiagramFileName_3, this.compileJsonDiagramFile(diagramFileName_3.substring(_plus_69, diagramFileName_3.length())));
                      _builder.append("  ");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      _builder.append("//");
                      String _put_4 = this.drawable.put(Integer.valueOf(i), (("ejercicio" + Integer.valueOf(i)) + ".png"));
                      _builder.append(_put_4, "\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t");
                      String _xblockexpression_14 = null;
                      {
                        i++;
                        _xblockexpression_14 = "";
                      }
                      _builder.append(_xblockexpression_14, "\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.append("import UIKit");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class ExamViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t   \t\t");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("//UI TRUE FALSE");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnTrueFalse1: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnTrueFalse2: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelTrueFalse1: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelTrueFalse2: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("//UI Imgs respuestas");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnImg1: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageAnswer1: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnImg2: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageAnswer2: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnImg3: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageAnswer3: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnImg4: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageAnswer4: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var rbtnImg5: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageAnswer5: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var imageEx: UIImageView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var textQuestion : UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var backButton: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var nextButton: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var endButton: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var undoButton: UIButton!\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("//UI multiseleccion");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection1: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection1: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection2: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection2: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection3: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection3: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection4: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection4: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection5: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection5: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnSelection6: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelSelection6: UILabel!\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("//UI cajas");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList1: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList1: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView1: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray1 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList2: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList2: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView2: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray2 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList3: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList3: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView3: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray3 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList4: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList4: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView4: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray4 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList5: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList5: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView5: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray5 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var labelDropDownList6: UILabel!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var btnDropDownList6: UIButton!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@IBOutlet weak var tableView6: UITableView!");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("var dataSourceArray6 = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("// FIN UI");
      _builder.newLine();
      _builder.append("\t\t   \t\t    ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answersFalseTrue = [Int]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answersImg = [Int : [Int : String]]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var btnNext = UIButton()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var btnPrevious = UIButton()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var exerciseType : Int = -1");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var correctAnswer = [Int]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var currentQuestion = Int()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerIsCorrect = Bool()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var userAllAnswers = [String]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var nAnswers : Int = 0");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var userAnswerIsCorrect = [Bool]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerImgsArray = [UIImageView]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerBtnsArray = [UIButton]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerCheckBoxArray = [UIButton]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerLabelCheckBoxArray = [UILabel]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var questionLabelListArray = [UILabel]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var answerListBtnsArray = [UIButton]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("private var tablesViewArray = [UITableView]()");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("override func viewDidLoad() {");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("super.viewDidLoad()");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("//array botones ejs0");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerBtnsArray.append(rbtnImg1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerBtnsArray.append(rbtnImg2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerBtnsArray.append(rbtnImg3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerBtnsArray.append(rbtnImg4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerBtnsArray.append(rbtnImg5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("//array de imagenes de respuestas");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerImgsArray.append(imageAnswer1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerImgsArray.append(imageAnswer2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerImgsArray.append(imageAnswer3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerImgsArray.append(imageAnswer4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerImgsArray.append(imageAnswer5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("//array botones y labels ejs1");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerCheckBoxArray.append(btnSelection6)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerLabelCheckBoxArray.append(labelSelection6)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("//arrays ejs 3");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("questionLabelListArray.append(labelDropDownList6)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerListBtnsArray.append(btnDropDownList6)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView1)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView2)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView3)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView4)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView5)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tablesViewArray.append(tableView6)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("backButton.layer.cornerRadius = 15");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("backButton.layer.borderWidth = 2");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("backButton.layer.borderColor = UIColor.systemGray2.cgColor");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("nextButton.layer.cornerRadius = 15");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("nextButton.layer.borderWidth = 2");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("nextButton.layer.borderColor = UIColor.systemGray2.cgColor");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("endButton.layer.cornerRadius = 15");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("endButton.layer.borderWidth = 2");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("endButton.layer.borderColor = UIColor.white.cgColor");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView1.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView1.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView2.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView2.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView3.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView3.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView4.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView4.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView5.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView5.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView6.delegate = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("tableView6.dataSource = self");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("reset()");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("func reset() {");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("answerIsCorrect = Bool()");
      _builder.newLine();
      _builder.newLine();
      {
        EList<MutatorTests> _exercises_1 = program.getExercises();
        for(final MutatorTests exercise_1 : _exercises_1) {
          {
            EList<Test> _tests_5 = exercise_1.getTests();
            for(final Test test_5 : _tests_5) {
              _builder.append("userAllAnswers.append(\"000000\")");
              _builder.newLine();
              _builder.append("userAnswerIsCorrect.append(false)");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t        ");
      _builder.append("currentQuestion = 0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("func checkAnswer() {");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("var userAnswer = [0,0,0,0,0,0]");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("var userAnswerStr = \"000000\"");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("if exerciseType == 3 { //true false");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("var j = 0");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("for button in answerListBtnsArray {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("j = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for option in dataSourceArray1 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if button.titleLabel?.text == option {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("userAnswer[i] = j");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("j = j + 1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("i = i + 1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let strAux = userAnswer.map { String($0)}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("userAnswerStr = String(strAux.compactMap {($0).first })");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("if exerciseType == 2 { //true false");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if rbtnTrueFalse1.isSelected {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("userAnswer[0] = 1");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("else if rbtnTrueFalse2.isSelected{");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("userAnswer[1] = 1");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let strAux = userAnswer.map { String($0)}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("userAnswerStr = String(strAux.compactMap {($0).first })");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("else if exerciseType == 1 { //multiseleccion");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("var  i = 0");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("for button in answerCheckBoxArray {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if button.isSelected {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("userAnswer[i] = 1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("i = i+1");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let strAux = userAnswer.map { String($0)}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("userAnswerStr = String(strAux.compactMap {($0).first })");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("else if exerciseType == 0 { //imagenes");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("var  i = 0");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("for button in answerBtnsArray {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if button.isSelected {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("userAnswer[i] = 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("break");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("i = i+1");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let strAux = userAnswer.map { String($0)}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("userAnswerStr = String(strAux.compactMap {($0).first })");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("//general");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("userAnswerIsCorrect[currentQuestion] = userAnswer == correctAnswer");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("userAllAnswers[currentQuestion] = userAnswerStr");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("func showQuestion() {");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let question = allQuestions[currentQuestion]");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("let partsQuestion = question.components(separatedBy: \";\")");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("textQuestion.text = partsQuestion[1]");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("hideAllItems()");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if (partsQuestion[0] == \"0\") {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("exerciseType = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("correctAnswer = [0,0,0,0,0,0]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let imgsPath = allAnswersImages[currentQuestion]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("for imageName in imgsPath ?? []{");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerImgsArray[i].image = ResizeImage(UIImage(named: imageName)!, targetSize : CGSize(width: 250, height: 250))");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerImgsArray[i].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerBtnsArray[i].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerBtnsArray[i].isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("if(Array(userAllAnswers[currentQuestion])[i] == \"1\"){");
      _builder.newLine();
      _builder.append("\t\t                            ");
      _builder.append("answerBtnsArray[i].isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("i = i+1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                                ");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("correctAnswer[Int(partsQuestion[3])!] = 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if (partsQuestion[0] == \"1\") { //multiseleccion");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("exerciseType = 1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("correctAnswer = [0,0,0,0,0,0]");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? \"errorImage\")!, targetSize : CGSize(width: 300, height: 300))");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let answers = partsQuestion[2...partsQuestion.count-1]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var answerCorrect = \"\"");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for answer in answers {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(answer.contains(\"*\")) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerCorrect = String(answer.dropFirst())");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("correctAnswer[i] = 1");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerLabelCheckBoxArray[i].text = answerCorrect");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerLabelCheckBoxArray[i].text = answer");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answerLabelCheckBoxArray[i].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answerLabelCheckBoxArray[i].sizeToFit()");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answerCheckBoxArray[i].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(Array(userAllAnswers[currentQuestion])[i] == \"1\"){");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerCheckBoxArray[i].isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerCheckBoxArray[i].isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("i = i+1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("//ejercicios true false");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if (partsQuestion[0] == \"2\") {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("exerciseType = 2");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//muestro los botones para este tipo de ejercicio");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse1.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse1.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse2.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse2.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("correctAnswer = [0,0,0,0,0,0]");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? \"errorImage\")!, targetSize : CGSize(width: 300, height: 300))");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var answer1 = partsQuestion[2]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var answer2 = partsQuestion[3]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if(answer1.contains(\"*\")) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answer1 = String(answer1.dropFirst())");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("correctAnswer[0] = 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("correctAnswer[1] = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answer2 = String(answer2.dropFirst())");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("correctAnswer[0] = 0");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("correctAnswer[1] = 1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse1.text = answer1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse2.text = answer2");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if(Array(userAllAnswers[currentQuestion])[0] == \"1\"){");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if (Array(userAllAnswers[currentQuestion])[1] == \"1\") {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("else if (partsQuestion[0] == \"3\") { //ejs dropdown list");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("exerciseType = 3");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("cleanDataSources()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("reloadTableViews()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? \"errorImage\")!, targetSize : CGSize(width: 300, height: 300))");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let partsToEnd = partsQuestion[2...partsQuestion.count-1]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var questions = [String]()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var solutions = [Int]()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var i = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for part in partsToEnd {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(part.contains(\"*\")) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("let solution = part[part.index(part.startIndex, offsetBy: 1)]");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("solutions.append(Int(String(solution)) ?? -1)");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("questions.append(String((part.dropFirst()).dropFirst()))");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("correctAnswer[i] = solutions[i]");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("i = i+1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else { //if part \"\" pasa");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("addDataToDataSource(data: part)");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("reloadTableViews()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var j = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for question in questions {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("questionLabelListArray[j].text = question");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("questionLabelListArray[j].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("answerListBtnsArray[j].isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                            ");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(Array(userAllAnswers[currentQuestion])[j] != \"0\"){");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("let answered = userAllAnswers[currentQuestion][userAllAnswers[currentQuestion].index(userAllAnswers[currentQuestion].startIndex, offsetBy: j)]");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("let index = IndexPath.init(row: Int(String(answered)) ?? 0, section: 0)");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("let cell = tablesViewArray[j].cellForRow(at: index)");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("cell?.textLabel?.text = dataSourceArray1[Int(String(answered)) ?? 0]");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("answerListBtnsArray[j].setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("j = j+1");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if currentQuestion == 0 {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnPrevious.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("else{");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnPrevious.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("if currentQuestion == allQuestions.count-1 {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnNext.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnNext.isHidden = false");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("@IBAction func rbtnAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if sender.tag == 2 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 4 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 6 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 7 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 8 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 9 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 10 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg1.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg2.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg3.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg4.isSelected =  false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnImg5.isSelected =  true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func checkBoxAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if sender.tag == 30 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection1.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection1.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                   ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 31 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection2.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection2.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 32 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection3.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection3.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection3.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 34 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection4.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection4.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection4.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 36 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection5.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection5.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection5.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 38 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if(btnSelection6.isSelected) {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection6.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("btnSelection6.isSelected = true");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func backButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if(currentQuestion > 0) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("checkAnswer()");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("currentQuestion = currentQuestion - 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func nextButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if(currentQuestion < allQuestions.count-1) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("checkAnswer()");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("currentQuestion = currentQuestion + 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("showQuestion()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func endButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var nota = 0.0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for answer in userAnswerIsCorrect {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("if answer == true {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("nota = nota + 1");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("nota = nota*10 / Double(userAnswerIsCorrect.count)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let vc = storyboard?.instantiateViewController(identifier: \"results\") as! ResultsViewController");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("vc.nota = nota");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("vc.modalPresentationStyle = .fullScreen");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("present(vc, animated: true)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func undoButtonAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//deshacer seleecion: array de botones guardados por preguntas");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if exerciseType == 0 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("for button in answerBtnsArray {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("button.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if exerciseType == 1 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("for button in answerCheckBoxArray {");
      _builder.newLine();
      _builder.append("\t\t                        ");
      _builder.append("button.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if exerciseType == 2 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse1.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("rbtnTrueFalse2.isSelected = false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("userAllAnswers[currentQuestion] = \"000000\"");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func numberOfSections(in tableView: UITableView) -> Int {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if tableView == tableView1 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray1.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView2 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray2.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView3 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray3.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView4 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray4.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView5 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray5.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView6 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("return dataSourceArray6.count");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let cell = tableView.dequeueReusableCell(withIdentifier: \"cell\", for: indexPath)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("cell.textLabel?.numberOfLines = 0");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("cell.textLabel?.sizeToFit()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if tableView == tableView1 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray1[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView2 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray2[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView3 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray3[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView4 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray4[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView5 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray5[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView6 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("cell.textLabel?.text = dataSourceArray6[indexPath.row]");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("return cell");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let cell = tableView.cellForRow(at: indexPath)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if tableView == tableView1 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList1.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView2 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList2.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView3 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList3.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView4 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList4.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView5 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList5.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if tableView == tableView6 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("btnDropDownList6.setTitle(cell?.textLabel?.text, for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("@IBAction func btnDropDownListAction(_ sender: UIButton) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if sender.tag == 70 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView1.isHidden = !self.tableView1.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 71 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView2.isHidden = !self.tableView2.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 72 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView3.isHidden = !self.tableView3.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 73 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView4.isHidden = !self.tableView4.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 74 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView5.isHidden = !self.tableView5.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("else if sender.tag == 75 {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("tableView6.isHidden = !self.tableView6.isHidden");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func ResizeImage(_ image: UIImage, targetSize: CGSize) -> UIImage? {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let size = image.size");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let widthRatio  = targetSize.width  / image.size.width");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let heightRatio = targetSize.height / image.size.height");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("// Figure out what our orientation is, and use that to form the rectangle");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("var newSize: CGSize");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if(widthRatio > heightRatio) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("newSize = CGSize(width: size.width * heightRatio, height: size.height * heightRatio)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("newSize = CGSize(width: size.width * widthRatio, height: size.height * widthRatio)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("// This is the rect that we\'ve calculated out and this is what is actually used below");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let rect = CGRect(x: 0, y: 0, width: newSize.width, height: newSize.height)");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("// Actually do the resizing to the rect using the ImageContext stuff");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("UIGraphicsBeginImageContextWithOptions(newSize, false, 1.0)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("image.draw(in: rect)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("let newImage = UIGraphicsGetImageFromCurrentImageContext()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("UIGraphicsEndImageContext()");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("return newImage");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func hideAllItems() {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//ejs true false");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse1.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse1.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("rbtnTrueFalse2.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("labelTrueFalse2.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//ejs imagenes");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for img in answerImgsArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("img.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for button in answerBtnsArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("button.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//ejs multiseleccion");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for button in answerCheckBoxArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("button.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for label in answerLabelCheckBoxArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("label.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("//ejs dropdownlist");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for label in questionLabelListArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("label.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("for button in answerListBtnsArray {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("button.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("imageEx.isHidden = true");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func addDataToDataSource(data: String) {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray1.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray1.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray2.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray2.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray3.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray3.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray4.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray4.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray5.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray5.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("if !dataSourceArray6.contains(data) {");
      _builder.newLine();
      _builder.append("\t\t                    ");
      _builder.append("dataSourceArray6.append(data)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func cleanDataSources() {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray1.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray1.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList1.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray2.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray2.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList2.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray3.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray3.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList3.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray4.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray4.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList4.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray5.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray5.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList5.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray6.removeAll()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("dataSourceArray6.append(\"Elegir\")");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("btnDropDownList6.setTitle(\"Elegir\", for: .normal)");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("func reloadTableViews() {");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView1.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView2.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView3.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView4.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView5.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.append("tableView6.reloadData()");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t                ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t            ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("}");
      _builder.newLine();
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
      _builder.append("let allQuestions  = [");
      _builder.newLine();
      _builder.append("\t\t\t");
      boolean isFirst = true;
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      boolean isFirst2 = true;
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      boolean isFirst3 = true;
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      boolean isFirst4 = true;
      _builder.newLineIfNotEmpty();
      {
        EList<MutatorTests> _exercises_1 = program.getExercises();
        for(final MutatorTests exercise_1 : _exercises_1) {
          _builder.append("\t\t\t");
          _builder.newLine();
          {
            if ((exercise_1 instanceof AlternativeResponse)) {
              {
                EList<Test> _tests_1 = ((AlternativeResponse)exercise_1).getTests();
                for(final Test test_1 : _tests_1) {
                  {
                    if ((isFirst == false)) {
                      _builder.append("\t\t\t");
                      _builder.append(",");
                      _builder.newLine();
                    } else {
                      _builder.append("\t\t\t");
                      String _xblockexpression_2 = null;
                      {
                        isFirst = false;
                        _xblockexpression_2 = "";
                      }
                      _builder.append(_xblockexpression_2, "\t\t\t");
                      _builder.append("\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    int _size_1 = this.rand.get(exercise_1).get(test_1).size();
                    boolean _greaterThan_1 = (_size_1 > 0);
                    if (_greaterThan_1) {
                      _builder.append("\t\t\t");
                      String diagram_1 = this.rand.get(exercise_1).get(test_1).get(0);
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _equals = diagram_1.equals(test_1.getSource().replace(".model", ".png"));
                        if (_equals) {
                          _builder.append("\t\t\t");
                          _builder.append("\"2;");
                          String _replace = test_1.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace, "\t\t\t");
                          _builder.append(";*True;False\"");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t\t\t");
                          _builder.append("\"2;");
                          String _replace_1 = test_1.getQuestion().replace("\"", "\'").replace("\'", "");
                          _builder.append(_replace_1, "\t\t\t");
                          _builder.append(";True;*False\"");
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
            if ((exercise_1 instanceof MultiChoiceDiagram)) {
              {
                EList<Test> _tests_2 = ((MultiChoiceDiagram)exercise_1).getTests();
                for(final Test test_2 : _tests_2) {
                  {
                    if ((isFirst == false)) {
                      _builder.append("\t\t\t");
                      _builder.append(",");
                      _builder.newLine();
                    } else {
                      _builder.append("\t\t\t");
                      String _xblockexpression_3 = null;
                      {
                        isFirst = false;
                        _xblockexpression_3 = "";
                      }
                      _builder.append(_xblockexpression_3, "\t\t\t");
                      _builder.append("\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t\t\t");
                  int j = 0;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  int correct = j;
                  _builder.newLineIfNotEmpty();
                  {
                    List<String> _get = this.diagrams.get(exercise_1).get(test_2);
                    for(final String diagram_2 : _get) {
                      {
                        boolean _equals_1 = diagram_2.equals(test_2.getSource().replace(".model", ".png"));
                        if (_equals_1) {
                          _builder.append("\t\t\t");
                          String _xblockexpression_4 = null;
                          {
                            correct = j;
                            _xblockexpression_4 = "";
                          }
                          _builder.append(_xblockexpression_4, "\t\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t\t");
                      _builder.append("\t\t\t\t");
                      String _xblockexpression_5 = null;
                      {
                        j++;
                        _xblockexpression_5 = "";
                      }
                      _builder.append(_xblockexpression_5, "\t\t\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t\t\t");
                  _builder.append("\t\t");
                  _builder.append("\"0;");
                  String _replace_2 = test_2.getQuestion().replace("\"", "\'").replace("\'", "");
                  _builder.append(_replace_2, "\t\t\t\t\t");
                  _builder.append(";");
                  _builder.append(j, "\t\t\t\t\t");
                  _builder.append(";");
                  _builder.append(correct, "\t\t\t\t\t");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          {
            if ((exercise_1 instanceof MultiChoiceEmendation)) {
              {
                EList<Test> _tests_3 = ((MultiChoiceEmendation)exercise_1).getTests();
                for(final Test test_3 : _tests_3) {
                  _builder.append("\t\t\t");
                  String fullQuestion = "";
                  _builder.newLineIfNotEmpty();
                  {
                    if ((isFirst == false)) {
                      _builder.append("\t\t\t");
                      _builder.append(",");
                      _builder.newLine();
                    } else {
                      _builder.append("\t\t\t");
                      String _xblockexpression_6 = null;
                      {
                        isFirst = false;
                        _xblockexpression_6 = "";
                      }
                      _builder.append(_xblockexpression_6, "\t\t\t");
                      _builder.append("\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t\t\t");
                  String _xblockexpression_7 = null;
                  {
                    String _fullQuestion = fullQuestion;
                    fullQuestion = (_fullQuestion + "1;");
                    _xblockexpression_7 = "";
                  }
                  _builder.append(_xblockexpression_7, "\t\t\t");
                  _builder.newLineIfNotEmpty();
                  {
                    if (((this.options.get(exercise_1) != null) && (this.options.get(exercise_1).get(test_3) != null))) {
                      _builder.append("\t\t\t");
                      String _xblockexpression_8 = null;
                      {
                        String _fullQuestion = fullQuestion;
                        String _replace_3 = test_3.getQuestion().replace("\"", "\'").replace("\'", "");
                        String _plus = (_replace_3 + ";");
                        fullQuestion = (_fullQuestion + _plus);
                        _xblockexpression_8 = "";
                      }
                      _builder.append(_xblockexpression_8, "\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if (((this.options.get(exercise_1) != null) && (this.options.get(exercise_1).get(test_3) != null))) {
                      _builder.append("\t\t\t");
                      int counter = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      List<AbstractMap.SimpleEntry<String, Boolean>> textOptions = new ArrayList<AbstractMap.SimpleEntry<String, Boolean>>();
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_1 = this.options.get(exercise_1).get(test_3);
                        for(final EduTestSuperGenerator.TestOption opt : _get_1) {
                          {
                            Set<String> _keySet = opt.text.keySet();
                            for(final String key : _keySet) {
                              {
                                List<String> _get_2 = opt.text.get(key);
                                for(final String text : _get_2) {
                                  _builder.append("\t\t\t");
                                  boolean found = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    for(final AbstractMap.SimpleEntry<String, Boolean> entry : textOptions) {
                                      {
                                        boolean _equals_2 = entry.getKey().equals(text);
                                        if (_equals_2) {
                                          _builder.append("\t\t\t");
                                          String _xblockexpression_9 = null;
                                          {
                                            found = true;
                                            _xblockexpression_9 = "";
                                          }
                                          _builder.append(_xblockexpression_9, "\t\t\t");
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found == false)) {
                                      _builder.append("\t\t\t");
                                      String _xblockexpression_10 = null;
                                      {
                                        counter++;
                                        _xblockexpression_10 = "";
                                      }
                                      _builder.append(_xblockexpression_10, "\t\t\t");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t\t");
                                      String _xblockexpression_11 = null;
                                      {
                                        AbstractMap.SimpleEntry<String, Boolean> _simpleEntry = new AbstractMap.SimpleEntry<String, Boolean>(text, Boolean.valueOf(false));
                                        textOptions.add(_simpleEntry);
                                        _xblockexpression_11 = "";
                                      }
                                      _builder.append(_xblockexpression_11, "\t\t\t");
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
                    if (((this.options.get(exercise_1) != null) && (this.options.get(exercise_1).get(test_3) != null))) {
                      _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t \t");
                      String diagram_3 = "";
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_3 = this.options.get(exercise_1).get(test_3);
                        boolean _tripleNotEquals = (_get_3 != null);
                        if (_tripleNotEquals) {
                          {
                            List<EduTestSuperGenerator.TestOption> _get_4 = this.options.get(exercise_1).get(test_3);
                            for(final EduTestSuperGenerator.TestOption opt_1 : _get_4) {
                              {
                                int _size_2 = opt_1.text.size();
                                boolean _greaterThan_2 = (_size_2 > 0);
                                if (_greaterThan_2) {
                                  _builder.append("\t\t\t");
                                  String _xblockexpression_12 = null;
                                  {
                                    diagram_3 = opt_1.path;
                                    _xblockexpression_12 = "";
                                  }
                                  _builder.append(_xblockexpression_12, "\t\t\t");
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                      {
                        boolean _equals_3 = diagram_3.equals("");
                        boolean _not = (!_equals_3);
                        if (_not) {
                          {
                            List<EduTestSuperGenerator.TestOption> _get_5 = this.options.get(exercise_1).get(test_3);
                            boolean _tripleNotEquals_1 = (_get_5 != null);
                            if (_tripleNotEquals_1) {
                              {
                                List<EduTestSuperGenerator.TestOption> _get_6 = this.options.get(exercise_1).get(test_3);
                                for(final EduTestSuperGenerator.TestOption opt_2 : _get_6) {
                                  _builder.append("\t\t\t");
                                  List<String> textOptions_1 = new ArrayList<String>();
                                  _builder.newLineIfNotEmpty();
                                  {
                                    int _size_3 = opt_2.text.size();
                                    boolean _greaterThan_3 = (_size_3 > 0);
                                    if (_greaterThan_3) {
                                      {
                                        Set<String> _keySet_1 = opt_2.text.keySet();
                                        for(final String key_1 : _keySet_1) {
                                          {
                                            List<String> _get_7 = opt_2.text.get(key_1);
                                            for(final String text_1 : _get_7) {
                                              {
                                                boolean _contains = textOptions_1.contains(text_1);
                                                boolean _not_1 = (!_contains);
                                                if (_not_1) {
                                                  String _xblockexpression_13 = null;
                                                  {
                                                    textOptions_1.add(text_1);
                                                    _xblockexpression_13 = "";
                                                  }
                                                  _builder.append(_xblockexpression_13);
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
                                List<EduTestSuperGenerator.TestOption> _get_8 = this.options.get(exercise_1).get(test_3);
                                for(final EduTestSuperGenerator.TestOption opt_3 : _get_8) {
                                  {
                                    if ((opt_3.solution == true)) {
                                      {
                                        int _size_4 = opt_3.text.size();
                                        boolean _greaterThan_4 = (_size_4 > 0);
                                        if (_greaterThan_4) {
                                          {
                                            Set<String> _keySet_2 = opt_3.text.keySet();
                                            for(final String key_2 : _keySet_2) {
                                              {
                                                List<String> _get_9 = opt_3.text.get(key_2);
                                                for(final String text_2 : _get_9) {
                                                  String _xblockexpression_14 = null;
                                                  {
                                                    String _fullQuestion = fullQuestion;
                                                    String _trim = text_2.trim();
                                                    String _plus = ("*" + _trim);
                                                    String _plus_1 = (_plus + ";");
                                                    fullQuestion = (_fullQuestion + _plus_1);
                                                    _xblockexpression_14 = "";
                                                  }
                                                  _builder.append(_xblockexpression_14);
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
                                        int _size_5 = opt_3.text.size();
                                        boolean _greaterThan_5 = (_size_5 > 0);
                                        if (_greaterThan_5) {
                                          {
                                            Set<String> _keySet_3 = opt_3.text.keySet();
                                            for(final String key_3 : _keySet_3) {
                                              {
                                                List<String> _get_10 = opt_3.text.get(key_3);
                                                for(final String text_3 : _get_10) {
                                                  String _xblockexpression_15 = null;
                                                  {
                                                    String _fullQuestion = fullQuestion;
                                                    String _trim = text_3.trim();
                                                    String _plus = (_trim + ";");
                                                    fullQuestion = (_fullQuestion + _plus);
                                                    _xblockexpression_15 = "";
                                                  }
                                                  _builder.append(_xblockexpression_15);
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
                  _builder.append("\t\t\t");
                  _builder.append("\"");
                  _builder.append(fullQuestion, "\t\t\t");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          {
            if ((exercise_1 instanceof MatchPairs)) {
              _builder.append("\t\t\t");
              int min = Integer.MAX_VALUE;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t\t\t\t\t        ");
              int index = 0;
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t\t\t\t\t        ");
              int max = Integer.MIN_VALUE;
              _builder.newLineIfNotEmpty();
              {
                EList<Test> _tests_4 = ((MatchPairs)exercise_1).getTests();
                for(final Test test_4 : _tests_4) {
                  _builder.append("\t\t\t");
                  String fullQuestion_1 = "";
                  _builder.newLineIfNotEmpty();
                  {
                    if ((isFirst == false)) {
                      _builder.append("\t\t\t");
                      _builder.append(",");
                      _builder.newLine();
                    } else {
                      _builder.append("\t\t\t");
                      String _xblockexpression_16 = null;
                      {
                        isFirst = false;
                        _xblockexpression_16 = "";
                      }
                      _builder.append(_xblockexpression_16, "\t\t\t");
                      _builder.append("\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    if (((this.options.get(exercise_1) != null) && (this.options.get(exercise_1).get(test_4) != null))) {
                      _builder.append("\t\t\t");
                      String _xblockexpression_17 = null;
                      {
                        String _fullQuestion = fullQuestion_1;
                        fullQuestion_1 = (_fullQuestion + "3;Match the correct option on the right with each of the statements on the left;");
                        _xblockexpression_17 = "";
                      }
                      _builder.append(_xblockexpression_17, "\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.newLine();
                      _builder.append("\t\t\t");
                      List<String> textOptions_2 = new ArrayList<String>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      int k = 0;
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      int counter_1 = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_11 = this.options.get(exercise_1).get(test_4);
                        for(final EduTestSuperGenerator.TestOption opt_4 : _get_11) {
                          {
                            Set<String> _keySet_4 = opt_4.text.keySet();
                            for(final String key_4 : _keySet_4) {
                              {
                                List<String> _get_12 = opt_4.text.get(key_4);
                                for(final String text_4 : _get_12) {
                                  {
                                    boolean _contains_1 = textOptions_2.contains(text_4);
                                    boolean _not_2 = (!_contains_1);
                                    if (_not_2) {
                                      String _xblockexpression_18 = null;
                                      {
                                        counter_1++;
                                        _xblockexpression_18 = "";
                                      }
                                      _builder.append(_xblockexpression_18);
                                      _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                                      _builder.newLineIfNotEmpty();
                                      String _xblockexpression_19 = null;
                                      {
                                        String _fullQuestion = fullQuestion_1;
                                        fullQuestion_1 = (_fullQuestion + (text_4 + ";"));
                                        _xblockexpression_19 = "";
                                      }
                                      _builder.append(_xblockexpression_19);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
                                      _builder.newLine();
                                      String _xblockexpression_20 = null;
                                      {
                                        textOptions_2.add(text_4);
                                        _xblockexpression_20 = "";
                                      }
                                      _builder.append(_xblockexpression_20);
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
                          _builder.append("\t\t\t");
                          String _xblockexpression_21 = null;
                          {
                            max = counter_1;
                            _xblockexpression_21 = "";
                          }
                          _builder.append(_xblockexpression_21, "\t\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t");
                          String _xblockexpression_22 = null;
                          {
                            index = k;
                            _xblockexpression_22 = "";
                          }
                          _builder.append(_xblockexpression_22, "\t\t\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t\t");
                      String _xblockexpression_23 = null;
                      {
                        k++;
                        _xblockexpression_23 = "";
                      }
                      _builder.append(_xblockexpression_23, "\t\t\t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      TreeMap<Integer, AbstractMap.SimpleEntry<String, String>> entries = new TreeMap<Integer, AbstractMap.SimpleEntry<String, String>>();
                      _builder.newLineIfNotEmpty();
                      {
                        List<EduTestSuperGenerator.TestOption> _get_13 = this.options.get(exercise_1).get(test_4);
                        for(final EduTestSuperGenerator.TestOption op : _get_13) {
                          {
                            boolean _isExpression = test_4.isExpression();
                            boolean _equals_4 = (_isExpression == true);
                            if (_equals_4) {
                              _builder.append("\t\t\t");
                              String key_5 = this.getText(test_4.getIdentifier(), op.entry.getKey().getURI().toFileString(), resource);
                              _builder.newLineIfNotEmpty();
                              {
                                int _length = key_5.length();
                                boolean _lessEqualsThan = (_length <= 36);
                                if (_lessEqualsThan) {
                                  _builder.append("\t\t\t");
                                  boolean found_1 = false;
                                  _builder.newLineIfNotEmpty();
                                  {
                                    Set<Integer> _keySet_5 = entries.keySet();
                                    for(final int length : _keySet_5) {
                                      _builder.append("\t\t\t");
                                      AbstractMap.SimpleEntry<String, String> entry_1 = entries.get(Integer.valueOf(length));
                                      _builder.newLineIfNotEmpty();
                                      {
                                        boolean _equals_5 = entry_1.getValue().equals(key_5);
                                        if (_equals_5) {
                                          _builder.append("\t\t\t");
                                          String _xblockexpression_24 = null;
                                          {
                                            found_1 = true;
                                            _xblockexpression_24 = "";
                                          }
                                          _builder.append(_xblockexpression_24, "\t\t\t");
                                          _builder.newLineIfNotEmpty();
                                        }
                                      }
                                    }
                                  }
                                  {
                                    if ((found_1 == false)) {
                                      _builder.append("\t\t\t");
                                      String _trim = op.text.get(((Object[])Conversions.unwrapArray(op.text.keySet(), Object.class))[index]).get(index).trim();
                                      AbstractMap.SimpleEntry<String, String> entry_2 = new AbstractMap.SimpleEntry<String, String>(key_5, _trim);
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t\t");
                                      String _xblockexpression_25 = null;
                                      {
                                        entries.put(Integer.valueOf(key_5.length()), entry_2);
                                        _xblockexpression_25 = "";
                                      }
                                      _builder.append(_xblockexpression_25, "\t\t\t");
                                      _builder.newLineIfNotEmpty();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                      _builder.append("\t\t\t");
                      String question = test_4.getQuestion().replace("\"", "\'");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      int counter2 = 0;
                      _builder.newLineIfNotEmpty();
                      {
                        Set<Integer> _keySet_6 = entries.keySet();
                        for(final int length_1 : _keySet_6) {
                          {
                            if ((counter2 < min)) {
                              _builder.append("\t\t\t");
                              AbstractMap.SimpleEntry<String, String> entry_3 = entries.get(Integer.valueOf(length_1));
                              _builder.newLineIfNotEmpty();
                              {
                                int _size_6 = textOptions_2.size();
                                int _minus = (_size_6 - 1);
                                IntegerRange _upTo = new IntegerRange(0, _minus);
                                for(final int l : _upTo) {
                                  {
                                    String _get_14 = textOptions_2.get(l);
                                    int _length_1 = textOptions_2.get(l).length();
                                    int _minus_1 = (_length_1 - 1);
                                    boolean _equals_6 = _get_14.substring(0, _minus_1).equals(entry_3.getValue());
                                    if (_equals_6) {
                                      _builder.append("\t\t\t");
                                      String _xblockexpression_26 = null;
                                      {
                                        String _fullQuestion = fullQuestion_1;
                                        String _key = entry_3.getKey();
                                        String _plus = ((("*" + Integer.valueOf(l)) + question) + _key);
                                        String _plus_1 = (_plus + ";");
                                        fullQuestion_1 = (_fullQuestion + _plus_1);
                                        _xblockexpression_26 = "";
                                      }
                                      _builder.append(_xblockexpression_26, "\t\t\t");
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
                  _builder.append("\t\t\t");
                  _builder.append("\"");
                  _builder.append(fullQuestion_1, "\t\t\t");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("\t\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("let allQuestionsImages = [");
      _builder.newLine();
      {
        Set<Integer> _keySet_7 = this.drawable.keySet();
        for(final int numExercise : _keySet_7) {
          {
            if ((isFirst2 == false)) {
              _builder.append("\t\t\t");
              _builder.append(",");
              _builder.newLine();
            } else {
              _builder.append("\t\t\t");
              String _xblockexpression_27 = null;
              {
                isFirst2 = false;
                _xblockexpression_27 = "";
              }
              _builder.append(_xblockexpression_27, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t\t");
          _builder.append(numExercise, "\t\t\t");
          _builder.append(" : \"");
          String _replace_3 = this.drawable.get(Integer.valueOf(numExercise)).replace(".png", "");
          _builder.append(_replace_3, "\t\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.newLine();
      _builder.append("let allAnswersImages = [");
      _builder.newLine();
      {
        Set<Integer> _keySet_8 = this.drawableAnswer.keySet();
        for(final int numExercise_1 : _keySet_8) {
          {
            if ((isFirst3 == false)) {
              _builder.append("\t\t\t");
              _builder.append(",");
              _builder.newLine();
            } else {
              _builder.append("\t\t\t");
              String _xblockexpression_28 = null;
              {
                isFirst3 = false;
                _xblockexpression_28 = "";
              }
              _builder.append(_xblockexpression_28, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t\t");
          _builder.append(numExercise_1, "\t\t\t");
          _builder.append(" : ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.newLine();
          {
            Set<Integer> _keySet_9 = this.drawableAnswer.get(Integer.valueOf(numExercise_1)).keySet();
            for(final int numAnswer : _keySet_9) {
              {
                if ((isFirst4 == false)) {
                  _builder.append("\t\t\t");
                  _builder.append(",");
                  _builder.newLine();
                } else {
                  _builder.append("\t\t\t");
                  String _xblockexpression_29 = null;
                  {
                    isFirst4 = false;
                    _xblockexpression_29 = "";
                  }
                  _builder.append(_xblockexpression_29, "\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("[");
                  _builder.newLine();
                }
              }
              _builder.append("\t\t\t");
              _builder.append(" ");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t ");
              _builder.append("\"");
              String _replace_4 = this.drawableAnswer.get(Integer.valueOf(numExercise_1)).get(Integer.valueOf(numAnswer)).replace(".png", "");
              _builder.append(_replace_4, "\t\t\t\t ");
              _builder.append("\" ");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t\t");
          String _xblockexpression_30 = null;
          {
            isFirst4 = true;
            _xblockexpression_30 = "";
          }
          _builder.append(_xblockexpression_30, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("]");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("]");
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
