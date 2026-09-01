package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.ModifyTargetReferenceMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.CompleteTypeSelection
import java.util.List
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorModifyTargetReferenceMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof ModifyTargetReferenceMutator»
		//«var ModifyTargetReferenceMutator mut = mt as ModifyTargetReferenceMutator»
		//MODIFY TARGET REFERENCE «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");			
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");			
				List<EObject> objects = new ArrayList<EObject>();
				for (EObject sourceSelection.getObjects()) {
					EObject obj = ent.getKey();
					objects.add(obj);
				}
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				SpecificObjectSelection sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}			
				List<EObject> objects = new ArrayList<EObject>();
				objects.add(sourceSelection.getObject());
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.newTarget instanceof RandomTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as RandomTypeSelection).type.name»");
			«ELSEIF mut.newTarget instanceof OtherTypeSelection»
				EObject otherSourceSelection = null; 
				«IF mut.source instanceof CompleteTypeSelection»
					otherSourceSelection = sourceSelection.getObject();
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
				OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, "«(mut.newTarget as OtherTypeSelection).type.name»", otherRef);
			«ELSEIF mut.newTarget instanceof CompleteTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as CompleteTypeSelection).type.name»");			
			«ELSEIF mut.newTarget instanceof SpecificObjectSelection»
				SpecificObjectSelection newTargetSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newTarget as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» != null) {
					newTargetSelection = new SpecificObjectSelection(entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}			
			«ELSE»
				ObSelectionStrategy newTargetSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.source instanceof CompleteTypeSelection»
				for (ObSelectionStrategy sourceSelection : listSourceSelection) {
					if (sourceSelection != null && newTargetSelection != null) {
					EObject source = sourceSelection.getObject();
					EObject target = newTargetSelection.getObject();
					// We avoid cycles
					if (source != null && target != null) {
					EObject previous = source.eContainer();
					while (previous != null && !EcoreUtil.equals(previous, target)) {
						previous = previous.eContainer();
					}
					if (EcoreUtil.equals(previous, target)) {
						continue;
					}
					mutations.add(ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»"));
					}
					}
				}
   			«ELSE»
				if (sourceSelection == null) {
					return mutations;
				}
				EObject source = sourceSelection.getObject();
				if (source == null) {
					return mutations;
				}
				if (newTargetSelection == null) {
					return mutations;
				}
				EObject target = newTargetSelection.getObject();
				if (target == null) {
					return mutations;
				}
				// We avoid cycles
				EObject previous = source.eContainer();
				while (previous != null && !EcoreUtil.equals(previous, target)) {
					previous = previous.eContainer();
				}
				if (!EcoreUtil.equals(previous, target)) {
				ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»");
				//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
	   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
				if (mut != null) {
					mut.setId("m«nMutation.get(0)»");
					mutations.add(mut);
				}
				}
	«ENDIF»
	//END MODIFY TARGET REFERENCE «methodName»
	«ENDIF»
	'''
	
}