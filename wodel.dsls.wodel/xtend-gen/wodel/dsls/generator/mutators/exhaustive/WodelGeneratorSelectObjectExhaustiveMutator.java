package wodel.dsls.generator.mutators.exhaustive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.Block;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.Resource;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.dsls.runner.WodelUtils;
import wodel.utils.manager.MutatorUtils;

@SuppressWarnings("all")
public class WodelGeneratorSelectObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      if ((mt instanceof SelectObjectMutator)) {
        _builder.append("\t");
        _builder.append("//");
        SelectObjectMutator mut = ((SelectObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//SELECT OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//");
        boolean rts = false;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        int i = 0;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        int j = 0;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        boolean hasAdditionalResources = MutatorUtils.selectionOriginatesFromAdditionalResources(mut);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        boolean closureHasAdditionalResources = MutatorUtils.closureHasAdditionalResources(mut);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<EPackage> resourcePackages = new ArrayList<EPackage>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<Resource> resources = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return numMutantsGenerated;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          if (((mut.getContainer() != null) && (mut.getContainer() instanceof SpecificObjectSelection))) {
            _builder.append("\t");
            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
            ObSelectionStrategy _container = mut.getContainer();
            String _name = ((SpecificObjectSelection) _container).getObjSel().getName();
            _builder.append(_name, "\t");
            _builder.append(" = null;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("//");
        final List<String> resourceURIs = new ArrayList<String>();
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("//");
        final List<String> ecoreURIs = new ArrayList<String>();
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("//");
        final String resourceName = mut.getObject().getResource();
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("//");
        Resource resource = null;
        _builder.newLineIfNotEmpty();
        {
          EList<Resource> _resources = program.getResources();
          for(final Resource res : _resources) {
            {
              boolean _equals = res.getName().equals(resourceName);
              if (_equals) {
                _builder.append("\t\t\t\t\t\t");
                _builder.append("//");
                _builder.append(resource = res, "\t\t\t\t\t\t");
                _builder.append(" ");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((resource == null)) {
            _builder.append("\t");
            _builder.append("resources.addAll(models);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("resourcePackages.addAll(packages);");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("//");
            final Source source = resource.getPath();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//");
            String _path = project.getLocation().toFile().getPath();
            String _plus = (_path + "/");
            String _path_1 = source.getPath();
            final String resourcePath = (_plus + _path_1);
            _builder.newLineIfNotEmpty();
            {
              File[] _listFiles = new File(resourcePath).listFiles();
              for(final File resourceFile : _listFiles) {
                {
                  boolean _endsWith = resourceFile.getName().endsWith(".model");
                  if (_endsWith) {
                    _builder.append("\t");
                    _builder.append("//");
                    boolean _add = resourceURIs.add(resourceFile.getPath());
                    _builder.append(_add, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _endsWith_1 = resourceFile.getName().endsWith(".ecore");
                  if (_endsWith_1) {
                    _builder.append("\t");
                    _builder.append("//");
                    boolean _add_1 = ecoreURIs.add(resourceFile.getPath());
                    _builder.append(_add_1, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("//");
            final String metamodelPath = resource.getMetamodel().replace("\\", "/");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("String relativeMetamodelPath = \"");
            String _xifexpression = null;
            String _name_1 = project.getName();
            String _plus_1 = ("/" + _name_1);
            String _plus_2 = (_plus_1 + "/");
            int _indexOf = metamodelPath.indexOf(_plus_2);
            boolean _notEquals = (_indexOf != (-1));
            if (_notEquals) {
              String _name_2 = project.getName();
              String _plus_3 = ("/" + _name_2);
              String _plus_4 = (_plus_3 + "/");
              int _lastIndexOf = metamodelPath.lastIndexOf(_plus_4);
              String _name_3 = project.getName();
              int _length = ("/" + _name_3).length();
              int _plus_5 = (_lastIndexOf + _length);
              _xifexpression = metamodelPath.substring(_plus_5);
            } else {
              _xifexpression = metamodelPath;
            }
            _builder.append(_xifexpression, "\t");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("String absoluteMetamodelPath = ");
            _builder.append(className, "\t");
            _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"\") + relativeMetamodelPath;");
            _builder.newLineIfNotEmpty();
            {
              if ((standalone == false)) {
                _builder.append("\t");
                _builder.append("resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, ");
                _builder.append(className, "\t");
                _builder.append(".class);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              for(final String resourceURI : resourceURIs) {
                _builder.append("\t");
                _builder.append("String relativeResourceURI_");
                _builder.append(i, "\t");
                _builder.append(" = \"");
                String _xifexpression_1 = null;
                String _replace = resourceURI.replace("\\", "/");
                String _name_4 = project.getName();
                String _plus_6 = ("/" + _name_4);
                String _plus_7 = (_plus_6 + "/");
                int _indexOf_1 = _replace.indexOf(_plus_7);
                boolean _notEquals_1 = (_indexOf_1 != (-1));
                if (_notEquals_1) {
                  String _replace_1 = resourceURI.replace("\\", "/");
                  String _replace_2 = resourceURI.replace("\\", "/");
                  String _name_5 = project.getName();
                  String _plus_8 = ("/" + _name_5);
                  String _plus_9 = (_plus_8 + "/");
                  int _lastIndexOf_1 = _replace_2.lastIndexOf(_plus_9);
                  String _name_6 = project.getName();
                  int _length_1 = ("/" + _name_6).length();
                  int _plus_10 = (_lastIndexOf_1 + _length_1);
                  _xifexpression_1 = _replace_1.substring(_plus_10);
                } else {
                  _xifexpression_1 = resourceURI;
                }
                _builder.append(_xifexpression_1, "\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("String absoluteResourceURI_");
                _builder.append(i, "\t");
                _builder.append(" = ");
                _builder.append(className, "\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"\") + relativeResourceURI_");
                _builder.append(i, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(\"file:/\" + absoluteResourceURI_");
                _builder.append(i, "\t");
                _builder.append(").toFileString()));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _xblockexpression = null;
                {
                  i++;
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              for(final String ecoreURI : ecoreURIs) {
                _builder.append("\t");
                _builder.append("String relativeEcoreURI_");
                _builder.append(j, "\t");
                _builder.append(" = \"");
                String _replace_3 = ecoreURI.replace("\\", "/");
                String _replace_4 = ecoreURI.replace("\\", "/");
                String _name_7 = project.getName();
                String _plus_11 = ("/" + _name_7);
                String _plus_12 = (_plus_11 + "/");
                int _lastIndexOf_2 = _replace_4.lastIndexOf(_plus_12);
                String _name_8 = project.getName();
                int _length_2 = ("/" + _name_8).length();
                int _plus_13 = (_lastIndexOf_2 + _length_2);
                String _substring = _replace_3.substring(_plus_13);
                _builder.append(_substring, "\t");
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("String absoluteEcoreURI_");
                _builder.append(j, "\t");
                _builder.append(" = ");
                _builder.append(className, "\t");
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"\") + relativeEcoreURI_");
                _builder.append(j, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                {
                  if ((standalone == false)) {
                    _builder.append("\t");
                    _builder.append("resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(\"file:/\" + absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(").toFileString()));");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(\"file:/\" + absoluteEcoreURI_");
                    _builder.append(j, "\t");
                    _builder.append(").toFileString()));");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                String _xblockexpression_1 = null;
                {
                  j++;
                  _xblockexpression_1 = "";
                }
                _builder.append(_xblockexpression_1, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("List<EPackage> selectionPackages = new ArrayList<EPackage>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<Resource> selection = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("selectionPackages.addAll(resourcePackages);");
        _builder.newLine();
        {
          if (((mut.getContainer() == null) && (hasAdditionalResources || closureHasAdditionalResources))) {
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleNotEquals = (_expression != null);
              if (_tripleNotEquals) {
                {
                  ObSelectionStrategy _object = mut.getObject();
                  if ((_object instanceof RandomTypeSelection)) {
                    _builder.append("\t");
                    _builder.newLine();
                  }
                }
                {
                  ObSelectionStrategy _object_1 = mut.getObject();
                  if ((_object_1 instanceof CompleteTypeSelection)) {
                    _builder.append("\t");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
        {
          if (((mut.getContainer() != null) && (hasAdditionalResources || closureHasAdditionalResources))) {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("entry_");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_9 = ((SpecificObjectSelection) _container_2).getObjSel().getName();
                _builder.append(_name_9, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_3 = mut.getContainer();
                String _name_10 = ((SpecificObjectSelection) _container_3).getObjSel().getName();
                _builder.append(_name_10, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_11 = ((SpecificObjectSelection) _container_4).getObjSel().getName();
                _builder.append(_name_11, "\t");
                _builder.append(" == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("selectionPackages = entry_");
                ObSelectionStrategy _container_5 = mut.getContainer();
                String _name_12 = ((SpecificObjectSelection) _container_5).getObjSel().getName();
                _builder.append(_name_12, "\t");
                _builder.append(".getValue().getValue();");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((!(hasAdditionalResources || closureHasAdditionalResources))) {
            _builder.append("\t");
            _builder.append("selection.addAll(models);");
            _builder.newLine();
          }
        }
        {
          if ((hasAdditionalResources || closureHasAdditionalResources)) {
            _builder.append("\t");
            _builder.append("selection.addAll(resources);");
            _builder.newLine();
          }
        }
        {
          if (((mut.getContainer() != null) && (hasAdditionalResources || closureHasAdditionalResources))) {
            {
              ObSelectionStrategy _container_6 = mut.getContainer();
              if ((_container_6 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("entry_");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_13 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_13, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_14 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_14, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_9 = mut.getContainer();
                String _name_15 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                _builder.append(_name_15, "\t");
                _builder.append(" == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_10 = mut.getContainer();
                String _name_16 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                _builder.append(_name_16, "\t");
                _builder.append(".getValue().getKey() == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("selection.add(entry_");
                ObSelectionStrategy _container_11 = mut.getContainer();
                String _name_17 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                _builder.append(_name_17, "\t");
                _builder.append(".getValue().getKey());");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
            {
              ObSelectionStrategy _container_12 = mut.getContainer();
              boolean _tripleEquals = (_container_12 == null);
              if (_tripleEquals) {
                {
                  ObSelectionStrategy _object_2 = mut.getObject();
                  if ((_object_2 instanceof RandomTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("//");
                    _builder.append(rts = true, "\t");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                        ObSelectionStrategy _object_3 = mut.getObject();
                        String _name_18 = ((RandomTypeSelection) _object_3).getType().getName();
                        _builder.append(_name_18, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, \"");
                        ObSelectionStrategy _object_4 = mut.getObject();
                        String _name_19 = ((RandomTypeSelection) _object_4).getType().getName();
                        _builder.append(_name_19, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_5 = mut.getObject();
                      if ((_object_5 instanceof CompleteTypeSelection)) {
                        _builder.append("\t");
                        _builder.append("//");
                        _builder.append(rts = true, "\t");
                        _builder.newLineIfNotEmpty();
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                            ObSelectionStrategy _object_6 = mut.getObject();
                            String _name_20 = ((CompleteTypeSelection) _object_6).getType().getName();
                            _builder.append(_name_20, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, \"");
                            ObSelectionStrategy _object_7 = mut.getObject();
                            String _name_21 = ((CompleteTypeSelection) _object_7).getType().getName();
                            _builder.append(_name_21, "\t");
                            _builder.append("\");");
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
              ObSelectionStrategy _container_13 = mut.getContainer();
              boolean _tripleNotEquals_1 = (_container_13 != null);
              if (_tripleNotEquals_1) {
                {
                  ObSelectionStrategy _container_14 = mut.getContainer();
                  if ((_container_14 instanceof RandomTypeSelection)) {
                    _builder.append("\t");
                    _builder.append("//");
                    _builder.append(rts = true, "\t");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                        ObSelectionStrategy _container_15 = mut.getContainer();
                        String _name_22 = ((RandomTypeSelection) _container_15).getType().getName();
                        _builder.append(_name_22, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, \"");
                        ObSelectionStrategy _container_16 = mut.getContainer();
                        String _name_23 = ((RandomTypeSelection) _container_16).getType().getName();
                        _builder.append(_name_23, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("EObject container = rts.getObject();");
                    _builder.newLine();
                    {
                      EReference _refType = mut.getContainer().getRefType();
                      boolean _tripleNotEquals_2 = (_refType != null);
                      if (_tripleNotEquals_2) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        String refName = mut.getContainer().getRefType().getName();
                        _builder.newLineIfNotEmpty();
                        {
                          EReference _refRefType = mut.getContainer().getRefRefType();
                          boolean _tripleNotEquals_3 = (_refRefType != null);
                          if (_tripleNotEquals_3) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("container = ModelManager.getReference(\"");
                            String _name_24 = mut.getContainer().getRefType().getName();
                            _builder.append(_name_24, "\t\t");
                            _builder.append("\", container);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("//");
                            _builder.append(refName = mut.getContainer().getRefRefType().getName(), "\t\t");
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refRefRefType = mut.getContainer().getRefRefRefType();
                              boolean _tripleNotEquals_4 = (_refRefRefType != null);
                              if (_tripleNotEquals_4) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("container = ModelManager.getReference(\"");
                                String _name_25 = mut.getContainer().getRefRefType().getName();
                                _builder.append(_name_25, "\t\t");
                                _builder.append("\", container);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("//");
                                _builder.append(refName = mut.getContainer().getRefRefRefType().getName(), "\t\t");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("if (container == null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                            _builder.append(refName, "\t");
                            _builder.append("\", containerSelection);");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                            _builder.append(refName, "\t");
                            _builder.append("\", containerSelection);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("containerSelectionList.add(containerSelection);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("referenceSelectionList.add(referenceSelection);");
                        _builder.newLine();
                      } else {
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("if (container == null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("containerSelectionList.add(containerSelection);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("referenceSelectionList.add(referenceSelection);");
                        _builder.newLine();
                      }
                    }
                  } else {
                    ObSelectionStrategy _container_17 = mut.getContainer();
                    if ((_container_17 instanceof CompleteTypeSelection)) {
                      _builder.append("\t");
                      _builder.append("//");
                      _builder.append(rts = true, "\t");
                      _builder.newLineIfNotEmpty();
                      {
                        if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("if (container == null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _container_18 = mut.getContainer();
                          String _name_26 = ((CompleteTypeSelection) _container_18).getType().getName();
                          _builder.append(_name_26, "\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, \"");
                          ObSelectionStrategy _container_19 = mut.getContainer();
                          String _name_27 = ((CompleteTypeSelection) _container_19).getType().getName();
                          _builder.append(_name_27, "\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t");
                      _builder.append("EObject container = rts.getObject();");
                      _builder.newLine();
                      {
                        if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                          _builder.append("\t");
                          _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);");
                          _builder.newLine();
                        } else {
                          _builder.append("\t");
                          _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, container);");
                          _builder.newLine();
                        }
                      }
                      _builder.append("\t");
                      _builder.append("containerSelectionList.add(containerSelection);");
                      _builder.newLine();
                      {
                        EReference _refType_1 = mut.getContainer().getRefType();
                        boolean _tripleNotEquals_5 = (_refType_1 != null);
                        if (_tripleNotEquals_5) {
                          {
                            if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                              _builder.append("\t");
                              _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                              String _name_28 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_28, "\t");
                              _builder.append("\", containerSelection);");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("\t");
                              _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                              String _name_29 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_29, "\t");
                              _builder.append("\", containerSelection);");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("referenceSelectionList.add(referenceSelection);");
                          _builder.newLine();
                        } else {
                          {
                            if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                              _builder.append("\t");
                              _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                              _builder.newLine();
                            } else {
                              _builder.append("\t");
                              _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("referenceSelectionList.add(referenceSelection);");
                          _builder.newLine();
                        }
                      }
                    } else {
                      ObSelectionStrategy _container_20 = mut.getContainer();
                      if ((_container_20 instanceof SpecificObjectSelection)) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("entry_");
                        ObSelectionStrategy _container_21 = mut.getContainer();
                        String _name_30 = ((SpecificObjectSelection) _container_21).getObjSel().getName();
                        _builder.append(_name_30, "\t\t");
                        _builder.append(" = hmObjects.get(\"");
                        ObSelectionStrategy _container_22 = mut.getContainer();
                        String _name_31 = ((SpecificObjectSelection) _container_22).getObjSel().getName();
                        _builder.append(_name_31, "\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("if (entry_");
                        ObSelectionStrategy _container_23 = mut.getContainer();
                        String _name_32 = ((SpecificObjectSelection) _container_23).getObjSel().getName();
                        _builder.append(_name_32, "\t\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                            ObSelectionStrategy _container_24 = mut.getContainer();
                            String _name_33 = ((SpecificObjectSelection) _container_24).getObjSel().getName();
                            _builder.append(_name_33, "\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(selection, entry_");
                            ObSelectionStrategy _container_25 = mut.getContainer();
                            String _name_34 = ((SpecificObjectSelection) _container_25).getObjSel().getName();
                            _builder.append(_name_34, "\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("if (recovered == null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("containerSelectionList.add(containerSelection);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("} else {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                        ObSelectionStrategy _container_26 = mut.getContainer();
                        String _name_35 = ((SpecificObjectSelection) _container_26).getObjSel().getName();
                        _builder.append(_name_35, "\t\t\t");
                        _builder.append(" = hmList.get(\"");
                        ObSelectionStrategy _container_27 = mut.getContainer();
                        String _name_36 = ((SpecificObjectSelection) _container_27).getObjSel().getName();
                        _builder.append(_name_36, "\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("if (listEntry_");
                        ObSelectionStrategy _container_28 = mut.getContainer();
                        String _name_37 = ((SpecificObjectSelection) _container_28).getObjSel().getName();
                        _builder.append(_name_37, "\t\t\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                        ObSelectionStrategy _container_29 = mut.getContainer();
                        String _name_38 = ((SpecificObjectSelection) _container_29).getObjSel().getName();
                        _builder.append(_name_38, "\t\t\t\t");
                        _builder.append(") {");
                        _builder.newLineIfNotEmpty();
                        {
                          String _resource = mut.getContainer().getResource();
                          boolean _tripleEquals_1 = (_resource == null);
                          if (_tripleEquals_1) {
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("EObject obj = ModelManager.getObject(model, ent.getKey());");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t\t\t\t");
                            _builder.append("EObject obj = ModelManager.getObject(selection, ent.getKey());");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("if (obj == null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("obj = ent.getKey();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t\t\t");
                        _builder.append("objs.add(obj);");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, objs);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t\t\t");
                        _builder.append("containerSelectionList.add(containerSelection);");
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
                        _builder.append("\t\t\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          EReference _refType_2 = mut.getContainer().getRefType();
                          boolean _tripleNotEquals_6 = (_refType_2 != null);
                          if (_tripleNotEquals_6) {
                            _builder.append("\t\t");
                            _builder.append("if (entry_");
                            ObSelectionStrategy _container_30 = mut.getContainer();
                            String _name_39 = ((SpecificObjectSelection) _container_30).getObjSel().getName();
                            _builder.append(_name_39, "\t\t");
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("EObject obRecovered = MutatorUtils.recoverLocalObject(model, entry_");
                                ObSelectionStrategy _container_31 = mut.getContainer();
                                String _name_40 = ((SpecificObjectSelection) _container_31).getObjSel().getName();
                                _builder.append(_name_40);
                                _builder.append(".getKey());");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("EObject obRecovered = MutatorUtils.recoverLocalObject(selection, entry_");
                                ObSelectionStrategy _container_32 = mut.getContainer();
                                String _name_41 = ((SpecificObjectSelection) _container_32).getObjSel().getName();
                                _builder.append(_name_41);
                                _builder.append(".getKey());");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("Object valueRecovered = obRecovered;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("Object valueRec = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("//");
                            String refName_1 = mut.getContainer().getRefType().getName();
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refRefType_1 = mut.getContainer().getRefRefType();
                              boolean _tripleNotEquals_7 = (_refRefType_1 != null);
                              if (_tripleNotEquals_7) {
                                _builder.append("\t\t\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_42 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_42, "\t\t\t");
                                _builder.append("\", (EObject) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRec instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (EObject) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRec instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("//");
                                _builder.append(refName_1 = mut.getContainer().getRefRefType().getName(), "\t\t\t");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              EReference _refRefRefType_1 = mut.getContainer().getRefRefRefType();
                              boolean _tripleNotEquals_8 = (_refRefRefType_1 != null);
                              if (_tripleNotEquals_8) {
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRecovered instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_43 = mut.getContainer().getRefRefType().getName();
                                _builder.append(_name_43, "\t\t\t\t");
                                _builder.append("\", (EObject) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRecovered instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_44 = mut.getContainer().getRefRefType().getName();
                                _builder.append(_name_44, "\t\t\t\t");
                                _builder.append("\", (List<EObject>) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRec instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (EObject) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("if (valueRec instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("//");
                                _builder.append(refName_1 = mut.getContainer().getRefRefRefType().getName(), "\t\t\t");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("if (valueRecovered == null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("obRecovered = entry_");
                            ObSelectionStrategy _container_33 = mut.getContainer();
                            String _name_45 = ((SpecificObjectSelection) _container_33).getObjSel().getName();
                            _builder.append(_name_45, "\t\t\t\t");
                            _builder.append(".getKey();");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t");
                            _builder.append("valueRecovered = obRecovered;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("valueRec = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("//");
                            _builder.append(refName_1 = mut.getContainer().getRefType().getName(), "\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refRefType_2 = mut.getContainer().getRefRefType();
                              boolean _tripleNotEquals_9 = (_refRefType_2 != null);
                              if (_tripleNotEquals_9) {
                                _builder.append("\t\t\t\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_46 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_46, "\t\t\t\t");
                                _builder.append("\", (EObject) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (EObject) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("//");
                                _builder.append(refName_1 = mut.getContainer().getRefRefType().getName(), "\t\t\t\t");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              EReference _refRefRefType_2 = mut.getContainer().getRefRefRefType();
                              boolean _tripleNotEquals_10 = (_refRefRefType_2 != null);
                              if (_tripleNotEquals_10) {
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRecovered instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_47 = mut.getContainer().getRefRefType().getName();
                                _builder.append(_name_47, "\t\t\t\t\t");
                                _builder.append("\", (EObject) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRecovered instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_48 = mut.getContainer().getRefRefRefType().getName();
                                _builder.append(_name_48, "\t\t\t\t\t");
                                _builder.append("\", (List<EObject>) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (EObject) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("//");
                                _builder.append(refName_1 = mut.getContainer().getRefRefRefType().getName(), "\t\t\t\t");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("if (valueRecovered instanceof EObject) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("EObject recovered = (EObject) valueRecovered;");
                            _builder.newLine();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);");
                                _builder.newLine();
                              } else {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t");
                            _builder.append("containerSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("containerSelectionList.add(containerSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                            _builder.append(refName_1, "\t\t\t\t");
                            _builder.append("\", recovered);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelectionList.add(referenceSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("if (valueRecovered instanceof List<?>) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("List<EObject> recoveredList = (List<EObject>) valueRecovered;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("containerSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("for (EObject recovered : recoveredList) {");
                            _builder.newLine();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);");
                                _builder.newLine();
                              } else {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("containerSelectionList.add(containerSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                            _builder.append(refName_1, "\t\t\t\t\t");
                            _builder.append("\", recovered);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("referenceSelectionList.add(referenceSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("} else {");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                            ObSelectionStrategy _container_34 = mut.getContainer();
                            String _name_49 = ((SpecificObjectSelection) _container_34).getObjSel().getName();
                            _builder.append(_name_49, "\t\t\t");
                            _builder.append(" = hmList.get(\"");
                            ObSelectionStrategy _container_35 = mut.getContainer();
                            String _name_50 = ((SpecificObjectSelection) _container_35).getObjSel().getName();
                            _builder.append(_name_50, "\t\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t");
                            _builder.append("if (listEntry_");
                            ObSelectionStrategy _container_36 = mut.getContainer();
                            String _name_51 = ((SpecificObjectSelection) _container_36).getObjSel().getName();
                            _builder.append(_name_51, "\t\t\t");
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t");
                            _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("if (listEntry_");
                            ObSelectionStrategy _container_37 = mut.getContainer();
                            String _name_52 = ((SpecificObjectSelection) _container_37).getObjSel().getName();
                            _builder.append(_name_52, "\t\t\t\t");
                            _builder.append(" == null || listEntry_");
                            ObSelectionStrategy _container_38 = mut.getContainer();
                            String _name_53 = ((SpecificObjectSelection) _container_38).getObjSel().getName();
                            _builder.append(_name_53, "\t\t\t\t");
                            _builder.append(".isEmpty()) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("containerSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("referenceSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                            ObSelectionStrategy _container_39 = mut.getContainer();
                            String _name_54 = ((SpecificObjectSelection) _container_39).getObjSel().getName();
                            _builder.append(_name_54, "\t\t\t\t");
                            _builder.append(") {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t\t\t");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(selection, ent.getKey());");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("if (recovered == null) {");
                            _builder.newLine();
                            {
                              ObSelectionStrategy _container_40 = mut.getContainer();
                              boolean _tripleEquals_2 = (_container_40 == null);
                              if (_tripleEquals_2) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("return numMutantsGenerated;");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("continue;");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("Object valueRec = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("Object valueRecovered = recovered;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("//");
                            _builder.append(refName_1 = mut.getContainer().getRefType().getName(), "\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refRefType_3 = mut.getContainer().getRefRefType();
                              boolean _tripleNotEquals_11 = (_refRefType_3 != null);
                              if (_tripleNotEquals_11) {
                                _builder.append("\t\t\t\t");
                                _builder.append("valueRec = ModelManager.getReferenced(\"");
                                String _name_55 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_55, "\t\t\t\t");
                                _builder.append("\", (EObject) valueRecovered);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof EObject) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (EObject) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("if (valueRec instanceof List<?>) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("//");
                                _builder.append(refName_1 = mut.getContainer().getRefRefType().getName(), "\t\t\t\t");
                                _builder.newLineIfNotEmpty();
                                {
                                  EReference _refRefRefType_3 = mut.getContainer().getRefRefRefType();
                                  boolean _tripleNotEquals_12 = (_refRefRefType_3 != null);
                                  if (_tripleNotEquals_12) {
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (valueRecovered instanceof EObject) {");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valueRec = ModelManager.getReferenced(\"");
                                    String _name_56 = mut.getContainer().getRefRefType().getName();
                                    _builder.append(_name_56, "\t\t\t\t\t");
                                    _builder.append("\", (EObject) valueRecovered);");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (valueRecovered instanceof List<?>) {");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valueRec = ModelManager.getReferenced(\"");
                                    String _name_57 = mut.getContainer().getRefRefRefType().getName();
                                    _builder.append(_name_57, "\t\t\t\t\t");
                                    _builder.append("\", (List<EObject>) valueRecovered);");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (valueRec instanceof EObject) {");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valueRecovered = (EObject) valueRec;");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("if (valueRec instanceof List<?>) {");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("\t");
                                    _builder.append("valueRecovered = (List<EObject>) valueRec;");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t\t\t");
                                    _builder.append("//");
                                    _builder.append(refName_1 = mut.getContainer().getRefRefRefType().getName(), "\t\t\t\t");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t\t\t");
                            _builder.append("if (valueRecovered instanceof EObject) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("EObject obRecovered = (EObject) valueRecovered;");
                            _builder.newLine();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, obRecovered);");
                                _builder.newLine();
                              } else {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, obRecovered);");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("containerSelectionList.add(containerSelection);");
                            _builder.newLine();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                                _builder.append(refName_1);
                                _builder.append("\", obRecovered);");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                                _builder.append(refName_1);
                                _builder.append("\", obRecovered);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("referenceSelectionList.add(referenceSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("if (valueRecovered instanceof List<?>) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("List<EObject> recoveredList = (List<EObject>) valueRecovered;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("containerSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("referenceSelectionList.clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("for (EObject recoveredIt : recoveredList) {");
                            _builder.newLine();
                            {
                              if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recoveredIt);");
                                _builder.newLine();
                                _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                                _builder.append(refName_1);
                                _builder.append("\", recoveredIt);");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(selectionPackages, selection, recovered);");
                                _builder.newLine();
                                _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                                _builder.append(refName_1);
                                _builder.append("\", recoveredIt);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("containerSelectionList.add(containerSelection);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("referenceSelectionList.add(referenceSelection);");
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
                            _builder.append("if (containerSelectionList.isEmpty()) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("referenceSelectionList.add(referenceSelection);");
                            _builder.newLine();
                          }
                        }
                      } else {
                        ObSelectionStrategy _container_41 = mut.getContainer();
                        if ((_container_41 instanceof SpecificClosureSelection)) {
                          _builder.append("\t");
                          _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                          ObSelectionStrategy _container_42 = mut.getContainer();
                          String _name_58 = ((SpecificClosureSelection) _container_42).getObjSel().getName();
                          _builder.append(_name_58, "\t");
                          _builder.append(" = hmObjects.get(\"");
                          ObSelectionStrategy _container_43 = mut.getContainer();
                          String _name_59 = ((SpecificClosureSelection) _container_43).getObjSel().getName();
                          _builder.append(_name_59, "\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("if (entry_");
                          ObSelectionStrategy _container_44 = mut.getContainer();
                          String _name_60 = ((SpecificClosureSelection) _container_44).getObjSel().getName();
                          _builder.append(_name_60, "\t");
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                          ObSelectionStrategy _container_45 = mut.getContainer();
                          String _name_61 = ((SpecificClosureSelection) _container_45).getObjSel().getName();
                          _builder.append(_name_61, "\t\t");
                          _builder.append(".getKey());");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t");
                          _builder.append("if (recovered == null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                          _builder.append("\t\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("ObSelectionStrategy containerSelection = new SpecificClosureSelection(selectionPackages, selection, recovered, \"");
                          ObSelectionStrategy _container_46 = mut.getContainer();
                          String _name_62 = ((SpecificClosureSelection) _container_46).getRefType().getName();
                          _builder.append(_name_62, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("containerSelectionList.add(containerSelection);");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("} else {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                          ObSelectionStrategy _container_47 = mut.getContainer();
                          String _name_63 = ((SpecificClosureSelection) _container_47).getObjSel().getName();
                          _builder.append(_name_63, "\t\t");
                          _builder.append(" = hmList.get(\"");
                          ObSelectionStrategy _container_48 = mut.getContainer();
                          String _name_64 = ((SpecificClosureSelection) _container_48).getObjSel().getName();
                          _builder.append(_name_64, "\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("if (listEntry_");
                          ObSelectionStrategy _container_49 = mut.getContainer();
                          String _name_65 = ((SpecificClosureSelection) _container_49).getObjSel().getName();
                          _builder.append(_name_65, "\t\t");
                          _builder.append(" != null) {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                          ObSelectionStrategy _container_50 = mut.getContainer();
                          String _name_66 = ((SpecificClosureSelection) _container_50).getObjSel().getName();
                          _builder.append(_name_66, "\t\t\t");
                          _builder.append(") {");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("EObject obj = ModelManager.getObject(selection, ent.getKey());");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("if (obj == null) {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t\t\t");
                          _builder.append("obj = ent.getKey();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t\t");
                          _builder.append("objs.add(obj);");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("ObSelectionStrategy containerSelection = new SpecificClosureSelection(selectionPackages, selection, objs, \"");
                          ObSelectionStrategy _container_51 = mut.getContainer();
                          String _name_67 = ((SpecificClosureSelection) _container_51).getRefType().getName();
                          _builder.append(_name_67, "\t\t\t");
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("containerSelectionList.add(containerSelection);");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("else {");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("return numMutantsGenerated;");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                          {
                            EReference _refType_3 = mut.getContainer().getRefType();
                            boolean _tripleNotEquals_13 = (_refType_3 != null);
                            if (_tripleNotEquals_13) {
                              _builder.append("\t\t");
                              _builder.append("if (entry_");
                              ObSelectionStrategy _container_52 = mut.getContainer();
                              String _name_68 = ((SpecificClosureSelection) _container_52).getObjSel().getName();
                              _builder.append(_name_68, "\t\t");
                              _builder.append(" != null) {");
                              _builder.newLineIfNotEmpty();
                              {
                                if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                  _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(model, entry_");
                                  ObSelectionStrategy _container_53 = mut.getContainer();
                                  String _name_69 = ((SpecificClosureSelection) _container_53).getObjSel().getName();
                                  _builder.append(_name_69);
                                  _builder.append(".getKey());");
                                  _builder.newLineIfNotEmpty();
                                } else {
                                  _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(selection, entry_");
                                  ObSelectionStrategy _container_54 = mut.getContainer();
                                  String _name_70 = ((SpecificClosureSelection) _container_54).getObjSel().getName();
                                  _builder.append(_name_70);
                                  _builder.append(".getKey());");
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                              _builder.append("if (recovered == null) {");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("\t\t\t");
                              _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, \"");
                              String _name_71 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_71, "\t\t\t");
                              _builder.append("\", recovered);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t");
                              _builder.append("referenceSelectionList.add(referenceSelection);");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("} else {");
                              _builder.newLine();
                              _builder.append("\t\t\t");
                              _builder.append("return numMutantsGenerated;");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("}");
                              _builder.newLine();
                            } else {
                              {
                                if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                                  _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                                  _builder.newLine();
                                } else {
                                  _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(selectionPackages, selection, null, null);");
                                  _builder.newLine();
                                }
                              }
                              _builder.append("\t\t");
                              _builder.append("referenceSelectionList.add(referenceSelection);");
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
            {
              if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
                {
                  ObSelectionStrategy _container_55 = mut.getContainer();
                  boolean _tripleNotEquals_14 = (_container_55 != null);
                  if (_tripleNotEquals_14) {
                    _builder.append("\t");
                    _builder.append("for (int j = 0; j < containerSelectionList.size(); j++) {");
                    _builder.newLine();
                  }
                }
                {
                  if ((rts == true)) {
                    {
                      ObSelectionStrategy _container_56 = mut.getContainer();
                      boolean _tripleNotEquals_15 = (_container_56 != null);
                      if (_tripleNotEquals_15) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), \"");
                        String _name_72 = mut.getObject().getType().getName();
                        _builder.append(_name_72, "\t\t");
                        _builder.append("\", referenceSelectionList.get(j), containerSelectionList.get(j));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("rts = new RandomTypeSelection(packages, model, \"");
                            String _name_73 = mut.getObject().getType().getName();
                            _builder.append(_name_73);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("rts = new RandomTypeSelection(selectionPackages, selection, \"");
                            String _name_74 = mut.getObject().getType().getName();
                            _builder.append(_name_74);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  } else {
                    {
                      ObSelectionStrategy _container_57 = mut.getContainer();
                      boolean _tripleNotEquals_16 = (_container_57 != null);
                      if (_tripleNotEquals_16) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), \"");
                        String _name_75 = mut.getObject().getType().getName();
                        _builder.append(_name_75, "\t\t");
                        _builder.append("\", referenceSelectionList.get(j), containerSelectionList.get(j));");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        _builder.append(rts = true, "\t\t");
                        _builder.newLineIfNotEmpty();
                      } else {
                        {
                          if ((((mut.getObject().getResource() == null) && (!hasAdditionalResources)) && (!closureHasAdditionalResources))) {
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                            String _name_76 = mut.getObject().getType().getName();
                            _builder.append(_name_76);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(selectionPackages, selection, \"");
                            String _name_77 = mut.getObject().getType().getName();
                            _builder.append(_name_77);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        _builder.append(rts = true, "\t\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  ObSelectionStrategy _container_58 = mut.getContainer();
                  boolean _tripleNotEquals_17 = (_container_58 != null);
                  if (_tripleNotEquals_17) {
                    {
                      if ((((mut.getObject().getExpression() == null) && (mut.getContainer().getExpression() == null)) && (!(mut.getObject() instanceof CompleteTypeSelection)))) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                      }
                    }
                  } else {
                    {
                      if ((((mut.getObject().getExpression() == null) && (mut.getContainer() == null)) && (!(mut.getObject() instanceof CompleteTypeSelection)))) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                      }
                    }
                  }
                }
                {
                  Expression _expression_1 = mut.getObject().getExpression();
                  boolean _tripleNotEquals_18 = (_expression_1 != null);
                  if (_tripleNotEquals_18) {
                    {
                      ObSelectionStrategy _container_59 = mut.getContainer();
                      boolean _tripleEquals_3 = (_container_59 == null);
                      if (_tripleEquals_3) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LIST: ");
                        List<Integer> expressionList = new ArrayList<Integer>();
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LEVEL: ");
                        boolean _add_2 = expressionList.add(Integer.valueOf(0));
                        _builder.append(_add_2, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//INDEX EXPRESSION: ");
                        int[] nExpression = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//INDEX EXPRESSION: ");
                        int _set = nExpression[0] = 0;
                        _builder.append(_set, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//RECURSION INDEX EXPRESSION: ");
                        int[] recursionIndexExpression = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//RECURSION INDEX EXPRESSION: ");
                        int _set_1 = recursionIndexExpression[0] = 0;
                        _builder.append(_set_1, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("Expression exp");
                        Integer _get = expressionList.get(0);
                        _builder.append(_get, "\t\t");
                        _builder.append(" = new Expression();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        int[] nReference = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        int _set_2 = nReference[0] = 0;
                        _builder.append(_set_2, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        boolean[] evaluation = new boolean[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        String _xblockexpression_2 = null;
                        {
                          evaluation[0] = false;
                          _xblockexpression_2 = "";
                        }
                        _builder.append(_xblockexpression_2, "\t\t");
                        _builder.newLineIfNotEmpty();
                        {
                          String _resource_1 = mut.getObject().getResource();
                          boolean _tripleEquals_4 = (_resource_1 == null);
                          if (_tripleEquals_4) {
                            _builder.append("\t");
                            _builder.append("\t");
                            Expression _expression_2 = mut.getObject().getExpression();
                            ObSelectionStrategy _container_60 = mut.getContainer();
                            boolean _tripleNotEquals_19 = (_container_60 != null);
                            Object _method = this.method(_expression_2, mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, _tripleNotEquals_19, evaluation);
                            _builder.append(_method, "\t\t");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            Expression _expression_3 = mut.getObject().getExpression();
                            ObSelectionStrategy _container_61 = mut.getContainer();
                            boolean _tripleNotEquals_20 = (_container_61 != null);
                            Object _method_1 = this.method(_expression_3, mut, nReference, expressionList, nExpression, recursionIndexExpression, true, true, _tripleNotEquals_20, evaluation);
                            _builder.append(_method_1, "\t\t");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("//");
                            _builder.newLine();
                          }
                        }
                        {
                          boolean _get_1 = evaluation[0];
                          boolean _equals_1 = (_get_1 == false);
                          if (_equals_1) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("objects = evaluate(objects, exp");
                            Integer _get_2 = expressionList.get(0);
                            _builder.append(_get_2, "\t\t");
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("objects = auxObjects;");
                            _builder.newLine();
                          }
                        }
                      } else {
                        Expression _expression_4 = mut.getContainer().getExpression();
                        boolean _tripleEquals_5 = (_expression_4 == null);
                        if (_tripleEquals_5) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("List<EObject> objects = rts.getObjects();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//EXPRESSION LIST: ");
                          List<Integer> expressionList_1 = new ArrayList<Integer>();
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//EXPRESSION LEVEL: ");
                          boolean _add_3 = expressionList_1.add(Integer.valueOf(0));
                          _builder.append(_add_3, "\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//INDEX EXPRESSION: ");
                          int[] nExpression_1 = new int[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//INDEX EXPRESSION: ");
                          int _set_3 = nExpression_1[0] = 0;
                          _builder.append(_set_3, "\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//RECURSION INDEX EXPRESSION: ");
                          int[] recursionIndexExpression_1 = new int[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//RECURSION INDEX EXPRESSION: ");
                          int _set_4 = recursionIndexExpression_1[0] = 0;
                          _builder.append(_set_4, "\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("Expression exp");
                          Integer _get_3 = expressionList_1.get(0);
                          _builder.append(_get_3, "\t\t");
                          _builder.append(" = new Expression();");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//");
                          int[] nReference_1 = new int[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//");
                          int _set_5 = nReference_1[0] = 0;
                          _builder.append(_set_5, "\t\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//");
                          boolean[] evaluation_1 = new boolean[1];
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("//");
                          String _xblockexpression_3 = null;
                          {
                            evaluation_1[0] = false;
                            _xblockexpression_3 = "";
                          }
                          _builder.append(_xblockexpression_3, "\t\t");
                          _builder.newLineIfNotEmpty();
                          {
                            String _resource_2 = mut.getObject().getResource();
                            boolean _tripleEquals_6 = (_resource_2 == null);
                            if (_tripleEquals_6) {
                              _builder.append("\t");
                              _builder.append("\t");
                              Expression _expression_5 = mut.getObject().getExpression();
                              ObSelectionStrategy _container_62 = mut.getContainer();
                              boolean _tripleNotEquals_21 = (_container_62 != null);
                              Object _method_2 = this.method(_expression_5, mut, nReference_1, expressionList_1, nExpression_1, recursionIndexExpression_1, true, false, _tripleNotEquals_21, evaluation_1);
                              _builder.append(_method_2, "\t\t");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("\t");
                              _builder.append("\t");
                              Expression _expression_6 = mut.getObject().getExpression();
                              ObSelectionStrategy _container_63 = mut.getContainer();
                              boolean _tripleNotEquals_22 = (_container_63 != null);
                              Object _method_3 = this.method(_expression_6, mut, nReference_1, expressionList_1, nExpression_1, recursionIndexExpression_1, true, true, _tripleNotEquals_22, evaluation_1);
                              _builder.append(_method_3, "\t\t");
                              _builder.newLineIfNotEmpty();
                            }
                          }
                          {
                            boolean _get_4 = evaluation_1[0];
                            boolean _equals_2 = (_get_4 == false);
                            if (_equals_2) {
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("objects = evaluate(objects, exp");
                              Integer _get_5 = expressionList_1.get(0);
                              _builder.append(_get_5, "\t\t");
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("objects = auxObjects;");
                              _builder.newLine();
                            }
                          }
                        }
                      }
                    }
                  }
                }
                {
                  Expression _expression_7 = mut.getObject().getExpression();
                  boolean _tripleEquals_7 = (_expression_7 == null);
                  if (_tripleEquals_7) {
                    {
                      if (((mut.getContainer() != null) && (mut.getContainer().getExpression() != null))) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LIST: ");
                        List<Integer> expressionList_2 = new ArrayList<Integer>();
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//EXPRESSION LEVEL: ");
                        boolean _add_4 = expressionList_2.add(Integer.valueOf(0));
                        _builder.append(_add_4, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//INDEX EXPRESSION: ");
                        int[] nExpression_2 = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//INDEX EXPRESSION: ");
                        int _set_6 = nExpression_2[0] = 0;
                        _builder.append(_set_6, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//RECURSION INDEX EXPRESSION: ");
                        int[] recursionIndexExpression_2 = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//RECURSION INDEX EXPRESSION: ");
                        int _set_7 = recursionIndexExpression_2[0] = 0;
                        _builder.append(_set_7, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("Expression exp");
                        Integer _get_6 = expressionList_2.get(0);
                        _builder.append(_get_6, "\t\t");
                        _builder.append(" = new Expression();");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        int[] nReference_2 = new int[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        int _set_8 = nReference_2[0] = 0;
                        _builder.append(_set_8, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        boolean[] evaluation_2 = new boolean[1];
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("//");
                        String _xblockexpression_4 = null;
                        {
                          evaluation_2[0] = false;
                          _xblockexpression_4 = "";
                        }
                        _builder.append(_xblockexpression_4, "\t\t");
                        _builder.newLineIfNotEmpty();
                        {
                          if (((mut.getObject().getResource() == null) || (!closureHasAdditionalResources))) {
                            _builder.append("\t");
                            _builder.append("\t");
                            Expression _expression_8 = mut.getContainer().getExpression();
                            ObSelectionStrategy _container_64 = mut.getContainer();
                            boolean _tripleNotEquals_23 = (_container_64 != null);
                            Object _method_4 = this.method(_expression_8, mut, nReference_2, expressionList_2, nExpression_2, recursionIndexExpression_2, true, false, _tripleNotEquals_23, evaluation_2);
                            _builder.append(_method_4, "\t\t");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            Expression _expression_9 = mut.getContainer().getExpression();
                            ObSelectionStrategy _container_65 = mut.getContainer();
                            boolean _tripleNotEquals_24 = (_container_65 != null);
                            Object _method_5 = this.method(_expression_9, mut, nReference_2, expressionList_2, nExpression_2, recursionIndexExpression_2, true, true, _tripleNotEquals_24, evaluation_2);
                            _builder.append(_method_5, "\t\t");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          boolean _get_7 = evaluation_2[0];
                          boolean _equals_3 = (_get_7 == false);
                          if (_equals_3) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("objects = evaluate(objects, exp");
                            Integer _get_8 = expressionList_2.get(0);
                            _builder.append(_get_8, "\t\t");
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("objects = auxObjects;");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                    {
                      if (((mut.getContainer() != null) && (mut.getContainer().getExpression() == null))) {
                        {
                          ObSelectionStrategy _object_8 = mut.getObject();
                          if ((_object_8 instanceof CompleteTypeSelection)) {
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("List<EObject> objects = rts.getObjects();");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                  }
                }
                {
                  if (((mut.getObject().getResource() != null) || closureHasAdditionalResources)) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//packages.clear();");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//packages.addAll(savedPackages);");
                    _builder.newLine();
                  }
                }
                {
                  String _name_78 = mut.getName();
                  boolean _tripleNotEquals_25 = (_name_78 != null);
                  if (_tripleNotEquals_25) {
                    {
                      ObSelectionStrategy _object_9 = mut.getObject();
                      if ((_object_9 instanceof CompleteTypeSelection)) {
                        _builder.append("\t\t\t\t\t\t");
                        _builder.append("if (objects == null || objects.isEmpty()) {");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_66 = mut.getContainer();
                          boolean _tripleEquals_8 = (_container_66 == null);
                          if (_tripleEquals_8) {
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                          } else {
                            _builder.append("continue;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          if (((mut.getObject().getResource() != null) || closureHasAdditionalResources)) {
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("Resource readOnlyResource = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("\t");
                            _builder.append("readOnlyResource =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("\t        ");
                            _builder.append("ModelManager.findModel(");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("\t            ");
                            _builder.append("selection,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("\t            ");
                            _builder.append("object);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("\t");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t\t\t\t\t");
                        _builder.newLine();
                        _builder.append("Resource resource = null;");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("SelectObjectMutator mut = null;");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("SpecificObjectSelection objectSelection = null;");
                        _builder.newLine();
                        _builder.append("List<");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("SimpleEntry<");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("EObject,");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("SimpleEntry<");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("Resource,");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("List<EPackage>>>> entries =");
                        _builder.newLine();
                        _builder.append("                ");
                        _builder.append("new ArrayList<>();");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("if (objects == null || objects.isEmpty()) {");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_67 = mut.getContainer();
                          boolean _tripleEquals_9 = (_container_67 == null);
                          if (_tripleEquals_9) {
                            _builder.append("\t\t\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                          } else {
                            _builder.append("\t\t\t");
                            _builder.append("continue;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("String tempModel =");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("WodelTempModelContext.nextModelPath(");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("model,");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("\"");
                        _builder.append(methodName, "            ");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("resource = owned.own(");
                        _builder.newLine();
                        _builder.append("\t\t\t    \t\t\t\t\t\t\t\t\t\t\t                    ");
                        _builder.append("ModelManager.cloneModel(");
                        _builder.newLine();
                        _builder.append("\t\t\t    \t\t\t\t\t\t\t\t\t\t\t                        ");
                        _builder.append("model,");
                        _builder.newLine();
                        _builder.append("\t\t\t    \t\t\t\t\t\t\t\t\t\t\t                        ");
                        _builder.append("tempModel));");
                        _builder.newLine();
                        _builder.append("models.add(resource);");
                        _builder.newLine();
                        _builder.append("try {      ");
                        _builder.newLine();
                        _builder.append("for (EObject selected :");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("objects) {");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("EObject recovered =");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("MutatorUtils.recoverLocalObject(");
                        _builder.newLine();
                        {
                          String _resource_3 = mut.getObject().getResource();
                          boolean _tripleNotEquals_26 = (_resource_3 != null);
                          if (_tripleNotEquals_26) {
                            _builder.append("               ");
                            _builder.append("readOnlyResource,");
                            _builder.newLine();
                          } else {
                            _builder.append("               ");
                            _builder.append("resource,");
                            _builder.newLine();
                          }
                        }
                        _builder.append("            ");
                        _builder.append("selected);");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("if (recovered == null) {");
                        _builder.newLine();
                        _builder.append("    \t");
                        _builder.append("recovered =");
                        _builder.newLine();
                        _builder.append("    \t\t");
                        _builder.append("ModelManager.getObject(");
                        _builder.newLine();
                        {
                          String _resource_4 = mut.getObject().getResource();
                          boolean _tripleNotEquals_27 = (_resource_4 != null);
                          if (_tripleNotEquals_27) {
                            _builder.append("    \t\t");
                            _builder.append("readOnlyResource,");
                            _builder.newLine();
                          } else {
                            _builder.append("    \t\t");
                            _builder.append("resource,");
                            _builder.newLine();
                          }
                        }
                        _builder.append("    \t\t               ");
                        _builder.append("selected);");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("}");
                        _builder.newLine();
                        {
                          if (closureHasAdditionalResources) {
                            _builder.append("    ");
                            _builder.append("if (recovered == null) {");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("\t");
                            _builder.append("recovered =");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("\t        ");
                            _builder.append("MutatorUtils.recoverLocalObject(");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("\t               \t");
                            _builder.append("readOnlyResource,");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("\t            ");
                            _builder.append("selected);");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    ");
                            _builder.append("if (recovered == null) {");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    \t");
                            _builder.append("recovered =");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    \t\t");
                            _builder.append("ModelManager.getObject(");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    \t\t               \t");
                            _builder.append("readOnlyResource,");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    \t\t               ");
                            _builder.append("selected);");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.append("    \t    ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("    ");
                            _builder.newLine();
                          }
                        }
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("if (recovered != null) {");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("SimpleEntry<Resource, List<EPackage>>");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("resourceEntry =");
                        _builder.newLine();
                        _builder.append("                ");
                        _builder.append("new SimpleEntry<>(");
                        _builder.newLine();
                        _builder.append("                    ");
                        _builder.append("resource,");
                        _builder.newLine();
                        _builder.append("                    ");
                        _builder.append("packages);");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("entries.add(");
                        _builder.newLine();
                        _builder.append("            ");
                        _builder.append("new SimpleEntry<>(");
                        _builder.newLine();
                        _builder.append("                ");
                        _builder.append("recovered,");
                        _builder.newLine();
                        _builder.append("                ");
                        _builder.append("resourceEntry));");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("if (entries.isEmpty()) {");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_68 = mut.getContainer();
                          boolean _tripleEquals_10 = (_container_68 == null);
                          if (_tripleEquals_10) {
                            _builder.append("    ");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                          } else {
                            _builder.append("    ");
                            _builder.append("continue;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("}");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("hmObjects.remove(");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("\"");
                        String _name_79 = mut.getName();
                        _builder.append(_name_79, "    ");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.newLine();
                        _builder.append("hmList.put(");
                        _builder.newLine();
                        _builder.append("    ");
                        _builder.append("\"");
                        String _name_80 = mut.getName();
                        _builder.append(_name_80, "    ");
                        _builder.append("\",");
                        _builder.newLineIfNotEmpty();
                        _builder.append("    ");
                        _builder.append("entries);");
                        _builder.newLine();
                        {
                          if (closureHasAdditionalResources) {
                            _builder.append("\t\t\t\t\t");
                            _builder.append("boolean belongsToAdditionalResources = false;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("    ");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_69 = mut.getContainer();
                          boolean _tripleNotEquals_28 = (_container_69 != null);
                          if (_tripleNotEquals_28) {
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.append("EObject oldContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("containerSelectionList");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append(".get(j)");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append(".getObject();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("EObject localContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("MutatorUtils.recoverLocalObject(");
                            _builder.newLine();
                            {
                              String _resource_5 = mut.getObject().getResource();
                              boolean _tripleNotEquals_29 = (_resource_5 != null);
                              if (_tripleNotEquals_29) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("oldContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("if (localContainer == null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("localContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("ModelManager.getObject(");
                            _builder.newLine();
                            {
                              String _resource_6 = mut.getObject().getResource();
                              boolean _tripleNotEquals_30 = (_resource_6 != null);
                              if (_tripleNotEquals_30) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                        ");
                            _builder.append("oldContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("}");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("if (localContainer == null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("            ");
                                _builder.append("localContainer =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                ");
                                _builder.append("MutatorUtils.recoverLocalObject(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("oldContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("if (localContainer != null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    \t");
                                _builder.append("belongsToAdditionalResources = true;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append(" ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("    ");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("            ");
                                _builder.append("if (localContainer == null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                ");
                                _builder.append("localContainer =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("ModelManager.getObject(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                        ");
                                _builder.append("oldContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("if (localContainer != null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    \t");
                                _builder.append("belongsToAdditionalResources = true;");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                    ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("            ");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("if (localContainer == null) {");
                            _builder.newLine();
                            {
                              ObSelectionStrategy _container_70 = mut.getContainer();
                              boolean _tripleEquals_11 = (_container_70 == null);
                              if (_tripleEquals_11) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                ");
                                _builder.append("return numMutantsGenerated;");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                ");
                                _builder.append("continue;");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("        ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("ObSelectionStrategy");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("localContainerSelection = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("SpecificReferenceSelection");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("localReferenceSelection = null;");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append(" ");
                                _builder.append("if (!belongsToAdditionalResources) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("ObSelectionStrategy");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("localContainerSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_7 = mut.getObject().getResource();
                              boolean _tripleNotEquals_31 = (_resource_7 != null);
                              if (_tripleNotEquals_31) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                        ");
                            _builder.append("localContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("SpecificReferenceSelection");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("localReferenceSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("new SpecificReferenceSelection(");
                            _builder.newLine();
                            {
                              String _resource_8 = mut.getObject().getResource();
                              boolean _tripleNotEquals_32 = (_resource_8 != null);
                              if (_tripleNotEquals_32) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            {
                              ObSelectionStrategy _container_71 = mut.getContainer();
                              EReference _refType_4 = null;
                              if (_container_71!=null) {
                                _refType_4=_container_71.getRefType();
                              }
                              boolean _tripleNotEquals_33 = (_refType_4 != null);
                              if (_tripleNotEquals_33) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("                        ");
                                _builder.append("\"");
                                String _name_81 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_81, "\t\t\t\t\t                        ");
                                _builder.append("\",");
                                _builder.newLineIfNotEmpty();
                              } else {
                                {
                                  ObSelectionStrategy _container_72 = mut.getContainer();
                                  EReference _refRefType_4 = null;
                                  if (_container_72!=null) {
                                    _refRefType_4=_container_72.getRefRefType();
                                  }
                                  boolean _tripleNotEquals_34 = (_refRefType_4 != null);
                                  if (_tripleNotEquals_34) {
                                    _builder.append("\t\t\t\t\t");
                                    _builder.append("                        ");
                                    _builder.append("\"");
                                    String _name_82 = mut.getContainer().getRefRefType().getName();
                                    _builder.append(_name_82, "\t\t\t\t\t                        ");
                                    _builder.append("\",");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    {
                                      ObSelectionStrategy _container_73 = mut.getContainer();
                                      EReference _refRefRefType_4 = null;
                                      if (_container_73!=null) {
                                        _refRefRefType_4=_container_73.getRefRefRefType();
                                      }
                                      boolean _tripleNotEquals_35 = (_refRefRefType_4 != null);
                                      if (_tripleNotEquals_35) {
                                        _builder.append("\t\t\t\t\t");
                                        _builder.append("                        ");
                                        _builder.append("\"");
                                        String _name_83 = mut.getContainer().getRefRefRefType().getName();
                                        _builder.append(_name_83, "\t\t\t\t\t                        ");
                                        _builder.append("\",");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        _builder.append("\t\t\t\t\t");
                                        _builder.append("                        ");
                                        _builder.append("null,");
                                        _builder.newLine();
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                        ");
                            _builder.append("localContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("objectSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_9 = mut.getObject().getResource();
                              boolean _tripleNotEquals_36 = (_resource_9 != null);
                              if (_tripleNotEquals_36) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                        ");
                            _builder.append("localObject);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("            ");
                            _builder.append("mut =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                ");
                            _builder.append("new SelectObjectMutator(");
                            _builder.newLine();
                            {
                              String _resource_10 = mut.getObject().getResource();
                              boolean _tripleNotEquals_37 = (_resource_10 != null);
                              if (_tripleNotEquals_37) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localReferenceSelection,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localContainerSelection,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("                    ");
                            _builder.append("objectSelection);");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append(" ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append(" ");
                                _builder.append("if (belongsToAdditionalResources) {");
                                _builder.newLine();
                                _builder.append("                ");
                                _builder.newLine();
                                _builder.append("    ");
                                _builder.newLine();
                                _builder.append("            ");
                                _builder.append("ObSelectionStrategy");
                                _builder.newLine();
                                _builder.append("                ");
                                _builder.append("localContainerSelection =");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("                        ");
                                _builder.append("localContainer);");
                                _builder.newLine();
                                _builder.append("    ");
                                _builder.newLine();
                                _builder.append("            ");
                                _builder.append("SpecificReferenceSelection");
                                _builder.newLine();
                                _builder.append("                ");
                                _builder.append("localReferenceSelection =");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("new SpecificReferenceSelection(");
                                _builder.newLine();
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                {
                                  ObSelectionStrategy _container_74 = mut.getContainer();
                                  EReference _refType_5 = null;
                                  if (_container_74!=null) {
                                    _refType_5=_container_74.getRefType();
                                  }
                                  boolean _tripleNotEquals_38 = (_refType_5 != null);
                                  if (_tripleNotEquals_38) {
                                    _builder.append("                        ");
                                    _builder.append("\"");
                                    String _name_84 = mut.getContainer().getRefType().getName();
                                    _builder.append(_name_84, "                        ");
                                    _builder.append("\",");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    {
                                      ObSelectionStrategy _container_75 = mut.getContainer();
                                      EReference _refRefType_5 = null;
                                      if (_container_75!=null) {
                                        _refRefType_5=_container_75.getRefRefType();
                                      }
                                      boolean _tripleNotEquals_39 = (_refRefType_5 != null);
                                      if (_tripleNotEquals_39) {
                                        _builder.append("                        ");
                                        _builder.append("\"");
                                        String _name_85 = mut.getContainer().getRefRefType().getName();
                                        _builder.append(_name_85, "                        ");
                                        _builder.append("\",");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        {
                                          ObSelectionStrategy _container_76 = mut.getContainer();
                                          EReference _refRefRefType_5 = null;
                                          if (_container_76!=null) {
                                            _refRefRefType_5=_container_76.getRefRefRefType();
                                          }
                                          boolean _tripleNotEquals_40 = (_refRefRefType_5 != null);
                                          if (_tripleNotEquals_40) {
                                            _builder.append("                        ");
                                            _builder.append("\"");
                                            String _name_86 = mut.getContainer().getRefRefRefType().getName();
                                            _builder.append(_name_86, "                        ");
                                            _builder.append("\",");
                                            _builder.newLineIfNotEmpty();
                                          } else {
                                            _builder.append("                        ");
                                            _builder.append("null,");
                                            _builder.newLine();
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                                _builder.append("                        ");
                                _builder.append("localContainer);");
                                _builder.newLine();
                                _builder.append("    ");
                                _builder.newLine();
                                _builder.append("                ");
                                _builder.append("objectSelection =");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("                        ");
                                _builder.append("localObject);");
                                _builder.newLine();
                                _builder.append("    ");
                                _builder.newLine();
                                _builder.append("            ");
                                _builder.append("mut =");
                                _builder.newLine();
                                _builder.append("                ");
                                _builder.append("new SelectObjectMutator(");
                                _builder.newLine();
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("localReferenceSelection,");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("localContainerSelection,");
                                _builder.newLine();
                                _builder.append("                    ");
                                _builder.append("objectSelection);");
                                _builder.newLine();
                                _builder.append(" ");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                          } else {
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("if (!belongsToAdditionalResources) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("objectSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                    ");
                            _builder.append("new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_11 = mut.getObject().getResource();
                              boolean _tripleNotEquals_41 = (_resource_11 != null);
                              if (_tripleNotEquals_41) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t                        ");
                            _builder.append("objects);\t\t\t\t\t");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t            ");
                            _builder.append("mut =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                ");
                            _builder.append("new SelectObjectMutator(");
                            _builder.newLine();
                            {
                              String _resource_12 = mut.getObject().getResource();
                              boolean _tripleNotEquals_42 = (_resource_12 != null);
                              if (_tripleNotEquals_42) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t                    ");
                            _builder.append("null,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                    ");
                            _builder.append("null,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                    ");
                            _builder.append("objectSelection);");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("if (belongsToAdditionalResources) {");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("objectSelection =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("objects);\t\t\t\t\t");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t            ");
                                _builder.append("mut =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("new SelectObjectMutator(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("null,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("null,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("objectSelection);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                          }
                        }
                        _builder.newLine();
                        _builder.append("if (mut == null || objectSelection == null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("return numMutantsGenerated;");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("Mutator mutator = null;");
                        _builder.newLine();
                        _builder.append("if (muts == null) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("//COUNTER: ");
                        int _get_9 = nRegistryMutation[0];
                        int _plus_14 = (_get_9 + 1);
                        int _set_9 = nRegistryMutation[0] = _plus_14;
                        _builder.append(_set_9, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("//COUNTER: ");
                        int _get_10 = nRegistryMethodCall[0];
                        int _plus_15 = (_get_10 + 1);
                        int _set_10 = nRegistryMethodCall[0] = _plus_15;
                        _builder.append(_set_10, "\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("//REGISTRY METHOD NAME:");
                        String _string = Integer.valueOf((nRegistryMethodCall[0])).toString();
                        String registryMethodName = ("registry" + _string);
                        _builder.newLineIfNotEmpty();
                        _builder.append("   \t\t");
                        _builder.append("int mutsMark = mutationMark(muts);");
                        _builder.newLine();
                        {
                          if ((executeMutation == true)) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("/*");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("* IMPORTANT:");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("* Capture the removed EObject from the PRE-MUTATION");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("* source model. Do not use mut.getObject() here:");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("* RemoveObjectMutator only populates that information");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("* during mutate().");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("     ");
                            _builder.append("*/");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("    ");
                            _builder.append("EObject clue =");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("        ");
                            _builder.append("findEObjectForRegistry(");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("            ");
                            _builder.append("seed,");
                            _builder.newLine();
                            {
                              String _resource_13 = mut.getObject().getResource();
                              boolean _tripleEquals_12 = (_resource_13 == null);
                              if (_tripleEquals_12) {
                                _builder.append("\t\t");
                                _builder.append("            ");
                                _builder.append("model,");
                                _builder.newLine();
                              } else {
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t");
                            _builder.append("            ");
                            _builder.append("objectSelection.getObject(),");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("            ");
                            _builder.append("null,");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("            ");
                            _builder.append("null,");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("            ");
                            _builder.append("mutPaths,");
                            _builder.newLine();
                            {
                              String _resource_14 = mut.getObject().getResource();
                              boolean _tripleNotEquals_43 = (_resource_14 != null);
                              if (_tripleNotEquals_43) {
                                _builder.append("\t\t");
                                _builder.append("       ");
                                _builder.append("selectionPackages);");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t");
                                _builder.append("       ");
                                _builder.append("packages);");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t");
                            _builder.append("Object mutated = mut.mutate();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("if (mutated != null) {");
                            _builder.newLine();
                            {
                              String _name_87 = mut.getName();
                              boolean _tripleNotEquals_44 = (_name_87 != null);
                              if (_tripleNotEquals_44) {
                                _builder.append("\t\t");
                                _builder.append("\t\t");
                                _builder.append("hmObjects.remove(\"");
                                String _name_88 = mut.getName();
                                _builder.append(_name_88, "\t\t\t\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t");
                                _builder.append("\t\t");
                                _builder.append("hmList.put(\"");
                                String _name_89 = mut.getName();
                                _builder.append(_name_89, "\t\t\t\t");
                                _builder.append("\", entries);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("AppMutation appMut = ");
                            _builder.append(registryMethodName, "\t\t\t\t");
                            _builder.append("(mut, hmMutator, seed, model, clue, mutPaths, packages);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("//\t\t\t\t\t\tAppMutation appMut = ");
                            _builder.append(registryMethodName);
                            _builder.append("(mut, hmMutator, seed, model, clue, mutPaths, packages);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("if (appMut != null) {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t\t");
                            _builder.append("muts.getMuts().add(appMut);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t\t\t");
                        _builder.append("try {");
                        _builder.newLine();
                        _builder.append("\t\t\t\t");
                        _builder.append("//COUNTER: ");
                        int _get_11 = nMethodCall[0];
                        int _plus_16 = (_get_11 + 1);
                        int _set_11 = nMethodCall[0] = _plus_16;
                        _builder.append(_set_11, "\t\t\t\t");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t\t");
                        _builder.append("//MUTATION METHOD NAME:");
                        String _string_1 = Integer.valueOf((nMethodCall[0])).toString();
                        String nMethodName = ("mutation" + _string_1);
                        _builder.newLineIfNotEmpty();
                        {
                          if ((last == false)) {
                            {
                              if ((standalone == false)) {
                                _builder.append("\t\t\t\t");
                                _builder.append(nMethodName, "\t\t\t\t");
                                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t");
                                _builder.append(nMethodName, "\t\t\t\t");
                                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t");
                            _builder.append("numMutantsGenerated = k[0];");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t");
                            _builder.append("} finally {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     ");
                            _builder.append("MutatorUtils.rollbackMutations(");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
                            _builder.append("muts,");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
                            _builder.append("mutsMark);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("} finally {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("models.remove(resource);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                        {
                          if ((last == true)) {
                            _builder.append("\t\t\t\t");
                            _builder.append("// MUTANT COMPLETION AND REGISTRY");
                            _builder.newLine();
                            _builder.append("\t\t\t\t");
                            _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
                            _builder.newLine();
                            {
                              EList<Constraint> _constraints = e.getConstraints();
                              for(final Constraint constraint : _constraints) {
                                _builder.append("\t\t\t\t");
                                _builder.append("if (rules.get(\"");
                                String _name_90 = constraint.getType().getName();
                                _builder.append(_name_90, "\t\t\t\t");
                                _builder.append("\") == null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("\t");
                                _builder.append("rules.put(\"");
                                String _name_91 = constraint.getType().getName();
                                _builder.append(_name_91, "\t\t\t\t\t");
                                _builder.append("\", new ArrayList<String>());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t");
                                _builder.append("List<String> newrules = rules.get(\"");
                                String _name_92 = constraint.getType().getName();
                                _builder.append(_name_92, "\t\t\t\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                {
                                  EList<InvariantCS> _expressions = constraint.getExpressions();
                                  boolean _tripleNotEquals_45 = (_expressions != null);
                                  if (_tripleNotEquals_45) {
                                    {
                                      EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                                      for(final InvariantCS expression : _expressions_1) {
                                        _builder.append("\t\t\t\t");
                                        _builder.append("newrules.add(\"");
                                        String _constraintText = WodelUtils.getConstraintText(fileURI.lastSegment(), expression);
                                        _builder.append(_constraintText, "\t\t\t\t");
                                        _builder.append("\");");
                                        _builder.newLineIfNotEmpty();
                                      }
                                    }
                                  }
                                }
                                {
                                  EList<String> _rules = constraint.getRules();
                                  boolean _tripleNotEquals_46 = (_rules != null);
                                  if (_tripleNotEquals_46) {
                                    {
                                      EList<String> _rules_1 = constraint.getRules();
                                      for(final String rule : _rules_1) {
                                        _builder.append("\t\t\t\t");
                                        _builder.append("newrules.add(\"");
                                        _builder.append(rule, "\t\t\t\t");
                                        _builder.append("\");");
                                        _builder.newLineIfNotEmpty();
                                      }
                                    }
                                  }
                                }
                                _builder.append("\t\t\t\t");
                                _builder.append("rules.put(\"");
                                String _name_93 = constraint.getType().getName();
                                _builder.append(_name_93, "\t\t\t\t");
                                _builder.append("\", newrules);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              if ((b == null)) {
                                _builder.append("\t\t\t\t");
                                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                                _builder.newLine();
                              } else {
                                {
                                  int _size = b.getFrom().size();
                                  boolean _equals_4 = (_size == 0);
                                  if (_equals_4) {
                                    _builder.append("\t\t\t\t");
                                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                                    String _name_94 = b.getName();
                                    _builder.append(_name_94, "\t\t\t\t");
                                    _builder.append("/Output\" + k[0] + \".model\";");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    _builder.append("\t\t\t\t");
                                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                                    String _name_95 = b.getName();
                                    _builder.append(_name_95, "\t\t\t\t");
                                    _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t\t\t");
                            _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
                            _builder.newLine();
                            {
                              if ((b == null)) {
                                {
                                  if ((standalone == false)) {
                                    _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);");
                                    _builder.newLine();
                                  } else {
                                    _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                                    String _name_96 = project.getName();
                                    _builder.append(_name_96);
                                    _builder.append("\", serialize, test, classes, ");
                                    _builder.append(className);
                                    _builder.append(".class, true);");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              } else {
                                {
                                  if ((standalone == false)) {
                                    _builder.append("\t\t\t\t");
                                    _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                                    String _name_97 = b.getName();
                                    _builder.append(_name_97, "\t\t\t\t");
                                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    _builder.append("\t\t\t\t");
                                    _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                                    String _name_98 = b.getName();
                                    _builder.append(_name_98, "\t\t\t\t");
                                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                                    String _name_99 = project.getName();
                                    _builder.append(_name_99, "\t\t\t\t");
                                    _builder.append("\", serialize, test, classes, ");
                                    _builder.append(className, "\t\t\t\t");
                                    _builder.append(".class, true, false);");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t\t\t\t");
                            _builder.append("if (isRepeated == false) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("numMutantsGenerated++;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("monitor.worked(1);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t");
                            _builder.append("k[0] = k[0] + 1;");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("//if (muts != null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("//\tmuts.getMuts().clear();");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("//}");
                            _builder.newLine();
                            _builder.append("}  finally {");
                            _builder.newLine();
                            _builder.append("\t        ");
                            _builder.append("MutatorUtils.rollbackMutations(");
                            _builder.newLine();
                            _builder.append("\t            ");
                            _builder.append("muts,");
                            _builder.newLine();
                            _builder.append("\t            ");
                            _builder.append("mutsMark);");
                            _builder.newLine();
                            _builder.append("\t    ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t\t\t");
                            _builder.append("} finally {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t\t\t");
                            _builder.append("models.remove(resource);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t    ");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                  }
                }
                {
                  boolean _not = (!((mut.getName() != null) && (mut.getObject() instanceof CompleteTypeSelection)));
                  if (_not) {
                    {
                      if (((mut.getObject().getResource() == null) && (!closureHasAdditionalResources))) {
                        _builder.append("if (objects == null || objects.isEmpty()) {");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_77 = mut.getContainer();
                          boolean _tripleEquals_13 = (_container_77 == null);
                          if (_tripleEquals_13) {
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("continue;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("String tempModel =");
                        _builder.newLine();
                        _builder.append("\t\t        ");
                        _builder.append("WodelTempModelContext.nextModelPath(");
                        _builder.newLine();
                        _builder.append("\t\t            ");
                        _builder.append("model,");
                        _builder.newLine();
                        _builder.append("\t\t            ");
                        _builder.append("\"");
                        _builder.append(methodName, "\t\t            ");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("if (objects == null || objects.isEmpty()) {");
                        _builder.newLine();
                        {
                          ObSelectionStrategy _container_78 = mut.getContainer();
                          boolean _tripleEquals_14 = (_container_78 == null);
                          if (_tripleEquals_14) {
                            _builder.append("\t");
                            _builder.append("return numMutantsGenerated;");
                            _builder.newLine();
                          } else {
                            _builder.append("\t");
                            _builder.append("continue;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("String tempModel =");
                        _builder.newLine();
                        _builder.append("\t\t        ");
                        _builder.append("WodelTempModelContext.nextModelPath(");
                        _builder.newLine();
                        _builder.append("\t\t            ");
                        _builder.append("model,");
                        _builder.newLine();
                        _builder.append("\t\t            ");
                        _builder.append("\"");
                        _builder.append(methodName, "\t\t            ");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  ObSelectionStrategy _object_10 = mut.getObject();
                  boolean _not_1 = (!(_object_10 instanceof CompleteTypeSelection));
                  if (_not_1) {
                    _builder.append("            ");
                    _builder.append("for (EObject object : objects) {");
                    _builder.newLine();
                    _builder.append("\t\t\t                ");
                    _builder.append("SelectObjectMutator mut = null;");
                    _builder.newLine();
                    {
                      if (((mut.getObject().getResource() != null) || closureHasAdditionalResources)) {
                        _builder.append("        ");
                        _builder.append("Resource readOnlyResource = null;");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("\t");
                        _builder.append("readOnlyResource =");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("\t        ");
                        _builder.append("ModelManager.findModel(");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("\t            ");
                        _builder.append("selection,");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("\t            ");
                        _builder.append("object);");
                        _builder.newLine();
                        _builder.append("        ");
                        _builder.append("\t");
                        _builder.newLine();
                      }
                    }
                    _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
                    _builder.newLine();
                    {
                      if (((mut.getName() != null) && (!(mut.getObject() instanceof CompleteTypeSelection)))) {
                        _builder.append("Resource resource = owned.own(");
                        _builder.newLine();
                      } else {
                        _builder.append("resource = owned.own(");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t    \t\t\t\t\t\t\t\t\t\t\t                    ");
                    _builder.append("ModelManager.cloneModel(");
                    _builder.newLine();
                    _builder.append("\t    \t\t\t\t\t\t\t\t\t\t\t                        ");
                    _builder.append("model,");
                    _builder.newLine();
                    _builder.append("\t    \t\t\t\t\t\t\t\t\t\t\t                        ");
                    _builder.append("tempModel));");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("models.add(resource);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("try {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("EObject localObject =");
                    _builder.newLine();
                    _builder.append("\t\t                ");
                    _builder.append("ModelManager.getObject(");
                    _builder.newLine();
                    {
                      String _resource_15 = mut.getObject().getResource();
                      boolean _tripleNotEquals_47 = (_resource_15 != null);
                      if (_tripleNotEquals_47) {
                        _builder.append("readOnlyResource,");
                        _builder.newLine();
                      } else {
                        _builder.append("\t\t                ");
                        _builder.append("resource,");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t    \t\t\t\t");
                    _builder.newLine();
                    _builder.append("\t\t                    ");
                    _builder.append("object);");
                    _builder.newLine();
                    {
                      if (closureHasAdditionalResources) {
                        _builder.append("\t\t\t");
                        _builder.append("if (localObject == null) {");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("\t");
                        _builder.append("localObject = ModelManager.getObject(");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("    \t    \t\t               \t");
                        _builder.append("readOnlyResource,");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("    \t    \t\t               ");
                        _builder.append("object);");
                        _builder.newLine();
                        _builder.append("\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t\t                    ");
                    _builder.append("if (localObject == null) {");
                    _builder.newLine();
                    _builder.append("\t\t                    \t");
                    _builder.append("continue;");
                    _builder.newLine();
                    _builder.append("\t\t                    ");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("ObSelectionStrategy objectSelection = null;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("EObject selectedObject = null;");
                    _builder.newLine();
                    {
                      if (((mut.getObject().getRefType() != null) && mut.getObject().getRefType().isMany())) {
                        _builder.append("\t\t");
                        _builder.append("List<EObject> l = ModelManager.getReferences(\"");
                        String _name_100 = mut.getObject().getRefType().getName();
                        _builder.append(_name_100, "\t\t");
                        _builder.append("\", localObject);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("ModelManager.sortEObjectsDeterministically(l);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("selectedObject = l.get(ModelManager.getRandomIndex(l));");
                        _builder.newLine();
                      } else {
                        if (((mut.getObject().getRefType() != null) && (!mut.getObject().getRefType().isMany()))) {
                          _builder.append("\t\t");
                          _builder.append("selectedObject = (EObject) ModelManager.getReferenced(\"");
                          String _name_101 = mut.getObject().getRefType().getName();
                          _builder.append(_name_101, "\t\t");
                          _builder.append("\", localObject);");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t\t");
                          _builder.append("selectedObject = localObject;");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("if (resource != null) {");
                    _builder.newLine();
                    {
                      if (closureHasAdditionalResources) {
                        _builder.append("\t\t\t");
                        _builder.append("boolean belongsToAdditionalResources = false;");
                        _builder.newLine();
                      }
                    }
                    {
                      ObSelectionStrategy _object_11 = mut.getObject();
                      boolean _not_2 = (!(_object_11 instanceof CompleteTypeSelection));
                      if (_not_2) {
                        {
                          ObSelectionStrategy _container_79 = mut.getContainer();
                          boolean _tripleNotEquals_48 = (_container_79 != null);
                          if (_tripleNotEquals_48) {
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.append("EObject oldContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("containerSelectionList");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append(".get(j)");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append(".getObject();");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.append("EObject localContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("MutatorUtils.recoverLocalObject(");
                            _builder.newLine();
                            {
                              String _resource_16 = mut.getObject().getResource();
                              boolean _tripleNotEquals_49 = (_resource_16 != null);
                              if (_tripleNotEquals_49) {
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("oldContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("if (localContainer == null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("localContainer =");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("ModelManager.getObject(");
                            _builder.newLine();
                            {
                              String _resource_17 = mut.getObject().getResource();
                              boolean _tripleNotEquals_50 = (_resource_17 != null);
                              if (_tripleNotEquals_50) {
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                        ");
                            _builder.append("oldContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("}");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("if (localContainer == null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("localContainer =");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("MutatorUtils.recoverLocalObject(");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("oldContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("if (localContainer != null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t               \t\t");
                                _builder.append("belongsToAdditionalResources = true;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t            ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t    ");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t            ");
                                _builder.append("if (localContainer == null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("localContainer =");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("ModelManager.getObject(");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("oldContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("if (localContainer != null) {");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t               \t\t");
                                _builder.append("belongsToAdditionalResources = true;");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("            ");
                                _builder.append("\t\t\t\t\t            ");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("if (localContainer == null) {");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("continue;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("ObSelectionStrategy");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("localContainerSelection = null;");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("            ");
                            _builder.append("SpecificReferenceSelection");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("localReferenceSelection = null;");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t");
                                _builder.append("    ");
                                _builder.append("if (!belongsToAdditionalResources) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localContainerSelection = new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_18 = mut.getObject().getResource();
                              boolean _tripleNotEquals_51 = (_resource_18 != null);
                              if (_tripleNotEquals_51) {
                                _builder.append("\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                        ");
                            _builder.append("localContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localReferenceSelection = new SpecificReferenceSelection(");
                            _builder.newLine();
                            {
                              String _resource_19 = mut.getObject().getResource();
                              boolean _tripleNotEquals_52 = (_resource_19 != null);
                              if (_tripleNotEquals_52) {
                                _builder.append("\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            {
                              ObSelectionStrategy _container_80 = mut.getContainer();
                              EReference _refType_6 = null;
                              if (_container_80!=null) {
                                _refType_6=_container_80.getRefType();
                              }
                              boolean _tripleNotEquals_53 = (_refType_6 != null);
                              if (_tripleNotEquals_53) {
                                _builder.append("\t\t\t");
                                _builder.append("                        ");
                                _builder.append("\"");
                                String _name_102 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_102, "\t\t\t                        ");
                                _builder.append("\",");
                                _builder.newLineIfNotEmpty();
                              } else {
                                {
                                  ObSelectionStrategy _container_81 = mut.getContainer();
                                  EReference _refRefType_6 = null;
                                  if (_container_81!=null) {
                                    _refRefType_6=_container_81.getRefRefType();
                                  }
                                  boolean _tripleNotEquals_54 = (_refRefType_6 != null);
                                  if (_tripleNotEquals_54) {
                                    _builder.append("\t\t\t");
                                    _builder.append("                        ");
                                    _builder.append("\"");
                                    String _name_103 = mut.getContainer().getRefRefType().getName();
                                    _builder.append(_name_103, "\t\t\t                        ");
                                    _builder.append("\",");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    {
                                      ObSelectionStrategy _container_82 = mut.getContainer();
                                      EReference _refRefRefType_6 = null;
                                      if (_container_82!=null) {
                                        _refRefRefType_6=_container_82.getRefRefRefType();
                                      }
                                      boolean _tripleNotEquals_55 = (_refRefRefType_6 != null);
                                      if (_tripleNotEquals_55) {
                                        _builder.append("\t\t\t");
                                        _builder.append("                        ");
                                        _builder.append("\"");
                                        String _name_104 = mut.getContainer().getRefRefRefType().getName();
                                        _builder.append(_name_104, "\t\t\t                        ");
                                        _builder.append("\",");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        _builder.append("\t\t\t");
                                        _builder.append("                        ");
                                        _builder.append("null,");
                                        _builder.newLine();
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                        ");
                            _builder.append("localContainer);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("objectSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_20 = mut.getObject().getResource();
                              boolean _tripleNotEquals_56 = (_resource_20 != null);
                              if (_tripleNotEquals_56) {
                                _builder.append("\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                        ");
                            _builder.append("selectedObject);");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("    ");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("mut =");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                ");
                            _builder.append("new SelectObjectMutator(");
                            _builder.newLine();
                            {
                              String _resource_21 = mut.getObject().getResource();
                              boolean _tripleNotEquals_57 = (_resource_21 != null);
                              if (_tripleNotEquals_57) {
                                _builder.append("\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localReferenceSelection,");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("localContainerSelection,");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("                    ");
                            _builder.append("objectSelection);");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("if (belongsToAdditionalResources) {");
                                _builder.newLine();
                                _builder.append("\t                    ");
                                _builder.append("localContainerSelection = new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("localContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t    ");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("localReferenceSelection = new SpecificReferenceSelection(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                {
                                  ObSelectionStrategy _container_83 = mut.getContainer();
                                  EReference _refType_7 = null;
                                  if (_container_83!=null) {
                                    _refType_7=_container_83.getRefType();
                                  }
                                  boolean _tripleNotEquals_58 = (_refType_7 != null);
                                  if (_tripleNotEquals_58) {
                                    _builder.append("\t\t\t\t\t                        ");
                                    _builder.append("\"");
                                    String _name_105 = mut.getContainer().getRefType().getName();
                                    _builder.append(_name_105, "\t\t\t\t\t                        ");
                                    _builder.append("\",");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    {
                                      ObSelectionStrategy _container_84 = mut.getContainer();
                                      EReference _refRefType_7 = null;
                                      if (_container_84!=null) {
                                        _refRefType_7=_container_84.getRefRefType();
                                      }
                                      boolean _tripleNotEquals_59 = (_refRefType_7 != null);
                                      if (_tripleNotEquals_59) {
                                        _builder.append("\t\t\t\t\t                        ");
                                        _builder.append("\"");
                                        String _name_106 = mut.getContainer().getRefRefType().getName();
                                        _builder.append(_name_106, "\t\t\t\t\t                        ");
                                        _builder.append("\",");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        {
                                          ObSelectionStrategy _container_85 = mut.getContainer();
                                          EReference _refRefRefType_7 = null;
                                          if (_container_85!=null) {
                                            _refRefRefType_7=_container_85.getRefRefRefType();
                                          }
                                          boolean _tripleNotEquals_60 = (_refRefRefType_7 != null);
                                          if (_tripleNotEquals_60) {
                                            _builder.append("\t\t\t\t\t                        ");
                                            _builder.append("\"");
                                            String _name_107 = mut.getContainer().getRefRefRefType().getName();
                                            _builder.append(_name_107, "\t\t\t\t\t                        ");
                                            _builder.append("\",");
                                            _builder.newLineIfNotEmpty();
                                          } else {
                                            _builder.append("\t\t\t\t\t                        ");
                                            _builder.append("null,");
                                            _builder.newLine();
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("localContainer);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t    ");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("objectSelection =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("selectedObject);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t    ");
                                _builder.newLine();
                                _builder.append("mut =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                ");
                                _builder.append("new SelectObjectMutator(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("localReferenceSelection,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("localContainerSelection,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("objectSelection);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                          } else {
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("if (!belongsToAdditionalResources) {");
                                _builder.newLine();
                              }
                            }
                            _builder.append("objectSelection =");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                    ");
                            _builder.append("new SpecificObjectSelection(");
                            _builder.newLine();
                            {
                              String _resource_22 = mut.getObject().getResource();
                              boolean _tripleNotEquals_61 = (_resource_22 != null);
                              if (_tripleNotEquals_61) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t                        ");
                            _builder.append("selectedObject);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t                        \t\t\t\t\t");
                            _builder.newLine();
                            _builder.append("mut = new SelectObjectMutator(");
                            _builder.newLine();
                            {
                              String _resource_23 = mut.getObject().getResource();
                              boolean _tripleNotEquals_62 = (_resource_23 != null);
                              if (_tripleNotEquals_62) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                              } else {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("resource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("packages,");
                                _builder.newLine();
                              }
                            }
                            _builder.append("\t\t\t\t\t\t\t");
                            _builder.append("null, null, objectSelection);");
                            _builder.newLine();
                            {
                              if (closureHasAdditionalResources) {
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("if (belongsToAdditionalResources) {");
                                _builder.newLine();
                                _builder.append("objectSelection =");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                    ");
                                _builder.append("new SpecificObjectSelection(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                        ");
                                _builder.append("selectedObject);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t                        \t\t\t\t\t");
                                _builder.newLine();
                                _builder.append("mut = new SelectObjectMutator(");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("readOnlyResource,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("selectionPackages,");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t\t\t");
                                _builder.append("null, null, objectSelection);");
                                _builder.newLine();
                                _builder.append("\t\t\t\t\t");
                                _builder.append("}");
                                _builder.newLine();
                              }
                            }
                          }
                        }
                      }
                    }
                    _builder.append("\t\t\t");
                    _builder.append("Mutator mutator = null;");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("if (muts == null) {");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
                    _builder.newLine();
                    _builder.append("\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("//COUNTER: ");
                    int _get_12 = nRegistryMutation[0];
                    int _plus_17 = (_get_12 + 1);
                    int _set_12 = nRegistryMutation[0] = _plus_17;
                    _builder.append(_set_12);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//COUNTER: ");
                    int _get_13 = nRegistryMethodCall[0];
                    int _plus_18 = (_get_13 + 1);
                    int _set_13 = nRegistryMethodCall[0] = _plus_18;
                    _builder.append(_set_13);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REGISTRY METHOD NAME:");
                    String _string_2 = Integer.valueOf((nRegistryMethodCall[0])).toString();
                    String registryMethodName_1 = ("registry" + _string_2);
                    _builder.newLineIfNotEmpty();
                    _builder.append("   \t\t");
                    _builder.append("int mutsMark = mutationMark(muts);");
                    _builder.newLine();
                    {
                      if ((executeMutation == true)) {
                        _builder.append("if (mut != null) {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("/*");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("* IMPORTANT:");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("* Capture the removed EObject from the PRE-MUTATION");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("* source model. Do not use mut.getObject() here:");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("* RemoveObjectMutator only populates that information");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("* during mutate().");
                        _builder.newLine();
                        _builder.append("\t     ");
                        _builder.append("*/");
                        _builder.newLine();
                        _builder.append("\t    ");
                        _builder.append("EObject clue =");
                        _builder.newLine();
                        _builder.append("\t        ");
                        _builder.append("findEObjectForRegistry(");
                        _builder.newLine();
                        _builder.append("\t            ");
                        _builder.append("seed,");
                        _builder.newLine();
                        {
                          String _resource_24 = mut.getObject().getResource();
                          boolean _tripleEquals_15 = (_resource_24 == null);
                          if (_tripleEquals_15) {
                            _builder.append("\t            ");
                            _builder.append("resource,");
                            _builder.newLine();
                          } else {
                            _builder.append("readOnlyResource,");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t            ");
                        _builder.append("objectSelection.getObject(),");
                        _builder.newLine();
                        _builder.append("\t            ");
                        _builder.append("null,");
                        _builder.newLine();
                        _builder.append("\t            ");
                        _builder.append("null,");
                        _builder.newLine();
                        _builder.append("\t            ");
                        _builder.append("mutPaths,");
                        _builder.newLine();
                        {
                          String _resource_25 = mut.getObject().getResource();
                          boolean _tripleNotEquals_63 = (_resource_25 != null);
                          if (_tripleNotEquals_63) {
                            _builder.append("\t       ");
                            _builder.append("selectionPackages);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t       ");
                            _builder.append("packages);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("Object mutated = mut.mutate();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("if (mutated != null) {");
                        _builder.newLine();
                        {
                          String _name_108 = mut.getName();
                          boolean _tripleNotEquals_64 = (_name_108 != null);
                          if (_tripleNotEquals_64) {
                            _builder.append("\t\t\t");
                            _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                            _builder.newLine();
                            {
                              ObSelectionStrategy _object_12 = mut.getObject();
                              boolean _not_3 = (!(_object_12 instanceof CompleteTypeSelection));
                              if (_not_3) {
                                _builder.append("\t\t\t");
                                _builder.append("hmObjects.put(\"");
                                String _name_109 = mut.getName();
                                _builder.append(_name_109, "\t\t\t");
                                _builder.append("\", entry);");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("\t\t\t");
                                _builder.append("hmObjects.remove(\"");
                                String _name_110 = mut.getName();
                                _builder.append(_name_110, "\t\t\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("hmList.put(\"");
                                String _name_111 = mut.getName();
                                _builder.append(_name_111, "\t\t\t");
                                _builder.append("\", entries);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        _builder.append("\t\t\t");
                        _builder.append("AppMutation appMut = ");
                        _builder.append(registryMethodName_1, "\t\t\t");
                        _builder.append("(mut, hmMutator, seed, resource, clue, mutPaths, packages);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("//\t\t\t\t\t\tAppMutation appMut = ");
                        _builder.append(registryMethodName_1);
                        _builder.append("(mut, hmMutator, seed, resource, clue, mutPaths, packages);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t\t");
                        _builder.append("if (appMut != null) {");
                        _builder.newLine();
                        _builder.append("\t\t\t\t");
                        _builder.append("muts.getMuts().add(appMut);");
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
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("mutator = mut;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("try {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("if (mutator != null) {");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("//COUNTER: ");
                    int _get_14 = nMethodCall[0];
                    int _plus_19 = (_get_14 + 1);
                    int _set_14 = nMethodCall[0] = _plus_19;
                    _builder.append(_set_14, "\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("//MUTATION METHOD NAME:");
                    String _string_3 = Integer.valueOf((nMethodCall[0])).toString();
                    String nMethodName_1 = ("mutation" + _string_3);
                    _builder.newLineIfNotEmpty();
                    {
                      if ((last == false)) {
                        {
                          if ((standalone == false)) {
                            _builder.append("\t\t");
                            _builder.append(nMethodName_1, "\t\t");
                            _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                            _builder.newLine();
                          } else {
                            _builder.append("\t\t");
                            _builder.append(nMethodName_1, "\t\t");
                            _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t\t\t\t\t");
                            _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("numMutantsGenerated = k[0];");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t");
                        _builder.append("} finally {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     ");
                        _builder.append("MutatorUtils.rollbackMutations(");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
                        _builder.append("muts,");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
                        _builder.append("mutsMark);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("} finally {");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("models.remove(resource);");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t\t\t\t\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      if ((last == true)) {
                        _builder.append("\t\t");
                        _builder.append("// MUTANT COMPLETION AND REGISTRY");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
                        _builder.newLine();
                        {
                          EList<Constraint> _constraints_1 = e.getConstraints();
                          for(final Constraint constraint_1 : _constraints_1) {
                            _builder.append("\t\t");
                            _builder.append("if (rules.get(\"");
                            String _name_112 = constraint_1.getType().getName();
                            _builder.append(_name_112, "\t\t");
                            _builder.append("\") == null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("rules.put(\"");
                            String _name_113 = constraint_1.getType().getName();
                            _builder.append(_name_113, "\t\t\t");
                            _builder.append("\", new ArrayList<String>());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("List<String> newrules = rules.get(\"");
                            String _name_114 = constraint_1.getType().getName();
                            _builder.append(_name_114, "\t\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            {
                              EList<InvariantCS> _expressions_2 = constraint_1.getExpressions();
                              boolean _tripleNotEquals_65 = (_expressions_2 != null);
                              if (_tripleNotEquals_65) {
                                {
                                  EList<InvariantCS> _expressions_3 = constraint_1.getExpressions();
                                  for(final InvariantCS expression_1 : _expressions_3) {
                                    _builder.append("\t\t");
                                    _builder.append("newrules.add(\"");
                                    String _constraintText_1 = WodelUtils.getConstraintText(fileURI.lastSegment(), expression_1);
                                    _builder.append(_constraintText_1, "\t\t");
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            {
                              EList<String> _rules_2 = constraint_1.getRules();
                              boolean _tripleNotEquals_66 = (_rules_2 != null);
                              if (_tripleNotEquals_66) {
                                {
                                  EList<String> _rules_3 = constraint_1.getRules();
                                  for(final String rule_1 : _rules_3) {
                                    _builder.append("\t\t");
                                    _builder.append("newrules.add(\"");
                                    _builder.append(rule_1, "\t\t");
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            _builder.append("\t\t");
                            _builder.append("rules.put(\"");
                            String _name_115 = constraint_1.getType().getName();
                            _builder.append(_name_115, "\t\t");
                            _builder.append("\", newrules);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          if ((b == null)) {
                            _builder.append("\t\t");
                            _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                            _builder.newLine();
                          } else {
                            {
                              int _size_1 = b.getFrom().size();
                              boolean _equals_5 = (_size_1 == 0);
                              if (_equals_5) {
                                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                                String _name_116 = b.getName();
                                _builder.append(_name_116);
                                _builder.append("/Output\" + k[0] + \".model\";");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                                String _name_117 = b.getName();
                                _builder.append(_name_117);
                                _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
                        _builder.newLine();
                        {
                          if ((b == null)) {
                            {
                              if ((standalone == false)) {
                                _builder.append("   \t\t");
                                _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                                _builder.newLine();
                                _builder.append("   \t\t");
                                _builder.append("\t");
                                _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);");
                                _builder.newLine();
                              } else {
                                _builder.append("   \t\t");
                                _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                                _builder.newLine();
                                _builder.append("   \t\t");
                                _builder.append("\t");
                                _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                                String _name_118 = project.getName();
                                _builder.append(_name_118, "   \t\t\t");
                                _builder.append("\", serialize, test, classes, ");
                                _builder.append(className, "   \t\t\t");
                                _builder.append(".class, true);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          } else {
                            {
                              if ((standalone == false)) {
                                _builder.append("\t\t   \t\t");
                                _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                                _builder.newLine();
                                _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                                String _name_119 = b.getName();
                                _builder.append(_name_119);
                                _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                                String _name_120 = b.getName();
                                _builder.append(_name_120, "\t");
                                _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                                String _name_121 = project.getName();
                                _builder.append(_name_121, "\t");
                                _builder.append("\", serialize, test, classes, ");
                                _builder.append(className, "\t");
                                _builder.append(".class, true, false);");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("if (isRepeated == false) {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("numMutantsGenerated++;");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("monitor.worked(1);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("k[0] = k[0] + 1;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("//if (muts != null) {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("//\tmuts.getMuts().clear();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("//}");
                            _builder.newLine();
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}  finally {");
                            _builder.newLine();
                            _builder.append("\t\t        ");
                            _builder.append("MutatorUtils.rollbackMutations(");
                            _builder.newLine();
                            _builder.append("\t\t            ");
                            _builder.append("muts,");
                            _builder.newLine();
                            _builder.append("\t\t            ");
                            _builder.append("mutsMark);");
                            _builder.newLine();
                            _builder.append("\t\t    ");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("} finally {");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("models.remove(resource);");
                            _builder.newLine();
                            _builder.append("\t\t\t\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.newLine();
                            _builder.newLine();
                          }
                        }
                        _builder.append("}");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.newLine();
                      }
                    }
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
              ObSelectionStrategy _container_86 = mut.getContainer();
              boolean _tripleNotEquals_67 = (_container_86 != null);
              if (_tripleNotEquals_67) {
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("//END SELECT OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
