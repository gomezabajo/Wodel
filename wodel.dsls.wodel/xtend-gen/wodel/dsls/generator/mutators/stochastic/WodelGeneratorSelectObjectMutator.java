package wodel.dsls.generator.mutators.stochastic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Expression;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.Resource;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class WodelGeneratorSelectObjectMutator extends WodelGeneratorGenericOperatorStochasticMutator {
  @Override
  public CharSequence apply(final Mutator mt, final String methodName, final int[] nMutation, final int[] nRegistryMutation, final Program program, final IProject project, final String className, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof SelectObjectMutator)) {
        _builder.append("//");
        SelectObjectMutator mut = ((SelectObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("//SELECT OBJECT ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("return mutations;");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        _builder.append("SpecificReferenceSelection referenceSelection = null;");
        _builder.newLine();
        _builder.append("List<EPackage> resourcePackages = packages;");
        _builder.newLine();
        _builder.append("List<Resource> resources = new ArrayList<Resource>();");
        _builder.newLine();
        _builder.append("resources.add(model);");
        _builder.newLine();
        _builder.append("//");
        boolean rts = false;
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        int i = 0;
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        int j = 0;
        _builder.newLineIfNotEmpty();
        {
          if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof CompleteTypeSelection))) {
            {
              String _resource = mut.getObject().getResource();
              boolean _tripleEquals = (_resource == null);
              if (_tripleEquals) {
                {
                  ObSelectionStrategy _container = mut.getContainer();
                  boolean _tripleEquals_1 = (_container == null);
                  if (_tripleEquals_1) {
                    {
                      ObSelectionStrategy _object = mut.getObject();
                      if ((_object instanceof RandomTypeSelection)) {
                        _builder.append("//");
                        _builder.append(rts = true);
                        _builder.newLineIfNotEmpty();
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                        ObSelectionStrategy _object_1 = mut.getObject();
                        String _name = ((RandomTypeSelection) _object_1).getType().getName();
                        _builder.append(_name);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_2 = mut.getObject();
                      if ((_object_2 instanceof CompleteTypeSelection)) {
                        _builder.append("//");
                        _builder.append(rts = true);
                        _builder.newLineIfNotEmpty();
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                        ObSelectionStrategy _object_3 = mut.getObject();
                        String _name_1 = ((CompleteTypeSelection) _object_3).getType().getName();
                        _builder.append(_name_1);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    {
                      ObSelectionStrategy _container_1 = mut.getContainer();
                      if ((_container_1 instanceof RandomTypeSelection)) {
                        _builder.append("//");
                        _builder.append(rts = true);
                        _builder.newLineIfNotEmpty();
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                        ObSelectionStrategy _container_2 = mut.getContainer();
                        String _name_2 = ((RandomTypeSelection) _container_2).getType().getName();
                        _builder.append(_name_2);
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                        _builder.append("EObject container = rts.getObject();");
                        _builder.newLine();
                        {
                          EReference _refType = mut.getContainer().getRefType();
                          boolean _tripleNotEquals = (_refType != null);
                          if (_tripleNotEquals) {
                            _builder.append("//");
                            String refName = mut.getContainer().getRefType().getName();
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refRefType = mut.getContainer().getRefRefType();
                              boolean _tripleNotEquals_1 = (_refRefType != null);
                              if (_tripleNotEquals_1) {
                                _builder.append("container = ModelManager.getReference(\"");
                                String _name_3 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_3);
                                _builder.append("\", container);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("//");
                                _builder.append(refName = mut.getContainer().getRefRefType().getName());
                                _builder.newLineIfNotEmpty();
                                {
                                  EReference _refRefRefType = mut.getContainer().getRefRefRefType();
                                  boolean _tripleNotEquals_2 = (_refRefRefType != null);
                                  if (_tripleNotEquals_2) {
                                    _builder.append("container = ModelManager.getReference(\"");
                                    String _name_4 = mut.getContainer().getRefRefType().getName();
                                    _builder.append(_name_4);
                                    _builder.append("\", container);");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("//");
                                    _builder.append(refName = mut.getContainer().getRefRefRefType().getName());
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                              }
                            }
                            _builder.append("containerSelection = new SpecificObjectSelection(packages, model, container);");
                            _builder.newLine();
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                            _builder.append(refName);
                            _builder.append("\", containerSelection);");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                            _builder.newLine();
                          }
                        }
                      } else {
                        ObSelectionStrategy _container_3 = mut.getContainer();
                        if ((_container_3 instanceof CompleteTypeSelection)) {
                          _builder.newLine();
                          _builder.append("//");
                          _builder.append(rts = true);
                          _builder.newLineIfNotEmpty();
                          _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
                          ObSelectionStrategy _container_4 = mut.getContainer();
                          String _name_5 = ((CompleteTypeSelection) _container_4).getType().getName();
                          _builder.append(_name_5);
                          _builder.append("\");");
                          _builder.newLineIfNotEmpty();
                          _builder.append("EObject container = rts.getObject();");
                          _builder.newLine();
                          _builder.append("containerSelection = new SpecificObjectSelection(packages, model, container);");
                          _builder.newLine();
                          {
                            EReference _refType_1 = mut.getContainer().getRefType();
                            boolean _tripleNotEquals_3 = (_refType_1 != null);
                            if (_tripleNotEquals_3) {
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, \"");
                              String _name_6 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_6);
                              _builder.append("\", containerSelection);");
                              _builder.newLineIfNotEmpty();
                            } else {
                              _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                              _builder.newLine();
                            }
                          }
                        } else {
                          ObSelectionStrategy _container_5 = mut.getContainer();
                          if ((_container_5 instanceof SpecificObjectSelection)) {
                            _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                            ObSelectionStrategy _container_6 = mut.getContainer();
                            String _name_7 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                            _builder.append(_name_7);
                            _builder.append(" = hmObjects.get(\"");
                            ObSelectionStrategy _container_7 = mut.getContainer();
                            String _name_8 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                            _builder.append(_name_8);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("if (entry_");
                            ObSelectionStrategy _container_8 = mut.getContainer();
                            String _name_9 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                            _builder.append(_name_9);
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("resourcePackages = entry_");
                            ObSelectionStrategy _container_9 = mut.getContainer();
                            String _name_10 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                            _builder.append(_name_10, "\t");
                            _builder.append(".getValue().getValue();");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("resources = new ArrayList<Resource>();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("resources.add(entry_");
                            ObSelectionStrategy _container_10 = mut.getContainer();
                            String _name_11 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                            _builder.append(_name_11, "\t");
                            _builder.append(".getValue().getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                            ObSelectionStrategy _container_11 = mut.getContainer();
                            String _name_12 = ((SpecificObjectSelection) _container_11).getObjSel().getName();
                            _builder.append(_name_12, "\t");
                            _builder.append(".getValue().getValue(), entry_");
                            ObSelectionStrategy _container_12 = mut.getContainer();
                            String _name_13 = ((SpecificObjectSelection) _container_12).getObjSel().getName();
                            _builder.append(_name_13, "\t");
                            _builder.append(".getValue().getKey(), entry_");
                            ObSelectionStrategy _container_13 = mut.getContainer();
                            String _name_14 = ((SpecificObjectSelection) _container_13).getObjSel().getName();
                            _builder.append(_name_14, "\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("} else {");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                            ObSelectionStrategy _container_14 = mut.getContainer();
                            String _name_15 = ((SpecificObjectSelection) _container_14).getObjSel().getName();
                            _builder.append(_name_15, "\t");
                            _builder.append(" = hmList.get(\"");
                            ObSelectionStrategy _container_15 = mut.getContainer();
                            String _name_16 = ((SpecificObjectSelection) _container_15).getObjSel().getName();
                            _builder.append(_name_16, "\t");
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("if (listEntry_");
                            ObSelectionStrategy _container_16 = mut.getContainer();
                            String _name_17 = ((SpecificObjectSelection) _container_16).getObjSel().getName();
                            _builder.append(_name_17, "\t");
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("resourcePackages = listEntry_");
                            ObSelectionStrategy _container_17 = mut.getContainer();
                            String _name_18 = ((SpecificObjectSelection) _container_17).getObjSel().getName();
                            _builder.append(_name_18, "\t\t");
                            _builder.append(".get(0).getValue().getValue();");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("resources = new ArrayList<Resource>();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("resources.add(listEntry_");
                            ObSelectionStrategy _container_18 = mut.getContainer();
                            String _name_19 = ((SpecificObjectSelection) _container_18).getObjSel().getName();
                            _builder.append(_name_19, "\t\t");
                            _builder.append(".get(0).getValue().getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                            ObSelectionStrategy _container_19 = mut.getContainer();
                            String _name_20 = ((SpecificObjectSelection) _container_19).getObjSel().getName();
                            _builder.append(_name_20, "\t\t");
                            _builder.append(") {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t\t");
                            _builder.append("EObject obj = ent.getKey();");
                            _builder.newLine();
                            _builder.append("\t\t\t");
                            _builder.append("objs.add(obj);");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("containerSelection = new SpecificObjectSelection(listEntry_");
                            ObSelectionStrategy _container_20 = mut.getContainer();
                            String _name_21 = ((SpecificObjectSelection) _container_20).getObjSel().getName();
                            _builder.append(_name_21, "\t\t");
                            _builder.append(".get(0).getValue().getValue(), listEntry_");
                            ObSelectionStrategy _container_21 = mut.getContainer();
                            String _name_22 = ((SpecificObjectSelection) _container_21).getObjSel().getName();
                            _builder.append(_name_22, "\t\t");
                            _builder.append(".get(0).getValue().getKey(), objs);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("else {");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("return mutations;");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("}");
                            _builder.newLine();
                            _builder.append("if (entry_");
                            ObSelectionStrategy _container_22 = mut.getContainer();
                            String _name_23 = ((SpecificObjectSelection) _container_22).getObjSel().getName();
                            _builder.append(_name_23);
                            _builder.append(" != null) {");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("resourcePackages = entry_");
                            ObSelectionStrategy _container_23 = mut.getContainer();
                            String _name_24 = ((SpecificObjectSelection) _container_23).getObjSel().getName();
                            _builder.append(_name_24, "\t");
                            _builder.append(".getValue().getValue();");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("resources = new ArrayList<Resource>();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("resources.add(entry_");
                            ObSelectionStrategy _container_24 = mut.getContainer();
                            String _name_25 = ((SpecificObjectSelection) _container_24).getObjSel().getName();
                            _builder.append(_name_25, "\t");
                            _builder.append(".getValue().getKey());");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t");
                            _builder.append("List<EObject> recovered = new ArrayList<EObject>();");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("recovered.add(entry_");
                            ObSelectionStrategy _container_25 = mut.getContainer();
                            String _name_26 = ((SpecificObjectSelection) _container_25).getObjSel().getName();
                            _builder.append(_name_26, "\t");
                            _builder.append(".getKey());");
                            _builder.newLineIfNotEmpty();
                            {
                              EReference _refType_2 = mut.getContainer().getRefType();
                              boolean _tripleNotEquals_4 = (_refType_2 != null);
                              if (_tripleNotEquals_4) {
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("//");
                                String refName_1 = mut.getContainer().getRefType().getName();
                                _builder.newLineIfNotEmpty();
                                {
                                  EReference _refRefType_1 = mut.getContainer().getRefRefType();
                                  boolean _tripleNotEquals_5 = (_refRefType_1 != null);
                                  if (_tripleNotEquals_5) {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("Object ob = ModelManager.getReferenced(\"");
                                    String _name_27 = mut.getContainer().getRefType().getName();
                                    _builder.append(_name_27, "\t\t");
                                    _builder.append("\", recovered.get(0));");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("if (ob instanceof EObject) {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("recovered.add((EObject) ob);");
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
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("recovered.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("//");
                                    _builder.append(refName_1 = mut.getContainer().getRefRefType().getName(), "\t\t");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                                    ObSelectionStrategy _container_26 = mut.getContainer();
                                    String _name_28 = ((SpecificObjectSelection) _container_26).getObjSel().getName();
                                    _builder.append(_name_28, "\t\t");
                                    _builder.append(".getValue().getValue(), entry_");
                                    ObSelectionStrategy _container_27 = mut.getContainer();
                                    String _name_29 = ((SpecificObjectSelection) _container_27).getObjSel().getName();
                                    _builder.append(_name_29, "\t\t");
                                    _builder.append(".getValue().getKey(), recovered.get(1));");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                    ObSelectionStrategy _container_28 = mut.getContainer();
                                    String _name_30 = ((SpecificObjectSelection) _container_28).getObjSel().getName();
                                    _builder.append(_name_30, "\t\t");
                                    _builder.append(".getValue().getValue(), entry_");
                                    ObSelectionStrategy _container_29 = mut.getContainer();
                                    String _name_31 = ((SpecificObjectSelection) _container_29).getObjSel().getName();
                                    _builder.append(_name_31, "\t\t");
                                    _builder.append(".getValue().getKey(), \"");
                                    _builder.append(refName_1, "\t\t");
                                    _builder.append("\", recovered.get(1));");
                                    _builder.newLineIfNotEmpty();
                                    {
                                      EReference _refRefRefType_1 = mut.getContainer().getRefRefRefType();
                                      boolean _tripleNotEquals_6 = (_refRefRefType_1 != null);
                                      if (_tripleNotEquals_6) {
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("ob = ModelManager.getReferenced(\"");
                                        String _name_32 = mut.getContainer().getRefRefType().getName();
                                        _builder.append(_name_32, "\t\t");
                                        _builder.append("\", recovered.get(1));");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("List<EObject> tmp = new ArrayList<EObject>();");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("tmp.add(recovered.get(1));");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("if (ob instanceof EObject) {");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("tmp.add((EObject) ob);");
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
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("tmp.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("}");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("recovered = tmp;");
                                        _builder.newLine();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("//");
                                        _builder.append(refName_1 = mut.getContainer().getRefRefRefType().getName(), "\t\t");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                                        ObSelectionStrategy _container_30 = mut.getContainer();
                                        String _name_33 = ((SpecificObjectSelection) _container_30).getObjSel().getName();
                                        _builder.append(_name_33, "\t\t");
                                        _builder.append(".getValue().getValue(), entry_");
                                        ObSelectionStrategy _container_31 = mut.getContainer();
                                        String _name_34 = ((SpecificObjectSelection) _container_31).getObjSel().getName();
                                        _builder.append(_name_34, "\t\t");
                                        _builder.append(".getValue().getKey(), recovered.get(1));");
                                        _builder.newLineIfNotEmpty();
                                        _builder.append("\t");
                                        _builder.append("\t");
                                        _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                        ObSelectionStrategy _container_32 = mut.getContainer();
                                        String _name_35 = ((SpecificObjectSelection) _container_32).getObjSel().getName();
                                        _builder.append(_name_35, "\t\t");
                                        _builder.append(".getValue().getValue(), entry_");
                                        ObSelectionStrategy _container_33 = mut.getContainer();
                                        String _name_36 = ((SpecificObjectSelection) _container_33).getObjSel().getName();
                                        _builder.append(_name_36, "\t\t");
                                        _builder.append(".getValue().getKey(), \"");
                                        _builder.append(refName_1, "\t\t");
                                        _builder.append("\", recovered.get(1));");
                                        _builder.newLineIfNotEmpty();
                                      }
                                    }
                                  } else {
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                                    ObSelectionStrategy _container_34 = mut.getContainer();
                                    String _name_37 = ((SpecificObjectSelection) _container_34).getObjSel().getName();
                                    _builder.append(_name_37, "\t\t");
                                    _builder.append(".getValue().getValue(), entry_");
                                    ObSelectionStrategy _container_35 = mut.getContainer();
                                    String _name_38 = ((SpecificObjectSelection) _container_35).getObjSel().getName();
                                    _builder.append(_name_38, "\t\t");
                                    _builder.append(".getValue().getKey(), recovered.get(0));");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("\t");
                                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                    ObSelectionStrategy _container_36 = mut.getContainer();
                                    String _name_39 = ((SpecificObjectSelection) _container_36).getObjSel().getName();
                                    _builder.append(_name_39, "\t\t");
                                    _builder.append(".getValue().getValue(), entry_");
                                    ObSelectionStrategy _container_37 = mut.getContainer();
                                    String _name_40 = ((SpecificObjectSelection) _container_37).getObjSel().getName();
                                    _builder.append(_name_40, "\t\t");
                                    _builder.append(".getValue().getKey(), \"");
                                    _builder.append(refName_1, "\t\t");
                                    _builder.append("\", recovered.get(0));");
                                    _builder.newLineIfNotEmpty();
                                  }
                                }
                                _builder.append("\t");
                                _builder.append("} else {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                                ObSelectionStrategy _container_38 = mut.getContainer();
                                String _name_41 = ((SpecificObjectSelection) _container_38).getObjSel().getName();
                                _builder.append(_name_41, "\t\t");
                                _builder.append(" = hmList.get(\"");
                                ObSelectionStrategy _container_39 = mut.getContainer();
                                String _name_42 = ((SpecificObjectSelection) _container_39).getObjSel().getName();
                                _builder.append(_name_42, "\t\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("if (listEntry_");
                                ObSelectionStrategy _container_40 = mut.getContainer();
                                String _name_43 = ((SpecificObjectSelection) _container_40).getObjSel().getName();
                                _builder.append(_name_43, "\t\t");
                                _builder.append(" != null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("resourcePackages = listEntry_");
                                ObSelectionStrategy _container_41 = mut.getContainer();
                                String _name_44 = ((SpecificObjectSelection) _container_41).getObjSel().getName();
                                _builder.append(_name_44, "\t\t\t");
                                _builder.append(".get(0).getValue().getValue();");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("resources = new ArrayList<Resource>();");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("resources.add(listEntry_");
                                ObSelectionStrategy _container_42 = mut.getContainer();
                                String _name_45 = ((SpecificObjectSelection) _container_42).getObjSel().getName();
                                _builder.append(_name_45, "\t\t\t");
                                _builder.append(".get(0).getValue().getKey());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                                ObSelectionStrategy _container_43 = mut.getContainer();
                                String _name_46 = ((SpecificObjectSelection) _container_43).getObjSel().getName();
                                _builder.append(_name_46, "\t\t\t");
                                _builder.append(") {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("\t\t\t");
                                _builder.append("EObject obj = ent.getKey();");
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
                                _builder.append("referenceSelection = new SpecificReferenceSelection(listEntry_");
                                ObSelectionStrategy _container_44 = mut.getContainer();
                                String _name_47 = ((SpecificObjectSelection) _container_44).getObjSel().getName();
                                _builder.append(_name_47, "\t\t\t");
                                _builder.append(".get(0).getValue().getValue(), listEntry_");
                                ObSelectionStrategy _container_45 = mut.getContainer();
                                String _name_48 = ((SpecificObjectSelection) _container_45).getObjSel().getName();
                                _builder.append(_name_48, "\t\t\t");
                                _builder.append(".get(0).getValue().getKey(), \"");
                                String _name_49 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_49, "\t\t\t");
                                _builder.append("\", listEntry_");
                                ObSelectionStrategy _container_46 = mut.getContainer();
                                String _name_50 = ((SpecificObjectSelection) _container_46).getObjSel().getName();
                                _builder.append(_name_50, "\t\t\t");
                                _builder.append(".get(0).getKey());");
                                _builder.newLineIfNotEmpty();
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
                                _builder.append("return mutations;");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                              } else {
                                _builder.append("\t");
                                _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                                _builder.newLine();
                              }
                            }
                          } else {
                            ObSelectionStrategy _container_47 = mut.getContainer();
                            if ((_container_47 instanceof SpecificClosureSelection)) {
                              _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                              ObSelectionStrategy _container_48 = mut.getContainer();
                              String _name_51 = ((SpecificClosureSelection) _container_48).getObjSel().getName();
                              _builder.append(_name_51);
                              _builder.append(" = hmObjects.get(\"");
                              ObSelectionStrategy _container_49 = mut.getContainer();
                              String _name_52 = ((SpecificClosureSelection) _container_49).getObjSel().getName();
                              _builder.append(_name_52);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("if (entry_");
                              ObSelectionStrategy _container_50 = mut.getContainer();
                              String _name_53 = ((SpecificClosureSelection) _container_50).getObjSel().getName();
                              _builder.append(_name_53);
                              _builder.append(" != null) {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("resourcePackages = entry_");
                              ObSelectionStrategy _container_51 = mut.getContainer();
                              String _name_54 = ((SpecificClosureSelection) _container_51).getObjSel().getName();
                              _builder.append(_name_54, "\t");
                              _builder.append(".getValue().getValue();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("resources = new ArrayList<Resource>();");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("resources.add(entry_");
                              ObSelectionStrategy _container_52 = mut.getContainer();
                              String _name_55 = ((SpecificClosureSelection) _container_52).getObjSel().getName();
                              _builder.append(_name_55, "\t");
                              _builder.append(".getValue().getKey());");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                              ObSelectionStrategy _container_53 = mut.getContainer();
                              String _name_56 = ((SpecificClosureSelection) _container_53).getObjSel().getName();
                              _builder.append(_name_56, "\t");
                              _builder.append(".getValue().getValue(), entry_");
                              ObSelectionStrategy _container_54 = mut.getContainer();
                              String _name_57 = ((SpecificClosureSelection) _container_54).getObjSel().getName();
                              _builder.append(_name_57, "\t");
                              _builder.append(".getValue().getKey(), entry_");
                              ObSelectionStrategy _container_55 = mut.getContainer();
                              String _name_58 = ((SpecificClosureSelection) _container_55).getObjSel().getName();
                              _builder.append(_name_58, "\t");
                              _builder.append(".getKey(), \"");
                              ObSelectionStrategy _container_56 = mut.getContainer();
                              String _name_59 = ((SpecificClosureSelection) _container_56).getRefType().getName();
                              _builder.append(_name_59, "\t");
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("} else {");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                              ObSelectionStrategy _container_57 = mut.getContainer();
                              String _name_60 = ((SpecificClosureSelection) _container_57).getObjSel().getName();
                              _builder.append(_name_60, "\t");
                              _builder.append(" = hmList.get(\"");
                              ObSelectionStrategy _container_58 = mut.getContainer();
                              String _name_61 = ((SpecificClosureSelection) _container_58).getObjSel().getName();
                              _builder.append(_name_61, "\t");
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("if (listEntry_");
                              ObSelectionStrategy _container_59 = mut.getContainer();
                              String _name_62 = ((SpecificClosureSelection) _container_59).getObjSel().getName();
                              _builder.append(_name_62, "\t");
                              _builder.append(" != null) {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("resourcePackages = listEntry_");
                              ObSelectionStrategy _container_60 = mut.getContainer();
                              String _name_63 = ((SpecificClosureSelection) _container_60).getObjSel().getName();
                              _builder.append(_name_63, "\t\t");
                              _builder.append(".get(0).getValue().getValue();");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("resources = new ArrayList<Resource>();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("resources.add(listEntry_");
                              ObSelectionStrategy _container_61 = mut.getContainer();
                              String _name_64 = ((SpecificClosureSelection) _container_61).getObjSel().getName();
                              _builder.append(_name_64, "\t\t");
                              _builder.append(".get(0).getValue().getKey());");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                              ObSelectionStrategy _container_62 = mut.getContainer();
                              String _name_65 = ((SpecificClosureSelection) _container_62).getObjSel().getName();
                              _builder.append(_name_65, "\t\t");
                              _builder.append(") {");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t\t");
                              _builder.append("EObject obj = ent.getKey();");
                              _builder.newLine();
                              _builder.append("\t\t\t");
                              _builder.append("objs.add(obj);");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("referenceSelection = new SpecificReferenceSelection(listEntry_");
                              ObSelectionStrategy _container_63 = mut.getContainer();
                              String _name_66 = ((SpecificClosureSelection) _container_63).getObjSel().getName();
                              _builder.append(_name_66, "\t\t");
                              _builder.append(".get(0).getValue().getValue(), listEntry_");
                              ObSelectionStrategy _container_64 = mut.getContainer();
                              String _name_67 = ((SpecificClosureSelection) _container_64).getObjSel().getName();
                              _builder.append(_name_67, "\t\t");
                              _builder.append(".get(0).getValue().getKey(), \"");
                              String _name_68 = mut.getContainer().getRefType().getName();
                              _builder.append(_name_68, "\t\t");
                              _builder.append("\", listEntry_");
                              ObSelectionStrategy _container_65 = mut.getContainer();
                              String _name_69 = ((SpecificClosureSelection) _container_65).getObjSel().getName();
                              _builder.append(_name_69, "\t\t");
                              _builder.append(".get(0).getKey());");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t");
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("else {");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("return mutations;");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("}");
                              _builder.newLine();
                              {
                                EReference _refType_3 = mut.getContainer().getRefType();
                                boolean _tripleNotEquals_7 = (_refType_3 != null);
                                if (_tripleNotEquals_7) {
                                  _builder.append("if (entry_");
                                  ObSelectionStrategy _container_66 = mut.getContainer();
                                  String _name_70 = ((SpecificClosureSelection) _container_66).getObjSel().getName();
                                  _builder.append(_name_70);
                                  _builder.append(" != null) {");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("resourcePackages = entry_");
                                  ObSelectionStrategy _container_67 = mut.getContainer();
                                  String _name_71 = ((SpecificClosureSelection) _container_67).getObjSel().getName();
                                  _builder.append(_name_71, "\t");
                                  _builder.append(".getValue().getValue();");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("resources = new ArrayList<Resource>();");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("resources.add(entry_");
                                  ObSelectionStrategy _container_68 = mut.getContainer();
                                  String _name_72 = ((SpecificClosureSelection) _container_68).getObjSel().getName();
                                  _builder.append(_name_72, "\t");
                                  _builder.append(".getValue().getKey());");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                  ObSelectionStrategy _container_69 = mut.getContainer();
                                  String _name_73 = ((SpecificClosureSelection) _container_69).getObjSel().getName();
                                  _builder.append(_name_73, "\t");
                                  _builder.append(".getValue().getValue(), entry_");
                                  ObSelectionStrategy _container_70 = mut.getContainer();
                                  String _name_74 = ((SpecificClosureSelection) _container_70).getObjSel().getName();
                                  _builder.append(_name_74, "\t");
                                  _builder.append(".getValue().getKey(), \"");
                                  String _name_75 = mut.getContainer().getRefType().getName();
                                  _builder.append(_name_75, "\t");
                                  _builder.append("\", entry_");
                                  ObSelectionStrategy _container_71 = mut.getContainer();
                                  String _name_76 = ((SpecificClosureSelection) _container_71).getObjSel().getName();
                                  _builder.append(_name_76, "\t");
                                  _builder.append(".getKey());");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("} else {");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                  _builder.append("}");
                                  _builder.newLine();
                                } else {
                                  _builder.append("referenceSelection = new SpecificReferenceSelection(packages, model, null, null);");
                                  _builder.newLine();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    {
                      if ((rts == true)) {
                        _builder.append("rts = new RandomTypeSelection(packages, model, \"");
                        String _name_77 = mut.getObject().getType().getName();
                        _builder.append(_name_77);
                        _builder.append("\", referenceSelection, containerSelection);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), \"");
                        String _name_78 = mut.getObject().getType().getName();
                        _builder.append(_name_78);
                        _builder.append("\", referenceSelection, containerSelection);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      if (((mut.getObject().getExpression() == null) && (mut.getContainer().getExpression() == null))) {
                        _builder.append("EObject object = rts.getObject();");
                        _builder.newLine();
                      }
                    }
                  }
                }
                {
                  if (((mut.getObject().getExpression() == null) && (mut.getContainer() == null))) {
                    _builder.append("EObject object = rts.getObject();");
                    _builder.newLine();
                  }
                }
                {
                  EReference _refType_4 = mut.getObject().getRefType();
                  boolean _tripleNotEquals_8 = (_refType_4 != null);
                  if (_tripleNotEquals_8) {
                    _builder.append("Object o = object.eGet(\"");
                    EReference _refType_5 = mut.getObject().getRefType();
                    _builder.append(_refType_5);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("if (o instanceof EObject) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("object = (EObject) o;");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("if (o instanceof List<?>) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("object = ((List<EObject) o).get(ModelManager.getRandomIndex((List<EObject) o));");
                    _builder.newLine();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                _builder.append("//");
                final List<String> resourceURIs = new ArrayList<String>();
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                final List<String> ecoreURIs = new ArrayList<String>();
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                final String resourceName = mut.getObject().getResource();
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                Resource resource = null;
                _builder.newLineIfNotEmpty();
                {
                  EList<Resource> _resources = program.getResources();
                  for(final Resource res : _resources) {
                    {
                      boolean _equals = res.getName().equals(resourceName);
                      if (_equals) {
                        _builder.append("//");
                        _builder.append(resource = res);
                        _builder.append(" ");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  if ((resource != null)) {
                    _builder.append("//");
                    final Source source = resource.getPath();
                    _builder.newLineIfNotEmpty();
                    _builder.append("//");
                    String _path = project.getLocation().toFile().getPath();
                    String _plus = (_path + "/");
                    String _path_1 = source.getPath();
                    final String resourcePath = (_plus + _path_1);
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _exists = new File(resourcePath).exists();
                      if (_exists) {
                        {
                          File[] _listFiles = new File(resourcePath).listFiles();
                          for(final File resourceFile : _listFiles) {
                            {
                              boolean _endsWith = resourceFile.getName().endsWith(".model");
                              if (_endsWith) {
                                _builder.append("//");
                                boolean _add = resourceURIs.add(resourceFile.getPath());
                                _builder.append(_add);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            {
                              boolean _endsWith_1 = resourceFile.getName().endsWith(".ecore");
                              if (_endsWith_1) {
                                _builder.append("//");
                                boolean _add_1 = ecoreURIs.add(resourceFile.getPath());
                                _builder.append(_add_1);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                      }
                    }
                    _builder.append("//");
                    final String metamodelPath = resource.getMetamodel().replace("\\", "/");
                    _builder.newLineIfNotEmpty();
                    _builder.append("String relativeMetamodelPath = \"");
                    String _xifexpression = null;
                    String _name_79 = project.getName();
                    String _plus_1 = ("/" + _name_79);
                    String _plus_2 = (_plus_1 + "/");
                    int _indexOf = metamodelPath.indexOf(_plus_2);
                    boolean _notEquals = (_indexOf != (-1));
                    if (_notEquals) {
                      String _name_80 = project.getName();
                      String _plus_3 = ("/" + _name_80);
                      String _plus_4 = (_plus_3 + "/");
                      int _lastIndexOf = metamodelPath.lastIndexOf(_plus_4);
                      String _name_81 = project.getName();
                      String _plus_5 = ("/" + _name_81);
                      int _length = (_plus_5 + "/").length();
                      int _plus_6 = (_lastIndexOf + _length);
                      _xifexpression = metamodelPath.substring(_plus_6, metamodelPath.length());
                    } else {
                      _xifexpression = metamodelPath;
                    }
                    _builder.append(_xifexpression);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("relativeMetamodelPath = relativeMetamodelPath.startsWith(\"/\") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; ");
                    _builder.newLine();
                    _builder.append("String absoluteMetamodelPath = ");
                    _builder.append(className);
                    _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeMetamodelPath;");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((standalone == false)) {
                        _builder.append("resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());");
                        _builder.newLine();
                      } else {
                        _builder.append("resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, ");
                        _builder.append(className);
                        _builder.append(".class);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("resources = new ArrayList<Resource>();");
                    _builder.newLine();
                    {
                      for(final String resourceURI : resourceURIs) {
                        _builder.append("String relativeResourceURI_");
                        _builder.append(i);
                        _builder.append(" = \"");
                        String _xifexpression_1 = null;
                        String _replace = resourceURI.replace("\\", "/");
                        String _name_82 = project.getName();
                        String _plus_7 = ("/" + _name_82);
                        String _plus_8 = (_plus_7 + "/");
                        int _indexOf_1 = _replace.indexOf(_plus_8);
                        boolean _notEquals_1 = (_indexOf_1 != (-1));
                        if (_notEquals_1) {
                          String _replace_1 = resourceURI.replace("\\", "/");
                          String _replace_2 = resourceURI.replace("\\", "/");
                          String _name_83 = project.getName();
                          String _plus_9 = ("/" + _name_83);
                          String _plus_10 = (_plus_9 + "/");
                          int _lastIndexOf_1 = _replace_2.lastIndexOf(_plus_10);
                          String _name_84 = project.getName();
                          String _plus_11 = ("/" + _name_84);
                          int _length_1 = (_plus_11 + "/").length();
                          int _plus_12 = (_lastIndexOf_1 + _length_1);
                          _xifexpression_1 = _replace_1.substring(_plus_12, resourceURI.replace("\\", "/").length());
                        } else {
                          _xifexpression_1 = resourceURI;
                        }
                        _builder.append(_xifexpression_1);
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("String absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(" = ");
                        _builder.append(className);
                        _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeResourceURI_");
                        _builder.append(i);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(" = absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(".substring(1, absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(".length()); ");
                        _builder.newLineIfNotEmpty();
                        {
                          if ((standalone == false)) {
                            _builder.append("resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_");
                            _builder.append(i);
                            _builder.append(").toFileString()));");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_");
                            _builder.append(i);
                            _builder.append(").toFileString()));");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        String _xblockexpression = null;
                        {
                          i++;
                          _xblockexpression = "";
                        }
                        _builder.append(_xblockexpression);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      for(final String ecoreURI : ecoreURIs) {
                        _builder.append("String relativeEcoreURI_");
                        _builder.append(j);
                        _builder.append(" = \"");
                        String _replace_3 = ecoreURI.replace("\\", "/");
                        String _replace_4 = ecoreURI.replace("\\", "/");
                        String _name_85 = project.getName();
                        String _plus_13 = ("/" + _name_85);
                        String _plus_14 = (_plus_13 + "/");
                        int _lastIndexOf_2 = _replace_4.lastIndexOf(_plus_14);
                        String _name_86 = project.getName();
                        String _plus_15 = ("/" + _name_86);
                        int _length_2 = (_plus_15 + "/").length();
                        int _plus_16 = (_lastIndexOf_2 + _length_2);
                        String _substring = _replace_3.substring(_plus_16, ecoreURI.replace("\\", "/").length());
                        _builder.append(_substring);
                        _builder.append("\";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("String absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(" = ");
                        _builder.append(className);
                        _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeEcoreURI_");
                        _builder.append(j);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                        _builder.append("absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(" = absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(".substring(1, absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(".length()); ");
                        _builder.newLineIfNotEmpty();
                        {
                          if ((standalone == false)) {
                            _builder.append("resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, \"file:/\" + URI.createURI(absoluteEcoreURI_");
                            _builder.append(j);
                            _builder.append(").toFileString()));");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, \"file:/\" + URI.createURI(absoluteEcoreURI_");
                            _builder.append(j);
                            _builder.append(").toFileString()));");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        String _xblockexpression_1 = null;
                        {
                          j++;
                          _xblockexpression_1 = "";
                        }
                        _builder.append(_xblockexpression_1);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _container_72 = mut.getContainer();
                      boolean _tripleEquals_2 = (_container_72 == null);
                      if (_tripleEquals_2) {
                        {
                          ObSelectionStrategy _object_4 = mut.getObject();
                          if ((_object_4 instanceof RandomTypeSelection)) {
                            _builder.append("//");
                            _builder.append(rts = true);
                            _builder.newLineIfNotEmpty();
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                            ObSelectionStrategy _object_5 = mut.getObject();
                            String _name_87 = ((RandomTypeSelection) _object_5).getType().getName();
                            _builder.append(_name_87);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          ObSelectionStrategy _object_6 = mut.getObject();
                          if ((_object_6 instanceof CompleteTypeSelection)) {
                            _builder.append("//");
                            _builder.append(rts = true);
                            _builder.newLineIfNotEmpty();
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                            ObSelectionStrategy _object_7 = mut.getObject();
                            String _name_88 = ((CompleteTypeSelection) _object_7).getType().getName();
                            _builder.append(_name_88);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      } else {
                        {
                          ObSelectionStrategy _container_73 = mut.getContainer();
                          if ((_container_73 instanceof RandomTypeSelection)) {
                            _builder.append("//");
                            _builder.append(rts = true);
                            _builder.newLineIfNotEmpty();
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                            ObSelectionStrategy _container_74 = mut.getContainer();
                            String _name_89 = ((RandomTypeSelection) _container_74).getType().getName();
                            _builder.append(_name_89);
                            _builder.append("\");");
                            _builder.newLineIfNotEmpty();
                            _builder.append("EObject container = rts.getObject();");
                            _builder.newLine();
                            _builder.append("containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);");
                            _builder.newLine();
                            {
                              EReference _refType_6 = mut.getContainer().getRefType();
                              boolean _tripleNotEquals_9 = (_refType_6 != null);
                              if (_tripleNotEquals_9) {
                                _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, \"");
                                String _name_90 = mut.getContainer().getRefType().getName();
                                _builder.append(_name_90);
                                _builder.append("\", containerSelection);");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);");
                                _builder.newLine();
                              }
                            }
                          } else {
                            ObSelectionStrategy _container_75 = mut.getContainer();
                            if ((_container_75 instanceof CompleteTypeSelection)) {
                              _builder.newLine();
                              _builder.append("//");
                              _builder.append(rts = true);
                              _builder.newLineIfNotEmpty();
                              _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                              ObSelectionStrategy _container_76 = mut.getContainer();
                              String _name_91 = ((CompleteTypeSelection) _container_76).getType().getName();
                              _builder.append(_name_91);
                              _builder.append("\");");
                              _builder.newLineIfNotEmpty();
                              _builder.append("EObject container = rts.getObject();");
                              _builder.newLine();
                              _builder.append("containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);");
                              _builder.newLine();
                              {
                                EReference _refType_7 = mut.getContainer().getRefType();
                                boolean _tripleNotEquals_10 = (_refType_7 != null);
                                if (_tripleNotEquals_10) {
                                  _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, \"");
                                  String _name_92 = mut.getContainer().getRefType().getName();
                                  _builder.append(_name_92);
                                  _builder.append("\", containerSelection);");
                                  _builder.newLineIfNotEmpty();
                                } else {
                                  _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);");
                                  _builder.newLine();
                                }
                              }
                            } else {
                              ObSelectionStrategy _container_77 = mut.getContainer();
                              if ((_container_77 instanceof SpecificObjectSelection)) {
                                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                                ObSelectionStrategy _container_78 = mut.getContainer();
                                String _name_93 = ((SpecificObjectSelection) _container_78).getObjSel().getName();
                                _builder.append(_name_93);
                                _builder.append(" = hmObjects.get(\"");
                                ObSelectionStrategy _container_79 = mut.getContainer();
                                String _name_94 = ((SpecificObjectSelection) _container_79).getObjSel().getName();
                                _builder.append(_name_94);
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("if (entry_");
                                ObSelectionStrategy _container_80 = mut.getContainer();
                                String _name_95 = ((SpecificObjectSelection) _container_80).getObjSel().getName();
                                _builder.append(_name_95);
                                _builder.append(" != null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("resourcePackages = entry_");
                                ObSelectionStrategy _container_81 = mut.getContainer();
                                String _name_96 = ((SpecificObjectSelection) _container_81).getObjSel().getName();
                                _builder.append(_name_96, "\t");
                                _builder.append(".getValue().getValue();");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("resources = new ArrayList<Resource>();");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("resources.add(entry_");
                                ObSelectionStrategy _container_82 = mut.getContainer();
                                String _name_97 = ((SpecificObjectSelection) _container_82).getObjSel().getName();
                                _builder.append(_name_97, "\t");
                                _builder.append(".getValue().getKey());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("containerSelection = new SpecificObjectSelection(entry_");
                                ObSelectionStrategy _container_83 = mut.getContainer();
                                String _name_98 = ((SpecificObjectSelection) _container_83).getObjSel().getName();
                                _builder.append(_name_98, "\t");
                                _builder.append(".getValue().getValue(), entry_");
                                ObSelectionStrategy _container_84 = mut.getContainer();
                                String _name_99 = ((SpecificObjectSelection) _container_84).getObjSel().getName();
                                _builder.append(_name_99, "\t");
                                _builder.append(".getValue().getKey(), entry_");
                                ObSelectionStrategy _container_85 = mut.getContainer();
                                String _name_100 = ((SpecificObjectSelection) _container_85).getObjSel().getName();
                                _builder.append(_name_100, "\t");
                                _builder.append(".getKey());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("} else {");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                                ObSelectionStrategy _container_86 = mut.getContainer();
                                String _name_101 = ((SpecificObjectSelection) _container_86).getObjSel().getName();
                                _builder.append(_name_101, "\t");
                                _builder.append(" = hmList.get(\"");
                                ObSelectionStrategy _container_87 = mut.getContainer();
                                String _name_102 = ((SpecificObjectSelection) _container_87).getObjSel().getName();
                                _builder.append(_name_102, "\t");
                                _builder.append("\");");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("if (listEntry_");
                                ObSelectionStrategy _container_88 = mut.getContainer();
                                String _name_103 = ((SpecificObjectSelection) _container_88).getObjSel().getName();
                                _builder.append(_name_103, "\t");
                                _builder.append(" != null) {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t");
                                _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("resourcePackages = listEntry_");
                                ObSelectionStrategy _container_89 = mut.getContainer();
                                String _name_104 = ((SpecificObjectSelection) _container_89).getObjSel().getName();
                                _builder.append(_name_104, "\t\t");
                                _builder.append(".get(0).getValue().getValue();");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t");
                                _builder.append("resources = new ArrayList<Resource>();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("resources.add(listEntry_");
                                ObSelectionStrategy _container_90 = mut.getContainer();
                                String _name_105 = ((SpecificObjectSelection) _container_90).getObjSel().getName();
                                _builder.append(_name_105, "\t\t");
                                _builder.append(".get(0).getValue().getKey());");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t");
                                _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                                ObSelectionStrategy _container_91 = mut.getContainer();
                                String _name_106 = ((SpecificObjectSelection) _container_91).getObjSel().getName();
                                _builder.append(_name_106, "\t\t");
                                _builder.append(") {");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t\t\t");
                                _builder.append("EObject obj = ent.getKey();");
                                _builder.newLine();
                                _builder.append("\t\t\t");
                                _builder.append("objs.add(obj);");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("containerSelection = new SpecificObjectSelection(listEntry_");
                                ObSelectionStrategy _container_92 = mut.getContainer();
                                String _name_107 = ((SpecificObjectSelection) _container_92).getObjSel().getName();
                                _builder.append(_name_107, "\t\t");
                                _builder.append(".get(0).getValue().getValue(), listEntry_");
                                ObSelectionStrategy _container_93 = mut.getContainer();
                                String _name_108 = ((SpecificObjectSelection) _container_93).getObjSel().getName();
                                _builder.append(_name_108, "\t\t");
                                _builder.append(".get(0).getValue().getKey(), objs);");
                                _builder.newLineIfNotEmpty();
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("else {");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("return mutations;");
                                _builder.newLine();
                                _builder.append("\t");
                                _builder.append("}");
                                _builder.newLine();
                                _builder.append("}");
                                _builder.newLine();
                                {
                                  EReference _refType_8 = mut.getContainer().getRefType();
                                  boolean _tripleNotEquals_11 = (_refType_8 != null);
                                  if (_tripleNotEquals_11) {
                                    _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                                    ObSelectionStrategy _container_94 = mut.getContainer();
                                    String _name_109 = ((SpecificObjectSelection) _container_94).getObjSel().getName();
                                    _builder.append(_name_109);
                                    _builder.append(" = hmObjects.get(\"");
                                    ObSelectionStrategy _container_95 = mut.getContainer();
                                    String _name_110 = ((SpecificObjectSelection) _container_95).getObjSel().getName();
                                    _builder.append(_name_110);
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("if (entry_");
                                    ObSelectionStrategy _container_96 = mut.getContainer();
                                    String _name_111 = ((SpecificObjectSelection) _container_96).getObjSel().getName();
                                    _builder.append(_name_111);
                                    _builder.append(" != null) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("resourcePackages = listEntry_");
                                    ObSelectionStrategy _container_97 = mut.getContainer();
                                    String _name_112 = ((SpecificObjectSelection) _container_97).getObjSel().getName();
                                    _builder.append(_name_112, "\t");
                                    _builder.append(".getValue().getValue();");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("resources = new ArrayList<Resource>();");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("resources.add(listEntry_");
                                    ObSelectionStrategy _container_98 = mut.getContainer();
                                    String _name_113 = ((SpecificObjectSelection) _container_98).getObjSel().getName();
                                    _builder.append(_name_113, "\t");
                                    _builder.append(".getValue().getKey());");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                    ObSelectionStrategy _container_99 = mut.getContainer();
                                    String _name_114 = ((SpecificObjectSelection) _container_99).getObjSel().getName();
                                    _builder.append(_name_114, "\t");
                                    _builder.append(".getValue().getValue(), entry_");
                                    ObSelectionStrategy _container_100 = mut.getContainer();
                                    String _name_115 = ((SpecificObjectSelection) _container_100).getObjSel().getName();
                                    _builder.append(_name_115, "\t");
                                    _builder.append(".getValue().getKey(), \"");
                                    String _name_116 = mut.getContainer().getRefType().getName();
                                    _builder.append(_name_116, "\t");
                                    _builder.append("\", entry_");
                                    ObSelectionStrategy _container_101 = mut.getContainer();
                                    String _name_117 = ((SpecificObjectSelection) _container_101).getObjSel().getName();
                                    _builder.append(_name_117, "\t");
                                    _builder.append(".getKey());");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("} else {");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                                    ObSelectionStrategy _container_102 = mut.getContainer();
                                    String _name_118 = ((SpecificObjectSelection) _container_102).getObjSel().getName();
                                    _builder.append(_name_118, "\t");
                                    _builder.append(" = hmList.get(\"");
                                    ObSelectionStrategy _container_103 = mut.getContainer();
                                    String _name_119 = ((SpecificObjectSelection) _container_103).getObjSel().getName();
                                    _builder.append(_name_119, "\t");
                                    _builder.append("\");");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("if (listEntry_");
                                    ObSelectionStrategy _container_104 = mut.getContainer();
                                    String _name_120 = ((SpecificObjectSelection) _container_104).getObjSel().getName();
                                    _builder.append(_name_120, "\t");
                                    _builder.append(" != null) {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t");
                                    _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("resourcePackages = listEntry_");
                                    ObSelectionStrategy _container_105 = mut.getContainer();
                                    String _name_121 = ((SpecificObjectSelection) _container_105).getObjSel().getName();
                                    _builder.append(_name_121, "\t\t");
                                    _builder.append(".get(0).getValue().getValue();");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t");
                                    _builder.append("resources = new ArrayList<Resource>();");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("resources.add(listEntry_");
                                    ObSelectionStrategy _container_106 = mut.getContainer();
                                    String _name_122 = ((SpecificObjectSelection) _container_106).getObjSel().getName();
                                    _builder.append(_name_122, "\t\t");
                                    _builder.append(".get(0).getValue().getKey());");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t");
                                    _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                                    ObSelectionStrategy _container_107 = mut.getContainer();
                                    String _name_123 = ((SpecificObjectSelection) _container_107).getObjSel().getName();
                                    _builder.append(_name_123, "\t\t");
                                    _builder.append(") {");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t\t\t");
                                    _builder.append("EObject obj = ent.getKey();");
                                    _builder.newLine();
                                    _builder.append("\t\t\t");
                                    _builder.append("objs.add(obj);");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("referenceSelection = new SpecificReferenceSelection(listEntry_");
                                    ObSelectionStrategy _container_108 = mut.getContainer();
                                    String _name_124 = ((SpecificObjectSelection) _container_108).getObjSel().getName();
                                    _builder.append(_name_124, "\t\t");
                                    _builder.append(".get(0).getValue().getValue(), listEntry_");
                                    ObSelectionStrategy _container_109 = mut.getContainer();
                                    String _name_125 = ((SpecificObjectSelection) _container_109).getObjSel().getName();
                                    _builder.append(_name_125, "\t\t");
                                    _builder.append(".get(0).getValue().getKey(), \"");
                                    String _name_126 = mut.getContainer().getRefType().getName();
                                    _builder.append(_name_126, "\t\t");
                                    _builder.append("\", listEntry_");
                                    ObSelectionStrategy _container_110 = mut.getContainer();
                                    String _name_127 = ((SpecificObjectSelection) _container_110).getObjSel().getName();
                                    _builder.append(_name_127, "\t\t");
                                    _builder.append(".get(0).getKey());");
                                    _builder.newLineIfNotEmpty();
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("else {");
                                    _builder.newLine();
                                    _builder.append("\t\t");
                                    _builder.append("return mutations;");
                                    _builder.newLine();
                                    _builder.append("\t");
                                    _builder.append("}");
                                    _builder.newLine();
                                    _builder.append("}");
                                    _builder.newLine();
                                  } else {
                                    _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);");
                                    _builder.newLine();
                                  }
                                }
                              } else {
                                ObSelectionStrategy _container_111 = mut.getContainer();
                                if ((_container_111 instanceof SpecificClosureSelection)) {
                                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                                  ObSelectionStrategy _container_112 = mut.getContainer();
                                  String _name_128 = ((SpecificClosureSelection) _container_112).getObjSel().getName();
                                  _builder.append(_name_128);
                                  _builder.append(" = hmObjects.get(\"");
                                  ObSelectionStrategy _container_113 = mut.getContainer();
                                  String _name_129 = ((SpecificClosureSelection) _container_113).getObjSel().getName();
                                  _builder.append(_name_129);
                                  _builder.append("\");");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("if (entry_");
                                  ObSelectionStrategy _container_114 = mut.getContainer();
                                  String _name_130 = ((SpecificClosureSelection) _container_114).getObjSel().getName();
                                  _builder.append(_name_130);
                                  _builder.append(" != null) {");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("resourcePackages = entry_");
                                  ObSelectionStrategy _container_115 = mut.getContainer();
                                  String _name_131 = ((SpecificClosureSelection) _container_115).getObjSel().getName();
                                  _builder.append(_name_131, "\t");
                                  _builder.append(".getValue().getValue();");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("resources = new ArrayList<Resource>();");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("resources.add(entry_");
                                  ObSelectionStrategy _container_116 = mut.getContainer();
                                  String _name_132 = ((SpecificClosureSelection) _container_116).getObjSel().getName();
                                  _builder.append(_name_132, "\t");
                                  _builder.append(".getValue().getKey());");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("containerSelection = new SpecificClosureSelection(entry_");
                                  ObSelectionStrategy _container_117 = mut.getContainer();
                                  String _name_133 = ((SpecificClosureSelection) _container_117).getObjSel().getName();
                                  _builder.append(_name_133, "\t");
                                  _builder.append(".getValue().getValue(), entry_");
                                  ObSelectionStrategy _container_118 = mut.getContainer();
                                  String _name_134 = ((SpecificClosureSelection) _container_118).getObjSel().getName();
                                  _builder.append(_name_134, "\t");
                                  _builder.append(".getValue().getKey(), entry_");
                                  ObSelectionStrategy _container_119 = mut.getContainer();
                                  String _name_135 = ((SpecificClosureSelection) _container_119).getObjSel().getName();
                                  _builder.append(_name_135, "\t");
                                  _builder.append(".getKey(), \"");
                                  ObSelectionStrategy _container_120 = mut.getContainer();
                                  String _name_136 = ((SpecificClosureSelection) _container_120).getRefType().getName();
                                  _builder.append(_name_136, "\t");
                                  _builder.append("\");");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("} else {");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                                  ObSelectionStrategy _container_121 = mut.getContainer();
                                  String _name_137 = ((SpecificClosureSelection) _container_121).getObjSel().getName();
                                  _builder.append(_name_137, "\t");
                                  _builder.append(" = hmList.get(\"");
                                  ObSelectionStrategy _container_122 = mut.getContainer();
                                  String _name_138 = ((SpecificObjectSelection) _container_122).getObjSel().getName();
                                  _builder.append(_name_138, "\t");
                                  _builder.append("\");");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("if (listEntry_");
                                  ObSelectionStrategy _container_123 = mut.getContainer();
                                  String _name_139 = ((SpecificClosureSelection) _container_123).getObjSel().getName();
                                  _builder.append(_name_139, "\t");
                                  _builder.append(" != null) {");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("resourcePackages = listEntry_");
                                  ObSelectionStrategy _container_124 = mut.getContainer();
                                  String _name_140 = ((SpecificClosureSelection) _container_124).getObjSel().getName();
                                  _builder.append(_name_140, "\t\t");
                                  _builder.append(".get(0).getValue().getValue();");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("resources = new ArrayList<Resource>();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("resources.add(listEntry_");
                                  ObSelectionStrategy _container_125 = mut.getContainer();
                                  String _name_141 = ((SpecificClosureSelection) _container_125).getObjSel().getName();
                                  _builder.append(_name_141, "\t\t");
                                  _builder.append(".get(0).getValue().getKey());");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                                  ObSelectionStrategy _container_126 = mut.getContainer();
                                  String _name_142 = ((SpecificClosureSelection) _container_126).getObjSel().getName();
                                  _builder.append(_name_142, "\t\t");
                                  _builder.append(") {");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t\t");
                                  _builder.append("EObject obj = ent.getKey();");
                                  _builder.newLine();
                                  _builder.append("\t\t\t");
                                  _builder.append("objs.add(obj);");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("}");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("containerSelection = new SpecificObjectSelection(listEntry_");
                                  ObSelectionStrategy _container_127 = mut.getContainer();
                                  String _name_143 = ((SpecificClosureSelection) _container_127).getObjSel().getName();
                                  _builder.append(_name_143, "\t\t");
                                  _builder.append(".get(0).getValue().getValue(), listEntry_");
                                  ObSelectionStrategy _container_128 = mut.getContainer();
                                  String _name_144 = ((SpecificClosureSelection) _container_128).getObjSel().getName();
                                  _builder.append(_name_144, "\t\t");
                                  _builder.append(".get(0).getValue().getKey(), objs);");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t");
                                  _builder.append("}");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("else {");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("return mutations;");
                                  _builder.newLine();
                                  _builder.append("\t");
                                  _builder.append("}");
                                  _builder.newLine();
                                  _builder.append("}");
                                  _builder.newLine();
                                  {
                                    EReference _refType_9 = mut.getContainer().getRefType();
                                    boolean _tripleNotEquals_12 = (_refType_9 != null);
                                    if (_tripleNotEquals_12) {
                                      _builder.append("if (entry_");
                                      ObSelectionStrategy _container_129 = mut.getContainer();
                                      String _name_145 = ((SpecificClosureSelection) _container_129).getObjSel().getName();
                                      _builder.append(_name_145);
                                      _builder.append(" != null) {");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t");
                                      _builder.append("resourcePackages = entry_");
                                      ObSelectionStrategy _container_130 = mut.getContainer();
                                      String _name_146 = ((SpecificClosureSelection) _container_130).getObjSel().getName();
                                      _builder.append(_name_146, "\t");
                                      _builder.append(".getValue().getValue();");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t");
                                      _builder.append("resources = new ArrayList<Resource>();");
                                      _builder.newLine();
                                      _builder.append("\t");
                                      _builder.append("resources.add(entry_");
                                      ObSelectionStrategy _container_131 = mut.getContainer();
                                      String _name_147 = ((SpecificClosureSelection) _container_131).getObjSel().getName();
                                      _builder.append(_name_147, "\t");
                                      _builder.append(".getValue().getKey());");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t");
                                      _builder.append("referenceSelection = new SpecificReferenceSelection(entry_");
                                      ObSelectionStrategy _container_132 = mut.getContainer();
                                      String _name_148 = ((SpecificClosureSelection) _container_132).getObjSel().getName();
                                      _builder.append(_name_148, "\t");
                                      _builder.append(".getValue().getValue(), entry_");
                                      ObSelectionStrategy _container_133 = mut.getContainer();
                                      String _name_149 = ((SpecificClosureSelection) _container_133).getObjSel().getName();
                                      _builder.append(_name_149, "\t");
                                      _builder.append(".getValue().getKey(), \"");
                                      String _name_150 = mut.getContainer().getRefType().getName();
                                      _builder.append(_name_150, "\t");
                                      _builder.append("\", entry_");
                                      ObSelectionStrategy _container_134 = mut.getContainer();
                                      String _name_151 = ((SpecificClosureSelection) _container_134).getObjSel().getName();
                                      _builder.append(_name_151, "\t");
                                      _builder.append(".getKey());");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("} else {");
                                      _builder.newLine();
                                      _builder.append("\t");
                                      _builder.append("List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_");
                                      ObSelectionStrategy _container_135 = mut.getContainer();
                                      String _name_152 = ((SpecificClosureSelection) _container_135).getObjSel().getName();
                                      _builder.append(_name_152, "\t");
                                      _builder.append(" = hmList.get(\"");
                                      ObSelectionStrategy _container_136 = mut.getContainer();
                                      String _name_153 = ((SpecificClosureSelection) _container_136).getObjSel().getName();
                                      _builder.append(_name_153, "\t");
                                      _builder.append("\");");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t");
                                      _builder.append("if (listEntry_");
                                      ObSelectionStrategy _container_137 = mut.getContainer();
                                      String _name_154 = ((SpecificClosureSelection) _container_137).getObjSel().getName();
                                      _builder.append(_name_154, "\t");
                                      _builder.append(" != null) {");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("List<EObject> objs = new ArrayList<EObject>();");
                                      _builder.newLine();
                                      _builder.append("\t\t");
                                      _builder.append("resourcePackages = listEntry_");
                                      ObSelectionStrategy _container_138 = mut.getContainer();
                                      String _name_155 = ((SpecificClosureSelection) _container_138).getObjSel().getName();
                                      _builder.append(_name_155, "\t\t");
                                      _builder.append(".get(0).getValue().getValue();");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("resources = new ArrayList<Resource>();");
                                      _builder.newLine();
                                      _builder.append("\t\t");
                                      _builder.append("resources.add(listEntry_");
                                      ObSelectionStrategy _container_139 = mut.getContainer();
                                      String _name_156 = ((SpecificClosureSelection) _container_139).getObjSel().getName();
                                      _builder.append(_name_156, "\t\t");
                                      _builder.append(".get(0).getValue().getKey());");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t");
                                      _builder.append("for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_");
                                      ObSelectionStrategy _container_140 = mut.getContainer();
                                      String _name_157 = ((SpecificClosureSelection) _container_140).getObjSel().getName();
                                      _builder.append(_name_157, "\t\t");
                                      _builder.append(") {");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t\t\t");
                                      _builder.append("EObject obj = ent.getKey();");
                                      _builder.newLine();
                                      _builder.append("\t\t\t");
                                      _builder.append("objs.add(obj);");
                                      _builder.newLine();
                                      _builder.append("\t\t");
                                      _builder.append("}");
                                      _builder.newLine();
                                      _builder.append("\t\t");
                                      _builder.append("referenceSelection = new SpecificReferenceSelection(listEntry_");
                                      ObSelectionStrategy _container_141 = mut.getContainer();
                                      String _name_158 = ((SpecificClosureSelection) _container_141).getObjSel().getName();
                                      _builder.append(_name_158, "\t\t");
                                      _builder.append(".get(0).getValue().getValue(), listEntry_");
                                      ObSelectionStrategy _container_142 = mut.getContainer();
                                      String _name_159 = ((SpecificObjectSelection) _container_142).getObjSel().getName();
                                      _builder.append(_name_159, "\t\t");
                                      _builder.append(".get(0).getValue().getKey(), \"");
                                      String _name_160 = mut.getContainer().getRefType().getName();
                                      _builder.append(_name_160, "\t\t");
                                      _builder.append("\", listEntry_");
                                      ObSelectionStrategy _container_143 = mut.getContainer();
                                      String _name_161 = ((SpecificClosureSelection) _container_143).getObjSel().getName();
                                      _builder.append(_name_161, "\t\t");
                                      _builder.append(".get(0).getKey());");
                                      _builder.newLineIfNotEmpty();
                                      _builder.append("\t");
                                      _builder.append("}");
                                      _builder.newLine();
                                      _builder.append("\t");
                                      _builder.append("else {");
                                      _builder.newLine();
                                      _builder.append("\t\t");
                                      _builder.append("return mutations;");
                                      _builder.newLine();
                                      _builder.append("\t");
                                      _builder.append("}");
                                      _builder.newLine();
                                      _builder.append("}");
                                      _builder.newLine();
                                    } else {
                                      _builder.append("referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);");
                                      _builder.newLine();
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        {
                          if ((rts == true)) {
                            _builder.append("rts = new RandomTypeSelection(resourcePackages, resources, \"");
                            String _name_162 = mut.getObject().getType().getName();
                            _builder.append(_name_162);
                            _builder.append("\", referenceSelection, containerSelection);");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, \"");
                            String _name_163 = mut.getObject().getType().getName();
                            _builder.append(_name_163);
                            _builder.append("\", referenceSelection, containerSelection);");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          if (((mut.getObject().getExpression() == null) && (mut.getContainer().getExpression() == null))) {
                            _builder.append("EObject object = rts.getObject();");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                    {
                      if (((mut.getObject().getExpression() == null) && (mut.getContainer() == null))) {
                        _builder.append("EObject object = rts.getObject();");
                        _builder.newLine();
                      }
                    }
                    {
                      EReference _refType_10 = mut.getObject().getRefType();
                      boolean _tripleNotEquals_13 = (_refType_10 != null);
                      if (_tripleNotEquals_13) {
                        _builder.append("List<EObject> o = ModelManager.getReferences(\"");
                        String _name_164 = mut.getObject().getRefType().getName();
                        _builder.append(_name_164);
                        _builder.append("\", object);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("object = o.get(ModelManager.getRandomIndex(o));");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
            _builder.newLine();
            _builder.append("//");
            final List<String> resourceURIs_1 = new ArrayList<String>();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            final List<String> ecoreURIs_1 = new ArrayList<String>();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            final String resourceName_1 = mut.getObject().getResource();
            _builder.newLineIfNotEmpty();
            _builder.append("//");
            Resource resource_1 = null;
            _builder.newLineIfNotEmpty();
            {
              EList<Resource> _resources_1 = program.getResources();
              for(final Resource res_1 : _resources_1) {
                {
                  boolean _equals_1 = res_1.getName().equals(resourceName_1);
                  if (_equals_1) {
                    _builder.append("//");
                    _builder.append(resource_1 = res_1);
                    _builder.append(" ");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              if ((resource_1 != null)) {
                _builder.append("List<EPackage> savedPackages = new ArrayList<EPackage>();");
                _builder.newLine();
                _builder.append("savedPackages.addAll(packages);");
                _builder.newLine();
                _builder.append("packages.clear();");
                _builder.newLine();
                _builder.append("List<EPackage> objectPackages = null;");
                _builder.newLine();
                _builder.append("resources = new ArrayList<Resource>();");
                _builder.newLine();
                _builder.append("//");
                final Source source_1 = resource_1.getPath();
                _builder.newLineIfNotEmpty();
                _builder.append("//");
                String _path_2 = project.getLocation().toFile().getPath();
                String _plus_17 = (_path_2 + "/");
                String _path_3 = source_1.getPath();
                final String resourcePath_1 = (_plus_17 + _path_3);
                _builder.newLineIfNotEmpty();
                {
                  boolean _exists_1 = new File(resourcePath_1).exists();
                  if (_exists_1) {
                    {
                      File[] _listFiles_1 = new File(resourcePath_1).listFiles();
                      for(final File resourceFile_1 : _listFiles_1) {
                        {
                          boolean _endsWith_2 = resourceFile_1.getName().endsWith(".model");
                          if (_endsWith_2) {
                            _builder.append("//");
                            boolean _add_2 = resourceURIs_1.add(resourceFile_1.getPath());
                            _builder.append(_add_2);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          boolean _endsWith_3 = resourceFile_1.getName().endsWith(".ecore");
                          if (_endsWith_3) {
                            _builder.append("//");
                            boolean _add_3 = ecoreURIs_1.add(resourceFile_1.getPath());
                            _builder.append(_add_3);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
                {
                  for(final String resourceURI_1 : resourceURIs_1) {
                    _builder.append("String relativeResourceURI_");
                    _builder.append(i);
                    _builder.append(" = \"");
                    String _xifexpression_2 = null;
                    String _replace_5 = resourceURI_1.replace("\\", "/");
                    String _name_165 = project.getName();
                    String _plus_18 = ("/" + _name_165);
                    String _plus_19 = (_plus_18 + "/");
                    int _indexOf_2 = _replace_5.indexOf(_plus_19);
                    boolean _notEquals_2 = (_indexOf_2 != (-1));
                    if (_notEquals_2) {
                      String _replace_6 = resourceURI_1.replace("\\", "/");
                      String _replace_7 = resourceURI_1.replace("\\", "/");
                      String _name_166 = project.getName();
                      String _plus_20 = ("/" + _name_166);
                      String _plus_21 = (_plus_20 + "/");
                      int _lastIndexOf_3 = _replace_7.lastIndexOf(_plus_21);
                      String _name_167 = project.getName();
                      String _plus_22 = ("/" + _name_167);
                      int _length_3 = (_plus_22 + "/").length();
                      int _plus_23 = (_lastIndexOf_3 + _length_3);
                      _xifexpression_2 = _replace_6.substring(_plus_23, resourceURI_1.replace("\\", "/").length());
                    } else {
                      _xifexpression_2 = resourceURI_1;
                    }
                    _builder.append(_xifexpression_2);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("String absoluteResourceURI_");
                    _builder.append(i);
                    _builder.append(" = ");
                    _builder.append(className);
                    _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeResourceURI_");
                    _builder.append(i);
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("absoluteResourceURI_");
                    _builder.append(i);
                    _builder.append(" = \"file:/\" + absoluteResourceURI_");
                    _builder.append(i);
                    _builder.append(".substring(1, absoluteResourceURI_");
                    _builder.append(i);
                    _builder.append(".length()); ");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((standalone == false)) {
                        _builder.append("resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_");
                        _builder.append(i);
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    String _xblockexpression_2 = null;
                    {
                      i++;
                      _xblockexpression_2 = "";
                    }
                    _builder.append(_xblockexpression_2);
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  for(final String ecoreURI_1 : ecoreURIs_1) {
                    _builder.append("String relativeEcoreURI_");
                    _builder.append(j);
                    _builder.append(" = \"");
                    String _replace_8 = ecoreURI_1.replace("\\", "/");
                    String _replace_9 = ecoreURI_1.replace("\\", "/");
                    String _name_168 = project.getName();
                    String _plus_24 = ("/" + _name_168);
                    String _plus_25 = (_plus_24 + "/");
                    int _lastIndexOf_4 = _replace_9.lastIndexOf(_plus_25);
                    String _name_169 = project.getName();
                    String _plus_26 = ("/" + _name_169);
                    int _length_4 = (_plus_26 + "/").length();
                    int _plus_27 = (_lastIndexOf_4 + _length_4);
                    String _substring_1 = _replace_8.substring(_plus_27, ecoreURI_1.replace("\\", "/").length());
                    _builder.append(_substring_1);
                    _builder.append("\";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("String absoluteEcoreURI_");
                    _builder.append(j);
                    _builder.append(" = ");
                    _builder.append(className);
                    _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeEcoreURI_");
                    _builder.append(j);
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("absoluteEcoreURI_");
                    _builder.append(j);
                    _builder.append(" = absoluteEcoreURI_");
                    _builder.append(j);
                    _builder.append(".substring(1, absoluteEcoreURI_");
                    _builder.append(j);
                    _builder.append(".length()); ");
                    _builder.newLineIfNotEmpty();
                    {
                      if ((standalone == false)) {
                        _builder.append("resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, \"file:/\" + URI.createURI(absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, \"file:/\" + URI.createURI(absoluteEcoreURI_");
                        _builder.append(j);
                        _builder.append(").toFileString()));");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    String _xblockexpression_3 = null;
                    {
                      j++;
                      _xblockexpression_3 = "";
                    }
                    _builder.append(_xblockexpression_3);
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("//");
                final String metamodelPath_1 = resource_1.getMetamodel().replace("\\", "/");
                _builder.newLineIfNotEmpty();
                _builder.append("String relativeObjectMetamodelPath = \"");
                String _name_170 = project.getName();
                String _plus_28 = ("/" + _name_170);
                String _plus_29 = (_plus_28 + "/");
                int _lastIndexOf_5 = metamodelPath_1.lastIndexOf(_plus_29);
                String _name_171 = project.getName();
                String _plus_30 = ("/" + _name_171);
                int _length_5 = (_plus_30 + "/").length();
                int _plus_31 = (_lastIndexOf_5 + _length_5);
                String _substring_2 = metamodelPath_1.substring(_plus_31, metamodelPath_1.length());
                _builder.append(_substring_2);
                _builder.append("\";");
                _builder.newLineIfNotEmpty();
                _builder.append("String absoluteObjectMetamodelPath = ");
                _builder.append(className);
                _builder.append(".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\") + relativeObjectMetamodelPath;");
                _builder.newLineIfNotEmpty();
                {
                  if ((standalone == false)) {
                    _builder.append("objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, this.getClass());");
                    _builder.newLine();
                  } else {
                    _builder.append("objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, ");
                    _builder.append(className);
                    _builder.append(".class);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("packages.addAll(objectPackages);");
                _builder.newLine();
              }
            }
            {
              Expression _expression = mut.getObject().getExpression();
              boolean _tripleNotEquals_14 = (_expression != null);
              if (_tripleNotEquals_14) {
                {
                  ObSelectionStrategy _container_144 = mut.getContainer();
                  boolean _tripleEquals_3 = (_container_144 == null);
                  if (_tripleEquals_3) {
                    _builder.append("List<EObject> objects = rts.getObjects();");
                    _builder.newLine();
                    _builder.append("//EXPRESSION LIST: ");
                    List<Integer> expressionList = new ArrayList<Integer>();
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LIST: ");
                    boolean _add_4 = expressionList.add(Integer.valueOf(0));
                    _builder.append(_add_4);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LEVEL: ");
                    int[] nExpression = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LEVEL: ");
                    int _set = nExpression[0] = 0;
                    _builder.append(_set);
                    _builder.newLineIfNotEmpty();
                    _builder.append("Expression exp");
                    Integer _get = expressionList.get(0);
                    _builder.append(_get);
                    _builder.append(" = new Expression();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int[] nReference = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int _set_1 = nReference[0] = 0;
                    _builder.append(_set_1);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//RECURSION EXPRESSION LIST: ");
                    int[] recursionIndexExpression = new int[1];
                    _builder.append("»");
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int _set_2 = recursionIndexExpression[0] = 0;
                    _builder.append(_set_2);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("//");
                    boolean[] evaluation = new boolean[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("//");
                    String _xblockexpression_4 = null;
                    {
                      evaluation[0] = false;
                      _xblockexpression_4 = "";
                    }
                    _builder.append(_xblockexpression_4, "\t");
                    _builder.newLineIfNotEmpty();
                    _builder.newLine();
                    Object _method = this.method(mut.getObject().getExpression(), mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation);
                    _builder.append(_method);
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _get_1 = evaluation[0];
                      if (_get_1) {
                        _builder.append("List<EObject> selectedObjects = auxObjects;");
                        _builder.newLine();
                      } else {
                        _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                        Integer _get_2 = expressionList.get(0);
                        _builder.append(_get_2);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_8 = mut.getObject();
                      if ((_object_8 instanceof RandomTypeSelection)) {
                        _builder.append("EObject object = null;");
                        _builder.newLine();
                        _builder.append("if (selectedObjects.size() > 0) {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      ObSelectionStrategy _object_9 = mut.getObject();
                      if ((_object_9 instanceof CompleteTypeSelection)) {
                        _builder.append("objects = selectedObjects;");
                        _builder.newLine();
                      }
                    }
                  } else {
                    Expression _expression_1 = mut.getContainer().getExpression();
                    boolean _tripleEquals_4 = (_expression_1 == null);
                    if (_tripleEquals_4) {
                      _builder.append("List<EObject> objects = rts.getObjects();");
                      _builder.newLine();
                      _builder.append("//EXPRESSION LIST: ");
                      List<Integer> expressionList_1 = new ArrayList<Integer>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("//EXPRESSION LEVEL: ");
                      List<Integer> nExpression_1 = new ArrayList<Integer>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("//EXPRESSION LEVEL: ");
                      boolean _add_5 = expressionList_1.add(Integer.valueOf(0));
                      _builder.append(_add_5);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//EXPRESSION LEVEL: ");
                      boolean _add_6 = nExpression_1.add(Integer.valueOf(0));
                      _builder.append(_add_6);
                      _builder.newLineIfNotEmpty();
                      _builder.append("Expression exp");
                      Integer _get_3 = expressionList_1.get(0);
                      _builder.append(_get_3);
                      _builder.append(" = new Expression();");
                      _builder.newLineIfNotEmpty();
                      _builder.append("//REFERENCE COUNTER: ");
                      List<Integer> nReference_1 = new ArrayList<Integer>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("//REFERENCE COUNTER: ");
                      boolean _add_7 = nReference_1.add(Integer.valueOf(0));
                      _builder.append(_add_7);
                      _builder.newLineIfNotEmpty();
                      _builder.append("//RECURSION EXPRESSION COUNTER: ");
                      List<Integer> recursionIndexExpression_1 = new ArrayList<Integer>();
                      _builder.newLineIfNotEmpty();
                      _builder.append("//RECURSION EXPRESSION COUNTER: ");
                      boolean _add_8 = recursionIndexExpression_1.add(Integer.valueOf(0));
                      _builder.append(_add_8);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("//");
                      boolean[] evaluation_1 = new boolean[1];
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("//");
                      String _xblockexpression_5 = null;
                      {
                        evaluation_1[0] = false;
                        _xblockexpression_5 = "";
                      }
                      _builder.append(_xblockexpression_5, "\t");
                      _builder.newLineIfNotEmpty();
                      final List<Integer> _converted_nReference_1 = (List<Integer>)nReference_1;
                      final List<Integer> _converted_nExpression_1 = (List<Integer>)nExpression_1;
                      final List<Integer> _converted_recursionIndexExpression_1 = (List<Integer>)recursionIndexExpression_1;
                      Object _method_1 = this.method(mut.getObject().getExpression(), mut, ((int[])Conversions.unwrapArray(_converted_nReference_1, int.class)), expressionList_1, ((int[])Conversions.unwrapArray(_converted_nExpression_1, int.class)), ((int[])Conversions.unwrapArray(_converted_recursionIndexExpression_1, int.class)), false, false, false, evaluation_1);
                      _builder.append(_method_1);
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _get_4 = evaluation_1[0];
                        if (_get_4) {
                          _builder.append("List<EObject> selectedObjects = auxObjects;");
                          _builder.newLine();
                        } else {
                          _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                          Integer _get_5 = expressionList_1.get(0);
                          _builder.append(_get_5);
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        ObSelectionStrategy _object_10 = mut.getObject();
                        if ((_object_10 instanceof RandomTypeSelection)) {
                          _builder.append("EObject object = null;");
                          _builder.newLine();
                          _builder.append("if (selectedObjects.size() > 0) {");
                          _builder.newLine();
                          _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                          _builder.newLine();
                          _builder.append("}");
                          _builder.newLine();
                        }
                      }
                      {
                        ObSelectionStrategy _object_11 = mut.getObject();
                        if ((_object_11 instanceof CompleteTypeSelection)) {
                          _builder.append("objects = selectedObjects;");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
            }
            {
              Expression _expression_2 = mut.getObject().getExpression();
              boolean _tripleEquals_5 = (_expression_2 == null);
              if (_tripleEquals_5) {
                {
                  if (((mut.getContainer() != null) && (mut.getContainer().getExpression() != null))) {
                    _builder.append("List<EObject> objects = rts.getObjects();");
                    _builder.newLine();
                    _builder.append("//EXPRESSION LIST: ");
                    List<Integer> expressionList_2 = new ArrayList<Integer>();
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LIST: ");
                    boolean _add_9 = expressionList_2.add(Integer.valueOf(0));
                    _builder.append(_add_9);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LEVEL: ");
                    int[] nExpression_2 = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("//EXPRESSION LEVEL: ");
                    int _set_3 = nExpression_2[0] = 0;
                    _builder.append(_set_3);
                    _builder.newLineIfNotEmpty();
                    _builder.append("Expression exp");
                    Integer _get_6 = expressionList_2.get(0);
                    _builder.append(_get_6);
                    _builder.append(" = new Expression();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int[] nReference_2 = new int[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int _set_4 = nReference_2[0] = 0;
                    _builder.append(_set_4);
                    _builder.newLineIfNotEmpty();
                    _builder.append("//RECURSION EXPRESSION LIST: ");
                    int[] recursionIndexExpression_2 = new int[1];
                    _builder.append("»");
                    _builder.newLineIfNotEmpty();
                    _builder.append("//REFERENCE LIST: ");
                    int _set_5 = recursionIndexExpression_2[0] = 0;
                    _builder.append(_set_5);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("//");
                    boolean[] evaluation_2 = new boolean[1];
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("//");
                    String _xblockexpression_6 = null;
                    {
                      evaluation_2[0] = false;
                      _xblockexpression_6 = "";
                    }
                    _builder.append(_xblockexpression_6, "\t");
                    _builder.newLineIfNotEmpty();
                    Object _method_2 = this.method(mut.getContainer().getExpression(), mut, nReference_2, expressionList_2, nExpression_2, recursionIndexExpression_2, true, false, false, evaluation_2);
                    _builder.append(_method_2);
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _get_7 = evaluation_2[0];
                      if (_get_7) {
                        _builder.append("List<EObject> selectedObjects = auxObjects;");
                        _builder.newLine();
                      } else {
                        _builder.append("List<EObject> selectedObjects = evaluate(objects, exp");
                        Integer _get_8 = expressionList_2.get(0);
                        _builder.append(_get_8);
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      ObSelectionStrategy _object_12 = mut.getObject();
                      if ((_object_12 instanceof RandomTypeSelection)) {
                        _builder.append("EObject object = null;");
                        _builder.newLine();
                        _builder.append("if (selectedObjects.size() > 0) {");
                        _builder.newLine();
                        _builder.append("object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));");
                        _builder.newLine();
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      ObSelectionStrategy _object_13 = mut.getObject();
                      if ((_object_13 instanceof CompleteTypeSelection)) {
                        _builder.append("objects = selectedObjects;");
                        _builder.newLine();
                      }
                    }
                  }
                }
                {
                  if (((mut.getContainer() != null) && (mut.getContainer().getExpression() == null))) {
                    {
                      ObSelectionStrategy _object_14 = mut.getObject();
                      if ((_object_14 instanceof CompleteTypeSelection)) {
                        _builder.append("List<EObject> objects = rts.getObjects();");
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
            {
              if ((resource_1 != null)) {
                _builder.append("packages.clear();");
                _builder.newLine();
                _builder.append("packages.addAll(savedPackages);");
                _builder.newLine();
              }
            }
            {
              if (((mut.getObject() instanceof RandomTypeSelection) || (mut.getObject() instanceof SpecificObjectSelection))) {
                _builder.append("ObSelectionStrategy objectSelection = null; ");
                _builder.newLine();
                _builder.append("if (object != null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          } else {
            ObSelectionStrategy _object_15 = mut.getObject();
            if ((_object_15 instanceof CompleteTypeSelection)) {
              _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, model, \"");
              ObSelectionStrategy _object_16 = mut.getObject();
              String _name_172 = ((CompleteTypeSelection) _object_16).getType().getName();
              _builder.append(_name_172);
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("EObject object = rts.getObject();");
              _builder.newLine();
              _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
              _builder.newLine();
            } else {
              ObSelectionStrategy _object_17 = mut.getObject();
              if ((_object_17 instanceof SpecificObjectSelection)) {
                _builder.append("ObSelectionStrategy objectSelection = null;");
                _builder.newLine();
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_145 = mut.getContainer();
                String _name_173 = ((SpecificObjectSelection) _container_145).getObjSel().getName();
                _builder.append(_name_173);
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_146 = mut.getContainer();
                String _name_174 = ((SpecificObjectSelection) _container_146).getObjSel().getName();
                _builder.append(_name_174);
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("if (entry_");
                ObSelectionStrategy _container_147 = mut.getContainer();
                String _name_175 = ((SpecificObjectSelection) _container_147).getObjSel().getName();
                _builder.append(_name_175);
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("resourcePackages = entry_");
                ObSelectionStrategy _container_148 = mut.getContainer();
                String _name_176 = ((SpecificObjectSelection) _container_148).getObjSel().getName();
                _builder.append(_name_176, "\t");
                _builder.append(".getValue().getValue();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("resources = new ArrayList<Resource>();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("resources.add(entry_");
                ObSelectionStrategy _container_149 = mut.getContainer();
                String _name_177 = ((SpecificObjectSelection) _container_149).getObjSel().getName();
                _builder.append(_name_177, "\t");
                _builder.append(".getValue().getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("objectSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _container_150 = mut.getContainer();
                String _name_178 = ((SpecificObjectSelection) _container_150).getObjSel().getName();
                _builder.append(_name_178, "\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _container_151 = mut.getContainer();
                String _name_179 = ((SpecificObjectSelection) _container_151).getObjSel().getName();
                _builder.append(_name_179, "\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _container_152 = mut.getContainer();
                String _name_180 = ((SpecificObjectSelection) _container_152).getObjSel().getName();
                _builder.append(_name_180, "\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("return mutations;");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              } else {
                ObSelectionStrategy _object_18 = mut.getObject();
                if ((_object_18 instanceof SpecificClosureSelection)) {
                  _builder.append("ObSelectionStrategy objectSelection = null;");
                  _builder.newLine();
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _container_153 = mut.getContainer();
                  String _name_181 = ((SpecificClosureSelection) _container_153).getObjSel().getName();
                  _builder.append(_name_181);
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _container_154 = mut.getContainer();
                  String _name_182 = ((SpecificClosureSelection) _container_154).getObjSel().getName();
                  _builder.append(_name_182);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("if (entry_");
                  ObSelectionStrategy _container_155 = mut.getContainer();
                  String _name_183 = ((SpecificClosureSelection) _container_155).getObjSel().getName();
                  _builder.append(_name_183);
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("resourcePackages = entry_");
                  ObSelectionStrategy _container_156 = mut.getContainer();
                  String _name_184 = ((SpecificClosureSelection) _container_156).getObjSel().getName();
                  _builder.append(_name_184, "\t");
                  _builder.append(".getValue().getValue();");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("resources = new ArrayList<Resource>();");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("resources.add(entry_");
                  ObSelectionStrategy _container_157 = mut.getContainer();
                  String _name_185 = ((SpecificClosureSelection) _container_157).getObjSel().getName();
                  _builder.append(_name_185, "\t");
                  _builder.append(".getValue().getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("objectSelection = new SpecificClosureSelection(entry_");
                  ObSelectionStrategy _container_158 = mut.getContainer();
                  String _name_186 = ((SpecificClosureSelection) _container_158).getObjSel().getName();
                  _builder.append(_name_186, "\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _container_159 = mut.getContainer();
                  String _name_187 = ((SpecificClosureSelection) _container_159).getObjSel().getName();
                  _builder.append(_name_187, "\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _container_160 = mut.getContainer();
                  String _name_188 = ((SpecificClosureSelection) _container_160).getObjSel().getName();
                  _builder.append(_name_188, "\t");
                  _builder.append(".getKey(), \"");
                  ObSelectionStrategy _object_19 = mut.getObject();
                  String _name_189 = ((SpecificClosureSelection) _object_19).getRefType().getName();
                  _builder.append(_name_189, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("return mutations;");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("List<EObject> objects = ModelManager.getParentObjects(packages, model, \"");
                  String _name_190 = mut.getType().getName();
                  _builder.append(_name_190);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("EObject container = containers.get(ModelManager.getRandomIndex(objects));");
                  _builder.newLine();
                  _builder.append("ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);");
                  _builder.newLine();
                }
              }
            }
          }
        }
        {
          ObSelectionStrategy _object_20 = mut.getObject();
          if ((_object_20 instanceof CompleteTypeSelection)) {
            _builder.append("for (EObject obj : objects) {");
            _builder.newLine();
            _builder.append("SelectObjectMutator mut = new SelectObjectMutator(resources, resourcePackages, referenceSelection, containerSelection, obj);");
            _builder.newLine();
            _builder.append("//INC COUNTER: ");
            int _get_9 = nMutation[0];
            int _plus_32 = (_get_9 + 1);
            int _set_6 = nMutation[0] = _plus_32;
            _builder.append(_set_6);
            _builder.newLineIfNotEmpty();
            _builder.append("//INC COUNTER: ");
            int _get_10 = nRegistryMutation[0];
            int _plus_33 = (_get_10 + 1);
            int _set_7 = nRegistryMutation[0] = _plus_33;
            _builder.append(_set_7);
            _builder.newLineIfNotEmpty();
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("mut.setId(\"m");
            _builder.append(nMutation);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("SelectObjectMutator mut = null;");
            _builder.newLine();
            _builder.append("if (objectSelection != null) {");
            _builder.newLine();
            _builder.append("mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, containerSelection, objectSelection);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.append("//INC COUNTER: ");
            int _get_11 = nMutation[0];
            int _plus_34 = (_get_11 + 1);
            int _set_8 = nMutation[0] = _plus_34;
            _builder.append(_set_8);
            _builder.newLineIfNotEmpty();
            _builder.append("//INC COUNTER: ");
            int _get_12 = nRegistryMutation[0];
            int _plus_35 = (_get_12 + 1);
            int _set_9 = nRegistryMutation[0] = _plus_35;
            _builder.append(_set_9);
            _builder.newLineIfNotEmpty();
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("mut.setId(\"m");
            int _get_13 = nMutation[0];
            _builder.append(_get_13);
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("mutations.add(mut);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("//END SELECT OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
