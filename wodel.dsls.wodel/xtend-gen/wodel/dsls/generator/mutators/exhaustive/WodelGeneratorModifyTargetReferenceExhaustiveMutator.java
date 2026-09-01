package wodel.dsls.generator.mutators.exhaustive;

import mutatorenvironment.Block;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.Constraint;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.miniOCL.InvariantCS;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import wodel.dsls.runner.WodelUtils;

@SuppressWarnings("all")
public class WodelGeneratorModifyTargetReferenceExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {
  @Override
  public CharSequence apply(final Mutator mt, final MutatorEnvironment e, final Block b, final String methodName, final int[] nMutation, final int[] nMethodCall, final int[] nRegistryMutation, final int[] nRegistryMethodCall, final boolean executeMutation, final boolean last, final String className, final URI fileURI, final Program program, final IProject project, final boolean standalone) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.newLine();
    {
      if ((mt instanceof ModifyTargetReferenceMutator)) {
        _builder.append("//");
        ModifyTargetReferenceMutator mut = ((ModifyTargetReferenceMutator) mt);
        _builder.newLineIfNotEmpty();
        _builder.append("//MODIFY TARGET REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("ObSelectionStrategy containerSelection = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("SpecificReferenceSelection referenceSelection = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("List<EObject> listSources = new ArrayList<EObject>();");
        _builder.newLine();
        {
          ObSelectionStrategy _source = mut.getSource();
          if ((_source instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, models, \"");
            ObSelectionStrategy _source_1 = mut.getSource();
            String _name = ((RandomTypeSelection) _source_1).getType().getName();
            _builder.append(_name, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("listSources.addAll(sourceSelection.getObjects());");
            _builder.newLine();
          } else {
            ObSelectionStrategy _source_2 = mut.getSource();
            if ((_source_2 instanceof CompleteTypeSelection)) {
              _builder.append("\t");
              _builder.append("RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, models, \"");
              ObSelectionStrategy _source_3 = mut.getSource();
              String _name_1 = ((CompleteTypeSelection) _source_3).getType().getName();
              _builder.append(_name_1, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("listSources.addAll(sourceSelection.getObjects());");
              _builder.newLine();
            } else {
              ObSelectionStrategy _source_4 = mut.getSource();
              if ((_source_4 instanceof SpecificObjectSelection)) {
                _builder.append("\t");
                _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                ObSelectionStrategy _source_5 = mut.getSource();
                String _name_2 = ((SpecificObjectSelection) _source_5).getObjSel().getName();
                _builder.append(_name_2, "\t");
                _builder.append(" = hmObjects.get(\"");
                ObSelectionStrategy _source_6 = mut.getSource();
                String _name_3 = ((SpecificObjectSelection) _source_6).getObjSel().getName();
                _builder.append(_name_3, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("SpecificObjectSelection sourceSelection = null;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("if (entry_");
                ObSelectionStrategy _source_7 = mut.getSource();
                String _name_4 = ((SpecificObjectSelection) _source_7).getObjSel().getName();
                _builder.append(_name_4, "\t");
                _builder.append(" != null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("sourceSelection = new SpecificObjectSelection(entry_");
                ObSelectionStrategy _source_8 = mut.getSource();
                String _name_5 = ((SpecificObjectSelection) _source_8).getObjSel().getName();
                _builder.append(_name_5, "\t\t");
                _builder.append(".getValue().getValue(), entry_");
                ObSelectionStrategy _source_9 = mut.getSource();
                String _name_6 = ((SpecificObjectSelection) _source_9).getObjSel().getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(".getValue().getKey(), entry_");
                ObSelectionStrategy _source_10 = mut.getSource();
                String _name_7 = ((SpecificObjectSelection) _source_10).getObjSel().getName();
                _builder.append(_name_7, "\t\t");
                _builder.append(".getKey());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("listSources.add(sourceSelection.getObject());");
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
              } else {
                _builder.append("\t");
                _builder.append("ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, models, (EObject) null);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("listSources.addAll(sourceSelection.getObjects());");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("Mutator mutator = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (listSources == null || listSources.isEmpty()) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return numMutantsGenerated;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("Resource model = MutatorUtils.currentModel(models);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (model == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return numMutantsGenerated;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
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
        _builder.append("\t\t\t\t\t\t\t");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (EObject sourceObject : listSources) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try (OwnedResourceScope owned = new OwnedResourceScope()) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("Resource resource = owned.own(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t    \t\t\t\t\t\t\t                    ");
        _builder.append("ModelManager.cloneModel(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t    \t\t\t\t\t\t\t                        ");
        _builder.append("model,");
        _builder.newLine();
        _builder.append("\t\t\t\t\t    \t\t\t\t\t\t\t                        ");
        _builder.append("tempModel));");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("models.add(resource);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Resource sourceModel = null;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("ObSelectionStrategy srcSelection = new SpecificObjectSelection(packages, resource, sourceObject);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("List<EObject> listTargets = new ArrayList<EObject>();");
        _builder.newLine();
        {
          ObSelectionStrategy _newTarget = mut.getNewTarget();
          if ((_newTarget instanceof RandomTypeSelection)) {
            _builder.append("\t");
            _builder.append("RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, resource, \"");
            ObSelectionStrategy _newTarget_1 = mut.getNewTarget();
            String _name_8 = ((RandomTypeSelection) _newTarget_1).getType().getName();
            _builder.append(_name_8, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("listTargets.addAll(newTargetSelection.getObjects());");
            _builder.newLine();
          } else {
            ObSelectionStrategy _newTarget_2 = mut.getNewTarget();
            if ((_newTarget_2 instanceof OtherTypeSelection)) {
              _builder.append("\t");
              _builder.append("Object otherRef = null;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("if (sourceObject != null) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (EReference ref : sourceObject.eClass().getEAllReferences()) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("if (ref.getName().equals(\"");
              String _name_9 = mut.getRefType().getName();
              _builder.append(_name_9, "\t\t\t");
              _builder.append("\")) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t\t\t");
              _builder.append("otherRef = sourceObject.eGet(ref);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t\t");
              _builder.append("break;");
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
              _builder.append("\t");
              _builder.append("OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, resource, \"");
              ObSelectionStrategy _newTarget_3 = mut.getNewTarget();
              String _name_10 = ((OtherTypeSelection) _newTarget_3).getType().getName();
              _builder.append(_name_10, "\t\t");
              _builder.append("\", otherRef);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("listTargets.addAll(newTargetSelection.getObjects());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              ObSelectionStrategy _newTarget_4 = mut.getNewTarget();
              if ((_newTarget_4 instanceof CompleteTypeSelection)) {
                _builder.append("\t");
                _builder.append("RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, resource, \"");
                ObSelectionStrategy _newTarget_5 = mut.getNewTarget();
                String _name_11 = ((CompleteTypeSelection) _newTarget_5).getType().getName();
                _builder.append(_name_11, "\t");
                _builder.append("\");\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("listTargets.addAll(newTargetSelection.getObjects());");
                _builder.newLine();
              } else {
                ObSelectionStrategy _newTarget_6 = mut.getNewTarget();
                if ((_newTarget_6 instanceof SpecificObjectSelection)) {
                  _builder.append("\t");
                  _builder.append("SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_");
                  ObSelectionStrategy _newTarget_7 = mut.getNewTarget();
                  String _name_12 = ((SpecificObjectSelection) _newTarget_7).getObjSel().getName();
                  _builder.append(_name_12, "\t");
                  _builder.append(" = hmObjects.get(\"");
                  ObSelectionStrategy _newTarget_8 = mut.getNewTarget();
                  String _name_13 = ((SpecificObjectSelection) _newTarget_8).getObjSel().getName();
                  _builder.append(_name_13, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("SpecificObjectSelection newTargetSelection = null;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("if (entry_");
                  ObSelectionStrategy _newTarget_9 = mut.getNewTarget();
                  String _name_14 = ((SpecificObjectSelection) _newTarget_9).getObjSel().getName();
                  _builder.append(_name_14, "\t");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("newTargetSelection = new SpecificObjectSelection(entry_");
                  ObSelectionStrategy _newTarget_10 = mut.getNewTarget();
                  String _name_15 = ((SpecificObjectSelection) _newTarget_10).getObjSel().getName();
                  _builder.append(_name_15, "\t\t");
                  _builder.append(".getValue().getValue(), entry_");
                  ObSelectionStrategy _newTarget_11 = mut.getNewTarget();
                  String _name_16 = ((SpecificObjectSelection) _newTarget_11).getObjSel().getName();
                  _builder.append(_name_16, "\t\t");
                  _builder.append(".getValue().getKey(), entry_");
                  ObSelectionStrategy _newTarget_12 = mut.getNewTarget();
                  String _name_17 = ((SpecificObjectSelection) _newTarget_12).getObjSel().getName();
                  _builder.append(_name_17, "\t\t");
                  _builder.append(".getKey());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("listTargets.add(newTargetSelection.getObject());");
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
                } else {
                  _builder.append("\t");
                  _builder.append("SpecificObjectSelection newTargetSelection = new SpecificObjectSelection(packages, resource, (EObject) null);");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("listTargets.add(newTargetSelection.getObject());");
                  _builder.newLine();
                }
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("for (EObject targetObject : listTargets) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("sourceModel = owned.own(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t                    ");
        _builder.append("ModelManager.cloneModel(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t                        ");
        _builder.append("model,");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t\t\t                        ");
        _builder.append("tempModel));");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("models.add(sourceModel);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("EObject source = ModelManager.getObject(models, sourceObject);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (source == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("ObSelectionStrategy srcSelection2 = new SpecificObjectSelection(packages, sourceModel, source);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("EObject target = ModelManager.getObject(resource, targetObject);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (target == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("// We avoid cycles");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("EObject previous = source.eContainer();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("while (previous != null && !EcoreUtil.equals(previous, target)) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("previous = previous.eContainer();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (EcoreUtil.equals(previous, target)) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("ObSelectionStrategy tarSelection = new SpecificObjectSelection(packages, sourceModel, target);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(srcSelection2.getModel(), srcSelection2.getMetaModel(), srcSelection2, tarSelection, \"");
        String _name_18 = mut.getRefType().getName();
        _builder.append(_name_18, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
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
        int _get = nRegistryMutation[0];
        int _plus = (_get + 1);
        int _set = nRegistryMutation[0] = _plus;
        _builder.append(_set);
        _builder.newLineIfNotEmpty();
        _builder.append("//COUNTER: ");
        int _get_1 = nRegistryMethodCall[0];
        int _plus_1 = (_get_1 + 1);
        int _set_1 = nRegistryMethodCall[0] = _plus_1;
        _builder.append(_set_1);
        _builder.newLineIfNotEmpty();
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
            _builder.append("srcSelection.getObject(),");
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
            _builder.append("\t\t");
            _builder.append("Object mutated = mut.mutate();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("if (mutated != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("AppMutation appMut = ");
            _builder.append(registryMethodName, "\t\t\t\t");
            _builder.append("(mut, hmMutator, seed, srcSelection.getModel(), clue, mutPaths, packages);");
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
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("mutator = mut;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (mutator != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//COUNTER: ");
        int _get_2 = nMethodCall[0];
        int _plus_2 = (_get_2 + 1);
        int _set_2 = nMethodCall[0] = _plus_2;
        _builder.append(_set_2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//MUTATION METHOD NAME:");
        String _string_1 = Integer.valueOf((nMethodCall[0])).toString();
        String nMethodName = ("mutation" + _string_1);
        _builder.newLineIfNotEmpty();
        {
          if ((last == false)) {
            {
              if ((standalone == false)) {
                _builder.append("\t");
                _builder.append(nMethodName, "\t");
                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append(nMethodName, "\t");
                _builder.append("(packages, models, hmObjects, hmList, hashmapModelFilenames,");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t\t\t\t");
                _builder.append("registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("numMutantsGenerated = k[0];");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(sourceModel);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          if ((last == true)) {
            _builder.append("\t");
            _builder.append("// MUTANT COMPLETION AND REGISTRY");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();");
            _builder.newLine();
            {
              EList<Constraint> _constraints = e.getConstraints();
              for(final Constraint constraint : _constraints) {
                _builder.append("\t");
                _builder.append("if (rules.get(\"");
                String _name_19 = constraint.getType().getName();
                _builder.append(_name_19, "\t");
                _builder.append("\") == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("rules.put(\"");
                String _name_20 = constraint.getType().getName();
                _builder.append(_name_20, "\t\t");
                _builder.append("\", new ArrayList<String>());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("List<String> newrules = rules.get(\"");
                String _name_21 = constraint.getType().getName();
                _builder.append(_name_21, "\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                {
                  EList<InvariantCS> _expressions = constraint.getExpressions();
                  boolean _tripleNotEquals = (_expressions != null);
                  if (_tripleNotEquals) {
                    {
                      EList<InvariantCS> _expressions_1 = constraint.getExpressions();
                      for(final InvariantCS expression : _expressions_1) {
                        _builder.append("\t");
                        _builder.append("newrules.add(\"");
                        String _constraintText = WodelUtils.getConstraintText(fileURI.lastSegment(), expression);
                        _builder.append(_constraintText, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
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
                        _builder.append("\t");
                        _builder.append("newrules.add(\"");
                        _builder.append(rule, "\t");
                        _builder.append("\");");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t");
                _builder.append("rules.put(\"");
                String _name_22 = constraint.getType().getName();
                _builder.append(_name_22, "\t");
                _builder.append("\", newrules);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((b == null)) {
                _builder.append("\t");
                _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/\" + \"Output\" + k[0] + \".model\";");
                _builder.newLine();
              } else {
                {
                  int _size = b.getFrom().size();
                  boolean _equals = (_size == 0);
                  if (_equals) {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_23 = b.getName();
                    _builder.append(_name_23);
                    _builder.append("/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("String mutFilename = hashmapModelFilenames.get(modelFilename) + \"/");
                    String _name_24 = b.getName();
                    _builder.append(_name_24);
                    _builder.append("/\" + hashmapModelFolders.get(modelFilename) + \"/Output\" + k[0] + \".model\";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);");
            _builder.newLine();
            {
              if ((b == null)) {
                {
                  if ((standalone == false)) {
                    _builder.append("\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);");
                    _builder.newLine();
                  } else {
                    _builder.append("\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t   \t\t");
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_25 = project.getName();
                    _builder.append(_name_25, "\t   \t\t\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t   \t\t\t");
                    _builder.append(".class, true, true);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                {
                  if ((standalone == false)) {
                    _builder.append("\t   \t\t");
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_26 = b.getName();
                    _builder.append(_name_26);
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("//System.out.println(\"ecoreURI: \" + ecoreURI);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, \"");
                    String _name_27 = b.getName();
                    _builder.append(_name_27, "\t");
                    _builder.append("\", fromNames, k, mutPaths, hashmapMutVersions, \"");
                    String _name_28 = project.getName();
                    _builder.append(_name_28, "\t");
                    _builder.append("\", serialize, test, classes, ");
                    _builder.append(className, "\t");
                    _builder.append(".class, true, false);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (isRepeated == false) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("numMutantsGenerated++;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("monitor.worked(1);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("k[0] = k[0] + 1;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//if (muts != null) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//\tmuts.getMuts().clear();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t     ");
            _builder.append("MutatorUtils.rollbackMutations(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t        ");
            _builder.append("muts,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t        ");
            _builder.append("mutsMark);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//Unload tmp model");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("resource.unload();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (Exception e) {}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} finally {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(sourceModel);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t");
            _builder.append("models.remove(resource);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t\t\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
        _builder.append("//END MODIFY TARGET REFERENCE ");
        _builder.append(methodName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
