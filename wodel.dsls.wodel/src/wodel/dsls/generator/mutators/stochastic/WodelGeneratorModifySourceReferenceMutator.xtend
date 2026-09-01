package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.OtherTypeSelection
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import mutatorenvironment.ModifySourceReferenceMutator

class WodelGeneratorModifySourceReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof ModifySourceReferenceMutator»
		//«var ModifySourceReferenceMutator mut = mt as ModifySourceReferenceMutator»
		//MODIFY SOURCE REFERENCE «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.source as CompleteTypeSelection).type.name» = hmList.get("«(mut.source as CompleteTypeSelection).type.name»");
				List<EObject> objects = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.source as CompleteTypeSelection).type.name») {
					EObject obj = ent.getKey();
					objects.add(obj);
				}
				List<ObSelectionStrategy> listSourceSelection = new ArrayList<ObSelectionStrategy>();
				for (EObject obj : objects) {
					ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);
					listSourceSelection.add(objectSelection);
				}
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				ObSelectionStrategy sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.newSource instanceof RandomTypeSelection»
				RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, "«(mut.newSource as RandomTypeSelection).type.name»");
			«ELSEIF mut.newSource instanceof OtherTypeSelection»
				EObject otherSourceSelection = null; 
				«IF mut.source instanceof CompleteTypeSelection»
					otherSourceSelection = sourceSelection.get(0).getObject();
				«ELSE»
					otherSourceSelection = sourceSelection.getObject();
				«ENDIF»
				Object otherRef = null;
				if (otherSourceSelection != null) {
					for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {
						if (ref.getName().equals("«mut.refType.name»")) {
							otherRef = otherSourceSelection.eGet(ref);
							break;
						}
					}
				}
				OtherTypeSelection newSourceSelection = new OtherTypeSelection(packages, model, "«(mut.newSource as OtherTypeSelection).type.name»", otherRef);
			«ELSEIF mut.newSource instanceof CompleteTypeSelection»
				«/*THE SAME AS RANDOM*/»
				RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, "«(mut.newSource as CompleteTypeSelection).type.name»");
			«ELSEIF mut.newSource instanceof SpecificObjectSelection»
				ObSelectionStrategy newSourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newSource as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newSource as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.newSource as SpecificObjectSelection).objSel.name» != null) {
					newSourceSelection = new SpecificObjectSelection(entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy newSourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.source instanceof CompleteTypeSelection»
				for (ObSelectionStrategy sourceSelection : listSourceSelection) {
					ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, "«mut.refType.name»");
				   	//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
				   	if (mut != null) {
				   		mut.setId("m«nMutation.get(0)»");
						mutations.add(mut);
					}
				}
			«ELSE»
				ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, "«mut.refType.name»");
				//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
	   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
				if (mut != null) {
					mut.setId("m«nMutation.get(0)»");
					mutations.add(mut);
				}
		«ENDIF»
			//END MODIFY SOURCE REFERENCE «methodName»
		«ENDIF»
	'''
	
}