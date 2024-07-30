package wodeledu.dsls.generator.modeldraw;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import modeldraw.Content;
import modeldraw.Decoration;
import modeldraw.Edge;
import modeldraw.Enumerator;
import modeldraw.Information;
import modeldraw.Level;
import modeldraw.MutatorDraw;
import modeldraw.Node;
import modeldraw.NodeColor;
import modeldraw.NodeEnumerator;
import modeldraw.NodeShape;
import modeldraw.NodeStyle;
import modeldraw.NodeType;
import modeldraw.Relation;
import modeldraw.ValuedFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodel.utils.manager.JavaUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * @author Pablo Gomez-Abajo - modelDraw dot code generator.
 * 
 * Generates the Java code for the graphical
 * representation of the models. GraphViz mode.
 */
@SuppressWarnings("all")
public class ModelDrawDotGenerator extends AbstractGenerator {
  private String fileName;

  private String className;

  private List<EPackage> metamodel;

  private List<EClass> roots;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      int i = 0;
      this.fileName = resource.getURI().lastSegment();
      String _replaceAll = this.fileName.replaceAll(".draw", "").replaceAll("[.]", "_");
      String _plus = (_replaceAll + ".draw");
      this.fileName = _plus;
      Iterable<MutatorDraw> _filter = Iterables.<MutatorDraw>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MutatorDraw.class);
      for (final MutatorDraw e : _filter) {
        {
          if ((i == 0)) {
            String _replace = this.fileName.replace(".draw", "");
            String _plus_1 = (_replace + "Draw.java");
            this.fileName = _plus_1;
          } else {
            String _replace_1 = this.fileName.replace(".draw", "");
            String _plus_2 = (_replace_1 + Integer.valueOf(i));
            String _plus_3 = (_plus_2 + "Draw.java");
            this.fileName = _plus_3;
          }
          ArrayList<EPackage> _arrayList = new ArrayList<EPackage>();
          this.metamodel = _arrayList;
          this.metamodel.addAll(ModelManager.loadMetaModel(e.getMetamodel()));
          ArrayList<EClass> _arrayList_1 = new ArrayList<EClass>();
          this.roots = _arrayList_1;
          this.roots.addAll(ModelManager.getRootEClasses(this.metamodel));
          this.className = this.fileName.replaceAll("Draw.java", "");
          fsa.generateFile(((("mutator/" + this.className) + "/") + this.fileName), JavaUtils.format(this.compile(e), false));
          i++;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public CharSequence generate(final MutatorDraw draw, final String folder) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Map<EObject, LabelStyle> dotnodes = new HashMap<EObject, LabelStyle>();");
    _builder.newLine();
    _builder.append("Map<String, List<Map<String, String>>> dotrels = new HashMap<String, List<Map<String, String>>>();");
    _builder.newLine();
    _builder.append("Map<String, List<String>> dottext = new HashMap<String, List<String>>();");
    _builder.newLine();
    _builder.append("List<String> dotcode = new ArrayList<String>();");
    _builder.newLine();
    {
      EList<Node> _nodes = draw.getInstances().get(0).getNodes();
      boolean _tripleNotEquals = (_nodes != null);
      if (_tripleNotEquals) {
        {
          int _size = draw.getInstances().get(0).getNodes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("generateNodes(packages, model, dotnodes, dotrels);");
            _builder.newLine();
          }
        }
      }
    }
    {
      EList<Relation> _relations = draw.getInstances().get(0).getRelations();
      boolean _tripleNotEquals_1 = (_relations != null);
      if (_tripleNotEquals_1) {
        {
          int _size_1 = draw.getInstances().get(0).getRelations().size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("generateRelations(model, dotrels, dottext);");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("dotcode.add(\"digraph ");
    String _name = draw.getInstances().get(0).getName().getName();
    _builder.append(_name);
    _builder.append(" {\\n\\nrankdir=LR;\\n\");");
    _builder.newLineIfNotEmpty();
    _builder.append("for (EObject dotnode : dotnodes.keySet()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (dotnodes.get(dotnode) != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dotcode.add(dotnodes.get(dotnode).name.replaceAll(\"\'\", \"\") + \" [\" + dotnodes.get(dotnode).label.replaceAll(\"\'\", \"\") + \"];\\n\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("for (String dott : dottext.keySet()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (dotrels.get(dott) == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("dotcode.add(dott + \";\\n\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (dotrels.get(dott).size() == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("dotcode.add(dott + \";\\n\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (String text : dottext.get(dott)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("dotcode.add(dott.replaceAll(\"\'\", \"\") + \" [\" + text.replaceAll(\"\'\", \"\") + \"];\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("dotcode.add(\"}\");");
    _builder.newLine();
    return _builder;
  }

  public CharSequence compile(final Content content, final String hmname) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((content != null)) {
        {
          if (((content.getNodenum() != null) && (content.getNodenum().size() > 0))) {
            {
              EList<NodeEnumerator> _nodenum = content.getNodenum();
              for(final NodeEnumerator nodenum : _nodenum) {
                _builder.append("for (EAttribute attribute : obj.eClass().getEAllAttributes()) {");
                _builder.newLine();
                {
                  EAttribute _att = nodenum.getAtt();
                  boolean _tripleNotEquals = (_att != null);
                  if (_tripleNotEquals) {
                    _builder.append("\t");
                    _builder.append("if (attribute.getName().equals(\"");
                    String _name = nodenum.getAtt().getName();
                    _builder.append(_name, "\t");
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("if (attribute.getName().equals(\"name\")) {");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t");
                _builder.append("if (obj.eGet(attribute) != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("EObject o = (EObject) obj.eGet(attribute);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("if (o instanceof EEnumLiteral) {");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("EEnumLiteral lit = (EEnumLiteral) o;");
                _builder.newLine();
                {
                  if (((nodenum.getEnumerator() != null) && (nodenum.getEnumerator().size() > 0))) {
                    {
                      EList<Enumerator> _enumerator = nodenum.getEnumerator();
                      for(final Enumerator lit : _enumerator) {
                        _builder.append("\t\t\t\t");
                        _builder.append("if (lit.getLiteral().equals(\"");
                        String _name_1 = lit.getLiteral().getName();
                        _builder.append(_name_1, "\t\t\t\t");
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("text = ");
                        _builder.append(hmname, "\t\t\t\t\t");
                        _builder.append(".get(obj);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("text = text + \"");
                        String _value = lit.getValue();
                        _builder.append(_value, "\t\t\t\t\t");
                        _builder.append(" \";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("\t");
                        _builder.append(hmname, "\t\t\t\t\t");
                        _builder.append(".put(obj, text);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("break;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        {
          if (((content.getInfo() != null) && (content.getInfo().size() > 0))) {
            {
              EList<Information> _info = content.getInfo();
              for(final Information info : _info) {
                _builder.append("for (EReference r : obj.eClass().getEAllReferences()) {");
                _builder.newLine();
                {
                  EReference _type = info.getType();
                  boolean _tripleNotEquals_1 = (_type != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t");
                    _builder.append("if (r.getName().equals(\"");
                    String _name_2 = info.getType().getName();
                    _builder.append(_name_2, "\t");
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("if (r.getName().equals(\"name\")) {");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t");
                _builder.append("if (obj.eGet(r) != null) {");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("EObject o = (EObject) obj.eGet(r);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("for (EAttribute attribute : o.eClass().getEAllAttributes()) {");
                _builder.newLine();
                {
                  EAttribute _att_1 = info.getAtt();
                  boolean _tripleNotEquals_2 = (_att_1 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("\t\t\t\t");
                    _builder.append("if (attribute.getName().equals(\"");
                    String _name_3 = info.getAtt().getName();
                    _builder.append(_name_3, "\t\t\t\t");
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t\t");
                    _builder.append("if (attribute.getName().equals(\"name\")) {");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t\t\t");
                _builder.append("text = ");
                _builder.append(hmname, "\t\t\t\t\t");
                _builder.append(".get(obj);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t");
                _builder.append("text = text + (String) o.eGet(attribute) + \" \";");
                _builder.newLine();
                _builder.append("\t\t\t\t\t");
                _builder.append(hmname, "\t\t\t\t\t");
                _builder.append(".put(obj, text);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t");
                _builder.append("break;");
                _builder.newLine();
                _builder.append("\t\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("break;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("for (EAttribute attribute : obj.eClass().getEAllAttributes()) {");
        _builder.newLine();
        {
          EAttribute _attName = content.getAttName();
          boolean _tripleNotEquals_3 = (_attName != null);
          if (_tripleNotEquals_3) {
            _builder.append("\t");
            _builder.append("if (attribute.getName().equals(\"");
            String _name_4 = content.getAttName().getName();
            _builder.append(_name_4, "\t");
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("if (attribute.getName().equals(\"name\")) {");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("text = ");
        _builder.append(hmname, "\t\t");
        _builder.append(".get(obj);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("text = text + (String) obj.eGet(attribute) + \" \";");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(hmname, "\t\t");
        _builder.append(".put(obj, text);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("break;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        {
          String _symbol = content.getSymbol();
          boolean _tripleNotEquals_4 = (_symbol != null);
          if (_tripleNotEquals_4) {
            _builder.append("text = ");
            _builder.append(hmname);
            _builder.append(".get(obj);");
            _builder.newLineIfNotEmpty();
            _builder.append("text = text + \"");
            String _symbol_1 = content.getSymbol();
            _builder.append(_symbol_1);
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append(hmname);
            _builder.append(".put(obj, text);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence decorate(final Relation rel) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((rel.getLabel() != null) && (rel.getLabel().size() > 0))) {
        _builder.append("parameters.put(\"label\", label);");
        _builder.newLine();
      }
    }
    {
      Decoration _tar_decoration = rel.getTar_decoration();
      boolean _notEquals = (!Objects.equal(_tar_decoration, Decoration.NONE));
      if (_notEquals) {
        _builder.append("if (parameters.containsKey(\"dir\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"dir\", \"both\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowtail\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowtail\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        {
          Decoration _tar_decoration_1 = rel.getTar_decoration();
          boolean _equals = Objects.equal(_tar_decoration_1, Decoration.TRIANGLE);
          if (_equals) {
            _builder.append("parameters.put(\"arrowhead\", \"empty\");");
            _builder.newLine();
          } else {
            {
              Decoration _tar_decoration_2 = rel.getTar_decoration();
              boolean _notEquals_1 = (!Objects.equal(_tar_decoration_2, Decoration.EMPTY));
              if (_notEquals_1) {
                _builder.append("parameters.put(\"arrowhead\", \"");
                Decoration _tar_decoration_3 = rel.getTar_decoration();
                _builder.append(_tar_decoration_3);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("parameters.put(\"arrowhead\", \"none\");");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EAttribute _tar_label = rel.getTar_label();
      boolean _tripleNotEquals = (_tar_label != null);
      if (_tripleNotEquals) {
        _builder.append("if (parameters.containsKey(\"dir\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"dir\", \"both\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowhead\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowhead\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowtail\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowtail\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("parameters.put(\"headlabel\", tar_label != null ? tar_label : \"\");");
        _builder.newLine();
      }
    }
    {
      Decoration _src_decoration = rel.getSrc_decoration();
      boolean _notEquals_2 = (!Objects.equal(_src_decoration, Decoration.NONE));
      if (_notEquals_2) {
        _builder.append("if (parameters.containsKey(\"dir\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"dir\", \"both\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowhead\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowhead\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        {
          Decoration _src_decoration_1 = rel.getSrc_decoration();
          boolean _equals_1 = Objects.equal(_src_decoration_1, Decoration.TRIANGLE);
          if (_equals_1) {
            _builder.append("parameters.put(\"arrowtail\", \"empty\");");
            _builder.newLine();
          } else {
            {
              Decoration _src_decoration_2 = rel.getSrc_decoration();
              boolean _notEquals_3 = (!Objects.equal(_src_decoration_2, Decoration.EMPTY));
              if (_notEquals_3) {
                _builder.append("parameters.put(\"arrowtail\", \"");
                Decoration _src_decoration_3 = rel.getSrc_decoration();
                _builder.append(_src_decoration_3);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("parameters.put(\"arrowtail\", \"none\");");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      EAttribute _src_label = rel.getSrc_label();
      boolean _tripleNotEquals_1 = (_src_label != null);
      if (_tripleNotEquals_1) {
        _builder.append("if (parameters.containsKey(\"dir\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"dir\", \"both\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowhead\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowhead\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (parameters.containsKey(\"arrowtail\") == false) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters.put(\"arrowtail\", \"none\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("parameters.put(\"taillabel\", src_label != null ? src_label : \"\");");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public CharSequence compile(final MutatorDraw draw) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mutator.");
    _builder.append(this.className);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.io.FileNotFoundException;");
    _builder.newLine();
    _builder.append("import java.io.PrintWriter;");
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.io.UnsupportedEncodingException;");
    _builder.newLine();
    _builder.append("import java.lang.InterruptedException;");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.LinkedHashMap;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EAttribute;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EEnum;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EEnumLiteral;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EPackage;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EReference;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EStructuralFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.resource.Resource;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.util.EcoreUtil;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.MetaModelNotFoundException;");
    _builder.newLine();
    _builder.append("import wodel.utils.exceptions.ModelNotFoundException;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.ProjectUtils;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.ModelManager;");
    _builder.newLine();
    _builder.append("import wodel.utils.manager.DrawUtils.LabelStyle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.IProgressMonitor;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.jface.operation.IRunnableWithProgress;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("import java.lang.reflect.InvocationTargetException;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("import org.eclipse.core.commands.AbstractHandler;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.core.commands.ExecutionEvent;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.commands.ExecutionException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.core.resources.IProject;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.jface.dialogs.ProgressMonitorDialog;");
    _builder.newLine();
    _builder.append("import org.eclipse.jface.operation.IRunnableWithProgress;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.swt.widgets.Display;");
    _builder.newLine();
    _builder.append("import org.eclipse.swt.widgets.Shell;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(this.className);
    _builder.append("Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Display activeDisplay = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Shell activeShell = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private class RunMutatorDrawWithProgress implements IRunnableWithProgress {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("generate(monitor);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("catch (MetaModelNotFoundException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("catch (ModelNotFoundException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("catch (FileNotFoundException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   \t\t");
    _builder.newLine();
    _builder.append("   \t\t\t");
    String _replace = ProjectUtils.getProject().getLocation().toFile().getPath().replace("\\", "/");
    String folder = (_replace + "/");
    _builder.newLineIfNotEmpty();
    {
      EList<Node> _nodes = draw.getInstances().get(0).getNodes();
      boolean _tripleNotEquals = (_nodes != null);
      if (_tripleNotEquals) {
        {
          int _size = draw.getInstances().get(0).getNodes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("\t");
            _builder.append("private void generateNodes(List<EPackage> packages, Resource model, Map<EObject, LabelStyle> dotnodes, Map<String, List<Map<String, String>>> dotrels) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("// COUNTER: ");
            int counter = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<Node> _nodes_1 = draw.getInstances().get(0).getNodes();
              for(final Node node : _nodes_1) {
                _builder.append("\t");
                _builder.append("List<EObject> lnode_");
                _builder.append(counter, "\t");
                _builder.append(" = ModelManager.getObjectsOfType(\"");
                String _name = node.getName().getName();
                _builder.append(_name, "\t");
                _builder.append("\", model);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("for (EObject node : lnode_");
                _builder.append(counter, "\t");
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("Map<String, String> parameters = new LinkedHashMap<String, String>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("List<Map<String, String>> rels = new ArrayList<Map<String, String>>();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("String name = \"\";");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("String typeName = node.eClass().getName();");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("for (EAttribute att : node.eClass().getEAllAttributes()) {");
                _builder.newLine();
                {
                  EAttribute _attName = node.getAttName();
                  boolean _tripleNotEquals_1 = (_attName != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t\t\t");
                    _builder.append("if (att.getName().equals(\"");
                    String _name_1 = node.getAttName().getName();
                    _builder.append(_name_1, "\t\t\t");
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t");
                    _builder.append("if (att.getName().equals(\"name\")) {");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("name = (String) node.eGet(att);");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("break;");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EList<ValuedFeature> _feature = node.getFeature();
                  boolean _tripleNotEquals_2 = (_feature != null);
                  if (_tripleNotEquals_2) {
                    {
                      int _size_1 = node.getFeature().size();
                      boolean _equals = (_size_1 == 0);
                      if (_equals) {
                        _builder.append("\t");
                        _builder.append("LabelStyle style = null;");
                        _builder.newLine();
                        {
                          NodeType _type = node.getType();
                          boolean _equals_1 = Objects.equal(_type, NodeType.MARKEDNODE);
                          if (_equals_1) {
                            _builder.append("\t");
                            _builder.append("style = new LabelStyle();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.name = \"_nil\";");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.shape = \"style = invis\"; ");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = new LabelStyle();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = dotnodes.get(node);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.name = name;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.border = \"0\";");
                            _builder.newLine();
                            {
                              if (((!Objects.equal(node.getShape(), NodeShape.LOAD)) && (!Objects.equal(node.getShape(), NodeShape.LOGIC)))) {
                                _builder.append("\t");
                                _builder.append("style.shape = \"shape = ");
                                NodeShape _shape = node.getShape();
                                _builder.append(_shape, "\t");
                                _builder.append("\";");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              NodeShape _shape_1 = node.getShape();
                              boolean _equals_2 = Objects.equal(_shape_1, NodeShape.LOGIC);
                              if (_equals_2) {
                                _builder.append("\t");
                                _builder.append("style.path = \"C:/eclipse/workspace/wodel.wodeledu/content/images/logic_\" + typeName.toLowerCase() + \".png\";");
                                _builder.newLine();
                              }
                            }
                            {
                              NodeShape _shape_2 = node.getShape();
                              boolean _equals_3 = Objects.equal(_shape_2, NodeShape.LOAD);
                              if (_equals_3) {
                                _builder.append("\t");
                                _builder.append("style.path = \"");
                                String _pathShape = node.getPathShape();
                                _builder.append(_pathShape, "\t");
                                _builder.append("\";");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("dotnodes.put(node, style);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("rels.add(parameters);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                            _builder.newLine();
                          }
                        }
                        {
                          NodeType _type_1 = node.getType();
                          boolean _equals_4 = Objects.equal(_type_1, NodeType.NODE);
                          if (_equals_4) {
                            _builder.append("\t");
                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = new LabelStyle();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = dotnodes.get(node);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.name = name;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.border = \"0\";");
                            _builder.newLine();
                            {
                              if (((!Objects.equal(node.getShape(), NodeShape.LOAD)) && (!Objects.equal(node.getShape(), NodeShape.LOGIC)))) {
                                _builder.append("\t");
                                _builder.append("style.shape = \"shape = ");
                                NodeShape _shape_3 = node.getShape();
                                _builder.append(_shape_3, "\t");
                                _builder.append("\";");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              NodeShape _shape_4 = node.getShape();
                              boolean _equals_5 = Objects.equal(_shape_4, NodeShape.LOGIC);
                              if (_equals_5) {
                                _builder.append("\t");
                                _builder.append("style.path = \"C:/eclipse/workspace/wodel.wodeledu/content/images/logic_\" + typeName.toLowerCase() + \".png\";");
                                _builder.newLine();
                              }
                            }
                            {
                              NodeShape _shape_5 = node.getShape();
                              boolean _equals_6 = Objects.equal(_shape_5, NodeShape.LOAD);
                              if (_equals_6) {
                                _builder.append("\t");
                                _builder.append("style.path = \"");
                                String _pathShape_1 = node.getPathShape();
                                _builder.append(_pathShape_1, "\t");
                                _builder.append("\";");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("dotnodes.put(node, style);");
                            _builder.newLine();
                          }
                        }
                        {
                          NodeShape _shape_6 = node.getShape();
                          boolean _equals_7 = Objects.equal(_shape_6, NodeShape.RECORD);
                          if (_equals_7) {
                            _builder.append("\t");
                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = new LabelStyle();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("style = dotnodes.get(node);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.name = name;");
                            _builder.newLine();
                            {
                              NodeStyle _style = node.getStyle();
                              boolean _equals_8 = Objects.equal(_style, NodeStyle.ITALIC);
                              if (_equals_8) {
                                _builder.append("\t");
                                _builder.append("style.style = \"I\";");
                                _builder.newLine();
                              }
                            }
                            {
                              NodeStyle _style_1 = node.getStyle();
                              boolean _equals_9 = Objects.equal(_style_1, NodeStyle.UNDERLINE);
                              if (_equals_9) {
                                _builder.append("\t");
                                _builder.append("style.style = \"U\";");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("style.border = \"1\";");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                            NodeColor _color = node.getColor();
                            _builder.append(_color, "\t");
                            _builder.append("\";");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("dotnodes.put(node, style);");
                            _builder.newLine();
                          }
                        }
                      } else {
                        {
                          EList<ValuedFeature> _feature_1 = node.getFeature();
                          for(final ValuedFeature feat : _feature_1) {
                            _builder.append("\t");
                            _builder.append("for (EStructuralFeature feat : node.eClass().getEAllStructuralFeatures()) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (feat.getName().equals(\"");
                            String _name_2 = feat.getFeat().getName();
                            _builder.append(_name_2, "\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("Object featObject = node.eGet(feat);");
                            _builder.newLine();
                            {
                              if ((feat instanceof ValuedFeature)) {
                                {
                                  EStructuralFeature _feat = feat.getFeat();
                                  if ((_feat instanceof EAttribute)) {
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("if (featObject instanceof Boolean) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("Boolean value = (Boolean) featObject;");
                                    _builder.newLine();
                                    {
                                      boolean _isNegation = feat.isNegation();
                                      boolean _equals_10 = (_isNegation == true);
                                      if (_equals_10) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (value == false) {");
                                        _builder.newLine();
                                      } else {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (value == true) {");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("LabelStyle style = null;");
                                    _builder.newLine();
                                    {
                                      NodeType _type_2 = node.getType();
                                      boolean _equals_11 = Objects.equal(_type_2, NodeType.MARKEDNODE);
                                      if (_equals_11) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style = new LabelStyle();");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.name = \"_nil\";");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.shape = \"style = invis\"; ");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (dotnodes.containsKey(node) == false) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = new LabelStyle();");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("else {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = dotnodes.get(node);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.name = name;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.border = \"0\";");
                                        _builder.newLine();
                                        {
                                          NodeShape _shape_7 = node.getShape();
                                          boolean _notEquals = (!Objects.equal(_shape_7, NodeShape.LOAD));
                                          if (_notEquals) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"shape = ");
                                            NodeShape _shape_8 = node.getShape();
                                            _builder.append(_shape_8, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                        {
                                          NodeShape _shape_9 = node.getShape();
                                          boolean _equals_12 = Objects.equal(_shape_9, NodeShape.LOAD);
                                          if (_equals_12) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.path = \"");
                                            String _pathShape_2 = node.getPathShape();
                                            _builder.append(_pathShape_2, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("dotnodes.put(node, style);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("rels.add(parameters);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                        _builder.newLine();
                                      }
                                    }
                                    {
                                      NodeType _type_3 = node.getType();
                                      boolean _equals_13 = Objects.equal(_type_3, NodeType.NODE);
                                      if (_equals_13) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (dotnodes.containsKey(node) == false) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = new LabelStyle();");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("else {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = dotnodes.get(node);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.name = name;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.border = \"0\";");
                                        _builder.newLine();
                                        {
                                          NodeShape _shape_10 = node.getShape();
                                          boolean _notEquals_1 = (!Objects.equal(_shape_10, NodeShape.LOAD));
                                          if (_notEquals_1) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"shape = ");
                                            NodeShape _shape_11 = node.getShape();
                                            _builder.append(_shape_11, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                        {
                                          NodeShape _shape_12 = node.getShape();
                                          boolean _equals_14 = Objects.equal(_shape_12, NodeShape.LOAD);
                                          if (_equals_14) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.path = \"");
                                            String _pathShape_3 = node.getPathShape();
                                            _builder.append(_pathShape_3, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("dotnodes.put(node, style);");
                                        _builder.newLine();
                                      }
                                    }
                                    {
                                      NodeShape _shape_13 = node.getShape();
                                      boolean _equals_15 = Objects.equal(_shape_13, NodeShape.RECORD);
                                      if (_equals_15) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (dotnodes.containsKey(node) == false) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = new LabelStyle();");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("else {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("style = dotnodes.get(node);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.name = name;");
                                        _builder.newLine();
                                        {
                                          NodeStyle _style_2 = node.getStyle();
                                          boolean _equals_16 = Objects.equal(_style_2, NodeStyle.ITALIC);
                                          if (_equals_16) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.style = \"I\";");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeStyle _style_3 = node.getStyle();
                                          boolean _equals_17 = Objects.equal(_style_3, NodeStyle.UNDERLINE);
                                          if (_equals_17) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.style = \"U\";");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.border = \"1\";");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                        NodeColor _color_1 = node.getColor();
                                        _builder.append(_color_1, "\t\t\t");
                                        _builder.append("\";");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("dotnodes.put(node, style);");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                {
                                  EStructuralFeature _feat_1 = feat.getFeat();
                                  if ((_feat_1 instanceof EReference)) {
                                    {
                                      EStructuralFeature _refFeature = feat.getRefFeature();
                                      boolean _tripleEquals = (_refFeature == null);
                                      if (_tripleEquals) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("{");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (featObject == null);");
                                        _builder.newLine();
                                        {
                                          if (((feat.getValue() != null) && feat.getValue().equals("null"))) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == true) {");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == false) {");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("LabelStyle style = null;");
                                        _builder.newLine();
                                        {
                                          NodeType _type_4 = node.getType();
                                          boolean _equals_18 = Objects.equal(_type_4, NodeType.MARKEDNODE);
                                          if (_equals_18) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = \"_nil\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"style = invis\"; ");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_14 = node.getShape();
                                              boolean _notEquals_2 = (!Objects.equal(_shape_14, NodeShape.LOAD));
                                              if (_notEquals_2) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_15 = node.getShape();
                                                _builder.append(_shape_15, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_16 = node.getShape();
                                              boolean _equals_19 = Objects.equal(_shape_16, NodeShape.LOAD);
                                              if (_equals_19) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_4 = node.getPathShape();
                                                _builder.append(_pathShape_4, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("rels.add(parameters);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeType _type_5 = node.getType();
                                          boolean _equals_20 = Objects.equal(_type_5, NodeType.NODE);
                                          if (_equals_20) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_17 = node.getShape();
                                              boolean _notEquals_3 = (!Objects.equal(_shape_17, NodeShape.LOAD));
                                              if (_notEquals_3) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_18 = node.getShape();
                                                _builder.append(_shape_18, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_19 = node.getShape();
                                              boolean _equals_21 = Objects.equal(_shape_19, NodeShape.LOAD);
                                              if (_equals_21) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_5 = node.getPathShape();
                                                _builder.append(_pathShape_5, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeShape _shape_20 = node.getShape();
                                          boolean _equals_22 = Objects.equal(_shape_20, NodeShape.RECORD);
                                          if (_equals_22) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            {
                                              NodeStyle _style_4 = node.getStyle();
                                              boolean _equals_23 = Objects.equal(_style_4, NodeStyle.ITALIC);
                                              if (_equals_23) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"I\";");
                                                _builder.newLine();
                                              }
                                            }
                                            {
                                              NodeStyle _style_5 = node.getStyle();
                                              boolean _equals_24 = Objects.equal(_style_5, NodeStyle.UNDERLINE);
                                              if (_equals_24) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"U\";");
                                                _builder.newLine();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"1\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                            NodeColor _color_2 = node.getColor();
                                            _builder.append(_color_2, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    {
                                      EStructuralFeature _refFeature_1 = feat.getRefFeature();
                                      boolean _tripleNotEquals_3 = (_refFeature_1 != null);
                                      if (_tripleNotEquals_3) {
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (featObject instanceof EObject) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("if (refFeature.getName().equals(\"");
                                        String _name_3 = feat.getRefFeature().getName();
                                        _builder.append(_name_3, "\t\t\t\t");
                                        _builder.append("\")) {");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("Object refFeatureObject = ((EObject) featObject).eGet(refFeature);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (refFeatureObject instanceof Boolean) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (Boolean) refFeatureObject;");
                                        _builder.newLine();
                                        {
                                          boolean _isNegation_1 = feat.isNegation();
                                          boolean _equals_25 = (_isNegation_1 == true);
                                          if (_equals_25) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == false) {");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == true) {");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("LabelStyle style = null;");
                                        _builder.newLine();
                                        {
                                          NodeType _type_6 = node.getType();
                                          boolean _equals_26 = Objects.equal(_type_6, NodeType.MARKEDNODE);
                                          if (_equals_26) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = \"_nil\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"style = invis\"; ");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_21 = node.getShape();
                                              boolean _notEquals_4 = (!Objects.equal(_shape_21, NodeShape.LOAD));
                                              if (_notEquals_4) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_22 = node.getShape();
                                                _builder.append(_shape_22, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_23 = node.getShape();
                                              boolean _equals_27 = Objects.equal(_shape_23, NodeShape.LOAD);
                                              if (_equals_27) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_6 = node.getPathShape();
                                                _builder.append(_pathShape_6, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("rels.add(parameters);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeType _type_7 = node.getType();
                                          boolean _equals_28 = Objects.equal(_type_7, NodeType.NODE);
                                          if (_equals_28) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_24 = node.getShape();
                                              boolean _notEquals_5 = (!Objects.equal(_shape_24, NodeShape.LOAD));
                                              if (_notEquals_5) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_25 = node.getShape();
                                                _builder.append(_shape_25, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_26 = node.getShape();
                                              boolean _equals_29 = Objects.equal(_shape_26, NodeShape.LOAD);
                                              if (_equals_29) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_7 = node.getPathShape();
                                                _builder.append(_pathShape_7, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeShape _shape_27 = node.getShape();
                                          boolean _equals_30 = Objects.equal(_shape_27, NodeShape.RECORD);
                                          if (_equals_30) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            {
                                              NodeStyle _style_6 = node.getStyle();
                                              boolean _equals_31 = Objects.equal(_style_6, NodeStyle.ITALIC);
                                              if (_equals_31) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"I\";");
                                                _builder.newLine();
                                              }
                                            }
                                            {
                                              NodeStyle _style_7 = node.getStyle();
                                              boolean _equals_32 = Objects.equal(_style_7, NodeStyle.UNDERLINE);
                                              if (_equals_32) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"U\";");
                                                _builder.newLine();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"1\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                            NodeColor _color_3 = node.getColor();
                                            _builder.append(_color_3, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("else {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (refFeatureObject == null);");
                                        _builder.newLine();
                                        {
                                          if (((feat.getValue() != null) && feat.getValue().equals("null"))) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == true) {");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == false) {");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("LabelStyle style = null;");
                                        _builder.newLine();
                                        {
                                          NodeType _type_8 = node.getType();
                                          boolean _equals_33 = Objects.equal(_type_8, NodeType.MARKEDNODE);
                                          if (_equals_33) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = \"_nil\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"style = invis\"; ");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_28 = node.getShape();
                                              boolean _notEquals_6 = (!Objects.equal(_shape_28, NodeShape.LOAD));
                                              if (_notEquals_6) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_29 = node.getShape();
                                                _builder.append(_shape_29, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_30 = node.getShape();
                                              boolean _equals_34 = Objects.equal(_shape_30, NodeShape.LOAD);
                                              if (_equals_34) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_8 = node.getPathShape();
                                                _builder.append(_pathShape_8, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("rels.add(parameters);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeType _type_9 = node.getType();
                                          boolean _equals_35 = Objects.equal(_type_9, NodeType.NODE);
                                          if (_equals_35) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_31 = node.getShape();
                                              boolean _notEquals_7 = (!Objects.equal(_shape_31, NodeShape.LOAD));
                                              if (_notEquals_7) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_32 = node.getShape();
                                                _builder.append(_shape_32, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_33 = node.getShape();
                                              boolean _equals_36 = Objects.equal(_shape_33, NodeShape.LOAD);
                                              if (_equals_36) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_9 = node.getPathShape();
                                                _builder.append(_pathShape_9, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeShape _shape_34 = node.getShape();
                                          boolean _equals_37 = Objects.equal(_shape_34, NodeShape.RECORD);
                                          if (_equals_37) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            {
                                              NodeStyle _style_8 = node.getStyle();
                                              boolean _equals_38 = Objects.equal(_style_8, NodeStyle.ITALIC);
                                              if (_equals_38) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"I\";");
                                                _builder.newLine();
                                              }
                                            }
                                            {
                                              NodeStyle _style_9 = node.getStyle();
                                              boolean _equals_39 = Objects.equal(_style_9, NodeStyle.UNDERLINE);
                                              if (_equals_39) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"U\";");
                                                _builder.newLine();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"1\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                            NodeColor _color_4 = node.getColor();
                                            _builder.append(_color_4, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (featObject instanceof List<?>) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("for (EObject featOb : (List<EObject>) featObject) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("for (EStructuralFeature refFeature : featOb.eClass().getEAllStructuralFeatures()) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("if (refFeature.getName().equals(\"");
                                        String _name_4 = feat.getRefFeature().getName();
                                        _builder.append(_name_4, "\t\t\t\t");
                                        _builder.append("\")) {");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("Object refFeatureObject = featOb.eGet(refFeature);");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (refFeatureObject instanceof Boolean) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (Boolean) refFeatureObject;");
                                        _builder.newLine();
                                        {
                                          boolean _isNegation_2 = feat.isNegation();
                                          boolean _equals_40 = (_isNegation_2 == true);
                                          if (_equals_40) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == false) {");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == true) {");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("LabelStyle style = null;");
                                        _builder.newLine();
                                        {
                                          NodeType _type_10 = node.getType();
                                          boolean _equals_41 = Objects.equal(_type_10, NodeType.MARKEDNODE);
                                          if (_equals_41) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = \"_nil\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"style = invis\"; ");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_35 = node.getShape();
                                              boolean _notEquals_8 = (!Objects.equal(_shape_35, NodeShape.LOAD));
                                              if (_notEquals_8) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_36 = node.getShape();
                                                _builder.append(_shape_36, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_37 = node.getShape();
                                              boolean _equals_42 = Objects.equal(_shape_37, NodeShape.LOAD);
                                              if (_equals_42) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_10 = node.getPathShape();
                                                _builder.append(_pathShape_10, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("rels.add(parameters);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeType _type_11 = node.getType();
                                          boolean _equals_43 = Objects.equal(_type_11, NodeType.NODE);
                                          if (_equals_43) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_38 = node.getShape();
                                              boolean _notEquals_9 = (!Objects.equal(_shape_38, NodeShape.LOAD));
                                              if (_notEquals_9) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_39 = node.getShape();
                                                _builder.append(_shape_39, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_40 = node.getShape();
                                              boolean _equals_44 = Objects.equal(_shape_40, NodeShape.LOAD);
                                              if (_equals_44) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_11 = node.getPathShape();
                                                _builder.append(_pathShape_11, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeShape _shape_41 = node.getShape();
                                          boolean _equals_45 = Objects.equal(_shape_41, NodeShape.RECORD);
                                          if (_equals_45) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            {
                                              NodeStyle _style_10 = node.getStyle();
                                              boolean _equals_46 = Objects.equal(_style_10, NodeStyle.ITALIC);
                                              if (_equals_46) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"I\";");
                                                _builder.newLine();
                                              }
                                            }
                                            {
                                              NodeStyle _style_11 = node.getStyle();
                                              boolean _equals_47 = Objects.equal(_style_11, NodeStyle.UNDERLINE);
                                              if (_equals_47) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"U\";");
                                                _builder.newLine();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"1\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                            NodeColor _color_5 = node.getColor();
                                            _builder.append(_color_5, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("else {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (refFeatureObject == null);");
                                        _builder.newLine();
                                        {
                                          if (((feat.getValue() != null) && feat.getValue().equals("null"))) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == true) {");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (value == false) {");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("LabelStyle style = null;");
                                        _builder.newLine();
                                        {
                                          NodeType _type_12 = node.getType();
                                          boolean _equals_48 = Objects.equal(_type_12, NodeType.MARKEDNODE);
                                          if (_equals_48) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = \"_nil\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape = \"style = invis\"; ");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(EcoreUtil.create(node.eClass()), style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_42 = node.getShape();
                                              boolean _notEquals_10 = (!Objects.equal(_shape_42, NodeShape.LOAD));
                                              if (_notEquals_10) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_43 = node.getShape();
                                                _builder.append(_shape_43, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_44 = node.getShape();
                                              boolean _equals_49 = Objects.equal(_shape_44, NodeShape.LOAD);
                                              if (_equals_49) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_12 = node.getPathShape();
                                                _builder.append(_pathShape_12, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("rels.add(parameters);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotrels.put(\"_nil -> \" + name, rels);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeType _type_13 = node.getType();
                                          boolean _equals_50 = Objects.equal(_type_13, NodeType.NODE);
                                          if (_equals_50) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"0\";");
                                            _builder.newLine();
                                            {
                                              NodeShape _shape_45 = node.getShape();
                                              boolean _notEquals_11 = (!Objects.equal(_shape_45, NodeShape.LOAD));
                                              if (_notEquals_11) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.shape = \"shape = ");
                                                NodeShape _shape_46 = node.getShape();
                                                _builder.append(_shape_46, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            {
                                              NodeShape _shape_47 = node.getShape();
                                              boolean _equals_51 = Objects.equal(_shape_47, NodeShape.LOAD);
                                              if (_equals_51) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.path = \"");
                                                String _pathShape_13 = node.getPathShape();
                                                _builder.append(_pathShape_13, "\t\t\t");
                                                _builder.append("\";");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        {
                                          NodeShape _shape_48 = node.getShape();
                                          boolean _equals_52 = Objects.equal(_shape_48, NodeShape.RECORD);
                                          if (_equals_52) {
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("if (dotnodes.containsKey(node) == false) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = new LabelStyle();");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("else {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("style = dotnodes.get(node);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.name = name;");
                                            _builder.newLine();
                                            {
                                              NodeStyle _style_12 = node.getStyle();
                                              boolean _equals_53 = Objects.equal(_style_12, NodeStyle.ITALIC);
                                              if (_equals_53) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"I\";");
                                                _builder.newLine();
                                              }
                                            }
                                            {
                                              NodeStyle _style_13 = node.getStyle();
                                              boolean _equals_54 = Objects.equal(_style_13, NodeStyle.UNDERLINE);
                                              if (_equals_54) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("style.style = \"U\";");
                                                _builder.newLine();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.border = \"1\";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("style.shape =\"shape = plaintext, style= filled, fillcolor=");
                                            NodeColor _color_6 = node.getColor();
                                            _builder.append(_color_6, "\t\t\t");
                                            _builder.append("\";");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("dotnodes.put(node, style);");
                                            _builder.newLine();
                                          }
                                        }
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            {
                              EList<EReference> _reference = node.getReference();
                              boolean _tripleNotEquals_4 = (_reference != null);
                              if (_tripleNotEquals_4) {
                                {
                                  int _size_2 = node.getReference().size();
                                  boolean _greaterThan_1 = (_size_2 > 0);
                                  if (_greaterThan_1) {
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("Map<EObject, String> table = new HashMap<EObject, String>();");
                                    _builder.newLine();
                                    {
                                      EList<EReference> _reference_1 = node.getReference();
                                      for(final EReference ref : _reference_1) {
                                        {
                                          EList<Content> _contents = draw.getInstances().get(0).getContents();
                                          boolean _tripleNotEquals_5 = (_contents != null);
                                          if (_tripleNotEquals_5) {
                                            {
                                              int _size_3 = draw.getInstances().get(0).getContents().size();
                                              boolean _greaterThan_2 = (_size_3 > 0);
                                              if (_greaterThan_2) {
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("for (EReference ref : node.eClass().getEAllReferences()) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("String label = \"\";");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("List<EClass> classes = null;");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("EClass cl = null;");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("if (ref.getName().equals(\"");
                                                String _name_5 = ref.getName();
                                                _builder.append(_name_5, "\t\t\t\t");
                                                _builder.append("\")) {");
                                                _builder.newLineIfNotEmpty();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t");
                                                _builder.append("//COUNT SET:");
                                                int count = 0;
                                                _builder.newLineIfNotEmpty();
                                                {
                                                  EList<Content> _contents_1 = draw.getInstances().get(0).getContents();
                                                  for(final Content content : _contents_1) {
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("//COUNT INC: ");
                                                    int _plusPlus = count++;
                                                    _builder.append(_plusPlus, "\t\t\t\t\t");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("classes = new ArrayList<EClass>();");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("cl = ModelManager.getEClassByName(packages, \"");
                                                    String _name_6 = content.getName().getName();
                                                    _builder.append(_name_6, "\t\t\t\t\t");
                                                    _builder.append("\");");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("classes.addAll(cl.getESuperTypes());");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("classes.add(cl);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("for (EClass c : classes) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t");
                                                    _builder.append("if (c.getName().equals(ref.getEType().getName())) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("String text = \"\";");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("if (ref.getUpperBound() < 0 || ref.getUpperBound() > 1) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("List<EObject> lobj = (List<EObject>) node.eGet(ref);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("if (lobj != null) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t");
                                                    _builder.append("for (EObject obj : lobj) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("if (obj != null) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("if (obj.eClass().getName().equals(\"");
                                                    String _name_7 = content.getName().getName();
                                                    _builder.append(_name_7, "\t\t\t\t\t\t\t\t\t\t\t");
                                                    _builder.append("\")) {");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("if (table.containsKey(obj) == false) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("table.put(obj, \"\");");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    CharSequence _compile = this.compile(content, "table");
                                                    _builder.append(_compile, "\t\t\t\t\t\t\t\t\t\t\t\t");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("if (label.length() > 0) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("if (label.endsWith(\"<TR>\") == true) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t\t");
                                                    _builder.append("label = label + \"<TD>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("else {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t\t");
                                                    _builder.append("label = label + \"<BR/>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("else {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t\t");
                                                    _builder.append("label = \"<TD>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("else {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("EObject obj = (EObject) node.eGet(ref);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("if (obj != null) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t");
                                                    _builder.append("if (obj.eClass().getName().equals(\"");
                                                    String _name_8 = content.getName().getName();
                                                    _builder.append(_name_8, "\t\t\t\t\t\t\t\t\t");
                                                    _builder.append("\")) {");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("if (table.containsKey(obj) == false) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("table.put(obj, \"\");");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    CharSequence _compile_1 = this.compile(content, "table");
                                                    _builder.append(_compile_1, "\t\t\t\t\t\t\t\t\t\t");
                                                    _builder.newLineIfNotEmpty();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("if (label.length() > 0) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("if (label.endsWith(\"<TR>\") == true) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("label = label + \"<TD>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("else {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t\t");
                                                    _builder.append("label = label + \"<BR/>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("else {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t\t");
                                                    _builder.append("label = \"<TD>\" + table.get(obj);");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("if (label.length() > 0) {");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t");
                                                    _builder.append("label = label + \"</TD></TR><TR>\";");
                                                    _builder.newLine();
                                                    _builder.append("\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("\t\t");
                                                    _builder.append("}");
                                                    _builder.newLine();
                                                  }
                                                }
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t");
                                                _builder.append("if (dotnodes.containsKey(node) == true) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t\t");
                                                _builder.append("if (dotnodes.get(node) != null) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t\t\t");
                                                _builder.append("LabelStyle style = dotnodes.get(node);");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t\t\t");
                                                _builder.append("style.label = style.label + label;");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t\t\t");
                                                _builder.append("dotnodes.put(node, style);");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t\t");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("}");
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
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("}");
                _builder.newLine();
                _builder.append("// INC COUNTER: ");
                _builder.append(counter = (counter + 1));
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("for (EObject dotnode : dotnodes.keySet()) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (dotnodes.get(dotnode) != null) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("LabelStyle style = dotnodes.get(dotnode);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("if (style.style.length() == 0) {");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("if (style.label.length() == 0) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.path.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.shape + \", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD>\" + style.name + \"</TD></TR></TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = \"image=\\\"\" + style.path + \"\\\", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD></TD></TR></TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.label.endsWith(\"<TR>\")) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.label.substring(0, style.label.length() - 4);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.label.endsWith(\"<TR></TD></TR>\")) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.label.substring(0, style.label.length() - 14);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.path.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.shape + \", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD>\" + style.name + \"</TD></TR><TR>\" + style.label + \"</TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = \"image=\\\"\" + style.path + \"\\\", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD></TD></TR><TR>\" + style.label + \"</TABLE>>\";");
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
            _builder.append("\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("if (style.label.length() == 0) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.path.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.shape + \", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD><\" + style.style + \">\" + style.name + \"</\" + style.style + \"></TD></TR></TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = \"image=\\\"\" + style.path + \"\\\", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD><\" + style.style + \"><TR><TD><\" + style.style + \"></\" + style.style + \"></TD></TR></TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.label.endsWith(\"<TR>\")) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.label.substring(0, style.label.length() - 4);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.label.endsWith(\"<TR></TD></TR>\")) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.label.substring(0, style.label.length() - 14);");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("if (style.path.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = style.shape + \", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD><\" + style.style + \">\" + style.name + \"</\" + style.style + \"></TD></TR><TR>\" + style.label + \"</TABLE>>\";");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t");
            _builder.append("style.label = \"image=\\\"\" + style.path + \"\\\", label=<<TABLE BORDER=\\\"0\\\" CELLBORDER=\\\"\" + style.border + \"\\\" CELLSPACING=\\\"0\\\"><TR><TD><\" + style.style + \"></TD></TR><TR><TD><\" + style.style + \"></\" + style.style + \"></TD></TR><TR>\" + style.label + \"</TABLE>>\";");
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
            _builder.append("\t\t\t");
            _builder.append("dotnodes.put(dotnode, style);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Relation> _relations = draw.getInstances().get(0).getRelations();
      boolean _tripleNotEquals_6 = (_relations != null);
      if (_tripleNotEquals_6) {
        {
          int _size_4 = draw.getInstances().get(0).getRelations().size();
          boolean _greaterThan_3 = (_size_4 > 0);
          if (_greaterThan_3) {
            _builder.append("\t");
            _builder.append("private void generateRelations(Resource model, Map<String, List<Map<String, String>>> dotrels, Map<String, List<String>> dottext) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// COUNTER: ");
            int counter_1 = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<Relation> _relations_1 = draw.getInstances().get(0).getRelations();
              for(final Relation rel : _relations_1) {
                {
                  if ((rel instanceof Edge)) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//");
                    Edge edge = ((Edge) rel);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<EObject> ledge_");
                    _builder.append(counter_1, "\t\t");
                    _builder.append(" = ModelManager.getObjectsOfType(\"");
                    String _name_9 = edge.getName().getName();
                    _builder.append(_name_9, "\t\t");
                    _builder.append("\", model);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("for (EObject edge : ledge_");
                    _builder.append(counter_1, "\t\t");
                    _builder.append(") {");
                    _builder.newLineIfNotEmpty();
                    {
                      EList<ValuedFeature> _feature_2 = edge.getFeature();
                      boolean _tripleNotEquals_7 = (_feature_2 != null);
                      if (_tripleNotEquals_7) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("boolean valid = true;");
                        _builder.newLine();
                        {
                          EList<ValuedFeature> _feature_3 = edge.getFeature();
                          for(final ValuedFeature feat_1 : _feature_3) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("for (EStructuralFeature feat : edge.eClass().getEAllStructuralFeatures()) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (feat.getName().equals(\"");
                            String _name_10 = feat_1.getFeat().getName();
                            _builder.append(_name_10, "\t\t\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("Object featObject = edge.eGet(feat);");
                            _builder.newLine();
                            {
                              EStructuralFeature _feat_2 = feat_1.getFeat();
                              if ((_feat_2 instanceof EAttribute)) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (featObject instanceof Boolean) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("Boolean value = (Boolean) featObject;");
                                _builder.newLine();
                                {
                                  boolean _isNegation_3 = feat_1.isNegation();
                                  boolean _equals_55 = (_isNegation_3 == true);
                                  if (_equals_55) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("if (value != false) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  } else {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("if (value != true) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            {
                              EStructuralFeature _feat_3 = feat_1.getFeat();
                              if ((_feat_3 instanceof EReference)) {
                                {
                                  EStructuralFeature _refFeature_2 = feat_1.getRefFeature();
                                  boolean _tripleEquals_1 = (_refFeature_2 == null);
                                  if (_tripleEquals_1) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("Boolean value = (featObject == null);");
                                    _builder.newLine();
                                    {
                                      if (((feat_1.getValue() != null) && feat_1.getValue().equals("null"))) {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (value != true) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("valid = false;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      } else {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (value != false) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("valid = false;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            {
                              EStructuralFeature _refFeature_3 = feat_1.getRefFeature();
                              boolean _tripleNotEquals_8 = (_refFeature_3 != null);
                              if (_tripleNotEquals_8) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (featObject instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t");
                                _builder.append("if (refFeature.getName().equals(\"");
                                String _name_11 = feat_1.getRefFeature().getName();
                                _builder.append(_name_11, "\t\t\t\t\t\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t");
                                _builder.append("Object refFeatureObject = ((EObject) featObject).eGet(refFeature);");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t");
                                _builder.append("if (refFeatureObject instanceof Boolean) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t\t");
                                _builder.append("Boolean value = (Boolean) refFeatureObject;");
                                _builder.newLine();
                                {
                                  boolean _isNegation_4 = feat_1.isNegation();
                                  boolean _equals_56 = (_isNegation_4 == true);
                                  if (_equals_56) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (value != false) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  } else {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (value != true) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t");
                                _builder.append("else {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t\t");
                                _builder.append("Boolean value = (refFeatureObject == null);");
                                _builder.newLine();
                                {
                                  if (((feat_1.getValue() != null) && feat_1.getValue().equals("null"))) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (value != true) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  } else {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (value != false) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valid = false;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("if (valid != true) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("continue;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("Map<String, String> parameters = new LinkedHashMap<String, String>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<Map<String, String>> rels = new ArrayList<Map<String, String>>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<String> source = new ArrayList<String>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<String> target = new ArrayList<String>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("String label = \"\";");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("String src_label = \"\";");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("String tar_label = \"\";");
                    _builder.newLine();
                    {
                      EClass _targetNode = edge.getTargetNode();
                      boolean _tripleEquals_2 = (_targetNode == null);
                      if (_tripleEquals_2) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("for (EReference ref : edge.eClass().getEAllReferences()) {");
                        _builder.newLine();
                        {
                          EReference _source = edge.getSource();
                          boolean _tripleNotEquals_9 = (_source != null);
                          if (_tripleNotEquals_9) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (ref.getName().equals(\"");
                            String _name_12 = edge.getSource().getName();
                            _builder.append(_name_12, "\t\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("EObject src = (EObject) edge.eGet(ref);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (src != null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("for (EAttribute att : src.eClass().getEAllAttributes()) {");
                            _builder.newLine();
                            {
                              EAttribute _attName_1 = edge.getAttName();
                              boolean _tripleNotEquals_10 = (_attName_1 != null);
                              if (_tripleNotEquals_10) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (att.getName().equals(\"");
                                String _name_13 = edge.getAttName().getName();
                                _builder.append(_name_13, "\t\t\t\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (att.getName().equals(\"name\")) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("source.add((String) src.eGet(att));");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("break;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        {
                          EReference _target = edge.getTarget();
                          boolean _tripleNotEquals_11 = (_target != null);
                          if (_tripleNotEquals_11) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (ref.getName().equals(\"");
                            String _name_14 = edge.getTarget().getName();
                            _builder.append(_name_14, "\t\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("EObject tar = (EObject) edge.eGet(ref);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (tar != null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("for (EAttribute att : tar.eClass().getEAllAttributes()) {");
                            _builder.newLine();
                            {
                              EAttribute _attName_2 = edge.getAttName();
                              boolean _tripleNotEquals_12 = (_attName_2 != null);
                              if (_tripleNotEquals_12) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (att.getName().equals(\"");
                                String _name_15 = edge.getAttName().getName();
                                _builder.append(_name_15, "\t\t\t\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("if (att.getName().equals(\"name\")) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("target.add((String) tar.eGet(att));");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("break;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      EClass _targetNode_1 = edge.getTargetNode();
                      boolean _tripleNotEquals_13 = (_targetNode_1 != null);
                      if (_tripleNotEquals_13) {
                        _builder.append("\t");
                        _builder.append("List<EObject> targetNodes = ModelManager.getConnectedObjectsOfType(\"");
                        String _name_16 = edge.getTargetNode().getName();
                        _builder.append(_name_16, "\t");
                        _builder.append("\", edge);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("for (EObject targetNode : targetNodes) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("EObject featObject = null;");
                        _builder.newLine();
                        {
                          EList<ValuedFeature> _targetFeature = edge.getTargetFeature();
                          boolean _tripleNotEquals_14 = (_targetFeature != null);
                          if (_tripleNotEquals_14) {
                            _builder.append("\t");
                            _builder.append("boolean targetValid = true;");
                            _builder.newLine();
                            {
                              EList<ValuedFeature> _targetFeature_1 = edge.getTargetFeature();
                              for(final ValuedFeature feat_2 : _targetFeature_1) {
                                _builder.append("\t");
                                _builder.append("for (EStructuralFeature feat : targetNode.eClass().getEAllStructuralFeatures()) {");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("if (feat.getName().equals(\"");
                                String _name_17 = feat_2.getFeat().getName();
                                _builder.append(_name_17, "\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("Object ob = targetNode.eGet(feat);");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("if (ob instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("featObject = (EObject) ob;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("} ");
                                _builder.newLine();
                                {
                                  EStructuralFeature _feat_4 = feat_2.getFeat();
                                  if ((_feat_4 instanceof EAttribute)) {
                                    _builder.append("\t");
                                    _builder.append("if (featObject instanceof Boolean) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("Boolean value = (Boolean) featObject;");
                                    _builder.newLine();
                                    {
                                      boolean _isNegation_5 = feat_2.isNegation();
                                      boolean _equals_57 = (_isNegation_5 == true);
                                      if (_equals_57) {
                                        _builder.append("\t");
                                        _builder.append("if (value != false) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      } else {
                                        _builder.append("\t");
                                        _builder.append("if (value != true) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                {
                                  EStructuralFeature _feat_5 = feat_2.getFeat();
                                  if ((_feat_5 instanceof EReference)) {
                                    {
                                      EStructuralFeature _refFeature_4 = feat_2.getRefFeature();
                                      boolean _tripleEquals_3 = (_refFeature_4 == null);
                                      if (_tripleEquals_3) {
                                        _builder.append("\t\t");
                                        _builder.append("Boolean value = (featObject == null);");
                                        _builder.newLine();
                                        {
                                          if (((feat_2.getValue() != null) && feat_2.getValue().equals("null"))) {
                                            _builder.append("\t\t");
                                            _builder.append("if (value != true) {");
                                            _builder.newLine();
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("targetValid = false;");
                                            _builder.newLine();
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                          } else {
                                            _builder.append("\t\t");
                                            _builder.append("if (value != false) {");
                                            _builder.newLine();
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("targetValid = false;");
                                            _builder.newLine();
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                                {
                                  EStructuralFeature _refFeature_5 = feat_2.getRefFeature();
                                  boolean _tripleNotEquals_15 = (_refFeature_5 != null);
                                  if (_tripleNotEquals_15) {
                                    _builder.append("\t\t");
                                    _builder.append("if (featObject instanceof EObject) {");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t");
                                    _builder.append("if (refFeature.getName().equals(\"");
                                    String _name_18 = feat_2.getRefFeature().getName();
                                    _builder.append(_name_18, "\t\t\t\t");
                                    _builder.append("\")) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t");
                                    _builder.append("Object refFeatureObject = ((EObject) featObject).eGet(refFeature);");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t");
                                    _builder.append("if (refFeatureObject instanceof Boolean) {");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("Boolean value = (Boolean) refFeatureObject;");
                                    _builder.newLine();
                                    {
                                      boolean _isNegation_6 = feat_2.isNegation();
                                      boolean _equals_58 = (_isNegation_6 == true);
                                      if (_equals_58) {
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("if (value != false) {");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      } else {
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("if (value != true) {");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t");
                                    _builder.append("else {");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t\t");
                                    _builder.append("Boolean value = (refFeatureObject == null);");
                                    _builder.newLine();
                                    {
                                      if (((feat_2.getValue() != null) && feat_2.getValue().equals("null"))) {
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("if (value != true) {");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      } else {
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("if (value != false) {");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("\t");
                                        _builder.append("targetValid = false;");
                                        _builder.newLine();
                                        _builder.append("\t\t");
                                        _builder.append("\t\t\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("\t\t");
                                    _builder.append("\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("if (targetValid == false) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("continue;");
                            _builder.newLine();
                            _builder.append("}\t");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("EObject src = null;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("EObject tar = null;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (featObject == null) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("src = edge;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("tar = targetNode;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("src = targetNode;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("tar = featObject;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("String srcName = \"\";");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (src != null) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("for (EAttribute att : src.eClass().getEAllAttributes()) {");
                        _builder.newLine();
                        {
                          EAttribute _attName_3 = edge.getAttName();
                          boolean _tripleNotEquals_16 = (_attName_3 != null);
                          if (_tripleNotEquals_16) {
                            _builder.append("\t\t");
                            _builder.append("if (att.getName().equals(\"");
                            String _name_19 = edge.getAttName().getName();
                            _builder.append(_name_19, "\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("if (att.getName().equals(\"name\")) {");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t\t\t");
                        _builder.append("srcName = (String) src.eGet(att);");
                        _builder.newLine();
                        _builder.append("\t\t\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("String tarName = \"\";");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (tar != null) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("for (EAttribute att : tar.eClass().getEAllAttributes()) {");
                        _builder.newLine();
                        {
                          EAttribute _attName_4 = edge.getAttName();
                          boolean _tripleNotEquals_17 = (_attName_4 != null);
                          if (_tripleNotEquals_17) {
                            _builder.append("\t\t");
                            _builder.append("if (att.getName().equals(\"");
                            String _name_20 = edge.getAttName().getName();
                            _builder.append(_name_20, "\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("if (att.getName().equals(\"name\")) {");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t\t\t");
                        _builder.append("tarName = (String) tar.eGet(att);");
                        _builder.newLine();
                        _builder.append("\t\t\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("if (!srcName.isEmpty() && !tarName.isEmpty() && !source.contains(srcName)) { //&& !target.contains(tarName)) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("source.add(srcName);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("target.add(tarName);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      EList<EReference> _reference_2 = edge.getReference();
                      boolean _tripleNotEquals_18 = (_reference_2 != null);
                      if (_tripleNotEquals_18) {
                        {
                          if ((((edge.getLabel() != null) || (edge.getSrc_label() != null)) || (edge.getTar_label() != null))) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("label += \"\\\"\";");
                            _builder.newLine();
                            {
                              int _size_5 = edge.getReference().size();
                              boolean _greaterThan_4 = (_size_5 > 0);
                              if (_greaterThan_4) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("for (EReference ref : edge.eClass().getEAllReferences()) {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                int i = 0;
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                int j = 0;
                                _builder.newLineIfNotEmpty();
                                {
                                  EList<EReference> _reference_3 = edge.getReference();
                                  for(final EReference reference : _reference_3) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (ref.getName().equals(\"");
                                    String _name_21 = reference.getName();
                                    _builder.append(_name_21, "\t\t\t");
                                    _builder.append("\")) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("EObject obj = (EObject) edge.eGet(ref);");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (obj != null) {");
                                    _builder.newLine();
                                    {
                                      if (((edge.getLabel() != null) && (edge.getLabel().size() > i))) {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        boolean found = false;
                                        _builder.newLineIfNotEmpty();
                                        {
                                          EList<EAttribute> _eAllAttributes = reference.getEReferenceType().getEAllAttributes();
                                          for(final EAttribute att : _eAllAttributes) {
                                            {
                                              boolean _equals_59 = att.getName().equals(edge.getLabel().get(i).getName());
                                              if (_equals_59) {
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("for (EAttribute att : obj.eClass().getEAllAttributes()) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("    ");
                                                _builder.append("if (att.getName().equals(\"");
                                                String _name_22 = edge.getLabel().get(i).getName();
                                                _builder.append(_name_22, "\t\t\t\t\t    ");
                                                _builder.append("\")) {");
                                                _builder.newLineIfNotEmpty();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t    ");
                                                _builder.append("if (att.getEType().getName().equals(\"EString\")) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t    ");
                                                _builder.append("label += (String) obj.eGet(att) + \", \";");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t    ");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t    ");
                                                _builder.append("if (att.getEType() instanceof EEnum) {");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t    ");
                                                _builder.append("EEnumLiteral value = (EEnumLiteral) obj.eGet(att);");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t\t    ");
                                                _builder.append("label += value.getName() + \", \";");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t    ");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("    ");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("}");
                                                _builder.newLine();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("//");
                                                _builder.append(found = true, "\t\t\t\t\t");
                                                _builder.newLineIfNotEmpty();
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("//");
                                                int _plusPlus_1 = i++;
                                                _builder.append(_plusPlus_1, "\t\t\t\t\t");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                          }
                                        }
                                        {
                                          if ((found == false)) {
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("for (EReference refType : obj.eClass().getEAllReferences()) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t");
                                            _builder.append("//");
                                            String refTypeName = Decoration.NONE.getLiteral();
                                            _builder.newLineIfNotEmpty();
                                            {
                                              int _size_6 = edge.getRefType().size();
                                              boolean _greaterThan_5 = (_size_6 > j);
                                              if (_greaterThan_5) {
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t");
                                                _builder.append("\t\t");
                                                _builder.append("\t");
                                                _builder.append("//");
                                                _builder.append(refTypeName = edge.getRefType().get(j).getName(), "\t\t\t\t\t\t");
                                                _builder.newLineIfNotEmpty();
                                              }
                                            }
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    ");
                                            _builder.append("if (refType.getName().equals(\"");
                                            _builder.append(refTypeName, "\t\t\t\t\t    ");
                                            _builder.append("\")) {");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    \t");
                                            _builder.append("EObject o = (EObject) ((EObject) edge.eGet(ref)).eGet(refType);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    \t");
                                            _builder.append("if (o != null) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    \t    ");
                                            _builder.append("for (EAttribute att : o.eClass().getEAllAttributes()) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    \t\t    ");
                                            _builder.append("if (att.getName().equals(\"");
                                            String _name_23 = edge.getLabel().get(i).getName();
                                            _builder.append(_name_23, "\t\t\t\t\t    \t\t    ");
                                            _builder.append("\")) {");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t    \t        ");
                                            _builder.append("if (att.getEType().getName().equals(\"EString\")) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t\t    \t        ");
                                            _builder.append("label += (String) o.eGet(att) + \", \";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t    \t        ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t    \t        ");
                                            _builder.append("if (att.getEType() instanceof EEnum) {");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t\t    \t        ");
                                            _builder.append("EEnumLiteral value = (EEnumLiteral) o.eGet(att);");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t\t    \t        ");
                                            _builder.append("label += value.getName() + \", \";");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t\t    \t    ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t    \t    ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t        ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("\t    ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("    ");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("}");
                                            _builder.newLine();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("//");
                                            int _plusPlus_2 = i++;
                                            _builder.append(_plusPlus_2, "\t\t\t\t\t");
                                            _builder.newLineIfNotEmpty();
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t");
                                            _builder.append("\t\t");
                                            _builder.append("//");
                                            int _plusPlus_3 = j++;
                                            _builder.append(_plusPlus_3, "\t\t\t\t\t");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                      }
                                    }
                                    {
                                      EAttribute _src_label = edge.getSrc_label();
                                      boolean _tripleNotEquals_19 = (_src_label != null);
                                      if (_tripleNotEquals_19) {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (att.getName().equals(\"");
                                        String _name_24 = edge.getSrc_label().getName();
                                        _builder.append(_name_24, "\t\t\t\t\t");
                                        _builder.append("\")) {");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("src_label = \"\\\"\" + (String) obj.eGet(att) + \"\\\"\";");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    {
                                      EAttribute _tar_label = edge.getTar_label();
                                      boolean _tripleNotEquals_20 = (_tar_label != null);
                                      if (_tripleNotEquals_20) {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("if (att.getName().equals(\"");
                                        String _name_25 = edge.getTar_label().getName();
                                        _builder.append(_name_25, "\t\t\t\t\t");
                                        _builder.append("\")) {");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("\t");
                                        _builder.append("tar_label = \"\\\"\" + (String) obj.eGet(att) + \"\\\"\";");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                      }
                                    }
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (label.indexOf(\",\") > 0) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("label = label.substring(0, label.lastIndexOf(\",\"));");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("label += \"\\\"\";");
                            _builder.newLine();
                          }
                        }
                      } else {
                        {
                          if ((((edge.getLabel() != null) || (edge.getSrc_label() != null)) || (edge.getTar_label() != null))) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("label = \"\\\"\";");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("for (EAttribute att : edge.eClass().getEAllAttributes()) {");
                            _builder.newLine();
                            {
                              if (((edge.getLabel() != null) && (edge.getLabel().size() > 0))) {
                                _builder.append("\t");
                                _builder.append("\t");
                                int i_1 = 0;
                                _builder.newLineIfNotEmpty();
                                {
                                  EList<EAttribute> _label = edge.getLabel();
                                  for(final EAttribute label : _label) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (att.getName().equals(\"");
                                    String _name_26 = label.getName();
                                    _builder.append(_name_26, "\t\t");
                                    _builder.append("\")) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (att.getEType().getName().equals(\"EString\")) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("label += (String) edge.eGet(att) + \", \";");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (att.getEType() instanceof EEnum) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("EEnumLiteral value = (EEnumLiteral) obj.eGet(att);");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t\t");
                                    _builder.append("label += value.getName() + \", \";");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("//");
                                    int _plusPlus_4 = i_1++;
                                    _builder.append(_plusPlus_4, "\t\t");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            {
                              EAttribute _src_label_1 = edge.getSrc_label();
                              boolean _tripleNotEquals_21 = (_src_label_1 != null);
                              if (_tripleNotEquals_21) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("if (att.getName().equals(\"");
                                String _name_27 = edge.getSrc_label().getName();
                                _builder.append(_name_27, "\t\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("src_label = \"\\\"\" + (String) edge.eGet(att) + \"\\\"\";");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            {
                              EAttribute _tar_label_1 = edge.getTar_label();
                              boolean _tripleNotEquals_22 = (_tar_label_1 != null);
                              if (_tripleNotEquals_22) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("if (att.getName().equals(\"");
                                String _name_28 = edge.getTar_label().getName();
                                _builder.append(_name_28, "\t\t\t");
                                _builder.append("\")) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("tar_label = \"\\\"\" + (String) edge.eGet(att) + \"\\\"\";");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("if (label.indexOf(\",\") > 0) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("label = label.substring(0, label.lastIndexOf(\",\"));");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("label += \"\\\"\"; ");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    CharSequence _decorate = this.decorate(edge);
                    _builder.append(_decorate, "\t\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (source.size() == target.size()) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("for (int i = 0; i < source.size() && i < target.size(); i++) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("if (dotrels.containsKey(source.get(i) + \"->\" + target.get(i)) == true) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels = dotrels.get(source.get(i) + \"->\" + target.get(i));");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels = new ArrayList<Map<String, String>>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("boolean found = false;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("for (Map<String, String> rel : rels) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("for (String key : rel.keySet()) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("if (key.equals(\"label\")) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("for (String keyParameters : parameters.keySet()) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("if (key.equals(keyParameters)) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t");
                    _builder.append("if (parameters.get(keyParameters).length() > 1) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("String value = rel.get(key);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("if (value.length() > 0) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t\t");
                    _builder.append("value = value.substring(0, value.length() - 1);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("value += \"\\n\" + parameters.get(keyParameters).substring(1, parameters.get(keyParameters).length());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("rel.put(key, value);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("found = true;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("if (found == false) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels.add(parameters);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("dotrels.put(source.get(i) + \"->\" + target.get(i), rels);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("for (int i = 0; i < source.size(); i++) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("if (dotrels.containsKey(source.get(i) + \"->\" + target.get(i)) == true) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels = dotrels.get(source.get(i) + \"->\" + target.get(i));");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels = new ArrayList<Map<String, String>>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("boolean found = false;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("for (Map<String, String> rel : rels) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("for (String key : rel.keySet()) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("if (key.equals(\"label\")) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("for (String keyParameters : parameters.keySet()) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("if (key.equals(keyParameters)) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t");
                    _builder.append("if (parameters.get(keyParameters).length() > 1) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("String value = rel.get(key);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("if (value.length() > 0) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t\t");
                    _builder.append("value = value.substring(0, value.length() - 1);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("value += \"\\n\" + parameters.get(keyParameters).substring(1, parameters.get(keyParameters).length());");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("rel.put(key, value);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t\t");
                    _builder.append("found = true;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("if (found == false) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("rels.add(parameters);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("dotrels.put(source.get(i) + \"->\" + target.get(i), rels);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  if ((rel instanceof Level)) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//");
                    Level level = ((Level) rel);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<EObject> llevel_");
                    _builder.append(counter_1, "\t\t");
                    _builder.append(" = ModelManager.getObjectsOfType(\"");
                    String _name_29 = level.getName().getName();
                    _builder.append(_name_29, "\t\t");
                    _builder.append("\", model);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("for (EObject level : llevel_");
                    _builder.append(counter_1, "\t\t");
                    _builder.append(") {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("Map<String, String> parameters = new LinkedHashMap<String, String>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<Map<String, String>> rels = new ArrayList<Map<String, String>>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("String source = \"\";");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("List<String> target = new ArrayList<String>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("for (EAttribute att : level.eClass().getEAllAttributes()) {");
                    _builder.newLine();
                    {
                      EAttribute _attName_5 = level.getAttName();
                      boolean _tripleNotEquals_23 = (_attName_5 != null);
                      if (_tripleNotEquals_23) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("if (att.getName().equals(\"");
                        String _name_30 = level.getAttName().getName();
                        _builder.append(_name_30, "\t\t\t\t");
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("if (att.getName().equals(\"name\")) {");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("source = (String) level.eGet(att);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("break;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("for (EReference ref : level.eClass().getEAllReferences()) {");
                    _builder.newLine();
                    {
                      EReference _upper = level.getUpper();
                      boolean _tripleNotEquals_24 = (_upper != null);
                      if (_tripleNotEquals_24) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("if (ref.getName().equals(\"");
                        String _name_31 = level.getUpper().getName();
                        _builder.append(_name_31, "\t\t\t\t");
                        _builder.append("\")) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("if (ref.getUpperBound() < 0 || ref.getUpperBound() > 1) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("List<EObject> ltar = (List<EObject>) level.eGet(ref);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("if (ltar != null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t");
                        _builder.append("for (EObject otar : ltar) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("if (otar != null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("for (EAttribute att : otar.eClass().getEAllAttributes()) {");
                        _builder.newLine();
                        {
                          EAttribute _attName_6 = level.getAttName();
                          boolean _tripleNotEquals_25 = (_attName_6 != null);
                          if (_tripleNotEquals_25) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("if (att.getName().equals(\"");
                            String _name_32 = level.getAttName().getName();
                            _builder.append(_name_32, "\t\t\t\t\t\t\t\t\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("if (att.getName().equals(\"name\")) {");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t");
                        _builder.append("target.add((String) otar.eGet(att));");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("EObject tar = (EObject) level.eGet(ref);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("if (tar != null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t");
                        _builder.append("for (EAttribute att : tar.eClass().getEAllAttributes()) {");
                        _builder.newLine();
                        {
                          EAttribute _attName_7 = level.getAttName();
                          boolean _tripleNotEquals_26 = (_attName_7 != null);
                          if (_tripleNotEquals_26) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t\t\t");
                            _builder.append("if (att.getName().equals(\"");
                            String _name_33 = level.getAttName().getName();
                            _builder.append(_name_33, "\t\t\t\t\t\t\t");
                            _builder.append("\")) {");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t\t\t");
                            _builder.append("if (att.getName().equals(\"name\")) {");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("target.add((String) tar.eGet(att));");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    CharSequence _decorate_1 = this.decorate(level);
                    _builder.append(_decorate_1, "\t\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("for (String tar : target) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("if ((source != null) && (tar != null)) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("if (source.length() > 0 && tar.length() > 0) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("if (dotrels.containsKey(source + \"->\" + tar) == true) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("rels = dotrels.get(source + \"->\" + tar);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("rels = new ArrayList<Map<String, String>>();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("if (source.length() > 0 && tar.length() > 0) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("if (rels.contains(parameters) == false) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("rels.add(parameters);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t\t");
                    _builder.append("dotrels.put(source + \"->\" + tar, rels);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("// COUNTER: ");
                _builder.append(counter_1 = (counter_1 + 1), "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("for (String relname : dotrels.keySet()) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("List<Map<String, String>> rels = dotrels.get(relname);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("for (Map<String, String> params : rels) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("int i = 0;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("String config = \"\";");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("for (String key : params.keySet()) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("if (i == 0) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("if (params.get(key) != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("if (params.get(key).length() > 0) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("config = key + \"=\" + params.get(key);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("i++;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("if (params.get(key) != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("if (params.get(key).length() > 0) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("config = config + \", \" + key + \"=\" + params.get(key);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("i++;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("List<String> lconf = null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("if (dottext.containsKey(relname) == true) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("lconf = dottext.get(relname);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("else {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("lconf = new ArrayList<String>();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("lconf.add(config);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("dottext.put(relname, lconf);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void generateGraphs(File file, String folder, List<EPackage> packages, File exercise, String projectName, IProgressMonitor monitor) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (file.isFile()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String pathfile = file.getPath();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (pathfile.endsWith(\".model\") == true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String printPathfile = pathfile.replace(\"\\\\\", \"/\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("printPathfile = printPathfile.substring(printPathfile.lastIndexOf(\"/\" + projectName + \"/\") + (\"/\" + projectName + \"/\").length(), printPathfile.length());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("monitor.subTask(\"Rendering image for mutant \" + printPathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Resource model = ModelManager.loadModel(packages, pathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String path = exercise.getName() + \"/\";");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("List<String> folders = Arrays.asList(folder.split(\"/\"));");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (folders.size() > 0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("for (String folderName : folders) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("path += folderName + \"/\";");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String dotfile = \"");
    _builder.append(folder, "\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + path + \"");
    String _name_34 = this.roots.get(0).getName();
    _builder.append(_name_34, "\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".dot\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("String pngfile = \"");
    _builder.append(folder, "\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + path + \"");
    String _name_35 = this.roots.get(0).getName();
    _builder.append(_name_35, "\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".png\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    CharSequence _generate = this.generate(draw, folder);
    _builder.append(_generate, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("File exercisefolder = new File(\"");
    _builder.append(folder, "\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + path);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("if (exercisefolder.exists() != true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("exercisefolder.mkdirs();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("PrintWriter dotwriter = new PrintWriter(dotfile, \"UTF-8\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (String dotline : dotcode) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("dotwriter.println(dotline);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("dotwriter.close();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String[] command = {\"dot\", \"-Tpng\", dotfile, \"-o\", pngfile};");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Process proc = Runtime.getRuntime().exec(command);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("proc.waitFor(); ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("//Reload input");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("model.load(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (Exception e) {}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("monitor.worked(1);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (file.getName().equals(\"registry\") != true && !file.getName().endsWith(\"vs\")) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("File[] filesBlock = file.listFiles();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (File fileBlock : filesBlock) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("generateGraphs(fileBlock, folder + file.getName(), packages, exercise, projectName, monitor);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void generate(IProgressMonitor monitor) throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String metamodel = \"");
    String _replace_1 = ModelManager.getMetaModel().replace("\\", "/");
    _builder.append(_replace_1, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<EPackage> packages = ModelManager.loadMetaModel(metamodel);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String projectName = ProjectUtils.getProject().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<String> models = ModelManager.getModels();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<String> mutants = ModelManager.getMutants();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int totalTasks = models.size() + mutants.size();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("monitor.beginTask(\"Rendering models\", totalTasks);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// GENERATES PNG FILES FROM SOURCE MODELS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("File folder = new File(\"");
    _builder.append(folder, "\t\t");
    _builder.append("data/model\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (File file : folder.listFiles()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (file.isFile()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String pathfile = file.getPath();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (pathfile.endsWith(\".model\") == true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("String printPathfile = pathfile.replace(\"\\\\\", \"/\");");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("printPathfile = printPathfile.substring(printPathfile.lastIndexOf(\"/\" + projectName + \"/\") + (\"/\" + projectName + \"/\").length(), printPathfile.length());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("monitor.subTask(\"Rendering image for model \" + printPathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Resource model = ModelManager.loadModel(packages, pathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("String dotfile = \"");
    _builder.append(folder, "\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("file.getName().replace(\".model\", \"\") + \"/\" +");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"");
    String _name_36 = this.roots.get(0).getName();
    _builder.append(_name_36, "\t\t\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".dot\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("String pngfile = \"");
    _builder.append(folder, "\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("file.getName().replace(\".model\", \"\") + \"/\" +");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"");
    String _name_37 = this.roots.get(0).getName();
    _builder.append(_name_37, "\t\t\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".png\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    CharSequence _generate_1 = this.generate(draw, folder);
    _builder.append(_generate_1, "\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("File diagramsfolder = new File(\"");
    _builder.append(folder, "\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (diagramsfolder.exists() != true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("diagramsfolder.mkdir();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("File dotfolder = new File(\"");
    _builder.append(folder, "\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("file.getName().replace(\".model\", \"\") + \"/\");");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (dotfolder.exists() != true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("dotfolder.mkdir();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("PrintWriter dotwriter = null;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("dotwriter = new PrintWriter(dotfile, \"UTF-8\");");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("for (String dotline : dotcode) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("dotwriter.println(dotline);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("dotwriter.close();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} catch (UnsupportedEncodingException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("//Reload input");
    _builder.newLine();
    _builder.append("\t    \t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("model.load(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("} catch (Exception ex) {}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("String[] command = {\"dot\", \"-Tpng\", dotfile, \"-o\", pngfile};");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("Process proc = Runtime.getRuntime().exec(command);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("proc.waitFor(); ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("//Reload input");
    _builder.newLine();
    _builder.append("    \t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("model.load(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} catch (Exception e) {}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("monitor.worked(1);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// GENERATES PNG FILES FROM MUTANTS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("folder = new File(\"");
    _builder.append(folder, "\t\t");
    _builder.append("data/out\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (File exercise : folder.listFiles()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (exercise.isDirectory()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (File file : exercise.listFiles()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (file.isFile()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("String pathfile = file.getPath();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if (pathfile.endsWith(\".model\") == true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("String printPathfile = pathfile.replace(\"\\\\\", \"/\");");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("printPathfile = printPathfile.substring(printPathfile.lastIndexOf(\"/\" + projectName + \"/\") + (\"/\" + projectName + \"/\").length(), printPathfile.length());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("monitor.subTask(\"Rendering image for mutant \" + printPathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("Resource model = ModelManager.loadModel(packages, pathfile);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("String dotfile = \"");
    _builder.append(folder, "\t\t\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + exercise.getName() + \"/\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("\"");
    String _name_38 = this.roots.get(0).getName();
    _builder.append(_name_38, "\t\t\t\t\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".dot\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("String pngfile = \"");
    _builder.append(folder, "\t\t\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + exercise.getName() + \"/\" +");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("\"");
    String _name_39 = this.roots.get(0).getName();
    _builder.append(_name_39, "\t\t\t\t\t\t\t");
    _builder.append("_\" + file.getName().replace(\".model\", \".png\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    CharSequence _generate_2 = this.generate(draw, folder);
    _builder.append(_generate_2, "\t\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("File diagramsfolder = new File(\"");
    _builder.append(folder, "\t\t\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("if (diagramsfolder.exists() != true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("diagramsfolder.mkdir();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("File dotfolder = new File(\"");
    _builder.append(folder, "\t\t\t\t\t\t\t");
    _builder.append("src-gen/html/diagrams/\" + exercise.getName() + \"/\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("if (dotfolder.exists() != true) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("dotfolder.mkdir();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("PrintWriter dotwriter = null;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("dotwriter = new PrintWriter(dotfile, \"UTF-8\");");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("for (String dotline : dotcode) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("dotwriter.println(dotline);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("dotwriter.close();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("} catch (UnsupportedEncodingException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("//Reload input");
    _builder.newLine();
    _builder.append("\t    \t\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("model.load(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("} catch (Exception ex) {}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("String[] command = {\"dot\", \"-Tpng\", dotfile, \"-o\", pngfile};");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("Process proc = Runtime.getRuntime().exec(command);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("proc.waitFor(); ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("//Reload input");
    _builder.newLine();
    _builder.append("\t    \t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("model.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("model.load(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("} catch (Exception e) {}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("monitor.worked(1);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if (file.getName().equals(\"registry\") != true && !file.getName().endsWith(\"vs\")) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("File[] filesBlock = file.listFiles();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("for (File fileBlock : filesBlock) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("generateGraphs(fileBlock, file.getName(), packages, exercise, projectName, monitor);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("} catch (UnsupportedEncodingException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("}");
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
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("public Object execute(ExecutionEvent event) throws ExecutionException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RunMutatorDrawWithProgress runMutatorDrawWithProgress = new RunMutatorDrawWithProgress();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ProgressMonitorDialog monitor = new ProgressMonitorDialog(activeShell);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("monitor.run(true, true, runMutatorDrawWithProgress);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (InvocationTargetException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODO Auto-generated catch block");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public void run(IProject project, String filename) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("activeDisplay = new Display();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("activeShell = new Shell(activeDisplay);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("execute(null);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (ExecutionException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//update(project, filename);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
