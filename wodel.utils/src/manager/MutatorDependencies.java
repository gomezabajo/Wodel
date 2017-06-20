package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceAdd;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RemoveRandomReferenceMutator;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificObjectSelection;

public class MutatorDependencies {

	protected String[] mutatorOperators = {
		"RemoveObjectMutator", "RemoveRandomReferenceMutator", "RemoveSpecificReferenceMutator", "RemoveCompleteReferenceMutator",
		"CreateObjectMutator", "SelectObjectMutator", "SelectSampleMutator", "ModifyInformationMutator", "CreateReferenceMutator",
		"ModifySourceReferenceMutator", "ModifyTargetReferenceMutator", "CloneObjectMutator"
	};
	
	protected Boolean[] initialVector = { null, true, true, true, null, true, false, true, true, true, true, true };
	
	protected HashMap<Mutator, List<Boolean>> dependenciesMatrix = null;
	
	protected List<Mutator> mutators = null;
	
	protected class MutatorData {
		public int index = 0;
		public EClass type = null;
		public Mutator mutator = null;
	}
	
	protected HashMap<Mutator, Boolean> dependencies = new HashMap<Mutator, Boolean>();
	
	protected HashMap<String, MutatorData> mutatorData = new HashMap<String, MutatorData>();
	
	public MutatorDependencies(List<Mutator> mutators) {
		this.mutators = mutators;
		createMutatorData();
		findDependencies();
	}
	
	protected int getMutatorIndex(Mutator mut) {
		for (int i = 0; i < mutatorOperators.length; i++) {
			if (mut.getClass().getSimpleName().startsWith(mutatorOperators[i])) {
				return i;
			}
		}
		return -1;
	}
	
	protected void createMutatorData() {
		if (mutators != null) {
			for (int i = 0; i < mutators.size(); i++) {
				Mutator mut = mutators.get(i);
				if (mut.getName() != null) {
					MutatorData mutData = new MutatorData();
					mutData.index = i;
					mutData.type = MutatorUtils.getMutatorType(mut);
					mutData.mutator = mut;
					mutatorData.put(mut.getName(), mutData);
				}
			}
		}
	}
	
	protected MutatorData getMutatorDataByType(EClass type) {
		for (String mutatorName : mutatorData.keySet()) {
			MutatorData mutData = mutatorData.get(mutatorName);
			if (mutData.type.getName().equals(type.getName())) {
				return mutData;
			}
		}
		return null;
	}
	
