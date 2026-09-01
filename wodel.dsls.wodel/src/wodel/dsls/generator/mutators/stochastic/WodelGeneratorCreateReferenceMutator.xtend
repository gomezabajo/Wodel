package wodel.dsls.generator.mutators.stochastic
 
import mutatorenvironment.CreateReferenceMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorCreateReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof CreateReferenceMutator»
		//«var CreateReferenceMutator mut = mt as CreateReferenceMutator»
		//CREATE REFERENCE «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), "«(mut.source as RandomTypeSelection).type.name»");
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), "«(mut.source as CompleteTypeSelection).type.name»");
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
			«IF mut.target instanceof RandomTypeSelection»
				RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, "«(mut.target as RandomTypeSelection).type.name»");			
			«ELSEIF mut.target instanceof CompleteTypeSelection»
				RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, "«(mut.target as CompleteTypeSelection).type.name»");
			«ELSEIF mut.target instanceof SpecificObjectSelection»
				ObSelectionStrategy targetSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.target as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.target as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.target as SpecificObjectSelection).objSel.name» != null) {
					targetSelection = new SpecificObjectSelection(entry_«(mut.target as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.target as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.target as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy targetSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			CreateReferenceMutator mut = new CreateReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, targetSelection, "«mut.refType.name»");
			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
  			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
			if (mut != null) {
				mut.setId("m«nMutation.get(0)»");
				mutations.add(mut);
			}
			//END CREATE REFERENCE «methodName»
		«ENDIF»
	'''
	
}