package wodel.dsls.generator;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mutatorenvironment.Block;
import mutatorenvironment.Constraint;
import mutatorenvironment.Definition;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.dsls.WodelUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.UseGeneratorUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel USE code generator.
 * 
 * Generates the USE code and the .properties file for
 * the seeds synthesizer.
 */
@SuppressWarnings("all")
public class WodelUseGenerator extends AbstractGenerator {
  private static class Cardinality {
    private int min = 0;

    private int max = 0;
  }

  private IProject project = null;

  private String fileName;

  private String modelName;

  private String useName;

  private String propertiesName;

  private String path;

  private EClass root;

  private String dummyClassName = "Dummy";

  private Map<URI, Map<URI, Map.Entry<String, String>>> useReferences = new HashMap<URI, Map<URI, Map.Entry<String, String>>>();

  public String predefinedConfiguration = null;

  public String configurationName = null;

  public Map<String, Integer> numObjects = null;

  public Map<String, AbstractMap.SimpleEntry<String, String>> tagsByClass = null;

  private int maxInteger;

  private int minInteger;

  private int maxReal;

  private int minReal;

  private int maxString;

  private int maxObjectsCardinality;

  private int maxAssociationsCardinality;

  public String getProjectName() {
    String projectName = null;
    IProject _project = ProjectUtils.getProject();
    boolean _tripleNotEquals = (_project != null);
    if (_tripleNotEquals) {
      projectName = ProjectUtils.getProject().getName();
    }
    return projectName;
  }

  public List<String> getMutators(final File[] files) {
    List<String> mutators = new ArrayList<String>();
    if ((files != null)) {
      for (final File file : files) {
        if ((file != null)) {
          boolean _isFile = file.isFile();
          boolean _equals = (_isFile == true);
          if (_equals) {
            boolean _endsWith = file.getName().endsWith(".mutator");
            if (_endsWith) {
              String mutator = file.getName().replaceAll(".mutator", "");
              boolean _contains = mutators.contains(mutator);
              boolean _not = (!_contains);
              if (_not) {
                mutators.add(mutator);
              }
            }
          } else {
            boolean _isDirectory = file.isDirectory();
            boolean _equals_1 = (_isDirectory == true);
            if (_equals_1) {
              List<String> nextMutators = new ArrayList<String>();
              nextMutators.addAll(this.getMutators(file.listFiles()));
              for (final String nextMutator : nextMutators) {
                boolean _contains_1 = mutators.contains(nextMutator);
                boolean _not_1 = (!_contains_1);
                if (_not_1) {
                  mutators.add(nextMutator);
                }
              }
            }
          }
        }
      }
    }
    return mutators;
  }