	protected static List<Boolean> transform(List<Boolean> vector, boolean value) {
		List<Boolean> ret = new ArrayList<Boolean>();
		for (Boolean v : vector) {
			if (value == true) {
				if (v == null) {
					ret.add(true);
					continue;
				}
				if (v == true) {
					ret.add(true);
					continue;
				}
				if (v == false) {
					ret.add(false);
					continue;
				}
			}
			else {
				if (v == null) {
					ret.add(null);
					continue;
				}
				if (v == true) {
					ret.add(null);
					continue;
				}
				if (v == false) {
					ret.add(false);
					continue;
				}
			}
		}
		return ret;
	}
	
	
	protected void findDependencies() {
		if (mutators != null) {
			int com = 0;
			boolean lastValue = true;
			List<Boolean> lastVector = null;
			List<Mutator> previousMutators = new ArrayList<Mutator>();
			for (Mutator mut : mutators) {
				boolean value = true;
				List<Boolean> activeVector = null;
				if (dependenciesMatrix == null) {
					dependenciesMatrix = new HashMap<Mutator, List<Boolean>>();
					activeVector = Arrays.asList(initialVector);
				}
				else {
					activeVector = transform(lastVector, lastValue);
				}
				if (mut instanceof RemoveObjectMutator) {
					if (((RemoveObjectMutator) mut).getObject() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((RemoveObjectMutator) mut).getObject();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = true;
							}
						}
					}
					if (((RemoveObjectMutator) mut).getObject() instanceof RandomTypeSelection) {
						value = true;
					}
					if (((RemoveObjectMutator) mut).getObject() instanceof CompleteTypeSelection) {
						CompleteTypeSelection selection = (CompleteTypeSelection) ((RemoveObjectMutator) mut).getObject();
						if (selection.getExpression() != null) {
							Expression exp = selection.getExpression();
							if (exp.getFirst() != null) {
								Evaluation ev = exp.getFirst();
								if (ev instanceof ReferenceEvaluation) {
									if (((ReferenceEvaluation) ev).getValue() == null) {
										EClass type = selection.getType();
										for (Mutator prevMut : previousMutators) {
											if (prevMut instanceof RemoveObjectMutator) {
												if (((RemoveObjectMutator) prevMut).getObject() instanceof SpecificObjectSelection) {
													SpecificObjectSelection sel = (SpecificObjectSelection) ((RemoveObjectMutator) prevMut).getObject();
													if (mutatorData.get(sel.getObjSel().getName()) != null) {
														EClass prevType = sel.getObjSel().getType();
														for (EReference ref : type.getEAllReferences()) {
															if (ref.getEType().getName().equals(prevType.getName())) {
																value = false;
																break;
															}
														}
													}
												}
												if (((RemoveObjectMutator) prevMut).getObject() instanceof RandomTypeSelection) {
													RandomTypeSelection sel = (RandomTypeSelection) ((RemoveObjectMutator) prevMut).getObject();
													EClass prevType = sel.getType();
													for (EReference ref : type.getEAllReferences()) {
														if (ref.getEType().getName().equals(prevType.getName())) {
															value = false;
															break;
														}
													}
												}
											}
											if (value == false) {
												break;
											}
										}
									}
								}
							}
						}
					}
				}
				if (mut instanceof RemoveRandomReferenceMutator) {
					EClass type = ((RemoveRandomReferenceMutator) mut).getType();
					MutatorData md = getMutatorDataByType(type);
					if (md != null && md.index < com) {
						value = false;
					}
				}
				if (mut instanceof RemoveSpecificReferenceMutator) {
					if (((RemoveSpecificReferenceMutator) mut).getContainer() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((RemoveSpecificReferenceMutator) mut).getContainer();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof RemoveCompleteReferenceMutator) {
					EClass type = ((RemoveCompleteReferenceMutator) mut).getType();
					MutatorData md = getMutatorDataByType(type);
					if (md != null && md.index < com) {
						value = false;
					}
				}
				if (mut instanceof CreateObjectMutator) {
					if (((CreateObjectMutator) mut).getReferences() != null) {
						List<ReferenceSet> references = ((CreateObjectMutator) mut).getReferences();
						if (references.size() > 0) {
							boolean refValue = false;
							for (ReferenceSet refSet : references) {
								if (refSet instanceof ReferenceInit) {
									ObSelectionStrategy strategy = refSet.getObject();
									EClass mutType = MutatorUtils.getMutatorType(mut);
									EClass refType = MutatorUtils.getStrategyType(strategy);
									if (!mutType.getName().equals(refType.getName())) {
										refValue = true;
									}
								}
								if (refSet instanceof ReferenceAdd) {
									ObSelectionStrategy strategy = refSet.getObject();
									EClass mutType = MutatorUtils.getMutatorType(mut);
									EClass refType = MutatorUtils.getStrategyType(strategy);
									if (!mutType.getName().equals(refType.getName())) {
										refValue = true;
									}
								}
								if (refSet instanceof ReferenceRemove) {
									ObSelectionStrategy strategy = refSet.getObject();
									EClass mutType = MutatorUtils.getMutatorType(mut);
									EClass refType = MutatorUtils.getStrategyType(strategy);
									if (!mutType.getName().equals(refType.getName())) {
										refValue = true;
									}
								}
								if (refSet instanceof ReferenceSwap) {
									ObSelectionStrategy strategy = refSet.getObject();
									EClass mutType = MutatorUtils.getMutatorType(mut);
									EClass refType = MutatorUtils.getStrategyType(strategy);
									if (!mutType.getName().equals(refType.getName())) {
										refValue = true;
									}
								}
							}
							value = refValue;
						}
					}
					else {
						value = false;
					}
				}
				if (mut instanceof SelectObjectMutator) {
					if (((SelectObjectMutator) mut).getObject() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((SelectObjectMutator) mut).getObject();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof SelectSampleMutator) {
					value = false;
				}
				if (mut instanceof ModifyInformationMutator) {
					if (((ModifyInformationMutator) mut).getObject() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((ModifyInformationMutator) mut).getObject();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof CreateReferenceMutator) {
					if (((CreateReferenceMutator) mut).getSource() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((CreateReferenceMutator) mut).getSource();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof ModifySourceReferenceMutator) {
					if (((ModifySourceReferenceMutator) mut).getSource() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((ModifySourceReferenceMutator) mut).getSource();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof ModifyTargetReferenceMutator) {
					if (((ModifyTargetReferenceMutator) mut).getSource() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((ModifyTargetReferenceMutator) mut).getSource();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				if (mut instanceof CloneObjectMutator) {
					if (((CloneObjectMutator) mut).getObject() instanceof SpecificObjectSelection) {
						SpecificObjectSelection selection = (SpecificObjectSelection) ((CloneObjectMutator) mut).getObject();
						if (mutatorData.get(selection.getObjSel().getName()) != null) {
							String mutatorName = selection.getObjSel().getName();
							MutatorData md = mutatorData.get(mutatorName);
							if (md != null && md.index < com) {
								value = false;
							}
						}
					}
				}
				dependencies.put(mut, value);
				dependenciesMatrix.put(mut, activeVector);
				previousMutators.add(mut);
				lastValue = value;
				lastVector = activeVector;
				com++;
			}
		}
	}
	
	public Boolean needsOCLConstraints(Mutator mutator) {
		return dependencies.get(mutator); 
	}
}
