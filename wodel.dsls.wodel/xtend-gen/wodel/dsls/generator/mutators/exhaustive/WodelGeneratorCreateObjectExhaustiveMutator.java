package wodel.dsls.generator.mutators.exhaustive;

import java.util.ArrayList;
import java.util.List;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.Block;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.dsls.runner.WodelUtils;

@SuppressWarnings("all")
public class WodelGeneratorCreateObjectExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((mt instanceof CreateObjectMutator)) {
        _builder.append("\t");
        _builder.append("//");
        CreateObjectMutator mut = ((CreateObjectMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//CREATE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
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
        _builder.append("\t");
        _builder.append("Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ObSelectionStrategy objectSelection = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        int[] counter = new int[1];
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        String _xblockexpression = null;
        {
          counter[0] = 0;
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//POSITION:");
        int position = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeSet> _attributes = mut.getAttributes();
          for(final AttributeSet c : _attributes) {
            _builder.append("\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_1 = null;
            {
              int _get = counter[0];
              int _plus = (_get + 1);
              counter[0] = _plus;
              _xblockexpression_1 = "";
            }
            _builder.append(_xblockexpression_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//POSITION");
            String _xblockexpression_2 = null;
            {
              position++;
              _xblockexpression_2 = "";
            }
            _builder.append(_xblockexpression_2, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _method = this.method(c, false, false, counter, position, true, "objectSelection");
            _builder.append(_method, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        String _xblockexpression_3 = null;
        {
          counter = new int[1];
          _xblockexpression_3 = "";
        }
        _builder.append(_xblockexpression_3, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COUNTER:");
        String _xblockexpression_4 = null;
        {
          counter[0] = 0;
          _xblockexpression_4 = "";
        }
        _builder.append(_xblockexpression_4, "\t");
        _builder.newLineIfNotEmpty();
        {
          EList<ReferenceSet> _references = mut.getReferences();
          for(final ReferenceSet c_1 : _references) {
            _builder.append("\t");
            _builder.append("//COUNTER:");
            String _xblockexpression_5 = null;
            {
              int _get = counter[0];
              int _plus = (_get + 1);
              counter[0] = _plus;
              _xblockexpression_5 = "";
            }
            _builder.append(_xblockexpression_5, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LIST: ");
            List<Integer> expressionList = new ArrayList<Integer>();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//EXPRESSION LEVEL: ");
            boolean _add = expressionList.add(Integer.valueOf(0));
            _builder.append(_add, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int[] nExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//INDEX EXPRESSION: ");
            int _set = nExpression[0] = 0;
            _builder.append(_set, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int[] recursionIndexExpression = new int[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("//RECURSION INDEX EXPRESSION: ");
            int _set_1 = recursionIndexExpression[0] = 0;
            _builder.append(_set_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("//");
            boolean[] evaluation = new boolean[1];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("//");
            String _xblockexpression_6 = null;
            {
              evaluation[0] = false;
              _xblockexpression_6 = "";
            }
            _builder.append(_xblockexpression_6, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _method_1 = this.method(c_1, mut, counter, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation);
            _builder.append(_method_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("String tempModel =");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
        _builder.append("WodelTempModelContext.nextModelPath(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
        _builder.append("model,");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
        _builder.append("\"");
        _builder.append(methodName, "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        ");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
        _builder.newLine();
        _builder.append("\t\t\t    \t\t\t\t\t\t\t");
        _builder.append("Resource resource = owned.own(");
        _builder.newLine();
        _builder.append("\t\t\t    \t\t\t\t\t\t\t                    ");
        _builder.append("ModelManager.cloneModel(");
        _builder.newLine();
        _builder.append("\t\t\t    \t\t\t\t\t\t\t                        ");
        _builder.append("model,");
        _builder.newLine();
        _builder.append("\t\t\t    \t\t\t\t\t\t\t                        ");
        _builder.append("tempModel));");
        _builder.newLine();
        _builder.append("\t\t\t    \t\t\t\t\t\t\t                        ");
        _builder.append("models.add(resource);");
        _builder.newLine();
        {
          ObSelectionStrategy _container = mut.getContainer();
          boolean _tripleEquals = (_container == null);
          if (_tripleEquals) {
            _builder.append("\t");
            _builder.append("List<EObject> containers = ModelManager.getParentObjects(packages, resource, \"");
            String _name = mut.getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("if (containers == null || containers.isEmpty()) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("return numMutantsGenerated;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("ModelManager.sortEObjectsDeterministically(containers);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("EObject container = containers.get(ModelManager.getRandomIndex(containers));");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);");
            _builder.newLine();
          } else {
            {
              ObSelectionStrategy _container_1 = mut.getContainer();
              if ((_container_1 instanceof RandomTypeSelection)) {
                _builder.append("\t");
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, resource, \"");
                ObSelectionStrategy _container_2 = mut.getContainer();
                String _name_1 = ((RandomTypeSelection) _container_2).getType().getName();
                _builder.append(_name_1, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);");
                _builder.newLine();
                {
                  EReference _refType = mut.getContainer().getRefType();
                  boolean _tripleNotEquals = (_refType != null);
                  if (_tripleNotEquals) {
                    _builder.append("\t");
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, \"");
                    String _name_2 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_2, "\t");
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_3 = mut.getContainer();
              if ((_container_3 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("RandomTypeSelection rts = new RandomTypeSelection(packages, resource, \"");
                ObSelectionStrategy _container_4 = mut.getContainer();
                String _name_3 = ((CompleteTypeSelection) _container_4).getType().getName();
                _builder.append(_name_3, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("EObject container = rts.getObject();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, resource, container);");
                _builder.newLine();
                {
                  EReference _refType_1 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_1 = (_refType_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder.append("\t");
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, \"");
                    String _name_4 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_4, "\t");
                    _builder.append("\", containerSelection);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              ObSelectionStrategy _container_5 = mut.getContainer();
              if ((_container_5 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy containerSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SpecificReferenceSelection referenceSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_6 = mut.getContainer();
                String _name_5 = ((SpecificObjectSelection) _container_6).getObjSel().getName();
                _builder.append(_name_5, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_7 = mut.getContainer();
                String _name_6 = ((SpecificObjectSelection) _container_7).getObjSel().getName();
                _builder.append(_name_6, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_8 = mut.getContainer();
                String _name_7 = ((SpecificObjectSelection) _container_8).getObjSel().getName();
                _builder.append(_name_7, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_");
                ObSelectionStrategy _container_9 = mut.getContainer();
                String _name_8 = ((SpecificObjectSelection) _container_9).getObjSel().getName();
                _builder.append(_name_8, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("recovered = ModelManager.getObject(");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t                ");
                _builder.append("models,");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t                ");
                _builder.append("entry_");
                ObSelectionStrategy _container_10 = mut.getContainer();
                String _name_9 = ((SpecificObjectSelection) _container_10).getObjSel().getName();
                _builder.append(_name_9, "\t\t\t                ");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_2 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_2 = (_refType_2 != null);
                  if (_tripleNotEquals_2) {
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificObjectSelection(packages, resource, recovered);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, resource, \"");
                    String _name_10 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_10, "\t");
                    _builder.append("\", recovered);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("} else {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              ObSelectionStrategy _container_11 = mut.getContainer();
              if ((_container_11 instanceof SpecificClosureSelection)) {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy containerSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SpecificReferenceSelection referenceSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _container_12 = mut.getContainer();
                String _name_11 = ((SpecificClosureSelection) _container_12).getObjSel().getName();
                _builder.append(_name_11, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _container_13 = mut.getContainer();
                String _name_12 = ((SpecificClosureSelection) _container_13).getObjSel().getName();
                _builder.append(_name_12, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_14 = mut.getContainer();
                String _name_13 = ((SpecificClosureSelection) _container_14).getObjSel().getName();
                _builder.append(_name_13, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _container_15 = mut.getContainer();
                String _name_14 = ((SpecificObjectSelection) _container_15).getObjSel().getName();
                _builder.append(_name_14, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_");
                ObSelectionStrategy _container_16 = mut.getContainer();
                String _name_15 = ((SpecificClosureSelection) _container_16).getObjSel().getName();
                _builder.append(_name_15, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("recovered = ModelManager.getObject(");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t                ");
                _builder.append("models,");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t                ");
                _builder.append("entry_");
                ObSelectionStrategy _container_17 = mut.getContainer();
                String _name_16 = ((SpecificClosureSelection) _container_17).getObjSel().getName();
                _builder.append(_name_16, "\t\t\t                ");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (recovered == null) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("return numMutantsGenerated;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  EReference _refType_3 = mut.getContainer().getRefType();
                  boolean _tripleNotEquals_3 = (_refType_3 != null);
                  if (_tripleNotEquals_3) {
                    _builder.append("\t");
                    _builder.append("containerSelection = new SpecificClosureSelection(packages, resource, recovered, \"");
                    ObSelectionStrategy _container_18 = mut.getContainer();
                    String _name_17 = ((SpecificClosureSelection) _container_18).getObjSel().getName();
                    _builder.append(_name_17, "\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("referenceSelection = new SpecificReferenceSelection(pakages, resource, \"");
                    String _name_18 = mut.getContainer().getRefType().getName();
                    _builder.append(_name_18, "\t");
                    _builder.append("\", recovered);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("referenceSelection = new SpecificReferenceSelection(packages, resource, null, null);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return numMutantsGenerated;");
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
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("CreateObjectMutator mut = new CreateObjectMutator(resource, packages, referenceSelection, containerSelection, atts, refs, \"");
        String _name_19 = mut.getType().getName();
        _builder.append(_name_19, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("Mutator mutator = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (muts == null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("muts = AppliedMutationsFactory.eINSTANCE.createMutations();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER: ");
        int _get = nRegistryMutation[0];
        int _plus = (_get + 1);
        int _set_2 = nRegistryMutation[0] = _plus;
        _builder.append(_set_2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//COUNTER: ");
        int _get_1 = nRegistryMethodCall[0];
        int _plus_1 = (_get_1 + 1);
        int _set_3 = nRegistryMethodCall[0] = _plus_1;
        _builder.append(_set_3, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//REGISTRY METHOD NAME:");
        String _string = Integer.valueOf((nRegistryMethodCall[0])).toString();
        String registryMethodName = ("registry" + _string);
        _builder.newLineIfNotEmpty();
        _builder.append("\t   \t\t");
        _builder.append("int mutsMark = mutationMark(muts);");
        _builder.newLine();
        {
          if ((executeMutation == true)) {
            _builder.append("\t");
            _builder.append("if (mut != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("/*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("* IMPORTANT:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("* Capture the removed EObject from the PRE-MUTATION");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("* source model. Do not use mut.getObject() here:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("* RemoveObjectMutator only populates that information");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("* during mutate().");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t     ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t    ");
            _builder.append("EObject clue =");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t        ");
            _builder.append("findEObjectForRegistry(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("seed,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("model,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("containerSelection.getObject(),");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("null,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("mutPaths,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t            ");
            _builder.append("packages);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t        ");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("if (mutated != null) {");
            _builder.newLine();
            {
              String _name_20 = mut.getName();
              boolean _tripleNotEquals_4 = (_name_20 != null);
              if (_tripleNotEquals_4) {
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);");
                _builder.newLine();
                {
                  ObSelectionStrategy _container_19 = mut.getContainer();
                  boolean _not = (!(_container_19 instanceof CompleteTypeSelection));
                  if (_not) {
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.put(\"");
                    String _name_21 = mut.getName();
                    _builder.append(_name_21, "\t\t\t\t");
                    _builder.append("\", entry);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("hmObjects.remove(\"");
                    String _name_22 = mut.getName();
                    _builder.append(_name_22, "\t\t\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t\t\t");
                    _builder.append("hmList.put(\"");
                    String _name_23 = mut.getName();
                    _builder.append(_name_23, "\t\t\t\t");
                    _builder.append("\", entries);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("AppMutation appMut = ");
            _builder.append(registryMethodName, "\t\t\t\t");
            _builder.append("(mut, hmMutator, seed, model, clue, mutPaths, packages);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("if (appMut != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("muts.getMuts().add(appMut);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("mutator = mut;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (mutator != null) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("//COUNTER: ");
        int _get_2 = nMethodCall[0];
        int _plus_2 = (_get_2 + 1);
        int _set_4 = nMethodCall[0] = _plus_2;
        _builder.append(_set_4, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("//MUTATION METHOD NAME:");
        String _string_1 = Integer.valueOf((nMethodCall[0])).toString();
        String nMethodName = ("mutation" + _string_1);
        _builder.newLineIfNotEmpty();
        {
          if ((last == false)) {
            {
              if ((standalone == false)) {
                _builder.append("\t\t\t");
                _builder.append(nMethodName, "\t\t\t");
                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                _builder.newLine();
              } else {
                _builder.append("\t\t\t");
                _builder.append(nMethodName, "\t\t\t");
                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("numMutantsGenerated = k[0];");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          if ((last == true)) {
            _builder.append("\t\t\t");
            _builder.append("// MUTANT COMPLETION AND REGISTRY");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
            _builder.newLine();
            {
              EList<Constraint> _constraints = e.getConstraints();
              for(final Constraint constraint : _constraints) {
                _builder.append("\t\t\t");
                _builder.append("if (rules.get(\"");
                String _name_24 = constraint.getType().getName();
                _builder.append(_name_24, "\t\t\t");
                _builder.append("\") == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("rules.put(\"");
                String _name_25 = constraint.getType().getName();
                _builder.append(_name_25, "\t\t\t\t");
                _builder.append("\", new ArrayList<String>());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("List<String> newrules = rules.get(\"");
                String _name_26 = constraint.getType().getName();
                _builder.append(_name_26, "\t\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InvariantCS> _expressions = constraint.getExpressions();
                  boolean _tripleNotEquals_5 = (_expressions != null);
                  if (_tripleNotEquals_5) {
                    {
                      EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                      for(final InvariantCS expression : _expressions_1) {
                        _builder.append("\t\t\t");
                        _builder.append("newrules.add(\"");
                        String _constraintText = WodelUtils.getConstraintText(fileURI.lastSegment(), expression);
                        _builder.append(_constraintText, "\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                {
                  EList<String> _rules = constraint.getRules();
                  boolean _tripleNotEquals_6 = (_rules != null);
                  if (_tripleNotEquals_6) {
                    {
                      EList<String> _rules_1 = constraint.getRules();
                      for(final String rule : _rules_1) {
                        _builder.append("\t\t\t");
                        _builder.append("newrules.add(\"");
                        _builder.append(rule, "\t\t\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("rules.put(\"");
                String _name_27 = constraint.getType().getName();
                _builder.append(_name_27, "\t\t\t");
                _builder.append("\", newrules);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((b == null)) {
                _builder.append("\t\t\t");
                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                _builder.newLine();
              } else {
                {
                  int _size = b.getFrom().size();
                  boolean _equals = (_size == 0);
                  if (_equals) {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_28 = b.getName();
                    _builder.append(_name_28);
                    _builder.append("/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_29 = b.getName();
                    _builder.append(_name_29);
                    _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
            _builder.newLine();
            {
              if ((b == null)) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_30 = project.getName();
                    _builder.append(_name_30, "\t\t   \t\t\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t\t   \t\t\t");
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
                    String _name_31 = b.getName();
                    _builder.append(_name_31);
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_32 = b.getName();
                    _builder.append(_name_32, "\t");
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_33 = project.getName();
                    _builder.append(_name_33, "\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t");
                    _builder.append(".class, true, false);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("if (isRepeated == false) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("numMutantsGenerated++;");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("monitor.worked(1);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("k[0] = k[0] + 1;");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("//if (muts != null) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("//\tmuts.getMuts().clear();");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("//}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//END CREATE OBJECT ");
        _builder.append(methodName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
