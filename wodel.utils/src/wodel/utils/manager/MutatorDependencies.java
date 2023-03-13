package wodel.utils.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificObjectSelection;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorDependencies
 * 
 * Dependencies between mutations
 * for the seed models synthesis
 * 
 */
public class MutatorDependencies {

	protected Integer[] initialVector = { null, 1, 1, 1, null, 1, 0, 1, 1, 1, 1, 1, null };
	
	protected HashMap<Mutator, List<Integer>> dependenciesMatrix = null;
	
	protected List<Mutator> mutators = null;
	
	protected List<EPackage> packages = null;
	
	protected class MutatorData {
		public int index = 0;
		public EClass type = null;
		public Mutator mutator = null;
		public int max = 0;
	}
	
	protected HashMap<Mutator, Integer> dependencies = new HashMap<Mutator, Integer>();
	
	protected HashMap<String, MutatorData> mutatorData = new HashMap<String, MutatorData>();
	
	/**
	 * MutatorDependencies constructor
	 * @param mutators
	 */
	public MutatorDependencies(List<EPackage> packages, List<Mutator> mutators) {
		this.mutators = mutators;
		this.packages = packages;
		createMutatorData();
		findDependencies();
	}
	
	/**
	 * Gets the mutator index
	 * @param mut
	 * @return
	 */
	protected int getMutatorIndex(Mutator mut) {
		for (int i = 0; i < MutatorUtils.mutatorTypeNames.length; i++) {
			if (mut.getClass().getSimpleName().startsWith(MutatorUtils.mutatorTypeNames[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Creates mutator data for computing dependencies
	 */
	protected void createMutatorData() {
		if (mutators != null) {
			for (int i = 0; i < mutators.size(); i++) {
				Mutator mut = mutators.get(i);
				MutatorData mutData = new MutatorData();
				mutData.index = i;
				mutData.type = MutatorUtils.getMutatorType(mut);
				mutData.mutator = mut;
				mutData.max = mut.getMax();
				if (mut.getName() != null) {
					mutatorData.put(mut.getName(), mutData);
				}
				else {
					mutatorData.put("mut_" + i, mutData);
				}
			}
		}
	}
	
	/**
	 * Gets the mutator data for computing dependencies by given type
	 * @param type
	 * @return
	 */
	protected MutatorData getMutatorDataByType(EClass type) {
		for (String mutatorName : mutatorData.keySet()) {
			MutatorData mutData = mutatorData.get(mutatorName);
			if (mutData.type.getName().equals(type.getName())) {
				return mutData;
			}
		}
		return null;
	}
	
	/**
	 * Gets the mutator data for computing dependencies by given mutator
	 * @param mut
	 * @return
	 */
	protected MutatorData getByMutator(Mutator mut) {
		for (MutatorData value : mutatorData.values()) {
			if (value.mutator.equals(mut)) {
				return value;
			}
		}
		return null;
	}
	
	/**
	 * Transforms the dependencies vector
	 * @param vector
	 * @param value
	 * @return
	 */
	protected static List<Integer> transform(List<Integer> vector, Integer value) {
		List<Integer> ret = new ArrayList<Integer>();
		for (Integer v : vector) {
			if (value == 1) {
				if (v == null) {
					ret.add(1);
					continue;
				}
				if (v == 1) {
					ret.add(1);
					continue;
				}
				if (v == 0) {
					ret.add(0);
					continue;
				}
			}
			else {
				if (v == null) {
					ret.add(null);
					continue;
				}
				if (v == 1) {
					ret.add(null);
					continue;
				}
				if (v == 0) {
					ret.add(0);
					continue;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Dependencies helper for remove object mutator 
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForRemoveObjectMutator(List<EPackage> packages, RemoveObjectMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		EClass type = MutatorUtils.getType(mut);
		if (mut.getObject() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					if (md.max < mut.getMax()) {
						value = 1;
					}
					else {
						value = 0;
					}
				}
			}
		}
		if (mut.getObject() instanceof RandomTypeSelection) {
			int max = 0;
			for (Mutator prevMut : previousMutators) {
				if (prevMut instanceof CreateObjectMutator) {
					if (EcoreUtil.equals(((CreateObjectMutator) prevMut).getType(), type)) {
						MutatorData md = getByMutator(prevMut);
						if (md != null && md.index < com) {
							max += md.max;
						}
					}
				}
				if (prevMut instanceof RetypeObjectMutator) {
					if (EcoreUtil.equals(((RetypeObjectMutator) prevMut).getType(), type)) {
						MutatorData md = getByMutator(prevMut);
						if (md != null && md.index < com) {
							max += md.max;
						}
					}
				}
			}
			if (previousMutators.size() == 0) {
				value = 1;
			}
			else if (max >= mut.getMax()) {
				value = 0;
			}
			else {
				value = mut.getMax() - max;
			}
		}
		if (mut.getObject() instanceof CompleteTypeSelection) {
			CompleteTypeSelection selection = (CompleteTypeSelection) mut.getObject();
			if (selection.getExpression() != null) {
				Expression exp = selection.getExpression();
				if (exp.getFirst() != null) {
					Evaluation ev = exp.getFirst();
					if (ev instanceof ReferenceEvaluation) {
						if (((ReferenceEvaluation) ev).getValue() == null) {
							for (Mutator prevMut : previousMutators) {
								if (prevMut instanceof RemoveObjectMutator) {
									if (((RemoveObjectMutator) prevMut).getObject() instanceof SpecificObjectSelection) {
										SpecificObjectSelection sel = (SpecificObjectSelection) ((RemoveObjectMutator) prevMut).getObject();
										if (mutatorData.get(sel.getObjSel().getName()) != null) {
											EClass prevType = sel.getObjSel().getType();
											for (EReference ref : type.getEAllReferences()) {
												if (EcoreUtil.equals(ref.getEReferenceType(), prevType)) {
													value = 0;
													break;
												}
											}
										}
									}
									if (((RemoveObjectMutator) prevMut).getObject() instanceof RandomTypeSelection) {
										RandomTypeSelection sel = (RandomTypeSelection) ((RemoveObjectMutator) prevMut).getObject();
										EClass prevType = sel.getType();
										for (EReference ref : type.getEAllReferences()) {
											if (EcoreUtil.equals(ref.getEReferenceType(), prevType)) {
												value = 0;
												break;
											}
										}
									}
								}
								if (value == 0) {
									break;
								}
							}
						}
					}
				}
			}
		}
		if (type != null) {
			List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(type));
			for (EClassifier container : containers) {
				for (EReference ref : ((EClass) container).getEAllReferences()) {
					if (ref.isContainment() == true && ref.getLowerBound() > 0) {
						List<EClass> types = new ArrayList<EClass>();
						types.add(type);
						types.addAll(type.getEAllSuperTypes());
						for (EClass eClass : types) {
							if (EcoreUtil.getURI(eClass).equals(EcoreUtil.getURI(type))) {
								value = 1;
								break;
							}
						}
					}
					if (value == 1) {
						break;
					}
				}
				if (value == 1) {
					break;
				}
			}
		}
		return value;
	}
	
	/**
	 * Dependencies helper for remove random reference mutator 
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForRemoveRandomReferenceMutator(RemoveRandomReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		EClass type = mut.getType();
		MutatorData md = getMutatorDataByType(type);
		if (md != null && md.index < com) {
			value = 0;
		}
		return value;
	}

	/**
	 * Dependencies helper for remove specific reference mutator 
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForRemoveSpecificReferenceMutator(RemoveSpecificReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getContainer() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getContainer();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}
	
	/**
	 * Dependencies helper for remove complete reference mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForRemoveCompleteReferenceMutator(RemoveCompleteReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		EClass type = mut.getType();
		MutatorData md = getMutatorDataByType(type);
		if (md != null && md.index < com) {
			value = 0;
		}
		return value;
	}
	
	/**
	 * Dependencies helper for create object mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForCreateObjectMutator(CreateObjectMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getReferences() != null) {
			List<ReferenceSet> references = mut.getReferences();
			if (references.size() > 0) {
				int refValue = 0;
				for (ReferenceSet refSet : references) {
					if (refSet instanceof ReferenceInit) {
						ObSelectionStrategy strategy = refSet.getObject();
						EClass mutType = MutatorUtils.getMutatorType(mut);
						EClass refType = MutatorUtils.getStrategyType(strategy);
						if (!mutType.getName().equals(refType.getName())) {
							refValue = 1;
						}
					}
					if (refSet instanceof ReferenceAdd) {
						ObSelectionStrategy strategy = refSet.getObject();
						EClass mutType = MutatorUtils.getMutatorType(mut);
						EClass refType = MutatorUtils.getStrategyType(strategy);
						if (!mutType.getName().equals(refType.getName())) {
							refValue = 1;
						}
					}
					if (refSet instanceof ReferenceRemove) {
						ObSelectionStrategy strategy = refSet.getObject();
						EClass mutType = MutatorUtils.getMutatorType(mut);
						EClass refType = MutatorUtils.getStrategyType(strategy);
						if (!mutType.getName().equals(refType.getName())) {
							refValue = 1;
						}
					}
					if (refSet instanceof ReferenceSwap) {
						ObSelectionStrategy strategy = refSet.getObject();
						EClass mutType = MutatorUtils.getMutatorType(mut);
						EClass refType = MutatorUtils.getStrategyType(strategy);
						if (!mutType.getName().equals(refType.getName())) {
							refValue = 1;
						}
					}
				}
				value = refValue;
			}
		}
		else {
			value = 0;
		}
		return value;
	}

	/**
	 * Dependencies helper for select object mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForSelectObjectMutator(SelectObjectMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getObject() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}
	
	/**
	 * Dependencies helper for modify information mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForModifyInformationMutator(ModifyInformationMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getObject() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}

	/**
	 * Dependencies helper for create reference mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForCreateReferenceMutator(CreateReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getSource() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getSource();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}

	/**
	 * Dependencies helper for modify source reference mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForModifySourceReferenceMutator(ModifySourceReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getSource() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getSource();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}

	/**
	 * Dependencies helper for modify target reference mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForModifyTargetReferenceMutator(ModifyTargetReferenceMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getSource() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getSource();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}

	/**
	 * Dependencies helper for clone object mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForCloneObjectMutator(CloneObjectMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getObject() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					value = 0;
				}
			}
		}
		return value;
	}

	/**
	 * Dependencies helper for retype object mutator
	 * @param mut
	 * @param com
	 * @param previousMutators
	 * @return
	 */
	private int dependenciesHelperForRetypeObjectMutator(RetypeObjectMutator mut, int com, List<Mutator> previousMutators) {
		int value = 1;
		if (mut.getObject() instanceof SpecificObjectSelection) {
			SpecificObjectSelection selection = (SpecificObjectSelection) mut.getObject();
			if (mutatorData.get(selection.getObjSel().getName()) != null) {
				String mutatorName = selection.getObjSel().getName();
				MutatorData md = mutatorData.get(mutatorName);
				if (md != null && md.index < com) {
					if (md.max < mut.getMax()) {
						value = 1;
					}
					else {
						value = 0;
					}
				}
			}
		}
		if (mut.getObject() instanceof RandomTypeSelection) {
			int max = 0;
			for (Mutator prevMut : previousMutators) {
				if (prevMut instanceof CreateObjectMutator) {
					if (EcoreUtil.equals(((CreateObjectMutator) prevMut).getType(), mut.getObject().getType())) {
						MutatorData md = getByMutator(prevMut);
						if (md != null && md.index < com) {
							max += md.max;
						}
					}
				}
				if (prevMut instanceof RetypeObjectMutator) {
					if (EcoreUtil.equals(((RetypeObjectMutator) prevMut).getType(), mut.getObject().getType())) {
						MutatorData md = getByMutator(prevMut);
						if (md != null && md.index < com) {
							max += md.max;
						}
					}
				}
			}
			if (previousMutators.size() == 0) {
				value = 1;
			}
			else if (max >= mut.getMax()) {
				value = 0;
			}
			else {
				value = mut.getMax() - max;
			}
		}
		if (mut.getObject() instanceof CompleteTypeSelection) {
			CompleteTypeSelection selection = (CompleteTypeSelection) mut.getObject();
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
												if (EcoreUtil.equals(ref.getEReferenceType(), prevType)) {
													value = 0;
													break;
												}
											}
										}
									}
									if (((RemoveObjectMutator) prevMut).getObject() instanceof RandomTypeSelection) {
										RandomTypeSelection sel = (RandomTypeSelection) ((RemoveObjectMutator) prevMut).getObject();
										EClass prevType = sel.getType();
										for (EReference ref : type.getEAllReferences()) {
											if (EcoreUtil.equals(ref.getEReferenceType(), prevType)) {
												value = 0;
												break;
											}
										}
									}
								}
								if (value == 0) {
									break;
								}
							}
						}
					}
				}
			}
		}
		return value;
	}

	/**
	 * Finds the dependencies between mutations 
	 */
	protected void findDependencies() {
		if (mutators != null) {
			int com = 0;
			int lastValue = 1;
			List<Integer> lastVector = null;
			List<Mutator> previousMutators = new ArrayList<Mutator>();
			for (Mutator mut : mutators) {
				int value = 1;
				List<Integer> activeVector = null;
				if (dependenciesMatrix == null) {
					dependenciesMatrix = new HashMap<Mutator, List<Integer>>();
					activeVector = Arrays.asList(initialVector);
				}
				else {
					activeVector = transform(lastVector, lastValue);
				}
				if (mut instanceof RemoveObjectMutator) {
					value = dependenciesHelperForRemoveObjectMutator(packages, (RemoveObjectMutator) mut, com, previousMutators);
				}
				if (mut instanceof RemoveRandomReferenceMutator) {
					value = dependenciesHelperForRemoveRandomReferenceMutator((RemoveRandomReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof RemoveSpecificReferenceMutator) {
					value = dependenciesHelperForRemoveSpecificReferenceMutator((RemoveSpecificReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof RemoveCompleteReferenceMutator) {
					value = dependenciesHelperForRemoveCompleteReferenceMutator((RemoveCompleteReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof CreateObjectMutator) {
					value = dependenciesHelperForCreateObjectMutator((CreateObjectMutator) mut, com, previousMutators);
				}
				if (mut instanceof SelectObjectMutator) {
					value = dependenciesHelperForSelectObjectMutator((SelectObjectMutator) mut, com, previousMutators); 
				}
				if (mut instanceof SelectSampleMutator) {
					value = 0;
				}
				if (mut instanceof ModifyInformationMutator) {
					value = dependenciesHelperForModifyInformationMutator((ModifyInformationMutator) mut, com, previousMutators);
				}
				if (mut instanceof CreateReferenceMutator) {
					value = dependenciesHelperForCreateReferenceMutator((CreateReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof ModifySourceReferenceMutator) {
					value = dependenciesHelperForModifySourceReferenceMutator((ModifySourceReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof ModifyTargetReferenceMutator) {
					value = dependenciesHelperForModifyTargetReferenceMutator((ModifyTargetReferenceMutator) mut, com, previousMutators);
				}
				if (mut instanceof CloneObjectMutator) {
					value = dependenciesHelperForCloneObjectMutator((CloneObjectMutator) mut, com, previousMutators);
				}
				if (mut instanceof RetypeObjectMutator) {
					value = dependenciesHelperForRetypeObjectMutator((RetypeObjectMutator) mut, com, previousMutators);
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

	/**
	 * Gets the dependency corresponding value for the mutator
	 * @param mutator
	 * @return
	 */
	public Integer needsOCLConstraints(Mutator mutator) {
		return dependencies.get(mutator); 
	}
}