  public String getMutatorPath(final MutatorEnvironment e, final File[] files) {
    String mutatorPath = null;
    if (((mutatorPath == null) && (files != null))) {
      for (final File file : files) {
        {
          if ((mutatorPath != null)) {
            return mutatorPath;
          }
          if ((file != null)) {
            boolean _isFile = file.isFile();
            boolean _equals = (_isFile == true);
            if (_equals) {
              boolean _equals_1 = file.getName().equals(this.fileName);
              if (_equals_1) {
                String path = file.getPath().replace("\\", "/");
                String _projectName = this.getProjectName();
                String _plus = ("/" + _projectName);
                String _plus_1 = (_plus + "/");
                int _lastIndexOf = path.lastIndexOf(_plus_1);
                String _projectName_1 = this.getProjectName();
                int _length = ("/" + _projectName_1).length();
                int _plus_2 = (_lastIndexOf + _length);
                String mutatorFolderAndFile = path.substring(_plus_2);
                String _replace = ProjectUtils.getProject().getLocation().toFile().getPath().replace("\\", "/");
                String _plus_3 = ("file:/" + _replace);
                String _plus_4 = (_plus_3 + mutatorFolderAndFile);
                mutatorPath = _plus_4;
              }
            } else {
              mutatorPath = this.getMutatorPath(e, file.listFiles());
            }
          }
        }
      }
    }
    return mutatorPath;
  }

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.project = ProjectUtils.getProject();
    this.path = ProjectUtils.getProject().getLocation().toFile().getPath();
    MutatorEnvironment mutatorEnvironment = null;
    Iterable<MutatorEnvironment> _filter = Iterables.<MutatorEnvironment>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorEnvironment.class);
    for (final MutatorEnvironment e : _filter) {
      {
        this.maxInteger = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum integer value", "100", null));
        this.minInteger = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Minimum integer value", "-100", null));
        this.maxReal = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum real value", "100", null));
        this.minReal = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Minimum real value", "0", null));
        this.maxString = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum string value", "10", null));
        this.maxObjectsCardinality = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum cardinality for objects value", "10", null));
        this.maxAssociationsCardinality = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum cardinality for associations value", "10", null));
        this.fileName = resource.getURI().lastSegment();
        this.fileName = this.fileName.replaceAll(".mutator", ".java").replace(".model", ".java");
        this.modelName = this.fileName.replaceAll(".java", "");
        this.useName = this.fileName.replaceAll(".java", ".use");
        this.propertiesName = this.fileName.replaceAll(".java", ".properties");
        fsa.generateFile(this.useName, this.removeComments(this.use(e, resource, resource), "use"));
        fsa.generateFile(this.propertiesName, this.removeComments(this.properties(e, resource, resource), "properties"));
        mutatorEnvironment = e;
        EList<Block> _blocks = mutatorEnvironment.getBlocks();
        for (final Block b : _blocks) {
          {
            this.fileName = resource.getURI().lastSegment();
            String _replaceAll = this.fileName.replaceAll(".model", "");
            String _name = b.getName();
            String _plus = ("_" + _name);
            String _plus_1 = (_plus + ".java");
            String _replaceAll_1 = _replaceAll.replaceAll(".mutator", _plus_1);
            String _name_1 = b.getName();
            String _plus_2 = ("_" + _name_1);
            String _plus_3 = (_plus_2 + ".java");
            this.fileName = _replaceAll_1.replace(".model", _plus_3);
            this.modelName = this.fileName.replaceAll(".java", "");
            this.useName = this.fileName.replaceAll(".java", ".use");
            this.propertiesName = this.fileName.replaceAll(".java", ".properties");
            final MutatorEnvironment blockMutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment();
            blockMutatorEnvironment.setDefinition(EcoreUtil.<Definition>copy(e.getDefinition()));
            blockMutatorEnvironment.getBlocks().add(EcoreUtil.<Block>copy(b));
            String _path = ProjectUtils.getProject().getLocation().toFile().getPath();
            String _plus_4 = ("file://" + _path);
            String _outputFolder = ModelManager.getOutputFolder();
            String _plus_5 = (_plus_4 + _outputFolder);
            String _plus_6 = (_plus_5 + "/");
            String _plus_7 = (_plus_6 + this.modelName);
            String _plus_8 = (_plus_7 + ".model");
            final Resource blockResource = ModelManager.createModel(_plus_8);
            blockResource.getContents().add(blockMutatorEnvironment);
            fsa.generateFile(this.useName, this.removeComments(this.use(blockMutatorEnvironment, resource, blockResource), "use"));
            fsa.generateFile(this.propertiesName, this.removeComments(this.properties(blockMutatorEnvironment, resource, blockResource), "properties"));
          }
        }
      }
    }
  }

  public CharSequence removeComments(final CharSequence contents, final String type) {
    boolean _equals = type.equals("use");
    if (_equals) {
      return contents.toString().replaceAll("--.*", "").replaceAll("(?m)^[ \t]*\r?\n", "");
    }
    boolean _equals_1 = type.equals("properties");
    if (_equals_1) {
      return contents.toString().replaceAll("#.*", "").replaceAll("(?m)^[ \t]*\r?\n", "");
    }
    return null;
  }

  public int getRandom(final int range) {
    if ((range == 1)) {
      return 0;
    }
    int _intValue = Long.valueOf(System.nanoTime()).intValue();
    int value = (_intValue % range);
    if ((value < 0)) {
      value = (value * (-1));
    }
    return value;
  }

  public void incContainers(final EClass eclass, final HashMap<String, WodelUseGenerator.Cardinality> classes, final List<EPackage> packages, final EClass root) {
    List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eclass));
    for (final EClassifier container : containers) {
      if (((!container.getName().equals(root.getName())) && (!container.getName().equals(eclass.getName())))) {
        WodelUseGenerator.Cardinality cardinality = classes.get(container.getName());
        EList<EReference> _eAllReferences = ((EClass) container).getEAllReferences();
        for (final EReference ref : _eAllReferences) {
          boolean _equals = ref.getEType().getName().equals(eclass.getName());
          if (_equals) {
            boolean _isContainment = ref.isContainment();
            if (_isContainment) {
              if ((cardinality.min == 0)) {
                cardinality.min++;
              }
            }
          }
        }
        classes.put(container.getName(), cardinality);
        this.incContainers(((EClass) container), classes, packages, root);
      }
    }
  }

  public void processBlocks(final HashMap<String, WodelUseGenerator.Cardinality> classes, final HashMap<String, HashMap<String, WodelUseGenerator.Cardinality>> blockCardinalities) {
    Set<String> _keySet = blockCardinalities.keySet();
    for (final String blockName : _keySet) {
      {
        HashMap<String, WodelUseGenerator.Cardinality> cardinality = blockCardinalities.get(blockName);
        Set<String> _keySet_1 = cardinality.keySet();
        for (final String className : _keySet_1) {
          {
            WodelUseGenerator.Cardinality cBlock = cardinality.get(className);
            WodelUseGenerator.Cardinality cMain = classes.get(className);
            if ((cBlock.min > cMain.min)) {
              cMain.min = cBlock.min;
            }
            classes.put(className, cMain);
          }
        }
      }
    }
  }

  public CharSequence generate(final MutatorEnvironment e, final Resource program, final List<EClass> eclasses, final HashMap<URI, String> classNames) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# ");
    HashMap<String, WodelUseGenerator.Cardinality> classes = new HashMap<String, WodelUseGenerator.Cardinality>();
    _builder.newLineIfNotEmpty();
    {
      if ((this.numObjects == null)) {
        {
          Set<URI> _keySet = classNames.keySet();
          for(final URI classURI : _keySet) {
            _builder.append("# ");
            WodelUseGenerator.Cardinality cardinality = new WodelUseGenerator.Cardinality();
            _builder.newLineIfNotEmpty();
            _builder.append("# ");
            _builder.append(cardinality.min = 0);
            _builder.newLineIfNotEmpty();
            {
              boolean _equals = EcoreUtil.getURI(this.root).equals(classURI);
              if (_equals) {
                _builder.append("# ");
                int _plusPlus = cardinality.min++;
                _builder.append(_plusPlus);
                _builder.newLineIfNotEmpty();
                _builder.append("# ");
                _builder.append(cardinality.max = 1);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("# ");
                _builder.append(cardinality.max = this.maxObjectsCardinality);
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("# ");
            WodelUseGenerator.Cardinality _put = classes.put(classNames.get(classURI), cardinality);
            _builder.append(_put);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size = e.getBlocks().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("# ");
            HashMap<String, HashMap<String, WodelUseGenerator.Cardinality>> blockCardinalities = new HashMap<String, HashMap<String, WodelUseGenerator.Cardinality>>();
            _builder.newLineIfNotEmpty();
            {
              EList<Block> _blocks = e.getBlocks();
              for(final Block b : _blocks) {
                _builder.append("# ");
                HashMap<String, WodelUseGenerator.Cardinality> cls = new HashMap<String, WodelUseGenerator.Cardinality>();
                _builder.newLineIfNotEmpty();
                {
                  Set<URI> _keySet_1 = classNames.keySet();
                  for(final URI classURI_1 : _keySet_1) {
                    _builder.append("# ");
                    WodelUseGenerator.Cardinality cardinality_1 = new WodelUseGenerator.Cardinality();
                    _builder.newLineIfNotEmpty();
                    _builder.append("# ");
                    _builder.append(cardinality_1.min = 0);
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _equals_1 = EcoreUtil.getURI(this.root).equals(classURI_1);
                      if (_equals_1) {
                        _builder.append("# ");
                        int _plusPlus_1 = cardinality_1.min++;
                        _builder.append(_plusPlus_1);
                        _builder.newLineIfNotEmpty();
                        _builder.append("# ");
                        _builder.append(cardinality_1.max = 1);
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("# ");
                        _builder.append(cardinality_1.max = this.maxObjectsCardinality);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("# ");
                HashMap<String, WodelUseGenerator.Cardinality> _put_1 = blockCardinalities.put(b.getName(), cls);
                _builder.append(_put_1);
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
            _builder.append("#");
            this.processBlocks(classes, blockCardinalities);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          Set<URI> _keySet_2 = classNames.keySet();
          for(final URI classURI_2 : _keySet_2) {
            String useClassName = classNames.get(classURI_2);
            _builder.newLineIfNotEmpty();
            String _encodeWord = UseGeneratorUtils.encodeWord(useClassName);
            _builder.append(_encodeWord);
            _builder.append("_min = ");
            _builder.append(classes.get(useClassName).min);
            _builder.newLineIfNotEmpty();
            String _encodeWord_1 = UseGeneratorUtils.encodeWord(useClassName);
            _builder.append(_encodeWord_1);
            _builder.append("_max = ");
            _builder.append(classes.get(useClassName).max);
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.newLine();
        {
          for(final EClass eclass : eclasses) {
            _builder.append("# ");
            WodelUseGenerator.Cardinality cardinality_2 = new WodelUseGenerator.Cardinality();
            _builder.newLineIfNotEmpty();
            _builder.append("# ");
            _builder.append(cardinality_2.min = 0);
            _builder.newLineIfNotEmpty();
            {
              boolean _equals_2 = EcoreUtil.getURI(this.root).equals(EcoreUtil.getURI(eclass));
              if (_equals_2) {
                _builder.append("# ");
                int _plusPlus_2 = cardinality_2.min++;
                _builder.append(_plusPlus_2);
                _builder.newLineIfNotEmpty();
                _builder.append("# ");
                _builder.append(cardinality_2.max = 1);
                _builder.newLineIfNotEmpty();
              } else {
                {
                  boolean _containsKey = this.numObjects.containsKey(eclass.getName());
                  if (_containsKey) {
                    _builder.append("# ");
                    _builder.append(cardinality_2.min = (this.numObjects.get(eclass.getName())).intValue());
                    _builder.newLineIfNotEmpty();
                    _builder.append("# ");
                    _builder.append(cardinality_2.max = (this.numObjects.get(eclass.getName())).intValue());
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("# ");
            WodelUseGenerator.Cardinality _put_2 = classes.put(classNames.get(EcoreUtil.getURI(eclass)), cardinality_2);
            _builder.append(_put_2);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          Set<URI> _keySet_3 = classNames.keySet();
          for(final URI classURI_3 : _keySet_3) {
            String useClassName_1 = classNames.get(classURI_3);
            _builder.newLineIfNotEmpty();
            String _encodeWord_2 = UseGeneratorUtils.encodeWord(useClassName_1);
            _builder.append(_encodeWord_2);
            _builder.append("_min = ");
            _builder.append(classes.get(useClassName_1).min);
            _builder.newLineIfNotEmpty();
            String _encodeWord_3 = UseGeneratorUtils.encodeWord(useClassName_1);
            _builder.append(_encodeWord_3);
            _builder.append("_max = ");
            _builder.append(classes.get(useClassName_1).max);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      if (((this.tagsByClass != null) && (this.tagsByClass.size() > 0))) {
        _builder.append("# ");
        Map<String, AbstractMap.SimpleEntry<String, String>> tagsByClassURI = new HashMap<String, AbstractMap.SimpleEntry<String, String>>();
        _builder.newLineIfNotEmpty();
        {
          for(final EClass eclass_1 : eclasses) {
            {
              boolean _containsKey_1 = this.tagsByClass.containsKey(eclass_1.getName());
              if (_containsKey_1) {
                _builder.append("# ");
                AbstractMap.SimpleEntry<String, String> _put_3 = tagsByClassURI.put(classNames.get(EcoreUtil.getURI(eclass_1)), this.tagsByClass.get(eclass_1.getName()));
                _builder.append(_put_3);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.newLine();
        {
          Set<URI> _keySet_4 = classNames.keySet();
          for(final URI classURI_4 : _keySet_4) {
            String useClassName_2 = classNames.get(classURI_4);
            _builder.newLineIfNotEmpty();
            {
              boolean _containsKey_2 = tagsByClassURI.containsKey(classNames.get(classURI_4));
              if (_containsKey_2) {
                String _encodeWord_4 = UseGeneratorUtils.encodeWord(useClassName_2);
                _builder.append(_encodeWord_4);
                _builder.append("_");
                String _key = tagsByClassURI.get(classNames.get(classURI_4)).getKey();
                _builder.append(_key);
                _builder.append(" = Set{");
                String _value = tagsByClassURI.get(classNames.get(classURI_4)).getValue();
                _builder.append(_value);
                _builder.append("}");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.newLine();
    {
      Set<URI> _keySet_5 = classNames.keySet();
      for(final URI classURI_5 : _keySet_5) {
        String useClassName_3 = classNames.get(classURI_5);
        _builder.newLineIfNotEmpty();
        String _encodeWord_5 = UseGeneratorUtils.encodeWord(useClassName_3);
        _builder.append(_encodeWord_5);
        _builder.append("_min = ");
        _builder.append(classes.get(useClassName_3).min);
        _builder.newLineIfNotEmpty();
        String _encodeWord_6 = UseGeneratorUtils.encodeWord(useClassName_3);
        _builder.append(_encodeWord_6);
        _builder.append("_max = ");
        _builder.append(classes.get(useClassName_3).max);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Associations");
    _builder.newLine();
    _builder.append("# ");
    HashMap<String, Integer> associationNames = new HashMap<String, Integer>();
    _builder.newLineIfNotEmpty();
    {
      for(final EClass eclass_2 : eclasses) {
        _builder.append("# ");
        EPackage pck = eclass_2.getEPackage();
        _builder.newLineIfNotEmpty();
        _builder.append("# ");
        List<EReference> refs = eclass_2.getEAllReferences();
        _builder.newLineIfNotEmpty();
        {
          int _size_1 = refs.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            {
              for(final EReference ref : refs) {
                _builder.append("# ");
                EPackage refEPackage = ref.getEReferenceType().getEPackage();
                _builder.newLineIfNotEmpty();
                {
                  if ((refEPackage != null)) {
                    _builder.append("# ");
                    String _name = pck.getName();
                    String _plus = (_name + "XxxX");
                    String _name_1 = eclass_2.getName();
                    String _plus_1 = (_plus + _name_1);
                    String _plus_2 = (_plus_1 + "XxxX");
                    String _name_2 = refEPackage.getName();
                    String _plus_3 = (_plus_2 + _name_2);
                    String _plus_4 = (_plus_3 + "XxxX");
                    String _name_3 = ref.getEType().getName();
                    String associationName = (_plus_4 + _name_3);
                    _builder.newLineIfNotEmpty();
                    {
                      Integer _get = associationNames.get(associationName);
                      boolean _tripleNotEquals = (_get != null);
                      if (_tripleNotEquals) {
                        _builder.append("# ");
                        Integer _get_1 = associationNames.get(associationName);
                        int _plus_5 = ((_get_1).intValue() + 1);
                        Integer _put_4 = associationNames.put(associationName, Integer.valueOf(_plus_5));
                        _builder.append(_put_4);
                        _builder.newLineIfNotEmpty();
                        _builder.append("# ");
                        String _associationName = associationName;
                        Integer _get_2 = associationNames.get(associationName);
                        String _plus_6 = associationName = (_associationName + _get_2);
                        _builder.append(_plus_6);
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("# ");
                        Integer _put_5 = associationNames.put(associationName, Integer.valueOf(0));
                        _builder.append(_put_5);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("# ");
                    int min = 0;
                    _builder.newLineIfNotEmpty();
                    {
                      String _name_4 = refEPackage.getName();
                      String _plus_7 = (_name_4 + "XxxX");
                      String _name_5 = ref.getEType().getName();
                      String _plus_8 = (_plus_7 + _name_5);
                      WodelUseGenerator.Cardinality _get_3 = classes.get(_plus_8);
                      boolean _tripleNotEquals_1 = (_get_3 != null);
                      if (_tripleNotEquals_1) {
                        {
                          String _name_6 = pck.getName();
                          String _plus_9 = (_name_6 + "XxxX");
                          String _name_7 = eclass_2.getName();
                          String _plus_10 = (_plus_9 + _name_7);
                          String _name_8 = refEPackage.getName();
                          String _plus_11 = (_name_8 + "XxxX");
                          String _name_9 = ref.getEType().getName();
                          String _plus_12 = (_plus_11 + _name_9);
                          if ((classes.get(_plus_10).min < classes.get(_plus_12).min)) {
                            _builder.append("# ");
                            String _name_10 = pck.getName();
                            String _plus_13 = (_name_10 + "XxxX");
                            String _name_11 = eclass_2.getName();
                            String _plus_14 = (_plus_13 + _name_11);
                            _builder.append(min = classes.get(_plus_14).min);
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("# ");
                            String _name_12 = refEPackage.getName();
                            String _plus_15 = (_name_12 + "XxxX");
                            String _name_13 = ref.getEType().getName();
                            String _plus_16 = (_plus_15 + _name_13);
                            _builder.append(min = classes.get(_plus_16).min);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      } else {
                        _builder.append("# ");
                        _builder.append(min = 0);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    String _encodeWord_7 = UseGeneratorUtils.encodeWord(associationName);
                    _builder.append(_encodeWord_7);
                    _builder.append("_min = ");
                    _builder.append(min);
                    _builder.newLineIfNotEmpty();
                    String _encodeWord_8 = UseGeneratorUtils.encodeWord(associationName);
                    _builder.append(_encodeWord_8);
                    _builder.append("_max = ");
                    _builder.append(this.maxAssociationsCardinality);
                    _builder.newLineIfNotEmpty();
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

  public CharSequence properties(final MutatorEnvironment e, final Resource program, final Resource model) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[default]");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Integer_min = ");
      _builder.append(this.minInteger);
      _builder.newLineIfNotEmpty();
      _builder.append("Integer_max = ");
      _builder.append(this.maxInteger);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("Real_min = ");
      _builder.append(this.minReal);
      _builder.newLineIfNotEmpty();
      _builder.append("Real_max = ");
      _builder.append(this.maxReal);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("String_max = ");
      _builder.append(this.maxString);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(this.dummyClassName);
      _builder.append("_min = 1");
      _builder.newLineIfNotEmpty();
      _builder.append(this.dummyClassName);
      _builder.append("_max = 1");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("# ");
      List<EPackage> packages = ModelManager.loadMetaModel(e.getDefinition().getMetamodel());
      _builder.newLineIfNotEmpty();
      _builder.append("# ");
      List<EClass> eclasses = ModelManager.getEClasses(packages);
      _builder.newLineIfNotEmpty();
      _builder.append("# ");
      HashMap<URI, String> classNames = UseGeneratorUtils.buildClassNames(eclasses);
      _builder.newLineIfNotEmpty();
      _builder.append("# ");
      _builder.append(this.root = ModelManager.getRootEClass(packages));
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generate = this.generate(e, program, eclasses, classNames);
      _builder.append(_generate);
      _builder.newLineIfNotEmpty();
      _builder.append("aggregationcyclefreeness = on");
      _builder.newLine();
      _builder.append("forbiddensharing = on");
      _builder.newLine();
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public CharSequence use(final MutatorEnvironment e, final Resource program, final Resource model) {
    StringConcatenation _builder = new StringConcatenation();
    String _generateUSE = UseGeneratorUtils.generateUSE(model, e, this.modelName, this.useReferences);
    _builder.append(_generateUSE);
    _builder.newLineIfNotEmpty();
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<Constraint> _constraints = e.getConstraints();
      for(final Constraint constraint : _constraints) {
        {
          EList<InvariantCS> _expressions = constraint.getExpressions();
          boolean _tripleNotEquals = (_expressions != null);
          if (_tripleNotEquals) {
            {
              EList<InvariantCS> _expressions_1 = constraint.getExpressions();
              for(final InvariantCS inv : _expressions_1) {
                String constraintText = WodelUtils.getConstraintText(this.fileName, inv);
                _builder.newLineIfNotEmpty();
                {
                  int _length = constraintText.length();
                  boolean _greaterThan = (_length > 0);
                  if (_greaterThan) {
                    String feature = constraintText.substring(0, constraintText.indexOf("->"));
                    _builder.newLineIfNotEmpty();
                    EClass eclass = constraint.getType();
                    _builder.newLineIfNotEmpty();
                    EClass featureclass = null;
                    _builder.newLineIfNotEmpty();
                    {
                      EList<EStructuralFeature> _eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
                      for(final EStructuralFeature sf : _eAllStructuralFeatures) {
                        {
                          boolean _equals = sf.getName().equals(feature);
                          if (_equals) {
                            _builder.append("-- ");
                            EClassifier _eType = sf.getEType();
                            _builder.append(featureclass = ((EClass) _eType));
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      if ((featureclass != null)) {
                        _builder.append("inv mutcode");
                        _builder.append(i);
                        _builder.append(" : ");
                        String _name = featureclass.getName();
                        _builder.append(_name);
                        _builder.append(".allInstances()->");
                        int _indexOf = constraintText.indexOf("->");
                        int _length_1 = "->".length();
                        int _plus = (_indexOf + _length_1);
                        String _substring = constraintText.substring(_plus, constraintText.length());
                        _builder.append(_substring);
                        _builder.newLineIfNotEmpty();
                        _builder.append("-- ");
                        int _plusPlus = i++;
                        _builder.append(_plusPlus);
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
          EList<String> _rules = constraint.getRules();
          boolean _tripleNotEquals_1 = (_rules != null);
          if (_tripleNotEquals_1) {
            {
              EList<String> _rules_1 = constraint.getRules();
              for(final String rule : _rules_1) {
                {
                  int _length_2 = rule.length();
                  boolean _greaterThan_1 = (_length_2 > 0);
                  if (_greaterThan_1) {
                    String feature_1 = rule.substring(0, rule.indexOf("->"));
                    _builder.newLineIfNotEmpty();
                    EClass eclass_1 = constraint.getType();
                    _builder.newLineIfNotEmpty();
                    EClass featureclass_1 = null;
                    _builder.newLineIfNotEmpty();
                    {
                      EList<EStructuralFeature> _eAllStructuralFeatures_1 = eclass_1.getEAllStructuralFeatures();
                      for(final EStructuralFeature sf_1 : _eAllStructuralFeatures_1) {
                        {
                          boolean _equals_1 = sf_1.getName().equals(feature_1);
                          if (_equals_1) {
                            _builder.append("-- ");
                            EClassifier _eType_1 = sf_1.getEType();
                            _builder.append(featureclass_1 = ((EClass) _eType_1));
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                    {
                      if ((featureclass_1 != null)) {
                        _builder.append("inv mutcode");
                        _builder.append(i);
                        _builder.append(" : ");
                        String _name_1 = featureclass_1.getName();
                        _builder.append(_name_1);
                        _builder.append(".allInstances()->");
                        int _indexOf_1 = rule.indexOf("->");
                        int _length_3 = "->".length();
                        int _plus_1 = (_indexOf_1 + _length_3);
                        String _substring_1 = rule.substring(_plus_1, rule.length());
                        _builder.append(_substring_1);
                        _builder.newLineIfNotEmpty();
                        _builder.append("-- ");
                        int _plusPlus_1 = i++;
                        _builder.append(_plusPlus_1);
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
    return _builder;
  }
}
